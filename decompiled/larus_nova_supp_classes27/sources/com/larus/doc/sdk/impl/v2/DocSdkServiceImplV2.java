package com.larus.doc.sdk.impl.v2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.DocPluginLevel;
import com.bytedance.ee.bear.browser.plugin.lazy.PluginMountStrategy;
import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarV2;
import com.bytedance.ee.bear.list.delete.f;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import com.larus.doc.sdk.api.IDocPermissionService;
import com.larus.doc.sdk.api.IDocSdkServiceV2;
import com.larus.doc.sdk.impl.statistics.DocSdkEventHelper;
import com.larus.doc.sdk.impl.v2.plugins.aiedit.AIEditStatePluginV2;
import com.larus.doc.sdk.impl.v2.plugins.common.DocInfoGetPluginV2;
import com.larus.doc.sdk.impl.v2.plugins.common.MinutesInfoPluginV2;
import com.larus.doc.sdk.impl.v2.plugins.editpanel.DocEditPanelDelegate;
import com.larus.doc.sdk.impl.v2.plugins.event.DocLoadEventPluginV2;
import com.larus.doc.sdk.impl.v2.plugins.extend.ContainerExtendPlugin;
import com.larus.doc.sdk.impl.v2.plugins.input.ChatInputContainerPlugin;
import com.larus.doc.sdk.impl.v2.plugins.notify.DocStateNotifyPluginV2;
import com.larus.doc.sdk.impl.v2.plugins.notify.OfflineDocCreateRequestNotifyPluginV2;
import com.larus.doc.sdk.impl.v2.plugins.notify.OfflineDocSyncNotifyPluginV2;
import com.larus.doc.sdk.impl.v2.plugins.rewrite.PartialRewritePluginV2;
import com.larus.doc.sdk.impl.v2.plugins.selection.FlowDocSelectionPluginV2;
import com.larus.doc.sdk.impl.v2.plugins.snapshot.DocSnapshotManager;
import com.larus.doc.sdk.impl.v2.plugins.snapshot.SnapshotPluginV2;
import com.larus.doc.sdk.impl.v2.plugins.state.DocStatePluginV2;
import com.larus.doc.sdk.impl.v2.plugins.state.FlowDocStatePluginV2;
import com.larus.doc.sdk.impl.v2.plugins.state.media.SelectMediaPluginV2;
import com.larus.doc.sdk.impl.v2.plugins.video.FullVideoPlugin;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.office.IOfficeSdkService;
import com.larus.office.OfficeInputParam;
import com.larus.office.base.plugins.authorization.LarkAuthorizationPluginV2;
import com.larus.office.base.plugins.editpanel.HostEditPanelPlugin;
import com.larus.office.base.plugins.media.SheetSelectMediaPluginV2;
import com.larus.office.base.plugins.permission.PermissionChangeHandlePluginV2;
import com.larus.office.base.plugins.share.OfficeSharePermissionPlugin;
import com.larus.office.base.plugins.statistics.ReportEventPluginV2;
import com.larus.office.base.plugins.titlebar.FlowDocTitleMenuPluginV2;
import com.larus.office.base.plugins.toast.ToastPluginV2;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.chat.ObricChatUIDelegate;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ew4.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n39.h;
import n39.m;
import n39.p;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u0000 h2\u00020\u0001:\u0002hiB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\u0018\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0018H\u0016J\n\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0018\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+H\u0016JY\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00182\b\u00103\u001a\u0004\u0018\u00010\u00182\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016¢\u0006\u0002\u0010>J\u000e\u0010?\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010@JZ\u0010A\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010B\u001a\u00020\u00182\b\u00103\u001a\u0004\u0018\u00010\u00182\b\u0010C\u001a\u0004\u0018\u00010\u00182\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u0001092\b\u0010<\u001a\u0004\u0018\u00010=H\u0096@¢\u0006\u0002\u0010DJ\u001a\u0010E\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\u00182\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u001a\u0010F\u001a\u00020!2\u0006\u00102\u001a\u00020\u00182\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u001a\u0010G\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u00182\b\u00106\u001a\u0004\u0018\u000107H\u0002JF\u0010H\u001a\u00020\u001a2\u0006\u00100\u001a\u0002012\u0006\u0010I\u001a\u00020\u00182\b\u0010J\u001a\u0004\u0018\u00010\u00182\"\u0010'\u001a\u001e\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010L\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u001a0KH\u0016Jt\u0010M\u001a\u00020\u001a2\u0006\u00100\u001a\u0002012\u0006\u0010I\u001a\u00020\u00182\u0006\u0010N\u001a\u00020\u00182\b\u0010O\u001a\u0004\u0018\u00010\u00182\b\u0010J\u001a\u0004\u0018\u00010\u00182\b\u0010P\u001a\u0004\u0018\u00010\u00182\b\u0010Q\u001a\u0004\u0018\u00010\u00182*\u0010'\u001a&\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010L\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u001a0RH\u0016J\b\u0010S\u001a\u00020\u001aH\u0016J\b\u0010T\u001a\u00020\u001aH\u0016J\u0012\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010N\u001a\u00020\u0018H\u0002J\u0010\u0010W\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u0018H\u0016J\b\u0010X\u001a\u00020\u0018H\u0016J1\u0010Y\u001a\u00020\u001a2\b\u0010Z\u001a\u0004\u0018\u00010\u00162\b\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010\"\u001a\u00020\u0018H\u0016¢\u0006\u0002\u0010_J\u0010\u0010`\u001a\u00020!2\u0006\u0010B\u001a\u00020\u0018H\u0016J\u0010\u0010a\u001a\u00020!2\u0006\u0010b\u001a\u00020/H\u0016J\u0012\u0010c\u001a\u00020\u001a2\b\u0010]\u001a\u0004\u0018\u00010\u000bH\u0016J\u0016\u0010d\u001a\u00020!2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00180fH\u0002J\u0010\u0010g\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006j"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/DocSdkServiceImplV2;", "Lcom/larus/doc/sdk/api/IDocSdkServiceV2;", "<init>", "()V", "docSdk", "Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;", "lastToolbar", "Lcom/bytedance/ee/bear/document/model/toolbar/ToolbarV2;", "documentExportExecutor", "Lcom/bytedance/ee/bear/document/export/net/DocumentExportExecutor;", "toolbarTraceListener", "Lcom/larus/doc/sdk/api/IToolbarTraceListener;", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "Lkotlin/Lazy;", "getPhotoPickerService", "Lcom/larus/doc/sdk/api/IPhotoPickerService;", "lifecycleOrder", "", "lifecycleCategory", "", "onToolbarChanged", "", "toolbar", "onToolbarItemClicked", "name", "onContextMenuShow", "notifyChatInputFoldStatusChanged", "isFold", "", "docLogicKey", "getPermissionService", "Lcom/larus/doc/sdk/api/IDocPermissionService;", "deleteDoc", "objToken", "callback", "Lcom/larus/doc/sdk/api/IDeleteDocCallback;", "preInitDocSdk", "officeSDKUserApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "initDocSdk", "postInitDocSdk", "getDocFragment", "Landroidx/fragment/app/Fragment;", "context", "Landroid/content/Context;", "resId", "content", "clickTimestamp", "", "param", "Lcom/larus/office/OfficeInputParam;", "permissionListener", "Lcom/larus/office/permission/IOfficePermissionListener;", "hostAbilityProvider", "Lcom/larus/office/OfficeHostAbilityProvider;", "reloadInterceptor", "Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/office/OfficeInputParam;Lcom/larus/office/permission/IOfficePermissionListener;Lcom/larus/office/OfficeHostAbilityProvider;Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;)Landroidx/fragment/app/Fragment;", "initDocSdkIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openAndGetDocFragment", "url", "messageId", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/office/OfficeInputParam;Lcom/larus/office/permission/IOfficePermissionListener;Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadDocumentData", "tryPrefetchData", "buildDocUrl", "startDownloadAudioFile", "fileName", "token", "Lkotlin/Function3;", "Landroid/net/Uri;", "startDocExport", "fileType", "type", "eventSource", "passback", "Lkotlin/Function4;", "cancelDocExport", "destroyDocSdk", "fileTypeToExportFormat", "Lcom/bytedance/ee/bear/contract/export/ExportFormatEnum;", "getShareLinkUrl", "getChameleonResVersion", "startDocSnapshot", "inputViewHeight", "drawable", "Landroid/graphics/drawable/Drawable;", "listener", "Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;", "(Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;Ljava/lang/String;)V", "isDoubaoDoc", "onBackPressed", "fragment", "setToolbarTraceListener", "pathValid", "path", "", "injectUserHostAbility", "Companion", "DocXOpenStrategy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocSdkServiceImplV2 implements IDocSdkServiceV2 {
    public static final Companion Companion = null;
    private static final String TAG = "DocSdkServiceImplV2";
    private ik5.a docSdk;
    private j15.a documentExportExecutor;
    private final Lazy keva$delegate;
    private ToolbarV2 lastToolbar;
    private p toolbarTraceListener;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/DocSdkServiceImplV2$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/DocSdkServiceImplV2$DocXOpenStrategy;", "Lcom/bytedance/ee/bear/office/export/docs/strategy/DocOpenStrategyExport;", "docSdk", "Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;", "<init>", "(Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;)V", "getBizPluginList", "Lcom/bytedance/ee/bear/browser/plugin/PluginList;", "pluginHost", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DocXOpenStrategy extends kk5.e {
        public static /* synthetic */ DocEditPanelDelegate c() {
            return getBizPluginList$lambda$0();
        }

        private static final DocEditPanelDelegate getBizPluginList$lambda$0() {
            return new DocEditPanelDelegate();
        }

        public DocXOpenStrategy(ik5.a r2) {
            Intrinsics.checkNotNullParameter(r2, "docSdk");
            super(r2);
        }

        public n getBizPluginList(ChameleonPluginHost r10) {
            Intrinsics.checkNotNullParameter(r10, "pluginHost");
            IOfficeSdkService r0 = (IOfficeSdkService) ServiceManager.get().getService(IOfficeSdkService.class);
            if (r0 == null) goto L5;
            n r1 = r0.g("docx");
        L7:
            if (z2.a.f4() == false) goto L13;
            SelectMediaPluginV2 r2 = new SelectMediaPluginV2();
            PluginMountStrategy r3 = PluginMountStrategy.LoadFinish;
            n r4 = new n(new n.a[]{n.i(r2, true, r3), n.i(new SheetSelectMediaPluginV2(new com.larus.office.base.plugins.media.a()), true, r3), n.i(new OfficeSharePermissionPlugin(), true, PluginMountStrategy.Immediate)});
            n r11 = super.getBizPluginList(r10);
            if (r1 != null) goto L12;
            r1 = new n(new n.a[0]);
        L12:
            return n.c(r11, n.c(r1, r4));
        L13:
            n r12 = super.getBizPluginList(r10);
            DocInfoGetPluginV2 r5 = new DocInfoGetPluginV2();
            PluginMountStrategy r7 = PluginMountStrategy.Immediate;
            FlowDocSelectionPluginV2 r6 = new FlowDocSelectionPluginV2();
            PluginMountStrategy r8 = PluginMountStrategy.LoadFinish;
            return n.c(r12, new n(new n.a[]{n.i(r5, true, r7), n.f(new ChatInputContainerPlugin(), DocPluginLevel.DOUBAO_CHAT_INPUT, r7), n.i(new PartialRewritePluginV2(), true, r7), n.i(new FlowDocTitleMenuPluginV2(false, 1, null), true, r7), n.i(r6, true, r8), n.k(new OfflineDocSyncNotifyPluginV2(), r8), n.k(new OfflineDocCreateRequestNotifyPluginV2(), r8), n.i(new SelectMediaPluginV2(), true, r8), n.i(new ReportEventPluginV2(), true, r7), n.i(new HostEditPanelPlugin(new b()), true, r7), n.i(new FullVideoPlugin(), true, r8), n.i(new ToastPluginV2(), true, PluginMountStrategy.FirstJSCall), n.i(new FlowDocStatePluginV2(), true, r8), n.i(new DocLoadEventPluginV2(), true, r7), n.i(new LarkAuthorizationPluginV2(), true, r7), n.i(new MinutesInfoPluginV2(), true, r7), n.i(new PermissionChangeHandlePluginV2(), true, r7), n.i(new DocStateNotifyPluginV2(), true, r8), n.i(new SnapshotPluginV2(), true, r8), n.i(new AIEditStatePluginV2(), true, r8), n.i(new DocStatePluginV2(), true, r8), n.k(new ContainerExtendPlugin(), r8), n.i(new SheetSelectMediaPluginV2(new com.larus.office.base.plugins.media.a()), true, r8)}));
        L5:
            r1 = null;
            goto L7
        }
    }

    /* JADX INFO: renamed from: com.larus.doc.sdk.impl.v2.DocSdkServiceImplV2$initDocSdkIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.doc.sdk.impl.v2.DocSdkServiceImplV2", f = "DocSdkServiceImplV2.kt", i = {}, l = {275}, m = "initDocSdkIfNeeded", n = {}, s = {})
    public static final class C01721 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DocSdkServiceImplV2 this$0;

        public C01721(DocSdkServiceImplV2 r1, Continuation<? super C01721> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.initDocSdkIfNeeded(this);
        }
    }

    /* JADX INFO: renamed from: com.larus.doc.sdk.impl.v2.DocSdkServiceImplV2$injectUserHostAbility$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR1\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R1\u0010\u0014\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00110\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013¨\u0006\u0018"}, d2 = {"com/larus/doc/sdk/impl/v2/DocSdkServiceImplV2$injectUserHostAbility$1", "Lcom/bytedance/ee/bear/api/registry/IToolbarConfig;", "globalDecoration", "Lcom/bytedance/ee/bear/api/registry/ToolbarIconDecoration;", "getGlobalDecoration", "()Lcom/bytedance/ee/bear/api/registry/ToolbarIconDecoration;", "itemFactorySet", "", "Lcom/bytedance/ee/bear/api/registry/ToolbarItemFactory;", "getItemFactorySet", "()Ljava/util/Set;", "onUpdateToolBarCallBack", "Lkotlin/Function1;", "Lcom/bytedance/ee/bear/document/model/toolbar/ToolbarV2;", "Lkotlin/ParameterName;", "name", "toolbar", "", "getOnUpdateToolBarCallBack", "()Lkotlin/jvm/functions/Function1;", "onToolbarItemClickCallBack", "", "id", "getOnToolbarItemClickCallBack", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C01731 implements an4.a {
        final /* synthetic */ DocSdkServiceImplV2 this$0;

        public static /* synthetic */ Unit X0(DocSdkServiceImplV2 r0, String r1) {
            return _get_onToolbarItemClickCallBack_$lambda$1(r0, r1);
        }

        public static /* synthetic */ Unit Z1(DocSdkServiceImplV2 r0, ToolbarV2 r1) {
            return _get_onUpdateToolBarCallBack_$lambda$0(r0, r1);
        }

        public an4.d getGlobalDecoration() {
            return new an4.d(2131103321, 2131240377, 2131240375);
        }

        public Set<an4.e> getItemFactorySet() {
            IDocSdkServiceV2 r0 = (IDocSdkServiceV2) ServiceManager.get().getService(IDocSdkServiceV2.class);
            if (r0 == null) goto L7;
            m r1 = r0.getPhotoPickerService();
            if (r1 == null) goto L7;
            an4.e r2 = r1.selectMediaToolbarFactory();
        L9:
            return SetsKt.a(r2);
        L7:
            r2 = null;
            goto L9
        }

        public Function1<String, Unit> getOnToolbarItemClickCallBack() {
            final DocSdkServiceImplV2 r0 = this.this$0;
            return new d(r0);
        }

        public Function1<ToolbarV2, Unit> getOnUpdateToolBarCallBack() {
            final DocSdkServiceImplV2 r0 = this.this$0;
            return new c(r0);
        }

        public C01731(DocSdkServiceImplV2 r1) {
            this.this$0 = r1;
        }

        private static final Unit _get_onToolbarItemClickCallBack_$lambda$1(DocSdkServiceImplV2 r1, String r2) {
            if (r2 == null) goto L12;
            if (DocSdkServiceImplV2.access$getToolbarTraceListener$p(r1) == null) goto L8;
            p r3 = DocSdkServiceImplV2.access$getToolbarTraceListener$p(r1);
            if (r3 == null) goto L12;
            r3.onToolbarItemClicked(r2);
            goto L12
        L8:
            IDocSdkServiceV2 r4 = (IDocSdkServiceV2) ServiceManager.get().getService(IDocSdkServiceV2.class);
            if (r4 == null) goto L12;
            r4.onToolbarItemClicked(r2);
        L12:
            return Unit.INSTANCE;
        }

        private static final Unit _get_onUpdateToolBarCallBack_$lambda$0(DocSdkServiceImplV2 r1, ToolbarV2 r2) {
            if (DocSdkServiceImplV2.access$getToolbarTraceListener$p(r1) == null) goto L7;
            p r3 = DocSdkServiceImplV2.access$getToolbarTraceListener$p(r1);
            if (r3 == null) goto L11;
            r3.onToolbarChanged(r2);
        L11:
            return Unit.INSTANCE;
        L7:
            IDocSdkServiceV2 r4 = (IDocSdkServiceV2) ServiceManager.get().getService(IDocSdkServiceV2.class);
            if (r4 == null) goto L11;
            r4.onToolbarChanged(r2);
            goto L11
        }
    }

    /* JADX INFO: renamed from: com.larus.doc.sdk.impl.v2.DocSdkServiceImplV2$injectUserHostAbility$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R1\u0010\u0002\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/larus/doc/sdk/impl/v2/DocSdkServiceImplV2$injectUserHostAbility$2", "Lcom/bytedance/ee/bear/selection/ISelectionConfig;", "onSelectionShowCallBack", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "key", "", "getOnSelectionShowCallBack", "()Lkotlin/jvm/functions/Function1;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass2 implements gm5.a {
        final /* synthetic */ DocSdkServiceImplV2 this$0;

        public static /* synthetic */ Unit X0(DocSdkServiceImplV2 r0, String r1) {
            return _get_onSelectionShowCallBack_$lambda$0(r0, r1);
        }

        public Function1<String, Unit> getOnSelectionShowCallBack() {
            final DocSdkServiceImplV2 r0 = this.this$0;
            return new e(r0);
        }

        public AnonymousClass2(DocSdkServiceImplV2 r1) {
            this.this$0 = r1;
        }

        private static final Unit _get_onSelectionShowCallBack_$lambda$0(DocSdkServiceImplV2 r3, String r4) {
            FLogger.a.i(DocSdkServiceImplV2.TAG, "injectUserHostAbility: " + r4);
            if (r4 == null) goto L13;
            if (DocSdkServiceImplV2.access$getToolbarTraceListener$p(r3) == null) goto L9;
            p r5 = DocSdkServiceImplV2.access$getToolbarTraceListener$p(r3);
            if (r5 == null) goto L13;
            r5.onContextMenuShow(r4);
            goto L13
        L9:
            IDocSdkServiceV2 r6 = (IDocSdkServiceV2) ServiceManager.get().getService(IDocSdkServiceV2.class);
            if (r6 == null) goto L13;
            r6.onContextMenuShow(r4);
        L13:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.doc.sdk.impl.v2.DocSdkServiceImplV2$openAndGetDocFragment$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.doc.sdk.impl.v2.DocSdkServiceImplV2", f = "DocSdkServiceImplV2.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {297}, m = "openAndGetDocFragment", n = {"context", "url", "content", "clickTimestamp", "param", "permissionListener", "reloadInterceptor"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
    public static final class C01741 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DocSdkServiceImplV2 this$0;

        public C01741(DocSdkServiceImplV2 r1, Continuation<? super C01741> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r11) {
            this.result = r11;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.openAndGetDocFragment(null, null, null, null, null, null, null, null, this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ Keva V() {
        return keva_delegate$lambda$0();
    }

    public void destroyDocSdk() {
        this.docSdk = null;
    }

    public String getChameleonResVersion() {
        return "";
    }

    public String lifecycleCategory() {
        return "doc";
    }

    public int lifecycleOrder() {
        return 1;
    }

    private final Keva getKeva() {
        return (Keva) this.keva$delegate.getValue();
    }

    private static final Keva keva_delegate$lambda$0() {
        return Keva.getRepo("doc_keva", 0);
    }

    @Override // com.larus.doc.sdk.api.IDocSdkServiceV2
    public void cancelDocExport() {
        FLogger.a.i(TAG, "cancelDocExport");
        j15.a r0 = this.documentExportExecutor;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.documentExportExecutor = null;
    }

    @Override // com.larus.doc.sdk.api.IDocSdkServiceV2
    public IDocPermissionService getPermissionService() {
        return (IDocPermissionService) ServiceManager.get().getService(IDocPermissionService.class);
    }

    @Override // com.larus.doc.sdk.api.IDocSdkServiceV2
    public m getPhotoPickerService() {
        return new C01711();
    }

    public DocSdkServiceImplV2() {
        this.keva$delegate = LazyKt.lazy(new a());
    }

    public static final /* synthetic */ p access$getToolbarTraceListener$p(DocSdkServiceImplV2 r0) {
        return r0.toolbarTraceListener;
    }

    private final rw4.n fileTypeToExportFormat(String r3) {
        int r0 = r3.hashCode();
        if (r0 == 110834) goto L17;
        if (r0 == 115312) goto L13;
        if (r0 == 3088960) goto L10;
    L18:
        return null;
    L10:
        if (r3.equals("docx") == false) goto L18;
        return rw4.n.c;
    L13:
        if (r3.equals("txt") == false) goto L18;
        return rw4.n.i;
    L17:
        if (r3.equals("pdf") == false) goto L18;
        return rw4.n.d;
    }

    private final void injectUserHostAbility(OfficeSDKUserApi r3) {
        r3.setHostService(an4.a.class, new C01731(this));
        r3.setHostService(gm5.a.class, new AnonymousClass2(this));
        r3.setHostService(y.class, new AnonymousClass3());
    }

    private final boolean pathValid(List<String> r4) {
        if (r4.size() == 2) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(ListProtector.get(r4, 0), "docx") == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.doc.sdk.api.IDocSdkServiceV2
    public String getShareLinkUrl(String r3) {
        Intrinsics.checkNotNullParameter(r3, "resId");
        return "https://feishu.doubao.com/docx/" + r3;
    }

    public void initDocSdk(OfficeSDKUserApi r4) {
        Intrinsics.checkNotNullParameter(r4, "officeSDKUserApi");
        IOfficeSdkServiceV2 r5 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        com.bytedance.ee.permission.a r0 = null;
        if (r5 == null) goto L5;
        ik5.a r6 = r5.c0();
    L6:
        this.docSdk = r6;
        FLogger.a.i(TAG, "initDocSdk: docSdk:" + this.docSdk);
        ik5.a r7 = this.docSdk;
        if (r7 == null) goto L9;
        r7.Ka(sbb.e.o, new DocXOpenStrategy(r7));
    L9:
        IDocPermissionService r8 = getPermissionService();
        if (r8 == null) goto L18;
        IOfficeSdkServiceV2 r1 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r1 == null) goto L16;
        gk5.e r2 = r1.q0();
        if (r2 == null) goto L16;
        r0 = r2.i0();
    L16:
        r8.initPermissionSdk(r0);
        return;
    L18:
        return;
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.larus.doc.sdk.api.IDocSdkServiceV2
    public Object initDocSdkIfNeeded(Continuation<? super Unit> r7) {
        if ((r7 instanceof C01721) == false) goto L7;
        C01721 r0 = (C01721) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        DocSdkServiceImplV2 r4 = (DocSdkServiceImplV2) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Exception -> L31
    L27:
        ik5.a r5 = (ik5.a) r8;     // Catch: Exception -> L31
    L29:
        r4.docSdk = r5;     // Catch: Exception -> L31
    L34:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r8);
        FLogger.a.i(TAG, "Init doc sdk if needed, docSdk=" + this.docSdk);
        if (this.docSdk != null) goto L34;
        IOfficeSdkServiceV2 r9 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);     // Catch: Exception -> L31
        r5 = null;
        if (r9 == null) goto L21;
        IOfficeSdkServiceV2.a.b(r9, true, null, 6);     // Catch: Exception -> L31
    L21:
        IOfficeSdkServiceV2 r10 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);     // Catch: Exception -> L31
        if (r10 == null) goto L28;
        r0.L$0 = this;     // Catch: Exception -> L31
        r0.label = 1;     // Catch: Exception -> L31
        r8 = r10.o0(DoraObricDeviceHomeViewModel.SCAN_TIMEOUT_MS, r0);     // Catch: Exception -> L31
        if (r8 != r2) goto L26;
        return r2;
    L26:
        r4 = this;
        goto L27
    L28:
        r4 = this;
    L31:
        e = move-exception;
        FLogger.a.e(TAG, "Load docSdk failed: " + e.getMessage());
    L7:
        r0 = new C01721(this, r7);
        goto L8
    }

    public boolean isDoubaoDoc(String r3) {
        Intrinsics.checkNotNullParameter(r3, "url");
        if (TextUtils.isEmpty(r3) == true) goto L12;
        Uri r4 = UriProtector.parse(r3);
        String r0 = r4.getHost();
        List<String> r5 = r4.getPathSegments();
        if (Intrinsics.areEqual(r0, "feishu.doubao.com") == false) goto L7;
    L8:
        Intrinsics.checkNotNull(r5);
        if (pathValid(r5) == false) goto L15;
        return true;
    L15:
        return false;
    L7:
        if (Intrinsics.areEqual(r0, "www.doubao.com") == true) goto L8;
        return false;
    L12:
        return false;
    }

    @Override // com.larus.doc.sdk.api.IDocSdkServiceV2
    public boolean onBackPressed(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        if ((r2 instanceof sa5.d) == true) goto L5;
        return false;
    L5:
        if (r2.isAdded() == true) goto L7;
        return false;
    L7:
        return ((sa5.d) r2).onBackPressed();
    }

    @Override // com.larus.doc.sdk.api.IDocSdkServiceV2
    public void onContextMenuShow(String r9) {
        Intrinsics.checkNotNullParameter(r9, "name");
        DocSdkEventHelper r1 = DocSdkEventHelper.INSTANCE;
        com.larus.doc.sdk.impl.service.ServiceManager r0 = com.larus.doc.sdk.impl.service.ServiceManager.INSTANCE;
        OfficeInputParam r2 = r0.getInputParam();
        if (r2 == null) goto L5;
        String r3 = r2.getResourceId();
    L6:
        OfficeInputParam r4 = r0.getInputParam();
        if (r4 == null) goto L9;
        String r5 = r4.getArtifactMetaId();
    L10:
        OfficeInputParam r6 = r0.getInputParam();
        if (r6 == null) goto L13;
        Integer r7 = Integer.valueOf(r6.getResourceType());
    L14:
        String r10 = r9.toLowerCase(Locale.ROOT);
        OfficeInputParam r8 = r0.getInputParam();
        if (r8 == null) goto L17;
        String r11 = r8.getConversationId();
    L18:
        OfficeInputParam r12 = r0.getInputParam();
        if (r12 == null) goto L21;
        String r13 = r12.getPreviousPage();
    L22:
        r1.reportContextMenuItemShow(r3, r5, r7, r10, r11, r13);
        return;
    L21:
        r13 = null;
        goto L22
    L17:
        r11 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.doc.sdk.api.IDocSdkServiceV2
    public void onToolbarChanged(ToolbarV2 r8) {
        Integer r0 = null;
        if (r8 == null) goto L5;
        ItemV2[] r1 = r8.getItems();
    L6:
        ToolbarV2 r2 = this.lastToolbar;
        if (r2 == null) goto L9;
        ItemV2[] r3 = r2.getItems();
    L10:
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("Current toolbar: ");
        if (r1 == null) goto L13;
        Integer r6 = Integer.valueOf(r1.length);
    L14:
        r5.append(r6);
        r5.append(", original toolbar: ");
        if (r3 == null) goto L17;
        r0 = Integer.valueOf(r3.length);
    L17:
        r5.append(r0);
        r4.i(TAG, r5.toString());
        int r7 = 0;
        if (r3 != null) goto L20;
    L39:
        boolean r9 = true;
    L40:
        if (r1 != null) goto L42;
    L61:
        this.lastToolbar = r8;
        ObricChatUIDelegate.b.y();
        return;
    L42:
        if (r1.length != 0) goto L44;
        boolean r10 = true;
    L46:
        if ((true ^ r10) == false) goto L61;
        if (r9 == false) goto L61;
        int r11 = r1.length;
    L49:
        if (r7 >= r11) goto L61;
        ItemV2 r12 = r1[r7];
        if (r12 == null) goto L60;
        if (r12.isEnable() == false) goto L60;
        vm9.a r13 = com.larus.office.base.service.m.d;
        if (r13 == null) goto L60;
        String r14 = r12.id().name();
        if (r14 != null) goto L59;
        r14 = "";
    L59:
        r13.reportToolbarItemShow(r14);
    L60:
        r7 = r7 + 1;
        goto L49
    L44:
        r10 = false;
        goto L46
    L20:
        if (r3.length != 0) goto L22;
        boolean r15 = true;
    L23:
        if (r15 == true) goto L39;
        int r16 = r3.length;
        int r17 = 0;
    L25:
        if (r17 >= r16) goto L35;
        ItemV2 r18 = r3[r17];
        if (r18 != null) goto L29;
    L31:
        boolean r20 = false;
    L32:
        if (r20 == false) goto L33;
        r17 = r17 + 1;
        goto L25
    L33:
        boolean r21 = false;
    L36:
        if (r21 == true) goto L39;
        r9 = false;
        goto L40
    L29:
        if (r18.isEnable() == true) goto L31;
        r20 = true;
        goto L32
    L35:
        r21 = true;
        goto L36
    L22:
        r15 = false;
        goto L23
    L13:
        r6 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.doc.sdk.api.IDocSdkServiceV2
    public void onToolbarItemClicked(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Lazy r0 = com.larus.office.base.service.m.a;
        vm9.a r1 = com.larus.office.base.service.m.d;
        if (r1 == null) goto L6;
        r1.a(r2);
        return;
    }

    public void postInitDocSdk(OfficeSDKUserApi r3) {
        Intrinsics.checkNotNullParameter(r3, "officeSDKUserApi");
        FLogger.a.i(TAG, "postInitDocSdk: docSdk:" + this.docSdk);
    }

    public void preInitDocSdk(OfficeSDKUserApi r4) {
        Intrinsics.checkNotNullParameter(r4, "officeSDKUserApi");
        FLogger.a.i(TAG, "preInitDocSdk: docSdk:" + this.docSdk);
        injectUserHostAbility(r4);
    }

    @Override // com.larus.doc.sdk.api.IDocSdkServiceV2
    public void setToolbarTraceListener(p r1) {
        this.toolbarTraceListener = r1;
    }

    private final String buildDocUrl(String r13, OfficeInputParam r14) {
        StringBuilder r0 = new StringBuilder();
        r0.append(getShareLinkUrl(r13));
        r0.append("?from=");
        if (r14 == null) goto L6;
        String r15 = r14.getEnterMethod();
        if (r15 == null) goto L6;
    L7:
        r0.append(r15);
        String r16 = r0.toString();
        ArrayList r1 = new ArrayList();
        if (r14 == null) goto L12;
        String r2 = r14.getApplyPermissionConversationId();
        if (r2 == null) goto L12;
        r1.add("key_apply_permission_conversation_id=".concat(r2));
    L12:
        if (r14 == null) goto L16;
        String r3 = r14.getApplyPermissionMessageId();
        if (r3 == null) goto L16;
        r1.add("key_apply_permission_message_id=".concat(r3));
    L16:
        if (r14 == null) goto L20;
        Integer r4 = r14.getObjType();
        if (r4 == null) goto L20;
        r1.add("obj_type=" + r4.intValue());
    L20:
        String r9 = null;
        if ((!r1.isEmpty()) == false) goto L26;
        com.larus.office.base.preview.c r10 = com.larus.office.base.preview.c.a;
        String r17 = r16 + '&' + CollectionsKt.joinToString$default(r1, "&", null, null, 0, null, null, 62, null);
        if (r14 == null) goto L25;
        r9 = r14.getSourceUrlForParams();
    L25:
        r10.getClass();
        return com.larus.office.base.preview.c.j(r17, r9);
    L26:
        com.larus.office.base.preview.c r5 = com.larus.office.base.preview.c.a;
        if (r14 == null) goto L29;
        r9 = r14.getSourceUrlForParams();
    L29:
        r5.getClass();
        return com.larus.office.base.preview.c.j(r16, r9);
    L6:
        r15 = "unknown";
        goto L7
    }

    @Override // com.larus.doc.sdk.api.IDocSdkServiceV2
    public void deleteDoc(String r3, final n39.e r4) {
        Intrinsics.checkNotNullParameter(r3, "objToken");
        Intrinsics.checkNotNullParameter(r4, "callback");
        ik5.a r0 = this.docSdk;
        if (r0 == null) goto L8;
        f r1 = r0.R();
        if (r1 == null) goto L9;
        r1.e(r3, 22, new AnonymousClass1(r4));
        return;
    L9:
        return;
    }

    @Override // com.larus.doc.sdk.api.IDocSdkServiceV2
    public void notifyChatInputFoldStatusChanged(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "docLogicKey");
        n39.b r4 = com.larus.doc.sdk.impl.service.ServiceManager.INSTANCE.getChatInputFoldStatusListener(r3);
        if (r4 == null) goto L6;
        r4.onFoldStatusChanged(r2);
        return;
    }

    @Override // com.larus.doc.sdk.api.IDocSdkServiceV2
    public void preloadDocumentData(String r6, OfficeInputParam r7) {
        Intrinsics.checkNotNullParameter(r6, "resId");
        ik5.a r0 = this.docSdk;
        if (r0 != null) goto L6;
        FLogger.a.i(TAG, "preloadDocumentData skipped, docSdk not ready, resId=" + r6);
        return;
    L6:
        String r8 = buildDocUrl(r6, r7);
        FLogger.a.i(TAG, "preloadDocumentData, resId=" + r6);
        r0.Qd(r8);
    }

    @Override // com.larus.doc.sdk.api.IDocSdkServiceV2
    public boolean tryPrefetchData(String r6, OfficeInputParam r7) {
        Intrinsics.checkNotNullParameter(r6, "resId");
        ik5.a r0 = this.docSdk;
        if (r0 != null) goto L11;
        IOfficeSdkServiceV2 r1 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r1 == null) goto L9;
        r0 = r1.c0();
        if (r0 == null) goto L9;
        this.docSdk = r0;
    L9:
        r0 = null;
    L11:
        if (r0 != null) goto L14;
        FLogger.a.i(TAG, "tryPrefetchData skipped, docSdk not ready, resId=" + r6);
        return false;
    L14:
        String r8 = buildDocUrl(r6, r7);
        FLogger.a.i(TAG, "tryPrefetchData, resId=" + r6);
        r0.r2(r8, "doubao");
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.doc.sdk.impl.v2.DocSdkServiceImplV2$startDocSnapshot$1] */
    @Override // com.larus.doc.sdk.api.IDocSdkServiceV2
    public void startDocSnapshot(Integer r2, Drawable r3, final h r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        Intrinsics.checkNotNullParameter(r5, "docLogicKey");
        if (z2.a.f4() == false) goto L7;
        IOfficeSdkService r6 = (IOfficeSdkService) ServiceManager.get().getService(IOfficeSdkService.class);
        if (r6 == null) goto L9;
        r6.f(r2, r3, new C01761(r4));
        return;
    L9:
        return;
    L7:
        DocSnapshotManager.INSTANCE.startDocSnapshot(r2, r3, r4, r5);
    }

    @Override // com.larus.doc.sdk.api.IDocSdkServiceV2
    public void startDownloadAudioFile(Context r2, String r3, String r4, final Function3<? super Boolean, ? super Uri, ? super String, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fileName");
        Intrinsics.checkNotNullParameter(r5, "callback");
        ik5.a r0 = this.docSdk;
        if (r0 == null) goto L8;
        j15.b r6 = r0.y4(r2, r3);
        if (r6 == null) goto L9;
        r6.a(DocumentType.DOCX.type, r4, new C01771(r5));
        return;
    L9:
        return;
    }

    @Override // com.larus.doc.sdk.api.IDocSdkServiceV2
    public Fragment getDocFragment(Context r110, String r20, String r21, Long r22, final OfficeInputParam r23, fo9.b r24, final com.larus.office.h r25, com.bytedance.ee.bear.container.f r26) {
        Intrinsics.checkNotNullParameter(r110, "context");
        Intrinsics.checkNotNullParameter(r20, "resId");
        FLogger r3 = FLogger.a;
        r3.i(TAG, "Get ChameleonFragment for doc");
        boolean r11 = true;
        getKeva().storeBoolean("has_opened_fusion_doc", true);
        com.larus.doc.sdk.impl.service.ServiceManager.INSTANCE.setInputParam(r23);
        final an9.a r4 = new an9.a(r24);
        hk5.a r15 = new DocSdkServiceImplV2$getDocFragment$pluginHostCallback$1(r4, r25, r23);
        if (Intrinsics.areEqual(r20, "fake_offline_doc_id") == false) goto L16;
        ik5.a r5 = this.docSdk;
        if (r5 == null) goto L8;
        String r6 = r5.J9();
        if (r6 == null) goto L8;
    L9:
        String r12 = r6;
        r3.i(TAG, "fakeToken logic: generate new fakeToken: ".concat(r12));
        AppHost.Companion r7 = AppHost.a;
        if (r7.isDebug() == false) goto L12;
    L15:
        s.j(s.a, r110, "fakeToken = ".concat(r12), 3000, true, 8);
    L17:
        String r13 = buildDocUrl(r12, r23);
        if (r23 != null) goto L20;
    L22:
        r11 = false;
    L23:
        if (r11 == true) goto L27;
        r3.i(TAG, "preload in openAndGetDocFragment, resId=" + r20);
        ik5.a r1 = this.docSdk;
        if (r1 == null) goto L28;
        r1.Qd(r13);
    L28:
        ik5.a r14 = this.docSdk;
        if (r14 == null) goto L33;
        Fragment r2 = r14.C6(r13, r22, r21, r15, r26);
        if (r2 == null) goto L33;
        return r2;
    L33:
        return new Fragment();
    L27:
        r3.i(TAG, "skip preload in openAndGetDocFragment, already preloaded upstream, resId=" + r20);
        goto L28
    L20:
        if (r23.getDocPreloaded() != true) goto L22;
    L12:
        if (r7.isDebugChannel() == true) goto L15;
        if (r7.isTestChannel() == false) goto L17;
    L8:
        r6 = "";
        goto L9
    L16:
        r12 = r20;
        goto L17
    }

    @Override // com.larus.doc.sdk.api.IDocSdkServiceV2
    public void startDocExport(Context r8, String r9, String r10, String r11, String r12, String r13, String r14, final Function4<? super Boolean, ? super Uri, ? super Integer, ? super String, Unit> r15) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "fileName");
        Intrinsics.checkNotNullParameter(r10, "fileType");
        Intrinsics.checkNotNullParameter(r15, "callback");
        ik5.a r0 = this.docSdk;
        if (r0 == null) goto L5;
        j15.a r16 = r0.R4(r8, r9);
    L6:
        j15.a r1 = r16;
        this.documentExportExecutor = r1;
        if (r1 == null) goto L10;
        r1.a(fileTypeToExportFormat(r10), r11, r12, r13, r14, new C01751(r15));
        return;
    L10:
        return;
    L5:
        r16 = null;
        goto L6
    }

    @Override // com.larus.doc.sdk.api.IDocSdkServiceV2
    public Object openAndGetDocFragment(Context r110, String r20, String r21, String r22, Long r23, OfficeInputParam r24, fo9.b r25, com.bytedance.ee.bear.container.f r26, Continuation<? super Fragment> r27) {
        if ((r27 instanceof C01741) == false) goto L7;
        C01741 r2 = (C01741) r27;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        boolean r6 = true;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        com.bytedance.ee.bear.container.f r7 = (com.bytedance.ee.bear.container.f) r2.L$6;
        fo9.b r8 = (fo9.b) r2.L$5;
        final OfficeInputParam r9 = (OfficeInputParam) r2.L$4;
        Long r10 = (Long) r2.L$3;
        String r11 = (String) r2.L$2;
        String r12 = (String) r2.L$1;
        Context r13 = (Context) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L14
        com.bytedance.ee.bear.container.f r14 = r7;
    L50:
        FLogger r1 = FLogger.a;
        r1.i(TAG, "Get doc fragment, docSdk=" + this.docSdk);
        this.lastToolbar = null;
        com.larus.doc.sdk.impl.service.ServiceManager.INSTANCE.setInputParam(r9);
        final an9.a r15 = new an9.a(r8);
        hk5.a r16 = new DocSdkServiceImplV2$openAndGetDocFragment$pluginHostCallback$1(r15, r9);
        if (Intrinsics.areEqual(r12, "fake_offline_doc_id") == false) goto L64;
        ik5.a r17 = this.docSdk;
        if (r17 == null) goto L56;
        String r18 = r17.J9();
        if (r18 == null) goto L56;
    L57:
        r12 = r18;
        r1.i(TAG, "fakeToken logic: generate new fakeToken: ".concat(r12));
        AppHost.Companion r28 = AppHost.a;
        if (r28.isDebug() == false) goto L60;
    L63:
        s.j(s.a, r13, "fakeToken = ".concat(r12), Boxing.boxInt(3000), true, 8);
        goto L64
    L60:
        if (r28.isDebugChannel() == true) goto L63;
        if (r28.isTestChannel() == false) goto L64;
    L56:
        r18 = "";
    L64:
        String r30 = buildDocUrl(r12, r9);
        if (r9 != null) goto L67;
    L69:
        r6 = false;
    L70:
        if (r6 == true) goto L74;
        r1.i(TAG, "preload in openAndGetDocFragment, resId=" + r12);
        ik5.a r31 = this.docSdk;
        if (r31 == null) goto L75;
        r31.Qd(r30);
    L75:
        ik5.a r32 = this.docSdk;
        if (r32 == null) goto L80;
        Fragment r33 = r32.C6(r30, r10, r11, r16, r14);
        if (r33 == null) goto L80;
        return r33;
    L80:
        return new Fragment();
    L74:
        r1.i(TAG, "skip preload in openAndGetDocFragment, already preloaded upstream, resId=" + r12);
        goto L75
    L67:
        if (r9.getDocPreloaded() != true) goto L69;
    L14:
        e = e;
        r14 = r7;
        fo9.b r111 = r8;
        Context r34 = r13;
        OfficeInputParam r112 = r9;
        String r35 = r12;
        Long r113 = r10;
        String r36 = r11;
    L48:
        FLogger.a.e(TAG, "Load docSdk failed: " + e.getMessage());
    L49:
        r13 = r34;
        r8 = r111;
        OfficeInputParam r114 = r112;
        r12 = r35;
        r9 = r114;
        Long r115 = r113;
        r11 = r36;
        r10 = r115;
        goto L50
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        FLogger.a.i(TAG, "Get doc fragment, docSdk=" + this.docSdk);
        getKeva().storeBoolean("has_opened_fusion_doc", true);
        r34 = r110;
        r2.L$0 = r34;     // Catch: Exception -> L46
        r35 = r20;
        r2.L$1 = r35;     // Catch: Exception -> L44
        r36 = r21;
        r2.L$2 = r36;     // Catch: Exception -> L42
        r113 = r23;
        r2.L$3 = r113;     // Catch: Exception -> L40
        r112 = r24;
        r2.L$4 = r112;     // Catch: Exception -> L38
        r111 = r25;
        r2.L$5 = r111;     // Catch: Exception -> L36
        r14 = r26;
        r2.L$6 = r14;     // Catch: Exception -> L34
        r2.label = 1;     // Catch: Exception -> L34
        if (initDocSdkIfNeeded(r2) != r4) goto L49;
        return r4;
    L34:
        e = e;
    L36:
        e = e;
    L37:
        r14 = r26;
    L38:
        e = e;
    L39:
        r111 = r25;
    L40:
        e = e;
    L41:
        r112 = r24;
    L42:
        e = e;
    L43:
        r113 = r23;
    L44:
        e = e;
    L45:
        r36 = r21;
    L46:
        e = e;
        r35 = r20;
    L7:
        r2 = new C01741(this, r27);
        goto L8
    }
}
