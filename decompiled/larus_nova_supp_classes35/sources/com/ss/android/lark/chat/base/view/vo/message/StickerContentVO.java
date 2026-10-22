package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class StickerContentVO extends v5b.a<StickerContent> {
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public Message h;

    public final int e() {
        return ((Number) this.d.getValue()).intValue();
    }

    public final String f() {
        return (String) this.b.getValue();
    }

    public final int g() {
        return ((Number) this.c.getValue()).intValue();
    }

    public final boolean h() {
        return ((Boolean) this.e.getValue()).booleanValue();
    }

    public StickerContentVO(final StickerContent r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        super(r2);
        this.b = LazyKt.lazy(new StickerContentVO$key$2(r2));
        this.c = LazyKt.lazy(new StickerContentVO$width$2(r2));
        this.d = LazyKt.lazy(new StickerContentVO$height$2(r2));
        this.e = LazyKt.lazy(new StickerContentVO$isAdded$2(r2));
        this.f = LazyKt.lazy(new StickerContentVO$stickerId$2(r2));
        this.g = LazyKt.lazy(new StickerContentVO$stickerSetId$2(r2));
    }

    @Override // v5b.a
    public final boolean d(v5b.a<?> r4) {
        if (super.d(r4) == true) goto L5;
        return false;
    L5:
        if (r4 != null) goto L7;
        return false;
    L7:
        if ((r4 instanceof StickerContentVO) == false) goto L17;
        StickerContentVO r5 = (StickerContentVO) r4;
        if (g() == r5.g()) goto L11;
        return false;
    L11:
        if (e() == r5.e()) goto L13;
        return false;
    L13:
        if (h() != r5.h()) goto L20;
        return true;
    L20:
        return false;
    L17:
        return false;
    }
}
