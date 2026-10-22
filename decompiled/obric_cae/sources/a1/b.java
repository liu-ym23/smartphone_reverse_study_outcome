package a1;

import android.database.Cursor;
import android.os.CancellationSignal;
import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public interface b extends Closeable {
    Cursor M(e r8, CancellationSignal r10);

    f S(String r8);

    Cursor a0(String r8);

    void c();

    void e(String r8);

    boolean isOpen();

    boolean j0();

    boolean k0();

    void m();

    void o();

    Cursor q(e r8);

    void t();
}
