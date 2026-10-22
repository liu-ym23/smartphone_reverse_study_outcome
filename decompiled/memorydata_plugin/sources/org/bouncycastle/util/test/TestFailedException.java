package org.bouncycastle.util.test;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class TestFailedException extends RuntimeException {
    private TestResult _result;

    public TestFailedException(TestResult r3) {
        this._result = (TestResult) ZeusTransformUtils.wrapperContextForParams(r3, TestResult.class, "com.obric.memorydata.plugin");
    }

    public TestResult getResult() {
        return this._result;
    }
}
