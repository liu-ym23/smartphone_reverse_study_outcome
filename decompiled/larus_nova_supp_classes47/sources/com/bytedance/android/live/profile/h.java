package com.bytedance.android.live.profile;

import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.monitor.EndType;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.monitor.TimeType;
import com.bytedance.android.live.profile.p000enum.ProfileMode;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.event.FollowStatusDataErrorEvent;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ NewProfileDialogLauncher a;
    public final /* synthetic */ ProfileMonitor b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ long d;
    public final /* synthetic */ IRoom e;
    public final /* synthetic */ long f;
    public final /* synthetic */ String g;
    public final /* synthetic */ Function1 h;
    public final /* synthetic */ ProfileMode i;

    public h(NewProfileDialogLauncher r1, ProfileMonitor r2, boolean r3, long r4, IRoom r6, long r7, String r9, Function1 r10, ProfileMode r12) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
        this.f = r7;
        this.g = r9;
        this.h = r10;
        this.i = r12;
    }

    public final void accept(Object r14) {
        ApiServerException r15 = (Throwable) r14;
        ProfileMonitor r0 = this.b;
        r0.i(TimeType.RequestEnd);
        DataType r1 = DataType.RequestLogId;
        boolean r2 = r15 instanceof CustomApiServerException;
        String r3 = null;
        if (r2 == true) goto L5;
        ApiServerException r4 = null;
    L6:
        CustomApiServerException r5 = (CustomApiServerException) r4;
        String r6 = "";
        if (r5 == null) goto L10;
        String r7 = r5.getXTtLogId();
        if (r7 == null) goto L10;
    L11:
        r0.d(r1, r7);
        r0.d(DataType.RequestSuccess, Boolean.FALSE);
        DataType r8 = DataType.ErrorCode;
        if ((r15 instanceof ApiException) == true) goto L14;
        ApiServerException r9 = null;
    L15:
        ApiException r10 = (ApiException) r9;
        if (r10 == null) goto L18;
        Integer r12 = Integer.valueOf(r10.getErrorCode());
    L19:
        r0.d(r8, r12);
        int r13 = -1;
        if (this.c == false) goto L30;
        LiveDialogFragment r16 = this.a.c;
        if ((r16 instanceof NewLiveProfileDialogFragment) == true) goto L24;
        r16 = null;
    L24:
        NewLiveProfileDialogFragment r17 = (NewLiveProfileDialogFragment) r16;
        if (r17 == null) goto L30;
        ALogger.i("NewUserProfile_ProfilePre", "二次刷新接口请求失败");
        ProfileMonitor r18 = r17.q;
        if (r18 == null) goto L29;
        r18.d(DataType.UpdateTimeNode, -1);
    L29:
        r17.T90().ensureFinalDataAvailable();
    L30:
        NewProfileDialogLauncher r19 = this.a;
        long r20 = this.d;
        IRoom r22 = this.e;
        r19.getClass();
        NewProfileDialogLauncher.d(r20, r22, DataType.FALSE);
        NewProfileDialogLauncher r23 = this.a;
        r23.a = false;
        boolean r24 = r15 instanceof ApiServerException;
        if (r24 == false) goto L33;
        r13 = r15.getErrorCode();
    L33:
        NewProfileDialogLauncher.a(r23, r13, this.f);
        if (r24 == false) goto L38;
        ApiServerException r25 = r15;
        if (TextUtils.isEmpty(r25.getPrompt()) == true) goto L38;
        f2.c(r25.getPrompt(), 0);
    L38:
        xs2.b r26 = xs2.b.a();
        FollowStatusDataErrorEvent.FollowDataSource r27 = FollowStatusDataErrorEvent.FollowDataSource.PROFILE_FOLLOW;
        if (r2 == true) goto L41;
        ApiServerException r28 = null;
    L42:
        CustomApiServerException r29 = (CustomApiServerException) r28;
        if (r29 == null) goto L48;
        String r30 = r29.getXTtLogId();
        if (r30 == null) goto L48;
        String r110 = r30;
    L49:
        IRoom r32 = this.e;
        if (r32 == null) goto L54;
        IBaseUser r33 = r32.getOwner();
        if (r33 == null) goto L54;
        r3 = r33.getIdString();
    L54:
        r26.post(new FollowStatusDataErrorEvent(null, r27, "api request error", r110, String.valueOf(r3), this.g));
        if ((r15 instanceof Exception) == false) goto L57;
        String r111 = r15.getMessage();
    L58:
        ALogger.i("NewProfileDialogLauncher", "livesdk_new_profile_load_error!-" + r111);
        ProfileMonitor r34 = this.b;
        EndType r35 = EndType.NetworkRequestError;
        if (r111 == null) goto L62;
        r6 = r111;
    L62:
        r34.a(r35, r6);
        Function1 r112 = this.h;
        if (r112 == null) goto L66;
        Unit r113 = (Unit) r112.invoke(this.i);
        return;
    L66:
        return;
    L57:
        r111 = "";
    L48:
        r110 = "";
        goto L49
    L41:
        r28 = r15;
        goto L42
    L18:
        r12 = null;
        goto L19
    L14:
        r9 = r15;
    L10:
        r7 = "";
        goto L11
    L5:
        r4 = r15;
        goto L6
    }
}
