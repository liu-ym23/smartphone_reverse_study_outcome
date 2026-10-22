package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q implements k82.d {
    public CheckBox a;
    public final VSInputSectionType b;
    public k82.a c;
    public k82.c d;
    public final c e;
    public final Context f;

    public static final class a {
    }

    public final class b extends k82.c {
        public final /* synthetic */ q c;

        public b(q r2, View r3, h82.b r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "panelBridge");
            this.c = r2;
            super(r3, r4);
        }
    }

    public static final class c implements j82.d {
        public final /* synthetic */ q a;

        @Override // j82.d
        public final boolean m() {
            CheckBox r0 = this.a.a;
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isChecked();
        }

        public c(q r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // k82.d
    public final void a() {
    }

    @Override // k82.d
    public final void d() {
    }

    @Override // k82.d
    public final void e() {
    }

    @Override // k82.d
    public final VSInputSectionType b() {
        return this.b;
    }

    @Override // k82.d
    public final k82.c c() {
        return this.d;
    }

    public final Context getContext() {
        return this.f;
    }

    public q(Context r1) {
        this.f = r1;
        this.b = VSInputSectionType.PUBLISH;
        this.e = new c(this);
    }

    @Override // k82.d
    public final View g(h82.b r5) {
        Intrinsics.checkNotNullParameter(r5, "panelBridge");
        Activity r0 = r5.getActivity();
        if (r0 != null) goto L5;
        return null;
    L5:
        this.c = r5;
        View r1 = LayoutInflater.from(r0).inflate(2131567717, null);
        b r2 = new b(this, r1, r5);
        q r6 = r2.c;
        r6.a = (CheckBox) r2.a.findViewById(2131383421);
        q r7 = r2.c;
        CheckBox r3 = r7.a;
        if (r3 == null) goto L14;
        k82.a r8 = r7.c;
        if (r8 == null) goto L12;
        t9 r9 = r8.s();
        if (r9 == null) goto L12;
        boolean r10 = r9.q;
    L13:
        r3.setChecked(r10);
        r3.setOnCheckedChangeListener(new r(r2));
    L12:
        r10 = false;
    L14:
        Unit r11 = Unit.INSTANCE;
        this.d = r2;
        return r1;
    }

    @Override // k82.d
    public final void h(VSInputSectionType r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "sectionType");
        Intrinsics.checkNotNullParameter(r3, "view");
        k82.d.a.a(r2, r3);
    }
}
