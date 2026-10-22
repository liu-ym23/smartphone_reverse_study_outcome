package com.bytedance.android.live.base.model.push;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/base/model/push/LivePushViewStyle;", "", "Normal", "Custom", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LivePushViewStyle extends Enum<LivePushViewStyle> {
    public static final LivePushViewStyle Custom = null;
    public static final LivePushViewStyle Normal = null;
    public static final /* synthetic */ LivePushViewStyle[] a = null;

    static {
        LivePushViewStyle r1 = new LivePushViewStyle("Normal", 0);
        Normal = r1;
        LivePushViewStyle r2 = new LivePushViewStyle("Custom", 1);
        Custom = r2;
        a = new LivePushViewStyle[]{r1, r2};
    }

    public static LivePushViewStyle valueOf(String r1) {
        return (LivePushViewStyle) r27.a.a(LivePushViewStyle.class, r1);
    }

    public static LivePushViewStyle[] values() {
        return (LivePushViewStyle[]) a.clone();
    }

    public LivePushViewStyle(String r1, int r2) {
        super(r1, r2);
    }
}
