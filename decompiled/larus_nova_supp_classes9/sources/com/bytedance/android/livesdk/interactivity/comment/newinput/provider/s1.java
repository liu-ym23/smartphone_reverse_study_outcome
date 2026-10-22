package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.message.t5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.awemeplay.view.LiveVideoCommentSelectAwemePanelView;
import com.bytedance.android.livesdk.interactivity.api.input.InputDialogFragmentSwitchType;
import com.bytedance.android.livesdk.interactivity.comment.input.VideoCommentPreviewFragment;
import com.bytedance.android.livesdk.interactivity.comment.input.VideoCommentSearchFragment;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.interactivity.comment.utils.CommentUtils;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s1 implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j, Object> {
    public final InputSectionType a;
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g b;
    public LiveVideoCommentSelectAwemePanelView c;
    public gd0.q d;
    public final a e;
    public final DataCenter f;
    public final Fragment g;

    public static final class a implements gd0.r {
        public final /* synthetic */ s1 a;

        public final void a() {
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.J();
            return;
        }

        public final void b() {
            s1 r0 = this.a;
            r0.getClass();
            Integer r1 = (Integer) ((ge1.a) hd0.c.f()).b;
            if (r1 != null) goto L6;
        L7:
            a r2 = r0.e;
            if (r2 == null) goto L14;
            r2.c();
            return;
        L14:
            return;
        L6:
            if (r1.intValue() != 2) goto L7;
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r3 = r0.b;
            if (r3 == null) goto L16;
            InputDialogFragmentSwitchType r4 = InputDialogFragmentSwitchType.FADE;
            String r5 = VideoCommentSearchFragment.O;
            a r6 = r0.e;
            Intrinsics.checkNotNullParameter(r6, "callback");
            VideoCommentSearchFragment r7 = new VideoCommentSearchFragment();
            r7.e = null;
            r7.f = r3;
            r7.g = r6;
            r3.o0(r4, r7);
            return;
        }

        public final void c() {
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.J();
            return;
        }

        public final void d() {
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.a.b;
            if (r0 == null) goto L5;
            r0.D0();
        L5:
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r1 = this.a.b;
            if (r1 == null) goto L9;
            r1.J();
            return;
        }

        public a(s1 r1) {
            this.a = r1;
        }

        public final void e(t5 r9) {
            Intrinsics.checkNotNullParameter(r9, "message");
            CommentUtils.a(r9, this.a.f);
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.J();
        L6:
            if (r9.isPin() == false) goto L25;
            long r2 = r9.getItemId();
            com.bytedance.android.live.base.model.message.m0 r1 = r9.getBaseMessage();
            if (r1 == null) goto L10;
            long r4 = r1.getMessageId();
        L11:
            IBaseUser r3 = r9.getUserInfo();
            if (r3 == null) goto L17;
            String r5 = r3.getRealNickName();
            if (r5 == null) goto L17;
            String r7 = r5;
        L18:
            IBaseUser r10 = r9.getUserInfo();
            if (r10 == null) goto L22;
            String r11 = r10.getIdString();
            if (r11 == null) goto L22;
        L23:
            k42.e r6 = new k42.e(r2, r4, r7, r11);
            o32.a.a("pin video " + r6.c);
            k42.b.a(new k42.a(r6));
            return;
        L22:
            r11 = BuildConfig.FLAVOR;
        L17:
            r7 = BuildConfig.FLAVOR;
            goto L18
        L10:
            r4 = 0;
            goto L11
        }

        public final void f(gd0.b r6) {
            Intrinsics.checkNotNullParameter(r6, "videoInfo");
            s1 r1 = this.a;
            r1.getClass();
            Integer r2 = (Integer) ((ge1.a) hd0.c.f()).b;
            if (r2 != null) goto L6;
        L7:
            a r7 = r1.e;
            if (r7 == null) goto L14;
            r7.c();
            return;
        L14:
            return;
        L6:
            if (r2.intValue() != 2) goto L7;
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r3 = r1.b;
            if (r3 == null) goto L16;
            InputDialogFragmentSwitchType r4 = InputDialogFragmentSwitchType.SLIDE_RIGHT;
            int r5 = VideoCommentPreviewFragment.w;
            a r8 = r1.e;
            Intrinsics.checkNotNullParameter(r6, "videoInfo");
            Intrinsics.checkNotNullParameter(r8, "callback");
            VideoCommentPreviewFragment r0 = new VideoCommentPreviewFragment();
            r0.e = null;
            r0.f = r3;
            r0.d = r6;
            r0.g = r8;
            r0.h = true;
            r3.o0(r4, r0);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
        LiveVideoCommentSelectAwemePanelView r0 = this.d;
        if (r0 == null) goto L6;
        r0.s = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
        LiveVideoCommentSelectAwemePanelView r0 = this.d;
        if (r0 == null) goto L7;
        LiveVideoCommentSelectAwemePanelView r1 = r0;
        r1.s = true;
        Integer r2 = r1.t;
        if (r2 == null) goto L7;
        r1.S5(r2.intValue());
    L7:
        LiveVideoCommentSelectAwemePanelView r3 = this.c;
        if (r3 == null) goto L20;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r4 = this.b;
        if (r4 != null) goto L12;
    L14:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5 = this.b;
        if (r5 == null) goto L17;
        int r6 = r5.W();
    L18:
        com.bytedance.android.live.core.utils.a1.k(r3, r6);
        return;
    L17:
        r6 = 0;
        goto L18
    L12:
        if (r4.W() != 0) goto L14;
        r6 = InputPanelSectionContainer.m;
        goto L18
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5) {
        Intrinsics.checkNotNullParameter(r5, "panelBridge");
        Activity r0 = r5.getActivity();
        LiveVideoCommentSelectAwemePanelView r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        this.b = r5;
        IInteractService r6 = jc1.k.f(IInteractService.class);
        if (r6 == null) goto L8;
        gd0.q r7 = r6.getVideoCommentPanel(r0, this.g, Boolean.TRUE);
    L9:
        this.d = r7;
        if (r7 == null) goto L12;
        r7.setCallback(this.e);
    L12:
        gd0.q r8 = this.d;
        if (r8 == null) goto L15;
        r1 = (LiveVideoCommentSelectAwemePanelView) r8;
    L15:
        this.c = r1;
        return r1;
    L8:
        r7 = null;
        goto L9
    }

    public s1(DataCenter r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        this.f = r2;
        this.g = r3;
        this.a = InputSectionType.VIDEO;
        this.e = new a(this);
    }
}
