package com.ss.android.lark.contact.base.contact_new.mvp;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class NewContactView_ViewBinding implements Unbinder {
    public NewContactView a;

    public final void unbind() {
        NewContactView r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mTitleBar = null;
        r0.mContentView = null;
        r0.mNewContactRV = null;
        r0.mPtrFrame = null;
        r0.mNewContactEmptyLayout = null;
        r0.newContactAddExtRl = null;
        r0.newContactAddExtTv = null;
        r0.newContactSubTitleTv = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public NewContactView_ViewBinding(NewContactView r4, View r5) {
        this.a = r4;
        r4.mTitleBar = (CommonTitleBar) Utils.findRequiredViewAsType(r5, 2131380716, "field 'mTitleBar'", CommonTitleBar.class);
        r4.mContentView = (ViewGroup) Utils.findRequiredViewAsType(r5, 2131367862, "field 'mContentView'", ViewGroup.class);
        r4.mNewContactRV = (RecyclerView) Utils.findRequiredViewAsType(r5, 2131380713, "field 'mNewContactRV'", RecyclerView.class);
        r4.mPtrFrame = (LKUIPtrClassicFrameLayout) Utils.findRequiredViewAsType(r5, 2131380712, "field 'mPtrFrame'", LKUIPtrClassicFrameLayout.class);
        r4.mNewContactEmptyLayout = Utils.findRequiredView(r5, 2131380710, "field 'mNewContactEmptyLayout'");
        r4.newContactAddExtRl = (RelativeLayout) Utils.findRequiredViewAsType(r5, 2131380682, "field 'newContactAddExtRl'", RelativeLayout.class);
        r4.newContactAddExtTv = (TextView) Utils.findRequiredViewAsType(r5, 2131380683, "field 'newContactAddExtTv'", TextView.class);
        r4.newContactSubTitleTv = (TextView) Utils.findRequiredViewAsType(r5, 2131380684, "field 'newContactSubTitleTv'", TextView.class);
    }
}
