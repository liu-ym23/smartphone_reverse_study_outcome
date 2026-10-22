package androidx.room;

import android.text.TextUtils;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import com.bytedance.ai.bridge.protocol.WorkerModule;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.lynx.map.ng.LynxMapView;
import com.bytedance.pia.core.api.bridge.PiaMethod$Error;
import com.bytedance.pia.core.api.bridge.PiaMethod$InvalidParamsError;
import com.bytedance.pia.core.bridge.methods.l0;
import com.bytedance.pia.core.bridge.methods.n0;
import com.bytedance.pia.core.metrics.PvEventType;
import com.bytedance.pia.core.utils.j;
import com.bytedance.pia.core.utils.m;
import com.bytedance.salamander.anniex.b0;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.obric.flow.cardlistpage.data.MiniAppWidgetCardModel;
import com.obric.flow.cardlistpage.ui.component.feedlist.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import ko.r;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import l9.l;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f587c;
    public final /* synthetic */ Object d;

    public /* synthetic */ f(gh.c r5, Object r10, String r11) {
        this.f585a = 5;
        this.f586b = r5;
        this.d = r10;
        this.f587c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f585a) {
            case 0: goto L121;
            case 1: goto L119;
            case 2: goto L104;
            case 3: goto L76;
            case 4: goto L66;
            case 5: goto L46;
            case 6: goto L31;
            case 7: goto L14;
            case 8: goto L12;
            case 9: goto L10;
            case 10: goto L8;
            case 11: goto L6;
            default: goto L4;
        };
    L4:
        LynxMapView.j((LynxMapView) this.f586b, (ReadableMap) this.f587c, (ReadableArray) this.d);
        return;
    L6:
        LynxMapView.c((LynxMapView) this.f586b, (ReadableMap) this.f587c, (Callback) this.d);
        return;
    L8:
        ProtocolMessage.Type r10 = ProtocolMessage.Type.Event;
        m1.i r5 = (m1.i) this.f586b;
        int r11 = r5.f19972a - 1;
        r5.f19972a = r11;
        Integer r12 = Integer.valueOf(r11);
        String r13 = (String) this.f587c;
        ProtocolMessage r14 = new ProtocolMessage(r13, (JsonObject) this.d, r12, null, r10, 40);
        r5.e.c(new j2.a(r14, new m1.h(r5.a(r14), r5, r13)));
        return;
    L10:
        ((kh.c) this.f586b).e.put(((PvEventType) this.f587c).f7040a, (Integer) this.d);
        return;
    L12:
        WorkerModule.a((Long) this.f586b, (WorkerModule) this.f587c, (JavaOnlyMap) this.d);
        return;
    L14:
        l0 r15 = (l0) this.d;
        l r16 = (l) this.f586b;
        r16.getClass();
        String r17 = (String) this.f587c;
        boolean r18 = "__port_init__".equals(r17);
        com.bytedance.pia.core.utils.a r19 = (com.bytedance.pia.core.utils.a) r16.d;
        if (r18 == false) goto L18;
        r19.b(new n0(2, r16, Boolean.FALSE));
        return;
    L18:
        if ("__port_init_next__".equals(r17) == false) goto L128;
        r19.b(new n0(2, r16, Boolean.TRUE));
        return;
    L128:
        JsonParser r20 = com.bytedance.pia.core.utils.i.f7152b;     // Catch: Throwable -> L25
        JsonObject r110 = (JsonObject) r20.parse(r17);     // Catch: Throwable -> L25
        if (r110.has("data") == true) goto L23;
    L27:
        r15.accept(r110);     // Catch: Throwable -> L25
        return;
    L23:
        if (r110.get("data").isJsonObject() == true) goto L27;
        r110.add("data", r20.parse(r110.get("data").getAsJsonPrimitive().getAsString()));     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Intrinsics.checkNotNullParameter("[Bridge] onMessage error:", "message");
        j.x("[Bridge] onMessage error:", th);
        return;
    L31:
        l r21 = (l) this.f586b;
        r21.getClass();
        boolean r22 = ((Boolean) this.f587c).booleanValue();
        JsonObject r111 = (JsonObject) this.d;
        if (r22 == false) goto L123;
    L41:
        String r112 = r111.toString();
        j.A(r112);
        WebMessagePort r23 = (WebMessagePort) r21.f19575c;
        if (r23 == null) goto L44;
        r23.postMessage(new WebMessage(r112));
        return;
    L44:
        m.a(new a2.b(26, r21, r112));
        return;
    L123:
    L39:
        th = move-exception;
        Intrinsics.checkNotNullParameter("[Bridge] handle local message error:", "message");
        j.x("[Bridge] handle local message error:", th);
        goto L41
    L34:
        if (r111.has("data") == false) goto L41;
        if (r111.get("data").isJsonObject() == false) goto L41;
        r111.addProperty("data", r111.get("data").getAsJsonObject().toString());     // Catch: Throwable -> L39
        goto L41
    L46:
        gh.c r24 = (gh.c) this.f586b;
        r24.getClass();
        Object r25 = this.d;
        String r113 = (String) this.f587c;
        if (r25 != null) goto L127;
        JsonObject r26 = null;
    L59:
        JsonObject r27 = com.bytedance.pia.core.bridge.protocol.ProtocolMessage.a(new b0(0, r113, r26));     // Catch: Throwable -> L52
        if (r27 != null) goto L62;
        r24.a(-3, r113, "create protocol message failed.", null);     // Catch: Throwable -> L52
        new PiaMethod$InvalidParamsError();     // Catch: Throwable -> L52
        return;
    L62:
        r24.e.c(r27);     // Catch: Throwable -> L52
        return;
    L127:
    L52:
        th = move-exception;
        new PiaMethod$InvalidParamsError(th.toString());
        return;
    L49:
        if ((r25 instanceof JsonObject) == false) goto L125;
        r26 = (JsonObject) r25;     // Catch: Throwable -> L52
        goto L59
    L125:
        r26 = (JsonObject) com.bytedance.pia.core.utils.i.a().toJsonTree(r25);     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        r24.a(-3, r113, "parse data failed.", th);     // Catch: Throwable -> L52
        new PiaMethod$InvalidParamsError();     // Catch: Throwable -> L52
        return;
    L66:
        final dn.f r28 = (dn.f) this.f586b;
        wn.d r29 = r28.T;
        r r30 = (r) this.f587c;
        final boolean r31 = true;
        if (r30 == null) goto L69;
        r28.e = r29.d(r30);
        final boolean r32 = true;
    L70:
        r r114 = (r) this.d;
        if (r114 == null) goto L73;
        r28.d = r29.d(r114);
    L74:
        com.lynx.tasm.utils.j.a().post(new dn.d(r28, r31, r32));
        return;
    L73:
        r31 = false;
        goto L74
    L69:
        r32 = false;
        goto L70
    L76:
        s r33 = (s) this.f586b;
        Intrinsics.checkNotNullParameter(r33, "this$0");
        String r34 = (String) this.f587c;
        Intrinsics.checkNotNullParameter(r34, "$instanceId");
        String r115 = (String) this.d;
        Intrinsics.checkNotNullParameter(r115, "$reason");
        Iterator r35 = r33.f11602j.f7569a.iterator();
        int r36 = 0;
    L78:
        if (r35.hasNext() == false) goto L90;
        Object r37 = r35.next();
        if ((r37 instanceof MiniAppWidgetCardModel) == false) goto L82;
        MiniAppWidgetCardModel r38 = (MiniAppWidgetCardModel) r37;
    L83:
        if (r38 == null) goto L85;
        String r39 = r38.getInstanceId();
    L87:
        if (Intrinsics.areEqual(r39, r34) == true) goto L91;
        r36 = r36 + 1;
    L91:
        obric.flow.miniappwidget.l r116 = r33.f11600h;
        if (r36 != (-1)) goto L98;
        String r117 = androidx.room.jarjarred.org.antlr.runtime.a.w(androidx.constraintlayout.motion.widget.a.y("miniAppWidget rebind skipped: card missing hostId=", r116.f20491a, " instanceId=", r34, " reason="), r115, "FeedListComponent", "tag", "msg");
        org.koin.core.a r40 = su.a.f22013b;
        if (r40 == null) goto L97;
        ((ju.b) r40.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).w("FeedListComponent", r117);
        return;
    L97:
        throw new IllegalStateException("KoinApplication has not been started");
    L98:
        String r41 = r116.f20491a;
        StringBuilder r118 = new StringBuilder("miniAppWidget rebind hostId=");
        r118.append(r41);
        r118.append(" position=");
        r118.append(r36);
        r118.append(" instanceId=");
        String r119 = androidx.constraintlayout.motion.widget.a.t(r118, r34, " reason=", r115);
        Intrinsics.checkNotNullParameter("FeedListComponent", "tag");
        Intrinsics.checkNotNullParameter(r119, "msg");
        org.koin.core.a r42 = su.a.f22013b;
        if (r42 == null) goto L103;
        ((ju.b) r42.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("FeedListComponent", r119);
        r33.f11602j.notifyItemChanged(r36);
        r33.y();
        return;
    L103:
        throw new IllegalStateException("KoinApplication has not been started");
    L85:
        r39 = null;
        goto L87
    L82:
        r38 = null;
        goto L83
    L90:
        r36 = -1;
        goto L91
    L104:
        nh.a r43 = (nh.a) ((WeakReference) this.f586b).get();
        if (r43 == null) goto L142;
        String r44 = (String) this.f587c;
        Object r45 = r43.a(r44);
        if ((r45 instanceof rh.i) == false) goto L140;
        rh.i r46 = (rh.i) r45;
        if (r46.e() == false) goto L141;
        ((n0) this.d).accept(new PiaMethod$Error(-10006));
        r46.b(null);
        if (r43.f20231b.get() == false) goto L115;
        return;
    L115:
        if (TextUtils.isEmpty(r44) == true) goto L144;
        r43.f20232c.remove(r44);
        return;
    L144:
        return;
    L141:
        return;
    L140:
        return;
    L142:
        return;
    L119:
        QueryInterceptorDatabase.b((QueryInterceptorDatabase) this.f586b, (String) this.f587c, (ArrayList) this.d);
        return;
    L121:
        QueryInterceptorDatabase.n((QueryInterceptorDatabase) this.f586b, (String) this.f587c, (Object[]) this.d);
    }

    public /* synthetic */ f(Object r5, int r10, Object r11, Object r12) {
        this.f585a = r10;
        this.f586b = r5;
        this.f587c = r11;
        this.d = r12;
    }
}
