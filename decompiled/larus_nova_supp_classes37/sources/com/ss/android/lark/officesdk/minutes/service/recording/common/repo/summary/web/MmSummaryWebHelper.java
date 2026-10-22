package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmAISummaryLayoutData;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmRecordingSummaryRepo$opt$2$1$initWebHelper$1;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.bridge.Message;
import com.ss.android.lark.utils.e0;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmSummaryWebHelper {
    public final CoroutineScope a;
    public final a b;
    public final Function0<MmRecordingUILaunchMode> c;
    public final String d;
    public OfficeWebView e;
    public MutableContextWrapper f;
    public boolean g;
    public boolean h;
    public String i;
    public MmAISummaryLayoutData j;
    public Context k;
    public Boolean l;
    public boolean m;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.e n;

    public interface a {
        com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy.a a();

        void b(String r1, JSONObject r2);

        void c();

        void d();

        boolean e(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.d r1);

        void f();

        void g();

        com.ss.android.lark.officesdk.minutes.service.foundation.feature.a getFeatureService();

        com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.b getSettingsService();

        void j();
    }

    public final void b() {
        lvb.a.e(this.d, "[destroyWebView]");
        OfficeWebView r0 = this.e;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        ((ConcurrentHashMap) r0.getBridge().b.a).clear();
        r0.stopLoading();
        r0.getSettings().setJavaScriptEnabled(false);
        r0.clearHistory();
        r0.clearView();
        r0.removeAllViews();
        r0.destroy();
    L5:
        this.e = null;
        this.f = null;
        this.k = null;
        this.g = false;
        this.h = false;
        this.i = "";
        this.j = null;
        this.l = null;
        this.m = false;
    }

    public final OfficeWebView c(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        if (this.e == null) goto L6;
        lvb.a.e(this.d, "[initWebView] reuse existing webView");
        e(r6, "initWebView");
        OfficeWebView r7 = this.e;
        Intrinsics.checkNotNull(r7);
        return r7;
    L6:
        lvb.a.e(this.d, "[initWebView] create new webView");
        MutableContextWrapper r0 = new MutableContextWrapper(r6.getApplicationContext());
        r0.setBaseContext(r6);
        this.f = r0;
        this.k = r6;
        OfficeWebView r1 = new OfficeWebView(r0, null, 6);
        r1.setHorizontalScrollBarEnabled(false);
        r1.setVerticalScrollBarEnabled(false);
        r1.getSettings().setAllowFileAccess(true);
        r1.getSettings().setJavaScriptEnabled(true);
        r1.getSettings().setSupportZoom(false);
        r1.getSettings().setNeedInitialFocus(false);
        r1.setOverScrollMode(2);
        r1.setLayerType(2, null);
        int r2 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.b.a;
        r1.setBackgroundColor(UIUtils.getColor(r6, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.b.a((MmRecordingUILaunchMode) this.c.invoke())));
        if (DevEnvUtil.isDebugMode(r6) == false) goto L9;
        WebView.setWebContentsDebuggingEnabled(true);
    L9:
        xwb.a r8 = r1.getBridge();
        r8.b("common.ready", new e(this));
        r8.b("common.fishBoneContentUpdate", new f(this));
        r8.b("common.markFishBone", new g(this));
        r8.b("common.vibrate", new h(this));
        r8.b("common.showToast", new i(this));
        r8.b("common.log", new j(this));
        r8.b("common.sendTrackEvent", new k(this));
        r8.b("common.getSettings", new l(this));
        r8.b("common.getFG", new c(this));
        r8.b("common.networkProxy", new d(this));
        r1.setWebViewClient(new m(this, this.n));
        this.e = r1;
        this.g = false;
        this.h = false;
        return r1;
    }

    public final void d(String r6) {
        Intrinsics.checkNotNullParameter(r6, "url");
        if (TextUtils.isEmpty(r6) == false) goto L5;
    L28:
        lvb.a.b(this.d, "[loadUrl] url is empty or webView is null, url=" + r6);
        return;
    L5:
        if (this.e == null) goto L28;
        if (Intrinsics.areEqual(r6, this.i) == true) goto L10;
    L13:
        this.i = r6;
        this.g = false;
        this.h = false;
        yub.d r1 = yub.d.a;
        Context r2 = com.ss.android.lark.appcontext.applifecycle2.api.a.a();
        if (r2 != null) goto L16;
        LarkAppContext.Companion.getClass();
        r2 = LarkAppContext.access$getInstance$cp().getContext();
    L16:
        boolean r3 = h18.f.a(r2);
        this.l = Boolean.valueOf(r3);
        if (r3 == false) goto L19;
        String r4 = "dark";
    L20:
        String r5 = "theme=".concat(r4);
        if (StringsKt.contains$default(r6, "?", false, 2, null) == false) goto L23;
        StringBuilder r0 = new StringBuilder();
        r0.append(r6);
        char r7 = '&';
    L24:
        r0.append(r7);
        r0.append(r5);
        String r8 = r0.toString();
        lvb.a.e(this.d, "[loadUrl] url=" + r8);
        OfficeWebView r9 = this.e;
        if (r9 == null) goto L30;
        r9.loadUrl(r8);
        return;
    L30:
        return;
    L23:
        r0 = new StringBuilder();
        r0.append(r6);
        r7 = '?';
        goto L24
    L19:
        r4 = "light";
        goto L20
    L10:
        if (this.g == false) goto L13;
        lvb.a.e(this.d, "[loadUrl] skip, same url and web is ready");
    }

    public final void f(MmAISummaryLayoutData r5) {
        Intrinsics.checkNotNullParameter(r5, "fishBoneData");
        this.j = r5;
        if (this.g == true) goto L6;
        lvb.a.e(this.d, "[updateFishBoneData] web not ready, cache pending data, timestamp=" + r5.getTimeStamp());
        return;
    L6:
        lvb.a.e(this.d, "[updateFishBoneData] send data to web, timestamp=" + r5.getTimeStamp());
        int r0 = b.a;
        b.b(this.e, r5);
    }

    public final void e(Context r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "newContext");
        Intrinsics.checkNotNullParameter(r5, "from");
        if (Intrinsics.areEqual(this.k, r4) == false) goto L6;
        lvb.a.a(this.d, "[updateContext] skip, same context. from=" + r5);
        return;
    L6:
        lvb.a.e(this.d, "[updateContext] newContext=" + r4 + ", from=" + r5);
        this.k = r4;
        MutableContextWrapper r6 = this.f;
        if (r6 == null) goto L10;
        r6.setBaseContext(r4);
        return;
    }

    public MmSummaryWebHelper(CoroutineScope r9, MmRecordingSummaryRepo$opt$2$1$initWebHelper$1 r10, Function0 r11) {
        Intrinsics.checkNotNullParameter(r9, "scope");
        Intrinsics.checkNotNullParameter(r10, "callback");
        Intrinsics.checkNotNullParameter(r11, "uiLaunchModeProvider");
        this.a = r9;
        this.b = r10;
        this.c = r11;
        this.d = "MmSummaryWebHelper";
        this.i = "";
        this.n = new com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.e(new com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.e.b("summary", 5, new MmSummaryWebHelper$renderGoneHandler$1(this), new MmSummaryWebHelper$renderGoneHandler$2(this), new MmSummaryWebHelper$renderGoneHandler$3(this), new MmSummaryWebHelper$renderGoneHandler$4(this), new MmSummaryWebHelper$renderGoneHandler$5(this)));
    }

    public final void a(final String r11, final int r12, final int r13, final Function1<? super Boolean, Unit> r14) {
        Intrinsics.checkNotNullParameter(r11, "direction");
        Intrinsics.checkNotNullParameter(r14, "callback");
        OfficeWebView r2 = this.e;
        if (r2 != null) goto L7;
        lvb.a.h(this.d, "[canScroll] webView is null, direction=" + r11 + ", x=" + r12 + ", y=" + r13);
        r14.invoke(Boolean.FALSE);
        return;
    L7:
        if (this.g == true) goto L10;
        lvb.a.h(this.d, "[canScroll] web not ready, direction=" + r11 + ", x=" + r12 + ", y=" + r13);
        r14.invoke(Boolean.FALSE);
        return;
    L10:
        int r3 = b.a;
        Function1<Boolean, Unit> r4 = new MmSummaryWebHelper$canScroll$1(this, r11, r12, r13, r14);
        Intrinsics.checkNotNullParameter(r11, "direction");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Message r15 = new Message();
        r15.setCallbackID("common.checkCanScroll");
        JSONObject r1 = new JSONObject();
        r1.put("x", r12);
        r1.put("y", r13);
        r1.put("direction", r11);
        r15.setData(r1.toString());
        StringCompanionObject r16 = StringCompanionObject.INSTANCE;
        String r17 = String.format("LarkWebViewJavaScriptBridge.nativeCallBack(%s);", Arrays.copyOf(new Object[]{e0.c(r15)}, 1));
        lvb.a.a("MmSummaryNativeToJSHelper", "[checkFishBoneCanScroll] script=" + r17);
        r2.evaluateJavascript(r17, new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web.a(r4));
    }
}
