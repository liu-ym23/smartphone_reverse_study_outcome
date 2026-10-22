package wo1;

import android.view.View;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.jsb.BannerAccessibilityMethod$invoke$1;
import com.bytedance.android.livesdk.config.br;
import com.bytedance.android.livesdk.r3;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends b<j, JsonObject> {
    public final WeakReference<View> a;
    public final Boolean b;
    public final String c;

    public static final class a {
    }

    static {
    }

    public c(View r1, String r2) {
        this.c = r2;
        this.a = new WeakReference(r1);
        this.b = (Boolean) br.a.getValue();
    }

    public final void invoke(Object r3, CallContext r4) {
        final j r5 = (j) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        View r6 = this.a.get();
        ALogger.i("BannerAccessibilityMethod", "invoke: params=" + GsonProtectorUtils.toJson(GsonHelper.get(), r5) + " view=" + r6);
        if (r6 != null) goto L5;
        finishWithFailure(new Exception("view已被销毁"));
        return;
    L5:
        r3.e(r6, new BannerAccessibilityMethod$invoke$1(this, r5));
        if (Intrinsics.areEqual(r5.b(), Boolean.TRUE) == true) goto L8;
    L11:
        finishWithSuccess();
        return;
    L8:
        if (r6.getVisibility() != 0) goto L10;
        r6.sendAccessibilityEvent(128);
        goto L11
    L10:
        ALogger.i("BannerAccessibilityMethod", "view cannot request focus because it is invisible");
        finishWithFailure(new Exception("view cannot request focus because it is invisible"));
    }
}
