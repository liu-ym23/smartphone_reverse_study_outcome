package qt9;

import com.google.gson.annotations.SerializedName;
import com.larus.common.apphost.AppHost;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J\u0013\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\""}, d2 = {"Lcom/larus/settings/provider/AppletLiteUsageConfig;", "", "replaceRuyi", "", "replaceOtherLynxView", "replaceLynxPage", "lynxPageHostWhitelist", "", "", "lynxViewHostWhitelist", "<init>", "(ZZZLjava/util/List;Ljava/util/List;)V", "getReplaceRuyi", "()Z", "getReplaceOtherLynxView", "getReplaceLynxPage", "getLynxPageHostWhitelist", "()Ljava/util/List;", "getLynxViewHostWhitelist", "getStandardLynxPageHostWhitelist", "getStandardLynxViewHostWhitelist", "handleWhitelist", "originalList", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class g {

    @SerializedName("lynx_page_host_whitelist")
    private final List<String> lynxPageHostWhitelist;

    @SerializedName("lynx_view_host_whitelist")
    private final List<String> lynxViewHostWhitelist;

    @SerializedName("replace_lynx_page")
    private final boolean replaceLynxPage;

    @SerializedName("replace_other_lynx_view")
    private final boolean replaceOtherLynxView;

    @SerializedName("replace_ruyi")
    private final boolean replaceRuyi;

    public g() {
        this(null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (this.replaceRuyi == r6.replaceRuyi) goto L12;
        return false;
    L12:
        if (this.replaceOtherLynxView == r6.replaceOtherLynxView) goto L15;
        return false;
    L15:
        if (this.replaceLynxPage == r6.replaceLynxPage) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lynxPageHostWhitelist, r6.lynxPageHostWhitelist) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.lynxViewHostWhitelist, r6.lynxViewHostWhitelist) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.replaceRuyi == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.replaceOtherLynxView == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.replaceLynxPage == true) goto L14;
        r1 = 1237;
    L14:
        int r5 = (r4 + r1) * 31;
        List<String> r6 = this.lynxPageHostWhitelist;
        int r7 = 0;
        if (r6 != null) goto L17;
        int r8 = 0;
    L18:
        int r9 = (r5 + r8) * 31;
        List<String> r10 = this.lynxViewHostWhitelist;
        if (r10 == null) goto L23;
        r7 = r10.hashCode();
    L23:
        return r9 + r7;
    L17:
        r8 = r6.hashCode();
        goto L18
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "AppletLiteUsageConfig(replaceRuyi=" + this.replaceRuyi + ", replaceOtherLynxView=" + this.replaceOtherLynxView + ", replaceLynxPage=" + this.replaceLynxPage + ", lynxPageHostWhitelist=" + this.lynxPageHostWhitelist + ", lynxViewHostWhitelist=" + this.lynxViewHostWhitelist + ')';
    }

    public final List<String> b() {
        List<String> r0 = this.lynxPageHostWhitelist;
        if (r0 == null) goto L10;
        List r1 = CollectionsKt.filterNotNull(r0);
        if (r1 == null) goto L10;
        return d(r1);
    L10:
        return CollectionsKt.emptyList();
    }

    public final List<String> c() {
        List<String> r0 = this.lynxViewHostWhitelist;
        if (r0 == null) goto L10;
        List r1 = CollectionsKt.filterNotNull(r0);
        if (r1 == null) goto L10;
        return d(r1);
    L10:
        return CollectionsKt.emptyList();
    }

    public final boolean a() {
        return this.replaceLynxPage;
    }

    public g(Object r6) {
        AppHost.Companion r7 = AppHost.a;
        boolean r0 = !r7.isOversea();
        boolean r1 = !r7.isOversea();
        boolean r2 = !r7.isOversea();
        if (r7.isOversea() == true) goto L5;
        List<String> r3 = CollectionsKt.listOf(".bytegecko.com");
    L7:
        if (r7.isOversea() == true) goto L9;
        List<String> r8 = CollectionsKt.listOf(".bytegecko.com");
    L10:
        this.replaceRuyi = r0;
        this.replaceOtherLynxView = r1;
        this.replaceLynxPage = r2;
        this.lynxPageHostWhitelist = r3;
        this.lynxViewHostWhitelist = r8;
        return;
    L9:
        r8 = CollectionsKt.emptyList();
        goto L10
    L5:
        r3 = CollectionsKt.emptyList();
        goto L7
    }

    public static List d(List r6) {
        ArrayList r0 = new ArrayList();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        String r1 = (String) r7.next();
        if (StringsKt.startsWith$default(r1, ".", false, 2, null) == true) goto L9;
        r1 = "." + r1;
    L9:
        r0.add(r1);
        goto L4
    L10:
        return r0;
    }
}
