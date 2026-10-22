package com.lynx.tasm.ui.image;

import com.facebook.common.internal.Objects;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeHierarchy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class y<DH extends DraweeHierarchy> {
    public volatile boolean a;
    public boolean b;
    public DH c;
    public q d;

    public final String toString() {
        return Objects.toStringHelper(this).add("controllerAttached", this.a).add("holderAttached", this.b).add("drawableVisible", true).toString();
    }

    public y(GenericDraweeHierarchy r2) {
        this.a = false;
        this.b = false;
        this.d = null;
        if (r2 == null) goto L6;
        this.c = r2;
        return;
    }
}
