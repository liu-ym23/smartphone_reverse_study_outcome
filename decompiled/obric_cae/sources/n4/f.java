package n4;

import he.j;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f extends j implements ge.a<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HashMap<Object, JSONObject> f9438b;

    public f(f2.a r8, int r10, HashMap<Object, JSONObject> r11) {
        this.f9437a = r10;
        this.f9438b = r11;
        super(0);
    }

    @Override // ge.a
    public final String f() {
        return "null handle missed group: " + this.f9437a + " with " + this.f9438b.size() + " events...";
    }
}
