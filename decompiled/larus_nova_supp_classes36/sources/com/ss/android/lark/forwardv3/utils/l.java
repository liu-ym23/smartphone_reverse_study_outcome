package com.ss.android.lark.forwardv3.utils;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.forwardv3.confirmdialog.ForwardConfirmDialogAdapter;
import com.ss.android.lark.picker.base.view.avatar.ExternalTargetAvatarProviderStore;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements ForwardConfirmDialogAdapter.a {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ y1b.a b;

    @Override // com.ss.android.lark.forwardv3.confirmdialog.ForwardConfirmDialogAdapter.a
    public final void a(SearchBaseInfo r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        int r0 = n.a;
        boolean r1 = this.a;
        y1b.a r2 = this.b;
        if (r2 != null) goto L6;
        return;
    L6:
        if (ExternalTargetAvatarProviderStore.INSTANCE.requiresProvider(r4) == true) goto L13;
        if (r1 == false) goto L11;
        v3c.a.a(r4);
        r2.a();
        return;
    L11:
        return;
    }

    public l(boolean r1, y1b.a r2, FragmentActivity r3) {
        this.a = r1;
        this.b = r2;
    }
}
