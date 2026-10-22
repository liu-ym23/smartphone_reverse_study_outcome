package sz7;

import android.content.Context;
import android.widget.ImageView;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Deprecated(level = DeprecationLevel.WARNING, message = "replaceWith: LarkAvatarView")
public final class v {
    public static boolean a;
    public static h b;
    public static final HashMap<Class<? extends g>, sz7.b<? extends g>> c = null;
    public static final b d = null;

    public static final class a {
        @Deprecated(message = "temp export, not use")
        @JvmStatic
        public static boolean a() {
            if (v.b != null) goto L7;
            return false;
        L7:
            return FeatureGatingModule.getFeatureGatingService().isEnable("lark_feature_doc_icon_custom");
        }
    }

    public static final class b implements j {
        public b() {
        }

        @Override // sz7.j
        public final void a(Context r1, String r2, String r3, int r4, int r5, ImageView r6) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r6, "imageView");
        }

        @Override // sz7.j
        public final void b(Context r1, String r2, String r3, String r4, int r5, int r6, r r7) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "key");
            r7.onError(new Throwable("icon load not implement"));
        }
    }

    static {
        c = new HashMap();
        d = new b();
    }
}
