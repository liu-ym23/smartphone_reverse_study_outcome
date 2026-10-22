package com.larus.bmhome.chat.component.list;

import android.content.Context;
import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.im.bean.bot.BotModel;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import td8.d;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatListComponentViewModel$g implements d {
    public final /* synthetic */ ChatListComponentViewModel a;
    public final /* synthetic */ String b;
    public final /* synthetic */ wc9.e c;
    public final /* synthetic */ BotModel d;
    public final /* synthetic */ long e;
    public final /* synthetic */ com.larus.bmhome.social.page.datasource.event.c<b> f;

    @Override // td8.d
    public final boolean E8() {
        return ChatListComponentViewModel.access$isServiceBot$p(this.a);
    }

    @Override // td8.d
    public final boolean Pa() {
        if (ChatListComponentViewModel.access$isCleared$p(this.a) == false) goto L5;
        return false;
    L5:
        Function0 r0 = ChatListComponentViewModel.access$getShouldForceLoadingWhenStreamingProvider$p(this.a);
        if (r0 != null) goto L8;
        return false;
    L8:
        if (((Boolean) r0.invoke()).booleanValue() != true) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // td8.d
    public final long b() {
        return ChatListComponentViewModel.access$getCurrentChatKey$p(this.a);
    }

    @Override // td8.d
    public final boolean c() {
        return ChatListComponentViewModel.access$isImmersive$p(this.a);
    }

    @Override // td8.d
    public final int d() {
        if (ChatListComponentViewModel.access$isCleared$p(this.a) == false) goto L5;
        return -1;
    L5:
        Function0 r0 = ChatListComponentViewModel.access$getFilterSugTypeProvider$p(this.a);
        if (r0 != null) goto L8;
        return -1;
    L8:
        return ((Number) r0.invoke()).intValue();
    }

    @Override // td8.d
    public final boolean e() {
        return ChatListComponentViewModel.access$isLoadCompleted$p(this.a);
    }

    @Override // td8.d
    public final Map<Object, Object> extraInfo() {
        return ChatListComponentViewModel.access$getExtraInfo$p(this.a);
    }

    @Override // td8.d
    public final va8.p0 f() {
        if (ChatListComponentViewModel.access$isCleared$p(this.a) == false) goto L5;
        return null;
    L5:
        Function0 r0 = ChatListComponentViewModel.access$getPreviewRoundMessageFilterConfigProvider$p(this.a);
        if (r0 != null) goto L8;
        return null;
    L8:
        return (va8.p0) r0.invoke();
    }

    @Override // td8.d
    public final FloatChatWindowState h() {
        if (ChatListComponentViewModel.access$isCleared$p(this.a) == false) goto L5;
        return null;
    L5:
        Function0 r0 = ChatListComponentViewModel.access$getWindowStateProvider$p(this.a);
        if (r0 != null) goto L8;
        return null;
    L8:
        return (FloatChatWindowState) r0.invoke();
    }

    @Override // td8.d
    public final long i() {
        wc9.e r0 = this.c;
        if (r0 == null) goto L8;
        Long r1 = r0.o;
        if (r1 == null) goto L8;
        return r1.longValue();
    L8:
        return this.e;
    }

    @Override // td8.d
    public final Context j() {
        if (ChatListComponentViewModel.access$isCleared$p(this.a) == false) goto L5;
        return null;
    L5:
        Function0 r0 = ChatListComponentViewModel.access$getGetUIContext$p(this.a);
        if (r0 != null) goto L8;
        return null;
    L8:
        return (Context) r0.invoke();
    }

    @Override // td8.d
    public final boolean k() {
        return ChatListComponentViewModel.access$getShowLastRoundChatInImmersiveStyle$p(this.a);
    }

    @Override // td8.d
    public final com.larus.bmhome.social.userchat.model.c0 l() {
        return ChatListComponentViewModel.access$getChatMessageReceiverRepo$p(this.a);
    }

    @Override // td8.d
    public final String m() {
        return ChatListComponentViewModel.access$getPushContentId$p(this.a);
    }

    @Override // td8.d
    public final b n() {
        return (b) CollectionsKt.lastOrNull(this.f.a);
    }

    @Override // td8.d
    public final long o() {
        return ChatListComponentViewModel.access$getCurrentChatSession$p(this.a);
    }

    @Override // td8.d
    public final boolean q() {
        return ChatListComponentViewModel.access$isRegen$p(this.a);
    }

    @Override // td8.d
    public final BotModel a() {
        return this.d;
    }

    @Override // td8.d
    public final wc9.e g() {
        return this.c;
    }

    @Override // td8.d
    public final String p() {
        return this.b;
    }

    public ChatListComponentViewModel$g(ChatListComponentViewModel r1, String r2, wc9.e r3, BotModel r4, long r5, com.larus.bmhome.social.page.datasource.event.c<b> r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r7;
    }
}
