package com.larus.share.impl;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.share.impl.view.DriveShareDialogFragment;
import com.larus.share.impl.view.SheetShareDialogFragment;
import com.larus.share.impl.view.SlidesShareDialogFragment;
import com.larus.share.service.IShareService;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kw9.b;
import kw9.f;
import kw9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\tH\u0016J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/larus/share/impl/ShareServiceImpl;", "Lcom/larus/share/service/IShareService;", "<init>", "()V", "showSlidesShareFragment", "Landroidx/fragment/app/DialogFragment;", "shareContext", "Lcom/larus/share/bean/SlideShareContext;", "showSheetShareFragment", "Lcom/larus/share/bean/SheetShareContext;", "showDriveShareFragment", "Lcom/larus/share/bean/DriveShareContext;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ShareServiceImpl implements IShareService {

    public static final class a {
    }

    static {
    }

    public ShareServiceImpl() {
    }

    @Override // com.larus.share.service.IShareService
    public final DialogFragment a(b r4) {
        int r0 = DriveShareDialogFragment.h;
        Intrinsics.checkNotNullParameter(r4, "shareContext");
        FragmentActivity r1 = r4.a;
        if (r1.isFinishing() == false) goto L5;
    L14:
        return null;
    L5:
        if (r1.isDestroyed() == true) goto L14;
        if (r1.getSupportFragmentManager().isStateSaved() == true) goto L14;
        DriveShareDialogFragment r2 = new DriveShareDialogFragment(r4);
        FragmentManager r5 = r4.a.getSupportFragmentManager();
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "DriveShareDialogFragment", r3);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, r2, r3) == true) goto L20;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L13:
        r2.show(r5, "DriveShareDialogFragment");
        return r2;
    L20:
        return r2;
    }

    @Override // com.larus.share.service.IShareService
    public final DialogFragment b(f r4) {
        int r0 = SheetShareDialogFragment.h;
        Intrinsics.checkNotNullParameter(r4, "shareContext");
        if (r4.a.isFinishing() == false) goto L5;
    L14:
        return null;
    L5:
        if (r4.a.isDestroyed() == true) goto L14;
        if (r4.a.getSupportFragmentManager().isStateSaved() == true) goto L14;
        SheetShareDialogFragment r1 = new SheetShareDialogFragment(r4);
        FragmentManager r5 = r4.a.getSupportFragmentManager();
        LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "SheetShareDialogFragment", r2);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, r1, r2) == true) goto L20;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L13:
        r1.show(r5, "SheetShareDialogFragment");
        return r1;
    L20:
        return r1;
    }

    @Override // com.larus.share.service.IShareService
    public final DialogFragment c(i r4) {
        int r0 = SlidesShareDialogFragment.h;
        Intrinsics.checkNotNullParameter(r4, "shareContext");
        if (r4.a.isFinishing() == false) goto L5;
    L14:
        return null;
    L5:
        if (r4.a.isDestroyed() == true) goto L14;
        if (r4.a.getSupportFragmentManager().isStateSaved() == true) goto L14;
        SlidesShareDialogFragment r1 = new SlidesShareDialogFragment(r4);
        FragmentManager r5 = r4.a.getSupportFragmentManager();
        LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "SlidesShareDialogFragment", r2);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, r1, r2) == true) goto L20;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L13:
        r1.show(r5, "SlidesShareDialogFragment");
        return r1;
    L20:
        return r1;
    }
}
