package com.larus.avlink.gallery.view;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.avlink.gallery.share.AlbumDeleteDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k0 implements com.larus.bmhome.bigimg.l1 {
    public final /* synthetic */ MediaAlbumViewHelper a;

    public k0(MediaAlbumViewHelper r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.bigimg.l1
    public final void a(Function0<Unit> r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "confirmCallback");
        Intrinsics.checkNotNullParameter(r5, "path");
        MediaAlbumViewHelper r0 = this.a;
        r0.getClass();
        AlbumDeleteDialog r1 = new AlbumDeleteDialog();
        r1.e = new i0(r0, r5, (com.larus.bmhome.bigimg.o) r4);
        FragmentActivity r6 = r0.a;
        if ((r6 instanceof FragmentActivity) == false) goto L13;
        FragmentManager r7 = r6.getSupportFragmentManager();
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "AlbumDeleteDialog", r8);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r1, r8) == true) goto L14;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        r1.show(r7, "AlbumDeleteDialog");
        return;
    L14:
        return;
    }
}
