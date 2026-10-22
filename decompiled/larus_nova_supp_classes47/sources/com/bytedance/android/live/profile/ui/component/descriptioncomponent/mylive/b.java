package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements View.OnClickListener {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ALogger.i("ProfileMyLiveAvatarNameComponent", "component click");
    }
}
