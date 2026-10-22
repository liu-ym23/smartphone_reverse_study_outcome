package com.obric.assistant.task.skill;

import android.content.Context;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.a2;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.o1;
import com.larus.bmhome.actionbar.model.p0;
import com.larus.bmhome.actionbar.model.s0;
import com.larus.bmhome.actionbar.model.t0;
import com.larus.bmhome.actionbar.model.u0;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.im.FlowRuntime;
import com.larus.im.b;
import com.larus.platform.service.x1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import com.obric.assistant.network.api.bean.ObricOmniModel;
import com.obric.assistant.network.api.bean.ObricOmniModelConfig;
import com.obric.assistant.spi.account.ObricAccountSPIServiceDelegate;
import com.obric.assistant.t1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class m {
    public static final AtomicBoolean a = null;
    public static final AtomicBoolean b = null;
    public static int c;

    public m() {
    }

    static {
        a = new AtomicBoolean(false);
        b = new AtomicBoolean(false);
    }

    public static String c() {
        StringBuilder r0 = new StringBuilder("res://");
        gd9.i r1 = b.a;
        Intrinsics.checkNotNull(r1);
        r0.append(r1.getApplication().getPackageName());
        r0.append("/2131243111");
        return y0.k(UriProtector.parse(r0.toString()));
    }

    public static String d() {
        StringBuilder r0 = new StringBuilder("res://");
        gd9.i r1 = b.a;
        Intrinsics.checkNotNull(r1);
        r0.append(r1.getApplication().getPackageName());
        r0.append("/2131244375");
        return y0.k(UriProtector.parse(r0.toString()));
    }

    public static boolean l() {
        int r0 = t1.a.getAutoGuiEnabledScene();
        if (r0 == 1) goto L7;
        if (r0 == 2) goto L7;
    L11:
        return false;
    L7:
        if (x1.a.a() == true) goto L11;
        if (ObricAccountSPIServiceDelegate.b.e().a(10000) == false) goto L11;
        return true;
    }

    public static boolean m() {
        boolean r0 = a.get();
        FLogger.a.i("ObricTaskSkillModeHelper", "isUsingMenuConfV2: " + r0);
        return r0;
    }

    public static String b(int r1) {
        return FlowRuntime.a().getApplication().getString(r1);
    }

    public static String e(ObricOmniModeTag r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ObricOmniModelConfigManager.a.getClass();
        Map r0 = ObricOmniModelConfigManager.c().getModeMap();
        if (r0 == null) goto L13;
        String r1 = (String) r0.get(r2.getValue());
        if (r1 == null) goto L13;
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L13;
        return r1;
    L13:
        return r2.getDefaultModeId();
    }

    public static String f(ObricOmniModelTag r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ObricOmniModelConfigManager.a.getClass();
        Map r0 = ObricOmniModelConfigManager.c().getModelMap();
        if (r0 == null) goto L13;
        String r1 = (String) r0.get(r2.getValue());
        if (r1 == null) goto L13;
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L13;
        return r1;
    L13:
        return r2.getDefaultModelId();
    }

    public static boolean h(z0 r3) {
        if (r3 == null) goto L12;
        p0 r4 = r3.o;
        if (r4 == null) goto L12;
        Integer r5 = r4.a;
        int r2 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r5 == null) goto L12;
        if (r5.intValue() != r2) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == true) goto L15;
        return false;
    L15:
        if (l() == false) goto L19;
        return true;
    L19:
        return false;
    L12:
        r6 = false;
        goto L13
    }

    public static boolean j(Integer r2) {
        if (r2 != null) goto L5;
    L6:
        if (r2 != null) goto L9;
    L11:
        return false;
    L9:
        if (r2.intValue() != 100001) goto L11;
    L12:
        return true;
    L5:
        if (r2.intValue() == 10000) goto L12;
        goto L6
    }

    public static boolean k(String r1) {
        if (Intrinsics.areEqual(r1, "10000") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, "100001") == true) goto L8;
        return false;
    }

    public static void g(Context r65, z0 r66) {
        Intrinsics.checkNotNullParameter(r65, "context");
        p0 r2 = r66.o;
        if (r2 == null) goto L185;
        Integer r3 = r2.a;
        int r4 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r3 != null) goto L9;
        return;
    L9:
        if (r3.intValue() == r4) goto L12;
        return;
    L12:
        if (h(r66) == true) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual(r2.k, Boolean.TRUE) == false) goto L120;
        p0 r1 = r66.o;
        if (r1 == null) goto L181;
        s0 r5 = r1.j;
        if (r5 == null) goto L183;
        u0 r6 = r5.a;
        if (r6 == null) goto L32;
        ArrayList r7 = r6.a;
        if (r7 == null) goto L32;
        ArrayList r8 = new ArrayList();
        Iterator r9 = r7.iterator();
    L27:
        if (r9.hasNext() == false) goto L31;
        Object r10 = r9.next();
        if (k(((t0) r10).a) == true) goto L27;
        r8.add(r10);
        goto L27
    L31:
        ArrayList r11 = (ArrayList) CollectionsKt.toCollection(r8, new ArrayList());
    L33:
        a2 r12 = r5.b;
        if (r12 == null) goto L36;
        ArrayList r13 = r12.a;
    L37:
        g1 r15 = new g1(null, d(), null, null, 29);
        g1 r22 = new g1(null, c(), null, null, 29);
        ObricOmniModelConfigManager.a.getClass();
        ObricOmniModelConfig r23 = ObricOmniModelConfigManager.c();
        String r14 = r65.getString(2131911923);
        String r17 = r65.getString(2131911923);
        int r0 = AgentMode.CHAT.getValue();
        vea.k r16 = r23.getDefaultModel();
        if (r16 == null) goto L40;
        String r18 = r16.a();
    L41:
        vea.k r19 = r23.getDefaultModel();
        if (r19 == null) goto L44;
        String r110 = r19.b();
    L45:
        o1 r20 = new o1(r18, r110);
        List<ObricOmniModel> r21 = a.a(r23);
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
        Iterator<T> r24 = r21.iterator();
    L47:
        if (r24.hasNext() == false) goto L58;
        ObricOmniModel r112 = (ObricOmniModel) r24.next();
        vea.k r113 = r112.getModelItemIndex();
        if (r113 == null) goto L51;
        String r114 = r113.a();
    L52:
        vea.k r115 = r112.getModelItemIndex();
        if (r115 == null) goto L55;
        String r116 = r115.b();
    L56:
        r111.add(new o1(r114, r116));
        goto L47
    L55:
        r116 = null;
        goto L56
    L51:
        r114 = null;
        goto L52
    L58:
        if (Intrinsics.areEqual(r5.d, Boolean.TRUE) == false) goto L90;
        a2 r25 = r5.b;
        if (r25 == null) goto L90;
        if (r13 != null) goto L63;
        List r117 = CollectionsKt.emptyList();
    L64:
        ArrayList r118 = new ArrayList();
        Iterator r119 = r117.iterator();
    L66:
        if (r119.hasNext() == false) goto L89;
        b2 r120 = (b2) r119.next();
        Iterator<T> r121 = a.a(r23).iterator();
    L69:
        if (r121.hasNext() == false) goto L82;
        Object r122 = r121.next();
        ObricOmniModel r123 = (ObricOmniModel) r122;
        if (Intrinsics.areEqual(r123.isSupportedModel(), Boolean.TRUE) == false) goto L79;
        vea.k r26 = r123.getModelItemIndex();
        if (r26 == null) goto L75;
        String r27 = r26.b();
    L77:
        if (Intrinsics.areEqual(r27, r120.o) == false) goto L79;
        boolean r28 = true;
    L80:
        if (r28 == false) goto L69;
    L83:
        ObricOmniModel r124 = (ObricOmniModel) r122;
        if (r124 != null) goto L86;
        b2 r29 = null;
    L87:
        if (r29 == null) goto L66;
        r118.add(r29);
        goto L66
    L86:
        r29 = b2.a(r120, r124.getDisplayModel(), r124.getDisplayModel());
        goto L87
    L75:
        r27 = null;
    L79:
        r28 = false;
        goto L80
    L82:
        r122 = null;
        goto L83
    L89:
        a2 r210 = new a2(new ArrayList(r118), r25.b);
    L91:
        t0 r30 = new t0("10000", r14, r15, r22, r15, r22, Integer.valueOf(r0), r17, r20, r111, Boolean.FALSE, r210, 51648);
        if (r11 == null) goto L94;
        a(r11, CollectionsKt.listOf(r30), new l());
    L94:
        if (r6 == null) goto L96;
        r6.a = r11;
    L96:
        ArrayList r31 = new ArrayList();
        if (r13 == null) goto L116;
        Iterator r32 = r13.iterator();
    L100:
        if (r32.hasNext() == false) goto L116;
        b2 r33 = (b2) r32.next();
        Iterator<T> r34 = a.a(r23).iterator();
    L103:
        if (r34.hasNext() == false) goto L111;
        Object r35 = r34.next();
        vea.k r36 = ((ObricOmniModel) r35).getModelItemIndex();
        if (r36 == null) goto L107;
        String r37 = r36.b();
    L109:
        if (Intrinsics.areEqual(r37, r33.o) == false) goto L103;
    L112:
        ObricOmniModel r38 = (ObricOmniModel) r35;
        if (r38 != null) goto L114;
        r31.add(r33);
        goto L100
    L114:
        r31.add(b2.a(r33, r38.getDisplayModel(), r38.getDisplayModel()));
        goto L100
    L107:
        r37 = null;
        goto L109
    L111:
        r35 = null;
    L116:
        a2 r39 = r5.b;
        if (r39 == null) goto L182;
        r39.a = r31;
        return;
    L182:
        return;
    L63:
        r117 = r13;
    L90:
        r210 = null;
        goto L91
    L44:
        r110 = null;
        goto L45
    L40:
        r18 = null;
        goto L41
    L36:
        r13 = null;
    L32:
        r11 = null;
        goto L33
    L183:
        return;
    L181:
        return;
    L120:
        p0 r40 = r66.o;
        if (r40 == null) goto L184;
        a2 r41 = r40.d();
        if (r41 == null) goto L186;
        ArrayList r42 = r41.a;
        if (r42 == null) goto L187;
        ArrayList r43 = new ArrayList();
        Iterator r44 = r42.iterator();
    L130:
        if (r44.hasNext() == false) goto L138;
        Object r45 = r44.next();
        ModelItemIdentity r46 = ((b2) r45).b();
        if (r46 == null) goto L134;
        Integer r47 = Integer.valueOf(r46.getDeprecatedItemId());
    L136:
        if (j(r47) == true) goto L130;
        r43.add(r45);
        goto L130
    L134:
        r47 = null;
        goto L136
    L138:
        ArrayList r48 = (ArrayList) CollectionsKt.toCollection(r43, new ArrayList());
        b2 r49 = (b2) CollectionsKt.firstOrNull(r48);
        if (r49 == null) goto L141;
        String r50 = r49.g;
    L143:
        if (o0.d(r50) == false) goto L145;
        String r51 = r65.getString(2131911922);
    L146:
        g1 r52 = new g1(null, d(), null, null, 29);
        g1 r125 = new g1(null, c(), null, null, 29);
        a(r48, CollectionsKt.listOf(new b2[]{new b2(10000, r65.getString(2131911923), r52, r125, null, null, r51, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097072), new b2(100001, r65.getString(2131911928), r52, r125, null, null, r51, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097072)}), new i());
        r41.a = r48;
        return;
    L145:
        r51 = null;
        goto L146
    L141:
        r50 = null;
        goto L143
    L187:
        return;
    L186:
        return;
    L184:
        return;
    }

    public static boolean i(String r1, String r2) {
        if (Intrinsics.areEqual(r1, e(ObricOmniModeTag.QUICK)) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r2, f(ObricOmniModelTag.QUICK)) == true) goto L8;
        return false;
    }

    public static void a(List r3, List r4, Function1 r5) {
        Iterator r0 = r3.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((Boolean) r5.invoke(r0.next())).booleanValue() == true) goto L10;
        r1 = r1 + 1;
    L10:
        if (r1 < 0) goto L12;
        int r2 = r1 + 1;
    L13:
        r3.addAll(r2, r4);
        return;
    L12:
        r2 = r3.size();
        goto L13
    L9:
        r1 = -1;
        goto L10
    }
}
