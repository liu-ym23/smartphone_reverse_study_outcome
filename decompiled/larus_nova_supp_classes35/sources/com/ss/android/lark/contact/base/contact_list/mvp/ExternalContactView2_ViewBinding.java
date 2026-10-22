package com.ss.android.lark.contact.base.contact_list.mvp;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ExternalContactView2_ViewBinding implements Unbinder {
    public ExternalContactView2 a;

    public final void unbind() {
        ExternalContactView2 r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mExternalContactLayout = null;
        r0.mTitleBar = null;
        r0.mExternalAddLayout = null;
        r0.mExternalAddTv = null;
        r0.mExternalContactContentLayout = null;
        r0.mPtrFrame = null;
        r0.mExternalContactRV = null;
        r0.mExternalContactEmptyLayout = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public ExternalContactView2_ViewBinding(ExternalContactView2 r4, View r5) {
        this.a = r4;
        r4.mExternalContactLayout = (ViewGroup) Utils.findRequiredViewAsType(r5, 2131372002, "field 'mExternalContactLayout'", ViewGroup.class);
        r4.mTitleBar = (CommonTitleBar) Utils.findRequiredViewAsType(r5, 2131372008, "field 'mTitleBar'", CommonTitleBar.class);
        r4.mExternalAddLayout = Utils.findRequiredView(r5, 2131371997, "field 'mExternalAddLayout'");
        r4.mExternalAddTv = (TextView) Utils.findRequiredViewAsType(r5, 2131371998, "field 'mExternalAddTv'", TextView.class);
        r4.mExternalContactContentLayout = (ViewGroup) Utils.findRequiredViewAsType(r5, 2131372000, "field 'mExternalContactContentLayout'", ViewGroup.class);
        r4.mPtrFrame = (LKUIPtrClassicFrameLayout) Utils.findRequiredViewAsType(r5, 2131372004, "field 'mPtrFrame'", LKUIPtrClassicFrameLayout.class);
        r4.mExternalContactRV = (RecyclerView) Utils.findRequiredViewAsType(r5, 2131372005, "field 'mExternalContactRV'", RecyclerView.class);
        r4.mExternalContactEmptyLayout = Utils.findRequiredView(r5, 2131372001, "field 'mExternalContactEmptyLayout'");
    }
}
