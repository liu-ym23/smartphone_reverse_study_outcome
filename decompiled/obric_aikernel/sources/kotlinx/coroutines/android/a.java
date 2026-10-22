package kotlinx.coroutines.android;

import android.os.Looper;
import java.util.List;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.internal.w;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements w {
    public a() {
    }

    @Override // kotlinx.coroutines.internal.w
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.w
    public g2 b(List<? extends w> r10) {
        Looper r11 = Looper.getMainLooper();
        if (r11 == null) goto L7;
        String r12 = null;
        return new HandlerContext(e.a(r11, true), r12, 2, 0 == true ? 1 : 0);
    L7:
        throw new IllegalStateException("The main looper is not available");
    }

    @Override // kotlinx.coroutines.internal.w
    public int c() {
        return 1073741823;
    }
}
