package com.ss.android.lark.contact.base.contact_mobile_invite.using;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lark.pb.basic.v1.UserInfo;
import com.bytedance.lark.pb.contact.v2.UserContactStatus;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.contact.base.entity.mobile.ContactMobileBean;
import com.ss.android.lark.contact.base.entity.mobile.item.BaseItemAdapter;
import com.ss.android.lark.contact.base.entity.mobile.item.ItemViewHolder;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.q;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends b9b.a<a> {
    public static final /* synthetic */ int i = 0;
    public final a9b.b.C0005b e;
    public final String f;
    public final BaseFragment g;
    public final BaseItemAdapter<b> h;

    /* JADX INFO: renamed from: com.ss.android.lark.contact.base.contact_mobile_invite.using.a$a, reason: collision with other inner class name */
    public static final class C0160a {
        public static List a(List r4, String r5, BaseFragment r6) {
            Intrinsics.checkNotNullParameter(r4, "cpFeishuUsers");
            Intrinsics.checkNotNullParameter(r5, "filterKey");
            Intrinsics.checkNotNullParameter(r6, "sourceFragment");
            if (TextUtils.isEmpty(r5) == true) goto L5;
            ArrayList r0 = new ArrayList();
            Iterator r7 = r4.iterator();
        L8:
            if (r7.hasNext() == false) goto L25;
            Object r1 = r7.next();
            a9b.b.C0005b r2 = (a9b.b.C0005b) r1;
            r2.getClass();
            if (TextUtils.isEmpty(r5) == false) goto L13;
        L20:
            boolean r3 = true;
        L22:
            if (r3 == false) goto L8;
            r0.add(r1);
            goto L8
        L13:
            if (r2.a.isMatch(r5) == true) goto L20;
            Iterator<a9b.a> r8 = r2.b.iterator();
        L17:
            if (r8.hasNext() == false) goto L21;
            if (a9b.c.a(r8.next(), r5) == false) goto L17;
        L21:
            r3 = false;
            goto L22
        L25:
            return b(r0, r5, r6);
        L5:
            return b(r4, BuildConfig.FLAVOR, r6);
        }

        public static List b(List r3, String r4, BaseFragment r5) {
            if (r3.isEmpty() == true) goto L5;
            List r6 = r3;
            ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
            Iterator r7 = r6.iterator();
        L8:
            if (r7.hasNext() == false) goto L10;
            r0.add(new a((a9b.b.C0005b) r7.next(), r5, r4));
            goto L8
        L10:
            return r0;
        L5:
            return CollectionsKt.listOf(new a());
        }
    }

    public static final class b extends b9b.a<b> {
        public static final /* synthetic */ int h = 0;
        public final int e;
        public final a9b.a f;
        public TextView g;

        /* JADX INFO: renamed from: com.ss.android.lark.contact.base.contact_mobile_invite.using.a$b$a, reason: collision with other inner class name */
        public static final class C0161a {
        }

        /* JADX INFO: renamed from: com.ss.android.lark.contact.base.contact_mobile_invite.using.a$b$b, reason: collision with other inner class name */
        public /* synthetic */ class C0162b {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[UserContactStatus.values().length];
                r0[UserContactStatus.CONTACT_POINT_FRIEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[UserContactStatus.CONTACT_STATUS_REQUEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[UserContactStatus.CONTACT_STATUS_RECEIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public static final class c implements View.OnClickListener {
            public final /* synthetic */ b a;
            public final /* synthetic */ int b;

            public c(b r1, int r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r2) {
                b.c(this.a);
                b r3 = this.a;
                int r0 = this.b;
                d9b.a.a = r3.e;
                d9b.a.b = r0;
            }
        }

        static {
        }

        public final void d() {
            Enum r0 = this.f.b;
            TextView r1 = null;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("contactStatus");
            r0 = null;
        L6:
            int r2 = C0162b.a[r0.ordinal()];
            if (r2 != 1) goto L9;
            TextView r3 = this.g;
            if (r3 != null) goto L48;
            Intrinsics.throwUninitializedPropertyAccessException("actionTv");
            r3 = null;
        L48:
            r3.setBackgroundColor(0);
            TextView r4 = this.g;
            if (r4 != null) goto L51;
            Intrinsics.throwUninitializedPropertyAccessException("actionTv");
            r4 = null;
        L51:
            r4.setTextColor(UIHelper.getColor(2131106620));
            TextView r5 = this.g;
            if (r5 != null) goto L54;
            Intrinsics.throwUninitializedPropertyAccessException("actionTv");
        L55:
            r1.setText(2131892431);
            return;
        L54:
            r1 = r5;
            goto L55
        L9:
            if (r2 != 2) goto L11;
            TextView r6 = this.g;
            if (r6 != null) goto L37;
            Intrinsics.throwUninitializedPropertyAccessException("actionTv");
            r6 = null;
        L37:
            r6.setBackgroundColor(0);
            TextView r7 = this.g;
            if (r7 != null) goto L40;
            Intrinsics.throwUninitializedPropertyAccessException("actionTv");
            r7 = null;
        L40:
            r7.setTextColor(UIHelper.getColor(2131106620));
            TextView r8 = this.g;
            if (r8 != null) goto L43;
            Intrinsics.throwUninitializedPropertyAccessException("actionTv");
        L44:
            r1.setText(2131892134);
            return;
        L43:
            r1 = r8;
            goto L44
        L11:
            if (r2 == 3) goto L23;
            TextView r9 = this.g;
            if (r9 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("actionTv");
            r9 = null;
        L15:
            r9.setBackgroundResource(2131238313);
            TextView r10 = this.g;
            if (r10 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("actionTv");
            r10 = null;
        L18:
            r10.setTextColor(UIHelper.getColor(2131106521));
            TextView r11 = this.g;
            if (r11 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("actionTv");
        L22:
            r1.setText(2131892430);
            return;
        L21:
            r1 = r11;
            goto L22
        L23:
            TextView r12 = this.g;
            if (r12 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("actionTv");
            r12 = null;
        L26:
            r12.setBackgroundResource(2131238313);
            TextView r13 = this.g;
            if (r13 != null) goto L29;
            Intrinsics.throwUninitializedPropertyAccessException("actionTv");
            r13 = null;
        L29:
            r13.setTextColor(UIHelper.getColor(2131106521));
            TextView r14 = this.g;
            if (r14 != null) goto L32;
            Intrinsics.throwUninitializedPropertyAccessException("actionTv");
        L33:
            r1.setText(2131891504);
            return;
        L32:
            r1 = r14;
            goto L33
        }

        public static final void c(b r3) {
            r3.getClass();
            ContactBaseModuleDependency.b.jumpProfilePage(LarkContext.getApplication(), r3.f.a().user_id, 10);
        }

        @Override // b9b.a
        public final void a(ItemViewHolder r11, int r12) {
            Intrinsics.checkNotNullParameter(r11, "holder");
            View r0 = ((RecyclerView.ViewHolder) r11).itemView;
            this.g = (TextView) r11.T3(2131374868);
            ImageView r1 = (ImageView) r11.T3(2131374869);
            TextView r2 = (TextView) r11.T3(2131374872);
            TextView r3 = (TextView) r11.T3(2131374871);
            d();
            UserInfo r4 = this.f.a();
            Context r5 = r0.getContext();
            String r6 = r4.avatar_key;
            String r7 = r4.user_id;
            LoadParams r8 = new LoadParams();
            r8.a = UIHelper.dp2px(48.0f);
            r8.b = UIHelper.dp2px(48.0f);
            ListenerParams.a r9 = new ListenerParams.a();
            r9.d(Scene.Contact);
            r9.c(ListenerParams.FromType.AVATAR);
            r8.l = r9.b();
            ImageModule.a(r5, r1, r6, r7, r8);
            if (TextUtils.isEmpty(r4.alias) == false) goto L5;
            String r10 = r4.user_name;
        L6:
            r2.setText(r10);
            String r13 = r4.tenant_name;
            if (TextUtils.isEmpty(r13) == false) goto L9;
            r13 = BuildConfig.FLAVOR;
        L9:
            r3.setText(r13);
            q.a(((RecyclerView.ViewHolder) r11).itemView);
            ((RecyclerView.ViewHolder) r11).itemView.setOnClickListener(new c(this, r12));
            TextView r14 = this.g;
            if (r14 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("actionTv");
            r14 = null;
        L12:
            r14.setOnClickListener(new com.ss.android.lark.contact.base.contact_mobile_invite.using.b(this, r12, r14));
            View r15 = ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131374870);
            if (Collections.unmodifiableList(this.c.a).indexOf(this) != (this.c.getItemCount() - 1)) goto L15;
            int r16 = 8;
        L16:
            r15.setVisibility(r16);
            return;
        L15:
            r16 = 0;
            goto L16
        L5:
            r10 = r4.alias;
            goto L6
        }

        public b(int r2, a9b.a r3, BaseFragment r4) {
            Intrinsics.checkNotNullParameter(r3, "cpUserInfo");
            Intrinsics.checkNotNullParameter(r4, "sourceFragment");
            super(2131561557);
            this.e = r2;
            this.f = r3;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ String b;
        public final /* synthetic */ TextView c;
        public final /* synthetic */ ContactMobileBean d;

        public c(TextView r1, String r2, TextView r3, ContactMobileBean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            if (((this.a.getPaint().measureText(this.b) + this.a.getPaddingLeft()) + this.a.getPaddingRight()) > this.a.getWidth()) goto L5;
            this.a.setText(this.b);
            this.c.setVisibility(8);
            return;
        L5:
            this.a.setText(UIHelper.getString(2131892429) + this.d.getName());
            this.c.setVisibility(0);
            this.c.setText(this.d.getEmailOrPhone());
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public a() {
        super(2131561554);
        this.h = new BaseItemAdapter();
    }

    @Override // b9b.a
    public final void a(ItemViewHolder r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        if (this.b != (a.class.hashCode() + 2131561554)) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        a9b.b.C0005b r1 = this.e;
        BaseFragment r2 = null;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("cpFeishuUsers");
        r1 = null;
    L11:
        ContactMobileBean r3 = r1.a;
        a9b.b.C0005b r4 = this.e;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("cpFeishuUsers");
        r4 = null;
    L14:
        String r5 = this.f;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("filterKey");
        r5 = null;
    L17:
        r4.getClass();
        if (TextUtils.isEmpty(r5) == false) goto L21;
        List<a9b.a> r6 = r4.b;
    L30:
        TextView r7 = (TextView) r8.T3(2131374867);
        r7.post(new c(r7, UIHelper.getString(2131892429) + r3.getName() + ' ' + r3.getEmailOrPhone(), (TextView) r8.T3(2131374866), r3));
        RecyclerView r10 = r8.T3(2131374865);
        BaseItemAdapter<b> r11 = this.h;
        int r12 = b.h;
        BaseFragment r13 = this.g;
        if (r13 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("sourceFragment");
    L34:
        Intrinsics.checkNotNullParameter(r6, "cpUserInfos");
        Intrinsics.checkNotNullParameter(r2, "sourceFragment");
        List<a9b.a> r14 = r6;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r16 = r14.iterator();
    L36:
        if (r16.hasNext() == false) goto L38;
        r15.add(new b(r9, (a9b.a) r16.next(), r2));
        goto L36
    L38:
        r11.a = r15;
        r10.setAdapter(this.h);
        r10.setLayoutManager(new LinearLayoutManager(r10.getContext()));
        return;
    L33:
        r2 = r13;
        goto L34
    L21:
        if (r4.a.isMatch(r5) == false) goto L23;
        r6 = r4.b;
        goto L30
    L23:
        List<a9b.a> r17 = r4.b;
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r17.iterator();
    L25:
        if (r19.hasNext() == false) goto L29;
        Object r20 = r19.next();
        if (a9b.c.a((a9b.a) r20, r5) == false) goto L25;
        r18.add(r20);
        goto L25
    L29:
        r6 = r18;
        goto L30
    L5:
        r0 = false;
        goto L6
    }

    public a(a9b.b.C0005b r2, BaseFragment r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "cpFeishuUsers");
        Intrinsics.checkNotNullParameter(r3, "sourceFragment");
        Intrinsics.checkNotNullParameter(r4, "filterKey");
        super(2131561558);
        this.h = new BaseItemAdapter();
        this.e = r2;
        this.g = r3;
        this.f = r4;
    }
}
