package com.bytedance.android.livesdk.interactivity.api.degrade.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeFeature;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "TAP_LIKE", "FLOW_LIKE", "LIKE", "HOT_COMMENT_TRAY", "ENTER_ANIM", "COMMENT_CARNIVAL", "PUBLIC_SCREEN", "PORARAIT_DANMAKU", "ENTER_ROOM_DURATION", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DegradeFeature extends Enum<DegradeFeature> {
    public static final DegradeFeature COMMENT_CARNIVAL = null;
    public static final DegradeFeature ENTER_ANIM = null;
    public static final DegradeFeature ENTER_ROOM_DURATION = null;
    public static final DegradeFeature FLOW_LIKE = null;
    public static final DegradeFeature HOT_COMMENT_TRAY = null;
    public static final DegradeFeature LIKE = null;
    public static final DegradeFeature PORARAIT_DANMAKU = null;
    public static final DegradeFeature PUBLIC_SCREEN = null;
    public static final DegradeFeature TAP_LIKE = null;
    public static final /* synthetic */ DegradeFeature[] a = null;
    private final String scene;

    public static DegradeFeature valueOf(String r1) {
        return (DegradeFeature) a.a(DegradeFeature.class, r1);
    }

    public static DegradeFeature[] values() {
        return (DegradeFeature[]) a.clone();
    }

    static {
        DegradeFeature r1 = new DegradeFeature("TAP_LIKE", 0, "tap_like");
        TAP_LIKE = r1;
        DegradeFeature r2 = new DegradeFeature("FLOW_LIKE", 1, "flow_like");
        FLOW_LIKE = r2;
        DegradeFeature r3 = new DegradeFeature("LIKE", 2, "like");
        LIKE = r3;
        DegradeFeature r4 = new DegradeFeature("HOT_COMMENT_TRAY", 3, "hot_comment_tray");
        HOT_COMMENT_TRAY = r4;
        DegradeFeature r5 = new DegradeFeature("ENTER_ANIM", 4, "flow_screen_message");
        ENTER_ANIM = r5;
        DegradeFeature r6 = new DegradeFeature("COMMENT_CARNIVAL", 5, "comment_carnival");
        COMMENT_CARNIVAL = r6;
        DegradeFeature r7 = new DegradeFeature("PUBLIC_SCREEN", 6, "public_screen");
        PUBLIC_SCREEN = r7;
        DegradeFeature r8 = new DegradeFeature("PORARAIT_DANMAKU", 7, "portrait_danmaku");
        PORARAIT_DANMAKU = r8;
        DegradeFeature r9 = new DegradeFeature("ENTER_ROOM_DURATION", 8, "enter_room_duration");
        ENTER_ROOM_DURATION = r9;
        a = new DegradeFeature[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
    }

    public final String getScene() {
        return this.scene;
    }

    public DegradeFeature(String r1, int r2, String r3) {
        super(r1, r2);
        this.scene = r3;
    }
}
