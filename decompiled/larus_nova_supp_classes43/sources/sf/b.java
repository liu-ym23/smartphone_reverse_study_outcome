package sf;

import com.bytedance.android.ec.core.apt.IECAPTService;
import com.bytedance.android.shopping.extensions.k;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import lg.c;
import lg.h;
import lg.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements IECAPTService {
    public b() {
    }

    @Override // com.bytedance.android.ec.core.apt.IECAPTService
    public final void record(c r10) {
        Intrinsics.checkNotNullParameter(r10, "node");
        ArrayList<i> r0 = a.a;
        a.a(r10);
    }

    @Override // com.bytedance.android.ec.core.apt.IECAPTService
    public final void registerPlugin(i r10) {
        Intrinsics.checkNotNullParameter(r10, "plugin");
        ArrayList<i> r1 = a.a;
        Intrinsics.checkNotNullParameter(r10, "plugin");
        a.a.add(r10);
    }

    @Override // com.bytedance.android.ec.core.apt.IECAPTService
    public final void diff(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        ArrayList<i> r0 = a.a;
        a.a(new h(r10 + "_old", k.w(r11)));
        a.a(new h(r10 + "_new", k.w(r12)));
    }
}
