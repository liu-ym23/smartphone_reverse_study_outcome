package com.ss.android.lark.coremdbiz.facade.plugins.markdown;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import com.bytedance.lark.pb.basic.v1.ImageSetV2;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.movable.attatchment.p;
import com.ss.android.lark.utils.UIHelper;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements p {
    public volatile Map<String, ImageSetV2> a;

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public final boolean a() {
        return false;
    }

    public final void b(String r6, LKUIRoundedImageView2 r7, int r8, int r9, String r10) {
        Intrinsics.checkNotNullParameter(r6, "url");
        Intrinsics.checkNotNullParameter(r7, "imageView");
        Intrinsics.checkNotNullParameter(r10, "urlType");
        Context r11 = r7.getContext();
        if (r11 != null) goto L5;
        return;
    L5:
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L22
        String r3 = UriProtector.parse(r6).getHost();     // Catch: Throwable -> L22
        String r12 = StringsKt.substringAfterLast$default(StringsKt.substringBeforeLast$default(r6, "?", null, 2, null), "/", null, 2, null);     // Catch: Throwable -> L22
        boolean r4 = true;
        if (Intrinsics.areEqual(r3, "img") == false) goto L15;
        if (r12.length() <= 0) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L15;
    L20:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L22
    L25:
        if (Result.isFailure-impl(r13) == true) goto L28;
        r1 = r13;
    L28:
        String r14 = (String) r1;
        if (r14 != null) goto L31;
        return;
    L31:
        Drawable r15 = UDIconUtils.getIconDrawable(r11, 2131254898, UDColorUtils.getColor(r11, 2131102420));
        if (Build.VERSION.SDK_INT < 23) goto L34;
        GradientDrawable r16 = new GradientDrawable();
        r16.setShape(0);
        r16.setColor(0);
        r16.setStroke(UIHelper.dp2px(0.5f), UIHelper.getColor(2131103351));
        r7.setForeground(r16);
    L34:
        ImageLoader.with(r11).override(r8, r9).load(new EncryptImage(r14)).error(r15).centerCrop().into(new c("imgKey: ".concat(r14), r7, r15));
        return;
    L11:
        r5 = false;
    L15:
        if (r12.length() == 0) goto L18;
        r4 = false;
    L18:
        if (r4 == false) goto L20;
        r12 = null;
    L22:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    }
}
