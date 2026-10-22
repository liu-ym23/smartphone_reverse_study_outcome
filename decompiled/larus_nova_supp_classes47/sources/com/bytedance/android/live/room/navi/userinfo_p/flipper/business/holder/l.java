package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ k a;

    public l(k r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        Unit r7 = (Unit) r6;
        k r8 = this.a;
        View r0 = r8.f;
        if (r0 == null) goto L10;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r2 = new ViewGroup.MarginLayoutParams(r1.width, r1.height);
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r1;
        r2.topMargin = r3.topMargin;
        r2.bottomMargin = r3.bottomMargin;
        r2.rightMargin = r3.rightMargin;
        r2.leftMargin = r3.leftMargin;
        Unit r4 = Unit.INSTANCE;
        r8.j = r2;
    L8:
        r1.height = s1.f(36.0f);
        UIUtils.updateLayoutMargin(r0, -3, 0, -3, 0);
        r0.setLayoutParams(r1);
        return;
    }
}
