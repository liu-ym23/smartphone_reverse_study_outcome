package com.obric.aikernel.middleware.api.appcontext.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.q1;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4528a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final g1<Integer> f4529b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final C0105a f4530c = null;

    /* JADX INFO: renamed from: com.obric.aikernel.middleware.api.appcontext.receiver.a$a, reason: collision with other inner class name */
    public static final class C0105a extends BroadcastReceiver {
        C0105a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            if (r11 == null) goto L5;
            a.a(a.f4528a, r11);
            return;
        }
    }

    static {
        f4528a = new a();
        f4529b = q1.a(0);
        f4530c = new C0105a();
    }

    private a() {
    }

    public static final /* synthetic */ void a(a r10, Intent r11) {
        r10.b(r11);
    }

    private final void b(Intent r10) {
        int r11 = r10.getIntExtra("level", 0);
        if (r11 < 0) goto L6;
        f4529b.c(Integer.valueOf(r11));
        return;
    }

    public final g1<Integer> c() {
        return f4529b;
    }

    public final void d(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intent r11 = r10.registerReceiver(f4530c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r11 == null) goto L6;
        f4528a.b(r11);
        return;
    }
}
