package com.bytedance.ai.bridge.remote.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001aB)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/BatchGetAppMetaResponse;", "Ljava/io/Serializable;", "code", "", a.KEY_MSG, "", "data", "Lcom/bytedance/ai/bridge/remote/model/BatchGetAppMetaResponse$Data;", "<init>", "(ILjava/lang/String;Lcom/bytedance/ai/bridge/remote/model/BatchGetAppMetaResponse$Data;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getData", "()Lcom/bytedance/ai/bridge/remote/model/BatchGetAppMetaResponse$Data;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "Data", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BatchGetAppMetaResponse implements Serializable {

    @SerializedName("code")
    private final int code;

    @SerializedName("data")
    private final Data data;

    @SerializedName(a.KEY_MSG)
    private final String message;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/BatchGetAppMetaResponse$Data;", "Ljava/io/Serializable;", "items", "", "Lcom/bytedance/ai/bridge/remote/model/AppMeta;", "failedKeys", "Lcom/bytedance/ai/bridge/remote/model/FailedKey;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "getFailedKeys", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Data implements Serializable {

        @SerializedName("failed_keys")
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private final List<FailedKey> failedKeys;

        @SerializedName("items")
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private final List<AppMeta> items;

        public Data() {
            List r0 = null;
            this(r0, r0, 3, r0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Data copy$default(Data r0, List r1, List r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r1 = r0.items;
        L6:
            if ((r11 & 2) == 0) goto L9;
            r10 = r0.failedKeys;
        L9:
            return r0.copy(r1, r10);
        }

        public final List<AppMeta> component1() {
            return this.items;
        }

        public final List<FailedKey> component2() {
            return this.failedKeys;
        }

        public final Data copy(List<AppMeta> r10, List<FailedKey> r11) {
            return new Data(r10, r11);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof Data) == true) goto L8;
            return false;
        L8:
            Data r11 = (Data) r10;
            if (Intrinsics.areEqual(this.items, r11.items) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.failedKeys, r11.failedKeys) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            List<AppMeta> r0 = this.items;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r10 = 0;
        L6:
            int r11 = r10 * 31;
            List<FailedKey> r12 = this.failedKeys;
            if (r12 == null) goto L11;
            r1 = r12.hashCode();
        L11:
            return r11 + r1;
        L5:
            r10 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "Data(items=" + this.items + ", failedKeys=" + this.failedKeys + ')';
        }

        public final List<FailedKey> getFailedKeys() {
            return this.failedKeys;
        }

        public final List<AppMeta> getItems() {
            return this.items;
        }

        public Data(List<AppMeta> r1, List<FailedKey> r10) {
            this.items = r1;
            this.failedKeys = r10;
        }

        public /* synthetic */ Data(List r1, List r10, int r11, DefaultConstructorMarker r12) {
            if ((r11 & 1) == 0) goto L6;
            r1 = CollectionsKt.emptyList();
        L6:
            if ((r11 & 2) == 0) goto L8;
            r10 = CollectionsKt.emptyList();
        L8:
            this(r1, r10);
        }
    }

    public BatchGetAppMetaResponse() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ BatchGetAppMetaResponse copy$default(BatchGetAppMetaResponse r0, int r1, String r10, Data r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = r0.message;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = r0.data;
    L12:
        return r0.copy(r1, r10, r11);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final Data component3() {
        return this.data;
    }

    public final BatchGetAppMetaResponse copy(int r10, String r11, Data r12) {
        return new BatchGetAppMetaResponse(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof BatchGetAppMetaResponse) == true) goto L8;
        return false;
    L8:
        BatchGetAppMetaResponse r11 = (BatchGetAppMetaResponse) r10;
        if (this.code == r11.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r11.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r11.data) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.code * 31;
        String r1 = this.message;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        Data r13 = this.data;
        if (r13 == null) goto L11;
        r10 = r13.hashCode();
    L11:
        return r12 + r10;
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "BatchGetAppMetaResponse(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ')';
    }

    public final int getCode() {
        return this.code;
    }

    public final Data getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public BatchGetAppMetaResponse(int r1, String r10, Data r11) {
        this.code = r1;
        this.message = r10;
        this.data = r11;
    }

    public /* synthetic */ BatchGetAppMetaResponse(int r10, String r11, Data r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }
}
