package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/LiveWaterMaskWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveWaterMaskWidget extends LiveRecyclableWidget {
    public HSImageView a;
    public HSImageView b;
    public final boolean c;
    public int d;
    public final Boolean e;
    public final int f;

    public final int getLayoutId() {
        return 2131567993;
    }

    public final void onUnload() {
    }

    public LiveWaterMaskWidget() {
        this.c = StatusBarUtil.isStatusBarTransparent();
        this.e = (Boolean) com.bytedance.android.livesdk.r2.a.getValue();
        this.f = -7829368;
    }

    public final void onInit(Object[] r2) {
        this.a = ((Widget) this).contentView.findViewById(2131384812);
        this.b = ((Widget) this).contentView.findViewById(2131384750);
        this.d = StatusBarUtil.getStatusBarHeight(((Widget) this).context);
    }

    public final void onLoad(Object[] r6) {
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L5;
    L12:
        LifecycleOwner r0 = null;
        if (isScreenPortrait() == false) goto L57;
        HSImageView r7 = this.b;
        if (r7 == null) goto L17;
        UtilityKotlinExtentionsKt.w(r7);
    L17:
        HSImageView r8 = this.a;
        if (r8 == null) goto L20;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
    L22:
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == true) goto L24;
        r9 = null;
    L24:
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r9;
        if (r10 != null) goto L27;
        return;
    L27:
        r10.height = UtilityKotlinExtentionsKt.i(72);
        if (this.c == false) goto L30;
        int r1 = this.d;
    L31:
        r10.topMargin = r1;
        r10.leftMargin = UtilityKotlinExtentionsKt.i(9);
        r10.rightMargin = UtilityKotlinExtentionsKt.i(9);
        HSImageView r2 = this.a;
        if (r2 == null) goto L34;
        r2.setLayoutParams(r10);
    L34:
        HSImageView r11 = this.b;
        if (r11 == null) goto L37;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
    L39:
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == true) goto L41;
        r12 = null;
    L41:
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        if (r13 != null) goto L44;
        return;
    L44:
        r13.height = UtilityKotlinExtentionsKt.i(144);
        r13.leftMargin = UtilityKotlinExtentionsKt.i(9);
        r13.rightMargin = UtilityKotlinExtentionsKt.i(6);
        r13.bottomMargin = UtilityKotlinExtentionsKt.i(52);
        HSImageView r3 = this.b;
        if (r3 == null) goto L47;
        r3.setLayoutParams(r13);
    L47:
        HSImageView r14 = this.b;
        if (r14 == null) goto L81;
        Context r4 = ((Widget) this).context;
        if ((r4 instanceof LifecycleOwner) == true) goto L52;
        r4 = null;
    L52:
        LifecycleOwner r5 = (LifecycleOwner) r4;
        if (r5 == null) goto L81;
        IHostAction r15 = jc1.k.f(IHostAction.class);
        if (r15 == null) goto L81;
        r15.putWatermarkInView(r5, r14);
    L81:
        HSImageView r16 = this.a;
        if (r16 == null) goto L93;
        LifecycleOwner r17 = ((Widget) this).context;
        if ((r17 instanceof LifecycleOwner) == false) goto L87;
        r0 = r17;
    L87:
        LifecycleOwner r18 = r0;
        if (r18 == null) goto L94;
        IHostAction r19 = jc1.k.f(IHostAction.class);
        if (r19 == null) goto L95;
        r19.putWatermarkInView(r18, r16);
        return;
    L95:
        return;
    L94:
        return;
    L93:
        return;
    L37:
        r12 = null;
        goto L39
    L30:
        r1 = UtilityKotlinExtentionsKt.i(2);
        goto L31
    L20:
        r9 = null;
        goto L22
    L57:
        HSImageView r20 = this.b;
        if (r20 == null) goto L60;
        UtilityKotlinExtentionsKt.t(r20);
    L60:
        HSImageView r21 = this.a;
        if (r21 == null) goto L63;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
    L65:
        if ((r22 instanceof ViewGroup.MarginLayoutParams) == true) goto L67;
        r22 = null;
    L67:
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r22;
        if (r23 != null) goto L70;
        return;
    L70:
        r23.height = UtilityKotlinExtentionsKt.i(72);
        r23.topMargin = UtilityKotlinExtentionsKt.i(9);
        if (this.c == false) goto L73;
        int r24 = UtilityKotlinExtentionsKt.i(46);
    L74:
        r23.leftMargin = r24;
        if (this.c == false) goto L77;
        int r25 = UtilityKotlinExtentionsKt.i(46);
    L78:
        r23.rightMargin = r25;
        HSImageView r26 = this.a;
        if (r26 == null) goto L81;
        r26.setLayoutParams(r23);
        goto L81
    L77:
        r25 = UtilityKotlinExtentionsKt.i(56) - this.d;
        goto L78
    L73:
        r24 = UtilityKotlinExtentionsKt.i(56) - this.d;
        goto L74
    L63:
        r22 = null;
        goto L65
    L5:
        if (this.e.booleanValue() == false) goto L12;
        HSImageView r27 = this.a;
        if (r27 == null) goto L9;
        r27.setBackgroundColor(this.f);
    L9:
        HSImageView r28 = this.b;
        if (r28 == null) goto L12;
        r28.setBackgroundColor(this.f);
        goto L12
    }
}
