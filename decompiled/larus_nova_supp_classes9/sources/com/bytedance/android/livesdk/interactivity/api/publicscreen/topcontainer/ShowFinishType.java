package com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/topcontainer/ShowFinishType;", BuildConfig.FLAVOR, "NORMAL", "TIMEOUT", "INTERRUPT", "DESTROY", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShowFinishType extends Enum<ShowFinishType> {
    public static final ShowFinishType DESTROY = null;
    public static final ShowFinishType INTERRUPT = null;
    public static final ShowFinishType NORMAL = null;
    public static final ShowFinishType TIMEOUT = null;
    public static final /* synthetic */ ShowFinishType[] a = null;

    static {
        ShowFinishType r1 = new ShowFinishType("NORMAL", 0);
        NORMAL = r1;
        ShowFinishType r2 = new ShowFinishType("TIMEOUT", 1);
        TIMEOUT = r2;
        ShowFinishType r3 = new ShowFinishType("INTERRUPT", 2);
        INTERRUPT = r3;
        ShowFinishType r4 = new ShowFinishType("DESTROY", 3);
        DESTROY = r4;
        a = new ShowFinishType[]{r1, r2, r3, r4};
    }

    public static ShowFinishType valueOf(String r1) {
        return (ShowFinishType) a.a(ShowFinishType.class, r1);
    }

    public static ShowFinishType[] values() {
        return (ShowFinishType[]) a.clone();
    }

    public ShowFinishType(String r1, int r2) {
        super(r1, r2);
    }
}
