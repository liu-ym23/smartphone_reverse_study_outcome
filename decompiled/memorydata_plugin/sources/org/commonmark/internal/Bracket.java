package org.commonmark.internal;

import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes7.dex */
public class Bracket {
    public boolean allowed;
    public boolean bracketAfter;
    public final boolean image;
    public final int index;
    public final Text node;
    public final Bracket previous;
    public final Delimiter previousDelimiter;

    private Bracket(Text r2, int r3, Bracket r4, Delimiter r5, boolean r6) {
        this.allowed = true;
        this.bracketAfter = false;
        this.node = r2;
        this.index = r3;
        this.image = r6;
        this.previous = r4;
        this.previousDelimiter = r5;
    }

    public static Bracket image(Text r7, int r8, Bracket r9, Delimiter r10) {
        return new Bracket(r7, r8, r9, r10, true);
    }

    public static Bracket link(Text r7, int r8, Bracket r9, Delimiter r10) {
        return new Bracket(r7, r8, r9, r10, false);
    }
}
