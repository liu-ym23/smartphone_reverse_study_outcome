package com.obric.assistant.session.singleton;

import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e {
    public static boolean a;
    public static final a b = null;

    public static final class a extends ContentObserver {
        public a(Handler r1) {
            super(r1);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r3) {
            super.onChange(r3);
            boolean r4 = e.a;
            boolean r1 = false;
            if (Settings.Secure.getInt(AppHost.a.getApplication().getContentResolver(), "lost_mode", 0) != 1) goto L5;
            r1 = true;
        L5:
            e.a = r1;
            FLogger.a.i("LostModeMonitor", "lost mode state changed to " + e.a);
        }
    }

    static {
        b = new a(t0.b);
    }
}
