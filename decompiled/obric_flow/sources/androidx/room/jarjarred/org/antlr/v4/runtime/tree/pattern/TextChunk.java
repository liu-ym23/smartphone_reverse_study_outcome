package androidx.room.jarjarred.org.antlr.v4.runtime.tree.pattern;

import ai.j0;

/* JADX INFO: loaded from: classes.dex */
class TextChunk extends Chunk {
    private final String text;

    public TextChunk(String r5) {
        if (r5 == null) goto L7;
        this.text = r5;
        return;
    L7:
        throw new IllegalArgumentException("text cannot be null");
    }

    public final String getText() {
        return this.text;
    }

    public String toString() {
        return j0.q(new StringBuilder("'"), this.text, "'");
    }
}
