package com.bytedance.android.livesdk.interactivity.roomintro.view;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a0<T> implements Consumer {
    public final /* synthetic */ RoomIntroDialogV2 a;

    public a0(RoomIntroDialogV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        String r0 = rm3.c.a;
        rm3.c.f(this.a.getActivity(), 2131923023, true, 16);
        ALogger.stacktrace(6, "RoomIntroDialogV2", ((Throwable) r5).getStackTrace());
    }
}
