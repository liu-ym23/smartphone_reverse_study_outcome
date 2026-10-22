package com.bytedance.rpc.serialize.json;

import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldFrom;
import com.bytedance.rpc.annotation.RpcFieldTo;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/* JADX INFO: loaded from: classes2.dex */
public class ExcludeFieldStrategy implements ExclusionStrategy {
    boolean mSerialize;

    public ExcludeFieldStrategy(boolean r1) {
        this.mSerialize = r1;
    }

    @Override // com.google.gson.ExclusionStrategy
    public boolean shouldSkipClass(Class<?> r1) {
        return false;
    }

    @Override // com.google.gson.ExclusionStrategy
    public boolean shouldSkipField(FieldAttributes r2) {
        if (this.mSerialize == false) goto L8;
        if (r2.getAnnotation(RpcFieldTo.class) == null) goto L11;
        return true;
    L11:
        if (r2.getAnnotation(RpcField.class) == null) goto L13;
        return true;
    L13:
        return false;
    L8:
        if (r2.getAnnotation(RpcFieldFrom.class) == null) goto L11;
        return true;
    }
}
