package jt0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileTagContent;
import com.bytedance.android.live.profile.ui.base.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b {

    public static final class a {
        public static void a(ProfileTagContent r1, NewProfileUser r2, h r3) {
            Intrinsics.checkNotNullParameter(r1, "tagContent");
            Intrinsics.checkNotNullParameter(r2, "user");
            Intrinsics.checkNotNullParameter(r3, "profileContext");
        }

        public static void b(ProfileTagContent r1, NewProfileUser r2, h r3) {
            Intrinsics.checkNotNullParameter(r1, "tagContent");
            Intrinsics.checkNotNullParameter(r2, "user");
            Intrinsics.checkNotNullParameter(r3, "profileContext");
        }
    }

    ViewGroup.LayoutParams a();

    boolean b(ProfileTagContent r1, h r2);

    void c(Fragment r1, View r2, ProfileTagContent r3, h r4, NewProfileUser r5);

    View d(Context r1);

    boolean e(ProfileTagContent r1, NewProfileUser r2, h r3);

    void f(NewProfileUser r1, h r2);

    void g(ProfileTagContent r1, NewProfileUser r2, h r3);

    long getType();

    void h(ProfileTagContent r1, NewProfileUser r2, h r3);
}
