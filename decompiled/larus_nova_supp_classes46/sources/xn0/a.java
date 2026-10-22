package xn0;

import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(HashMap r4) {
        Intrinsics.checkNotNullParameter(r4, "kv");
        Iterator r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L21;
        Map.Entry r0 = (Map.Entry) r5.next();
        String r1 = (String) r0.getKey();
        String r2 = (String) r0.getValue();
        int r3 = r1.hashCode();
        if (r3 != (-1877291291)) goto L8;
        if (r1.equals("enable_push_so") == false) goto L4;
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r6 = ILiveWrappedEffectSDKService.a.a();
        if (r6 == null) goto L4;
        r6.multiMediaEnv_diagnosis_setEnableLoadLibrariesFromDisk(Boolean.parseBoolean(r2));
        goto L4
    L8:
        if (r3 != 1343046286) goto L4;
        if (r1.equals("enable_vehook") == false) goto L4;
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r7 = ILiveWrappedEffectSDKService.a.a();
        if (r7 == null) goto L4;
        r7.multiMediaEnv_diagnosis_setEnableVEHook(Boolean.parseBoolean(r2));
        goto L4
    }
}
