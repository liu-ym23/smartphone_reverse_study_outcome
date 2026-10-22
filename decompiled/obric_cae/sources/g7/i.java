package g7;

import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class i extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f7739n;

    public i() {
        this.f7739n = false;
    }

    @Override // g7.a
    public final boolean b(long r8, String r10, JSONObject r11) {
        ArrayList r12 = new ArrayList();
        r12.add(0, Boolean.FALSE);
        boolean r13 = i(r11, r12);
        this.f7739n = ((Boolean) r12.get(0)).booleanValue();
        return r13;
    }

    public abstract a.EnumC0079a g(String r8, ArrayList r10);

    public abstract int h();

    public abstract boolean i(JSONObject r8, ArrayList r10);
}
