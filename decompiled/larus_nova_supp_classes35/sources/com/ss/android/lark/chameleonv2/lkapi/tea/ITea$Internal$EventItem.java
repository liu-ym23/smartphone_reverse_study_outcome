package com.ss.android.lark.chameleonv2.lkapi.tea;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J%\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jt\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032$\b\u0002\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007`\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010)\u001a\u00020\rHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R-\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006+"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/tea/ITea$Internal$EventItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "eventName", BuildConfig.FLAVOR, "instanceId", "params", "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Lkotlin/collections/HashMap;", "timestamp", BuildConfig.FLAVOR, "userId", Keys.API_RETURN_KEY_APP_ID, BuildConfig.FLAVOR, "reportUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "getInstanceId", "getParams", "()Ljava/util/HashMap;", "getTimestamp", "()J", "getUserId", "getAppId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getReportUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/ss/android/lark/chameleonv2/lkapi/tea/ITea$Internal$EventItem;", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ITea$Internal$EventItem implements NonProguard {
    private final Integer appId;
    private final String eventName;
    private final String instanceId;
    private final HashMap<String, Object> params;
    private final String reportUrl;
    private final long timestamp;
    private final String userId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ITea$Internal$EventItem copy$default(ITea$Internal$EventItem r9, String r10, String r11, HashMap r12, long r13, String r15, Integer r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r1 = r9.eventName;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r2 = r9.instanceId;
    L11:
        if ((r18 & 4) == 0) goto L13;
        HashMap r3 = r9.params;
    L15:
        if ((r18 & 8) == 0) goto L17;
        long r4 = r9.timestamp;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.userId;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Integer r7 = r9.appId;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.reportUrl;
    L31:
        return r9.copy(r1, r2, r3, r4, r6, r7, r8);
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r4 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final String component1() {
        return this.eventName;
    }

    public final String component2() {
        return this.instanceId;
    }

    public final HashMap<String, Object> component3() {
        return this.params;
    }

    public final long component4() {
        return this.timestamp;
    }

    public final String component5() {
        return this.userId;
    }

    public final Integer component6() {
        return this.appId;
    }

    public final String component7() {
        return this.reportUrl;
    }

    public final ITea$Internal$EventItem copy(String r11, String r12, HashMap<String, Object> r13, long r14, String r16, Integer r17, String r18) {
        Intrinsics.checkNotNullParameter(r11, "eventName");
        Intrinsics.checkNotNullParameter(r12, "instanceId");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r16, "userId");
        return new ITea$Internal$EventItem(r11, r12, r13, r14, r16, r17, r18);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ITea$Internal$EventItem) == true) goto L8;
        return false;
    L8:
        ITea$Internal$EventItem r9 = (ITea$Internal$EventItem) r8;
        if (Intrinsics.areEqual(this.eventName, r9.eventName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.instanceId, r9.instanceId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.params, r9.params) == true) goto L18;
        return false;
    L18:
        if (this.timestamp == r9.timestamp) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.userId, r9.userId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.appId, r9.appId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.reportUrl, r9.reportUrl) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.eventName.hashCode() * 31) + this.instanceId.hashCode()) * 31) + this.params.hashCode()) * 31;
        long r1 = this.timestamp;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.userId.hashCode()) * 31;
        Integer r3 = this.appId;
        int r4 = 0;
        if (r3 != null) goto L5;
        int r5 = 0;
    L6:
        int r6 = (r2 + r5) * 31;
        String r7 = this.reportUrl;
        if (r7 == null) goto L11;
        r4 = r7.hashCode();
    L11:
        return r6 + r4;
    L5:
        r5 = r3.hashCode();
        goto L6
    }

    public String toString() {
        return "EventItem(eventName=" + this.eventName + ", instanceId=" + this.instanceId + ", params=" + this.params + ", timestamp=" + this.timestamp + ", userId=" + this.userId + ", appId=" + this.appId + ", reportUrl=" + this.reportUrl + ')';
    }

    public final Integer getAppId() {
        return this.appId;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final String getInstanceId() {
        return this.instanceId;
    }

    public final HashMap<String, Object> getParams() {
        return this.params;
    }

    public final String getReportUrl() {
        return this.reportUrl;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getUserId() {
        return this.userId;
    }

    public ITea$Internal$EventItem(String r2, String r3, HashMap<String, Object> r4, long r5, String r7, Integer r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "instanceId");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r7, "userId");
        this.eventName = r2;
        this.instanceId = r3;
        this.params = r4;
        this.timestamp = r5;
        this.userId = r7;
        this.appId = r8;
        this.reportUrl = r9;
    }
}
