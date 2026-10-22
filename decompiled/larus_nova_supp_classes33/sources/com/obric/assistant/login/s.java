package com.obric.assistant.login;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.OneShotPreDrawListener;
import com.obric.assistant.onelogin.impl.databinding.ObricEnterpriseAccountTipListItemBinding;
import com.obric.oui.dialog.v2.alert.c;
import com.obric.oui.dialog.v2.common.ODialogListItemView;
import com.obric.oui.dialog.v2.common.a;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class s {
    public static final s a = null;
    public static WeakReference<c> b;

    static {
        a = new s();
    }

    public s() {
    }

    public static /* synthetic */ void b(ObricEnterpriseAccountTipListItemBinding r7, int r8, int r9, int r10, int r11, int r12) {
        a(r7, r8, r9, r10, true, r11, r12);
    }

    public static void a(ObricEnterpriseAccountTipListItemBinding r3, int r4, int r5, int r6, boolean r7, int r8, int r9) {
        ODialogListItemView r0 = r3.b;
        r0.setTitle(r0.getContext().getText(r5));
        ODialogListItemView r10 = r3.b;
        r10.setSubtitle(r10.getContext().getText(r6));
        r3.b.setChangeAlphaWhenPress(false);
        r3.b.setClickable(false);
        r3.b.setFocusable(false);
        r3.b.getSubtitleView().setMaxLines(Integer.MAX_VALUE);
        r3.b.getSubtitleView().setEllipsize(null);
        ODialogListItemView r11 = r3.b;
        ImageView r1 = new ImageView(r3.b.getContext());
        r1.setImageResource(r4);
        r1.setImportantForAccessibility(2);
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(r8, r8);
        r12.gravity = 17;
        Unit r13 = Unit.INSTANCE;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r12, "layoutParams");
        r11.d(r11.getLeadingContainer(), r1, r12);
        r11.getListItemRoot().setPadding(d.n(r11, 0), r11.getPaddingTop(), r11.getPaddingRight(), r11.getPaddingBottom());
        r11.getLeadingContainer().measure(0, 0);
        r11.e(r11.m);
        FrameLayout r14 = r3.b.getLeadingContainer();
        ViewGroup.LayoutParams r15 = r3.b.getLeadingContainer().getLayoutParams();
        r15.width = r9;
        r15.height = -1;
        r14.setLayoutParams(r15);
        ODialogListItemView r16 = r3.b;
        r16.m = r7;
        r16.getLeadingContainer().measure(0, 0);
        OneShotPreDrawListener.add(r16, new a(r16, r16, r7));
    }
}
