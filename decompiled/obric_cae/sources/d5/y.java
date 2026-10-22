package d5;

import org.json.JSONObject;
import x4.j0;
import x4.x0;

/* JADX INFO: loaded from: classes.dex */
public final class y extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j0 f6832e;

    public y(j0 r8) {
        super(true, false);
        this.f6832e = r8;
    }

    @Override // d5.d
    public final boolean a(JSONObject r8) {
        k5.k.a r10 = k5.k.f8943a;
        x0.h(r8, "sim_region", this.f6832e.H.f7907c.I.getSimCountryIso());
        return true;
    }
}
