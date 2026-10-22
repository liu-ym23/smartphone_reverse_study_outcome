package com.ss.android.lark.inline.ai.creationai;

import com.ss.android.lark.inline.ai.api.creationai.MenuItem;
import com.ss.android.lark.inline.ai.creationai.operates.ButtonGroupsAdapter;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class w implements ButtonGroupsAdapter.b {
    public final /* synthetic */ CreationAIPanelController a;

    public w(CreationAIPanelController r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.inline.ai.creationai.operates.ButtonGroupsAdapter.b
    public final void a(MenuItem r3) {
        Intrinsics.checkNotNullParameter(r3, "menuItem");
        Log.i("CreationAIPanelController", "click header left item, menuItem = " + r3);
        this.a.b.m(r3);
    }
}
