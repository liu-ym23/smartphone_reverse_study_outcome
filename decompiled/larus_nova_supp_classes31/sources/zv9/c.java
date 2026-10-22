package zv9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b1\b\u0086\b\u0018\u00002\u00020\u0001B»\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00120\b\u0002\u0010\t\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u0001`\f\u0012\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000e\u0012\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000e\u0012\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000e\u0012\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\bHÆ\u0003J1\u00105\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u0001`\fHÆ\u0003J\u0013\u00106\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000eHÆ\u0003J\u0013\u00107\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000eHÆ\u0003J\u0013\u00108\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000eHÆ\u0003J\u0013\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000eHÆ\u0003J½\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b20\b\u0002\u0010\t\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u0001`\f2\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000e2\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000e2\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000e2\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000eHÆ\u0001J\u0013\u0010;\u001a\u00020\u00032\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\bHÖ\u0001J\t\u0010>\u001a\u00020\u000bHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!RF\u0010\t\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u0001`\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R(\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R(\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R(\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R(\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)¨\u0006?"}, d2 = {"Lcom/larus/settings/provider/security/AppOpsConfig;", "", "enable", "", "blackListMode", "needStack", "useNewTag", "maxCacheSize", "", "mockApi2Op", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "serviceBlackSet", "", "serviceClassBlackSet", "serviceWhiteSet", "serviceClassWhiteSet", "<init>", "(ZZZZILjava/util/HashMap;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getEnable", "()Z", "setEnable", "(Z)V", "getBlackListMode", "setBlackListMode", "getNeedStack", "setNeedStack", "getUseNewTag", "setUseNewTag", "getMaxCacheSize", "()I", "setMaxCacheSize", "(I)V", "getMockApi2Op", "()Ljava/util/HashMap;", "setMockApi2Op", "(Ljava/util/HashMap;)V", "getServiceBlackSet", "()Ljava/util/List;", "setServiceBlackSet", "(Ljava/util/List;)V", "getServiceClassBlackSet", "setServiceClassBlackSet", "getServiceWhiteSet", "setServiceWhiteSet", "getServiceClassWhiteSet", "setServiceClassWhiteSet", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class c {

    @SerializedName("black_list_mode")
    private boolean blackListMode;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("max_cache_size")
    private int maxCacheSize;

    @SerializedName("mock_api_2_op")
    private HashMap<Integer, String> mockApi2Op;

    @SerializedName("need_stack")
    private boolean needStack;

    @SerializedName("service_black_set")
    private List<String> serviceBlackSet;

    @SerializedName("service_class_black_set")
    private List<String> serviceClassBlackSet;

    @SerializedName("service_class_white_set")
    private List<String> serviceClassWhiteSet;

    @SerializedName("service_white_set")
    private List<String> serviceWhiteSet;

    @SerializedName("use_new_tag")
    private boolean useNewTag;

    public c() {
        this(null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.enable == r6.enable) goto L12;
        return false;
    L12:
        if (this.blackListMode == r6.blackListMode) goto L15;
        return false;
    L15:
        if (this.needStack == r6.needStack) goto L18;
        return false;
    L18:
        if (this.useNewTag == r6.useNewTag) goto L21;
        return false;
    L21:
        if (this.maxCacheSize == r6.maxCacheSize) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.mockApi2Op, r6.mockApi2Op) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.serviceBlackSet, r6.serviceBlackSet) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.serviceClassBlackSet, r6.serviceClassBlackSet) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.serviceWhiteSet, r6.serviceWhiteSet) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.serviceClassWhiteSet, r6.serviceClassWhiteSet) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.enable == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.blackListMode == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.needStack == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.useNewTag == true) goto L18;
        r1 = 1237;
    L18:
        int r7 = (((r6 + r1) * 31) + this.maxCacheSize) * 31;
        HashMap<Integer, String> r8 = this.mockApi2Op;
        int r9 = 0;
        if (r8 != null) goto L21;
        int r10 = 0;
    L22:
        int r11 = (r7 + r10) * 31;
        List<String> r12 = this.serviceBlackSet;
        if (r12 != null) goto L25;
        int r13 = 0;
    L26:
        int r14 = (r11 + r13) * 31;
        List<String> r15 = this.serviceClassBlackSet;
        if (r15 != null) goto L29;
        int r16 = 0;
    L30:
        int r17 = (r14 + r16) * 31;
        List<String> r18 = this.serviceWhiteSet;
        if (r18 != null) goto L33;
        int r19 = 0;
    L34:
        int r20 = (r17 + r19) * 31;
        List<String> r21 = this.serviceClassWhiteSet;
        if (r21 == null) goto L39;
        r9 = r21.hashCode();
    L39:
        return r20 + r9;
    L33:
        r19 = r18.hashCode();
        goto L34
    L29:
        r16 = r15.hashCode();
        goto L30
    L25:
        r13 = r12.hashCode();
        goto L26
    L21:
        r10 = r8.hashCode();
        goto L22
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "AppOpsConfig(enable=" + this.enable + ", blackListMode=" + this.blackListMode + ", needStack=" + this.needStack + ", useNewTag=" + this.useNewTag + ", maxCacheSize=" + this.maxCacheSize + ", mockApi2Op=" + this.mockApi2Op + ", serviceBlackSet=" + this.serviceBlackSet + ", serviceClassBlackSet=" + this.serviceClassBlackSet + ", serviceWhiteSet=" + this.serviceWhiteSet + ", serviceClassWhiteSet=" + this.serviceClassWhiteSet + ')';
    }

    public final boolean a() {
        return this.enable;
    }

    public final int b() {
        return this.maxCacheSize;
    }

    public final HashMap<Integer, String> c() {
        return this.mockApi2Op;
    }

    public final boolean d() {
        return this.needStack;
    }

    public final List<String> e() {
        return this.serviceBlackSet;
    }

    public final List<String> f() {
        return this.serviceWhiteSet;
    }

    public c(Object r6) {
        HashMap<Integer, String> r7 = new HashMap();
        List<String> r0 = CollectionsKt.emptyList();
        List<String> r1 = CollectionsKt.emptyList();
        List<String> r2 = CollectionsKt.emptyList();
        List<String> r3 = CollectionsKt.emptyList();
        this.enable = false;
        this.blackListMode = false;
        this.needStack = false;
        this.useNewTag = false;
        this.maxCacheSize = 50;
        this.mockApi2Op = r7;
        this.serviceBlackSet = r0;
        this.serviceClassBlackSet = r1;
        this.serviceWhiteSet = r2;
        this.serviceClassWhiteSet = r3;
    }
}
