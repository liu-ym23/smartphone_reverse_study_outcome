package obric.flow.miniappwidget;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1 f20502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f20503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f20504c;
    public boolean d;
    public final j8.a e;

    public m(Context r5, Function1 r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "onAppletInstallStateChanged");
        this.f20502a = r10;
        this.f20503b = r5.getApplicationContext();
        this.f20504c = Uri.parse("content://com.obric.appletapp.SystemAppletProvider").buildUpon().appendPath("applet_install_changed").build();
        this.e = new j8.a(this, new Handler(Looper.getMainLooper()), 1);
    }
}
