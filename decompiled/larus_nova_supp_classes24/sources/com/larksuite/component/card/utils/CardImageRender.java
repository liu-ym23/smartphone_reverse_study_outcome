package com.larksuite.component.card.utils;

import android.content.Context;
import android.widget.ImageView;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.suite.lark.platform.component.widgetrenderinterceptor.IMBizImageRenderInterceptor;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class CardImageRender {
    public static final /* synthetic */ int a = 0;

    public static final class a implements IMBizImageRenderInterceptor.a {
        public final /* synthetic */ ImageView a;

        public final ImageView a() {
            return this.a;
        }

        public a(ImageView r1) {
            this.a = r1;
        }
    }

    static {
    }

    public static void a(com.suite.lark.platform.component.widgetrenderinterceptor.a r1, final Function0 r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "clickBlock");
        r1.b(new CardImageRender$clickCardImage$1(r2));
        r1.a();
    }

    public static com.suite.lark.platform.component.widgetrenderinterceptor.a b(Context r2, ImageView r3, final ResourceCleanScene r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "imageView");
        a r1 = new a(r3);
        Intrinsics.checkNotNullParameter(r1, "func");
        Function0<kpc.a> r5 = new CardImageRender$createImageRender$2(r4);
        Intrinsics.checkNotNullParameter(r5, "data");
        kpc.a r6 = (kpc.a) r5.invoke();
        Intrinsics.checkNotNullParameter(r2, "context");
        com.suite.lark.platform.component.widgetrenderinterceptor.a r7 = new com.suite.lark.platform.component.widgetrenderinterceptor.a(r2);
        r7.c = r6;
        r7.b = r1;
        return r7;
    }

    public static void c(com.suite.lark.platform.component.widgetrenderinterceptor.a r1, final int r2, final int r3, final Function0 r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r4, "renderBlock");
        r1.c(new CardImageRender$renderCardImage$1(r4, r2, r3));
        r1.d();
    }
}
