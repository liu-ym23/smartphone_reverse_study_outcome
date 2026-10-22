package com.larus.bot.impl.common.util;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {

    public static final class a extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ Function1<Boolean, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Boolean, Unit> r1) {
            this.a = r1;
        }

        public final void onFailure(String r1, Throwable r2) {
            super.onFailure(r1, r2);
            Function1<Boolean, Unit> r3 = this.a;
            if (r3 == null) goto L6;
            r3.invoke(Boolean.FALSE);
            return;
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            super.onFinalImageSet(r1, (ImageInfo) r2, r3);
            Function1<Boolean, Unit> r4 = this.a;
            if (r4 == null) goto L6;
            r4.invoke(Boolean.TRUE);
            return;
        }
    }

    public static final void a(final SimpleDraweeView r10, Uri r11, String r12, final boolean r13, final Integer r14, final Integer r15, final boolean r16, final Function1<? super Boolean, Unit> r17) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ImageLoaderKt.x(r10, r11, r12, null, new g(r13, r16, r10, r17, r15, r14), 4);
    }

    public static /* synthetic */ void b(SimpleDraweeView r8, Uri r9, String r10, boolean r11, Integer r12, Integer r13, Function1 r14, int r15) {
        if ((r15 & 4) == 0) goto L5;
        boolean r3 = false;
    L7:
        if ((r15 & 8) == 0) goto L9;
        Integer r4 = null;
    L11:
        if ((r15 & 16) == 0) goto L13;
        Integer r5 = null;
    L15:
        if ((r15 & 64) == 0) goto L17;
        Function1 r7 = null;
    L18:
        a(r8, r9, r10, r3, r4, r5, false, r7);
        return;
    L17:
        r7 = r14;
        goto L18
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }
}
