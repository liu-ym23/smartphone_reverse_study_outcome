package com.larus.sheet.sdk.impl.plugins.selection;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.google.gson.Gson;
import com.larus.sheet.sdk.api.SheetSelectionChangeData;
import com.larus.sheet.sdk.api.SheetUserSelection;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sw9.g;
import tb5.i;
import tb5.m;
import vz4.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0003\u0013\u0014\u0015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\f\u001a\u00020\u00062\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016¨\u0006\u0016"}, d2 = {"Lcom/larus/sheet/sdk/impl/plugins/selection/SheetSelectionChangePluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "Lcom/larus/sheet/sdk/api/IReferenceStateListener;", "<init>", "()V", "onAttachToUIContainer", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "getBridgeHandlers", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onClearReference", "notifyCloseCustomMenu", "Companion", "DoubaoMenuClickHandler", "ElementSelectionChangeHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SheetSelectionChangePluginV2 extends OfficeDocumentPlugin implements pw9.c {
    private static final String BIZ_DOUBAO_MENU_CLICK = "biz.navigation.handleDoubaoMenuClick";
    private static final String BIZ_NOTIFY_IS_REF_SELECT = "biz.notify.isRefSelect";
    private static final String BIZ_SHEET_SELECTION = "biz.notify.sheetSelectChange";
    public static final a Companion = null;
    private static final String FUNC_CLEAR_REFERENCE = "javascript:window.flow.biz.util.clearReference";
    private static final String TAG = "SheetSelectionPlugin";

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
            FLogger.a.i(SheetSelectionChangePluginV2.TAG, "Got doubao menu click data: " + r3);
            g.a().requestChatInputFocus();
        }
    }

    public static final class c implements i<String> {
        public c() {
        }

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public final void handle(Object r4, m r5) {
            String r6 = (String) r4;
            FLogger.a.i(SheetSelectionChangePluginV2.TAG, "Got sheet selection change data: " + r6);
            Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L5
            Object r8 = Result.constructor-impl((SheetSelectionChangeData) new Gson().fromJson(r6, SheetSelectionChangeData.class));     // Catch: Throwable -> L5
        L7:
            Integer r1 = null;
            if (Result.isFailure-impl(r8) == false) goto L10;
            r8 = null;
        L10:
            SheetSelectionChangeData r9 = (SheetSelectionChangeData) r8;
            g.c().P(true);
            sw9.b r0 = g.c();
            if (r9 == null) goto L15;
            SheetUserSelection r2 = r9.getSelected();
            if (r2 == null) goto L15;
            String r3 = r2.getPlainText();
        L16:
            if (r3 != null) goto L18;
            r3 = "";
        L18:
            if (r9 == null) goto L20;
            r1 = Integer.valueOf(r9.getSpreadsheetVersion());
        L20:
            r0.a(r6, r3, r1);
            return;
        L15:
            r3 = null;
        L5:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // pw9.c
    public void notifyCloseCustomMenu() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        ChameleonPluginHost r1 = getHost();     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        d r2 = r1.getHostAbility(d.class);     // Catch: Throwable -> L10
        if (r2 == null) goto L7;
        r2.closeActionMode();     // Catch: Throwable -> L10
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L8:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L10
    L12:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L18;
        FLogger.a.e(TAG, "notifyCloseCustomMenu error: " + r5.getMessage());
        return;
    L18:
        return;
    L7:
        r3 = null;
    L10:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // pw9.c
    public void onClearReference() {
        g.c().P(false);
    }

    public SheetSelectionChangePluginV2() {
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.ss.android.lark.chameleon.AbsChameleonPlugin*/.getBridgeHandlers(r3);
        r3.put(BIZ_SHEET_SELECTION, new c());
        r3.put(BIZ_DOUBAO_MENU_CLICK, new b());
    }

    public void onAttachToUIContainer(ChameleonPluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r2, r3);
        pw9.c r4 = g.a;
        g.a = this;
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r2, r3);
        pw9.c r4 = g.a;
        g.a = null;
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
