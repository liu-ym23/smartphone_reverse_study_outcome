package com.lynx.tasm.behavior.ui;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public ILynxUIMeaningfulContent$MeaningfulContentStatus e;
    public long f;

    public interface a {
        IDrawChildHook getDrawChildHook();

        void invalidateMeaningfulPaintingArea();
    }

    public e(int r3, int r4, int r5, int r6) {
        this.e = ILynxUIMeaningfulContent$MeaningfulContentStatus.IRRELEVANT;
        this.f = -1;
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
