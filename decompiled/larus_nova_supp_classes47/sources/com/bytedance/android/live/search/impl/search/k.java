package com.bytedance.android.live.search.impl.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.search.impl.search.model.LiveSearchResultParam;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k implements Runnable {
    public final /* synthetic */ LiveSearchResultFragment a;

    public k(LiveSearchResultFragment r1) {
        this.a = r1;
    }

    public final void a() {
        EditText r0 = this.a.g;
        if (r0 == null) goto L5;
        r0.setCursorVisible(true);
    L5:
        EditText r1 = this.a.g;
        if (r1 == null) goto L8;
        r1.setHint(LiveSearchResultFragment.y);
    L8:
        View r2 = this.a.h;
        boolean r3 = false;
        if (r2 == null) goto L11;
        r2.setVisibility(0);
    L11:
        View r4 = this.a.i;
        if (r4 == null) goto L14;
        r4.setVisibility(8);
    L14:
        EditText r5 = this.a.g;
        if (r5 == null) goto L17;
        r5.requestFocus();
    L17:
        LiveSearchResultFragment r6 = this.a;
        Bundle r7 = r6.getArguments();
        if (r7 == null) goto L20;
        String r8 = r7.getString("default_search_key", null);
    L21:
        if (r8 == null) goto L29;
        if ((!TextUtils.isEmpty(r8)) == true) goto L26;
        r8 = null;
    L26:
        if (r8 == null) goto L29;
        String r9 = a.a;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        a.a = r8;
    L30:
        r3 = true;
    L31:
        if (r3 == false) goto L36;
        EditText r10 = r6.g;
        if (r10 == null) goto L35;
        r10.setText(a.a);
    L35:
        a.b = 0;
        LiveSearchResultParam r12 = new LiveSearchResultParam();
        r12.setKeyword(a.a);
        Unit r13 = Unit.INSTANCE;
        r6.V90(r12, true);
    L37:
        r6.s = null;
        return;
    L36:
        r6.W90();
        i0.c().postDelayed(new s(r6), 50);
    L29:
        if (a.e != 1) goto L31;
    L20:
        r8 = null;
        goto L21
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
