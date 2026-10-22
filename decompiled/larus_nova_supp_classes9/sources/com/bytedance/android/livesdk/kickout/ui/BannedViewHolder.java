package com.bytedance.android.livesdk.kickout.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bd2.a;
import bd2.b;
import bf1.e;
import bf1.f;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.widget.VHeadView;
import dd2.c;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class BannedViewHolder extends RecyclerView.ViewHolder implements b, f {
    public static final /* synthetic */ int n = 0;
    public VHeadView a;
    public TextView b;
    public View c;
    public TextView d;
    public HSImageView e;
    public final Context f;
    public List<User> g;
    public final String h;
    public final a i;
    public final e j;
    public User k;
    public final long l;
    public final String m;

    @Override // bd2.b
    public final void H3(c r1, Exception r2) {
    }

    public final void N1(Exception r1) {
    }

    @Override // bd2.b
    public final void hideLoading() {
    }

    @Override // bd2.b
    public final void C2(boolean r4) {
        if (r4 == true) goto L5;
        this.b.setVisibility(0);
        this.c.setVisibility(8);
        xs2.b.a().post(new cd2.b(false, this.k.getIdStr()));
        f2.b(2131919763, 0);
        return;
    }

    public final void v3(boolean r3) {
        if (r3 == true) goto L7;
        xs2.b.a().post(new cd2.a(this.k.getIdStr()));
        this.b.setVisibility(0);
        this.c.setVisibility(8);
        if (tb1.c.a == true) goto L8;
        f2.b(2131919763, 0);
        return;
    L8:
        return;
    }

    @Override // bd2.b
    public final void x3(boolean r2, Exception r3) {
        if (r2 == true) goto L5;
        this.b.setVisibility(0);
        this.c.setVisibility(8);
        ExceptionUtils.handleException(this.f, r3);
        return;
    }

    public BannedViewHolder(Context r2, View r3, String r4, long r5, String r7) {
        super(r3);
        this.g = new ArrayList();
        this.a = r3.findViewById(2131374294);
        this.b = (TextView) r3.findViewById(2131365123);
        this.c = r3.findViewById(2131365130);
        this.d = (TextView) r3.findViewById(2131392049);
        this.e = r3.findViewById(2131392013);
        this.f = r2;
        this.h = r4;
        this.l = r5;
        this.m = r7;
        a r6 = new a();
        this.i = r6;
        r6.a = this;
        e r8 = new e();
        this.j = r8;
        r8.a = this;
    }
}
