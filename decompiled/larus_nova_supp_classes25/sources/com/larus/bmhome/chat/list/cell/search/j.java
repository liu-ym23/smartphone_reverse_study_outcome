package com.larus.bmhome.chat.list.cell.search;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.search.ArticleInfo;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.bmhome.chat.search.MoreInfo;
import com.larus.bmhome.chat.search.SearchBoxStyle;
import com.larus.bmhome.chat.search.SourceFrom;
import com.larus.bmhome.chat.search.VideoInfo;
import com.larus.bmhome.video.Content;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.ItemShowType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class j implements Function3 {
    public final /* synthetic */ SearchListCell a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ BotModel c;

    public /* synthetic */ j(SearchListCell r1, Message r2, BotModel r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r31, Object r32, Object r33) {
        SearchListCell r0 = this.a;
        Message r15 = this.b;
        BotModel r14 = this.c;
        pi8.l r13 = (pi8.l) r31;
        oi8.c r8 = (oi8.c) r33;
        int r3 = SearchListCell.o;
        Intrinsics.checkNotNullParameter(r13, "callbackData");
        Intrinsics.checkNotNullParameter((oi8.k) r32, "searchListData");
        SearchImageInfo r12 = r13.a;
        SearchBoxStyle r2 = com.larus.bmhome.chat.search.a.a(r15);
        int r4 = r13.b;
        r0.getClass();
        Pair r5 = SearchListCell.o(r2, r4);
        int r6 = ((Number) r5.component1()).intValue();
        int r7 = ((Number) r5.component2()).intValue();
        Long r18 = null;
        String r19 = null;
        r19 = null;
        switch(SearchListCell$c.a[r12.getSearchItemType().ordinal()]) {
            case 1: goto L109;
            case 2: goto L95;
            case 3: goto L32;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L7;
            default: goto L5;
        };
    L18:
        r0.f = false;
        r12.setItemShowType(ItemShowType.ITEM_SHOW_TYPE_NONE);
    L121:
        return Unit.INSTANCE;
    L5:
        throw new NoWhenBranchMatchedException();
    L7:
        if ((r12 instanceof Content) == false) goto L126;
        int r9 = oi8.f.a;
        q0 r10 = lf8.a.b(r0);
        if (r10 == null) goto L12;
        LruSet<String> r11 = r10.E7();
    L13:
        ChatParam r16 = r0.t();
        String r1 = r14.getBotId();
        if (r1 != null) goto L16;
        String r17 = "";
    L17:
        oi8.f.k(r11, r15, r16, r6, r7, r12, r8, null, r17, null, null, r13.c, r13.d, null, 9856);
        goto L121
    L16:
        r17 = r1;
        goto L17
    L12:
        r11 = null;
        goto L13
    L126:
        return Unit.INSTANCE;
    L20:
        if ((r12 instanceof SearchImageInfo) == false) goto L127;
        int r20 = oi8.f.a;
        q0 r21 = lf8.a.b(r0);
        if (r21 == null) goto L25;
        LruSet<String> r22 = r21.E7();
    L26:
        ChatParam r23 = r0.t();
        String r24 = r14.getBotId();
        if (r24 != null) goto L29;
        String r110 = "";
    L30:
        oi8.f.k(r22, r15, r23, r6, r7, r12, r8, null, r110, null, null, r13.c, r13.d, r12.getDocId(), 1664);
        goto L121
    L29:
        r110 = r24;
        goto L30
    L25:
        r22 = null;
        goto L26
    L127:
        return Unit.INSTANCE;
    L32:
        if ((r12 instanceof ArticleInfo) == false) goto L128;
        int r25 = oi8.f.a;
        q0 r26 = lf8.a.b(r0);
        if (r26 == null) goto L37;
        LruSet<String> r27 = r26.E7();
    L38:
        ChatParam r28 = r0.t();
        String r29 = r14.getBotId();
        if (r29 != null) goto L41;
        String r111 = "";
    L42:
        oi8.f.k(r27, r15, r28, r6, r7, r12, r8, null, r111, null, null, r13.c, r13.d, null, 9856);
        ArticleInfo r112 = (ArticleInfo) r12;
        Integer r30 = r112.getSourceFrom();
        SourceFrom r34 = SourceFrom.BaiKe;
        int r35 = r34.value;
        if (r30 != null) goto L46;
    L48:
        String r36 = null;
    L49:
        Integer r37 = r112.getSourceFrom();
        int r38 = r34.value;
        if (r37 != null) goto L53;
    L55:
        String r39 = r19;
        int r40 = r13.b;
        String r41 = r14.getBotId();
        if (r41 != null) goto L58;
        r41 = "";
    L58:
        Intrinsics.checkNotNullParameter(r112, "<this>");
        String r42 = ve8.b.a(r112.getSummary());
        String r43 = ve8.b.a(r112.getTitle());
        String r44 = ve8.b.a(r112.getSiteName());
        if (o0.d(r42) == false) goto L61;
    L66:
        boolean r113 = true;
    L67:
        Boolean r114 = Boolean.valueOf(r113);
        if (r42 != null) goto L72;
        if (r43 != null) goto L71;
        r42 = r44;
        goto L72
    L71:
        r42 = r43;
    L72:
        Pair r45 = new Pair(r114, r42);
        String r46 = r15.getMessageId();
        long r47 = ((long) r40) + 1;
        long r115 = r15.getCreateTime();
        boolean r48 = ((Boolean) r45.getFirst()).booleanValue();
        String r49 = (String) r45.getSecond();
        String r116 = r112.getSearchId();
        Long r50 = Long.valueOf(r47);
        Boolean r51 = Boolean.valueOf(r48);
        Long r52 = Long.valueOf(r115);
        JSONObject r117 = new JSONObject();
        Intrinsics.checkNotNullParameter(r117, "params");
        r117.put("bot_id", r41);     // Catch: JSONException -> L91
        r117.put("card_type", "search_slide_card");     // Catch: JSONException -> L91
        if (r46 == null) goto L76;
        r117.put("message_id", r46);     // Catch: JSONException -> L91
    L76:
        if (r50 == null) goto L78;
        r117.put("position", r50.longValue());     // Catch: JSONException -> L91
    L78:
        if (r36 == null) goto L80;
        r117.put("card_source", r36);     // Catch: JSONException -> L91
    L80:
        if (r39 == null) goto L82;
        r117.put("baike_id", r39);     // Catch: JSONException -> L91
    L82:
        if (r51 == null) goto L84;
        r117.put("unreadable", r51.booleanValue() ? 1 : 0);     // Catch: JSONException -> L91
    L84:
        if (r49 == null) goto L86;
        r117.put(ChatDraftItem.TYPE_TEXT, r49);     // Catch: JSONException -> L91
    L86:
        if (r52 == null) goto L88;
        r117.put("create_time", r52.longValue());     // Catch: JSONException -> L91
    L88:
        if (r116 == null) goto L93;
        r117.put("search_id", r116);     // Catch: JSONException -> L91
    L93:
        TrackParams r53 = new TrackParams().merge(r117);
        by7.a r54 = new by7.a("search_card_show");
        r54.a.merge(r53);
        r54.b();
    L91:
        e = move-exception;
        FLogger.a.e("SearchEventHelper", "error in SearchEventHelper searchCardShow " + e.getLocalizedMessage());
        goto L93
    L61:
        if (o0.d(r43) == true) goto L66;
        if (o0.d(r44) == true) goto L66;
        r113 = false;
        goto L67
    L53:
        if (r37.intValue() != r38) goto L55;
        r19 = r112.getSourceId();
        goto L55
    L46:
        if (r30.intValue() != r35) goto L48;
        r36 = "douyin_baike";
        goto L49
    L41:
        r111 = r29;
        goto L42
    L37:
        r27 = null;
        goto L38
    L128:
        return Unit.INSTANCE;
    L95:
        if ((r12 instanceof MoreInfo) == false) goto L129;
        MoreInfo r118 = (MoreInfo) r12;
        String r55 = r14.getBotId();
        if (r55 == null) goto L100;
        r18 = StringsKt.toLongOrNull(r55);
    L100:
        JSONObject r56 = new JSONObject();
        Intrinsics.checkNotNullParameter(r56, "params");
        if (r18 != null) goto L122;
    L103:
        r56.put("current_page", "chat");     // Catch: JSONException -> L105
    L107:
        TrackParams r57 = new TrackParams().merge(r56);
        by7.a r58 = new by7.a("magnifier_icon_show");
        r58.a.merge(r57);
        r58.b();
    L105:
        e = move-exception;
        FLogger.a.e("MagnifierEventHelper", "error in MagnifierEventHelper magnifierIconShow " + e.getLocalizedMessage());
        goto L107
    L122:
        r56.put("bot_id", r18.longValue());     // Catch: JSONException -> L105
        goto L103
    L129:
        return Unit.INSTANCE;
    L109:
        if ((r12 instanceof VideoInfo) == false) goto L130;
        int r59 = oi8.f.a;
        q0 r60 = lf8.a.b(r0);
        if (r60 == null) goto L114;
        LruSet<String> r61 = r60.E7();
    L115:
        ChatParam r62 = r0.t();
        String r63 = r14.getBotId();
        if (r63 != null) goto L118;
        String r119 = "";
    L119:
        oi8.f.k(r61, r15, r62, r6, r7, r12, r8, null, r119, null, null, r13.c, r13.d, null, 9856);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SearchListCell$firstShowVideoItem$1(r15, r13.b, r0.s(), (VideoInfo) r12, null), 3, null);
        goto L121
    L118:
        r119 = r63;
        goto L119
    L114:
        r61 = null;
        goto L115
    L130:
        return Unit.INSTANCE;
    }
}
