package com.ss.android.lark.contact.base.contact_mobile_invite.using;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lark.pb.contact.v2.UserContactStatus;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.contact.base.common_ui.InvBaseFragment;
import com.ss.android.lark.contact.base.entity.mobile.item.BaseItemAdapter;
import com.ss.android.lark.contact.base.utils.InvApmUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.a1;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\u0014\u0010\u001a\u001a\u00020\u00172\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/contact/base/contact_mobile_invite/using/InviteExternalContactUsingFragment;", "Lcom/ss/android/lark/contact/base/common_ui/InvBaseFragment;", "<init>", "()V", "cpFeishuUsers", BuildConfig.FLAVOR, "Lcom/ss/android/lark/contact/base/entity/mobile/ContactsMobileFeishuInfo$CpFeishuUsers;", "baseItemAdapter", "Lcom/ss/android/lark/contact/base/entity/mobile/item/BaseItemAdapter;", "Lcom/ss/android/lark/contact/base/contact_mobile_invite/using/InviteExternalContactUsingItem;", "searchKey", BuildConfig.FLAVOR, "isCreated", BuildConfig.FLAVOR, "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", BuildConfig.FLAVOR, "view", "onDestroy", "update", "Companion", "contact-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InviteExternalContactUsingFragment extends InvBaseFragment {
    public static final /* synthetic */ int h = 0;
    public List<a9b.b.C0005b> d;
    public BaseItemAdapter<com.ss.android.lark.contact.base.contact_mobile_invite.using.a> e;
    public String f;
    public boolean g;

    public static final class a {
    }

    public static final class b implements a1.c {
        public final /* synthetic */ InviteExternalContactUsingFragment a;

        public b(InviteExternalContactUsingFragment r1) {
            this.a = r1;
        }

        public final void a(a1.b r6) {
            Intrinsics.checkNotNullParameter(r6, "localMessage");
            InviteExternalContactUsingFragment r0 = this.a;
            Object r7 = r6.a();
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.String");
            r0.f = (String) r7;
            BaseItemAdapter<com.ss.android.lark.contact.base.contact_mobile_invite.using.a> r8 = this.a.e;
            BaseItemAdapter<com.ss.android.lark.contact.base.contact_mobile_invite.using.a> r1 = null;
            if (r8 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("baseItemAdapter");
            r8 = null;
        L5:
            int r2 = com.ss.android.lark.contact.base.contact_mobile_invite.using.a.i;
            List<a9b.b.C0005b> r3 = this.a.d;
            if (r3 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("cpFeishuUsers");
            r3 = null;
        L8:
            InviteExternalContactUsingFragment r4 = this.a;
            r8.a = com.ss.android.lark.contact.base.contact_mobile_invite.using.a.C0160a.a(r3, r4.f, r4);
            BaseItemAdapter<com.ss.android.lark.contact.base.contact_mobile_invite.using.a> r9 = this.a.e;
            if (r9 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("baseItemAdapter");
        L12:
            r1.notifyDataSetChanged();
            return;
        L11:
            r1 = r9;
            goto L12
        }
    }

    public static final class c implements a1.c {
        public final /* synthetic */ InviteExternalContactUsingFragment a;

        public c(InviteExternalContactUsingFragment r1) {
            this.a = r1;
        }

        public final void a(a1.b r9) {
            Intrinsics.checkNotNullParameter(r9, "localMessage");
            Object r10 = r9.a();
            a9b.b.C0005b r1 = null;
            if ((r10 instanceof UserContactStatus) == false) goto L5;
            UserContactStatus r11 = (UserContactStatus) r10;
        L6:
            if (r11 != null) goto L8;
            return;
        L8:
            int r0 = com.ss.android.lark.contact.base.contact_mobile_invite.using.a.i;
            BaseItemAdapter<com.ss.android.lark.contact.base.contact_mobile_invite.using.a> r2 = this.a.e;
            if (r2 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("baseItemAdapter");
            r2 = null;
        L11:
            List r3 = Collections.unmodifiableList(r2.a);
            Intrinsics.checkNotNullParameter(r3, "items");
            Intrinsics.checkNotNullParameter(r11, "status");
            int r4 = d9b.a.a;
            int r5 = d9b.a.b;
            if (r4 >= 0) goto L14;
        L30:
            Log.i("ContactFeat", "cpIndex: " + r4 + " is invalid.");
            return;
        L14:
            if (r4 >= r3.size()) goto L30;
            b9b.a r6 = (b9b.a) ListProtector.get(r3, r4);
            if ((r6 instanceof com.ss.android.lark.contact.base.contact_mobile_invite.using.a) == false) goto L35;
            if (r5 >= 0) goto L27;
            a9b.b.C0005b r7 = ((com.ss.android.lark.contact.base.contact_mobile_invite.using.a) r6).e;
            if (r7 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("cpFeishuUsers");
        L25:
            if (r1.b.size() > r5) goto L27;
            Log.i("ContactFeat", "cpUserIndex: " + r5 + " is invalid.");
            return;
        L23:
            r1 = r7;
        L27:
            com.ss.android.lark.contact.base.contact_mobile_invite.using.a.b r8 = (com.ss.android.lark.contact.base.contact_mobile_invite.using.a.b) ListProtector.get(Collections.unmodifiableList(((com.ss.android.lark.contact.base.contact_mobile_invite.using.a) r6).h.a), r5);
            r8.getClass();
            Intrinsics.checkNotNullParameter(r11, "status");
            a9b.a r12 = r8.f;
            r12.getClass();
            Intrinsics.checkNotNullParameter(r11, "<set-?>");
            r12.b = r11;
            if (r8.a == false) goto L33;
            r8.d();
            return;
        L33:
            return;
        L35:
            return;
        L5:
            r11 = null;
            goto L6
        }
    }

    static {
    }

    public InviteExternalContactUsingFragment() {
        this.f = BuildConfig.FLAVOR;
    }

    @Override // com.ss.android.lark.contact.base.common_ui.InvBaseFragment
    public final void onDestroy() {
        super.onDestroy();
        boolean r0 = a1.f;
        a1 r1 = a1.a.a;
        r1.c(2131361936);
        r1.c(2131361937);
    }

    public final void update(List<a9b.b.C0005b> r5) {
        Intrinsics.checkNotNullParameter(r5, "cpFeishuUsers");
        if (this.g == true) goto L5;
        return;
    L5:
        this.d = r5;
        BaseItemAdapter<com.ss.android.lark.contact.base.contact_mobile_invite.using.a> r0 = this.e;
        BaseItemAdapter<com.ss.android.lark.contact.base.contact_mobile_invite.using.a> r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("baseItemAdapter");
        r0 = null;
    L8:
        int r3 = com.ss.android.lark.contact.base.contact_mobile_invite.using.a.i;
        r0.a = com.ss.android.lark.contact.base.contact_mobile_invite.using.a.C0160a.a(r5, this.f, this);
        BaseItemAdapter<com.ss.android.lark.contact.base.contact_mobile_invite.using.a> r6 = this.e;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("baseItemAdapter");
    L12:
        r1.notifyDataSetChanged();
        return;
    L11:
        r1 = r6;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        BaseItemAdapter<com.ss.android.lark.contact.base.contact_mobile_invite.using.a> r8 = new BaseItemAdapter();
        this.e = r8;
        int r0 = com.ss.android.lark.contact.base.contact_mobile_invite.using.a.i;
        List<a9b.b.C0005b> r1 = this.d;
        List<a9b.b.C0005b> r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cpFeishuUsers");
        r1 = null;
    L5:
        r8.a = com.ss.android.lark.contact.base.contact_mobile_invite.using.a.C0160a.a(r1, this.f, this);
        RecyclerView r9 = r6.findViewById(2131374864);
        BaseItemAdapter<com.ss.android.lark.contact.base.contact_mobile_invite.using.a> r10 = this.e;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("baseItemAdapter");
        r10 = null;
    L8:
        r9.setAdapter(r10);
        r9.setLayoutManager(new LinearLayoutManager(getContext()));
        boolean r11 = a1.f;
        a1 r12 = a1.a.a;
        r12.a(2131361936, new b(this));
        r12.a(2131361937, new c(this));
        List<a9b.b.C0005b> r13 = this.d;
        if (r13 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("cpFeishuUsers");
        r13 = null;
    L11:
        Iterator<a9b.b.C0005b> r14 = r13.iterator();
        int r3 = 0;
    L13:
        if (r14.hasNext() == false) goto L15;
        r3 = r3 + r14.next().b.size();
        goto L13
    L15:
        Pair[] r15 = new Pair[2];
        List<a9b.b.C0005b> r4 = this.d;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("cpFeishuUsers");
    L19:
        r15[0] = new Pair("availableCpCount", Integer.valueOf(r2.size()));
        r15[1] = new Pair("availableUserCount", Integer.valueOf(r3));
        InvApmUtils.f("contact_opt_contact_list_timing_ms", MapsKt.hashMapOf(r15), 10);
        this.g = true;
        return;
    L18:
        r2 = r4;
        goto L19
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561559, r3, false);
    }
}
