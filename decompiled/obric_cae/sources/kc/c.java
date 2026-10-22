package kc;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.obric.cae.R;
import com.obric.oui.indexscrollbar.LettersBar;
import he.i;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LettersBar f9105a;

    public c(LettersBar r8) {
        this.f9105a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LettersBar r12 = this.f9105a;
        if (r12.getOldChosen() != r12.getNewChosen()) goto L5;
    L50:
        r12.setShowPopupTaskStartTime(-1);
        return;
    L5:
        if (r12.getNewChosen() < 0) goto L50;
        int r8 = r12.getNewChosen();
        List<a> r10 = r12.f6316a;
        i.c(r10);
        if (r8 >= r10.size()) goto L50;
        int r11 = r12.getNewChosen();
        float r13 = (float) Math.max(r12.f6325t / r12.b().size(), r12.f6321p);
        List<a> r14 = r12.f6316a;
        i.c(r14);
        String r15 = r14.get(r11).f9102b;
        if (i.a(r15, r12.C) == true) goto L49;
        zc.b.a("LettersBar", "showPopupWindow, scene: ACTION_DOWN, c = " + r11 + ", letter = " + r15 + ", lastPopupLetter = " + r12.C);
        Bitmap[] r16 = r12.f6319n;
        Bitmap r17 = null;
        if (r16 == null) goto L14;
        Integer r18 = Integer.valueOf(r16.length);
    L15:
        List<a> r19 = r12.f6316a;
        i.c(r19);
        if (r19.get(r11).f9101a != 2) goto L21;
        if (r18 == null) goto L21;
        if (Integer.parseInt(r15) > r18.intValue()) goto L21;
        Bitmap[] r20 = r12.f6319n;
        i.c(r20);
        r17 = r20[Integer.parseInt(r15) - 1];
    L21:
        int r21 = r12.getResources().getDimensionPixelSize(R.dimen.oui_h_title_bar_window);
        int r22 = r12.B - r12.getWidth();
        Resources r23 = Resources.getSystem();
        i.e(r23, "Resources.getSystem()");
        int r24 = r22 - l6.a.I0(TypedValue.applyDimension(1, 20, r23.getDisplayMetrics()));
        Resources r25 = Resources.getSystem();
        i.e(r25, "Resources.getSystem()");
        int r26 = r24 - l6.a.I0(TypedValue.applyDimension(1, 18, r25.getDisplayMetrics()));
        Resources r27 = Resources.getSystem();
        i.e(r27, "Resources.getSystem()");
        int r28 = r26 - l6.a.I0(TypedValue.applyDimension(1, 6, r27.getDisplayMetrics()));
        Resources r29 = Resources.getSystem();
        i.e(r29, "Resources.getSystem()");
        int r30 = r28 - l6.a.I0(TypedValue.applyDimension(1, 10, r29.getDisplayMetrics()));
        int r31 = r12.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r31 <= 0) goto L24;
        r21 = r21 + r12.getResources().getDimensionPixelSize(r31);
    L24:
        int[] r32 = new int[2];
        r12.getLocationInWindow(r32);
        int r33 = Math.max((int) ((r13 * (r11 - 1)) + r32[1]), r21);
        d r34 = r12.A;
        r34.getClass();
        i.f(r15, "letter");
        ImageView r35 = r34.f9108m;
        TextView r36 = r34.f9107b;
        if (r17 != null) goto L32;
        if (r36 == null) goto L28;
        r36.setText(r15);
    L28:
        if (r35 == null) goto L30;
        r35.setVisibility(8);
    L30:
        if (r36 == null) goto L38;
        r36.setVisibility(0);
    L38:
        PopupWindow r37 = r34.f9106a;
        if (r37 != null) goto L41;
    L45:
        PopupWindow r38 = r34.f9106a;
        if (r38 == null) goto L48;
        r38.update(r30, r33, -2, -2);
    L48:
        r12.C = r15;
        goto L49
    L41:
        if (r37.isShowing() == true) goto L45;
        PopupWindow r39 = r34.f9106a;
        if (r39 == null) goto L48;
        r39.showAtLocation(r34, 0, r30, r33);
        goto L48
    L32:
        if (r36 == null) goto L34;
        r36.setVisibility(8);
    L34:
        if (r35 == null) goto L36;
        r35.setVisibility(0);
    L36:
        if (r35 == null) goto L38;
        r35.setImageBitmap(r17);
        goto L38
    L14:
        r18 = null;
    L49:
        defpackage.c.a0(r12, 26);
        LettersBar.a(r12, r12.getNewChosen());
        goto L50
    }
}
