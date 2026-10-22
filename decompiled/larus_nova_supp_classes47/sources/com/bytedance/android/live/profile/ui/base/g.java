package com.bytedance.android.live.profile.ui.base;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileSkin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface g {
    void b(d r1);

    void d(NewProfileUser r1);

    void e(ProfileSkin r1);

    void f();

    void g(NewProfileUser r1);

    ComponentType getComponentType();

    void onComponentDestroy();

    void update(NewProfileUser r1);
}
