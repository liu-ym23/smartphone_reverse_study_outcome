package com.suite.lark.platform.component.widget_biz_translate;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ TranslateOptionsAdapter a;
    public final /* synthetic */ int b;
    public final /* synthetic */ TranslateOptionsAdapter.b c;

    public a(TranslateOptionsAdapter r1, int r2, TranslateOptionsAdapter.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        TranslateOptionsAdapter r6 = this.a;
        TranslateOptionsAdapter.b r7 = (TranslateOptionsAdapter.b) CollectionsKt.getOrNull(r6.a, r6.b);
        if (r7 == null) goto L5;
        TranslateOptionsAdapter r1 = this.a;
        Log.d("TranslateOptionsAdapter", "onBindViewHolder: lastSelectedIndex is : " + r1.b);
        r7.a = false;
        r1.notifyItemChanged(r1.b);
    L5:
        ((TranslateOptionsAdapter.b) ListProtector.get(this.a.a, this.b)).a = true;
        this.a.b = this.b;
        Log.d("TranslateOptionsAdapter", "onBindViewHolder: newSelectIndex is : " + this.a.b);
        TranslateOptionsAdapter r8 = this.a;
        r8.notifyItemChanged(r8.b);
        this.a.c.invoke(this.c);
    }
}
