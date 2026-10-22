package com.larus.business.debug.base.livetutor;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.business.debug.api.ILiveTutorDebugService;
import com.larus.business.debug.api.RTCDebugInfo;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/larus/business/debug/base/livetutor/LiveTutorDebugServiceImpl;", "Lcom/larus/business/debug/api/ILiveTutorDebugService;", "<init>", "()V", "openRTCDebugDialog", "", "rtcInfo", "Lcom/larus/business/debug/api/RTCDebugInfo;", "context", "Landroid/content/Context;", "bizContent", "", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveTutorDebugServiceImpl implements ILiveTutorDebugService {
    public LiveTutorDebugServiceImpl() {
    }

    @Override // com.larus.business.debug.api.ILiveTutorDebugService
    public final void a(RTCDebugInfo r2, Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "rtcInfo");
        Intrinsics.checkNotNullParameter(r3, "context");
        if ((r3 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r5 = (FragmentActivity) r3;
    L6:
        if (r5 == null) goto L18;
        FragmentManager r6 = r5.getSupportFragmentManager();
        if (r6 == null) goto L19;
        RTCDebugDialog r0 = new RTCDebugDialog(r2, r4);
        LandscapeRestrictionOperation r7 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "RTCDebug", r7);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r0, r7) == true) goto L20;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L13:
        r0.show(r6, "RTCDebug");
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r5 = null;
        goto L6
    }
}
