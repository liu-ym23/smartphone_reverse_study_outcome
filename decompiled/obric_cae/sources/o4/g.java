package o4;

import android.annotation.SuppressLint;
import com.bytedance.keva.KevaImpl;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public final class g extends a {
    @Override // o4.a
    @SuppressLint({"[ByDesign7.4]WeakPRNG"})
    public final boolean c(b r8) {
        int r10 = a();
        if (r10 >= 0) goto L6;
        return true;
    L6:
        if (r10 <= 0) goto L9;
        return false;
    L9:
        if (new Random().nextInt(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD) < this.f9647a) goto L12;
        return true;
    L12:
        return false;
    }
}
