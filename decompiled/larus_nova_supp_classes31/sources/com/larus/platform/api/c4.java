package com.larus.platform.api;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface c4 {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static String a() {
            String r0 = AppHost.a.getApplication().getCacheDir().getPath() + "/vesdk";
            PolarisFileWrapper r1 = new PolarisFileWrapper(r0);
            if (r1.exists() == true) goto L5;
            r1.mkdirs();
        L5:
            return r0;
        }
    }

    public interface b {
        void onError(String r1);

        void onSuccess(boolean r1);
    }

    public interface c {
        void a(int r1, String r2);

        void onCompileDone();

        void onCompileProgress(float r1);
    }

    static {
        a = a.a;
    }

    void a(Integer r1, long r2);
}
