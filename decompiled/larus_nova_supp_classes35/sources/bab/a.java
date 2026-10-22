package bab;

import android.text.Layout;
import android.text.Spanned;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.coremd.base.parse.v;
import com.ss.android.lark.coremd.base.parse.y;
import com.ss.android.lark.coremd.impl.parse.ProxyClickSpanInner$Companion$proxyNodeClickInner$1$proxySpan$1;
import com.ss.android.lark.coremd.impl.parse.e;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.light.layout.f;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements LKUILightTextView.c {
    public final LKUILightTextView a;
    public final b b;

    /* JADX INFO: renamed from: bab.a$a, reason: collision with other inner class name */
    public static final class C0011a {
    }

    public static final class b implements e.a {
        public final /* synthetic */ a a;

        @Override // com.ss.android.lark.coremd.impl.parse.e.a
        public final void b(y r2, CharSequence r3) {
            Intrinsics.checkNotNullParameter(r2, "span");
            Intrinsics.checkNotNullParameter(r3, ChameleonOpenTracker.ParamKey.RESULT);
        }

        public b(a r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.coremd.impl.parse.e.a
        public final void a(Object r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r5, "span");
            if (r6 == false) goto L9;
            f r7 = this.a.a.getLayout();
            if ((r7 instanceof f) == false) goto L7;
            f r8 = r7;
            r8.getClass();
            long r0 = System.currentTimeMillis();
            r8.c = r8.a();
            Log.d("LightDynamicLayout", "prepareStaticLayout, cost " + (System.currentTimeMillis() - r0));
            return;
        L7:
            Log.e("LightTextNodeSpanCoordinator", "LKUILightTextView only support LightDynamicLayout to reflow, method return");
            return;
        L9:
            this.a.a.invalidate();
        }

        @Override // com.ss.android.lark.coremd.impl.parse.e.a
        public final void c(s r8, v r9, ProxyClickSpanInner$Companion$proxyNodeClickInner$1$proxySpan$1.a r10, int r11) {
            Intrinsics.checkNotNullParameter(r8, "node");
            Intrinsics.checkNotNullParameter(r9, "proxyClickSpan");
            Intrinsics.checkNotNullParameter(r10, "proxyClickHandle");
            CharSequence r12 = this.a.a.getContentText();
            if ((r12 instanceof Spanned) == false) goto L5;
            Spanned r13 = (Spanned) r12;
        L6:
            if (r13 != null) goto L8;
            return;
        L8:
            Layout r3 = this.a.a.getLayout();
            if (r3 != null) goto L11;
            return;
        L11:
            int r4 = r13.getSpanStart(r9);
            int r5 = r13.getSpanEnd(r9);
            if (r4 < 0) goto L15;
            if (r4 >= r5) goto L15;
            boolean r14 = true;
        L16:
            if (r14 == false) goto L19;
            r10.a(this.a.a, r3, r4, r5, r11);
            return;
        L19:
            return;
        L15:
            r14 = false;
            goto L16
        L5:
            r13 = null;
            goto L6
        }
    }

    static {
    }

    public a(LKUILightTextView r2) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        this.a = r2;
        this.b = new b(this);
    }

    public final void a(Layout r8, Layout r9) {
        if (Intrinsics.areEqual(r8, r9) == false) goto L5;
        return;
    L5:
        CharSequence r0 = null;
        if (r8 == null) goto L8;
        CharSequence r10 = r8.getText();
    L9:
        int r2 = 0;
        if ((r10 instanceof Spanned) == false) goto L15;
        Spanned r11 = (Spanned) r10;
        Object[] r12 = r11.getSpans(0, r11.length(), e.class);
        int r1 = r12.length;
        int r3 = 0;
    L13:
        if (r3 >= r1) goto L15;
        e r4 = (e) r12[r3];
        b r5 = this.b;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "callback");
        r4.a.remove(r5);
        r3 = r3 + 1;
    L15:
        if (r9 == null) goto L18;
        r0 = r9.getText();
    L18:
        if ((r0 instanceof Spanned) == false) goto L23;
        Spanned r6 = (Spanned) r0;
        Object[] r13 = r6.getSpans(0, r6.length(), e.class);
        int r14 = r13.length;
    L21:
        if (r2 >= r14) goto L26;
        ((e) r13[r2]).b(this.b);
        r2 = r2 + 1;
        goto L21
    L26:
        return;
    L23:
        return;
    L8:
        r10 = null;
        goto L9
    }
}
