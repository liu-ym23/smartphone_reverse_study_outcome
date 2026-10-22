package com.ss.android.lark.filedetail.impl.folder.manage.page.title;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements UDListDialogController.OnItemClickListener {
    public final /* synthetic */ List<Function0<Unit>> a;

    public d(List<? extends Function0<Unit>> r1) {
        this.a = r1;
    }

    public final void onItemClick(int r2) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        if (r2 >= this.a.size()) goto L8;
        ((Function0) ListProtector.get(this.a, r2)).invoke();
        return;
    }
}
