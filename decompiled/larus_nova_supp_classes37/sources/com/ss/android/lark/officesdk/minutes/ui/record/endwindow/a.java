package com.ss.android.lark.officesdk.minutes.ui.record.endwindow;

import com.google.gson.Gson;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAvatar;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.g;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.r;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmEndWindowChangeSpeakerOrigin;
import com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmEndWindowChangeSpeakerResponse;
import com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmLarkSpeakerInfoToJS;
import com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmNonLarkSpeakerInfoToJS;
import com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmSpeakerAvatarToJS;
import com.ss.android.lark.officewebview.bridge.Status;
import com.ss.android.lark.utils.e0;
import kotlin.jvm.internal.Intrinsics;
import xwb.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements com.ss.android.lark.officesdk.minutes.ui.record.speaker.a {
    public final /* synthetic */ MmEndWindowFragment a;
    public final /* synthetic */ j b;
    public final /* synthetic */ MmEndWindowChangeSpeakerOrigin c;

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.speaker.a
    public final void onDismiss() {
        int r0 = bwb.b.a;
        MmUiLogScene r1 = MmUiLogScene.END_WINDOW;
        MmEndWindowFragment r2 = this.a;
        int r3 = MmEndWindowFragment.D;
        bwb.b.f(r1, "onChangeSpeaker", "panel dismissed", r2.U90());
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.speaker.a
    public final void h(g r21) {
        Intrinsics.checkNotNullParameter(r21, "result");
        int r2 = bwb.b.a;
        MmUiLogScene r3 = MmUiLogScene.END_WINDOW;
        MmEndWindowFragment r4 = this.a;
        int r5 = MmEndWindowFragment.D;
        bwb.b.f(r3, "onSpeakerMarked", "result=" + r21, r4.U90());
        if (r21.a == false) goto L26;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r1 = r21.d;
        if (r1 == null) goto L25;
        MmEndWindowFragment r6 = this.a;
        MmEndWindowChangeSpeakerOrigin r7 = this.c;
        j r8 = this.b;
        r6.ia0().dispatchEvent(new c.b(r7.getClusterId(), r1));
        boolean r9 = false;
        String r10 = null;
        MmSpeakerAvatarToJS r11 = null;
        if (r1.f.isLarkUser() == false) goto L18;
        MmEndWindowChangeSpeakerResponse.a r12 = MmEndWindowChangeSpeakerResponse.Companion;
        String r14 = r7.getClusterId();
        r12.getClass();
        Intrinsics.checkNotNullParameter(r14, "clusterId");
        Intrinsics.checkNotNullParameter(r1, MmEndWindowAvatar.TYPE_SPEAKER);
        MmLarkSpeakerInfoToJS.Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, MmEndWindowAvatar.TYPE_SPEAKER);
        String r13 = r1.a;
        String r15 = r1.b;
        String r16 = r1.c;
        if (r16.length() <= 0) goto L11;
        r9 = true;
    L11:
        if (r9 == true) goto L14;
        r16 = null;
    L14:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.d r17 = r1.e;
        if (r17 == null) goto L17;
        r11 = new MmSpeakerAvatarToJS(r17.a, r17.b);
    L17:
        MmEndWindowChangeSpeakerResponse r18 = new MmEndWindowChangeSpeakerResponse(true, r14, 1, new MmLarkSpeakerInfoToJS(r13, r15, r16, r11), null, 16, null);
    L24:
        String r19 = e0.c(r18);
        bwb.b.f(r3, "onChangeSpeaker", "toJS=" + r19, r6.U90());
        r8.a(Status.SUCCESS, r19);
        return;
    L18:
        MmEndWindowChangeSpeakerResponse.a r20 = MmEndWindowChangeSpeakerResponse.Companion;
        String r110 = r7.getClusterId();
        r20.getClass();
        Intrinsics.checkNotNullParameter(r110, "clusterId");
        Intrinsics.checkNotNullParameter(r1, MmEndWindowAvatar.TYPE_SPEAKER);
        MmNonLarkSpeakerInfoToJS.Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, MmEndWindowAvatar.TYPE_SPEAKER);
        String r22 = r1.a;
        String r111 = r1.b;
        String r23 = r1.d;
        if (r23.length() <= 0) goto L21;
        r9 = true;
    L21:
        if (r9 == false) goto L23;
        r10 = r23;
    L23:
        r18 = new MmEndWindowChangeSpeakerResponse(true, r110, 2, null, new MmNonLarkSpeakerInfoToJS(r22, r111, r10), 8, null);
        goto L24
    L25:
        j r24 = this.b;
        Status r25 = Status.FAILURE;
        Gson r26 = e0.a;
        MmEndWindowChangeSpeakerResponse.Companion.getClass();
        r24.a(r25, e0.c(MmEndWindowChangeSpeakerResponse.a.a()));
        return;
    L26:
        j r27 = this.b;
        Status r28 = Status.FAILURE;
        Gson r29 = e0.a;
        MmEndWindowChangeSpeakerResponse.Companion.getClass();
        r27.a(r28, e0.c(MmEndWindowChangeSpeakerResponse.a.a()));
    }

    public a(MmEndWindowFragment r1, xwb.d r2, MmEndWindowChangeSpeakerOrigin r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.speaker.a
    public final void a(String r11, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r12, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r13) {
        Intrinsics.checkNotNullParameter(r11, "clusterId");
        Intrinsics.checkNotNullParameter(r12, "oldSpeaker");
        Intrinsics.checkNotNullParameter(r13, "newSpeaker");
        MmEndWindowFragment r3 = this.a;
        int r4 = MmEndWindowFragment.D;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.c r5 = r3.ha0();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r11, "clusterId");
        Intrinsics.checkNotNullParameter(r12, "oldSpeaker");
        Intrinsics.checkNotNullParameter(r13, "newSpeaker");
        ((r) r5.a.h.getValue()).a(r5.c, r11, r12, r13, "end_summary");
    }
}
