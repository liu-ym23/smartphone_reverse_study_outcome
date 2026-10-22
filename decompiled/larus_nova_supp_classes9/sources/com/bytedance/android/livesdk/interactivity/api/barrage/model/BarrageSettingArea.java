package com.bytedance.android.livesdk.interactivity.api.barrage.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/BarrageSettingArea;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "area", "I", "getArea", "()I", "Companion", "a", "CLOSE", "TOP", "HALF", "FULL", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BarrageSettingArea extends Enum<BarrageSettingArea> {
    public static final BarrageSettingArea CLOSE = null;
    public static final a Companion = null;
    public static final BarrageSettingArea FULL = null;
    public static final BarrageSettingArea HALF = null;
    public static final BarrageSettingArea TOP = null;
    public static final /* synthetic */ BarrageSettingArea[] a = null;
    private final int area;

    public static final class a {
        public a() {
        }
    }

    static {
        BarrageSettingArea r1 = new BarrageSettingArea("CLOSE", 0, 0);
        CLOSE = r1;
        BarrageSettingArea r2 = new BarrageSettingArea("TOP", 1, 1);
        TOP = r2;
        BarrageSettingArea r3 = new BarrageSettingArea("HALF", 2, 2);
        HALF = r3;
        BarrageSettingArea r4 = new BarrageSettingArea("FULL", 3, 3);
        FULL = r4;
        a = new BarrageSettingArea[]{r1, r2, r3, r4};
        Companion = new a();
    }

    public static BarrageSettingArea valueOf(String r1) {
        return (BarrageSettingArea) r27.a.a(BarrageSettingArea.class, r1);
    }

    public static BarrageSettingArea[] values() {
        return (BarrageSettingArea[]) a.clone();
    }

    public final int getArea() {
        return this.area;
    }

    public BarrageSettingArea(String r1, int r2, int r3) {
        super(r1, r2);
        this.area = r3;
    }
}
