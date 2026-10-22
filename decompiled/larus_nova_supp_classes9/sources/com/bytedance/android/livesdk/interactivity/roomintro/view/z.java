package com.bytedance.android.livesdk.interactivity.roomintro.view;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.roomintro.v2.RoomIntroDataSource;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z<T> implements Consumer {
    public final /* synthetic */ RoomIntroDialogV2 a;
    public final /* synthetic */ boolean b;

    public z(RoomIntroDialogV2 r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        Response r8 = (Response) r7;
        Integer r0 = ((com.bytedance.android.livesdk.interactivity.api.roomintro.api.b) ((BaseResponse) r8).data).j();
        boolean r2 = false;
        if (r0 != null) goto L6;
    L11:
        String r1 = rm3.c.a;
        FragmentActivity r3 = this.a.getActivity();
        String r4 = ((com.bytedance.android.livesdk.interactivity.api.roomintro.api.b) ((BaseResponse) r8).data).c();
        if (r4 != null) goto L14;
        r4 = s1.B(2131923023);
    L14:
        rm3.c.g(r3, r4, 0, true, 16);
    L15:
        RoomIntroDialogV2 r5 = this.a;
        Integer r9 = ((com.bytedance.android.livesdk.interactivity.api.roomintro.api.b) ((BaseResponse) r8).data).j();
        int r6 = RoomIntroDialogV2.u;
        r5.getClass();
        if (r9 == null) goto L22;
        r9.intValue();
        if (r9.intValue() != 0) goto L20;
    L21:
        boolean r10 = true;
    L23:
        if (r10 == false) goto L73;
        RoomIntroDataSource r11 = this.a.d;
        if (r11 == null) goto L35;
        boolean r13 = this.b;
        RoomIntroDataSource.x.getClass();
        if (RoomIntroDataSource.a.a() == false) goto L35;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r14 = r11.n;
        if (r14 == null) goto L35;
        Function1<Boolean, Unit> r15 = r14.f;
        if (r15 == null) goto L35;
        Unit r16 = (Unit) r15.invoke(Boolean.valueOf(r13));
    L35:
        if (this.b == false) goto L74;
        RoomIntroDataSource r17 = this.a.d;
        if (r17 == null) goto L71;
        RoomIntroDataSource.x.getClass();
        if (RoomIntroDataSource.a.a() == false) goto L71;
        PropertyOwner r18 = r17.m;
        if (r18 == null) goto L71;
        gz.b r19 = (gz.b) r18.a;
        if (r19 == null) goto L71;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r20 = r17.n;
        if (r20 == null) goto L49;
        gz.b r21 = r20.d;
    L50:
        if (r21 != null) goto L53;
    L57:
        if (r2 == true) goto L71;
        com.bytedance.android.livesdk.sharedpref.e r23 = com.bytedance.android.livesdk.sharedpref.b.B;
        r23.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r23, 1);
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r24 = r17.n;
        if (r24 == null) goto L71;
        Function1<gz.b, Unit> r25 = r24.e;
        if (r25 == null) goto L71;
        Unit r26 = (Unit) r25.invoke(r19);
        goto L71
    L53:
        if (r19.a != r21.a) goto L57;
        if (Intrinsics.areEqual(r19.c, r21.c) == false) goto L57;
        r2 = true;
        goto L57
    L49:
        r21 = null;
    L71:
        this.a.dismiss();     // Catch: Exception -> L66
        return;
    L66:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r27 = DialogFragmentLancet.sLastShowStack;
        if (r27 == null) goto L75;
        com.bytedance.crash.d.d(r27, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L75:
        return;
    L74:
        return;
    L73:
        return;
    L20:
        if (r9.intValue() == 30001) goto L21;
    L22:
        r10 = false;
        goto L23
    L6:
        if (r0.intValue() != 0) goto L11;
        if (this.b == false) goto L10;
        String r28 = rm3.c.a;
        rm3.c.f(this.a.getActivity(), 2131919921, true, 16);
    L10:
        ALogger.i("RoomIntroDialogV2", "update room_intro succeed with switch " + this.b);
        goto L15
    }
}
