package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.content.DialogInterface;
import android.widget.CompoundButton;
import android.widget.Switch;
import com.bytedance.android.live.liveinteract.api.IInteractService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e1 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ VideoTalkSettingFragment a;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ e1 a;
        public final /* synthetic */ boolean b;

        public a(e1 r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            r2.dismiss();
            VideoTalkSettingFragment r4 = this.a.a;
            boolean r5 = this.b;
            int r0 = VideoTalkSettingFragment.z;
            r4.ia0(r5);
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ e1 a;
        public final /* synthetic */ boolean b;

        public b(e1 r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            VideoTalkSettingFragment r5 = this.a.a;
            r5.v = true;
            ((Switch) r5.ja0().findViewById(2131387900)).setChecked(true ^ this.b);
            r3.dismiss();
        }
    }

    public static final class c implements DialogInterface.OnCancelListener {
        public final /* synthetic */ e1 a;
        public final /* synthetic */ boolean b;

        public c(e1 r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r3) {
            VideoTalkSettingFragment r4 = this.a.a;
            r4.v = true;
            ((Switch) r4.ja0().findViewById(2131387900)).setChecked(true ^ this.b);
        }
    }

    public e1(VideoTalkSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r5, boolean r6) {
        VideoTalkSettingFragment r7 = this.a;
        if (r7.v == false) goto L7;
        r7.v = false;
        return;
    L7:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L9;
        com.bytedance.android.livesdk.widget.x0.b r8 = new com.bytedance.android.livesdk.widget.x0.b(this.a.getContext(), 0);
        r8.a.a = 4;
        r8.a.d = com.bytedance.android.live.core.utils.s1.B(2131923169);
        r8.setCornerRadius(2.0f);
        r8.i(0, 2131923167, new a(this, r6));
        r8.i(1, 2131915442, new b(this, r6));
        com.bytedance.android.livesdk.widget.x0.d r0 = r8.a;
        r0.k = false;
        r0.h = new c(this, r6);
        r8.n();
        return;
    L9:
        this.a.ia0(r6);
    }
}
