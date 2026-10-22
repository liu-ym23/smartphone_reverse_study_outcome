package p61;

import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import jc1.k;
import kotlin.jvm.JvmStatic;
import l61.c;
import l61.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static boolean a;

    @JvmStatic
    public static final boolean a() {
        if (a == false) goto L5;
        return false;
    L5:
        ILiveExpOptService r0 = (ILiveExpOptService) k.f(ILiveExpOptService.class);
        if (r0 == null) goto L13;
        c r1 = r0.getSceneState(null, d.a.a1.e);
        if (r1 != null) goto L10;
        return false;
    L10:
        if (r1.a() != true) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    static {
    }
}
