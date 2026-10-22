package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class AsyncListDiffer<T> {
    private static final Executor sMainThreadExecutor = null;
    final AsyncDifferConfig<T> mConfig;
    private List<T> mList;
    private final List<ListListener<T>> mListeners;
    Executor mMainThreadExecutor;
    int mMaxScheduledGeneration;
    private List<T> mReadOnlyList;
    private final ListUpdateCallback mUpdateCallback;

    public interface ListListener<T> {
        void onCurrentListChanged(List<T> r1, List<T> r2);
    }

    private static class MainThreadExecutor implements Executor {
        final Handler mHandler;

        MainThreadExecutor() {
            this.mHandler = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r3) {
            Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            this.mHandler.post(r4);
        }
    }

    static {
        sMainThreadExecutor = new MainThreadExecutor();
    }

    public AsyncListDiffer(ListUpdateCallback r3, AsyncDifferConfig<T> r4) {
        ListUpdateCallback r5 = (ListUpdateCallback) ZeusTransformUtils.wrapperContextForParams(r3, ListUpdateCallback.class, "com.obric.memorydata.plugin");
        this.mListeners = new CopyOnWriteArrayList();
        this.mReadOnlyList = Collections.emptyList();
        this.mUpdateCallback = r5;
        this.mConfig = r4;
        if (r4.getMainThreadExecutor() == null) goto L5;
        Executor r6 = r4.getMainThreadExecutor();
    L6:
        this.mMainThreadExecutor = r6;
        return;
    L5:
        r6 = sMainThreadExecutor;
        goto L6
    }

    public AsyncListDiffer(RecyclerView.Adapter r2, DiffUtil.ItemCallback<T> r3) {
        this(new AdapterListUpdateCallback(r2), new AsyncDifferConfig.Builder(r3).build());
    }

    private void onCurrentListChanged(List<T> r5, Runnable r6) {
        List<T> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.memorydata.plugin");
        Iterator<ListListener<T>> r0 = this.mListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ListListener) ZeusTransformUtils.preCheckCast(r0.next(), ListListener.class, "com.obric.memorydata.plugin")).onCurrentListChanged(r7, this.mReadOnlyList);
        goto L4
    L6:
        if (r8 == null) goto L10;
        r8.run();
        return;
    }

    public void addListListener(ListListener<T> r3) {
        ListListener<T> r4 = (ListListener) ZeusTransformUtils.wrapperContextForParams(r3, ListListener.class, "com.obric.memorydata.plugin");
        this.mListeners.add(r4);
    }

    public List<T> getCurrentList() {
        return this.mReadOnlyList;
    }

    void latchList(List<T> r3, DiffUtil.DiffResult r4, Runnable r5) {
        List<T> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");
        List<T> r0 = this.mReadOnlyList;
        this.mList = r6;
        this.mReadOnlyList = Collections.unmodifiableList(r6);
        r4.dispatchUpdatesTo(this.mUpdateCallback);
        onCurrentListChanged(r0, r7);
    }

    public void removeListListener(ListListener<T> r3) {
        ListListener r4 = (ListListener) ZeusTransformUtils.wrapperContextForParams(r3, ListListener.class, "com.obric.memorydata.plugin");
        this.mListeners.remove(r4);
    }

    public void submitList(List<T> r3) {
        submitList((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), null);
    }

    public void submitList(List<T> r9, Runnable r10) {
        final List<T> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        final Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r10, Runnable.class, "com.obric.memorydata.plugin");
        final int r6 = this.mMaxScheduledGeneration + 1;
        this.mMaxScheduledGeneration = r6;
        final List<T> r4 = this.mList;
        if (r5 != r4) goto L7;
        if (r7 == null) goto L16;
        r7.run();
        return;
    L16:
        return;
    L7:
        List<T> r11 = this.mReadOnlyList;
        if (r5 != null) goto L11;
        int r0 = r4.size();
        this.mList = null;
        this.mReadOnlyList = Collections.emptyList();
        this.mUpdateCallback.onRemoved(0, r0);
        onCurrentListChanged(r11, r7);
        return;
    L11:
        if (r4 != null) goto L14;
        this.mList = r5;
        this.mReadOnlyList = Collections.unmodifiableList(r5);
        this.mUpdateCallback.onInserted(0, r5.size());
        onCurrentListChanged(r11, r7);
        return;
    L14:
        this.mConfig.getBackgroundThreadExecutor().execute(new AnonymousClass1(this, r4, r5, r6, r7));
    }
}
