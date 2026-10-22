package com.bytedance.android.live.profile.ui.component.base;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import kotlin.jvm.internal.Intrinsics;
import ut0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface e<T> {

    public static final class a {
        public static void a(NewProfileUser r1, f r2) {
            Intrinsics.checkNotNullParameter(r1, "user");
            Intrinsics.checkNotNullParameter(r2, "logUseCase");
        }

        public static <T> void update(e<T> r0, T r1, NewProfileUser r2) {
            Intrinsics.checkNotNullParameter(r2, "user");
        }
    }

    void a(T r1, NewProfileUser r2, f r3);

    void c(T r1, NewProfileUser r2);

    void d(T r1, ProfileSkin r2);

    void e(T r1);

    void update(T r1, NewProfileUser r2);
}
