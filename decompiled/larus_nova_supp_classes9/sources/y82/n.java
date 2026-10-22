package y82;

import android.content.Context;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.livesdk.interactivity.medialink.ui.player.utils.LiveType;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n {
    public Boolean a;
    public m b;
    public o c;
    public final Context d;
    public final boolean e;
    public final LiveMode f;
    public final DataCenter g;

    public final m a() {
        Boolean r0 = this.a;
        if (r0 == null) goto L51;
        boolean r4 = r0.booleanValue();
        int r1 = e.a;
        boolean r3 = this.e;
        LiveMode r2 = this.f;
        Intrinsics.checkNotNullParameter(r2, "$this$toLiveType");
        if (r2 != LiveMode.THIRD_PARTY) goto L9;
        LiveType r5 = LiveType.PC_LIVE;
    L15:
        f r6 = new f(r3, r4, r5, jc1.k.n(ILinkServiceExternal.class).getMultiAnchorServiceExternal().c().getDeviceType(), this.g);
        Intrinsics.checkNotNullParameter(r6, "param");
        if (r6.a == true) goto L54;
        LiveType r7 = r6.c;
        LiveType r8 = LiveType.PC_LIVE;
        if (r7 != r8) goto L21;
    L22:
        int r9 = b92.a.a;
        DeviceType r10 = r6.d;
        Intrinsics.checkNotNullParameter(r7, "live");
        Intrinsics.checkNotNullParameter(r10, "device");
        if (rc0.n.a(r10) == true) goto L25;
    L27:
        if (r7 != r8) goto L30;
    L31:
        boolean r11 = true;
    L33:
        if (r11 == false) goto L55;
        DeviceType r13 = r6.d;
        if (r13 != DeviceType.NORMAL_MOBILE) goto L39;
        c92.a r14 = new d92.b();
    L48:
        if (r14 != null) goto L50;
        return null;
    L50:
        return new m(r6.e, r14);
    L39:
        if (r13 != DeviceType.FOLD_FULL) goto L42;
        r14 = new d92.a();
        goto L48
    L42:
        if (r13 != DeviceType.PAD_V) goto L45;
        r14 = new d92.d();
        goto L48
    L45:
        if (r13 != DeviceType.PAD_H) goto L47;
        r14 = new d92.c();
        goto L48
    L47:
        r14 = null;
        goto L48
    L55:
        return null;
    L30:
        if (r7 == LiveType.VIDEO) goto L31;
    L32:
        r11 = false;
        goto L33
    L25:
        if (PadConfigUtils.c() == true) goto L27;
    L21:
        if (r7 == LiveType.VIDEO) goto L22;
        return null;
    L54:
        return null;
    L9:
        if (r2 != LiveMode.VIDEO) goto L12;
        r5 = LiveType.VIDEO;
        goto L15
    L12:
        if (r2 != LiveMode.MEDIA) goto L14;
        r5 = LiveType.VIDEO;
        goto L15
    L14:
        r5 = LiveType.OTHERS;
        goto L15
    L51:
        return null;
    }

    public final Context getContext() {
        return this.d;
    }

    public final void b(boolean r3) {
        if (Intrinsics.areEqual(Boolean.valueOf(r3), this.a) == false) goto L5;
        return;
    L5:
        this.a = Boolean.valueOf(r3);
        m r4 = a();
        this.b = r4;
        o r0 = this.c;
        if (r0 == null) goto L9;
        r0.i(r4);
        return;
    }

    public n(Context r2, LiveMode r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "liveMode");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.d = r2;
        this.e = false;
        this.f = r3;
        this.g = r4;
    }
}
