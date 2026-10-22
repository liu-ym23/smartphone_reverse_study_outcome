package com.ss.android.lark.filedetail.impl.open;

import android.content.Context;
import com.ss.android.lark.filedetail.FileDetailModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j {
    public final hfb.b a;
    public final hfb.b.InterfaceC0233b b;
    public final com.ss.android.lark.filedetail.impl.detail.menu.d c;
    public final OpenFileInfo d;
    public final Context e;
    public final boolean f;
    public boolean g;

    public j(Context r4, OpenFileInfo r5) {
        com.ss.android.lark.storage.a r0 = FileDetailModule.a;
        hfb.b r1 = FileDetailModule.a.a();
        this.a = r1;
        this.b = r1.getAuditDependency();
        this.g = false;
        this.e = r4;
        this.d = r5;
        this.f = true;
        if (r5.isFromFolderManage == false) goto L5;
        hfb.b.d r2 = com.ss.android.lark.filedetail.impl.detail.menu.a.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "params");
        this.c = new com.ss.android.lark.filedetail.impl.detail.menu.b(r5, r4);
        return;
    L5:
        hfb.b.d r3 = com.ss.android.lark.filedetail.impl.detail.menu.a.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "params");
        this.c = new com.ss.android.lark.filedetail.impl.detail.menu.c(r5, r4);
    }
}
