package hp1;

import com.bytedance.android.live.base.model.morepanel.AreaPattern;
import com.bytedance.android.live.base.model.morepanel.ColumnElement;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.k;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.utils.MorePanelBubbleAlog;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.MorePanelDynamicControllerViewModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.ab.MoreMixSharePanelUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import ip1.e;
import ip1.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp1.d;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements d<e> {
    public List<ColumnElement> a;
    public final List<Integer> b;
    public final DataCenter c;

    public final List<ColumnElement> d() {
        List<ColumnElement> r0 = this.a;
        if (r0 != null) goto L39;
        MorePanelDynamicControllerViewModel.Companion r1 = MorePanelDynamicControllerViewModel.Companion;
        DataCenter r2 = this.c;
        r1.getClass();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.d r3 = MorePanelDynamicControllerViewModel.Companion.a(r2);
        ArrayList r4 = null;
        if (r3 == null) goto L38;
        AreaPattern r5 = (AreaPattern) r3.getServerPanelPattern();
        if (r5 == null) goto L38;
        List r6 = r5.getColumnElements();
        if (r6 == null) goto L38;
        boolean r7 = true;
        if ((!r6.isEmpty()) == true) goto L14;
        r6 = null;
    L14:
        if (r6 == null) goto L38;
        List r8 = CollectionsKt.toMutableList(r6);
        if (r8 == null) goto L38;
        MoreMixSharePanelUtils r9 = MoreMixSharePanelUtils.INSTANCE;
        boolean r10 = z.e(this.c, false);
        DataCenter r11 = this.c;
        if (r11 == null) goto L22;
        r7 = z.m(r11, true);
    L22:
        if (r9.isMoreMixShareMode(r10, r7) == true) goto L24;
        ColumnElement r12 = new ColumnElement();
        r12.setType(Integer.valueOf(ElementType.Toolbar.getId()));
        Unit r13 = Unit.INSTANCE;
        ListProtector.add(r8, 0, r12);
    L24:
        ArrayList r14 = new ArrayList();
        Iterator r15 = r8.iterator();
    L26:
        if (r15.hasNext() == false) goto L31;
        Object r16 = r15.next();
        if (CollectionsKt.contains(this.b, ((ColumnElement) r16).getType()) == false) goto L26;
        r14.add(r16);
        goto L26
    L31:
        if (TypeIntrinsics.isMutableList(r14) == false) goto L34;
        r4 = r14;
    L34:
        if (r4 != null) goto L36;
        r0 = CollectionsKt.toMutableList(r14);
    L37:
        this.a = r0;
        goto L39
    L36:
        r0 = r4;
    L38:
        return null;
    L39:
        return r0;
    }

    @Override // jp1.d
    public final List<Integer> c() {
        List<ColumnElement> r0 = d();
        if (r0 == null) goto L12;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L16;
        List r3 = ((ColumnElement) r2.next()).getWidgetIds();
        if (r3 != null) goto L10;
        r3 = CollectionsKt.emptyList();
    L10:
        CollectionsKt.addAll(r1, r3);
        goto L6
    L16:
        return r1;
    L12:
        return CollectionsKt.emptyList();
    }

    public a(DataCenter r5) {
        this.c = r5;
        ElementType[] r6 = ElementType.values();
        ArrayList r0 = new ArrayList(r6.length);
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(Integer.valueOf(r6[r2].getId()));
        r2 = r2 + 1;
        goto L3
    L5:
        this.b = r0;
    }

    @Override // jp1.d
    public final /* bridge */ /* synthetic */ e a(List r1) {
        return e(r1);
    }

    @Override // jp1.d
    public final List<com.bytedance.android.livesdk.chatroom.e> b(List<? extends com.bytedance.android.livesdk.chatroom.e> r3) {
        Intrinsics.checkNotNullParameter(r3, "originButtons");
        e r4 = e(r3);
        if (r4 == null) goto L17;
        ArrayList<lp1.b<Object>> r5 = r4.a;
        if (r5 == null) goto L17;
        ArrayList r0 = new ArrayList();
        Iterator<lp1.b<Object>> r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        CollectionsKt.addAll(r0, r6.next().getChildren());
        goto L8
    L10:
        List r7 = CollectionsKt.filterIsInstance(r0, lp1.a.class);
        if (r7 == null) goto L17;
        List r8 = r7;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r9 = r8.iterator();
    L14:
        if (r9.hasNext() == false) goto L20;
        r1.add(((lp1.a) r9.next()).getButton());
        goto L14
    L20:
        return r1;
    L17:
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final e e(List<? extends com.bytedance.android.livesdk.chatroom.e> r20) {
        a r0 = this;
        Intrinsics.checkNotNullParameter(r20, "originButtons");
        if (r20 == null) goto L173;
        List r1 = CollectionsKt.toMutableList(r20);
        if (r1 == null) goto L173;
        List<ColumnElement> r3 = d();
        if (r3 != null) goto L10;
        return null;
    L10:
        e r4 = new e();
        Iterator r5 = r3.iterator();
        a r8 = r0;
        int r6 = 0;
        boolean r7 = false;
    L12:
        if (r5.hasNext() == false) goto L129;
        Object r9 = r5.next();
        int r11 = r6 + 1;
        if (r6 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        ColumnElement r10 = (ColumnElement) r9;
        Integer r12 = r10.getType();
        if (r12 == null) goto L27;
        int r13 = r12.intValue();
        ElementType[] r14 = ElementType.values();
        int r15 = r14.length;
        int r16 = 0;
    L19:
        if (r16 >= r15) goto L27;
        ElementType r17 = r14[r16];
        if (r17.getId() != r13) goto L23;
        boolean r2 = true;
    L24:
        if (r2 == true) goto L25;
        r16 = r16 + 1;
        goto L19
    L25:
        ElementType r18 = r17;
    L28:
        if (r18 != null) goto L30;
        List r19 = r1;
        Iterator r110 = r5;
    L128:
        r6 = r11;
        r1 = r19;
        r5 = r110;
        goto L12
    L30:
        List r111 = r1;
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r113 = r111.iterator();
    L32:
        if (r113.hasNext() == false) goto L34;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r21 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r113.next();
        r112.add(TuplesKt.to(Integer.valueOf(r21.g), r21));
        goto L32
    L34:
        Map r22 = MapsKt.toMap(r112);
        if (r18 != ElementType.Toolbar) goto L46;
        ?? r23 = new ArrayList();
        Iterator r24 = r111.iterator();
    L38:
        if (r24.hasNext() == false) goto L79;
        Object r114 = r24.next();
        if (((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r114).i != 1) goto L42;
        boolean r115 = true;
    L43:
        if (r115 == false) goto L38;
        r23.add(r114);
        goto L38
    L42:
        r115 = false;
    L79:
        if (r23 == 0) goto L123;
        boolean r25 = !((Collection) r23).isEmpty();
        ?? r26 = r23;
        if (r25 == true) goto L84;
        r26 = 0;
    L84:
        if (r26 == 0) goto L123;
        r1.removeAll((Collection) r26);
        Iterable r27 = (Iterable) r26;
        ArrayList r28 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));
        Iterator r29 = r27.iterator();
    L87:
        if (r29.hasNext() == false) goto L119;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r116 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r29.next();
        ip1.c r117 = new ip1.c(r18, r116);
        MorePanelDynamicControllerViewModel.Companion r118 = MorePanelDynamicControllerViewModel.Companion;
        DataCenter r30 = r8.c;
        r118.getClass();
        k r31 = MorePanelDynamicControllerViewModel.Companion.a(r30);
        if (r31 == null) goto L117;
        BubbleEnv r32 = r31.getBubbleEnv();
        if (r32 == null) goto L117;
        g r33 = r32.a();
        if (r33 == null) goto L117;
        g.b r34 = r33.c();
        if (r34 == null) goto L117;
        if (Math.abs(System.currentTimeMillis() - r34.c()) > 15000) goto L99;
        boolean r119 = true;
    L100:
        List r120 = r1;
        Iterator r121 = r5;
        if (r34.a() != r116.g) goto L107;
        if (r119 == false) goto L107;
        if (r34.f() == true) goto L107;
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r35 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r35.d("AudiencePanelDataProcessor");
        r35.c("展示引导的按钮为：" + r116.f);
        MorePanelBubbleAlog.a(r35.b());
        r117.a = true;
        r117.b = false;
        r117.c = r34;
    L118:
        r28.add(r117);
        r8 = this;
        r1 = r120;
        r5 = r121;
    L107:
        if (r34.a() != r116.g) goto L118;
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r36 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r36.d("AudiencePanelDataProcessor");
        r36.c("无法展示引导按钮：" + r116.f);
        Pair[] r37 = {TuplesKt.to("inDuration", Boolean.valueOf(r119)), TuplesKt.to("hasShownAssociateEffect", Boolean.valueOf(r34.f()))};
        int r38 = 0;
    L109:
        if (r38 >= 2) goto L116;
        Pair r122 = r37[r38];
        if (r122 == null) goto L115;
        Object r123 = r122.getSecond();
        if (r123 == null) goto L115;
        r36.a((String) r122.getFirst(), r123);
    L115:
        r38 = r38 + 1;
        goto L109
    L116:
        MorePanelBubbleAlog.a(r36.b());
        goto L118
    L99:
        r119 = false;
    L117:
        r120 = r1;
        r121 = r5;
        goto L118
    L119:
        r19 = r1;
        r110 = r5;
        ArrayList<lp1.b<Object>> r39 = r4.a;
        ip1.d r40 = new ip1.d(r18, r6);
        r40.a.addAll(r28);
        if (r40.a.size() <= 5) goto L122;
        r7 = true;
    L122:
        Unit r41 = Unit.INSTANCE;
        r39.add(r40);
    L124:
        r0 = this;
        DataCenter r42 = r0.c;
        if (r42 == null) goto L127;
        r42.put("data_is_morepanel_average_width", Boolean.valueOf(!r7));
    L127:
        r8 = r0;
    L123:
        r19 = r1;
        r110 = r5;
        goto L124
    L46:
        if (r18 == ElementType.ShareIM) goto L56;
        ?? r124 = new ArrayList();
        Iterator r125 = r111.iterator();
    L49:
        if (r125.hasNext() == false) goto L57;
        Object r126 = r125.next();
        if (((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r126).i != 1) goto L53;
        boolean r127 = true;
    L54:
        if (r127 == false) goto L49;
        r124.add(r126);
        goto L49
    L53:
        r127 = false;
    L57:
        List r43 = r10.getWidgetIds();
        if (r43 == null) goto L72;
        ArrayList r128 = new ArrayList();
        Iterator r44 = r43.iterator();
    L61:
        if (r44.hasNext() == false) goto L66;
        Object r129 = r44.next();
        if (r22.keySet().contains(Integer.valueOf(((Number) r129).intValue())) == false) goto L61;
        r128.add(r129);
        goto L61
    L66:
        ArrayList r45 = new ArrayList();
        Iterator r130 = r128.iterator();
    L68:
        if (r130.hasNext() == false) goto L73;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r131 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r22.get(Integer.valueOf(((Number) r130.next()).intValue()));
        if (r131 == null) goto L68;
        r45.add(r131);
    L73:
        if (r124 != 0) goto L75;
        r124 = CollectionsKt.emptyList();
    L75:
        Collection r132 = (Collection) r124;
        List r46 = r45;
        if (r45 != null) goto L78;
        r46 = CollectionsKt.emptyList();
    L78:
        r23 = CollectionsKt.plus(r132, r46);
        goto L79
    L72:
        r45 = null;
        goto L73
    L56:
        r124 = 0;
        goto L57
    L23:
        r2 = false;
    L27:
        r18 = null;
        goto L28
    L129:
        ArrayList r47 = new ArrayList();
        ArrayList<lp1.b<Object>> r48 = r4.a;
        if ((!r48.isEmpty()) == true) goto L133;
        r48 = null;
    L133:
        if (r48 == null) goto L170;
        Iterator r49 = r48.iterator();
        int r50 = 0;
        ElementType r51 = null;
    L136:
        if (r49.hasNext() == false) goto L146;
        Object r52 = r49.next();
        int r53 = r50 + 1;
        if (r50 >= 0) goto L140;
        CollectionsKt.throwIndexOverflow();
    L140:
        lp1.b r54 = (lp1.b) r52;
        if (r54.getElementType() == r51) goto L144;
        if (r51 == null) goto L144;
        r47.add(TuplesKt.to(Integer.valueOf(r50), f.c));
    L144:
        r51 = r54.getElementType();
        r50 = r53;
        goto L136
    L146:
        if ((!r47.isEmpty()) == true) goto L149;
        r47 = null;
    L149:
        if (r47 == null) goto L156;
        List r55 = CollectionsKt.reversed(r47);
        if (r55 == null) goto L156;
        Iterator r56 = r55.iterator();
    L154:
        if (r56.hasNext() == false) goto L156;
        Pair r57 = (Pair) r56.next();
        ListProtector.add(r4.a, ((Number) r57.getFirst()).intValue(), r57.getSecond());
    L156:
        MoreMixSharePanelUtils r58 = MoreMixSharePanelUtils.INSTANCE;
        boolean r59 = z.e(r0.c, false);
        DataCenter r60 = r0.c;
        if (r60 == null) goto L159;
        boolean r133 = z.m(r60, true);
    L161:
        if (r58.isMoreMixShareMode(r59, r133) == false) goto L169;
        lp1.b r61 = (lp1.b) CollectionsKt.lastOrNull(r4.a);
        if (r61 == null) goto L165;
        ElementType r62 = r61.getElementType();
    L167:
        if (r62 == ElementType.Basic) goto L169;
        r4.a.add(ip1.b.c);
        goto L169
    L165:
        r62 = null;
    L169:
        return r4;
    L159:
        r133 = true;
        goto L161
    L170:
        return null;
    L173:
        return null;
    }
}
