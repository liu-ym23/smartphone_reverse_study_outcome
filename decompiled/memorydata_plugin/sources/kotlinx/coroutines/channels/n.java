package kotlinx.coroutines.channels;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.de;
import kotlinx.coroutines.internal.ag;
import kotlinx.coroutines.internal.aj;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00000\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ)\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b\u0019J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\tH\u0000¢\u0006\u0002\b\u001cJ!\u0010\u001d\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b\u001fJ\u0017\u0010 \u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\tH\u0000¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\tH\u0000¢\u0006\u0002\b$J\"\u0010%\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)H\u0016J\u0016\u0010*\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0015J\u0017\u0010,\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\tH\u0000¢\u0006\u0004\b-\u0010\"J\u001a\u0010.\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010\u0010H\u0002J\u001f\u00100\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b1J\u001f\u00102\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u00103\u001a\u00028\u0000H\u0000¢\u0006\u0004\b4\u00105R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fX\u0082\u0004R\u0014\u0010\u0011\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u00066"}, d2 = {"Lkotlinx/coroutines/channels/ChannelSegment;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/internal/Segment;", OaidModel.KEY_ID, "", "prev", "channel", "Lkotlinx/coroutines/channels/BufferedChannel;", "pointers", "", "(JLkotlinx/coroutines/channels/ChannelSegment;Lkotlinx/coroutines/channels/BufferedChannel;I)V", "_channel", "getChannel", "()Lkotlinx/coroutines/channels/BufferedChannel;", "data", "Lkotlinx/atomicfu/AtomicArray;", "", "numberOfSlots", "getNumberOfSlots", "()I", "casState", "", "index", "from", TypedValues.TransitionType.S_TO, "casState$kotlinx_coroutines_core", "cleanElement", "", "cleanElement$kotlinx_coroutines_core", "getAndSetState", BuildConfig.CHANNEL, "getAndSetState$kotlinx_coroutines_core", "getElement", "getElement$kotlinx_coroutines_core", "(I)Ljava/lang/Object;", "getState", "getState$kotlinx_coroutines_core", "onCancellation", "cause", "", "context", "Lkotlin/coroutines/CoroutineContext;", "onCancelledRequest", "receiver", "retrieveElement", "retrieveElement$kotlinx_coroutines_core", "setElementLazy", EventBody.KEY_VALUE, "setState", "setState$kotlinx_coroutines_core", "storeElement", "element", "storeElement$kotlinx_coroutines_core", "(ILjava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class n<E> extends ag<n<E>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g<E> f17292b;
    private final /* synthetic */ AtomicReferenceArray c;

    public n(long r3, n<E> r5, g<E> r6, int r7) {
        super(r3, (ag) ZeusTransformUtils.preCheckCast(r5, ag.class, "com.obric.memorydata.plugin"), r7);
        this.f17292b = r6;
        this.c = new AtomicReferenceArray(h.f17284a * 2);
    }

    private final void d(int r1, Object r2) {
        m().set(r1 * 2, r2);
    }

    private final /* synthetic */ AtomicReferenceArray m() {
        return this.c;
    }

    public final E a(int r1) {
        return (E) m().get(r1 * 2);
    }

    public final g<E> a() {
        g<E> r0 = this.f17292b;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public final void a(int r1, E r2) {
        d(r1, r2);
    }

    @Override // kotlinx.coroutines.internal.ag
    public void a(int r4, Throwable r5, CoroutineContext r6) {
        CoroutineContext r7 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r6, CoroutineContext.class, "com.obric.memorydata.plugin");
        if (r4 < h.f17284a) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L8;
        r4 = r4 - h.f17284a;
    L8:
        E r0 = a(r4);
    L9:
        Object r1 = d(r4);
        if (ZeusTransformUtils.instanceOf(r1, de.class) == true) goto L41;
        if (ZeusTransformUtils.instanceOf(r1, ab.class) == true) goto L41;
        if (r1 == h.e()) goto L35;
        if (r1 == h.g()) goto L35;
        if (r1 == h.m()) goto L9;
        if (r1 == h.n()) goto L9;
        if (r1 != h.f()) goto L27;
        return;
    L27:
        if (r1 != h.f17285b) goto L30;
        return;
    L30:
        if (r1 != h.b()) goto L33;
        return;
    L33:
        throw new IllegalStateException(("unexpected state: " + r1).toString());
    L35:
        c(r4);
        if (r8 == false) goto L65;
        Function1<E, Unit> r3 = a().f17279b;
        if (r3 == null) goto L66;
        kotlinx.coroutines.internal.ab.a(r3, r0, r7);
        return;
    L66:
        return;
    L65:
        return;
    L41:
        if (r8 == false) goto L43;
        aj r2 = h.e();
    L45:
        if (a(r4, r1, r2) == false) goto L9;
        c(r4);
        a(r4, !r8);
        if (r8 == false) goto L67;
        Function1<E, Unit> r9 = a().f17279b;
        if (r9 == null) goto L68;
        kotlinx.coroutines.internal.ab.a(r9, r0, r7);
        return;
    L68:
        return;
    L67:
        return;
    L43:
        r2 = h.g();
        goto L45
    L5:
        r8 = false;
        goto L6
    }

    public final void a(int r5, boolean r6) {
        if (r6 == false) goto L4;
        a().b((this.f17558a * ((long) h.f17284a)) + ((long) r5));
    L4:
        l();
    }

    public final boolean a(int r1, Object r2, Object r3) {
        return m().compareAndSet((r1 * 2) + 1, r2, r3);
    }

    @Override // kotlinx.coroutines.internal.ag
    public int b() {
        return h.f17284a;
    }

    public final E b(int r2) {
        E r0 = a(r2);
        c(r2);
        return r0;
    }

    public final void b(int r1, Object r2) {
        m().set((r1 * 2) + 1, r2);
    }

    public final Object c(int r1, Object r2) {
        return m().getAndSet((r1 * 2) + 1, r2);
    }

    public final void c(int r2) {
        d(r2, null);
    }

    public final Object d(int r1) {
        return m().get((r1 * 2) + 1);
    }
}
