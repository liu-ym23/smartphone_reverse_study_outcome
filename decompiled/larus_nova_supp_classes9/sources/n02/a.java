package n02;

import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {

    /* JADX INFO: renamed from: n02.a$a, reason: collision with other inner class name */
    public static final class C0252a {
    }

    static {
    }

    public a() {
    }

    public static void a(EffectMessage r1) {
        if (r1 == null) goto L5;
        Intrinsics.checkNotNullParameter(new Throwable("vibration is not supported on saas (missing CapabilityScheduler)"), "throwable");
        return;
    }
}
