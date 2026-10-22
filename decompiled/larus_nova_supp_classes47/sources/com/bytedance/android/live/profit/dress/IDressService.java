package com.bytedance.android.live.profit.dress;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&J\"\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&J*\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002H&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/dress/IDressService;", "Lzt0/e;", "", "dressId", "", "type", "function", "Lcom/bytedance/android/live/profit/dress/o;", "getDressModel", "Lcom/bytedance/android/live/profit/dress/p;", "getDressModelRaw", "", "pbData", "definition", "definitionVersion", "typeName", "getDressParsePbData", "live-dress-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IDressService extends zt0.e {
    /* synthetic */ void clearDressCache();

    @Override // zt0.e
    /* synthetic */ void clearGiftMemoryCache();

    /* synthetic */ void fetchAllDress(String r1);

    /* synthetic */ void fetchDressById(String r1, String r2, zt0.b r3);

    @Override // zt0.e
    /* synthetic */ <T extends d> T getDressData(String r1, int r2, long r3, String r5, zt0.b r6);

    @Override // zt0.e
    /* synthetic */ <T extends d> T getDressData(String r1, int r2, String r3);

    /* synthetic */ <T extends d> T getDressData(String r1, int r2, String r3, String r4, zt0.b r5);

    o getDressModel(String r1, int r2, String r3);

    p getDressModelRaw(String r1, int r2, String r3);

    String getDressParsePbData(byte[] r1, String r2, int r3, String r4);

    /* synthetic */ void onRoomChanged(String r1);
}
