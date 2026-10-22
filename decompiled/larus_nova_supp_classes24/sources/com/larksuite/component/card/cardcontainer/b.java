package com.larksuite.component.card.cardcontainer;

import android.text.TextUtils;
import com.larksuite.component.card.monitor.UniversalCardMonitorUtils;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.context.action.CardActionService;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.q1;
import com.lynx.tasm.v0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import fyb.e;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends q1 {
    public CardContext a;
    public long b;
    public long c;
    public long d;
    public String e;
    public String f;
    public String g;

    public static final class a {
    }

    static {
    }

    public b() {
        this.e = "";
    }

    public final void onFirstScreen() {
        super.onFirstScreen();
        Log.i("UniversalCardLynxClient", hashCode() + " onFirstScreen");
    }

    public final void onLoadSuccess() {
        super.onLoadSuccess();
        this.d = System.currentTimeMillis();
        int r0 = UniversalCardMonitorUtils.a;
        String r1 = this.f;
        CardContext r2 = this.a;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cardContext");
        r2 = null;
    L5:
        OPTrace r3 = r2.getRenderTrace();
        long r4 = System.currentTimeMillis() - this.b;
        if (TextUtils.isEmpty(r1) == true) goto L10;
        long r5 = System.currentTimeMillis() - r4;
        e r6 = com.larksuite.component.card.monitor.b.a;
        com.larksuite.component.card.monitor.b.c.a(ncb.c.d).addCategoryValue(CardActionService.CARD_ID, r1).addCategoryValue("is_universal_card", Boolean.TRUE).setDuration(r5).tracing(r3).flush();
        return;
    }

    public final void onRuntimeReady() {
        super.onRuntimeReady();
        Log.i("UniversalCardLynxClient", hashCode() + " onRuntimeReady");
    }

    public final void onFirstLoadPerfReady(v0 r2) {
        super.onFirstLoadPerfReady(r2);
        Log.i("UniversalCardLynxClient", hashCode() + " onFirstLoadPerfReady");
    }

    public final void onPageStart(String r4) {
        super.onPageStart(r4);
        this.c = System.currentTimeMillis();
        Log.i("UniversalCardLynxClient", hashCode() + " onPageStart");
        int r5 = UniversalCardMonitorUtils.a;
        String r6 = this.f;
        CardContext r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cardContext");
        r0 = null;
    L5:
        OPTrace r1 = r0.getRenderTrace();
        if (TextUtils.isEmpty(r6) == true) goto L10;
        e r2 = com.larksuite.component.card.monitor.b.a;
        com.larksuite.component.card.monitor.b.c.a(ncb.c.c).addCategoryValue(CardActionService.CARD_ID, r6).tracing(r1).flush();
        return;
    }

    public final void onReceivedError(LynxError r7) {
        Intrinsics.checkNotNullParameter(r7, "error");
        super.onReceivedError(r7);
        Log.e("UniversalCardLynxClient", "onReceivedError: " + r7.getMsg());
        int r0 = UniversalCardMonitorUtils.a;
        String r1 = this.f;
        CardContext r2 = this.a;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cardContext");
        r2 = null;
    L5:
        OPTrace r3 = r2.getRenderTrace();
        int r4 = r7.getErrorCode();
        String r8 = r7.getMsg();
        String r5 = this.e;
        Intrinsics.checkNotNullParameter(r8, "errorMsg");
        Intrinsics.checkNotNullParameter(r5, "templateJsVersion");
        if (TextUtils.isEmpty(r1) == true) goto L10;
        e r6 = com.larksuite.component.card.monitor.b.a;
        com.larksuite.component.card.monitor.b.c.a(ncb.c.g).addCategoryValue(CardActionService.CARD_ID, r1).addCategoryValue("error_code", Integer.valueOf(r4)).addCategoryValue("error_msg", r8).addCategoryValue("template_version", r5).tracing(r3).flush();
        return;
    }

    public final void onTimingSetup(Map<String, Object> r23) {
        super.onTimingSetup(r23);
        long r1 = System.currentTimeMillis();
        int r3 = UniversalCardMonitorUtils.a;
        String r5 = this.f;
        CardContext r4 = this.a;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cardContext");
        r4 = null;
    L5:
        UniversalCardMonitorUtils.e(0, r5, r4.getRenderTrace(), r1 - this.b, r1 - this.c, r1 - this.d, r23, this.e);
        UniversalCardMonitorUtils.a(this.f, this.g, 0, this.b, r23, null);
        Log.i("UniversalCardLynxClient", hashCode() + " onTimingSetUp");
    }

    public final void onTimingUpdate(Map<String, Object> r23, Map<String, Long> r24, String r25) {
        super.onTimingUpdate(r23, r24, r25);
        Log.i("UniversalCardLynxClient", hashCode() + " onTimingUpdate");
        long r1 = System.currentTimeMillis();
        int r3 = UniversalCardMonitorUtils.a;
        String r5 = this.f;
        CardContext r4 = this.a;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cardContext");
        r4 = null;
    L5:
        UniversalCardMonitorUtils.e(1, r5, r4.getRenderTrace(), r1 - this.b, r1 - this.c, r1 - this.d, r23, this.e);
        UniversalCardMonitorUtils.a(this.f, this.g, 1, this.b, r23, r24);
    }
}
