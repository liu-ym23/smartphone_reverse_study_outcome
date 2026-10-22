package com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare;

import android.util.LruCache;
import com.larksuite.framework.utils.i0;
import com.ss.android.lark.biz.im.api.ChatWindowPrepareData;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.biz.im.api.h0;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.thread.TopicGroup;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.h;
import com.ss.android.lark.im.sdk.service.x;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.passportc.dwarf.UserScope;
import h7b.j;
import javax.inject.Inject;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import m6b.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class a implements com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.b, r {
    public static final /* synthetic */ int k = 0;
    public final m a;
    public final String b;
    public final ImSdkChatService c;
    public final h d;
    public final x e;
    public final t f;
    public CoroutineScope g;
    public final LruCache<String, Chat> h;
    public final i0<ChatChatter> i;
    public final b j;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.a$a, reason: collision with other inner class name */
    public static final class C0055a {
    }

    public static final class b implements h0 {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void a(Chatter r7) {
            a r0 = this.a;
            r0.getClass();
            if (r7 != null) goto L6;
            return;
        L6:
            if ((r7 instanceof ChatChatter) == false) goto L14;
            ChatChatter r8 = (ChatChatter) r7;
            ChatChatter r1 = (ChatChatter) r0.i.a(r8.getChatId(), r8.getId());
            if (r1 != null) goto L11;
            return;
        L11:
            if (r1.getUpdateTime() > r8.getUpdateTime()) goto L15;
            r0.i.b(r8.getId(), r8.getId(), r8);
            return;
        L15:
            return;
        }
    }

    static {
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final m getPassport() {
        return this.a;
    }

    public final ChatWindowPrepareData c(String r8) {
        com.ss.android.lark.chat.entity.chat.a r0 = this.c.nd(r8);
        if (r0 != null) goto L6;
        Log.e("ChatPrepareDataLoader", "prepare botChat in ChatWindow , but cannot get botChat" + r8);
        return null;
    L6:
        Chat r3 = r0.a;
        if (r3 == null) goto L10;
        this.h.put(r8, r3);
    L10:
        if (this.i.a(r8, this.b) != null) goto L12;
        i0<ChatChatter> r4 = this.i;
        String r5 = this.b;
        r4.b(r8, r5, this.d.He(r8, r5));
    L12:
        if (r3 != null) goto L16;
        Log.e("ChatPrepareDataLoader", "prepare chat in ChatWindow , but cannot get chat" + r8);
        return null;
    L16:
        if (r3.getType() != Chat.Type.P2P) goto L28;
        String r1 = this.c.getOtherP2PChatterId(r3);
        if (r1 != null) goto L22;
        return b(r8, r0.b, r0.d);
    L22:
        if (this.i.a(r8, r1) != null) goto L28;
        Chatter r2 = r0.c;
        if (r2 == null) goto L26;
        this.i.b(r8, r1, new ChatChatter(r2));
        goto L28
    L26:
        this.i.b(r8, r1, this.d.He(r8, r1));
    L28:
        return b(r8, r0.b, r0.d);
    }

    public final void onUserOffline(f0c.h r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r3, "state");
        this.f.te(this.j);
        CoroutineScope r4 = this.g;
        if (r4 == null) goto L5;
        CoroutineScopeKt.cancel$default(r4, null, 1, null);
    L5:
        this.g = null;
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r2, "state");
        this.f.J1(this.j);
        this.g = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.b
    public final ChatWindowPrepareData a(String r1, Continuation r2) {
        return c(r1);
    }

    public final ChatWindowPrepareData b(String r9, OpenApp r10, ChatThemeInfo r11) {
        ChatChatter r4 = (ChatChatter) this.i.a(r9, this.b);
        Chat r2 = this.h.get(r9);
        if (r2.getType() != Chat.Type.P2P) goto L17;
        Intrinsics.checkNotNull(r2);
        j.a r12 = new j(r2, this.d).a();
        if (r12 == null) goto L7;
        ChatChatter r1 = r12.a;
    L8:
        if (r1 != null) goto L10;
        Log.e("ChatPrepareDataLoader", "opening p2p chat in ChatWindow , but cannot get chatter");
        return null;
    L10:
        ChatChatter r3 = r12.a;
        OpenApp r13 = r12.b;
        if (r13 != null) goto L13;
        OpenApp r5 = r10;
    L15:
        return new ChatWindowPrepareData(r2, r3, r4, r5, null, r11);
    L13:
        r5 = r13;
        goto L15
    L7:
        r1 = null;
        goto L8
    L17:
        if (r2.getChatMode() != Chat.ChatMode.THREAD_V2) goto L26;
        TopicGroup r6 = this.e.fc(r9);
        if (r6 != null) goto L21;
    L23:
        Log.i("ChatPrepareDataLoader", "prepare chat from cache chat");
        return new ChatWindowPrepareData(r2, null, r4, r10, r6, r11);
    L21:
        if (r6.getChat() == null) goto L23;
        Log.i("ChatPrepareDataLoader", "prepare chat from topGroup");
        return new ChatWindowPrepareData(r6.getChat(), null, r4, r10, r6, r11);
    L26:
        return new ChatWindowPrepareData(r2, null, r4, r10, null, r11);
    }

    @Inject
    public a(m r2, String r3, ImSdkChatService r4, h r5, x r6, t r7) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r4, "chatService");
        Intrinsics.checkNotNullParameter(r5, "chatterService");
        Intrinsics.checkNotNullParameter(r6, "threadService");
        Intrinsics.checkNotNullParameter(r7, "chatterPush");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        r2.d(this);
        this.h = new LruCache(200);
        this.i = new i0();
        this.j = new b(this);
    }
}
