package com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdk.interactivity.roomintro.v2.RoomIntroDataSource;
import com.bytedance.android.livesdk.interactivity.roomintro.v2.secondarydialog.RoomIntroLabelSelectDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ m a;
    public final /* synthetic */ Function0 b;

    public n(m r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        int r0 = RoomIntroLabelSelectDialog.j;
        if (r4 == null) goto L5;
        Context r5 = r4.getContext();
    L6:
        RoomIntroDataSource r1 = this.a.f;
        Integer r2 = (Integer) this.b.invoke();
        Intrinsics.checkNotNullParameter(r1, "dataSource");
        FragmentActivity r6 = ContextUtil.contextToFragmentActivity(r5);
        if (r6 == null) goto L17;
        RoomIntroLabelSelectDialog r3 = new RoomIntroLabelSelectDialog();
        r3.d = r1;
        r3.e = r2;
        FragmentManager r7 = r6.getSupportFragmentManager();
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, "RoomIntroLabelSelectDialog", r8);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r3, r8) == true) goto L18;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L12:
        r3.show(r7, "RoomIntroLabelSelectDialog");
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r5 = null;
        goto L6
    }
}
