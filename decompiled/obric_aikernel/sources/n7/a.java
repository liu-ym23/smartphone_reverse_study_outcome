package n7;

import android.content.Context;
import android.os.PowerManager;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.q1;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements PowerManager.OnThermalStatusChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11264a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final g1<Integer> f11265b = null;

    static {
        f11264a = new a();
        f11265b = q1.a(6);
    }

    private a() {
    }

    public final g1<Integer> a() {
        return f11265b;
    }

    public final int b() {
        return f11265b.getValue().intValue();
    }

    public final void c(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Object r11 = r10.getSystemService("power");
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager r12 = (PowerManager) r11;
        f11265b.c(Integer.valueOf(r12.getCurrentThermalStatus()));
        r12.addThermalStatusListener(this);
    }

    @Override // android.os.PowerManager.OnThermalStatusChangedListener
    public void onThermalStatusChanged(int r10) {
        f11265b.c(Integer.valueOf(r10));
    }
}
