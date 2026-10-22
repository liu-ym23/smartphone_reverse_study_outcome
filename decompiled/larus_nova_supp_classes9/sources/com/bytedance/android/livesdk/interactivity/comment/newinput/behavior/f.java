package com.bytedance.android.livesdk.interactivity.comment.newinput.behavior;

import am2.x;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputFunctionEnum;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends c {
    public boolean i;
    public boolean j;
    public FrameLayout k;
    public TextView l;
    public ValueAnimator m;
    public Function2<? super Boolean, ? super Long, Unit> n;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c
    public final int c() {
        return 2131567042;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final View getView() {
        if (this.a != null) goto L18;
        TextView r2 = null;
        View r0 = LayoutInflater.from(getContext()).inflate(2131567042, null);
        this.a = r0;
        if (r0 == null) goto L7;
        FrameLayout r1 = (FrameLayout) r0.findViewById(2131373059);
    L8:
        this.k = r1;
        View r3 = this.a;
        if (r3 == null) goto L11;
        ImageView r4 = (ImageView) r3.findViewById(2131384095);
    L11:
        View r5 = this.a;
        if (r5 == null) goto L14;
        r2 = (TextView) r5.findViewById(2131367928);
    L14:
        this.l = r2;
        View r6 = this.a;
        if (r6 == null) goto L18;
        r6.setTag(this.f);
        goto L18
    L7:
        r1 = null;
    L18:
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final void k(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2) {
        Intrinsics.checkNotNullParameter(r2, "bridges");
        super.k(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final void s(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2) {
        Intrinsics.checkNotNullParameter(r2, "bridges");
        Intrinsics.checkNotNullParameter(r2, "bridges");
        ValueAnimator r3 = this.m;
        if (r3 == null) goto L5;
        r3.cancel();
    L5:
        this.m = null;
    }

    public f(InputFunctionEnum r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "symbol");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3, null);
        this.i = false;
        this.j = true;
    }

    public final void e(long r7, boolean r9) {
        if (r9 == false) goto L6;
    L7:
        boolean r10 = true;
    L9:
        this.i = r10;
        this.j = false;
        View r2 = getView();
        if (r2 == null) goto L12;
        TextView r3 = (TextView) r2.findViewById(2131367928);
    L13:
        float r4 = 0.0f;
        if (r10 == false) goto L16;
        float r5 = 0.0f;
    L17:
        if (r10 == false) goto L19;
        r4 = 45.0f;
    L19:
        ValueAnimator r11 = ValueAnimator.ofFloat(new float[]{r5, r4});
        r11.setInterpolator(new AccelerateDecelerateInterpolator());
        r11.setDuration(250);
        r11.addUpdateListener(new g(r11, r3));
        Unit r0 = Unit.INSTANCE;
        this.m = r11;
        com.bytedance.android.live.core.utils.h.a(r11, new FoldBehavior$rotateButton$2(this));
        ValueAnimator r13 = this.m;
        if (r13 == null) goto L23;
        r13.start();
    L23:
        if (this.i == false) goto L25;
        r3.a(this.l, "关闭");
    L26:
        Function2<? super Boolean, ? super Long, Unit> r14 = this.n;
        if (r14 == null) goto L30;
        Unit r8 = (Unit) r14.invoke(Boolean.valueOf(this.i), Long.valueOf(r7));
        return;
    L30:
        return;
    L25:
        r3.a(this.l, this.f.getDesc());
        goto L26
    L16:
        r5 = 45.0f;
        goto L17
    L12:
        r3 = null;
        goto L13
    L6:
        if (this.i == false) goto L7;
        r10 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final void t(View r4, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "bridges");
        if (this.j == true) goto L5;
        return;
    L5:
        e(250, false);
        if (this.i == false) goto L9;
        r5.E0();
    L11:
        boolean r6 = this.i;
        HashMap r0 = new HashMap();
        r0.put("screen_type", "portrait");
        if (r6 == false) goto L14;
        String r7 = "on";
    L15:
        r0.put("extend_mode", r7);
        j0.l().sendLog("livesdk_comment_expansion_module_extend", r0, new Object[]{IRoom.class, x.class});
        return;
    L14:
        r7 = "off";
        goto L15
    L9:
        if (r5.Q() != InputSectionType.MORE) goto L11;
        r5.D0();
        goto L11
    }
}
