package x4;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f13421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f13422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f13423e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f13424f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f13425g;

    public class a extends k5.l<PackageInfo> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g f13426c;

        public a(g r8) {
            this.f13426c = r8;
        }

        @Override // k5.l
        public final PackageInfo a(Object[] r8) {
            g r10 = this.f13426c;
            return r10.f13424f.getPackageManager().getPackageInfo(r10.f13424f.getPackageName(), 0);
        L5:
            int r11 = r.f13543a;
            return null;
        }
    }

    public g(k r8) {
        this.f13425g = new a(this);
        this.f13424f = r8.f13498j;
        this.f13419a = r8.f13501m;
        if (TextUtils.isEmpty(r8.f13502n) == false) goto L5;
        String r10 = "";
    L6:
        this.f13420b = r10;
        this.f13421c = r8.f13503o;
        this.f13422d = r8.f13504p;
        this.f13423e = r8.f13505q;
        return;
    L5:
        r10 = r8.f13502n;
        goto L6
    }
}
