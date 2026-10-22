package bab;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.coremd.base.parse.v;
import com.ss.android.lark.coremd.base.parse.y;
import com.ss.android.lark.coremd.impl.parse.ProxyClickSpanInner$Companion$proxyNodeClickInner$1$proxySpan$1;
import com.ss.android.lark.coremd.impl.parse.e;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements TextWatcher {
    public final TextView a;
    public Editable b;
    public final a c;
    public final b d;

    public final class a implements SpanWatcher {
        public final /* synthetic */ c a;

        @Override // android.text.SpanWatcher
        public final void onSpanChanged(Spannable r1, Object r2, int r3, int r4, int r5, int r6) {
        }

        public a(c r1) {
            this.a = r1;
        }

        @Override // android.text.SpanWatcher
        public final void onSpanAdded(Spannable r1, Object r2, int r3, int r4) {
            if ((r2 instanceof e) == false) goto L6;
            ((e) r2).b(this.a.d);
            return;
        }

        @Override // android.text.SpanWatcher
        public final void onSpanRemoved(Spannable r1, Object r2, int r3, int r4) {
            if ((r2 instanceof e) == false) goto L6;
            e r5 = (e) r2;
            b r6 = this.a.d;
            r5.getClass();
            Intrinsics.checkNotNullParameter(r6, "callback");
            r5.a.remove(r6);
            return;
        }
    }

    public static final class b implements e.a {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.coremd.impl.parse.e.a
        public final void a(Object r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r11, "span");
            Editable r13 = this.a.a.getEditableText();
            if (Intrinsics.areEqual(r13, this.a.b) == true) goto L5;
            return;
        L5:
            Intrinsics.checkNotNull(r13);
            Object[] r7 = r13.getSpans(0, r13.length(), SpanWatcher.class);
            int r8 = r7.length;
            int r9 = 0;
        L6:
            if (r9 >= r8) goto L13;
            SpanWatcher r0 = (SpanWatcher) r7[r9];
            int r5 = r13.getSpanStart(r11);
            int r6 = r13.getSpanEnd(r11);
            if (r5 < 0) goto L12;
            if (r6 < 0) goto L12;
            if (r5 >= r6) goto L12;
            r0.onSpanChanged(r13, r11, r5, r6, r5, r6);
        L12:
            r9 = r9 + 1;
            goto L6
        }

        @Override // com.ss.android.lark.coremd.impl.parse.e.a
        public final void b(y r4, CharSequence r5) {
            Intrinsics.checkNotNullParameter(r4, "span");
            Intrinsics.checkNotNullParameter(r5, ChameleonOpenTracker.ParamKey.RESULT);
            Editable r0 = this.a.a.getEditableText();
            int r1 = r0.getSpanStart(r4);
            int r6 = r0.getSpanEnd(r4);
            boolean r2 = false;
            if (r1 < 0) goto L6;
            if (r1 >= r6) goto L6;
            r2 = true;
        L6:
            if (r2 == false) goto L9;
            r0.replace(r1, r6, BuildConfig.FLAVOR);
            r0.insert(r1, r5);
            return;
        }

        @Override // com.ss.android.lark.coremd.impl.parse.e.a
        public final void c(s r7, v r8, ProxyClickSpanInner$Companion$proxyNodeClickInner$1$proxySpan$1.a r9, int r10) {
            Intrinsics.checkNotNullParameter(r7, "node");
            Intrinsics.checkNotNullParameter(r8, "proxyClickSpan");
            Intrinsics.checkNotNullParameter(r9, "proxyClickHandle");
            Editable r11 = this.a.a.getEditableText();
            int r3 = r11.getSpanStart(r8);
            int r4 = r11.getSpanEnd(r8);
            if (r3 < 0) goto L6;
            if (r3 >= r4) goto L6;
            boolean r12 = true;
        L7:
            if (r12 == false) goto L10;
            TextView r1 = this.a.a;
            r9.a(r1, r1.getLayout(), r3, r4, r10);
            return;
        L10:
            return;
        L6:
            r12 = false;
            goto L7
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public c(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        this.a = r2;
        this.c = new a(this);
        this.d = new b(this);
        afterTextChanged(r2.getEditableText());
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r8) {
        Editable r0 = this.b;
        int r1 = 0;
        if (r8 == r0) goto L11;
        if (r0 == null) goto L10;
        e[] r2 = (e[]) r0.getSpans(0, r0.length(), e.class);
        if (r2 == null) goto L10;
        int r3 = r2.length;
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L10;
        e r5 = r2[r4];
        b r6 = this.d;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "callback");
        r5.a.remove(r6);
        r4 = r4 + 1;
    L10:
        this.b = r8;
    L11:
        Editable r9 = this.b;
        if (r9 != null) goto L14;
        return;
    L14:
        if (r9.getSpanStart(this.c) != (-1)) goto L21;
        r9.setSpan(this.c, 0, r9.length(), 18);
        Object[] r10 = r9.getSpans(0, r9.length(), e.class);
        int r7 = r10.length;
    L16:
        if (r1 >= r7) goto L22;
        ((e) r10[r1]).b(this.d);
        r1 = r1 + 1;
        goto L16
    L22:
        return;
    }
}
