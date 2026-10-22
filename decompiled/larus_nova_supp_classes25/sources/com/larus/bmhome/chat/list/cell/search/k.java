package com.larus.bmhome.chat.list.cell.search;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.search.ArticleInfo;
import com.larus.bmhome.chat.search.SourceFrom;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.ItemData;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class k implements Function4 {
    public final /* synthetic */ Message a;
    public final /* synthetic */ BotModel b;

    public /* synthetic */ k(Message r1, BotModel r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r11, Object r12, Object r13, Object r14) {
        Message r0 = this.a;
        BotModel r1 = this.b;
        long r2 = ((Long) r11).longValue();
        int r15 = ((Integer) r12).intValue();
        ItemData r16 = (ItemData) r13;
        int r17 = SearchListCell.o;
        Intrinsics.checkNotNullParameter(r16, "itemData");
        Intrinsics.checkNotNullParameter((oi8.k) r14, "searchListData");
        if (SearchListCell$c.a[r16.getSearchItemType().ordinal()] != 3) goto L40;
        if ((r16 instanceof ArticleInfo) == false) goto L43;
        FLogger r18 = FLogger.a;
        StringBuilder r19 = new StringBuilder("onItemExposeEnd ");
        r19.append(r2);
        r19.append(' ');
        r19.append(r15 + 1);
        r19.append(' ');
        ArticleInfo r110 = (ArticleInfo) r16;
        r19.append(r110.getTitle());
        r18.d("SearchListCell", r19.toString());
        Integer r111 = r110.getSourceFrom();
        SourceFrom r112 = SourceFrom.BaiKe;
        int r4 = r112.value;
        String r5 = null;
        if (r111 != null) goto L11;
    L13:
        String r113 = null;
    L14:
        Integer r6 = r110.getSourceFrom();
        int r114 = r112.value;
        if (r6 != null) goto L18;
    L20:
        Long r115 = Long.valueOf(((long) r15) + 1);
        String r116 = r0.getMessageId();
        String r3 = r1.getBotId();
        Long r7 = Long.valueOf(r2);
        JSONObject r8 = new JSONObject();
        Intrinsics.checkNotNullParameter(r8, "params");
        if (r113 != null) goto L41;
    L25:
        if (r5 == null) goto L27;
        r8.put("baike_id", r5);     // Catch: JSONException -> L23
    L27:
        r8.put("card_type", "search_slide_card");     // Catch: JSONException -> L23
        if (r115 == null) goto L30;
        r8.put("position", r115.longValue());     // Catch: JSONException -> L23
    L30:
        if (r116 == null) goto L32;
        r8.put("message_id", r116);     // Catch: JSONException -> L23
    L32:
        if (r3 == null) goto L34;
        r8.put("bot_id", r3);     // Catch: JSONException -> L23
    L34:
        if (r7 == null) goto L38;
        r8.put("stay_time", r7.longValue());     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        FLogger.a.e("SearchEventHelper", "error in SearchEventHelper searchCardLeave " + e.getLocalizedMessage());
    L38:
        TrackParams r117 = new TrackParams().merge(r8);
        by7.a r118 = new by7.a("search_card_leave");
        r118.a.merge(r117);
        r118.b();
        goto L40
    L41:
        r8.put("card_source", r113);     // Catch: JSONException -> L23
        goto L25
    L18:
        if (r6.intValue() != r114) goto L20;
        r5 = r110.getSourceId();
        goto L20
    L11:
        if (r111.intValue() != r4) goto L13;
        r113 = "douyin_baike";
        goto L14
    L43:
        return Unit.INSTANCE;
    L40:
        return Unit.INSTANCE;
    }
}
