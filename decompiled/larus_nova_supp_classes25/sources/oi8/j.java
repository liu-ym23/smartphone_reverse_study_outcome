package oi8;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.bmhome.chat.deepresearch.view.a2;
import com.larus.bmhome.chat.deepresearch.view.b2;
import com.larus.bmhome.chat.deepresearch.view.p1;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    public static final class a extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ Function0<Unit> a;
        public final /* synthetic */ Function1<Throwable, Unit> b;
        public final /* synthetic */ Function3<Integer, Integer, Boolean, Unit> c;
        public final /* synthetic */ Ref.BooleanRef d;

        public final void onFailure(String r1, Throwable r2) {
            Function1<Throwable, Unit> r3 = this.b;
            if (r3 == null) goto L6;
            r3.invoke(r2);
            return;
        }

        public final void onSubmit(String r1, Object r2) {
            super.onSubmit(r1, r2);
            Function0<Unit> r3 = this.a;
            if (r3 == null) goto L6;
            r3.invoke();
            return;
        }

        public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
            ImageInfo r5 = (ImageInfo) r3;
            Intrinsics.checkNotNullParameter(r2, "id");
            if (r5 != null) goto L6;
            return;
        L6:
            if (this.c == null) goto L11;
            int r6 = r5.getWidth();
            int r7 = r5.getHeight();
            this.c.invoke(Integer.valueOf(r6), Integer.valueOf(r7), Boolean.valueOf(this.d.element));
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function0<Unit> r1, Function1<? super Throwable, Unit> r2, Function3<? super Integer, ? super Integer, ? super Boolean, Unit> r3, Ref.BooleanRef r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public j() {
    }

    public static void a(final SimpleDraweeView r12, String r13, final String r14, final Integer r15, final Integer r16, Function3 r17, Function0 r18, Function1 r19, final boolean r20, com.larus.image.loader.g r21) {
        Intrinsics.checkNotNullParameter(r12, "imageView");
        Intrinsics.checkNotNullParameter(r13, "url");
        Intrinsics.checkNotNullParameter(r14, "bizTag");
        final Ref.BooleanRef r8 = new Ref.BooleanRef();
        final a r6 = new a(r18, r19, r17, r8);
        ImageLoaderKt.v(r12, r13, r14, r21, new h(r12, r15, r16, r14, r6, r20, r8));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.larus.platform.service.g.a.ensureNotReachHere(e, "SearchImageUtils loadImage exception , url -> " + r13 + " , bizTag -> " + r14 + " , resizeWidth -> " + r15 + ", reSizeHeight -> " + r16);
    }

    public static /* synthetic */ void b(SimpleDraweeView r13, String r14, String r15, Integer r16, Integer r17, p1 r18, a2 r19, b2 r20, boolean r21, int r22) {
        if ((r22 & 32) == 0) goto L5;
        p1 r8 = null;
    L7:
        if ((r22 & 64) == 0) goto L9;
        a2 r9 = null;
    L11:
        if ((r22 & 128) == 0) goto L13;
        b2 r10 = null;
    L15:
        if ((r22 & 256) == 0) goto L17;
        boolean r11 = false;
    L18:
        a(r13, r14, r15, r16, r17, r8, r9, r10, r11, null);
        return;
    L17:
        r11 = r21;
        goto L18
    L13:
        r10 = r20;
        goto L15
    L9:
        r9 = r19;
        goto L11
    L5:
        r8 = r18;
        goto L7
    }
}
