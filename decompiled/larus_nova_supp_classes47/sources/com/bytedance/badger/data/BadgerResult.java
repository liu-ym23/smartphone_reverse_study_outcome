package com.bytedance.badger.data;

import com.bytedance.android.live.profile.ui.component.model.ProfileButtonType;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0003\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/badger/data/BadgerResult;", "", "<init>", "()V", "Companion", "a", "Failure", "Success", "Lcom/bytedance/badger/data/BadgerResult$Success;", "Lcom/bytedance/badger/data/BadgerResult$Failure;", "badger-api_release"}, k = 1, mv = {1, 4, 0})
public abstract class BadgerResult {
    public static final a Companion = null;
    public static final int ERROR = -1000;
    public static final int ERROR_AWAIT_TIMEOUT = -2001;
    public static final int SUCCESS = 0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/badger/data/BadgerResult$Failure;", "Lcom/bytedance/badger/data/BadgerResult;", "errorCode", "", Constants.Keys.ERROR, "", "(ILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "badger-api_release"}, k = 1, mv = {1, 1, ProfileButtonType.FANS_GROUP_CREATE})
    public static final class Failure extends BadgerResult {
        private final int errorCode;
        private final String errorMsg;

        public static /* synthetic */ Failure copy$default(Failure r0, int r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.errorCode;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.errorMsg;
        L9:
            return r0.copy(r1, r2);
        }

        public final int component1() {
            return this.errorCode;
        }

        public final String component2() {
            return this.errorMsg;
        }

        public final Failure copy(int r2, String r3) {
            return new Failure(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L5;
        L15:
            return true;
        L5:
            if ((r5 instanceof Failure) == false) goto L14;
            Failure r6 = (Failure) r5;
            if (this.errorCode != r6.errorCode) goto L9;
            boolean r1 = true;
        L10:
            if (r1 == false) goto L14;
            if (Intrinsics.areEqual(this.errorMsg, r6.errorMsg) == false) goto L14;
        L9:
            r1 = false;
        L14:
            return false;
        }

        public int hashCode() {
            int r0 = this.errorCode * 31;
            String r1 = this.errorMsg;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }

        public String toString() {
            return "Failure(errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ")";
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorMsg() {
            return this.errorMsg;
        }

        public Failure(int r2, String r3) {
            super(null);
            this.errorCode = r2;
            this.errorMsg = r3;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/badger/data/BadgerResult$Success;", "Lcom/bytedance/badger/data/BadgerResult;", Constants.Keys.DATA, "Lcom/bytedance/badger/data/IBadgerData;", "(Lcom/bytedance/badger/data/IBadgerData;)V", "getData", "()Lcom/bytedance/badger/data/IBadgerData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "badger-api_release"}, k = 1, mv = {1, 1, ProfileButtonType.FANS_GROUP_CREATE})
    public static final class Success extends BadgerResult {
        private final IBadgerData data;

        public static /* synthetic */ Success copy$default(Success r0, IBadgerData r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.data;
        L6:
            return r0.copy(r1);
        }

        public final IBadgerData component1() {
            return this.data;
        }

        public final Success copy(IBadgerData r2) {
            return new Success(r2);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof Success) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.data, ((Success) r2).data) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            IBadgerData r0 = this.data;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.data + ")";
        }

        public final IBadgerData getData() {
            return this.data;
        }

        public Success(IBadgerData r2) {
            super(null);
            this.data = r2;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private BadgerResult() {
    }

    public /* synthetic */ BadgerResult(DefaultConstructorMarker r1) {
        this();
    }
}
