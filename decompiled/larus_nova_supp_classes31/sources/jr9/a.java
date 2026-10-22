package jr9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003JC\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/larus/platform/model/share/ShareItemConfig;", "", "channelType", "", "shareType", "shareItemUIConfig", "Lcom/larus/platform/model/share/ShareItemUIConfig;", "traceMap", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/share/ShareItemUIConfig;Ljava/util/Map;)V", "getChannelType", "()Ljava/lang/String;", "getShareType", "getShareItemUIConfig", "()Lcom/larus/platform/model/share/ShareItemUIConfig;", "setShareItemUIConfig", "(Lcom/larus/platform/model/share/ShareItemUIConfig;)V", "getTraceMap", "()Ljava/util/Map;", "setTraceMap", "(Ljava/util/Map;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class a {
    public transient b a;
    public final transient Map<String, String> b;

    @SerializedName("channel_type")
    private final String channelType;

    @SerializedName("share_type")
    private final String shareType;

    public a() {
        String r0 = null;
        this(r0, r0, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.channelType, r6.channelType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.shareType, r6.shareType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r0 = this.channelType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.shareType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        b r7 = this.a;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return ((r6 + r1) * 31) + this.b.hashCode();
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShareItemConfig(channelType=" + this.channelType + ", shareType=" + this.shareType + ", shareItemUIConfig=" + this.a + ", traceMap=" + this.b + ')';
    }

    public final String b() {
        return this.channelType;
    }

    public final String c() {
        return this.shareType;
    }

    public static a a(a r4) {
        String r0 = r4.channelType;
        b r1 = r4.a;
        Map<String, String> r2 = r4.b;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r2, "traceMap");
        return new a(r0, "file_url", r1, r2);
    }

    public /* synthetic */ a(String r3, String r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r5 & 8) == 0) goto L11;
        LinkedHashMap r6 = new LinkedHashMap();
    L12:
        this(r3, r4, null, r6);
        return;
    L11:
        r6 = null;
        goto L12
    }

    public a(String r2, String r3, b r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r5, "traceMap");
        this.channelType = r2;
        this.shareType = r3;
        this.a = r4;
        this.b = r5;
    }
}
