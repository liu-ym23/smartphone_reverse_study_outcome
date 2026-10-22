package com.larus.doc.sdk.impl.v2.plugins.state;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.larus.doc.sdk.impl.generalbiz.common.DocSdkVersion;
import com.larus.doc.sdk.impl.generalbiz.rewrite.PartialRewriteJsCaller;
import com.larus.doc.sdk.impl.generalbiz.state.ToolbarProcessor;
import com.larus.doc.sdk.impl.generalbiz.state.keyboard.EditPanelsManager;
import com.larus.doc.sdk.impl.generalbiz.state.model.FlowDocStateViewModel;
import com.larus.office.x;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n39.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u0015J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012¨\u0006\""}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/state/FlowDocStatePluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "Lcom/larus/doc/sdk/api/IToolbarService;", "<init>", "()V", "toolbarViewModel", "Lcom/larus/doc/sdk/impl/generalbiz/state/model/FlowDocStateViewModel;", "editPanelsManager", "Lcom/larus/doc/sdk/impl/generalbiz/state/keyboard/EditPanelsManager;", "editPanelHost", "Lcom/larus/office/base/plugins/IOfficePluginHost;", "getEditPanelHost", "()Lcom/larus/office/base/plugins/IOfficePluginHost;", "editPanelHost$delegate", "Lkotlin/Lazy;", "toolBarProcessor", "Lcom/larus/doc/sdk/impl/generalbiz/state/ToolbarProcessor;", "getToolBarProcessor", "()Lcom/larus/doc/sdk/impl/generalbiz/state/ToolbarProcessor;", "toolBarProcessor$delegate", "onAttachToHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onDetachFromHost", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "switchToAiEditMode", "switchToNormalEditMode", "switchToReadOnlyMode", "notifyMoreAction", "type", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowDocStatePluginV2 extends OfficeDocumentPlugin implements o {
    private final Lazy editPanelHost$delegate;
    private final EditPanelsManager editPanelsManager;
    private final Lazy toolBarProcessor$delegate;
    private FlowDocStateViewModel toolbarViewModel;

    public static /* synthetic */ ToolbarProcessor a(FlowDocStatePluginV2 r0) {
        return toolBarProcessor_delegate$lambda$1(r0);
    }

    public static /* synthetic */ FlowDocStatePluginV2$editPanelHost$2$1 c(FlowDocStatePluginV2 r0) {
        return editPanelHost_delegate$lambda$0(r0);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final xm9.a getEditPanelHost() {
        return (xm9.a) this.editPanelHost$delegate.getValue();
    }

    private final ToolbarProcessor getToolBarProcessor() {
        return (ToolbarProcessor) this.toolBarProcessor$delegate.getValue();
    }

    public FlowDocStatePluginV2() {
        this.editPanelsManager = new EditPanelsManager();
        this.editPanelHost$delegate = LazyKt.lazy(new b(this));
        this.toolBarProcessor$delegate = LazyKt.lazy(new c(this));
    }

    public final void switchToAiEditMode() {
        String r0 = x.a(getHost());
        getToolBarProcessor().switchToAiEditMode(r0);
        PartialRewriteJsCaller.INSTANCE.enterStreamEditMode(getHost().getWeb().getWebView(), null, DocSdkVersion.V2);
    }

    @Override // n39.o
    public void switchToNormalEditMode() {
        getToolBarProcessor().switchToNormalEditMode();
    }

    @Override // n39.o
    public void switchToReadOnlyMode() {
        getToolBarProcessor().switchToReadOnlyMode();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.doc.sdk.impl.v2.plugins.state.FlowDocStatePluginV2$editPanelHost$2$1] */
    private static final FlowDocStatePluginV2$editPanelHost$2$1 editPanelHost_delegate$lambda$0(final FlowDocStatePluginV2 r1) {
        return new FlowDocStatePluginV2$editPanelHost$2$1(r1);
    }

    private static final ToolbarProcessor toolBarProcessor_delegate$lambda$1(FlowDocStatePluginV2 r4) {
        return new ToolbarProcessor(r4.toolbarViewModel, r4.editPanelsManager, r4.getEditPanelHost(), DocSdkVersion.V2);
    }

    @Override // n39.o
    public void notifyMoreAction(String r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        getToolBarProcessor().notifyMoreAction(r2);
    }

    public void onAttachToHost(final ChameleonPluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        this.toolbarViewModel = (FlowDocStateViewModel) q.c(r3, FlowDocStateViewModel.class, null);
        this.editPanelsManager.onAttachToHost(new AnonymousClass1(r3));
    }

    public void onDetachFromHost(ChameleonPluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r1);
        this.editPanelsManager.onDetachFromHost();
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    public void onAttachToUIContainer(final ChameleonPluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r2, r3);
        FlowDocStateViewModel r4 = this.toolbarViewModel;
        if (r4 == null) goto L6;
        r4.setEditPanelDelegate(new FlowDocStatePluginV2$onAttachToUIContainer$1$1(r2));
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }
}
