package com.bytedance.android.livesdk.chatroom.ui.record.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.live.IQuickRecordPopupWindow;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;
import pm1.h;
import vr1.t;
import vr1.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class QuickRecordingPresenter$startRecord$1 implements js0.b {
    public final /* synthetic */ QuickRecordingPresenter a;

    public static final class a implements tp2.a.b {
        public a(QuickRecordingPresenter$startRecord$1 r1, z r2) {
        }
    }

    public final void onSuccess(String r9) {
        Intrinsics.checkNotNullParameter(r9, "track");
        String r10 = r.r().a(this.a.getContext(), System.currentTimeMillis() + ".mp4");
        if (TextUtils.isEmpty(r10) == false) goto L6;
        f2.c("缓存文件创建失败", 0);
        return;
    L6:
        QuickRecordingPresenter r0 = this.a;
        if (r10 != null) goto L9;
        return;
    L9:
        r0.getClass();
        h r11 = h.d;
        Object r1 = r11.c(vr1.h.class);
        Intrinsics.checkNotNull(r1);
        com.bytedance.android.livesdk.chatroom.vs_host.impl.r r2 = ((vr1.h) r1).a(this.a.getContext());
        QuickRecordingPresenter r3 = this.a;
        Object r12 = r11.c(vr1.h.class);
        Intrinsics.checkNotNull(r12);
        QuickRecordingPresenter r4 = this.a;
        Intent r5 = r4.k;
        ((vr1.h) r12).c(r4.getContext(), r2);
        r3.getClass();
        this.a.getClass();
        View r13 = null;
        this.a.getClass();
        this.a.f(false);     // Catch: Exception -> L43
        this.a.getClass();     // Catch: Exception -> L43
        this.a.e(ILiveRecordService.RecordStatus.READY);     // Catch: Exception -> L43
        this.a.getClass();     // Catch: Exception -> L43
        this.a.e(ILiveRecordService.RecordStatus.RECORDING);     // Catch: Exception -> L43
        final int[] r6 = new int[2];     // Catch: Exception -> L43
        this.a.h.getLocationInWindow(r6);     // Catch: Exception -> L43
        Context r7 = this.a.getContext();     // Catch: Exception -> L43
        if ((r7 instanceof Activity) == true) goto L13;
        r7 = null;
    L13:
        Activity r8 = (Activity) r7;     // Catch: Exception -> L43
        if (r8 == null) goto L48;
        QuickRecordingPresenter r14 = this.a;     // Catch: Exception -> L43
        t r15 = r.r();     // Catch: Exception -> L43
        DataCenter r16 = this.a.g;     // Catch: Exception -> L43
        if (r16 == null) goto L23;
        IRoom r17 = (IRoom) r16.get("data_room");     // Catch: Exception -> L43
        if (r17 == null) goto L23;
        IBaseUser r18 = r17.getOwner();     // Catch: Exception -> L43
        if (r18 == null) goto L23;
        String r19 = r18.getNickName();     // Catch: Exception -> L43
        if (r19 == null) goto L23;
    L24:
        r14.a = r15.c(r8, r19);     // Catch: Exception -> L43
        IQuickRecordPopupWindow r20 = this.a.a;     // Catch: Exception -> L43
        if (r20 == null) goto L27;
        r20.setDismissListener(new QuickRecordingPresenter$startRecord$1$onSuccess$$inlined$apply$lambda$1(this, r6));     // Catch: Exception -> L43
    L27:
        QuickRecordingPresenter r21 = this.a;     // Catch: Exception -> L43
        IQuickRecordPopupWindow r22 = r21.a;     // Catch: Exception -> L43
        if (r22 == null) goto L49;
        Context r23 = r21.getContext();     // Catch: Exception -> L43
        if ((r23 instanceof Activity) == true) goto L32;
        r23 = null;
    L32:
        Activity r24 = (Activity) r23;     // Catch: Exception -> L43
        if (r24 == null) goto L41;
        Window r25 = r24.getWindow();     // Catch: Exception -> L43
        if (r25 == null) goto L41;
        r13 = r25.getDecorView();     // Catch: Exception -> L43
        if (com.larus.home.impl.utils.c.e == false) goto L41;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Exception -> L43
        Thread r26 = ThreadMethodProxy.currentThread();     // Catch: Exception -> L43
        if (r26 == com.larus.home.impl.utils.c.a) goto L41;
        com.larus.home.impl.utils.c.a(r26, "getDecorView");     // Catch: Exception -> L43
    L41:
        r22.showAtLocation(r13, 0, r6[0], r6[1]);     // Catch: Exception -> L43
        return;
    L49:
        return;
    L23:
        r19 = "";
        goto L24
    L48:
        return;
    L43:
        e = move-exception;
        ALogger.e("QuickRecordingPresenter", e);
        QuickRecordingPresenter r27 = this.a;
        r27.getClass();
        r27.e(ILiveRecordService.RecordStatus.FINISH);
        r27.getClass();
        r27.f(true);
    }

    public QuickRecordingPresenter$startRecord$1(QuickRecordingPresenter r1, long r2) {
        this.a = r1;
    }
}
