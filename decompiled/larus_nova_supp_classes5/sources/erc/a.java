package erc;

import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.shadowhook.ShadowHook;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static void a() {
        ByteHook.access$000();
        int r0 = ByteHook.access$100();
        ByteHook.access$200();
        ShadowHook.Mode r1 = ByteHook.access$300();
        ByteHook.b r2 = new ByteHook.b();
        r2.a = r0;
        r2.b = false;
        r2.c = false;
        r2.d = r1;
        r2.e = false;
        r2.f = false;
        ByteHook.init(r2);
    }

    public static void b() {
        ShadowHook.access$000();
        int r0 = ShadowHook.access$100();
        ShadowHook.b r1 = new ShadowHook.b();
        r1.a = r0;
        r1.b = false;
        r1.c = false;
        r1.d = false;
        ShadowHook.init(r1);
    }
}
