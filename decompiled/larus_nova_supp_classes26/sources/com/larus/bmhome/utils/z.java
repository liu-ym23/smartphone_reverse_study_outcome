package com.larus.bmhome.utils;

import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.MobileThinkingStreamFields;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.im.bean.message.block.ThinkingBlock;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.complextask.ComplexTaskDelegate;
import gb8.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class z {
    public static final z a = null;

    static {
        a = new z();
    }

    public z() {
    }

    public static String c(Message r3, boolean r4, ThinkingBlock r5, List r6, DeepThinkFoldStatus r7) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r6, "childrenBlocks");
        Intrinsics.checkNotNullParameter(r7, "foldStatus");
        boolean r0 = v19.h.a;
        String r1 = null;
        boolean r2 = v19.h.a(null);
        jc8.j r8 = (jc8.a) CollectionsKt.lastOrNull(r6);
        if (com.larus.im.bean.message.a.i(r3) == true) goto L5;
    L41:
        return "";
    L5:
        if (ic8.q.a(r7) == false) goto L7;
    L8:
        if (r4 == false) goto L41;
        if (r8 == null) goto L13;
        Block r9 = ((jc8.a) r8).a;
        if (r9 == null) goto L13;
        BlockContent r10 = r9.getContent();
    L14:
        if (r10 != null) goto L25;
        if (r2 == false) goto L20;
        if (r5 == null) goto L18;
        r1 = r5.iconUrlDark;
    L18:
        if (r1 == null) goto L41;
    L44:
        return r1;
    L20:
        if (r5 == null) goto L22;
        r1 = r5.iconUrl;
    L22:
        if (r1 != null) goto L44;
    L25:
        if ((r8 instanceof jc8.j) == false) goto L27;
        jc8.j r11 = r8;
    L28:
        if (r11 == null) goto L31;
        String r12 = r11.a(r2);
        if (r12 == null) goto L31;
        return r12;
    L31:
        if (r2 == false) goto L36;
        if (r5 == null) goto L34;
        r1 = r5.iconUrlDark;
    L34:
        if (r1 != null) goto L44;
    L36:
        if (r5 == null) goto L38;
        r1 = r5.iconUrl;
    L38:
        if (r1 != null) goto L44;
    L27:
        r11 = null;
    L13:
        r10 = null;
        goto L14
    L7:
        if (com.larus.im.bean.message.a.l0(r3) == false) goto L41;
        goto L8
    }

    public static String d(Message r8, boolean r9, ThinkingBlock r10, List r11, DeepThinkFoldStatus r12) {
        Intrinsics.checkNotNullParameter(r8, "message");
        Intrinsics.checkNotNullParameter(r11, "childrenBlocks");
        Intrinsics.checkNotNullParameter(r12, "foldStatus");
        boolean r0 = true;
        String r4 = null;
        if (r9 == false) goto L72;
        if (ic8.q.a(r12) == false) goto L13;
        if (r10 == null) goto L8;
        String r5 = r10.streamingTitle;
    L10:
        if (com.larus.utils.o0.d(r5) == false) goto L13;
        if (r10 == null) goto L24;
        String r6 = r10.streamingTitle;
    L25:
        if (r6 != null) goto L27;
    L30:
        boolean r7 = true;
    L31:
        if (r7 == false) goto L33;
        r6 = AppHost.a.getApplication().getString(2131901490);
        Intrinsics.checkNotNull(r6);
    L33:
        jc8.j r13 = (jc8.a) CollectionsKt.lastOrNull(r11);
        if (r13 == null) goto L37;
        FLogger.a.d("DeepThinkGenerateHelper", "getCotCompressionTitle lastBlock=" + r13.getClass().getSimpleName() + " cotUiStyleShowSummary=" + com.larus.im.bean.message.a.i(r8) + " isCompleteFold=" + ic8.q.a(r12));
    L37:
        if (com.larus.im.bean.message.a.i(r8) == true) goto L39;
    L48:
        String r14 = null;
    L49:
        FLogger r15 = FLogger.a;
        StringBuilder r1 = new StringBuilder("generateLoadingTitle normalTitle=");
        r1.append(r6);
        r1.append(" streamingTitle=");
        if (r10 == null) goto L54;
        MobileThinkingStreamFields r16 = r10.streamExtension;
        if (r16 == null) goto L54;
        String r17 = r16.streamingTitle;
    L55:
        r1.append(r17);
        r1.append(" processingTitle=");
        if (r10 == null) goto L60;
        MobileThinkingStreamFields r18 = r10.streamExtension;
        if (r18 == null) goto L60;
        r4 = r18.streamingTitle;
    L60:
        r1.append(r4);
        r1.append(" summaryTitle=");
        r1.append(r14);
        r15.d("DeepThinkGenerateHelper", r1.toString());
        if (r14 != null) goto L63;
    L66:
        if (r0 == true) goto L68;
        r6 = r14;
    L95:
        Intrinsics.checkNotNull(r6);
        ComplexTaskDelegate r19 = ComplexTaskDelegate.b;
        if (r19.f(r8) == false) goto L104;
        String r20 = r19.k(r8, r9, r10);
        if (r20 == null) goto L105;
        String r21 = r6 + r20;
        if (r21 != null) goto L103;
        return r6;
    L103:
        return r21;
    L105:
        return r6;
    L104:
        return r6;
    L68:
        if (com.larus.im.bean.message.a.l0(r8) == false) goto L95;
        r6 = ContextCompat.getString(AppHost.a.getApplication().getApplicationContext(), 2131910477);
        goto L95
    L63:
        if (r14.length() == 0) goto L66;
        r0 = false;
    L54:
        r17 = null;
        goto L55
    L39:
        if (ic8.q.a(r12) == true) goto L43;
        if (com.larus.im.bean.message.a.l0(r8) == false) goto L48;
    L43:
        if ((r13 instanceof jc8.j) == false) goto L45;
        jc8.j r110 = r13;
    L46:
        if (r110 == null) goto L48;
        r14 = r110.c();
        goto L49
    L45:
        r110 = null;
        goto L46
    L27:
        if (r6.length() == 0) goto L30;
        r7 = false;
    L24:
        r6 = null;
        goto L25
    L8:
        r5 = null;
    L13:
        if (r10 == null) goto L15;
        String r22 = r10.unfoldStreamingTitle;
    L17:
        if (com.larus.utils.o0.d(r22) == false) goto L20;
        if (r10 == null) goto L24;
        r6 = r10.unfoldStreamingTitle;
        goto L25
    L20:
        if (r10 == null) goto L24;
        MobileThinkingStreamFields r23 = r10.streamExtension;
        if (r23 == null) goto L24;
        r6 = r23.processingTitle;
        goto L25
    L15:
        r22 = null;
        goto L17
    L72:
        if (com.larus.im.bean.message.a.f0(r8) == false) goto L87;
        if (r10 == null) goto L75;
        r4 = r10.finishTitle;
    L75:
        FLogger.a.d("DeepThinkGenerateHelper", "generateLoadingTitle finishTitle=" + r4);
        if (r4 != null) goto L78;
    L81:
        if (r0 == true) goto L83;
        r6 = r4;
        goto L95
    L83:
        if (com.larus.im.bean.message.a.l0(r8) == false) goto L85;
        r6 = AppHost.a.getApplication().getString(2131909906);
        goto L95
    L85:
        r6 = AppHost.a.getApplication().getString(2131901490);
        goto L95
    L78:
        if (r4.length() == 0) goto L81;
        r0 = false;
        goto L81
    L87:
        FLogger r111 = FLogger.a;
        StringBuilder r112 = new StringBuilder("generateLoadingTitle loading_text=");
        Map r2 = r8.getExt();
        if (r2 == null) goto L90;
        r4 = (String) r2.get("loading_text");
    L90:
        r112.append(r4);
        r111.d("DeepThinkGenerateHelper", r112.toString());
        Map r113 = r8.getExt();
        if (r113 == null) goto L94;
        r6 = (String) r113.get("loading_text");
        if (r6 != null) goto L95;
    L94:
        r6 = AppHost.a.getApplication().getString(2131900977);
        goto L95
    }

    public static ib8.w0 b(po8.e r19, boolean r20, Message r21, String r22, String r23, String r24, ib8.c0 r25, DeepThinkFoldStatus r26, boolean r27) {
        Intrinsics.checkNotNullParameter(r26, "currentFoldStatus");
        if (r19 != null) goto L5;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == false) goto L13;
        float r12 = 90.0f;
    L14:
        if (r20 == false) goto L28;
        if (r19 == null) goto L25;
        DeepThinkFoldStatus r0 = r19.b;
        if (r0 != DeepThinkFoldStatus.CompleteExpand) goto L19;
    L22:
        boolean r1 = true;
    L23:
        if (r1 != true) goto L25;
        boolean r2 = true;
    L26:
        if (r2 == true) goto L28;
        boolean r8 = true;
    L29:
        String r3 = null;
        if (r25 == null) goto L32;
        Message r6 = r25.d;
    L33:
        if (r6 != null) goto L35;
    L37:
        boolean r7 = false;
    L38:
        if (r7 == false) goto L46;
        Set r9 = SetsKt.setOf(new String[]{"1", "true"});
        Map r10 = r6.getExt();
        if (r10 == null) goto L42;
        String r11 = (String) r10.get("need_lazy_load");
    L44:
        if (CollectionsKt.contains(r9, r11) == false) goto L46;
        boolean r13 = true;
    L47:
        if (r21 == null) goto L49;
        String r14 = r21.getBizContentType();
    L50:
        boolean r15 = Intrinsics.areEqual(r14, "deep_search_card");
        if (r22 == null) goto L53;
        String r16 = r22;
    L68:
        if (r22 != null) goto L76;
        if (r25 == null) goto L76;
        ib8.m r17 = r25.c;
        if (r17 == null) goto L76;
        Function1 r18 = r17.d;
        if (r18 == null) goto L76;
        List r110 = (List) r18.invoke(r26);
    L77:
        if (r23 == null) goto L79;
        String r111 = r23;
    L88:
        if (r25 == null) goto L102;
        Message r4 = r25.d;
        if (r4 == null) goto L102;
        if (com.larus.bmhome.chat.bean.d.f0(r4) == true) goto L95;
    L100:
        boolean r28 = false;
    L101:
        boolean r29 = !r28;
    L103:
        if (r29 == false) goto L106;
        if (r13 == true) goto L106;
        boolean r112 = true;
    L107:
        if (r13 == false) goto L110;
        if (r27 == false) goto L110;
        boolean r113 = true;
    L112:
        return new ib8.w0(r15, r8, r16, r110, r111, r12, r112, r113, 256);
    L110:
        r113 = false;
    L106:
        r112 = false;
        goto L107
    L95:
        if (r25.i != true) goto L97;
        boolean r30 = true;
    L98:
        if (r30 == false) goto L100;
        r28 = true;
        goto L101
    L97:
        r30 = false;
    L102:
        r29 = true;
        goto L103
    L79:
        if (r25 == null) goto L85;
        ib8.m r31 = r25.c;
        if (r31 == null) goto L85;
        Function1 r32 = r31.a;
        if (r32 == null) goto L85;
        r3 = (String) r32.invoke(r26);
    L85:
        if (r3 != null) goto L87;
        r3 = "";
    L87:
        r111 = r3;
    L76:
        r110 = null;
        goto L77
    L53:
        List r33 = StringsKt.split$default(r24, new String[]{"%s"}, false, 0, 6, null);
        if (r33 != null) goto L56;
    L58:
        boolean r34 = false;
    L59:
        if (r34 == true) goto L61;
        r16 = r24;
        goto L68
    L61:
        if (r25 == null) goto L65;
        ib8.m r35 = r25.c;
        if (r35 == null) goto L65;
        String r36 = r35.c;
    L66:
        r16 = StringsKt.replace$default(r24, "%s", String.valueOf(r36), false, 4, null);
    L65:
        r36 = null;
        goto L66
    L56:
        if (r33.size() != 2) goto L58;
        r34 = true;
        goto L59
    L49:
        r14 = null;
        goto L50
    L42:
        r11 = null;
    L46:
        r13 = false;
        goto L47
    L35:
        if (r6.getMessageStatusLocal() != 21) goto L37;
        r7 = true;
        goto L38
    L32:
        r6 = null;
        goto L33
    L19:
        if (r0 == DeepThinkFoldStatus.HalfFold) goto L22;
        r1 = false;
    L25:
        r2 = false;
    L28:
        r8 = false;
        goto L29
    L13:
        r12 = 0.0f;
        goto L14
    L5:
        if (r19.b != DeepThinkFoldStatus.CompleteExpand) goto L7;
        boolean r37 = true;
    L8:
        if (r37 != true) goto L10;
        r5 = true;
        goto L11
    L7:
        r37 = false;
        goto L8
    }

    public static ib8.c0 a(ib8.d0 r23, final boolean r24, final b r25, Boolean r26, final kc8.b r27, boolean r28, Long r29, DeepThinkFoldStatus r30, boolean r31, Integer r32, Integer r33, Integer r34, boolean r35) {
        Intrinsics.checkNotNullParameter(r25, "blockModel");
        Message r2 = r25.j();
        Block r3 = ((jc8.a) r25).a;
        boolean r10 = !Intrinsics.areEqual(Boolean.valueOf(com.larus.im.bean.message.a.f0(r2)), r26);
        Lazy r4 = qg8.b.a;
        if (r27 == null) goto L7;
        kc8.y r6 = r27.a;
        if (r6 == null) goto L7;
        com.larus.bmhome.chat.api.q0 r7 = r6.x;
    L9:
        if (r27 == null) goto L13;
        kc8.y r8 = r27.a;
        if (r8 == null) goto L13;
        boolean r12 = Intrinsics.areEqual(r8.g, Boolean.TRUE);
    L14:
        DeepThinkFoldStatus r9 = qg8.b.c(r2, r7, r28, r29, r10, r30, r12);
        ComplexTaskDelegate r11 = ComplexTaskDelegate.b;
        if (r11.f(r2) == false) goto L17;
        r9 = com.larus.bmhome.block.holder.deepthink.m.b(r11.g(com.larus.bmhome.block.holder.deepthink.m.a(r9), r2, r3));
    L17:
        BlockContent r5 = ((jc8.a) r25).a.getContent();
        if (r5 == null) goto L20;
        final ThinkingBlock r13 = r5.getThinkingBlock();
    L21:
        final List r14 = r25.i();
        Message r15 = r25.j();
        if (com.larus.bmhome.chat.bean.d.e0(r15) == false) goto L24;
    L28:
        boolean r16 = false;
    L29:
        if (r24 == true) goto L33;
        if (r16 == true) goto L33;
        boolean r17 = false;
    L35:
        if (r11.f(r15) == true) goto L37;
    L39:
        boolean r18 = false;
    L40:
        ib8.m r19 = new ib8.m(new v(r25, r24, r13, r14), new w(r25, r24, r13, r14), "", new x(r25, r14));
        Message r110 = r25.j();
        boolean r111 = r14.isEmpty();
        Message r20 = r25.j();
        if (com.larus.im.bean.message.a.l0(r20) == false) goto L73;
        List r21 = r20.getContentBlock();
        if (r21 == null) goto L71;
        Iterator r22 = r21.iterator();
    L47:
        if (r22.hasNext() == false) goto L69;
        Object r112 = r22.next();
        Block r113 = (Block) r112;
        BlockContent r114 = r113.getContent();
        if (r114 == null) goto L51;
        ArtifactBlock r115 = r114.getDocBlock();
    L52:
        if (r115 == null) goto L66;
        BlockContent r116 = r113.getContent();
        if (r116 == null) goto L63;
        ArtifactBlock r117 = r116.getDocBlock();
        if (r117 == null) goto L63;
        Integer r118 = r117.getResourceType();
        if (r118 == null) goto L63;
        if (r118.intValue() != 9) goto L63;
        boolean r36 = true;
    L64:
        if (r36 == false) goto L66;
        boolean r37 = true;
    L67:
        if (r37 == false) goto L47;
    L70:
        Block r119 = (Block) r112;
    L72:
        if (r119 == null) goto L73;
        boolean r38 = false;
    L75:
        if (r38 == true) goto L77;
    L105:
        boolean r120 = false;
    L106:
        ReferenceInfo r0 = r25.j().getReferenceInfo();
        if (r0 == null) goto L129;
        if (r27 == null) goto L123;
        kc8.y r39 = r27.a;
        if (r39 == null) goto L123;
        com.larus.bmhome.chat.api.q0 r40 = r39.x;
        if (r40 == null) goto L123;
        List<Message> r41 = r40.getCurrentList();
        if (r41 == null) goto L123;
        Iterator<T> r42 = r41.iterator();
    L117:
        if (r42.hasNext() == false) goto L121;
        Object r43 = r42.next();
        if (Intrinsics.areEqual(((Message) r43).getMessageId(), r0.referencedMessageId) == false) goto L117;
    L122:
        Message r44 = (Message) r43;
    L124:
        if (r44 == null) goto L126;
        boolean r45 = true;
    L127:
        if (r45 == false) goto L129;
        ReferenceInfo r46 = r0;
    L130:
        if (r46 == null) goto L132;
        boolean r121 = true;
    L133:
        if (r17 == false) goto L137;
        if (r18 == true) goto L137;
        boolean r122 = false;
    L138:
        if (r27 == null) goto L142;
        kc8.y r1 = r27.a;
        if (r1 == null) goto L142;
        boolean r210 = Intrinsics.areEqual(r1.g, Boolean.TRUE);
    L144:
        return new ib8.c0(r14, r23, r19, r110, r24, r9, null, false, r111, r120, false, new y(r27), r121, r122, r31, r32, r33, r34, r35, r210, 10626);
    L142:
        r210 = false;
    L137:
        r122 = true;
        goto L138
    L132:
        r121 = false;
        goto L133
    L126:
        r45 = false;
        goto L127
    L121:
        r43 = null;
    L123:
        r44 = null;
    L129:
        r46 = null;
        goto L130
    L77:
        if (((ArrayList) com.larus.im.bean.message.a.A(r20)).isEmpty() == false) goto L79;
    L104:
        r120 = true;
        goto L106
    L79:
        if (((ArrayList) com.larus.im.bean.message.a.h(r20)).isEmpty() == true) goto L104;
        if (ComplexTaskDelegate.b.f(r20) == false) goto L105;
        ArrayList r47 = (ArrayList) com.larus.im.bean.message.a.h(r20);
        if (r47.isEmpty() == true) goto L102;
        Iterator r48 = r47.iterator();
    L87:
        if (r48.hasNext() == false) goto L102;
        BlockContent r49 = ((Block) r48.next()).getContent();
        if (r49 == null) goto L93;
        TextBlock r50 = r49.getTextBlock();
        if (r50 == null) goto L93;
        String r51 = r50.text;
    L94:
        if (r51 != null) goto L96;
    L99:
        boolean r52 = true;
    L100:
        if (r52 == true) goto L87;
        boolean r53 = false;
    L103:
        if (r53 == false) goto L105;
    L96:
        if (r51.length() == 0) goto L99;
        r52 = false;
    L93:
        r51 = null;
    L102:
        r53 = true;
    L63:
        r36 = false;
    L66:
        r37 = false;
        goto L67
    L51:
        r115 = null;
        goto L52
    L69:
        r112 = null;
        goto L70
    L71:
        r119 = null;
    L73:
        r38 = true;
        goto L75
    L37:
        if (r11.b(r15, ((jc8.a) r25).a) == false) goto L39;
        r18 = true;
    L33:
        r17 = true;
        goto L35
    L24:
        if (r15.getMessageStatusLocal() != 23) goto L26;
    L27:
        r16 = true;
        goto L29
    L26:
        if (r15.getMessageStatusLocal() != 22) goto L28;
    L20:
        r13 = null;
    L13:
        r12 = false;
    L7:
        r7 = null;
        goto L9
    }
}
