package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import cn.nubia.neopush.commons.Constant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u000fH$J\b\u0010\u0013\u001a\u00020\u000fH\u0016J*\u0010\u0014\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0004J\"\u0010\u0019\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0004R&\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000@TX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/runtime/AbstractApplier;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/Applier;", "root", "(Ljava/lang/Object;)V", "<set-?>", "current", "getCurrent", "()Ljava/lang/Object;", "setCurrent", "Ljava/lang/Object;", "getRoot", "stack", "", "clear", "", Constant.ClientMessageType.DOWN, "node", "onClear", "up", "move", "from", "", "to", "count", "remove", "index", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AbstractApplier<T> implements Applier<T> {
    public static final int $stable = 8;
    private T current;
    private final T root;
    private final List<T> stack;

    public AbstractApplier(T r5) {
        this.root = r5;
        this.stack = new ArrayList();
        this.current = r5;
    }

    @Override // androidx.compose.runtime.Applier
    public final void clear() {
        this.stack.clear();
        setCurrent(this.root);
        onClear();
    }

    @Override // androidx.compose.runtime.Applier
    public void down(T r5) {
        this.stack.add(getCurrent());
        setCurrent(r5);
    }

    @Override // androidx.compose.runtime.Applier
    public T getCurrent() {
        return this.current;
    }

    public final T getRoot() {
        return this.root;
    }

    public final void move(List<T> r5, int r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 <= r11) goto L5;
        int r13 = r11;
    L7:
        if (r12 == 1) goto L9;
        List<T> r14 = r5.subList(r10, r12 + r10);
        List r15 = CollectionsKt.toMutableList(r14);
        r14.clear();
        r5.addAll(r13, r15);
        return;
    L9:
        if (r10 != (r11 + 1)) goto L11;
    L14:
        r5.set(r10, r5.set(r11, r5.get(r10)));
        return;
    L11:
        if (r10 == (r11 - 1)) goto L14;
        r5.add(r13, r5.remove(r10));
        return;
    L5:
        r13 = r11 - r12;
        goto L7
    }

    public abstract void onClear();

    public final void remove(List<T> r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r11 != 1) goto L5;
        r5.remove(r10);
        return;
    L5:
        r5.subList(r10, r11 + r10).clear();
    }

    public void setCurrent(T r5) {
        this.current = r5;
    }

    @Override // androidx.compose.runtime.Applier
    public void up() {
        if (this.stack.isEmpty() == true) goto L7;
        List<T> r5 = this.stack;
        setCurrent(r5.remove(r5.size() - 1));
        return;
    L7:
        throw new IllegalStateException("Check failed.");
    }
}
