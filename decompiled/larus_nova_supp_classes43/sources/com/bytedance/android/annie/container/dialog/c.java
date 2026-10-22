package com.bytedance.android.annie.container.dialog;

import com.bytedance.android.livesdk.pannel.CloseType;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements com.bytedance.android.livesdk.pannel.d {
    public final /* synthetic */ BaseDialogFragment a;

    public final void a() {
    }

    public c(BaseDialogFragment r1) {
        this.a = r1;
    }

    public final void b(boolean r10, CloseType r11) {
        Intrinsics.checkNotNullParameter(r11, "closeType");
        if (r10 == true) goto L6;
        this.a.sendJsEvent("H5_tapWebMaskView", new JSONObject());
        BaseDialogFragment r12 = this.a;
        r12.getClass();
        JSONObject r0 = new JSONObject();
        r0.put("type", r11.getTag());
        Unit r13 = Unit.INSTANCE;
        r12.sendJsEvent("containerShouldClose", r0);
        return;
    }
}
