package com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.gift.IGiftCoreService;
import com.bytedance.android.livesdk.chatroom.ui.framework.d;
import com.bytedance.common.utility.UIUtils;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/clearscreen/AnchorPortraitClearScreenCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/clearscreen/ClearScreenCompositeWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPortraitClearScreenCompositeWidget extends ClearScreenCompositeWidget {
    public d g;

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.ClearScreenCompositeWidget, com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b
    public final void Hc() {
        Gq(true);
        d r1 = this.g;
        View r2 = null;
        if (r1 == null) goto L5;
        ViewGroup r3 = r1.bg();
    L7:
        if (r3 == null) goto L11;
        int r4 = r3.getChildCount();
        int r5 = 0;
    L9:
        if (r5 >= r4) goto L11;
        r3.getChildAt(r5).setVisibility(0);
        r5 = r5 + 1;
    L11:
        IGiftCoreService r6 = k.f(IGiftCoreService.class);
        if (r6 == null) goto L14;
        r6.setNeedShowGiftEffectSwitch(true);
    L14:
        d r0 = ho1.a.i(getComponentContext());
        if (r0 == null) goto L17;
        r2 = r0.Eo();
    L17:
        UIUtils.setViewVisibility(r2, 0);
        return;
    L5:
        r3 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.ClearScreenCompositeWidget, com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b
    public final void Rf() {
        Gq(false);
        d r1 = this.g;
        View r2 = null;
        if (r1 == null) goto L5;
        ViewGroup r3 = r1.bg();
    L7:
        if (r3 == null) goto L11;
        int r4 = r3.getChildCount();
        int r5 = 0;
    L9:
        if (r5 >= r4) goto L11;
        r3.getChildAt(r5).setVisibility(8);
        r5 = r5 + 1;
    L11:
        IGiftCoreService r6 = k.f(IGiftCoreService.class);
        if (r6 == null) goto L14;
        r6.setNeedShowGiftEffectSwitch(false);
    L14:
        d r0 = ho1.a.i(getComponentContext());
        if (r0 == null) goto L17;
        r2 = r0.Eo();
    L17:
        UIUtils.setViewVisibility(r2, 8);
        return;
    L5:
        r3 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.ClearScreenCompositeWidget, com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L5;
        d r1 = ho1.a.i(r0);
    L6:
        this.g = r1;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public AnchorPortraitClearScreenCompositeWidget() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.ClearScreenCompositeWidget
    public final void onDestroy() {
        super.onDestroy();
    }

    public final void Gq(boolean r6) {
        d r0 = this.g;
        ViewGroup r1 = null;
        if (r0 == null) goto L5;
        ViewGroup r2 = r0.nn();
    L6:
        int r3 = 0;
        if (r2 == null) goto L12;
        if (r6 == false) goto L10;
        int r4 = 0;
    L11:
        r2.setVisibility(r4);
        goto L12
    L10:
        r4 = 8;
    L12:
        d r5 = this.g;
        if (r5 == null) goto L15;
        ViewGroup r7 = r5.Wa();
    L16:
        if (r7 == null) goto L21;
        if (r6 == false) goto L19;
        int r8 = 0;
    L20:
        r7.setVisibility(r8);
        goto L21
    L19:
        r8 = 8;
    L21:
        d r9 = this.g;
        if (r9 == null) goto L24;
        r1 = r9.Yh();
    L24:
        if (r1 == null) goto L30;
        if (r6 == true) goto L28;
        r3 = 8;
    L28:
        r1.setVisibility(r3);
        return;
    L30:
        return;
    L15:
        r7 = null;
        goto L16
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.ClearScreenCompositeWidget
    public final void Bq(boolean r2, boolean r3, boolean r4) {
        super.Bq(r2, r3, r4);
        if (g1() == true) goto L6;
        if (r3 == true) goto L6;
        return;
    L6:
        if (r4 == true) goto L8;
    L10:
        boolean r5 = false;
    L11:
        I4(r2, r5);
        return;
    L8:
        if (g1() == false) goto L10;
        r5 = true;
        goto L11
    }
}
