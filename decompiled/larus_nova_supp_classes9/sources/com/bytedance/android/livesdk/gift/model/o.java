package com.bytedance.android.livesdk.gift.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o {
    public static final /* synthetic */ KProperty[] a = null;
    public static final vh7.i b = null;
    public static final vh7.i c = null;
    public static final vh7.i d = null;
    public static final vh7.i e = null;
    public static final vh7.i f = null;
    public static final vh7.i g = null;

    static {
        KCallable[] r0 = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(o.class, "localIconBitmap", "getLocalIconBitmap(Lcom/bytedance/android/livesdk/gift/model/DIYGiftCardInfo;)Ljava/lang/String;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(o.class, "giftToolbarFrame", "getGiftToolbarFrame(Lcom/bytedance/android/livesdk/gift/model/DIYGiftCardInfo;)Lcom/bytedance/android/livesdk/gift/model/CaptureAssemblyGiftFrame;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(o.class, "giftCellFrame", "getGiftCellFrame(Lcom/bytedance/android/livesdk/gift/model/DIYGiftCardInfo;)Lcom/bytedance/android/livesdk/gift/model/CaptureAssemblyGiftFrame;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(o.class, "isRecommend", "isRecommend(Lcom/bytedance/android/livesdk/gift/model/DIYGiftCardInfo;)Ljava/lang/Boolean;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(o.class, "isNewCard", "isNewCard(Lcom/bytedance/android/livesdk/gift/model/DIYGiftCardInfo;)Ljava/lang/Boolean;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(o.class, "isLocal", "isLocal(Lcom/bytedance/android/livesdk/gift/model/DIYGiftCardInfo;)Ljava/lang/Boolean;", 1))};
        a = r0;
        int r1 = vh7.a.a;
        b = new vh7.i(new vh7.a.b(r0[0].getName()));
        c = new vh7.i(new vh7.a.b(r0[1].getName()));
        d = new vh7.i(new vh7.a.b(r0[2].getName()));
        e = new vh7.i(new vh7.a.b(r0[3].getName()));
        f = new vh7.i(new vh7.a.b(r0[4].getName()));
        g = new vh7.i(new vh7.a.b(r0[5].getName()));
    }

    public static final j a(n r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$giftCellFrame");
        vh7.i r0 = d;
        KProperty r1 = a[2];
        Object r2 = null;
        if ((r3 instanceof FlexModelBase) == true) goto L5;
        r3 = null;
    L5:
        FlexModelBase r4 = (FlexModelBase) r3;
        if (r4 == null) goto L9;
        r2 = r4.get(r0.a);
    L9:
        return (j) r2;
    }

    public static final j b(n r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$giftToolbarFrame");
        vh7.i r0 = c;
        KProperty r1 = a[1];
        Object r2 = null;
        if ((r3 instanceof FlexModelBase) == true) goto L5;
        r3 = null;
    L5:
        FlexModelBase r4 = (FlexModelBase) r3;
        if (r4 == null) goto L9;
        r2 = r4.get(r0.a);
    L9:
        return (j) r2;
    }

    public static final boolean c(n r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$unLocked");
        if (r1.getLockInfo() == null) goto L10;
        CardLockInfo r2 = r1.getLockInfo();
        if (r2 != null) goto L7;
    L9:
        return false;
    L7:
        if (r2.getLockStatus() != CardLockInfo.Companion.LockStatus.UNLOCKED.getV()) goto L9;
    L10:
        return true;
    }
}
