package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.r3;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e0 implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<c, z62.e> {
    public static final a d = null;
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g a;
    public c b;
    public final d c;

    public static final class a implements z62.e {
        public a() {
        }

        @Override // z62.e
        public final void d(boolean r1) {
        }
    }

    public static final class b {
    }

    public final class c extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j {
        public TextView c;
        public Boolean d;
        public final /* synthetic */ e0 e;

        public final void g(boolean r4) {
            if (Intrinsics.areEqual(this.d, Boolean.valueOf(r4)) == false) goto L5;
            return;
        L5:
            if (r4 == false) goto L13;
            TextView r0 = this.c;
            if (r0 == null) goto L9;
            r0.setClickable(true);
        L9:
            TextView r1 = this.c;
            if (r1 == null) goto L12;
            r1.setAlpha(1.0f);
        L12:
            r3.c(this.c, com.bytedance.android.live.core.utils.s1.B(2131914445), true);
        L20:
            this.d = Boolean.valueOf(r4);
            return;
        L13:
            TextView r2 = this.c;
            if (r2 == null) goto L16;
            r2.setClickable(false);
        L16:
            TextView r3 = this.c;
            if (r3 == null) goto L19;
            r3.setAlpha(0.34f);
        L19:
            r3.a(this.c, com.bytedance.android.live.core.utils.s1.B(2131914446));
            goto L20
        }

        public c(e0 r2, View r3, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "panelBridge");
            this.e = r2;
            super(r3, r4);
        }
    }

    public static final class d implements z62.e {
        public final /* synthetic */ e0 a;

        public d(e0 r1) {
            this.a = r1;
        }

        @Override // z62.e
        public final void d(boolean r2) {
            c r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.g(r2);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r1) {
    }

    static {
        d = new a();
    }

    public e0() {
        this.c = new d(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return InputSectionType.SEND_PORTRAIT;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5) {
        Intrinsics.checkNotNullParameter(r5, "panelBridge");
        Activity r0 = r5.getActivity();
        Editable r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        this.a = r5;
        View r2 = LayoutInflater.from(r0).inflate(2131567719, null);
        c r3 = new c(this, r2, r5);
        TextView r6 = (TextView) r3.a.findViewById(2131391397);
        r3.c = r6;
        if (r6 == null) goto L8;
        r6.setOnClickListener(new f0(r3));
    L8:
        r3.a(r3.c, com.bytedance.android.live.core.utils.s1.B(2131914445));
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r7 = r3.e.a;
        if (r7 == null) goto L13;
        EditText r8 = r7.a;
        if (r8 == null) goto L13;
        r1 = r8.getText();
    L13:
        r3.g(!TextUtils.isEmpty(r1));
        Unit r9 = Unit.INSTANCE;
        this.b = r3;
        return r2;
    }
}
