package com.bytedance.android.livesdk.ec.adapter.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ec/adapter/api/Scene;", "", "LIVE", "SHOP", "DETAIL", "ec-adapter-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Scene extends Enum<Scene> {
    public static final Scene DETAIL = null;
    public static final Scene LIVE = null;
    public static final Scene SHOP = null;
    public static final /* synthetic */ Scene[] a = null;

    static {
        Scene r1 = new Scene("LIVE", 0);
        LIVE = r1;
        Scene r2 = new Scene("SHOP", 1);
        SHOP = r2;
        Scene r3 = new Scene("DETAIL", 2);
        DETAIL = r3;
        a = new Scene[]{r1, r2, r3};
    }

    public static Scene valueOf(String r1) {
        return (Scene) a.a(Scene.class, r1);
    }

    public static Scene[] values() {
        return (Scene[]) a.clone();
    }

    public Scene(String r1, int r2) {
        super(r1, r2);
    }
}
