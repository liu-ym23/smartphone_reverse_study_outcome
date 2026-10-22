package lt0;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileTagContent;
import com.bytedance.android.live.base.model.user.WhiteCategoryCert;
import com.bytedance.android.live.profile.ui.base.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e extends d {
    @Override // lt0.d, jt0.b
    public final boolean b(ProfileTagContent r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "tagContent");
        Intrinsics.checkNotNullParameter(r3, "profileContext");
        return false;
    }

    @Override // lt0.d, jt0.b
    public final boolean e(ProfileTagContent r2, NewProfileUser r3, h r4) {
        Intrinsics.checkNotNullParameter(r2, "tagContent");
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        return true;
    }

    public e() {
    }

    @Override // lt0.d, jt0.b
    public long getType() {
        return ProfileTagContent.TAG_TYPE_WHITE_CERT;
    }

    @Override // lt0.d, jt0.b
    public final void c(Fragment r2, View r3, ProfileTagContent r4, h r5, NewProfileUser r6) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r4, "tagContent");
        Intrinsics.checkNotNullParameter(r5, "profileContext");
        Intrinsics.checkNotNullParameter(r6, "user");
        if (r3 == null) goto L14;
        Context r7 = r3.getContext();
        if (r7 == null) goto L16;
        WhiteCategoryCert r8 = r6.whiteCategoryCert;
        if (r8 == null) goto L15;
        WhiteCategoryCert.SubCertInfo r9 = r8.subCertInfo;
        if (r9 == null) goto L17;
        r5.showWhiteCertPageNoLog(r7, r9);
        return;
    L17:
        return;
    L15:
        return;
    L16:
        return;
    }
}
