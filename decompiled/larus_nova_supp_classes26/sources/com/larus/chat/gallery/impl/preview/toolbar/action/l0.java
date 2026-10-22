package com.larus.chat.gallery.impl.preview.toolbar.action;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.larus.chat.gallery.impl.preview.toolbar.PreviewToolbarView;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import xy8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l0 {
    public final xy8.d a;
    public final CoroutineScope b;
    public final FragmentManager c;
    public final Context d;
    public final com.larus.gallery.api.w e;
    public final PreviewToolbarView f;
    public final boolean g;
    public final a h;
    public final boolean i;
    public final boolean j;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r6 = (l0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        PreviewToolbarView r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        int r5 = 1231;
        if (this.g == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (r4 + r6) * 31;
        a r8 = this.h;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        int r9 = (r7 + r2) * 31;
        if (this.i == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        if (this.j == true) goto L23;
        r5 = 1237;
    L23:
        return r11 + r5;
    L17:
        r10 = 1237;
        goto L18
    L9:
        r6 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ToolbarActionContext(data=" + this.a + ", lifecycleScope=" + this.b + ", fragmentManager=" + this.c + ", context=" + this.d + ", mediator=" + this.e + ", toolbarView=" + this.f + ", publishInSharePanel=" + this.g + ", toolbarCapability=" + this.h + ", isFromOverflow=" + this.i + ", isFromSharePanel=" + this.j + ')';
    }

    public final Context getContext() {
        return this.d;
    }

    public l0(xy8.d r2, CoroutineScope r3, FragmentManager r4, Context r5, com.larus.gallery.api.w r6, PreviewToolbarView r7, boolean r8, a r9, boolean r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r4, "fragmentManager");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "mediator");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
    }
}
