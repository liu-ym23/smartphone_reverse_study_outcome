package ib;

import android.app.Application;
import android.net.Uri;
import com.bytedance.android.anniex.ability.service.IAnnieXBizPropsProvider;
import com.bytedance.android.anniex.ability.service.IAnnieXContextProvider;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.lite.utils.AnnieXSettings;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.optimize.JSBPreHandleManager;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.h;
import com.bytedance.ies.bullet.prefetchv2.a0;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import t36.j;
import y36.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final String a;
    public final Map<String, Object> b;
    public Map<String, Object> c;

    public static final class a {
    }

    static {
    }

    public d(String r10) {
        Application r0 = h.h.b;
        LinkedHashMap r1 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r1, "globalProps");
        this.a = r10;
        this.b = r1;
    }

    public static AnnieXWebModel b(d r10, String r11, Map r12) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter("AnnieXCard", "enterFrom");
        Uri r13 = UriProtector.parse(r11);
        String r1 = UUID.randomUUID().toString();
        Map<String, i36.d> r14 = MonitorManager.a;
        String r15 = r10.a;
        Intrinsics.checkNotNullParameter(r15, "bid");
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        MonitorManager.P(r15, r1, "AnnieXCard");
        MonitorManager.e0(r1, r13);
        return r10.a(r1, r13, null, r12, true, true, "AnnieXCard");
    }

    public final AnnieXWebModel a(String r20, Uri r21, j r22, Map r23, boolean r24, boolean r25, String r26) {
        Intrinsics.checkNotNullParameter(r20, "sessionId");
        Intrinsics.checkNotNullParameter(r21, "uri");
        Intrinsics.checkNotNullParameter(r26, "enterFrom");
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        r11.element = r21;
        if (r22 != null) goto L6;
        Lazy r1 = SchemaService.f;
        SchemaService r10 = SchemaService.a.a();
        Uri r12 = (Uri) r11.element;
        com.bytedance.ies.bullet.service.sdk.c r13 = new com.bytedance.ies.bullet.service.sdk.c();
        r13.a(new b(this.a));
        r13.a(new ib.a(this.a));
        Unit r14 = Unit.INSTANCE;
        r10.a(r12, r13);
    L6:
        if (r22 != null) goto L8;
        Lazy r15 = SchemaService.f;
        j r16 = new j(SchemaService.a.a().c(this.a, (Uri) r11.element, true));
    L9:
        String r17 = (String) r16.a.c().get(com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r17 == null) goto L12;
        Uri r18 = UriProtector.parse(r17);
    L13:
        if (r18 != null) goto L15;
        r18 = (Uri) r11.element;
    L15:
        r11.element = r18;
        Lazy r19 = SchemaService.f;
        SchemaService r27 = SchemaService.a.a();
        t36.d r28 = r16.a;
        r27.getClass();
        r16.b = SchemaService.d(r28, v36.a.class);
        SchemaService r29 = SchemaService.a.a();
        t36.d r30 = r16.a;
        r29.getClass();
        r16.c = SchemaService.d(r30, v36.a.class);
        SchemaService r31 = SchemaService.a.a();
        t36.d r32 = r16.a;
        r31.getClass();
        v36.e r33 = SchemaService.d(r32, v36.e.class);
        r16.d = r33;
        Intrinsics.checkNotNull(r33, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.schema.model.BDXWebKitModel");
        i r34 = r33.r;
        if (r34 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("appendCommonParams");
        r34 = null;
    L20:
        if (Intrinsics.areEqual(r34.b, Boolean.TRUE) == false) goto L32;
        StringBuilder r35 = new StringBuilder(((Uri) r11.element).toString());
        String r36 = this.a;
        Lazy r37 = AnnieXSettings.a;
        if (AnnieXSettings.a() == false) goto L24;
        AnnieXServiceCenter.a.getClass();
        IAnnieXContextProvider r38 = (IAnnieXContextProvider) AnnieXServiceCenter.d(r36, IAnnieXContextProvider.class);
    L28:
        if (r38 == null) goto L30;
        Uri r39 = (Uri) r11.element;
        r38.B();
    L30:
        r11.element = UriProtector.parse(r35.toString());
        goto L32
    L24:
        com.bytedance.android.anniex.assemble.a r40 = com.bytedance.android.anniex.assemble.a.a;
        IAnnieXContextProvider r41 = (IAnnieXContextProvider) com.bytedance.android.anniex.assemble.a.g(r36, IAnnieXContextProvider.class);
        if (r41 != null) goto L27;
        s26.d r42 = s26.d.c;
        r38 = (IAnnieXContextProvider) s26.d.c.d(r36, IAnnieXContextProvider.class);
        goto L28
    L27:
        r38 = r41;
    L32:
        if (r25 == false) goto L36;
        Uri r43 = (Uri) r11.element;
        List<String> r44 = com.bytedance.android.anniex.utils.c.a;
        Intrinsics.checkNotNullParameter(r43, "<this>");
        if (StringsKt.equals$default(a36.b.e(r43, "enable_prefetch"), "1", false, 2, null) == false) goto L36;
        a0 r45 = a0.a;
        a0.e((Uri) r11.element, this.a, 2);
    L36:
        String r110 = e.b((Uri) r11.element);
        String r46 = ((Uri) r11.element).toString();
        int r47 = com.bytedance.ies.bullet.forest.j.a;
        com.bytedance.ies.bullet.forest.j.b(r16, (Uri) r11.element, r20, this.a, PreloadType.WEB, null, false);
        Uri r48 = (Uri) r11.element;
        boolean r49 = e.c(r16);
        if (this.c != null) goto L45;
        ConcurrentHashMap<String, Object> r50 = com.bytedance.android.anniex.ability.f.a;
        Map<String, Object> r51 = com.bytedance.android.anniex.ability.f.k(KitType.WEB, this.a);
        if (com.bytedance.ies.bullet.service.base.h.G() == true) goto L44;
        Iterator<Map.Entry<String, Object>> r52 = this.b.entrySet().iterator();
    L42:
        if (r52.hasNext() == false) goto L44;
        Map.Entry<String, Object> r53 = r52.next();
        r51.put(r53.getKey(), r53.getValue());
    L44:
        this.c = r51;
    L45:
        LinkedHashMap r54 = new LinkedHashMap();
        Map<String, Object> r55 = this.c;
        if (r55 == null) goto L53;
        Intrinsics.checkNotNull(r55);
        r54.putAll(r55);
        if (com.bytedance.ies.bullet.service.base.h.G() == false) goto L50;
        r54.putAll(this.b);
    L50:
        r54.put("containerID", r20);
        r54.put("monitorSessionID", r20);
        if (r23 == null) goto L53;
        r54.putAll(r23);
    L53:
        if (r49 == true) goto L55;
    L59:
        com.bytedance.android.anniex.assemble.a r56 = com.bytedance.android.anniex.assemble.a.a;
        IAnnieXBizPropsProvider r57 = (IAnnieXBizPropsProvider) com.bytedance.android.anniex.assemble.a.g(this.a, IAnnieXBizPropsProvider.class);
        if (r57 == null) goto L64;
        Map<String, Object> r58 = r57.b(KitType.WEB, this.a, r48);
        if (r58 == null) goto L64;
        r54.putAll(r58);
    L64:
        Map r59 = com.bytedance.ies.bullet.web.pia.c.a;
        if (com.bytedance.ies.bullet.web.pia.c.d(r46, this.a, r20) == false) goto L67;
        com.bytedance.ies.bullet.web.pia.c.h(r46, this.a, r20, r16);
        com.bytedance.ies.bullet.web.pia.c.f(this.a, r54);
        boolean r60 = true;
    L68:
        Lazy r61 = JSBPreHandleManager.a;
        String r62 = this.a;
        PlatformType r63 = PlatformType.WEB;
        Intrinsics.checkNotNullParameter(r20, "sessionId");
        Intrinsics.checkNotNullParameter(r62, "bid");
        Intrinsics.checkNotNullParameter(r46, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r63, "platformType");
        String r64 = this.a;
        if (r110 != null) goto L71;
        String r65 = r46;
    L72:
        Uri r66 = (Uri) r11.element;
        LinkedHashMap r67 = new LinkedHashMap();
        if (r23 == null) goto L75;
        r67.putAll(r23);
    L75:
        AnnieXWebModel r111 = new AnnieXWebModel(r64, r65, r66, r20, r60, r67, r54, r16, r26, r24);
        s26.d r68 = s26.d.c;
        b36.d r69 = s26.d.c.d(this.a, b36.d.class);
        if (r69 != null) goto L78;
    L80:
        BulletContext r70 = r111.l;
        r70.getClass();
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r70.g = r16;
        r111.l.e = r16.a;
        Map<String, i36.d> r71 = MonitorManager.a;
        MonitorManager.Q(r20);
        return r111;
    L78:
        if (r69.i0() == true) goto L80;
        r69.u(r111);
        goto L80
    L71:
        r65 = r110;
        goto L72
    L67:
        r60 = false;
        goto L68
    L55:
        if (com.bytedance.ies.bullet.service.base.h.q() == false) goto L59;
        com.bytedance.android.anniex.assemble.a r72 = com.bytedance.android.anniex.assemble.a.a;
        IAnnieXBizPropsProvider r73 = (IAnnieXBizPropsProvider) com.bytedance.android.anniex.assemble.a.g(this.a, IAnnieXBizPropsProvider.class);
        if (r73 == null) goto L64;
        r73.a(r54, KitType.WEB, this.a, r48);
        goto L64
    L12:
        r18 = null;
        goto L13
    L8:
        r16 = r22;
        goto L9
    }
}
