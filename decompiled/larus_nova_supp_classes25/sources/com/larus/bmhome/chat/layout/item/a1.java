package com.larus.bmhome.chat.layout.item;

import android.view.View;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.larus.bmhome.ability.ContainerExceptionType;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a1 extends ix7.d.a {
    public boolean a;
    public final /* synthetic */ LynxBox b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    public final void a() {
        FLogger.a.i("LynxBox", "onTimingSetup");
        Function0<Unit> r0 = this.b.getOnTimingSetupCallback();
        if (r0 == null) goto L5;
        r0.invoke();
    L5:
        va8.x r1 = LynxBox.o(this.b);
        if (r1 == null) goto L9;
        String r2 = this.c;
        String r3 = this.e;
        Intrinsics.checkNotNull(r3);
        r1.G40(r2, r3, this.d);
        return;
    }

    public final void c(BulletContainerView r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r3, "view");
        FLogger.a.i("LynxBox", "onRuntimeReady");
        kx7.b r4 = this.b.getLynxPluginView();
        if (r4 == null) goto L8;
        Function1<kx7.b, Unit> r0 = this.b.getRenderFinishedCallBack();
        if (r0 == null) goto L9;
        r0.invoke(r4);
        return;
    L9:
        return;
    }

    public final void e(Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, "e");
        this.a = false;
        FLogger.a.e("LynxBox", "onLoadFail " + r10.getMessage());
        va8.x r1 = LynxBox.o(this.b);
        if (r1 == null) goto L5;
        String r2 = this.c;
        ContainerExceptionType r3 = ContainerExceptionType.FAILED_LYNX;
        String r4 = this.d;
        JSONObject r5 = new JSONObject();
        String r6 = this.e;
        String r7 = this.f;
        r5.put("applet_id", r6);
        r5.put("error_msg", r10.getMessage());
        r5.put("url", r7);
        Unit r8 = Unit.INSTANCE;
        r1.uN(r2, r3, r4, r5);
    L5:
        Intrinsics.checkNotNullParameter(r10, "e");
    }

    public final void onLoadSuccess(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if (this.a == true) goto L6;
        this.a = true;
        return;
    L6:
        Intrinsics.checkNotNullParameter(r3, "view");
        FLogger.a.i("LynxBox", "onLoadSuccess");
    }

    public a1(LynxBox r1, String r2, String r3, String r4, String r5) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.a = true;
    }
}
