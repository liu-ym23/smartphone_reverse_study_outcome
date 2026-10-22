package sz7;

import android.content.Context;
import com.ss.android.lark.assembly.avatar.officesdk.OfficeInitAvatarLoaderTask;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class t {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static s a(Context r6) {
            Intrinsics.checkNotNullParameter(r6, "context");
            OfficeInitAvatarLoaderTask.a r1 = v.b;
            if (r1 == null) goto L12;
            OfficeInitAvatarLoaderTask.a r2 = r1;
            if (r2.a != null) goto L10;
            Log.i("OfficeAvatar", String.format("fg, docIcon:%s, badgeTag:%s, threadBadge:%s", new Object[]{Boolean.valueOf(FeatureGatingModule.getFeatureGatingService().isEnable("lark_feature_doc_icon_custom")), Boolean.TRUE, Boolean.valueOf(FeatureGatingModule.getFeatureGatingService().isEnable("lark_feature_doc_icon_custom"))}));
            if (com.larksuite.framework.utils.z.e(r2.b) == false) goto L9;
            r2.a = new OfficeInitAvatarLoaderTask.g();
            goto L10
        L9:
            r2.a = new OfficeInitAvatarLoaderTask.h();
        L10:
            j r3 = r2.a;
            if (r3 == null) goto L12;
        L14:
            return new s(r6, r3);
        L12:
            r3 = v.d;
            goto L14
        }
    }

    static {
    }
}
