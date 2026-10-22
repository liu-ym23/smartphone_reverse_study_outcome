package com.ss.android.lark.contact.customized.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeEmptyStateView;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeLoadingView;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeTitleBar;
import com.ss.android.lark.contact.customized.myqrcode.view.OfficeInviteExternalCardView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ContactDbActivityMyQrcodeBinding implements ViewBinding {
    public final LinearLayout a;
    public final ContactOfficeEmptyStateView b;
    public final FrameLayout c;
    public final ContactOfficeLoadingView d;
    public final OfficeInviteExternalCardView e;
    public final FrameLayout f;
    public final LinearLayout g;
    public final ContactOfficeTitleBar h;

    public final View getRoot() {
        return this.a;
    }

    public ContactDbActivityMyQrcodeBinding(LinearLayout r1, ContactOfficeEmptyStateView r2, FrameLayout r3, ContactOfficeLoadingView r4, OfficeInviteExternalCardView r5, FrameLayout r6, LinearLayout r7, ContactOfficeTitleBar r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
