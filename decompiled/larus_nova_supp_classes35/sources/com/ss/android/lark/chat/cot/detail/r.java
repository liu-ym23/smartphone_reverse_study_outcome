package com.ss.android.lark.chat.cot.detail;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.cot.CotBlockExtra;
import com.ss.android.lark.chat.cot.CotBlockStatus;
import com.ss.android.lark.chat.cot.CotViewBlock;
import com.ss.android.lark.chat.cot.CotViewBlockType;
import com.ss.android.lark.chat.cot.CotViewModel;
import com.ss.android.lark.chat.cot.ToolCallCodeResultArea;
import com.ss.android.lark.chat.cot.ToolCallExtra;
import com.ss.android.lark.chat.cot.ToolCallListResultArea;
import com.ss.android.lark.chat.cot.ToolCallResultArea;
import com.ss.android.lark.chat.cot.ToolCallResultAreaListItem;
import com.ss.android.lark.chat.cot.ToolCallTextResultArea;
import com.ss.android.lark.chat.entity.message.CotStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class r {
    public final boolean a;
    public final StateFlowImpl b;
    public final StateFlowImpl c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[CotDetailBlockType.values().length];
            r0[CotDetailBlockType.ACTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L32:
            r0[CotDetailBlockType.TOOLCALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L6:
            a = r0;
            int[] r1 = new int[CotViewBlockType.values().length];
            r1[CotViewBlockType.TOOL_CALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L44:
            r1[CotViewBlockType.ACTIVITY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L9:
            b = r1;
            int[] r2 = new int[CotStatus.values().length];
            r2[CotStatus.RUNNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L36:
            r2[CotStatus.DONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L38:
            r2[CotStatus.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L28:
            r2[CotStatus.INTERRUPTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L40:
            r2[CotStatus.PAUSED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L30:
            r2[CotStatus.TIMEOUT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L16:
            c = r2;
        }
    }

    public r(boolean r1) {
        this.a = r1;
        StateFlowImpl r2 = j1.a(q.d);
        this.b = r2;
        this.c = r2;
    }

    public final q a(CotViewModel r30) {
        Intrinsics.checkNotNullParameter(r30, "viewModel");
        CotStatus r0 = r30.getOverallStatus();
        String r3 = "status:";
        int r4 = 2;
        if (r30.getViolated() == true) goto L5;
        ArrayList<CotViewBlock> r2 = r30.getBlocks();
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r2.iterator();
    L7:
        int r8 = 1;
        if (r6.hasNext() == false) goto L17;
        Object r7 = r6.next();
        CotViewBlock r9 = (CotViewBlock) r7;
        if (r9.getType() != CotViewBlockType.RUN) goto L12;
    L14:
        boolean r10 = false;
    L15:
        if (r10 == false) goto L7;
        r5.add(r7);
        goto L7
    L12:
        if (r9.getType() == CotViewBlockType.STEP) goto L14;
        r10 = true;
        goto L15
    L17:
        ArrayList r11 = new ArrayList();
        Iterator r12 = r5.iterator();
    L19:
        if (r12.hasNext() == false) goto L33;
        Object r13 = r12.next();
        CotViewBlock r14 = (CotViewBlock) r13;
        if (r14.getType() != CotViewBlockType.REASONING) goto L30;
        String r15 = r14.getBody();
        if (r15 != null) goto L25;
    L27:
        boolean r16 = false;
    L28:
        if (r16 == true) goto L30;
        boolean r17 = true;
    L31:
        if (r17 == true) goto L19;
        r11.add(r13);
        goto L19
    L25:
        if (StringsKt.isBlank(r15) == true) goto L27;
        r16 = true;
    L30:
        r17 = false;
        goto L31
    L33:
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r19 = r11.iterator();
    L35:
        if (r19.hasNext() == false) goto L108;
        CotViewBlock r20 = (CotViewBlock) r19.next();
        int r110 = a.b[r20.getType().ordinal()];
        if (r110 == r8) goto L41;
        if (r110 == r4) goto L40;
        CotDetailBlockType r111 = CotDetailBlockType.THINKING;
    L42:
        CotDetailBlockType r112 = r111;
        CotBlockExtra r113 = r20.getCotBlockExtra();
        if ((r113 instanceof ToolCallExtra) == false) goto L45;
        ToolCallExtra r114 = (ToolCallExtra) r113;
    L46:
        int[] r115 = a.a;
        int r116 = r115[r112.ordinal()];
        String r117 = "lark.im.agent.cot_message.raw_image_icon";
        if (r116 == r8) goto L50;
        if (r116 == r4) goto L50;
        com.ss.android.lark.chat.cot.c r21 = null;
    L58:
        String r118 = r20.getStableId();
        String r119 = r20.getTitle();
        String r120 = r20.getBody();
        CotBlockStatus r121 = r20.getStatus();
        boolean r22 = r20.isStreaming();
        int r122 = r115[r112.ordinal()];
        if (r122 == r8) goto L105;
        if (r122 == r4) goto L63;
        CotStatus r28 = r0;
        Iterator r24 = r19;
        String r26 = r3;
        b r123 = null;
    L107:
        r18.add(new k(r118, r112, r119, r120, r121, r22, r123));
        r19 = r24;
        r3 = r26;
        r0 = r28;
        r4 = 2;
        r8 = 1;
        goto L35
    L63:
        if (r114 == null) goto L65;
        List r124 = r114.getResultAreas();
    L66:
        if (r124 != null) goto L69;
        r124 = CollectionsKt.emptyList();
    L69:
        if (r124.isEmpty() == false) goto L71;
        List r125 = CollectionsKt.emptyList();
        r28 = r0;
        r24 = r19;
        r26 = r3;
    L104:
        b r1 = new u(r21, r125, 4);
    L106:
        r123 = r1;
        goto L107
    L71:
        ArrayList r23 = new ArrayList();
        Iterator r126 = r124.iterator();
    L73:
        if (r126.hasNext() == false) goto L103;
        ToolCallResultArea r25 = (ToolCallResultArea) r126.next();
        if ((r25 instanceof ToolCallTextResultArea) == false) goto L78;
        v r27 = new v.c(((ToolCallTextResultArea) r25).getText());
    L80:
        CotStatus r29 = r0;
        String r210 = r3;
        String r211 = r117;
    L100:
        r23.add(r27);
        r126 = r126;
        r19 = r19;
        r3 = r210;
        r117 = r211;
        r0 = r29;
        goto L73
    L78:
        if ((r25 instanceof ToolCallCodeResultArea) == false) goto L81;
        ToolCallCodeResultArea r31 = (ToolCallCodeResultArea) r25;
        r27 = new v.a(r31.getCode(), r31.getLanguage());
        goto L80
    L81:
        r19 = r19;
        if ((r25 instanceof ToolCallListResultArea) == false) goto L102;
        ArrayList<ToolCallResultAreaListItem> r32 = ((ToolCallListResultArea) r25).getItems();
        ArrayList r33 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r32, 10));
        Iterator r34 = r32.iterator();
    L85:
        if (r34.hasNext() == false) goto L99;
        ToolCallResultAreaListItem r127 = (ToolCallResultAreaListItem) r34.next();
        String r212 = r127.getImageKey();
        if (r212 != null) goto L91;
        r212 = r127.getIcon();
        if (r212 != null) goto L91;
        r212 = r127.getIconUrl();
    L91:
        String r35 = r212;
        Iterator r213 = r34;
        String r36 = r127.getText();
        String r214 = r3;
        String r37 = r127.getLink();
        if (r35 == null) goto L97;
        Set<String> r215 = com.ss.android.lark.chat.cot.b.a;
        CotStatus r216 = r0;
        String r217 = r117;
        com.ss.android.lark.chat.cot.c r38 = com.ss.android.lark.chat.cot.b.a(r35, r127.getText(), null, ChatCoreModule.a().getFeatureGatingDependency().isEnable(r117));
        if ((r38 instanceof com.ss.android.lark.chat.cot.c.b) == false) goto L96;
        com.ss.android.lark.chat.cot.c r128 = com.ss.android.lark.chat.cot.c.e.a;
    L98:
        r33.add(new w(r36, r37, r128));
        r34 = r213;
        r3 = r214;
        r117 = r217;
        r0 = r216;
        goto L85
    L96:
        r128 = r38;
        goto L98
    L97:
        r216 = r0;
        r217 = r117;
        r128 = null;
        goto L98
    L99:
        r29 = r0;
        r210 = r3;
        r211 = r117;
        r27 = new v.b(r33);
        goto L100
    L102:
        throw new NoWhenBranchMatchedException();
    L103:
        r28 = r0;
        r24 = r19;
        r26 = r3;
        r125 = r23;
        goto L104
    L65:
        r124 = null;
        goto L66
    L105:
        r28 = r0;
        r24 = r19;
        r26 = r3;
        r1 = new com.ss.android.lark.chat.cot.detail.a(r21);
    L50:
        Set<String> r129 = com.ss.android.lark.chat.cot.b.a;
        if (r114 == null) goto L53;
        String r130 = r114.getIcon();
    L54:
        if (r114 == null) goto L56;
        String r39 = r114.getToolCallName();
    L57:
        r21 = com.ss.android.lark.chat.cot.b.a(r130, r39, r20.getTitle(), ChatCoreModule.a().getFeatureGatingDependency().isEnable("lark.im.agent.cot_message.raw_image_icon"));
        goto L58
    L56:
        r39 = null;
        goto L57
    L53:
        r130 = null;
        goto L54
    L45:
        r114 = null;
        goto L46
    L40:
        r111 = CotDetailBlockType.ACTION;
        goto L42
    L41:
        r111 = CotDetailBlockType.TOOLCALL;
        goto L42
    L108:
        CotStatus r218 = r0;
        String r219 = r3;
        if (this.a == false) goto L163;
        int r40 = p.a;
        Intrinsics.checkNotNullParameter(r18, "items");
        if (r18.isEmpty() == true) goto L122;
        Iterator r41 = r18.iterator();
    L115:
        if (r41.hasNext() == false) goto L122;
        if (((k) r41.next()).b != CotDetailBlockType.TOOLCALL) goto L119;
        boolean r42 = true;
    L120:
        if (r42 == false) goto L115;
        boolean r43 = false;
    L123:
        if (r43 == true) goto L163;
        ArrayList r44 = new ArrayList(r18.size() * 2);
        int r45 = 0;
    L127:
        if (r45 >= r18.size()) goto L162;
        k r46 = (k) ListProtector.get(r18, r45);
        if (r46.b != CotDetailBlockType.TOOLCALL) goto L130;
        int r47 = r45;
    L133:
        if (r47 >= r18.size()) goto L137;
        if (((k) ListProtector.get(r18, r47)).b != CotDetailBlockType.TOOLCALL) goto L137;
        r47 = r47 + 1;
    L137:
        List r48 = r18.subList(r45, r47);
        String r49 = "tool-group:" + ((k) CollectionsKt.first(r48)).a;
        List r50 = r48;
        if ((r50 instanceof Collection) == true) goto L140;
    L142:
        Iterator r51 = r50.iterator();
    L144:
        if (r51.hasNext() == false) goto L148;
        if (((k) r51.next()).f == false) goto L144;
        boolean r131 = true;
    L149:
        CotDetailBlockType r132 = CotDetailBlockType.GROUP;
        if (r131 == false) goto L152;
        CotBlockStatus r52 = CotBlockStatus.RUNNING;
    L153:
        r44.add(new k(r49, r132, null, null, r52, r131, new s(r48.size(), 2)));
        Iterator r53 = r48.iterator();
    L155:
        if (r53.hasNext() == false) goto L161;
        k r54 = (k) r53.next();
        u r55 = r54.c();
        if (r55 != null) goto L160;
        r55 = new u(null, null, 7);
    L160:
        com.ss.android.lark.chat.cot.c r56 = r55.a;
        List<v> r57 = r55.b;
        Intrinsics.checkNotNullParameter(r57, "resultAreas");
        r44.add(k.a(r54, new u(r56, r57, r49)));
        goto L155
    L161:
        r45 = r47;
        goto L127
    L152:
        r52 = CotBlockStatus.DONE;
    L148:
        r131 = false;
        goto L149
    L140:
        if (r50.isEmpty() == false) goto L142;
    L130:
        r44.add(r46);
        r45 = r45 + 1;
        goto L127
    L162:
        k r133 = null;
        r18 = r44;
    L164:
        ArrayList r58 = new ArrayList(r18);
        if ((!r58.isEmpty()) == false) goto L177;
        String r59 = r30.getCotId();
        String r60 = com.ss.android.lark.chat.cot.h.c(r30);
        switch(a.c[r218.ordinal()]) {
            case 1: goto L174;
            case 2: goto L169;
            case 3: goto L169;
            case 4: goto L169;
            case 5: goto L169;
            case 6: goto L169;
            default: goto L168;
        };
    L168:
        CotStatus r61 = r218;
    L175:
        if (r133 == null) goto L179;
        r58.add(r133);
    L179:
        return new q(r30.getCotId(), r58, r61);
    L169:
        String r134 = r219 + r59;
        CotDetailBlockType r135 = CotDetailBlockType.STATUS;
        r61 = r218;
        if (r61 != CotStatus.ERROR) goto L172;
        CotBlockStatus r62 = CotBlockStatus.ERROR;
    L173:
        r133 = new k(r134, r135, null, null, r62, false, new t(r61, r60));
        goto L175
    L172:
        r62 = CotBlockStatus.DONE;
        goto L173
    L174:
        r61 = r218;
        r133 = new k(r219 + r59, CotDetailBlockType.STATUS, null, null, CotBlockStatus.RUNNING, true, new t(r61, 2));
        goto L175
    L177:
        r61 = r218;
        goto L179
    L119:
        r42 = false;
    L122:
        r43 = true;
    L163:
        r133 = null;
        goto L164
    L5:
        return new q(r30.getCotId(), CollectionsKt.listOf(new k("status:" + r30.getCotId(), CotDetailBlockType.STATUS, null, null, CotBlockStatus.VIOLATED, false, new t(r0, 2))), r0);
    }
}
