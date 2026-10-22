package com.larus.doc.impl.util;

import android.os.SystemClock;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.doc.sdk.api.VoiceInputFrom;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.im.bean.message.block.TextBlockScene;
import com.larus.utils.logger.FLogger;
import ic8.p0;
import ic8.q0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import vd9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DocUtils {
    public static final DocUtils a = null;
    public static final Regex b = null;
    public static final Lazy c = null;

    public DocUtils() {
    }

    static {
        a = new DocUtils();
        b = new Regex("!\\[[^\\]]*]\\([^)]+\\)");
        c = LazyKt.lazy(new a());
    }

    public static String a(Message r20) {
        Intrinsics.checkNotNullParameter(r20, "message");
        boolean r3 = true;
        if (r20.getContentType() == 800) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L24;
        p0 r0 = q0.a(r20);
        if (r0 == null) goto L199;
        p0.a r2 = r0.e();
        if (r2 == null) goto L202;
        String r4 = r2.e();
        if (r4 == null) goto L203;
        String r5 = r2.a();
        if (StringsKt.startsWith$default(r4, "# ", false, 2, null) == true) goto L200;
        r4 = "# ".concat(r4);
    L200:
        return r4 + '\n' + r5;
    L203:
        return "";
    L202:
        return "";
    L199:
        return "";
    L24:
        if (com.larus.im.bean.message.a.b0(r20) == false) goto L157;
        Intrinsics.checkNotNullParameter(r20, "<this>");
        List r6 = r.a(r20);
        if (r6.isEmpty() == true) goto L92;
        LinkedHashSet r7 = new LinkedHashSet();
        Iterator r8 = r6.iterator();
    L30:
        if (r8.hasNext() == false) goto L42;
        Block r9 = (Block) r8.next();
        String r10 = r9.getBlockId();
        if (r9.getBlockType() != BlockType.BLOCK_TYPE_DEEP_THINK.getValue()) goto L30;
        if (r10 != null) goto L35;
    L38:
        boolean r11 = true;
    L39:
        if (r11 == true) goto L30;
        r7.add(r10);
        goto L30
    L35:
        if (r10.length() == 0) goto L38;
        r11 = false;
        goto L39
    L42:
        if (r7.isEmpty() == true) goto L92;
        boolean r12 = true;
    L45:
        if (r12 == false) goto L71;
        Iterator r13 = r6.iterator();
        boolean r14 = false;
    L48:
        if (r13.hasNext() == false) goto L70;
        Block r15 = (Block) r13.next();
        String r16 = r15.getParentId();
        String r17 = r15.getBlockId();
        if (r16 != null) goto L52;
    L55:
        boolean r18 = true;
    L56:
        if (r18 == true) goto L48;
        if (r17 != null) goto L59;
    L62:
        boolean r110 = true;
    L63:
        if (r110 == true) goto L48;
        if (r7.contains(r16) == false) goto L48;
        if (r7.add(r17) == false) goto L48;
        r14 = true;
        goto L48
    L59:
        if (r17.length() == 0) goto L62;
        r110 = false;
        goto L63
    L52:
        if (r16.length() == 0) goto L55;
        r18 = false;
        goto L56
    L70:
        r12 = r14;
        goto L45
    L71:
        ArrayList r21 = new ArrayList();
        Iterator r22 = r6.iterator();
    L73:
        if (r22.hasNext() == false) goto L89;
        Object r23 = r22.next();
        String r111 = ((Block) r23).getBlockId();
        if (r111 != null) goto L77;
    L80:
        boolean r112 = true;
    L81:
        if (r112 == false) goto L83;
    L85:
        boolean r113 = false;
    L86:
        if (r113 == true) goto L73;
        r21.add(r23);
        goto L73
    L83:
        if (r7.contains(r111) == false) goto L85;
        r113 = true;
        goto L86
    L77:
        if (r111.length() == 0) goto L80;
        r112 = false;
        goto L81
    L89:
        if (r21.size() == r6.size()) goto L91;
        FLogger.a.i("DocUtils", "filterThinkingBlocksForOfflineDoc: filtered=" + (r6.size() - r21.size()) + ", total=" + r6.size());
    L91:
        r6 = r21;
    L92:
        List r24 = r6;
        Iterator r25 = r24.iterator();
    L94:
        if (r25.hasNext() == false) goto L105;
        Object r26 = r25.next();
        BlockContent r27 = ((Block) r26).getContent();
        if (r27 == null) goto L102;
        TextBlock r28 = r27.getTextBlock();
        if (r28 == null) goto L102;
        if (r28.scene != TextBlockScene.TEXT_BLOCK_AIDOC.getType()) goto L102;
        boolean r30 = true;
    L103:
        if (r30 == false) goto L94;
    L106:
        Block r31 = (Block) r26;
        if (r31 == null) goto L112;
        String r32 = qf8.a.a(r31, r20);
        if (r32 != null) goto L111;
        r32 = "";
    L111:
        String r33 = new Regex("\\n+").replace(r32, "\n");
    L149:
        if (r33.length() == 0) goto L152;
        r3 = false;
    L152:
        if (r3 == false) goto L201;
        String r34 = d.H(r20);
        if (r34 != null) goto L161;
        return "";
    L161:
        return r34;
    L201:
        return r33;
    L112:
        ArrayList r35 = new ArrayList();
        Iterator r36 = r24.iterator();
    L114:
        if (r36.hasNext() == false) goto L121;
        Object r37 = r36.next();
        if (((Block) r37).getBlockType() != BlockType.BLOCK_TYPE_TEXT.getValue()) goto L118;
        boolean r114 = true;
    L119:
        if (r114 == false) goto L114;
        r35.add(r37);
        goto L114
    L118:
        r114 = false;
        goto L119
    L121:
        ArrayList r115 = new ArrayList();
        Iterator r38 = r35.iterator();
        int r40 = 0;
    L123:
        if (r38.hasNext() == false) goto L147;
        Object r41 = r38.next();
        int r116 = r40 + 1;
        if (r40 >= 0) goto L127;
        CollectionsKt.throwIndexOverflow();
    L127:
        Block r42 = (Block) r41;
        if (r40 != 0) goto L130;
        String r43 = qf8.a.a(r42, r20);
    L136:
        if (r43 != null) goto L138;
    L143:
        r43 = null;
    L144:
        if (r43 == null) goto L146;
        r115.add(r43);
    L146:
        r40 = r116;
        goto L123
    L138:
        if (r43.length() <= 0) goto L140;
        boolean r44 = true;
    L141:
        if (r44 == false) goto L143;
    L140:
        r44 = false;
        goto L141
    L130:
        BlockContent r45 = r42.getContent();
        if (r45 == null) goto L135;
        TextBlock r46 = r45.getTextBlock();
        if (r46 == null) goto L135;
        r43 = r46.text;
    L135:
        r43 = null;
        goto L136
    L147:
        r33 = new Regex("\\n+").replace(CollectionsKt.joinToString$default(r115, "", null, null, 0, null, null, 62, null), "\n");
    L102:
        r30 = false;
        goto L103
    L105:
        r26 = null;
        goto L106
    L157:
        r34 = d.H(r20);
        if (r34 != null) goto L161;
        return "";
    L5:
        if (Intrinsics.areEqual(r20.getBizContentType(), "dora_record") == false) goto L7;
        r1 = true;
        goto L9
    }

    public static String c(String r1) {
        if (r1 != null) goto L4;
    L21:
        return "chat";
    L4:
        switch(r1.hashCode()) {
            case -1140332614: goto L19;
            case 50910586: goto L15;
            case 1506620522: goto L11;
            case 1571879921: goto L7;
            default: goto L21;
        };
    L7:
        if (r1.equals("doc_create_empty") == false) goto L21;
        return VoiceInputFrom.NEW_DOC;
    L11:
        if (r1.equals("doc_exist_content") == false) goto L21;
        return "existing_doc";
    L15:
        if (r1.equals("doc_create_list") == false) goto L21;
        return "doc_manage";
    L19:
        if (r1.equals("doc_ai_edit") == false) goto L21;
        return "basic_edit_left_icon";
    }

    public final Object b(String r12, String r13, Continuation<? super String> r14) {
        if ((r14 instanceof DocUtils$getMessageMarkdownContent$1) == false) goto L7;
        DocUtils$getMessageMarkdownContent$1 r0 = (DocUtils$getMessageMarkdownContent$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r16 = r0.J$1;
        long r4 = r0.J$0;
        String r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L31:
        Message r17 = (Message) r15;
        long r7 = SystemClock.elapsedRealtime() - r16;
        if (r17 != null) goto L35;
        FLogger.a.i("DocUtils", "getMessageMarkdownContent: message not found, messageId=" + r5 + ", findCost=" + r7 + "ms, totalCost=" + (SystemClock.elapsedRealtime() - r4) + "ms");
        return null;
    L35:
        long r6 = SystemClock.elapsedRealtime();
        String r18 = a(r17);
        long r9 = SystemClock.elapsedRealtime() - r6;
        FLogger.a.i("DocUtils", "getMessageMarkdownContent: messageId=" + r5 + ", findCost=" + r7 + "ms, convertCost=" + r9 + "ms, totalCost=" + (SystemClock.elapsedRealtime() - r4) + "ms, contentLen=" + r18.length());
        return r18;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        long r8 = SystemClock.elapsedRealtime();
        if (Intrinsics.areEqual(r12, "fake_offline_doc_id") == true) goto L18;
        FLogger.a.i("DocUtils", "getMessageMarkdownContent: skip, not offline doc, cost=" + (SystemClock.elapsedRealtime() - r8) + "ms");
        return null;
    L18:
        if (r13 != null) goto L20;
    L23:
        boolean r110 = true;
    L24:
        if (r110 == false) goto L27;
        FLogger.a.i("DocUtils", "getMessageMarkdownContent: skip, messageId empty, cost=" + (SystemClock.elapsedRealtime() - r8) + "ms");
        return null;
    L27:
        long r10 = SystemClock.elapsedRealtime();
        IChatRepoService r111 = zh8.a.a;
        r0.L$0 = r13;
        r0.J$0 = r8;
        r0.J$1 = r10;
        r0.label = 1;
        r15 = r111.E1(r13, r0);
        if (r15 != r2) goto L30;
        return r2;
    L30:
        r5 = r13;
        r4 = r8;
        r16 = r10;
        goto L31
    L20:
        if (r13.length() == 0) goto L23;
        r110 = false;
    L7:
        r0 = new DocUtils$getMessageMarkdownContent$1(this, r14);
        goto L8
    }
}
