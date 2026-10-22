package androidx.room.jarjarred.org.stringtemplate.v4;

import ai.j0;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.CompiledST;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.STException;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ErrorType;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.Misc;
import java.io.File;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public class STGroupFile extends STGroup {
    protected boolean alreadyLoaded;
    public String fileName;
    public URL url;

    public STGroupFile(String r5) {
        this(r5, Typography.less, Typography.greater);
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STGroup
    public String getFileName() {
        return this.fileName;
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STGroup
    public String getName() {
        return Misc.getFileNameNoSuffix(this.fileName);
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STGroup
    public URL getRootDirURL() {
        String r10 = Misc.stripLastPathElement(this.url.toString());
        return new URL(r10);
    L5:
        e = move-exception;
        this.errMgr.runTimeError(null, null, ErrorType.INVALID_TEMPLATE_NAME, e, r10);
        return null;
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

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STGroup
    public String show() {
        if (this.alreadyLoaded == true) goto L6;
        load();
    L6:
        return super.show();
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STGroup
    public synchronized void unload() {
        monitor-enter(this);
        super.unload();     // Catch: Throwable -> L6
        this.alreadyLoaded = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public STGroupFile(String r5, char r10, char r11) {
        super(r10, r11);
        this.alreadyLoaded = false;
        if (r5.endsWith(STGroup.GROUP_FILE_EXTENSION) == false) goto L23;
        File r12 = new File(r5);
        if (r12.exists() == true) goto L24;
        URL r13 = getURL(r5);
        this.url = r13;
        if (r13 == null) goto L21;
        if (STGroup.verbose == false) goto L18;
        PrintStream r14 = System.out;
        StringBuilder r15 = j0.x("STGroupFile(", r5, ") == url ");
        r15.append(this.url);
        r14.println(r15.toString());
    L18:
        this.fileName = r5;
        return;
    L21:
        throw new IllegalArgumentException("No such group file: ".concat(r5));
    L24:
        this.url = r12.toURI().toURL();     // Catch: MalformedURLException -> L10
        if (STGroup.verbose == false) goto L18;
        PrintStream r16 = System.out;
        StringBuilder r17 = j0.x("STGroupFile(", r5, ") == file ");
        r17.append(r12.getAbsolutePath());
        r16.println(r17.toString());
    L10:
        e = move-exception;
        throw new STException("can't load group file ".concat(r5), e);
    L23:
        throw new IllegalArgumentException("Group file names must end in .stg: ".concat(r5));
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STGroup
    public void load() {
        if (this.alreadyLoaded == false) goto L5;
        return;
    L5:
        this.alreadyLoaded = true;
        if (STGroup.verbose == false) goto L8;
        System.out.println("loading group file " + this.url.toString());
    L8:
        loadGroupFile("/", this.url.toString());
        if (STGroup.verbose == false) goto L12;
        System.out.println("found " + this.templates.size() + " templates in " + this.url.toString() + " = " + this.templates.keySet());
        return;
    }

    public STGroupFile(String r5, String r10) {
        this(r5, r10, Typography.less, Typography.greater);
    }

    public STGroupFile(String r5, String r10, char r11, char r12) {
        this(r5, r11, r12);
        this.encoding = r10;
    }

    public STGroupFile(URL r5, String r10, char r11, char r12) {
        super(r11, r12);
        this.alreadyLoaded = false;
        this.url = r5;
        this.encoding = r10;
        String r13 = r5.toString();     // Catch: Exception -> L8
        if (r13.startsWith("jar:file:") == false) goto L6;
        r13 = r13.substring(4);     // Catch: Exception -> L8
    L6:
        this.fileName = new File(new URI(r13)).getAbsolutePath();     // Catch: Exception -> L8
        return;
    }
}
