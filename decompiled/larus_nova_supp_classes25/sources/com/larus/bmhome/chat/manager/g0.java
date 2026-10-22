package com.larus.bmhome.chat.manager;

import android.content.Context;
import android.graphics.Bitmap;
import com.larus.bmhome.chat.model.MessageShareViewModel;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g0 {
    public final Context a;
    public final MessageShareViewModel.b b;
    public final String c;
    public final List<Message> d;
    public final wc9.e e;
    public final Bitmap f;
    public final Bitmap g;
    public final boolean h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r6 = (g0) r5;
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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.d.hashCode()) * 31;
        wc9.e r5 = this.e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Bitmap r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Bitmap r11 = this.g;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        int r12 = (r10 + r2) * 31;
        if (this.h == false) goto L21;
        int r13 = 1231;
    L23:
        return r12 + r13;
    L21:
        r13 = 1237;
        goto L23
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "GenerateSharePicContext(context=" + this.a + ", provider=" + this.b + ", shareUrl=" + this.c + ", sortMessages=" + this.d + ", conversation=" + this.e + ", avatarBitmap=" + this.f + ", immersiveBgBitmap=" + this.g + ", onlyMsgList=" + this.h + ')';
    }

    public final Context getContext() {
        return this.a;
    }

    public g0(Context r2, MessageShareViewModel.b r3, String r4, List<Message> r5, wc9.e r6, Bitmap r7, Bitmap r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "provider");
        Intrinsics.checkNotNullParameter(r5, "sortMessages");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
