package com.bytedance.android.livesdk.interactivity.comment.utils;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.widget.EditText;
import com.bytedance.android.live.core.utils.d2;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.comment.CommonInputParams;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.utils.u3;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j {
    public InputFilter a;
    public int b;
    public final EditText c;
    public final CommonInputParams d;

    public static final class a extends d2 {
        public final /* synthetic */ j a;

        public a(j r1) {
            this.a = r1;
        }

        public final void afterTextChanged(Editable r11) {
            if (r11 == null) goto L5;
            String r0 = r11.toString();
            if (r0 == null) goto L5;
        L6:
            int r1 = this.a.d.e;
            int r2 = TextUtils.getTrimmedLength(r0);
            u3.a r13 = u3.a(r11, r1);
            if (r13 == null) goto L9;
            int r3 = r13.a;
            r2 = r13.b;
            int r14 = r3;
        L10:
            j r4 = this.a;
            r4.b = r2;
            if (r2 <= r1) goto L13;
            EditText r6 = r4.c;
            InputFilter.LengthFilter r8 = new InputFilter.LengthFilter(r0.length());
            r4.a = r8;
            r6.setFilters(new InputFilter[]{r8});
        L16:
            if (r2 <= r1) goto L42;
            f2.c(s1.C(2131917443, new Object[]{Integer.valueOf(this.a.d.e)}), 1);
            int r5 = r0.length();
            if (r14 == 0) goto L20;
            r1 = Math.min(r14, r5);
        L28:
            this.a.c.setText(r0.substring(0, r1));
            EditText r15 = this.a.c;     // Catch: Exception -> L31
            r15.setSelection(r15.getText().length());     // Catch: Exception -> L31
            return;
        L31:
            e = move-exception;
            b0 r7 = b0.o();
            StackTraceElement[] r16 = e.getStackTrace();
            r7.getClass();
            com.bytedance.android.live.core.log.g.m(6, r16);
            return;
        L20:
            Iterator r17 = ((ArrayList) ab2.a.d(r0)).iterator();
        L22:
            if (r17.hasNext() == false) goto L28;
            db2.a r9 = (db2.a) r17.next();
            if (r9.c <= r1) goto L22;
            int r10 = r9.b;
            if (r1 < r10) goto L22;
            r1 = r10;
            goto L28
        L42:
            return;
        L13:
            EditText r18 = r4.c;
            if (r4.a == null) goto L16;
            r18.setFilters(new InputFilter[0]);
            r4.a = null;
            goto L16
        L9:
            r14 = 0;
        L5:
            r0 = BuildConfig.FLAVOR;
            goto L6
        }
    }

    public j(EditText r2, CommonInputParams r3) {
        Intrinsics.checkNotNullParameter(r2, "inputEditText");
        Intrinsics.checkNotNullParameter(r3, "commonInputParams");
        this.c = r2;
        this.d = r3;
        r2.addTextChangedListener(new a(this));
    }
}
