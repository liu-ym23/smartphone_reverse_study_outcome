package com.ss.android.lark.keyboard.edittext2.base;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class BaseFunctionEditor<T> implements com.ss.android.lark.keyboard.edittext2.base.a, b {
    public static final /* synthetic */ int b = 0;
    public b a;

    public static final class a {
    }

    static {
    }

    public BaseFunctionEditor() {
    }

    public void P(Editable r2) {
        Intrinsics.checkNotNullParameter(r2, "targetEditable");
    }

    public void Q(Editable r2) {
        Intrinsics.checkNotNullParameter(r2, "targetEditable");
    }

    public abstract void S(SpannableStringBuilder r1, T r2, int r3);

    public void T(T r1, SpannableStringBuilder r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "text");
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public void d() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final b getTarget() {
        b r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("target");
        return null;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.b
    public final Context context() {
        return getTarget().context();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void A(b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public void G(com.ss.android.lark.keyboard.edittext2.base.a r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
    }

    public void insert(T r3) {
        final SpannableStringBuilder r0 = new SpannableStringBuilder();
        R(r3, r0);
        if (r0.length() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L9;
        Log.i("BaseFunctionEditor", "insert: buffer is empty");
        return;
    L9:
        b r5 = getTarget();
        if ((r5 instanceof FunctionEditText) == false) goto L12;
        FunctionEditText r6 = (FunctionEditText) r5;
    L13:
        if (r6 == null) goto L16;
        r6.c(new AnonymousClass1(this, r0));
        return;
    L16:
        return;
    L12:
        r6 = null;
        goto L13
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.b
    public final <E extends com.ss.android.lark.keyboard.edittext2.base.a> E q(com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a<E> r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        return (E) getTarget().q(r2);
    }

    public final void R(T r4, SpannableStringBuilder r5) {
        Intrinsics.checkNotNullParameter(r5, "buffer");
        int r0 = r5.length();
        Log.d("BaseFunctionEditor", "onInsert: on start");
        S(r5, r4, r0);
        Log.d("BaseFunctionEditor", "onInsert: on end");
        T(r4, r5, r0, r5.length());
    }
}
