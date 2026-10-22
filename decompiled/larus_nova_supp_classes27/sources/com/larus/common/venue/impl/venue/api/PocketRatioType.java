package com.larus.common.venue.impl.venue.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/common/venue/impl/venue/api/PocketRatioType;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface PocketRatioType {
    public static final a Companion = null;
    public static final long RATIO_16_9 = 5;
    public static final long RATIO_1_1 = 1;
    public static final long RATIO_2_3 = 7;
    public static final long RATIO_3_2 = 6;
    public static final long RATIO_3_4 = 3;
    public static final long RATIO_4_3 = 2;
    public static final long RATIO_9_16 = 4;

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
