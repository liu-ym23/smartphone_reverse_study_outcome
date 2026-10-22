package com.bytedance.android.live.broadcastgame.api.xplay;

import com.bytedance.android.livehostapi.business.depend.xplay.IByteRtcVideoFrame;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final String a(IByteRtcVideoFrame r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$dumpProperties");
        return "pixelFormat = " + r3.getPixelFormat() + ", width = " + r3.getWidth() + ", height = " + r3.getHeight() + ", textureId = " + r3.getTextureId() + ", timestampUs = " + r3.getTimestampUs();
    }

    public static final boolean b(IByteRtcVideoFrame r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$supportTextureMix");
        String r3 = r2.getPixelFormat();
        if (Intrinsics.areEqual(r3, IByteRtcVideoFrame.PixelFormat.TEXTURE_2D.getStringValue()) == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r3, IByteRtcVideoFrame.PixelFormat.TEXTURE_OES.getStringValue()) == true) goto L11;
        return false;
    L11:
        return true;
    }
}
