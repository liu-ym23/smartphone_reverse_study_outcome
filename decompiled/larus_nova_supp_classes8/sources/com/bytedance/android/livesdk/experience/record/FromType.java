package com.bytedance.android.livesdk.experience.record;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/experience/record/FromType;", "", "ContentResolver", "Display", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FromType extends Enum<FromType> {
    public static final FromType ContentResolver = null;
    public static final FromType Display = null;
    public static final /* synthetic */ FromType[] a = null;

    static {
        FromType r1 = new FromType("ContentResolver", 0);
        ContentResolver = r1;
        FromType r2 = new FromType("Display", 1);
        Display = r2;
        a = new FromType[]{r1, r2};
    }

    public static FromType valueOf(String r1) {
        return (FromType) a.a(FromType.class, r1);
    }

    public static FromType[] values() {
        return (FromType[]) a.clone();
    }

    public FromType(String r1, int r2) {
        super(r1, r2);
    }
}
