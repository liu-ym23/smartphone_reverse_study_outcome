package obric.flow.basics.impl.appcontext;

import android.app.Application;
import android.content.Context;
import iu.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f20429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f20430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final iu.b f20431c;
    public final Lazy d;

    public a(Application r5, Context r10, iu.b r11) {
        Intrinsics.checkNotNullParameter(r5, "application");
        Intrinsics.checkNotNullParameter(r10, "baseContext");
        Intrinsics.checkNotNullParameter(r11, "appBuildConfig");
        this.f20429a = r5;
        this.f20430b = r10;
        this.f20431c = r11;
        this.d = LazyKt.lazy(new AppContextImpl$contextThemeWrapper$2(this));
    }

    @Override // iu.c
    public final boolean a() {
        this.f20431c.getClass();
        return false;
    }

    @Override // iu.d
    public final Application getApplication() {
        return this.f20429a;
    }

    @Override // iu.d
    public final Context getContext() {
        return this.f20430b;
    }

    @Override // iu.d
    public final String getPackageName() {
        return this.f20430b.getPackageName();
    }
}
