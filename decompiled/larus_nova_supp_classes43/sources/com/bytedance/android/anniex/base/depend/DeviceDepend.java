package com.bytedance.android.anniex.base.depend;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class DeviceDepend {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/anniex/base/depend/DeviceDepend$FoldStatus;", "", "Companion", "a", "anniex_release"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FoldStatus {
        public static final a Companion = null;
        public static final String FLAT = "flat";
        public static final String FOLDED = "folded";
        public static final String HALF = "half";
        public static final String UNKNOWN = "";

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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/anniex/base/depend/DeviceDepend$FoldType;", "", "Companion", "a", "anniex_release"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FoldType {
        public static final a Companion = null;
        public static final String HORIZONTAL = "horizontal";
        public static final String UNKNOWN = "";
        public static final String VERTICAL = "vertical";

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

    public DeviceDepend() {
    }
}
