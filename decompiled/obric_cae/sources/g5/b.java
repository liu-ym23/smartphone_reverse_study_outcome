package g5;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class b<SERVICE> implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f7644b;

    public class a extends k5.l<Boolean> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f7645c;

        public a(b r8) {
            this.f7645c = r8;
        }

        @Override // k5.l
        public final Boolean a(Object[] r8) {
            boolean r10 = false;
            Context r11 = (Context) r8[0];
            String r12 = this.f7645c.f7643a;
            if (r11.getPackageManager().getPackageInfo(r12, 128) == null) goto L7;
            r10 = true;
        L7:
            return Boolean.valueOf(r10);
        }
    }

    public b(String r8) {
        this.f7644b = new a(this);
        this.f7643a = r8;
    }

    @Override // g5.m
    public m.a a(Context r8) {
        String r10 = (String) new t(r8, c(r8), d()).a();
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return null;
    L5:
        m.a r11 = new m.a();
        r11.f7667a = r10;
        return r11;
    }

    @Override // g5.m
    public final boolean b(Context r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        return this.f7644b.b(new Object[]{r8}).booleanValue();
    }

    public abstract Intent c(Context r8);

    public abstract t.b<SERVICE, String> d();
}
