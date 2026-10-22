package obric.flow.miniappwidget;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f20514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f20515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f20516c;
    public boolean d;
    public final j8.a e;

    public q(Context r5, Function0 r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "onServerAlive");
        this.f20514a = r10;
        this.f20515b = r5.getApplicationContext();
        this.f20516c = Uri.parse("content://com.obric.appletapp.SystemAppletProvider").buildUpon().appendPath("server_alive").build();
        this.e = new j8.a(this, new Handler(Looper.getMainLooper()), 2);
    }
}
