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
        void onCurrentListChanged(@NonNull List<T> r10, @NonNull List<T> r11);
    }

    private static class MainThreadExecutor implements Executor {
        final Handler mHandler;

        MainThreadExecutor() {
            this.mHandler = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable r10) {
            this.mHandler.post(r10);
        }
    }

    static {
        sMainThreadExecutor = new MainThreadExecutor();
    }

    public AsyncListDiffer(@NonNull ListUpdateCallback r10, @NonNull AsyncDifferConfig<T> r11) {
        this.mListeners = new CopyOnWriteArrayList();
        this.mReadOnlyList = Collections.emptyList();
        this.mUpdateCallback = r10;
        this.mConfig = r11;
        if (r11.getMainThreadExecutor() == null) goto L5;
        Executor r12 = r11.getMainThreadExecutor();
    L6:
        this.mMainThreadExecutor = r12;
        return;
    L5:
        r12 = sMainThreadExecutor;
        goto L6
    }

    public AsyncListDiffer(@NonNull RecyclerView.Adapter r10, @NonNull DiffUtil.ItemCallback<T> r11) {
        this(new AdapterListUpdateCallback(r10), new AsyncDifferConfig.Builder(r11).build());
    }

    private void onCurrentListChanged(@NonNull List<T> r10, @Nullable Runnable r11) {
        Iterator<ListListener<T>> r12 = this.mListeners.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().onCurrentListChanged(r10, this.mReadOnlyList);
        goto L4
    L6:
        if (r11 == null) goto L10;
        r11.run();
        return;
    }

    public void addListListener(@NonNull ListListener<T> r10) {
        this.mListeners.add(r10);
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.mReadOnlyList;
    }

    void latchList(@NonNull List<T> r10, @NonNull DiffUtil.DiffResult r11, @Nullable Runnable r12) {
        List<T> r13 = this.mReadOnlyList;
        this.mList = r10;
        this.mReadOnlyList = Collections.unmodifiableList(r10);
        r11.dispatchUpdatesTo(this.mUpdateCallback);
        onCurrentListChanged(r13, r12);
    }

    public void removeListListener(@NonNull ListListener<T> r10) {
        this.mListeners.remove(r10);
    }

    public void submitList(@Nullable List<T> r10) {
        submitList(r10, null);
    }

    public void submitList(@Nullable final List<T> r10, @Nullable final Runnable r11) {
        final int r12 = this.mMaxScheduledGeneration + 1;
        this.mMaxScheduledGeneration = r12;
        final List<T> r13 = this.mList;
        if (r10 != r13) goto L7;
        if (r11 == null) goto L16;
        r11.run();
        return;
    L16:
        return;
    L7:
        List<T> r14 = this.mReadOnlyList;
        if (r10 != null) goto L11;
        int r15 = r13.size();
        this.mList = null;
        this.mReadOnlyList = Collections.emptyList();
        this.mUpdateCallback.onRemoved(0, r15);
        onCurrentListChanged(r14, r11);
        return;
    L11:
        if (r13 != null) goto L14;
        this.mList = r10;
        this.mReadOnlyList = Collections.unmodifiableList(r10);
        this.mUpdateCallback.onInserted(0, r10.size());
        onCurrentListChanged(r14, r11);
        return;
    L14:
        this.mConfig.getBackgroundThreadExecutor().execute(new AnonymousClass1(this, r13, r10, r12, r11));
    }
}
