package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.view.error.OpenPlatformFullScreenErrorView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements TextWatcher {
    public final /* synthetic */ MiniAppChooseSearchFragment a;

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "s");
    }

    public c(MiniAppChooseSearchFragment r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r3) {
        Intrinsics.checkNotNullParameter(r3, "s");
        if (r3.length() != 0) goto L5;
        boolean r4 = true;
    L7:
        if (r4 == false) goto L9;
        ((ImageView) this.a.S90(2131366949)).setVisibility(4);
        return;
    L9:
        ((ImageView) this.a.S90(2131366949)).setVisibility(0);
        return;
    L5:
        r4 = false;
        goto L7
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "s");
        ((OpenPlatformFullScreenErrorView) this.a.S90(2131371779)).R5();
        this.a.hideLoading();
        this.a.S90(2131385565).setVisibility(8);
        this.a.S90(2131385498).setVisibility(0);
        MiniAppChooseSearchViewModel r6 = this.a.f;
        if (r6 == null) goto L5;
        int r7 = r6.getHistoryListSize();
    L7:
        if (r7 < 1) goto L9;
        ((TextView) this.a.S90(2131366935)).setVisibility(0);
        return;
    L9:
        ((TextView) this.a.S90(2131366935)).setVisibility(8);
        return;
    L5:
        r7 = 0;
        goto L7
    }
}
