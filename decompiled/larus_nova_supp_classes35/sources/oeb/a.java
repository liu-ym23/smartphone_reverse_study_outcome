package oeb;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.passportc.dwarf.UserScope;
import f0c.h;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class a implements d, r {
    public final m a;
    public final AtomicBoolean b;

    /* JADX INFO: renamed from: oeb.a$a, reason: collision with other inner class name */
    public static final class C0272a {
    }

    static {
    }

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // oeb.d
    public final boolean get() {
        return this.b.get();
    }

    public final m getPassport() {
        return this.a;
    }

    @Inject
    public a(m r3) {
        Intrinsics.checkNotNullParameter(r3, "passport");
        this.a = r3;
        this.b = new AtomicBoolean(false);
        r3.d(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r2, "state");
        Log.i("FeedStrangerData", "rest stranger available");
        this.b.set(false);
    }

    @Override // oeb.d
    public void update(boolean r3) {
        Log.i("FeedStrangerData", "update stranger available " + r3);
        this.b.set(r3);
    }
}
