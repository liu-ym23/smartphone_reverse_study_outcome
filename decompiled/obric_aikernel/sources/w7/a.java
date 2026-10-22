package w7;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.keva.Keva;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements t7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Keva f13412a;

    public a(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        this.f13412a = Keva.getRepo(r10, r11);
        new HashMap();
    }

    @Override // t7.a
    public String a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        String r11 = this.f13412a.getString(r10, "");
        Intrinsics.checkNotNullExpressionValue(r11, "keva.getString(key, \"\")");
        return r11;
    }

    @Override // t7.a
    public void b(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        this.f13412a.storeString(r10, r11);
    }

    @Override // t7.a
    public void c(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        this.f13412a.storeBoolean(r10, r11);
    }

    @Override // t7.a
    public boolean contains(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return this.f13412a.contains(r10);
    }

    @Override // t7.a
    public void d(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        this.f13412a.storeInt(r10, r11);
    }

    @Override // t7.a
    public String[] e() {
        return (String[]) this.f13412a.getAll().keySet().toArray(new String[0]);
    }

    @Override // t7.a
    public boolean f(String... r10) {
        Intrinsics.checkNotNullParameter(r10, "keys");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        String r13 = r10[r12];
        this.f13412a.erase(r13);
        r12 = r12 + 1;
        goto L3
    L5:
        return true;
    }

    @Override // t7.a
    public int g(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return this.f13412a.getInt(r10, 0);
    }

    @Override // t7.a
    public boolean getBoolean(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return this.f13412a.getBoolean(r10, r11);
    }

    @Override // t7.a
    public int getInt(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return this.f13412a.getInt(r10, r11);
    }

    @Override // t7.a
    public String getString(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        String r12 = this.f13412a.getString(r10, r11);
        if (r12 != null) goto L6;
        return "";
    L6:
        return r12;
    }
}
