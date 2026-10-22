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
import dx9.d;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\f\u001a\u00020\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u000fH\u0016J\u001c\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/larus/slides/sdk/impl/plugins/media/AIGenerateImagePluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "editPanelManager", "Lcom/bytedance/ee/bear/document/toolbar/editpanels/EditPanelsManager;", "editPanel", "Lcom/larus/slides/sdk/impl/plugins/editpanel/AIGenerateImageDelegate;", "getEditPanel", "()Lcom/larus/slides/sdk/impl/plugins/editpanel/AIGenerateImageDelegate;", "editPanel$delegate", "Lkotlin/Lazy;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToUIContainer", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "Companion", "AIGenerateImageHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AIGenerateImagePluginV2 extends OfficeDocumentPlugin {
    private static final String BIZ_AI_GENERATE_IMAGE = "biz.util.AIGenerateImage";
    public static final b Companion = null;
    private static final String TAG = "AIGenerateImagePluginV2";
    private final Lazy editPanel$delegate;
    private EditPanelsManager editPanelManager;

    public final class a implements i<SelectedImageModel> {
        public final /* synthetic */ AIGenerateImagePluginV2 a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public a(AIGenerateImagePluginV2 r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [dx9.b] */
        /* JADX WARN: Type inference failed for: r3v0, types: [dx9.c] */
        public final void handle(Object r6, m r7) {
            SelectedImageModel r8 = (SelectedImageModel) r6;
            FLogger.a.d(AIGenerateImagePluginV2.TAG, "call ai generate image:" + GsonProtectorUtils.toJson(new Gson(), r8));
            if (AIGenerateImagePluginV2.access$getActivity(this.a) == null) goto L11;
            final AIGenerateImagePluginV2 r9 = this.a;
            if ((AIGenerateImagePluginV2.access$getActivity(r9) instanceof c) == false) goto L7;
            c r0 = AIGenerateImagePluginV2.access$getActivity(r9);
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larus.slides.sdk.api.media.ISelectMediaBridge");
            r0.i0(new bx9.a(r8, new dx9.b(r9), new dx9.c(r9), 2));
        L7:
            View r10 = r9.getHost().getUIContainer().getContentView();
            if (r10 == null) goto L12;
            r10.postDelayed(new d(r9), 500);
            return;
        L12:
            return;
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    public static /* synthetic */ cx9.a a() {
        return editPanel_delegate$lambda$0();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private static final cx9.a editPanel_delegate$lambda$0() {
        return new cx9.a();
    }

    private final cx9.a getEditPanel() {
        return (cx9.a) this.editPanel$delegate.getValue();
    }

    public AIGenerateImagePluginV2() {
        this.editPanel$delegate = LazyKt.lazy(new dx9.a());
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(AIGenerateImagePluginV2 r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ cx9.a access$getEditPanel(AIGenerateImagePluginV2 r0) {
        return r0.getEditPanel();
    }

    public static final /* synthetic */ EditPanelsManager access$getEditPanelManager$p(AIGenerateImagePluginV2 r0) {
        return r0.editPanelManager;
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.ss.android.lark.chameleon.AbsChameleonPlugin*/.getBridgeHandlers(r3);
        r3.put(BIZ_AI_GENERATE_IMAGE, new a(this));
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
