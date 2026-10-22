package ef0;

import com.bytedance.android.live.broadcastgame.api.xplay.g;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.android.livehostapi.business.depend.xplay.IByteRtcVideoFrame;
import com.bytedance.live.datacontext.m;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import rj0.d;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends bf0.a<g> {
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public b() {
        this.b = "kColorSpaceYCbCrBT601LimitedRange";
        this.c = "kColorSpaceYCbCrBT601FullRange";
        this.d = "kColorSpaceYCbCrBT709LimitedRange";
        this.e = "kColorSpaceYCbCrBT709FullRange";
    }

    @Override // bf0.a
    public final g b(Object r5) {
        g r6 = (g) r5;
        Intrinsics.checkNotNullParameter(r6, "frame");
        IInteractService r0 = (IInteractService) k.f(IInteractService.class);
        if (r0 == null) goto L7;
        d r1 = r0.getCommonService();
        if (r1 == null) goto L7;
        com.bytedance.android.live.pushstream.d r2 = r1.getLiveStream();
    L8:
        if (r2 == null) goto L39;
        HamletAvatarContext r3 = HamletAvatarContext.Companion.getContext();
        if (r3 == null) goto L17;
        m<Boolean> r4 = r3.isStreamRending();
        if (r4 == null) goto L17;
        Boolean r7 = (Boolean) r4.getValue();
        if (r7 == null) goto L17;
        boolean r8 = r7.booleanValue();
    L19:
        if (gh0.a.d() == false) goto L39;
        if (r8 == false) goto L39;
        IByteRtcVideoFrame r9 = r6.b();
        if (com.bytedance.android.live.broadcastgame.api.xplay.a.b(r9) == true) goto L24;
        String r10 = r6.b().getColorSpace();
        if (Intrinsics.areEqual(r10, this.b) == false) goto L31;
    L36:
        d0 r11 = r2.getLiveCore();
        if (r11 == null) goto L39;
        r6.a();
        r9.getWidth();
        r9.getHeight();
        r9.getTimestampUs();
        r11.j();
        goto L39
    L31:
        if (Intrinsics.areEqual(r10, this.d) == true) goto L36;
        if (Intrinsics.areEqual(r10, this.c) == true) goto L36;
        Intrinsics.areEqual(r10, this.e);
        goto L36
    L24:
        if (r9.getTextureId() <= 0) goto L39;
        d0 r12 = r2.getLiveCore();
        if (r12 == null) goto L39;
        r9.getTextureId();
        Intrinsics.checkNotNullParameter(r9, "$this$isTextureOes");
        Intrinsics.areEqual(r9.getPixelFormat(), IByteRtcVideoFrame.PixelFormat.TEXTURE_OES.getStringValue());
        r9.getWidth();
        r9.getHeight();
        r9.getRotation();
        r9.getTextureMatrix();
        r9.getTimestampUs();
        r12.n();
    L17:
        r8 = false;
    L39:
        return r6;
    L7:
        r2 = null;
        goto L8
    }
}
