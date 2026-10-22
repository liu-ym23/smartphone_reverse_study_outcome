package com.bytedance.android.anniex.salamander;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.anniex.container.ui.j;
import com.bytedance.crash.d;
import com.bytedance.ies.bullet.service.sdk.param.StatusFontMode;
import com.bytedance.salamander.anniex.AnnieXStatusFontMode;
import com.bytedance.salamander.anniex.f3;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements f3 {
    public final double a;
    public final double b;
    public final double c;
    public final double d;
    public j e;
    public DialogFragment f;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AnnieXStatusFontMode.values().length];
            r0[AnnieXStatusFontMode.LIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[AnnieXStatusFontMode.DARK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[AnnieXStatusFontMode.DEFAULT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public final double b() {
        DialogFragment r0 = this.f;
        if (r0 == null) goto L12;
        Context r1 = r0.getContext();
        if (r1 == null) goto L12;
        List r10 = i16.a.a;
        if (this.e == null) goto L9;
        double r11 = j.b(r1);
    L13:
        return i16.a.m(r11, r1);
    L9:
        r11 = 0.0d;
    L12:
        return this.d;
    }

    public final void close() {
        DialogFragment r0 = this.f;
        if (r0 == null) goto L13;
        r0.dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L14;
        d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }

    public final double a() {
        return this.c;
    }

    public final double getContainerWidth() {
        return this.b;
    }

    public final double l() {
        return this.a;
    }

    public final void c(boolean r10) {
        j r0 = this.e;
        if (r0 == null) goto L6;
        r0.f(!r10);
        return;
    }

    public final void d(AnnieXStatusFontMode r10) {
        Intrinsics.checkNotNullParameter(r10, "fontMode");
        j r0 = this.e;
        if (r0 == null) goto L17;
        int r11 = a.a[r10.ordinal()];
        if (r11 != 1) goto L7;
        StatusFontMode r12 = StatusFontMode.LIGHT;
    L15:
        r0.c(r12);
        return;
    L7:
        if (r11 != 2) goto L9;
        r12 = StatusFontMode.DARK;
        goto L15
    L9:
        if (r11 != 3) goto L12;
        r12 = StatusFontMode.DEFAULT;
        goto L15
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public c(double r1, double r10, double r11, double r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }
}
