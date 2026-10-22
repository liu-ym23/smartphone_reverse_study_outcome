package com.ss.android.lark.flow.threadwindow;

import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.base.view.vo.message.ThreadForwardContentVOV2;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.chat.utils.c1;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowThreadWindowCellSpecMapper implements com.ss.android.lark.blueprint.o<y6b.a<?>> {
    public final m2b.a a;
    public final List<com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a<?, ?, ?>> b;
    public final jdb.g c;
    public final boolean d;
    public final List<xya.a> e;
    public final Class<y6b.a<?>> f;
    public final Lazy g;
    public final Lazy h;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L53:
            r0[Message.Type.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L63:
            r0[Message.Type.IMAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L39:
            r0[Message.Type.MEDIA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L41:
            r0[Message.Type.SYSTEM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L49:
            r0[Message.Type.SHARE_GROUP_CHAT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L59:
            r0[Message.Type.STICKER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L45:
            r0[Message.Type.FILE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L27
        L55:
            r0[Message.Type.FOLDER.ordinal()] = 9;     // Catch: NoSuchFieldError -> L28
        L57:
            r0[Message.Type.MERGE_FORWARD.ordinal()] = 10;     // Catch: NoSuchFieldError -> L29
        L37:
            r0[Message.Type.AUDIO.ordinal()] = 11;     // Catch: NoSuchFieldError -> L30
        L51:
            r0[Message.Type.SHARE_USER_CARD.ordinal()] = 12;     // Catch: NoSuchFieldError -> L31
        L61:
            r0[Message.Type.SHARE_CALENDAR_EVENT.ordinal()] = 13;     // Catch: NoSuchFieldError -> L32
        L35:
            r0[Message.Type.GENERAL_CALENDAR.ordinal()] = 14;     // Catch: NoSuchFieldError -> L33
        L43:
            r0[Message.Type.VIDEO_CHAT.ordinal()] = 15;     // Catch: NoSuchFieldError -> L34
        L18:
            a = r0;
        }
    }

    public final Class<y6b.a<?>> getDataType() {
        return this.f;
    }

    public final com.ss.android.lark.blueprint.n a(Object r11) {
        y6b.c r12 = (y6b.a) r11;
        Intrinsics.checkNotNullParameter(r12, "data");
        SystemContent r1 = null;
        if ((r12 instanceof y6b.c) == false) goto L5;
        y6b.c r0 = r12;
    L6:
        boolean r3 = true;
        if (((Boolean) this.g.getValue()).booleanValue() == true) goto L11;
        if (r12.j() == false) goto L11;
    L43:
        IMMessageKeys.Layouts r2 = e(IMMessageKeys.Layouts.BUBBLE, r12);
        List r7 = CollectionsKt.mutableListOf(new com.ss.android.lark.blueprint.j[]{IMMessageKeys.Blocks.RECALLED_CONTENT, IMMessageKeys.Blocks.AVATAR, IMMessageKeys.Blocks.USERNAME});
        b(r7, r12);
        com.ss.android.lark.blueprint.f r4 = new com.ss.android.lark.blueprint.f(r2, r7);
    L44:
        if (r4 == null) goto L47;
        return r4;
    L47:
        if (r12.getType() == Message.Type.LOCATION) goto L59;
        if (r12.getType() == Message.Type.CARD) goto L51;
    L52:
        Iterator<com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a<?, ?, ?>> r5 = this.b.iterator();
    L54:
        if (r5.hasNext() == false) goto L59;
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a<?, ?, ?> r6 = r5.next();
        if (r6.a(r12) == false) goto L54;
        IMMessageKeys.Layouts r8 = e(IMMessageKeys.Layouts.BUBBLE_OPEN_CELL_NESTED, r12);
        List r9 = CollectionsKt.mutableListOf(new com.ss.android.lark.blueprint.j[]{r6.c});
        d(r9);
        b(r9, r12);
        return new com.ss.android.lark.blueprint.f(r8, r9);
    L51:
        if (this.d == true) goto L52;
    L59:
        if (((y6b.a) r12).b == null) goto L61;
        boolean r10 = true;
    L62:
        if (r10 == false) goto L64;
        IMMessageKeys.Layouts r13 = e(IMMessageKeys.Layouts.BUBBLE, r12);
        List r14 = CollectionsKt.mutableListOf(new com.ss.android.lark.blueprint.j[]{IMMessageKeys.Blocks.COT_PROCESS});
        d(r14);
        b(r14, r12);
        return new com.ss.android.lark.blueprint.f(r13, r14);
    L64:
        Iterator<xya.a> r15 = this.e.iterator();
    L66:
        if (r15.hasNext() == false) goto L78;
        Iterator r16 = r15.next().a().entrySet().iterator();
    L69:
        if (r16.hasNext() == false) goto L66;
        Map.Entry r17 = (Map.Entry) r16.next();
        if (r12.getType().getNumber() != ((MessageType) r17.getKey()).getNumber()) goto L69;
        if (r12.getType() != Message.Type.DOUBAO) goto L75;
        IMMessageKeys.Layouts r18 = e(IMMessageKeys.Layouts.DOUBAO_BUBBLE, r12);
    L76:
        List<com.ss.android.lark.blueprint.j> r19 = c((com.ss.android.lark.blueprint.j) r17.getValue());
        b(r19, r12);
        return new com.ss.android.lark.blueprint.f(r18, r19);
    L75:
        r18 = e(IMMessageKeys.Layouts.BUBBLE_CLEAN, r12);
        goto L76
    L78:
        switch(a.a[r12.getType().ordinal()]) {
            case 1: goto L121;
            case 2: goto L109;
            case 3: goto L108;
            case 4: goto L107;
            case 5: goto L93;
            case 6: goto L92;
            case 7: goto L91;
            case 8: goto L90;
            case 9: goto L89;
            case 10: goto L85;
            case 11: goto L83;
            case 12: goto L82;
            case 13: goto L81;
            case 14: goto L81;
            case 15: goto L80;
            default: goto L79;
        };
    L79:
        IMMessageKeys.Layouts r20 = e(IMMessageKeys.Layouts.BUBBLE, r12);
        List r21 = CollectionsKt.mutableListOf(new com.ss.android.lark.blueprint.j[]{IMMessageKeys.Blocks.FLOW_UNKNOWN_CONTENT, IMMessageKeys.Blocks.AVATAR, IMMessageKeys.Blocks.USERNAME});
        b(r21, r12);
        return new com.ss.android.lark.blueprint.f(r20, r21);
    L80:
        IMMessageKeys.Layouts r22 = e(IMMessageKeys.Layouts.BUBBLE_NESTED, r12);
        List<com.ss.android.lark.blueprint.j> r23 = c(IMMessageKeys.Blocks.FLOW_VIDEO_CHAT_CONTENT);
        b(r23, r12);
        return new com.ss.android.lark.blueprint.f(r22, r23);
    L81:
        IMMessageKeys.Layouts r24 = e(IMMessageKeys.Layouts.BUBBLE_NESTED, r12);
        List<com.ss.android.lark.blueprint.j> r25 = c(IMMessageKeys.Blocks.FLOW_CALENDAR_CONTENT);
        b(r25, r12);
        return new com.ss.android.lark.blueprint.f(r24, r25);
    L82:
        IMMessageKeys.Layouts r26 = e(IMMessageKeys.Layouts.BUBBLE_NESTED, r12);
        List<com.ss.android.lark.blueprint.j> r27 = c(IMMessageKeys.Blocks.FLOW_PROFILE_CONTENT);
        b(r27, r12);
        return new com.ss.android.lark.blueprint.f(r26, r27);
    L83:
        IMMessageKeys.Layouts r28 = e(IMMessageKeys.Layouts.BUBBLE, r12);
        List<com.ss.android.lark.blueprint.j> r29 = c(IMMessageKeys.Blocks.AUDIO_CONTENT);
        b(r29, r12);
        return new com.ss.android.lark.blueprint.f(r28, r29);
    L89:
        IMMessageKeys.Layouts r30 = e(IMMessageKeys.Layouts.BUBBLE_NESTED, r12);
        List<com.ss.android.lark.blueprint.j> r31 = c(IMMessageKeys.Blocks.FOLDER_CONTENT);
        b(r31, r12);
        return new com.ss.android.lark.blueprint.f(r30, r31);
    L90:
        IMMessageKeys.Layouts r32 = e(IMMessageKeys.Layouts.BUBBLE_NESTED, r12);
        List<com.ss.android.lark.blueprint.j> r33 = c(IMMessageKeys.Blocks.FILE_CONTENT);
        b(r33, r12);
        return new com.ss.android.lark.blueprint.f(r32, r33);
    L91:
        IMMessageKeys.Layouts r34 = e(IMMessageKeys.Layouts.BUBBLE_MINIMAL, r12);
        List<com.ss.android.lark.blueprint.j> r35 = c(IMMessageKeys.Blocks.STICKER_CONTENT);
        b(r35, r12);
        return new com.ss.android.lark.blueprint.f(r34, r35);
    L92:
        IMMessageKeys.Layouts r36 = e(IMMessageKeys.Layouts.BUBBLE_NESTED, r12);
        List r37 = CollectionsKt.mutableListOf(new com.ss.android.lark.blueprint.j[]{IMMessageKeys.Blocks.SHARE_GROUP_CHAT_CONTENT});
        d(r37);
        b(r37, r12);
        return new com.ss.android.lark.blueprint.f(r36, r37);
    L93:
        com.ss.android.lark.chat.base.view.vo.message.d r110 = r12.b();
        if ((r110 instanceof com.ss.android.lark.chat.base.view.vo.message.d) == false) goto L96;
        com.ss.android.lark.chat.base.view.vo.message.d r111 = r110;
    L97:
        if (r111 == null) goto L99;
        r1 = (SystemContent) ((v5b.a) r111).a;
    L99:
        if (r1 != null) goto L101;
    L103:
        r3 = false;
    L104:
        if (r3 == false) goto L106;
        com.ss.android.lark.blueprint.f r112 = new com.ss.android.lark.blueprint.f(IMMessageKeys.Layouts.PLAIN, CollectionsKt.listOf(IMMessageKeys.Blocks.SYS_RED_PACKET));
    L141:
        return r112;
    L106:
        r112 = new com.ss.android.lark.blueprint.f(IMMessageKeys.Layouts.PLAIN, CollectionsKt.listOf(IMMessageKeys.Blocks.SYSTEM_CONTENT));
        goto L141
    L101:
        if (r1.isRedPackSystemMessage() != true) goto L103;
    L96:
        r111 = null;
        goto L97
    L107:
        IMMessageKeys.Layouts r38 = e(IMMessageKeys.Layouts.BUBBLE_MINIMAL, r12);
        List<com.ss.android.lark.blueprint.j> r39 = c(IMMessageKeys.Blocks.MEDIA_CONTENT);
        b(r39, r12);
        return new com.ss.android.lark.blueprint.f(r38, r39);
    L108:
        IMMessageKeys.Layouts r40 = e(IMMessageKeys.Layouts.BUBBLE_MINIMAL, r12);
        List<com.ss.android.lark.blueprint.j> r41 = c(IMMessageKeys.Blocks.IMAGE_CONTENT);
        b(r41, r12);
        return new com.ss.android.lark.blueprint.f(r40, r41);
    L109:
        SystemContent r42 = r12.b();
        if ((r42 instanceof PostContentVO) == false) goto L112;
        r1 = (PostContentVO) r42;
    L112:
        if (r1 != null) goto L114;
    L116:
        boolean r43 = false;
    L117:
        if (r43 == false) goto L119;
        IMMessageKeys.Layouts r44 = e(IMMessageKeys.Layouts.BUBBLE_CLEAN, r12);
    L120:
        List r45 = CollectionsKt.mutableListOf(new com.ss.android.lark.blueprint.j[]{IMMessageKeys.Blocks.POST_CONTENT});
        d(r45);
        b(r45, r12);
        return new com.ss.android.lark.blueprint.f(r44, r45);
    L119:
        r44 = e(IMMessageKeys.Layouts.BUBBLE, r12);
        goto L120
    L114:
        if (r1.i() != true) goto L116;
        r43 = true;
        goto L117
    L121:
        int r46 = c1.a;
        if (c1.a(r12, this.a, null) == false) goto L124;
        IMMessageKeys.Layouts r47 = e(IMMessageKeys.Layouts.BUBBLE_NESTED, r12);
        List r48 = CollectionsKt.mutableListOf(new com.ss.android.lark.blueprint.j[]{IMMessageKeys.Blocks.URL_PREVIEW_CONTENT});
        d(r48);
        b(r48, r12);
        return new com.ss.android.lark.blueprint.f(r47, r48);
    L124:
        IMMessageKeys.Layouts r49 = e(IMMessageKeys.Layouts.BUBBLE, r12);
        List r50 = CollectionsKt.mutableListOf(new com.ss.android.lark.blueprint.j[]{IMMessageKeys.Blocks.TEXT_CONTENT});
        d(r50);
        b(r50, r12);
        return new com.ss.android.lark.blueprint.f(r49, r50);
    L85:
        if ((r12.b() instanceof ThreadForwardContentVOV2) == false) goto L88;
        IMMessageKeys.Layouts r51 = e(IMMessageKeys.Layouts.BUBBLE_THREAD_FORWARD_NESTED, r12);
        List<com.ss.android.lark.blueprint.j> r52 = c(IMMessageKeys.Blocks.THREAD_FORWARD_CONTENT);
        r52.add(IMMessageKeys.Blocks.FLOW_THREAD_FORWARD_EXPOSURE);
        Unit r53 = Unit.INSTANCE;
        b(r52, r12);
        r112 = new com.ss.android.lark.blueprint.f(r51, r52);
        goto L141
    L88:
        IMMessageKeys.Layouts r54 = e(IMMessageKeys.Layouts.BUBBLE_NESTED_TRANSPARENT, r12);
        List<com.ss.android.lark.blueprint.j> r55 = c(IMMessageKeys.Blocks.MERGE_FORWARD_CONTENT);
        b(r55, r12);
        return new com.ss.android.lark.blueprint.f(r54, r55);
    L61:
        r10 = false;
    L11:
        if (((Boolean) this.g.getValue()).booleanValue() == true) goto L13;
    L20:
        if (r0 != null) goto L22;
    L24:
        boolean r56 = false;
    L25:
        if (r56 == true) goto L43;
        if (r12.H() == false) goto L32;
        if (r12.O() == false) goto L43;
    L32:
        if (((Boolean) this.g.getValue()).booleanValue() == true) goto L34;
    L42:
        r4 = null;
        goto L44
    L34:
        if (r12.j() == false) goto L42;
        if (r0 != null) goto L37;
    L39:
        boolean r57 = false;
    L40:
        if (r57 == true) goto L42;
        r4 = new com.ss.android.lark.blueprint.f(IMMessageKeys.Layouts.PLAIN, CollectionsKt.listOf(IMMessageKeys.Blocks.RECALLED_SYSTEM_CONTENT));
        goto L44
    L37:
        if (r0.Y() != true) goto L39;
        r57 = true;
        goto L40
    L22:
        if (r0.Y != true) goto L24;
        r56 = true;
        goto L25
    L13:
        if (r12.j() == false) goto L20;
        if (r0 != null) goto L16;
    L18:
        boolean r58 = false;
    L19:
        if (r58 == true) goto L43;
    L16:
        if (r0.Y() != true) goto L18;
        r58 = true;
        goto L19
    L5:
        r0 = null;
        goto L6
    }

    public final List<com.ss.android.lark.blueprint.j> c(com.ss.android.lark.blueprint.j r3) {
        List<com.ss.android.lark.blueprint.j> r4 = CollectionsKt.mutableListOf(new com.ss.android.lark.blueprint.j[]{r3});
        d(r4);
        return r4;
    }

    public final void d(List r4) {
        com.ss.android.lark.blueprint.j[] r0 = new com.ss.android.lark.blueprint.j[7];
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
        r4.addAll(CollectionsKt.listOfNotNull(r0));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static void b(List r1, y6b.a r2) {
        if ((r2 instanceof y6b.c) == false) goto L5;
        y6b.c r3 = (y6b.c) r2;
    L6:
        if (r3 != null) goto L9;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == false) goto L17;
        r1.add(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE);
        return;
    L17:
        return;
    L9:
        if (r3.d() == false) goto L13;
        if (r3.isPreMessage() == true) goto L13;
        r4 = true;
        goto L14
    L5:
        r3 = null;
        goto L6
    }

    public final IMMessageKeys.Layouts e(IMMessageKeys.Layouts r2, y6b.a<?> r3) {
        if ((r3 instanceof y6b.c) == true) goto L6;
        return r2;
    L6:
        if (((y6b.c) r3).k1 == true) goto L8;
        return r2;
    L8:
        return r2.toRtl();
    }

    public FlowThreadWindowCellSpecMapper(m2b.a r2, List<? extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a<?, ?, ?>> r3, jdb.g r4, boolean r5, List<? extends xya.a> r6) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        Intrinsics.checkNotNullParameter(r3, "openCellAdapters");
        Intrinsics.checkNotNullParameter(r4, "fgService");
        Intrinsics.checkNotNullParameter(r6, "extensions");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = y6b.a.class;
        this.g = LazyKt.lazy(new FlowThreadWindowCellSpecMapper$isNewRecallEnabled$2(this));
        this.h = LazyKt.lazy(new FlowThreadWindowCellSpecMapper$isExcelPermissionEnabled$2(this));
    }
}
