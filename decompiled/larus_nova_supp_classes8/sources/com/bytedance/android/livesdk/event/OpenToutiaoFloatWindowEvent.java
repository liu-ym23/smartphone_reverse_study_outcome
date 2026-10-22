package com.bytedance.android.livesdk.event;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class OpenToutiaoFloatWindowEvent {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/event/OpenToutiaoFloatWindowEvent$FloatWindowSource;", "", "", "logString", "Ljava/lang/String;", "getLogString", "()Ljava/lang/String;", "SMALL_WINDOW_BUTTON", "BACK_BUTTON", "POPUP", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum FloatWindowSource extends Enum<FloatWindowSource> {
        public static final FloatWindowSource BACK_BUTTON = null;
        public static final FloatWindowSource POPUP = null;
        public static final FloatWindowSource SMALL_WINDOW_BUTTON = null;
        public static final /* synthetic */ FloatWindowSource[] a = null;
        private final String logString;

        static {
            FloatWindowSource r1 = new FloatWindowSource("SMALL_WINDOW_BUTTON", 0, "small_window_button");
            SMALL_WINDOW_BUTTON = r1;
            FloatWindowSource r2 = new FloatWindowSource("BACK_BUTTON", 1, "back_button");
            BACK_BUTTON = r2;
            FloatWindowSource r3 = new FloatWindowSource("POPUP", 2, "popup");
            POPUP = r3;
            a = new FloatWindowSource[]{r1, r2, r3};
        }

        public static FloatWindowSource valueOf(String r1) {
            return (FloatWindowSource) r27.a.a(FloatWindowSource.class, r1);
        }

        public static FloatWindowSource[] values() {
            return (FloatWindowSource[]) a.clone();
        }

        public final String getLogString() {
            return this.logString;
        }

        public FloatWindowSource(String r1, int r2, String r3) {
            super(r1, r2);
            this.logString = r3;
        }
    }
}
