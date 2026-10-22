package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class AsyncListDiffer<T> {
    private static final Executor sMainThreadExecutor = null;
    final AsyncDifferConfig<T> mConfig;

    @Nullable
    private List<T> mList;
    private final List<ListListener<T>> mListeners;
    Executor mMainThreadExecutor;
    int mMaxScheduledGeneration;

    @NonNull
    private List<T> mReadOnlyList;
    private final ListUpdateCallback mUpdateCallback;

    public interface ListListener<T> {
        void onCurrentListChanged(@NonNull List<T> r5, @NonNull List<T> r10);
    }

    public static class MainThreadExecutor implements Executor {
        final Handler mHandler;

        public MainThreadExecutor() {
            this.mHandler = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable r5) {
            this.mHandler.post(r5);
        }
    }

    static {
        sMainThreadExecutor = new MainThreadExecutor();
    }

    public AsyncListDiffer(@NonNull RecyclerView.Adapter r5, @NonNull DiffUtil.ItemCallback<T> r10) {
        this(new AdapterListUpdateCallback(r5), new AsyncDifferConfig.Builder(r10).build());
    }

    private void onCurrentListChanged(@NonNull List<T> r5, @Nullable Runnable r10) {
        Iterator<ListListener<T>> r11 = this.mListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onCurrentListChanged(r5, this.mReadOnlyList);
        goto L4
    L6:
        if (r10 == null) goto L10;
        r10.run();
        return;
    }

    public void addListListener(@NonNull ListListener<T> r5) {
        this.mListeners.add(r5);
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.mReadOnlyList;
    }

    public void latchList(@NonNull List<T> r5, @NonNull DiffUtil.DiffResult r10, @Nullable Runnable r11) {
        List<T> r12 = this.mReadOnlyList;
        this.mList = r5;
        this.mReadOnlyList = Collections.unmodifiableList(r5);
        r10.dispatchUpdatesTo(this.mUpdateCallback);
        onCurrentListChanged(r12, r11);
    }

    public void removeListListener(@NonNull ListListener<T> r5) {
        this.mListeners.remove(r5);
    }

    public void submitList(@Nullable List<T> r5) {
        submitList(r5, null);
    }

    public void submitList(@Nullable final List<T> r10, @Nullable final Runnable r11) {
        final int r5 = this.mMaxScheduledGeneration + 1;
        this.mMaxScheduledGeneration = r5;
        final List<T> r12 = this.mList;
        if (r10 != r12) goto L7;
        if (r11 == null) goto L16;
        r11.run();
        return;
    L16:
        return;
    L7:
        List<T> r13 = this.mReadOnlyList;
        if (r10 != null) goto L11;
        int r14 = r12.size();
        this.mList = null;
        this.mReadOnlyList = Collections.emptyList();
        this.mUpdateCallback.onRemoved(0, r14);
        onCurrentListChanged(r13, r11);
        return;
    L11:
        if (r12 != null) goto L14;
        this.mList = r10;
        this.mReadOnlyList = Collections.unmodifiableList(r10);
        this.mUpdateCallback.onInserted(0, r10.size());
        onCurrentListChanged(r13, r11);
        return;
    L14:
        this.mConfig.getBackgroundThreadExecutor().execute(new AnonymousClass1(this, r12, r10, r5, r11));
    }

    public AsyncListDiffer(@NonNull ListUpdateCallback r5, @NonNull AsyncDifferConfig<T> r10) {
        this.mListeners = new CopyOnWriteArrayList();
        this.mReadOnlyList = Collections.emptyList();
        this.mUpdateCallback = r5;
        this.mConfig = r10;
        if (r10.getMainThreadExecutor() == null) goto L5;
        this.mMainThreadExecutor = r10.getMainThreadExecutor();
        return;
    L5:
        this.mMainThreadExecutor = sMainThreadExecutor;
    }
}
