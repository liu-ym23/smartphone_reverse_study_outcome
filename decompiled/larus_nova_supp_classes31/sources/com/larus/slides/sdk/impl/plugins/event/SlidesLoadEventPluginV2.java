package com.larus.slides.sdk.impl.plugins.event;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.office.OfficeInputParam;
import com.larus.office.base.plugins.statistics.OfficeTraceHelper;
import com.larus.office.w;
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
import com.tencent.open.log.TraceLevel;
import fo9.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001c\u001d\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J \u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\rH\u0016J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\u001c\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/slides/sdk/impl/plugins/event/SlidesLoadEventPluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "mLoadingView", "Lcom/larus/office/base/page/IHostLoadingAndErrorLayout;", "hasReportFinishEvent", "", "getPluginId", "", "getBridgeHandlers", "", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromHost", "updateCache", "onDetachFromUIContainer", "onClickFailedRetry", "errCode", "", "replaceDocumentFragment", "Companion", "ShowLoadingHandler", "EventHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SlidesLoadEventPluginV2 extends OfficeDocumentPlugin {
    private static final String BIZ_HIDE_LOADING = "biz.util.hideLoading";
    private static final String BIZ_NOTIFY_EVENT = "biz.notify.event";
    private static final String BIZ_SHOW_LOADING = "biz.util.showLoading";
    public static final a Companion = null;
    private static final int ERRCODE_DOCX_NEED_UPGRADE = 700;
    private static final int ERR_DELETED = -55;
    private static final String EVENT_DELETE = "NOTE_DELETED";
    private static final String EVENT_DOCX_UPGRADE = "DOCX_UPGRADE";
    private static final String EVENT_EDIT = "EDIT";
    private static final String EVENT_NOT_FOUND = "NOTE_NOT_FOUND";
    private static final String EVENT_VIEW = "VIEW";
    private static final String TAG = "SlidesLoadEventPluginV2";
    private boolean hasReportFinishEvent;
    private vm9.b mLoadingView;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<EventModel> {
        public final /* synthetic */ SlidesLoadEventPluginV2 a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(SlidesLoadEventPluginV2 r1) {
            this.a = r1;
        }

        public final void handle(Object r21, m r22) {
            EventModel r1 = (EventModel) r21;
            FLogger r2 = FLogger.a;
            StringBuilder r3 = new StringBuilder("EventHandler: ");
            String r4 = null;
            if (r1 == null) goto L5;
            String r5 = r1.getEvent();
        L6:
            r3.append(r5);
            r2.i(SlidesLoadEventPluginV2.TAG, r3.toString());
            if (r1 == null) goto L9;
            String r6 = r1.getEvent();
        L11:
            if (Intrinsics.areEqual(r6, SlidesLoadEventPluginV2.EVENT_EDIT) == true) goto L116;
            if (r1 == null) goto L14;
            String r7 = r1.getEvent();
        L16:
            if (Intrinsics.areEqual(r7, SlidesLoadEventPluginV2.EVENT_VIEW) == true) goto L119;
            if (r1 == null) goto L20;
            String r8 = r1.getEvent();
        L22:
            if (r8 == null) goto L41;
            int r9 = r8.hashCode();
            if (r9 == (-1911183619)) goto L38;
            if (r9 == (-131073335)) goto L34;
            if (r9 != 2097412268) goto L41;
            if (r8.equals(SlidesLoadEventPluginV2.EVENT_DELETE) == false) goto L41;
        L36:
            int r10 = SlidesLoadEventPluginV2.ERR_DELETED;
        L42:
            vm9.b r11 = SlidesLoadEventPluginV2.access$getMLoadingView$p(this.a);
            if (r11 == null) goto L48;
            if (r1 == null) goto L46;
            String r12 = r1.getMessage();
        L47:
            r11.a(r10, r12);
            goto L48
        L46:
            r12 = null;
        L48:
            vm9.c r13 = ex9.e.b();
            if (r13 == null) goto L51;
            r13.onLoadFailed(r10);
        L51:
            if (r10 != SlidesLoadEventPluginV2.ERR_DELETED) goto L53;
            String r14 = "deleted";
        L54:
            String r16 = r14;
            if (SlidesLoadEventPluginV2.access$getHasReportFinishEvent$p(this.a) == true) goto L117;
            OfficeInputParam r15 = ex9.e.b;
            boolean r17 = true;
            if (r15 != null) goto L59;
        L61:
            boolean r18 = false;
        L62:
            if (r18 == false) goto L118;
            SlidesLoadEventPluginV2.access$setHasReportFinishEvent$p(this.a, true);
            r2.i(SlidesLoadEventPluginV2.TAG, "reportDocLaunchResult: onLoadFail");
            vm9.c r19 = ex9.e.b();
            if (r19 == null) goto L66;
            r19.notifyHasReportLoadResultEvent();
        L66:
            ChameleonPluginHost r20 = this.a.getHost();
            if (r20 == null) goto L71;
            k r23 = r20.getWeb();
            if (r23 == null) goto L71;
            WebView r24 = r23.getWebView();
        L73:
            if ((r24 instanceof ChameleonWebView) == false) goto L75;
            ChameleonWebView r25 = (ChameleonWebView) r24;
        L76:
            if (r25 == null) goto L78;
            int r26 = r25.getUsedCount();
        L79:
            int r27 = OfficeTraceHelper.a;
            String r28 = OfficeTraceHelper.DOC_TYPE.SLIDES.getType();
            OfficeInputParam r29 = ex9.e.b;
            if (r29 == null) goto L82;
            String r30 = r29.getSlidesToken();
        L83:
            OfficeInputParam r31 = ex9.e.b;
            if (r31 == null) goto L86;
            Integer r32 = Integer.valueOf(r31.getResourceType());
        L87:
            OfficeInputParam r33 = ex9.e.b;
            if (r33 == null) goto L90;
            String r34 = r33.getConversationId();
        L91:
            OfficeInputParam r110 = ex9.e.b;
            if (r110 != null) goto L94;
        L96:
            r17 = false;
        L98:
            if (r17 == false) goto L100;
            String r111 = "1";
        L101:
            if (r26 <= 0) goto L103;
            String r35 = "1";
        L104:
            OfficeInputParam r36 = ex9.e.b;
            if (r36 == null) goto L107;
            r4 = r36.getEnterMethod();
        L107:
            String r112 = r4;
            long r37 = System.currentTimeMillis();
            OfficeInputParam r38 = ex9.e.b;
            long r113 = 0;
            if (r38 == null) goto L110;
            long r114 = r38.getClickTimestamp();
        L111:
            Long r39 = Long.valueOf(r37 - r114);
            long r40 = System.currentTimeMillis();
            OfficeInputParam r115 = ex9.e.b;
            if (r115 == null) goto L114;
            r113 = r115.getBeginLoadTimestamp();
        L114:
            String r41 = r30;
            String r116 = r111;
            String r117 = r35;
            OfficeTraceHelper.b(r28, r41, r32, r34, "0", r116, r117, r112, r39, Long.valueOf(r40 - r113), r16, "Error: " + r10, null, 4096);
            return;
        L110:
            r114 = 0;
            goto L111
        L103:
            r35 = "0";
            goto L104
        L100:
            r111 = "0";
            goto L101
        L94:
            if (r110.isColdStart() != true) goto L96;
        L90:
            r34 = null;
            goto L91
        L86:
            r32 = null;
            goto L87
        L82:
            r30 = null;
            goto L83
        L78:
            r26 = 0;
            goto L79
        L75:
            r25 = null;
        L71:
            r24 = null;
            goto L73
        L118:
            return;
        L59:
            if (r15.getHasReportFinishEvent() == true) goto L61;
            r18 = true;
            goto L62
        L117:
            return;
        L53:
            r14 = "other";
            goto L54
        L34:
            if (r8.equals(SlidesLoadEventPluginV2.EVENT_NOT_FOUND) == true) goto L36;
        L38:
            if (r8.equals(SlidesLoadEventPluginV2.EVENT_DOCX_UPGRADE) == false) goto L41;
            r10 = SlidesLoadEventPluginV2.ERRCODE_DOCX_NEED_UPGRADE;
        L41:
            r10 = 999;
            goto L42
        L20:
            r8 = null;
            goto L22
        L119:
            return;
        L14:
            r7 = null;
            goto L16
        L116:
            return;
        L9:
            r6 = null;
            goto L11
        L5:
            r5 = null;
            goto L6
        }
    }

    public final class c implements i<Object> {
        public final /* synthetic */ SlidesLoadEventPluginV2 a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public c(SlidesLoadEventPluginV2 r1) {
            this.a = r1;
        }

        public final void handle(Object r2, m r3) {
            FLogger.a.i(SlidesLoadEventPluginV2.TAG, "handle showLoading loadingView=" + SlidesLoadEventPluginV2.access$getMLoadingView$p(this.a));
            t r4 = SlidesLoadEventPluginV2.access$getUIContainer(this.a);
            if (r4 == null) goto L9;
            View r5 = r4.getContentView();
            if (r5 == null) goto L9;
            View r6 = r5.findViewById(2131367051);
            if (r6 == null) goto L9;
            e1.x(r6);
        L9:
            vm9.b r7 = SlidesLoadEventPluginV2.access$getMLoadingView$p(this.a);
            if (r7 == null) goto L13;
            r7.b();
            return;
        }
    }

    public static final class d implements x2.b {
        public final /* synthetic */ SlidesLoadEventPluginV2 a;
        public final /* synthetic */ ChameleonPluginHost b;

        public final /* synthetic */ void onLoadCancel() {
        }

        public final /* synthetic */ void onSSRLoadSuccess() {
        }

        public final void onLoadStart() {
            if (SlidesLoadEventPluginV2.access$getMLoadingView$p(this.a) != null) goto L9;
            SlidesLoadEventPluginV2 r0 = this.a;
            vm9.c r1 = ex9.e.b();
            if (r1 == null) goto L7;
            vm9.b r2 = r1.getLoadingView();
        L8:
            SlidesLoadEventPluginV2.access$setMLoadingView$p(r0, r2);
            goto L9
        L7:
            r2 = null;
        L9:
            FLogger.a.i(SlidesLoadEventPluginV2.TAG, "Begin loading loadingView: " + SlidesLoadEventPluginV2.access$getMLoadingView$p(this.a));
            vm9.b r3 = SlidesLoadEventPluginV2.access$getMLoadingView$p(this.a);
            if (r3 == null) goto L13;
            r3.b();
            return;
        }

        public final void onLoadSuccess() {
            FLogger r1 = FLogger.a;
            r1.i(SlidesLoadEventPluginV2.TAG, "load success, hide loading loadingView: " + SlidesLoadEventPluginV2.access$getMLoadingView$p(this.a));
            OfficeInputParam r2 = ex9.e.b;
            if (r2 == null) goto L5;
            r2.setLoadSuccessTimestamp(System.currentTimeMillis());
        L5:
            vm9.b r3 = SlidesLoadEventPluginV2.access$getMLoadingView$p(this.a);
            if (r3 == null) goto L8;
            r3.hide();
        L8:
            t r4 = SlidesLoadEventPluginV2.access$getUIContainer(this.a);
            if (r4 == null) goto L15;
            View r5 = r4.getContentView();
            if (r5 == null) goto L15;
            View r6 = r5.findViewById(2131367051);
            if (r6 == null) goto L15;
            e1.o(r6);
        L15:
            ChameleonPluginHost r7 = this.b;
            boolean r8 = true;
            if (r7 == null) goto L22;
            k r9 = r7.getWeb();
            if (r9 == null) goto L22;
            WebView r10 = r9.getWebView();
            if (r10 == null) goto L22;
            r10.setLayerType(2, new Paint(1));
        L22:
            ex9.e.a().a();
            if (SlidesLoadEventPluginV2.access$getHasReportFinishEvent$p(this.a) == true) goto L84;
            OfficeInputParam r11 = ex9.e.b;
            if (r11 != null) goto L27;
        L29:
            boolean r12 = false;
        L30:
            if (r12 == false) goto L85;
            SlidesLoadEventPluginV2.access$setHasReportFinishEvent$p(this.a, true);
            vm9.c r13 = ex9.e.b();
            if (r13 == null) goto L34;
            r13.notifyHasReportLoadResultEvent();
        L34:
            r1.i(SlidesLoadEventPluginV2.TAG, "reportDocLaunchResult: onLoadSuccess hide loading");
            ChameleonPluginHost r14 = this.b;
            String r15 = null;
            if (r14 == null) goto L39;
            k r16 = r14.getWeb();
            if (r16 == null) goto L39;
            WebView r17 = r16.getWebView();
        L41:
            if ((r17 instanceof ChameleonWebView) == false) goto L43;
            ChameleonWebView r18 = (ChameleonWebView) r17;
        L44:
            if (r18 == null) goto L46;
            int r19 = r18.getUsedCount();
        L47:
            int r20 = OfficeTraceHelper.a;
            String r21 = OfficeTraceHelper.DOC_TYPE.SLIDES.getType();
            OfficeInputParam r22 = ex9.e.b;
            if (r22 == null) goto L50;
            String r23 = r22.getSlidesToken();
        L51:
            OfficeInputParam r24 = ex9.e.b;
            if (r24 == null) goto L54;
            Integer r25 = Integer.valueOf(r24.getResourceType());
        L55:
            OfficeInputParam r26 = ex9.e.b;
            if (r26 == null) goto L58;
            String r27 = r26.getConversationId();
        L59:
            OfficeInputParam r28 = ex9.e.b;
            if (r28 != null) goto L62;
        L64:
            r8 = false;
        L66:
            if (r8 == false) goto L68;
            String r110 = "1";
        L69:
            if (r19 <= 0) goto L71;
            String r111 = "1";
        L72:
            OfficeInputParam r29 = ex9.e.b;
            if (r29 == null) goto L75;
            r15 = r29.getEnterMethod();
        L75:
            String r112 = r15;
            long r30 = System.currentTimeMillis();
            OfficeInputParam r31 = ex9.e.b;
            long r32 = 0;
            if (r31 == null) goto L78;
            long r113 = r31.getClickTimestamp();
        L79:
            Long r114 = Long.valueOf(r30 - r113);
            long r33 = System.currentTimeMillis();
            OfficeInputParam r34 = ex9.e.b;
            if (r34 == null) goto L82;
            r32 = r34.getBeginLoadTimestamp();
        L82:
            OfficeTraceHelper.b(r21, r23, r25, r27, "1", r110, r111, r112, r114, Long.valueOf(r33 - r32), null, null, null, 7168);
            return;
        L78:
            r113 = 0;
            goto L79
        L71:
            r111 = "0";
            goto L72
        L68:
            r110 = "0";
            goto L69
        L62:
            if (r28.isColdStart() != true) goto L64;
        L58:
            r27 = null;
            goto L59
        L54:
            r25 = null;
            goto L55
        L50:
            r23 = null;
            goto L51
        L46:
            r19 = 0;
            goto L47
        L43:
            r18 = null;
        L39:
            r17 = null;
            goto L41
        L85:
            return;
        L27:
            if (r11.getHasReportFinishEvent() == true) goto L29;
            r12 = true;
            goto L30
        }

        public d(SlidesLoadEventPluginV2 r1, ChameleonPluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onLoadFail(int r21, Throwable r22) {
            FLogger r2 = FLogger.a;
            StringBuilder r3 = new StringBuilder("load failed, code: ");
            r3.append(r21);
            r3.append(", e: ");
            String r4 = null;
            if (r22 == null) goto L5;
            String r5 = r22.getMessage();
        L6:
            r3.append(r5);
            r2.i(SlidesLoadEventPluginV2.TAG, r3.toString());
            t r6 = SlidesLoadEventPluginV2.access$getUIContainer(this.a);
            if (r6 == null) goto L13;
            View r7 = r6.getContentView();
            if (r7 == null) goto L13;
            View r8 = r7.findViewById(2131367051);
            if (r8 == null) goto L13;
            e1.x(r8);
        L13:
            vm9.b r9 = SlidesLoadEventPluginV2.access$getMLoadingView$p(this.a);
            if (r9 == null) goto L16;
            r9.a(r21, "");
        L16:
            vm9.c r10 = ex9.e.b();
            if (r10 == null) goto L20;
            r10.onLoadFailed(r21);
        L20:
            if (r21 != SlidesLoadEventPluginV2.ERR_DELETED) goto L22;
            String r11 = "deleted";
        L23:
            String r16 = r11;
            if (SlidesLoadEventPluginV2.access$getHasReportFinishEvent$p(this.a) == true) goto L85;
            OfficeInputParam r12 = ex9.e.b;
            boolean r13 = true;
            if (r12 != null) goto L28;
        L30:
            boolean r14 = false;
        L31:
            if (r14 == false) goto L86;
            SlidesLoadEventPluginV2.access$setHasReportFinishEvent$p(this.a, true);
            r2.i(SlidesLoadEventPluginV2.TAG, "reportSlidesLaunchResult: onLoadFail");
            vm9.c r15 = ex9.e.b();
            if (r15 == null) goto L35;
            r15.notifyHasReportLoadResultEvent();
        L35:
            ChameleonPluginHost r17 = this.b;
            if (r17 == null) goto L40;
            k r18 = r17.getWeb();
            if (r18 == null) goto L40;
            WebView r19 = r18.getWebView();
        L42:
            if ((r19 instanceof ChameleonWebView) == false) goto L44;
            ChameleonWebView r20 = (ChameleonWebView) r19;
        L45:
            if (r20 == null) goto L47;
            int r23 = r20.getUsedCount();
        L48:
            int r24 = OfficeTraceHelper.a;
            String r25 = OfficeTraceHelper.DOC_TYPE.SLIDES.getType();
            OfficeInputParam r26 = ex9.e.b;
            if (r26 == null) goto L51;
            String r27 = r26.getSlidesToken();
        L52:
            OfficeInputParam r28 = ex9.e.b;
            if (r28 == null) goto L55;
            Integer r29 = Integer.valueOf(r28.getResourceType());
        L56:
            OfficeInputParam r30 = ex9.e.b;
            if (r30 == null) goto L59;
            String r31 = r30.getConversationId();
        L60:
            OfficeInputParam r110 = ex9.e.b;
            if (r110 != null) goto L63;
        L65:
            r13 = false;
        L67:
            if (r13 == false) goto L69;
            String r111 = "1";
        L70:
            if (r23 <= 0) goto L72;
            String r32 = "1";
        L73:
            OfficeInputParam r33 = ex9.e.b;
            if (r33 == null) goto L76;
            r4 = r33.getEnterMethod();
        L76:
            String r112 = r4;
            long r34 = System.currentTimeMillis();
            OfficeInputParam r35 = ex9.e.b;
            long r113 = 0;
            if (r35 == null) goto L79;
            long r114 = r35.getClickTimestamp();
        L80:
            Long r36 = Long.valueOf(r34 - r114);
            long r37 = System.currentTimeMillis();
            OfficeInputParam r115 = ex9.e.b;
            if (r115 == null) goto L83;
            r113 = r115.getBeginLoadTimestamp();
        L83:
            String r38 = r27;
            String r116 = r111;
            String r117 = r32;
            OfficeTraceHelper.b(r25, r38, r29, r31, "0", r116, r117, r112, r36, Long.valueOf(r37 - r113), r16, "Error: " + r21, null, 4096);
            return;
        L79:
            r114 = 0;
            goto L80
        L72:
            r32 = "0";
            goto L73
        L69:
            r111 = "0";
            goto L70
        L63:
            if (r110.isColdStart() != true) goto L65;
        L59:
            r31 = null;
            goto L60
        L55:
            r29 = null;
            goto L56
        L51:
            r27 = null;
            goto L52
        L47:
            r23 = 0;
            goto L48
        L44:
            r20 = null;
        L40:
            r19 = null;
            goto L42
        L86:
            return;
        L28:
            if (r12.getHasReportFinishEvent() == true) goto L30;
            r14 = true;
            goto L31
        L85:
            return;
        L22:
            r11 = "other";
            goto L23
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class e implements vm9.e {
        public final /* synthetic */ SlidesLoadEventPluginV2 a;

        public e(SlidesLoadEventPluginV2 r1) {
            this.a = r1;
        }

        public final void onFailedRetry(int r4) {
            FLogger.a.e(SlidesLoadEventPluginV2.TAG, "Retry load document, errorCode: " + r4);
            SlidesLoadEventPluginV2.access$onClickFailedRetry(this.a, r4);
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void replaceDocumentFragment() {
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
        INVOKEVIRTUAL_com_larus_slides_sdk_impl_plugins_event_SlidesLoadEventPluginV2_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(r1.beginTransaction(), r2.getId(), r15).commitAllowingStateLoss();
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

    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.slides.sdk.impl.plugins.event.SlidesLoadEventPluginV2$updateCache$1] */
    private final void updateCache() {
        OfficeInputParam r0 = ex9.e.b;
        if (r0 == null) goto L6;
        final String r1 = r0.getSlidesToken();
        if (r1 == null) goto L6;
    L7:
        com.larus.slides.sdk.impl.utils.b r2 = new com.larus.slides.sdk.impl.utils.b();
        Intrinsics.checkNotNullParameter("id", "name");
        Intrinsics.checkNotNullParameter(r1, "value");
        r2.a.put("id", r1);
        Intrinsics.checkNotNullParameter("mode", "name");
        r2.a.put("mode", String.valueOf(0));
        Intrinsics.checkNotNullParameter("tns_filter", "name");
        Intrinsics.checkNotNullParameter("CLIENT_VARS", "value");
        r2.a.put("tns_filter", "CLIENT_VARS");
        com.larus.slides.sdk.impl.utils.c.b(r2.a(), new AnonymousClass1(r1));
        return;
    L6:
        r1 = "";
        goto L7
    }

    public String getPluginId() {
        return ChameleonPluginId.LoadingPlugin.getValue();
    }

    public SlidesLoadEventPluginV2() {
    }

    public static final /* synthetic */ boolean access$getHasReportFinishEvent$p(SlidesLoadEventPluginV2 r0) {
        return r0.hasReportFinishEvent;
    }

    public static final /* synthetic */ vm9.b access$getMLoadingView$p(SlidesLoadEventPluginV2 r0) {
        return r0.mLoadingView;
    }

    public static final /* synthetic */ t access$getUIContainer(SlidesLoadEventPluginV2 r0) {
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
        r3.put(BIZ_SHOW_LOADING, new c(this));
        r3.put(BIZ_NOTIFY_EVENT, new b(this));
    }

    public void onAttachToHost(ChameleonPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        x2 r0 = getDocumentLoader();
        if (r0 == null) goto L6;
        r0.S3(new d(this, r3));
        return;
    }

    public void onDetachFromHost(ChameleonPluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r1);
        updateCache();
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    public static final /* synthetic */ void access$onClickFailedRetry(SlidesLoadEventPluginV2 r0, int r1) {
        r0.onClickFailedRetry(r1);
    }

    public static final /* synthetic */ void access$setHasReportFinishEvent$p(SlidesLoadEventPluginV2 r0, boolean r1) {
        r0.hasReportFinishEvent = r1;
    }

    public static final /* synthetic */ void access$setMLoadingView$p(SlidesLoadEventPluginV2 r0, vm9.b r1) {
        r0.mLoadingView = r1;
    }

    public void onAttachToUIContainer(ChameleonPluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r2, r3);
        vm9.c r4 = ex9.e.b();
        if (r4 == null) goto L5;
        vm9.b r5 = r4.getLoadingView();
    L6:
        this.mLoadingView = r5;
        if (r5 == null) goto L10;
        r5.setOnRetryListener(new e(this));
        return;
    L10:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r21, t r22) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r21, r22);
        String r1 = null;
        this.mLoadingView = null;
        if (this.hasReportFinishEvent == true) goto L64;
        OfficeInputParam r2 = ex9.e.b;
        boolean r3 = true;
        if (r2 != null) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L65;
        this.hasReportFinishEvent = true;
        vm9.c r5 = ex9.e.b();
        if (r5 == null) goto L14;
        r5.notifyHasReportLoadResultEvent();
    L14:
        FLogger.a.i(TAG, "reportSlidesLaunchResult: onDetachFromUIContainer");
        if (r21 == null) goto L19;
        k r6 = r21.getWeb();
        if (r6 == null) goto L19;
        WebView r7 = r6.getWebView();
    L21:
        if ((r7 instanceof ChameleonWebView) == false) goto L23;
        ChameleonWebView r8 = (ChameleonWebView) r7;
    L24:
        if (r8 == null) goto L26;
        int r9 = r8.getUsedCount();
    L27:
        int r10 = OfficeTraceHelper.a;
        String r11 = OfficeTraceHelper.DOC_TYPE.SLIDES.getType();
        OfficeInputParam r12 = ex9.e.b;
        if (r12 == null) goto L30;
        String r13 = r12.getSlidesToken();
    L31:
        OfficeInputParam r14 = ex9.e.b;
        if (r14 == null) goto L34;
        Integer r15 = Integer.valueOf(r14.getResourceType());
    L35:
        OfficeInputParam r16 = ex9.e.b;
        if (r16 == null) goto L38;
        String r17 = r16.getConversationId();
    L39:
        OfficeInputParam r18 = ex9.e.b;
        if (r18 != null) goto L42;
    L44:
        r3 = false;
    L46:
        if (r3 == false) goto L48;
        String r19 = "1";
    L49:
        if (r9 <= 0) goto L51;
        String r110 = "1";
    L52:
        OfficeInputParam r20 = ex9.e.b;
        if (r20 == null) goto L55;
        r1 = r20.getEnterMethod();
    L55:
        String r111 = r1;
        long r23 = System.currentTimeMillis();
        OfficeInputParam r24 = ex9.e.b;
        long r25 = 0;
        if (r24 == null) goto L58;
        long r112 = r24.getClickTimestamp();
    L59:
        Long r113 = Long.valueOf(r23 - r112);
        long r26 = System.currentTimeMillis();
        OfficeInputParam r27 = ex9.e.b;
        if (r27 == null) goto L62;
        r25 = r27.getBeginLoadTimestamp();
    L62:
        OfficeTraceHelper.b(r11, r13, r15, r17, "0", r19, r110, r111, r113, Long.valueOf(r26 - r25), "exitWhileLoading", null, null, 6144);
        return;
    L58:
        r112 = 0;
        goto L59
    L51:
        r110 = "0";
        goto L52
    L48:
        r19 = "0";
        goto L49
    L42:
        if (r18.isColdStart() != true) goto L44;
    L38:
        r17 = null;
        goto L39
    L34:
        r15 = null;
        goto L35
    L30:
        r13 = null;
        goto L31
    L26:
        r9 = 0;
        goto L27
    L23:
        r8 = null;
    L19:
        r7 = null;
        goto L21
    L65:
        return;
    L7:
        if (r2.getHasReportFinishEvent() == true) goto L9;
        r4 = true;
        goto L10
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_larus_slides_sdk_impl_plugins_event_SlidesLoadEventPluginV2_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r2, int r3, Fragment r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r3) == false) goto L6;
        return r2;
    L6:
        return r2.replace(r3, r4);
    }
}
