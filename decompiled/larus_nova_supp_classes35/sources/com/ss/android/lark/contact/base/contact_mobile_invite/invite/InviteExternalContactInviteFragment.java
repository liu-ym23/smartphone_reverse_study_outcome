package com.ss.android.lark.contact.base.contact_mobile_invite.invite;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.contact.base.common_ui.InvBaseFragment;
import com.ss.android.lark.contact.base.entity.mobile.ContactMobileBean;
import com.ss.android.lark.contact.base.entity.mobile.item.BaseItemAdapter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.a1;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0014\u0010\u0015\u001a\u00020\u00132\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/contact/base/contact_mobile_invite/invite/InviteExternalContactInviteFragment;", "Lcom/ss/android/lark/contact/base/common_ui/InvBaseFragment;", "<init>", "()V", "beans", BuildConfig.FLAVOR, "Lcom/ss/android/lark/contact/base/entity/mobile/ContactMobileBean;", "baseItemAdapter", "Lcom/ss/android/lark/contact/base/entity/mobile/item/BaseItemAdapter;", "Lcom/ss/android/lark/contact/base/contact_mobile_invite/invite/InviteExternalContactInviteItem;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", BuildConfig.FLAVOR, "view", "update", "Companion", "contact-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InviteExternalContactInviteFragment extends InvBaseFragment {
    public static final /* synthetic */ int f = 0;
    public List<? extends ContactMobileBean> d;
    public final BaseItemAdapter<com.ss.android.lark.contact.base.contact_mobile_invite.invite.a> e;

    public static final class a {
    }

    public static final class b implements a1.c {
        public final /* synthetic */ InviteExternalContactInviteFragment a;

        public b(InviteExternalContactInviteFragment r1) {
            this.a = r1;
        }

        public final void a(a1.b r6) {
            Intrinsics.checkNotNullParameter(r6, "localMessage");
            Object r7 = r6.a();
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.String");
            String r8 = (String) r7;
            Log.i("ContactModule_", r8);
            InviteExternalContactInviteFragment r0 = this.a;
            BaseItemAdapter<com.ss.android.lark.contact.base.contact_mobile_invite.invite.a> r1 = r0.e;
            String r2 = com.ss.android.lark.contact.base.contact_mobile_invite.invite.a.k;
            List<? extends ContactMobileBean> r3 = r0.d;
            if (r3 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("beans");
            r3 = null;
        L5:
            Intrinsics.checkNotNullParameter(r3, "beans");
            Intrinsics.checkNotNullParameter(r8, "filterKey");
            if (TextUtils.isEmpty(r8) == false) goto L8;
            List r9 = com.ss.android.lark.contact.base.contact_mobile_invite.invite.a.C0159a.a(r3);
        L15:
            r1.a = r9;
            this.a.e.notifyDataSetChanged();
            return;
        L8:
            ArrayList r4 = new ArrayList();
            Iterator<T> r5 = r3.iterator();
        L10:
            if (r5.hasNext() == false) goto L14;
            Object r10 = r5.next();
            if (((ContactMobileBean) r10).isMatch(r8) == false) goto L10;
            r4.add(r10);
            goto L10
        L14:
            r9 = com.ss.android.lark.contact.base.contact_mobile_invite.invite.a.C0159a.a(r4);
            goto L15
        }
    }

    static {
    }

    public InviteExternalContactInviteFragment() {
        this.e = new BaseItemAdapter();
    }

    public final void update(List<? extends ContactMobileBean> r3) {
        Intrinsics.checkNotNullParameter(r3, "beans");
        this.d = r3;
        BaseItemAdapter<com.ss.android.lark.contact.base.contact_mobile_invite.invite.a> r0 = this.e;
        String r1 = com.ss.android.lark.contact.base.contact_mobile_invite.invite.a.k;
        r0.a = com.ss.android.lark.contact.base.contact_mobile_invite.invite.a.C0159a.a(r3);
        this.e.notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        BaseItemAdapter<com.ss.android.lark.contact.base.contact_mobile_invite.invite.a> r4 = this.e;
        String r0 = com.ss.android.lark.contact.base.contact_mobile_invite.invite.a.k;
        List<? extends ContactMobileBean> r1 = this.d;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("beans");
        r1 = null;
    L5:
        r4.a = com.ss.android.lark.contact.base.contact_mobile_invite.invite.a.C0159a.a(r1);
        RecyclerView r5 = r2.findViewById(2131374856);
        r5.setAdapter(this.e);
        r5.setLayoutManager(new LinearLayoutManager(getContext()));
        boolean r6 = a1.f;
        a1.a.a.a(2131361936, new b(this));
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561556, r3, false);
    }
}
