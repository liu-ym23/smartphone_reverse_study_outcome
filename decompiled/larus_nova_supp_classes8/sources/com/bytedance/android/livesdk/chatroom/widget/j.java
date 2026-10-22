package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.user.IUserService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j extends RelativeLayout {
    public Map<Integer, View> a;
    public ValueAnimator b;

    public static final class a {
    }

    static {
    }

    public j(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.a = new LinkedHashMap();
        View.inflate(r3, 2131566636, this);
        py.k r4 = jc1.k.n(IUserService.class).user().b().getAvatarMedium();
        if (r4 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.utils.a1.v((ImageView) a(2131363703), r4, 2131251889);
    L5:
        ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.b = r5;
        if (r5 == null) goto L8;
        r5.setDuration(1000);
    L8:
        ValueAnimator r6 = this.b;
        if (r6 == null) goto L11;
        r6.setRepeatCount(-1);
    L11:
        ValueAnimator r7 = this.b;
        if (r7 == null) goto L14;
        r7.setInterpolator(new LinearInterpolator());
    L14:
        ValueAnimator r8 = this.b;
        if (r8 == null) goto L17;
        r8.addUpdateListener(new k(this));
    L17:
        ValueAnimator r9 = this.b;
        if (r9 == null) goto L21;
        r9.start();
        return;
    }

    public final View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void setTips(String r2) {
        ((TextView) a(2131390186)).setText(r2);
    }

    public static final void b(j r3, View r4, float r5) {
        r3.getClass();
        if (r4 == null) goto L6;
        r4.setAlpha(1.0f - r5);
    L6:
        if (r4 == null) goto L10;
        ViewGroup.LayoutParams r1 = r4.getLayoutParams();
        if (r1 == null) goto L10;
        r1.height = com.bytedance.android.live.core.utils.s1.f((r5 * 30.0f) + 96.0f);
    L10:
        if (r4 == null) goto L15;
        ViewGroup.LayoutParams r6 = r4.getLayoutParams();
        if (r6 == null) goto L16;
        r6.width = com.bytedance.android.live.core.utils.s1.f((r5 * 30.0f) + 96.0f);
        return;
    L16:
        return;
    }
}
