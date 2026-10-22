package com.ss.android.lark.flow.notification.online.process;

import com.bytedance.lark.pb.basic.v1.AppFeedCardData;
import com.bytedance.lark.pb.basic.v1.AppFeedData;
import com.bytedance.lark.pb.basic.v1.Channel;
import com.bytedance.lark.pb.basic.v1.ChatApplyData;
import com.bytedance.lark.pb.basic.v1.CustomSpeechFile;
import com.bytedance.lark.pb.basic.v1.DocFeedData;
import com.bytedance.lark.pb.basic.v1.DocImageReplyData;
import com.bytedance.lark.pb.basic.v1.FriendApplicationData;
import com.bytedance.lark.pb.basic.v1.Image;
import com.bytedance.lark.pb.basic.v1.MailData;
import com.bytedance.lark.pb.basic.v1.Message;
import com.bytedance.lark.pb.basic.v1.MessageData;
import com.bytedance.lark.pb.basic.v1.Notification;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.Notice;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zsb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.notification.online.process.FlowNotificationPushManager$handleNotificationPush$1", f = "FlowNotificationPushManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FlowNotificationPushManager$handleNotificationPush$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Notification $resp;
    int label;
    final /* synthetic */ d this$0;

    public FlowNotificationPushManager$handleNotificationPush$1(Notification r1, d r2, Continuation<? super FlowNotificationPushManager$handleNotificationPush$1> r3) {
        this.$resp = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowNotificationPushManager$handleNotificationPush$1(this.$resp, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L106;
        ResultKt.throwOnFailure(r10);
        Notification r11 = this.$resp;
        if (r11 == null) goto L104;
        d r0 = this.this$0;
        thb.a.b("FlowNotificationPushManager", "receive notification id = " + r11.id);
        Notice r1 = new Notice(r11);
        r1.messageId = "";
        r1.state = r11.state.getValue();
        r1.content = r11.content;
        r1.title = r11.title;
        MessageData r3 = r11.message_data;
        if (r3 == null) goto L22;
        int r4 = f.a[r3.type.ordinal()];
        int r6 = 2;
        if (r4 != 1) goto L11;
    L40:
        r1.type = r6;
        r1.key = r11.id;
        r1.shouldNotify = r11.should_notify.booleanValue();
        MessageData r5 = r11.message_data;
        if (r5 == null) goto L50;
        r1.createTime = r5.create_time.longValue();
        r1.messageId = r5.message_id;
        r1.position = r5.position.intValue();
        Notice.Extra r12 = new Notice.Extra();
        r1.extra = r12;
        r12.j = r5.recaller_id;
        Channel r7 = r5.channel;
        if (r7 == null) goto L45;
        r12.i = r7.type.getValue();
        Notice.Extra r13 = r1.extra;
        String r8 = r5.channel.id;
        r13.getClass();
    L45:
        Notice.Extra r14 = r1.extra;
        r14.a = r5.chat_id;
        r14.b = Notice.Extra.ChatType.valueOf(r5.chat_type.getValue());
        r1.extra.d = Notice.Extra.ChatMode.forNumber(r5.chat_mode.getValue());
        r1.extra.f = r5.is_crypto.booleanValue();
        r1.extra.h = r5.new_message_count.intValue();
        Notice.Extra r15 = r1.extra;
        r15.g = r5.avatar_key;
        r15.k = r5.thread_message_position.intValue();
        r1.extra.c = r5.from_chatter_id;
        new ArrayList(r5.image_urls);
        Notice.Extra r16 = r1.extra;
        r16.e = r5.thread_id;
        r16.l = r5.channel_thread_position.intValue();
        Notice.Extra r17 = r1.extra;
        r5.me_read.booleanValue();
        r17.getClass();
        r1.extra.q = r5.is_on_time_del.booleanValue();
        r1.extra.p = r5.target_user_id.toString();
        Notice.Extra r18 = r1.extra;
        if (Message.ThreadMessageType.THREAD_REPLY_MESSAGE != r5.thread_message_type) goto L48;
        boolean r9 = true;
    L49:
        r18.r = Boolean.valueOf(r9);
        Notice.Extra r19 = r1.extra;
        Message.RecallerIdentity r20 = Message.RecallerIdentity.UNKNOWN_IDENTITY;
        r19.getClass();
        r1.extra.getClass();
        Notice.Extra r110 = r1.extra;
        r110.s = r5.unit_key;
        r110.t = r5.from_chatter_name;
    L94:
        if (r1.type == 14) goto L99;
        String r111 = r1.key + ' ' + r1.extra.s;
        if (r0.f.get(r111) == null) goto L98;
        thb.a.b("FlowNotificationPushManager", "Ignore notice due to repeated notice. " + r111);
        goto L104
    L98:
        r0.f.put(r111, Boxing.boxBoolean(true));
    L99:
        Iterator<ctb.a> r112 = r0.c.iterator();
    L101:
        if (r112.hasNext() == false) goto L104;
        r112.next().a(r1);
        goto L101
    L48:
        r9 = false;
        goto L49
    L50:
        MailData r21 = r11.mail_data;
        if (r21 == null) goto L56;
        r1.messageId = r21.message_id;
        r1.createTime = r21.create_time.longValue();
        Notice.Extra r113 = new Notice.Extra();
        r1.extra = r113;
        Channel r22 = r21.channel;
        if (r22 == null) goto L55;
        r113.i = r22.type.getValue();
        Notice.Extra r114 = r1.extra;
        String r23 = r21.channel.id;
        r114.getClass();
    L55:
        Notice.Extra r115 = r1.extra;
        r115.e = r21.thread_id;
        r115.h = r21.new_message_count.intValue();
        Notice.Extra r116 = r1.extra;
        r116.c = r21.from_chatter_id;
        r116.getClass();
        goto L94
    L56:
        DocImageReplyData r24 = r11.doc_image_reply_data;
        if (r24 == null) goto L59;
        r1.createTime = r24.create_time.longValue();
        r1.extra = new Notice.Extra();
        goto L94
    L59:
        DocFeedData r25 = r11.doc_feed_data;
        if (r25 == null) goto L65;
        r1.messageId = r25.message_id;
        r1.createTime = r25.create_time.longValue();
        Notice.Extra r117 = new Notice.Extra();
        r1.extra = r117;
        Channel r26 = r25.channel;
        if (r26 == null) goto L64;
        r117.i = r26.type.getValue();
        Notice.Extra r118 = r1.extra;
        String r27 = r25.channel.id;
        r118.getClass();
    L64:
        Notice.Extra r119 = r1.extra;
        r119.c = r25.from_chatter_id;
        r119.g = r25.avatar_key;
        r119.h = r25.new_message_count.intValue();
        goto L94
    L65:
        ChatApplyData r28 = r11.chat_apply_data;
        if (r28 == null) goto L68;
        Notice.Extra r120 = new Notice.Extra();
        r1.extra = r120;
        r120.a = r28.chat_id;
        goto L94
    L68:
        AppFeedData r29 = r11.app_feed_data;
        if (r29 == null) goto L73;
        r1.messageId = r29.message_id;
        r1.createTime = r29.create_time.longValue();
        Notice.Extra r121 = new Notice.Extra();
        r1.extra = r121;
        r121.g = r29.avatar_key;
        Channel r30 = r29.channel;
        if (r30 == null) goto L94;
        r121.i = r30.type.getValue();
        Notice.Extra r122 = r1.extra;
        String r31 = r29.channel.id;
        r122.getClass();
        goto L94
    L73:
        AppFeedCardData r32 = r11.app_feed_card_data;
        if (r32 == null) goto L90;
        AppFeedCardData.AppFeedCardType r33 = r32.type;
        if (r33 != AppFeedCardData.AppFeedCardType.OPEN) goto L78;
    L80:
        Notice.Extra r34 = new Notice.Extra();
        r1.extra = r34;
        r34.m = r32.feed_id;
        Image r35 = r32.avatar;
        if (r35 == null) goto L84;
        com.ss.android.lark.widget.richtext.Image r36 = new com.ss.android.lark.widget.richtext.Image();
        r36.setKey(r35.key);
        r36.setWidth(r35.width.intValue());
        r36.setHeight(r35.height.intValue());
        r36.setUrls(r35.urls);
        r36.setCrypto(r35.crypto);
        r36.setFsUnit(r35.fs_unit);
    L84:
        Image r37 = r32.avatar;
        if (r37 == null) goto L87;
        r1.extra.g = r37.key;
    L87:
        r1.extra.getClass();
        r1.extra.getClass();
        CustomSpeechFile r38 = r32.speech_file;
        if (r38 == null) goto L90;
        Notice.Extra r39 = r1.extra;
        r39.n = r38.file_key;
        r39.o = r38.fs_unit;
        goto L90
    L78:
        if (r33 == AppFeedCardData.AppFeedCardType.DOUBAO) goto L80;
    L90:
        FriendApplicationData r123 = r11.friend_application_data;
        if (r123 == null) goto L94;
        Notice.Extra r40 = new Notice.Extra();
        r1.extra = r40;
        r40.g = r123.avatar_key;
        r123.user_id.getClass();
        r1.title = r123.user_name;
        goto L94
    L11:
        if (r4 == 2) goto L20;
        r6 = 4;
        if (r4 == 3) goto L40;
        if (r4 == 4) goto L19;
        if (r4 != 5) goto L29;
        r6 = 12;
    L29:
        r6 = 1;
        goto L40
    L19:
        r6 = 5;
        goto L40
    L20:
        r6 = 3;
        goto L40
    L22:
        if (r11.mail_data == null) goto L25;
        r6 = 7;
        goto L40
    L25:
        if (r11.doc_image_reply_data == null) goto L28;
        r6 = 9;
        goto L40
    L28:
        if (r11.doc_feed_data != null) goto L29;
        if (r11.chat_apply_data == null) goto L34;
        r6 = 8;
        goto L40
    L34:
        if (r11.app_feed_data == null) goto L37;
        r6 = 10;
        goto L40
    L37:
        if (r11.app_feed_card_data == null) goto L39;
        r6 = 14;
        goto L40
    L39:
        r6 = 6;
    L104:
        return Unit.INSTANCE;
    L106:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
