package com.bytedance.android.live.openplatform.impl.base.utils.text;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements b {
    public final SpannableStringBuilder a;

    public c(SpannableStringBuilder r2) {
        Intrinsics.checkNotNullParameter(r2, "target");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.utils.text.b
    public final c a(Function1 r3) {
        Intrinsics.checkNotNullParameter(r3, "builderAction");
        b(new StyleSpan(2), r3);
        return this;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.utils.text.b
    public final c append(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.a.append(r2);
        return this;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.utils.text.b
    public final c c(Function1 r3) {
        Intrinsics.checkNotNullParameter(r3, "builderAction");
        b(new StyleSpan(1), r3);
        return this;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.utils.text.b
    public final c b(Object r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r4, "span");
        Intrinsics.checkNotNullParameter(r5, "builderAction");
        int r0 = this.a.length();
        r5.invoke(this);
        SpannableStringBuilder r6 = this.a;
        r6.setSpan(r4, r0, r6.length(), 17);
        return this;
    }

    public final c d(int r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r4, "builderAction");
        b(new AbsoluteSizeSpan(r3, true), r4);
        return this;
    }

    public final c e(int r2, int r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r4, "builderAction");
        b(new a(r2, r3), r4);
        return this;
    }
}
