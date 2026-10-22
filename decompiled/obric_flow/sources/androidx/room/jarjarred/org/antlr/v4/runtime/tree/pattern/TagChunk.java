package androidx.room.jarjarred.org.antlr.v4.runtime.tree.pattern;

/* JADX INFO: loaded from: classes.dex */
class TagChunk extends Chunk {
    private final String label;
    private final String tag;

    public TagChunk(String r5) {
        this(null, r5);
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getTag() {
        return this.tag;
    }

    public String toString() {
        if (this.label == null) goto L7;
        return this.label + ":" + this.tag;
    L7:
        return this.tag;
    }

    public TagChunk(String r5, String r10) {
        if (r10 == null) goto L9;
        if (r10.isEmpty() == true) goto L9;
        this.label = r5;
        this.tag = r10;
        return;
    L9:
        throw new IllegalArgumentException("tag cannot be null or empty");
    }
}
