package com.ss.android.lark.contact.customized.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeEmptyStateView;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeTitleBar;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ContactDbFragmentOfficeMyJoinGroupBinding implements ViewBinding {
    public final LinearLayout a;
    public final ContactOfficeEmptyStateView b;
    public final LinearLayout c;
    public final LKUIPtrClassicFrameLayout d;
    public final CommonRecyclerView e;
    public final ContactOfficeTitleBar f;

    public final View getRoot() {
        return this.a;
    }

    public ContactDbFragmentOfficeMyJoinGroupBinding(LinearLayout r1, ContactOfficeEmptyStateView r2, LinearLayout r3, LKUIPtrClassicFrameLayout r4, CommonRecyclerView r5, ContactOfficeTitleBar r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
