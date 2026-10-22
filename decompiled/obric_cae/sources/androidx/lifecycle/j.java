package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f2173a = null;

    public static final class a extends d {
        public a() {
        }

        @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r8, Bundle r10) {
            he.i.f(r8, "activity");
            int r11 = y.f2204b;
            y.b.b(r8);
        }
    }

    static {
        f2173a = new AtomicBoolean(false);
    }
}
