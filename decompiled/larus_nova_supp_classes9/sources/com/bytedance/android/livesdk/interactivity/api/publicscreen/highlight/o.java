package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final String a(DataCenter r4) {
        Integer r0 = null;
        if (r4 == null) goto L5;
        IRoom r5 = gb2.a.e(r4);
    L6:
        IInteractService r1 = jc1.k.f(IInteractService.class);
        if (r1 == null) goto L9;
        Integer r2 = Integer.valueOf(r1.getCurrentScene());
    L10:
        IInteractService r3 = jc1.k.f(IInteractService.class);
        if (r3 == null) goto L14;
        r0 = Integer.valueOf(r3.getCurrentUiLayout());
    L14:
        if (r5 != null) goto L16;
    L41:
        if (r2 != null) goto L44;
        return BuildConfig.FLAVOR;
    L44:
        if (r2.intValue() != 12) goto L51;
        return "video";
    L51:
        return BuildConfig.FLAVOR;
    L16:
        if (r5.isLiveTypeAudio() != true) goto L41;
        if (r2 != null) goto L20;
    L22:
        if (r2 != null) goto L24;
    L25:
        if (r0 != null) goto L27;
    L40:
        return "radio";
    L27:
        if (r0.intValue() == 0) goto L40;
    L29:
        if (r2 != null) goto L32;
        return BuildConfig.FLAVOR;
    L32:
        if (r2.intValue() != 9) goto L48;
        if (r0 != null) goto L36;
    L38:
        String r6 = "ktv";
    L49:
        return r6;
    L36:
        if (r0.intValue() != 61) goto L38;
        r6 = "chorus";
        goto L49
    L48:
        return BuildConfig.FLAVOR;
    L24:
        if (r2.intValue() != 0) goto L29;
    L20:
        if (r2.intValue() != 5) goto L22;
        return "voice";
    L9:
        r2 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    @JvmStatic
    public static final String b(DataCenter r1) {
        if (r1 == null) goto L6;
        IRoom r2 = gb2.a.e(r1);
        if (r2 == null) goto L6;
        LiveMode r3 = r2.getStreamType();
    L7:
        int r0 = h1.a;
        return i1.a(r3);
    L6:
        r3 = null;
        goto L7
    }

    public static void c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "str");
        ALogger.i("PSHighlightLogger", r1);
    }
}
