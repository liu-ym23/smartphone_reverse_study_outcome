package com.obric.aikernel;

import android.content.Context;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class AIKernelApplication extends v7.b {

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public AIKernelApplication() {
    }

    @Override // v7.b, android.content.ContextWrapper
    protected void attachBaseContext(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "base");
        super.attachBaseContext(r10);
        InitTracker.f4402a.b();
    }

    @Override // v7.b, android.app.Application
    public void onCreate() {
        AIKLog r10 = AIKLog.INSTANCE;
        r10.v("_AIKernelApplication", "onCreate");
        super.onCreate();
        AppContext r11 = AppContext.INSTANCE;
        if (r11.isDebug() == false) goto L6;
        r10.d("_AIKernelApplication", "app is debug");
    L6:
        if (r11.isAdminMode() == false) goto L9;
        r10.d("_AIKernelApplication", "app is admin mode");
        return;
    }
}
