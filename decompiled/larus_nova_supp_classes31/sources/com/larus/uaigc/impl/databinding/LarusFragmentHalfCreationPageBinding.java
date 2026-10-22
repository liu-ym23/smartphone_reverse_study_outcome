package com.larus.uaigc.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.ChatConstraintLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusFragmentHalfCreationPageBinding implements ViewBinding {
    public final ChatConstraintLayout a;
    public final FrameLayout b;
    public final ConstraintLayout c;
    public final FrameLayout d;
    public final ViewStub e;
    public final ChatConstraintLayout f;

    public final View getRoot() {
        return this.a;
    }

    public static LarusFragmentHalfCreationPageBinding a(LayoutInflater r8, ViewGroup r9) {
        ChatConstraintLayout r10 = r8.inflate(2131562398, r9, false);
        int r11 = 2131365537;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r10, 2131365537);
        if (r3 == null) goto L13;
        r11 = 2131368253;
        ConstraintLayout r4 = ViewBindings.findChildViewById(r10, 2131368253);
        if (r4 == null) goto L13;
        r11 = 2131374177;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r10, 2131374177);
        if (r5 == null) goto L13;
        r11 = 2131375364;
        ViewStub r6 = (ViewStub) ViewBindings.findChildViewById(r10, 2131375364);
        if (r6 == null) goto L13;
        ChatConstraintLayout r7 = r10;
        return new LarusFragmentHalfCreationPageBinding(r7, r3, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public LarusFragmentHalfCreationPageBinding(ChatConstraintLayout r1, FrameLayout r2, ConstraintLayout r3, FrameLayout r4, ViewStub r5, ChatConstraintLayout r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
