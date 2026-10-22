package com.bytedance.ies.bullet.service.popup.ui.primary;

import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ies.bullet.service.popup.ui.AbsPopupDialog;
import com.obric.launcher.widget.R$id;
import com.obric.launcher.widget.R$style;
import com.obric.oui.swipeaction.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/ui/primary/PrimaryDialog;", "Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupDialog;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public class PrimaryDialog extends AbsPopupDialog {
    public View f;
    public volatile Rect g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final GestureDetector f6102h;

    public PrimaryDialog(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, R$style.Dialog_Immersive_NoAnim);
        this.g = new Rect();
        this.f6102h = new GestureDetector(r5, new b(this, 3));
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if (this.f != null) goto L5;
        this.f = findViewById(R$id.bullet_popup_round);
    L5:
        View r5 = this.f;
        if (r5 == null) goto L8;
        int[] r11 = {(int) r5.getX(), (int) r5.getY()};
        r5.getLocationOnScreen(r11);
        int r12 = r11[0];
        int r13 = r11[1];
        int r14 = r5.getWidth() + r12;
        int r15 = r11[1];
        Rect r16 = new Rect(r12, r13, r14, r5.getHeight() + r15);
    L9:
        if (r16 != null) goto L13;
        return super.dispatchTouchEvent(r10);
    L13:
        if (r10.getActionMasked() != 0) goto L15;
        this.g = r16;
    L15:
        r16.contains((int) r10.getRawX(), (int) r10.getRawY());
        if (this.f6102h.onTouchEvent(r10) == false) goto L18;
    L21:
        return true;
    L18:
        if (super.dispatchTouchEvent(r10) == true) goto L21;
        return false;
    L8:
        r16 = null;
        goto L9
    }
}
