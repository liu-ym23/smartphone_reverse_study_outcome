package com.larus.voicecall.impl.utils;

import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.keva.Keva;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class RealtimeNoticeDialogHelper {
    public static final Lazy a = null;
    public static Job b;
    public static String c;

    public static final class a implements p0 {
        public a() {
        }

        public final void confirm() {
        }
    }

    static {
        a = LazyKt.lazy(new p());
        c = NameKeys.UnloadStrategy_No_Strategy;
    }

    public static void b() {
        if (((Keva) a.getValue()).getBoolean("KEY_IS_FIRST_SHOW_CALL_VIDEO_NOTICE", true) == false) goto L6;
        b = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new RealtimeNoticeDialogHelper$tryShowCallViewNotice$1(null), 2, null);
        return;
    }

    public static void a(Fragment r6) {
        Intrinsics.checkNotNullParameter(r6, "fragment");
        Context r0 = r6.getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        CommonDialog.a r1 = new CommonDialog.a();
        r1.i(r6.getResources().getString(2131900530));
        r1.g(r6.getResources().getString(2131900532));
        CommonDialog.a.f(r1, new a(), r6.getResources().getString(2131900531), false, 12);
        CommonDialog r2 = r1.b(ContextCompat.getColor(r0, v19.c.b(2130972123, r0, 2131103203)));
        FragmentManager r7 = r6.getChildFragmentManager();
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "RealtimeNoticeDialogHelper", r3);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r2, r3) == true) goto L14;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        r2.show(r7, "RealtimeNoticeDialogHelper");
        return;
    }
}
