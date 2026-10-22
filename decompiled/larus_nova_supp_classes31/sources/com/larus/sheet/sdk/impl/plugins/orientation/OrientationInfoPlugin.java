package com.larus.sheet.sdk.impl.plugins.orientation;

import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.sheet.sdk.api.orientation.SetOrientationModel;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pw9.e;
import tb5.h;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0003\u0012\u0013\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J \u0010\n\u001a\u00020\u00072\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\fH\u0016J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0014\u0010\u0004\u001a\b\u0018\u00010\u0005R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/sheet/sdk/impl/plugins/orientation/OrientationInfoPlugin;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "mJSBinder", "Lcom/larus/sheet/sdk/impl/plugins/orientation/OrientationInfoPlugin$OrientationStateHandler;", "onAttachToHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "getBridgeHandlers", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onConfigurationChanged", "newConfiguration", "Landroid/content/res/Configuration;", "Companion", "GetOrientationHandler", "OrientationStateHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class OrientationInfoPlugin extends OfficeDocumentPlugin {
    private static final String BIZ_HANDLER_NAME = "biz.orientation.getStatus";
    public static final a Companion = null;
    public static final String NOTIFY_ORIENTATION_CHANGE = "window.flow.biz.orientation.onSwitch";
    private static final String TAG = "OrientationInfoPlugin";
    private c mJSBinder;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<SetOrientationModel> {
        public final /* synthetic */ OrientationInfoPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(OrientationInfoPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r5, m r6) {
            SetOrientationModel r7 = (SetOrientationModel) r5;
            if ((OrientationInfoPlugin.access$getActivity(this.a) instanceof e) == false) goto L7;
            if (r6 == null) goto L8;
            JSONObject r8 = new JSONObject();
            e r0 = OrientationInfoPlugin.access$getActivity(this.a);
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larus.sheet.sdk.api.ISupportChangeScreenConfigPage");
            String r1 = r0.ha();
            FLogger.a.d(OrientationInfoPlugin.TAG, "handle orientation=" + r1);
            r8.put("type", r1);
            r6.b(r8);
            return;
        L8:
            return;
        }
    }

    public final class c implements h<Object> {
        public final /* synthetic */ OrientationInfoPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerRunOnNotUIThread.-CC.$default$authType(this);
        }

        public c(OrientationInfoPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r3, m r4) {
            Configuration r5 = OrientationInfoPlugin.access$getResources(this.a).getConfiguration();
            if (r4 != null) goto L5;
            return;
        L5:
            if (r5.orientation != 2) goto L7;
            boolean r6 = true;
        L8:
            if (r6 == false) goto L10;
            String r7 = "landscape";
        L11:
            JSONObject r0 = new JSONObject();
            r0.put("type", r7);
            r4.b(r0);
            return;
        L10:
            r7 = "portrait";
            goto L11
        L7:
            r6 = false;
            goto L8
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public OrientationInfoPlugin() {
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(OrientationInfoPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ Resources access$getResources(OrientationInfoPlugin r0) {
        return r0.getResources();
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.ss.android.lark.chameleon.AbsChameleonPlugin*/.getBridgeHandlers(r3);
        r3.put(BIZ_HANDLER_NAME, new b(this));
    }

    public void onAttachToHost(ChameleonPluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r1);
        this.mJSBinder = new c(this);
    }

    public void onConfigurationChanged(Configuration r7) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onConfigurationChanged(r7);
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onConfigurationChanged: isLandscape = ");
        boolean r2 = false;
        if (r7 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        r1.append(r5);
        r0.i(TAG, r1.toString());
        c r3 = this.mJSBinder;
        if (r3 == null) goto L21;
        k r4 = r3.a.getWeb();
        if (r4 == null) goto L22;
        if (r7 != null) goto L14;
        return;
    L14:
        if (r7.orientation != 2) goto L16;
        r2 = true;
    L16:
        if (r2 == false) goto L18;
        String r8 = "landscape";
    L19:
        JSONObject r6 = new JSONObject();
        r6.put("type", r8);
        r0.i(TAG, "notifyOrientationChange: isLandscape = " + r2);
        r4.j(NOTIFY_ORIENTATION_CHANGE, r6);
        return;
    L18:
        r8 = "portrait";
        goto L19
    L22:
        return;
    L21:
        return;
    L5:
        if (r7.orientation != 2) goto L7;
        r5 = true;
        goto L8
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }
}
