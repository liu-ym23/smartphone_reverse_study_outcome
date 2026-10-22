package qe;

import android.os.Looper;
import java.util.List;
import pe.l1;
import ue.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements o {
    public a() {
    }

    @Override // ue.o
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // ue.o
    public l1 b(List<? extends o> r8) {
        Looper r10 = Looper.getMainLooper();
        if (r10 == null) goto L7;
        return new f(h.a(r10));
    L7:
        throw new IllegalStateException("The main looper is not available");
    }

    @Override // ue.o
    public int c() {
        return 1073741823;
    }
}
