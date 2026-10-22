package c8;

import android.content.Context;
import android.view.View;
import com.bytedance.android.annie.lynx.bridge.AnnieLynxBridgeModule;
import com.bytedance.android.annie.lynx.f;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.ies.web.jsbridge2.o;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.WritableMap;
import com.lynx.tasm.LynxView;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends com.bytedance.ies.web.jsbridge2.b {
    public static final Scheduler u = null;
    public final Context n;
    public final ConcurrentLinkedQueue<f> o;
    public final String p;
    public final com.bytedance.android.annie.param.a q;
    public final Function0<String> r;
    public AnnieLynxBridgeModule s;
    public LynxView t;

    public static final class a {
    }

    public final void j(o r10) {
        Intrinsics.checkNotNullParameter(r10, "environment");
    }

    static {
        u = Schedulers.single();
    }

    public final View g() {
        LynxView r0 = this.t;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("lynxView");
        return null;
    L7:
        return r0;
    }

    public final String h() {
        return (String) this.r.invoke();
    }

    public Context getContext(o r10) {
        Intrinsics.checkNotNullParameter(r10, "environment");
        return this.n;
    }

    public final void k(String r10) {
        r(new JSONObject(r10));
    }

    public final void l(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "jsonObject");
        r(r10);
    }

    public final void r(JSONObject r10) {
        Object r0 = r10.remove("__event_id");
        LynxView r11 = null;
        if ((r0 instanceof String) == false) goto L5;
        String r1 = (String) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        Object r12 = r10.remove("__params");
        if (r12 == null) goto L18;
        JSONObject r13 = new JSONObject();
        r13.put("code", 1);
        r13.put("data", r12);
        WritableMap r14 = c8.a.d(r13);
        if (r14 == null) goto L19;
        LynxView r15 = this.t;
        if (r15 == null) goto L15;
        r11 = r15;
    L16:
        r11.sendGlobalEvent(r1, JavaOnlyArray.of(new Object[]{r14}));
        return;
    L15:
        Intrinsics.throwUninitializedPropertyAccessException("lynxView");
        goto L16
    L19:
        return;
    L18:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void m(String r10, c0 r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        if (r11 != null) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject(r10);
        Iterator<T> r12 = this.o.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        ((f) r12.next()).c(r0, r11);
        goto L7
    L9:
        AnnieLynxBridgeModule r13 = this.s;
        if (r13 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("lynxBridgeModule");
        r13 = null;
    L13:
        r13.invokeCallback$annie_lynx_release(r0, r11);
    }

    public final void n(JSONObject r10, c0 r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        if (r11 != null) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.o.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((f) r0.next()).c(r10, r11);
        goto L7
    L9:
        AnnieLynxBridgeModule r1 = this.s;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("lynxBridgeModule");
        r1 = null;
    L13:
        r1.invokeCallback$annie_lynx_release(r10, r11);
    }

    public b(Context r10, ConcurrentLinkedQueue<f> r11, String r12, com.bytedance.android.annie.param.a r13, Function0<String> r14) {
        Intrinsics.checkNotNullParameter(r10, "androidContext");
        Intrinsics.checkNotNullParameter(r11, "lifecycleCallbacks");
        Intrinsics.checkNotNullParameter(r13, "annieContext");
        Intrinsics.checkNotNullParameter(r14, com.bytedance.android.ec.core.event.a.KEY_URL);
        this.n = r10;
        this.o = r11;
        this.p = r12;
        this.q = r13;
        this.r = r14;
    }
}
