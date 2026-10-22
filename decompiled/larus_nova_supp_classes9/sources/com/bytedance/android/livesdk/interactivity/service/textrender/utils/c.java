package com.bytedance.android.livesdk.interactivity.service.textrender.utils;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.w2;
import com.bytedance.bdlocation.BuildConfig;
import gm2.q;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final tb2.c a(int r4) {
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "placeholder");
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        BitmapFactory.decodeResource(s1.getResources(), r4, r0);
        tb2.c r2 = new tb2.c(vh7.f.c(c5.class));
        r2.setType(PieceType.IMAGE.getPieceType());
        r2.setText(BuildConfig.FLAVOR);
        ITextPieceImage r1 = (ITextPieceImage) vh7.f.c(ITextPieceImage.class);
        r1.setResourceType(ITextPieceImage.ResourceType.Local);
        r1.setLocalResId(r4);
        r1.setWidth(r0.outWidth);
        r1.setHeight(r0.outHeight);
        Unit r5 = Unit.INSTANCE;
        r2.setImageValue(r1);
        return r2;
    }

    @JvmStatic
    public static final tb2.c f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        tb2.c r0 = new tb2.c(vh7.f.c(c5.class));
        r0.setType(PieceType.STRING.getPieceType());
        r0.setText(r2);
        r0.setStringValue(r2);
        return r0;
    }

    @JvmStatic
    public static final tb2.c e(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "content");
        return g(r3, String.format("#%08X", new Object[]{Integer.valueOf(r2)}));
    }

    @JvmStatic
    public static final tb2.c g(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "content");
        Intrinsics.checkNotNullParameter(r3, "contentColor");
        tb2.c r0 = new tb2.c(vh7.f.c(c5.class));
        r0.setType(PieceType.STRING.getPieceType());
        r0.setText(r2);
        r0.setStringValue(r2);
        b5 r4 = (b5) vh7.f.c(b5.class);
        r4.setColor(r3);
        r4.setUseRemoteColor(true);
        Unit r5 = Unit.INSTANCE;
        r0.setFormat(r4);
        return r0;
    }

    @JvmStatic
    public static final tb2.c c(k r3, ITextPieceImage.ScaleType r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r4, "scaleType");
        if (r3.getWidth() != 0) goto L5;
    L10:
        int r0 = w2.a;
        tb2.c r6 = d("我的", r3, s1.E() / 3.0f);
        ITextPieceImage r1 = r6.getImageValue();
        if (r1 == null) goto L13;
        r1.setScaleType(r4);
    L13:
        r6.setImageDefaultRes(r5);
    L14:
        return r6;
    L5:
        if (r3.getHeight() == 0) goto L10;
        r6 = b("我的", r3, (int) g.a(r3.getWidth()), (int) g.a(r3.getHeight()));
        ITextPieceImage r2 = r6.getImageValue();
        if (r2 == null) goto L9;
        r2.setScaleType(r4);
    L9:
        r6.setImageDefaultRes(r5);
        goto L14
    }

    public static tb2.c d(String r2, k r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "placeholder");
        Intrinsics.checkNotNullParameter(r3, "model");
        tb2.c r0 = new tb2.c(vh7.f.c(c5.class));
        r0.setType(PieceType.IMAGE.getPieceType());
        r0.setText(r2);
        ITextPieceImage r5 = (ITextPieceImage) vh7.f.c(ITextPieceImage.class);
        r5.setEnableTextWhenFailed(false);
        r5.setResourceType(ITextPieceImage.ResourceType.NetWork);
        r5.setImageModel(r3);
        r5.setScaleX(r4);
        r5.setScaleY(r4);
        Unit r6 = Unit.INSTANCE;
        r0.setImageValue(r5);
        return r0;
    }

    @JvmStatic
    public static final tb2.c b(String r2, k r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "placeholder");
        Intrinsics.checkNotNullParameter(r3, "model");
        tb2.c r0 = new tb2.c(vh7.f.c(c5.class));
        r0.setType(PieceType.IMAGE.getPieceType());
        r0.setText(r2);
        ITextPieceImage r6 = (ITextPieceImage) vh7.f.c(ITextPieceImage.class);
        r6.setResourceType(ITextPieceImage.ResourceType.NetWork);
        r6.setImageModel(r3);
        r6.setWidth(r4);
        r6.setHeight(r5);
        Unit r7 = Unit.INSTANCE;
        r0.setImageValue(r6);
        return r0;
    }

    @JvmStatic
    public static final tb2.c h(IBaseUser r1, String r2, boolean r3, boolean r4) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        r2 = q.a(r1, r4);
    L6:
        if (r3 == false) goto L8;
        String r5 = "：";
    L9:
        tb2.c r6 = new tb2.c(vh7.f.c(c5.class));
        r6.setType(PieceType.USER.getPieceType());
        r6.setText(Intrinsics.stringPlus(r2, r5));
        i5 r7 = (i5) vh7.f.c(i5.class);
        r7.setUser(r1);
        r7.setWithColon(true);
        Unit r8 = Unit.INSTANCE;
        r6.setUserValue(r7);
        return r6;
    L8:
        r5 = BuildConfig.FLAVOR;
        goto L9
    }
}
