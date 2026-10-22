package androidx.room.jarjarred.org.antlr.v4.tool;

import androidx.room.jarjarred.org.antlr.runtime.Token;

/* JADX INFO: loaded from: classes.dex */
public class Attribute {
    public String decl;
    public AttributeDict dict;
    public String initValue;
    public String name;
    public Token token;
    public String type;

    public Attribute() {
    }

    public String toString() {
        if (this.initValue == null) goto L7;
        return this.name + ":" + this.type + "=" + this.initValue;
    L7:
        if (this.type == null) goto L11;
        return this.name + ":" + this.type;
    L11:
        return this.name;
    }

    public Attribute(String r5) {
        this(r5, null);
    }

    public Attribute(String r5, String r10) {
        this.name = r5;
        this.decl = r10;
    }
}
