package ni;

import android.util.LruCache;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map f20263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LruCache f20264b;

    public a(String r5, int r10, LinkedHashMap r11) {
        Intrinsics.checkNotNullParameter(r5, "namespace");
        Intrinsics.checkNotNullParameter(r11, "configMap");
        this.f20263a = MapsKt.emptyMap();
        if (r10 > 0) goto L5;
        r10 = 32;
    L5:
        this.f20264b = new LruCache(r10);
        this.f20263a = r11;
    }

    public static String a(String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        Object[] r10 = new Regex("[.]").split(r5, 0).toArray(new String[0]);
        if (r10 == null) goto L15;
        String[] r11 = (String[]) r10;
        int r12 = r11.length;
        if (r12 >= 2) goto L10;
        return null;
    L10:
        if (r12 != 2) goto L13;
        return r5;
    L13:
        return r11[r12 - 2] + '.' + r11[r12 - 1];
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
