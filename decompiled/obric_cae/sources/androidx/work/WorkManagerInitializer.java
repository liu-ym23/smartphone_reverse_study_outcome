package androidx.work;

import android.content.Context;
import j1.b0;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class WorkManagerInitializer implements d1.b<v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2774a = null;

    static {
        f2774a = m.f("WrkMgrInitializer");
    }

    public WorkManagerInitializer() {
    }

    @Override // d1.b
    public final List<Class<? extends d1.b<?>>> a() {
        return Collections.emptyList();
    }

    @Override // d1.b
    public final v b(Context r8) {
        m.d().a(f2774a, "Initializing WorkManager with default configuration.");
        b0.i(r8, new c(new c.a()));
        return b0.f(r8);
    }
}
