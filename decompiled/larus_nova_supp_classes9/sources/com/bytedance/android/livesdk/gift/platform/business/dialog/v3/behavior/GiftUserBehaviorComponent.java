package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.behavior;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftUserBehaviorComponent {
    public com.bytedance.android.livesdk.behavior.a a;
    public b b;
    public int c;
    public String d;
    public int e;
    public int f;
    public int g;
    public final Lazy h;
    public final Lazy i;
    public int j;
    public String k;

    public GiftUserBehaviorComponent() {
        this.d = "0";
        this.h = LazyKt.lazy(GiftUserBehaviorComponent$mTouchTargetField$2.INSTANCE);
        this.i = LazyKt.lazy(new GiftUserBehaviorComponent$mTouchViewField$2(this));
        this.j = 48;
        this.k = BuildConfig.FLAVOR;
    }
}
