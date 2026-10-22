package com.bytedance.android.live.profile.usecase;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.report.IMiddlewareReportService;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant$BusinessSource;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n implements ut0.e {
    public boolean a;
    public final MutableLiveData<Boolean> b;
    public final com.bytedance.android.live.profile.usecase.a c;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ n a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ ps0.b c;

        public a(n r1, Context r2, ps0.b r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r9, int r10) {
            n.e(this.a, "confirm");
            n r12 = this.a;
            Context r0 = this.b;
            boolean r5 = !r12.a;
            Disposable r1 = os0.b.b(r12.c.getRoomDataCenter()).i(this.c.getId(), r5, new o(r12, r5), new p(r12, r0));
            if (r1 == null) goto L5;
            r r13 = r12.c.getNewProfileRequestManager();
            r13.getClass();
            Intrinsics.checkNotNullParameter(r1, "disposable");
            r13.a.add(r1);
        L5:
            r9.dismiss();
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ n a;

        public b(n r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            n.e(this.a, "cancel");
            r2.dismiss();
        }
    }

    public static final class c implements DialogInterface.OnCancelListener {
        public final /* synthetic */ n a;

        public c(n r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r2) {
            n.e(this.a, "cancel");
        }
    }

    @Override // ut0.e
    public final MutableLiveData<Boolean> a() {
        return this.b;
    }

    public n(com.bytedance.android.live.profile.usecase.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileViewModel");
        this.c = r2;
        this.b = new MutableLiveData();
    }

    @Override // ut0.e
    public final void b(boolean r2) {
        this.a = r2;
        this.b.postValue(Boolean.valueOf(r2));
    }

    @Override // ut0.e
    public final void showAnonymousUserSilentDialog(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        NewProfileTrackUseCase r0 = this.c.getLogUseCase();
        boolean r1 = this.a;
        r0.getClass();
        HashMap r2 = new HashMap();
        String r3 = "unmute";
        if (r1 == false) goto L5;
        Object r4 = "unmute";
    L6:
        r2.put("mute_type", r4);
        r0.B("livesdk_mute_click", r2);
        ps0.b r5 = this.c.getRoom();
        x0.d r6 = new x0.d();
        r6.b = r10;
        r6.a = 4;
        if (this.a == false) goto L9;
        int r7 = 2131923002;
    L10:
        r6.d = s1.B(r7);
        String r8 = s1.B(2131922835);
        a r9 = new a(this, r10, r5);
        x0.c[] r12 = r6.g;
        x0.c r13 = r12[0];
        if (r13 != null) goto L13;
        r13 = new x0.c();
        r12[0] = r13;
    L13:
        r13.a = r8;
        r13.b = r9;
        String r14 = s1.B(2131922826);
        b r15 = new b(this);
        x0.c[] r16 = r6.g;
        x0.c r17 = r16[1];
        if (r17 != null) goto L16;
        r17 = new x0.c();
        r16[1] = r17;
    L16:
        r17.a = r14;
        r17.b = r15;
        r6.h = new c(this);
        x0 r18 = new x0(r6.b, r6);
        if (DialogLancet.shouldBlockDialogShow(r18) == false) goto L28;
        DialogLancet.handleBlockedDialogShow(r18);
    L21:
        HashMap r19 = new HashMap();
        if (this.a == true) goto L25;
        r3 = "mute";
    L25:
        r19.put("mute_type", r3);
        j0.l().sendLog("livesdk_mute_toast_show", r19, new Object[]{IRoom.class});
        return;
    L28:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
    L20:
        DialogLancet.beforeDialogShow(r18);
        r18.show();
        DialogLancet.afterDialogShow(r18);
        goto L21
    L9:
        r7 = 2131922549;
        goto L10
    L5:
        r4 = "mute";
        goto L6
    }

    public static final void e(n r3, String r4) {
        r3.getClass();
        HashMap r0 = new HashMap();
        if (r3.a == false) goto L5;
        String r5 = "unmute";
    L6:
        r0.put("mute_type", r5);
        r0.put("click_type", r4);
        j0.l().sendLog("livesdk_mute_toast_click", r0, new Object[]{IRoom.class});
        return;
    L5:
        r5 = "mute";
        goto L6
    }

    @Override // ut0.e
    public final void c(Context r12, UserProfileEvent r13) {
        Intrinsics.checkNotNullParameter(r12, "context");
        ps0.b r0 = this.c.getRoom();
        boolean r7 = this.c.isVertical();
        if (NetworkUtils.f(r12) == true) goto L6;
        f2.b(2131916005, 0);
        return;
    L6:
        NewProfileTrackUseCase r1 = this.c.getLogUseCase();
        r1.getClass();
        com.bytedance.android.livesdk.chatroom.o r2 = os0.b.a();
        if (r2 != null) goto L9;
    L13:
        r1.B("livesdk_anchor_room_manage_click", r1.e);
    L14:
        boolean r6 = this.c.getPageTypeUseCase().a;
        IBaseUser r5 = this.c.getRoomUser();
        IRoom r3 = r0.b();
        if ((r3 instanceof IRoom) == true) goto L17;
        r3 = null;
    L17:
        IRoom r4 = r3;
        Dialog r14 = os0.b.b(this.c.getRoomDataCenter()).f(r12, r4, r5, r6, r7, r13, Bundle.EMPTY);
        if (r14 != null) goto L20;
        return;
    L20:
        if (DialogLancet.shouldBlockDialogShow(r14) == false) goto L26;
        DialogLancet.handleBlockedDialogShow(r14);
        return;
    L26:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L23:
        DialogLancet.beforeDialogShow(r14);
        r14.show();
        DialogLancet.afterDialogShow(r14);
        return;
    L9:
        if (r2.isMediaRoom() != true) goto L13;
        if (Intrinsics.areEqual(r2.isAnchor(), Boolean.TRUE) == false) goto L13;
        HashMap r8 = new HashMap(r1.e);
        r8.put("live_type", "media");
        r1.B("livesdk_anchor_room_manage_click", r8);
        goto L14
    }

    @Override // ut0.e
    public final void d(Activity r5, UserProfileEvent r6) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        ps0.b r7 = this.c.getRoom();
        IBaseUser r0 = this.c.getRoomUser();
        this.c.isVertical();
        IRoom r8 = r7.b();
        if ((r8 instanceof IRoom) == true) goto L5;
        r8 = null;
    L5:
        IRoom r9 = r8;
        if (r9 == null) goto L12;
        if (r6 == null) goto L13;
        IMiddlewareReportService r1 = (IMiddlewareReportService) jc1.k.f(IMiddlewareReportService.class);
        if (r1 == null) goto L14;
        y71.a r2 = new y71.a(ReportConstant$BusinessSource.NewProfile);
        r2.a = r0;
        r2.b = r9;
        r2.c = r6.mSource;
        r2.d = r6.mReportSource;
        r2.e = r6.mReportTypeForLog;
        r2.f = r6.mCommentReportModel;
        r2.a(r6.getReportObject());
        r1.report(r2);
        return;
    L14:
        return;
    L13:
        return;
    }
}
