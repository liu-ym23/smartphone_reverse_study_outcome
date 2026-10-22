package com.bytedance.android.livesdk.interactivity.api.chatchannel;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/ContainerType;", BuildConfig.FLAVOR, "PublicScreen", "MultiTab", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ContainerType extends Enum<ContainerType> {
    public static final ContainerType MultiTab = null;
    public static final ContainerType PublicScreen = null;
    public static final /* synthetic */ ContainerType[] a = null;

    static {
        ContainerType r1 = new ContainerType("PublicScreen", 0);
        PublicScreen = r1;
        ContainerType r2 = new ContainerType("MultiTab", 1);
        MultiTab = r2;
        a = new ContainerType[]{r1, r2};
    }

    public static ContainerType valueOf(String r1) {
        return (ContainerType) a.a(ContainerType.class, r1);
    }

    public static ContainerType[] values() {
        return (ContainerType[]) a.clone();
    }

    public ContainerType(String r1, int r2) {
        super(r1, r2);
    }
}
