package com.ss.android.lark.contact.customized.externalcontact.view;

import androidx.lifecycle.Observer;
import kotlin.Function;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final /* synthetic */ class g implements Observer, FunctionAdapter {
    public final /* synthetic */ OfficeExternalContactFragment a;

    public g(OfficeExternalContactFragment r1) {
        this.a = r1;
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof Observer) == true) goto L5;
        return false;
    L5:
        if ((r3 instanceof FunctionAdapter) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
    }

    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(1, this.a, OfficeExternalContactFragment.class, "handleEnterpriseStateChanged", "handleEnterpriseStateChanged(Lcom/ss/android/lark/contact/customized/common/model/StatefulModel;)V", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    public final void onChanged(Object r3) {
        i9b.a r4 = (i9b.a) r3;
        Intrinsics.checkNotNullParameter(r4, "p0");
        OfficeExternalContactFragment r0 = this.a;
        int r1 = OfficeExternalContactFragment.r;
        r0.getClass();
        r0.Y90(r4, new OfficeExternalContactFragment$handleEnterpriseStateChanged$1(r0));
    }
}
