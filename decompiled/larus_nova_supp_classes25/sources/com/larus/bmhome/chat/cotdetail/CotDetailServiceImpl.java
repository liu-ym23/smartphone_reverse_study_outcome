package com.larus.bmhome.chat.cotdetail;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.bytedance.crash.d;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/cotdetail/CotDetailServiceImpl;", "Lcom/larus/bmhome/chat/cotdetail/ICotDetailService;", "<init>", "()V", "show", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "arguments", "Landroid/os/Bundle;", "getCurrentThreadId", "", "dismiss", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CotDetailServiceImpl implements ICotDetailService {
    public CotDetailServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.cotdetail.ICotDetailService
    public final void a(FragmentManager r2) {
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        CotDetailDialogFragment r3 = r2.findFragmentByTag("CotDetailDialogFragment");
        if ((r3 instanceof CotDetailDialogFragment) == false) goto L5;
        CotDetailDialogFragment r4 = r3;
    L6:
        if (r4 == null) goto L16;
        r4.dismissAllowingStateLoss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L17;
        d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.cotdetail.ICotDetailService
    public final String c(FragmentManager r4) {
        Intrinsics.checkNotNullParameter(r4, "fragmentManager");
        CotDetailDialogFragment r5 = r4.findFragmentByTag("CotDetailDialogFragment");
        if ((r5 instanceof CotDetailDialogFragment) == false) goto L5;
        CotDetailDialogFragment r6 = r5;
    L6:
        if (r6 != null) goto L8;
        return null;
    L8:
        CotDetailFragment r0 = r6.getChildFragmentManager().findFragmentById(2131367980);
        if ((r0 instanceof CotDetailFragment) == false) goto L11;
        CotDetailFragment r1 = r0;
    L13:
        if (r1 == null) goto L20;
        Bundle r2 = r1.getArguments();
        if (r2 == null) goto L20;
        String r3 = r2.getString("thread_id");
        if (r3 == null) goto L20;
        return r3;
    L20:
        Bundle r7 = r6.getArguments();
        if (r7 != null) goto L23;
        return null;
    L23:
        return r7.getString("thread_id");
    L11:
        r1 = null;
        goto L13
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.cotdetail.ICotDetailService
    public final boolean b(FragmentManager r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "fragmentManager");
        Intrinsics.checkNotNullParameter(r5, "arguments");
        if (r4.isStateSaved() == false) goto L5;
        return false;
    L5:
        if (r4.findFragmentByTag("CotDetailDialogFragment") != null) goto L20;
        int r2 = CotDetailDialogFragment.f;
        Intrinsics.checkNotNullParameter(r5, "arguments");
        CotDetailDialogFragment r0 = new CotDetailDialogFragment();
        r0.setArguments(new Bundle(r5));
        LandscapeRestrictionOperation r6 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "CotDetailDialogFragment", r6);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r0, r6) == true) goto L19;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L11:
        r0.show(r4, "CotDetailDialogFragment");
        return true;
    L19:
        return true;
    L20:
        return false;
    }
}
