package com.larus.common.location.impl;

import com.google.gson.annotations.SerializedName;
import com.larus.dora.api.model.FlowDoraConnectReason;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/larus/common/location/impl/LocationAuthManager$CommonResponse;", "", FlowDoraConnectReason.SUCCESS, "", "data", "", "<init>", "(ZLjava/lang/String;)V", "getSuccess", "()Z", "getData", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("resp")
        private final String data;

        @SerializedName(FlowDoraConnectReason.SUCCESS)
        private final boolean success;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.success == r6.success) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.data, r6.data) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.success == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = r0 * 31;
            String r2 = this.data;
            if (r2 != null) goto L9;
            int r3 = 0;
        L11:
            return r1 + r3;
        L9:
            r3 = r2.hashCode();
            goto L11
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "CommonResponse(success=" + this.success + ", data=" + this.data + ')';
        }

        public a() {
            this.success = false;
            this.data = null;
        }
    }

    static {
    }
}
