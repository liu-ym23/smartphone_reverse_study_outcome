package eda;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.bmhome.utils.i;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.AppletBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.chat.component.list.pipeline.update.RecordingOperationCardKind;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import td8.c;
import td8.d;
import xc8.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements c {
    public final d a;

    public b(d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
    }

    public final boolean a(int r1, xc8.b r2, xc8.b r3, List<? extends xc8.b> r4) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "input");
        if (ObricFeatureServiceDelegate.b.c() == false) goto L19;
        xc8.b r5 = (xc8.b) CollectionsKt.firstOrNull(r4);
        if (r5 == null) goto L12;
        Message r6 = r5.getMessage();
        if (r6 == null) goto L12;
        String r7 = r6.getConversationId();
        if (r7 == null) goto L12;
        boolean r8 = i.g(r7);
    L14:
        if (IWindowContextKt.isWindowContext(this.a.j()) == true) goto L16;
        if (r8 == true) goto L16;
        return false;
    L16:
        return true;
    L12:
        r8 = false;
        goto L14
    L19:
        return false;
    }

    public final List<xc8.b> b(int r102, xc8.b r103, xc8.b r104, List<xc8.b> r105) {
        List<xc8.b> r6 = r105;
        Intrinsics.checkNotNullParameter(r104, "current");
        Intrinsics.checkNotNullParameter(r6, "input");
        if (c.a.a(this, 0, null, null, r105, 7) == true) goto L5;
        return r6;
    L5:
        Iterator<xc8.b> r0 = r105.iterator();
        int r2 = 0;
    L6:
        boolean r5 = true;
        if (r0.hasNext() == false) goto L19;
        Message r3 = r0.next().getMessage();
        if (com.larus.bmhome.chat.bean.d.G0(r3) == true) goto L11;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == true) goto L20;
        r2 = r2 + 1;
    L20:
        if (r2 >= 0) goto L22;
        return r6;
    L22:
        Iterator r1 = r6.iterator();
        int r7 = 0;
        Integer r8 = null;
        int r9 = 0;
    L24:
        if (r1.hasNext() == false) goto L198;
        Object r10 = r1.next();
        int r11 = r7 + 1;
        if (r7 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        xc8.b r12 = (xc8.b) r10;
        Message r13 = r12.getMessage();
        LinkedHashSet r14 = new LinkedHashSet();
        Iterator r15 = com.larus.im.bean.message.a.d(r13).iterator();
    L30:
        if (r15.hasNext() == false) goto L42;
        Block r16 = (Block) r15.next();
        a r17 = a.a;
        BlockContent r18 = r16.getContent();
        if (r18 == null) goto L36;
        AppletBlock r19 = r18.getAppletBlock();
        if (r19 == null) goto L36;
        String r110 = r19.renderData;
    L37:
        r17.getClass();
        a.c r111 = a.b(r110);
        if (r111 != null) goto L40;
        Set r112 = SetsKt.emptySet();
    L41:
        CollectionsKt.addAll(r14, r112);
        goto L30
    L40:
        r112 = a.c(r111.b, r111.c);
    L36:
        r110 = null;
        goto L37
    L42:
        Intrinsics.checkNotNullParameter(r14, "kinds");
        if (r14.contains(RecordingOperationCardKind.TRANSIENT) == false) goto L51;
        if (r8 != null) goto L46;
    L49:
        boolean r113 = true;
    L50:
        Boolean r114 = Boolean.valueOf(r113);
    L53:
        if ((r14.isEmpty() ^ r5) == false) goto L55;
        r8 = Integer.valueOf(r9);
    L55:
        Message r115 = r12.getMessage();
        if (r7 >= r2) goto L58;
        boolean r116 = true;
    L59:
        List r117 = com.larus.im.bean.message.a.d(r115);
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator r21 = r117.iterator();
        boolean r118 = false;
    L61:
        if (r21.hasNext() == false) goto L177;
        Block r22 = (Block) r21.next();
        BlockContent r119 = r22.getContent();
        if (r119 == null) goto L67;
        AppletBlock r23 = r119.getAppletBlock();
        if (r23 == null) goto L67;
        a r120 = a.a;
        Iterator r91 = r1;
        String r24 = r23.renderData;
        r120.getClass();
        a.c r25 = a.b(r24);
        if (r25 != null) goto L71;
        int r92 = r2;
        Iterator r93 = r21;
    L75:
        int r100 = r7;
        Integer r94 = r8;
        int r98 = r9;
        xc8.b r99 = r12;
        int r95 = r11;
        Boolean r96 = r114;
        boolean r97 = r116;
    L162:
        String r65 = null;
    L168:
        if (r65 != null) goto L170;
    L169:
        Block r26 = r22;
    L171:
        if (r118 == true) goto L175;
        if (r26 != r22) goto L175;
        r118 = false;
    L176:
        r20.add(r26);
        r1 = r91;
        r2 = r92;
        r21 = r93;
        r8 = r94;
        r11 = r95;
        r114 = r96;
        r116 = r97;
        r9 = r98;
        r12 = r99;
        r7 = r100;
    L175:
        r118 = true;
        goto L176
    L170:
        r26 = Block.copy$default(r22, 0, null, null, BlockContent.copy$default(r119, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, AppletBlock.copy$default(r23, r65, null, null, null, null, 30, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.MAX_VALUE, -1, 31, null), false, null, null, null, 247, null);
        goto L171
    L71:
        r92 = r2;
        r93 = r21;
        Set r27 = a.c(r25.b, r25.c);
        if (r27.contains(RecordingOperationCardKind.TRANSIENT) == false) goto L77;
        if (r114 == null) goto L75;
        boolean r28 = r114.booleanValue();
    L79:
        r100 = r7;
        r94 = r8;
        r98 = r9;
        r99 = r12;
        r95 = r11;
        r96 = r114;
        r97 = r116;
    L161:
        if (Intrinsics.areEqual(r25.c.opt("is_latest_round"), Boolean.valueOf(r28)) == true) goto L162;
        r25.c.put("is_latest_round", r28);
        JSONObject r29 = r25.a;
        if (r25.d == false) goto L166;
        Object r30 = r25.c.toString();
        Intrinsics.checkNotNull(r30);
    L167:
        r29.put("widget_data", r30);
        r65 = r25.a.toString();
        goto L168
    L166:
        r30 = r25.c;
        goto L167
    L77:
        if (r27.contains(RecordingOperationCardKind.TERMINAL) == false) goto L80;
        r28 = true;
        goto L79
    L80:
        String r31 = r25.b;
        JSONObject r32 = r25.c;
        r94 = r8;
        if (a.b.contains(r31) == false) goto L84;
        r100 = r7;
        r98 = r9;
        r99 = r12;
        r95 = r11;
        r96 = r114;
        r97 = r116;
    L83:
        boolean r90 = true;
    L157:
        if (r90 == false) goto L162;
        r28 = r97;
        goto L161
    L84:
        JSONArray r33 = r32.optJSONArray("cards");
        if (r33 != null) goto L88;
        r100 = r7;
        r98 = r9;
        r99 = r12;
        r95 = r11;
    L87:
        r96 = r114;
        r97 = r116;
        r90 = false;
        goto L157
    L88:
        int r34 = r33.length();
        r95 = r11;
        int r121 = 0;
    L89:
        if (r121 >= r34) goto L155;
        int r122 = r34;
        JSONObject r35 = r33.optJSONObject(r121);
        JSONArray r123 = r33;
        if (r35 == null) goto L95;
        JSONArray r36 = r35.optJSONArray("items");
        if (r36 == null) goto L95;
        int r37 = r36.length();
        r96 = r114;
        int r124 = 0;
    L97:
        if (r124 >= r37) goto L151;
        int r125 = r37;
        JSONObject r38 = r36.optJSONObject(r124);
        JSONArray r210 = r36;
        if (r38 != null) goto L101;
        r100 = r7;
        r98 = r9;
        r99 = r12;
        r97 = r116;
    L150:
        r124 = r124 + 1;
        r37 = r125;
        r36 = r210;
        r116 = r97;
        r9 = r98;
        r12 = r99;
        r7 = r100;
        goto L97
    L101:
        String r39 = r38.optString("intentName");
        if (StringsKt.isBlank(r39) == false) goto L104;
        r39 = r38.optString("intent_name");
    L104:
        r97 = r116;
        JSONObject r126 = a.a(r38);
        if (r126 != null) goto L107;
        r100 = r7;
        r98 = r9;
        r99 = r12;
    L122:
        boolean r40 = false;
    L123:
        if (r40 == true) goto L149;
        if (Intrinsics.areEqual(r39, "System_UserConfirm") == false) goto L141;
        JSONObject r41 = a.a(r38);
        if (r41 == null) goto L130;
        String r42 = a.d(r41, "confirmIntent");
    L131:
        if (r42 != null) goto L133;
        r42 = NameKeys.UnloadStrategy_No_Strategy;
    L133:
        Set<String> r43 = a.e.get(r42);
        if (r43 != null) goto L136;
    L138:
        boolean r44 = false;
    L139:
        if (r44 == false) goto L141;
    L136:
        if (r43.contains(r31) != true) goto L138;
        r44 = true;
        goto L139
    L130:
        r42 = null;
    L141:
        Set<String> r45 = a.e.get(r39);
        if (r45 == null) goto L147;
        if (r45.contains(r31) != true) goto L147;
        boolean r46 = true;
    L148:
        if (r46 == false) goto L150;
    L147:
        r46 = false;
    L149:
        boolean r47 = true;
    L152:
        if (r47 == true) goto L83;
    L154:
        r121 = r121 + 1;
        r34 = r122;
        r33 = r123;
        r114 = r96;
        r116 = r97;
        r9 = r98;
        r12 = r99;
        r7 = r100;
        goto L89
    L107:
        r98 = r9;
        r99 = r12;
        if (Intrinsics.areEqual(r39, "System_UserSelect") == false) goto L116;
        Set<a.b> r48 = a.c;
        r100 = r7;
        String r49 = a.d(r126, "sourceIntent");
        if (r49 != null) goto L112;
        r49 = NameKeys.UnloadStrategy_No_Strategy;
    L112:
        String r127 = a.d(r126, "type");
        if (r127 != null) goto L115;
        r127 = NameKeys.UnloadStrategy_No_Strategy;
    L115:
        r40 = r48.contains(new a.b(r31, r49, r127));
        goto L123
    L116:
        r100 = r7;
        if (Intrinsics.areEqual(r39, "System_MultiUserSelect") == false) goto L122;
        Set<a.C0088a> r50 = a.d;
        String r51 = a.d(r126, "type");
        if (r51 != null) goto L121;
        r51 = NameKeys.UnloadStrategy_No_Strategy;
    L121:
        r40 = r50.contains(new a.C0088a(r31, r51));
        goto L123
    L151:
        r100 = r7;
        r98 = r9;
        r99 = r12;
        r97 = r116;
        r47 = false;
    L95:
        r100 = r7;
        r98 = r9;
        r99 = r12;
        r96 = r114;
        r97 = r116;
        goto L154
    L155:
        r100 = r7;
        r98 = r9;
        r99 = r12;
    L67:
        r91 = r1;
        r92 = r2;
        r93 = r21;
        r100 = r7;
        r94 = r8;
        r98 = r9;
        r99 = r12;
        r95 = r11;
        r96 = r114;
        r97 = r116;
        goto L169
    L177:
        Iterator r910 = r1;
        int r911 = r2;
        int r101 = r7;
        Integer r912 = r8;
        int r913 = r9;
        xc8.b r914 = r12;
        int r915 = r11;
        if (r118 == false) goto L180;
        Message r52 = Message.copy$default(r115, null, null, null, 0, 0, null, 0, false, null, null, r20, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1025, 31, null);
    L181:
        if (r52 == null) goto L183;
        List<xc8.b> r53 = r105;
        ListProtector.set(r53, r101, f.f(r52));
    L184:
        Message r54 = r914.getMessage();
        if (com.larus.bmhome.chat.bean.d.G0(r54) == false) goto L192;
        if (b0.f(r54) == true) goto L192;
        if (r54.getMessageStatusLocal() != 11) goto L192;
        boolean r55 = true;
    L193:
        if (r55 == false) goto L195;
        r9 = r913 + 1;
    L196:
        r6 = r53;
        r1 = r910;
        r2 = r911;
        r8 = r912;
        r7 = r915;
        r5 = true;
        goto L24
    L195:
        r9 = r913;
    L192:
        r55 = false;
        goto L193
    L183:
        r53 = r105;
        goto L184
    L180:
        r52 = null;
        goto L181
    L58:
        r116 = false;
        goto L59
    L46:
        if ((r9 - r8.intValue()) >= 5) goto L49;
        r113 = false;
        goto L50
    L51:
        r114 = null;
        goto L53
    L198:
        return r6;
    L11:
        if (b0.f(r3) == true) goto L15;
        if (r3.getMessageStatusLocal() != 11) goto L15;
        r4 = true;
        goto L16
    L19:
        r2 = -1;
        goto L20
    }
}
