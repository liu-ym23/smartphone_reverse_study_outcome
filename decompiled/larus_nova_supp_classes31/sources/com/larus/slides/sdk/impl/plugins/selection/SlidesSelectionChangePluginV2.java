package com.larus.slides.sdk.impl.plugins.selection;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.google.gson.JsonObject;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.util.SafeJSExecutor;
import com.tencent.open.log.TraceLevel;
import ex9.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0004\u0013\u0014\u0015\u0016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\f\u001a\u00020\u00062\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016¨\u0006\u0017"}, d2 = {"Lcom/larus/slides/sdk/impl/plugins/selection/SlidesSelectionChangePluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "Lcom/larus/slides/sdk/api/IReferenceStateListener;", "<init>", "()V", "onAttachToUIContainer", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "getBridgeHandlers", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onClearReference", "notifyCloseCustomMenu", "Companion", "DoubaoMenuClickHandler", "IsRefSelectHandler", "ElementSelectionChangeHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SlidesSelectionChangePluginV2 extends OfficeDocumentPlugin implements ax9.c {
    private static final String BIZ_DOUBAO_MENU_CLICK = "biz.navigation.handleDoubaoMenuClick";
    private static final String BIZ_NOTIFY_IS_REF_SELECT = "biz.notify.isRefSelect";
    private static final String BIZ_SLIDES_SELECTION = "biz.notify.onSlidesSelectionChange";
    public static final a Companion = null;
    private static final String FUNC_CLEAR_REFERENCE = "javascript:window.flow.biz.util.clearReference";
    private static final String TAG = "SlidesSelectionPlugin";

    public static final class a {
        public a() {
        }
    }

    public static final class b implements i<Object> {
        public b() {
        }

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public final void handle(Object r3, m r4) {
            FLogger.a.i(SlidesSelectionChangePluginV2.TAG, "Got doubao menu click data: " + r3);
            e.a().requestChatInputFocus();
        }
    }

    public static final class c implements i<String> {
        public c() {
        }

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public final void handle(Object r3, m r4) {
            String r5 = (String) r3;
            FLogger.a.i(SlidesSelectionChangePluginV2.TAG, "Got slides selection change data: " + r5);
            ((ex9.b) e.d.getValue()).Q(r5);
        }
    }

    public static final class d implements i<RefSelectData> {
        public d() {
        }

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public final void handle(Object r3, m r4) {
            RefSelectData r5 = (RefSelectData) r3;
            FLogger r6 = FLogger.a;
            StringBuilder r0 = new StringBuilder("Got is ref select data: ");
            if (r5 == null) goto L5;
            Boolean r1 = r5.isRef();
        L6:
            r0.append(r1);
            r6.i(SlidesSelectionChangePluginV2.TAG, r0.toString());
            ex9.b r7 = (ex9.b) e.d.getValue();
            if (r5 == null) goto L9;
            boolean r8 = Intrinsics.areEqual(r5.isRef(), Boolean.TRUE);
        L10:
            r7.P(r8);
            return;
        L9:
            r8 = false;
            goto L10
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // ax9.c
    public void notifyCloseCustomMenu() {
        getHost().getHostAbility(vz4.d.class).closeActionMode();
    }

    @Override // ax9.c
    public void onClearReference() {
        SafeJSExecutor.execJS(getHost().getWeb().getWebView(), FUNC_CLEAR_REFERENCE, new JsonObject());
    }

    public SlidesSelectionChangePluginV2() {
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.ss.android.lark.chameleon.AbsChameleonPlugin*/.getBridgeHandlers(r3);
        r3.put(BIZ_SLIDES_SELECTION, new c());
        r3.put(BIZ_DOUBAO_MENU_CLICK, new b());
        r3.put(BIZ_NOTIFY_IS_REF_SELECT, new d());
    }

    public void onAttachToUIContainer(ChameleonPluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r2, r3);
        ax9.c r4 = e.a;
        e.a = this;
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r2, r3);
        ax9.c r4 = e.a;
        e.a = null;
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
