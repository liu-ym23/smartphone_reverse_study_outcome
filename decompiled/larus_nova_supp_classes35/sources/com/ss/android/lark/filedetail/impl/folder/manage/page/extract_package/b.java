package com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package;

import androidx.lifecycle.Observer;
import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ ExtractPackageFragment a;

    public b(ExtractPackageFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Pair r4 = (Pair) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        if (((CharSequence) r4.getFirst()).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (r4.getSecond() != null) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(this.a.e.b(), r4.getFirst()) == false) goto L23;
        StringBuilder r1 = new StringBuilder("file key = ");
        r1.append((String) r4.getFirst());
        r1.append(", size = ");
        nfb.c r2 = (nfb.c) r4.getSecond();
        if (r2 == null) goto L18;
        List<nfb.a> r5 = r2.a;
        if (r5 == null) goto L18;
        Integer r6 = Integer.valueOf(r5.size());
    L19:
        r1.append(r6);
        Log.i("ExtractPackageFragment", r1.toString());
        this.a.e.e((String) r4.getFirst(), (nfb.c) r4.getSecond());
        return;
    L18:
        r6 = null;
        goto L19
    L23:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
