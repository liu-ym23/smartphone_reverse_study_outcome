package na8;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class o extends bx7.c {
    public final String b;
    public final String c;
    public gk5.b d;
    public gk5.a e;

    public static final class a {
    }

    static {
    }

    public boolean f(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return false;
    }

    public final void release() {
        i(null);
    }

    public final String getName() {
        return this.b;
    }

    public static Map g(JSONObject r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<String> r1 = r4.keys();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r2 = r1.next();
        r0.put(r2, h(r4.opt(r2)));
        goto L4
    L6:
        return r0;
    }

    public static Object h(Object r4) {
        if (r4 == null) goto L16;
        if (Intrinsics.areEqual(r4, JSONObject.NULL) == true) goto L16;
        if ((r4 instanceof JSONObject) == false) goto L10;
        return g((JSONObject) r4);
    L10:
        if ((r4 instanceof JSONArray) == false) goto L19;
        JSONArray r5 = (JSONArray) r4;
        int r0 = r5.length();
        ArrayList r1 = new ArrayList(r0);
        int r2 = 0;
    L12:
        if (r2 >= r0) goto L20;
        r1.add(h(r5.opt(r2)));
        r2 = r2 + 1;
        goto L12
    L20:
        return r1;
    L19:
        return r4;
    L16:
        return JSONObject.NULL;
    }

    public final void i(gk5.a r3) {
        monitor-enter(this);
        if (r3 != null) goto L18;
    L8:
        Pair r4 = new Pair(this.d, this.e);     // Catch: Throwable -> L15
        this.d = null;     // Catch: Throwable -> L15
        this.e = null;     // Catch: Throwable -> L15
        monitor-exit(this);
        gk5.b r0 = (gk5.b) r4.component1();
        gk5.a r5 = (gk5.a) r4.component2();
        if (r0 == null) goto L20;
        if (r5 == null) goto L21;
        r0.b(r5);
        return;
    L21:
        return;
    L20:
        return;
    L15:
        th = move-exception;
        throw th;
    L18:
        if (this.e == r3) goto L8;
        monitor-exit(this);
    }

    public o(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this.b = r2;
        this.c = r3;
    }

    public final void a(dx7.b r9, ux7.d.d r10, IvyBridgePlatformType r11) {
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r10, "callback");
        Intrinsics.checkNotNullParameter(r11, "type");
        FLogger r0 = FLogger.a;
        r0.i("OfficeCCMH5JSBMethod", "handle request, method=" + this.b + ", platform=" + r11);
        String r1 = "";
        if (this.c == null) goto L15;
        p56.b r12 = (p56.b) e(p56.b.class);
        if (r12 == null) goto L8;
        String r13 = r12.provideContainerID();
    L9:
        if (r13 == null) goto L13;
        r1 = r13;
    L13:
        if (StringsKt.isBlank(r1) == false) goto L15;
        r0.w("OfficeCCMH5JSBMethod", "reject request, method=" + this.b + ", reason=container_id_unavailable");
        bx7.c.c(this, r10, 0, "container ID unavailable", 8);
        r1 = null;
        goto L15
    L8:
        r13 = null;
    L15:
        if (r1 != null) goto L17;
        return;
    L17:
        Context r14 = (Context) e(Context.class);
        if (r14 == null) goto L21;
        Activity r15 = com.bytedance.ies.xbridge.utils.f.a.getActivity(r14);
        if (r15 == null) goto L21;
    L23:
        if ((r15 instanceof FragmentActivity) == false) goto L25;
        FragmentActivity r16 = (FragmentActivity) r15;
    L26:
        if (r16 != null) goto L28;
    L81:
        r0.w("OfficeCCMH5JSBMethod", "reject request, method=" + this.b + ", reason=activity_unavailable");
        bx7.c.c(this, r10, 0, "activity unavailable", 8);
        return;
    L28:
        if (r16.isFinishing() == false) goto L30;
    L32:
        boolean r5 = false;
    L33:
        if (r5 == false) goto L81;
        Object r6 = xp9.o.a;
        if ((r6 instanceof OfficeSDKUserApi) == false) goto L38;
        OfficeSDKUserApi r7 = (OfficeSDKUserApi) r6;
    L39:
        if (r7 == null) goto L41;
        gk5.d r8 = (gk5.d) r7.getService(gk5.d.class);
    L42:
        if (r8 != null) goto L45;
        r0.w("OfficeCCMH5JSBMethod", "reject request, method=" + this.b + ", reason=service_unavailable");
        bx7.c.c(this, r10, 0, "Office CCM H5 JSB service unavailable", 8);
        return;
    L45:
        gk5.b r17 = r8.Y5(this.b);
        if (r17 != null) goto L50;
        r0.w("OfficeCCMH5JSBMethod", "reject request, method=" + this.b + ", reason=handler_unavailable");
        bx7.c.c(this, r10, 0, "Office CCM H5 JSB handler unavailable", 8);
        return;
    L50:
        if (this.c != null) goto L52;
    L55:
        i(null);
        AtomicBoolean r2 = new AtomicBoolean(false);
        p r4 = new p(r2, this, r10, r1);
        if (this.c != null) goto L58;
    L83:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L69
        r17.a(r16, new JSONObject(r9.a()), r4);     // Catch: Throwable -> L69
        Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L69
    L71:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L87;
        i(r4);
        FLogger r110 = FLogger.a;
        r110.e("OfficeCCMH5JSBMethod", "handle " + this.b + " failed", r19);
        if (r2.compareAndSet(false, true) == false) goto L79;
        String r20 = r19.getMessage();
        if (r20 != null) goto L78;
        r20 = "Office CCM H5 JSB handle failed";
    L78:
        bx7.c.c(this, r10, 0, r20, 8);
        return;
    L79:
        r110.w("OfficeCCMH5JSBMethod", "ignore exception after completion, method=" + this.b);
        return;
    L87:
        return;
    L69:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L71
    L58:
        if ((r17 instanceof gk5.b) == false) goto L83;
        gk5.b r21 = r17;
        monitor-enter(this);
        this.d = r21;     // Catch: Throwable -> L64
        this.e = r4;     // Catch: Throwable -> L64
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L64
        monitor-exit(this);
    L64:
        th = move-exception;
        throw th;
    L52:
        if ((r17 instanceof gk5.b) == true) goto L55;
        r0.w("OfficeCCMH5JSBMethod", "reject request, method=" + this.b + ", reason=event_handler_unavailable");
        bx7.c.c(this, r10, 0, "Office CCM H5 JSB event handler unavailable", 8);
        return;
    L41:
        r8 = null;
        goto L42
    L38:
        r7 = null;
        goto L39
    L30:
        if (r16.isDestroyed() == true) goto L32;
        r5 = true;
        goto L33
    L25:
        r16 = null;
    L21:
        r15 = AppHost.a.a().getCurrentActivity();
        goto L23
    }
}
