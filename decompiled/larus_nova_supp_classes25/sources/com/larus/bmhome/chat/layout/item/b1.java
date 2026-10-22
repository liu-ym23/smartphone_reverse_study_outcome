package com.larus.bmhome.chat.layout.item;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.ability.ContainerExceptionType;
import com.larus.bmhome.chat.bean.WidgetEvent;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b1 implements ic8.x {
    public final /* synthetic */ LynxBox a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[WidgetEvent.values().length];
            r0[WidgetEvent.TIMING_SETUP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    @Override // ic8.x
    public final void a() {
        FLogger.a.i("LynxBox", "onPageStart");
    }

    @Override // ic8.x
    public final void b() {
        FLogger.a.e("LynxBox", "onPageError");
        int r0 = com.larus.utils.p0.a;
        JSONObject r1 = com.larus.utils.p0.b(this.a.getLynxBoxConfig().g);
        JSONObject r2 = r1.optJSONObject("commonProps");
        if (r2 == null) goto L5;
        String r3 = r2.optString("messageId");
    L7:
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        String r4 = this.a.getTemplateInfo().getMixtureCardId();
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        String r5 = r1.optString("card_type");
        va8.x r6 = LynxBox.o(this.a);
        if (r6 == null) goto L15;
        ContainerExceptionType r7 = ContainerExceptionType.FAILED_LYNX;
        JSONObject r8 = new JSONObject();
        LynxBox r9 = this.a;
        r8.put("applet_id", r5);
        r8.put("error_msg", "");
        r8.put("url", r9.I);
        Unit r10 = Unit.INSTANCE;
        r6.uN(r3, r7, r4, r8);
    L15:
        this.a.q(LynxBox.LynxShowState.FAIL);
        return;
    L5:
        r3 = null;
        goto L7
    }

    @Override // ic8.x
    public final void c() {
        FLogger.a.i("LynxBox", "onPageFinish");
        this.a.q(LynxBox.LynxShowState.SUCCESS);
        Function3<View, Fragment, com.larus.bmhome.chat.api.v0, Unit> r0 = this.a.getAppletRenderFinishedCallBack();
        if (r0 == null) goto L6;
        r0.invoke(this.a.getAppletLynxView(), LynxBox.n(this.a), this.a.H);
        return;
    }

    @Override // ic8.x
    public final void onDestroy() {
        FLogger.a.i("LynxBox", "onDestroy");
    }

    @Override // ic8.x
    public final void onStart() {
        FLogger.a.i("LynxBox", "onStart");
        if (this.a.getLynxBoxConfig().c == true) goto L6;
        this.a.q(LynxBox.LynxShowState.LOADING);
        return;
    }

    public b1(LynxBox r1) {
        this.a = r1;
    }

    @Override // ic8.x
    public void onEvent(WidgetEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (a.a[r6.ordinal()] != 1) goto L22;
        int r7 = com.larus.utils.p0.a;
        JSONObject r8 = com.larus.utils.p0.b(this.a.getLynxBoxConfig().g);
        JSONObject r0 = r8.optJSONObject("commonProps");
        if (r0 == null) goto L7;
        String r1 = r0.optString("messageId");
    L8:
        String r2 = "";
        if (r1 != null) goto L11;
        r1 = "";
    L11:
        String r3 = this.a.getTemplateInfo().getMixtureCardId();
        if (r3 == null) goto L15;
        r2 = r3;
    L15:
        String r9 = r8.optString("card_type");
        FLogger.a.i("LynxBox", "onTimingSetup");
        Function0<Unit> r4 = this.a.getOnTimingSetupCallback();
        if (r4 == null) goto L18;
        r4.invoke();
    L18:
        va8.x r5 = LynxBox.o(this.a);
        if (r5 == null) goto L23;
        Intrinsics.checkNotNull(r9);
        r5.G40(r1, r9, r2);
        return;
    L23:
        return;
    L7:
        r1 = null;
        goto L8
    }
}
