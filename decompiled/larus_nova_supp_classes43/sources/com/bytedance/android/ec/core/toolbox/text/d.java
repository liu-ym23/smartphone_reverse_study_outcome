package com.bytedance.android.ec.core.toolbox.text;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements c {
    public final SpannableStringBuilder a;

    @Override // com.bytedance.android.ec.core.toolbox.text.c
    public final d e() {
        this.a.append('x');
        return this;
    }

    public final SpannedString f() {
        return new SpannedString(this.a);
    }

    public d(SpannableStringBuilder r10) {
        Intrinsics.checkNotNullParameter(r10, "target");
        this.a = r10;
    }

    @Override // com.bytedance.android.ec.core.toolbox.text.c
    public final d a(Function1 r10) {
        Intrinsics.checkNotNullParameter(r10, "builderAction");
        b(new StyleSpan(2), r10);
        return this;
    }

    @Override // com.bytedance.android.ec.core.toolbox.text.c
    public final d append(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "text");
        this.a.append(r10);
        return this;
    }

    @Override // com.bytedance.android.ec.core.toolbox.text.c
    public final d c(Function1 r10) {
        Intrinsics.checkNotNullParameter(r10, "builderAction");
        b(new StyleSpan(1), r10);
        return this;
    }

    @Override // com.bytedance.android.ec.core.toolbox.text.c
    public final d d(Function1 r10) {
        Intrinsics.checkNotNullParameter(r10, "builderAction");
        b(new a(), r10);
        return this;
    }

    @Override // com.bytedance.android.ec.core.toolbox.text.c
    public final d b(Object r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r10, "span");
        Intrinsics.checkNotNullParameter(r11, "builderAction");
        int r0 = this.a.length();
        r11.invoke(this);
        SpannableStringBuilder r12 = this.a;
        r12.setSpan(r10, r0, r12.length(), 17);
        return this;
    }

    public final d g(int r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r11, "builderAction");
        b(new ForegroundColorSpan(r10), r11);
        return this;
    }

    public final d h(int r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r11, "builderAction");
        b(new AbsoluteSizeSpan(r10, true), r11);
        return this;
    }

    public final d i(int r10, int r11, Function1 r12) {
        Intrinsics.checkNotNullParameter(r12, "builderAction");
        b(new b(r10, r11), r12);
        return this;
    }
}
