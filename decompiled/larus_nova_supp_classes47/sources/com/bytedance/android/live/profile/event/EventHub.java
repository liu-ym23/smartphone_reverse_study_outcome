package com.bytedance.android.live.profile.event;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class EventHub {
    public final PropertyOwner<com.bytedance.android.live.profile.event.a> a;
    public final PropertyOwner<com.bytedance.android.live.profile.event.a> b;

    public static final class a {
    }

    static {
    }

    public EventHub() {
        SpreadStateType r2 = SpreadStateType.Close;
        this.a = new PropertyOwner(new com.bytedance.android.live.profile.event.a(r2), EventHub$infoSpreadState$1.INSTANCE);
        this.b = new PropertyOwner(new com.bytedance.android.live.profile.event.a(r2), EventHub$bottomSpreadState$1.INSTANCE);
    }
}
