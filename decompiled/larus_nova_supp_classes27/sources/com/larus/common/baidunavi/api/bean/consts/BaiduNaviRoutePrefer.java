package com.larus.common.baidunavi.api.bean.consts;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/common/baidunavi/api/bean/consts/BaiduNaviRoutePrefer;", "", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface BaiduNaviRoutePrefer {
    public static final a Companion = null;
    public static final int DRIVE_AVOID_JAM = 5;
    public static final int DRIVE_AVOID_JAM_AND_HIGHWAY = 7;
    public static final int DRIVE_AVOID_JAM_AND_LESS_FEE = 9;
    public static final int DRIVE_AVOID_JAM_AND_NO_HIGHWAY = 8;
    public static final int DRIVE_AVOID_JAM_AND_NO_HIGHWAY_AND_LESS_FEE = 10;
    public static final int DRIVE_DISTANCE_FIRST = 12;
    public static final int DRIVE_DISTANCE_SHORTEST = 2;
    public static final int DRIVE_HIGHWAY = 4;
    public static final int DRIVE_LESS_FEE = 6;
    public static final int DRIVE_NO_HIGHWAY_AND_LESS_FEE = 11;
    public static final int DRIVE_NO_HIGHWAY_OR_RIDING_LEGAL = 3;
    public static final int DRIVE_TIME_FIRST = 13;
    public static final int DRIVE_TIME_FIRST_IGNORE_LIVE_TRAFFIC = 14;
    public static final int RECOMMEND = 0;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.a;
    }
}
