package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ImageContentVO extends f<ImageContent> {
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public MessageIdentity n;
    public final int o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;

    @Override // com.ss.android.lark.chat.base.view.vo.message.f
    public final boolean e() {
        int r0 = this.f;
        if (r0 == 1) goto L8;
        if (r0 == 0) goto L8;
        if (this.g == null) goto L8;
        return true;
    L8:
        return false;
    }

    public ImageContentVO(final ImageContent r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        super(r2);
        this.h = LazyKt.lazy(new ImageContentVO$key$2(r2));
        this.i = LazyKt.lazy(new ImageContentVO$origin$2(r2));
        this.j = LazyKt.lazy(new ImageContentVO$originKey$2(r2));
        this.k = LazyKt.lazy(new ImageContentVO$thumbnail$2(r2));
        this.l = LazyKt.lazy(new ImageContentVO$middle$2(r2));
        this.m = LazyKt.lazy(new ImageContentVO$inlinePreview$2(r2));
        r2.getImageTranslateProperty();
        this.o = r2.getProgress();
        this.p = LazyKt.lazy(new ImageContentVO$isOriginSource$2(r2));
        this.q = LazyKt.lazy(new ImageContentVO$originSize$2(r2));
        this.r = LazyKt.lazy(new ImageContentVO$isFromMe$2(r2));
    }

    @Override // com.ss.android.lark.chat.base.view.vo.message.f, v5b.a
    public final boolean d(v5b.a<?> r4) {
        if (super.d(r4) == true) goto L5;
        return false;
    L5:
        if (r4 != null) goto L7;
        return false;
    L7:
        if ((r4 instanceof ImageContentVO) == false) goto L15;
        ImageContentVO r5 = (ImageContentVO) r4;
        if (y28.a.a(this.n, r5.n) == true) goto L11;
        return false;
    L11:
        if (this.o != r5.o) goto L17;
        return true;
    L17:
        return false;
    L15:
        return false;
    }
}
