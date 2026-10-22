package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.api.service.ITranslateService;
import com.ss.android.lark.chat.service.impl.EditMessageService;
import com.ss.android.lark.chat.utils.x0;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatAppContainerV1 implements v, m2b.b {
    public static final ChatAppContainerV1 a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;

    public ChatAppContainerV1() {
    }

    static {
        a = new ChatAppContainerV1();
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.SYNCHRONIZED;
        b = LazyKt.lazy(r0, ChatAppContainerV1$editMessageService$2.INSTANCE);
        c = LazyKt.lazy(r0, ChatAppContainerV1$pushChatRelationListenerManager$2.INSTANCE);
        d = LazyKt.lazy(r0, ChatAppContainerV1$cotFeatureGate$2.INSTANCE);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final x H() {
        return new ChatAppContainerV1$dataPreloadContainer$1();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final x0 Q() {
        return (x0) c.getValue();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final EditMessageService S() {
        return (EditMessageService) b.getValue();
    }

    @Override // m2b.b
    public final <T extends x1b.b> T get() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatAppContainerV1.get");
        return this;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final com.ss.android.lark.chat.cot.a o0() {
        return (com.ss.android.lark.chat.cot.a) d.getValue();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final com.ss.android.lark.translate.service.impl.a A() {
        return (com.ss.android.lark.translate.service.impl.a) e0c.k.a(LarkContext.getApplication(), com.ss.android.lark.translate.service.impl.a.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final ImSdkChatService B() {
        return ImSdkService.b();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final jdb.g C() {
        return FeatureGatingModule.getFeatureGatingService();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final m6b.g D() {
        return (m6b.g) e0c.k.a(LarkContext.getApplication(), m6b.g.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final a2b.o E() {
        return (a2b.o) e0c.k.a(LarkContext.getApplication(), a2b.o.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final a2b.n F() {
        return (a2b.n) e0c.k.a(LarkContext.getApplication(), a2b.n.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final a2b.j G() {
        return (a2b.j) e0c.k.a(LarkContext.getApplication(), a2b.j.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final a2b.l J() {
        return (a2b.l) e0c.k.a(LarkContext.getApplication(), a2b.l.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final com.ss.android.lark.biz.im.api.o0 K() {
        return (com.ss.android.lark.biz.im.api.o0) e0c.k.a(LarkContext.getApplication(), com.ss.android.lark.biz.im.api.o0.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final m6b.u L() {
        return ImSdkService.e();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final w4b.c.o M() {
        return (w4b.c.o) e0c.k.a(LarkContext.getApplication(), w4b.c.o.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final m6b.q N() {
        return (m6b.q) e0c.k.a(LarkContext.getApplication(), m6b.q.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b O() {
        return (com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b) e0c.k.a(LarkContext.getApplication(), com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final a2b.f P() {
        return (a2b.f) e0c.k.a(LarkContext.getApplication(), a2b.f.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final com.ss.android.lark.im.sdk.service.h T() {
        return ImSdkService.d();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final m6b.d V() {
        return (m6b.d) e0c.k.a(LarkContext.getApplication(), m6b.d.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final m6b.m W() {
        return (m6b.m) e0c.k.a(LarkContext.getApplication(), m6b.m.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final z Z() {
        return (z) e0c.k.a(LarkContext.getApplication(), z.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final m6b.t c0() {
        return ImSdkService.c();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final m6b.j f0() {
        return (m6b.j) e0c.k.a(LarkContext.getApplication(), m6b.j.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final String getUserId() {
        return M().userId();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final IChatService j0() {
        return (IChatService) e0c.k.a(LarkContext.getApplication(), IChatService.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final com.ss.android.lark.chat.core.api.d p0() {
        return (com.ss.android.lark.chat.core.api.d) e0c.k.a(LarkContext.getApplication(), com.ss.android.lark.chat.core.api.d.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final IAudioService v() {
        return (IAudioService) e0c.k.a(LarkContext.getApplication(), IAudioService.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final com.ss.android.lark.im.sdk.service.p w() {
        return ImSdkService.f();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final ITranslateService x() {
        return (ITranslateService) e0c.k.a(LarkContext.getApplication(), ITranslateService.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final a2b.c z() {
        return (a2b.c) e0c.k.a(LarkContext.getApplication(), a2b.c.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final b38.b y() {
        return b38.b.a;
    }
}
