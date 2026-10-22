package com.obric.security.secretdata;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class QueryResult {
    private List<SecretData> mDataList;
    private int mResultCode;

    public QueryResult(int r2, List<SecretData> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public List<SecretData> getDataList() {
        throw new RuntimeException("Stub!!");
    }

    public int getResultCode() {
        throw new RuntimeException("Stub!!");
    }
}
