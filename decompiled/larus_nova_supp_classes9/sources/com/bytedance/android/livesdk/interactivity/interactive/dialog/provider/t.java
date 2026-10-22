package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.KeyboardShadowView;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import com.bytedance.android.livesdk.r3;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t implements k82.d {
    public final VSInputSectionType a;
    public k82.c b;

    public final class a extends k82.c {
        public KeyboardShadowView c;

        public a(View r2, h82.b r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "bridges");
            super(r2, r3);
        }
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

    public t() {
        this.a = VSInputSectionType.SHADOW;
    }

    @Override // k82.d
    public final VSInputSectionType b() {
        return this.a;
    }

    @Override // k82.d
    public final k82.c c() {
        return this.b;
    }

    @Override // k82.d
    public final View g(h82.b r5) {
        Intrinsics.checkNotNullParameter(r5, "panelBridge");
        Activity r0 = r5.getActivity();
        if (r0 != null) goto L5;
        return null;
    L5:
        View r1 = LayoutInflater.from(r0).inflate(2131566195, null);
        a r2 = new a(r1, r5);
        KeyboardShadowView r6 = r2.a.findViewById(2131375433);
        r2.c = r6;
        if (r6 == null) goto L8;
        r6.setOnClickListener(new s(r2));
    L8:
        KeyboardShadowView r7 = r2.c;
        if (r7 == null) goto L11;
        r7.enableDispatchTouchEventToActivity(false);
    L11:
        KeyboardShadowView r8 = r2.c;
        if (r8 == null) goto L14;
        r8.setIsAnchor(r2.b.u());
    L14:
        KeyboardShadowView r9 = r2.c;
        if (r9 == null) goto L17;
        r2.b.v();
        r9.setIsPortrait(true);
    L17:
        Activity r10 = r2.b.getActivity();
        if (r10 == null) goto L22;
        KeyboardShadowView r3 = r2.c;
        if (r3 == null) goto L22;
        r3.setActivity(r10);
    L22:
        r3.c(r2.c, s1.B(2131914440), true);
        Unit r11 = Unit.INSTANCE;
        this.b = r2;
        return r1;
    }

    @Override // k82.d
    public final void h(VSInputSectionType r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "sectionType");
        Intrinsics.checkNotNullParameter(r3, "view");
        k82.d.a.a(r2, r3);
    }
}
