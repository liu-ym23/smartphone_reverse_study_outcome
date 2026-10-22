package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenAccessibilityUtil;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/PSTextMessageViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/PSMessageViewHolder;", "Lg52/b;", "Lg52/d;", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PSTextMessageViewHolder extends PSMessageViewHolder implements g52.b, g52.d {
    public static final /* synthetic */ int j = 0;
    public final g52.a b;
    public final NoMoreSpaceTextView c;
    public final a d;
    public View.OnClickListener e;
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k<s> f;
    public final Function0<s> g;
    public final Function1<s, Unit> h;
    public boolean i;

    public static final class a implements com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l {
        public final /* synthetic */ PSTextMessageViewHolder a;
        public final /* synthetic */ g52.c b;

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l
        public final void a(View r4) {
            Intrinsics.checkNotNullParameter(r4, "view");
            s r0 = (s) this.a.g.invoke();
            if (r0 == null) goto L5;
            r0.l(r4, this.a, this.b);
        L5:
            this.a.Z3(false);
        }

        public a(PSTextMessageViewHolder r1, g52.c r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l
        public final boolean b(View r2, tb2.b r3, ClickableSpan r4) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "action");
            Intrinsics.checkNotNullParameter(r4, "span");
            PSTextMessageViewHolder r5 = this.a;
            int r0 = PSTextMessageViewHolder.j;
            boolean r1 = false;
            r5.Z3(false);
            s r6 = (s) this.a.g.invoke();
            if (r6 == null) goto L5;
            r1 = r6.n(r2, r3);
        L5:
            if (r1 == false) goto L7;
            return r1;
        L7:
            if ((r3 instanceof tb2.e) == false) goto L11;
            int r7 = tb2.f.a;
            return tb2.f.a((tb2.e) r3);
        L11:
            return r1;
        }
    }

    public static final class b implements View.OnLongClickListener {
        public final /* synthetic */ PSTextMessageViewHolder a;

        public b(PSTextMessageViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            s r0 = (s) this.a.g.invoke();
            if (r0 == null) goto L7;
            boolean r4 = r0.m(r3);
            boolean r1 = true;
            if (r4 != true) goto L7;
        L8:
            this.a.Z3(false);
            return r1;
        L7:
            r1 = false;
            goto L8
        }
    }

    @Override // g52.d
    public final void d3() {
        Function0<s> r0 = this.g;
        if ((r0 instanceof s) == true) goto L5;
        r0 = null;
    L5:
        s r1 = (s) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        com.bytedance.live.datacontext.j<l> r2 = m.a(null);
        if (r2 == null) goto L23;
        l r3 = (l) r2.getValue();
        if (r3 == null) goto L24;
        e52.a r4 = r3.getTextConfig();
        if (r4 != null) goto L16;
        return;
    L16:
        if (this.i == false) goto L18;
    L21:
        X3(r4, r1, true);
        return;
    L18:
        if (r1.i == true) goto L21;
        X3(r4, r1, false);
        return;
    L24:
        return;
    }

    public final void Y3(com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k<s> r2) {
        Intrinsics.checkNotNullParameter(r2, "renderTextProcessor");
        this.f = r2;
        View.OnClickListener r3 = r2.c(this.d);
        this.e = r3;
        this.c.setOnClickListener(r3);
        this.c.setMovementMethod(new com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.u());
        this.c.setHighlightColor(0);
    }

    public final void Z3(boolean r1) {
        this.i = r1;
        d3();
    }

    @Override // g52.b
    public final void c(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        e52.a r0 = null;
        com.bytedance.live.datacontext.j<l> r1 = m.a(null);
        if (r1 == null) goto L7;
        l r2 = (l) r1.getValue();
        if (r2 == null) goto L7;
        r0 = r2.getTextConfig();
    L7:
        Object r4 = this.g.invoke();
        if (r0 == null) goto L18;
        if (r4 == null) goto L19;
        s r5 = (s) r4;
        int r6 = r3.getAction();
        if (r6 != 0) goto L13;
        Z3(true);
        return;
    L13:
        if (r6 != 3) goto L21;
        Z3(false);
        return;
    L21:
        return;
    L19:
        return;
    }

    public PSTextMessageViewHolder(View r4, g52.c r5) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r4);
        KeyEvent.Callback r1 = r4.findViewById(2131377403);
        if ((r1 instanceof g52.a) == true) goto L5;
        r1 = null;
    L5:
        this.b = (g52.a) r1;
        NoMoreSpaceTextView r2 = r4.findViewById(2131388367);
        this.c = r2;
        this.g = new PSTextMessageViewHolder$getTagMessageModel$1(this);
        this.h = new PSTextMessageViewHolder$setTagMessageModel$1(this);
        this.d = new a(this, r5);
        r2.setOnLongClickListener(new b(this));
        r2.setAlpha(1.0f);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.t.a(r2);
        ViewGroup r6 = (ViewGroup) r4.findViewById(2131377403);
        if (r6 == null) goto L8;
        r6.setImportantForAccessibility(2);
    L8:
        r2.setFocusable(true);
    }

    public final void W3(s r7, g52.e r8) {
        Intrinsics.checkNotNullParameter(r7, "model");
        this.h.invoke(r7);
        g52.a r0 = this.b;
        if (r0 == null) goto L5;
        r0.setDispatchCallback(this);
    L5:
        com.bytedance.live.datacontext.j<l> r1 = m.a(null);
        if (r1 == null) goto L10;
        l r2 = (l) r1.getValue();
        if (r2 == null) goto L10;
        e52.a r3 = r2.getTextConfig();
    L11:
        boolean r4 = false;
        if (r3 == null) goto L14;
        r7.k().a.b = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.c(r3, r7);
        X3(r3, r7, false);
    L14:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k<s> r5 = this.f;
        if (r5 == null) goto L17;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j r6 = r5.b(r7, new com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.f(false), new w(this));
    L18:
        NoMoreSpaceTextView r9 = this.c;
        if (r6 == null) goto L25;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i r10 = r6.b;
        if (r10 == null) goto L25;
        if (r10.a != true) goto L25;
        r4 = true;
    L25:
        r9.setAlwaysInvalidate(r4);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.t.a r11 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.t.a;
        NoMoreSpaceTextView r13 = this.c;
        if (r6 == null) goto L30;
        CharSequence r14 = r6.a;
        if (r14 == null) goto L30;
    L31:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.t.b(r13, r14);
        NoMoreSpaceTextView r15 = this.c;
        PublicScreenAccessibilityUtil r16 = PublicScreenAccessibilityUtil.a;
        CharSequence r17 = r15.getText();
        if ((r17 instanceof Spanned) == true) goto L34;
        r17 = null;
    L34:
        r16.getClass();
        PublicScreenAccessibilityUtil.a((Spanned) r17, r15, null);
        NoMoreSpaceTextView r18 = this.c;
        if (r8 == null) goto L37;
        int r19 = g52.e.j;
        r8.a(r18, true);
    L37:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k<s> r20 = this.f;
        if (r20 == null) goto L40;
        r20.a(r7);
    L40:
        r7.getClass();
        return;
    L30:
        r14 = BuildConfig.FLAVOR;
        goto L31
    L17:
        r6 = null;
    L10:
        r3 = null;
        goto L11
    }

    public void X3(e52.a r2, s r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "textMessageConfig");
        Intrinsics.checkNotNullParameter(r3, "model");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.e(this.c, com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l.a(r4, null, r2));
    }
}
