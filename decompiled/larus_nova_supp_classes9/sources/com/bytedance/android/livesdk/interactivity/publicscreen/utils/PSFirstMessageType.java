package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/utils/PSFirstMessageType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "statusCode", "I", "getStatusCode", "()I", "REALTIME", "HISTORY", "BACKEND_TOP", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PSFirstMessageType extends Enum<PSFirstMessageType> {
    public static final PSFirstMessageType BACKEND_TOP = null;
    public static final PSFirstMessageType HISTORY = null;
    public static final PSFirstMessageType REALTIME = null;
    public static final /* synthetic */ PSFirstMessageType[] a = null;
    private final int statusCode;

    static {
        PSFirstMessageType r1 = new PSFirstMessageType("REALTIME", 0);
        REALTIME = r1;
        PSFirstMessageType r2 = new PSFirstMessageType("HISTORY", 1);
        HISTORY = r2;
        PSFirstMessageType r3 = new PSFirstMessageType("BACKEND_TOP", 2);
        BACKEND_TOP = r3;
        a = new PSFirstMessageType[]{r1, r2, r3};
    }

    public static PSFirstMessageType valueOf(String r1) {
        return (PSFirstMessageType) r27.a.a(PSFirstMessageType.class, r1);
    }

    public static PSFirstMessageType[] values() {
        return (PSFirstMessageType[]) a.clone();
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public PSFirstMessageType(String r1, int r2) {
        super(r1, r2);
        this.statusCode = 1 << ordinal();
    }
}
