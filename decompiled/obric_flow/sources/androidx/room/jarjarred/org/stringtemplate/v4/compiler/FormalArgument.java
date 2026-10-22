package androidx.room.jarjarred.org.stringtemplate.v4.compiler;

import androidx.room.jarjarred.org.antlr.runtime.Token;

/* JADX INFO: loaded from: classes.dex */
public class FormalArgument {
    public CompiledST compiledDefaultValue;
    public Object defaultValue;
    public Token defaultValueToken;
    public int index;
    public String name;

    public FormalArgument(String r5) {
        this.name = r5;
    }

    public boolean equals(Object r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        if ((r5 instanceof FormalArgument) == false) goto L22;
        FormalArgument r10 = (FormalArgument) r5;
        if (this.name.equals(r10.name) == true) goto L10;
        return false;
    L10:
        Token r11 = this.defaultValueToken;
        if (r11 != null) goto L13;
    L14:
        if (r11 == null) goto L16;
    L17:
        return true;
    L16:
        if (r10.defaultValueToken == null) goto L17;
        return false;
    L13:
        if (r10.defaultValueToken != null) goto L14;
        return false;
    L22:
        return false;
    }

    public int hashCode() {
        int r5 = this.name.hashCode();
        return this.defaultValueToken.hashCode() + r5;
    }

    public String toString() {
        if (this.defaultValueToken == null) goto L7;
        return this.name + "=" + this.defaultValueToken.getText();
    L7:
        return this.name;
    }

    public FormalArgument(String r5, Token r10) {
        this.name = r5;
        this.defaultValueToken = r10;
    }
}
