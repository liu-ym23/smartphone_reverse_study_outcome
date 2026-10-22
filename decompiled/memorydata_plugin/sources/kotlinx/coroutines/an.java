package kotlinx.coroutines;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.security.dbcipher.utils.CipherConst;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0081\b\u001a\b\u0010\u0018\u001a\u00020\u0015H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0014\u0010\b\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003\"\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u001c\u0010\u000f\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0003\"\u000e\u0010\u0013\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"ASSERTIONS_ENABLED", "", "getASSERTIONS_ENABLED", "()Z", "COROUTINE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "getCOROUTINE_ID", "()Ljava/util/concurrent/atomic/AtomicLong;", CipherConst.LEVEL_DEBUG, "getDEBUG", "DEBUG_PROPERTY_NAME", "", "DEBUG_PROPERTY_VALUE_AUTO", "DEBUG_PROPERTY_VALUE_OFF", "DEBUG_PROPERTY_VALUE_ON", "RECOVER_STACK_TRACES", "getRECOVER_STACK_TRACES$annotations", "()V", "getRECOVER_STACK_TRACES", "STACKTRACE_RECOVERY_PROPERTY_NAME", "assert", "", EventBody.KEY_VALUE, "Lkotlin/Function0;", "resetCoroutineId", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class an {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f17212a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f17213b = false;
    private static final boolean c = false;
    private static final AtomicLong d = null;

    static {
        boolean r0 = false;
        f17212a = false;
        String r1 = kotlinx.coroutines.internal.ak.a("kotlinx.coroutines.debug");
        if (r1 == null) goto L26;
        int r3 = r1.hashCode();
        if (r3 == 0) goto L22;
        if (r3 == 3551) goto L19;
        if (r3 == 109935) goto L16;
        if (r3 != 3005871) goto L25;
        if (r1.equals("auto") == true) goto L26;
    L25:
        throw new IllegalStateException(("System property 'kotlinx.coroutines.debug' has unrecognized value '" + r1 + '\'').toString());
    L16:
        if (r1.equals(com.tom_roush.pdfbox.pdmodel.a.d.f.g) == false) goto L25;
    L19:
        if (r1.equals(com.tom_roush.pdfbox.pdmodel.a.d.f.f) == false) goto L25;
    L23:
        boolean r2 = true;
    L27:
        f17213b = r2;
        if (r2 == true) goto L30;
    L32:
        c = r0;
        d = new AtomicLong(0);
        return;
    L30:
        if (kotlinx.coroutines.internal.ak.a("kotlinx.coroutines.stacktrace.recovery", true) == false) goto L32;
        r0 = true;
        goto L32
    L22:
        if (r1.equals("") == false) goto L25;
    L26:
        r2 = false;
        goto L27
    }

    public static final boolean a() {
        return f17212a;
    }

    public static final boolean b() {
        return f17213b;
    }

    public static final boolean c() {
        return c;
    }

    public static final AtomicLong d() {
        return d;
    }
}
