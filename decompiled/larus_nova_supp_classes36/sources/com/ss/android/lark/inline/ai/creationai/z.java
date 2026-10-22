package com.ss.android.lark.inline.ai.creationai;

import com.ss.android.lark.inline.ai.api.creationai.MenuItem;
import com.ss.android.lark.inline.ai.creationai.label.LabelAdapter;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class z implements LabelAdapter.b {
    public final /* synthetic */ CreationAIPanelController a;

    public z(CreationAIPanelController r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.inline.ai.creationai.label.LabelAdapter.b
    public final void a(MenuItem r2) {
        Intrinsics.checkNotNullParameter(r2, "menuItem");
        Log.i("CreationAIPanelController", "click label item");
    }

    @Override // com.ss.android.lark.inline.ai.creationai.label.LabelAdapter.b
    public final void b(MenuItem r2) {
        Intrinsics.checkNotNullParameter(r2, "menuItem");
        this.a.b.m(r2);
    }
}
