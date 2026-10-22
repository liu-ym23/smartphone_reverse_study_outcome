package com.larus.bmhome.chat.list.cell.generate_image;

import com.larus.bmhome.chat.layout.holder.image.ImageHolderDispatcher;
import com.larus.im.bean.message.Message;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q extends xc8.b {
    public final Message e;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ImageHolderDispatcher.GenerateImageType.values().length];
            r0[ImageHolderDispatcher.GenerateImageType.IMAGE4.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    @Override // xc8.b
    public final int d() {
        Lazy r0 = ImageHolderDispatcher.a;
        ImageHolderDispatcher.GenerateImageType r1 = ImageHolderDispatcher.c(this.e);
        if (a.a[r1.ordinal()] != 1) goto L5;
        return 0;
    L5:
        return 3;
    }

    public q(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "generateImageMessage");
        super(r2);
        this.e = r2;
    }
}
