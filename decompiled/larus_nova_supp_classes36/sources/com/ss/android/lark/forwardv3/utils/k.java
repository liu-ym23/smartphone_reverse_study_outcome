package com.ss.android.lark.forwardv3.utils;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.picker.base.view.avatar.ExternalTargetAvatarProviderStore;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ y1b.a b;
    public final /* synthetic */ SearchBaseInfo c;

    public k(boolean r1, y1b.a r2, FragmentActivity r3, SearchBaseInfo r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        int r5 = n.a;
        boolean r6 = this.a;
        y1b.a r0 = this.b;
        SearchBaseInfo r1 = this.c;
        if (r0 != null) goto L6;
        return;
    L6:
        if (ExternalTargetAvatarProviderStore.INSTANCE.requiresProvider(r1) == true) goto L13;
        if (r6 == false) goto L11;
        v3c.a.a(r1);
        r0.a();
        return;
    L11:
        return;
    }
}
