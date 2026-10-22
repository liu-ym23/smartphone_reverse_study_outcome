package com.ss.android.lark.officesdk;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.basesdk.services.container.DomainCharacteristicServiceOfficeSDKCompat_ProvideDomainCharacteristicServiceFactory;
import com.bytedance.ee.bear.basesdk.services.route.UserRouteServiceImpl;
import com.bytedance.ee.bear.bitable.core.usercomponent.BitableUserModule_ProvideBitableAppFactory;
import com.bytedance.ee.bear.bitable.homepage.BitableHomePageFragment;
import com.bytedance.ee.bear.bitable.homepage.BitableTabFragmentV4;
import com.bytedance.ee.bear.bitable.homepage.chart.datasource.UserScopeChartDataFetcher;
import com.bytedance.ee.bear.bitable.homepage.chart.home.fullscreen.BitableChartFullscreenActivity;
import com.bytedance.ee.bear.bitable.homepage.chart.widget.chart.ChartItemView;
import com.bytedance.ee.bear.bitable.homepage.recommend.BitableDiscoveryFragment;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.demo.CCMFolderDemoActivity;
import com.bytedance.ee.bear.demo.OfficeCCMDemoActivity;
import com.bytedance.ee.bear.demo.OfficeCCMDemoContainerActivity;
import com.bytedance.ee.bear.demo.OfficeFolderDetailDemoActivity;
import com.bytedance.ee.bear.demo.OfficeSpaceDemoActivity;
import com.bytedance.ee.bear.doc.syncblock.SyncBlockFragment;
import com.bytedance.ee.bear.docs.DocsHistoryDomainModule_ProvideDocsHistoryDomainDependencyFactory;
import com.bytedance.ee.bear.docs.UserDocsSdkImpl;
import com.bytedance.ee.bear.document.OfficePluginDependencyModule_ProvideIAlertConfigFactory;
import com.bytedance.ee.bear.document.OfficePluginDependencyModule_ProvideIBitableFabConfigFactory;
import com.bytedance.ee.bear.document.OfficePluginDependencyModule_ProvideIBitableFilePickerConfigFactory;
import com.bytedance.ee.bear.document.OfficePluginDependencyModule_ProvideICommentHostConfigFactory;
import com.bytedance.ee.bear.document.OfficePluginDependencyModule_ProvideILocationHostServiceFactory;
import com.bytedance.ee.bear.document.OfficePluginDependencyModule_ProvideIOrientationConfigFactory;
import com.bytedance.ee.bear.document.OfficePluginDependencyModule_ProvideIQRCodeHostServiceFactory;
import com.bytedance.ee.bear.document.OfficePluginDependencyModule_ProvideISelectionConfigFactory;
import com.bytedance.ee.bear.document.OfficePluginDependencyModule_ProvideISheetFabConfigFactory;
import com.bytedance.ee.bear.document.OfficePluginDependencyModule_ProvideISheetFabPanelConfigFactory;
import com.bytedance.ee.bear.document.OfficePluginDependencyModule_ProvideISheetToolbarConfigFactory;
import com.bytedance.ee.bear.document.OfficePluginDependencyModule_ProvideIToolbarConfigFactory;
import com.bytedance.ee.bear.document.OfficeTemplateUrlModule_ProvideTemplateUrlDependencyFactory;
import com.bytedance.ee.bear.document.r5;
import com.bytedance.ee.bear.document.synced.block.references.doc.SyncedSourceDocReferencesFragment;
import com.bytedance.ee.bear.document.synced.block.references.doc.SyncedSourceReferencesViewModel;
import com.bytedance.ee.bear.document.synced.block.references.doc.SyncedSourceReferencesViewModel_HiltModules_KeyModule_ProvideFactory;
import com.bytedance.ee.bear.document.t5;
import com.bytedance.ee.bear.domain.container.CCMDomainUserModule_ProvideDwarfDocDomainConfigFactory;
import com.bytedance.ee.bear.domain.container.CCMDomainUserModule_ProvideDwarfDomainConfigParserFactory;
import com.bytedance.ee.bear.drive.biz.versions.VersionOperationRecordV2Activity;
import com.bytedance.ee.bear.drive.cache.DriveCacheServiceOfficeSDKCompat_ProvideDriveCacheServiceFactory;
import com.bytedance.ee.bear.drive.core.fragment.UserContainerDriveMainFragment;
import com.bytedance.ee.bear.drive.sdk.service.DriveSdkService;
import com.bytedance.ee.bear.facade.common.CCMUserCookiesModule_ProvideUserCookiesAdapterV2Factory;
import com.bytedance.ee.bear.integrator.di.AppInitializeOfficeSDKCompat_ProvideAppInitializeFactory;
import com.bytedance.ee.bear.integrator.di.configs.net.container.NetServiceOfficeSDKCompat_ProvideNetServiceFactory;
import com.bytedance.ee.bear.lark.NewDocMainTabFragment;
import com.bytedance.ee.bear.lark.sidebar.SidebarDocTabFragment;
import com.bytedance.ee.bear.list.share.HomeSharedFragment;
import com.bytedance.ee.bear.middleground.permission.apiimpl.ShareUIServiceOfficeSDKCompat_ProvideIShareUIServiceFactory;
import com.bytedance.ee.bear.middleground.permission.apply.OfficePermissionPageFactory;
import com.bytedance.ee.bear.middleground.record.privacy.PrivacyFragment;
import com.bytedance.ee.bear.middleground.unbundle.BenefitManagerOfficeSDKCompat_ProvideDriveCacheServiceFactory;
import com.bytedance.ee.bear.route.OfficeUserRouteServiceImpl_Factory;
import com.bytedance.ee.bear.tts.service.TtsService;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.wikiv2.home2.WikiHomeFragment2;
import com.bytedance.ee.bear.wikiv2.mylib.HomeLibraryFragment;
import com.bytedance.ee.bear.wikiv2.selector.RootSelectFragment;
import com.bytedance.ee.bear.wikiv2.spacedetail.WikiSpaceDetailActivity;
import com.bytedance.ee.bear.wikiv2.wikitreev2.create.WikiCreateToFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.main.WikiTreeFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.panel.WikiTreePanelDialog;
import com.bytedance.ee.space.sync.SyncPushService;
import com.bytedance.lark.lark_biz_feed_android_wrapper.FeedRepositoryServiceDaggerModule_ProvidesMoltenLifecycleDisposableFactory;
import com.bytedance.lark.rustclient.UserRustClientModule_ProvideClientFactory;
import com.bytedance.lark.rustclient.UserRustClientModule_ProvideDispatcherFactory;
import com.bytedance.lark.sdk.refactor.RustSdkModule_ProvideBarrierFactory;
import com.larksuite.rucket.UserRucketModule_ProvideRucketFactory;
import com.ss.android.lark.appsetting.v2.impl.UserSettingManager_Factory;
import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.audio.voiceinput.service.NewAudio2TextPush;
import com.ss.android.lark.audio.voiceinput.service.NewAudio2TextPushRepositoryV2;
import com.ss.android.lark.auditsdk.v2.receivecheck.cache.AuthorityUserScopeModule_ProvideImFileAuthorityRecordCacheFactory;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ILaunchDataInput;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.RealLaunchData;
import com.ss.android.lark.biz.im.api.page.configurator.ConfiguratorType;
import com.ss.android.lark.biz.im.api.page.plugin.PluginType;
import com.ss.android.lark.chameleon.AbsChameleonJsRuntime;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonFragmentV2;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.api.service.ITranslateService;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.api.service.impl.PreviewPush;
import com.ss.android.lark.chat.api.service.impl.PreviewPushRepositoryV2;
import com.ss.android.lark.chat.api.service.impl.PreviewRepositoryV2;
import com.ss.android.lark.chat.api.service.impl.PreviewService;
import com.ss.android.lark.chat.api.service.impl.PrivateDescriptionService;
import com.ss.android.lark.chat.api.service.impl.TranslateService;
import com.ss.android.lark.chat.api.service.impl.a2;
import com.ss.android.lark.chat.api.service.impl.l1;
import com.ss.android.lark.chat.api.service.impl.q1;
import com.ss.android.lark.chat.api.service.impl.secret.SecretChatDataCorruptPush;
import com.ss.android.lark.chat.api.service.impl.smartreply.SmartApplyAnswerService;
import com.ss.android.lark.chat.api.service.impl.usergroup.UserGroupPush;
import com.ss.android.lark.chat.api.service.impl.usergroup.UserGroupPushRepository;
import com.ss.android.lark.chat.api.service.impl.usergroup.UserGroupService;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.KeyboardWrapperConfigurator;
import com.ss.android.lark.chat.chatwindow.chat.preloaderv2.DataPreloadEngineV2;
import com.ss.android.lark.chat.chatwindow.chat.preloaderv2.DataPreloadManagerV2;
import com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.ChatDataPreLoaderV2;
import com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.DataPreLoaderType;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenFragment;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenViewModel_HiltModules_KeyModule_ProvideFactory;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.UserFieldsService;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatAppContainerUserModule_ProvideChatAppContainerFactory;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatAppContainerV2;
import com.ss.android.lark.chat.component.task.SetLoginChatterTask;
import com.ss.android.lark.chat.export.offlineCacheClean.OfflineCacheClean;
import com.ss.android.lark.chat.repository.impl.DraftRepositoryV2;
import com.ss.android.lark.chat.service.impl.EditMessageService;
import com.ss.android.lark.chat.service.impl.ImSdkChatPushImplV2;
import com.ss.android.lark.chat.service.impl.ImSdkChatterPushImplV2;
import com.ss.android.lark.chat.service.impl.MessagePushV2;
import com.ss.android.lark.chat.service.impl.MessageTenantConfService;
import com.ss.android.lark.chat.service.impl.k2;
import com.ss.android.lark.chat.service.impl.l2;
import com.ss.android.lark.chat.service.impl.n1;
import com.ss.android.lark.chat.service.impl.v1;
import com.ss.android.lark.chat.service.impl.z1;
import com.ss.android.lark.chatwindow.launcher.ChatLauncherV2;
import com.ss.android.lark.chatwindow.launcher.transform.ChatBundleTransform;
import com.ss.android.lark.chatwindow.launcher.transform.ChatIdBundleTransform;
import com.ss.android.lark.chatwindow.launcher.transform.ChatLaunchParamDataBundleTransform;
import com.ss.android.lark.chatwindow.launcher.transform.ChatLaunchService;
import com.ss.android.lark.chatwindow.launcher.transform.ChatterIdBundleTransform;
import com.ss.android.lark.conditional.access.device.ui.UserScopeDeviceDeclareFragment;
import com.ss.android.lark.conditional.access.device.viewmodel.DeviceDeclareViewModel;
import com.ss.android.lark.conditional.access.device.viewmodel.DeviceDeclareViewModel_Factory;
import com.ss.android.lark.conditional.access.device.viewmodel.DeviceDeclareViewModel_HiltModules_KeyModule_ProvideFactory;
import com.ss.android.lark.conditional.access.display.CustomDisplayModule;
import com.ss.android.lark.conditional.access.network.service.ConditionalAccessNetDependency;
import com.ss.android.lark.conditional.access.nopermission.manager.NoPermissionModuleManager;
import com.ss.android.lark.conditional.access.nopermission.ui.DeviceOwnerNoPermissionFragment;
import com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity;
import com.ss.android.lark.conditional.access.nopermission.viewmodel.NoPermissionViewModel;
import com.ss.android.lark.conditional.access.nopermission.viewmodel.NoPermissionViewModel_Factory;
import com.ss.android.lark.conditional.access.nopermission.viewmodel.NoPermissionViewModel_HiltModules_KeyModule_ProvideFactory;
import com.ss.android.lark.conditional.access.web.viewmodel.BindDeviceWebViewModel;
import com.ss.android.lark.conditional.access.web.viewmodel.BindDeviceWebViewModel_Factory;
import com.ss.android.lark.conditional.access.web.viewmodel.BindDeviceWebViewModel_HiltModules_KeyModule_ProvideFactory;
import com.ss.android.lark.create.groupchat.impl.service.CreateGroupService;
import com.ss.android.lark.create.groupchat.impl.service.InterceptorType;
import com.ss.android.lark.create.groupchat.impl.service.interceptor.DefaultErrorInterceptor;
import com.ss.android.lark.create.groupchat.impl.service.interceptor.ExceedGroupLimitAndApplyInterceptor;
import com.ss.android.lark.create.groupchat.impl.service.interceptor.ExceedGroupLimitInterceptor;
import com.ss.android.lark.create.groupchat.impl.service.interceptor.GroupMemberLimitInterceptor;
import com.ss.android.lark.dynamicconfig.v2.impl.service.UserDomainConfigService_Factory;
import com.ss.android.lark.featuregatingv2impl.service.UserFeatureGatingService_Factory;
import com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModelFactory;
import com.ss.android.lark.feed.shared.page.FeedItemsFragment;
import com.ss.android.lark.flow.bottomsheet.biz.chatwindow.ChatWindowBottomFrameFragment;
import com.ss.android.lark.flow.bottomsheet.biz.replyinthread.ReplyInThreadFrameFragment;
import com.ss.android.lark.flow.chat.creategroup.page.FlowGroupCreateFragmentV2;
import com.ss.android.lark.flow.chat.page.ChatFragment;
import com.ss.android.lark.flow.chat.page.flow.FlowChatFragment;
import com.ss.android.lark.flow.chat.page.flow.FlowChatFragment_Factory;
import com.ss.android.lark.flow.chat.page.flow.configurator.FlowMessageListConfigurator;
import com.ss.android.lark.flow.chat.page.flow.plugin.FlowChatPluginModule_ProvideFlowChatPluginFactory;
import com.ss.android.lark.flow.chat.page.starter.FlowChatStarter_Factory;
import com.ss.android.lark.flow.chatthread.FlowChatThreadContainerFragment;
import com.ss.android.lark.flow.chatthread.page.FlowChatThreadFragment;
import com.ss.android.lark.flow.chatthread.page.FlowChatThreadFragment_Factory;
import com.ss.android.lark.flow.feed.data.DoubaoFeedMigrateStatus;
import com.ss.android.lark.flow.feed.page.FlowHumanFeedItemsFragment;
import com.ss.android.lark.flow.mergeforward.FlowMergeForwardActivity;
import com.ss.android.lark.flow.mergeforward.FlowMergeForwardContainerFragment;
import com.ss.android.lark.flow.mergeforward.FlowMergeForwardContainerFragment_Factory;
import com.ss.android.lark.flow.mergeforward.page.FlowMergeForwardFragment;
import com.ss.android.lark.flow.mergeforward.page.FlowMergeForwardFragment_Factory;
import com.ss.android.lark.flow.mergeforward.page.plugin.MergeForwardPluginModule_ProvideMergeForwardPluginFactory;
import com.ss.android.lark.flow.replyinthread.FlowReplyInThreadActivity;
import com.ss.android.lark.flow.replyinthread.FlowReplyInThreadContainerFragment;
import com.ss.android.lark.flow.replyinthread.FlowReplyInThreadContainerFragment_Factory;
import com.ss.android.lark.flow.replyinthread.pages.FlowReplyInThreadFragment;
import com.ss.android.lark.flow.replyinthread.pages.FlowReplyInThreadFragment_Factory;
import com.ss.android.lark.flow.replyinthread.pages.plugin.ReplyInThreadPluginModule_ProvideReplyInThreadPluginFactory;
import com.ss.android.lark.flow.threadwindow.FlowThreadWindowFragment;
import com.ss.android.lark.flow.threadwindow.plugin.FlowThreadWindowPluginModule_ProvideFlowThreadWindowPluginFactory;
import com.ss.android.lark.framework.assembly.rust.component.task.MakeRustOnlineTask_Factory;
import com.ss.android.lark.im.base.di.ImUserStorageModule_ProvideKVRepoFactory;
import com.ss.android.lark.im.base.page.BasePageFragment;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.ImSdkChatterServiceImplV2;
import com.ss.android.lark.im.sdk.service.ImSdkMessageServiceImplV2;
import com.ss.android.lark.im.sdk.service.VoiceTextPostProcessServiceImpl;
import com.ss.android.lark.integrator.ccm.dependency.di.OfficeMessagingDependencyImpl;
import com.ss.android.lark.integrator.security.compliance.OfficeSDKWatermarkRuntimeInfoProviderModule_ProvideRuntimeInfoProviderFactory;
import com.ss.android.lark.integrator.security.compliance.screen_audit.OfficeSDKScreenCaptureAuditService;
import com.ss.android.lark.message.lynxcard.monitor.LynxCardMonitorServiceImpl;
import com.ss.android.lark.myai.export.MyAIService;
import com.ss.android.lark.newemoji.impl.EmojiMapManager2;
import com.ss.android.lark.newemoji.impl.EmojiService2;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponentManager;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponentManagerImpl;
import com.ss.android.lark.officesdk.demo.dependency.BaseUserMocksModule_ProvideIExportTabDataManagerFactory;
import com.ss.android.lark.officesdk.demo.dependency.BaseUserMocksModule_ProvideINotificationControllerApiFactory;
import com.ss.android.lark.officesdk.demo.dependency.BaseUserMocksModule_ProvideINotificationSettingApiFactory;
import com.ss.android.lark.officesdk.demo.dependency.BaseUserMocksModule_ProvideMyAIServiceFactory;
import com.ss.android.lark.officesdk.integrator.mock.OfficeSdkStarterMockModule_ProvideGroupProfileStarterFactory;
import com.ss.android.lark.officesdk.integrator.mock.OfficeSdkStarterMockModule_ProvideMyAiStarterFactory;
import com.ss.android.lark.officesdk.integrator.mock.OfficeSdkStarterMockModule_ProvideUnknownStarterFactory;
import com.ss.android.lark.officesdk.minutes.assembly.recording.common.InitMinutesRecordingTask;
import com.ss.android.lark.officesdk.minutes.assembly.recording.common.InitMinutesRecordingTask_Factory;
import com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingOfficeSDKUserModule_ProvideMmRecordingUserComponentFactory;
import com.ss.android.lark.officesdk.minutes.ui.record.endwindow.MmEndWindowFragment;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingFragment;
import com.ss.android.lark.passport.UserListFetcher;
import com.ss.android.lark.passport.flow.mfa.FlowMfaEngine;
import com.ss.android.lark.passport.flow.mfa.FlowMfaRepository;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.ffi.KmpOfflineTask;
import com.ss.android.lark.passportc.ffi.KmpOnlineTask;
import com.ss.android.lark.passportc.ffi.KmpUserConvention;
import com.ss.android.lark.passportc.internal.UserPassportServiceImpl;
import com.ss.android.lark.passportc.task.InitStaticUserConventionTask_Factory;
import com.ss.android.lark.profile.core.di.ProfileNetClientGetterImpl;
import com.ss.android.lark.profile.v2.entity.BaseField;
import com.ss.android.lark.reaction.service.impl.ReactionOrderService2;
import com.ss.android.lark.reaction.service.impl.ReactionService2;
import com.ss.android.lark.rustinfrabridge.appstatesync.service.IAppStateSyncService;
import com.ss.android.lark.rustinfrabridge.netstate.impl.UserNetStateService;
import com.ss.android.lark.rustinfrabridge.store.service.impl.userscope.UserStoreService;
import com.ss.android.lark.security.compliance.infra.network.userscpoe.SCRequestUserScopeImpl;
import com.ss.android.lark.sticker.core.impl.CustomStickerService;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.tab.service.ChatTabExtraPush;
import com.ss.android.lark.tab.service.ChatTabExtraPushRepositoryV2;
import com.ss.android.lark.tab.service.ChatTabExtraService;
import com.ss.android.lark.tab.service.ChatTabPush;
import com.ss.android.lark.tab.service.ChatTabPushRepositoryV2;
import com.ss.android.lark.tab.service.IChatTabService;
import com.ss.android.lark.watermark.userscope.ProcessSynchronizerV3;
import com.ss.android.lark.watermark.userscope.SubprocessWatermarkViewModelV3;
import com.ss.android.lark.watermark.userscope.UiThreadExecutionWatermarkImplV3;
import com.ss.android.lark.watermark.userscope.WatermarkAdapterV3;
import com.ss.android.lark.watermark.userscope.WatermarkImplFactoryV3;
import com.ss.android.lark.watermark.userscope.WatermarkImplV3;
import com.ss.android.lark.watermark.userscope.WatermarkModuleV3;
import com.ss.android.lark.watermark.userscope.WatermarkRepositoryV3;
import com.ss.android.lark.watermark.userscope.WatermarkViewModelV3;
import com.ss.android.lark.widget.photo.preview.video.pip.PipUserContainerImpl;
import com.ss.lark.android.encryption.userscope.SCCipherManagerUserScope;
import com.ss.lark.android.encryption.userscope.StreamParamManagerUserScope;
import com.suite.lark.emm.impl.clipboard.userscope.user.ClipboardManagerUserScope;
import com.suite.lark.platform.component.storage.di.UserStorageModule_ProvideUserKVStorageFactory;
import com.suite.lark.platform.component.widget.floatingpanel.impl.FloatingPanelService;
import com.suite.lark.platform.component.widget.floatingpanel.impl.integration.FloatingPanelInitTask_Factory;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories_DwarfInternalFactoryFactory_Factory;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory;
import dagger.hilt.dwarf.lifecycle.ComponentLifecycleAware;
import dagger.hilt.dwarf.spi.DwarfSPI;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.SetBuilder;
import dagger.internal.SetFactory;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import mc5.x2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class y extends a1 {
    public Provider<com.ss.android.lark.storage.kv.storage.a> A;
    public Provider<com.ss.android.lark.tab.service.g> A0;
    public Provider<h85.d1> A1;
    public a A2;
    public Provider<ytb.m> A3;
    public Provider<by4.b> B;
    public Provider<com.ss.android.lark.tab.service.b> B0;
    public Provider<an4.a> B1;
    public a B2;
    public Provider<x5c.b> B3;
    public Provider<s45.c> C;
    public Provider<ChatTabExtraService> C0;
    public Provider<dn4.b> C1;
    public Provider<com.ss.android.lark.chatwindow.launcher.starter.a> C2;
    public Provider<com.ss.android.lark.sticker.core.impl.a> C3;
    public Provider<bwa.r> D;
    public Provider<UserGroupService> D0;
    public Provider<com.bytedance.ee.bear.bitable.core.usercomponent.a> D1;
    public Provider<com.ss.android.lark.chatwindow.launcher.starter.a> D2;
    public Provider<com.ss.android.lark.sticker.core.impl.c> D3;
    public Provider<s45.f> E;
    public Provider<SmartApplyAnswerService> E0;
    public Provider<ew4.w> E1;
    public Provider<com.ss.android.lark.chatwindow.launcher.starter.a> E2;
    public Provider<CustomStickerService> E3;
    public DelegateFactory F;
    public Provider<ImSdkChatterPushImplV2> F0;
    public Provider<ew4.x> F1;
    public a F2;
    public Provider<WatermarkRepositoryV3> F3;
    public Provider<com.bytedance.ee.bear.document.template.a> G;
    public Provider<com.ss.android.lark.translate.service.impl.o> G0;
    public Provider<ew4.y> G1;
    public a G2;
    public Provider<ProcessSynchronizerV3> G3;
    public Provider<com.bytedance.ee.bear.account.container.dwarf.a> H;
    public Provider<com.ss.android.lark.translate.service.impl.n> H0;
    public Provider<ew4.z> H1;
    public Provider<ChatLauncherV2> H2;
    public Provider<WatermarkViewModelV3> H3;
    public Provider<s45.p> I;
    public Provider<l2> I0;
    public Provider<ew4.a0> I1;
    public a I2;
    public Provider<SubprocessWatermarkViewModelV3> I3;
    public Provider<com.bytedance.ee.bear.init.d> J;
    public Provider<k2> J0;
    public Provider<ew4.b0> J1;
    public Provider<com.ss.android.lark.conditional.access.display.d> J2;
    public Provider<WatermarkImplV3> J3;
    public Provider<x05.a> K;
    public Provider<PreviewPushRepositoryV2> K0;
    public Provider<ew4.c0> K1;
    public Provider<com.ss.android.lark.conditional.access.display.e> K2;
    public Provider<UiThreadExecutionWatermarkImplV3> K3;
    public Provider<UserDocsSdkImpl> L;
    public Provider<PreviewPush> L0;
    public Provider<ew4.e0> L1;
    public Provider<CustomDisplayModule> L2;
    public Provider<WatermarkAdapterV3> L3;
    public Provider<com.bytedance.ee.bear.office.space.l> M;
    public Provider<com.ss.android.lark.audio.voiceinput.service.x> M0;
    public Provider<ew4.f0> M1;
    public Provider<SCRequestUserScopeImpl> M2;
    public Provider<WatermarkImplFactoryV3> M3;
    public Provider<com.bytedance.ee.util.db.container.a> N;
    public Provider<com.ss.android.lark.audio.voiceinput.service.w> N0;
    public Provider<ew4.g0> N1;
    public Provider<ConditionalAccessNetDependency> N2;
    public Provider<WatermarkModuleV3> N3;
    public Provider<com.bytedance.ee.bear.account.container.impl.c> O;
    public Provider<com.ss.android.lark.chat.service.impl.g> O0;
    public Provider<by4.a> O1;
    public Provider<com.ss.android.lark.conditional.access.traffic.handler.policy.center.d> O2;
    public Provider<ucc.c> O3;
    public Provider<yqb.a> P;
    public Provider<com.ss.android.lark.chat.service.impl.f> P0;
    public a P1;
    public a P2;
    public Provider<PipUserContainerImpl> P3;
    public Provider<com.bytedance.ee.bear.route.g> Q;
    public Provider<NewAudio2TextPushRepositoryV2> Q0;
    public a Q1;
    public a Q2;
    public Provider<StreamParamManagerUserScope> Q3;
    public Provider<x2> R;
    public Provider<NewAudio2TextPush> R0;
    public Provider<com.bytedance.ee.bear.drive.cache.w> R1;
    public a R2;
    public Provider<SCCipherManagerUserScope> R3;
    public Provider<BenefitManagerAPI> S;
    public Provider<ChatTabPushRepositoryV2> S0;
    public Provider<o75.b> S1;
    public a S2;
    public Provider<a0c.b> S3;
    public Provider<com.bytedance.lark.rustclient.api.l> T;
    public Provider<ChatTabPush> T0;
    public a T1;
    public a T2;
    public Provider<doc.l> T3;
    public Provider<com.ss.android.lark.conditional.access.plugin.a> U;
    public Provider<ChatTabExtraPushRepositoryV2> U0;
    public Provider<DriveSdkService> U1;
    public a U2;
    public Provider<ClipboardManagerUserScope> U3;
    public Provider<com.ss.android.lark.active.user.bridge.h> V;
    public Provider<ChatTabExtraPush> V0;
    public Provider<com.bytedance.ee.bear.drive.services.i> V1;
    public a V2;
    public Provider<dxa.a> V3;
    public Provider<com.ss.android.lark.active.user.bridge.d> W;
    public Provider<UserGroupPushRepository> W0;
    public Provider<com.bytedance.ee.bear.drive.services.c0> W1;
    public Provider<com.ss.android.lark.create.groupchat.impl.service.b> W2;
    public a W3;
    public Provider<v1b.b> X;
    public Provider<UserGroupPush> X0;
    public Provider<hb5.a> X1;
    public Provider<CreateGroupService> X2;
    public Provider<FloatingPanelService> X3;
    public Provider<b38.b> Y;
    public Provider<com.ss.android.lark.im.sdk.service.f> Y0;
    public Provider<OfficeMessagingDependencyImpl> Y1;
    public Provider<qbb.b> Y2;
    public a Y3;
    public Provider<KVRepo> Z;
    public Provider<ImSdkChatterServiceImplV2> Z0;
    public Provider<com.ss.android.lark.integrator.ccm.dependency.di.g1> Z1;
    public Provider<hnb.b> Z2;
    public Provider<d1> Z3;
    public final w0 a;
    public Provider<w4b.a0> a0;
    public Provider<com.ss.android.lark.im.sdk.service.y> a1;
    public Provider<com.bytedance.ee.bear.assemble.profile.c> a2;
    public Provider<jeb.a> a3;
    public Provider<OfficeSDKUserComponentManagerImpl> a4;
    public final String b;
    public Provider<com.ss.android.lark.chat.api.service.impl.o> b0;
    public Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.a> b1;
    public Provider<OfficePermissionPageFactory> b2;
    public Provider<neb.b> b3;
    public Provider<com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a> b4;
    public final com.ss.android.lark.passportc.internal.f0 c;
    public Provider<ChatService> c0;
    public a c1;
    public Provider<ii5.d> c2;
    public Provider<DoubaoFeedMigrateStatus> c3;
    public Provider<cub.a> c4;
    public final nb5.b d;
    public Provider<com.ss.android.lark.audio.voiceinput.service.d> d0;
    public a d1;
    public Provider<cj5.c> d2;
    public Provider<com.ss.android.lark.forwardv3.forward.mediaforward.h> d3;
    public Provider<com.ss.android.lark.officesdk.feed.impl.a> d4;
    public final com.bytedance.ee.bear.basesdk.services.container.b e;
    public Provider<com.ss.android.lark.audio.voiceinput.service.i> e0;
    public Provider<DataPreloadEngineV2> e1;
    public Provider<gm5.a> e2;
    public Provider<nwb.d> e3;
    public a e4;
    public final t5 f;
    public Provider<l1> f0;
    public a f1;
    public Provider<gi5.a> f2;
    public a f3;
    public Provider<ova.r> f4;
    public final tz4.b g;
    public Provider<q1> g0;
    public a g1;
    public Provider<TtsService> g2;
    public Provider<LynxCardMonitorServiceImpl> g3;
    public Provider<skc.a> g4;
    public final com.bytedance.ee.bear.middleground.unbundle.a h;
    public Provider<n1> h0;
    public Provider<DataPreloadManagerV2> h1;
    public Provider<s85.a> h2;
    public Provider<MyAIService> h3;
    public a h4;
    public final com.ss.android.lark.chat.chatwindow.chat.v2.push.b i;
    public Provider<v1> i0;
    public Provider<SecretChatDataCorruptPush> i1;
    public Provider<zt5.c> i2;
    public Provider<EmojiMapManager2> i3;
    public a i4;
    public final gkb.a j;
    public Provider<DraftRepositoryV2> j0;
    public Provider<dnb.b> j1;
    public Provider<SyncPushService> j2;
    public Provider<EmojiService2> j3;
    public a j4;
    public final UserSession k;
    public Provider<com.ss.android.lark.chat.service.impl.r> k0;
    public Provider<com.ss.android.lark.chat.chatwindow.chat.v2.push.n0> k1;
    public Provider<yra.a> k2;
    public Provider<ysb.a> k3;
    public a k4;
    public final r5 l;
    public Provider<com.ss.android.lark.chat.cot.a> l0;
    public Provider<ytb.p> l1;
    public Provider<com.ss.android.lark.audit.userscope.audit.d> l2;
    public Provider<ysb.b> l3;
    public a l4;
    public final com.bytedance.ee.bear.drive.cache.u m;
    public Provider<PreviewRepositoryV2> m0;
    public Provider<ChatAppContainerV2> m1;
    public Provider<com.ss.android.lark.audit.userscope.audit.e> m2;
    public Provider<com.ss.android.lark.flow.notification.online.process.d> m3;
    public a m4;
    public final com.bytedance.ee.bear.integrator.di.d n;
    public Provider<PreviewService> n0;
    public Provider<com.ss.android.lark.chat.chatwindow.chat.v2.push.v> n1;
    public Provider<com.ss.android.lark.audit.userscope.audit.a> n2;
    public Provider<com.ss.android.lark.flow.notification.online.process.e> n3;
    public Provider<KmpUserConvention> n4;
    public final jg5.r o;
    public Provider<a2> o0;
    public Provider<OfflineCacheClean> o1;
    public Provider<com.ss.android.lark.audit.userscope.audit.g> o2;
    public Provider<com.ss.android.lark.flow.notification.online.process.c> o3;
    public Provider<OfficeSDKScreenCaptureAuditService> o4;
    public final com.bytedance.lark.lark_biz_feed_android_wrapper.a p;
    public Provider<TranslateService> p0;
    public Provider<oeb.a> p1;
    public Provider<com.ss.android.lark.auditsdk.v2.receivecheck.cache.a> p2;
    public Provider<UserListFetcher> p3;
    public Provider<FeedSidebarItemsMoltenViewModelFactory> p4;
    public final eeb.a q;
    public Provider<com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.d> q0;
    public Provider<com.ss.android.lark.feed.molten.page.a> q1;
    public Provider<com.ss.android.lark.biz.im.api.message.audit.b> q2;
    public Provider<FlowMfaEngine> q3;
    public final y r;
    public Provider<UserFieldsService> r0;
    public a r1;
    public Provider<m0b.a> r2;
    public Provider<com.ss.android.lark.passport.flow.mfa.u> r3;
    public Provider<UserScopeChartDataFetcher> s;
    public Provider<com.ss.android.lark.chat.api.service.impl.e1> s0;
    public a s1;
    public Provider<q1b.c> s2;
    public Provider<ProfileNetClientGetterImpl> s3;
    public Provider<ks4.d> t;
    public Provider<PrivateDescriptionService> t0;
    public a t1;
    public Provider<com.ss.android.lark.chat.name.a> t2;
    public Provider<ReactionService2> t3;
    public Provider<ldb.g> u;
    public Provider<com.ss.android.lark.officesdk.integrator.im.impl.q> u0;
    public a u1;
    public Provider<ImSdkChatPushImplV2> u2;
    public Provider<ReactionOrderService2> u3;
    public Provider<UserPassportServiceImpl> v;
    public Provider<MessageTenantConfService> v0;
    public a v1;
    public Provider<MessagePushV2> v2;
    public Provider<UserNetStateService> v3;
    public Provider<lcb.f> w;
    public Provider<z1> w0;
    public a w1;
    public Provider<ytb.b> w2;
    public a w3;
    public Provider<t45.b> x;
    public Provider<ImSdkMessageServiceImplV2> x0;
    public Provider<ytb.n> x1;
    public Provider<ChatLaunchService> x2;
    public Provider<ytb.u> x3;
    public Provider<sa5.j> y;
    public Provider<com.ss.android.lark.chat.service.impl.i> y0;
    public a y1;
    public a y2;
    public Provider<com.ss.android.lark.search.doubao.env.b> y3;
    public Provider<NetService> z;
    public Provider<com.ss.android.lark.tab.service.f> z0;
    public a z1;
    public a z2;
    public Provider<y4c.c> z3;

    public static final class a<T> implements Provider<T> {
        public final y a;
        public final int b;

        /* JADX WARN: Type inference failed for: r1v12, types: [T, com.ss.android.lark.flow.mergeforward.FlowMergeForwardContainerFragment] */
        /* JADX WARN: Type inference failed for: r1v13, types: [T, com.ss.android.lark.flow.replyinthread.FlowReplyInThreadContainerFragment] */
        /* JADX WARN: Type inference failed for: r1v14, types: [T, com.ss.android.lark.officesdk.d1] */
        /* JADX WARN: Type inference failed for: r1v308, types: [T, tgb.a] */
        public final T a() {
            switch(this.b) {
                case 100: goto L205;
                case 101: goto L203;
                case 102: goto L201;
                case 103: goto L199;
                case 104: goto L197;
                case 105: goto L195;
                case 106: goto L193;
                case 107: goto L191;
                case 108: goto L189;
                case 109: goto L187;
                case 110: goto L184;
                case 111: goto L182;
                case 112: goto L180;
                case 113: goto L179;
                case 114: goto L177;
                case 115: goto L174;
                case 116: goto L173;
                case 117: goto L170;
                case 118: goto L168;
                case 119: goto L166;
                case 120: goto L164;
                case 121: goto L162;
                case 122: goto L160;
                case 123: goto L158;
                case 124: goto L156;
                case 125: goto L154;
                case 126: goto L152;
                case 127: goto L150;
                case 128: goto L149;
                case 129: goto L147;
                case 130: goto L145;
                case 131: goto L142;
                case 132: goto L140;
                case 133: goto L139;
                case 134: goto L137;
                case 135: goto L135;
                case 136: goto L133;
                case 137: goto L131;
                case 138: goto L129;
                case 139: goto L127;
                case 140: goto L124;
                case 141: goto L123;
                case 142: goto L121;
                case 143: goto L118;
                case 144: goto L116;
                case 145: goto L115;
                case 146: goto L113;
                case 147: goto L111;
                case 148: goto L109;
                case 149: goto L107;
                case 150: goto L104;
                case 151: goto L103;
                case 152: goto L101;
                case 153: goto L99;
                case 154: goto L97;
                case 155: goto L95;
                case 156: goto L93;
                case 157: goto L91;
                case 158: goto L89;
                case 159: goto L87;
                case 160: goto L84;
                case 161: goto L82;
                case 162: goto L81;
                case 163: goto L79;
                case 164: goto L77;
                case 165: goto L75;
                case 166: goto L73;
                case 167: goto L71;
                case 168: goto L69;
                case 169: goto L67;
                case 170: goto L65;
                case 171: goto L63;
                case 172: goto L61;
                case 173: goto L58;
                case 174: goto L57;
                case 175: goto L55;
                case 176: goto L53;
                case 177: goto L51;
                case 178: goto L49;
                case 179: goto L47;
                case 180: goto L45;
                case 181: goto L43;
                case 182: goto L41;
                case 183: goto L39;
                case 184: goto L37;
                case 185: goto L35;
                case 186: goto L33;
                case 187: goto L31;
                case 188: goto L29;
                case 189: goto L27;
                case 190: goto L25;
                case 191: goto L23;
                case 192: goto L21;
                case 193: goto L19;
                case 194: goto L16;
                case 195: goto L15;
                case 196: goto L13;
                case 197: goto L11;
                case 198: goto L9;
                case 199: goto L7;
                default: goto L5;
            };
        L16:
            y r1 = this.a;
            return (T) new DoubaoFeedMigrateStatus(r1.b, (com.bytedance.lark.rustclient.api.l) r1.T.get(), (com.ss.android.lark.passportc.api.m) this.a.v.get());
        L58:
            y r0 = this.a;
            ?? r2 = (T) FlowChatStarter_Factory.newInstance((jdb.g) r0.u.get(), (com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d) this.a.h1.get());
            ((tgb.a) r2).c = r0.k;
            return r2;
        L82:
            y r3 = this.a;
            return (T) new MessagePushV2(r3.b, (com.bytedance.lark.rustclient.api.l) r3.T.get());
        L84:
            y r4 = this.a;
            return (T) new ImSdkChatPushImplV2(r4.b, (com.bytedance.lark.rustclient.api.l) r4.T.get());
        L104:
            com.ss.android.lark.passportc.api.m r5 = (com.ss.android.lark.passportc.api.m) this.a.v.get();
            y r6 = this.a;
            return (T) new yra.a(r5, r6.b, (com.bytedance.lark.rustclient.api.l) r6.T.get());
        L116:
            y r7 = this.a;
            return (T) OfficePluginDependencyModule_ProvideISelectionConfigFactory.provideISelectionConfig(r7.l, r7.b);
        L118:
            y r8 = this.a;
            return (T) ShareUIServiceOfficeSDKCompat_ProvideIShareUIServiceFactory.provideIShareUIService(r8.o, (by4.b) r8.B.get());
        L124:
            by4.b r9 = (by4.b) this.a.B.get();
            return (T) new com.bytedance.ee.bear.assemble.profile.c();
        L140:
            com.ss.android.lark.passportc.api.m r10 = (com.ss.android.lark.passportc.api.m) this.a.v.get();
            return (T) new o75.b();
        L142:
            y r11 = this.a;
            return (T) DriveCacheServiceOfficeSDKCompat_ProvideDriveCacheServiceFactory.provideDriveCacheService(r11.m, (by4.b) r11.B.get(), (com.ss.android.lark.passportc.api.m) this.a.v.get());
        L150:
            y r12 = this.a;
            return (T) OfficePluginDependencyModule_ProvideISheetToolbarConfigFactory.provideISheetToolbarConfig(r12.l, r12.b);
        L152:
            y r13 = this.a;
            return (T) OfficePluginDependencyModule_ProvideISheetFabPanelConfigFactory.provideISheetFabPanelConfig(r13.l, r13.b);
        L154:
            y r14 = this.a;
            return (T) OfficePluginDependencyModule_ProvideISheetFabConfigFactory.provideISheetFabConfig(r14.l, r14.b);
        L156:
            y r15 = this.a;
            return (T) OfficePluginDependencyModule_ProvideIQRCodeHostServiceFactory.provideIQRCodeHostService(r15.l, r15.b);
        L158:
            y r16 = this.a;
            return (T) OfficePluginDependencyModule_ProvideIOrientationConfigFactory.provideIOrientationConfig(r16.l, r16.b);
        L160:
            y r17 = this.a;
            return (T) OfficePluginDependencyModule_ProvideILocationHostServiceFactory.provideILocationHostService(r17.l, r17.b);
        L162:
            y r18 = this.a;
            return (T) OfficePluginDependencyModule_ProvideICommentHostConfigFactory.provideICommentHostConfig(r18.l, r18.b);
        L164:
            y r19 = this.a;
            return (T) OfficePluginDependencyModule_ProvideIBitableFilePickerConfigFactory.provideIBitableFilePickerConfig(r19.l, r19.b);
        L166:
            y r20 = this.a;
            return (T) OfficePluginDependencyModule_ProvideIBitableFabConfigFactory.provideIBitableFabConfig(r20.l, r20.b);
        L168:
            y r21 = this.a;
            return (T) OfficePluginDependencyModule_ProvideIAlertConfigFactory.provideIAlertConfig(r21.l, r21.b);
        L170:
            y r22 = this.a;
            String r23 = r22.b;
            com.ss.android.lark.passportc.api.m r24 = (com.ss.android.lark.passportc.api.m) r22.v.get();
            y r25 = this.a;
            return (T) BitableUserModule_ProvideBitableAppFactory.provideBitableApp(r23, r24, r25.k, (com.bytedance.lark.rustclient.api.l) r25.T.get(), (jdb.g) this.a.u.get(), (awa.d) this.a.D.get(), (by4.d) this.a.B.get(), (com.bytedance.ee.util.db.a) this.a.N.get());
        L174:
            y r26 = this.a;
            return (T) OfficePluginDependencyModule_ProvideIToolbarConfigFactory.provideIToolbarConfig(r26.l, r26.b);
        L180:
            y r27 = this.a;
            ?? r28 = (T) HiltRoot_HiltComponents_UserCServiceProvider_Factory.newInstance();
            r28.a = DoubleCheck.lazy(r27.Y3);
            return r28;
        L182:
            y r29 = this.a;
            ?? r30 = (T) FlowReplyInThreadContainerFragment_Factory.newInstance();
            r29.getClass();
            FlowReplyInThreadFragment r31 = FlowReplyInThreadFragment_Factory.newInstance();
            r31.f = (com.ss.android.lark.chat.chatwindow.chat.v2.push.v) r29.n1.get();
            r31.g = r29.B1();
            r31.h = r29.y1();
            ((FlowReplyInThreadContainerFragment) r30).g = r31;
            return r30;
        L184:
            y r32 = this.a;
            ?? r33 = (T) FlowMergeForwardContainerFragment_Factory.newInstance();
            r32.getClass();
            FlowMergeForwardFragment r34 = FlowMergeForwardFragment_Factory.newInstance();
            ((BasePageFragment) r34).f = r32.B1();
            ((BasePageFragment) r34).g = r32.y1();
            r34.m = (com.ss.android.lark.chat.chatwindow.chat.v2.push.v) r32.n1.get();
            ((FlowMergeForwardContainerFragment) r33).f = r34;
            return r33;
        L5:
            throw new AssertionError(this.b);
        L7:
            return (T) BaseUserMocksModule_ProvideMyAIServiceFactory.provideMyAIService();
        L9:
            return (T) new LynxCardMonitorServiceImpl((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L11:
            return (T) new VoiceTextPostProcessServiceImpl((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L13:
            return (T) new nwb.d();
        L15:
            return (T) new com.ss.android.lark.forwardv3.forward.mediaforward.h((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L19:
            return (T) new neb.b(this.a.b);
        L21:
            return (T) new jeb.a(this.a.b);
        L23:
            return (T) new hnb.b();
        L25:
            return (T) new qbb.b((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L27:
            return (T) new com.ss.android.lark.create.groupchat.impl.service.interceptor.b();
        L29:
            return (T) new DefaultErrorInterceptor();
        L31:
            return (T) new ExceedGroupLimitAndApplyInterceptor();
        L33:
            return (T) new ExceedGroupLimitInterceptor();
        L35:
            return (T) new GroupMemberLimitInterceptor();
        L37:
            return (T) new com.ss.android.lark.create.groupchat.impl.service.interceptor.f();
        L39:
            return (T) new com.ss.android.lark.create.groupchat.impl.service.interceptor.g();
        L41:
            return (T) new com.ss.android.lark.create.groupchat.impl.service.b(y.x1(this.a));
        L43:
            return (T) new CreateGroupService((b38.b) this.a.Y.get(), (com.ss.android.lark.create.groupchat.impl.service.b) this.a.W2.get());
        L45:
            return (T) new com.ss.android.lark.conditional.access.traffic.handler.policy.center.d(this.a.b);
        L47:
            return (T) new SCRequestUserScopeImpl((com.bytedance.lark.rustclient.api.l) this.a.T.get(), (jdb.g) this.a.u.get());
        L49:
            return (T) new ConditionalAccessNetDependency((NoPermissionModuleManager) Preconditions.checkNotNullFromComponent((NoPermissionModuleManager) ((o) this.a.a).L0.get()), (com.ss.android.lark.security.compliance.infra.network.userscpoe.a) this.a.M2.get(), (com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L51:
            return (T) new com.ss.android.lark.conditional.access.display.e((com.ss.android.lark.storage.kv.storage.a) this.a.A.get());
        L53:
            return (T) new com.ss.android.lark.conditional.access.display.d((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L55:
            return (T) new CustomDisplayModule((com.ss.android.lark.passportc.api.m) this.a.v.get(), (com.ss.android.lark.conditional.access.display.h) this.a.J2.get(), (com.ss.android.lark.conditional.access.display.i) this.a.K2.get(), (apb.a) Preconditions.checkNotNullFromComponent((apb.a) ((o) this.a.a).Y0.get()));
        L57:
            return (T) Preconditions.checkNotNullFromComponent((k8b.c) ((o) this.a.a).K0.get());
        L61:
            return (T) new tgb.b();
        L63:
            return (T) OfficeSdkStarterMockModule_ProvideUnknownStarterFactory.provideUnknownStarter(new ytb.a());
        L65:
            return (T) OfficeSdkStarterMockModule_ProvideGroupProfileStarterFactory.provideGroupProfileStarter(new ytb.a());
        L67:
            return (T) OfficeSdkStarterMockModule_ProvideMyAiStarterFactory.provideMyAiStarter(new ytb.a());
        L69:
            return (T) new ChatterIdBundleTransform((com.ss.android.lark.chatwindow.launcher.transform.b) this.a.x2.get());
        L71:
            return (T) new ChatIdBundleTransform((com.ss.android.lark.chatwindow.launcher.transform.b) this.a.x2.get());
        L73:
            return (T) new ChatLaunchParamDataBundleTransform((com.ss.android.lark.chatwindow.launcher.transform.b) this.a.x2.get());
        L75:
            return (T) new ChatLaunchService((ImSdkChatService) this.a.Y0.get(), (com.ss.android.lark.im.sdk.service.h) this.a.Z0.get());
        L77:
            return (T) new ChatBundleTransform((com.ss.android.lark.chatwindow.launcher.transform.b) this.a.x2.get());
        L79:
            return (T) new ChatLauncherV2((com.ss.android.lark.passportc.api.m) this.a.v.get(), y.v1(this.a), y.w1(this.a));
        L81:
            return (T) new ytb.b();
        L87:
            return (T) new com.ss.android.lark.chat.name.a((IChatService) this.a.c0.get(), (ITranslateService) this.a.p0.get(), (jdb.g) this.a.u.get());
        L89:
            return (T) new q1b.c((com.ss.android.lark.passportc.api.m) this.a.v.get(), (com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L91:
            return (T) new m0b.a();
        L93:
            return (T) new com.ss.android.lark.biz.im.api.message.audit.b();
        L95:
            return (T) AuthorityUserScopeModule_ProvideImFileAuthorityRecordCacheFactory.provideImFileAuthorityRecordCache((com.ss.android.lark.passportc.api.m) this.a.v.get());
        L97:
            return (T) new com.ss.android.lark.audit.userscope.audit.e((com.bytedance.lark.rustclient.api.l) this.a.T.get(), (com.ss.android.lark.audit.userscope.audit.d) this.a.l2.get(), this.a.b);
        L99:
            return (T) new com.ss.android.lark.audit.userscope.audit.a((com.ss.android.lark.audit.userscope.audit.e) this.a.m2.get());
        L101:
            return (T) new com.ss.android.lark.audit.userscope.audit.d(this.a.b);
        L103:
            return (T) new com.ss.android.lark.audit.userscope.audit.g((com.ss.android.lark.passportc.api.m) this.a.v.get(), (com.ss.android.lark.audit.userscope.audit.d) this.a.l2.get(), (com.ss.android.lark.audit.userscope.audit.a) this.a.n2.get());
        L107:
            return (T) new SyncPushService((by4.b) this.a.B.get(), (com.ss.android.lark.passportc.api.m) this.a.v.get());
        L109:
            return (T) new zt5.c((by4.b) this.a.B.get(), (com.bytedance.ee.bear.middleground.permission.apply.c0) this.a.b2.get());
        L111:
            return (T) new s85.a((by4.b) this.a.B.get());
        L113:
            return (T) new TtsService((by4.b) this.a.B.get());
        L115:
            return (T) new gi5.a((by4.b) this.a.B.get());
        L121:
            return (T) new ii5.d();
        L123:
            return (T) new OfficePermissionPageFactory();
        L127:
            return (T) new com.ss.android.lark.integrator.ccm.dependency.di.g1();
        L129:
            return (T) new OfficeMessagingDependencyImpl();
        L131:
            return (T) AppInitializeOfficeSDKCompat_ProvideAppInitializeFactory.provideAppInitialize(this.a.n);
        L133:
            return (T) new com.bytedance.ee.bear.drive.services.c0((com.ss.android.lark.passportc.api.m) this.a.v.get());
        L135:
            return (T) new com.bytedance.ee.bear.drive.services.i((com.ss.android.lark.passportc.api.m) this.a.v.get());
        L137:
            return (T) new DriveSdkService((by4.b) this.a.B.get());
        L139:
            return (T) new x45.a();
        L145:
            return (T) new com.bytedance.ee.bear.document.knowledgeai.b();
        L147:
            return (T) new yz4.c();
        L149:
            return (T) new by4.a(this.a.b);
        L173:
            return (T) new dn4.b((jdb.g) this.a.u.get());
        L177:
            return (T) new h85.d1((com.ss.android.lark.passportc.api.m) this.a.v.get());
        L179:
            return (T) MapBuilder.newMapBuilder(167).put(com.bytedance.ee.bear.h.class, this.a.A1).put(an4.a.class, this.a.B1).put(dn4.a.class, this.a.C1).put(com.bytedance.ee.bear.bitable.core.usercomponent.a.class, this.a.D1).put(ks4.k.class, this.a.t).put(com.bytedance.ee.bear.bitable.homepage.chart.datasource.e.class, this.a.s).put(ew4.w.class, this.a.E1).put(ew4.x.class, this.a.F1).put(ew4.y.class, this.a.G1).put(ew4.z.class, this.a.H1).put(ew4.a0.class, this.a.I1).put(ew4.b0.class, this.a.J1).put(ew4.c0.class, this.a.K1).put(ew4.e0.class, this.a.L1).put(ew4.f0.class, this.a.M1).put(ew4.g0.class, this.a.N1).put(com.bytedance.ee.bear.contract.a0.class, this.a.H).put(com.bytedance.ee.bear.contract.h0.class, this.a.O).put(NetService.class, this.a.z).put(by4.c.class, this.a.O1).put(by4.d.class, this.a.B).put(yz4.a.class, this.a.P1).put(x05.a.class, this.a.K).put(com.bytedance.ee.bear.document.knowledgeai.a.class, this.a.Q1).put(com.bytedance.ee.bear.document.template.a.class, this.a.G).put(s45.c.class, this.a.C).put(t45.c.class, this.a.F).put(com.bytedance.ee.bear.drive.cache.w.class, this.a.R1).put(o75.a.class, this.a.S1).put(t75.a.class, this.a.T1).put(com.bytedance.ee.bear.drive.sdk.service.f.class, this.a.U1).put(com.bytedance.ee.bear.drive.services.c.class, this.a.V1).put(com.bytedance.ee.bear.drive.services.w.class, this.a.W1).put(com.bytedance.ee.bear.init.b.class, this.a.J).put(hb5.a.class, this.a.X1).put(com.bytedance.ee.bear.lark.dependency.t.class, this.a.Y1).put(com.bytedance.ee.bear.lark.dependency.a0.class, this.a.Z1).put(com.bytedance.ee.bear.lark.dependency.c0.class, this.a.a2).put(mc5.j.class, this.a.R).put(com.bytedance.ee.bear.middleground.permission.apply.c0.class, this.a.b2).put(ii5.b.class, this.a.c2).put(cj5.c.class, this.a.d2).put(ik5.a.class, this.a.L).put(com.bytedance.ee.bear.office.export.space.a.class, this.a.M).put(com.bytedance.ee.bear.route.h.class, this.a.Q).put(gm5.a.class, this.a.e2).put(hm5.a.class, this.a.f2).put(mo5.e.class, this.a.g2).put(BenefitManagerAPI.class, this.a.S).put(com.bytedance.ee.drive.preview.f.class, this.a.h2).put(zt5.a.class, this.a.i2).put(com.bytedance.ee.space.sync.b.class, this.a.j2).put(com.bytedance.ee.util.db.a.class, this.a.N).put(yra.e.class, this.a.k2).put(com.ss.android.lark.audio.voiceinput.service.k.class, this.a.d0).put(IAudioService.class, this.a.e0).put(com.ss.android.lark.audio.voiceinput.service.l.class, this.a.R0).put(com.ss.android.lark.audio.voiceinput.service.m.class, this.a.Q0).put(com.ss.android.lark.audio.voiceinput.service.o.class, this.a.N0).put(com.ss.android.lark.audio.voiceinput.service.p.class, this.a.M0).put(com.ss.android.lark.audit.userscope.audit.l.class, this.a.o2).put(com.ss.android.lark.auditsdk.v2.receivecheck.cache.a.class, this.a.p2).put(com.ss.android.lark.biz.im.api.o0.class, this.a.g0).put(com.ss.android.lark.biz.im.api.message.audit.f.class, this.a.q2).put(AbsChameleonJsRuntime.class, this.a.r2).put(q1b.a.class, this.a.s2).put(v1b.a.class, this.a.X).put(IChatService.class, this.a.c0).put(a2b.c.class, this.a.L0).put(a2b.d.class, this.a.K0).put(a2b.e.class, this.a.m0).put(a2b.f.class, this.a.n0).put(a2b.g.class, this.a.s0).put(a2b.h.class, this.a.t0).put(a2b.i.class, this.a.i1).put(a2b.j.class, this.a.E0).put(a2b.k.class, this.a.u0).put(a2b.l.class, this.a.j1).put(ITranslateService.class, this.a.p0).put(a2b.n.class, this.a.X0).put(a2b.o.class, this.a.D0).put(com.ss.android.lark.chat.api.service.impl.t0.class, this.a.o0).put(com.ss.android.lark.chat.api.service.impl.usergroup.b.class, this.a.W0).put(com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d.class, this.a.h1).put(com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.b.class, this.a.b1).put(com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.a.class, this.a.q0).put(com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b.class, this.a.r0).put(com.ss.android.lark.chat.chatwindow.chat.v2.push.v.class, this.a.n1).put(com.ss.android.lark.chat.chatwindow.chat.v2.push.z.class, this.a.k1).put(com.ss.android.lark.chat.core.api.d.class, this.a.l1).put(w4b.c.o.class, this.a.a0).put(com.ss.android.lark.chat.export.offlineCacheClean.a.class, this.a.o1).put(com.ss.android.lark.chat.name.f.class, this.a.t2).put(l6b.a.class, this.a.j0).put(m6b.a.class, this.a.P0).put(m6b.d.class, this.a.y0).put(m6b.g.class, this.a.k0).put(m6b.j.class, this.a.v0).put(m6b.m.class, this.a.i0).put(m6b.n.class, this.a.w0).put(m6b.q.class, this.a.J0).put(m6b.s.class, this.a.u2).put(m6b.t.class, this.a.F0).put(m6b.u.class, this.a.v2).put(x6b.a.class, this.a.w2).put(com.ss.android.lark.chatwindow.launcher.c.class, this.a.H2).put(k8b.c.class, this.a.I2).put(com.ss.android.lark.conditional.access.display.g.class, this.a.L2).put(ConditionalAccessNetDependency.class, this.a.N2).put(com.ss.android.lark.conditional.access.traffic.handler.policy.center.a.class, this.a.O2).put(com.ss.android.lark.create.groupchat.impl.service.h.class, this.a.X2).put(qbb.a.class, this.a.Y2).put(scb.b.class, this.a.Z2).put(jeb.d.class, this.a.a3).put(neb.a.class, this.a.b3).put(oeb.d.class, this.a.p1).put(com.ss.android.lark.flow.feed.data.a.class, this.a.c3).put(com.ss.android.lark.forwardv3.forward.mediaforward.f.class, this.a.d3).put(com.ss.android.lark.framework.assembly.rust.d.class, this.a.e3).put(com.ss.android.lark.im.sdk.service.e.class, this.a.f3).put(ImSdkChatService.class, this.a.Y0).put(com.ss.android.lark.im.sdk.service.h.class, this.a.Z0).put(com.ss.android.lark.im.sdk.service.p.class, this.a.x0).put(com.ss.android.lark.im.sdk.service.x.class, this.a.a1).put(yqb.a.class, this.a.P).put(com.ss.android.lark.message.lynxcard.monitor.a.class, this.a.g3).put(MyAIService.class, this.a.h3).put(rsb.a.class, this.a.i3).put(rsb.b.class, this.a.j3).put(ysb.a.class, this.a.k3).put(ysb.b.class, this.a.l3).put(zsb.a.class, this.a.m3).put(zsb.c.class, this.a.n3).put(INotificationHitPoint.class, this.a.o3).put(com.ss.android.lark.passport.b.class, this.a.p3).put(yyb.b.class, this.a.r3).put(com.ss.android.lark.passportc.api.m.class, this.a.v).put(com.ss.android.lark.profile.core.di.a.class, this.a.s3).put(m2c.a.class, this.a.u3).put(m2c.b.class, this.a.t3).put(g3c.a.class, this.a.v3).put(k3c.a.class, this.a.w3).put(a4c.a.class, this.a.x3).put(a4c.b.class, this.a.x3).put(b4c.a.class, this.a.x3).put(b4c.b.class, this.a.x3).put(b4c.c.class, this.a.x3).put(b4c.d.class, this.a.y3).put(y4c.a.class, this.a.z3).put(z4c.b.class, this.a.A3).put(o5c.b.class, this.a.B3).put(e6c.a.class, this.a.C3).put(e6c.b.class, this.a.D3).put(e6c.c.class, this.a.E3).put(com.ss.android.lark.tab.service.i.class, this.a.V0).put(com.ss.android.lark.tab.service.l.class, this.a.C0).put(com.ss.android.lark.tab.service.m.class, this.a.T0).put(IChatTabService.class, this.a.A0).put(com.ss.android.lark.translate.service.impl.a.class, this.a.H0).put(com.ss.android.lark.watermark.userscope.c.class, this.a.N3).put(com.ss.android.lark.watermark.v2.p.class, this.a.L3).put(ucc.a.class, this.a.O3).put(com.ss.android.lark.widget.photo.preview.video.pip.b.class, this.a.P3).put(jkc.c.class, this.a.R3).put(doc.e.class, this.a.U3).put(soc.a.class, this.a.W3).put(yoc.h.class, this.a.X3).build();
        L187:
            return (T) new ytb.n();
        L189:
            return (T) new KeyboardWrapperConfigurator();
        L191:
            return (T) new FlowMessageListConfigurator();
        L193:
            return (T) ReplyInThreadPluginModule_ProvideReplyInThreadPluginFactory.provideReplyInThreadPlugin();
        L195:
            return (T) MergeForwardPluginModule_ProvideMergeForwardPluginFactory.provideMergeForwardPlugin();
        L197:
            return (T) FlowThreadWindowPluginModule_ProvideFlowThreadWindowPluginFactory.provideFlowThreadWindowPlugin();
        L199:
            return (T) FlowChatPluginModule_ProvideFlowChatPluginFactory.provideFlowChatPlugin();
        L201:
            return (T) new com.ss.android.lark.feed.molten.page.a((com.ss.android.lark.passportc.api.m) this.a.v.get(), (com.ss.android.lark.feed.molten.cache.b) Preconditions.checkNotNullFromComponent(((o) this.a.a).l()));
        L203:
            return (T) new oeb.a((com.ss.android.lark.passportc.api.m) this.a.v.get());
        L205:
            return (T) new OfflineCacheClean((com.ss.android.lark.passportc.api.m) this.a.v.get(), (jdb.g) this.a.u.get(), (b38.b) this.a.Y.get());
        }

        /* JADX WARN: Type inference failed for: r1v226, types: [T, com.ss.android.lark.conditional.access.web.viewmodel.BindDeviceWebViewModel] */
        /* JADX WARN: Type inference failed for: r1v230, types: [T, com.ss.android.lark.conditional.access.device.viewmodel.DeviceDeclareViewModel] */
        /* JADX WARN: Type inference failed for: r1v235, types: [T, com.ss.android.lark.conditional.access.nopermission.viewmodel.NoPermissionViewModel] */
        public final T b() {
            switch(this.b) {
                case 200: goto L121;
                case 201: goto L119;
                case 202: goto L117;
                case 203: goto L115;
                case 204: goto L113;
                case 205: goto L111;
                case 206: goto L109;
                case 207: goto L106;
                case 208: goto L105;
                case 209: goto L102;
                case 210: goto L101;
                case 211: goto L99;
                case 212: goto L97;
                case 213: goto L95;
                case 214: goto L93;
                case 215: goto L91;
                case 216: goto L89;
                case 217: goto L87;
                case 218: goto L85;
                case 219: goto L83;
                case 220: goto L81;
                case 221: goto L79;
                case 222: goto L77;
                case 223: goto L75;
                case 224: goto L73;
                case 225: goto L71;
                case 226: goto L69;
                case 227: goto L67;
                case 228: goto L64;
                case 229: goto L63;
                case 230: goto L61;
                case 231: goto L59;
                case 232: goto L57;
                case 233: goto L55;
                case 234: goto L53;
                case 235: goto L51;
                case 236: goto L49;
                case 237: goto L47;
                case 238: goto L44;
                case 239: goto L43;
                case 240: goto L41;
                case 241: goto L39;
                case 242: goto L36;
                case 243: goto L34;
                case 244: goto L33;
                case 245: goto L31;
                case 246: goto L28;
                case 247: goto L27;
                case 248: goto L25;
                case 249: goto L22;
                case 250: goto L20;
                case 251: goto L19;
                case 252: goto L16;
                case 253: goto L15;
                case 254: goto L12;
                case 255: goto L11;
                case 256: goto L9;
                case 257: goto L7;
                default: goto L5;
            };
        L12:
            Application r0 = (Application) Preconditions.checkNotNullFromComponent(((o) this.a.a).G4());
            this.a.getClass();
            return (T) DwarfViewModelFactories_DwarfInternalFactoryFactory_Factory.newInstance(r0, SetBuilder.newSetBuilder(5).add(BindDeviceWebViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(DeviceDeclareViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(MessageFullScreenViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(NoPermissionViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(SyncedSourceReferencesViewModel_HiltModules_KeyModule_ProvideFactory.provide()).build(), Collections.emptySet());
        L16:
            y r1 = this.a;
            ?? r2 = (T) NoPermissionViewModel_Factory.newInstance();
            ((NoPermissionViewModel) r2).networkDependency = (ConditionalAccessNetDependency) r1.N2.get();
            ((NoPermissionViewModel) r2).dependency = (k8b.c) Preconditions.checkNotNullFromComponent((k8b.c) ((o) r1.a).K0.get());
            ((NoPermissionViewModel) r2).mfaService = (yyb.b) r1.r3.get();
            return r2;
        L20:
            y r3 = this.a;
            ?? r4 = (T) DeviceDeclareViewModel_Factory.newInstance((jdb.g) r3.u.get());
            ((DeviceDeclareViewModel) r4).networkDependency = (ConditionalAccessNetDependency) r3.N2.get();
            return r4;
        L22:
            y r5 = this.a;
            ?? r6 = (T) BindDeviceWebViewModel_Factory.newInstance();
            ((BindDeviceWebViewModel) r6).networkDependency = (ConditionalAccessNetDependency) r5.N2.get();
            return r6;
        L28:
            Application r7 = (Application) Preconditions.checkNotNullFromComponent(((o) this.a.a).G4());
            com.ss.android.lark.passportc.api.j r8 = (com.ss.android.lark.passportc.api.j) Preconditions.checkNotNullFromComponent((com.ss.android.lark.passportc.api.j) ((o) this.a.a).v0.get());
            com.ss.android.lark.passportc.api.m r9 = (com.ss.android.lark.passportc.api.m) this.a.v.get();
            y r10 = this.a;
            return (T) new ova.r(r7, r8, r9, r10.k, DoubleCheck.lazy(r10.e4), DoubleCheck.lazy(SetFactory.empty()));
        L34:
            y r11 = this.a;
            return (T) MmRecordingOfficeSDKUserModule_ProvideMmRecordingUserComponentFactory.provideMmRecordingUserComponent(r11.b, (mcb.c) r11.w.get(), (com.ss.android.lark.passportc.api.m) this.a.v.get(), (jdb.g) this.a.u.get(), (com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L36:
            Application r12 = (Application) Preconditions.checkNotNullFromComponent(((o) this.a.a).G4());
            y r13 = this.a;
            return (T) new OfficeSDKUserComponentManagerImpl(r12, r13.k, new w(r13));
        L44:
            y r14 = this.a;
            return (T) new a0c.b(r14.b, (yzb.b) Preconditions.checkNotNullFromComponent((yzb.b) ((o) r14.a).j0.get()), (kzb.b) Preconditions.checkNotNullFromComponent((kzb.b) ((o) this.a.a).a1.get()), (izb.a) Preconditions.checkNotNullFromComponent((izb.a) ((o) this.a.a).Z0.get()));
        L64:
            com.ss.android.lark.storage.kv.storage.a r15 = (com.ss.android.lark.storage.kv.storage.a) this.a.A.get();
            com.bytedance.lark.rustclient.api.l r16 = (com.bytedance.lark.rustclient.api.l) this.a.T.get();
            this.a.getClass();
            return (T) new WatermarkRepositoryV3(r15, r16, Collections.singleton(OfficeSDKWatermarkRuntimeInfoProviderModule_ProvideRuntimeInfoProviderFactory.provideRuntimeInfoProvider()));
        L102:
            y r17 = this.a;
            return (T) new FlowMfaEngine(r17.b, new FlowMfaRepository((com.bytedance.lark.rustclient.api.l) r17.T.get()), new com.ss.android.lark.passport.flow.mfa.h());
        L106:
            y r18 = this.a;
            return (T) new UserListFetcher(r18.b, (com.bytedance.lark.rustclient.api.l) r18.T.get());
        L5:
            throw new AssertionError(this.b);
        L7:
            return (T) new FeedSidebarItemsMoltenViewModelFactory((com.ss.android.lark.passportc.api.m) this.a.v.get(), (com.ss.android.lark.feed.molten.cache.b) Preconditions.checkNotNullFromComponent(((o) this.a.a).l()));
        L9:
            return (T) new OfficeSDKScreenCaptureAuditService(new com.ss.android.lark.integrator.security.compliance.screen_audit.a());
        L11:
            return (T) new KmpUserConvention((com.ss.android.lark.passportc.api.m) this.a.v.get());
        L15:
            return (T) new SyncedSourceReferencesViewModel((NetService) this.a.z.get(), (t45.c) this.a.F.get());
        L19:
            return (T) new MessageFullScreenViewModel((com.ss.android.lark.im.sdk.service.p) this.a.x0.get(), (jdb.g) this.a.u.get());
        L25:
            return (T) new skc.a(this.a.k);
        L27:
            return (T) Preconditions.checkNotNullFromComponent(((o) this.a.a).b());
        L31:
            return (T) new com.ss.android.lark.officesdk.feed.impl.a((com.bytedance.lark.rustclient.api.l) this.a.T.get(), (Application) Preconditions.checkNotNullFromComponent(((o) this.a.a).G4()), (com.ss.android.lark.passportc.api.m) this.a.v.get());
        L33:
            return (T) new cub.a((Application) Preconditions.checkNotNullFromComponent(((o) this.a.a).G4()), (OfficeSDKUserComponentManager) this.a.a4.get(), this.a.b);
        L39:
            return (T) new FloatingPanelService((com.ss.android.lark.passportc.api.m) this.a.v.get());
        L41:
            return (T) new dxa.a();
        L43:
            return (T) new soc.c(Collections.singleton((dxa.c) this.a.V3.get()));
        L47:
            return (T) new doc.l((com.ss.android.lark.storage.kv.storage.a) this.a.A.get(), (yzb.a) this.a.S3.get(), (o5c.b) this.a.B3.get());
        L49:
            return (T) new ClipboardManagerUserScope((com.ss.android.lark.storage.kv.storage.a) Preconditions.checkNotNullFromComponent((com.ss.android.lark.storage.kv.storage.a) ((o) this.a.a).h0.get()), (com.ss.android.lark.storage.kv.storage.a) this.a.A.get(), (doc.l) this.a.T3.get(), (yzb.a) this.a.S3.get(), (com.ss.android.lark.audit.userscope.auth.j) Preconditions.checkNotNullFromComponent((com.ss.android.lark.audit.userscope.auth.j) ((o) this.a.a).I0.get()), (jdb.g) this.a.u.get());
        L51:
            return (T) new StreamParamManagerUserScope((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L53:
            return (T) new SCCipherManagerUserScope((com.bytedance.lark.rustclient.api.l) this.a.T.get(), (com.ss.android.lark.passportc.api.m) this.a.v.get(), (jkc.d) this.a.Q3.get());
        L55:
            return (T) new PipUserContainerImpl((com.ss.android.lark.passportc.api.m) this.a.v.get());
        L57:
            return (T) new ucc.c((com.ss.android.lark.passportc.api.m) this.a.v.get());
        L59:
            return (T) new WatermarkAdapterV3((UiThreadExecutionWatermarkImplV3) this.a.K3.get());
        L61:
            return (T) new SubprocessWatermarkViewModelV3((WatermarkRepositoryV3) this.a.F3.get(), (ProcessSynchronizerV3) this.a.G3.get());
        L63:
            return (T) new ProcessSynchronizerV3((com.ss.android.lark.storage.kv.storage.a) this.a.A.get());
        L67:
            return (T) new WatermarkViewModelV3((WatermarkRepositoryV3) this.a.F3.get(), (ProcessSynchronizerV3) this.a.G3.get(), (jdb.g) this.a.u.get());
        L69:
            return (T) new WatermarkImplV3((WatermarkViewModelV3) this.a.H3.get(), (SubprocessWatermarkViewModelV3) this.a.I3.get());
        L71:
            return (T) new UiThreadExecutionWatermarkImplV3((WatermarkImplV3) this.a.J3.get());
        L73:
            return (T) new WatermarkImplFactoryV3((UiThreadExecutionWatermarkImplV3) this.a.K3.get(), (WatermarkAdapterV3) this.a.L3.get());
        L75:
            return (T) new WatermarkModuleV3((com.ss.android.lark.passportc.api.m) this.a.v.get(), (WatermarkImplFactoryV3) this.a.M3.get(), (com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L77:
            return (T) new CustomStickerService((com.ss.android.lark.passportc.api.m) this.a.v.get(), (com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L79:
            return (T) new com.ss.android.lark.sticker.core.impl.c((com.ss.android.lark.passportc.api.m) this.a.v.get(), (com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L81:
            return (T) new com.ss.android.lark.sticker.core.impl.a((com.ss.android.lark.passportc.api.m) this.a.v.get(), (com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L83:
            return (T) new x5c.b(this.a.b);
        L85:
            return (T) new ytb.m();
        L87:
            return (T) new y4c.c((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L89:
            return (T) new com.ss.android.lark.search.doubao.env.b((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L91:
            return (T) new ytb.u();
        L93:
            return (T) new UserStoreService((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L95:
            return (T) new UserNetStateService((com.bytedance.lark.rustclient.api.l) this.a.T.get(), this.a.b);
        L97:
            return (T) new ReactionService2((com.ss.android.lark.passportc.api.m) this.a.v.get(), (com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L99:
            return (T) new ReactionOrderService2((com.ss.android.lark.passportc.api.m) this.a.v.get(), (com.bytedance.lark.rustclient.api.l) this.a.T.get(), (rsb.b) this.a.j3.get(), (rsb.a) this.a.i3.get(), (m2c.b) this.a.t3.get(), (jdb.g) this.a.u.get());
        L101:
            return (T) new ProfileNetClientGetterImpl((com.bytedance.lark.rustclient.api.l) this.a.T.get(), (b38.b) this.a.Y.get());
        L105:
            return (T) new com.ss.android.lark.passport.flow.mfa.u((FlowMfaEngine) this.a.q3.get());
        L109:
            return (T) new com.ss.android.lark.flow.notification.online.process.c((com.ss.android.lark.passportc.api.m) this.a.v.get());
        L111:
            return (T) new com.ss.android.lark.flow.notification.online.process.e((com.ss.android.lark.passportc.api.m) this.a.v.get());
        L113:
            return (T) new com.ss.android.lark.flow.notification.online.process.d((com.ss.android.lark.passportc.api.m) this.a.v.get(), (com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L115:
            return (T) BaseUserMocksModule_ProvideINotificationSettingApiFactory.provideINotificationSettingApi();
        L117:
            return (T) BaseUserMocksModule_ProvideINotificationControllerApiFactory.provideINotificationControllerApi();
        L119:
            return (T) new EmojiService2((com.ss.android.lark.passportc.api.m) this.a.v.get(), (com.bytedance.lark.rustclient.api.l) this.a.T.get(), (rsb.a) this.a.i3.get());
        L121:
            return (T) new EmojiMapManager2((com.ss.android.lark.passportc.api.m) this.a.v.get());
        }

        public final T get() {
            int r1 = this.b;
            int r2 = r1 / 100;
            if (r2 != 0) goto L5;
            switch(r1) {
                case 0: goto L117;
                case 1: goto L213;
                case 2: goto L113;
                case 3: goto L211;
                case 4: goto L111;
                case 5: goto L209;
                case 6: goto L109;
                case 7: goto L207;
                case 8: goto L107;
                case 9: goto L206;
                case 10: goto L105;
                case 11: goto L204;
                case 12: goto L203;
                case 13: goto L202;
                case 14: goto L101;
                case 15: goto L100;
                case 16: goto L200;
                case 17: goto L98;
                case 18: goto L97;
                case 19: goto L96;
                case 20: goto L196;
                case 21: goto L195;
                case 22: goto L194;
                case 23: goto L92;
                case 24: goto L193;
                case 25: goto L192;
                case 26: goto L89;
                case 27: goto L190;
                case 28: goto L87;
                case 29: goto L188;
                case 30: goto L187;
                case 31: goto L186;
                case 32: goto L83;
                case 33: goto L82;
                case 34: goto L183;
                case 35: goto L80;
                case 36: goto L181;
                case 37: goto L180;
                case 38: goto L179;
                case 39: goto L178;
                case 40: goto L177;
                case 41: goto L176;
                case 42: goto L175;
                case 43: goto L174;
                case 44: goto L173;
                case 45: goto L172;
                case 46: goto L171;
                case 47: goto L170;
                case 48: goto L169;
                case 49: goto L168;
                case 50: goto L167;
                case 51: goto L166;
                case 52: goto L165;
                case 53: goto L164;
                case 54: goto L163;
                case 55: goto L162;
                case 56: goto L161;
                case 57: goto L160;
                case 58: goto L159;
                case 59: goto L56;
                case 60: goto L157;
                case 61: goto L156;
                case 62: goto L155;
                case 63: goto L154;
                case 64: goto L153;
                case 65: goto L152;
                case 66: goto L151;
                case 67: goto L48;
                case 68: goto L149;
                case 69: goto L46;
                case 70: goto L147;
                case 71: goto L44;
                case 72: goto L145;
                case 73: goto L42;
                case 74: goto L143;
                case 75: goto L40;
                case 76: goto L141;
                case 77: goto L38;
                case 78: goto L139;
                case 79: goto L36;
                case 80: goto L137;
                case 81: goto L34;
                case 82: goto L135;
                case 83: goto L32;
                case 84: goto L133;
                case 85: goto L30;
                case 86: goto L29;
                case 87: goto L130;
                case 88: goto L129;
                case 89: goto L26;
                case 90: goto L25;
                case 91: goto L126;
                case 92: goto L125;
                case 93: goto L124;
                case 94: goto L123;
                case 95: goto L122;
                case 96: goto L19;
                case 97: goto L120;
                case 98: goto L119;
                case 99: goto L118;
                default: goto L15;
            };
        L19:
            y r3 = this.a;
            return (T) new SecretChatDataCorruptPush(r3.b, (com.bytedance.lark.rustclient.api.l) r3.T.get());
        L25:
            com.ss.android.lark.passportc.api.m r4 = (com.ss.android.lark.passportc.api.m) this.a.v.get();
            y r5 = this.a;
            return (T) new com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.a(r4, r5.b, (ImSdkChatService) r5.Y0.get(), (com.ss.android.lark.im.sdk.service.h) this.a.Z0.get(), (com.ss.android.lark.im.sdk.service.x) this.a.a1.get(), (m6b.t) this.a.F0.get());
        L26:
            y r6 = this.a;
            return (T) new com.ss.android.lark.im.sdk.service.f(r6.b, (com.bytedance.lark.rustclient.api.l) r6.T.get());
        L29:
            com.ss.android.lark.chat.chatwindow.chat.preloaderv2.c r7 = (com.ss.android.lark.chat.chatwindow.chat.preloaderv2.c) this.a.e1.get();
            Map r8 = y.u1(this.a);
            y r9 = this.a;
            r9.getClass();
            return (T) new DataPreloadManagerV2(r7, r8, MapBuilder.newMapBuilder(2).put(DataPreLoaderType.CHAT_DATA, r9.f1).put(DataPreLoaderType.CHAT_WINDOW, r9.g1).build(), (com.ss.android.lark.passportc.api.m) this.a.v.get());
        L30:
            y r10 = this.a;
            return (T) new UserGroupPushRepository(r10.b, (com.bytedance.lark.rustclient.api.l) r10.T.get());
        L32:
            y r11 = this.a;
            return (T) new ChatTabExtraPushRepositoryV2(r11.b, (com.bytedance.lark.rustclient.api.l) r11.T.get());
        L34:
            y r12 = this.a;
            return (T) new ChatTabPushRepositoryV2(r12.b, (com.bytedance.lark.rustclient.api.l) r12.T.get());
        L36:
            y r13 = this.a;
            return (T) new NewAudio2TextPushRepositoryV2(r13.b, (com.bytedance.lark.rustclient.api.l) r13.T.get());
        L38:
            y r14 = this.a;
            return (T) new com.ss.android.lark.chat.service.impl.g(r14.b, (com.bytedance.lark.rustclient.api.l) r14.T.get());
        L40:
            y r15 = this.a;
            return (T) new com.ss.android.lark.audio.voiceinput.service.x(r15.b, (com.bytedance.lark.rustclient.api.l) r15.T.get());
        L42:
            y r16 = this.a;
            return (T) new PreviewPushRepositoryV2(r16.b, (com.bytedance.lark.rustclient.api.l) r16.T.get());
        L44:
            y r17 = this.a;
            return (T) new l2(r17.b, (com.bytedance.lark.rustclient.api.l) r17.T.get());
        L46:
            y r18 = this.a;
            return (T) new com.ss.android.lark.translate.service.impl.o(r18.b, (com.bytedance.lark.rustclient.api.l) r18.T.get());
        L48:
            y r19 = this.a;
            return (T) new ImSdkChatterPushImplV2(r19.b, (com.bytedance.lark.rustclient.api.l) r19.T.get());
        L56:
            y r20 = this.a;
            r20.getClass();
            com.ss.android.lark.im.sdk.message.f r21 = new com.ss.android.lark.im.sdk.message.f((com.bytedance.lark.rustclient.api.l) r20.T.get(), new VoiceTextPostProcessServiceImpl((com.bytedance.lark.rustclient.api.l) r20.T.get()));
            y r22 = this.a;
            r22.getClass();
            return (T) new ImSdkMessageServiceImplV2(r21, new com.ss.android.lark.im.sdk.message.b((com.bytedance.lark.rustclient.api.l) r22.T.get()), (com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L80:
            y r23 = this.a;
            return (T) ImUserStorageModule_ProvideKVRepoFactory.provideKVRepo(r23.j, (com.ss.android.lark.storage.kv.storage.a) r23.A.get());
        L82:
            y r24 = this.a;
            String r25 = r24.b;
            b38.b r26 = (b38.b) r24.Y.get();
            KVRepo r27 = (KVRepo) this.a.Z.get();
            w4b.c.o r28 = (w4b.c.o) this.a.a0.get();
            IChatService r29 = (IChatService) this.a.c0.get();
            IAudioService r30 = (IAudioService) this.a.e0.get();
            com.ss.android.lark.biz.im.api.o0 r31 = (com.ss.android.lark.biz.im.api.o0) this.a.g0.get();
            m6b.m r110 = (m6b.m) this.a.i0.get();
            m6b.g r111 = (m6b.g) this.a.k0.get();
            jdb.g r112 = (jdb.g) this.a.u.get();
            com.ss.android.lark.chat.cot.a r113 = (com.ss.android.lark.chat.cot.a) this.a.l0.get();
            a2b.f r114 = (a2b.f) this.a.n0.get();
            ITranslateService r115 = (ITranslateService) this.a.p0.get();
            com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b r116 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b) this.a.r0.get();
            a2b.h r117 = (a2b.h) this.a.t0.get();
            a2b.k r118 = (a2b.k) this.a.u0.get();
            MessageTenantConfService r119 = (MessageTenantConfService) this.a.v0.get();
            m6b.n r210 = (m6b.n) this.a.w0.get();
            y r32 = this.a;
            r32.getClass();
            EditMessageService r33 = new EditMessageService((b38.b) r32.Y.get(), (m6b.j) r32.v0.get(), (com.ss.android.lark.im.sdk.service.p) r32.x0.get());
            m6b.d r211 = (m6b.d) this.a.y0.get();
            y r34 = this.a;
            r34.getClass();
            return (T) new ChatAppContainerV2(r25, r26, r27, r28, r29, r30, r31, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r33, r211, new com.ss.android.lark.chat.utils.x0((m6b.d) r34.y0.get()), (IChatTabService) this.a.A0.get(), (com.ss.android.lark.tab.service.l) this.a.C0.get(), (a2b.o) this.a.D0.get(), (a2b.j) this.a.E0.get(), (m6b.t) this.a.F0.get(), (com.ss.android.lark.translate.service.impl.a) this.a.H0.get(), (m6b.q) this.a.J0.get(), (a2b.c) this.a.L0.get(), (com.ss.android.lark.audio.voiceinput.service.o) this.a.N0.get(), (m6b.a) this.a.P0.get(), (com.ss.android.lark.audio.voiceinput.service.l) this.a.R0.get(), (com.ss.android.lark.tab.service.m) this.a.T0.get(), (com.ss.android.lark.tab.service.i) this.a.V0.get(), (a2b.n) this.a.X0.get(), (com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d) this.a.h1.get(), (a2b.i) this.a.i1.get(), (a2b.l) this.a.j1.get(), (com.ss.android.lark.chat.chatwindow.chat.v2.push.z) this.a.k1.get(), (com.ss.android.lark.chat.core.api.d) this.a.l1.get());
        L83:
            y r35 = this.a;
            return (T) ChatAppContainerUserModule_ProvideChatAppContainerFactory.provideChatAppContainer(r35.i, (ChatAppContainerV2) r35.m1.get());
        L87:
            com.bytedance.lark.sdk.refactor.l r36 = (com.bytedance.lark.sdk.refactor.l) Preconditions.checkNotNullFromComponent((com.bytedance.lark.sdk.refactor.l) ((o) this.a.a).b0.get());
            com.bytedance.lark.sdk.refactor.state.c r37 = (com.bytedance.lark.sdk.refactor.state.c) Preconditions.checkNotNullFromComponent(((o) this.a.a).H4());
            com.bytedance.lark.rustclient.internal.k r38 = (com.bytedance.lark.rustclient.internal.k) Preconditions.checkNotNullFromComponent((com.bytedance.lark.rustclient.internal.k) ((o) this.a.a).Y.get());
            com.bytedance.lark.rustclient.internal.m r39 = (com.bytedance.lark.rustclient.internal.m) Preconditions.checkNotNullFromComponent(((o) this.a.a).I4());
            ((o) this.a.a).getClass();
            return (T) UserRustClientModule_ProvideClientFactory.provideClient(r36, r37, r38, r39, (Set) Preconditions.checkNotNullFromComponent(Collections.singleton(new com.ss.android.lark.framework.assembly.rust.e0())), (com.bytedance.lark.sdk.refactor.e) Preconditions.checkNotNullFromComponent(RustSdkModule_ProvideBarrierFactory.provideBarrier((com.bytedance.lark.sdk.refactor.n) ((o) this.a.a).z0.get())), (com.ss.android.lark.passportc.api.m) this.a.v.get());
        L89:
            y r40 = this.a;
            return (T) BenefitManagerOfficeSDKCompat_ProvideDriveCacheServiceFactory.provideDriveCacheService(r40.h, (NetService) r40.z.get(), (com.ss.android.lark.passportc.api.m) this.a.v.get(), (by4.b) this.a.B.get(), (com.bytedance.ee.util.db.a) this.a.N.get());
        L92:
            y r41 = this.a;
            com.bytedance.ee.bear.route.g r42 = OfficeUserRouteServiceImpl_Factory.newInstance((t45.c) r41.F.get());
            ((UserRouteServiceImpl) r42).a = DoubleCheck.lazy(r41.P);
        L212:
            return (T) r42;
        L96:
            y r43 = this.a;
            return (T) DocsHistoryDomainModule_ProvideDocsHistoryDomainDependencyFactory.provideDocsHistoryDomainDependency(r43.g, r43.b);
        L97:
            com.ss.android.lark.passportc.api.m r44 = (com.ss.android.lark.passportc.api.m) this.a.v.get();
            return (T) new s45.p((s45.c) this.a.C.get(), (awa.d) this.a.D.get(), (s45.f) this.a.E.get());
        L98:
            y r45 = this.a;
            return (T) OfficeTemplateUrlModule_ProvideTemplateUrlDependencyFactory.provideTemplateUrlDependency(r45.f, r45.b, (t45.c) r45.F.get(), (jdb.g) this.a.u.get());
        L100:
            y r46 = this.a;
            r42 = UserSettingManager_Factory.newInstance((awa.b) Preconditions.checkNotNullFromComponent((awa.b) ((o) r46.a).D0.get()));
            ((bwa.r) r42).a = r46.b;
            ((bwa.r) r42).b = (awa.b) Preconditions.checkNotNullFromComponent((awa.b) ((o) r46.a).D0.get());
            goto L212
        L101:
            com.ss.android.lark.passportc.api.m r47 = (com.ss.android.lark.passportc.api.m) this.a.v.get();
            return (T) new s45.j((s45.c) this.a.C.get(), (awa.d) this.a.D.get(), (s45.f) this.a.E.get(), this.a.G);
        L105:
            y r48 = this.a;
            return (T) DomainCharacteristicServiceOfficeSDKCompat_ProvideDomainCharacteristicServiceFactory.provideDomainCharacteristicService(r48.e, (by4.d) r48.B.get(), (NetService) this.a.z.get(), (t45.b) this.a.x.get(), (com.ss.android.lark.passportc.api.m) this.a.v.get());
        L107:
            y r49 = this.a;
            r42 = UserDomainConfigService_Factory.newInstance((com.ss.android.lark.passportc.api.j) Preconditions.checkNotNullFromComponent((com.ss.android.lark.passportc.api.j) ((o) r49.a).v0.get()), (mcb.b) Preconditions.checkNotNullFromComponent((mcb.b) ((o) this.a.a).P0.get()));
            ((lcb.f) r42).a = r49.b;
            ((lcb.f) r42).b = (mcb.b) Preconditions.checkNotNullFromComponent((mcb.b) ((o) r49.a).P0.get());
            ((lcb.f) r42).c = (com.ss.android.lark.passportc.api.j) Preconditions.checkNotNullFromComponent((com.ss.android.lark.passportc.api.j) ((o) r49.a).v0.get());
            goto L212
        L109:
            y r50 = this.a;
            return (T) NetServiceOfficeSDKCompat_ProvideNetServiceFactory.provideNetService(r50.d, (t45.b) r50.x.get(), (com.ss.android.lark.passportc.api.m) this.a.v.get(), (sa5.j) this.a.y.get(), (jdb.g) this.a.u.get());
        L111:
            y r51 = this.a;
            return (T) new UserPassportServiceImpl(r51.c, (com.ss.android.lark.log.c) Preconditions.checkNotNullFromComponent((com.ss.android.lark.log.c) ((o) r51.a).e0.get()), new com.ss.android.lark.passportc.internal.i(), (l0c.c) Preconditions.checkNotNullFromComponent((l0c.c) ((o) this.a.a).U.get()));
        L113:
            y r52 = this.a;
            r42 = UserFeatureGatingService_Factory.newInstance((jdb.d) Preconditions.checkNotNullFromComponent((jdb.d) ((o) r52.a).G0.get()));
            ((ldb.g) r42).a = r52.b;
            goto L212
        L15:
            throw new AssertionError(this.b);
        L118:
            return (T) new ytb.p();
        L119:
            return (T) new com.ss.android.lark.chat.chatwindow.chat.v2.push.n0((com.ss.android.lark.passportc.api.m) this.a.v.get());
        L120:
            return (T) new dnb.b();
        L122:
            return (T) new v3b.c();
        L123:
            return (T) new v3b.b();
        L124:
            return (T) new com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.b((com.ss.android.lark.im.sdk.service.p) this.a.x0.get());
        L125:
            return (T) new com.ss.android.lark.im.sdk.service.y((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L126:
            return (T) new ImSdkChatterServiceImplV2((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L129:
            return (T) new ChatDataPreLoaderV2((ImSdkChatService) this.a.Y0.get(), (com.ss.android.lark.im.sdk.service.p) this.a.x0.get(), (com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.b) this.a.b1.get());
        L130:
            return (T) new DataPreloadEngineV2((com.ss.android.lark.passportc.api.m) this.a.v.get(), y.u1(this.a));
        L133:
            return (T) new UserGroupPush((com.ss.android.lark.chat.api.service.impl.usergroup.b) this.a.W0.get(), (a2b.o) this.a.D0.get());
        L135:
            return (T) new ChatTabExtraPush((com.ss.android.lark.tab.service.j) this.a.U0.get());
        L137:
            return (T) new ChatTabPush((com.ss.android.lark.tab.service.n) this.a.S0.get());
        L139:
            return (T) new NewAudio2TextPush((com.ss.android.lark.audio.voiceinput.service.m) this.a.Q0.get());
        L141:
            return (T) new com.ss.android.lark.chat.service.impl.f((m6b.b) this.a.O0.get());
        L143:
            return (T) new com.ss.android.lark.audio.voiceinput.service.w((com.ss.android.lark.audio.voiceinput.service.p) this.a.M0.get());
        L145:
            return (T) new PreviewPush((a2b.d) this.a.K0.get(), (a2b.f) this.a.n0.get());
        L147:
            return (T) new k2((m6b.r) this.a.I0.get());
        L149:
            return (T) new com.ss.android.lark.translate.service.impl.n((com.ss.android.lark.translate.service.impl.b) this.a.G0.get());
        L151:
            return (T) new SmartApplyAnswerService((b38.b) this.a.Y.get());
        L152:
            return (T) new UserGroupService((com.bytedance.lark.rustclient.api.l) this.a.T.get(), (jdb.g) this.a.u.get());
        L153:
            return (T) new com.ss.android.lark.tab.service.b((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L154:
            return (T) new ChatTabExtraService((com.ss.android.lark.tab.service.k) this.a.B0.get());
        L155:
            return (T) new com.ss.android.lark.tab.service.f((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L156:
            return (T) new com.ss.android.lark.tab.service.g((com.ss.android.lark.tab.service.o) this.a.z0.get());
        L157:
            return (T) new com.ss.android.lark.chat.service.impl.i((IChatService) this.a.c0.get());
        L159:
            return (T) new z1((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L160:
            return (T) new MessageTenantConfService((b38.b) this.a.Y.get());
        L161:
            return (T) new com.ss.android.lark.officesdk.integrator.im.impl.q();
        L162:
            return (T) new com.ss.android.lark.chat.api.service.impl.e1((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L163:
            return (T) new PrivateDescriptionService((a2b.g) this.a.s0.get());
        L164:
            return (T) new com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.d((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L165:
            return (T) new UserFieldsService((com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.a) this.a.q0.get(), (jdb.g) this.a.u.get());
        L166:
            return (T) new a2((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L167:
            return (T) new TranslateService((com.ss.android.lark.chat.api.service.impl.t0) this.a.o0.get());
        L168:
            return (T) new PreviewRepositoryV2((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L169:
            return (T) new PreviewService((a2b.e) this.a.m0.get());
        L170:
            return (T) new com.ss.android.lark.chat.cot.a((jdb.g) this.a.u.get());
        L171:
            return (T) new DraftRepositoryV2((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L172:
            return (T) new com.ss.android.lark.chat.service.impl.r((l6b.a) this.a.j0.get());
        L173:
            return (T) new n1((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L174:
            return (T) new v1((m6b.l) this.a.h0.get());
        L175:
            return (T) new l1((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L176:
            return (T) new q1((a2b.m) this.a.f0.get());
        L177:
            return (T) new com.ss.android.lark.audio.voiceinput.service.d((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L178:
            return (T) new com.ss.android.lark.audio.voiceinput.service.i((com.ss.android.lark.audio.voiceinput.service.k) this.a.d0.get(), this.a.k);
        L179:
            return (T) new com.ss.android.lark.chat.api.service.impl.o((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L180:
            return (T) new ChatService((a2b.a) this.a.b0.get());
        L181:
            return (T) new w4b.a0((com.ss.android.lark.passportc.api.m) this.a.v.get());
        L183:
            return (T) UserRucketModule_ProvideRucketFactory.provideRucket((com.bytedance.lark.rustclient.api.l) this.a.T.get(), this.a.b);
        L186:
            return (T) new v1b.b();
        L187:
            return (T) new com.ss.android.lark.active.user.bridge.d();
        L188:
            return (T) new com.ss.android.lark.active.user.bridge.h();
        L190:
            return (T) new com.ss.android.lark.conditional.access.plugin.a((com.bytedance.lark.rustclient.api.l) this.a.T.get());
        L192:
            return (T) new x2((com.bytedance.ee.util.db.a) this.a.N.get(), (t45.c) this.a.F.get());
        L193:
            return (T) BaseUserMocksModule_ProvideIExportTabDataManagerFactory.provideIExportTabDataManager();
        L194:
            return (T) new com.bytedance.ee.util.db.container.a((com.ss.android.lark.passportc.api.m) this.a.v.get());
        L195:
            return (T) new com.bytedance.ee.bear.account.container.impl.c((com.ss.android.lark.passportc.api.m) this.a.v.get(), (com.bytedance.ee.bear.contract.a0) this.a.H.get(), (NetService) this.a.z.get(), (com.bytedance.ee.util.db.a) this.a.N.get(), (by4.d) this.a.B.get());
        L196:
            return (T) new com.bytedance.ee.bear.office.space.l((Application) Preconditions.checkNotNullFromComponent(((o) this.a.a).G4()), (com.bytedance.ee.bear.init.a) Preconditions.checkNotNullFromComponent((com.bytedance.ee.bear.init.a) ((o) this.a.a).R.get()), (NetService) this.a.z.get());
        L200:
            return (T) CCMDomainUserModule_ProvideDwarfDomainConfigParserFactory.provideDwarfDomainConfigParser((com.ss.android.lark.passportc.api.m) this.a.v.get(), (s45.c) this.a.C.get());
        L202:
            return (T) new com.bytedance.ee.bear.account.container.dwarf.a((com.ss.android.lark.passportc.api.m) this.a.v.get(), (t45.c) this.a.F.get(), (NetService) this.a.z.get(), (t45.b) this.a.x.get());
        L203:
            return (T) UserStorageModule_ProvideUserKVStorageFactory.provideUserKVStorage((Application) Preconditions.checkNotNullFromComponent(((o) this.a.a).G4()), this.a.b);
        L204:
            return (T) new by4.b((com.ss.android.lark.storage.kv.storage.a) this.a.A.get());
        L206:
            return (T) CCMUserCookiesModule_ProvideUserCookiesAdapterV2Factory.provideUserCookiesAdapterV2((com.ss.android.lark.passportc.api.m) this.a.v.get());
        L207:
            return (T) CCMDomainUserModule_ProvideDwarfDocDomainConfigFactory.provideDwarfDocDomainConfig((com.ss.android.lark.passportc.api.m) this.a.v.get(), (mcb.c) this.a.w.get());
        L209:
            return (T) new com.bytedance.ee.bear.init.d((NetService) this.a.z.get(), (s45.c) this.a.C.get(), (com.bytedance.ee.bear.contract.a0) this.a.H.get(), (s45.p) this.a.I.get());
        L211:
            return (T) new UserDocsSdkImpl((com.ss.android.lark.passportc.api.m) this.a.v.get(), (com.bytedance.ee.bear.init.a) Preconditions.checkNotNullFromComponent((com.bytedance.ee.bear.init.a) ((o) this.a.a).R.get()), (com.bytedance.ee.bear.init.b) this.a.J.get(), (s45.f) this.a.E.get(), (t45.c) this.a.F.get(), (x05.a) this.a.K.get());
        L213:
            return (T) new ks4.d();
        L117:
            return (T) new UserScopeChartDataFetcher();
        L5:
            if (r2 == 1) goto L12;
            if (r2 != 2) goto L10;
            return b();
        L10:
            throw new AssertionError(this.b);
        L12:
            return a();
        }

        public a(y r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final void A() {
    }

    public final void A0() {
    }

    public final void B() {
    }

    public final void B0() {
    }

    public final void C0() {
    }

    public final void D() {
    }

    public final void D0() {
    }

    public final void E() {
    }

    public final void F() {
    }

    public final void F0() {
    }

    public final void G() {
    }

    public final void G0() {
    }

    public final void H0() {
    }

    public final void I() {
    }

    public final void I0() {
    }

    public final void J() {
    }

    public final void K0() {
    }

    public final void L() {
    }

    public final void L0() {
    }

    public final void M() {
    }

    public final void N0() {
    }

    public final void O() {
    }

    public final void Q() {
    }

    public final void Q0() {
    }

    @Override // com.ss.android.lark.passportc.task.j
    public final Set<com.ss.android.lark.passportc.task.d> R() {
        SetBuilder r0 = SetBuilder.newSetBuilder(7);
        InitMinutesRecordingTask r1 = InitMinutesRecordingTask_Factory.newInstance();
        r1.a = (com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a) this.b4.get();
        SetBuilder r2 = r0.add(r1);
        com.ss.android.lark.passportc.task.h r3 = InitStaticUserConventionTask_Factory.newInstance();
        r3.a = (com.ss.android.lark.passportc.api.m) this.v.get();
        r3.b = SetBuilder.newSetBuilder(3).add((com.ss.android.lark.passportc.api.q) this.n4.get()).add(new com.ss.android.lark.passportc.api.v()).add((com.ss.android.lark.passportc.api.q) this.o4.get()).build();
        SetBuilder r4 = r2.add(r3).add(new KmpOnlineTask());
        jjb.h r5 = MakeRustOnlineTask_Factory.newInstance((com.bytedance.lark.rustclient.api.l) this.T.get(), UserRustClientModule_ProvideDispatcherFactory.provideDispatcher((com.bytedance.lark.rustclient.api.l) this.T.get()), (com.bytedance.lark.rustclient.internal.m) Preconditions.checkNotNullFromComponent(((o) this.a).I4()), (yzb.a) this.S3.get(), (jzb.a) Preconditions.checkNotNullFromComponent((jzb.a) ((o) this.a).w5.get()), (com.bytedance.lark.sdk.refactor.n) Preconditions.checkNotNullFromComponent(((o) this.a).J4()), new UserStoreService((com.bytedance.lark.rustclient.api.l) this.T.get()), (IAppStateSyncService) Preconditions.checkNotNullFromComponent((IAppStateSyncService) ((o) this.a).o2.get()));
        r5.i = new com.ss.android.lark.framework.assembly.rust.p((jdb.e) Preconditions.checkNotNullFromComponent((jdb.e) ((o) this.a).G0.get()), (apb.a) Preconditions.checkNotNullFromComponent((apb.a) ((o) this.a).Y0.get()));
        r5.j = (com.ss.android.lark.framework.assembly.rust.d) this.e3.get();
        SetBuilder r6 = r4.add(r5).add(new SetLoginChatterTask((com.ss.android.lark.passportc.api.i) Preconditions.checkNotNullFromComponent((com.ss.android.lark.passportc.api.i) ((o) this.a).c0.get()))).add(new wjb.a());
        zoc.b r7 = FloatingPanelInitTask_Factory.newInstance();
        r7.a = DoubleCheck.lazy(this.X3);
        return r6.add(r7).build();
    }

    public final void R0() {
    }

    public final void S0() {
    }

    public final void T() {
    }

    public final void U() {
    }

    public final void V0() {
    }

    public final void W0() {
    }

    public final void Y() {
    }

    public final void Z0() {
    }

    public final void a() {
    }

    public final void a0() {
    }

    public final Map<Class<?>, javax.inject.Provider<com.ss.android.lark.active.user.bridge.e<?, ?>>> b() {
        return MapBuilder.newMapBuilder(2).put(com.ss.android.lark.conditional.access.plugin.a.class, this.U).put(com.ss.android.lark.active.user.bridge.h.class, this.V).build();
    }

    public final void b1() {
    }

    public final void c() {
    }

    public final void c0() {
    }

    public final void c1() {
    }

    public final void d() {
    }

    public final void d0() {
    }

    public final void d1() {
    }

    public final void e() {
    }

    public final void f() {
    }

    public final void f0() {
    }

    @Override // com.ss.android.lark.passportc.task.j
    public final Set<com.ss.android.lark.passportc.task.c> g() {
        return SetBuilder.newSetBuilder(3).add(new eeb.b(Collections.singleton(FeedRepositoryServiceDaggerModule_ProvidesMoltenLifecycleDisposableFactory.providesMoltenLifecycleDisposable(this.p)))).add(new KmpOfflineTask()).add(new jjb.e((com.bytedance.lark.rustclient.internal.m) Preconditions.checkNotNullFromComponent(((o) this.a).I4()), UserRustClientModule_ProvideDispatcherFactory.provideDispatcher((com.bytedance.lark.rustclient.api.l) this.T.get()), (com.bytedance.lark.sdk.refactor.n) Preconditions.checkNotNullFromComponent(((o) this.a).J4()))).build();
    }

    public final Set<ComponentLifecycleAware> getLifecycleAwares() {
        return SetBuilder.newSetBuilder(5).add((ComponentLifecycleAware) this.c4.get()).add((ComponentLifecycleAware) this.d4.get()).add((ComponentLifecycleAware) this.v.get()).add((ComponentLifecycleAware) this.f4.get()).add((ComponentLifecycleAware) this.g4.get()).build();
    }

    public final void h0() {
    }

    public final void h1() {
    }

    public final void i() {
    }

    public final void i0() {
    }

    public final void j1() {
    }

    public final void k() {
    }

    public final void l() {
    }

    public final void l0() {
    }

    public final void m() {
    }

    public final void m1() {
    }

    public final void n1() {
    }

    public final void o0() {
    }

    public final void p0() {
    }

    public final void q() {
    }

    public final void r() {
    }

    public final void r0() {
    }

    public final void r1() {
    }

    public final void s() {
    }

    public final void s0() {
    }

    public final void t() {
    }

    public final void t0() {
    }

    public final void v() {
    }

    public final void w() {
    }

    public final void w0() {
    }

    public final void x() {
    }

    public final void y() {
    }

    public final void z0() {
    }

    public final Map<String, javax.inject.Provider<ViewModel>> z1() {
        return MapBuilder.newMapBuilder(5).put("com.ss.android.lark.conditional.access.web.viewmodel.BindDeviceWebViewModel", this.h4).put("com.ss.android.lark.conditional.access.device.viewmodel.DeviceDeclareViewModel", this.i4).put("com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenViewModel", this.j4).put("com.ss.android.lark.conditional.access.nopermission.viewmodel.NoPermissionViewModel", this.k4).put("com.bytedance.ee.bear.document.synced.block.references.doc.SyncedSourceReferencesViewModel", this.l4).build();
    }

    public final void A1() {
        y r1 = this.r;
        this.h4 = new a(r1, 249);
        this.i4 = new a(r1, 250);
        this.j4 = new a(r1, 251);
        this.k4 = new a(r1, 252);
        this.l4 = new a(r1, 253);
        this.m4 = new a(r1, 254);
        this.n4 = DoubleCheck.provider(new a(r1, 255));
        this.o4 = DoubleCheck.provider(new a(this.r, 256));
        this.p4 = DoubleCheck.provider(new a(this.r, 257));
    }

    public final zmb.b B1() {
        return new zmb.b(MapBuilder.newMapBuilder(4).put(PluginType.FLOW_CHAT_PLUGIN_FACTORY, this.r1).put(PluginType.FLOW_THREAD_WINDOW_PLUGIN_FACTORY, this.s1).put(PluginType.MERGE_FORWARD_PLUGIN_FACTORY, this.t1).put(PluginType.REPLY_IN_THREAD_PLUGIN_FACTORY, this.u1).build());
    }

    public final DwarfSPI dwarfSPI() {
        return (d1) this.Z3.get();
    }

    public final DwarfViewModelFactory.DwarfViewModelCollector dwarfViewModelCollector() {
        return new e0c.n(z1(), Collections.emptyMap());
    }

    public final DwarfViewModelFactories.FactoryFactoryCollector factoryFactoryCollector() {
        return new e0c.o(this.m4);
    }

    @Override // com.ss.android.lark.officesdk.container.U2OUEntryPoint, com.ss.android.lark.officesdk.container.UserComponentEntryPoint
    public final OfficeSDKUserComponentManager getOfficeSDKUserComponentManager() {
        return (OfficeSDKUserComponentManager) this.a4.get();
    }

    @Override // com.ss.android.lark.officesdk.container.U2OUEntryPoint
    public final com.bytedance.lark.sdk.refactor.n getRustSDK() {
        return (com.bytedance.lark.sdk.refactor.n) Preconditions.checkNotNullFromComponent(((o) this.a).J4());
    }

    public final com.ss.android.lark.active.user.bridge.f u() {
        return (com.ss.android.lark.active.user.bridge.f) this.W.get();
    }

    public final zmb.a y1() {
        return new zmb.a(MapBuilder.newMapBuilder(2).put(ConfiguratorType.MESSAGE_LIST, this.v1).put(ConfiguratorType.KEYBOARD_WRAPPER, this.w1).build());
    }

    @Override // com.ss.android.lark.officesdk.container.U2OUEntryPoint
    public final String getUserId() {
        return this.b;
    }

    public static Map u1(y r3) {
        r3.getClass();
        return MapBuilder.newMapBuilder(2).put(DataPreLoaderType.CHAT_DATA, r3.c1).put(DataPreLoaderType.CHAT_WINDOW, r3.d1).build();
    }

    public static Map v1(y r3) {
        r3.getClass();
        return MapBuilder.newMapBuilder(4).put(ILaunchDataInput.LaunchDataType.CHAT, r3.y2).put(ILaunchDataInput.LaunchDataType.CHAT_EQUAL_DATA, r3.z2).put(ILaunchDataInput.LaunchDataType.CHAT_ID, r3.A2).put(ILaunchDataInput.LaunchDataType.CHATTER_ID, r3.B2).build();
    }

    public static Map w1(y r3) {
        r3.getClass();
        return MapBuilder.newMapBuilder(5).put(RealLaunchData.ChatDirection.MY_AI, r3.C2).put(RealLaunchData.ChatDirection.GROUP_PROFILE, r3.D2).put(RealLaunchData.ChatDirection.UNKNOWN, r3.E2).put(RealLaunchData.ChatDirection.THREAD, r3.F2).put(RealLaunchData.ChatDirection.FLOW_CHAT, r3.G2).build();
    }

    public static Map x1(y r3) {
        r3.getClass();
        return MapBuilder.newMapBuilder(7).put(InterceptorType.STRANGER, r3.P2).put(InterceptorType.HIT_POINT, r3.Q2).put(InterceptorType.GROUP_MEMBER_LIMIT, r3.R2).put(InterceptorType.EXCEED_GROUP_LIMIT, r3.S2).put(InterceptorType.EXCEED_GROUP_LIMIT_NEED_APPLY, r3.T2).put(InterceptorType.DEFAULT, r3.U2).put(InterceptorType.DLP, r3.V2).build();
    }

    public final void C(FlowChatFragment r2) {
        ((BasePageFragment) r2).f = B1();
        ((BasePageFragment) r2).g = y1();
        r2.k = (com.ss.android.lark.chat.chatwindow.chat.v2.push.v) this.n1.get();
    }

    public final void E0(VersionOperationRecordV2Activity r2) {
        r2.p = (NetService) this.z.get();
    }

    public final void H(FlowHumanFeedItemsFragment r2) {
        ((FeedItemsFragment) r2).j = (com.bytedance.lark.rustclient.api.l) this.T.get();
        ((FeedItemsFragment) r2).k = (oeb.d) this.p1.get();
        ((FeedItemsFragment) r2).q = (com.ss.android.lark.feed.shared.page.t) this.q1.get();
    }

    public final void J0(ReplyInThreadFrameFragment r3) {
        FlowReplyInThreadFragment r0 = FlowReplyInThreadFragment_Factory.newInstance();
        r0.f = (com.ss.android.lark.chat.chatwindow.chat.v2.push.v) this.n1.get();
        r0.g = B1();
        r0.h = y1();
        r3.l = r0;
    }

    public final void K(FlowGroupCreateFragmentV2 r2) {
        r2.f = (com.ss.android.lark.chat.chatwindow.chat.v2.push.v) this.n1.get();
    }

    public final void M0(BitableHomePageFragment r2) {
        r2.o = (com.bytedance.ee.bear.bitable.homepage.chart.datasource.e) this.s.get();
        r2.r = (ks4.k) this.t.get();
    }

    public final void N(HomeSharedFragment r2) {
        r2.A = (jdb.g) this.u.get();
    }

    public final void O0(BitableDiscoveryFragment r2) {
        r2.O = (jdb.g) this.u.get();
    }

    public final void P(FlowMergeForwardContainerFragment r3) {
        FlowMergeForwardFragment r0 = FlowMergeForwardFragment_Factory.newInstance();
        ((BasePageFragment) r0).f = B1();
        ((BasePageFragment) r0).g = y1();
        r0.m = (com.ss.android.lark.chat.chatwindow.chat.v2.push.v) this.n1.get();
        r3.f = r0;
    }

    public final void P0(SyncedSourceDocReferencesFragment r2) {
        r2.f = (com.bytedance.ee.bear.route.h) this.Q.get();
        r2.g = (t45.c) this.F.get();
    }

    public final void S(ChatFragment r2) {
        r2.g = (oya.a) this.x1.get();
        r2.h = (jdb.g) this.u.get();
        r2.i = (com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d) this.h1.get();
    }

    public final void T0(ChameleonFragmentV2 r2) {
        r2.l = (v1b.a) this.X.get();
    }

    public final void U0(WikiHomeFragment2 r2) {
        r2.q = (BenefitManagerAPI) this.S.get();
    }

    public final void V(ChatWindowBottomFrameFragment r3) {
        FlowChatFragment r0 = FlowChatFragment_Factory.newInstance();
        ((BasePageFragment) r0).f = B1();
        ((BasePageFragment) r0).g = y1();
        r0.k = (com.ss.android.lark.chat.chatwindow.chat.v2.push.v) this.n1.get();
        r3.n = r0;
        r3.o = (com.ss.android.lark.passportc.api.m) this.v.get();
    }

    public final void W(WikiCreateToFragment r2) {
        r2.m = (NetService) this.z.get();
    }

    public final void X(WikiTreePanelDialog r2) {
        r2.t = (NetService) this.z.get();
    }

    public final void X0(BasePageFragment r2) {
        r2.f = B1();
        r2.g = y1();
    }

    public final void Y0(SidebarDocTabFragment r2) {
        r2.N = (com.bytedance.ee.bear.route.h) this.Q.get();
        r2.O = (by4.d) this.B.get();
        r2.P = (mc5.j) this.R.get();
    }

    public final void Z(OfficeCCMDemoContainerActivity r2) {
        r2.d = (ik5.a) this.L.get();
    }

    public final void a1(PrivacyFragment r2) {
        r2.z = (NetService) this.z.get();
        r2.A = (com.bytedance.ee.bear.route.h) this.Q.get();
    }

    public final void b0(FeedItemsFragment r2) {
        r2.j = (com.bytedance.lark.rustclient.api.l) this.T.get();
        r2.k = (oeb.d) this.p1.get();
        r2.q = (com.ss.android.lark.feed.shared.page.t) this.q1.get();
    }

    public final void e0(FlowReplyInThreadFragment r2) {
        r2.f = (com.ss.android.lark.chat.chatwindow.chat.v2.push.v) this.n1.get();
        r2.g = B1();
        r2.h = y1();
    }

    public final void e1(FlowChatThreadContainerFragment r3) {
        FlowChatThreadFragment r0 = FlowChatThreadFragment_Factory.newInstance();
        ((BasePageFragment) r0).f = B1();
        ((BasePageFragment) r0).g = y1();
        r0.k = (com.ss.android.lark.chat.chatwindow.chat.v2.push.v) this.n1.get();
        r3.f = r0;
    }

    public final void f1(FlowReplyInThreadActivity r2) {
        r2.b = DoubleCheck.lazy(this.z1);
    }

    public final void g0(OfficeCCMDemoActivity r2) {
        r2.d = (ik5.a) this.L.get();
    }

    public final void g1(BitableTabFragmentV4 r2) {
        r2.Y = (jdb.g) this.u.get();
    }

    public final void h(WikiSpaceDetailActivity r2) {
        r2.o = (NetService) this.z.get();
    }

    public final void i1(BitableChartFullscreenActivity r2) {
        r2.i = (com.bytedance.ee.bear.bitable.homepage.chart.datasource.e) this.s.get();
    }

    public final void j(UserContainerDriveMainFragment r2) {
        r2.o = new x45.a();
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.base.e
    public final void j0(MmRecordingFragment r2) {
        r2.n = (com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a) this.b4.get();
    }

    public final void k0(WikiTreeFragment r2) {
        r2.s = (NetService) this.z.get();
    }

    public final void k1(FlowMergeForwardActivity r2) {
        r2.b = DoubleCheck.lazy(this.y1);
    }

    public final void l1(OfficeSpaceDemoActivity r2) {
        r2.d = (com.bytedance.ee.bear.office.export.space.a) this.M.get();
    }

    public final void m0(FlowChatThreadFragment r2) {
        ((BasePageFragment) r2).f = B1();
        ((BasePageFragment) r2).g = y1();
        r2.k = (com.ss.android.lark.chat.chatwindow.chat.v2.push.v) this.n1.get();
    }

    public final void n(OfficeFolderDetailDemoActivity r2) {
        r2.d = (com.bytedance.ee.bear.office.export.space.a) this.M.get();
    }

    public final void n0(FlowMergeForwardFragment r2) {
        ((BasePageFragment) r2).f = B1();
        ((BasePageFragment) r2).g = y1();
        r2.m = (com.ss.android.lark.chat.chatwindow.chat.v2.push.v) this.n1.get();
    }

    public final void o(CCMFolderDemoActivity r2) {
        r2.d = (ik5.a) this.L.get();
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.endwindow.b
    public final void o1(MmEndWindowFragment r2) {
        r2.n = (com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a) this.b4.get();
    }

    public final void p(FlowThreadWindowFragment r2) {
        ((BasePageFragment) r2).f = B1();
        ((BasePageFragment) r2).g = y1();
        r2.k = (com.ss.android.lark.chat.chatwindow.chat.v2.push.v) this.n1.get();
    }

    public final void p1(HomeLibraryFragment r2) {
        r2.n = (NetService) this.z.get();
    }

    public final void q0(NewDocMainTabFragment r2) {
        r2.j = (jdb.g) this.u.get();
    }

    public final void q1(ChartItemView r2) {
        r2.p = (ks4.k) this.t.get();
    }

    public final void s1(SyncBlockFragment r2) {
        r2.l = (t45.c) this.F.get();
        r2.m = (com.bytedance.ee.bear.contract.h0) this.O.get();
        r2.n = (NetService) this.z.get();
        r2.o = (com.bytedance.ee.bear.route.h) this.Q.get();
    }

    public final void t1(NoPermissionActivity r2) {
        r2.b = (k8b.c) Preconditions.checkNotNullFromComponent((k8b.c) ((o) this.a).K0.get());
        r2.c = (NoPermissionModuleManager) Preconditions.checkNotNullFromComponent((NoPermissionModuleManager) ((o) this.a).L0.get());
    }

    public final void u0(UserScopeDeviceDeclareFragment r2) {
        r2.i = (com.ss.android.lark.storage.kv.storage.a) this.A.get();
    }

    public final void v0(DeviceOwnerNoPermissionFragment r2) {
        r2.j = (com.ss.android.lark.passportc.api.m) this.v.get();
    }

    public final void x0(MessageFullScreenFragment r2) {
        r2.f = (com.ss.android.lark.chat.chatwindow.chat.v2.push.v) this.n1.get();
        r2.g = (com.ss.android.lark.chat.export.offlineCacheClean.a) this.o1.get();
    }

    public final void y0(RootSelectFragment r2) {
        r2.l = (NetService) this.z.get();
    }

    public final void z(FlowReplyInThreadContainerFragment r3) {
        FlowReplyInThreadFragment r0 = FlowReplyInThreadFragment_Factory.newInstance();
        r0.f = (com.ss.android.lark.chat.chatwindow.chat.v2.push.v) this.n1.get();
        r0.g = B1();
        r0.h = y1();
        r3.g = r0;
    }

    public y(com.bytedance.ee.bear.integrator.di.d r5, com.bytedance.ee.bear.middleground.unbundle.a r6, com.ss.android.lark.chat.chatwindow.chat.v2.push.b r7, tz4.b r8, com.bytedance.ee.bear.basesdk.services.container.b r9, com.bytedance.ee.bear.drive.cache.u r10, eeb.a r11, com.bytedance.lark.lark_biz_feed_android_wrapper.a r12, gkb.a r13, nb5.b r14, r5 r15, t5 r16, jg5.r r17, w0 r18, com.ss.android.lark.passportc.internal.f0 r19, String r20, UserSession r21) {
        this.r = this;
        this.a = r18;
        this.b = r20;
        this.c = r19;
        this.d = r14;
        this.e = r9;
        this.f = r16;
        this.g = r8;
        this.h = r6;
        this.i = r7;
        this.j = r13;
        this.k = r21;
        this.l = r15;
        this.m = r10;
        this.n = r5;
        this.o = r17;
        this.p = r12;
        this.q = r11;
        this.s = DoubleCheck.provider(new a(this, 0));
        this.t = DoubleCheck.provider(new a(this, 1));
        this.u = DoubleCheck.provider(new a(this, 2));
        this.v = DoubleCheck.provider(new a(this, 4));
        this.w = DoubleCheck.provider(new a(this, 8));
        this.x = DoubleCheck.provider(new a(this, 7));
        this.y = DoubleCheck.provider(new a(this, 9));
        this.z = DoubleCheck.provider(new a(this, 6));
        this.A = DoubleCheck.provider(new a(this, 12));
        this.B = DoubleCheck.provider(new a(this, 11));
        this.C = DoubleCheck.provider(new a(this, 10));
        this.D = DoubleCheck.provider(new a(this, 15));
        this.E = DoubleCheck.provider(new a(this, 16));
        this.F = new DelegateFactory();
        this.G = DoubleCheck.provider(new a(this, 17));
        DelegateFactory.setDelegate(this.F, DoubleCheck.provider(new a(this, 14)));
        this.H = DoubleCheck.provider(new a(this, 13));
        this.I = DoubleCheck.provider(new a(this, 18));
        this.J = DoubleCheck.provider(new a(this, 5));
        this.K = DoubleCheck.provider(new a(this, 19));
        this.L = DoubleCheck.provider(new a(this, 3));
        this.M = DoubleCheck.provider(new a(this, 20));
        this.N = DoubleCheck.provider(new a(this, 22));
        this.O = DoubleCheck.provider(new a(this, 21));
        this.P = DoubleCheck.provider(new a(this, 24));
        this.Q = DoubleCheck.provider(new a(this, 23));
        this.R = DoubleCheck.provider(new a(this, 25));
        this.S = DoubleCheck.provider(new a(this, 26));
        this.T = DoubleCheck.provider(new a(this, 28));
        this.U = DoubleCheck.provider(new a(this, 27));
        this.V = DoubleCheck.provider(new a(this, 29));
        this.W = DoubleCheck.provider(new a(this, 30));
        this.X = DoubleCheck.provider(new a(this, 31));
        this.Y = DoubleCheck.provider(new a(this, 34));
        this.Z = DoubleCheck.provider(new a(this, 35));
        this.a0 = DoubleCheck.provider(new a(this, 36));
        this.b0 = DoubleCheck.provider(new a(this, 38));
        this.c0 = DoubleCheck.provider(new a(this, 37));
        this.d0 = DoubleCheck.provider(new a(this, 40));
        this.e0 = DoubleCheck.provider(new a(this, 39));
        this.f0 = DoubleCheck.provider(new a(this, 42));
        this.g0 = DoubleCheck.provider(new a(this, 41));
        this.h0 = DoubleCheck.provider(new a(this, 44));
        this.i0 = DoubleCheck.provider(new a(this, 43));
        this.j0 = DoubleCheck.provider(new a(this, 46));
        this.k0 = DoubleCheck.provider(new a(this, 45));
        this.l0 = DoubleCheck.provider(new a(this, 47));
        this.m0 = DoubleCheck.provider(new a(this, 49));
        this.n0 = DoubleCheck.provider(new a(this, 48));
        this.o0 = DoubleCheck.provider(new a(this, 51));
        this.p0 = DoubleCheck.provider(new a(this, 50));
        this.q0 = DoubleCheck.provider(new a(this, 53));
        this.r0 = DoubleCheck.provider(new a(this, 52));
        this.s0 = DoubleCheck.provider(new a(this, 55));
        this.t0 = DoubleCheck.provider(new a(this, 54));
        this.u0 = DoubleCheck.provider(new a(this, 56));
        this.v0 = DoubleCheck.provider(new a(this, 57));
        this.w0 = DoubleCheck.provider(new a(this, 58));
        this.x0 = DoubleCheck.provider(new a(this, 59));
        this.y0 = DoubleCheck.provider(new a(this, 60));
        this.z0 = DoubleCheck.provider(new a(this, 62));
        this.A0 = DoubleCheck.provider(new a(this, 61));
        this.B0 = DoubleCheck.provider(new a(this, 64));
        this.C0 = DoubleCheck.provider(new a(this, 63));
        this.D0 = DoubleCheck.provider(new a(this, 65));
        this.E0 = DoubleCheck.provider(new a(this, 66));
        this.F0 = DoubleCheck.provider(new a(this, 67));
        this.G0 = DoubleCheck.provider(new a(this, 69));
        this.H0 = DoubleCheck.provider(new a(this, 68));
        this.I0 = DoubleCheck.provider(new a(this, 71));
        this.J0 = DoubleCheck.provider(new a(this, 70));
        this.K0 = DoubleCheck.provider(new a(this, 73));
        this.L0 = DoubleCheck.provider(new a(this, 72));
        this.M0 = DoubleCheck.provider(new a(this, 75));
        this.N0 = DoubleCheck.provider(new a(this, 74));
        this.O0 = DoubleCheck.provider(new a(this, 77));
        this.P0 = DoubleCheck.provider(new a(this, 76));
        this.Q0 = DoubleCheck.provider(new a(this, 79));
        this.R0 = DoubleCheck.provider(new a(this, 78));
        this.S0 = DoubleCheck.provider(new a(this, 81));
        this.T0 = DoubleCheck.provider(new a(this, 80));
        this.U0 = DoubleCheck.provider(new a(this, 83));
        this.V0 = DoubleCheck.provider(new a(this, 82));
        this.W0 = DoubleCheck.provider(new a(this, 85));
        this.X0 = DoubleCheck.provider(new a(this, 84));
        this.Y0 = DoubleCheck.provider(new a(this, 89));
        this.Z0 = DoubleCheck.provider(new a(this, 91));
        this.a1 = DoubleCheck.provider(new a(this, 92));
        this.b1 = DoubleCheck.provider(new a(this, 90));
        this.c1 = new a(this, 88);
        this.d1 = new a(this, 93);
        this.e1 = DoubleCheck.provider(new a(this, 87));
        this.f1 = new a(this, 94);
        this.g1 = new a(this, 95);
        this.h1 = DoubleCheck.provider(new a(this, 86));
        this.i1 = DoubleCheck.provider(new a(this, 96));
        this.j1 = DoubleCheck.provider(new a(this, 97));
        this.k1 = DoubleCheck.provider(new a(this, 98));
        this.l1 = DoubleCheck.provider(new a(this, 99));
        this.m1 = DoubleCheck.provider(new a(this, 33));
        this.n1 = DoubleCheck.provider(new a(this, 32));
        this.o1 = DoubleCheck.provider(new a(this, 100));
        this.p1 = DoubleCheck.provider(new a(this, BaseField.FIELD_TYPE_S_PHONE_NUMBER));
        this.q1 = DoubleCheck.provider(new a(this, BaseField.FIELD_TYPE_S_FRIEND_LINK));
        this.r1 = new a(this, 103);
        this.s1 = new a(this, BaseField.FIELD_TYPE_ALIAS_AND_MEMO);
        this.t1 = new a(this, BaseField.FIELD_TYPE_MEMO_DESCRIPTION);
        this.u1 = new a(this, 106);
        this.v1 = new a(this, 107);
        this.w1 = new a(this, 108);
        this.x1 = DoubleCheck.provider(new a(this, 109));
        this.y1 = new a(this, 110);
        this.z1 = new a(this, 111);
        this.A1 = DoubleCheck.provider(new a(this, 114));
        this.B1 = DoubleCheck.provider(new a(this, 115));
        this.C1 = DoubleCheck.provider(new a(this, 116));
        this.D1 = DoubleCheck.provider(new a(this, 117));
        this.E1 = DoubleCheck.provider(new a(this, 118));
        this.F1 = DoubleCheck.provider(new a(this, 119));
        this.G1 = DoubleCheck.provider(new a(this, 120));
        this.H1 = DoubleCheck.provider(new a(this, 121));
        this.I1 = DoubleCheck.provider(new a(this, 122));
        this.J1 = DoubleCheck.provider(new a(this, 123));
        this.K1 = DoubleCheck.provider(new a(this, 124));
        this.L1 = DoubleCheck.provider(new a(this, 125));
        this.M1 = DoubleCheck.provider(new a(this, 126));
        this.N1 = DoubleCheck.provider(new a(this, 127));
        this.O1 = DoubleCheck.provider(new a(this, 128));
        this.P1 = new a(this, 129);
        this.Q1 = new a(this, 130);
        this.R1 = DoubleCheck.provider(new a(this, 131));
        this.S1 = DoubleCheck.provider(new a(this, 132));
        this.T1 = new a(this, 133);
        this.U1 = DoubleCheck.provider(new a(this, 134));
        this.V1 = DoubleCheck.provider(new a(this, 135));
        this.W1 = DoubleCheck.provider(new a(this, 136));
        this.X1 = DoubleCheck.provider(new a(this, 137));
        this.Y1 = DoubleCheck.provider(new a(this, 138));
        this.Z1 = DoubleCheck.provider(new a(this, 139));
        this.a2 = DoubleCheck.provider(new a(this, 140));
        this.b2 = DoubleCheck.provider(new a(this, 141));
        this.c2 = DoubleCheck.provider(new a(this, 142));
        this.d2 = DoubleCheck.provider(new a(this, 143));
        this.e2 = DoubleCheck.provider(new a(this, 144));
        this.f2 = DoubleCheck.provider(new a(this, 145));
        this.g2 = DoubleCheck.provider(new a(this, 146));
        this.h2 = DoubleCheck.provider(new a(this, 147));
        this.i2 = DoubleCheck.provider(new a(this, 148));
        this.j2 = DoubleCheck.provider(new a(this, 149));
        this.k2 = DoubleCheck.provider(new a(this, 150));
        this.l2 = DoubleCheck.provider(new a(this, 152));
        this.m2 = DoubleCheck.provider(new a(this, 154));
        this.n2 = DoubleCheck.provider(new a(this, 153));
        this.o2 = DoubleCheck.provider(new a(this, 151));
        this.p2 = DoubleCheck.provider(new a(this, 155));
        this.q2 = DoubleCheck.provider(new a(this, 156));
        this.r2 = DoubleCheck.provider(new a(this, 157));
        this.s2 = DoubleCheck.provider(new a(this, 158));
        this.t2 = DoubleCheck.provider(new a(this, 159));
        this.u2 = DoubleCheck.provider(new a(this, 160));
        this.v2 = DoubleCheck.provider(new a(this, 161));
        this.w2 = DoubleCheck.provider(new a(this, 162));
        this.x2 = DoubleCheck.provider(new a(this, 165));
        this.y2 = new a(this, 164);
        this.z2 = new a(this, 166);
        this.A2 = new a(this, 167);
        this.B2 = new a(this, 168);
        this.C2 = DoubleCheck.provider(new a(this, 169));
        this.D2 = DoubleCheck.provider(new a(this, 170));
        this.E2 = DoubleCheck.provider(new a(this, 171));
        this.F2 = new a(this, 172);
        this.G2 = new a(this, 173);
        this.H2 = DoubleCheck.provider(new a(this, 163));
        this.I2 = new a(this, 174);
        this.J2 = DoubleCheck.provider(new a(this, 176));
        this.K2 = DoubleCheck.provider(new a(this, 177));
        this.L2 = DoubleCheck.provider(new a(this, 175));
        this.M2 = DoubleCheck.provider(new a(this, 179));
        this.N2 = DoubleCheck.provider(new a(this, 178));
        this.O2 = DoubleCheck.provider(new a(this, 180));
        this.P2 = new a(this, 183);
        this.Q2 = new a(this, 184);
        this.R2 = new a(this, 185);
        this.S2 = new a(this, 186);
        this.T2 = new a(this, 187);
        this.U2 = new a(this, 188);
        this.V2 = new a(this, 189);
        this.W2 = DoubleCheck.provider(new a(this, 182));
        this.X2 = DoubleCheck.provider(new a(this, 181));
        this.Y2 = DoubleCheck.provider(new a(this, 190));
        this.Z2 = DoubleCheck.provider(new a(this, 191));
        this.a3 = DoubleCheck.provider(new a(this, 192));
        this.b3 = DoubleCheck.provider(new a(this, 193));
        this.c3 = DoubleCheck.provider(new a(this, 194));
        this.d3 = DoubleCheck.provider(new a(this, 195));
        this.e3 = DoubleCheck.provider(new a(this, 196));
        this.f3 = new a(this, 197);
        this.g3 = DoubleCheck.provider(new a(this, 198));
        this.h3 = DoubleCheck.provider(new a(this, 199));
        this.i3 = DoubleCheck.provider(new a(this, 200));
        this.j3 = DoubleCheck.provider(new a(this, 201));
        this.k3 = DoubleCheck.provider(new a(this, 202));
        this.l3 = DoubleCheck.provider(new a(this, 203));
        this.m3 = DoubleCheck.provider(new a(this, 204));
        this.n3 = DoubleCheck.provider(new a(this, 205));
        this.o3 = DoubleCheck.provider(new a(this, 206));
        this.p3 = DoubleCheck.provider(new a(this, 207));
        this.q3 = DoubleCheck.provider(new a(this, 209));
        this.r3 = DoubleCheck.provider(new a(this, 208));
        this.s3 = DoubleCheck.provider(new a(this, 210));
        this.t3 = DoubleCheck.provider(new a(this, 212));
        this.u3 = DoubleCheck.provider(new a(this, 211));
        this.v3 = DoubleCheck.provider(new a(this, 213));
        this.w3 = new a(this, 214);
        this.x3 = DoubleCheck.provider(new a(this, 215));
        this.y3 = DoubleCheck.provider(new a(this, 216));
        this.z3 = DoubleCheck.provider(new a(this, 217));
        this.A3 = DoubleCheck.provider(new a(this, 218));
        this.B3 = DoubleCheck.provider(new a(this, 219));
        this.C3 = DoubleCheck.provider(new a(this, 220));
        this.D3 = DoubleCheck.provider(new a(this, 221));
        this.E3 = DoubleCheck.provider(new a(this, 222));
        this.F3 = DoubleCheck.provider(new a(this, 228));
        this.G3 = DoubleCheck.provider(new a(this, 229));
        this.H3 = DoubleCheck.provider(new a(this, 227));
        this.I3 = DoubleCheck.provider(new a(this, 230));
        this.J3 = DoubleCheck.provider(new a(this, 226));
        this.K3 = DoubleCheck.provider(new a(this, 225));
        this.L3 = DoubleCheck.provider(new a(this, 231));
        this.M3 = DoubleCheck.provider(new a(this, 224));
        this.N3 = DoubleCheck.provider(new a(this, 223));
        this.O3 = DoubleCheck.provider(new a(this, 232));
        this.P3 = DoubleCheck.provider(new a(this, 233));
        this.Q3 = DoubleCheck.provider(new a(this, 235));
        this.R3 = DoubleCheck.provider(new a(this, 234));
        this.S3 = DoubleCheck.provider(new a(this, 238));
        this.T3 = DoubleCheck.provider(new a(this, 237));
        this.U3 = DoubleCheck.provider(new a(this, 236));
        this.V3 = DoubleCheck.provider(new a(this, 240));
        this.W3 = new a(this, 239);
        this.X3 = DoubleCheck.provider(new a(this, 241));
        this.Y3 = new a(this, 113);
        this.Z3 = DoubleCheck.provider(new a(this, 112));
        this.a4 = DoubleCheck.provider(new a(this, 242));
        this.b4 = DoubleCheck.provider(new a(this, 243));
        this.c4 = DoubleCheck.provider(new a(this, 244));
        this.d4 = DoubleCheck.provider(new a(this, 245));
        this.e4 = new a(this, 247);
        this.f4 = DoubleCheck.provider(new a(this, 246));
        this.g4 = DoubleCheck.provider(new a(this, 248));
        A1();
    }
}
