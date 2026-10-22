package com.ss.android.lark.chat.cot.detail.blueprint.block;

import android.content.Context;
import android.util.Range;
import android.view.View;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.cot.CotBlockStatus;
import com.ss.android.lark.chat.cot.detail.t;
import com.ss.android.lark.chat.entity.message.CotStatus;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CotStatusBlock extends com.ss.android.lark.chat.cot.detail.blueprint.block.a {
    public final boolean c;
    public final com.ss.android.lark.chat.cot.detail.blueprint.b.c d;

    public static final class a {
    }

    public static final class b implements k<View> {
        public final View a;
        public final LottieAnimationView b;
        public final TextView c;

        public final View getView() {
            return this.a;
        }

        public b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
            this.b = r2.findViewById(2131367993);
            this.c = (TextView) r2.findViewById(2131367994);
        }
    }

    public static final class c {
        public final int a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "StatusStyle(colorRes=" + this.a + ", textRes=" + this.b + ')';
        }

        public c(int r2) {
            this.a = 2131106607;
            this.b = r2;
        }
    }

    static {
    }

    public final j getKey() {
        return this.d;
    }

    @Override // com.ss.android.lark.chat.cot.detail.blueprint.block.a
    public final void d(k<?> r2) {
        if ((r2 instanceof b) == false) goto L5;
        b r3 = (b) r2;
    L6:
        if (r3 == null) goto L11;
        LottieAnimationView r4 = r3.b;
        if (r4 == null) goto L12;
        r4.cancelAnimation();
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public CotStatusBlock(g r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.c = r3;
        this.d = com.ss.android.lark.chat.cot.detail.blueprint.b.e;
    }

    public void update(m<com.ss.android.lark.chat.cot.detail.k> r10, q<com.ss.android.lark.chat.cot.detail.k> r11, com.ss.android.lark.chat.cot.detail.k r12) {
        Intrinsics.checkNotNullParameter(r10, "cell");
        Intrinsics.checkNotNullParameter(r11, "layout");
        Intrinsics.checkNotNullParameter(r12, Keys.API_RETURN_KEY_DATA);
        b r13 = (b) r11.c(this.d, this.b, new CotStatusBlock$update$$inlined$acquireBlockView$1());
        boolean r1 = true;
        CotStatus r3 = null;
        int r4 = 8;
        if (r12.e != CotBlockStatus.RUNNING) goto L13;
        r13.c.setVisibility(8);
        LottieAnimationView r0 = r13.b;
        r0.setVisibility(0);
        if (r0.getAnimation() == null) goto L89;
    L12:
        r0.playAnimation();
    L87:
        e(r13.c, r12);
        return;
    L89:
        CloseableKt.closeFinally(r0.getContext().getAssets().open("ai_message_loading.json"), null);     // Catch: Throwable -> L9
    L10:
        if (r1 == false) goto L12;
        Range<Integer> r2 = ChatCoreModule.a().getMyAIDependency().e();
        r0.setMinAndMaxFrame(((Number) r2.getLower()).intValue(), ((Number) r2.getUpper()).intValue());
        r0.setAnimation("ai_message_loading.json");
    L9:
        r1 = false;
        goto L10
    L13:
        r13.b.cancelAnimation();
        r13.b.setVisibility(8);
        CotBlockStatus r14 = r12.e;
        CotBlockStatus r5 = CotBlockStatus.VIOLATED;
        if (r14 != r5) goto L16;
        c r15 = new c(2131890945);
    L52:
        Context r6 = r13.a.getContext();
        TextView r7 = r13.c;
        if (this.c == false) goto L61;
        t r8 = r12.b();
        if (r8 == null) goto L57;
        CotStatus r9 = r8.a;
    L59:
        if (r9 != CotStatus.DONE) goto L61;
        boolean r16 = true;
    L62:
        if (r16 == true) goto L65;
        r4 = 0;
    L65:
        r7.setVisibility(r4);
        t r17 = r12.b();
        if (r17 == null) goto L72;
        String r18 = r17.b;
        if (r18 == null) goto L72;
        if ((!StringsKt.isBlank(r18)) == false) goto L72;
    L73:
        if (r18 != null) goto L75;
    L82:
        r1 = false;
    L83:
        if (r1 == false) goto L85;
        r13.c.setText(r18);
    L86:
        TextView r19 = r13.c;
        Intrinsics.checkNotNull(r6);
        r19.setTextColor(UDColorUtils.getColor(r6, r15.a));
        goto L87
    L85:
        r13.c.setText(r15.b);
        goto L86
    L75:
        if (r12.e == r5) goto L82;
        t r20 = r12.b();
        if (r20 == null) goto L80;
        r3 = r20.a;
    L80:
        if (r3 == CotStatus.TIMEOUT) goto L82;
    L72:
        r18 = null;
        goto L73
    L57:
        r9 = null;
    L61:
        r16 = false;
        goto L62
    L16:
        t r110 = r12.b();
        if (r110 == null) goto L19;
        CotStatus r111 = r110.a;
    L21:
        if (r111 != CotStatus.DONE) goto L23;
        r15 = new c(2131890937);
        goto L52
    L23:
        t r112 = r12.b();
        if (r112 == null) goto L26;
        CotStatus r113 = r112.a;
    L28:
        if (r113 != CotStatus.ERROR) goto L30;
        r15 = new c(2131890938);
        goto L52
    L30:
        t r114 = r12.b();
        if (r114 == null) goto L33;
        CotStatus r115 = r114.a;
    L35:
        if (r115 != CotStatus.TIMEOUT) goto L37;
        r15 = new c(2131890942);
        goto L52
    L37:
        t r116 = r12.b();
        if (r116 == null) goto L40;
        CotStatus r117 = r116.a;
    L42:
        if (r117 != CotStatus.INTERRUPTED) goto L44;
        r15 = new c(2131890939);
        goto L52
    L44:
        t r118 = r12.b();
        if (r118 == null) goto L47;
        CotStatus r119 = r118.a;
    L49:
        if (r119 != CotStatus.PAUSED) goto L51;
        r15 = new c(2131890940);
        goto L52
    L51:
        r15 = new c(2131890937);
        goto L52
    L47:
        r119 = null;
        goto L49
    L40:
        r117 = null;
        goto L42
    L33:
        r115 = null;
        goto L35
    L26:
        r113 = null;
        goto L28
    L19:
        r111 = null;
        goto L21
    }

    @Override // com.ss.android.lark.chat.cot.detail.blueprint.block.a
    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (com.ss.android.lark.chat.cot.detail.k) r3);
    }
}
