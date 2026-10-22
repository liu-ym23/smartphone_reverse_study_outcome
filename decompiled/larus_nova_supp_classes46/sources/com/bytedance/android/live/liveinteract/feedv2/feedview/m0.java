package com.bytedance.android.live.liveinteract.feedv2.feedview;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.radio.RadioDarkMaskView;
import com.bytedance.android.live.liveinteract.voicechat.view.VoiceChatRoomAnchorView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m0 implements Runnable {
    public final /* synthetic */ MultiLinkRadioFeedView a;
    public final /* synthetic */ FrameLayout b;

    public m0(MultiLinkRadioFeedView r1, FrameLayout r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        MultiLinkRadioFeedView.u(this.a, this.b, 136);
        IVoiceLiveTheme r4 = null;
        if (((FrameLayout) this.a.g(2131363500)).indexOfChild(this.a.f) >= 0) goto L9;
        HSImageView r0 = this.a.f;
        Context r6 = this.a.getContext();
        if ((r6 instanceof Activity) == true) goto L7;
        r6 = null;
    L7:
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, com.bytedance.android.live.liveinteract.utils.h.d((Activity) r6)));
        ((FrameLayout) this.a.g(2131363500)).addView(this.a.f, 0);
    L9:
        if (((FrameLayout) this.a.g(2131363500)).indexOfChild(this.a.g) >= 0) goto L14;
        HSImageView r1 = this.a.g;
        Context r7 = this.a.getContext();
        if ((r7 instanceof Activity) == true) goto L13;
        r7 = null;
    L13:
        r1.setLayoutParams(new FrameLayout.LayoutParams(-1, com.bytedance.android.live.liveinteract.utils.h.d((Activity) r7)));
        ((FrameLayout) this.a.g(2131363500)).addView(this.a.g, 1);
    L14:
        IPreviewMultiLinkOuterConfigProvider r2 = this.a.b;
        if (r2 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L17:
        IVoiceLiveTheme r3 = r2.getRoom().getVoiceLiveTheme();
        if (r3 == null) goto L22;
        VoiceChatRoomAnchorView r5 = this.a.r;
        if (r5 == null) goto L22;
        Intrinsics.checkNotNullParameter(r3, "theme");
        r5.r = r3;
        r5.c();
    L22:
        MultiLinkRadioFeedView r8 = this.a;
        r8.getClass();
        if (MultiLinkRadioFeedView.v() == true) goto L50;
        IRoom r9 = r8.i;
        if (r9 == null) goto L28;
        r4 = r9.getVoiceLiveTheme();
    L28:
        if (r4 != null) goto L30;
    L31:
        if (r4 != null) goto L33;
    L43:
        com.bytedance.android.live.ui.q r10 = r8.k;
        if (r10 == null) goto L49;
        r10.a(com.bytedance.android.livesdk.model.k.a());
        return;
    L49:
        return;
    L33:
        if (5 != r4.getBgType()) goto L43;
    L34:
        com.bytedance.android.live.ui.q r11 = r8.k;
        if (r11 == null) goto L38;
        r11.a(r4);
    L38:
        if (vm2.d.s0() == true) goto L40;
    L42:
        ((RadioDarkMaskView) r8.g(2131383596)).setVisibility(8);
        return;
    L40:
        if (r4.isUgcImage() != true) goto L42;
        ((RadioDarkMaskView) r8.g(2131383596)).setVisibility(0);
        return;
    L30:
        if (2 == r4.getBgType()) goto L34;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
