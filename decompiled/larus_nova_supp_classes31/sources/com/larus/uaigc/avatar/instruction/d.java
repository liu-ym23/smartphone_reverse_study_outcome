package com.larus.uaigc.avatar.instruction;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d extends BaseControllerListener<Object> {
    public final /* synthetic */ DigitalAvatarSelectorHolder a;

    public d(DigitalAvatarSelectorHolder r1) {
        this.a = r1;
    }

    public final void onFailure(String r4, Throwable r5) {
        FLogger.a.i("DigitalAvatarTemplateListSelectorWidget", "item cover image failed");
        super.onFailure(r4, r5);
        e1.x(this.a.f);
    }

    public final void onSubmit(String r4, Object r5) {
        FLogger.a.i("DigitalAvatarTemplateListSelectorWidget", "item cover image submit");
        super.onSubmit(r4, r5);
        e1.o(this.a.e);
        e1.o(this.a.f);
    }

    public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
        super.onFinalImageSet(r2, r3, r4);
        FLogger.a.i("DigitalAvatarTemplateListSelectorWidget", "item cover image set");
        if (r3 == null) goto L5;
        e1.x(this.a.e);
        return;
    L5:
        e1.x(this.a.f);
    }
}
