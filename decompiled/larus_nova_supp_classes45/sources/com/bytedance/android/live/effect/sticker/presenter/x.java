package com.bytedance.android.live.effect.sticker.presenter;

import com.google.gson.annotations.SerializedName;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x {
    public final Map<String, a> a;
    public final List<Object> b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/presenter/x$a;", "", "", "stickerID", "Ljava/lang/String;", "getStickerID", "()Ljava/lang/String;", "extra", "getExtra", "teaLogParams", "a", "messageType", "getMessageType", "arg1", "getArg1", "arg2", "getArg2", "arg3", "getArg3", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("arg1")
        private final String arg1;

        @SerializedName("arg2")
        private final String arg2;

        @SerializedName("arg3")
        private final String arg3;

        @SerializedName("extra")
        private final String extra;

        @SerializedName("message_type")
        private final String messageType;

        @SerializedName("sticker_id")
        private final String stickerID;

        @SerializedName("tea_log_params")
        private final String teaLogParams;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L20;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.stickerID, r4.stickerID) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.teaLogParams, r4.teaLogParams) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.messageType, r4.messageType) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.arg1, r4.arg1) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.arg2, r4.arg2) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.arg3, r4.arg3) == true) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        public final int hashCode() {
            String r0 = this.stickerID;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.extra;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.teaLogParams;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r11 = this.messageType;
            if (r11 == null) goto L17;
            int r12 = r11.hashCode();
        L18:
            int r13 = (r9 + r12) * 31;
            String r14 = this.arg1;
            if (r14 == null) goto L21;
            int r15 = r14.hashCode();
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.arg2;
            if (r17 == null) goto L25;
            int r18 = r17.hashCode();
        L26:
            int r19 = (r16 + r18) * 31;
            String r21 = this.arg3;
            if (r21 == null) goto L30;
            r1 = r21.hashCode();
        L30:
            return r19 + r1;
        L25:
            r18 = 0;
            goto L26
        L21:
            r15 = 0;
            goto L22
        L17:
            r12 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "InteractStickerInfo(stickerID=" + this.stickerID + ", extra=" + this.extra + ", teaLogParams=" + this.teaLogParams + ", messageType=" + this.messageType + ", arg1=" + this.arg1 + ", arg2=" + this.arg2 + ", arg3=" + this.arg3 + ")";
        }

        public final String a() {
            return this.teaLogParams;
        }
    }

    public x() {
        this.a = new LinkedHashMap();
        this.b = new ArrayList();
        new CompositeDisposable();
    }
}
