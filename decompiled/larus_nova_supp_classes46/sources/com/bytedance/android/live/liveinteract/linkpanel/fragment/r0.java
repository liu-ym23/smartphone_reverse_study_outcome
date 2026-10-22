package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.content.DialogInterface;
import android.widget.CompoundButton;
import android.widget.Switch;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r0 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ VideoTalkSettingFragment a;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ r0 a;

        public a(r0 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            ((Switch) this.a.a.ja0().findViewById(2131387859)).setChecked(true);
            r2.dismiss();
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ r0 a;

        public b(r0 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            VideoTalkSettingFragment.ca0(this.a.a);
            this.a.a.oa0(Boolean.FALSE);
            r2.dismiss();
        }
    }

    public r0(VideoTalkSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r4, boolean r5) {
        VideoTalkSettingFragment r6 = this.a;
        int r0 = VideoTalkSettingFragment.z;
        if (r6.fa0() == false) goto L20;
        if (r5 == false) goto L6;
        return;
    L6:
        IInteractService r7 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r7 == null) goto L11;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r8 = r7.getLinkUserInfoCenter();
        if (r8 == null) goto L11;
        int r9 = r8.b();
    L12:
        IInteractService r10 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r10 == null) goto L15;
        int r11 = r10.getOnLineCountFromPk();
    L16:
        if (r9 > 0) goto L19;
        if (r11 > 0) goto L19;
        VideoTalkSettingFragment.ca0(this.a);
        this.a.oa0(Boolean.FALSE);
        return;
    L19:
        com.bytedance.android.livesdk.widget.x0.b r12 = new com.bytedance.android.livesdk.widget.x0.b(this.a.getContext(), 0);
        com.bytedance.android.livesdk.widget.x0.d r13 = r12.a;
        r13.k = false;
        r13.l = false;
        r12.m(2131914617);
        r12.l(2131914616);
        r12.i(1, 2131915442, new a(this));
        r12.i(0, 2131920806, new b(this));
        r12.n();
        return;
    L15:
        r11 = 0;
    L11:
        r9 = 0;
        goto L12
    L20:
        VideoTalkSettingFragment r14 = this.a;
        if (r5 == false) goto L23;
        r14.ta0(true, false);
        return;
    L23:
        r14.ta0(false, false);
    }
}
