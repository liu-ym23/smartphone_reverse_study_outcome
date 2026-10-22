package com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.larksuite.component.universe_design.progress.UDProgress;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ ExtractPackageFragment a;

    public f(ExtractPackageFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        float r8 = ((Number) r7).floatValue();
        ExtractPackageFragment.U90(this.a, false, true, false, false, 13);
        int r9 = (int) (r8 * 100);
        UDProgress r0 = this.a.h;
        TextView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("extractProgress");
        r0 = null;
    L5:
        r0.setProgress(r9);
        TextView r2 = this.a.i;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("extractProgressDesc");
    L9:
        StringBuilder r3 = new StringBuilder();
        r3.append(r9);
        r3.append('%');
        r1.setText(r3.toString());
        return;
    L8:
        r1 = r2;
        goto L9
    }
}
