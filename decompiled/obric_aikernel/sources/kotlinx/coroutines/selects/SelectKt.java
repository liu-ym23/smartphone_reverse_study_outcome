package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.internal.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class SelectKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Function3<Object, Object, Object, Object> f10672a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final i0 f10673b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final i0 f10674c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final i0 f10675d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final i0 f10676e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final i0 f10677f = null;

    static {
        f10672a = SelectKt$DUMMY_PROCESS_RESULT_FUNCTION$1.INSTANCE;
        f10673b = new i0("STATE_REG");
        f10674c = new i0("STATE_COMPLETED");
        f10675d = new i0("STATE_CANCELLED");
        f10676e = new i0("NO_RESULT");
        f10677f = new i0("PARAM_CLAUSE_0");
    }

    private static final TrySelectDetailedResult a(int r10) {
        if (r10 == 0) goto L15;
        if (r10 == 1) goto L18;
        if (r10 == 2) goto L17;
        if (r10 != 3) goto L11;
        return TrySelectDetailedResult.ALREADY_SELECTED;
    L11:
        throw new IllegalStateException(("Unexpected internal result: " + r10).toString());
    L17:
        return TrySelectDetailedResult.CANCELLED;
    L18:
        return TrySelectDetailedResult.REREGISTER;
    L15:
        return TrySelectDetailedResult.SUCCESSFUL;
    }

    public static final /* synthetic */ TrySelectDetailedResult b(int r10) {
        return a(r10);
    }

    public static final /* synthetic */ Function3 c() {
        return f10672a;
    }

    public static final /* synthetic */ i0 d() {
        return f10676e;
    }

    public static final /* synthetic */ i0 e() {
        return f10675d;
    }

    public static final /* synthetic */ i0 f() {
        return f10674c;
    }

    public static final /* synthetic */ i0 g() {
        return f10673b;
    }

    public static final /* synthetic */ boolean h(kotlinx.coroutines.n r10, Function1 r11) {
        return j(r10, r11);
    }

    public static final i0 i() {
        return f10677f;
    }

    private static final boolean j(kotlinx.coroutines.n<? super Unit> r10, Function1<? super Throwable, Unit> r11) {
        Object r12 = r10.k(Unit.INSTANCE, null, r11);
        if (r12 != null) goto L6;
        return false;
    L6:
        r10.N(r12);
        return true;
    }
}
