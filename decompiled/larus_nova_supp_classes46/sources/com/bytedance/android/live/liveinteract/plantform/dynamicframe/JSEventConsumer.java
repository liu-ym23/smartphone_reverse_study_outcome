package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/JSEventConsumer;", "", "Dual", "RootWidget", "LogicWidget", "FeedRootWidget", "RenderWidget", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum JSEventConsumer extends Enum<JSEventConsumer> {
    public static final JSEventConsumer Dual = null;
    public static final JSEventConsumer FeedRootWidget = null;
    public static final JSEventConsumer LogicWidget = null;
    public static final JSEventConsumer RenderWidget = null;
    public static final JSEventConsumer RootWidget = null;
    public static final /* synthetic */ JSEventConsumer[] a = null;

    static {
        JSEventConsumer r1 = new JSEventConsumer("Dual", 0);
        Dual = r1;
        JSEventConsumer r2 = new JSEventConsumer("RootWidget", 1);
        RootWidget = r2;
        JSEventConsumer r3 = new JSEventConsumer("LogicWidget", 2);
        LogicWidget = r3;
        JSEventConsumer r4 = new JSEventConsumer("FeedRootWidget", 3);
        FeedRootWidget = r4;
        JSEventConsumer r5 = new JSEventConsumer("RenderWidget", 4);
        RenderWidget = r5;
        a = new JSEventConsumer[]{r1, r2, r3, r4, r5};
    }

    public static JSEventConsumer valueOf(String r1) {
        return (JSEventConsumer) r27.a.a(JSEventConsumer.class, r1);
    }

    public static JSEventConsumer[] values() {
        return (JSEventConsumer[]) a.clone();
    }

    public JSEventConsumer(String r1, int r2) {
        super(r1, r2);
    }
}
