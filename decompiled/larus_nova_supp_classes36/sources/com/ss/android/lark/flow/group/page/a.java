package com.ss.android.lark.flow.group.page;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.utils.g;
import com.ss.android.lark.flow.chat.view.sheet.FlowBottomSheet;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends FlowBottomSheet {
    public final b d;
    public c e;
    public C0053a f;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.group.page.a$a, reason: collision with other inner class name */
    public static final class C0053a {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final int e;
        public final String f;
        public final String g;
        public final boolean h;
        public final boolean i;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0053a) == true) goto L8;
            return false;
        L8:
            C0053a r6 = (C0053a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
            int r2 = 1231;
            if (this.h == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.i == true) goto L11;
            r2 = 1237;
        L11:
            return r3 + r2;
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "Data(chatId=" + this.a + ", avatarKey=" + this.b + ", entityId=" + this.c + ", name=" + this.d + ", memberCount=" + this.e + ", inviterId=" + this.f + ", token=" + this.g + ", isExpired=" + this.h + ", isDismiss=" + this.i + ')';
        }

        public C0053a() {
            this("", "", "", "", 0, "", "", false, false);
        }

        public C0053a(String r2, String r3, String r4, String r5, int r6, String r7, String r8, boolean r9, boolean r10) {
            Intrinsics.checkNotNullParameter(r2, "chatId");
            Intrinsics.checkNotNullParameter(r3, "avatarKey");
            Intrinsics.checkNotNullParameter(r4, "entityId");
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r7, "inviterId");
            Intrinsics.checkNotNullParameter(r8, "token");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
        }
    }

    public interface b {
        void a(String r1, String r2, String r3);
    }

    public static final class c {
        public final View a;
        public final ImageView b;
        public final TextView c;
        public final TextView d;
        public final TextView e;
        public final View f;
        public final ImageView g;

        public c(View r2) {
            Intrinsics.checkNotNullParameter(r2, "rootView");
            this.a = r2;
            this.b = (ImageView) r2.findViewById(2131373927);
            this.c = (TextView) r2.findViewById(2131373984);
            this.d = (TextView) r2.findViewById(2131373948);
            this.e = (TextView) r2.findViewById(2131373969);
            this.f = r2.findViewById(2131366983);
            this.g = (ImageView) r2.findViewById(2131374734);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.b(true);
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.b(true);
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ a a;
        public final /* synthetic */ C0053a b;

        public f(a r1, C0053a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            b r5 = this.a.d;
            C0053a r0 = this.b;
            r5.a(r0.a, r0.f, r0.g);
        }
    }

    public final void e() {
        c r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        C0053a r1 = this.f;
        if (r1 != null) goto L8;
        return;
    L8:
        g.e(r0.a.getContext(), r0.b, r1.b, r1.c, UIHelper.dp2px(56.0f), UIHelper.dp2px(56.0f), Scene.Chat);
        r0.f.setOnClickListener(new d(this));
        Context r2 = r0.a.getContext();
        boolean r3 = r1.h;
        if (r3 == false) goto L11;
    L14:
        if (r3 == false) goto L16;
        String r4 = UIUtils.getString(r2, 2131890095);
    L17:
        r0.c.setText(r4);
        r0.d.setVisibility(8);
        r0.e.setText(UIUtils.getString(r2, 2131889965));
        r0.e.setTextColor(UIUtils.getColor(r0.a.getContext(), 2131102040));
        r0.e.setBackgroundResource(2131235421);
        r0.e.setOnClickListener(new e(this));
        ImageView r5 = r0.g;
        Intrinsics.checkNotNull(r2);
        r5.setImageDrawable(new FlowChatQRCodeDismissWarningDrawable(r2));
        r0.g.setVisibility(0);
        return;
    L16:
        r4 = UIUtils.getString(r2, 2131890094);
        goto L17
    L11:
        if (r1.i == true) goto L14;
        r0.c.setText(r1.d);
        r0.d.setVisibility(0);
        r0.d.setText(ICUUtils.icuFormat(UIUtils.getQuantityString(r2, 2131755045, r1.e), "num", Long.valueOf(r1.e)));
        r0.e.setText(UIUtils.getString(r2, 2131890116));
        r0.e.setTextColor(UIUtils.getColor(r0.a.getContext(), 2131102063));
        r0.e.setBackgroundResource(2131235420);
        r0.e.setOnClickListener(new f(this, r1));
        r0.g.setVisibility(8);
    }

    @Override // com.ss.android.lark.flow.chat.view.sheet.FlowBottomSheet
    public final View a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "container");
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131561144, r4, false);
        Intrinsics.checkNotNull(r5);
        this.e = new c(r5);
        e();
        return r5;
    }

    public a(Activity r2, FlowQRCodeGroupCardActivity.AnonymousClass1 r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "listener");
        super(r2);
        this.d = r3;
    }
}
