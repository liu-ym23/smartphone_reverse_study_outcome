package ug0;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import java.util.List;
import jc1.k;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yg0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static Pair a() {
        ILivePlayerClient r0 = hs0.a.b.getCurrentClient();
        if (r0 == null) goto L13;
        IRoomEventHub r1 = r0.getEventHub();
        if (r1 == null) goto L13;
        MutableLiveData r2 = r1.getVideoSizeChanged();
        if (r2 == null) goto L13;
        Pair r3 = (Pair) r2.getValue();
        if (r3 == null) goto L13;
        return new Pair(r3.getFirst(), r3.getSecond());
    L13:
        return new Pair(0, 0);
    }

    static {
    }

    public static boolean c(m r6) {
        Intrinsics.checkNotNullParameter(r6, "layoutConfig");
        m.a r0 = r6.c();
        if (r0 != null) goto L5;
    L13:
        return false;
    L5:
        if (r0.e() != 2) goto L13;
        List r1 = CollectionsKt.listOf(new Integer[]{9, 6, 3});
        m.a r7 = r6.c();
        if (r7 == null) goto L9;
        Integer r8 = Integer.valueOf(r7.b());
    L11:
        if (CollectionsKt.contains(r1, r8) == false) goto L13;
        return true;
    L9:
        r8 = null;
        goto L11
    }

    public static Pair b(int r7, int r8, int r9, int r10) {
        float r1 = r10;
        boolean r2 = true;
        if ((r9 / r1) <= 0.5625f) goto L5;
        boolean r0 = true;
    L6:
        ln0.a r5 = h.a;
        boolean r6 = h.j(r7, r8);
        if (FoldScreenUtils.e() == false) goto L9;
    L13:
        if (r6 == false) goto L22;
        if (r2 == false) goto L22;
        int r3 = c1.a;
        if (c1.a(Integer.valueOf(r7), Integer.valueOf(r8)) == true) goto L22;
        if (((IInteractService) k.n(IInteractService.class)).needSpecialAdjustScreen(r7, r8) == false) goto L21;
        int r11 = Math.min(r9, (int) (r1 * 0.5f));
    L23:
        int r12 = x8.a.a;
        StringBuilder r13 = new StringBuilder("adjustUIForXScreen, screen[");
        r13.append(s1.y());
        r13.append(", ");
        r13.append(s1.w());
        r13.append("], livePlayerParent[");
        hs0.a r4 = hs0.a.b;
        View r14 = r4.getCurrentLivePlayerParent();
        Integer r15 = null;
        if (r14 == null) goto L26;
        Integer r16 = Integer.valueOf(r14.getWidth());
    L27:
        r13.append(r16);
        r13.append(", ");
        View r17 = r4.getCurrentLivePlayerParent();
        if (r17 == null) goto L30;
        r15 = Integer.valueOf(r17.getHeight());
    L30:
        r13.append(r15);
        r13.append("], containerWH[");
        r13.append(r9);
        r13.append(", ");
        r13.append(r10);
        r13.append("], adjustWH[");
        r13.append(r11);
        r13.append(", ");
        r13.append(r10);
        r13.append(']');
        x8.a.b("ScreenAdjust", r13.toString(), false);
        return new Pair(Integer.valueOf(r11), Integer.valueOf(r10));
    L26:
        r16 = null;
        goto L27
    L21:
        r11 = Math.min(r9, (int) (r1 * 0.5625f));
    L22:
        r11 = r9;
        goto L23
    L9:
        if (PadConfigUtils.c() == true) goto L13;
        if (r0 == true) goto L13;
        r2 = false;
        goto L13
    L5:
        r0 = false;
        goto L6
    }
}
