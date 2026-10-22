package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\b\u0010\b\u001a\u00020\u0001H\u0002\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"DefaultDelay", "Lkotlinx/coroutines/Delay;", "getDefaultDelay$annotations", "()V", "getDefaultDelay", "()Lkotlinx/coroutines/Delay;", "defaultMainDelayOptIn", "", "initializeDefaultDelay", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class aq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f17221a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final at f17222b = null;

    static {
        f17221a = kotlinx.coroutines.internal.ak.a("kotlinx.coroutines.main.delay", false);
        f17222b = b();
    }

    public static final at a() {
        return f17222b;
    }

    private static final at b() {
        if (f17221a == false) goto L5;
        ci r0 = ba.b();
        if (kotlinx.coroutines.internal.z.a(r0) == true) goto L10;
        boolean r2 = ZeusTransformUtils.instanceOf(r0, at.class);
        Object r1 = r0;
        if (r2 == false) goto L10;
    L12:
        return (at) ZeusTransformUtils.preCheckCast(r1, at.class, "com.obric.memorydata.plugin");
    L10:
        r1 = ap.f17219a;
        goto L12
    L5:
        return (at) ZeusTransformUtils.preCheckCast(ap.f17219a, at.class, "com.obric.memorydata.plugin");
    }
}
