package com.ss.android.lark.im.sdk.message.send;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Channel;
import com.bytedance.lark.pb.basic.v1.CreateScene;
import com.bytedance.lark.pb.basic.v1.QuasiContent;
import com.bytedance.lark.pb.im.v1.CreateQuasiMessageRequest;
import com.bytedance.lark.pb.im.v1.QuasiMessageExtraData;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.chat.entity.message.LarkAgentContext;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.service.impl.b1;
import com.ss.android.lark.chat.service.impl.h1;
import com.ss.android.lark.chat.service.impl.j1;
import com.ss.android.lark.chat.utils.n0;
import com.ss.android.lark.im.sdk.service.o;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements jkb.d<k> {
    public static final /* synthetic */ int b = 0;
    public final b a;

    public static final class a {
    }

    public interface b {
        SdkSender.d<l5b.c> a(CreateQuasiMessageRequest.Builder r1, String r2, com.ss.android.lark.sdk.h r3);
    }

    static {
    }

    @Override // jkb.d
    public final String getName() {
        return "SdkCreatePreMessageStep";
    }

    public j(b r2) {
        Intrinsics.checkNotNullParameter(r2, "quasiMessageSdkCreator");
        this.a = r2;
    }

    @Override // jkb.d
    public final void a(jkb.b r9, jkb.c r10) {
        k r11 = (k) r9;
        Intrinsics.checkNotNullParameter(r11, "pipelineContext");
        Intrinsics.checkNotNullParameter(r10, "pipelineControl");
        o r0 = r11.b;
        MessageInfo r1 = r11.c;
        MessageInfo r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getcId();
    L6:
        r0.d(r3, r11.a);
        String r4 = r0.e();
        MessageParams<?, ?> r5 = r11.a;
        Intrinsics.checkNotNullParameter(r5, "messageParams");
        Log.i("SdkCreatePreMessageStep", "savePreMessageAndRelation");
        monitor-enter(b1.class);
    L55:
        th = move-exception;
        throw th;
    L9:
        if (b1.a != null) goto L11;
        j1 r6 = new j1(new b1.h());     // Catch: Throwable -> L55
        b1.a = r6;     // Catch: Throwable -> L55
        r6.a(Message.Type.TEXT, new b1.m());     // Catch: Throwable -> L55
        b1.a.a(Message.Type.AUDIO, new b1.a());     // Catch: Throwable -> L55
        b1.a.a(Message.Type.IMAGE, new b1.e());     // Catch: Throwable -> L55
        b1.a.a(Message.Type.POST, new b1.i());     // Catch: Throwable -> L55
        b1.a.a(Message.Type.STICKER, new b1.l());     // Catch: Throwable -> L55
        b1.a.a(Message.Type.FILE, new b1.d());     // Catch: Throwable -> L55
        b1.a.a(Message.Type.SHARE_GROUP_CHAT, new b1.k());     // Catch: Throwable -> L55
        b1.a.a(Message.Type.MEDIA, new b1.g());     // Catch: Throwable -> L55
        b1.a.a(Message.Type.CARD, new b1.c());     // Catch: Throwable -> L55
        b1.a.a(Message.Type.LOCATION, new b1.f());     // Catch: Throwable -> L55
        b1.a.a(Message.Type.SHARE_USER_CARD, new b1.j());     // Catch: Throwable -> L55
    L11:
        j1 r7 = b1.a;     // Catch: Throwable -> L55
        monitor-exit(b1.class);
        j1.a r8 = r7.b;
        if (r8 == null) goto L18;
        m6b.k r12 = (m6b.k) ((HashMap) r7.a).get(r8.a(r5));
        if (r12 == null) goto L18;
        Object r13 = r12.transform(r5);
    L19:
        k5b.f r14 = (k5b.f) r13;
        if (r14 != null) goto L22;
        SdkSender.d r15 = new SdkSender.d();
    L35:
        MessageInfo r16 = (MessageInfo) r15.a;
        ErrorResult r17 = r15.b;
        int r18 = 500500;
        if (r17 == null) goto L47;
        String r19 = r17.getMessage();
        if (r19 != null) goto L40;
        r19 = "SDK create pre-message failed";
    L40:
        com.ss.android.lark.im.sdk.a.a("SdkCreatePreMessageStep", r19);
        Integer r20 = Integer.valueOf(r15.b.getCode());
        if (r20 != null) goto L43;
    L46:
        r10.b(new jkb.e(r19, Integer.valueOf(r18), true));
        return;
    L43:
        if (r20.intValue() == 0) goto L46;
        r18 = r20.intValue();
        goto L46
    L47:
        if (r16 != null) goto L49;
        com.ss.android.lark.im.sdk.a.a("SdkCreatePreMessageStep", "SDK create pre-message failed");
        r10.b(new jkb.e("SDK create pre-message failed", 500500, true));
        return;
    L49:
        Log.i("SdkCreatePreMessageStep", "SDK create pre-message successfully");
        r11.c = r16;
        com.ss.android.lark.im.sdk.a.b("SdkCreatePreMessageStep", "Config pre-process key for message");
        com.ss.android.lark.biz.im.api.n r21 = r11.a;
        if ((r21 instanceof com.ss.android.lark.biz.im.api.n) == false) goto L52;
        String r22 = r21.a();
        com.ss.android.lark.im.sdk.a.b("SdkCreatePreMessageStep", "MessageParams's pro-process key is " + r22);
        MessageInfo r23 = r11.c;
        Intrinsics.checkNotNull(r23);
        r23.getMessage().setPreprocessKey(r22);
    L53:
        r0.l(r16.getcId());
        r10.a();
        return;
    L52:
        com.ss.android.lark.im.sdk.a.b("SdkCreatePreMessageStep", "MessageParams !is HasPreProcessKey");
        goto L53
    L22:
        boolean r24 = n0.a;
        Intrinsics.checkNotNullParameter(r5, "params");
        MessageParams.CreateScene r25 = r5.n;
        if (r25 != null) goto L25;
    L27:
        CreateScene r26 = null;
    L28:
        r14.k = r26;
        SdkSender.d<l5b.c> r27 = b(r4, r14);
        if (r27.b == null) goto L31;
        SdkSender.d r28 = new SdkSender.d();
        Log.e("SdkCreatePreMessageStep", "savePreMessageAndRelation failed: cid is " + r14.d);
        r28.b = r27.b;
        r15 = r28;
        goto L35
    L31:
        SdkSender.d r29 = new SdkSender.d();
        l5b.c r30 = (l5b.c) r27.a;
        if (r30 == null) goto L34;
        r2 = r30.a;
    L34:
        r29.a = r2;
        r15 = r29;
        goto L35
    L25:
        if (r25 == MessageParams.CreateScene.NORMAL) goto L27;
        r26 = CreateScene.fromValue(r25.getNumber());
    L18:
        r13 = null;
        goto L19
    L5:
        r3 = null;
        goto L6
    }

    public final SdkSender.d<l5b.c> b(String r7, k5b.f r8) {
        Log.i("SdkCreatePreMessageStep", "putPreMessage");
        String r0 = r8.d;
        if (r0 != null) goto L5;
    L8:
        CreateQuasiMessageRequest.Builder r1 = new CreateQuasiMessageRequest.Builder().type(com.bytedance.lark.pb.basic.v1.Message.Type.UNKNOWN);
        QuasiContent.Builder r2 = new QuasiContent.Builder();
        monitor-enter(h1.class);
    L64:
        th = move-exception;
        throw th;
    L11:
        if (h1.a != null) goto L13;
        j1 r3 = new j1(new h1.h());     // Catch: Throwable -> L64
        h1.a = r3;     // Catch: Throwable -> L64
        r3.a(Message.Type.TEXT, new h1.m());     // Catch: Throwable -> L64
        h1.a.a(Message.Type.AUDIO, new h1.a());     // Catch: Throwable -> L64
        h1.a.a(Message.Type.IMAGE, new h1.e());     // Catch: Throwable -> L64
        h1.a.a(Message.Type.POST, new h1.i());     // Catch: Throwable -> L64
        h1.a.a(Message.Type.STICKER, new h1.l());     // Catch: Throwable -> L64
        h1.a.a(Message.Type.FILE, new h1.d());     // Catch: Throwable -> L64
        h1.a.a(Message.Type.SHARE_GROUP_CHAT, new h1.k());     // Catch: Throwable -> L64
        h1.a.a(Message.Type.MEDIA, new h1.g());     // Catch: Throwable -> L64
        h1.a.a(Message.Type.CARD, new h1.c());     // Catch: Throwable -> L64
        h1.a.a(Message.Type.LOCATION, new h1.f());     // Catch: Throwable -> L64
        h1.a.a(Message.Type.SHARE_USER_CARD, new h1.j());     // Catch: Throwable -> L64
    L13:
        j1 r4 = h1.a;     // Catch: Throwable -> L64
        monitor-exit(h1.class);
        j1.a r5 = r4.b;
        if (r5 == null) goto L18;
        m6b.k r6 = (m6b.k) ((HashMap) r4.a).get(r5.a(r8));
    L19:
        h1.b r9 = (h1.b) r6;
        r9.a = r1;
        r9.b = r2;
        r6.transform(r8);
        Map r10 = r8.t;
        if (r10 != null) goto L22;
    L27:
        Map r11 = r8.u;
        if (r11 != null) goto L30;
    L35:
        Channel.Builder r12 = new Channel.Builder();
        String r13 = r8.g;
        if (r13 != null) goto L38;
        r13 = "";
    L38:
        CreateQuasiMessageRequest.Builder r14 = r1.channel(r12.id(r13).type(Channel.Type.fromValue(r8.f.getNumber())).build()).chat_id(r8.c);
        String r15 = r8.a;
        if (r15 != null) goto L41;
        r15 = "";
    L41:
        CreateQuasiMessageRequest.Builder r16 = r14.root_id(r15);
        String r17 = r8.b;
        if (r17 != null) goto L44;
        r17 = "";
    L44:
        r16.parent_id(r17).thread_id(r8.h).is_anonymous(Boolean.valueOf(r8.i)).is_reply_in_thread(Boolean.valueOf(r8.j)).create_scene(r8.k).content(r2.build()).ai_chat_mode_id(r8.l).ai_info_context(null).transmit_to_chat(Boolean.valueOf(r8.n)).partial_reply_info(r8.o).has_ai_reply(Boolean.valueOf(r8.p)).is_mention_doubao(Boolean.valueOf(r8.q)).send_with_queue_id(r8.r);
        Boolean r18 = r8.s;
        if (r18 == null) goto L47;
        boolean r19 = r18.booleanValue();
        r1.is_last_in_batch(Boolean.valueOf(r19));
        Log.i("SdkCreatePreMessageStep", "[MessageBatch] create quasi message, queueId=" + r8.r + ", isLastInBatch=" + r19);
    L47:
        LarkAgentContext r20 = r8.m;
        if (r20 == null) goto L54;
        int r21 = bcb.a.a;
        Intrinsics.checkNotNullParameter(r20, "<this>");
        com.bytedance.lark.pb.basic.v1.LarkAgentContext.Builder r22 = new com.bytedance.lark.pb.basic.v1.LarkAgentContext.Builder();
        String r23 = r20.getActiveChatId();
        if (r23 == null) goto L52;
        r22.active_chat_id(r23);
    L52:
        r1.lark_agent_context(r22.build());
    L54:
        if (r8.e != Message.Type.IMAGE) goto L58;
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.request.ImageMessageRequest");
        if (((k5b.c) r8).y == false) goto L58;
        r1.image_compressed_size_kb(1L);
    L58:
        StringBuilder r24 = new StringBuilder();
        if (TextUtils.isEmpty(r7) == true) goto L61;
        String r25 = r7 + '_';
    L62:
        r24.append(r25);
        r24.append(com.ss.android.lark.sdk.a.a());
        String r26 = r24.toString();
        com.ss.android.lark.sdk.h r27 = new com.ss.android.lark.sdk.h();
        Intrinsics.checkNotNull(r1);
        return this.a.a(r1, r26, r27);
    L61:
        r25 = "";
        goto L62
    L30:
        if ((!r11.isEmpty()) == true) goto L33;
        r11 = null;
    L33:
        if (r11 == null) goto L35;
        r1.extra_data(new QuasiMessageExtraData.Builder().url_preview_entities(r11).build());
        goto L35
    L22:
        if ((!r10.isEmpty()) == true) goto L25;
        r10 = null;
    L25:
        if (r10 == null) goto L27;
        r2.url_preview_hang_point_map(r10);
        goto L27
    L18:
        r6 = null;
        goto L19
    L5:
        if (r0.length() >= 15) goto L8;
        return new SdkSender.d();
    }
}
