package com.bytedance.ies.xelement.input;

import android.graphics.Typeface;
import com.lynx.base.log.LynxLog;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import zm.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f6435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6436b;

    public c(LynxBaseInputView r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "inputView");
        this.f6435a = new WeakReference(r5);
        this.f6436b = r10;
    }

    @Override // zm.f0
    public final void b(Typeface r5, int r10) {
        LynxBaseInputView r11 = (LynxBaseInputView) this.f6435a.get();
        if (r11 == null) goto L17;
        LynxLog.b(2, "LynxBaseInputView", "font-face is loaded successfully");
        int r12 = this.f6436b;
        if (r12 != 0) goto L13;
        LynxEditText r13 = r11.f6402a;
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r13 = null;
    L10:
        r13.setTypeface(Typeface.create(r5, r10));
        return;
    L13:
        if (r12 != 1) goto L16;
        r11.q();
        return;
    L16:
        return;
    }
}
