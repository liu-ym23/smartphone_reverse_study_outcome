package zg0;

import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.hw0;
import com.bytedance.android.livesdk.config.m20;
import com.bytedance.android.livesdk.config.vb1;
import com.bytedance.android.livesdk.config.z50;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import ih0.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import pn0.c;
import pn0.d;
import pn0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {

    /* JADX INFO: renamed from: zg0.a$a, reason: collision with other inner class name */
    public static final class C0299a {
    }

    static {
    }

    public a() {
    }

    public static boolean c(d r4) {
        if (r4.a() == false) goto L5;
    L15:
        List<Integer> r5 = r4.f();
        if (r5 != null) goto L18;
        return false;
    L18:
        if (r5.contains(4) != true) goto L25;
        return true;
    L25:
        return false;
    L5:
        if (((Boolean) m20.a.getValue()).booleanValue() == true) goto L15;
        if (r4.g() != 21) goto L21;
        List<Integer> r6 = r4.c();
        if (r6 != null) goto L12;
        return false;
    L12:
        if (r6.contains(7) != true) goto L23;
        return true;
    L23:
        return false;
    L21:
        return false;
    }

    public final g e(d r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        int r0 = r10.g();
        int r1 = r10.b();
        Map<Integer, List<Integer>> r3 = null;
        if (r10.a() == false) goto L13;
        Object r2 = r10.j;
        if ((r2 instanceof DataCenter) == true) goto L7;
        r2 = null;
    L7:
        DataCenter r4 = (DataCenter) r2;
        IInteractService r5 = (IInteractService) k.f(IInteractService.class);
        if (r5 == null) goto L13;
        b r6 = r5.dynamicService(r4);
        if (r6 == null) goto L13;
        r3 = r6.Pl();
    L13:
        if (c(r10) == false) goto L15;
        StringBuilder r7 = r10.e().a;
        r7.append("\n");
        r7.append("content: call modifyUILayoutForRequestIfNeed, modifyUILayout from " + r10.g() + " to 999 for 语音团战特殊适配");
        r0 = 999;
    L42:
        return new g(r0, r1, r3);
    L15:
        boolean r8 = true;
        if (r10.g() != 28) goto L18;
        boolean r9 = true;
    L19:
        if (r9 == false) goto L22;
        StringBuilder r11 = r10.e().a;
        r11.append("\n");
        r11.append("content: call modifyUILayoutForRequestIfNeed, modifyUILayout from " + r10.g() + " to 1000 for 语音avatar特殊适配");
        r0 = 1000;
        goto L42
    L22:
        if (r10.g() == 2) goto L25;
        r8 = false;
    L25:
        if (r8 == false) goto L42;
        if ((r10 instanceof c) == false) goto L29;
        int r12 = ((c) r10).l;
    L30:
        switch(r12) {
            case 0: goto L38;
            case 1: goto L38;
            case 2: goto L38;
            case 3: goto L37;
            case 4: goto L36;
            case 5: goto L35;
            case 6: goto L34;
            case 7: goto L33;
            case 8: goto L32;
            default: goto L39;
        };
    L32:
        int r13 = 108;
    L40:
        StringBuilder r14 = r10.e().a;
        r14.append("\n");
        r14.append("content: call modifyUILayoutForRequestIfNeed, modifyUILayout from " + r10.g() + " to " + r13 + ", windowCount = " + r12 + ", for 动态宫格特殊适配");
        r0 = r13;
        goto L42
    L33:
        r13 = 107;
        goto L40
    L34:
        r13 = 106;
        goto L40
    L35:
        r13 = com.bytedance.android.live.liveinteract.multianchor.model.b.TYPE_CANCELED_BY_SERVER;
        goto L40
    L36:
        r13 = 104;
        goto L40
    L37:
        r13 = 103;
        goto L40
    L38:
        r13 = 102;
        goto L40
    L39:
        r13 = 5;
        goto L40
    L29:
        r12 = 9;
        goto L30
    L18:
        r9 = false;
        goto L19
    }

    public final String a(d r4, g r5) {
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r5, "modifiedRequestParams");
        List<Integer> r0 = r4.c();
        if (r0 == null) goto L7;
        int r1 = 7;
        if (r0.contains(7) != true) goto L7;
    L9:
        if ((r4 instanceof c) == false) goto L11;
        int r2 = ((c) r4).l;
    L12:
        StringBuilder r3 = new StringBuilder();
        r3.append(r5.a);
        r3.append('-');
        r3.append(r1);
        r3.append('-');
        r3.append(r2);
        r3.append('-');
        r3.append(r4.b());
        r3.append('-');
        r3.append(r4.i());
        return r3.toString();
    L11:
        r2 = 9;
    L7:
        r1 = 0;
        goto L9
    }

    public final String b(d r18, g r19) {
        Intrinsics.checkNotNullParameter(r18, "request");
        Intrinsics.checkNotNullParameter(r19, "modifiedRequestParams");
        List<Integer> r2 = r18.c();
        boolean r3 = false;
        if (r2 == null) goto L7;
        int r5 = 7;
        if (r2.contains(7) != true) goto L7;
    L9:
        if ((r18 instanceof c) == false) goto L11;
        int r4 = ((c) r18).l;
    L12:
        int r6 = r18.g();
        int r7 = r19.a;
        if (r7 == 0) goto L15;
        r6 = r7;
    L15:
        List<Integer> r8 = r18.f();
        Map<Integer, List<Integer>> r9 = r19.c;
        if (r9 != null) goto L18;
    L21:
        boolean r10 = true;
    L22:
        if (r10 == true) goto L32;
        ArrayList r11 = new ArrayList();
        Map<Integer, List<Integer>> r12 = r19.c;
        if (r12 == null) goto L26;
        List<Integer> r13 = r12.get(Integer.valueOf(r6));
    L27:
        if (r8 == null) goto L29;
        r11.addAll(r8);
    L29:
        if (r13 == null) goto L31;
        r11.addAll(r13);
    L31:
        r8 = CollectionsKt.sorted(r11);
        goto L32
    L26:
        r13 = null;
    L32:
        String r14 = "";
        if (r8 == null) goto L36;
        String r15 = CollectionsKt.joinToString$default(r8, "_", null, null, 0, null, null, 62, null);
        if (r15 == null) goto L36;
    L38:
        if (r15.length() <= 0) goto L40;
        r3 = true;
    L40:
        if (r3 == false) goto L43;
        r14 = "-".concat(r15);
    L43:
        return r19.a + '-' + r5 + '-' + r4 + '-' + r18.b() + '-' + r18.i() + r14;
    L36:
        r15 = "";
        goto L38
    L18:
        if (r9.isEmpty() == true) goto L21;
        r10 = false;
        goto L22
    L11:
        r4 = 9;
    L7:
        r5 = 0;
        goto L9
    }

    public final LayoutConfigModel d(d r24, g r25, LayoutConfigModel r26, LayoutConfigModel r27) {
        Intrinsics.checkNotNullParameter(r24, "request");
        Intrinsics.checkNotNullParameter(r25, "modifiedRequestParams");
        Intrinsics.checkNotNullParameter(r26, "layoutConfigModel");
        Map<String, LayoutConfigModel.a> r6 = r26.c();
        if (r6 == null) goto L8;
        LayoutConfigModel.a r7 = r6.get("android");
        if (r7 == null) goto L8;
        r26.E(r7.b());
    L8:
        if (r24.h() == true) goto L10;
    L18:
        boolean r8 = false;
    L20:
        if (r8 == false) goto L47;
        if (r24.a() == false) goto L42;
        if (r27 == null) goto L27;
        Map<String, LayoutConfigModel.a> r9 = r27.c();
        if (r9 == null) goto L27;
        LayoutConfigModel.a r10 = r9.get("android");
    L28:
        LayoutConfigModel.g r11 = r26.p();
        if (r11 == null) goto L45;
        if (r10 == null) goto L34;
        LayoutConfigModel.g r16 = r10.b();
        if (r16 == null) goto L34;
        int r17 = r16.b();
    L35:
        r11.f(100 + r17);
        if (r10 == null) goto L40;
        LayoutConfigModel.g r12 = r10.b();
        if (r12 == null) goto L40;
        int r13 = r12.e();
    L41:
        r11.i(140 + r13);
    L40:
        r13 = 0;
    L34:
        r17 = 0;
    L45:
        r24.e().a.append("\ncontent: call modifyLayoutConfigForResponseIfNeed for 主播侧固定浮窗适配，uiLayout = " + r24.g());
    L131:
        if (r24.i() == true) goto L150;
        int r14 = (int) s1.G(StatusBarUtil.getStatusBarHeight(s1.getContext()));
        LayoutConfigModel.g r15 = r26.p();
        Intrinsics.checkNotNull(r15);
        if (r15.e() <= 0) goto L136;
        LayoutConfigModel.g r18 = r26.p();
        Intrinsics.checkNotNull(r18);
        r18.i(r18.e() + r14);
        StringBuilder r19 = r24.e().a;
        r19.append("\n");
        StringBuilder r20 = new StringBuilder("content: call modifyLayoutConfigForResponseIfNeed, result ui_container#top = ");
        LayoutConfigModel.g r110 = r26.p();
        Intrinsics.checkNotNull(r110);
        r20.append(r110.e());
        r20.append(", statusBarHeightDp ");
        r20.append(r14);
        r20.append(", for 状态栏特殊适配");
        r19.append(r20.toString());
    L136:
        if (r26.q() != 29) goto L150;
        List<LayoutConfigModel.e> r21 = r26.i();
        if (r21 == null) goto L142;
        LayoutConfigModel.e r22 = (LayoutConfigModel.e) CollectionsKt.getOrNull(r21, 0);
        if (r22 == null) goto L142;
        r22.l(r22.f() + ((double) r14));
    L142:
        StringBuilder r23 = r24.e().a;
        r23.append("\n");
        StringBuilder r111 = new StringBuilder("content: call modifyLayoutConfigForResponseIfNeed, result region#y = ");
        List<LayoutConfigModel.e> r112 = r26.i();
        if (r112 == null) goto L147;
        LayoutConfigModel.e r113 = (LayoutConfigModel.e) ListProtector.get(r112, 0);
        if (r113 == null) goto L147;
        Double r114 = Double.valueOf(r113.f());
    L148:
        r111.append(r114);
        r111.append(", statusBarHeightDp ");
        r111.append(r14);
        r111.append(", for 电台连线场景");
        r23.append(r111.toString());
    L147:
        r114 = null;
    L150:
        if (r24.a() == true) goto L192;
        Intrinsics.checkNotNullParameter(r24, "request");
        Intrinsics.checkNotNullParameter(r25, "modifiedRequestParams");
        Object r4 = r24.j;
        if ((r4 instanceof DataCenter) == true) goto L154;
        r4 = null;
    L154:
        DataCenter r5 = (DataCenter) r4;
        IInteractService r28 = (IInteractService) k.f(IInteractService.class);
        if (r28 == null) goto L163;
        Long r29 = r24.d();
        if (r29 == null) goto L159;
        long r30 = r29.longValue();
    L160:
        b r31 = r28.dynamicService(r5, r30);
        if (r31 == null) goto L163;
        Map<String, LayoutConfigModel> r32 = r31.en();
    L164:
        if (r32 != null) goto L166;
    L169:
        boolean r115 = true;
    L170:
        if (r115 == true) goto L192;
        LinkedHashMap r33 = new LinkedHashMap();
        Iterator<Map.Entry<String, LayoutConfigModel>> r34 = r32.entrySet().iterator();
    L174:
        if (r34.hasNext() == false) goto L179;
        Map.Entry<String, LayoutConfigModel> r35 = r34.next();
        if (StringsKt.split$default(r35.getKey(), new String[]{","}, false, 0, 6, null).contains(String.valueOf(r25.a)) == false) goto L174;
        r33.put(r35.getKey(), r35.getValue());
        goto L174
    L179:
        if (((Boolean) hw0.a.getValue()).booleanValue() == true) goto L181;
    L182:
        r33 = new LinkedHashMap();
        Iterator<Map.Entry<String, LayoutConfigModel>> r0 = r32.entrySet().iterator();
    L184:
        if (r0.hasNext() == false) goto L189;
        Map.Entry<String, LayoutConfigModel> r36 = r0.next();
        if (StringsKt.split$default(r36.getKey(), new String[]{","}, false, 0, 6, null).contains(String.valueOf(r24.g())) == false) goto L184;
        r33.put(r36.getKey(), r36.getValue());
    L189:
        if (r33.isEmpty() == true) goto L192;
        if (r33.size() >= 2) goto L192;
    L193:
        String.valueOf(r33);
        if (r33 == null) goto L238;
        Map.Entry r1 = (Map.Entry) CollectionsKt.firstOrNull(r33.entrySet());
        if (r1 == null) goto L198;
        LayoutConfigModel r2 = (LayoutConfigModel) r1.getValue();
    L199:
        if (r2 != null) goto L201;
    L281:
        boolean r37 = false;
    L282:
        Object r3 = r24.j;
        if ((r3 instanceof DataCenter) == true) goto L285;
        r3 = null;
    L285:
        DataCenter r38 = (DataCenter) r3;
        Room r39 = m.i().getCurrentRoom();
        if (r39 == null) goto L288;
        LiveMode r116 = r39.getStreamType();
    L290:
        if (r116 != LiveMode.VIDEO) goto L292;
        r37 = true;
    L292:
        if (r37 == false) goto L301;
        c0 r40 = y3.m(r38);
        if (r40 == null) goto L301;
        if (r40.n(ToolbarButton.LITTLE_GAME) != true) goto L301;
        r24.g();
        if (r24.g() == 7) goto L300;
        r26.y(1);
    L300:
        r26.s(8);
    L301:
        return r26;
    L288:
        r116 = null;
        goto L290
    L201:
        if (r2.j() == (-1)) goto L204;
        r26.y(r2.j());
    L204:
        if (r2.d() == (-1)) goto L206;
        r26.s(r2.d());
    L206:
        LayoutConfigModel.g r41 = r2.p();
        if (r41 == null) goto L209;
        LayoutConfigModel.g r42 = r26.p();
        Intrinsics.checkNotNull(r42);
        r42.g(r42.c() + r41.c());
        r42.i(r42.e() + r41.e());
        r42.h(r42.d() + r41.d());
        r42.f(r42.b() + r41.b());
    L209:
        LayoutConfigModel.b r43 = r2.e();
        if (r43 == null) goto L212;
        LayoutConfigModel.b r44 = r26.e();
        Intrinsics.checkNotNull(r44);
        r44.g(r44.d() + r43.d());
        r44.f(r44.c() + r43.c());
        r44.e(r43.b());
    L212:
        LayoutConfigModel.d r45 = r2.f();
        if (r45 == null) goto L215;
        LayoutConfigModel.d r46 = r26.f();
        Intrinsics.checkNotNull(r46);
        r46.h(r46.d() + r45.d());
        r46.i(r46.e() + r45.e());
        r46.g(r46.c() + r45.c());
        r46.f(r46.b() + r45.b());
    L215:
        List<LayoutConfigModel.e> r47 = r2.i();
        if (r47 == null) goto L236;
        Iterator<LayoutConfigModel.e> r48 = r47.iterator();
    L219:
        if (r48.hasNext() == false) goto L236;
        LayoutConfigModel.e r49 = r48.next();
        List<LayoutConfigModel.e> r50 = r26.i();
        if (r50 == null) goto L233;
        Iterator<T> r51 = r50.iterator();
    L224:
        if (r51.hasNext() == false) goto L231;
        Object r52 = r51.next();
        if (r49.c() != ((LayoutConfigModel.e) r52).c()) goto L228;
        boolean r117 = true;
    L229:
        if (r117 == false) goto L224;
    L232:
        LayoutConfigModel.e r53 = (LayoutConfigModel.e) r52;
    L234:
        if (r53 == null) goto L219;
        r53.k(r53.e() + r49.e());
        r53.l(r53.f() + r49.f());
        r53.j(r53.d() + r49.d());
        r53.h(r53.b() + r49.b());
        goto L219
    L228:
        r117 = false;
        goto L229
    L231:
        r52 = null;
        goto L232
    L233:
        r53 = null;
    L236:
        StringBuilder r54 = r24.e().a;
        r54.append("\n");
        r54.append("content modifyResponseByLynxLayoutConfigOffset but lynxLayoutConfigOffset is null!");
        goto L281
    L198:
        r2 = null;
        goto L199
    L238:
        if (r24.a() == true) goto L281;
        z50 r55 = z50.a;
        if (((vb1) r55.getValue()).a() == true) goto L242;
    L279:
        r37 = false;
        int r56 = 0;
    L280:
        Intrinsics.checkNotNullParameter(r24, "request");
        Intrinsics.checkNotNullParameter(r26, "layoutConfigModel");
        LayoutConfigModel.g r57 = r26.p();
        Intrinsics.checkNotNull(r57);
        r57.i(r57.e() + r56);
        goto L282
    L242:
        if (je0.d.D() == true) goto L279;
        Room r58 = m.i().getCurrentRoom();
        if (r58 == null) goto L249;
        z5 r59 = r58.getLinkerDetail();
        if (r59 == null) goto L249;
        String r60 = r59.getClientUiInfo();
    L251:
        if (r60 != null) goto L302;
    L258:
        boolean r118 = true;
    L259:
        if (r118 == true) goto L279;
        r24.g();     // Catch: Exception -> L256
        r24.e().a.append("\ncontent: call modifyResponseByClientUiInfo for 布局跳变优化适配, modifyUILayout to " + r24.g() + ", clientUiInfo=" + r60);     // Catch: Exception -> L256
        r56 = JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(new JSONObject(r60), "ui_translation"), "vertical");     // Catch: Exception -> L256
        if (r56 != 10000) goto L304;
        r56 = 0;
    L304:
        Map r61 = ((vb1) r55.getValue()).b();     // Catch: Exception -> L275
        if (r61 == null) goto L270;
        Integer r62 = (Integer) r61.get(String.valueOf(r56));     // Catch: Exception -> L275
        if (r62 == null) goto L270;
        int r63 = r62.intValue();     // Catch: Exception -> L275
    L271:
        if (r63 == 0) goto L273;
        int r65 = r63;
    L274:
        r56 = r65;
        r37 = false;
        goto L280
    L273:
        r65 = r56;
    L270:
        r63 = r56;
    L275:
        e = e;
    L278:
        r37 = false;
        StringsKt.append(r24.e().a, new Object[]{"\ncontent: call modifyResponseByClientUiInfo for 布局跳变优化适配, modifyUILayout to " + r24.g() + ", parse ui_translation error!", e});
    L256:
        e = e;
        r56 = 0;
        goto L278
    L302:
        if (r60.length() == 0) goto L258;
        r118 = false;
    L249:
        r60 = null;
        goto L251
    L181:
        if (r33.isEmpty() == false) goto L189;
    L166:
        if (r32.isEmpty() == true) goto L169;
        r115 = false;
        goto L170
    L159:
        r30 = 0;
    L163:
        r32 = null;
    L192:
        r33 = null;
    L27:
        r10 = null;
        goto L28
    L42:
        LayoutConfigModel.g r66 = r26.p();
        if (r66 == null) goto L45;
        r66.f(100);
        r66.i(140);
        goto L45
    L47:
        if (r24.h() == true) goto L49;
    L57:
        boolean r67 = false;
    L58:
        if (r67 == false) goto L87;
        List<LayoutConfigModel.e> r68 = r26.i();
        if (r68 == null) goto L68;
        Iterator<T> r69 = r68.iterator();
    L63:
        if (r69.hasNext() == false) goto L68;
        LayoutConfigModel.e r119 = (LayoutConfigModel.e) r69.next();
        if (r119.c() <= 0) goto L63;
        r119.l(((double) 41) + r119.f());
    L68:
        if (r24.a() == false) goto L82;
        if (r27 == null) goto L73;
        Map<String, LayoutConfigModel.a> r70 = r27.c();
        if (r70 == null) goto L73;
        LayoutConfigModel.a r71 = r70.get("android");
    L74:
        LayoutConfigModel.g r72 = r26.p();
        if (r72 == null) goto L85;
        if (r71 == null) goto L80;
        LayoutConfigModel.g r73 = r71.b();
        if (r73 == null) goto L80;
        int r74 = r73.b();
    L81:
        r72.f(52 + r74);
    L80:
        r74 = 0;
    L85:
        r24.e().a.append("\ncontent: call modifyLayoutConfigForResponseIfNeed for 主播侧动态浮窗适配，uiLayout = " + r24.g());
    L73:
        r71 = null;
        goto L74
    L82:
        LayoutConfigModel.g r75 = r26.p();
        if (r75 == null) goto L85;
        r75.f(52);
        goto L85
    L87:
        if (c(r24) == false) goto L97;
        int r76 = r24.g();
        if (r24.a() == false) goto L91;
    L94:
        r24.e().a.append("\ncontent: call modifyLayoutConfigForResponseIfNeed for 语音团战跳变优化特殊适配, modifyUILayout from " + r26.q() + ", request uiLayout params: " + r24.g() + ", to 21");
        r76 = 21;
    L95:
        r26.F(r76);
        goto L131
    L91:
        if (((Boolean) m20.a.getValue()).booleanValue() == true) goto L94;
        r24.e().a.append("\ncontent: call modifyLayoutConfigForResponseIfNeed for 语音团战特殊适配, modifyUILayout from " + r26.q() + " to " + r76);
        goto L95
    L97:
        if (r24.g() != 28) goto L99;
        boolean r77 = true;
    L100:
        if (r77 == false) goto L103;
        StringBuilder r78 = r24.e().a;
        r78.append("\n");
        r78.append("content: call modifyUILayoutForRequestIfNeed, modifyUILayout from " + r24.g() + " to " + r26.q() + " for 语音avatar特殊适配");
        r26.F(r24.g());
        goto L131
    L103:
        if (r24.g() != 2) goto L105;
        boolean r79 = true;
    L106:
        if (r79 == false) goto L109;
        r24.e().a.append("\ncontent: call modifyLayoutConfigForResponseIfNeed for 动态宫格特殊适配, modifyUILayout from " + r26.q() + " to " + r24.g());
        r26.F(r24.g());
        goto L131
    L109:
        if (r24.g() != 15) goto L111;
    L114:
        boolean r80 = true;
    L115:
        if (r80 == false) goto L126;
        List<LayoutConfigModel.e> r81 = r26.i();
        Intrinsics.checkNotNull(r81);
        List<LayoutConfigModel.e> r82 = CollectionsKt.toMutableList(r81);
        if (r82.size() != 9) goto L131;
        int r120 = r24.g();
        if (r120 == 15) goto L123;
        if (r120 == 113) goto L122;
        double r121 = 0.0d;
    L124:
        LayoutConfigModel.e r83 = new LayoutConfigModel.e();
        r83.m(1);
        r83.i(9);
        r83.k(293.75d);
        r83.l(r121);
        r83.j(56.25d);
        r83.h(56.25d);
        r82.add(r83);
        r26.x(r82);
        r24.e().a.append("\ncontent: call modifyLayoutConfigForResponseIfNeed for 新弹幕玩法布局特殊适配, uiLayout = " + r24.g() + ", regionListSize = " + r82.size() + ", newRegion = " + r83);
        goto L131
    L122:
        r121 = 471.5d;
        goto L124
    L123:
        r121 = 77.75d;
        goto L124
    L126:
        if (aj0.b.c(r24.g()) == false) goto L131;
        LayoutConfigModel.g r84 = r26.p();
        if (r84 == null) goto L131;
        r84.i(r84.e() + 14);
        goto L131
    L111:
        if (r24.g() == 113) goto L114;
        r80 = false;
        goto L115
    L105:
        r79 = false;
        goto L106
    L99:
        r77 = false;
        goto L100
    L49:
        if (r24.g() != 7) goto L51;
    L56:
        r67 = true;
        goto L58
    L51:
        if (r24.g() == 110) goto L56;
        if (r24.g() == 109) goto L56;
        if (r24.g() != 111) goto L57;
    L10:
        if (r24.g() != 1) goto L12;
    L17:
        r8 = true;
        goto L20
    L12:
        if (r24.g() == 6) goto L17;
        if (r24.g() == 9) goto L17;
        if (r24.g() != 112) goto L18;
        goto L17
    }

    public final LayoutConfigModel f(d r9, g r10, LayoutConfigModel r11, LayoutConfigModel r12) {
        Intrinsics.checkNotNullParameter(r9, "request");
        Intrinsics.checkNotNullParameter(r10, "modifiedRequestParams");
        Intrinsics.checkNotNullParameter(r11, "originLayoutConfigModel");
        Intrinsics.checkNotNullParameter(r12, "offsetLayoutConfigModel");
        Map<String, LayoutConfigModel.a> r13 = r12.c();
        if (r13 == null) goto L5;
        LayoutConfigModel.a r14 = r13.get("android");
    L6:
        Map<String, LayoutConfigModel.a> r1 = r11.c();
        if (r1 == null) goto L11;
        LayoutConfigModel.a r15 = r1.get("android");
        if (r15 == null) goto L11;
        LayoutConfigModel.g r16 = r15.b();
    L12:
        if (r14 == null) goto L14;
        LayoutConfigModel.g r17 = r14.b();
    L15:
        if (r16 == null) goto L18;
        if (r17 == null) goto L18;
        r16.i(r16.e() + r17.e());
        r16.g(r16.c() + r17.c());
        r16.f(r16.b() + r17.b());
        r16.h(r16.d() + r17.d());
    L18:
        LayoutConfigModel.b r18 = r12.e();
        LayoutConfigModel.b r19 = r11.e();
        if (r19 == null) goto L29;
        int r2 = r19.d();
        if (r18 == null) goto L23;
        int r3 = r18.d();
    L24:
        r19.g(r2 + r3);
        int r4 = r19.c();
        if (r18 == null) goto L27;
        int r20 = r18.c();
    L28:
        r19.f(r4 + r20);
        goto L29
    L27:
        r20 = 0;
        goto L28
    L23:
        r3 = 0;
    L29:
        LayoutConfigModel.d r21 = r12.f();
        LayoutConfigModel.d r110 = r11.f();
        if (r110 == null) goto L47;
        double r5 = r110.d();
        double r6 = 0.0d;
        if (r21 == null) goto L34;
        double r7 = r21.d();
    L35:
        r110.h(r5 + r7);
        double r8 = r110.e();
        if (r21 == null) goto L38;
        r6 = r21.e();
    L38:
        r110.i(r8 + r6);
        int r22 = r110.c();
        if (r21 == null) goto L41;
        int r23 = r21.c();
    L42:
        r110.g(r22 + r23);
        int r24 = r110.b();
        if (r21 == null) goto L45;
        int r25 = r21.b();
    L46:
        r110.f(r24 + r25);
        goto L47
    L45:
        r25 = 0;
        goto L46
    L41:
        r23 = 0;
        goto L42
    L34:
        r7 = 0.0d;
    L47:
        List<LayoutConfigModel.e> r26 = r11.i();
        if (r26 == null) goto L68;
        Iterator<T> r27 = r26.iterator();
    L51:
        if (r27.hasNext() == false) goto L68;
        LayoutConfigModel.e r111 = (LayoutConfigModel.e) r27.next();
        List<LayoutConfigModel.e> r28 = r12.i();
        if (r28 == null) goto L65;
        Iterator<T> r29 = r28.iterator();
    L56:
        if (r29.hasNext() == false) goto L63;
        Object r30 = r29.next();
        if (((LayoutConfigModel.e) r30).c() != r111.c()) goto L60;
        boolean r31 = true;
    L61:
        if (r31 == false) goto L56;
    L64:
        LayoutConfigModel.e r32 = (LayoutConfigModel.e) r30;
    L66:
        if (r32 == null) goto L51;
        r111.k(r111.e() + r32.e());
        r111.l(r111.f() + r32.f());
        r111.j(r111.d() + r32.d());
        r111.h(r111.b() + r32.b());
        goto L51
    L60:
        r31 = false;
        goto L61
    L63:
        r30 = null;
        goto L64
    L65:
        r32 = null;
    L68:
        return r11;
    L14:
        r17 = null;
    L11:
        r16 = null;
        goto L12
    L5:
        r14 = null;
        goto L6
    }
}
