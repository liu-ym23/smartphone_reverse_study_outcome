package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image;

import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public final Scene a;
    public final DiskCacheStrategy b;
    public final boolean c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "LoaderConfig(scene=" + this.a + ", diskCacheStrategy=" + this.b + ", saveToPrivatePath=" + this.c + ')';
    }

    public c(Scene r2, DiskCacheStrategy r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "diskCacheStrategy");
        this.a = r2;
        this.b = r3;
        this.c = false;
    }
}
