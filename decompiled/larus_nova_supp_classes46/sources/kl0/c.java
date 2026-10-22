package kl0;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.lynx.bridge.LiveLynxBridgeModule;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.ies.web.jsbridge2.o;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.WritableMap;
import com.lynx.tasm.LynxView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends com.bytedance.ies.web.jsbridge2.b {
    public static final /* synthetic */ int r = 0;
    public LiveLynxBridgeModule n;
    public LynxView o;
    public final Context p;
    public final Function0<String> q;

    public static final class a {
    }

    static {
    }

    public final void j(o r2) {
        Intrinsics.checkNotNullParameter(r2, "environment");
    }

    public final View g() {
        LynxView r0 = this.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lynxView");
    L5:
        return r0;
    }

    public final String h() {
        return (String) this.q.invoke();
    }

    public Context getContext(o r2) {
        Intrinsics.checkNotNullParameter(r2, "environment");
        return this.p;
    }

    public final void k(String r2) {
        r(new JSONObject(r2));
    }

    public final void l(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "jsonObject");
        r(r2);
    }

    public final void r(JSONObject r5) {
        Object r0 = r5.remove("__event_id");
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        String r1 = (String) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        Object r6 = r5.remove("__params");
        if (r6 == null) goto L17;
        JSONObject r2 = new JSONObject();
        r2.put("code", 1);
        r2.put("data", r6);
        WritableMap r7 = b.d(r2);
        if (r7 == null) goto L18;
        LynxView r3 = this.o;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("lynxView");
    L15:
        r3.sendGlobalEvent(r1, JavaOnlyArray.of(new Object[]{r7}));
        return;
    L18:
        return;
    }

    public c(Context r2, Function0<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "androidContext");
        Intrinsics.checkNotNullParameter(r3, "url");
        this.p = r2;
        this.q = r3;
    }

    public final void m(String r3, c0 r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        if (r4 != null) goto L5;
        return;
    L5:
        LiveLynxBridgeModule r0 = this.n;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("lynxBridgeModule");
    L8:
        r0.invokeCallback$livehybrid_impl_saasRelease(new JSONObject(r3), r4);
    }

    public final void n(JSONObject r3, c0 r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        if (r4 != null) goto L5;
        return;
    L5:
        LiveLynxBridgeModule r0 = this.n;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("lynxBridgeModule");
    L8:
        r0.invokeCallback$livehybrid_impl_saasRelease(r3, r4);
    }
}
