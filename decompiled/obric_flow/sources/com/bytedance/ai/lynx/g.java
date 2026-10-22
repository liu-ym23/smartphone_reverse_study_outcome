package com.bytedance.ai.lynx;

import android.app.Application;
import android.net.Uri;
import com.bytedance.crash.Npth;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxLoadMode;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.l0;
import com.lynx.tasm.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends LynxView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f2183c;
    public Uri d;
    public com.bytedance.sdk.xbridge.cn.platform.lynx.a e;
    public l2.a f;

    public g(Application r5, String r10, String r11, l0 r12) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "containerId");
        Intrinsics.checkNotNullParameter(r11, "bid");
        Intrinsics.checkNotNullParameter(r12, "builder");
        super(r5, r12);
        this.f2181a = r10;
        this.f2182b = r11;
        c r13 = new c(this, r11);
        this.f2183c = r13;
        this.d = Uri.EMPTY;
        this.f = new l2.a();
        addLynxViewClient(r13);
    }

    private final void setNpthLastUrl(String r5) {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L9
        HashMap r11 = new HashMap();     // Catch: Throwable -> L9
        if (r5 == null) goto L11;
        List r12 = StringsKt.K(r5, new String[]{"?"}, 0, 6);     // Catch: Throwable -> L9
        if (r12 == null) goto L11;
        String r13 = (String) r12.get(0);     // Catch: Throwable -> L9
        if (r13 == null) goto L11;
    L12:
        r11.put("last_lynx_url", r13);     // Catch: Throwable -> L9
        r11.put(LynxEventReporter.PROP_NAME_LYNX_SDK_VERSION, LynxEnv.inst().getLynxVersion());     // Catch: Throwable -> L9
        Npth.addTags(r11);     // Catch: Throwable -> L9
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L11:
        r13 = "";
    L9:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }

    public final void b(String r11, TemplateBundle r12, TemplateData r13, t9.a r14) {
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, "templateBundle");
        Intrinsics.checkNotNullParameter(r13, "initData");
        Intrinsics.checkNotNullParameter(r14, "lifeCycle");
        Uri r5 = Uri.parse(r11);
        this.d = r5;
        String r10 = r5.getQueryParameter("forest_session_id");
        if (r10 != null) goto L5;
        r10 = this.f2181a;
    L5:
        c r15 = this.f2183c;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r15.e = r10;
        r15.f2176c = this.d;
        r15.d = r14;
        setNpthLastUrl(r11);
        x r16 = new x(r11, null, r12, r13, null, LynxLoadMode.f10003a, 4);
        k r17 = k.f2188a;
        TemplateData r18 = TemplateData.c(k.b(this.f2182b));
        Map r19 = k.a(getContext());
        if (r19 == null) goto L11;
        Iterator r110 = r19.entrySet().iterator();
    L9:
        if (r110.hasNext() == false) goto L11;
        Map.Entry r111 = (Map.Entry) r110.next();
        r18.i((String) r111.getKey(), r111.getValue());
    L11:
        r18.i("__AI_SDK_VERSION__", "0.90.0-rc.37-miniapp");
        r18.e = true;
        updateGlobalProps(r18);
        loadTemplate(r16);
    }

    @Override // com.lynx.tasm.LynxView
    public final void destroy() {
        qo.a.g(this);
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r5 = this.e;
        Intrinsics.checkNotNullParameter(this.f2182b, "bid");
        if (r5 == null) goto L9;
        com.bytedance.sdk.xbridge.cn.platform.lynx.c r10 = r5.t();
        if (r10 == null) goto L9;
        rb.b r11 = (rb.b) r10.a(rb.b.class);
        if (r11 == null) goto L9;
        r11.f21717a.clear();
    L9:
        removeLynxViewClient(this.f2183c);
        setAsyncImageInterceptor(null);
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r12 = this.e;
        if (r12 == null) goto L12;
        r12.r();
    L12:
        super.destroy();
    }

    public final l2.a getLynxRemoteBridgeMessages() {
        return this.f;
    }

    public final Uri getOriginalUri$ai_sdk_release() {
        return this.d;
    }

    public final f getTouchEventCallback() {
        return null;
    }

    @Override // com.lynx.tasm.LynxView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        t9.a r5 = this.f2183c.d;
    }

    public final void setLynxRemoteBridgeMessages(l2.a r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f = r5;
    }

    public final void setReused(boolean r5) {
    }

    public final void setTouchEventCallback(f r5) {
    }

    @Override // com.lynx.tasm.LynxView
    public final void updateData(TemplateData r5) {
        Intrinsics.checkNotNullParameter(r5, "initData");
        r5.e = true;
        super.updateData(r5);
    }
}
