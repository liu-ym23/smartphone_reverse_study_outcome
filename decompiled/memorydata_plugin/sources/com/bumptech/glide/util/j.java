package com.bumptech.glide.util;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    public static <T> T a(T r1) {
        return (T) a(r1, "Argument must not be null");
    }

    public static <T> T a(T r0, String r1) {
        Objects.requireNonNull(r0, r1);
        return r0;
    }

    public static String a(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L6;
        return r1;
    L6:
        throw new IllegalArgumentException("Must not be null or empty");
    }

    public static <T extends Collection<Y>, Y> T a(T r2) {
        T r3 = (T) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if (r3.isEmpty() == true) goto L6;
        return r3;
    L6:
        throw new IllegalArgumentException("Must not be empty.");
    }

    public static void a(boolean r0, String r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r1);
    }
}
