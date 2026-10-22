package com.ss.android.lark.contact.base.contact_mobile_invite.invite;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.contact.base.contact_search.s;
import com.ss.android.lark.contact.base.entity.mobile.ContactMobileBean;
import com.ss.android.lark.contact.base.entity.mobile.item.ItemViewHolder;
import com.ss.android.lark.contact.base.service.c0;
import com.ss.android.lark.contact.base.statistics.InvHitPoint;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends b9b.a<a> {
    public static String k;
    public static String l;
    public final ContactMobileBean e;
    public boolean f;
    public TextView g;
    public ImageView h;
    public TextView i;
    public s j;

    /* JADX INFO: renamed from: com.ss.android.lark.contact.base.contact_mobile_invite.invite.a$a, reason: collision with other inner class name */
    public static final class C0159a {
        public static List a(List r3) {
            Intrinsics.checkNotNullParameter(r3, "beans");
            if (r3.isEmpty() == true) goto L5;
            List r4 = r3;
            ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
            Iterator r5 = r4.iterator();
        L8:
            if (r5.hasNext() == false) goto L10;
            r0.add(new a((ContactMobileBean) r5.next()));
            goto L8
        L10:
            return r0;
        L5:
            return CollectionsKt.listOf(new a());
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ a a;
        public final /* synthetic */ View b;

        public b(a r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            if (this.a.f == false) goto L5;
            return;
        L5:
            Statistics.sendEvent("addressbook_usinglark_invite_click", InvHitPoint.a());
            String r4 = a.k;
            if (r4 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("inviteMsg");
            r4 = null;
        L10:
            if (TextUtils.isEmpty(r4) == false) goto L12;
            a r5 = this.a;
            Context r0 = this.b.getContext();
            r5.getClass();
            int r1 = c0.a;
            c0.a.a(r0, new com.ss.android.lark.contact.base.contact_mobile_invite.invite.b(r5, r0));
            return;
        L12:
            a.c(this.a, this.b.getContext());
        }
    }

    static {
    }

    public final void d() {
        TextView r1 = null;
        if (this.f == false) goto L15;
        TextView r0 = this.g;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("actionTv");
        r0 = null;
    L7:
        r0.setBackgroundColor(0);
        TextView r2 = this.g;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("actionTv");
        r2 = null;
    L10:
        r2.setTextColor(UIHelper.getColor(2131106620));
        TextView r3 = this.g;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("actionTv");
    L14:
        r1.setText(2131892434);
        return;
    L13:
        r1 = r3;
        goto L14
    L15:
        TextView r4 = this.g;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("actionTv");
        r4 = null;
    L18:
        r4.setBackgroundResource(2131238313);
        TextView r5 = this.g;
        if (r5 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("actionTv");
        r5 = null;
    L21:
        r5.setTextColor(UIHelper.getColor(2131106521));
        TextView r6 = this.g;
        if (r6 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("actionTv");
    L25:
        r1.setText(2131892433);
        return;
    L24:
        r1 = r6;
        goto L25
    }

    public a() {
        super(2131561554);
    }

    public a(ContactMobileBean r2) {
        Intrinsics.checkNotNullParameter(r2, "bean");
        super(2131561555);
        this.e = r2;
    }

    @Override // b9b.a
    public final void b(ItemViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        this.a = false;
        if (this.h != null) goto L5;
        return;
    L5:
        if (this.i == null) goto L12;
        ContactMobileBean r4 = this.e;
        if (r4 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("bean");
        r4 = null;
    L9:
        r4.cancelLoadAvatar(this.i, this.h);
        return;
    }

    public static final void c(final a r7, final Context r8) {
        r7.getClass();
        ContactMobileBean r0 = r7.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bean");
        r0 = null;
    L5:
        String r2 = r0.getEmailOrPhoneE164();
        String r1 = k;
        if (r1 == null) goto L8;
        String r3 = r1;
    L9:
        s r6 = new s(r8, r2, r3, new InviteExternalContactInviteItem$showDrawer$1(r8, r7), c.a);
        r6.j();
        r7.j = r6;
        return;
    L8:
        Intrinsics.throwUninitializedPropertyAccessException("inviteMsg");
        r3 = null;
        goto L9
    }

    @Override // b9b.a
    public final void a(ItemViewHolder r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        int r2 = 0;
        if (this.b != (a.class.hashCode() + 2131561554)) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        View r1 = ((RecyclerView.ViewHolder) r7).itemView;
        this.g = (TextView) r7.T3(2131374857);
        this.h = (ImageView) r7.T3(2131374859);
        this.i = (TextView) r7.T3(2131374860);
        TextView r3 = (TextView) r7.T3(2131374863);
        TextView r9 = (TextView) r7.T3(2131374862);
        ViewGroup.LayoutParams r4 = r1.getLayoutParams();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.LayoutParams r5 = (RecyclerView.LayoutParams) r4;
        if (r8 != 0) goto L11;
        r2 = UIHelper.dp2px(8.0f);
    L11:
        ((ViewGroup.MarginLayoutParams) r5).topMargin = r2;
        r1.setLayoutParams(r5);
        ContactMobileBean r10 = this.e;
        ContactMobileBean r6 = null;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("bean");
        r10 = null;
    L14:
        r10.loadAvatar(this.i, this.h);
        ContactMobileBean r11 = this.e;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("bean");
        r11 = null;
    L17:
        r3.setText(r11.getName());
        ContactMobileBean r12 = this.e;
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("bean");
    L21:
        r9.setText(r6.getEmailOrPhone());
        d();
        q.a(r1);
        r1.setOnClickListener(new b(this, r1));
        return;
    L20:
        r6 = r12;
        goto L21
    L5:
        r0 = false;
        goto L6
    }
}
