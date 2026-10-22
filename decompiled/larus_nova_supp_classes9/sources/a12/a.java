package a12;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.model.d;
import com.bytedance.android.livesdk.gift.platform.core.utils.z;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;
import tz0.b;
import uz0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Observable a(boolean r13, int r14, String r15) {
        Intrinsics.checkNotNullParameter(r15, "supportAsset265");
        b r0 = b.a;
        e r1 = new e();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map r2 = ((uz0.a) r1).b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r16 = Integer.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter("download_assets_from", "$this$setTo");
        if (r16 == null) goto L6;
        r2.put("download_assets_from", r16);
    L6:
        if (r13 == false) goto L15;
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r17 = ILiveWrappedEffectSDKService.a.a();
        if (r17 == null) goto L10;
        String r18 = r17.getSdkVersion();
    L11:
        Intrinsics.checkNotNullParameter("effect_sdk_version", "$this$setTo");
        if (r18 == null) goto L14;
        r2.put("effect_sdk_version", r18);
    L14:
        int r19 = b12.b.a;
        Intrinsics.checkNotNullParameter("ttlive_get_effect_sdk_version_status", "name");
        b12.b.b(z.a("ttlive_get_effect_sdk_version_status"), new JSONObject(), 0);
        goto L15
    L10:
        r18 = null;
    L15:
        Intrinsics.checkNotNullParameter("asset_265_supported", "$this$setTo");
        r2.put("asset_265_supported", r15);
        String r110 = String.valueOf(false);
        Intrinsics.checkNotNullParameter("is_living", "$this$setTo");
        if (r110 == null) goto L18;
        r2.put("is_living", r110);
    L18:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return f.a(INetworkService.class).L4(INetworkService.Biz.Revenue, "/webcast/assets/effects/", TypesJVMKt.getJavaType(Reflection.typeOf(d.class)), Extra.class, ((uz0.a) r1).d, ((uz0.a) r1).a, ((uz0.a) r1).b, ((uz0.a) r1).c, r1.e, r1.f, r1.g);
    }
}
