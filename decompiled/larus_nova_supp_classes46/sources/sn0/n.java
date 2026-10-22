package sn0;

import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    public static final class a implements m {
        public final List<pn0.a> a;
        public final rn0.a b;

        @Override // sn0.m
        public final l a(l r2) {
            return new sn0.b(this, r2);
        }

        public a(List r2, rn0.b r3) {
            Intrinsics.checkNotNullParameter(r2, "geckoLayoutConfigReviewList");
            Intrinsics.checkNotNullParameter(r3, "provider");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b implements m {
        public final List<pn0.a> a;
        public final rn0.a b;

        @Override // sn0.m
        public final l a(l r2) {
            return new i(this, r2);
        }

        public b(List r2, rn0.b r3) {
            Intrinsics.checkNotNullParameter(r2, "localAssetsEntranceList");
            Intrinsics.checkNotNullParameter(r3, "provider");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c implements m {
        public final HashMap<String, LayoutConfigModel> a;
        public final rn0.a b;

        @Override // sn0.m
        public final l a(l r1) {
            return new k(this);
        }

        public c(HashMap r2, rn0.b r3) {
            Intrinsics.checkNotNullParameter(r2, "layoutConfigResMap");
            Intrinsics.checkNotNullParameter(r3, "provider");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }
}
