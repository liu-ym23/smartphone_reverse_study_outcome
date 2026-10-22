package lt0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileTagContent;
import com.bytedance.android.live.profile.standard.tag.view.LiveLifeHonorView;
import com.bytedance.android.live.profile.ui.base.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements jt0.b {
    public a() {
    }

    @Override // jt0.b
    public final ViewGroup.LayoutParams a() {
        return null;
    }

    @Override // jt0.b
    public final boolean b(ProfileTagContent r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "tagContent");
        Intrinsics.checkNotNullParameter(r3, "profileContext");
        return false;
    }

    @Override // jt0.b
    public final void c(Fragment r1, View r2, ProfileTagContent r3, h r4, NewProfileUser r5) {
        Intrinsics.checkNotNullParameter(r1, "fragment");
        Intrinsics.checkNotNullParameter(r3, "tagContent");
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        Intrinsics.checkNotNullParameter(r5, "user");
    }

    @Override // jt0.b
    public final boolean e(ProfileTagContent r2, NewProfileUser r3, h r4) {
        Intrinsics.checkNotNullParameter(r2, "tagContent");
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        return false;
    }

    @Override // jt0.b
    public long getType() {
        return ProfileTagContent.TAG_TYPE_LOCAL_LIFE;
    }

    @Override // jt0.b
    public final View d(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new LiveLifeHonorView(r5, null, 6, 0);
    }

    @Override // jt0.b
    public final void f(NewProfileUser r3, h r4) {
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "profileContext");
    }

    @Override // jt0.b
    public final void g(ProfileTagContent r2, NewProfileUser r3, h r4) {
        Intrinsics.checkNotNullParameter(r2, "tagContent");
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        jt0.b.a.a(r2, r3, r4);
    }

    @Override // jt0.b
    public final void h(ProfileTagContent r2, NewProfileUser r3, h r4) {
        Intrinsics.checkNotNullParameter(r2, "tagContent");
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        jt0.b.a.b(r2, r3, r4);
    }
}
