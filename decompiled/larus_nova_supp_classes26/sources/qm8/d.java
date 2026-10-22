package qm8;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.standarduikit.quickreply.view.QuickReplyView;
import com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.QuickReplyVMDependencyImpl;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.IconAlignment;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyBlockStatus;
import com.larus.im.bean.message.block.QuickReplyIcon;
import com.larus.im.bean.message.block.QuickReplyItem;
import com.larus.im.bean.message.block.QuickReplyScene;
import com.larus.im.bean.message.block.RenderStyle;
import com.larus.im.bean.message.block.SortType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc8.e;
import kc8.l0;
import kc8.y;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tm8.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d extends jc8.b<c> {
    public pm8.c d;

    public final String c() {
        return "QuickReplyBlockHolder";
    }

    public d() {
    }

    public final jc8.d f(jc8.a r2) {
        c r3 = (c) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return e.d(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v24 */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.util.List] */
    public final void g(jc8.a r35) {
        c r1 = (c) r35;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        kc8.b r2 = jc8.c.a(this, kc8.b.class);
        QuickReplyVMDependencyImpl r3 = new QuickReplyVMDependencyImpl();
        pm8.c r4 = this.d;
        if (r4 == null) goto L271;
        BlockContent r5 = ((jc8.a) r1).a.getContent();
        if (r5 == null) goto L57;
        QuickReplyBlock r17 = r5.getQuickReplyBlock();
        if (r17 == null) goto L57;
        if (r2 == null) goto L11;
        y r6 = r2.a;
    L12:
        Message r20 = r1.j();
        jc8.a r7 = r1.k();
        if (r7 == null) goto L15;
        long r8 = r7.c;
    L16:
        long r12 = r8;
        String r9 = ((jc8.a) r1).g;
        if (r6 == null) goto L22;
        Function0 r10 = r6.f;
        if (r10 == null) goto L22;
        String r11 = (String) r10.invoke();
        if (r11 == null) goto L22;
    L23:
        String r13 = r11;
        String r14 = r20.getMessageId();
        if (r6 == null) goto L31;
        Function0 r15 = r6.l;
        if (r15 == null) goto L31;
        BotModel r16 = (BotModel) r15.invoke();
        if (r16 == null) goto L31;
        String r18 = r16.getBotId();
        if (r18 == null) goto L31;
    L32:
        String r19 = r18;
        if (r6 == null) goto L39;
        Function0 r21 = r6.m;
        if (r21 == null) goto L39;
        ChatParam r22 = (ChatParam) r21.invoke();
        if (r22 == null) goto L39;
        String r110 = r22.d;
    L40:
        Map r111 = r20.getExt();
        if (r2 == null) goto L45;
        l0 r23 = r2.s;
        if (r23 == null) goto L45;
        Function6 r112 = r23.a;
    L46:
        if (r2 == null) goto L50;
        l0 r24 = r2.s;
        if (r24 == null) goto L50;
        Integer r113 = r24.b;
    L51:
        if (r6 == null) goto L55;
        Function0 r25 = r6.n;
        if (r25 == null) goto L55;
        ChatPageContext r114 = (ChatPageContext) r25.invoke();
    L56:
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b r26 = new com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b(r13, r14, r19, r110, r12, r111, r112, r113, r17, r114, r9, r20);
    L58:
        Intrinsics.checkNotNullParameter(r26, "vmData");
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.d r27 = (com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.d) r4.b.getValue();
        r27.getClass();
        Intrinsics.checkNotNullParameter(r26, "vmData");
        r27.a = r26;
        r27.b = r3;
        QuickReplyView r28 = (QuickReplyView) r4.a.getValue();
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.d r29 = (com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.d) r4.b.getValue();
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b r30 = r29.a;
        if (r30 != null) goto L61;
        r30 = new com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b(null, null, null, null, 0, null, null, null, 4095);
    L61:
        QuickReplyBlock r31 = r30.i;
        String r32 = r30.k;
        if (r31 == null) goto L69;
        Integer r115 = r31.getStatus();
        int r116 = QuickReplyBlockStatus.STATUS_HIDDEN.getValue();
        if (r115 == null) goto L69;
        if (r115.intValue() != r116) goto L69;
        boolean r117 = true;
    L71:
        if (r117 == false) goto L74;
        ?? r33 = CollectionsKt.emptyList();
    L135:
        ?? r118 = r33;
    L137:
        Iterable r34 = (Iterable) r118;
        ArrayList r36 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r34, 10));
        Iterator r37 = r34.iterator();
    L139:
        if (r37.hasNext() == false) goto L141;
        r36.add(((com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.d.b) r37.next()).a);
        goto L139
    L141:
        r29.c = r36;
        String r38 = r30.b;
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b r39 = r29.a;
        if (r39 == null) goto L144;
        String r210 = r39.k;
    L145:
        if (r31 == null) goto L147;
        Integer r40 = r31.getSortType();
    L148:
        if (r31 == null) goto L150;
        Integer r119 = r31.getScene();
    L151:
        List<QuickReplyItem> r41 = r29.c;
        if (r41.size() <= 1) goto L182;
        int r120 = QuickReplyScene.SCENE_ASWEER_INNER_OPTION.getValue();
        if (r119 != null) goto L158;
    L160:
        int r121 = SortType.VERTICAL.getValue();
        if (r40 != null) goto L164;
    L166:
        List<QuickReplyItem> r42 = r41;
        if ((r42 instanceof Collection) == true) goto L169;
    L171:
        Iterator r43 = r42.iterator();
    L173:
        if (r43.hasNext() == false) goto L182;
        Integer r44 = ((QuickReplyItem) r43.next()).getRenderStyle();
        int r122 = RenderStyle.RENDER_STYLE_BUTTON_BLOCK.getValue();
        if (r44 != null) goto L178;
    L180:
        boolean r45 = false;
    L181:
        if (r45 == false) goto L173;
    L178:
        if (r44.intValue() != r122) goto L180;
        r45 = true;
        goto L181
    L169:
        if (r42.isEmpty() == false) goto L171;
    L164:
        if (r40.intValue() != r121) goto L166;
    L158:
        if (r119.intValue() != r120) goto L160;
    L182:
        if (r31 == null) goto L193;
        String r46 = r31.getGuideText();
        if (r46 == null) goto L193;
        if ((!StringsKt.isBlank(r46)) == true) goto L188;
    L190:
        boolean r47 = false;
    L191:
        if (r47 == false) goto L193;
        String r211 = r46;
    L194:
        Integer r48 = r30.h;
        ArrayList r49 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r34, 10));
        Iterator r50 = r34.iterator();
    L196:
        if (r50.hasNext() == false) goto L250;
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.d.b r51 = (com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.d.b) r50.next();
        QuickReplyItem r123 = r51.a;
        String r212 = r123.getText();
        int r213 = r123.getTrackIndex();
        QuickReplyIcon r124 = r123.getIcon();
        if (r124 == null) goto L200;
        String r214 = r124.getUrlLight();
    L201:
        QuickReplyIcon r125 = r123.getIcon();
        if (r125 == null) goto L204;
        String r215 = r125.getUrlDark();
    L205:
        QuickReplyIcon r126 = r123.getIcon();
        if (r126 == null) goto L213;
        Integer r127 = r126.getAlignment();
        int r128 = IconAlignment.ALIGN_LEFT.getValue();
        if (r127 == null) goto L213;
        if (r127.intValue() != r128) goto L213;
        int r129 = 1;
    L214:
        int r216 = r129 ^ 1;
        if (r31 == null) goto L217;
        Integer r130 = r31.getScene();
    L218:
        Integer r131 = r123.getRenderStyle();
        RenderStyle r132 = RenderStyle.RENDER_STYLE_BUTTON_BLOCK;
        int r52 = r132.getValue();
        if (r131 != null) goto L222;
    L224:
        int r53 = RenderStyle.RENDER_STYLE_UNDERLINE.getValue();
        if (r131 != null) goto L228;
    L230:
        int r54 = RenderStyle.RENDER_STYLE_DEFAULT.getValue();
        if (r131 != null) goto L234;
    L241:
        int r310 = 0;
    L242:
        Integer r55 = r123.getRenderStyle();
        int r133 = r132.getValue();
        if (r55 != null) goto L246;
    L248:
        boolean r311 = false;
    L249:
        r49.add(new tm8.a(r212, r213, r214, r215, r216, r310, r311, r51.b, r123.getExtraParams()));
        goto L196
    L246:
        if (r55.intValue() != r133) goto L248;
        r311 = true;
        goto L249
    L234:
        if (r131.intValue() != r54) goto L241;
        int r56 = QuickReplyScene.SCENE_ASWEER_INNER_OPTION.getValue();
        if (r130 == null) goto L241;
        if (r130.intValue() != r56) goto L241;
    L240:
        r310 = 2;
        goto L242
    L228:
        if (r131.intValue() != r53) goto L230;
    L222:
        if (r131.intValue() != r52) goto L224;
        r310 = 1;
        goto L242
    L217:
        r130 = null;
    L213:
        r129 = 0;
        goto L214
    L204:
        r215 = null;
        goto L205
    L200:
        r214 = null;
        goto L201
    L250:
        r28.a(new n(r38, r210, r49, r211, r48), ((com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.d) r4.b.getValue()).d);
        return;
    L188:
        if ((!((Collection) r118).isEmpty()) == false) goto L190;
        r47 = true;
    L193:
        r211 = null;
        goto L194
    L150:
        r119 = null;
        goto L151
    L147:
        r40 = null;
        goto L148
    L144:
        r210 = null;
        goto L145
    L74:
        if (r31 == null) goto L76;
        List r134 = r31.getItems();
    L77:
        if (r134 != null) goto L79;
        r134 = CollectionsKt.emptyList();
    L79:
        ArrayList r135 = new ArrayList();
        Iterator r136 = r134.iterator();
    L81:
        if (r136.hasNext() == false) goto L92;
        Object r137 = r136.next();
        String r138 = ((QuickReplyItem) r137).getText();
        if (r138 != null) goto L85;
    L88:
        boolean r139 = true;
    L90:
        if ((!r139) == false) goto L81;
        r135.add(r137);
        goto L81
    L85:
        if (StringsKt.isBlank(r138) == true) goto L88;
        r139 = false;
        goto L90
    L92:
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b r140 = r29.a;
        if (r140 == null) goto L97;
        Message r141 = r140.l;
        if (r141 == null) goto L97;
        Map r142 = r141.getBusinessExt();
    L98:
        if (r142 == null) goto L100;
        String r143 = (String) r142.get("quick_reply_click_index_info");
    L101:
        if (r143 != null) goto L103;
    L106:
        boolean r144 = true;
    L107:
        if (r144 == false) goto L112;
        r33 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r135, 10));
        Iterator r145 = r135.iterator();
    L110:
        if (r145.hasNext() == false) goto L135;
        r33.add(new com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.d.b((QuickReplyItem) r145.next(), false));
        goto L110
    L112:
        ArrayList r146 = new ArrayList();
        Iterator r147 = r135.iterator();
        int r148 = 0;
    L114:
        if (r147.hasNext() == false) goto L130;
        Object r149 = r147.next();
        int r150 = r148 + 1;
        if (r148 >= 0) goto L118;
        CollectionsKt.throwIndexOverflow();
    L118:
        QuickReplyItem r57 = (QuickReplyItem) r149;
        StringBuilder r58 = new StringBuilder();
        if (r32 != null) goto L121;
        String r151 = "";
    L122:
        r58.append(r151);
        r58.append('-');
        r58.append(r148);
        if (Intrinsics.areEqual(r143, r58.toString()) == false) goto L125;
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.d.b r59 = new com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.d.b(r57, true);
    L126:
        if (r59 == null) goto L128;
        r146.add(r59);
    L128:
        r148 = r150;
        goto L114
    L125:
        r59 = null;
        goto L126
    L121:
        r151 = r32;
        goto L122
    L130:
        if (r146.isEmpty() == false) goto L136;
        r33 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r135, 10));
        Iterator r60 = r135.iterator();
    L133:
        if (r60.hasNext() == false) goto L135;
        r33.add(new com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.d.b((QuickReplyItem) r60.next(), false));
        goto L133
    L136:
        r118 = r146;
        goto L137
    L103:
        if (r143.length() == 0) goto L106;
        r144 = false;
        goto L107
    L100:
        r143 = null;
    L97:
        r142 = null;
        goto L98
    L76:
        r134 = null;
    L69:
        r117 = false;
    L55:
        r114 = null;
    L50:
        r113 = null;
    L45:
        r112 = null;
    L39:
        r110 = null;
    L31:
        r18 = r20.getSenderId();
    L22:
        r11 = r20.getConversationId();
        goto L23
    L15:
        r8 = 0;
        goto L16
    L11:
        r6 = null;
    L57:
        r26 = new com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b(null, null, null, null, 0, null, null, null, 4095);
        goto L58
    }

    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        pm8.c r0 = this.d;
        if (r0 != null) goto L6;
        r0 = new pm8.c(r2.getContext());
        this.d = r0;
    L6:
        return (QuickReplyView) r0.a.getValue();
    }
}
