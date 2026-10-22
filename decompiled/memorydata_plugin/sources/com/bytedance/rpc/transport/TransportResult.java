package com.bytedance.rpc.transport;

import com.bytedance.rpc.RpcException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TransportResult {
    long mContentLength;
    String mContentType;
    Object mData;
    RpcException mError;
    Map<String, String> mHeaders;
    int mHttpCode;
    String mHttpMsg;
    long mRequestFinishedTime;
    int mRequestId;
    long mRequestReceivedTime;
    long mRequestSerializeTime;
    long mRequestTransformTime;

    /* JADX INFO: renamed from: com.bytedance.rpc.transport.TransportResult$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        long mContentLength;
        String mContentType;
        Object mData;
        RpcException mError;
        Map<String, String> mHeaders;
        int mHttpCode;
        String mHttpMsg;
        long mRequestFinishedTime;
        int mRequestId;
        long mRequestReceivedTime;
        long mRequestSerializeTime;
        long mRequestTransformTime;

        public Builder() {
        }

        private Builder self() {
            return this;
        }

        public TransportResult build() {
            return new TransportResult(this, null);
        }

        public Builder setContentLength(long r1) {
            this.mContentLength = r1;
            return self();
        }

        public Builder setContentType(String r1) {
            this.mContentType = r1;
            return self();
        }

        public Builder setHeaders(Map<String, String> r3) {
            this.mHeaders = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            return self();
        }

        public Builder setHttpCode(int r1) {
            this.mHttpCode = r1;
            return self();
        }

        public Builder setHttpMsg(String r1) {
            this.mHttpMsg = r1;
            return self();
        }

        public Builder setRequestFinishedTime(long r1) {
            this.mRequestFinishedTime = r1;
            return self();
        }

        public Builder setRequestId(int r1) {
            this.mRequestId = r1;
            return self();
        }

        public Builder setRequestReceivedTime(long r1) {
            this.mRequestReceivedTime = r1;
            return self();
        }

        public Builder setRequestSerializeTime(long r1) {
            this.mRequestSerializeTime = r1;
            return self();
        }

        public Builder setRequestTransformTime(long r1) {
            this.mRequestTransformTime = r1;
            return self();
        }

        public Builder setResult(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, Throwable.class) == true) goto L5;
            this.mData = r3;
        L12:
            return self();
        L5:
            if (ZeusTransformUtils.instanceOf(r3, RpcException.class) == false) goto L9;
            RpcException r4 = (RpcException) ZeusTransformUtils.preCheckCast(r3, RpcException.class, "com.obric.memorydata.plugin");
            this.mError = r4;
            if (r4.isHttpError() == false) goto L12;
            this.mHttpCode = this.mError.getCode();
            this.mHttpMsg = this.mError.getMessage();
            goto L12
        L9:
            this.mError = RpcException.from((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin")).build();
            goto L12
        }
    }

    private TransportResult(Builder r3) {
        this.mRequestId = r3.mRequestId;
        this.mRequestReceivedTime = r3.mRequestReceivedTime;
        this.mRequestTransformTime = r3.mRequestTransformTime;
        this.mRequestSerializeTime = r3.mRequestSerializeTime;
        this.mRequestFinishedTime = r3.mRequestFinishedTime;
        this.mHttpCode = r3.mHttpCode;
        this.mHttpMsg = r3.mHttpMsg;
        this.mContentType = r3.mContentType;
        this.mContentLength = r3.mContentLength;
        this.mData = r3.mData;
        this.mError = r3.mError;
        this.mHeaders = r3.mHeaders;
    }

    /* synthetic */ TransportResult(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    public long getContentLength() {
        return this.mContentLength;
    }

    public String getContentType() {
        return this.mContentType;
    }

    public Object getData() {
        return this.mData;
    }

    public RpcException getError() {
        return this.mError;
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public int getHttpCode() {
        return this.mHttpCode;
    }

    public String getHttpMsg() {
        return this.mHttpMsg;
    }

    public long getRequestFinishedTime() {
        return this.mRequestFinishedTime;
    }

    public int getRequestId() {
        return this.mRequestId;
    }

    public long getRequestReceivedTime() {
        return this.mRequestReceivedTime;
    }

    public long getRequestSerializeTime() {
        return this.mRequestSerializeTime;
    }

    public long getRequestTransformTime() {
        return this.mRequestTransformTime;
    }

    public boolean isTransportSuccess() {
        if (this.mError != null) goto L5;
        return true;
    L5:
        return false;
    }
}
