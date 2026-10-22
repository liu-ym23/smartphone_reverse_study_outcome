package com.lynx.tasm.animation.keyframe;

import android.animation.Keyframe;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements Comparator<Keyframe> {
    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(Keyframe r1, Keyframe r2) {
        return Float.compare(r1.getFraction(), r2.getFraction());
    }
}
