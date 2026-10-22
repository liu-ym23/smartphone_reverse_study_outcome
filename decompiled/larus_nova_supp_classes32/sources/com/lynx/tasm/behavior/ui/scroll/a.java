package com.lynx.tasm.behavior.ui.scroll;

import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements Comparator<b.C0055b> {
    public a() {
    }

    @Override // java.util.Comparator
    public final int compare(b.C0055b r1, b.C0055b r2) {
        return Integer.compare(Math.abs(r1.d), Math.abs(r2.d));
    }
}
