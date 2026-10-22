package com.bytedance.android.live.broadcastgame.opengame.utils;

import android.graphics.PointF;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.common.utility.Logger;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        public final void accept(T r2) {
            Function1 r0 = this.a;
            if (r0 == null) goto L6;
            Unit r3 = (Unit) r0.invoke(r2);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r1) {
            Logger.e(String.valueOf(((Throwable) r1).getMessage()));
        }
    }

    public static final void c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$toToastOrLog");
        LocalTestManager.a(new Class[]{wy.a.class});
        int r0 = q.a;
        q.g(r3, "");
    }

    public static final <T> Disposable b(Observable<T> r1, Function1<? super T, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$subscribeSuc");
        return r1.subscribe(new a(r2), b.a);
    }

    public static void a(SimpleDraweeView r3, String r4, PointF r5, float r6, float r7, float r8, float r9, int r11) {
        if ((r11 & 2) == 0) goto L5;
        ScalingUtils.ScaleType r0 = ScalingUtils.ScaleType.FOCUS_CROP;
    L7:
        if ((r11 & 4) == 0) goto L10;
        r5 = new PointF(0.5f, 0.5f);
    L10:
        if ((r11 & 8) == 0) goto L13;
        r6 = 0.0f;
    L13:
        if ((r11 & 16) == 0) goto L16;
        r7 = 0.0f;
    L16:
        if ((r11 & 32) == 0) goto L19;
        r8 = 0.0f;
    L19:
        if ((r11 & 64) == 0) goto L21;
        r9 = 0.0f;
    L21:
        Intrinsics.checkNotNullParameter(r3, "$this$loadUrl");
        Intrinsics.checkNotNullParameter(r0, "scaleType");
        Intrinsics.checkNotNullParameter(r5, "focusPoint");
        if (r4 != null) goto L24;
    L27:
        boolean r12 = true;
    L28:
        if (r12 == false) goto L30;
        r3.setImageResource(2131109391);
        return;
    L30:
        GenericDraweeHierarchyBuilder r13 = new GenericDraweeHierarchyBuilder(r3.getResources()).setActualImageScaleType(r0).setActualImageFocusPoint(r5);
        r13.setRoundingParams(RoundingParams.fromCornersRadii(r6, r7, r8, r9));
        Unit r14 = Unit.INSTANCE;
        r3.setHierarchy(r13.build());
        r3.setImageURI(r4);
        return;
    L24:
        if (r4.length() == 0) goto L27;
        r12 = false;
        goto L28
    L5:
        r0 = null;
        goto L7
    }
}
