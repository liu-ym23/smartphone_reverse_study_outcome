package kotlinx.coroutines;

import kotlin.jvm.JvmField;

/* JADX INFO: loaded from: classes3.dex */
public final class d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.i0 f10330a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public static final kotlinx.coroutines.internal.i0 f10331b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.i0 f10332c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.i0 f10333d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.i0 f10334e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final e1 f10335f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final e1 f10336g = null;

    static {
        f10330a = new kotlinx.coroutines.internal.i0("COMPLETING_ALREADY");
        f10331b = new kotlinx.coroutines.internal.i0("COMPLETING_WAITING_CHILDREN");
        f10332c = new kotlinx.coroutines.internal.i0("COMPLETING_RETRY");
        f10333d = new kotlinx.coroutines.internal.i0("TOO_LATE_TO_CANCEL");
        f10334e = new kotlinx.coroutines.internal.i0("SEALED");
        f10335f = new e1(false);
        f10336g = new e1(true);
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.i0 a() {
        return f10330a;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.i0 b() {
        return f10332c;
    }

    public static final /* synthetic */ e1 c() {
        return f10336g;
    }

    public static final /* synthetic */ e1 d() {
        return f10335f;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.i0 e() {
        return f10334e;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.i0 f() {
        return f10333d;
    }

    public static final Object g(Object r10) {
        if ((r10 instanceof p1) == true) goto L5;
        return r10;
    L5:
        return new q1((p1) r10);
    }

    public static final Object h(Object r10) {
        if ((r10 instanceof q1) == false) goto L5;
        q1 r11 = (q1) r10;
    L6:
        if (r11 == null) goto L12;
        p1 r12 = r11.f10627a;
        if (r12 != null) goto L11;
        return r10;
    L11:
        return r12;
    L12:
        return r10;
    L5:
        r11 = null;
        goto L6
    }
}
