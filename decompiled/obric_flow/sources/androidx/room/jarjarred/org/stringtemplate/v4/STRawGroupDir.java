package androidx.room.jarjarred.org.stringtemplate.v4;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.CharStream;
import androidx.room.jarjarred.org.antlr.runtime.CommonToken;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.CompiledST;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.Compiler;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.Misc;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class STRawGroupDir extends STGroupDir {
    public STRawGroupDir(String r5) {
        super(r5);
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STGroup
    public CompiledST loadTemplateFile(String r5, String r10, CharStream r11) {
        String r12 = r11.substring(0, r11.size() - 1);
        String r13 = j0.j(r5, Misc.getFileNameNoSuffix(r10));
        CompiledST r14 = new Compiler(this).compile(r13, r12);
        CommonToken r15 = new CommonToken(9);
        r15.setInputStream(r11);
        rawDefineTemplate(r13, r14, r15);
        r14.defineImplicitlyDefinedTemplates(this);
        return r14;
    }

    public STRawGroupDir(String r5, char r10, char r11) {
        super(r5, r10, r11);
    }

    public STRawGroupDir(String r5, String r10) {
        super(r5, r10);
    }

    public STRawGroupDir(String r5, String r10, char r11, char r12) {
        super(r5, r10, r11, r12);
    }

    public STRawGroupDir(URL r5, String r10, char r11, char r12) {
        super(r5, r10, r11, r12);
    }
}
