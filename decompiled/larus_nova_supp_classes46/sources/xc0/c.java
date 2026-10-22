package xc0;

import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.o;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements b {
    public static final c b = null;

    public static final class a {
    }

    public c() {
    }

    static {
        b = new c();
    }

    @Override // xc0.b
    public final o a(com.bytedance.android.live.liveinteract.animation.e r4, com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r5, o r6, ArrayList<String> r7) {
        Intrinsics.checkNotNullParameter(r5, "giftInfo");
        Intrinsics.checkNotNullParameter(r6, "positionInfo");
        Intrinsics.checkNotNullParameter(r7, "onlineList");
        String r8 = r5.b;
        if (r8 != null) goto L5;
        return r6;
    L5:
        o r0 = new o(r6.a, r6.b, r6.c);
        if (r7.contains(r8) == false) goto L11;
        if (r4 == null) goto L9;
        EPointF r9 = r4.Mj(r8);
    L10:
        r0.a = r9;
        r0.d = true;
        goto L11
    L9:
        r9 = null;
    L11:
        return r0;
    }
}
