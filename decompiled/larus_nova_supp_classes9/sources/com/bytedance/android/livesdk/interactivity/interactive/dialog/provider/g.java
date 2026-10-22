package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.utils.u3;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements TextWatcher {
    public final /* synthetic */ a.b a;
    public final /* synthetic */ k82.a b;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r13) {
        EditText r0 = this.a.e;
        if (r0 == null) goto L5;
        Editable r1 = r0.getText();
    L6:
        this.a.o = String.valueOf(r1);
        if (TextUtils.isEmpty(this.a.o) == false) goto L11;
        this.b.d(false);
        TextView r2 = this.a.n;
        if (r2 == null) goto L14;
        UtilityKotlinExtentionsKt.w(r2);
    L14:
        a.b r3 = this.a;
        EditText r4 = r3.e;
        if (r4 == null) goto L48;
        int r5 = n82.c.a;
        Intrinsics.checkNotNullParameter(r4, "editText");
        Editable r6 = r4.getText();
        if (r6 == null) goto L19;
        CharSequence r7 = r6;
    L20:
        int r8 = TextUtils.getTrimmedLength(r7);
        int r9 = 200;
        u3.a r10 = u3.a(r6, 200);
        if (r10 == null) goto L23;
        int r11 = r10.a;
        r8 = r10.b;
        int r14 = r11;
    L24:
        if (r8 <= 200) goto L26;
        r4.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(r7.length())});
    L27:
        if (r8 <= 200) goto L47;
        f2.c(s1.C(2131917443, new Object[]{200}), 1);
        int r15 = r7.length();
        if (r14 == 0) goto L31;
        r9 = Math.min(r14, r15);
    L41:
        r4.setText(r7.subSequence(0, r9));
        r4.setSelection(r4.getText().length());     // Catch: Exception -> L44
    L46:
        r8 = r9;
    L44:
        e = move-exception;
        b0 r16 = b0.o();
        StackTraceElement[] r17 = e.getStackTrace();
        r16.getClass();
        com.bytedance.android.live.core.log.g.m(6, r17);
        goto L46
    L31:
        Iterator r18 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.g().parseEmojiIndexList(r7).iterator();
    L33:
        if (r18.hasNext() == false) goto L41;
        Object r19 = r18.next();
        if ((r19 instanceof db2.a) == false) goto L33;
        db2.a r20 = (db2.a) r19;
        if (r20.c <= 200) goto L33;
        int r21 = r20.b;
        if (200 < r21) goto L33;
        r9 = r21;
    L47:
        r3.r = r8;
        goto L48
    L26:
        r4.setFilters(new InputFilter[0]);
        goto L27
    L23:
        r14 = 0;
        goto L24
    L19:
        r7 = BuildConfig.FLAVOR;
    L48:
        if (r13 == null) goto L53;
        Iterator<TextWatcher> r23 = this.a.q.iterator();
    L51:
        if (r23.hasNext() == false) goto L53;
        r23.next().afterTextChanged(r13);
    L53:
        a.b r110 = this.a;
        System.currentTimeMillis();
        r110.getClass();
        return;
    L11:
        this.b.d(true);
        TextView r24 = this.a.n;
        if (r24 == null) goto L14;
        UtilityKotlinExtentionsKt.t(r24);
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    public g(a.b r1, h82.b r2) {
        this.a = r1;
        this.b = r2;
    }
}
