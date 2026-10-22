package bp1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.model.k3;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T, R> implements Function {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final Object apply(Object r7) {
        Response r8 = (Response) r7;
        Intrinsics.checkNotNullParameter(r8, "response");
        i r0 = new i(0);
        if (((BaseResponse) r8).statusCode == 0) goto L5;
        int r9 = a.h;
        ALogger.e("ExtShareEnhancePanel", "ShopGuideID Error: response.statusCode != 0! ");
    L18:
        return r0;
    L5:
        if (((BaseResponse) r8).data != null) goto L8;
        int r2 = a.h;
        ALogger.e("ExtShareEnhancePanel", "ShopGuideID Error: response.data == null，获取导购信息失败! ");
        r0.c = false;
        r0.b = "";
    L8:
        if (((k3) ((BaseResponse) r8).data).a() != null) goto L10;
    L16:
        int r10 = a.h;
        ALogger.e("ExtShareEnhancePanel", "ShopGuideID Error: 导购信息 == null! ");
        r0.c = false;
        r0.b = "";
        goto L18
    L10:
        if (Intrinsics.areEqual(((k3) ((BaseResponse) r8).data).a(), Boolean.TRUE) == false) goto L16;
        if (mz.c.b(((k3) ((BaseResponse) r8).data).c()) == true) goto L16;
        if (mz.c.b(((k3) ((BaseResponse) r8).data).d()) == true) goto L16;
        r0.a = ((k3) ((BaseResponse) r8).data).c();
        r0.c = true;
        r0.b = ((k3) ((BaseResponse) r8).data).d();
        goto L18
    }
}
