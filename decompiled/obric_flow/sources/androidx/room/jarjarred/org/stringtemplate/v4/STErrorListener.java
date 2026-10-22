package androidx.room.jarjarred.org.stringtemplate.v4;

import androidx.room.jarjarred.org.stringtemplate.v4.misc.STMessage;

/* JADX INFO: loaded from: classes.dex */
public interface STErrorListener {
    void IOError(STMessage r5);

    void compileTimeError(STMessage r5);

    void internalError(STMessage r5);

    void runTimeError(STMessage r5);
}
