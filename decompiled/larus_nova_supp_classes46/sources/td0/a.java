package td0;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import gd0.v;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public static boolean a() {
        i0 r0 = TalkRoomLogUtils.a;
        int r1 = ((IInteractService) k.n(IInteractService.class)).getLinkMode();
        if (v.a(r1, 4) == false) goto L6;
        return false;
    L6:
        if (v.a(r1, 64) == false) goto L8;
        return false;
    L8:
        int r2 = TalkRoomLogUtils.q();
        if (r2 != 5) goto L11;
    L16:
        return true;
    L11:
        if (r2 == 8) goto L16;
        if (r2 == 12) goto L16;
        if (r2 == 16) goto L16;
        return false;
    }

    static {
    }
}
