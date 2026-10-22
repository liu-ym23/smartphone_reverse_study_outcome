package uy1;

import android.content.Context;
import com.bytedance.android.anya.q;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.grouplive.component.GroupComponentFacade;
import com.bytedance.android.livesdk.gift.grouplive.component.k;
import com.bytedance.android.livesdk.gift.grouplive.component.m;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.scope.o;
import cy0.j;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements o {
    public q a;
    public m b;
    public GroupComponentFacade c;
    public com.bytedance.android.livesdk.revenue.service.ui.b d;
    public int e;
    public CompositeDisposable f;
    public final k g;
    public final Context h;
    public final com.bytedance.android.livesdk.revenue.service.room.c i;

    public final void onStart() {
    }

    public final void onStop() {
        CompositeDisposable r0 = this.f;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.f = null;
    }

    public static boolean d(int r3) {
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.g.n.getValue(null, com.bytedance.android.livesdk.gift.platform.core.g.a[11])).booleanValue() == true) goto L5;
    L9:
        return false;
    L5:
        if (r3 != 6) goto L7;
    L8:
        return true;
    L7:
        if (r3 != 7) goto L9;
        goto L8
    }

    public e(k r2, Context r3, com.bytedance.android.livesdk.revenue.service.room.c r4) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "roomService");
        this.g = r2;
        this.h = r3;
        this.i = r4;
    }

    public final aq2.a c(int r4, int r5, int r6, int r7) {
        ALogger.d("GroupCard", "Third Row Count:shortTouchCount(" + r4 + "),normalBannerCount(" + r5 + "),activityBannerCount(" + r6 + ')');
        com.bytedance.android.livesdk.revenue.service.sti.a r0 = (com.bytedance.android.livesdk.revenue.service.sti.a) com.bytedance.android.scope.m.e.d(this.g, com.bytedance.android.livesdk.revenue.service.sti.a.class);
        if (r0 == null) goto L10;
        r0.Io();
        if (((r4 + r5) + r6) > 0) goto L10;
        if (d(r7) == true) goto L10;
        float r8 = 74.0f;
    L12:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L14;
    L18:
        this.e = (r4 + r5) + r6;
        return new aq2.a(new aq2.b(s1.f(12.0f), s1.f(r8 + 8.0f), s1.f(12.0f), s1.f(52.0f)), true, 9);
    L14:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L18;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L18;
        r8 = r8 + UtilityKotlinExtentionsKt.k(StatusBarUtil.getStatusBarHeight(this.h));
    L10:
        r8 = 128.0f;
        goto L12
    }

    public static final void a(e r3, int r4, int r5, int r6, int r7) {
        com.bytedance.android.livesdk.revenue.service.ui.b r0 = r3.d;
        if (r0 == null) goto L15;
        int r1 = (r4 + r5) + r6;
        if (r3.e <= 0) goto L8;
        if (r1 == 0) goto L9;
    L10:
        boolean r2 = false;
    L11:
        r0.a(r3.c(r4, r5, r6, r7));
        if (r2 == false) goto L16;
        n r8 = new n();
        mz0.m r9 = new mz0.m();
        r9.b(LogCommon.ROOM);
        List r10 = r8.b;
        ArrayList r11 = (ArrayList) r10;
        r11.addAll(r9.a);
        cy0.e.a.getClass();
        j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r14);
        ((f80.a) r14).w3("livesdk_group_playmode_widget_conflict", r8.a, r8.b);
        return;
    L16:
        return;
    L9:
        r2 = true;
        goto L11
    L8:
        if (r1 <= 0) goto L10;
    }
}
