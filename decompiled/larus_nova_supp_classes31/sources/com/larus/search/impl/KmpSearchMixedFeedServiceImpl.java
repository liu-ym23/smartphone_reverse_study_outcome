package com.larus.search.impl;

import com.bytedance.flow.search.kmp.api.spi.SearchMixedFeedService;
import com.bytedance.lark.pb.basic.v1.Chat;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.Item;
import com.bytedance.lark.pb.basic.v1.StatusEffectiveInterval;
import com.bytedance.lark.pb.basic.v1.Tag;
import com.bytedance.lark.pb.feed.v1.ChatData;
import com.bytedance.lark.pb.feed.v1.FeedCursor;
import com.bytedance.lark.pb.feed.v1.FeedEntityPreview;
import com.bytedance.lark.pb.feed.v1.GetDoubaoFeedListResponse;
import com.bytedance.lark.pb.feed.v1.OpenFeedData;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u000e\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u00020\u0018H\u0002J\f\u0010\u0019\u001a\u00020\f*\u00020\u001aH\u0002J\f\u0010\u001b\u001a\u00020\f*\u00020\u001aH\u0002J\u000e\u0010\u001c\u001a\u00020\u001d*\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0010*\u0004\u0018\u00010\u001dH\u0002J\u000e\u0010\u001f\u001a\u00020\u0010*\u0004\u0018\u00010 H\u0002J\u000e\u0010!\u001a\u0004\u0018\u00010\u0010*\u00020\"H\u0002J'\u0010#\u001a\u0004\u0018\u00010\u0010*\u00020\"2\u0012\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100%\"\u00020\u0010H\u0002¢\u0006\u0002\u0010&J\f\u0010'\u001a\u00020\f*\u00020\"H\u0002R#\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006)"}, d2 = {"Lcom/larus/search/impl/KmpSearchMixedFeedServiceImpl;", "Lcom/bytedance/flow/search/kmp/api/spi/SearchMixedFeedService;", "<init>", "()V", "ntpService", "Lcom/ss/android/lark/usersetting/service/ntp/INtpService;", "kotlin.jvm.PlatformType", "getNtpService", "()Lcom/ss/android/lark/usersetting/service/ntp/INtpService;", "ntpService$delegate", "Lkotlin/Lazy;", "isMixedFeedEnabled", "", "requestMixedFeed", "Lcom/bytedance/flow/search/kmp/api/spi/SearchMixedFeedResult;", "cursor", "", "count", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFeedOfficeSdkService", "Lcom/ss/android/lark/officesdk/feed/api/IFeedOfficeSdkService;", "toSearchMixedFeedPreview", "Lcom/bytedance/flow/search/kmp/api/spi/SearchMixedFeedPreview;", "Lcom/bytedance/lark/pb/feed/v1/FeedEntityPreview;", "hasActiveOnLeaveStatus", "Lcom/bytedance/lark/pb/feed/v1/ChatData;", "hasExternalRelationTag", "toFeedCursor", "Lcom/bytedance/lark/pb/feed/v1/FeedCursor;", "toCursorKey", "decodeDoubaoConversationId", "", "readConversationId", "Lorg/json/JSONObject;", "optNonBlankString", "keys", "", "(Lorg/json/JSONObject;[Ljava/lang/String;)Ljava/lang/String;", "hasPreviewDataPayloadKeys", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class KmpSearchMixedFeedServiceImpl implements SearchMixedFeedService {
    public static final /* synthetic */ int c = 0;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    public final boolean i3() {
        LarkSocialExp.a.getClass();
        return LarkSocialExp.e();
    }

    public KmpSearchMixedFeedServiceImpl() {
        this.b = LazyKt.lazy(LazyThreadSafetyMode.NONE, new w());
    }

    public static FeedCursor k0(String r13) {
        if (r13 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        long r3 = 0;
        long r5 = Long.MAX_VALUE;
        if (r2 == true) goto L12;
        List r14 = StringsKt.split$default(r13, new String[]{":"}, false, 2, 2, null);
        String r0 = (String) CollectionsKt.getOrNull(r14, 0);
        if (r0 == null) goto L18;
        Long r1 = StringsKt.toLongOrNull(r0);
        if (r1 == null) goto L18;
        r3 = r1.longValue();
    L18:
        String r15 = (String) CollectionsKt.getOrNull(r14, 1);
        if (r15 == null) goto L24;
        Long r16 = StringsKt.toLongOrNull(r15);
        if (r16 == null) goto L24;
        r5 = r16.longValue();
    L24:
        return new FeedCursor(Long.valueOf(r5), Long.valueOf(r3));
    L12:
        return new FeedCursor(Long.MAX_VALUE, 0L);
    L5:
        if (StringsKt.isBlank(r13) == true) goto L8;
        r2 = false;
        goto L9
    }

    public final zv5.k z0(FeedEntityPreview r32) {
        String r4 = "";
        if (r32.doubao_custom_data == null) goto L83;
        String r0 = r32.biz_id;
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        if (StringsKt.isBlank(r0) == false) goto L79;
        OpenFeedData r1 = r32.doubao_custom_data;
        if (r1 == null) goto L14;
        ByteString r2 = r1.preview_data;
        if (r2 == null) goto L14;
        byte[] r6 = r2.toByteArray();
    L198:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L21
        if (r6 == null) goto L18;
        String r5 = StringsKt.decodeToString(r6);     // Catch: Throwable -> L21
    L19:
        Object r7 = Result.constructor-impl(r5);     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r7) == false) goto L26;
        r7 = null;
    L26:
        String r8 = (String) r7;
        if (r8 != null) goto L30;
        r8 = "";
    L30:
        if (StringsKt.isBlank(r8) == true) goto L76;
        String r9 = StringsKt.trim(r8).toString();
        if (StringsKt.startsWith$default(r9, "{", false, 2, null) == false) goto L76;
        Object r10 = Result.constructor-impl(new JSONObject(r9));     // Catch: Throwable -> L37
    L40:
        if (Result.isFailure-impl(r10) == false) goto L42;
        r10 = null;
    L42:
        JSONObject r11 = (JSONObject) r10;
        if (r11 != null) goto L49;
        FLogger r12 = FLogger.a;
        StringBuilder r13 = new StringBuilder("decodeDoubaoConversationId failed, size=");
        if (r6 == null) goto L47;
        int r14 = r6.length;
    L48:
        r13.append(r14);
        r12.w("SearchMixedFeedServiceImpl", r13.toString());
        goto L76
    L47:
        r14 = 0;
        goto L48
    L49:
        String r15 = u(r11, new String[]{"bizId"});
        if (r15 != null) goto L77;
        JSONObject r16 = r11.optJSONObject("data");
        if (r16 == null) goto L56;
        JSONObject r17 = r16.optJSONObject(SlashMentionConfig.MENTION_CONTENT_CONVERSATION);
        if (r17 == null) goto L56;
        r15 = u(r17, new String[]{"conversationId", "conversation_id"});
    L57:
        if (r15 != null) goto L77;
        if (r11.has(SlashMentionConfig.MENTION_CONTENT_CONVERSATION) == false) goto L61;
    L66:
        boolean r18 = true;
    L67:
        if (r18 == true) goto L70;
        r11 = null;
    L70:
        if (r11 == null) goto L74;
        JSONObject r19 = r11.optJSONObject(SlashMentionConfig.MENTION_CONTENT_CONVERSATION);
        if (r19 == null) goto L74;
        r0 = u(r19, new String[]{"conversationId", "conversation_id"});
    L75:
        if (r0 != null) goto L79;
    L74:
        r0 = null;
        goto L75
    L61:
        if (r11.has("botModel") == true) goto L66;
        if (r11.has("message") == true) goto L66;
        r18 = false;
    L56:
        r15 = null;
    L77:
        r0 = r15;
    L37:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L76:
        r0 = "";
        goto L79
    L18:
        r5 = null;
    L21:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
    L14:
        r6 = null;
    L79:
        if ((!StringsKt.isBlank(r0)) == true) goto L82;
        r0 = null;
    L82:
        String r22 = r0;
    L84:
        ChatData r23 = r32.chat_data;
        if (r23 == null) goto L189;
        Item r24 = r23.item;
        if (r24 == null) goto L89;
        String r25 = r24.entity_id;
    L90:
        if (r25 != null) goto L93;
        r25 = "";
    L93:
        if (StringsKt.isBlank(r25) == false) goto L98;
        r25 = r32.biz_id;
        if (r25 != null) goto L98;
        r25 = "";
    L98:
        if (StringsKt.isBlank(r25) == false) goto L102;
        r25 = r32.feed_id;
        if (r25 != null) goto L102;
        String r26 = "";
    L103:
        String r27 = r23.chatter_id;
        if (r27 != null) goto L106;
        String r110 = "";
    L107:
        String r28 = (String) CollectionsKt.firstOrNull(r23.avatar_urls);
        if (r28 != null) goto L110;
        String r111 = "";
    L111:
        String r29 = r23.name;
        if (r29 != null) goto L114;
        String r112 = "";
    L115:
        String r30 = r23.localized_digest_message;
        if (r30 != null) goto L118;
        String r113 = "";
    L119:
        Long r114 = r23.display_time;
        Long r115 = r32.backup_update_time_ms;
        Integer r31 = r23.unread_count;
        if (r31 == null) goto L122;
        int r116 = r31.intValue();
    L123:
        Chat.Type r33 = r23.chat_type;
        if (r33 == null) goto L126;
        Integer r117 = Integer.valueOf(r33.getValue());
    L127:
        Boolean r34 = r23.is_shortcut;
        Boolean r35 = Boolean.TRUE;
        boolean r118 = Intrinsics.areEqual(r34, r35);
        String r36 = r23.avatar_key;
        if (r36 == null) goto L131;
        r4 = r36;
    L131:
        boolean r210 = Intrinsics.areEqual(r23.is_public_v2, r35);
        boolean r211 = Intrinsics.areEqual(r23.is_department, r35);
        List r37 = r23.tags;
        if (r37 != null) goto L134;
    L136:
        boolean r212 = false;
    L137:
        List r38 = r23.tags;
        if (r38 != null) goto L140;
    L142:
        boolean r213 = false;
    L143:
        boolean r214 = Intrinsics.areEqual(r23.is_blocked, r35);
        long r39 = ((cac.a) this.b.getValue()).a(30000) / 1000;
        List r40 = r23.chatter_status;
        if (r40 != null) goto L146;
        r40 = CollectionsKt.emptyList();
    L146:
        List r41 = r40;
        if ((r41 instanceof Collection) == true) goto L149;
    L151:
        Iterator r42 = r41.iterator();
    L153:
        if (r42.hasNext() == false) goto L171;
        Chatter.ChatterCustomStatus r43 = (Chatter.ChatterCustomStatus) r42.next();
        StatusEffectiveInterval r44 = r43.effective_interval;
        if (r44 != null) goto L157;
        Iterator r215 = r42;
    L167:
        boolean r45 = false;
    L168:
        if (r45 == true) goto L169;
        r42 = r215;
        goto L153
    L169:
        boolean r46 = true;
    L172:
        TagData r47 = com.ss.android.lark.parser.internal.a0.a(r23.tag_info);
        if (r47 == null) goto L182;
        TagData.Companion.getClass();
        Iterator r48 = ((ArrayList) TagData.a.b(r47)).iterator();
    L176:
        if (r48.hasNext() == false) goto L180;
        Object r49 = r48.next();
        if (g08.b.a(((g08.a) r49).b) == false) goto L176;
    L181:
        g08.a r50 = (g08.a) r49;
    L183:
        if (r50 != null) goto L185;
    L187:
        boolean r216 = false;
    L188:
        zv5.j r51 = new zv5.j(r26, r110, r111, r112, r113, r114, r115, r116, r117, r118, r4, r210, r211, r212, r213, r214, r46, r216, Intrinsics.areEqual(r23.is_agent, Boolean.TRUE));
    L190:
        if (r22 != null) goto L195;
        if (r51 != null) goto L195;
        return null;
    L195:
        return new zv5.k(r22, r51, r32.update_time, r32.rank_level, r32.on_top_rank_time);
    L185:
        if (r50.b != 1) goto L187;
        r216 = true;
        goto L188
    L180:
        r49 = null;
        goto L181
    L182:
        r50 = null;
        goto L183
    L157:
        r215 = r42;
        if (Intrinsics.areEqual(r43.icon_key, "GeneralVacation") == false) goto L167;
        Long r52 = r44.start_time;
        if (r39 <= r44.end_time.longValue()) goto L162;
    L164:
        boolean r53 = false;
    L165:
        if (r53 == false) goto L167;
        r45 = true;
        goto L168
    L162:
        if (r52.longValue() > r39) goto L164;
        r53 = true;
    L171:
        r46 = false;
        goto L172
    L149:
        if (r41.isEmpty() == false) goto L151;
    L140:
        if (r38.contains(Tag.FROZEN) != true) goto L142;
        r213 = true;
        goto L143
    L134:
        if (r37.contains(Tag.USER_RESIGNED) != true) goto L136;
        r212 = true;
        goto L137
    L126:
        r117 = null;
        goto L127
    L122:
        r116 = 0;
        goto L123
    L118:
        r113 = r30;
        goto L119
    L114:
        r112 = r29;
        goto L115
    L110:
        r111 = r28;
        goto L111
    L106:
        r110 = r27;
    L102:
        r26 = r25;
        goto L103
    L89:
        r25 = null;
        goto L90
    L189:
        r51 = null;
        goto L190
    L83:
        r22 = null;
        goto L84
    }

    public static String u(JSONObject r5, String... r6) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        String r2 = null;
        if (r1 >= r0) goto L10;
        String r3 = r5.optString(r6[r1]);
        Intrinsics.checkNotNull(r3);
        if ((!StringsKt.isBlank(r3)) == false) goto L8;
        r2 = r3;
    L8:
        if (r2 != null) goto L10;
        r1 = r1 + 1;
    L10:
        return r2;
    }

    public final Object r2(String r9, int r10, Continuation<? super zv5.l> r11) {
        if ((r11 instanceof KmpSearchMixedFeedServiceImpl$requestMixedFeed$1) == false) goto L7;
        KmpSearchMixedFeedServiceImpl$requestMixedFeed$1 r0 = (KmpSearchMixedFeedServiceImpl$requestMixedFeed$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        KmpSearchMixedFeedServiceImpl r13 = (KmpSearchMixedFeedServiceImpl) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L14
    L44:
        GetDoubaoFeedListResponse r14 = (GetDoubaoFeedListResponse) r12;     // Catch: Throwable -> L14
        if (r14 != null) goto L47;
        zv5.l r15 = null;
    L64:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L14
    L67:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L71;
        FLogger.a.e("SearchMixedFeedServiceImpl", "requestMixedFeed failed", r17);
    L71:
        if (Result.isFailure-impl(r16) == false) goto L74;
        return null;
    L74:
        return r16;
    L47:
        List r18 = r14.previews;     // Catch: Throwable -> L14
        ArrayList r4 = new ArrayList();     // Catch: Throwable -> L14
        Iterator r19 = r18.iterator();     // Catch: Throwable -> L14
    L49:
        if (r19.hasNext() == false) goto L53;
        FeedEntityPreview r5 = (FeedEntityPreview) r19.next();     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L14
        zv5.k r6 = r13.z0(r5);     // Catch: Throwable -> L14
        if (r6 == null) goto L49;
        r4.add(r6);     // Catch: Throwable -> L14
        goto L49
    L53:
        FeedCursor r110 = r14.next_cursor;     // Catch: Throwable -> L14
        r13.getClass();     // Catch: Throwable -> L14
        if (r110 == null) goto L62;
        Long r20 = r110.id;     // Catch: Throwable -> L14
        if (r20 == null) goto L62;
        long r7 = r20.longValue();     // Catch: Throwable -> L14
        Long r21 = r110.rank_time;     // Catch: Throwable -> L14
        if (r21 == null) goto L60;
        long r22 = r21.longValue();     // Catch: Throwable -> L14
    L61:
        StringBuilder r111 = new StringBuilder();     // Catch: Throwable -> L14
        r111.append(r7);     // Catch: Throwable -> L14
        r111.append(':');     // Catch: Throwable -> L14
        r111.append(r22);     // Catch: Throwable -> L14
        String r23 = r111.toString();     // Catch: Throwable -> L14
    L63:
        r15 = new zv5.l(r4, r23);     // Catch: Throwable -> L14
        goto L64
    L60:
        r22 = Long.MAX_VALUE;
    L62:
        r23 = null;
        goto L63
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r12);
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L28
        Object r113 = xp9.o.a;     // Catch: Throwable -> L28
        if ((r113 instanceof OfficeSDKUserApi) == false) goto L22;
        OfficeSDKUserApi r114 = (OfficeSDKUserApi) r113;     // Catch: Throwable -> L28
    L23:
        if (r114 == null) goto L25;
        qtb.a r115 = (qtb.a) r114.getService(qtb.a.class);     // Catch: Throwable -> L28
    L26:
        Object r116 = Result.constructor-impl(r115);     // Catch: Throwable -> L28
    L30:
        Throwable r8 = Result.exceptionOrNull-impl(r116);
        if (r8 == null) goto L34;
        FLogger.a.e("SearchMixedFeedServiceImpl", "getFeedOfficeSdkService failed", r8);
    L34:
        if (Result.isFailure-impl(r116) == false) goto L36;
        r116 = null;
    L36:
        qtb.a r117 = (qtb.a) r116;
        if (r117 != null) goto L40;
        FLogger.a.w("SearchMixedFeedServiceImpl", "requestMixedFeed skipped, feedUpdateService is null");
        return null;
    L40:
        FeedCursor r24 = k0(r9);     // Catch: Throwable -> L14
        r0.L$0 = this;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        r12 = r117.Ra(r24, r10);     // Catch: Throwable -> L14
        if (r12 != r2) goto L43;
        return r2;
    L43:
        r13 = this;
        goto L44
    L25:
        r115 = null;
        goto L26
    L22:
        r114 = null;
    L28:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r116 = Result.constructor-impl(ResultKt.createFailure(th));
    L14:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new KmpSearchMixedFeedServiceImpl$requestMixedFeed$1(this, r11);
        goto L8
    }
}
