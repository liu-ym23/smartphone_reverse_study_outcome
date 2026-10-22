package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.adapter.AudiencePortraitSettingAdapter;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ AudienceExperienceSettingDialog a;

    public b(AudienceExperienceSettingDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Integer r3 = (Integer) r2;
        if (r3.intValue() <= 0) goto L7;
        AudiencePortraitSettingAdapter<? extends np1.b> r0 = this.a.C;
        if (r0 == null) goto L11;
        r0.notifyItemChanged(r3.intValue());
        return;
    L11:
        return;
    L7:
        AudiencePortraitSettingAdapter<? extends np1.b> r4 = this.a.C;
        if (r4 == null) goto L13;
        r4.notifyDataSetChanged();
        return;
    }
}
