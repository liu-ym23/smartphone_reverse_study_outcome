package com.larus.doc.sdk.impl.v2.plugins.state.media;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.doc.sdk.impl.generalbiz.common.DocSdkVersion;
import com.larus.doc.sdk.impl.generalbiz.state.media.SelectMediaProcessor;
import com.larus.doc.sdk.impl.generalbiz.state.media.SelectMediaViewModel;
import com.larus.doc.sdk.impl.v2.plugins.state.FlowDocStatePluginV2;
import com.larus.office.base.plugins.attachment.ImageDataModel;
import com.larus.platform.service.z2;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00122\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00190\u0017H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/state/media/SelectMediaPluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "viewModel", "Lcom/larus/doc/sdk/impl/generalbiz/state/media/SelectMediaViewModel;", "docPluginHost", "Lcom/larus/office/base/plugins/IOfficePluginHost;", "getDocPluginHost", "()Lcom/larus/office/base/plugins/IOfficePluginHost;", "docPluginHost$delegate", "Lkotlin/Lazy;", "selectMediaProcessor", "Lcom/larus/doc/sdk/impl/generalbiz/state/media/SelectMediaProcessor;", "getSelectMediaProcessor", "()Lcom/larus/doc/sdk/impl/generalbiz/state/media/SelectMediaProcessor;", "selectMediaProcessor$delegate", "onAttachToHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "getBridgeHandlers", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Companion", "InnerOpenImageHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectMediaPluginV2 extends OfficeDocumentPlugin {
    public static final Companion Companion = null;
    private static final String OPEN_IMAGE_METHOD = "biz.util.openImg";
    private final Lazy docPluginHost$delegate;
    private final Lazy selectMediaProcessor$delegate;
    private SelectMediaViewModel viewModel;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/state/media/SelectMediaPluginV2$Companion;", "", "<init>", "()V", "OPEN_IMAGE_METHOD", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/state/media/SelectMediaPluginV2$InnerOpenImageHandler;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Lcom/larus/office/base/plugins/attachment/ImageDataModel;", "<init>", "(Lcom/larus/doc/sdk/impl/v2/plugins/state/media/SelectMediaPluginV2;)V", "openImageHandler", "Lcom/larus/office/base/plugins/attachment/OpenImageHandler;", "getOpenImageHandler", "()Lcom/larus/office/base/plugins/attachment/OpenImageHandler;", "openImageHandler$delegate", "Lkotlin/Lazy;", "authType", "Lcom/bytedance/ee/bear/jsbridge/auth/BridgeAuthType;", "handle", "", "data", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class InnerOpenImageHandler implements i<ImageDataModel> {
        private final Lazy openImageHandler$delegate;
        final /* synthetic */ SelectMediaPluginV2 this$0;

        public static /* synthetic */ Unit a(m r0, JSONObject r1) {
            return handle$lambda$1(r0, r1);
        }

        public static /* synthetic */ com.larus.office.base.plugins.attachment.f c(SelectMediaPluginV2 r0) {
            return openImageHandler_delegate$lambda$0(r0);
        }

        private final com.larus.office.base.plugins.attachment.f getOpenImageHandler() {
            return (com.larus.office.base.plugins.attachment.f) this.openImageHandler$delegate.getValue();
        }

        public BridgeAuthType authType() {
            return BridgeAuthType.Private;
        }

        public InnerOpenImageHandler(final SelectMediaPluginV2 r2) {
            this.this$0 = r2;
            this.openImageHandler$delegate = LazyKt.lazy(new e(r2));
        }

        private static final com.larus.office.base.plugins.attachment.f openImageHandler_delegate$lambda$0(SelectMediaPluginV2 r2) {
            return new com.larus.office.base.plugins.attachment.f(SelectMediaPluginV2.access$getDocPluginHost(r2), "Doc");
        }

        private static final Unit handle$lambda$1(m r1, JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "param");
            if (r1 == null) goto L6;
            r1.b(r2);
        L6:
            return Unit.INSTANCE;
        }

        public void handle(ImageDataModel r3, final m r4) {
            getOpenImageHandler().d = r3;
            getOpenImageHandler().c(r3, new d(r4));
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
            handle((ImageDataModel) r1, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ Unit a(ChameleonPluginHost r0, List r1) {
        return onAttachToHost$lambda$2(r0, r1);
    }

    public static /* synthetic */ SelectMediaProcessor c(SelectMediaPluginV2 r0) {
        return selectMediaProcessor_delegate$lambda$1(r0);
    }

    public static /* synthetic */ SelectMediaPluginV2$docPluginHost$2$1 d(SelectMediaPluginV2 r0) {
        return docPluginHost_delegate$lambda$0(r0);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final xm9.a getDocPluginHost() {
        return (xm9.a) this.docPluginHost$delegate.getValue();
    }

    private final SelectMediaProcessor getSelectMediaProcessor() {
        return (SelectMediaProcessor) this.selectMediaProcessor$delegate.getValue();
    }

    public SelectMediaPluginV2() {
        this.docPluginHost$delegate = LazyKt.lazy(new b(this));
        this.selectMediaProcessor$delegate = LazyKt.lazy(new c(this));
    }

    public static final /* synthetic */ xm9.a access$getDocPluginHost(SelectMediaPluginV2 r0) {
        return r0.getDocPluginHost();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.doc.sdk.impl.v2.plugins.state.media.SelectMediaPluginV2$docPluginHost$2$1] */
    private static final SelectMediaPluginV2$docPluginHost$2$1 docPluginHost_delegate$lambda$0(final SelectMediaPluginV2 r1) {
        return new SelectMediaPluginV2$docPluginHost$2$1(r1);
    }

    private static final SelectMediaProcessor selectMediaProcessor_delegate$lambda$1(SelectMediaPluginV2 r3) {
        return new SelectMediaProcessor(r3.viewModel, r3.getDocPluginHost(), DocSdkVersion.V2);
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.ss.android.lark.chameleon.AbsChameleonPlugin*/.getBridgeHandlers(r3);
        if (z2.a.f4() == true) goto L6;
        r3.put(OPEN_IMAGE_METHOD, new InnerOpenImageHandler(this));
        return;
    }

    public void onAttachToHost(final ChameleonPluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        this.viewModel = (SelectMediaViewModel) q.c(r3, SelectMediaViewModel.class, null);
        getSelectMediaProcessor().addMediaSelectCallback(new a(r3));
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    private static final Unit onAttachToHost$lambda$2(ChameleonPluginHost r1, List r2) {
        Intrinsics.checkNotNullParameter(r2, "media");
        r1.getHostAbility(vz4.g.class).insertMedias(r2);
        FlowDocStatePluginV2 r3 = r1.findPlugin(FlowDocStatePluginV2.class);
        if (r3 == null) goto L6;
        r3.switchToReadOnlyMode();
    L6:
        return Unit.INSTANCE;
    }
}
