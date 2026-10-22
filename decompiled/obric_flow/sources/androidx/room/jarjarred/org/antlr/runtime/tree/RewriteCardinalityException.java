package androidx.room.jarjarred.org.antlr.runtime.tree;

/* JADX INFO: loaded from: classes.dex */
public class RewriteCardinalityException extends RuntimeException {
    public String elementDescription;

    public RewriteCardinalityException(String r5) {
        this.elementDescription = r5;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String r5 = this.elementDescription;
        if (r5 == null) goto L5;
        return r5;
    L5:
        return null;
    }
}
