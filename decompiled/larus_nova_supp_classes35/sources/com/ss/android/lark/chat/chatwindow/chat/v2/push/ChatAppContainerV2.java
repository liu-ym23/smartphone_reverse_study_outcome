package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.api.service.ITranslateService;
import com.ss.android.lark.chat.service.impl.EditMessageService;
import com.ss.android.lark.chat.service.impl.MessageTenantConfService;
import com.ss.android.lark.chat.utils.x0;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.tab.service.IChatTabService;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class ChatAppContainerV2 implements v, m2b.b {
    public final com.ss.android.lark.translate.service.impl.a A;
    public final m6b.q B;
    public final a2b.c C;
    public final com.ss.android.lark.audio.voiceinput.service.o D;
    public final m6b.a E;
    public final com.ss.android.lark.audio.voiceinput.service.l F;
    public final com.ss.android.lark.tab.service.m G;
    public final com.ss.android.lark.tab.service.i H;
    public final a2b.n I;
    public final com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d J;
    public final a2b.i K;
    public final a2b.l L;
    public final z M;
    public final com.ss.android.lark.chat.core.api.d N;
    public final String a;
    public final b38.b b;
    public final KVRepo c;
    public final w4b.c.o d;
    public final IChatService e;
    public final IAudioService f;
    public final com.ss.android.lark.biz.im.api.o0 g;
    public final m6b.m h;
    public final m6b.g i;
    public final jdb.g j;
    public final com.ss.android.lark.chat.cot.a k;
    public final a2b.f l;
    public final ITranslateService m;
    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b n;
    public final a2b.h o;
    public final a2b.k p;
    public final MessageTenantConfService q;
    public final m6b.n r;
    public final EditMessageService s;
    public final m6b.d t;
    public final x0 u;
    public final IChatTabService v;
    public final com.ss.android.lark.tab.service.l w;
    public final a2b.o x;
    public final a2b.j y;
    public final m6b.t z;

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final x H() {
        return new ChatAppContainerV2$dataPreloadContainer$1(this);
    }

    @Override // m2b.b
    public final <T extends x1b.b> T get() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatAppContainerV2.get");
        return this;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final ImSdkChatService B() {
        return ImSdkService.b();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final m6b.u L() {
        return ImSdkService.e();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final com.ss.android.lark.im.sdk.service.h T() {
        return ImSdkService.d();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final com.ss.android.lark.im.sdk.service.p w() {
        return ImSdkService.f();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final com.ss.android.lark.translate.service.impl.a A() {
        return this.A;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final jdb.g C() {
        return this.j;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final m6b.g D() {
        return this.i;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final a2b.o E() {
        return this.x;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final a2b.n F() {
        return this.I;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final a2b.j G() {
        return this.y;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final a2b.l J() {
        return this.L;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final com.ss.android.lark.biz.im.api.o0 K() {
        return this.g;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final w4b.c.o M() {
        return this.d;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final m6b.q N() {
        return this.B;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b O() {
        return this.n;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final a2b.f P() {
        return this.l;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final x0 Q() {
        return this.u;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final EditMessageService S() {
        return this.s;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final m6b.d V() {
        return this.t;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final m6b.m W() {
        return this.h;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final z Z() {
        return this.M;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final m6b.t c0() {
        return this.z;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final m6b.j f0() {
        return this.q;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final String getUserId() {
        return this.a;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final IChatService j0() {
        return this.e;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final com.ss.android.lark.chat.cot.a o0() {
        return this.k;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final com.ss.android.lark.chat.core.api.d p0() {
        return this.N;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final IAudioService v() {
        return this.f;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final ITranslateService x() {
        return this.m;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final b38.b y() {
        return this.b;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final a2b.c z() {
        return this.C;
    }

    @Inject
    public ChatAppContainerV2(String r17, b38.b r18, KVRepo r19, w4b.c.o r20, IChatService r21, IAudioService r22, com.ss.android.lark.biz.im.api.o0 r23, m6b.m r24, m6b.g r25, jdb.g r26, com.ss.android.lark.chat.cot.a r27, a2b.f r28, ITranslateService r29, com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b r30, a2b.h r31, a2b.k r32, MessageTenantConfService r33, m6b.n r34, EditMessageService r35, m6b.d r36, x0 r37, IChatTabService r38, com.ss.android.lark.tab.service.l r39, a2b.o r40, a2b.j r41, m6b.t r42, com.ss.android.lark.translate.service.impl.a r43, m6b.q r44, a2b.c r45, com.ss.android.lark.audio.voiceinput.service.o r46, m6b.a r47, com.ss.android.lark.audio.voiceinput.service.l r48, com.ss.android.lark.tab.service.m r49, com.ss.android.lark.tab.service.i r50, a2b.n r51, com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d r52, a2b.i r53, a2b.l r54, z r55, com.ss.android.lark.chat.core.api.d r56) {
        Intrinsics.checkNotNullParameter(r18, "rucket");
        Intrinsics.checkNotNullParameter(r19, "imUserKVRepo");
        Intrinsics.checkNotNullParameter(r20, "passportDependency");
        Intrinsics.checkNotNullParameter(r21, "legacyChatService");
        Intrinsics.checkNotNullParameter(r22, "audioService");
        Intrinsics.checkNotNullParameter(r23, "threadService");
        Intrinsics.checkNotNullParameter(r24, "quoteService");
        Intrinsics.checkNotNullParameter(r25, "draftService");
        Intrinsics.checkNotNullParameter(r26, "fgService");
        Intrinsics.checkNotNullParameter(r27, "cotFeatureGate");
        Intrinsics.checkNotNullParameter(r28, "previewService");
        Intrinsics.checkNotNullParameter(r29, "translateService");
        Intrinsics.checkNotNullParameter(r30, "userFieldsService");
        Intrinsics.checkNotNullParameter(r31, "privateDescriptionService");
        Intrinsics.checkNotNullParameter(r32, "storePrivateDescriptionHandlerFactory");
        Intrinsics.checkNotNullParameter(r33, "messageTenantConfService");
        Intrinsics.checkNotNullParameter(r34, "previewVideoService");
        Intrinsics.checkNotNullParameter(r35, "editMessageService");
        Intrinsics.checkNotNullParameter(r36, "chatSubscribeService");
        Intrinsics.checkNotNullParameter(r37, "pushChatRelationListenerManager");
        Intrinsics.checkNotNullParameter(r38, "chatTabService");
        Intrinsics.checkNotNullParameter(r39, "chatTabExtraService");
        Intrinsics.checkNotNullParameter(r40, "userGroupService");
        Intrinsics.checkNotNullParameter(r41, "aiSmartApplyAnswerService");
        Intrinsics.checkNotNullParameter(r42, "chatterPush");
        Intrinsics.checkNotNullParameter(r43, "translatePush");
        Intrinsics.checkNotNullParameter(r44, "threadPush");
        Intrinsics.checkNotNullParameter(r45, "previewPush");
        Intrinsics.checkNotNullParameter(r46, "speechPush");
        Intrinsics.checkNotNullParameter(r47, "audioTextPush");
        Intrinsics.checkNotNullParameter(r48, "newAudioTextPush");
        Intrinsics.checkNotNullParameter(r49, "chatTabPush");
        Intrinsics.checkNotNullParameter(r50, "chatTabExtraPush");
        Intrinsics.checkNotNullParameter(r51, "userGroupPush");
        Intrinsics.checkNotNullParameter(r52, "dataPreloaderManager");
        Intrinsics.checkNotNullParameter(r53, "secretChatDataCorruptPush");
        Intrinsics.checkNotNullParameter(r54, "strangerActionUploader");
        Intrinsics.checkNotNullParameter(r55, "unreadAIDataCache");
        Intrinsics.checkNotNullParameter(r56, "mentionBotsNotInChatCoordinator");
        this.a = r17;
        this.b = r18;
        this.c = r19;
        this.d = r20;
        this.e = r21;
        this.f = r22;
        this.g = r23;
        this.h = r24;
        this.i = r25;
        this.j = r26;
        this.k = r27;
        this.l = r28;
        this.m = r29;
        this.n = r30;
        this.o = r31;
        this.p = r32;
        this.q = r33;
        this.r = r34;
        this.s = r35;
        this.t = r36;
        this.u = r37;
        this.v = r38;
        this.w = r39;
        this.x = r40;
        this.y = r41;
        this.z = r42;
        this.A = r43;
        this.B = r44;
        this.C = r45;
        this.D = r46;
        this.E = r47;
        this.F = r48;
        this.G = r49;
        this.H = r50;
        this.I = r51;
        this.J = r52;
        this.K = r53;
        this.L = r54;
        this.M = r55;
        this.N = r56;
    }
}
