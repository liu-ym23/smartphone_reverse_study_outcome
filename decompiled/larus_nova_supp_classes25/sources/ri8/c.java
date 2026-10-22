package ri8;

import android.text.Spanned;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import oi8.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final c a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[SearchBoxStyle.values().length];
            r0[SearchBoxStyle.doubleColumnVideo.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L61:
            r0[SearchBoxStyle.singleRowVideoNew.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L65:
            r0[SearchBoxStyle.doubleColumnImage.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L45:
            r0[SearchBoxStyle.doubleColumnMixedMedia.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L47:
            r0[SearchBoxStyle.singleRowTiny.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L55:
            r0[SearchBoxStyle.singleRowNormal.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L13:
            a = r0;
            int[] r1 = new int[DeepThinkFoldStatus.values().length];
            r1[DeepThinkFoldStatus.CompleteFold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L31
        L49:
            r1[DeepThinkFoldStatus.CompleteExpand.ordinal()] = 2;     // Catch: NoSuchFieldError -> L32
        L57:
            r1[DeepThinkFoldStatus.HalfFold.ordinal()] = 3;     // Catch: NoSuchFieldError -> L33
        L17:
            b = r1;
            int[] r2 = new int[CardType.values().length];
            r2[CardType.Video.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L51:
            r2[CardType.Image.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L59:
            r2[CardType.MixedMedia.ordinal()] = 3;     // Catch: NoSuchFieldError -> L36
        L63:
            r2[CardType.Unknown.ordinal()] = 4;     // Catch: NoSuchFieldError -> L37
        L41:
            r2[CardType.Text.ordinal()] = 5;     // Catch: NoSuchFieldError -> L38
        L23:
            c = r2;
        }
    }

    static {
        a = new c();
    }

    public c() {
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

    public static String f(DeepThinkFoldStatus r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r2 = a.b[r1.ordinal()];
        if (r2 != 1) goto L5;
        return "fold";
    L5:
        if (r2 != 2) goto L7;
        return "unfold";
    L7:
        if (r2 != 3) goto L10;
        return "half_fold";
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static String g(Boolean r1) {
        Boolean r0 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r0) == true) goto L5;
        return "fold";
    L5:
        if (Intrinsics.areEqual(null, r0) == false) goto L7;
        return "half_fold";
    L7:
        return "unfold";
    }

    public static String i(oi8.c r6) {
        if (l(r6) == false) goto L6;
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

    public static boolean l(oi8.c r2) {
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

    public static SearchBoxStyle b(c r9, oi8.c r10) {
        r9.getClass();
        SearchBoxStyle r11 = null;
        if (r10 == null) goto L5;
        e r0 = r10.c();
    L6:
        int r1 = 0;
        if (r0 == null) goto L31;
        CardType.a r7 = CardType.Companion;
        Integer r2 = r0.a();
        if (r2 == null) goto L11;
        int r3 = r2.intValue();
    L12:
        r7.getClass();
        CardType r4 = CardType.a.a(r3);
        if (r4 != null) goto L15;
        int r5 = -1;
    L16:
        if (r5 == (-1)) goto L31;
        if (r5 == 1) goto L28;
        if (r5 == 2) goto L26;
        if (r5 == 3) goto L25;
        if (r5 == 4) goto L31;
        if (r5 == 5) goto L31;
        throw new NoWhenBranchMatchedException();
    L25:
        r11 = SearchBoxStyle.doubleColumnMixedMedia;
        goto L31
    L26:
        r11 = SearchBoxStyle.doubleColumnImage;
        goto L31
    L28:
        if (Intrinsics.areEqual(null, "1") == false) goto L30;
        r11 = SearchBoxStyle.singleRowVideoNew;
        goto L31
    L30:
        r11 = SearchBoxStyle.doubleColumnVideo;
        goto L31
    L15:
        r5 = a.c[r4.ordinal()];
        goto L16
    L11:
        r3 = 0;
    L31:
        if (r11 != null) goto L76;
        if (r10 == null) goto L37;
        Integer r12 = r10.a();
        if (r12 == null) goto L37;
        r1 = r12.intValue();
    L37:
        if (r10 == null) goto L41;
        Integer r13 = r10.b();
        if (r13 == null) goto L41;
        int r14 = r13.intValue();
    L42:
        if (r1 != 1) goto L45;
        if (r14 != 1) goto L45;
        return SearchBoxStyle.singleRowTiny;
    L45:
        if (r1 != 1) goto L48;
        if (r14 != 3) goto L48;
        return SearchBoxStyle.singleRowNormal;
    L48:
        if (r1 != 2) goto L51;
        if (r14 != 1) goto L51;
        return SearchBoxStyle.singleRowTiny;
    L51:
        if (r1 != 3) goto L54;
        if (r14 != 2) goto L54;
        return SearchBoxStyle.singleRowNormal;
    L54:
        if (r1 != 4) goto L57;
        if (r14 != 1) goto L57;
        return SearchBoxStyle.singleRowTiny;
    L57:
        if (r1 != 4) goto L60;
        if (r14 != 3) goto L60;
        return SearchBoxStyle.singleRowNormal;
    L60:
        if (r1 != 5) goto L63;
        if (r14 != 1) goto L63;
        return SearchBoxStyle.singleRowTiny;
    L63:
        if (r1 != 5) goto L67;
        if (r14 != 2) goto L67;
        return SearchBoxStyle.singleRowTiny;
    L67:
        return SearchBoxStyle.singleRowNormal;
    L41:
        r14 = 1;
        goto L42
    L76:
        return r11;
    L5:
        r0 = null;
        goto L6
    }

    public static String e(ItemData r4, oi8.c r5) {
        if (l(r5) == false) goto L37;
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

    public static String h(int r6, int r7) {
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

    public static String j(oi8.c r3, Message r4) {
        boolean r2 = true;
        if (l(r3) == false) goto L25;
        if (r4 == null) goto L8;
        Map r5 = r4.getExt();
        if (r5 == null) goto L8;
        String r6 = (String) r5.get("video_as_ref");
    L10:
        if (Intrinsics.areEqual(r6, "1") == false) goto L23;
        if (r3 == null) goto L20;
        e r7 = r3.c();
        if (r7 == null) goto L20;
        Integer r8 = r7.a();
        int r9 = CardType.MixedMedia.value;
        if (r8 == null) goto L20;
        if (r8.intValue() != r9) goto L20;
    L21:
        if (r2 == true) goto L23;
        return "multiple_card";
    L20:
        r2 = false;
    L23:
        return "double_column";
    L8:
        r6 = null;
        goto L10
    L25:
        int r10 = -1;
        if (r3 == null) goto L30;
        Integer r0 = r3.a();
        if (r0 == null) goto L30;
        int r1 = r0.intValue();
    L31:
        if (r3 == null) goto L35;
        Integer r11 = r3.b();
        if (r11 == null) goto L35;
        r10 = r11.intValue();
    L35:
        if (r10 == 1) goto L37;
    L42:
        return "multiple_card";
    L37:
        if (r1 != 4) goto L39;
        return "think_process";
    L39:
        if (r1 != 5) goto L42;
        return "think_process";
    L30:
        r1 = -1;
        goto L31
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [ri8.a] */
    public static Integer k(final Spanned r9, usc.e r10) {
        if (r9 != null) goto L5;
        return null;
    L5:
        if (r10 != null) goto L7;
        return null;
    L7:
        boolean r1 = false;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L16
        Object[] r3 = r9.getSpans(0, r9.length(), usc.e.class);     // Catch: Throwable -> L16
        ArrayList r4 = new ArrayList();     // Catch: Throwable -> L16
        int r5 = r3.length;     // Catch: Throwable -> L16
        int r6 = 0;
    L9:
        if (r6 >= r5) goto L14;
        Object r7 = r3[r6];     // Catch: Throwable -> L16
        if (Intrinsics.areEqual(((usc.e) r7).getDataType(), r10.getDataType()) == false) goto L13;
        r4.add(r7);     // Catch: Throwable -> L16
    L13:
        r6 = r6 + 1;     // Catch: Throwable -> L16
        goto L9
    L14:
        final ?? r8 = new ri8.a(r9);     // Catch: Throwable -> L16
        Object r11 = Result.constructor-impl(CollectionsKt.sortedWith(r4, new b(r8)));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r11) == false) goto L21;
        r11 = null;
    L21:
        List r12 = (List) r11;
        List r13 = r12;
        if (r13 != null) goto L24;
    L25:
        r1 = true;
    L26:
        if (r1 == false) goto L45;
        return null;
    L45:
        Object r14 = Result.constructor-impl(Integer.valueOf(r12.indexOf(r10)));     // Catch: Throwable -> L30
    L33:
        if (Result.isFailure-impl(r14) == false) goto L35;
        r14 = null;
    L35:
        Integer r15 = (Integer) r14;
        if (r15 != null) goto L38;
    L42:
        return null;
    L38:
        if (r15.intValue() < 0) goto L42;
        return Integer.valueOf(r15.intValue() + 1);
    L30:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    L24:
        if (r13.isEmpty() == false) goto L26;
    L16:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }

    public static String c(ItemData r1, Message r2, String r3) {
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

    public final String d(oi8.c r2, int r3, int r4) {
        SearchBoxStyle r5 = b(this, r2);
        switch(a.a[r5.ordinal()]) {
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
        return h(r3, r4);
    L14:
        return h(r3, r4);
    L11:
        return h(r3, r4);
    }

    public static void p(Message r8, ChatParam r9, int r10, oi8.c r11, String r12, int r13, int r14, int r15) {
        if ((r15 & 64) == 0) goto L6;
        r11 = new oi8.c(null, null, 15);
    L6:
        if ((r15 & 128) == 0) goto L9;
        r12 = "";
    L9:
        if ((r15 & 256) == 0) goto L11;
        Object r0 = "";
    L13:
        if ((r15 & 512) == 0) goto L15;
        String r3 = "";
    L17:
        if ((r15 & 1024) == 0) goto L19;
        String r4 = "";
    L21:
        if ((r15 & 2048) == 0) goto L24;
        r13 = 0;
    L24:
        if ((r15 & 4096) == 0) goto L26;
        r14 = 0;
    L26:
        Intrinsics.checkNotNullParameter(r8, "msg");
        Intrinsics.checkNotNullParameter(r12, "cardType");
        Intrinsics.checkNotNullParameter(r0, "botId");
        Intrinsics.checkNotNullParameter(r3, "cardSize");
        Intrinsics.checkNotNullParameter(r4, "moduleType");
        c(null, r8, r12);
        o r16 = o.a;
        JSONObject r5 = new JSONObject();
        r5.put("current_page", r9.d);
        r5.put("previous_page", r9.c);
        r5.put("message_id", r8.getMessageId());
        r5.put("conversation_id", r8.getConversationId());
        r5.put("bot_id", r0);
        r5.put("chat_type", "default");
        r5.put("reply_id", r8.getReplyId());
        c r17 = a;
        r5.put("module_position", i(r11));
        if (o0.d(r4) == false) goto L30;
    L33:
        r5.put("module_type", r4);
        if (Intrinsics.areEqual(r12, "expert") == true) goto L37;
        r5.put("card_id", c(null, r8, r12));
    L37:
        if (Intrinsics.areEqual(r12, "") == false) goto L39;
        r12 = e(null, r11);
    L39:
        r5.put("card_type", r12);
        r5.put("card_position", r10 + 1);
        r5.put("module_source", "no_text_normal");
        r5.put("content_type", "normal");
        if (o0.d(r3) == true) goto L43;
        r3 = r17.d(r11, r13, r14);
    L43:
        r5.put("card_size", r3);
        r5.put("req_id", com.larus.bmhome.chat.bean.d.x(r8).getReqId());
        Unit r18 = Unit.INSTANCE;
        r16.reportEvent("show_card", r5);
        return;
    L30:
        if (Intrinsics.areEqual(r12, "") == true) goto L32;
        r4 = r12;
        goto L33
    L32:
        r4 = j(r11, r8);
        goto L33
    L19:
        r4 = null;
        goto L21
    L15:
        r3 = null;
        goto L17
    L11:
        r0 = null;
        goto L13
    }

    public static void o(Message r17, int r18, VideoInfo r19, oi8.c r20, String r21, String r22, int r23, int r24, String r25, int r26) {
        if ((r26 & 16) == 0) goto L5;
        VideoInfo r2 = null;
    L7:
        if ((r26 & 32) == 0) goto L9;
        oi8.c r4 = new oi8.c(null, null, 15);
    L11:
        if ((r26 & 64) == 0) goto L13;
        String r5 = "";
    L15:
        if ((r26 & 128) == 0) goto L17;
        String r7 = "";
    L19:
        if ((r26 & 256) == 0) goto L21;
        String r8 = "";
    L23:
        if ((r26 & 512) == 0) goto L25;
        String r9 = "";
    L27:
        if ((r26 & 1024) == 0) goto L29;
        String r10 = "";
    L31:
        if ((r26 & 2048) == 0) goto L33;
        int r11 = 0;
    L35:
        if ((r26 & 4096) == 0) goto L37;
        int r13 = 0;
    L39:
        if ((r26 & 8192) == 0) goto L41;
        String r1 = null;
    L42:
        Intrinsics.checkNotNullParameter(r17, "msg");
        Intrinsics.checkNotNullParameter(r5, "cardType");
        Intrinsics.checkNotNullParameter(r7, "clickEffect");
        Intrinsics.checkNotNullParameter(r8, "botId");
        Intrinsics.checkNotNullParameter(r9, "cardSize");
        Intrinsics.checkNotNullParameter(r10, "moduleType");
        o r14 = o.a;
        JSONObject r15 = new JSONObject();
        r15.put("current_page", null);
        r15.put("previous_page", null);
        r15.put("message_id", r17.getMessageId());
        r15.put("conversation_id", r17.getConversationId());
        r15.put("bot_id", r8);
        r15.put("chat_type", "default");
        r15.put("reply_id", r17.getReplyId());
        c r3 = a;
        r15.put("module_position", i(r4));
        if (o0.d(r10) == false) goto L46;
    L49:
        r15.put("module_type", r10);
        r15.put("current_page", r1);
        if (r2 == null) goto L55;
        String r6 = r2.getSearchId();
        if (r6 == null) goto L55;
        r15.put("search_id", r6);
    L55:
        if (Intrinsics.areEqual(r5, "expert") == true) goto L61;
        if (r2 == null) goto L58;
        String r12 = c(r2, r17, r5);
    L59:
        r15.put("card_id", r12);
        goto L61
    L58:
        r12 = null;
    L61:
        if (Intrinsics.areEqual(r5, "") == false) goto L64;
        if (r2 == null) goto L64;
        r5 = e(r2, r4);
    L64:
        r15.put("card_type", r5);
        r15.put("click_effect", r7);
        r15.put("card_position", r18 + 1);
        if (o0.d(r9) == true) goto L68;
        r9 = r3.d(r4, r11, r13);
    L68:
        r15.put("card_size", r9);
        if (o0.d(r7) == false) goto L72;
    L77:
        r15.put("click_effect", r7);
        if ((r2 instanceof VideoInfo) == false) goto L80;
        VideoInfo r16 = r2;
    L82:
        if (r16 == null) goto L84;
        r15.put("video_id", r16.getItemId());
    L84:
        r15.put("req_id", com.larus.bmhome.chat.bean.d.x(r17).getReqId());
        boolean r0 = r2 instanceof Content;
        if (r0 == false) goto L87;
        r15.put("module_source", "no_text_recommend");
        r15.put("content_type", "ugc");
    L89:
        if ((r2 instanceof SearchImageInfo) == false) goto L91;
        SearchImageInfo r27 = (SearchImageInfo) r2;
    L92:
        if (r27 == null) goto L104;
        Integer[] r28 = new Integer[2];
        Integer r29 = r27.getOriginWidth();
        if (r29 == null) goto L96;
        int r30 = r29.intValue();
    L97:
        r28[0] = Integer.valueOf(r30);
        Integer r31 = r27.getOriginHeight();
        if (r31 == null) goto L100;
        int r110 = r31.intValue();
    L101:
        r28[1] = Integer.valueOf(r110);
        r15.put("image_resolution", a(CollectionsKt.listOf(r28)));
        String r32 = r27.getDocId();
        if (r32 == null) goto L104;
        r15.put("doc_id", r32);
        goto L104
    L100:
        r110 = 0;
        goto L101
    L96:
        r30 = 0;
    L104:
        if (r0 == false) goto L106;
        Content r111 = (Content) r2;
    L107:
        if (r111 == null) goto L127;
        Integer r33 = r111.getItemType();
        ItemType r34 = ItemType.VIDEO;
        int r35 = r34.getValue();
        if (r33 != null) goto L112;
    L114:
        String r36 = "ugc_graphic";
    L115:
        r15.put("slidemode", r36);
        Integer r37 = r111.getItemType();
        int r38 = r34.getValue();
        if (r37 != null) goto L119;
    L121:
        Integer r39 = r111.getItemType();
        int r40 = ItemType.ARTICLE.getValue();
        if (r39 == null) goto L127;
        if (r39.intValue() != r40) goto L127;
        r15.put("graphic_id", r111.getItemId());
        goto L127
    L119:
        if (r37.intValue() != r38) goto L121;
        r15.put("video_id", r111.getItemId());
        goto L127
    L112:
        if (r33.intValue() != r35) goto L114;
        r36 = "ugc_video";
    L127:
        Unit r41 = Unit.INSTANCE;
        r14.reportEvent("click_card", r15);
        return;
    L106:
        r111 = null;
        goto L107
    L91:
        r27 = null;
        goto L92
    L87:
        r15.put("module_source", "no_text_normal");
        r15.put("content_type", "normal");
        goto L89
    L80:
        r16 = null;
        goto L82
    L72:
        switch(a.a[b(r3, r4).ordinal()]) {
            case 1: goto L76;
            case 2: goto L76;
            case 3: goto L76;
            case 4: goto L76;
            case 5: goto L75;
            case 6: goto L75;
            default: goto L74;
        };
    L75:
        r7 = null;
        goto L77
    L76:
        r7 = "open_media";
        goto L77
    L74:
        throw new NoWhenBranchMatchedException();
    L46:
        if (Intrinsics.areEqual(r5, "") == true) goto L48;
        r10 = r5;
        goto L49
    L48:
        r10 = j(r4, r17);
        goto L49
    L41:
        r1 = r25;
        goto L42
    L37:
        r13 = r24;
        goto L39
    L33:
        r11 = r23;
        goto L35
    L29:
        r10 = null;
        goto L31
    L25:
        r9 = null;
        goto L27
    L21:
        r8 = r22;
        goto L23
    L17:
        r7 = null;
        goto L19
    L13:
        r5 = r21;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = r19;
        goto L7
    }

    public static void m(String r39, String r40, String r41, String r42, String r43, String r44, Integer r45, Integer r46, String r47, String r48, String r49, String r50, String r51, String r52, String r53, String r54, Integer r55, String r56, String r57, String r58, String r59, List r60, String r61, String r62, String r63, String r64, String r65, String r66, String r67, String r68, String r69, String r70, String r71, String r72, String r73, Function0 r74, String r75, Integer r76, int r77, int r78) {
        if ((r77 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r77 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r77 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r77 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r77 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r77 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r77 & 64) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r77 & 128) == 0) goto L33;
        Integer r9 = null;
    L35:
        if ((r77 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r77 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r77 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r77 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r77 & 4096) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r77 & 8192) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r77 & 16384) == 0) goto L61;
        String r2 = null;
    L63:
        if ((r77 & 32768) == 0) goto L65;
        String r16 = null;
    L67:
        if ((r77 & 65536) == 0) goto L69;
        Integer r19 = null;
    L71:
        if ((r77 & 131072) == 0) goto L73;
        String r20 = null;
    L75:
        if ((r77 & 262144) == 0) goto L77;
        String r21 = null;
    L79:
        if ((r77 & 524288) == 0) goto L81;
        String r22 = null;
    L83:
        if ((r77 & 1048576) == 0) goto L85;
        String r23 = null;
    L87:
        if ((r77 & 2097152) == 0) goto L89;
        List r18 = null;
    L91:
        if ((r77 & 4194304) == 0) goto L93;
        String r25 = "normal";
    L95:
        if ((r77 & 8388608) == 0) goto L97;
        String r26 = null;
    L99:
        if ((r77 & 16777216) == 0) goto L101;
        String r27 = null;
    L103:
        if ((r77 & 33554432) == 0) goto L105;
        String r28 = null;
    L107:
        if ((r77 & 67108864) == 0) goto L109;
        String r29 = null;
    L111:
        if ((r77 & 134217728) == 0) goto L113;
        String r30 = null;
    L115:
        if ((r77 & 268435456) == 0) goto L117;
        String r31 = null;
    L119:
        if ((r77 & 536870912) == 0) goto L121;
        String r32 = null;
    L123:
        if ((r77 & 1073741824) == 0) goto L125;
        String r33 = null;
    L127:
        if ((r77 & Integer.MIN_VALUE) == 0) goto L129;
        String r0 = null;
    L130:
        String r310 = r0;
        if ((r78 & 1) == 0) goto L133;
        String r17 = null;
    L135:
        if ((r78 & 2) == 0) goto L137;
        String r34 = null;
    L139:
        if ((r78 & 4) == 0) goto L141;
        String r35 = null;
    L143:
        if ((r78 & 8) == 0) goto L145;
        Function0 r24 = null;
    L147:
        if ((r78 & 16) == 0) goto L149;
        String r37 = null;
    L151:
        if ((r78 & 32) == 0) goto L153;
        Integer r38 = null;
    L154:
        o r36 = o.a;
        JSONObject r79 = new JSONObject();
        r79.putOpt("current_page", r6);
        r79.putOpt("previous_page", r7);
        r79.putOpt("message_id", r3);
        r79.putOpt("conversation_id", r4);
        r79.putOpt("bot_id", r13);
        r79.putOpt("chat_type", "default");
        r79.putOpt("reply_id", r5);
        r79.putOpt("module_position", r11);
        r79.putOpt("module_type", r15);
        r79.putOpt("card_id", r1);
        r79.putOpt("card_type", r12);
        r79.putOpt("card_position", r8);
        r79.putOpt("card_sub_position", r9);
        r79.putOpt("card_size", r14);
        r79.putOpt("click_effect", r2);
        r79.putOpt("pic_id", r16);
        r79.putOpt("module_order", r19);
        r79.putOpt("video_id", r20);
        r79.putOpt("req_id", r21);
        r79.putOpt("graphic_id", r23);
        r79.putOpt("slidemode", r22);
        r79.putOpt("module_source", r10);
        r79.putOpt("image_resolution", a(r18));
        r79.putOpt("content_type", r25);
        r79.putOpt("deep_research_id", r26);
        r79.putOpt("dr_process_detail", r27);
        r79.putOpt("search_intention", r28);
        r79.putOpt("agent_id", r29);
        r79.putOpt("agent_tool", r30);
        r79.putOpt("tool_name", r31);
        r79.putOpt("chat_type", r32);
        r79.putOpt("memory_status", r33);
        r79.putOpt("code_type", r17);
        r79.putOpt("jump_type", r38);
        r79.putOpt("click_position", r34);
        r79.putOpt("search_id", r37);
        if (r310 == null) goto L157;
        r79.put("doc_id", r310);
    L157:
        if (r24 == null) goto L164;
        Map r80 = (Map) r24.invoke();
        if (r80 == null) goto L164;
        Iterator r81 = r80.entrySet().iterator();
    L162:
        if (r81.hasNext() == false) goto L164;
        Map.Entry r82 = (Map.Entry) r81.next();
        r79.put((String) r82.getKey(), r82.getValue());
    L164:
        String r83 = r35;
        if (r83 == null) goto L167;
        r79.put("host_enter_from", r83);
    L167:
        Unit r84 = Unit.INSTANCE;
        r36.reportEvent("click_card", r79);
        return;
    L153:
        r38 = r76;
        goto L154
    L149:
        r37 = r75;
        goto L151
    L145:
        r24 = r74;
        goto L147
    L141:
        r35 = r73;
        goto L143
    L137:
        r34 = r72;
        goto L139
    L133:
        r17 = r71;
        goto L135
    L129:
        r0 = r70;
        goto L130
    L125:
        r33 = r69;
        goto L127
    L121:
        r32 = r68;
        goto L123
    L117:
        r31 = r67;
        goto L119
    L113:
        r30 = r66;
        goto L115
    L109:
        r29 = r65;
        goto L111
    L105:
        r28 = r64;
        goto L107
    L101:
        r27 = r63;
        goto L103
    L97:
        r26 = r62;
        goto L99
    L93:
        r25 = r61;
        goto L95
    L89:
        r18 = r60;
        goto L91
    L85:
        r23 = r59;
        goto L87
    L81:
        r22 = r58;
        goto L83
    L77:
        r21 = r57;
        goto L79
    L73:
        r20 = r56;
        goto L75
    L69:
        r19 = r55;
        goto L71
    L65:
        r16 = r54;
        goto L67
    L61:
        r2 = r53;
        goto L63
    L57:
        r15 = r52;
        goto L59
    L53:
        r14 = r51;
        goto L55
    L49:
        r13 = r50;
        goto L51
    L45:
        r12 = r49;
        goto L47
    L41:
        r11 = r48;
        goto L43
    L37:
        r10 = r47;
        goto L39
    L33:
        r9 = r46;
        goto L35
    L29:
        r8 = r45;
        goto L31
    L25:
        r7 = r44;
        goto L27
    L21:
        r6 = r43;
        goto L23
    L17:
        r5 = r42;
        goto L19
    L13:
        r4 = r41;
        goto L15
    L9:
        r3 = r40;
        goto L11
    L5:
        r1 = r39;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v2, types: [boolean] */
    public static void n(LruSet r40, String r41, String r42, String r43, String r44, String r45, String r46, Integer r47, Integer r48, String r49, String r50, String r51, String r52, String r53, String r54, Integer r55, String r56, String r57, String r58, String r59, List r60, String r61, String r62, String r63, String r64, String r65, String r66, String r67, String r68, String r69, String r70, String r71, String r72, Boolean r73, Long r74, String r75, Function0 r76, String r77, int r78, int r79) {
        if ((r78 & 1) == 0) goto L5;
        LruSet r1 = null;
    L7:
        if ((r78 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r78 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r78 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r78 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r78 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r78 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r78 & 128) == 0) goto L33;
        Integer r9 = null;
    L35:
        if ((r78 & 256) == 0) goto L37;
        Integer r10 = null;
    L39:
        if ((r78 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r78 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r78 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r78 & 4096) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r78 & 8192) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r78 & 16384) == 0) goto L61;
        String r2 = null;
    L63:
        if ((r78 & 32768) == 0) goto L65;
        Integer r16 = null;
    L67:
        if ((r78 & 65536) == 0) goto L69;
        String r17 = null;
    L71:
        if ((r78 & 131072) == 0) goto L73;
        String r20 = null;
    L75:
        if ((r78 & 262144) == 0) goto L77;
        String r21 = null;
    L79:
        if ((r78 & 524288) == 0) goto L81;
        String r22 = null;
    L83:
        if ((r78 & 1048576) == 0) goto L85;
        List r19 = null;
    L87:
        if ((r78 & 2097152) == 0) goto L89;
        String r24 = "normal";
    L91:
        if ((r78 & 4194304) == 0) goto L93;
        String r25 = null;
    L95:
        if ((r78 & 8388608) == 0) goto L97;
        String r26 = null;
    L99:
        if ((r78 & 16777216) == 0) goto L101;
        String r27 = null;
    L103:
        if ((r78 & 33554432) == 0) goto L105;
        String r28 = null;
    L107:
        if ((r78 & 67108864) == 0) goto L109;
        String r29 = null;
    L111:
        if ((r78 & 134217728) == 0) goto L113;
        String r30 = null;
    L115:
        if ((r78 & 268435456) == 0) goto L117;
        String r31 = null;
    L119:
        if ((r78 & 536870912) == 0) goto L121;
        String r32 = null;
    L123:
        if ((r78 & 1073741824) == 0) goto L125;
        String r33 = null;
    L127:
        if ((r78 & Integer.MIN_VALUE) == 0) goto L129;
        String r0 = null;
    L131:
        if ((r79 & 1) == 0) goto L133;
        String r34 = null;
    L135:
        if ((r79 & 2) == 0) goto L137;
        Boolean r23 = null;
    L139:
        if ((r79 & 4) == 0) goto L141;
        Long r36 = null;
    L143:
        if ((r79 & 8) == 0) goto L145;
        String r37 = null;
    L147:
        if ((r79 & 16) == 0) goto L149;
        Function0 r35 = null;
    L151:
        if ((r79 & 32) == 0) goto L153;
        String r39 = null;
    L154:
        int r18 = 0;
        if (r1 == null) goto L159;
        String r38 = r0;
        String r410 = r17;
        boolean r110 = true;
        if (CollectionsKt.contains(r1, r3) == true) goto L161;
    L160:
        r110 = false;
    L161:
        if (r110 == true) goto L184;
        if (r3 == null) goto L166;
        if (r1 == null) goto L166;
        r1.add(r3);
    L166:
        o r80 = o.a;
        JSONObject r81 = new JSONObject();
        r81.putOpt("current_page", r7);
        r81.putOpt("previous_page", r8);
        r81.putOpt("message_id", r4);
        r81.putOpt("conversation_id", r5);
        r81.putOpt("bot_id", r14);
        r81.putOpt("chat_type", "default");
        r81.putOpt("reply_id", r6);
        r81.putOpt("module_position", r12);
        r81.putOpt("module_type", r2);
        r81.putOpt("card_id", r3);
        r81.putOpt("card_type", r13);
        r81.putOpt("card_position", r9);
        r81.putOpt("card_sub_position", r10);
        r81.putOpt("card_size", r15);
        r81.putOpt("video_id", r410);
        r81.putOpt("module_order", r16);
        r81.putOpt("req_id", r20);
        r81.putOpt("graphic_id", r22);
        r81.putOpt("slidemode", r21);
        r81.putOpt("module_source", r11);
        r81.putOpt("image_resolution", a(r19));
        r81.putOpt("content_type", r24);
        r81.putOpt("deep_research_id", r25);
        r81.putOpt("dr_process_detail", r26);
        r81.putOpt("status", r27);
        r81.putOpt("search_intention", r28);
        r81.putOpt("agent_id", r29);
        r81.putOpt("agent_tool", r30);
        r81.putOpt("memory_status", r38);
        r81.putOpt("tool_name", r31);
        r81.putOpt("chat_type", r32);
        r81.putOpt("code_type", r34);
        String r82 = r33;
        if (r82 == null) goto L169;
        r81.put("doc_id", r82);
    L169:
        if (r23 == null) goto L171;
        r18 = r23.booleanValue();
    L171:
        r81.putOpt("if_cr_show_success", Integer.valueOf(r18));
        r81.putOpt("cr_loading_time", r36);
        r81.putOpt("search_id", r39);
        String r83 = r37;
        if (r83 == null) goto L174;
        r81.putOpt("host_enter_from", r83);
    L174:
        if (r35 == null) goto L181;
        Map r84 = (Map) r35.invoke();
        if (r84 == null) goto L181;
        Iterator r85 = r84.entrySet().iterator();
    L179:
        if (r85.hasNext() == false) goto L181;
        Map.Entry r86 = (Map.Entry) r85.next();
        r81.put((String) r86.getKey(), r86.getValue());
    L181:
        Unit r87 = Unit.INSTANCE;
        r80.reportEvent("show_card", r81);
        return;
    L184:
        return;
    L159:
        r38 = r0;
        r410 = r17;
        goto L160
    L153:
        r39 = r77;
        goto L154
    L149:
        r35 = r76;
        goto L151
    L145:
        r37 = r75;
        goto L147
    L141:
        r36 = r74;
        goto L143
    L137:
        r23 = r73;
        goto L139
    L133:
        r34 = r72;
        goto L135
    L129:
        r0 = r71;
        goto L131
    L125:
        r33 = r70;
        goto L127
    L121:
        r32 = r69;
        goto L123
    L117:
        r31 = r68;
        goto L119
    L113:
        r30 = r67;
        goto L115
    L109:
        r29 = r66;
        goto L111
    L105:
        r28 = r65;
        goto L107
    L101:
        r27 = r64;
        goto L103
    L97:
        r26 = r63;
        goto L99
    L93:
        r25 = r62;
        goto L95
    L89:
        r24 = r61;
        goto L91
    L85:
        r19 = r60;
        goto L87
    L81:
        r22 = r59;
        goto L83
    L77:
        r21 = r58;
        goto L79
    L73:
        r20 = r57;
        goto L75
    L69:
        r17 = r56;
        goto L71
    L65:
        r16 = r55;
        goto L67
    L61:
        r2 = r54;
        goto L63
    L57:
        r15 = r53;
        goto L59
    L53:
        r14 = r52;
        goto L55
    L49:
        r13 = r51;
        goto L51
    L45:
        r12 = r50;
        goto L47
    L41:
        r11 = r49;
        goto L43
    L37:
        r10 = r48;
        goto L39
    L33:
        r9 = r47;
        goto L35
    L29:
        r8 = r46;
        goto L31
    L25:
        r7 = r45;
        goto L27
    L21:
        r6 = r44;
        goto L23
    L17:
        r5 = r43;
        goto L19
    L13:
        r4 = r42;
        goto L15
    L9:
        r3 = r41;
        goto L11
    L5:
        r1 = r40;
        goto L7
    }
}
