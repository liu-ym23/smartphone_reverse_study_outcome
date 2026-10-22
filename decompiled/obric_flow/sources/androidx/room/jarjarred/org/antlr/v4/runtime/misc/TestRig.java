package androidx.room.jarjarred.org.antlr.v4.runtime.misc;

import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import java.io.PrintStream;

/* JADX INFO: loaded from: classes.dex */
public class TestRig {
    public TestRig() {
    }

    public static void main(String[] r5) {
        System.err.println("Warning: TestRig moved to org.antlr.v4.gui.TestRig; calling automatically");     // Catch: ClassNotFoundException -> L7
        androidx.room.jarjarred.org.antlr.v4.gui.TestRig.class.getMethod(JvmProtoBufUtil.DEFAULT_MODULE_NAME, new Class[]{String[].class}).invoke(null, new Object[]{r5});     // Catch: Exception -> L5
    L9:
        return;
    L5:
        System.err.println("Problems calling org.antlr.v4.gui.TestRig.main(args)");     // Catch: ClassNotFoundException -> L7
    L7:
        PrintStream r10 = System.err;
        r10.println("Use of TestRig now requires the use of the tool jar, antlr-4.X-complete.jar");
        r10.println("Maven users need group ID org.antlr and artifact ID antlr4");
    }
}
