package com.bytedance.android.live.room.share.summersinging;

import androidx.fragment.app.FragmentManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ FragmentManager a;
    public final /* synthetic */ com.bytedance.android.live.base.model.data.f b;
    public final /* synthetic */ DataCenter c;

    public f(FragmentManager r1, com.bytedance.android.live.base.model.data.f r2, DataCenter r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r5) {
        p r6 = (p) r5;
        if (r6 != null) goto L6;
        return;
    L6:
        if (r6.a == null) goto L21;
        FragmentManager r0 = this.a;
        if (r0 == null) goto L19;
        com.bytedance.android.live.base.model.data.f.a r1 = GroupPhotoDialogFragment.q;
        com.bytedance.android.live.base.model.data.f r2 = this.b;
        DataCenter r3 = this.c;
        Intrinsics.checkNotNullParameter(r2, "groupPhotoDetail");
        Intrinsics.checkNotNullParameter(r6, "imageBitmapStore");
        GroupPhotoDialogFragment r4 = new GroupPhotoDialogFragment(r2, r3, r6);
        LandscapeRestrictionOperation r7 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, "GroupPhotoDialogFragment", r7);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r0, r4, r7) == true) goto L22;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L14:
        r4.show(r0, "GroupPhotoDialogFragment");
        return;
    L22:
        return;
    L19:
        return;
    }
}
