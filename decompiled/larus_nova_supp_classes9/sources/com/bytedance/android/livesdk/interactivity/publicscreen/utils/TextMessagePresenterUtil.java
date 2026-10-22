package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.interactivity.api.settings.config.u0;
import com.bytedance.android.livesdk.message.model.ck;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.message.AppointmentInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r52.a4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class TextMessagePresenterUtil {
    public static final boolean a = false;

    static {
        a = ((u0) a4.a.getValue()).b();
    }

    @JvmStatic
    public static final boolean a(tlc.d r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r4, "message");
        if ((r4 instanceof ck) == true) goto L5;
    L21:
        return false;
    L5:
        if (a == true) goto L7;
        return false;
    L7:
        ck r6 = (ck) r4;
        if (r6.H() == false) goto L11;
        ALogger.i("PublicScreenFirstMessageProcessorV2", "满足poeEnable，异步渲染");
        return true;
    L11:
        AppointmentInfo r7 = r6.G();
        if (r7 == null) goto L14;
        String r8 = r7.getAppointmentId();
    L16:
        if (Intrinsics.areEqual(o3.j(r5).isAnchor(), Boolean.FALSE) == false) goto L21;
        if (r2.a(r8) == false) goto L21;
        ALogger.i("PublicScreenFirstMessageProcessorV2", "直播间预告，异步渲染");
        return true;
    L14:
        r8 = null;
        goto L16
    }

    @JvmStatic
    public static final void b(final DataCenter r2, CompositeDisposable r3, final tlc.d r4) {
        Intrinsics.checkNotNullParameter(r3, "disposable");
        Intrinsics.checkNotNullParameter(r4, "message");
        com.bytedance.android.livesdk.interactivity.api.h r0 = com.bytedance.android.livesdk.interactivity.api.i.a(null, r2);
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.getHasAllPluginLoaded();
        if (r1 == null) goto L11;
        Disposable r5 = i80.a.a(r1, new TextMessagePresenterUtil$storeAndDispatchRoomIntroMessage$1(r2, r4));
        if (r5 == null) goto L12;
        RxUtilKt.c(r5, r3);
        return;
    L12:
        return;
    L11:
        return;
    }
}
