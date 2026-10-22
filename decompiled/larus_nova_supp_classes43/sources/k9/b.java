package k9;

import com.bytedance.ies.web.jsbridge2.u;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements e {

    public static final class a implements d {
        public a() {
        }

        @Override // k9.d
        public final void a(String r1, String r10, int r11) {
            Intrinsics.checkNotNullParameter(r1, "monitorId");
            Intrinsics.checkNotNullParameter(r10, "key");
        }

        @Override // k9.d
        public final void b(String r1, int r10) {
            Intrinsics.checkNotNullParameter(r1, "monitorId");
            Intrinsics.checkNotNullParameter("scene", "field");
        }

        @Override // k9.d
        public final void c(String r1, String r10, long r11) {
            Intrinsics.checkNotNullParameter(r1, "monitorId");
            Intrinsics.checkNotNullParameter(r10, "field");
        }

        @Override // k9.d
        public final void d(String r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r10, "monitorId");
            Intrinsics.checkNotNullParameter(r11, "key");
            Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        }
    }

    public b() {
    }

    @Override // k9.e
    public final d V0() {
        return new a();
    }

    @Override // k9.e
    public final List<b7.a> T() {
        return CollectionsKt.emptyList();
    }

    @Override // k9.e
    public final List<u> Z0() {
        return CollectionsKt.emptyList();
    }

    @Override // k9.e
    public final j9.b H0() {
        return j9.b.C0169b.a;
    }
}
