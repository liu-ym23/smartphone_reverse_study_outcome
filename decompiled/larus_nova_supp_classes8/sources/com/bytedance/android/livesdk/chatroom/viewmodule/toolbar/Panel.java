package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/Panel;", "", "MORE", "BEAUTY", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Panel extends Enum<Panel> {
    public static final Panel BEAUTY = null;
    public static final Panel MORE = null;
    public static final /* synthetic */ Panel[] a = null;

    static {
        Panel r1 = new Panel("MORE", 0);
        MORE = r1;
        Panel r2 = new Panel("BEAUTY", 1);
        BEAUTY = r2;
        a = new Panel[]{r1, r2};
    }

    public static Panel valueOf(String r1) {
        return (Panel) r27.a.a(Panel.class, r1);
    }

    public static Panel[] values() {
        return (Panel[]) a.clone();
    }

    public Panel(String r1, int r2) {
        super(r1, r2);
    }
}
