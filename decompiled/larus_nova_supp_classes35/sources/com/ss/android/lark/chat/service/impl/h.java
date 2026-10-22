package com.ss.android.lark.chat.service.impl;

import android.text.TextUtils;
import com.bytedance.lark.pb.im.v1.DoubaoTyping;
import com.bytedance.lark.pb.im.v1.PushDoubaoSmartReply;
import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.bytedance.lark.pb.im.v1.PushMessageReadStates;
import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements m6b.c {
    public final m6b.d a;
    public String b;
    public m6b.o c;
    public final C0113h d;
    public final i e;
    public final c f;
    public final d g;
    public final g h;
    public final f i;
    public final b j;
    public final e k;

    public static final class a {
    }

    public static final class b implements x {
        public final /* synthetic */ h a;

        public b(h r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.service.impl.x
        public final void a(Chat r2, Map<String, ChatChatter> r3) {
            if (r2 == null) goto L8;
            if (r3 == null) goto L9;
            m6b.o r0 = this.a.c;
            if (r0 == null) goto L10;
            r0.h(r2, r3);
            return;
        L10:
            return;
        L9:
            return;
        }
    }

    public static final class c implements y {
        public final /* synthetic */ h a;

        public c(h r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.service.impl.y
        public final void onPushChat(Chat r2) {
            if (r2 == null) goto L7;
            m6b.o r0 = this.a.c;
            if (r0 == null) goto L8;
            r0.onPushChat(r2);
            return;
        L8:
            return;
        }

        @Override // com.ss.android.lark.chat.service.impl.y
        public final void onPushThreadTopic(ThreadTopic r2) {
            if (r2 == null) goto L7;
            m6b.o r0 = this.a.c;
            if (r0 == null) goto L8;
            r0.onPushThreadTopic(r2);
            return;
        L8:
            return;
        }
    }

    public static final class d implements z {
        public final /* synthetic */ h a;

        public d(h r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.service.impl.z
        public final void onPushChatRemoveMe(Chat r2) {
            if (r2 == null) goto L7;
            m6b.o r0 = this.a.c;
            if (r0 == null) goto L8;
            r0.onPushChatRemoveMe(r2);
            return;
        L8:
            return;
        }

        @Override // com.ss.android.lark.chat.service.impl.z
        public final void a(Chat r2, Map<String, ChatChatter> r3) {
            if (r2 == null) goto L8;
            if (r3 == null) goto L9;
            m6b.o r0 = this.a.c;
            if (r0 == null) goto L10;
            r0.g(r2, r3);
            return;
        L10:
            return;
        L9:
            return;
        }
    }

    public static final class e implements a0 {
        public final /* synthetic */ h a;

        public e(h r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.service.impl.a0
        public final void a(Chat r2, Map<String, ChatChatter> r3) {
            if (r2 == null) goto L8;
            if (r3 == null) goto L9;
            m6b.o r0 = this.a.c;
            if (r0 == null) goto L10;
            r0.i(r2, r3);
            return;
        L10:
            return;
        L9:
            return;
        }
    }

    public static final class f implements c0 {
        public final /* synthetic */ h a;

        public f(h r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.service.impl.c0
        public final void d(PushDoubaoSmartReply r2) {
            Intrinsics.checkNotNullParameter(r2, "push");
            m6b.o r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.d(r2);
            return;
        }
    }

    public static final class g implements d0 {
        public final /* synthetic */ h a;

        public g(h r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.service.impl.d0
        public final void e(DoubaoTyping r2) {
            Intrinsics.checkNotNullParameter(r2, "doubaoTyping");
            m6b.o r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.e(r2);
            return;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.service.impl.h$h, reason: collision with other inner class name */
    public static final class C0113h implements com.ss.android.lark.biz.im.api.k0 {
        public final /* synthetic */ h a;

        public C0113h(h r1) {
            this.a = r1;
        }

        public final void a(com.ss.android.lark.biz.im.api.g1 r2) {
            Intrinsics.checkNotNullParameter(r2, "pushMessageDTO");
            m6b.o r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.a(r2);
            return;
        }

        public final void b(PushMessageReadStates r2) {
            Intrinsics.checkNotNullParameter(r2, "readStates");
            m6b.o r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.b(r2);
            return;
        }

        public final void f(PushMessageReactions r2) {
            Intrinsics.checkNotNullParameter(r2, "reactions");
            m6b.o r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.f(r2);
            return;
        }
    }

    public static final class i implements g0 {
        public final /* synthetic */ h a;

        public i(h r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.service.impl.g0
        public final void c(MessageInfo r2) {
            m6b.o r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.c(r2);
            return;
        }
    }

    static {
    }

    public final void g() {
        ImSdkService.a().b3(this.f);
        ImSdkService.a().O5(this.f);
        ImSdkService.e().O3(this.d);
        ImSdkService.e().kd(this.e);
        ImSdkService.a().Z4(this.g);
        ImSdkService.a().Cc(this.j);
        ImSdkService.a().Gb(this.k);
        ImSdkService.a().V2(this.h);
        ImSdkService.a().k5(this.i);
    }

    public h(m6b.d r2) {
        Intrinsics.checkNotNullParameter(r2, "chatSubscriber");
        this.a = r2;
        this.d = new C0113h(this);
        this.e = new i(this);
        this.f = new c(this);
        this.g = new d(this);
        this.h = new g(this);
        this.i = new f(this);
        this.j = new b(this);
        this.k = new e(this);
    }

    @Override // m6b.c
    public final void b(String r2) {
        if (r2 != null) goto L4;
    L6:
        g();
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L6;
        h(r2, null);
        goto L6
    }

    public final void e(m6b.o r2) {
        this.c = r2;
        ImSdkService.a().b3(this.f);
        ImSdkService.a().ke(this.f);
        ImSdkService.a().O5(this.f);
        ImSdkService.a().c1(this.f);
        ImSdkService.e().O3(this.d);
        ImSdkService.e().gc(this.d);
        ImSdkService.e().kd(this.e);
        ImSdkService.e().K3(this.e);
        ImSdkService.a().Z4(this.g);
        ImSdkService.a().Qa(this.g);
        ImSdkService.a().Cc(this.j);
        ImSdkService.a().O1(this.j);
        ImSdkService.a().Gb(this.k);
        ImSdkService.a().ha(this.k);
        ImSdkService.a().V2(this.h);
        ImSdkService.a().W6(this.h);
        ImSdkService.a().k5(this.i);
        ImSdkService.a().Nd(this.i);
    }

    @Override // m6b.c
    public final void c(String r2, aqb.a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (r2 != null) goto L5;
    L7:
        e(r3);
        return;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L7;
        f(r2, null);
        goto L7
    }

    @Override // m6b.c
    public final void d(String r2, SubscribeChatEventRequest.SubscriptionKey r3) {
        Intrinsics.checkNotNullParameter(r3, "subscriptionKey");
        if (r2 != null) goto L5;
    L7:
        g();
        return;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L7;
        h(r2, r3);
        goto L7
    }

    public final void f(String r3, SubscribeChatEventRequest.SubscriptionKey r4) {
        Log.i("ChatRelationPushSubscriber", "subscribeChat old chat id: " + this.b + " new chat id: " + r3);
        if (TextUtils.isEmpty(this.b) == true) goto L8;
        if (Intrinsics.areEqual(this.b, r3) == false) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(this.b) == true) goto L13;
        if (Intrinsics.areEqual(this.b, r3) == true) goto L13;
        this.a.z9(this.b, r4);
    L13:
        if (TextUtils.isEmpty(r3) == true) goto L16;
        this.a.K6(r3, r4);
        this.b = r3;
        return;
    }

    public final void h(String r3, SubscribeChatEventRequest.SubscriptionKey r4) {
        Log.i("ChatRelationPushSubscriber", "unSubscribeChat cur chat id: " + this.b + " new unSubscribeC hat id: " + r3);
        if (TextUtils.isEmpty(this.b) == false) goto L5;
    L7:
        Log.e("ChatRelationPushSubscriber", "unSubscribeChat : mSubscribedChatId = " + this.b + " and getChatId = " + r3);
        return;
    L5:
        if (Intrinsics.areEqual(this.b, r3) == false) goto L7;
        this.a.z9(this.b, r4);
        this.b = null;
    }

    @Override // m6b.c
    public final void a(String r2, SubscribeChatEventRequest.SubscriptionKey r3, m6b.o r4) {
        Intrinsics.checkNotNullParameter(r3, "subscriptionKey");
        Intrinsics.checkNotNullParameter(r4, "listener");
        if (r2 != null) goto L5;
    L7:
        e(r4);
        return;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L7;
        f(r2, r3);
        goto L7
    }
}
