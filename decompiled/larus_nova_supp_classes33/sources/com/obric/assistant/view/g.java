package com.obric.assistant.view;

import android.view.View;
import android.widget.TextView;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class g implements View.OnClickListener {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ View c;

    public /* synthetic */ g(sba.e r1, View r2) {
        this.a = r1;
        this.b = false;
        this.c = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        Function0 r0 = this.a;
        boolean r1 = this.b;
        View r2 = this.c;
        if (r0 == null) goto L5;
        r0.invoke();
    L5:
        if (r1 == true) goto L7;
        j.a();
        return;
    L7:
        r8.setVisibility(8);
        ((TextView) r2.findViewById(2131381152)).setVisibility(0);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ObricBannerPopupWindow$show$6$1(null), 3, null);
    }
}
