package com.bytedance.android.live.search.impl.search.adapter;

import android.view.View;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.config.d7;
import com.bytedance.android.livesdk.config.lb;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ LiveSearchUserAdapter a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ LiveSearchUserViewHolder c;
    public final /* synthetic */ User d;

    public a(LiveSearchUserAdapter r1, Ref.BooleanRef r2, LiveSearchUserViewHolder r3, User r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        int r5 = d7.a;
        if (((Boolean) lb.a.getValue()).booleanValue() == false) goto L8;
        if (this.a.d == true) goto L8;
        return;
    L8:
        if (this.b.element == false) goto L10;
        return;
    L10:
        LiveSearchUserViewHolder r6 = this.c;
        r6.T3().setSelected(!r6.T3().isSelected());
        Function3<? super User, ? super LiveSearchUserViewHolder, ? super Boolean, Unit> r7 = this.a.b;
        User r0 = this.d;
        LiveSearchUserViewHolder r1 = this.c;
        r7.invoke(r0, r1, Boolean.valueOf(r1.T3().isSelected()));
    }
}
