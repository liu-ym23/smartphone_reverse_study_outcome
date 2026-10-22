package d5;

import android.annotation.SuppressLint;
import android.content.Context;
import org.json.JSONObject;
import x4.x0;

/* JADX INFO: loaded from: classes.dex */
public final class s extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f6826e;

    public s(Context r8) {
        super(true, true);
        this.f6826e = r8;
    }

    @Override // d5.d
    @SuppressLint({"MissingPermission"})
    public final boolean a(JSONObject r8) {
        x0.h(r8, "access", r5.e.b(this.f6826e));
        return true;
    }
}
