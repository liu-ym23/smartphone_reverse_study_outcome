package com.bytedance.awemeopen.infra.plugs.kvstorage;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.awemeopen.servicesapi.storage.AoKVStorageService;
import e64.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class AoKVStorageServiceImpl implements AoKVStorageService {
    public AoKVStorageServiceImpl() {
    }

    public final SharedPreferences h(Context r2, String r3) {
        return new c(r2, r3);
    }
}
