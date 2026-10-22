package m9;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements c {
    public b() {
    }

    @Override // m9.c
    public final void c1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "scene");
    }

    @Override // m9.c
    public final double getCpuRate() {
        return 0.0d;
    }

    @Override // m9.c
    public final double getCpuSpeed() {
        return 0.0d;
    }

    @Override // m9.c
    public final float getTemperature() {
        return 0.0f;
    }

    @Override // m9.c
    public final void h0(String r1, Function2<? super Double, ? super JSONObject, Unit> r10) {
    }
}
