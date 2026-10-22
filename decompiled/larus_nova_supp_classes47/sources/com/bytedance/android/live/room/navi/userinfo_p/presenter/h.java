package com.bytedance.android.live.room.navi.userinfo_p.presenter;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements e91.b {
    public final int a;
    public final int b;
    public final int c;
    public final /* synthetic */ UserInfoTabPresenter d;

    public static final class a implements n81.b {
        public final /* synthetic */ h b;

        @Override // n81.b
        public final void onShow() {
            IRoom r0 = this.b.d.b();
            if (r0 == null) goto L6;
            String r1 = com.bytedance.android.live.room.navi.userinfo_p.utils.b.a(r0);
            if (r1 == null) goto L6;
        L7:
            UserInfoTabPresenter.x(r1);
            return;
        L6:
            r1 = "";
            goto L7
        }

        public a(h r1) {
            this.b = r1;
        }
    }

    @Override // e91.b
    public final void a() {
        UIUtils.setViewVisibility(this.d.g, 8);
        UIUtils.setViewVisibility(this.d.l, 8);
        UIUtils.setViewVisibility(this.d.j, 8);
    }

    @Override // e91.b
    public final ViewGroup getContainer() {
        return this.d.k;
    }

    @Override // e91.b
    public final void onShow() {
        IRoom r0 = this.d.b();
        if (r0 != null) goto L5;
    L7:
        UserInfoTabPresenter.h(this.d);
        ViewGroup r1 = this.d.k;
        if (r1 == null) goto L11;
        n81.b.a.getClass();
        r1.setTag(2131389804, new a(this));
        return;
    L11:
        return;
    L5:
        if (r0.isVipRoom() != true) goto L7;
        UserInfoTabPresenter r2 = this.d;
        r2.getClass();
        j0.l().sendLog("livesdk_livevip_exclusive_live_show", null, new Object[]{r2.s, IRoom.class});
        goto L7
    }

    @Override // e91.b
    public final void onUnload() {
        UIUtils.setViewVisibility(this.d.g, this.a);
        UIUtils.setViewVisibility(this.d.l, this.b);
        UIUtils.setViewVisibility(this.d.j, this.c);
    }

    public h(UserInfoTabPresenter r3) {
        this.d = r3;
        View r0 = r3.g;
        int r1 = 8;
        if (r0 == null) goto L5;
        int r2 = r0.getVisibility();
    L6:
        this.a = r2;
        TextView r4 = r3.l;
        if (r4 == null) goto L9;
        int r5 = r4.getVisibility();
    L10:
        this.b = r5;
        TextView r6 = r3.j;
        if (r6 == null) goto L13;
        r1 = r6.getVisibility();
    L13:
        this.c = r1;
        return;
    L9:
        r5 = 8;
        goto L10
    L5:
        r2 = 8;
        goto L6
    }

    @Override // e91.b
    public final void b(Bitmap r5, ImageView r6, k r7) {
        Intrinsics.checkNotNullParameter(r5, "bitmap");
        Intrinsics.checkNotNullParameter(r6, "certImg");
        Intrinsics.checkNotNullParameter(r7, "imageModel");
        if (r5.getHeight() == 0) goto L6;
        r6.setLayoutParams(new FrameLayout.LayoutParams(s1.f((int) ((((double) r5.getWidth()) * 10.0d) / ((double) r5.getHeight()))), s1.f(10)));
        return;
    }
}
