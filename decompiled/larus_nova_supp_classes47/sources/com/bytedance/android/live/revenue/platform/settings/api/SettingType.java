package com.bytedance.android.live.revenue.platform.settings.api;

import com.bytedance.tools.kcp.aio.runtime.RpcEnum;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@RpcEnum(messageName = "webcast.revenue.biz.foundation.SettingType")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/settings/api/SettingType;", "", "", "typeIndex", "I", "getTypeIndex", "()I", "INT", "DOUBLE", "ARRAY", "OBJECT", "STRING", "BOOL", "live-kmp-platform-dynamic-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SettingType extends Enum<SettingType> {
    public static final SettingType ARRAY = null;
    public static final SettingType BOOL = null;
    public static final SettingType DOUBLE = null;
    public static final SettingType INT = null;
    public static final SettingType OBJECT = null;
    public static final SettingType STRING = null;
    public static final /* synthetic */ SettingType[] a = null;
    private final int typeIndex;

    static {
        SettingType r1 = new SettingType("INT", 0, 0);
        INT = r1;
        SettingType r2 = new SettingType("DOUBLE", 1, 1);
        DOUBLE = r2;
        SettingType r3 = new SettingType("ARRAY", 2, 2);
        ARRAY = r3;
        SettingType r4 = new SettingType("OBJECT", 3, 3);
        OBJECT = r4;
        SettingType r5 = new SettingType("STRING", 4, 4);
        STRING = r5;
        SettingType r6 = new SettingType("BOOL", 5, 5);
        BOOL = r6;
        a = new SettingType[]{r1, r2, r3, r4, r5, r6};
    }

    public static SettingType valueOf(String r1) {
        return (SettingType) a.a(SettingType.class, r1);
    }

    public static SettingType[] values() {
        return (SettingType[]) a.clone();
    }

    public final int getTypeIndex() {
        return this.typeIndex;
    }

    public SettingType(String r1, int r2, int r3) {
        super(r1, r2);
        this.typeIndex = r3;
    }
}
