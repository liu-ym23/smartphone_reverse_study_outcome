package mh;

import cj.b;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    @JvmStatic
    public static final void a() {
        int r0 = ECSdk.a;
        b r1 = (b) ECSdk.a(b.class);
        if (r1 == null) goto L6;
        r1.closeAnimDelay();
        return;
    }

    @JvmStatic
    public static final void b() {
        int r0 = ECSdk.a;
        b r1 = (b) ECSdk.a(b.class);
        if (r1 == null) goto L6;
        r1.openAnimDelay();
        return;
    }

    static {
    }
}
