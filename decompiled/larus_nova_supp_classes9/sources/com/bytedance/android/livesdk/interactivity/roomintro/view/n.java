package com.bytedance.android.livesdk.interactivity.roomintro.view;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ FragmentActivity a;

    public n(FragmentActivity r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        String r0 = rm3.c.a;
        rm3.c.f(this.a, 2131923023, false, 28);
        ALogger.stacktrace(6, "RoomIntroDialogV2", ((Throwable) r5).getStackTrace());
    }
}
