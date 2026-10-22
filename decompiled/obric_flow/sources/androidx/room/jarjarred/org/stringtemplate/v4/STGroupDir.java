package androidx.room.jarjarred.org.stringtemplate.v4;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.ANTLRInputStream;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.CompiledST;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.STException;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ErrorType;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.Misc;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public class STGroupDir extends STGroup {
    public String groupDirName;
    public URL root;

    public STGroupDir(String r5) {
        this(r5, Typography.less, Typography.greater);
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STGroup
    public String getFileName() {
        return this.root.getFile();
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STGroup
    public String getName() {
        return this.groupDirName;
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STGroup
    public URL getRootDirURL() {
        return this.root;
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STGroup
    public void importTemplates(Token r5) {
        throw new UnsupportedOperationException("import illegal in group files embedded in STGroupDirs; import " + r5.getText() + " in STGroupDir " + getName());
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STGroup
    public CompiledST load(String r10) {
        if (STGroup.verbose == false) goto L5;
        System.out.println("STGroupDir.load(" + r10 + ")");
    L5:
        String r5 = Misc.getParent(r10);
        String r11 = Misc.getPrefix(r10);
        InputStream r12 = new URL(this.root + r5 + STGroup.GROUP_FILE_EXTENSION).openStream();     // Catch: Throwable -> L15 IOException -> L17
        if (r12 != null) goto L24;
    L13:
        loadGroupFile(r11, this.root + r5 + STGroup.GROUP_FILE_EXTENSION);
        return rawGetTemplate(r10);
    L24:
        r12.close();     // Catch: IOException -> L11
    L11:
        e = move-exception;
        this.errMgr.internalError(null, "can't close template file stream " + r10, e);
        goto L13
    L15:
        th = move-exception;
        throw th;
    L18:
        return loadTemplateFile(r11, Misc.getFileName(r10) + STGroup.TEMPLATE_FILE_EXTENSION);
    L19:
        e = move-exception;
        this.errMgr.internalError(null, "bad URL: " + this.root + r5 + STGroup.GROUP_FILE_EXTENSION, e);
        return null;
    }

    public CompiledST loadTemplateFile(String r10, String r11) {
        if (STGroup.verbose == false) goto L17;
        PrintStream r5 = System.out;
        StringBuilder r12 = j0.x("loadTemplateFile(", r11, ") in groupdir from ");
        r12.append(this.root);
        r12.append(" prefix=");
        r12.append(r10);
        r5.println(r12.toString());
    L17:
        ANTLRInputStream r13 = new ANTLRInputStream(new URL(this.root + r10 + r11).openStream(), this.encoding);     // Catch: IOException -> L10
        r13.name = r11;     // Catch: IOException -> L10
        return loadTemplateFile(r10, r11, r13);
    L11:
        if (STGroup.verbose == false) goto L13;
        System.out.println(this.root + "/" + r11 + " doesn't exist");
    L13:
        return null;
    L14:
        e = move-exception;
        this.errMgr.runTimeError(null, null, ErrorType.INVALID_TEMPLATE_NAME, e, this.root + r11);
        return null;
    }

    public STGroupDir(String r5, char r10, char r11) {
        super(r10, r11);
        this.groupDirName = r5;
        File r12 = new File(r5);
        if (r12.exists() == true) goto L5;
    L13:
        URL r13 = Thread.currentThread().getContextClassLoader().getResource(r5);
        this.root = r13;
        if (r13 != null) goto L17;
        this.root = getClass().getClassLoader().getResource(r5);
    L17:
        if (STGroup.verbose == false) goto L20;
        PrintStream r14 = System.out;
        StringBuilder r15 = j0.x("STGroupDir(", r5, ") found via CLASSPATH at ");
        r15.append(this.root);
        r14.println(r15.toString());
    L20:
        if (this.root == null) goto L23;
        return;
    L23:
        throw new IllegalArgumentException(j0.C("No such directory: ", r5));
    L5:
        if (r12.isDirectory() == false) goto L13;
        this.root = r12.toURI().toURL();     // Catch: MalformedURLException -> L10
        if (STGroup.verbose == false) goto L21;
        PrintStream r16 = System.out;
        StringBuilder r17 = j0.x("STGroupDir(", r5, ") found at ");
        r17.append(this.root);
        r16.println(r17.toString());
        return;
    L21:
        return;
    L10:
        e = move-exception;
        throw new STException(j0.C("can't load dir ", r5), e);
    }

    public STGroupDir(String r5, String r10) {
        this(r5, r10, Typography.less, Typography.greater);
    }

    public STGroupDir(String r5, String r10, char r11, char r12) {
        this(r5, r11, r12);
        this.encoding = r10;
    }

    public STGroupDir(URL r5, String r10, char r11, char r12) {
        super(r11, r12);
        this.groupDirName = new File(r5.getFile()).getName();
        this.root = r5;
        this.encoding = r10;
    }
}
