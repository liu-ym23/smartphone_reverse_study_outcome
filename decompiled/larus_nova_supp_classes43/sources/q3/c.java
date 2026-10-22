package q3;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    static {
    }

    public static HttpUrl a(HttpUrl r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (Intrinsics.areEqual(ListProtector.get(r10.pathSegments(), r10.pathSize() - 1), "") == true) goto L7;
        HttpUrl.a r11 = r10.newBuilder();
        r11.getClass();
        r11.e("", 0, 0, false, false);
        return r11.b();
    L7:
        return r10;
    }

    public static HttpUrl b(HttpUrl r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r0 = r10.pathSize() - 1;
        if (Intrinsics.areEqual(ListProtector.get(r10.pathSegments(), r0), "") == false) goto L9;
        HttpUrl.a r11 = r10.newBuilder();
        ListProtector.remove(r11.f, r0);
        if (((ArrayList) r11.f).isEmpty() == false) goto L8;
        ((ArrayList) r11.f).add("");
    L8:
        return r11.b();
    L9:
        return r10;
    }
}
