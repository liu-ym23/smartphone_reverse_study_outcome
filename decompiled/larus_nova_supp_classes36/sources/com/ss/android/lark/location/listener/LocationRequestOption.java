package com.ss.android.lark.location.listener;

import com.ss.android.lark.location.dto.LarkLocation;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class LocationRequestOption {

    public static final enum LocationPriority extends Enum<LocationPriority> {
        public static final LocationPriority DEVICE_SENSORS = null;
        public static final LocationPriority PRIORITY_BALANCED_POWER_ACCURACY = null;
        public static final LocationPriority PRIORITY_HIGH_ACCURACY = null;
        public static final LocationPriority PRIORITY_LOW_POWER = null;
        public static final LocationPriority PRIORITY_NO_POWER = null;
        public static final /* synthetic */ LocationPriority[] a = null;

        static {
            LocationPriority r0 = new LocationPriority("PRIORITY_HIGH_ACCURACY", 0);
            PRIORITY_HIGH_ACCURACY = r0;
            LocationPriority r1 = new LocationPriority("PRIORITY_BALANCED_POWER_ACCURACY", 1);
            PRIORITY_BALANCED_POWER_ACCURACY = r1;
            LocationPriority r3 = new LocationPriority("PRIORITY_LOW_POWER", 2);
            PRIORITY_LOW_POWER = r3;
            LocationPriority r5 = new LocationPriority("PRIORITY_NO_POWER", 3);
            PRIORITY_NO_POWER = r5;
            LocationPriority r7 = new LocationPriority("DEVICE_SENSORS", 4);
            DEVICE_SENSORS = r7;
            a = new LocationPriority[]{r0, r1, r3, r5, r7};
        }

        public static LocationPriority[] values() {
            return (LocationPriority[]) a.clone();
        }

        public static LocationPriority valueOf(String r1) {
            return (LocationPriority) a.a(LocationPriority.class, r1);
        }

        public LocationPriority(String r1, int r2) {
            super(r1, r2);
        }
    }

    public LocationRequestOption() {
        LarkLocation.CoordinateSystem r0 = LarkLocation.CoordinateSystem.DEFAULT;
        LocationPriority r1 = LocationPriority.PRIORITY_HIGH_ACCURACY;
    }
}
