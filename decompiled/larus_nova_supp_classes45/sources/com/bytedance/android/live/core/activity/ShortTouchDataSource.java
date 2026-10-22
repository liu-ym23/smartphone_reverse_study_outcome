package com.bytedance.android.live.core.activity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/core/activity/ShortTouchDataSource;", "", "", "source", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "MESSAGE", "API", "JSB", "livecore-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShortTouchDataSource extends Enum<ShortTouchDataSource> {
    public static final ShortTouchDataSource API = null;
    public static final ShortTouchDataSource JSB = null;
    public static final ShortTouchDataSource MESSAGE = null;
    public static final /* synthetic */ ShortTouchDataSource[] a = null;
    private String source;

    static {
        ShortTouchDataSource r1 = new ShortTouchDataSource("MESSAGE", 0, "message");
        MESSAGE = r1;
        ShortTouchDataSource r2 = new ShortTouchDataSource("API", 1, "api");
        API = r2;
        ShortTouchDataSource r3 = new ShortTouchDataSource("JSB", 2, "jsb");
        JSB = r3;
        a = new ShortTouchDataSource[]{r1, r2, r3};
    }

    public static ShortTouchDataSource valueOf(String r1) {
        return (ShortTouchDataSource) a.a(ShortTouchDataSource.class, r1);
    }

    public static ShortTouchDataSource[] values() {
        return (ShortTouchDataSource[]) a.clone();
    }

    public final String getSource() {
        return this.source;
    }

    public final void setSource(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.source = r2;
    }

    public ShortTouchDataSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.source = r3;
    }
}
