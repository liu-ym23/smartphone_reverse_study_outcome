package com.larus.bmhome.utils;

import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ASRModifyReporter {
    public static final ConcurrentHashMap<String, String> a = null;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/utils/ASRModifyReporter$CreateUserQueryPairResponse;", "Ljava/io/Serializable;", "code", "", "msg", "", "<init>", "(Ljava/lang/Long;Ljava/lang/String;)V", "getCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/String;)Lcom/larus/bmhome/utils/ASRModifyReporter$CreateUserQueryPairResponse;", "equals", "", "other", "", "hashCode", "", "toString", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CreateUserQueryPairResponse implements Serializable {

        @SerializedName("code")
        private final Long code;

        @SerializedName("msg")
        private final String msg;

        /* JADX WARN: Multi-variable type inference failed */
        public CreateUserQueryPairResponse() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ CreateUserQueryPairResponse copy$default(CreateUserQueryPairResponse r0, Long r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.code;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.msg;
        L9:
            return r0.copy(r1, r2);
        }

        public final Long component1() {
            return this.code;
        }

        public final String component2() {
            return this.msg;
        }

        public final CreateUserQueryPairResponse copy(Long r2, String r3) {
            return new CreateUserQueryPairResponse(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof CreateUserQueryPairResponse) == true) goto L8;
            return false;
        L8:
            CreateUserQueryPairResponse r6 = (CreateUserQueryPairResponse) r5;
            if (Intrinsics.areEqual(this.code, r6.code) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.msg, r6.msg) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            Long r0 = this.code;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.msg;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "CreateUserQueryPairResponse(code=" + this.code + ", msg=" + this.msg + ')';
        }

        public final Long getCode() {
            return this.code;
        }

        public final String getMsg() {
            return this.msg;
        }

        public CreateUserQueryPairResponse(Long r1, String r2) {
            this.code = r1;
            this.msg = r2;
        }

        public /* synthetic */ CreateUserQueryPairResponse(Long r3, String r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r3 = 0L;
        L6:
            if ((r5 & 2) == 0) goto L8;
            r4 = "";
        L8:
            this(r3, r4);
        }
    }

    static {
        a = new ConcurrentHashMap();
    }

    public static void a(Message r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        String r0 = r10.getMessageId();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        ConcurrentHashMap<String, String> r2 = a;
        if (r2.isEmpty() == false) goto L14;
        return;
    L14:
        Map r3 = r10.getExt();
        if (r3 == null) goto L17;
        String r4 = (String) r3.get("source_from_asr");
    L19:
        if (Intrinsics.areEqual(r4, "1") == true) goto L21;
        return;
    L21:
        Map r5 = r10.getExt();
        if (r5 == null) goto L24;
        String r6 = (String) r5.get("modified_from");
    L25:
        if (r6 != null) goto L27;
        return;
    L27:
        String r7 = r2.remove(r6);
        if (r7 != null) goto L30;
        return;
    L30:
        String r8 = r10.getMessageId();
        Map r11 = r10.getExt();
        if (r11 == null) goto L33;
        String r12 = (String) r11.get("bot_id");
    L34:
        if (r12 != null) goto L36;
        return;
    L36:
        FLogger.a.d("ASRModifyReporter", "oldMessageId:" + r7 + ", newMessageId:" + r8 + ", botId:" + r12);
        if (r8 != null) goto L39;
        r8 = "";
    L39:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ASRModifyReporter$createQueryPair$1(r7, r8, r12, null), 3, null);
        return;
    L33:
        r12 = null;
        goto L34
    L24:
        r6 = null;
        goto L25
    L17:
        r4 = null;
        goto L19
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
