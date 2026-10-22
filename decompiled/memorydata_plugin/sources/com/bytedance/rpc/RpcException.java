package com.bytedance.rpc;

import com.bytedance.rpc.internal.RpcUtils;
import com.bytedance.rpc.log.DefaultErrorFormatter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class RpcException extends RuntimeException implements Serializable {
    private static final List<Converter> mConverters = null;
    private int mCode;
    private long mErrorTime;
    private boolean mHttpProtocolError;
    private int mRequestId;
    private String mSource;
    private Map<Class<?>, Object> mTags;

    /* JADX INFO: renamed from: com.bytedance.rpc.RpcException$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private Throwable mCause;
        private int mCode;
        private long mErrorTime;
        private boolean mHttpProtocolError;
        private String mMsg;
        private int mRequestId;
        private String mSource;
        private Map<Class<?>, Object> mTags;

        private Builder(int r1, String r2, boolean r3) {
            this.mCode = r1;
            this.mMsg = r2;
            this.mHttpProtocolError = r3;
            this.mTags = new HashMap(2);
        }

        /* synthetic */ Builder(int r1, String r2, boolean r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        private Builder(RpcException r1) {
            this(r1);
        }

        /* synthetic */ Builder(RpcException r1, AnonymousClass1 r2) {
            this(r1);
        }

        private Builder(Throwable r5) {
            this.mCause = r5;
            this.mCode = ErrorCode.UNKNOWN;
            if (ZeusTransformUtils.instanceOf(r5, RpcException.class) == false) goto L5;
            RpcException r6 = (RpcException) ZeusTransformUtils.preCheckCast(r5, RpcException.class, "com.obric.memorydata.plugin");
            this.mHttpProtocolError = RpcException.access$300(r6);
            this.mCode = RpcException.access$400(r6);
            this.mMsg = r6.getMessage();
            this.mRequestId = RpcException.access$500(r6);
            this.mCause = r6.getCause();
            this.mErrorTime = RpcException.access$600(r6);
            this.mTags = RpcException.access$700(r6);
            this.mSource = RpcException.access$800(r6);
            return;
        L5:
            this.mTags = new HashMap(2);
            Iterator r0 = RpcException.access$900().iterator();
        L7:
            if (r0.hasNext() == false) goto L11;
            ((Converter) ZeusTransformUtils.preCheckCast(r0.next(), Converter.class, "com.obric.memorydata.plugin")).convert(r5, this);
            goto L7
        }

        /* synthetic */ Builder(Throwable r1, AnonymousClass1 r2) {
            this(r1);
        }

        private Builder self() {
            return this;
        }

        public RpcException apply(RpcException r2) {
            if (r2 == null) goto L4;
            RpcException.access$402(r2, this.mCode);
            RpcException.access$502(r2, this.mRequestId);
            RpcException.access$702(r2, this.mTags);
            RpcException.access$802(r2, this.mSource);
            return r2;
        L4:
            return build();
        }

        public RpcException build() {
            if (RpcUtils.isInvisible(this.mMsg) == false) goto L8;
            Throwable r0 = this.mCause;
            if (r0 != null) goto L7;
            String r1 = "";
        L9:
            RpcException r2 = new RpcException(r1, this.mCause, null);
            RpcException.access$402(r2, this.mCode);
            RpcException.access$502(r2, this.mRequestId);
            RpcException.access$302(r2, this.mHttpProtocolError);
            if (RpcException.access$602(r2, this.mErrorTime) != 0) goto L12;
            RpcException.access$602(r2, System.currentTimeMillis());
        L12:
            RpcException.access$702(r2, this.mTags);
            RpcException.access$802(r2, this.mSource);
            return r2;
        L7:
            r1 = r0.getMessage();
            goto L9
        L8:
            r1 = this.mMsg;
            goto L9
        }

        public Builder setCode(int r1) {
            this.mCode = r1;
            return self();
        }

        public Builder setHttpProtocolError(boolean r1) {
            this.mHttpProtocolError = r1;
            return self();
        }

        public Builder setInfo(int r1, String r2) {
            this.mCode = r1;
            this.mMsg = r2;
            return self();
        }

        public Builder setMessage(String r1) {
            this.mMsg = r1;
            return self();
        }

        public Builder setRequestId(int r1) {
            this.mRequestId = r1;
            return self();
        }

        public Builder setSource(String r1) {
            this.mSource = r1;
            return self();
        }

        public Builder setTag(Class<?> r2, Object r3) {
            this.mTags.put(r2, r3);
            return self();
        }
    }

    public interface Converter {
        void convert(Throwable r1, Builder r2);
    }

    public interface ErrorCode {
        public static final int CANCEL_TIMEOUT = 987654324;
        public static final int CANCEL_USER = 987654323;
        public static final int IGNORE = 987654322;
        public static final int NULL_RESPONSE_BODY = 987654326;
        public static final int OK = 0;
        public static final int RPCINTERCEPTED = 987654325;
        public static final int UNKNOWN = 987654321;
    }

    static {
        mConverters = new ArrayList();
    }

    private RpcException(String r1, Throwable r2) {
        super(r1, r2);
    }

    /* synthetic */ RpcException(String r1, Throwable r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    static /* synthetic */ boolean access$300(RpcException r0) {
        return r0.mHttpProtocolError;
    }

    static /* synthetic */ boolean access$302(RpcException r0, boolean r1) {
        r0.mHttpProtocolError = r1;
        return r1;
    }

    static /* synthetic */ int access$400(RpcException r0) {
        return r0.mCode;
    }

    static /* synthetic */ int access$402(RpcException r0, int r1) {
        r0.mCode = r1;
        return r1;
    }

    static /* synthetic */ int access$500(RpcException r0) {
        return r0.mRequestId;
    }

    static /* synthetic */ int access$502(RpcException r0, int r1) {
        r0.mRequestId = r1;
        return r1;
    }

    static /* synthetic */ long access$600(RpcException r2) {
        return r2.mErrorTime;
    }

    static /* synthetic */ long access$602(RpcException r0, long r1) {
        r0.mErrorTime = r1;
        return r1;
    }

    static /* synthetic */ Map access$700(RpcException r0) {
        return r0.mTags;
    }

    static /* synthetic */ Map access$702(RpcException r2, Map r3) {
        Map<Class<?>, Object> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        r2.mTags = r4;
        return r4;
    }

    static /* synthetic */ String access$800(RpcException r0) {
        return r0.mSource;
    }

    static /* synthetic */ String access$802(RpcException r0, String r1) {
        r0.mSource = r1;
        return r1;
    }

    static /* synthetic */ List access$900() {
        return mConverters;
    }

    public static void addConverter(Converter r2) {
        Converter r3 = (Converter) ZeusTransformUtils.wrapperContextForParams(r2, Converter.class, "com.obric.memorydata.plugin");
        mConverters.add(r3);
    }

    public static Builder from(Throwable r2) {
        return new Builder(r2, null);
    }

    public static Builder fromHttp(int r3, String r4) {
        return new Builder(r3, r4, true, null);
    }

    public static Builder fromNew(int r3, String r4) {
        return new Builder(r3, r4, false, null);
    }

    public static final Throwable getFinalCause(Throwable r0) {
        return DefaultErrorFormatter.getLastCause(r0);
    }

    public static RpcException ignore(String r1, int r2) {
        return fromNew(ErrorCode.IGNORE, r1).setRequestId(r2).build();
    }

    public static boolean removeConverter(Converter r2) {
        Converter r3 = (Converter) ZeusTransformUtils.wrapperContextForParams(r2, Converter.class, "com.obric.memorydata.plugin");
        return mConverters.remove(r3);
    }

    public int getCode() {
        return this.mCode;
    }

    public long getErrorTime() {
        return this.mErrorTime;
    }

    public final Throwable getLastCause() {
        return getFinalCause(getCause());
    }

    public int getRequestId() {
        return this.mRequestId;
    }

    public String getResource() {
        return this.mSource;
    }

    public Object getTag(Class<?> r1) {
        Map<Class<?>, Object> r0 = this.mTags;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.get(r1);
    }

    public boolean isCanceled() {
        if (this.mCode != 987654323) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isHttpError() {
        return this.mHttpProtocolError;
    }

    public boolean isIgnored() {
        if (this.mCode != 987654322) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isTimeout() {
        int r0 = this.mCode;
        if (r0 != 987654324) goto L6;
        return true;
    L6:
        if (r0 != 987654321) goto L16;
        Throwable r4 = getLastCause();
        if (r4 == null) goto L15;
        if (ZeusTransformUtils.instanceOf(r4, TimeoutException.class) == false) goto L12;
        return true;
    L12:
        if (ZeusTransformUtils.instanceOf(r4, SocketTimeoutException.class) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public Builder toBuilder() {
        return new Builder(this, null);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "RpcException{code=" + this.mCode + ", reason=" + getMessage() + ", httpProtocolError=" + this.mHttpProtocolError + ", requestId=" + this.mRequestId + ", errorTime=" + this.mErrorTime + ", source='" + this.mSource + "', cause=" + getLastCause() + ", tags=" + this.mTags + '}';
    }
}
