package zd0;

import com.bytedance.android.live.liveinteract.aimv.LiveLinkmicAIMVContext;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements yd0.a {
    public a() {
    }

    @Override // yd0.a
    public final boolean a(wd0.b r4) {
        Intrinsics.checkNotNullParameter(r4, "renderContext");
        IVoiceLiveTheme r5 = r4.f;
        boolean r0 = false;
        if (r5 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        LiveLinkmicAIMVContext r2 = LiveLinkmicAIMVContext.Companion.getContext();
        if (r2 == null) goto L15;
        m<Boolean> r3 = r2.isPlaying();
        if (r3 == null) goto L15;
        if (((Boolean) r3.getValue()).booleanValue() != true) goto L15;
        r0 = true;
    L15:
        if (r0 == false) goto L17;
        return r6;
    L17:
        return true;
    L5:
        if (r5.getImageType() != 3) goto L7;
        r6 = true;
        goto L8
    }
}
