package com.ss.android.lark.passport.flow.auth_type;

import com.ss.android.lark.passport.flow.core.widget.CommonTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b extends CommonTitleBar.c {
    public final /* synthetic */ AuthTypeActivity a;

    @Override // com.ss.android.lark.passport.flow.core.widget.CommonTitleBar.b
    public final void b() {
        this.a.onBackPressed();
    }

    public b(AuthTypeActivity r1) {
        this.a = r1;
    }
}
