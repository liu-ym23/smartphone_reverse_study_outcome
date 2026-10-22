package androidx.room.jarjarred.org.stringtemplate.v4;

import androidx.room.jarjarred.org.antlr.runtime.ANTLRStringStream;
import androidx.room.jarjarred.org.antlr.runtime.CommonTokenStream;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.CompiledST;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.GroupLexer;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.GroupParser;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ErrorType;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public class STGroupString extends STGroup {
    protected boolean alreadyLoaded;
    public String sourceName;
    public String text;

    public STGroupString(String r5) {
        this(Grammar.GRAMMAR_FROM_STRING_NAME, r5, Typography.less, Typography.greater);
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STGroup
    public String getFileName() {
        return Grammar.GRAMMAR_FROM_STRING_NAME;
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STGroup
    public boolean isDefined(String r5) {
        if (this.alreadyLoaded == true) goto L6;
        load();
    L6:
        return super.isDefined(r5);
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STGroup
    public boolean isDictionary(String r5) {
        if (this.alreadyLoaded == true) goto L6;
        load();
    L6:
        return super.isDictionary(r5);
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STGroup
    public CompiledST load(String r5) {
        if (this.alreadyLoaded == true) goto L6;
        load();
    L6:
        return rawGetTemplate(r5);
    }

    public STGroupString(String r5, String r10) {
        this(r5, r10, Typography.less, Typography.greater);
    }

    public STGroupString(String r5, String r10, char r11, char r12) {
        super(r11, r12);
        this.alreadyLoaded = false;
        this.sourceName = r5;
        this.text = r10;
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STGroup
    public void load() {
        if (this.alreadyLoaded == false) goto L5;
        return;
    L5:
        this.alreadyLoaded = true;
        ANTLRStringStream r5 = new ANTLRStringStream(this.text);     // Catch: Exception -> L8
        r5.name = this.sourceName;     // Catch: Exception -> L8
        new GroupParser(new CommonTokenStream(new GroupLexer(r5))).group(this, "/");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        this.errMgr.IOError(null, ErrorType.CANT_LOAD_GROUP_FILE, e, Grammar.GRAMMAR_FROM_STRING_NAME);
    }
}
