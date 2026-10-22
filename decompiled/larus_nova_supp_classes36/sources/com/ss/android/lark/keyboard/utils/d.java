package com.ss.android.lark.keyboard.utils;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public static final class a implements TextView.OnEditorActionListener {
        public final /* synthetic */ Function0<Unit> a;

        public a(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
            if (r2 != 4) goto L6;
            this.a.invoke();
            return true;
        L6:
            return false;
        }
    }

    public static final class b implements View.OnKeyListener {
        public boolean a;
        public final /* synthetic */ Function0<Unit> b;

        public b(Function0<Unit> r1) {
            this.b = r1;
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View r3, int r4, KeyEvent r5) {
            Intrinsics.checkNotNullParameter(r5, "event");
            if ((r3 instanceof EditText) == false) goto L5;
            EditText r6 = (EditText) r3;
        L7:
            if (r6 != null) goto L10;
            return false;
        L10:
            if (r4 == 66) goto L12;
        L35:
            return false;
        L12:
            if (r5.getAction() != 0) goto L32;
            this.a = false;
            if (r5.isShiftPressed() == true) goto L22;
            if (r5.isCtrlPressed() == true) goto L22;
            if (TextUtils.isEmpty(StringsKt.trim(r6.getText())) == true) goto L22;
            this.b.invoke();
            this.a = true;
            return true;
        L22:
            if (TextUtils.isEmpty(StringsKt.trim(r6.getText())) == false) goto L26;
            this.a = true;
            return true;
        L26:
            if (r5.isCtrlPressed() == false) goto L28;
        L29:
            r6.append("\n");
            this.a = true;
            return true;
        L28:
            if (r5.isShiftPressed() == false) goto L35;
        L32:
            if (r5.getAction() != 1) goto L35;
            return this.a;
        L5:
            r6 = null;
            goto L7
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(KeyboardFunctionEditText r5, Function0 r6) {
        Intrinsics.checkNotNullParameter(r5, "editText");
        Intrinsics.checkNotNullParameter(r6, "sendAction");
        Object r1 = r5.getTag(2131376760);
        if ((r1 instanceof View.OnKeyListener) == false) goto L5;
        View.OnKeyListener r2 = (View.OnKeyListener) r1;
    L7:
        if (r2 == null) goto L9;
        Intrinsics.checkNotNullParameter(r2, "onKeyListener");
        r5.i.remove(r2);
        r5.setOnEditorActionListener(null);
        r5.setTag(2131376760, null);
    L9:
        r5.setImeOptions(4);
        r5.setInputType(16385);
        r5.setTransformationMethod(null);
        r5.setMaxLines(Integer.MAX_VALUE);
        r5.setHorizontallyScrolling(false);
        r5.setOnEditorActionListener(new a(r6));
        b r3 = new b(r6);
        Intrinsics.checkNotNullParameter(r3, "onKeyListener");
        ListProtector.add(r5.i, 0, r3);
        r5.setTag(2131376760, r3);
        return;
    L5:
        r2 = null;
        goto L7
    }
}
