package com.bytedance.android.live.anchormodelink.linkroom;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.liveinteract.videotalk.dialog.InteractBeautyPreviewDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LinkBasicJsbHandler$showLinkmicBeautyPanel$1 implements js0.b {
    public final /* synthetic */ e a;
    public final /* synthetic */ d b;
    public final /* synthetic */ boolean c;

    public final void onSuccess(String r4) {
        Intrinsics.checkNotNullParameter(r4, "track");
        int r5 = InteractBeautyPreviewDialog.A;
        InteractBeautyPreviewDialog r6 = InteractBeautyPreviewDialog.a.a(this.b, "NewVideoLinkJSB", new LinkBasicJsbHandler$showLinkmicBeautyPanel$1$onSuccess$1(this));
        e r0 = this.a;
        r0.a = r6;
        if (this.c == false) goto L5;
        r6.w = true;
    L5:
        r6.x = true;
        FragmentActivity r1 = r0.d;
        if (r1 == null) goto L14;
        FragmentManager r2 = r1.getSupportFragmentManager();
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, "InteractBeautyPreviewDialog", r3);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r6, r3) == true) goto L18;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L11:
        r6.show(r2, "InteractBeautyPreviewDialog");
        return;
    L18:
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public LinkBasicJsbHandler$showLinkmicBeautyPanel$1(e r1, d r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
