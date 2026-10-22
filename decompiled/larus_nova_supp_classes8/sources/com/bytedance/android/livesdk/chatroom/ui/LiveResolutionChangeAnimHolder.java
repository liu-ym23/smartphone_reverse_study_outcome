package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.config.ne1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveResolutionChangeAnimHolder {
    public HSImageView a;
    public final Lazy b;
    public final ViewGroup c;
    public final DataCenter d;

    public final void a() {
        final HSImageView r0 = this.a;
        if (r0 == null) goto L13;
        Intrinsics.checkNotNullParameter(r0, "$this$removeParent");
        Function1<ViewGroup, Unit> r1 = new LiveResolutionChangeAnimHolder$removeParent$1(r0);
        Intrinsics.checkNotNullParameter(r0, "$this$withParent");
        Intrinsics.checkNotNullParameter(r1, "resolve");
        ViewParent r2 = r0.getParent();
        if (r2 != null) goto L7;
        return;
    L7:
        if ((r2 instanceof ViewGroup) == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L15;
        r1.invoke((ViewGroup) r2);
        return;
    L15:
        return;
    }

    public final void b() {
        DataCenter r0 = this.d;
        ViewGroup.LayoutParams r1 = null;
        Context r2 = null;
        if (r0 == null) goto L5;
        VideoViewParams r3 = (VideoViewParams) r0.get("live_render_view_params", null);
    L6:
        if (r3 != null) goto L8;
        return;
    L8:
        HSImageView r4 = this.a;
        if (r4 != null) goto L16;
        ViewGroup r5 = this.c;
        if (r5 == null) goto L13;
        r2 = r5.getContext();
    L13:
        View r6 = new HSImageView(r2);
        this.a = r6;
        ViewGroup r7 = this.c;
        if (r7 == null) goto L26;
        ViewGroup.MarginLayoutParams r8 = new ViewGroup.MarginLayoutParams(r3.a, r3.b);
        r8.topMargin = r3.c;
        Unit r9 = Unit.INSTANCE;
        r7.addView(r6, r8);
    L26:
        final HSImageView r10 = this.a;
        if (r10 == null) goto L38;
        UtilityKotlinExtentionsKt.w(r10);
        PipelineDraweeControllerBuilder r11 = Fresco.newDraweeControllerBuilder();
        if (r3.a <= r3.b) goto L33;
        String r12 = ((ne1) this.b.getValue()).a();
        if (r12 == null) goto L35;
    L36:
        PipelineDraweeControllerBuilder r13 = r11.setUri(r12).setAutoPlayAnimations(true);
        int r14 = com.bytedance.android.livesdk.chatroom.utils.f.a;
        r10.setController(r13.setControllerListener(com.bytedance.android.livesdk.chatroom.utils.f.a(LiveResolutionChangeAnimHolder$showResolutionChangeAnim$3$1.INSTANCE, new LiveResolutionChangeAnimHolder$showResolutionChangeAnim$3$2(r10), 1)).build());
        return;
    L35:
        r12 = "";
        goto L36
    L33:
        r12 = ((ne1) this.b.getValue()).b();
        if (r12 != null) goto L36;
    L38:
        return;
    L16:
        ViewGroup.LayoutParams r15 = r4.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        r1 = r15;
    L20:
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r1;
        if (r16 != null) goto L23;
        return;
    L23:
        r16.width = r3.a;
        r16.height = r3.b;
        r16.topMargin = r3.c;
        HSImageView r17 = this.a;
        if (r17 == null) goto L26;
        r17.setLayoutParams(r16);
        goto L26
    L5:
        r3 = null;
        goto L6
    }

    public LiveResolutionChangeAnimHolder(ViewGroup r1, DataCenter r2) {
        this.c = r1;
        this.d = r2;
        this.b = LazyKt.lazy(LiveResolutionChangeAnimHolder$config$2.INSTANCE);
    }
}
