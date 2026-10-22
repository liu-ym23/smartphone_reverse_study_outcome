package com.bytedance.ies.xelement.input;

import android.text.Editable;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class r implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxTextAreaView f6467a;

    public r(LynxTextAreaView r5) {
        this.f6467a = r5;
    }

    public final boolean a() {
        LynxTextAreaView r10 = this.f6467a;
        LynxEditText r5 = r10.M;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r5 = null;
    L5:
        Editable r11 = r5.getText();
        if (r11 != null) goto L8;
    L10:
        Iterator r12 = r10.R.iterator();
    L11:
        boolean r13 = false;
    L13:
        if (r12.hasNext() == false) goto L22;
        t r14 = (t) r12.next();
        if (r13 == true) goto L21;
        LynxEditText r15 = r10.M;
        if (r15 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r15 = null;
    L19:
        Editable r16 = r15.getText();
        Intrinsics.checkNotNull(r16);
        if (r14.a(r16) == false) goto L11;
    L21:
        r13 = true;
        goto L13
    L22:
        return r13;
    L8:
        if (r11.length() != 0) goto L10;
        return false;
    }
}
