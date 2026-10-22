package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.api.service.ITranslateService;
import com.ss.android.lark.chat.service.impl.EditMessageService;
import com.ss.android.lark.chat.service.impl.MessageTenantConfService;
import com.ss.android.lark.chat.utils.x0;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.tab.service.IChatTabService;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatAppContainerV2_Factory implements Factory<ChatAppContainerV2> {
    private final Provider<a2b.j> aiSmartApplyAnswerServiceProvider;
    private final Provider<IAudioService> audioServiceProvider;
    private final Provider<m6b.a> audioTextPushProvider;
    private final Provider<m6b.d> chatSubscribeServiceProvider;
    private final Provider<com.ss.android.lark.tab.service.i> chatTabExtraPushProvider;
    private final Provider<com.ss.android.lark.tab.service.l> chatTabExtraServiceProvider;
    private final Provider<com.ss.android.lark.tab.service.m> chatTabPushProvider;
    private final Provider<IChatTabService> chatTabServiceProvider;
    private final Provider<m6b.t> chatterPushProvider;
    private final Provider<com.ss.android.lark.chat.cot.a> cotFeatureGateProvider;
    private final Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d> dataPreloaderManagerProvider;
    private final Provider<m6b.g> draftServiceProvider;
    private final Provider<EditMessageService> editMessageServiceProvider;
    private final Provider<jdb.g> fgServiceProvider;
    private final Provider<KVRepo> imUserKVRepoProvider;
    private final Provider<IChatService> legacyChatServiceProvider;
    private final Provider<com.ss.android.lark.chat.core.api.d> mentionBotsNotInChatCoordinatorProvider;
    private final Provider<MessageTenantConfService> messageTenantConfServiceProvider;
    private final Provider<com.ss.android.lark.audio.voiceinput.service.l> newAudioTextPushProvider;
    private final Provider<w4b.c.o> passportDependencyProvider;
    private final Provider<a2b.c> previewPushProvider;
    private final Provider<a2b.f> previewServiceProvider;
    private final Provider<m6b.n> previewVideoServiceProvider;
    private final Provider<a2b.h> privateDescriptionServiceProvider;
    private final Provider<x0> pushChatRelationListenerManagerProvider;
    private final Provider<m6b.m> quoteServiceProvider;
    private final Provider<b38.b> rucketProvider;
    private final Provider<a2b.i> secretChatDataCorruptPushProvider;
    private final Provider<com.ss.android.lark.audio.voiceinput.service.o> speechPushProvider;
    private final Provider<a2b.k> storePrivateDescriptionHandlerFactoryProvider;
    private final Provider<a2b.l> strangerActionUploaderProvider;
    private final Provider<m6b.q> threadPushProvider;
    private final Provider<com.ss.android.lark.biz.im.api.o0> threadServiceProvider;
    private final Provider<com.ss.android.lark.translate.service.impl.a> translatePushProvider;
    private final Provider<ITranslateService> translateServiceProvider;
    private final Provider<z> unreadAIDataCacheProvider;
    private final Provider<com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b> userFieldsServiceProvider;
    private final Provider<a2b.n> userGroupPushProvider;
    private final Provider<a2b.o> userGroupServiceProvider;
    private final Provider<String> userIdProvider;

    public ChatAppContainerV2 get() {
        return newInstance((String) this.userIdProvider.get(), (b38.b) this.rucketProvider.get(), (KVRepo) this.imUserKVRepoProvider.get(), (w4b.c.o) this.passportDependencyProvider.get(), (IChatService) this.legacyChatServiceProvider.get(), (IAudioService) this.audioServiceProvider.get(), (com.ss.android.lark.biz.im.api.o0) this.threadServiceProvider.get(), (m6b.m) this.quoteServiceProvider.get(), (m6b.g) this.draftServiceProvider.get(), (jdb.g) this.fgServiceProvider.get(), (com.ss.android.lark.chat.cot.a) this.cotFeatureGateProvider.get(), (a2b.f) this.previewServiceProvider.get(), (ITranslateService) this.translateServiceProvider.get(), (com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b) this.userFieldsServiceProvider.get(), (a2b.h) this.privateDescriptionServiceProvider.get(), (a2b.k) this.storePrivateDescriptionHandlerFactoryProvider.get(), (MessageTenantConfService) this.messageTenantConfServiceProvider.get(), (m6b.n) this.previewVideoServiceProvider.get(), (EditMessageService) this.editMessageServiceProvider.get(), (m6b.d) this.chatSubscribeServiceProvider.get(), (x0) this.pushChatRelationListenerManagerProvider.get(), (IChatTabService) this.chatTabServiceProvider.get(), (com.ss.android.lark.tab.service.l) this.chatTabExtraServiceProvider.get(), (a2b.o) this.userGroupServiceProvider.get(), (a2b.j) this.aiSmartApplyAnswerServiceProvider.get(), (m6b.t) this.chatterPushProvider.get(), (com.ss.android.lark.translate.service.impl.a) this.translatePushProvider.get(), (m6b.q) this.threadPushProvider.get(), (a2b.c) this.previewPushProvider.get(), (com.ss.android.lark.audio.voiceinput.service.o) this.speechPushProvider.get(), (m6b.a) this.audioTextPushProvider.get(), (com.ss.android.lark.audio.voiceinput.service.l) this.newAudioTextPushProvider.get(), (com.ss.android.lark.tab.service.m) this.chatTabPushProvider.get(), (com.ss.android.lark.tab.service.i) this.chatTabExtraPushProvider.get(), (a2b.n) this.userGroupPushProvider.get(), (com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d) this.dataPreloaderManagerProvider.get(), (a2b.i) this.secretChatDataCorruptPushProvider.get(), (a2b.l) this.strangerActionUploaderProvider.get(), (z) this.unreadAIDataCacheProvider.get(), (com.ss.android.lark.chat.core.api.d) this.mentionBotsNotInChatCoordinatorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m483get() {
        return get();
    }

    public ChatAppContainerV2_Factory(Provider<String> r3, Provider<b38.b> r4, Provider<KVRepo> r5, Provider<w4b.c.o> r6, Provider<IChatService> r7, Provider<IAudioService> r8, Provider<com.ss.android.lark.biz.im.api.o0> r9, Provider<m6b.m> r10, Provider<m6b.g> r11, Provider<jdb.g> r12, Provider<com.ss.android.lark.chat.cot.a> r13, Provider<a2b.f> r14, Provider<ITranslateService> r15, Provider<com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b> r16, Provider<a2b.h> r17, Provider<a2b.k> r18, Provider<MessageTenantConfService> r19, Provider<m6b.n> r20, Provider<EditMessageService> r21, Provider<m6b.d> r22, Provider<x0> r23, Provider<IChatTabService> r24, Provider<com.ss.android.lark.tab.service.l> r25, Provider<a2b.o> r26, Provider<a2b.j> r27, Provider<m6b.t> r28, Provider<com.ss.android.lark.translate.service.impl.a> r29, Provider<m6b.q> r30, Provider<a2b.c> r31, Provider<com.ss.android.lark.audio.voiceinput.service.o> r32, Provider<m6b.a> r33, Provider<com.ss.android.lark.audio.voiceinput.service.l> r34, Provider<com.ss.android.lark.tab.service.m> r35, Provider<com.ss.android.lark.tab.service.i> r36, Provider<a2b.n> r37, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d> r38, Provider<a2b.i> r39, Provider<a2b.l> r40, Provider<z> r41, Provider<com.ss.android.lark.chat.core.api.d> r42) {
        this.userIdProvider = r3;
        this.rucketProvider = r4;
        this.imUserKVRepoProvider = r5;
        this.passportDependencyProvider = r6;
        this.legacyChatServiceProvider = r7;
        this.audioServiceProvider = r8;
        this.threadServiceProvider = r9;
        this.quoteServiceProvider = r10;
        this.draftServiceProvider = r11;
        this.fgServiceProvider = r12;
        this.cotFeatureGateProvider = r13;
        this.previewServiceProvider = r14;
        this.translateServiceProvider = r15;
        this.userFieldsServiceProvider = r16;
        this.privateDescriptionServiceProvider = r17;
        this.storePrivateDescriptionHandlerFactoryProvider = r18;
        this.messageTenantConfServiceProvider = r19;
        this.previewVideoServiceProvider = r20;
        this.editMessageServiceProvider = r21;
        this.chatSubscribeServiceProvider = r22;
        this.pushChatRelationListenerManagerProvider = r23;
        this.chatTabServiceProvider = r24;
        this.chatTabExtraServiceProvider = r25;
        this.userGroupServiceProvider = r26;
        this.aiSmartApplyAnswerServiceProvider = r27;
        this.chatterPushProvider = r28;
        this.translatePushProvider = r29;
        this.threadPushProvider = r30;
        this.previewPushProvider = r31;
        this.speechPushProvider = r32;
        this.audioTextPushProvider = r33;
        this.newAudioTextPushProvider = r34;
        this.chatTabPushProvider = r35;
        this.chatTabExtraPushProvider = r36;
        this.userGroupPushProvider = r37;
        this.dataPreloaderManagerProvider = r38;
        this.secretChatDataCorruptPushProvider = r39;
        this.strangerActionUploaderProvider = r40;
        this.unreadAIDataCacheProvider = r41;
        this.mentionBotsNotInChatCoordinatorProvider = r42;
    }

    public static ChatAppContainerV2_Factory create(Provider<String> r42, Provider<b38.b> r43, Provider<KVRepo> r44, Provider<w4b.c.o> r45, Provider<IChatService> r46, Provider<IAudioService> r47, Provider<com.ss.android.lark.biz.im.api.o0> r48, Provider<m6b.m> r49, Provider<m6b.g> r50, Provider<jdb.g> r51, Provider<com.ss.android.lark.chat.cot.a> r52, Provider<a2b.f> r53, Provider<ITranslateService> r54, Provider<com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b> r55, Provider<a2b.h> r56, Provider<a2b.k> r57, Provider<MessageTenantConfService> r58, Provider<m6b.n> r59, Provider<EditMessageService> r60, Provider<m6b.d> r61, Provider<x0> r62, Provider<IChatTabService> r63, Provider<com.ss.android.lark.tab.service.l> r64, Provider<a2b.o> r65, Provider<a2b.j> r66, Provider<m6b.t> r67, Provider<com.ss.android.lark.translate.service.impl.a> r68, Provider<m6b.q> r69, Provider<a2b.c> r70, Provider<com.ss.android.lark.audio.voiceinput.service.o> r71, Provider<m6b.a> r72, Provider<com.ss.android.lark.audio.voiceinput.service.l> r73, Provider<com.ss.android.lark.tab.service.m> r74, Provider<com.ss.android.lark.tab.service.i> r75, Provider<a2b.n> r76, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d> r77, Provider<a2b.i> r78, Provider<a2b.l> r79, Provider<z> r80, Provider<com.ss.android.lark.chat.core.api.d> r81) {
        return new ChatAppContainerV2_Factory(r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81);
    }

    public static ChatAppContainerV2 newInstance(String r42, b38.b r43, KVRepo r44, w4b.c.o r45, IChatService r46, IAudioService r47, com.ss.android.lark.biz.im.api.o0 r48, m6b.m r49, m6b.g r50, jdb.g r51, com.ss.android.lark.chat.cot.a r52, a2b.f r53, ITranslateService r54, com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b r55, a2b.h r56, a2b.k r57, MessageTenantConfService r58, m6b.n r59, EditMessageService r60, m6b.d r61, x0 r62, IChatTabService r63, com.ss.android.lark.tab.service.l r64, a2b.o r65, a2b.j r66, m6b.t r67, com.ss.android.lark.translate.service.impl.a r68, m6b.q r69, a2b.c r70, com.ss.android.lark.audio.voiceinput.service.o r71, m6b.a r72, com.ss.android.lark.audio.voiceinput.service.l r73, com.ss.android.lark.tab.service.m r74, com.ss.android.lark.tab.service.i r75, a2b.n r76, com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d r77, a2b.i r78, a2b.l r79, z r80, com.ss.android.lark.chat.core.api.d r81) {
        return new ChatAppContainerV2(r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81);
    }
}
