package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class g extends i implements st8.a {
    public p p;
    public Function0<Boolean> q;

    public float getClickX() {
        return 0.0f;
    }

    public float getClickY() {
        return 0.0f;
    }

    public final View l5() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FrameLayout getContainer() {
        if ((this instanceof FrameLayout) == true) goto L7;
        return null;
    L7:
        return (FrameLayout) this;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public Integer getImmerseBgColor() {
        return super.getImmerseBgColor();
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public boolean getUseSubscribedColor() {
        return super.getUseSubscribedColor();
    }

    public Function0<Boolean> getDownListener() {
        return this.q;
    }

    public g(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final void setBoxChangedListener(p r2) {
        Intrinsics.checkNotNullParameter(r2, "boxChangedListener");
        this.p = r2;
    }

    public void setDownListener(Function0<Boolean> r1) {
        this.q = r1;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public void setImmerseBgColor(Integer r2) {
        super.setImmerseBgColor(r2);
        p r0 = this.p;
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public void setUseSubscribedColor(boolean r2) {
        super.setUseSubscribedColor(r2);
        p r0 = this.p;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public void l(boolean r2, boolean r3) {
        super.l(r2, r3);
        p r0 = this.p;
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }
}
