package com.lynx.animax.property;

import androidx.annotation.RestrictTo;
import com.lynx.animax.base.CalledByNative;
import com.lynx.animax.base.bridge.JavaOnlyArray;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class AnimaXKeyPath {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JavaOnlyArray f9684a;

    public AnimaXKeyPath(JavaOnlyArray r5) {
        this.f9684a = r5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @CalledByNative
    public JavaOnlyArray getKeys() {
        return this.f9684a;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("KeyPath{keys=");
        ArrayList r10 = new ArrayList();
        Iterator<Object> r11 = this.f9684a.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r12 = r11.next();
        if ((r12 instanceof String) == false) goto L4;
        r10.add((String) r12);
        goto L4
    L8:
        r5.append(r10.toString());
        r5.append("}");
        return r5.toString();
    }
}
