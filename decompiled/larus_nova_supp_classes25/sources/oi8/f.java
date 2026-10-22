package oi8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.search.ArticleInfo;
import com.larus.bmhome.chat.search.CardType;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.bmhome.chat.search.SearchBoxStyle;
import com.larus.bmhome.chat.search.VideoInfo;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.ItemType;
import com.larus.im.bean.message.ItemData;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.platform.service.o;
import com.larus.utils.o0;
import java.util.Arrays;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[SearchBoxStyle.values().length];
            r0[SearchBoxStyle.doubleColumnVideo.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L32:
            r0[SearchBoxStyle.singleRowVideoNew.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L42:
            r0[SearchBoxStyle.doubleColumnImage.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L34:
            r0[SearchBoxStyle.doubleColumnMixedMedia.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L36:
            r0[SearchBoxStyle.singleRowTiny.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L26:
            r0[SearchBoxStyle.singleRowNormal.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L11:
            a = r0;
            int[] r1 = new int[DeepThinkFoldStatus.values().length];
            r1[DeepThinkFoldStatus.CompleteFold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L38:
            r1[DeepThinkFoldStatus.CompleteExpand.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L28:
            r1[DeepThinkFoldStatus.HalfFold.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L15:
            b = r1;
        }
    }

    static {
    }

    public f() {
    }

    public static String a(List r2) {
        if (r2 != null) goto L4;
        return "";
    L4:
        if (r2.size() != 2) goto L10;
        StringBuilder r0 = new StringBuilder();
        r0.append(ListProtector.get(r2, 0));
        r0.append(',');
        r0.append(ListProtector.get(r2, 1));
        return r0.toString();
    L10:
        return "";
    }

    public static String g(c r6) {
        if (i(r6) == false) goto L6;
        return "no_text";
    L6:
        int r0 = -1;
        if (r6 == null) goto L11;
        Integer r1 = r6.a();
        if (r1 == null) goto L11;
        int r2 = r1.intValue();
    L12:
        if (r6 == null) goto L17;
        Integer r7 = r6.b();
        if (r7 == null) goto L17;
        r0 = r7.intValue();
    L17:
        if (r2 != 1) goto L21;
        if (r0 != 1) goto L21;
        return "above_text";
    L21:
        if (r2 != 1) goto L25;
        if (r0 != 3) goto L25;
        return "below_text";
    L25:
        if (r2 != 2) goto L27;
        return "above_text";
    L27:
        if (r2 != 3) goto L30;
        return "below_text";
    L30:
        if (r2 != 4) goto L33;
        if (r0 != 1) goto L33;
        return "above_text";
    L33:
        if (r2 != 4) goto L36;
        if (r0 != 3) goto L36;
        return "below_text";
    L36:
        return "above_text";
    L11:
        r2 = -1;
        goto L12
    }

    public static boolean i(c r2) {
        if (r2 == null) goto L6;
        e r3 = r2.c();
        if (r3 == null) goto L6;
        Integer r4 = r3.a();
    L7:
        int r0 = CardType.Image.value;
        if (r4 != null) goto L11;
    L12:
        int r1 = CardType.Video.value;
        if (r4 != null) goto L16;
    L17:
        int r5 = CardType.MixedMedia.value;
        if (r4 != null) goto L21;
    L23:
        return false;
    L21:
        if (r4.intValue() != r5) goto L23;
    L24:
        return true;
    L16:
        if (r4.intValue() == r1) goto L24;
    L11:
        if (r4.intValue() == r0) goto L24;
    L6:
        r4 = null;
        goto L7
    }

    public static String d(ItemData r4, c r5) {
        if (i(r5) == false) goto L37;
        if (r5 == null) goto L8;
        e r0 = r5.c();
        if (r0 == null) goto L8;
        Integer r1 = r0.a();
    L9:
        int r2 = CardType.Video.value;
        if (r1 != null) goto L13;
    L15:
        int r3 = CardType.Image.value;
        if (r1 != null) goto L19;
    L22:
        int r6 = CardType.MixedMedia.value;
        if (r1 == null) goto L37;
        if (r1.intValue() != r6) goto L37;
        if ((r4 instanceof Content) == false) goto L37;
        Integer r7 = ((Content) r4).getItemType();
        int r8 = ItemType.VIDEO.getValue();
        if (r7 != null) goto L33;
    L35:
        return "graphic";
    L33:
        if (r7.intValue() != r8) goto L35;
        return "video";
    L19:
        if (r1.intValue() != r3) goto L22;
        return "picture";
    L13:
        if (r1.intValue() != r2) goto L15;
        return "video";
    L8:
        r1 = null;
    L37:
        int r9 = -1;
        if (r5 == null) goto L42;
        Integer r10 = r5.a();
        if (r10 == null) goto L42;
        int r11 = r10.intValue();
    L43:
        if (r5 == null) goto L48;
        Integer r12 = r5.b();
        if (r12 == null) goto L48;
        r9 = r12.intValue();
    L48:
        if ((r4 instanceof VideoInfo) == false) goto L50;
        return "video";
    L50:
        boolean r13 = r4 instanceof ArticleInfo;
        if (r13 == true) goto L53;
    L58:
        if (r13 == false) goto L61;
        return "link";
    L61:
        return "think_process";
    L53:
        if (r9 != 2) goto L58;
        if (r11 != 5) goto L58;
        return "pic";
    L42:
        r11 = -1;
        goto L43
    }

    public static String e(Boolean r1, Boolean r2) {
        Boolean r0 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r0) == true) goto L5;
        return "fold";
    L5:
        if (Intrinsics.areEqual(r2, r0) == false) goto L8;
        return "half_fold";
    L8:
        return "unfold";
    }

    public static String f(int r6, int r7) {
        if (r7 != 0) goto L5;
        return "0";
    L5:
        float r8 = r6 / r7;
        if ((((double) r8) % 1.0d) != 0.0d) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        return String.format("%.0f", Arrays.copyOf(new Object[]{Float.valueOf(r8)}, 1));
    L12:
        return StringsKt.trimEnd(StringsKt.trimEnd(String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r8)}, 1)), new char[]{'0'}), new char[]{'.'});
    L8:
        r0 = false;
        goto L9
    }

    public static String h(c r3, Message r4) {
        boolean r2 = true;
        if (i(r3) == true) goto L5;
        int r5 = -1;
        if (r3 == null) goto L25;
        Integer r0 = r3.a();
        if (r0 == null) goto L25;
        int r1 = r0.intValue();
    L26:
        if (r3 == null) goto L30;
        Integer r6 = r3.b();
        if (r6 == null) goto L30;
        r5 = r6.intValue();
    L30:
        if (r5 == 1) goto L32;
    L37:
        return "multiple_card";
    L32:
        if (r1 != 4) goto L34;
        return "think_process";
    L34:
        if (r1 != 5) goto L37;
        return "think_process";
    L25:
        r1 = -1;
        goto L26
    L5:
        if (com.larus.bmhome.chat.search.a.e(r4) == false) goto L18;
        if (r3 == null) goto L15;
        e r7 = r3.c();
        if (r7 == null) goto L15;
        Integer r8 = r7.a();
        int r9 = CardType.MixedMedia.value;
        if (r8 == null) goto L15;
        if (r8.intValue() != r9) goto L15;
    L16:
        if (r2 == true) goto L18;
        return "multiple_card";
    L15:
        r2 = false;
    L18:
        return "double_column";
    }

    public static String b(ItemData r1, Message r2, String r3) {
        if (Intrinsics.areEqual(r3, "think_process") == false) goto L7;
        return String.valueOf(r2.hashCode());
    L7:
        if (Intrinsics.areEqual(r3, "expert") == false) goto L11;
        return r2.getMessageId();
    L11:
        if ((r1 instanceof VideoInfo) == false) goto L15;
        return ((VideoInfo) r1).getCardId();
    L15:
        if ((r1 instanceof ArticleInfo) == false) goto L19;
        return ((ArticleInfo) r1).getCardId();
    L19:
        if ((r1 instanceof SearchImageInfo) == false) goto L26;
        Long r4 = ((SearchImageInfo) r1).getCardId();
        if (r4 != null) goto L31;
        return null;
    L31:
        return r4.toString();
    L26:
        if ((r1 instanceof Content) == true) goto L28;
        return "";
    L28:
        return ((Content) r1).getItemId();
    }

    public static String c(c r1, int r2, int r3) {
        SearchBoxStyle r4 = com.larus.bmhome.chat.search.a.b(r1, null);
        switch(a.a[r4.ordinal()]) {
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L6;
            case 6: goto L9;
            default: goto L5;
        };
    L6:
        return "half";
    L9:
        return "full";
    L5:
        throw new NoWhenBranchMatchedException();
    L13:
        return f(r2, r3);
    L14:
        return f(r2, r3);
    L11:
        return f(r2, r3);
    }

    public static void j(Message r16, ChatParam r17, int r18, int r19, ItemData r20, c r21, String r22, String r23, String r24, String r25, String r26, int r27, int r28, int r29) {
        if ((r29 & 16) == 0) goto L5;
        ItemData r3 = null;
    L7:
        if ((r29 & 32) == 0) goto L9;
        c r5 = new c(null, null, 15);
    L11:
        if ((r29 & 64) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r29 & 128) == 0) goto L17;
        String r8 = "";
    L19:
        if ((r29 & 256) == 0) goto L21;
        String r9 = "";
    L23:
        if ((r29 & 512) == 0) goto L25;
        String r10 = "";
    L27:
        if ((r29 & 1024) == 0) goto L29;
        String r11 = "";
    L31:
        if ((r29 & 2048) == 0) goto L33;
        int r12 = 0;
    L35:
        if ((r29 & 4096) == 0) goto L37;
        int r2 = 0;
    L38:
        Intrinsics.checkNotNullParameter(r16, "msg");
        Intrinsics.checkNotNullParameter(r6, "cardType");
        Intrinsics.checkNotNullParameter(r8, "clickEffect");
        Intrinsics.checkNotNullParameter(r9, "botId");
        Intrinsics.checkNotNullParameter(r10, "cardSize");
        Intrinsics.checkNotNullParameter(r11, "moduleType");
        o r14 = o.a;
        JSONObject r15 = new JSONObject();
        if (r17 == null) goto L41;
        String r13 = r17.d;
    L42:
        r15.put("current_page", r13);
        if (r17 == null) goto L45;
        String r1 = r17.c;
    L46:
        r15.put("previous_page", r1);
        r15.put("message_id", r16.getMessageId());
        r15.put("conversation_id", r16.getConversationId());
        r15.put("bot_id", r9);
        r15.put("chat_type", "default");
        r15.put("reply_id", r16.getReplyId());
        r15.put("module_position", g(r5));
        if (o0.d(r11) == false) goto L50;
    L53:
        r15.put("module_type", r11);
        r15.put("current_page", null);
        if (r3 == null) goto L59;
        String r4 = r3.getSearchId();
        if (r4 == null) goto L59;
        r15.put("search_id", r4);
    L59:
        if (Intrinsics.areEqual(r6, "expert") == true) goto L65;
        if (r3 == null) goto L62;
        String r7 = b(r3, r16, r6);
    L63:
        r15.put("card_id", r7);
        goto L65
    L62:
        r7 = null;
    L65:
        if (Intrinsics.areEqual(r6, "") == false) goto L68;
        if (r3 == null) goto L68;
        r6 = d(r3, r5);
    L68:
        r15.put("card_type", r6);
        r15.put("card_position", r18 + 1);
        if (r19 < 0) goto L72;
        r15.put("card_sub_position", r19 + 1);
    L72:
        if (o0.d(r10) == true) goto L75;
        r10 = c(r5, r12, r2);
    L75:
        r15.put("card_size", r10);
        if (o0.d(r8) == false) goto L78;
        VideoInfo r30 = null;
    L84:
        r15.put("click_effect", r8);
        if ((r3 instanceof VideoInfo) == false) goto L87;
        VideoInfo r31 = (VideoInfo) r3;
    L89:
        if (r31 == null) goto L91;
        r15.put("video_id", r31.getItemId());
    L91:
        r15.put("req_id", com.larus.bmhome.chat.bean.d.x(r16).getReqId());
        boolean r0 = r3 instanceof Content;
        if (r0 == false) goto L94;
        r15.put("module_source", "no_text_recommend");
        r15.put("content_type", "ugc");
    L96:
        if ((r3 instanceof SearchImageInfo) == false) goto L98;
        VideoInfo r32 = (SearchImageInfo) r3;
    L99:
        if (r32 == null) goto L111;
        Integer[] r33 = new Integer[2];
        Integer r34 = r32.getOriginWidth();
        if (r34 == null) goto L103;
        int r35 = r34.intValue();
    L104:
        r33[0] = Integer.valueOf(r35);
        Integer r36 = r32.getOriginHeight();
        if (r36 == null) goto L107;
        int r110 = r36.intValue();
    L108:
        r33[1] = Integer.valueOf(r110);
        r15.put("image_resolution", a(CollectionsKt.listOf(r33)));
        String r37 = r32.getDocId();
        if (r37 == null) goto L111;
        r15.put("doc_id", r37);
        goto L111
    L107:
        r110 = 0;
        goto L108
    L103:
        r35 = 0;
    L111:
        if (r0 == false) goto L113;
        VideoInfo r38 = (Content) r3;
    L114:
        if (r38 == null) goto L134;
        Integer r39 = r38.getItemType();
        ItemType r40 = ItemType.VIDEO;
        int r41 = r40.getValue();
        if (r39 != null) goto L119;
    L121:
        String r42 = "ugc_graphic";
    L122:
        r15.put("slidemode", r42);
        Integer r43 = r38.getItemType();
        int r44 = r40.getValue();
        if (r43 != null) goto L126;
    L128:
        Integer r45 = r38.getItemType();
        int r46 = ItemType.ARTICLE.getValue();
        if (r45 == null) goto L134;
        if (r45.intValue() != r46) goto L134;
        r15.put("graphic_id", r38.getItemId());
        goto L134
    L126:
        if (r43.intValue() != r44) goto L128;
        r15.put("video_id", r38.getItemId());
        goto L134
    L119:
        if (r39.intValue() != r41) goto L121;
        r42 = "ugc_video";
    L134:
        Unit r47 = Unit.INSTANCE;
        r14.reportEvent("click_card", r15);
        return;
    L113:
        r38 = r30;
        goto L114
    L98:
        r32 = r30;
        goto L99
    L94:
        r15.put("module_source", "no_text_normal");
        r15.put("content_type", "normal");
        goto L96
    L87:
        r31 = r30;
        goto L89
    L78:
        r30 = null;
        switch(a.a[com.larus.bmhome.chat.search.a.b(r5, null).ordinal()]) {
            case 1: goto L83;
            case 2: goto L83;
            case 3: goto L83;
            case 4: goto L83;
            case 5: goto L82;
            case 6: goto L82;
            default: goto L81;
        };
    L82:
        r8 = null;
        goto L84
    L83:
        r8 = "open_media";
        goto L84
    L81:
        throw new NoWhenBranchMatchedException();
    L50:
        if (Intrinsics.areEqual(r6, "") == true) goto L52;
        r11 = r6;
        goto L53
    L52:
        r11 = h(r5, r16);
        goto L53
    L45:
        r1 = null;
        goto L46
    L41:
        r13 = null;
        goto L42
    L37:
        r2 = r28;
        goto L38
    L33:
        r12 = r27;
        goto L35
    L29:
        r11 = r26;
        goto L31
    L25:
        r10 = r25;
        goto L27
    L21:
        r9 = r24;
        goto L23
    L17:
        r8 = r23;
        goto L19
    L13:
        r6 = r22;
        goto L15
    L9:
        r5 = r21;
        goto L11
    L5:
        r3 = r20;
        goto L7
    }

    public static void k(LruSet r16, Message r17, ChatParam r18, int r19, int r20, ItemData r21, c r22, String r23, String r24, String r25, String r26, int r27, int r28, String r29, int r30) {
        if ((r30 & 32) == 0) goto L5;
        ItemData r4 = null;
    L7:
        if ((r30 & 64) == 0) goto L9;
        c r6 = new c(null, null, 15);
    L11:
        if ((r30 & 128) == 0) goto L13;
        String r7 = "";
    L15:
        if ((r30 & 256) == 0) goto L17;
        String r9 = "";
    L19:
        if ((r30 & 512) == 0) goto L21;
        String r10 = "";
    L23:
        if ((r30 & 1024) == 0) goto L25;
        String r11 = "";
    L27:
        if ((r30 & 2048) == 0) goto L29;
        int r12 = 0;
    L31:
        if ((r30 & 4096) == 0) goto L33;
        int r14 = 0;
    L35:
        if ((r30 & 8192) == 0) goto L37;
        String r3 = null;
    L38:
        Intrinsics.checkNotNullParameter(r17, "msg");
        Intrinsics.checkNotNullParameter(r7, "cardType");
        Intrinsics.checkNotNullParameter(r9, "botId");
        Intrinsics.checkNotNullParameter(r10, "cardSize");
        Intrinsics.checkNotNullParameter(r11, "moduleType");
        if (r16 != null) goto L41;
    L43:
        boolean r5 = false;
    L44:
        if (r5 == true) goto L135;
        String r8 = b(r4, r17, r7);
        if (r8 == null) goto L50;
        if (r16 == null) goto L50;
        r16.add(r8);
    L50:
        o r0 = o.a;
        JSONObject r13 = new JSONObject();
        if (r18 == null) goto L53;
        String r15 = r18.d;
    L54:
        r13.put("current_page", r15);
        if (r18 == null) goto L57;
        String r2 = r18.c;
    L58:
        r13.put("previous_page", r2);
        r13.put("message_id", r17.getMessageId());
        r13.put("conversation_id", r17.getConversationId());
        r13.put("bot_id", r9);
        r13.put("chat_type", "default");
        r13.put("reply_id", r17.getReplyId());
        r13.put("module_position", g(r6));
        if (o0.d(r11) == false) goto L62;
    L65:
        r13.put("module_type", r11);
        if (r3 == null) goto L68;
        r13.put("doc_id", r3);
    L68:
        if (r4 == null) goto L73;
        String r31 = r4.getSearchId();
        if (r31 == null) goto L73;
        r13.put("search_id", r31);
    L73:
        if (Intrinsics.areEqual(r7, "expert") == true) goto L76;
        r13.put("card_id", b(r4, r17, r7));
    L76:
        if (Intrinsics.areEqual(r7, "") == false) goto L78;
        r7 = d(r4, r6);
    L78:
        r13.put("card_type", r7);
        r13.put("card_position", r19 + 1);
        if (r20 < 0) goto L81;
        r13.put("card_sub_position", r20 + 1);
    L81:
        boolean r32 = r4 instanceof Content;
        if (r32 == false) goto L84;
        r13.put("module_source", "no_text_recommend");
        r13.put("content_type", "ugc");
    L86:
        if (o0.d(r10) == true) goto L89;
        r10 = c(r6, r12, r14);
    L89:
        r13.put("card_size", r10);
        if ((r4 instanceof VideoInfo) == false) goto L92;
        VideoInfo r33 = (VideoInfo) r4;
    L94:
        if (r33 == null) goto L96;
        r13.put("video_id", r33.getItemId());
    L96:
        r13.put("req_id", com.larus.bmhome.chat.bean.d.x(r17).getReqId());
        if ((r4 instanceof SearchImageInfo) == false) goto L99;
        SearchImageInfo r1 = (SearchImageInfo) r4;
    L100:
        if (r1 == null) goto L110;
        Integer[] r34 = new Integer[2];
        Integer r35 = r1.getOriginWidth();
        if (r35 == null) goto L104;
        int r36 = r35.intValue();
    L105:
        r34[0] = Integer.valueOf(r36);
        Integer r37 = r1.getOriginHeight();
        if (r37 == null) goto L108;
        int r110 = r37.intValue();
    L109:
        r34[1] = Integer.valueOf(r110);
        r13.put("image_resolution", a(CollectionsKt.listOf(r34)));
        goto L110
    L108:
        r110 = 0;
        goto L109
    L104:
        r36 = 0;
    L110:
        if (r32 == false) goto L112;
        Content r38 = (Content) r4;
    L113:
        if (r38 == null) goto L133;
        Integer r39 = r38.getItemType();
        ItemType r40 = ItemType.VIDEO;
        int r41 = r40.getValue();
        if (r39 != null) goto L118;
    L120:
        String r42 = "ugc_graphic";
    L121:
        r13.put("slidemode", r42);
        Integer r43 = r38.getItemType();
        int r44 = r40.getValue();
        if (r43 != null) goto L125;
    L127:
        Integer r45 = r38.getItemType();
        int r46 = ItemType.ARTICLE.getValue();
        if (r45 == null) goto L133;
        if (r45.intValue() != r46) goto L133;
        r13.put("graphic_id", r38.getItemId());
        goto L133
    L125:
        if (r43.intValue() != r44) goto L127;
        r13.put("video_id", r38.getItemId());
        goto L133
    L118:
        if (r39.intValue() != r41) goto L120;
        r42 = "ugc_video";
    L133:
        Unit r47 = Unit.INSTANCE;
        r0.reportEvent("show_card", r13);
        return;
    L112:
        r38 = null;
        goto L113
    L99:
        r1 = null;
        goto L100
    L92:
        r33 = null;
        goto L94
    L84:
        r13.put("module_source", "no_text_normal");
        r13.put("content_type", "normal");
        goto L86
    L62:
        if (Intrinsics.areEqual(r7, "") == true) goto L64;
        r11 = r7;
        goto L65
    L64:
        r11 = h(r6, r17);
        goto L65
    L57:
        r2 = null;
        goto L58
    L53:
        r15 = null;
        goto L54
    L135:
        return;
    L41:
        if (CollectionsKt.contains(r16, b(r4, r17, r7)) != true) goto L43;
        r5 = true;
        goto L44
    L37:
        r3 = r29;
        goto L38
    L33:
        r14 = r28;
        goto L35
    L29:
        r12 = r27;
        goto L31
    L25:
        r11 = r26;
        goto L27
    L21:
        r10 = r25;
        goto L23
    L17:
        r9 = r24;
        goto L19
    L13:
        r7 = r23;
        goto L15
    L9:
        r6 = r22;
        goto L11
    L5:
        r4 = r21;
        goto L7
    }
}
