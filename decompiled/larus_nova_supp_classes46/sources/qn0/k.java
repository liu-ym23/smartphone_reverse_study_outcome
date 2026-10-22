package qn0;

import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import sn0.l;
import sn0.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    public static final class a implements m {
        public final HashMap<String, HashMap<String, String>> a;
        public final HashMap<String, String> b;
        public final rn0.a c;

        @Override // sn0.m
        public final l a(l r2) {
            return new qn0.a(this, r2);
        }

        public a(HashMap r2, HashMap r3, rn0.b r4) {
            Intrinsics.checkNotNullParameter(r2, "offsetLayoutConfigMap");
            Intrinsics.checkNotNullParameter(r3, "offsetUIFeatureMap");
            Intrinsics.checkNotNullParameter(r4, "provider");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b implements m {
        public final HashMap<String, HashMap<String, String>> a;
        public final HashMap<String, String> b;
        public final rn0.a c;

        @Override // sn0.m
        public final l a(l r2) {
            return new h(this, r2);
        }

        public b(HashMap r2, HashMap r3, rn0.b r4) {
            Intrinsics.checkNotNullParameter(r2, "offsetLayoutConfigMap");
            Intrinsics.checkNotNullParameter(r3, "offsetUIFeatureMap");
            Intrinsics.checkNotNullParameter(r4, "provider");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c implements m {
        public final HashMap<String, LayoutConfigModel> a;
        public final rn0.a b;

        @Override // sn0.m
        public final l a(l r1) {
            return new j(this);
        }

        public c(HashMap r2, rn0.b r3) {
            Intrinsics.checkNotNullParameter(r2, "updateOffsetLayoutConfigToCacheMap");
            Intrinsics.checkNotNullParameter(r3, "provider");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }
}
