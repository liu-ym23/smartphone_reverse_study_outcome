package com.ss.android.lark.contact.customized.mygroup.view;

import androidx.lifecycle.Observer;
import com.ss.android.lark.contact.customized.databinding.ContactDbFragmentOfficeMyJoinGroupBinding;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ OfficeMyJoinGroupFragment a;

    public c(OfficeMyJoinGroupFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        Unit r2 = (Unit) r1;
        ContactDbFragmentOfficeMyJoinGroupBinding r3 = this.a.e;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r3 = null;
    L5:
        r3.d.refreshComplete();
    }
}
