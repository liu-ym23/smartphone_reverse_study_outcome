package lt0;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileTagContent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profile.standard.tag.view.StandardTagView;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class d implements jt0.b {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @Override // jt0.b
    public final ViewGroup.LayoutParams a() {
        return null;
    }

    @Override // jt0.b
    public long getType() {
        return ProfileTagContent.TAG_TYPE_UNKNOWN;
    }

    @Override // jt0.b
    public final View d(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        AttributeSet r3 = null;
        return new StandardTagView(r5, r3, 6, 0);
    }

    @Override // jt0.b
    public boolean b(ProfileTagContent r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "tagContent");
        Intrinsics.checkNotNullParameter(r3, "profileContext");
        return r2.clickHideProfile;
    }

    @Override // jt0.b
    public final void f(NewProfileUser r3, h r4) {
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "profileContext");
    }

    @Override // jt0.b
    public boolean e(ProfileTagContent r2, NewProfileUser r3, h r4) {
        Intrinsics.checkNotNullParameter(r2, "tagContent");
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        return r2.canClick;
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

    @Override // jt0.b
    public void c(Fragment r2, View r3, ProfileTagContent r4, h r5, NewProfileUser r6) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r4, "tagContent");
        Intrinsics.checkNotNullParameter(r5, "profileContext");
        Intrinsics.checkNotNullParameter(r6, "user");
        if (r3 != null) goto L12;
        return;
    L12:
        IBaseLiveActionHandler r7 = k.f(IBaseLiveActionHandler.class);     // Catch: Exception -> L9
        if (r7 == null) goto L14;
        r7.handle(r3.getContext(), r4.schema);     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        ALogger.e("StandardTagItem", "onTagClick handle schema error: " + e.getMessage());
    }
}
