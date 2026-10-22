package com.ss.android.lark.contact.impl.group.join;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class MyJoinGroupView_ViewBinding implements Unbinder {
    public MyJoinGroupView a;

    public final void unbind() {
        MyJoinGroupView r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mPtrFrame = null;
        r0.mMyJoinGroupRV = null;
        r0.mEmptyLayout = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public MyJoinGroupView_ViewBinding(MyJoinGroupView r4, View r5) {
        this.a = r4;
        r4.mPtrFrame = (LKUIPtrClassicFrameLayout) Utils.findRequiredViewAsType(r5, 2131380561, "field 'mPtrFrame'", LKUIPtrClassicFrameLayout.class);
        r4.mMyJoinGroupRV = (RecyclerView) Utils.findRequiredViewAsType(r5, 2131380562, "field 'mMyJoinGroupRV'", RecyclerView.class);
        r4.mEmptyLayout = Utils.findRequiredView(r5, 2131371589, "field 'mEmptyLayout'");
    }
}
