package com.bytedance.android.live.openplatform.impl.base.utils;

import android.graphics.PointF;
import android.view.View;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m {

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

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            int r0 = qo0.a.a;
            qo0.a.b("subscribeFail", String.valueOf(r4.getMessage()), r4);
        }
    }

    public static final JSONObject g(Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$toJSONObject");
        Iterator<Map.Entry<String, String>> r4 = r3.entrySet().iterator();
        JSONObject r0 = new JSONObject();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<String, String> r1 = r4.next();
        r0.put(r1.getKey(), r1.getValue());
        goto L4
    L6:
        return r0;
    }

    public static final Map<String, String> h(JSONObject r4) throws JSONException {
        Intrinsics.checkNotNullParameter(r4, "$this$toMutableStringMap");
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r4.keys();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r2 = r1.next();
        r0.put(r2, r4.get(r2).toString());
        goto L4
    L6:
        return r0;
    }

    public static final boolean a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$equalUri");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(Boolean.valueOf(UriProtector.parse(r1).equals(UriProtector.parse(r2))));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r3) == false) goto L10;
        r3 = null;
    L10:
        Boolean r4 = (Boolean) r3;
        if (r4 != null) goto L17;
        return false;
    L17:
        return r4.booleanValue();
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static void c(View r4, Function0 r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$onFastCheckClick");
        Ref.LongRef r0 = new Ref.LongRef();
        r0.element = 0;
        r4.setOnClickListener(new l(r0, 500, r5));
    }

    public static final void e(View r1, Boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$setVisible");
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L5;
        int r3 = 0;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public static final <T> Disposable f(Observable<T> r1, Function1<? super T, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$subscribeSuc");
        return r1.subscribe(new a(r2), b.a);
    }

    public static final void d(JSONObject r1, String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$putIfAbsent");
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        if (r1.has(r2) == true) goto L11;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L6
        Result.constructor-impl(r1.put(r2, r3));     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    }

    public static void b(SimpleDraweeView r1, String r2, ScalingUtils.ScaleType r3, PointF r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = ScalingUtils.ScaleType.FOCUS_CROP;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = new PointF(0.5f, 0.5f);
    L8:
        Intrinsics.checkNotNullParameter(r1, "$this$loadUrl");
        Intrinsics.checkNotNullParameter(r3, "scaleType");
        Intrinsics.checkNotNullParameter(r4, "focusPoint");
        if (r2 != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        if (r6 == false) goto L17;
        r1.setImageResource(2131109391);
        return;
    L17:
        GenericDraweeHierarchyBuilder r7 = new GenericDraweeHierarchyBuilder(r1.getResources()).setActualImageScaleType(r3).setActualImageFocusPoint(r4);
        r7.setRoundingParams(RoundingParams.fromCornersRadii(0.0f, 0.0f, 0.0f, 0.0f));
        Unit r8 = Unit.INSTANCE;
        r1.setHierarchy(r7.build());
        r1.setImageURI(r2);
        return;
    L11:
        if (r2.length() == 0) goto L14;
        r6 = false;
        goto L15
    }
}
