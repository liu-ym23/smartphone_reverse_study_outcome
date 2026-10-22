package com.ss.android.lark.chameleon.util;

import android.content.Context;
import com.ss.android.lark.chameleon.idependency.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chameleon/util/AssetsUtils;", BuildConfig.FLAVOR, "()V", "TAG", BuildConfig.FLAVOR, "readAssetsConfig", "context", "Landroid/content/Context;", "assetsName", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AssetsUtils {
    public static final AssetsUtils INSTANCE = null;
    private static final String TAG = "AssetsUtils";

    static {
        INSTANCE = new AssetsUtils();
    }

    private AssetsUtils() {
    }

    public final String readAssetsConfig(Context r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "assetsName");
        Context r7 = r5.getApplicationContext();
        if (r7 != null) goto L23;
        Log.e(TAG, "readAssetsConfig fail, context is null");
        return BuildConfig.FLAVOR;
    L23:
        InputStream r8 = r7.getAssets().open(r6);     // Catch: Exception -> L16
        String r2 = TextStreamsKt.readText(new InputStreamReader(r8, StandardCharsets.UTF_8));     // Catch: Throwable -> L11
    L9:
        CloseableKt.closeFinally(r8, null);     // Catch: Exception -> L16
        return r2;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Exception -> L16
        throw th;     // Catch: Exception -> L16
    L16:
        e = move-exception;
        Log.e(TAG, "readAssetsConfig fail, assetsName is " + r6, e);
        return BuildConfig.FLAVOR;
    }
}
