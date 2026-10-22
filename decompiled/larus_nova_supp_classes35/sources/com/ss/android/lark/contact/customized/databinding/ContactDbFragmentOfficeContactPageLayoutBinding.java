package com.ss.android.lark.contact.customized.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeEmptyStateView;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ContactDbFragmentOfficeContactPageLayoutBinding implements ViewBinding {
    public final RelativeLayout a;
    public final FrameLayout b;
    public final LinearLayout c;
    public final LKUIPtrClassicFrameLayout d;
    public final CommonRecyclerView e;
    public final FrameLayout f;
    public final ContactOfficeEmptyStateView g;
    public final FrameLayout h;
    public final TextView i;

    public final View getRoot() {
        return this.a;
    }

    public ContactDbFragmentOfficeContactPageLayoutBinding(RelativeLayout r1, FrameLayout r2, LinearLayout r3, LKUIPtrClassicFrameLayout r4, CommonRecyclerView r5, FrameLayout r6, ContactOfficeEmptyStateView r7, FrameLayout r8, TextView r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
