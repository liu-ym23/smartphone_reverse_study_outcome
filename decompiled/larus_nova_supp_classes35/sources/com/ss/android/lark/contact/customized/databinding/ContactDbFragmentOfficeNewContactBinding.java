package com.ss.android.lark.contact.customized.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeEmptyStateView;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeTitleBar;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ContactDbFragmentOfficeNewContactBinding implements ViewBinding {
    public final LinearLayout a;
    public final LinearLayout b;
    public final LKUIPtrClassicFrameLayout c;
    public final CommonRecyclerView d;
    public final FrameLayout e;
    public final ContactOfficeEmptyStateView f;
    public final ContactOfficeTitleBar g;

    public final View getRoot() {
        return this.a;
    }

    public ContactDbFragmentOfficeNewContactBinding(LinearLayout r1, LinearLayout r2, LKUIPtrClassicFrameLayout r3, CommonRecyclerView r4, FrameLayout r5, ContactOfficeEmptyStateView r6, ContactOfficeTitleBar r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
