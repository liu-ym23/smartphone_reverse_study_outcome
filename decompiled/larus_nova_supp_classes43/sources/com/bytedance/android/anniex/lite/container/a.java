package com.bytedance.android.anniex.lite.container;

import com.bytedance.android.anniex.container.popup.PopupCloseType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements com.bytedance.android.anniex.container.popup.c {
    public final /* synthetic */ AnnieXFlowPopupContainer a;

    /* JADX INFO: renamed from: com.bytedance.android.anniex.lite.container.a$a, reason: collision with other inner class name */
    public static final class C0094a implements com.bytedance.ies.bullet.core.kit.bridge.h {
        public final String getName() {
            return "H5_tapWebMaskView";
        }

        public final Object getParams() {
            return null;
        }

        public C0094a() {
        }
    }

    @Override // com.bytedance.android.anniex.container.popup.c
    public final void a() {
    }

    public a(AnnieXFlowPopupContainer r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.anniex.container.popup.c
    public final void b(boolean r10, PopupCloseType r11) {
        Intrinsics.checkNotNullParameter(r11, "popupCloseType");
        if (r10 == true) goto L6;
        this.a.sendEvent(new C0094a());
        AnnieXFlowPopupContainer r12 = this.a;
        r12.getClass();
        r12.sendEvent(new i(r11));
        return;
    }
}
