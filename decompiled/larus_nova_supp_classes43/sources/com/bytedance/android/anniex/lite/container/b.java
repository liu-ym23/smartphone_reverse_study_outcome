package com.bytedance.android.anniex.lite.container;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.anniex.container.popup.PopupCloseType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ AnnieXFlowPopupContainer a;

    public static final class a implements com.bytedance.ies.bullet.core.kit.bridge.h {
        public final String getName() {
            return "H5_tapWebMaskView";
        }

        public final Object getParams() {
            return null;
        }

        public a() {
        }
    }

    public b(AnnieXFlowPopupContainer r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        DialogFragment r11 = this.a.c;
        if (r11 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
        r11 = null;
    L6:
        if (r11.isCancelable() == false) goto L10;
        Dialog r12 = this.a.e;
        if (r12 == null) goto L12;
        r12.cancel();
        return;
    L12:
        return;
    L10:
        this.a.sendEvent(new a());
        AnnieXFlowPopupContainer r13 = this.a;
        PopupCloseType r0 = PopupCloseType.CLICK_MASK;
        r13.getClass();
        r13.sendEvent(new i(r0));
    }
}
