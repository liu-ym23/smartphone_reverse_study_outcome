package com.larus.bmhome.video.fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b0 {
    public static final b0 a = null;

    static {
        a = new b0();
    }

    public b0() {
    }

    public static void a(FragmentManager r5, os8.b r6) {
        Intrinsics.checkNotNullParameter(r5, "fragmentManager");
        Intrinsics.checkNotNullParameter(r6, "scene");
        FLogger r0 = FLogger.a;
        r0.i("VideoDetailLauncher", "[open] scene:" + r6);
        if ((r6 instanceof os8.b.C0128b) == false) goto L6;
        r0.e("VideoDetailLauncher", "[open] VideoDetailScene.Unknown");
        return;
    L6:
        if ((r6 instanceof os8.b.a) == false) goto L9;
        VideoDetailPagerFragment r1 = new VideoDetailPagerFragment();
        ArrayList r3 = new ArrayList();
        r1.j = r3;
        r3.add(ff8.a.a(((os8.b.a) r6).a));
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r1.k = r6;
    L28:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L20
        FragmentTransaction r8 = r5.beginTransaction();     // Catch: Throwable -> L20
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r8, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "VideoDetailPagerFragment", 0) == true) goto L18;
        r8.add(r1, "VideoDetailPagerFragment");     // Catch: Throwable -> L20
    L18:
        r8.commitAllowingStateLoss();     // Catch: Throwable -> L20
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L20
    L22:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L31;
        FLogger.a.e("VideoDetailLauncher", "[openInternal] " + r10);
        return;
    L31:
        return;
    L20:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L9:
        if (Intrinsics.areEqual(r6, os8.b.C0128b.a) == false) goto L12;
        return;
    L12:
        if ((r6 instanceof os8.b.c) == false) goto L27;
        r1 = new VideoDetailPagerFragment();
        ArrayList r4 = new ArrayList();
        r1.j = r4;
        r4.add(((os8.b.c) r6).a);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r1.k = r6;
        goto L28
    L27:
        throw new NoWhenBranchMatchedException();
    }
}
