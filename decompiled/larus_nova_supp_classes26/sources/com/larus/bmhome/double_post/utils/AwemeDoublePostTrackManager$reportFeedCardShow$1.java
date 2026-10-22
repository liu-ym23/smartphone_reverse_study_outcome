package com.larus.bmhome.double_post.utils;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.video.AuthorInfo;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.ContentDescription;
import com.larus.bmhome.video.InteractInfo;
import com.larus.bmhome.video.InteractionStatistic;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.double_post.utils.AwemeDoublePostTrackManager$reportFeedCardShow$1", f = "AwemeDoublePostTrackManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AwemeDoublePostTrackManager$reportFeedCardShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Content $data;
    final /* synthetic */ String $hostEnterFrom;
    final /* synthetic */ int $index;
    final /* synthetic */ String $messageId;
    final /* synthetic */ int $spanIndex;
    int label;

    public AwemeDoublePostTrackManager$reportFeedCardShow$1(int r1, int r2, Content r3, String r4, String r5, Continuation<? super AwemeDoublePostTrackManager$reportFeedCardShow$1> r6) {
        this.$index = r1;
        this.$spanIndex = r2;
        this.$data = r3;
        this.$hostEnterFrom = r4;
        this.$messageId = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new AwemeDoublePostTrackManager$reportFeedCardShow$1(this.$index, this.$spanIndex, this.$data, this.$hostEnterFrom, this.$messageId, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L82;
        ResultKt.throwOnFailure(r17);
        Integer r0 = Boxing.boxInt(this.$index + 1);
        Integer r2 = Boxing.boxInt(this.$spanIndex + 1);
        e r3 = e.a;
        String r4 = e.a(this.$data);
        LaunchInfo r5 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
        String r6 = null;
        if (r5 == null) goto L7;
        String r7 = r5.W();
    L8:
        String r8 = this.$hostEnterFrom;
        Content r9 = this.$data;
        if (r9 == null) goto L13;
        Integer r10 = r9.getImprIndex();
        if (r10 == null) goto L13;
        int r11 = r10.intValue();
    L14:
        Integer r12 = Boxing.boxInt(r11);
        Content r13 = this.$data;
        if (r13 == null) goto L17;
        String r14 = r13.getItemId();
    L18:
        Content r15 = this.$data;
        if (r15 == null) goto L23;
        AuthorInfo r16 = r15.getAuthorInfo();
        if (r16 == null) goto L23;
        String r18 = r16.getOpenId();
    L24:
        Content r19 = this.$data;
        if (r19 == null) goto L29;
        ContentDescription r110 = r19.getContentDescription();
        if (r110 == null) goto L29;
        String r111 = r110.getTitle();
    L30:
        Content r112 = this.$data;
        if (r112 == null) goto L37;
        InteractInfo r113 = r112.getInteractInfo();
        if (r113 == null) goto L37;
        InteractionStatistic r114 = r113.getStatistic();
        if (r114 == null) goto L37;
        Long r115 = Boxing.boxLong(r114.getLikedCount());
    L38:
        String r116 = e.b;
        String r117 = e.c;
        if (r117 != null) goto L41;
        String r118 = null;
    L42:
        Content r119 = this.$data;
        if (r119 == null) goto L45;
        r6 = r119.getRequestId();
    L45:
        String r120 = this.$messageId;
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r0 != null) goto L83;
    L50:
        if (r2 == null) goto L52;
        r1.put("column", r2.intValue());     // Catch: JSONException -> L48
    L52:
        if (r4 == null) goto L54;
        r1.put("group_type", r4);     // Catch: JSONException -> L48
    L54:
        if (r7 == null) goto L56;
        r1.put("bot_id", r7);     // Catch: JSONException -> L48
    L56:
        r1.put("chat_type", "default");     // Catch: JSONException -> L48
        if (r8 == null) goto L59;
        r1.put("host_enter_from", r8);     // Catch: JSONException -> L48
    L59:
        if (r12 == null) goto L61;
        r1.put("impr_index", r12.intValue());     // Catch: JSONException -> L48
    L61:
        if (r14 == null) goto L63;
        r1.put("item_group_id", r14);     // Catch: JSONException -> L48
    L63:
        if (r18 == null) goto L65;
        r1.put("author_id", r18);     // Catch: JSONException -> L48
    L65:
        if (r111 == null) goto L67;
        r1.put("title", r111);     // Catch: JSONException -> L48
    L67:
        if (r115 == null) goto L69;
        r1.put("favorite_cnt", r115.longValue());     // Catch: JSONException -> L48
    L69:
        if (r116 == null) goto L71;
        r1.put("last_message_id", r116);     // Catch: JSONException -> L48
    L71:
        if (r118 == null) goto L73;
        r1.put("last_bot_id", r118);     // Catch: JSONException -> L48
    L73:
        if (r6 == null) goto L75;
        r1.put("req_id", r6);     // Catch: JSONException -> L48
    L75:
        if (r120 == null) goto L79;
        r1.put(MusicAppletPage.KEY_MESSAGE_ID, r120);     // Catch: JSONException -> L48
    L48:
        e = move-exception;
        FLogger.a.e("AwemeFeedEventHelper", "error in AwemeFeedEventHelper mobFeedCardShow " + e.getLocalizedMessage());
    L79:
        TrackParams r20 = new TrackParams().merge(r1);
        by7.a r21 = new by7.a("feed_card_show");
        r21.a.merge(r20);
        r21.b();
        return Unit.INSTANCE;
    L83:
        r1.put("rank", r0.intValue());     // Catch: JSONException -> L48
        goto L50
    L41:
        r118 = BotInfoCache.INSTANCE.getBotId(r117);
    L37:
        r115 = null;
    L29:
        r111 = null;
    L23:
        r18 = null;
        goto L24
    L17:
        r14 = null;
    L13:
        r11 = 0;
        goto L14
    L7:
        r7 = null;
        goto L8
    L82:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
