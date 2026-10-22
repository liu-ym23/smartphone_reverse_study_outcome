package com.larus.bmhome.chat;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.view.ImmerseBgVideoView;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d1 implements Runnable {
    public final /* synthetic */ SimpleDraweeView a;
    public final /* synthetic */ h1 b;
    public final /* synthetic */ ImageView c;

    public /* synthetic */ d1(SimpleDraweeView r1, h1 r2, ImageView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SimpleDraweeView r0 = this.a;
        h1 r1 = this.b;
        ImageView r2 = this.c;
        ViewGroup.LayoutParams r3 = r0.getLayoutParams();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        FragmentActivity r5 = r1.a.getActivity();
        if (r5 == null) goto L5;
        int r6 = com.larus.utils.u.c(r5);
    L6:
        int r7 = c7.b(68) - r6;
        float r8 = -r6;
        r0.setTranslationY(r8);
        r4.bottomMargin = r7;
        r0.setLayoutParams(r4);
        com.larus.utils.e1.x(r0);
        int r9 = com.larus.bmhome.chat.immerse.k0.a;
        com.larus.bmhome.chat.immerse.k0.a = r4.height;
        ImmerseBgVideoView r10 = r1.k;
        ViewGroup.MarginLayoutParams r11 = null;
        if (r10 == null) goto L9;
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
    L11:
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        r11 = (ViewGroup.MarginLayoutParams) r12;
    L13:
        ImmerseBgVideoView r13 = r1.k;
        if (r13 == null) goto L16;
        r13.setTranslationY(r8);
    L16:
        if (r11 == null) goto L20;
        r11.bottomMargin = r7;
        ImmerseBgVideoView r14 = r1.k;
        if (r14 == null) goto L20;
        r14.setLayoutParams(r11);
    L20:
        if (r2 == null) goto L23;
        r2.setTranslationY(r8);
        return;
    L23:
        return;
    L9:
        r12 = null;
        goto L11
    L5:
        r6 = 0;
        goto L6
    }
}
