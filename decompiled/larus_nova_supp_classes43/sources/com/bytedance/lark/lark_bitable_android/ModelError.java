package com.bytedance.lark.lark_bitable_android;

import com.bytedance.ai.event.MessageIndication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0006\u0010\u0018\u001a\u00020\u0019J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/lark/lark_bitable_android/ModelError;", "Lcom/bytedance/lark/lark_bitable_android/UnhandledException;", "code", "", MessageIndication.MESSAGE_TYPE_MSG, "", "(JLjava/lang/String;)V", "getCode", "()J", "setCode", "(J)V", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "into", "Llark_bitable/proto/ModelError;", "toString", "lark_bitable_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ModelError extends UnhandledException {
    private long code;
    private String msg;

    public static /* synthetic */ ModelError copy$default(ModelError r0, long r1, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.msg;
    L9:
        return r0.copy(r1, r10);
    }

    public final long component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final ModelError copy(long r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        return new ModelError(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ModelError) == true) goto L8;
        return false;
    L8:
        ModelError r11 = (ModelError) r10;
        if (this.code == r11.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r11.msg) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r0 = this.code;
        return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.msg.hashCode();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "ModelError(code=" + this.code + ", msg=" + this.msg + ')';
    }

    public final lark_bitable.proto.ModelError into() {
        return new lark_bitable.proto.ModelError(Long.valueOf(this.code), this.msg);
    }

    public final long getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void setCode(long r1) {
        this.code = r1;
    }

    public final void setMsg(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.msg = r10;
    }

    public ModelError(long r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        super(null, 1, null);
        this.code = r10;
        this.msg = r11;
    }
}
