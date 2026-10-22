package com.larus.doc.sdk.impl.v2.plugins.audio;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.larus.doc.sdk.impl.generalbiz.common.DocSdkVersion;
import com.larus.doc.sdk.impl.generalbiz.common.FlowJsCaller;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n39.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\n\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\fH\u0016J\u001c\u0010\u000e\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0012H\u0016¨\u0006\u0014"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/audio/VoiceInputPluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "Lcom/larus/doc/sdk/api/IVoiceInputService;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onDetachFromHost", "startVoiceInput", "callback", "Lkotlin/Function1;", "", "stopVoiceInput", "", "displayAsrText", "sentence", "Lkotlin/Pair;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceInputPluginV2 extends OfficeDocumentPlugin implements r {
    public static final Companion Companion = null;
    private static final String TAG = "VoiceInputPlugin";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/audio/VoiceInputPluginV2$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public VoiceInputPluginV2() {
    }

    @Override // n39.r
    public void displayAsrText(Pair<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "sentence");
        FLogger.a.i(TAG, "displayAsrText: " + r4);
        FlowJsCaller.INSTANCE.displayAsrText(getHost().getWeb().getWebView(), r4, DocSdkVersion.V2);
    }

    public void onAttachToHost(ChameleonPluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r1);
        DocVoiceInputManager.INSTANCE.setService(this);
    }

    public void onDetachFromHost(ChameleonPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r2);
        DocVoiceInputManager.INSTANCE.setService(null);
    }

    @Override // n39.r
    public void startVoiceInput(Function1<? super String, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        FLogger.a.i(TAG, "startVoiceInput");
        FlowJsCaller.INSTANCE.startVoiceInput(getHost().getWeb().getWebView(), r4, DocSdkVersion.V2);
    }

    @Override // n39.r
    public void stopVoiceInput(Function1<? super Integer, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        FLogger.a.i(TAG, "stopVoiceInput");
        FlowJsCaller.INSTANCE.stopVoiceInput(getHost().getWeb().getWebView(), r4, DocSdkVersion.V2);
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }
}
