package com.bytedance.android.live.componentsmarket.impl.components.title;

import am2.x;
import android.view.View;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ TitleTetris a;

    public e(TitleTetris r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        TitleTetris r0 = this.a;
        boolean r7 = ((Boolean) r6).booleanValue();
        View r1 = r0.v;
        if (r1 == null) goto L13;
        if (r7 == false) goto L10;
        int r3 = 0;
        if (PadConfigUtils.c() == false) goto L8;
    L9:
        u.l().d("livesdk_live_intro_title_show", new Object[]{Room.class, x.class});
    L11:
        r1.setVisibility(r3);
        return;
    L8:
        if (CollectionsKt.listOf(new Integer[]{1, 9}).contains(Integer.valueOf(e5.a())) == true) goto L9;
    L10:
        r3 = 8;
        goto L11
    }
}
