package com.obric.security.secretdata;

import android.content.Context;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class SecretDataManager {
    private SecretDataManager() {
    }

    public static SecretDataManager getInstance() {
        throw new RuntimeException("Stub!!");
    }

    public AddResult addData(Context r1, SecretData r2, Bundle r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public int deleteData(Context r1, String r2, Bundle r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public QueryResult queryData(Context r1, String r2, Bundle r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public int updateData(Context r1, SecretData r2, Bundle r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }
}
