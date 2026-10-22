package com.larus.bmhome.chat.component.fastsend;

import com.larus.platform.api.a0;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a implements Function0 {
    public final /* synthetic */ FastSendImageComponent a;
    public final /* synthetic */ String b;

    public /* synthetic */ a(FastSendImageComponent r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        FastSendImageComponent r0 = this.a;
        String r1 = this.b;
        if (Intrinsics.areEqual(r0.u, Boolean.FALSE) == false) goto L5;
        String r2 = "no_image";
    L6:
        FLogger.a.i("FastSendImageComponent", "[updateBottomAlbumAfterPermission] updateDisplayType:" + r2 + ", from:" + r1);
        r0.v = r2;
        a0 r3 = r0.i;
        if (r3 == null) goto L10;
        r3.cP(r2);
    L10:
        return Unit.INSTANCE;
    L5:
        r2 = "album_display";
        goto L6
    }
}
