package com.bytedance.android.live.plugin_api;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a {
    public static final C0188a a = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.plugin_api.a$a, reason: collision with other inner class name */
    public static final class C0188a {
        public static final com.bytedance.android.live.plugin_impl.service.a a = null;
        public static final /* synthetic */ C0188a b = null;

        public C0188a() {
        }

        static {
            b = new C0188a();
            a = new com.bytedance.android.live.plugin_impl.service.a();
        }
    }

    static {
        a = C0188a.b;
    }

    a addOnFail(js0.a r1);

    a addOnSuccess(js0.b r1);

    a callbackOnMainThread();

    void justPrepare();

    void justPrepare(String r1);

    void requireByUser(String r1);

    a syncCallbackIfReady(boolean r1);

    a update(int r1);
}
