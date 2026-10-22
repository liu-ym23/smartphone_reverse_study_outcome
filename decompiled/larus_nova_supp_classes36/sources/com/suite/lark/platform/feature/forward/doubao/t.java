package com.suite.lark.platform.feature.forward.doubao;

import androidx.lifecycle.Observer;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class t<T> implements Observer {
    public final /* synthetic */ DoubaoForwardFragment a;

    public t(DoubaoForwardFragment r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onChanged(Object r2) {
        sib.a r3 = (sib.a) r2;
        if ((r3 instanceof sib.a.b) == false) goto L9;
        IGetDataCallback<List<SearchBaseInfo>> r0 = this.a.j;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("callback");
        r0 = null;
    L7:
        r0.onSuccess(((rib.b) ((sib.a.b) r3).a).a);
        return;
    }
}
