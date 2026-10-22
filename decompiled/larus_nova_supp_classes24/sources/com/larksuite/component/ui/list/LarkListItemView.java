package com.larksuite.component.ui.list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import b08.a;
import b08.b;
import b08.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class LarkListItemView extends LinearLayout implements c {
    public final a a;

    public abstract View a(ViewGroup r1);

    public abstract void b();

    public LarkListItemView(Context r1) {
        super(r1);
        this.a = new a();
        addView(a(this));
        b();
    }

    public LarkListItemView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = new a();
        addView(a(this));
        b();
    }

    public LarkListItemView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new a();
        addView(a(this));
        b();
    }

    @Override // b08.c
    public final <M, V extends View> void registerModelBinder(Class<M> r2, Class<V> r3, b<? super V, ? super M> r4) {
        this.a.registerModelBinder(r2, r3, r4);
    }
}
