package com.larus.bmhome;

import android.view.View;
import android.widget.FrameLayout;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class s implements View.OnClickListener {
    public final /* synthetic */ Ref.ObjectRef a;
    public final /* synthetic */ BaseHomeTabFragment b;

    public /* synthetic */ s(Ref.ObjectRef r1, BaseHomeTabFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        Ref.ObjectRef r6 = this.a;
        BaseHomeTabFragment r0 = this.b;
        int r1 = BaseHomeTabFragment.i;
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("container click childCount== ");
        FrameLayout r4 = (FrameLayout) r6.element;
        if (r4 == null) goto L5;
        Integer r7 = Integer.valueOf(r4.getChildCount());
    L6:
        r3.append(r7);
        r2.d("BaseHomeTabFragment", r3.toString());
        FrameLayout r8 = (FrameLayout) r6.element;
        if (r8 != null) goto L9;
    L11:
        boolean r9 = false;
    L12:
        if (r9 == false) goto L15;
        r0.X90();
        return;
    L15:
        return;
    L9:
        if (r8.getChildCount() != 0) goto L11;
        r9 = true;
        goto L12
    L5:
        r7 = null;
        goto L6
    }
}
