package androidx.activity;

import androidx.core.util.Consumer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class OnBackPressedCallback {
    private CopyOnWriteArrayList<Cancellable> mCancellables;
    private boolean mEnabled;
    private Consumer<Boolean> mEnabledConsumer;

    public OnBackPressedCallback(boolean r2) {
        this.mCancellables = new CopyOnWriteArrayList();
        this.mEnabled = r2;
    }

    void addCancellable(Cancellable r3) {
        Cancellable r4 = (Cancellable) ZeusTransformUtils.wrapperContextForParams(r3, Cancellable.class, "com.obric.memorydata.plugin");
        this.mCancellables.add(r4);
    }

    public abstract void handleOnBackPressed();

    public final boolean isEnabled() {
        return this.mEnabled;
    }

    public final void remove() {
        Iterator<Cancellable> r3 = this.mCancellables.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((Cancellable) ZeusTransformUtils.preCheckCast(r3.next(), Cancellable.class, "com.obric.memorydata.plugin")).cancel();
        goto L4
    }

    void removeCancellable(Cancellable r3) {
        Cancellable r4 = (Cancellable) ZeusTransformUtils.wrapperContextForParams(r3, Cancellable.class, "com.obric.memorydata.plugin");
        this.mCancellables.remove(r4);
    }

    public final void setEnabled(boolean r1) {
        this.mEnabled = r1;
        Consumer<Boolean> r0 = this.mEnabledConsumer;
        if (r0 == null) goto L6;
        r0.accept(Boolean.valueOf(r1));
        return;
    }

    void setIsEnabledConsumer(Consumer<Boolean> r3) {
        this.mEnabledConsumer = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
    }
}
