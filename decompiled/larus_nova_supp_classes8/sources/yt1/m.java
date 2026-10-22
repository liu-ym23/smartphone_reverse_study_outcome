package yt1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface m {

    public static final class a {
        public static void a(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "type");
            Intrinsics.checkNotNullParameter(r2, "reason");
        }
    }

    void a(com.bytedance.android.livesdk.dslservice.a r1, boolean r2, String r3);

    void b(String r1, String r2, Throwable r3);

    void onFetchSuccess();
}
