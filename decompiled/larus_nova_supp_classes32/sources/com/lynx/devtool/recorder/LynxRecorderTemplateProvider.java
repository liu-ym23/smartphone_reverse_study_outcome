package com.lynx.devtool.recorder;

import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxRecorderTemplateProvider extends d8a.b {
    private final OkHttpClient client;
    private final Handler mainHandler;

    /* JADX INFO: renamed from: com.lynx.devtool.recorder.LynxRecorderTemplateProvider$1, reason: invalid class name */
    public class AnonymousClass1 implements Callback {
        final /* synthetic */ LynxRecorderTemplateProvider this$0;
        final /* synthetic */ d8a.b.a val$callback;

        public static /* synthetic */ void a(d8a.b.a r0, byte[] r1) {
            lambda$onResponse$2(r0, r1);
        }

        public static /* synthetic */ void b(d8a.b.a r0, IOException r1) {
            lambda$onFailure$0(r0, r1);
        }

        public static /* synthetic */ void c(d8a.b.a r0, IOException r1) {
            lambda$onResponse$1(r0, r1);
        }

        public AnonymousClass1(LynxRecorderTemplateProvider r1, d8a.b.a r2) {
            this.this$0 = r1;
            this.val$callback = r2;
        }

        private static /* synthetic */ void lambda$onFailure$0(d8a.b.a r0, IOException r1) {
            r0.onFailed(r1.toString());
        }

        private static /* synthetic */ void lambda$onResponse$1(d8a.b.a r0, IOException r1) {
            r0.onFailed(r1.toString());
        }

        private static /* synthetic */ void lambda$onResponse$2(d8a.b.a r0, byte[] r1) {
            r0.onSuccess(r1);
        }

        public void onFailure(Call r3, final IOException r4) {
            Handler r5 = LynxRecorderTemplateProvider.access$000(this.this$0);
            final d8a.b.a r0 = this.val$callback;
            r5.post(new i(r0, r4));
        }

        public void onResponse(Call r3, Response r4) throws IOException {
            if (r4.isSuccessful() == true) goto L6;
            final IOException r5 = new IOException("Unexpected code: " + r4);
            Handler r6 = LynxRecorderTemplateProvider.access$000(this.this$0);
            final d8a.b.a r0 = this.val$callback;
            r6.post(new j(r0, r5));
            return;
        L6:
            final byte[] r7 = r4.body().bytes();
            Handler r8 = LynxRecorderTemplateProvider.access$000(this.this$0);
            final d8a.b.a r1 = this.val$callback;
            r8.post(new k(r1, r7));
        }
    }

    public LynxRecorderTemplateProvider() {
        this.client = new OkHttpClient();
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    public static /* synthetic */ Handler access$000(LynxRecorderTemplateProvider r0) {
        return r0.mainHandler;
    }

    @Override // d8a.b
    public void loadTemplate(String r2, d8a.b.a r3) {
        Request r4 = new Request.Builder().url(r2).build();
        this.client.newCall(r4).enqueue(new AnonymousClass1(this, r3));
    }
}
