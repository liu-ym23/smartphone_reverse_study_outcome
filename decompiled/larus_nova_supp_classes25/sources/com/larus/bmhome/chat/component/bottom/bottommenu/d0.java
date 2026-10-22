package com.larus.bmhome.chat.component.bottom.bottommenu;

import android.view.View;
import com.larus.platform.model.UploadUiStyle;
import com.larus.platform.service.FlowDriveSdkService;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d0 implements Function1 {
    public final /* synthetic */ BottomMenuComponent a;

    public /* synthetic */ d0(BottomMenuComponent r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.bmhome.chat.component.bottom.bottommenu.n0] */
    public final Object invoke(Object r5) {
        final BottomMenuComponent r0 = this.a;
        final View r6 = (View) r5;
        int r1 = BottomMenuComponent.x1;
        final boolean r2 = FlowDriveSdkService.a.h();
        if (r2 == true) goto L5;
    L7:
        final boolean r3 = false;
    L8:
        final ?? r4 = new n0(r0, r2, r6);
        com.obric.assistant.spi.keyguard.a.b(r3, new o0(r3, r4, r0), 2);
        return Unit.INSTANCE;
    L5:
        if (((UploadUiStyle) r0.w.getValue()) != UploadUiStyle.LOCAL_DRIVE_RECENT) goto L7;
        r3 = true;
        goto L8
    }
}
