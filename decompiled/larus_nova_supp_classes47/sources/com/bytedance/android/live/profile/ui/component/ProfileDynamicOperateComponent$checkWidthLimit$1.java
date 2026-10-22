package com.bytedance.android.live.profile.ui.component;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.ActionConfig;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfileDynamicOperateComponent$checkWidthLimit$1 implements Runnable {
    public final /* synthetic */ ProfileDynamicOperateComponent a;
    public final /* synthetic */ List b;

    /* JADX INFO: renamed from: com.bytedance.android.live.profile.ui.component.ProfileDynamicOperateComponent$checkWidthLimit$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ ProfileDynamicOperateComponent$checkWidthLimit$1 a;

        /* JADX INFO: renamed from: com.bytedance.android.live.profile.ui.component.ProfileDynamicOperateComponent$checkWidthLimit$1$1$a */
        public static final class a implements hm3.a {
            public a() {
            }

            public final void onCancel() {
            }
        }

        public AnonymousClass1(ProfileDynamicOperateComponent$checkWidthLimit$1 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r12) {
            final ArrayList r4 = new ArrayList();
            Iterator r13 = this.a.b.iterator();
            int r1 = 0;
        L4:
            if (r13.hasNext() == false) goto L16;
            Object r2 = r13.next();
            int r3 = r1 + 1;
            if (r1 >= 0) goto L8;
            CollectionsKt.throwIndexOverflow();
        L8:
            ActionConfig r5 = (ActionConfig) r2;
            String r6 = r5.getTextInMore();
            if (r6 == null) goto L15;
            if (r5.actionType == ActionConfig.TYPE_DIGG) goto L13;
            boolean r7 = true;
        L14:
            r4.add(new gm3.a(r1, r6, r7));
            goto L15
        L13:
            r7 = false;
        L15:
            r1 = r3;
            goto L4
        L16:
            Context r8 = this.a.a.a.getContext();
            if (r8 == null) goto L23;
            Intrinsics.checkNotNullParameter(r8, "context");
            String r9 = s1.B(2131920691);
            Intrinsics.checkNotNullParameter(r9, "name");
            Intrinsics.checkNotNullParameter(r4, "items");
            a r10 = new a();
            Intrinsics.checkNotNullParameter(r10, "listener");
            hm3.b r14 = new ProfileDynamicOperateComponent$checkWidthLimit$1$1$$special$$inlined$let$lambda$1(this, r4);
            Intrinsics.checkNotNullParameter(r14, "listener");
            new gm3.b(r14, r10, r9, r4, r8, null).b();
            return;
        }
    }

    public ProfileDynamicOperateComponent$checkWidthLimit$1(ProfileDynamicOperateComponent r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        if (this.b.size() <= 1) goto L41;
        LinearLayout r0 = this.a.l();
        int r1 = 0;
        if (r0 == null) goto L7;
        int r2 = r0.getMeasuredWidth();
    L8:
        LinearLayout r3 = this.a.n();
        if (r3 == null) goto L12;
        r1 = r3.getMeasuredWidth();
    L12:
        if ((r2 + r1) <= (com.bytedance.android.live.profile.j.a() - UtilityKotlinExtentionsKt.i(32))) goto L42;
        this.a.getClass();
        LinearLayout r4 = this.a.n();
        if (r4 == null) goto L16;
        UtilityKotlinExtentionsKt.w(r4);
    L16:
        LinearLayout r5 = (LinearLayout) this.a.k.getValue();
        if (r5 == null) goto L19;
        UtilityKotlinExtentionsKt.t(r5);
    L19:
        LinearLayout r6 = (LinearLayout) this.a.g.getValue();
        if (r6 == null) goto L22;
        r6.setOnClickListener(null);
    L22:
        HSImageView r7 = this.a.q();
        if (r7 == null) goto L25;
        UtilityKotlinExtentionsKt.w(r7);
    L25:
        HSImageView r8 = this.a.q();
        if (r8 == null) goto L28;
        ProfileDynamicOperateComponent r9 = this.a;
        int r10 = UtilityKotlinExtentionsKt.i(54);
        r9.getClass();
        r8.getLayoutParams().width = r10;
        r8.requestLayout();
    L28:
        HSImageView r12 = this.a.q();
        if (r12 == null) goto L31;
        r12.setImageDrawable(s1.m(2131251361));
    L31:
        Space r13 = (Space) this.a.e.getValue();
        if (r13 == null) goto L34;
        UtilityKotlinExtentionsKt.t(r13);
    L34:
        TextView r14 = (TextView) this.a.f.getValue();
        if (r14 == null) goto L37;
        UtilityKotlinExtentionsKt.t(r14);
    L37:
        LinearLayout r15 = this.a.p();
        if (r15 == null) goto L43;
        r15.setOnClickListener(new AnonymousClass1(this));
        return;
    L43:
        return;
    L42:
        return;
    L7:
        r2 = 0;
        goto L8
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
