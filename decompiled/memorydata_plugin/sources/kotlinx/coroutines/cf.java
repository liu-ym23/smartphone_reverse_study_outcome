package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0010\u0010\r\u001a\u0004\u0018\u00010\u000e*\u0004\u0018\u00010\u000eH\u0000\u001a\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u0004\u0018\u00010\u000eH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"COMPLETING_ALREADY", "Lkotlinx/coroutines/internal/Symbol;", "COMPLETING_RETRY", "COMPLETING_WAITING_CHILDREN", "EMPTY_ACTIVE", "Lkotlinx/coroutines/Empty;", "EMPTY_NEW", "FALSE", "", "RETRY", "SEALED", "TOO_LATE_TO_CANCEL", "TRUE", "boxIncomplete", "", "unboxState", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class cf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.aj f17268a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.aj f17269b = null;
    private static final kotlinx.coroutines.internal.aj c = null;
    private static final kotlinx.coroutines.internal.aj d = null;
    private static final kotlinx.coroutines.internal.aj e = null;
    private static final bf f = null;
    private static final bf g = null;

    static {
        f17269b = new kotlinx.coroutines.internal.aj("COMPLETING_ALREADY");
        f17268a = new kotlinx.coroutines.internal.aj("COMPLETING_WAITING_CHILDREN");
        c = new kotlinx.coroutines.internal.aj("COMPLETING_RETRY");
        d = new kotlinx.coroutines.internal.aj("TOO_LATE_TO_CANCEL");
        e = new kotlinx.coroutines.internal.aj("SEALED");
        f = new bf(false);
        g = new bf(true);
    }

    public static final Object a(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, br.class) == true) goto L5;
        return r3;
    L5:
        return new bs((br) ZeusTransformUtils.preCheckCast(r3, br.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ bf a() {
        return g;
    }

    public static final Object b(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, bs.class) == false) goto L5;
        bs r0 = (bs) ZeusTransformUtils.preCheckCast(r2, bs.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L12;
        br r1 = r0.f17247a;
        if (r1 != null) goto L11;
        return r2;
    L11:
        return r1;
    L12:
        return r2;
    L5:
        r0 = null;
        goto L6
    }

    public static final /* synthetic */ bf b() {
        return f;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.aj c() {
        return f17269b;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.aj d() {
        return d;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.aj e() {
        return c;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.aj f() {
        return e;
    }
}
