package com.obric.cae.smartBluetooth.storage.carkey;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface CarkeyAppInfoDao {
    void delete(CarkeyAppInfo r8);

    List<CarkeyAppInfo> getAll();

    CarkeyAppInfo getByAppName(String r8);

    void upsert(CarkeyAppInfo r8);
}
