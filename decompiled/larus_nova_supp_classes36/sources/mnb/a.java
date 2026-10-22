package mnb;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.jsruntime.EngineType;
import rnb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: mnb.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0297a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[EngineType.values().length];
            r0[EngineType.VMSDK_QUICKJS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[EngineType.VMSDK_V8.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[EngineType.AHA_V8.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public static boolean a() {
        boolean r0 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.mobile.enable_runtime_debug");
        c.c("ccm_JSRuntimeFactory", "enableRuntimeDebug: " + r0);
        return r0;
    }
}
