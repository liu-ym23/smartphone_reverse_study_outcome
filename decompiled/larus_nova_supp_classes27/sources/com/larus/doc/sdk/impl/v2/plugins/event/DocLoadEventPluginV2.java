package com.larus.doc.sdk.impl.v2.plugins.event;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.doc.sdk.impl.service.ServiceManager;
import com.larus.doc.sdk.impl.v2.plugins.input.ChatInputContainerPlugin;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.office.OfficeInputParam;
import com.larus.office.base.plugins.statistics.OfficeTraceHelper;
import com.larus.office.w;
import com.larus.office.x;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleon.PluginProvider;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginId;
import com.ss.android.lark.chameleonv2.Chameleon;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import fo9.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n39.c;
import tb5.i;
import tb5.m;
import vm9.b;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u000b\b\u0016\u0018\u0000  2\u00020\u0001:\u0004 !\"#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u0012H\u0016J\u0012\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u001b\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0010H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006$"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/event/DocLoadEventPluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "mLoadingView", "Lcom/larus/office/base/page/IHostLoadingAndErrorLayout;", "hasReportFinishEvent", "", "getChatService", "Lcom/larus/doc/sdk/api/IChatService;", "loadingCallback", "com/larus/doc/sdk/impl/v2/plugins/event/DocLoadEventPluginV2$loadingCallback$1", "Lcom/larus/doc/sdk/impl/v2/plugins/event/DocLoadEventPluginV2$loadingCallback$1;", "getPluginId", "", "getBridgeHandlers", "", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromHost", "onDetachFromUIContainer", "onClickFailedRetry", "errCode", "", "replaceDocumentFragment", "Companion", "HideLoadingHandler", "ShowLoadingHandler", "EventHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DocLoadEventPluginV2 extends OfficeDocumentPlugin {
    private static final String BIZ_HIDE_LOADING = "biz.util.hideLoading";
    private static final String BIZ_NOTIFY_EVENT = "biz.notify.event";
    private static final String BIZ_SHOW_LOADING = "biz.util.showLoading";
    public static final Companion Companion = null;
    private static final int ERRCODE_DOCX_NEED_UPGRADE = 700;
    private static final int ERR_DELETED = -55;
    private static final String EVENT_DELETE = "NOTE_DELETED";
    private static final String EVENT_DOCX_UPGRADE = "DOCX_UPGRADE";
    private static final String EVENT_EDIT = "EDIT";
    private static final String EVENT_NOT_FOUND = "NOTE_NOT_FOUND";
    private static final String EVENT_VIEW = "VIEW";
    private static final String NO_PERMISSION = "NO_PERMISSION";
    private static final String TAG = "DocLoadEventPlugin";
    private boolean hasReportFinishEvent;
    private final DocLoadEventPluginV2$loadingCallback$1 loadingCallback;
    private b mLoadingView;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/event/DocLoadEventPluginV2$Companion;", "", "<init>", "()V", "TAG", "", "ERR_DELETED", "", "ERRCODE_DOCX_NEED_UPGRADE", "BIZ_SHOW_LOADING", "BIZ_HIDE_LOADING", "BIZ_NOTIFY_EVENT", "EVENT_DELETE", "EVENT_NOT_FOUND", "EVENT_DOCX_UPGRADE", "EVENT_EDIT", "EVENT_VIEW", DocLoadEventPluginV2.NO_PERMISSION, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/event/DocLoadEventPluginV2$EventHandler;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Lcom/larus/doc/sdk/impl/v2/plugins/event/EventModel;", "<init>", "(Lcom/larus/doc/sdk/impl/v2/plugins/event/DocLoadEventPluginV2;)V", "handle", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class EventHandler implements i<EventModel> {
        final /* synthetic */ DocLoadEventPluginV2 this$0;

        @Nullable
        public /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return null;
        }

        public EventHandler(DocLoadEventPluginV2 r1) {
            this.this$0 = r1;
        }

        public void handle(EventModel r22, m r23) {
            FLogger r1 = FLogger.a;
            StringBuilder r2 = new StringBuilder("EventHandler: ");
            String r3 = null;
            if (r22 == null) goto L5;
            String r4 = r22.getEvent();
        L6:
            r2.append(r4);
            r1.i(DocLoadEventPluginV2.TAG, r2.toString());
            if (r22 == null) goto L9;
            String r5 = r22.getEvent();
        L11:
            if (r5 != null) goto L13;
        L36:
            int r6 = 999;
        L37:
            b r7 = DocLoadEventPluginV2.access$getMLoadingView$p(this.this$0);
            if (r7 == null) goto L43;
            if (r22 == null) goto L41;
            String r8 = r22.getMessage();
        L42:
            r7.a(r6, r8);
            goto L43
        L41:
            r8 = null;
        L43:
            if (r6 == DocLoadEventPluginV2.ERR_DELETED) goto L60;
            if (r6 == DocLoadEventPluginV2.ERRCODE_DOCX_NEED_UPGRADE) goto L58;
            c r9 = DocLoadEventPluginV2.access$getChatService(this.this$0);
            ChameleonPluginHost r10 = this.this$0.getHost();
            if (r10 == null) goto L50;
            ChatInputContainerPlugin r11 = r10.findPlugin(ChatInputContainerPlugin.class);
            if (r11 == null) goto L50;
            ViewGroup r12 = r11.getChatInputContainer();
        L51:
            ChameleonPluginHost r13 = this.this$0.getHost();
            if (r13 == null) goto L56;
            Fragment r14 = r13.getFragment();
            if (r14 == null) goto L56;
            FragmentManager r15 = r14.getChildFragmentManager();
        L57:
            r9.notifyInitChatInput(r12, r15);
        L59:
            String r16 = "other";
        L61:
            String r17 = r16;
            if (DocLoadEventPluginV2.access$getHasReportFinishEvent$p(this.this$0) == true) goto L124;
            ServiceManager r18 = ServiceManager.INSTANCE;
            OfficeInputParam r20 = r18.getInputParam();
            int r21 = 1;
            if (r20 != null) goto L66;
        L68:
            boolean r24 = false;
        L69:
            if (r24 == false) goto L125;
            DocLoadEventPluginV2.access$setHasReportFinishEvent$p(this.this$0, true);
            r1.i(DocLoadEventPluginV2.TAG, "reportDocLaunchResult: onLoadFail");
            DocLoadEventPluginV2.access$getChatService(this.this$0).onLoadFinishEventReported();
            ChameleonPluginHost r25 = this.this$0.getHost();
            if (r25 == null) goto L75;
            k r26 = r25.getWeb();
            if (r26 == null) goto L75;
            WebView r27 = r26.getWebView();
        L77:
            if ((r27 instanceof ChameleonWebView) == false) goto L79;
            ChameleonWebView r28 = (ChameleonWebView) r27;
        L80:
            if (r28 == null) goto L82;
            int r30 = r28.getUsedCount();
        L83:
            int r31 = OfficeTraceHelper.a;
            String r32 = OfficeTraceHelper.DOC_TYPE.DOCX.getType();
            OfficeInputParam r33 = r18.getInputParam();
            if (r33 == null) goto L86;
            String r34 = r33.getResourceId();
        L87:
            OfficeInputParam r110 = r18.getInputParam();
            if (r110 == null) goto L90;
            String r111 = r110.getConversationId();
        L91:
            OfficeInputParam r112 = r18.getInputParam();
            if (r112 != null) goto L94;
        L96:
            boolean r113 = false;
        L97:
            String r114 = "1";
            if (r113 == false) goto L100;
            String r115 = "1";
        L101:
            if (r30 > 0) goto L104;
            r114 = "0";
        L104:
            OfficeInputParam r35 = r18.getInputParam();
            if (r35 == null) goto L107;
            r3 = r35.getEnterMethod();
        L107:
            long r116 = System.currentTimeMillis();
            OfficeInputParam r36 = r18.getInputParam();
            long r117 = 0;
            if (r36 == null) goto L110;
            long r118 = r36.getClickTimestamp();
        L111:
            Long r119 = Long.valueOf(r116 - r118);
            long r120 = System.currentTimeMillis();
            OfficeInputParam r37 = r18.getInputParam();
            if (r37 == null) goto L114;
            r117 = r37.getBeginLoadTimestamp();
        L114:
            Long r121 = Long.valueOf(r120 - r117);
            String r122 = "Error: " + r6;
            OfficeInputParam r38 = r18.getInputParam();
            if (r38 != null) goto L117;
        L119:
            r21 = 0;
        L120:
            OfficeTraceHelper.a(r32, r34, 10, r111, "0", r115, r114, r3, r119, r121, r17, r122, Integer.valueOf(r21));
            return;
        L117:
            if (r38.isFakeOfflineDoc() != true) goto L119;
        L110:
            r118 = 0;
            goto L111
        L100:
            r115 = "0";
            goto L101
        L94:
            if (r112.isColdStart() != true) goto L96;
            r113 = true;
            goto L97
        L90:
            r111 = null;
            goto L91
        L86:
            r34 = null;
            goto L87
        L82:
            r30 = 0;
            goto L83
        L79:
            r28 = null;
        L75:
            r27 = null;
            goto L77
        L125:
            return;
        L66:
            if (r20.getHasReportFinishEvent() == true) goto L68;
            r24 = true;
            goto L69
        L124:
            return;
        L56:
            r15 = null;
        L50:
            r12 = null;
            goto L51
        L58:
            DocLoadEventPluginV2.access$getChatService(this.this$0).onDocNeedUpdate();
            goto L59
        L60:
            DocLoadEventPluginV2.access$getChatService(this.this$0).onDocDeleted();
            r16 = "deleted";
            goto L61
        L13:
            switch(r5.hashCode()) {
                case -1911183619: goto L33;
                case -131073335: goto L29;
                case 2123274: goto L25;
                case 2634405: goto L22;
                case 1252789005: goto L19;
                case 2097412268: goto L16;
                default: goto L36;
            };
        L16:
            if (r5.equals(DocLoadEventPluginV2.EVENT_DELETE) == false) goto L36;
        L31:
            r6 = DocLoadEventPluginV2.ERR_DELETED;
            goto L37
        L19:
            if (r5.equals(DocLoadEventPluginV2.NO_PERMISSION) == false) goto L36;
            return;
        L22:
            if (r5.equals(DocLoadEventPluginV2.EVENT_VIEW) == false) goto L36;
            return;
        L25:
            if (r5.equals(DocLoadEventPluginV2.EVENT_EDIT) == false) goto L36;
            return;
        L29:
            if (r5.equals(DocLoadEventPluginV2.EVENT_NOT_FOUND) == true) goto L31;
        L33:
            if (r5.equals(DocLoadEventPluginV2.EVENT_DOCX_UPGRADE) == false) goto L36;
            r6 = DocLoadEventPluginV2.ERRCODE_DOCX_NEED_UPGRADE;
            goto L37
        L9:
            r5 = null;
            goto L11
        L5:
            r4 = null;
            goto L6
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
            handle((EventModel) r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/event/DocLoadEventPluginV2$HideLoadingHandler;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "", "<init>", "(Lcom/larus/doc/sdk/impl/v2/plugins/event/DocLoadEventPluginV2;)V", "handle", "", "data", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class HideLoadingHandler implements i<Object> {
        final /* synthetic */ DocLoadEventPluginV2 this$0;

        @Nullable
        public /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return null;
        }

        public HideLoadingHandler(DocLoadEventPluginV2 r1) {
            this.this$0 = r1;
        }

        public void handle(Object r2, m r3) {
            FLogger r4 = FLogger.a;
            r4.i(DocLoadEventPluginV2.TAG, "hideLoading");
            r4.i("[DocTracer]", "Hide loading");
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/event/DocLoadEventPluginV2$ShowLoadingHandler;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "", "<init>", "(Lcom/larus/doc/sdk/impl/v2/plugins/event/DocLoadEventPluginV2;)V", "handle", "", "data", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ShowLoadingHandler implements i<Object> {
        final /* synthetic */ DocLoadEventPluginV2 this$0;

        @Nullable
        public /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return null;
        }

        public ShowLoadingHandler(DocLoadEventPluginV2 r1) {
            this.this$0 = r1;
        }

        public void handle(Object r2, m r3) {
            FLogger.a.i(DocLoadEventPluginV2.TAG, "showLoading");
            t r4 = DocLoadEventPluginV2.access$getUIContainer(this.this$0);
            if (r4 == null) goto L9;
            View r5 = r4.getContentView();
            if (r5 == null) goto L9;
            View r6 = r5.findViewById(2131367051);
            if (r6 == null) goto L9;
            e1.x(r6);
        L9:
            b r7 = DocLoadEventPluginV2.access$getMLoadingView$p(this.this$0);
            if (r7 == null) goto L13;
            r7.b();
            return;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final c getChatService() {
        ServiceManager r0 = ServiceManager.INSTANCE;
        ChameleonPluginHost r1 = getHost();
        if (r1 == null) goto L6;
        String r2 = x.a(r1);
        if (r2 == null) goto L6;
    L8:
        return r0.getChatService(r2);
    L6:
        r2 = "";
        goto L8
    }

    public String getPluginId() {
        return ChameleonPluginId.LoadingPlugin.getValue();
    }

    public void replaceDocumentFragment() {
        FLogger r0 = FLogger.a;
        r0.i(TAG, "replaceDocumentFragment()...");
        Fragment r2 = getHost().getFragment();
        Bundle r3 = r2.getArguments();
        String r4 = "";
        if (r3 == null) goto L5;
        String r5 = r3.getString("session_id", "");
    L6:
        if (r5 == null) goto L10;
        r4 = r5;
    L10:
        if (TextUtils.isEmpty(r4) == false) goto L14;
        r0.w(TAG, "the documentFragment or its sessionId is null");
        return;
    L14:
        if (TextUtils.isEmpty(getHost().getUrl()) == false) goto L17;
        r0.w(TAG, "the documentFragment or its origin url is null");
        return;
    L17:
        FragmentManager r1 = r2.getFragmentManager();
        if (r1 == null) goto L41;
        List r6 = com.ss.android.lark.chameleonv2.container.webcontainer.util.b.c(r4);
        ChameleonConfig r7 = com.ss.android.lark.chameleonv2.container.webcontainer.util.b.b(r4);
        OpenConfig r8 = r7.getOpenConfig();     // Catch: Exception -> L35
        if (r8 == null) goto L27;
        PluginProvider r9 = r8.getPluginProvider();     // Catch: Exception -> L35
        if (r9 == null) goto L27;
        ArrayList r10 = r9.getPluginHostAbilitys();     // Catch: Exception -> L35
        if (r10 == null) goto L27;
        r10.add(getHost().getHostAbility(w.class));     // Catch: Exception -> L35
    L27:
        OpenConfig r11 = r7.getOpenConfig();     // Catch: Exception -> L35
        if (r11 == null) goto L37;
        PluginProvider r12 = r11.getPluginProvider();     // Catch: Exception -> L35
        if (r12 == null) goto L37;
        ArrayList r13 = r12.getPluginHostAbilitys();     // Catch: Exception -> L35
        if (r13 == null) goto L37;
        r13.add(getHost().getHostAbility(g.class));     // Catch: Exception -> L35
    L37:
        Chameleon r14 = Chameleon.a;
        Fragment r15 = Chameleon.a(getContext(), r7, r6);
        INVOKEVIRTUAL_com_larus_doc_sdk_impl_v2_plugins_event_DocLoadEventPluginV2_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(r1.beginTransaction(), r2.getId(), r15).commitAllowingStateLoss();
        return;
    L35:
        e = move-exception;
        FLogger.a.e(TAG, "replaceDocumentFragment: add PluginHostParamFetchAbility failed", e);
        goto L37
    L41:
        return;
    L5:
        r5 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.doc.sdk.impl.v2.plugins.event.DocLoadEventPluginV2$loadingCallback$1] */
    public DocLoadEventPluginV2() {
        this.loadingCallback = new DocLoadEventPluginV2$loadingCallback$1(this);
    }

    public static final /* synthetic */ c access$getChatService(DocLoadEventPluginV2 r0) {
        return r0.getChatService();
    }

    public static final /* synthetic */ boolean access$getHasReportFinishEvent$p(DocLoadEventPluginV2 r0) {
        return r0.hasReportFinishEvent;
    }

    public static final /* synthetic */ b access$getMLoadingView$p(DocLoadEventPluginV2 r0) {
        return r0.mLoadingView;
    }

    public static final /* synthetic */ t access$getUIContainer(DocLoadEventPluginV2 r0) {
        return r0.getUIContainer();
    }

    private final void onClickFailedRetry(int r4) {
        FLogger.a.e(TAG, "onFailedRetry()... errCode = " + r4);
        if (r4 != (-56)) goto L5;
        return;
    L5:
        if (r4 == ERR_DELETED) goto L9;
        replaceDocumentFragment();
        return;
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.ss.android.lark.chameleon.AbsChameleonPlugin*/.getBridgeHandlers(r3);
        r3.put(BIZ_SHOW_LOADING, new ShowLoadingHandler(this));
        r3.put(BIZ_NOTIFY_EVENT, new EventHandler(this));
    }

    public void onAttachToHost(ChameleonPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        x2 r3 = getDocumentLoader();
        if (r3 == null) goto L6;
        r3.S3(this.loadingCallback);
        return;
    }

    public void onDetachFromHost(ChameleonPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r2);
        x2 r3 = getDocumentLoader();
        if (r3 == null) goto L6;
        r3.S(this.loadingCallback);
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    public static final /* synthetic */ void access$onClickFailedRetry(DocLoadEventPluginV2 r0, int r1) {
        r0.onClickFailedRetry(r1);
    }

    public static final /* synthetic */ void access$setHasReportFinishEvent$p(DocLoadEventPluginV2 r0, boolean r1) {
        r0.hasReportFinishEvent = r1;
    }

    public static final /* synthetic */ void access$setMLoadingView$p(DocLoadEventPluginV2 r0, b r1) {
        r0.mLoadingView = r1;
    }

    public void onAttachToUIContainer(ChameleonPluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r2, r3);
        String r4 = x.a(r2);
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        b r5 = ServiceManager.INSTANCE.getLoadingService(r4).getLoadingView();
        this.mLoadingView = r5;
        if (r5 == null) goto L9;
        r5.setOnRetryListener(new AnonymousClass1(this));
        return;
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r22, t r23) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r22, r23);
        b r1 = this.mLoadingView;
        String r2 = null;
        if (r1 == null) goto L5;
        r1.setOnRetryListener(null);
    L5:
        this.mLoadingView = null;
        if (this.hasReportFinishEvent == true) goto L65;
        ServiceManager r3 = ServiceManager.INSTANCE;
        OfficeInputParam r4 = r3.getInputParam();
        int r5 = 1;
        if (r4 != null) goto L10;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == false) goto L66;
        this.hasReportFinishEvent = true;
        FLogger.a.i(TAG, "reportDocLaunchResult: onDetachFromUIContainer");
        getChatService().onLoadFinishEventReported();
        if (r22 == null) goto L19;
        k r7 = r22.getWeb();
        if (r7 == null) goto L19;
        WebView r8 = r7.getWebView();
    L21:
        if ((r8 instanceof ChameleonWebView) == false) goto L23;
        ChameleonWebView r9 = (ChameleonWebView) r8;
    L24:
        if (r9 == null) goto L26;
        int r10 = r9.getUsedCount();
    L27:
        int r11 = OfficeTraceHelper.a;
        String r12 = OfficeTraceHelper.DOC_TYPE.DOCX.getType();
        OfficeInputParam r13 = r3.getInputParam();
        if (r13 == null) goto L30;
        String r14 = r13.getResourceId();
    L31:
        OfficeInputParam r15 = r3.getInputParam();
        if (r15 == null) goto L34;
        String r16 = r15.getConversationId();
    L35:
        OfficeInputParam r17 = r3.getInputParam();
        if (r17 != null) goto L38;
    L40:
        boolean r18 = false;
    L41:
        String r110 = "0";
        if (r18 == false) goto L44;
        String r20 = "1";
    L45:
        if (r10 <= 0) goto L47;
        r110 = "1";
    L47:
        OfficeInputParam r21 = r3.getInputParam();
        if (r21 == null) goto L50;
        r2 = r21.getEnterMethod();
    L50:
        String r111 = r2;
        long r24 = System.currentTimeMillis();
        OfficeInputParam r112 = r3.getInputParam();
        long r113 = 0;
        if (r112 == null) goto L53;
        long r114 = r112.getClickTimestamp();
    L54:
        Long r25 = Long.valueOf(r24 - r114);
        long r115 = System.currentTimeMillis();
        OfficeInputParam r26 = r3.getInputParam();
        if (r26 == null) goto L57;
        r113 = r26.getBeginLoadTimestamp();
    L57:
        Long r116 = Long.valueOf(r115 - r113);
        OfficeInputParam r27 = r3.getInputParam();
        if (r27 != null) goto L60;
    L62:
        r5 = 0;
    L63:
        OfficeTraceHelper.b(r12, r14, 10, r16, "0", r20, r110, r111, r25, r116, "exitWhileLoading", null, Integer.valueOf(r5), 2048);
        return;
    L60:
        if (r27.isFakeOfflineDoc() != true) goto L62;
    L53:
        r114 = 0;
        goto L54
    L44:
        r20 = "0";
        goto L45
    L38:
        if (r17.isColdStart() != true) goto L40;
        r18 = true;
        goto L41
    L34:
        r16 = null;
        goto L35
    L30:
        r14 = null;
        goto L31
    L26:
        r10 = 0;
        goto L27
    L23:
        r9 = null;
    L19:
        r8 = null;
        goto L21
    L66:
        return;
    L10:
        if (r4.getHasReportFinishEvent() == true) goto L12;
        r6 = true;
        goto L13
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_larus_doc_sdk_impl_v2_plugins_event_DocLoadEventPluginV2_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r2, int r3, Fragment r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r3) == false) goto L6;
        return r2;
    L6:
        return r2.replace(r3, r4);
    }
}
