package com.obric.aiagent.messenger.stub;

import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.i2;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class AppIntentIDLStub$c implements Runnable {
    public final /* synthetic */ AppIntentIDLStub$d a;

    public static final class a implements Function0<Unit> {
        public final /* synthetic */ List<String> a;
        public final /* synthetic */ AppIntentIDLStub$d b;

        public a(List<String> r1, AppIntentIDLStub$d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object invoke() {
            FragmentActivity r0 = AppHost.a.a().getCurrentActivity();
            if ((r0 instanceof FragmentActivity) == false) goto L5;
            FragmentActivity r1 = r0;
        L6:
            FragmentActivity r2 = r1;
            if (r2 == null) goto L10;
            List<String> r3 = this.a;
            AppIntentIDLStub$d r4 = this.b;
            i2 r5 = i2.b;
            com.larus.platform.api.g1.a.b(r2, r3, r4, null, null, 56);
        L10:
            return Unit.INSTANCE;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class b implements Function0<Unit> {
        public final /* synthetic */ AppIntentIDLStub$d a;
        public final /* synthetic */ List<String> b;

        public b(AppIntentIDLStub$d r1, List<String> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object invoke() {
            this.a.onResult(false, CollectionsKt.emptyList(), this.b, false);
            return Unit.INSTANCE;
        }
    }

    public AppIntentIDLStub$c(AppIntentIDLStub$d r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List r0 = CollectionsKt.listOf(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"});     // Catch: Throwable -> L4
        AppIntentIDLStub$d r2 = this.a;     // Catch: Throwable -> L4
        com.obric.assistant.spi.keyguard.a.a(new a(r0, r2), new b(r2, r0), null, false, 28);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
