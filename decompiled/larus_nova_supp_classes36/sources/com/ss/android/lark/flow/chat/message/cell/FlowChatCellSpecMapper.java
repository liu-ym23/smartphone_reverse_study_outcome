package com.ss.android.lark.flow.chat.message.cell;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.blueprint.f;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.n;
import com.ss.android.lark.blueprint.o;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.base.view.vo.message.ThreadForwardContentVOV2;
import com.ss.android.lark.chat.base.view.vo.message.d;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.chat.utils.c1;
import com.ss.android.lark.message.lynxcard.message.r;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jdb.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import y6b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowChatCellSpecMapper implements o<y6b.a<?>> {
    public final m2b.a a;
    public final List<com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a<?, ?, ?>> b;
    public final g c;
    public final List<xya.a> d;
    public final Class<y6b.a<?>> e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L67:
            r0[Message.Type.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L79:
            r0[Message.Type.IMAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L49:
            r0[Message.Type.MEDIA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L53:
            r0[Message.Type.SYSTEM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
        L61:
            r0[Message.Type.SHARE_GROUP_CHAT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L29
        L73:
            r0[Message.Type.STICKER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L30
        L57:
            r0[Message.Type.FILE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L31
        L69:
            r0[Message.Type.FOLDER.ordinal()] = 9;     // Catch: NoSuchFieldError -> L32
        L71:
            r0[Message.Type.MERGE_FORWARD.ordinal()] = 10;     // Catch: NoSuchFieldError -> L33
        L45:
            r0[Message.Type.AUDIO.ordinal()] = 11;     // Catch: NoSuchFieldError -> L34
        L65:
            r0[Message.Type.SHARE_USER_CARD.ordinal()] = 12;     // Catch: NoSuchFieldError -> L35
        L77:
            r0[Message.Type.CALENDAR.ordinal()] = 13;     // Catch: NoSuchFieldError -> L36
        L43:
            r0[Message.Type.SHARE_CALENDAR_EVENT.ordinal()] = 14;     // Catch: NoSuchFieldError -> L37
        L55:
            r0[Message.Type.GENERAL_CALENDAR.ordinal()] = 15;     // Catch: NoSuchFieldError -> L38
        L75:
            r0[Message.Type.VIDEO_CHAT.ordinal()] = 16;     // Catch: NoSuchFieldError -> L39
        L47:
            r0[Message.Type.RED_PACKET.ordinal()] = 17;     // Catch: NoSuchFieldError -> L40
        L51:
            r0[Message.Type.COMMERCIALIZED_HONGBAO.ordinal()] = 18;     // Catch: NoSuchFieldError -> L41
        L63:
            r0[Message.Type.TODO.ordinal()] = 19;     // Catch: NoSuchFieldError -> L42
        L22:
            a = r0;
        }
    }

    public final Class<y6b.a<?>> getDataType() {
        return this.e;
    }

    public final n a(Object r13) {
        c r14 = (y6b.a) r13;
        Intrinsics.checkNotNullParameter(r14, "data");
        boolean r0 = this.a.Y();
        boolean r3 = true;
        if (r14.getType() == Message.Type.LOCATION) goto L5;
    L10:
        boolean r1 = false;
    L11:
        SystemContent r5 = null;
        if (r14.d() == true) goto L14;
    L27:
        boolean r2 = false;
    L28:
        boolean r4 = r14 instanceof c;
        if (r4 == false) goto L31;
        c r6 = r14;
    L33:
        if (((Boolean) this.g.getValue()).booleanValue() == true) goto L37;
        if (r14.j() == false) goto L37;
    L74:
        IMMessageKeys.Layouts r7 = e(IMMessageKeys.Layouts.BUBBLE, r14);
        List r8 = CollectionsKt.mutableListOf(new IMMessageKeys.Blocks[]{IMMessageKeys.Blocks.RECALLED_CONTENT, IMMessageKeys.Blocks.AVATAR, IMMessageKeys.Blocks.USERNAME});
        if (r2 == false) goto L77;
        r8.add(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE);
    L77:
        n r9 = new f(r7, r8);
    L78:
        if (r9 != null) goto L304;
        if (r4 == false) goto L82;
        c r10 = r14;
    L83:
        if (r10 != null) goto L85;
    L87:
        boolean r11 = false;
    L88:
        if (r11 == true) goto L290;
        if (r4 == false) goto L92;
        c r12 = r14;
    L93:
        if (r12 != null) goto L95;
    L97:
        boolean r15 = false;
    L98:
        if (r15 == true) goto L298;
        if (r1 == true) goto L118;
        if (r14.getType() == Message.Type.CARD) goto L104;
    L105:
        Iterator<com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a<?, ?, ?>> r16 = this.b.iterator();
    L107:
        if (r16.hasNext() == false) goto L118;
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a<?, ?, ?> r17 = r16.next();
        if (r17.a(r14) == false) goto L107;
        if (r2 == false) goto L112;
        IMMessageKeys.Layouts r18 = IMMessageKeys.Layouts.BUBBLE_OPEN_CELL_NESTED;
    L113:
        IMMessageKeys.Layouts r19 = e(r18, r14);
        List<j> r20 = CollectionsKt.mutableListOf(new j[]{r17.c});
        c(r20);
        if (r2 == false) goto L299;
        r20.add(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE);
    L299:
        return new f(r19, r20);
    L112:
        r18 = IMMessageKeys.Layouts.BUBBLE_OPEN_CELL;
        goto L113
    L104:
        if (((Boolean) this.f.getValue()).booleanValue() == true) goto L105;
    L118:
        if (((y6b.a) r14).b == null) goto L120;
        boolean r21 = true;
    L121:
        if (r21 == false) goto L126;
        IMMessageKeys.Layouts r110 = e(IMMessageKeys.Layouts.BUBBLE, r14);
        List<j> r22 = CollectionsKt.mutableListOf(new j[]{IMMessageKeys.Blocks.COT_PROCESS});
        c(r22);
        if (r2 == false) goto L300;
        r22.add(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE);
    L300:
        return new f(r110, r22);
    L126:
        Iterator<xya.a> r23 = this.d.iterator();
    L128:
        if (r23.hasNext() == false) goto L143;
        Iterator r24 = r23.next().a().entrySet().iterator();
    L131:
        if (r24.hasNext() == false) goto L128;
        Map.Entry r25 = (Map.Entry) r24.next();
        if (r14.getType().getNumber() != ((MessageType) r25.getKey()).getNumber()) goto L131;
        if (r14.getType() != Message.Type.DOUBAO) goto L137;
        IMMessageKeys.Layouts r111 = e(IMMessageKeys.Layouts.DOUBAO_BUBBLE, r14);
    L138:
        List<j> r26 = b((j) r25.getValue());
        if (r2 == false) goto L301;
        r26.add(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE);
    L301:
        return new f(r111, r26);
    L137:
        r111 = e(IMMessageKeys.Layouts.BUBBLE_CLEAN, r14);
        goto L138
    L143:
        switch(a.a[r14.getType().ordinal()]) {
            case 1: goto L277;
            case 2: goto L262;
            case 3: goto L258;
            case 4: goto L254;
            case 5: goto L239;
            case 6: goto L232;
            case 7: goto L228;
            case 8: goto L208;
            case 9: goto L201;
            case 10: goto L186;
            case 11: goto L181;
            case 12: goto L174;
            case 13: goto L167;
            case 14: goto L167;
            case 15: goto L167;
            case 16: goto L160;
            case 17: goto L153;
            case 18: goto L153;
            case 19: goto L146;
            default: goto L144;
        };
    L144:
        f r27 = new f(e(IMMessageKeys.Layouts.BUBBLE, r14), CollectionsKt.mutableListOf(new j[]{IMMessageKeys.Blocks.FLOW_UNKNOWN_CONTENT, IMMessageKeys.Blocks.AVATAR, IMMessageKeys.Blocks.USERNAME}));
    L302:
        return r27;
    L146:
        if (r2 == false) goto L148;
        IMMessageKeys.Layouts r28 = IMMessageKeys.Layouts.BUBBLE_NESTED;
    L149:
        IMMessageKeys.Layouts r112 = e(r28, r14);
        List<j> r29 = b(IMMessageKeys.Blocks.FLOW_TODO_CONTENT);
        if (r2 == false) goto L152;
        r29.add(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE);
    L152:
        r27 = new f(r112, r29);
        goto L302
    L148:
        r28 = IMMessageKeys.Layouts.BUBBLE_CLEAN;
        goto L149
    L153:
        if (r2 == false) goto L155;
        IMMessageKeys.Layouts r113 = e(IMMessageKeys.Layouts.BUBBLE_NESTED, r14);
    L156:
        List<j> r30 = b(IMMessageKeys.Blocks.FLOW_RED_PACKET_CONTENT);
        if (r2 == false) goto L159;
        r30.add(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE);
    L159:
        r27 = new f(r113, r30);
        goto L302
    L155:
        r113 = e(IMMessageKeys.Layouts.BUBBLE_CLEAN, r14);
        goto L156
    L160:
        if (r2 == false) goto L162;
        IMMessageKeys.Layouts r31 = IMMessageKeys.Layouts.BUBBLE_NESTED;
    L163:
        IMMessageKeys.Layouts r114 = e(r31, r14);
        List<j> r32 = b(IMMessageKeys.Blocks.FLOW_VIDEO_CHAT_CONTENT);
        if (r2 == false) goto L166;
        r32.add(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE);
    L166:
        r27 = new f(r114, r32);
        goto L302
    L162:
        r31 = IMMessageKeys.Layouts.BUBBLE_CLEAN;
        goto L163
    L167:
        if (r2 == false) goto L169;
        IMMessageKeys.Layouts r33 = IMMessageKeys.Layouts.BUBBLE_NESTED;
    L170:
        IMMessageKeys.Layouts r115 = e(r33, r14);
        List<j> r34 = b(IMMessageKeys.Blocks.FLOW_CALENDAR_CONTENT);
        if (r2 == false) goto L173;
        r34.add(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE);
    L173:
        r27 = new f(r115, r34);
        goto L302
    L169:
        r33 = IMMessageKeys.Layouts.BUBBLE_CLEAN;
        goto L170
    L174:
        if (r2 == false) goto L176;
        IMMessageKeys.Layouts r35 = IMMessageKeys.Layouts.BUBBLE_NESTED;
    L177:
        IMMessageKeys.Layouts r116 = e(r35, r14);
        List<j> r36 = b(IMMessageKeys.Blocks.FLOW_PROFILE_CONTENT);
        if (r2 == false) goto L180;
        r36.add(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE);
    L180:
        r27 = new f(r116, r36);
        goto L302
    L176:
        r35 = IMMessageKeys.Layouts.BUBBLE_CLEAN;
        goto L177
    L181:
        IMMessageKeys.Layouts r117 = e(IMMessageKeys.Layouts.BUBBLE, r14);
        List<j> r37 = b(IMMessageKeys.Blocks.AUDIO_CONTENT);
        if (r2 == false) goto L184;
        r37.add(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE);
    L184:
        r27 = new f(r117, r37);
        goto L302
    L201:
        if (r2 == false) goto L203;
        IMMessageKeys.Layouts r38 = IMMessageKeys.Layouts.BUBBLE_NESTED;
    L204:
        IMMessageKeys.Layouts r118 = e(r38, r14);
        List<j> r39 = b(IMMessageKeys.Blocks.FOLDER_CONTENT);
        if (r2 == false) goto L207;
        r39.add(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE);
    L207:
        r27 = new f(r118, r39);
        goto L302
    L203:
        r38 = IMMessageKeys.Layouts.BUBBLE_CLEAN;
        goto L204
    L208:
        if (r2 == true) goto L221;
        String r40 = r14.M();
        if (r40 != null) goto L212;
    L215:
        boolean r41 = true;
    L216:
        if (r41 == true) goto L218;
    L220:
        r3 = false;
        goto L221
    L218:
        if (r.a(r14.i()) == false) goto L220;
    L212:
        if (r40.length() == 0) goto L215;
        r41 = false;
    L221:
        if (r3 == false) goto L223;
        IMMessageKeys.Layouts r42 = IMMessageKeys.Layouts.BUBBLE_NESTED;
    L224:
        IMMessageKeys.Layouts r119 = e(r42, r14);
        List<j> r43 = b(IMMessageKeys.Blocks.FILE_CONTENT);
        if (r2 == false) goto L227;
        r43.add(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE);
    L227:
        r27 = new f(r119, r43);
        goto L302
    L223:
        r42 = IMMessageKeys.Layouts.BUBBLE_CLEAN;
        goto L224
    L228:
        IMMessageKeys.Layouts r120 = e(IMMessageKeys.Layouts.BUBBLE_MINIMAL, r14);
        List<j> r44 = b(IMMessageKeys.Blocks.STICKER_CONTENT);
        if (r2 == false) goto L231;
        r44.add(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE);
    L231:
        r27 = new f(r120, r44);
        goto L302
    L232:
        if (r2 == false) goto L234;
        IMMessageKeys.Layouts r45 = IMMessageKeys.Layouts.BUBBLE_NESTED;
    L235:
        IMMessageKeys.Layouts r121 = e(r45, r14);
        List r46 = CollectionsKt.mutableListOf(new j[]{IMMessageKeys.Blocks.SHARE_GROUP_CHAT_CONTENT});
        d(r46);
        if (r2 == false) goto L238;
        r46.add(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE);
    L238:
        r27 = new f(r121, r46);
        goto L302
    L234:
        r45 = IMMessageKeys.Layouts.BUBBLE_CLEAN;
        goto L235
    L239:
        d r122 = r14.b();
        if ((r122 instanceof d) == false) goto L242;
        d r123 = r122;
    L243:
        if (r123 == null) goto L245;
        r5 = (SystemContent) ((v5b.a) r123).a;
    L245:
        if (r5 != null) goto L247;
    L249:
        r3 = false;
    L250:
        if (r3 == false) goto L252;
        f r124 = new f(IMMessageKeys.Layouts.PLAIN, CollectionsKt.listOf(IMMessageKeys.Blocks.SYS_RED_PACKET));
    L303:
        return r124;
    L252:
        r124 = new f(IMMessageKeys.Layouts.PLAIN, CollectionsKt.listOf(IMMessageKeys.Blocks.SYSTEM_CONTENT));
        goto L303
    L247:
        if (r5.isRedPackSystemMessage() != true) goto L249;
    L242:
        r123 = null;
        goto L243
    L254:
        IMMessageKeys.Layouts r125 = e(IMMessageKeys.Layouts.BUBBLE_MINIMAL, r14);
        List<j> r47 = b(IMMessageKeys.Blocks.MEDIA_CONTENT);
        if (r2 == false) goto L257;
        r47.add(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE);
    L257:
        r27 = new f(r125, r47);
        goto L302
    L258:
        IMMessageKeys.Layouts r126 = e(IMMessageKeys.Layouts.BUBBLE_MINIMAL, r14);
        List<j> r48 = b(IMMessageKeys.Blocks.IMAGE_CONTENT);
        if (r2 == false) goto L261;
        r48.add(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE);
    L261:
        r27 = new f(r126, r48);
        goto L302
    L262:
        SystemContent r49 = r14.b();
        if ((r49 instanceof PostContentVO) == false) goto L265;
        r5 = (PostContentVO) r49;
    L265:
        if (r5 != null) goto L267;
    L269:
        boolean r50 = false;
    L270:
        if (r50 == false) goto L272;
        IMMessageKeys.Layouts r51 = IMMessageKeys.Layouts.BUBBLE_CLEAN;
    L273:
        IMMessageKeys.Layouts r127 = e(r51, r14);
        List<j> r52 = CollectionsKt.mutableListOf(new j[]{IMMessageKeys.Blocks.POST_CONTENT});
        c(r52);
        if (r2 == false) goto L276;
        r52.add(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE);
    L276:
        r27 = new f(r127, r52);
        goto L302
    L272:
        r51 = IMMessageKeys.Layouts.BUBBLE;
        goto L273
    L267:
        if (r5.i() != true) goto L269;
        r50 = true;
        goto L270
    L277:
        int r53 = c1.a;
        if (c1.a(r14, this.a, null) == false) goto L286;
        if (r2 == false) goto L281;
        IMMessageKeys.Layouts r54 = IMMessageKeys.Layouts.BUBBLE_NESTED;
    L282:
        IMMessageKeys.Layouts r128 = e(r54, r14);
        List r55 = CollectionsKt.mutableListOf(new j[]{IMMessageKeys.Blocks.THREAD_REPLY, IMMessageKeys.Blocks.URL_PREVIEW_CONTENT});
        d(r55);
        if (r2 == false) goto L285;
        r55.add(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE);
    L285:
        r27 = new f(r128, r55);
        goto L302
    L281:
        r54 = IMMessageKeys.Layouts.BUBBLE_SINGLE_URL;
        goto L282
    L286:
        IMMessageKeys.Layouts r129 = e(IMMessageKeys.Layouts.BUBBLE, r14);
        List<j> r56 = CollectionsKt.mutableListOf(new j[]{IMMessageKeys.Blocks.TEXT_CONTENT});
        c(r56);
        if (r2 == false) goto L289;
        r56.add(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE);
    L289:
        r27 = new f(r129, r56);
        goto L302
    L186:
        if ((r14.b() instanceof ThreadForwardContentVOV2) == false) goto L194;
        if (r2 == false) goto L189;
        IMMessageKeys.Layouts r57 = IMMessageKeys.Layouts.BUBBLE_THREAD_FORWARD_NESTED;
    L190:
        IMMessageKeys.Layouts r130 = e(r57, r14);
        List<j> r58 = b(IMMessageKeys.Blocks.THREAD_FORWARD_CONTENT);
        r58.add(IMMessageKeys.Blocks.FLOW_THREAD_FORWARD_EXPOSURE);
        if (r2 == false) goto L193;
        r58.add(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE);
    L193:
        r27 = new f(r130, r58);
        goto L302
    L189:
        r57 = IMMessageKeys.Layouts.BUBBLE_THREAD_FORWARD;
        goto L190
    L194:
        if (r2 == false) goto L196;
        IMMessageKeys.Layouts r59 = IMMessageKeys.Layouts.BUBBLE_NESTED_TRANSPARENT;
    L197:
        IMMessageKeys.Layouts r131 = e(r59, r14);
        List<j> r60 = b(IMMessageKeys.Blocks.MERGE_FORWARD_CONTENT);
        if (r2 == false) goto L200;
        r60.add(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE);
    L200:
        r27 = new f(r131, r60);
        goto L302
    L196:
        r59 = IMMessageKeys.Layouts.BUBBLE_CLEAN;
        goto L197
    L120:
        r21 = false;
        goto L121
    L298:
        return new f(IMMessageKeys.Layouts.REPLY_AUTH, CollectionsKt.emptyList());
    L95:
        if (r12.Z2 != true) goto L97;
        r15 = true;
        goto L98
    L92:
        r12 = null;
        goto L93
    L290:
        return new f(IMMessageKeys.Layouts.REPLY_ZONE, CollectionsKt.emptyList());
    L85:
        if (r10.Y2 != true) goto L87;
        r11 = true;
        goto L88
    L82:
        r10 = null;
        goto L83
    L304:
        return r9;
    L37:
        if (((Boolean) this.g.getValue()).booleanValue() == true) goto L39;
    L46:
        if (r6 != null) goto L48;
    L50:
        boolean r61 = false;
    L51:
        if (r61 == true) goto L74;
        if (r14.H() == false) goto L58;
        if (r14.O() == false) goto L74;
    L58:
        if (((Boolean) this.g.getValue()).booleanValue() == false) goto L69;
        if (r14.j() == false) goto L69;
        if (r6 != null) goto L63;
    L65:
        boolean r62 = false;
    L66:
        if (r62 == true) goto L69;
        r9 = new f(IMMessageKeys.Layouts.PLAIN, CollectionsKt.listOf(IMMessageKeys.Blocks.RECALLED_SYSTEM_CONTENT));
        goto L78
    L63:
        if (r6.Y() != true) goto L65;
        r62 = true;
    L69:
        if (this.a.Y() == true) goto L71;
    L73:
        r9 = null;
        goto L78
    L71:
        if (r14.P() == false) goto L73;
        r9 = new f(e(IMMessageKeys.Layouts.BUBBLE, r14), CollectionsKt.listOf(new IMMessageKeys.Blocks[]{IMMessageKeys.Blocks.RECALLED_CONTENT, IMMessageKeys.Blocks.AVATAR, IMMessageKeys.Blocks.USERNAME}));
        goto L78
    L48:
        if (r6.Y != true) goto L50;
        r61 = true;
        goto L51
    L39:
        if (r14.j() == false) goto L46;
        if (r6 != null) goto L42;
    L44:
        boolean r63 = false;
    L45:
        if (r63 == true) goto L74;
    L42:
        if (r6.Y() != true) goto L44;
        r63 = true;
        goto L45
    L31:
        r6 = null;
        goto L33
    L14:
        if (this.a.q8() == false) goto L16;
    L25:
        if (r0 == true) goto L27;
        r2 = true;
        goto L28
    L16:
        if (this.a.e0() == false) goto L27;
        if ((r14 instanceof c) == false) goto L20;
        c r64 = r14;
    L21:
        if (r64 == null) goto L23;
        int r65 = r64.T1;
    L24:
        if (r65 <= 0) goto L27;
    L23:
        r65 = 0;
        goto L24
    L20:
        r64 = null;
        goto L21
    L5:
        if (this.a.r() == false) goto L7;
    L9:
        r1 = true;
        goto L11
    L7:
        if (this.a.q() == true) goto L9;
        if (r0 == false) goto L10;
        goto L9
    }

    public final List<j> b(j r3) {
        List<j> r4 = CollectionsKt.mutableListOf(new j[]{r3});
        c(r4);
        return r4;
    }

    public final List<j> c(List<j> r5) {
        if (this.a.Y() == false) goto L5;
        ListProtector.add(r5, 0, IMMessageKeys.Blocks.REPLY);
    L6:
        d(r5);
        return r5;
    L5:
        r5.addAll(0, CollectionsKt.listOf(new IMMessageKeys.Blocks[]{IMMessageKeys.Blocks.REPLY, IMMessageKeys.Blocks.THREAD_REPLY}));
        goto L6
    }

    public final void d(List r4) {
        j[] r0 = new j[8];
        r0[0] = IMMessageKeys.Blocks.AVATAR;
        r0[1] = IMMessageKeys.Blocks.USERNAME;
        if (((Boolean) this.h.getValue()).booleanValue() == false) goto L5;
        IMMessageKeys.Blocks r1 = IMMessageKeys.Blocks.EXCEL_PERMISSION;
    L6:
        r0[2] = r1;
        r0[3] = IMMessageKeys.Blocks.MESSAGE_STATUS;
        r0[4] = IMMessageKeys.Blocks.REACTION;
        r0[5] = IMMessageKeys.Blocks.DLP;
        r0[6] = IMMessageKeys.Blocks.TIME;
        r0[7] = IMMessageKeys.Blocks.MULTI_SELECT;
        r4.addAll(CollectionsKt.listOfNotNull(r0));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final IMMessageKeys.Layouts e(IMMessageKeys.Layouts r2, y6b.a<?> r3) {
        if ((r3 instanceof c) == true) goto L6;
        return r2;
    L6:
        if (((c) r3).k1 == true) goto L8;
        return r2;
    L8:
        return r2.toRtl();
    }

    public FlowChatCellSpecMapper(m2b.a r2, List<? extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a<?, ?, ?>> r3, g r4, List<? extends xya.a> r5) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        Intrinsics.checkNotNullParameter(r3, "openCellAdapters");
        Intrinsics.checkNotNullParameter(r4, "fgService");
        Intrinsics.checkNotNullParameter(r5, "extensions");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = y6b.a.class;
        this.f = LazyKt.lazy(new FlowChatCellSpecMapper$enableOpenCellRender$2(this));
        this.g = LazyKt.lazy(new FlowChatCellSpecMapper$isNewRecallEnabled$2(this));
        this.h = LazyKt.lazy(new FlowChatCellSpecMapper$isExcelPermissionEnabled$2(this));
    }
}
