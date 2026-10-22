package com.bytedance.android.anniex.salamander;

import android.app.Activity;
import com.bytedance.android.anniex.container.ui.j;
import com.bytedance.ies.bullet.service.sdk.param.StatusFontMode;
import com.bytedance.salamander.anniex.AnnieXStatusFontMode;
import com.bytedance.salamander.anniex.f3;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements f3 {
    public final j a;
    public final Activity b;

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

    public final double a() {
        return 0.0d;
    }

    public final double getContainerWidth() {
        return 300.0d;
    }

    public final double l() {
        return 600.0d;
    }

    public final double b() {
        List r0 = i16.a.a;
        j r1 = this.a;
        Activity r10 = this.b;
        r1.getClass();
        return i16.a.m(j.b(r10), this.b);
    }

    public final void close() {
        this.b.finish();
    }

    public b(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        this.b = r10;
        j r0 = new j(r10.getWindow());
        this.a = r0;
        r0.d();
    }

    public final void c(boolean r10) {
        this.a.f(!r10);
    }

    public final void d(AnnieXStatusFontMode r10) {
        Intrinsics.checkNotNullParameter(r10, "fontMode");
        j r0 = this.a;
        int r11 = a.a[r10.ordinal()];
        if (r11 != 1) goto L5;
        StatusFontMode r12 = StatusFontMode.LIGHT;
    L13:
        r0.c(r12);
        return;
    L5:
        if (r11 != 2) goto L7;
        r12 = StatusFontMode.DARK;
        goto L13
    L7:
        if (r11 != 3) goto L10;
        r12 = StatusFontMode.DEFAULT;
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
