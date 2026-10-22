package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.OSurfaceView;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IVideoController;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l4 extends xc8.h {
    public IVideoController A;
    public final TextView p;
    public final SimpleDraweeView q;
    public final SimpleDraweeView r;
    public final OSurfaceView s;
    public final View t;
    public int u;
    public int v;
    public final ArrayList<MediaEntity> w;
    public Message x;
    public MediaEntityContainer y;
    public String z;

    public static final class a {
    }

    public static final class b implements com.larus.platform.api.l4 {
        public final /* synthetic */ l4 a;

        public b(l4 r1) {
            this.a = r1;
        }

        public final void a(String r8, com.larus.video.impl.sdk.a r9) {
            ArrayList<MediaEntity> r0 = this.a.w;
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L11;
            return;
        L11:
            ArrayList<MediaEntity> r2 = this.a.w;
            Intrinsics.checkNotNull(r2);
            MediaEntity r3 = (MediaEntity) ListProtector.get(r2, 0);
            if (r3 == null) goto L14;
            String r4 = r3.getVideo_model();
        L16:
            if (Intrinsics.areEqual(r4, r8) == false) goto L21;
            Lazy r10 = com.larus.platform.service.q3.a;
            com.larus.platform.api.z3 r5 = com.larus.platform.service.q3.a();
            if (r5 == null) goto L22;
            com.larus.platform.api.z3.a.a(r5, r9, null, 0, null, 30);
            return;
        L22:
            return;
        L21:
            return;
        L14:
            r4 = null;
            goto L16
        L5:
            if (r0.isEmpty() == true) goto L8;
            r1 = false;
            goto L9
        }
    }

    static {
    }

    public final void n() {
        ArrayList<MediaEntity> r0 = this.w;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        Lazy r2 = com.larus.platform.service.q3.a;
        com.larus.platform.api.z3 r3 = com.larus.platform.service.q3.a();
        if (r3 == null) goto L19;
        ArrayList<MediaEntity> r4 = this.w;
        Intrinsics.checkNotNull(r4);
        MediaEntity r5 = (MediaEntity) ListProtector.get(r4, 0);
        if (r5 == null) goto L16;
        String r6 = r5.getVideo_model();
    L17:
        r3.f(r6, new b(this));
        return;
    L16:
        r6 = null;
        goto L17
    L19:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.larus.bmhome.chat.layout.item.i, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L8;
        com.larus.platform.api.r2 r1 = r0.A0();
        if (r1 == null) goto L9;
        r1.l(getContext());
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IVideoController r0 = this.A;
        if (r0 == null) goto L8;
        r0.I(false);
        if (r0.isReleased() == true) goto L9;
        r0.release();
        return;
    L9:
        return;
    }

    public l4(Context r5) {
        super(r5);
        this.u = (int) UIUtils.dip2Px(r5, 190.0f);
        this.v = (int) UIUtils.dip2Px(r5, 286.0f);
        this.w = new ArrayList();
        OSurfaceView r1 = null;
        View r6 = LayoutInflater.from(r5).inflate(2131563196, null);
        this.t = r6;
        ConstraintLayout.LayoutParams r0 = new ConstraintLayout.LayoutParams(this.u, -2);
        if (r6 == null) goto L5;
        ImageView r2 = (ImageView) r6.findViewById(2131382435);
    L5:
        if (r6 == null) goto L7;
        TextView r3 = (TextView) r6.findViewById(2131392378);
    L8:
        this.p = r3;
        if (r6 == null) goto L11;
        SimpleDraweeView r4 = (SimpleDraweeView) r6.findViewById(2131368153);
    L12:
        this.q = r4;
        if (r6 == null) goto L15;
        SimpleDraweeView r7 = (SimpleDraweeView) r6.findViewById(2131363091);
    L16:
        this.r = r7;
        if (r6 == null) goto L19;
        r1 = (OSurfaceView) r6.findViewById(2131392379);
    L19:
        this.s = r1;
        addView(r6, r0);
        return;
    L15:
        r7 = null;
        goto L16
    L11:
        r4 = null;
        goto L12
    L7:
        r3 = null;
        goto L8
    }
}
