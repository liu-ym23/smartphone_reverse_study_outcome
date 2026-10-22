package com.ss.android.lark.chatwindow.view.preview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.utils.r0;
import com.ss.android.lark.doc.entity.DocResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements c<C0120a, h2b.b> {
    public final Context a;
    public final b b;
    public final View.OnLongClickListener c;

    /* JADX INFO: renamed from: com.ss.android.lark.chatwindow.view.preview.a$a, reason: collision with other inner class name */
    public static final class C0120a extends c.a {
        public View b;

        public C0120a(ViewGroup r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public interface b {
        boolean a();

        String b();

        String c();

        String d();

        String e();

        String f();

        void g();

        String getChatId();

        String getP2pChatterId();

        boolean isCrossTenant();

        boolean isGroup();
    }

    @Override // com.ss.android.lark.chatwindow.view.preview.c
    public final int getPreviewType() {
        return 2;
    }

    public final Context getContext() {
        return this.a;
    }

    public static void c(View r3, View.OnLongClickListener r4) {
        if (r3.hasOnClickListeners() == false) goto L6;
        r3.setOnLongClickListener(r4);
    L6:
        if ((r3 instanceof ViewGroup) == false) goto L10;
        ViewGroup r5 = (ViewGroup) r3;
        int r0 = r5.getChildCount();
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L12;
        c(r5.getChildAt(r1), r4);
        r1 = r1 + 1;
        goto L8
    L12:
        return;
    }

    @Override // com.ss.android.lark.chatwindow.view.preview.c
    public final void a(h2b.a r21, c.a r22) {
        h2b.b r1 = (h2b.b) r21;
        C0120a r2 = (C0120a) r22;
        Object r3 = null;
        if (r1 == null) goto L5;
        DocResult r4 = r1.a;
    L6:
        if (r4 != null) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == false) goto L53;
        if (r2 == null) goto L15;
        ViewGroup r6 = r2.a;
    L17:
        if (r6 == null) goto L19;
        Object r7 = r6.getTag(2131388101);
    L20:
        ibb.c r8 = (ibb.c) r7;
        if (r8 != null) goto L23;
        ChatCoreModule.a().getCcmDependency().b();
        ibb.c r9 = null;
    L24:
        if (r9 != null) goto L27;
        return;
    L27:
        if (r2 == null) goto L31;
        ViewGroup r10 = r2.a;
        if (r10 == null) goto L31;
        r3 = r10.getTag(2131369347);
    L31:
        View r11 = (View) r3;
        if (r11 != null) goto L37;
        if (r2 == null) goto L37;
        ViewGroup r12 = r2.a;
        if (r12 == null) goto L37;
        r11 = r9.b(r12);
        r12.addView(r11);
        r12.setTag(2131388101, r9);
        r12.setTag(2131369347, r11);
    L37:
        if (r2 == null) goto L39;
        r2.b = r11;
    L39:
        if (r2 == null) goto L50;
        View r13 = r2.b;
        if (r13 == null) goto L51;
        if (r1 == null) goto L46;
        DocResult r14 = r1.a;
        if (r14 == null) goto L46;
        String r15 = this.b.e();
        String r16 = this.b.b();
        String r17 = this.b.getP2pChatterId();
        String r18 = this.b.f();
        String r19 = this.b.d();
        String r110 = this.b.getChatId();
        String r111 = this.b.c();
        boolean r112 = this.b.isCrossTenant();
        boolean r113 = this.b.isGroup();
        boolean r114 = this.b.a();
        this.b.g();
        r9.a(r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, false);
    L46:
        r13.setOnLongClickListener(this.c);
        ViewGroup r20 = r2.a;
        if (r20 == null) goto L52;
        c(r20, this.c);
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L23:
        r9 = r8;
        goto L24
    L19:
        r7 = null;
        goto L20
    L15:
        r6 = null;
        goto L17
    L53:
        return;
    L8:
        if (r0.f(r1.a, this.b.a()) == false) goto L10;
        r5 = true;
        goto L11
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chatwindow.view.preview.c
    public final c.a b(h2b.a r2, ViewGroup r3) {
        h2b.b r4 = (h2b.b) r2;
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 == null) goto L5;
        DocResult r5 = r4.a;
    L6:
        if (r5 != null) goto L9;
        return null;
    L9:
        return new C0120a(r3);
    L5:
        r5 = null;
        goto L6
    }

    public a(FragmentActivity r2, m7b.a r3, View.OnLongClickListener r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
