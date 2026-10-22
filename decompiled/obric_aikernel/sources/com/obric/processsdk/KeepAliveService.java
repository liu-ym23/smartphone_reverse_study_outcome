package com.obric.processsdk;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class KeepAliveService extends Service {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f7780c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b extends na.a.AbstractBinderC0249a {
        b() {
        }

        @Override // na.a
        public boolean init() {
            return true;
        }
    }

    static {
        new a(null);
    }

    public KeepAliveService() {
        this.f7780c = new b();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        ka.a r11 = la.a.f10917a.a();
        if (r11 == null) goto L6;
        r11.i("KeepAliveService", "KeepAliveService onBind");
    L6:
        return this.f7780c;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ka.a r10 = la.a.f10917a.a();
        if (r10 == null) goto L6;
        r10.i("KeepAliveService", "KeepAliveService onCreate");
        return;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        ka.a r13 = la.a.f10917a.a();
        if (r13 == null) goto L6;
        r13.i("KeepAliveService", "KeepAliveService onStartCommand");
    L6:
        return super.onStartCommand(r10, r11, r12);
    }
}
