package com.bytedance.pia.core.setting;

import android.net.Uri;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import com.bytedance.pia.core.utils.i;
import com.bytedance.pia.core.utils.j;
import com.google.gson.annotations.SerializedName;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u001b\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001AR\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010 \u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0019\u0010\u001fR \u0010%\u001a\b\u0012\u0004\u0012\u00020\u00180!8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\u0011\u0010$R\u001a\u0010'\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u001e\u001a\u0004\b\"\u0010\u001fR\u001a\u0010)\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u001e\u001a\u0004\b(\u0010\u001fR\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001aR\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001aR\u001a\u0010.\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006R\u001a\u00100\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010\u0004\u001a\u0004\b/\u0010\u0006R\u001a\u00103\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010\u0004\u001a\u0004\b2\u0010\u0006R\u001a\u00104\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b1\u0010\u0006R\u001a\u00106\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\u0004\u001a\u0004\b5\u0010\u0006R\u001a\u00108\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010\u0004\u001a\u0004\b7\u0010\u0006R \u0010;\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0083\u0004¢\u0006\f\n\u0004\b7\u0010\u001a\u0012\u0004\b9\u0010:R\u001a\u0010<\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010\u0004\u001a\u0004\b,\u0010\u0006R\u001a\u0010@\u001a\u00020=8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010>\u001a\u0004\b\u0003\u0010?¨\u0006B"}, d2 = {"Lcom/bytedance/pia/core/setting/Settings;", "", "", "a", "Z", "q", "()Z", "isPiaEnabled", "b", "l", "isBootEnabled", "c", "m", "isCacheEnabled", "d", "x", "isWorkerEnabled", "e", "v", "isVanillaFetchEnabled", "f", "w", "isWarmupEnabled", "", "", "g", "Ljava/util/List;", "allowedDomains", "", "h", "I", "()I", "htmlInterceptTimeout", "", "i", "Ljava/util/Set;", "()Ljava/util/Set;", "enabledFeatures", "j", "pageStorageCapacity", "k", "streamingInterceptTimeout", "blockedPages", "urlRules", "n", "r", "isPiaQueryDisable", "o", "isMustFinishWarmup", LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME, "u", "isUrlCompatV2Enabled", "isNsrV1Enabled", "s", "isPrefetchV1Enabled", "t", "isSnapshotV1Enabled", "getBlockedV1Page$annotations", "()V", "blockedV1Page", "isCreateRuntimeWaitEnable", "", "J", "()J", "createRuntimeWaitInternal", "com/lynx/tasm/p", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@SourceDebugExtension({"SMAP\nSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Settings.kt\ncom/bytedance/pia/core/setting/Settings\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,276:1\n1711#2,3:277\n1711#2,3:280\n*E\n*S KotlinDebug\n*F\n+ 1 Settings.kt\ncom/bytedance/pia/core/setting/Settings\n*L\n156#1,3:277\n187#1,3:280\n*E\n"})
public final class Settings {
    public static final Lazy B = null;
    public static final Lazy C = null;
    public static volatile boolean D;
    public static volatile Settings E;
    public final Lazy A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(JvmProtoBufUtil.DEFAULT_MODULE_NAME)
    private final boolean f7053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("boot")
    private final boolean f7054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("cache")
    private final boolean f7055c;

    @SerializedName("worker")
    private final boolean d;

    @SerializedName("vanilla_fetch")
    private final boolean e;

    @SerializedName("warmup")
    private final boolean f;

    @SerializedName("allow_domains")
    private final List<String> g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SerializedName("html_intercept_timeout")
    private final int f7056h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SerializedName("features")
    private final Set<String> f7057i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SerializedName("page_storage_capacity")
    private final int f7058j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SerializedName("streaming_intercept_timeout")
    private final int f7059k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @SerializedName("blocked_pages")
    private final List<String> f7060l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @SerializedName("url_rules")
    private final List<String> f7061m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @SerializedName("experiment_disable_pia_query")
    private final boolean f7062n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @SerializedName("experiment_must_finish_warmup")
    private final boolean f7063o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @SerializedName("enable_add_cache_key")
    private final boolean f7064p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @SerializedName("nsr_v1")
    private final boolean f7065q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @SerializedName("prefetch_v1")
    private final boolean f7066r;

    @SerializedName("snapshot_v1")
    private final boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @SerializedName("blocked_pages_v1")
    private final List<String> f7067t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @SerializedName("create_runtime_wait")
    private final boolean f7068u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @SerializedName("create_runtime_wait_internal")
    private final long f7069v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f7070w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f7071x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f7072y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f7073z;

    static {
        B = LazyKt.lazy(Settings$Companion$DEFAULT_SETTINGS$2.f7074a);
        C = LazyKt.lazy(Settings$Companion$DISABLED_SETTINGS$2.f7075a);
        D = true;
    }

    public Settings() {
        this(null, 4194303);
    }

    public static final /* synthetic */ List b(Settings r5) {
        return r5.g;
    }

    public static final /* synthetic */ List d(Settings r5) {
        return r5.f7060l;
    }

    public static final /* synthetic */ List h(Settings r5) {
        return r5.f7067t;
    }

    public static final /* synthetic */ List j(Settings r5) {
        return r5.f7061m;
    }

    public final long a() {
        return this.f7069v;
    }

    public final boolean c(Uri r10) {
        if (D == true) goto L6;
        return true;
    L6:
        if (this.f7053a == true) goto L9;
        return false;
    L9:
        if (((Collection) this.f7072y.getValue()).isEmpty() == false) goto L12;
        return false;
    L12:
        if (((Collection) this.f7072y.getValue()).contains(XPath.WILDCARD) == false) goto L14;
        return true;
    L14:
        if (r10 != null) goto L17;
        return false;
    L17:
        if (j.z(r10) == true) goto L19;
        return false;
    L19:
        Collection r5 = (Collection) this.f7072y.getValue();
        if ((r5 instanceof Collection) == true) goto L22;
    L24:
        Iterator r11 = r5.iterator();
    L26:
        if (r11.hasNext() == false) goto L30;
        if (StringsKt.k("." + r10.getHost(), (String) r11.next()) == false) goto L26;
        return true;
    L30:
        return false;
    L22:
        if (r5.isEmpty() == false) goto L24;
        return false;
    }

    public final Set e() {
        return this.f7057i;
    }

    public final boolean f(Uri r5) {
        if (D == true) goto L6;
        return false;
    L6:
        if (r5 != null) goto L9;
        return true;
    L9:
        if (this.f7053a == true) goto L12;
        return true;
    L12:
        if (j.z(r5) == true) goto L15;
        return true;
    L15:
        if (((List) this.f7073z.getValue()).isEmpty() == false) goto L17;
        return false;
    L17:
        String r10 = r5.getHost();
        if (r10 != null) goto L20;
        return true;
    L20:
        String r11 = r5.getPath();
        if (r11 != null) goto L23;
        return true;
    L23:
        String r12 = r10.concat(r11);
        List r13 = (List) this.f7073z.getValue();
        if (r13 != null) goto L26;
    L28:
        Iterator r14 = r13.iterator();
    L30:
        if (r14.hasNext() == false) goto L34;
        if (StringsKt.g(r12, (String) r14.next()) == false) goto L30;
        return true;
    L34:
        return false;
    L26:
        if (r13.isEmpty() == false) goto L28;
        return false;
    }

    public final int g() {
        return this.f7056h;
    }

    public final int i() {
        return this.f7058j;
    }

    public final int k() {
        return this.f7059k;
    }

    public final boolean l() {
        return this.f7054b;
    }

    public final boolean m() {
        return this.f7055c;
    }

    public final boolean n() {
        return this.f7068u;
    }

    public final boolean o() {
        return this.f7063o;
    }

    public final boolean p() {
        return this.f7065q;
    }

    public final boolean q() {
        return this.f7053a;
    }

    public final boolean r() {
        return this.f7062n;
    }

    public final boolean s() {
        return this.f7066r;
    }

    public final boolean t() {
        return this.s;
    }

    public final String toString() {
        return "PiaSettings(enabled=" + D + "): " + i.a().toJson(this);
    }

    public final boolean u() {
        return this.f7064p;
    }

    public final boolean v() {
        return this.e;
    }

    public final boolean w() {
        return this.f;
    }

    public final boolean x() {
        return this.d;
    }

    public Settings(List r11, int r12) {
        if ((r12 & 64) == 0) goto L5;
        r11 = CollectionsKt.emptyList();
    L5:
        Set<String> r5 = SetsKt.setOf(new String[]{"prefetch", "nsr", "snapshot", "cache", "streaming", "preload"});
        List<String> r10 = CollectionsKt.emptyList();
        List<String> r13 = CollectionsKt.emptyList();
        if ((r12 & 8192) == 0) goto L8;
        boolean r14 = false;
    L10:
        if ((65536 & r12) == 0) goto L12;
        boolean r15 = false;
    L14:
        if ((131072 & r12) == 0) goto L16;
        boolean r16 = false;
    L18:
        if ((r12 & 262144) == 0) goto L20;
        boolean r17 = false;
    L21:
        List<String> r18 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r11, "allowedDomains");
        Intrinsics.checkNotNullParameter(r5, "enabledFeatures");
        Intrinsics.checkNotNullParameter(r10, "blockedPages");
        Intrinsics.checkNotNullParameter(r13, "urlRules");
        Intrinsics.checkNotNullParameter(r18, "blockedV1Page");
        this.f7053a = true;
        this.f7054b = true;
        this.f7055c = true;
        this.d = true;
        this.e = true;
        this.f = true;
        this.g = r11;
        this.f7056h = 20;
        this.f7057i = r5;
        this.f7058j = 500;
        this.f7059k = 5;
        this.f7060l = r10;
        this.f7061m = r13;
        this.f7062n = r14;
        this.f7063o = false;
        this.f7064p = false;
        this.f7065q = r15;
        this.f7066r = r16;
        this.s = r17;
        this.f7067t = r18;
        this.f7068u = false;
        this.f7069v = 200;
        this.f7070w = LazyKt.lazy(new Settings$base$2(this));
        this.f7071x = LazyKt.lazy(new Settings$features$2(this));
        this.f7072y = LazyKt.lazy(new Settings$safeAllowedDomain$2(this));
        this.f7073z = LazyKt.lazy(new Settings$safeBlockedPages$2(this));
        this.A = LazyKt.lazy(new Settings$urlMatcher$2(this));
        return;
    L20:
        r17 = true;
        goto L21
    L16:
        r16 = true;
        goto L18
    L12:
        r15 = true;
        goto L14
    L8:
        r14 = true;
        goto L10
    }
}
