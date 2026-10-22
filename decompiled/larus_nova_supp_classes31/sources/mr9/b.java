package mr9;

import android.os.Build;
import com.google.gson.annotations.SerializedName;
import com.obric.assistant.common.spi.security.ObricSecurityServiceDelegate;
import com.tencent.open.log.TraceLevel;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001%BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0019\u001a\u00020\u0003H\u0016J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u00020\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006&"}, d2 = {"Lcom/larus/platform/model/upload/ImageAuth;", "", "accessKey", "", "secretKey", "sessionToken", "expiredTime", "currentTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessKey", "()Ljava/lang/String;", "getSecretKey", "getSessionToken", "getExpiredTime", "getCurrentTime", "expiredTimestamp", "", "getExpiredTimestamp", "()J", "setExpiredTimestamp", "(J)V", "currentTimeStamp", "getCurrentTimeStamp", "setCurrentTimeStamp", "toString", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class b {
    public static final a a = null;
    public static final SimpleDateFormat b = null;

    @SerializedName("access_key_id")
    private final String accessKey;

    @SerializedName("current_time")
    private final String currentTime;

    @SerializedName("expired_time")
    private final String expiredTime;

    @SerializedName("secret_access_key")
    private final String secretKey;

    @SerializedName("session_token")
    private final String sessionToken;

    public static final class a {
        public a() {
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.accessKey, r6.accessKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.secretKey, r6.secretKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sessionToken, r6.sessionToken) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.expiredTime, r6.expiredTime) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.currentTime, r6.currentTime) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r0 = this.accessKey;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.secretKey;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.sessionToken;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.expiredTime;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.currentTime;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    static {
        a = new a();
        if (Build.VERSION.SDK_INT < 24) goto L5;
        SimpleDateFormat r0 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
    L6:
        b = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    public b() {
        this("", "", "", "", "");
    }

    public final long b() {
        a r0 = a;
        String r1 = this.expiredTime;
        r0.getClass();
        if (Build.VERSION.SDK_INT < 24) goto L22;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        SimpleDateFormat r3 = b;     // Catch: Throwable -> L12
        if (r3 == null) goto L9;
        Date r4 = r3.parse(r1);     // Catch: Throwable -> L12
        if (r4 == null) goto L9;
        long r5 = r4.getTime();     // Catch: Throwable -> L12
    L10:
        Object r6 = Result.constructor-impl(Long.valueOf(r5));     // Catch: Throwable -> L12
    L15:
        if (Result.exceptionOrNull-impl(r6) == null) goto L19;
        r6 = -1L;
    L19:
        return ((Number) r6).longValue();
    L9:
        r5 = -1;
    L12:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L22:
        return -1;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("ImageAuth(accessKey=");
        ObricSecurityServiceDelegate r1 = ObricSecurityServiceDelegate.b;
        r0.append(r1.a(this.accessKey));
        r0.append(", secretKey=");
        r0.append(r1.a(this.secretKey));
        r0.append(", sessionToken=");
        r0.append(r1.a(this.sessionToken));
        r0.append(", expiredTime=");
        r0.append(this.expiredTime);
        r0.append(", currentTime=");
        r0.append(this.currentTime);
        r0.append(')');
        return r0.toString();
    }

    public final String a() {
        return this.accessKey;
    }

    public final String c() {
        return this.secretKey;
    }

    public final String d() {
        return this.sessionToken;
    }

    public b(String r1, String r2, String r3, String r4, String r5) {
        this.accessKey = r1;
        this.secretKey = r2;
        this.sessionToken = r3;
        this.expiredTime = r4;
        this.currentTime = r5;
    }
}
