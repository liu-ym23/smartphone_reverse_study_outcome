package com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package;

import android.view.View;
import com.ss.android.lark.filedetail.dto.FolderManageLaunchParams;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ ExtractPackageFragment a;

    public d(ExtractPackageFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        int r10 = pfb.d.a;
        String r11 = this.a.d.b;
        Intrinsics.checkNotNullParameter("retry", "click");
        Intrinsics.checkNotNullParameter("none", "target");
        if (r11 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == true) goto L12;
        pfb.d.a.b(r11, "im_file_decompress_fail_time_out_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("click", "retry"), TuplesKt.to("target", "none")}));
    L12:
        ExtractPackageFragment.U90(this.a, true, false, false, false, 14);
        ExtractPackageViewModel r12 = this.a.x;
        if (r12 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r12 = null;
    L15:
        ExtractPackageViewModel r0 = r12;
        ExtractPackageFragment r13 = this.a;
        String r1 = r13.y;
        FolderManageLaunchParams r2 = r13.d;
        r0.requestExtractPackage(r1, r2.s, r2.u, r2.t, ((Number) r13.e.a().getFirst()).longValue(), this.a.d.f);
        return;
    L5:
        if (r11.length() == 0) goto L8;
        r6 = false;
        goto L9
    }
}
