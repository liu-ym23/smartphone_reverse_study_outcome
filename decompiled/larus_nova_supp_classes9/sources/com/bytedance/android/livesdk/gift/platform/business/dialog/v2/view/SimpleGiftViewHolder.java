package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.k0;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdk.gift.platform.core.utils.s;
import com.bytedance.android.livesdk.gift.util.b;
import com.bytedance.android.livesdk.gift.vs.panel.statemachine.GiftListViewModelNew;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import py.k;
import qz1.t;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class SimpleGiftViewHolder extends BaseLiveGiftViewHolder<AbsPanel<?>> {
    public AbsPanel b;
    public final HSImageView c;
    public final TextView d;

    public class a implements p0 {
        public final /* synthetic */ AbsPanel a;

        public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
        }

        public final /* synthetic */ void d(ImageInfo r1) {
        }

        public final /* synthetic */ void e(k r1) {
        }

        public a(AbsPanel r1) {
            this.a = r1;
        }

        public final void b(k r4, Exception r5) {
            AbsPanel r0 = this.a;
            if (r0.a != 1) goto L6;
            c0.c(r0.c(), r4.getUri(), r4.getUrls(), r5.getMessage());
            return;
        }

        public final void c(k r3, int r4, int r5, boolean r6) {
            GiftContext r7 = b.b();
            if (r7 != null) goto L5;
            return;
        L5:
            if (((Long) r7.getFirstGiftImageRenderSucAt().getValue()).longValue() != 0) goto L9;
            r7.getFirstGiftImageRenderSucAt().setValue(Long.valueOf(System.currentTimeMillis()));
            return;
        }
    }

    public final List<Integer> U3() {
        AbsPanel r0 = this.b;
        if (r0 != null) goto L5;
        return null;
    L5:
        ArrayList<e3> r1 = r0.b;
        if (r1 != null) goto L8;
    L17:
        return null;
    L8:
        if (r1.size() == 0) goto L17;
        ArrayList r2 = new ArrayList();
        Iterator<e3> r3 = this.b.b.iterator();
    L12:
        if (r3.hasNext() == false) goto L16;
        if ((r3.next() instanceof e3) == false) goto L12;
        r2.add(0);
        goto L12
    L16:
        return r2;
    }

    public SimpleGiftViewHolder(View r2) {
        super(r2);
        this.c = r2.findViewById(2131373729);
        this.d = (TextView) r2.findViewById(2131373743);
        r2.setOnClickListener(new t(this));
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.BaseLiveGiftViewHolder
    public void T3(AbsPanel r6) {
        this.b = r6;
        HSImageView r0 = this.c;
        if (r0 == null) goto L9;
        GenericDraweeHierarchy r1 = r0.getHierarchy();
        int r2 = ((Integer) b.a().c(GiftConfigKey.KEY_GIFT_DEFAULT_ICON, 2131250964)).intValue();
        r1.setPlaceholderImage(r2);
        r1.setFailureImage(r2);
        if (r6.g() == null) goto L7;
        k r3 = r6.g();
    L8:
        ImageLoader.bindImage(this.c, r3, s1.j(2131168749), s1.j(2131168749), new a(r6));
        goto L9
    L7:
        r3 = r6.d();
    L9:
        TextView r4 = this.d;
        if (r4 == null) goto L13;
        r4.setText(r6.f());
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.BaseLiveGiftViewHolder, android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r15) {
        if (com.bytedance.android.livesdk.gift.platform.core.utils.t.b() == true) goto L37;
        GiftListViewModelNew r16 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.l();
        if (r16 == null) goto L7;
        GiftStateMachineConfig.e r17 = (GiftStateMachineConfig.e) r16.j.b();
    L9:
        if ((r17 instanceof GiftStateMachineConfig.e.b) == false) goto L38;
        AbsPanel r18 = this.b;
        if (r18 == null) goto L39;
        T r19 = r18.h;
        boolean r1 = true;
        if ((r19 instanceof h1) == false) goto L21;
        h1 r110 = (h1) r19;
        if (r110.getGiftPreviewInfo() != null) goto L17;
    L19:
        boolean r111 = false;
    L20:
        boolean r11 = r111;
    L22:
        IBaseUser r112 = f.c(IBaseUser.class);
        if (s.c() != null) goto L25;
    L27:
        IBaseUser r13 = r112;
        T r113 = this.b.h;
        if ((r113 instanceof h1) == true) goto L30;
        boolean r14 = false;
    L35:
        long r3 = this.b.c();
        boolean r5 = this.b.h instanceof h1;
        int r6 = getLayoutPosition();
        AbsPanel r114 = this.b;
        h.Z(r3, r5, r6, false, r114.f, r114.c, r114.b, r11, r13, r14);
        return;
    L30:
        if (((h1) r113).getBizType() == 2) goto L33;
        r1 = false;
    L33:
        r14 = r1;
        goto L35
    L25:
        if (s.c().a == null) goto L27;
        r112 = s.c().a;
        goto L27
    L17:
        if (r110.getGiftPreviewInfo().getLockStatus() != k0.UNLOCKED) goto L19;
        r111 = true;
        goto L20
    L21:
        r11 = false;
        goto L22
    L39:
        return;
    L38:
        return;
    L7:
        r17 = null;
        goto L9
    }
}
