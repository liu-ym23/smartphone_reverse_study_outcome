package com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package;

import android.view.View;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ ExtractPackageFragment a;

    public e(ExtractPackageFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        int r9 = pfb.d.a;
        String r10 = this.a.d.b;
        Intrinsics.checkNotNullParameter("download", "click");
        Intrinsics.checkNotNullParameter("none", "target");
        if (r10 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == true) goto L12;
        pfb.d.a.b(r10, "im_file_decompress_fail_not_support_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("click", "download"), TuplesKt.to("target", "none")}));
    L12:
        this.a.e.f();
        return;
    L5:
        if (r10.length() == 0) goto L8;
        r6 = false;
        goto L9
    }
}
