package com.obric.memorydata.middleware.impl.image;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 -*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001-B?\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010!\u001a\u00020\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003JL\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0007\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R \u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u0012\u0010\u001d\u001a\u00020\u001e8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006."}, d2 = {"Lcom/obric/memorydata/middleware/impl/image/Resp;", ExifInterface.GPS_DIRECTION_TRUE, "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "data", "payload", "logId", "<init>", "(JLjava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()J", "setCode", "(J)V", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getPayload", "setPayload", "getLogId", "setLogId", "success", "", "getSuccess", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "(JLjava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/memorydata/middleware/impl/image/Resp;", "equals", "other", "hashCode", "", "toString", "Companion", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Resp<T> {
    private static final long[] CODE_RISK_CONTROL = null;
    public static final long CODE_UNKNOWN = -999;
    public static final a Companion = null;

    @SerializedName("code")
    private long code;

    @SerializedName("data")
    private T data;

    @SerializedName("log_id")
    private String logId;

    @SerializedName(NotificationCompat.CATEGORY_MESSAGE)
    private String msg;

    @SerializedName("payload")
    private String payload;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/middleware/impl/image/Resp$Companion;", "", "<init>", "()V", "CODE_UNKNOWN", "", "CODE_RISK_CONTROL", "", "getCODE_RISK_CONTROL", "()[J", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
        CODE_RISK_CONTROL = new long[]{710012005, 710012021};
    }

    public Resp() {
        this(0, null, null, null, null, 31, null);
    }

    public Resp(long r2, String r4, T r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        this.code = r2;
        this.msg = r4;
        this.data = r5;
        this.payload = r6;
        this.logId = r7;
    }

    public /* synthetic */ Resp(long r8, String r10, Object r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = -999;
    L5:
        long r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        String r3 = "";
    L10:
        if ((r14 & 4) == 0) goto L12;
        Object r4 = null;
    L14:
        if ((r14 & 8) == 0) goto L16;
        String r5 = null;
    L18:
        if ((r14 & 16) == 0) goto L20;
        String r6 = "";
    L21:
        this(r1, r3, r4, r5, r6);
        return;
    L20:
        r6 = r13;
        goto L21
    L16:
        r5 = r12;
        goto L18
    L12:
        r4 = r11;
        goto L14
    L8:
        r3 = r10;
        goto L10
    }

    public static final /* synthetic */ long[] access$getCODE_RISK_CONTROL$cp() {
        return CODE_RISK_CONTROL;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Resp copy$default(Resp r7, long r8, String r10, Object r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.code;
    L5:
        long r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r10 = r7.msg;
    L8:
        String r3 = r10;
        if ((r14 & 4) == 0) goto L11;
        r11 = r7.data;
    L11:
        Object r4 = r11;
        if ((r14 & 8) == 0) goto L14;
        r12 = r7.payload;
    L14:
        String r5 = r12;
        if ((r14 & 16) == 0) goto L18;
        r13 = r7.logId;
    L18:
        return r7.copy(r1, r3, r4, r5, r13);
    }

    public final long component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final T component3() {
        return this.data;
    }

    public final String component4() {
        return this.payload;
    }

    public final String component5() {
        return this.logId;
    }

    public final Resp<T> copy(long r8, String r10, T r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_MESSAGE);
        return new Resp(r8, r10, r11, r12, r13);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, Resp.class) == true) goto L8;
        return false;
    L8:
        Resp r10 = (Resp) ZeusTransformUtils.preCheckCast(r9, Resp.class, "com.obric.memorydata.plugin");
        if (this.code == r10.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r10.msg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r10.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.payload, r10.payload) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.logId, r10.logId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final long getCode() {
        return this.code;
    }

    public final T getData() {
        return this.data;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final boolean getSuccess() {
        if (getCode() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        int r0 = ((Long.hashCode(this.code) * 31) + this.msg.hashCode()) * 31;
        T r1 = this.data;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.payload;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.logId;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final void setCode(long r1) {
        this.code = r1;
    }

    public final void setData(T r1) {
        this.data = r1;
    }

    public final void setLogId(String r1) {
        this.logId = r1;
    }

    public final void setMsg(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.msg = r2;
    }

    public final void setPayload(String r1) {
        this.payload = r1;
    }

    public String toString() {
        return "Resp(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ", payload=" + this.payload + ", logId=" + this.logId + ')';
    }
}
