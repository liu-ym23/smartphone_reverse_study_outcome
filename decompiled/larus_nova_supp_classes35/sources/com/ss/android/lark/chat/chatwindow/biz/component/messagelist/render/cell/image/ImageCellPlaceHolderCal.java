package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image;

import android.graphics.drawable.Drawable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ImageCellPlaceHolderCal {
    public final m2b.a a;
    public Drawable b;
    public final Lazy c;

    public ImageCellPlaceHolderCal(m2b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        this.a = r2;
        this.c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ImageCellPlaceHolderCal$mIsImageAsyncLoadEnabled$2.INSTANCE);
    }
}
