package com.bytedance.android.livesdk.interactivity.roomintro.view;

import android.text.TextUtils;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livehostapi.business.depend.IShowPoiSearchCallback;
import com.bytedance.android.livesdk.interactivity.roomintro.v2.RoomIntroDataSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x implements IShowPoiSearchCallback {
    public final /* synthetic */ RoomIntroDialogV2 a;

    public x(RoomIntroDialogV2 r1) {
        this.a = r1;
    }

    public final void onSearchFinish(gz.b r3) {
        Intrinsics.checkNotNullParameter(r3, "poiInfo");
        if (r3.a == false) goto L16;
        RoomIntroDataSource r0 = this.a.d;
        if (r0 == null) goto L11;
        PropertyOwner r1 = r0.m;
        if (r1 == null) goto L11;
        gz.b r2 = (gz.b) r1.a;
        if (r2 == null) goto L11;
        String r4 = r2.c;
    L13:
        if (TextUtils.equals(r4, r3.c) == false) goto L16;
        f2.b(2131919902, 0);
        return;
    L11:
        r4 = null;
    L16:
        RoomIntroDataSource r5 = this.a.d;
        if (r5 == null) goto L23;
        Intrinsics.checkNotNullParameter(r3, "newPoiStruct");
        PropertyOwner<gz.b> r6 = r5.w;
        if (r6 != null) goto L21;
        ALogger.e("RoomIntroDialogV2", "local life poi is not useable");
        return;
    L21:
        r6.a(r3);
        return;
    }
}
