package com.ss.android.lark.chat.base.view.recycleview;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import zdc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ItemShineManager<T extends c> {
    public final RecyclerView a;
    public final g2b.c b;
    public final b.InterfaceC0030b c;
    public int d;
    public g2b.a e;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ItemShineStyle {
        public static final int CONSTANT_SHINE = 1;
        public static final int NONE = -1;
        public static final int SHORT_SHINE = 0;
    }

    public final void a() {
        int r0 = this.d;
        if (r0 != 0) goto L5;
        b r1 = new b(this.a, this.c);
        r1.b = this.b;
        r1.d = 100;
        this.e = r1;
        return;
    L5:
        if (r0 != 1) goto L11;
        this.e = new a(this.a, this.b, this.c);
        return;
    }

    public static void b(View r2) {
        Object r0 = r2.getTag(2131384415);
        if ((r0 instanceof Drawable) == false) goto L6;
        r2.setBackground((Drawable) r0);
        return;
    }

    public ItemShineManager(RecyclerView r2, g2b.c r3, b.InterfaceC0030b r4) {
        this.d = 0;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
