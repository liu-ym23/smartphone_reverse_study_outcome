package com.larus.slides.sdk.impl.plugins.media;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import bx9.c;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.slides.sdk.api.media.SelectedImageModel;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.tencent.open.log.TraceLevel;
import dx9.e;
import dx9.f;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010\u0013\u001a\u00020\r2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/larus/slides/sdk/impl/plugins/media/SlidesSelectMediaPluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "editPanelManager", "Lcom/bytedance/ee/bear/document/toolbar/editpanels/EditPanelsManager;", "editPanel", "Lcom/larus/slides/sdk/impl/plugins/editpanel/SlidesSelectMediaDelegate;", "getEditPanel", "()Lcom/larus/slides/sdk/impl/plugins/editpanel/SlidesSelectMediaDelegate;", "editPanel$delegate", "Lkotlin/Lazy;", "onAttachToUIContainer", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "getBridgeHandlers", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Companion", "SelectMediaHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SlidesSelectMediaPluginV2 extends OfficeDocumentPlugin {
    private static final String BIZ_SLIDES_SELECT_MEDIA = "biz.util.slidesSelectMedia";
    public static final a Companion = null;
    private static final String TAG = "SlidesSelectMediaPluginV2";
    private final Lazy editPanel$delegate;
    private EditPanelsManager editPanelManager;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<SelectedImageModel> {
        public final ChameleonPluginHost a;
        public final /* synthetic */ SlidesSelectMediaPluginV2 b;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(SlidesSelectMediaPluginV2 r1, ChameleonPluginHost r2) {
            this.b = r1;
            this.a = r2;
        }

        public final void handle(Object r5, m r6) {
            final SelectedImageModel r7 = (SelectedImageModel) r5;
            FLogger.a.i(SlidesSelectMediaPluginV2.TAG, "call select media:" + GsonProtectorUtils.toJson(new Gson(), r7));
            if ((SlidesSelectMediaPluginV2.access$getActivity(this.b) instanceof c) == false) goto L15;
            SlidesSelectMediaPluginV2.access$getEditPanel(this.b).setActive(true);
            EditPanelsManager r8 = SlidesSelectMediaPluginV2.access$getEditPanelManager$p(this.b);
            if (r8 == null) goto L7;
            r8.requestUpdateWebContentHeight();
        L7:
            ChameleonPluginHost r9 = this.a;
            if (r9 == null) goto L16;
            t r10 = r9.getUIContainer();
            if (r10 == null) goto L17;
            View r11 = r10.getContentView();
            if (r11 == null) goto L18;
            final SlidesSelectMediaPluginV2 r0 = this.b;
            r11.postDelayed(new f(r0, r7, this), 250);
            return;
        L18:
            return;
        L17:
            return;
        L16:
            return;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ cx9.c a() {
        return editPanel_delegate$lambda$0();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private static final cx9.c editPanel_delegate$lambda$0() {
        return new cx9.c();
    }

    private final cx9.c getEditPanel() {
        return (cx9.c) this.editPanel$delegate.getValue();
    }

    public SlidesSelectMediaPluginV2() {
        this.editPanel$delegate = LazyKt.lazy(new e());
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(SlidesSelectMediaPluginV2 r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ cx9.c access$getEditPanel(SlidesSelectMediaPluginV2 r0) {
        return r0.getEditPanel();
    }

    public static final /* synthetic */ EditPanelsManager access$getEditPanelManager$p(SlidesSelectMediaPluginV2 r0) {
        return r0.editPanelManager;
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.ss.android.lark.chameleon.AbsChameleonPlugin*/.getBridgeHandlers(r3);
        r3.put(BIZ_SLIDES_SELECT_MEDIA, new b(this, getHost()));
    }

    public void onAttachToUIContainer(ChameleonPluginHost r2, t r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r2, r3);
        EditPanelsManager r4 = ViewModelProviders.of(getActivity()).get(Reflection.getOrCreateKotlinClass(EditPanelsManager.class));
        this.editPanelManager = r4;
        if (r4 == null) goto L6;
        r4.registerEditPanel(getLifecycleOwner(), getEditPanel());
        return;
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
        this.editPanelManager = null;
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
