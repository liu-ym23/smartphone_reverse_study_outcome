package androidx.room.jarjarred.org.stringtemplate.v4;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public class NoIndentWriter extends AutoIndentWriter {
    public NoIndentWriter(Writer r5) {
        super(r5);
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.AutoIndentWriter, androidx.room.jarjarred.org.stringtemplate.v4.STWriter
    public int write(String r5) throws IOException {
        this.out.write(r5);
        return r5.length();
    }
}
