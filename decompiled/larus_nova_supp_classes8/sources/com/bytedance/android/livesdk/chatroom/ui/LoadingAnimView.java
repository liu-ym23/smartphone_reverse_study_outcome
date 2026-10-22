package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LoadingAnimView extends FrameLayout {
    public HSImageView a;
    public HSImageView b;
    public TextView c;
    public Animatable d;
    public Animatable e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public Drawable j;
    public Drawable k;
    public int l;
    public boolean m;

    public class a extends BaseControllerListener {
        public final /* synthetic */ LoadingAnimView a;

        public a(LoadingAnimView r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
            super.onFinalImageSet(r2, r3, r4);
            LoadingAnimView r5 = this.a;
            r5.d = r4;
            if ((r4 instanceof Drawable) == false) goto L5;
            r5.j = (Drawable) r4;
        L5:
            int r6 = r5.l;
            Drawable r7 = r5.j;
            if (r7 == null) goto L8;
            r7.setColorFilter(r6, PorterDuff.Mode.SRC_ATOP);
        L8:
            Drawable r8 = r5.k;
            if (r8 == null) goto L11;
            r8.setColorFilter(r6, PorterDuff.Mode.SRC_ATOP);
        L11:
            TextView r9 = r5.c;
            if (r9 == null) goto L15;
            r9.setTextColor(r6);
        L15:
            if (r5.m == false) goto L17;
            r5.b();
            return;
        L17:
            r5.c();
        }
    }

    public class b extends BaseControllerListener {
        public final /* synthetic */ LoadingAnimView a;

        public b(LoadingAnimView r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
            super.onFinalImageSet(r2, r3, r4);
            LoadingAnimView r5 = this.a;
            r5.e = r4;
            if ((r4 instanceof Drawable) == false) goto L5;
            r5.k = (Drawable) r4;
        L5:
            int r6 = r5.l;
            Drawable r7 = r5.j;
            if (r7 == null) goto L8;
            r7.setColorFilter(r6, PorterDuff.Mode.SRC_ATOP);
        L8:
            Drawable r8 = r5.k;
            if (r8 == null) goto L11;
            r8.setColorFilter(r6, PorterDuff.Mode.SRC_ATOP);
        L11:
            TextView r9 = r5.c;
            if (r9 == null) goto L15;
            r9.setTextColor(r6);
        L15:
            if (r5.m == false) goto L17;
            r5.b();
            return;
        L17:
            r5.c();
        }
    }

    public final void b() {
        Animatable r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        Animatable r1 = this.e;
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.isRunning() == true) goto L14;
        this.e.start();
        this.c.setVisibility(0);
        return;
    L14:
        return;
    L5:
        if (r0.isRunning() == true) goto L7;
        this.d.start();
        this.c.setVisibility(0);
        goto L7
    }

    public final void c() {
        Animatable r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        Animatable r1 = this.e;
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.isRunning() == false) goto L14;
        this.e.stop();
        return;
    L14:
        return;
    L5:
        if (r0.isRunning() == false) goto L7;
        this.d.stop();
        goto L7
    }

    public final void a() {
        View r0 = LayoutInflater.from(getContext()).inflate(2131567767, this, true);
        this.c = (TextView) r0.findViewById(2131379084);
        this.a = r0.findViewById(2131378998);
        a r1 = new a(this);
        if (com.bytedance.android.livesdk.config.setting.w.a.c() == false) goto L5;
        AbstractDraweeController r2 = Fresco.newDraweeControllerBuilder().setUri(this.h).setControllerListener(r1).build();
    L6:
        this.a.setController(r2);
        this.b = r0.findViewById(2131379018);
        b r3 = new b(this);
        long r4 = System.currentTimeMillis();
        if (com.bytedance.android.livesdk.config.setting.w.a.c() == false) goto L9;
        AbstractDraweeController r5 = Fresco.newDraweeControllerBuilder().setUri(this.i).setControllerListener(r3).build();
        ALogger.i("LoadingAnimView", "local time = " + (System.currentTimeMillis() - r4));
    L10:
        this.b.setController(r5);
        return;
    L9:
        r5 = Fresco.newDraweeControllerBuilder().setUri(com.bytedance.android.livesdk.chatroom.utils.i2.c(this.g)).setControllerListener(r3).build();
        ALogger.i("LoadingAnimView", "remote time = " + (System.currentTimeMillis() - r4));
        goto L10
    L5:
        r2 = Fresco.newDraweeControllerBuilder().setUri(com.bytedance.android.livesdk.chatroom.utils.i2.c(this.f)).setControllerListener(r1).build();
        goto L6
    }

    public LoadingAnimView(Context r1) {
        super(r1);
        this.f = "/common/ttlive_ic_loading_center.webp";
        this.g = "/common/ttlive_ic_loading_point.webp";
        this.h = "asset://com.ss.android.ies.live.sdk/ttlive_ic_loading_center.webp";
        this.i = "asset://com.ss.android.ies.live.sdk/ttlive_ic_loading_point.webp";
        this.l = -1;
        this.m = false;
        a();
    }

    public void setColor(int r3) {
        if (r3 != 0) goto L4;
        return;
    L4:
        this.l = r3;
        Drawable r0 = this.j;
        if (r0 == null) goto L7;
        r0.setColorFilter(r3, PorterDuff.Mode.SRC_ATOP);
    L7:
        Drawable r1 = this.k;
        if (r1 == null) goto L10;
        r1.setColorFilter(r3, PorterDuff.Mode.SRC_ATOP);
    L10:
        TextView r2 = this.c;
        if (r2 == null) goto L14;
        r2.setTextColor(r3);
        return;
    }

    public LoadingAnimView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.f = "/common/ttlive_ic_loading_center.webp";
        this.g = "/common/ttlive_ic_loading_point.webp";
        this.h = "asset://com.ss.android.ies.live.sdk/ttlive_ic_loading_center.webp";
        this.i = "asset://com.ss.android.ies.live.sdk/ttlive_ic_loading_point.webp";
        this.l = -1;
        this.m = false;
        a();
    }

    public LoadingAnimView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.f = "/common/ttlive_ic_loading_center.webp";
        this.g = "/common/ttlive_ic_loading_point.webp";
        this.h = "asset://com.ss.android.ies.live.sdk/ttlive_ic_loading_center.webp";
        this.i = "asset://com.ss.android.ies.live.sdk/ttlive_ic_loading_point.webp";
        this.l = -1;
        this.m = false;
        a();
    }
}
