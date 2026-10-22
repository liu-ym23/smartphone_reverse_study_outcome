package u4;

import com.bytedance.keva.Keva;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements c {
    public e() {
    }

    @Override // u4.c
    public final void b(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "storage");
        Intrinsics.checkNotNullParameter(r11, "key");
        Keva.getRepo(r10).erase(r11);
    }

    @Override // u4.c
    public final String a(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "storage");
        Intrinsics.checkNotNullParameter(r11, "key");
        return Keva.getRepo(r10).getString(r11, r12);
    }

    @Override // u4.c
    public final void c(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "storage");
        Intrinsics.checkNotNullParameter(r11, "key");
        Keva.getRepo(r10).storeString(r11, r12);
    }
}
