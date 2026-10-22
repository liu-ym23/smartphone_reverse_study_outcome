package com.bytedance.android.live.network.impl.interceptor;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostNetwork;
import com.bytedance.android.livesdk.config.np0;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.net.URI;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class FuseRequestAdaptorInterceptor implements Interceptor {
    public static final List<String> a = null;
    public static final SettingKey<List<String>> b = null;
    public static final SettingKey<List<PathPrefixReplaceRule>> c = null;
    public static final List<String> d = null;
    public static final SettingKey<List<String>> e = null;
    public static final SettingKey<List<String>> f = null;
    public static final List<Triple<String, String, MatchRule>> g = null;
    public static final List<Pair<String, MatchRule>> h = null;
    public static final List<String> i = null;
    public static final FuseRequestAdaptorInterceptor j = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/network/impl/interceptor/FuseRequestAdaptorInterceptor$MatchRule;", "", "PREFIX", "FULL", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum MatchRule extends Enum<MatchRule> {
        public static final MatchRule FULL = null;
        public static final MatchRule PREFIX = null;
        public static final /* synthetic */ MatchRule[] a = null;

        static {
            MatchRule r1 = new MatchRule("PREFIX", 0);
            PREFIX = r1;
            MatchRule r2 = new MatchRule("FULL", 1);
            FULL = r2;
            a = new MatchRule[]{r1, r2};
        }

        public static MatchRule valueOf(String r1) {
            return (MatchRule) r27.a.a(MatchRule.class, r1);
        }

        public static MatchRule[] values() {
            return (MatchRule[]) a.clone();
        }

        public MatchRule(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/network/impl/interceptor/FuseRequestAdaptorInterceptor$PathPrefixReplaceRule;", "", "fromPath", "", "toPath", "matchRule", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getFromPath", "()Ljava/lang/String;", "getMatchRule", "()I", "getToPath", "component1", "component2", "component3", "copy", "equals", "", PbRequest.SwitchType.OTHER, "hashCode", "toString", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PathPrefixReplaceRule {

        @SerializedName("from")
        private final String fromPath;

        @SerializedName("rule")
        private final int matchRule;

        @SerializedName("to")
        private final String toPath;

        public static /* synthetic */ PathPrefixReplaceRule copy$default(PathPrefixReplaceRule r0, String r1, String r2, int r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.fromPath;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.toPath;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.matchRule;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final String component1() {
            return this.fromPath;
        }

        public final String component2() {
            return this.toPath;
        }

        public final int component3() {
            return this.matchRule;
        }

        public final PathPrefixReplaceRule copy(String r2, String r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "fromPath");
            Intrinsics.checkNotNullParameter(r3, "toPath");
            return new PathPrefixReplaceRule(r2, r3, r4);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof PathPrefixReplaceRule) == false) goto L12;
            PathPrefixReplaceRule r4 = (PathPrefixReplaceRule) r3;
            if (Intrinsics.areEqual(this.fromPath, r4.fromPath) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.toPath, r4.toPath) == true) goto L10;
            return false;
        L10:
            if (this.matchRule == r4.matchRule) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r0 = this.fromPath;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.toPath;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return ((r3 + r1) * 31) + this.matchRule;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "PathPrefixReplaceRule(fromPath=" + this.fromPath + ", toPath=" + this.toPath + ", matchRule=" + this.matchRule + ")";
        }

        public final String getFromPath() {
            return this.fromPath;
        }

        public final int getMatchRule() {
            return this.matchRule;
        }

        public final String getToPath() {
            return this.toPath;
        }

        public PathPrefixReplaceRule(String r2, String r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "fromPath");
            Intrinsics.checkNotNullParameter(r3, "toPath");
            this.fromPath = r2;
            this.toPath = r3;
            this.matchRule = r4;
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/network/impl/interceptor/FuseRequestAdaptorInterceptor$a", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/live/network/impl/interceptor/FuseRequestAdaptorInterceptor$PathPrefixReplaceRule;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<List<? extends PathPrefixReplaceRule>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/network/impl/interceptor/FuseRequestAdaptorInterceptor$b", "Lcom/google/gson/reflect/TypeToken;", "", "", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<List<? extends String>> {
        public b() {
        }
    }

    public FuseRequestAdaptorInterceptor() {
    }

    static {
        j = new FuseRequestAdaptorInterceptor();
        List<String> r0 = CollectionsKt.listOf("/linkmic/battle/end_punish/");
        a = r0;
        b = new SettingKey("live_radical_request_block_list", "", r0, r0);
        c = new SettingKey("live_path_prefix_replace_rule_list", new a().getType(), null);
        List<String> r1 = CollectionsKt.listOf(new String[]{"/webcast/ranklist/audience/", "/webcast/content_open/feed/"});
        d = r1;
        e = new SettingKey("live_request_host_replace_rule_list", "直播完全同构 saas 域名强制映射", r1, r1);
        f = new SettingKey("live_request_host_replace_rule_skip_list", new b().getType(), null);
        MatchRule r3 = MatchRule.FULL;
        MatchRule r2 = MatchRule.PREFIX;
        g = CollectionsKt.listOf(new Triple[]{new Triple("/webcast/openapi/feed/", "/webcast/content_open/feed/", r3), new Triple("/webcast/openapi/room/enter/", "/webcast/room/enter/", r3), new Triple("/webcast/openapi/user/", "/webcast/user/", r3), new Triple("/webcast/openapi/room/in_room_banner/", "/webcast/room/in_room_banner/", r3), new Triple("/webcast/openapi/room/short_touch/", "/webcast/room/short_touch/", r3), new Triple("/webcast/openapi/coin/touch_entrance/", "/webcast/content_open/coin/touch_entrance/", r3), new Triple("/webcast/openapi/lottery/melon/", "/webcast/lottery/melon/", r2), new Triple("/webcast/openapi/show/", "/webcast/show/", r2), new Triple("/webcast/openapi/wallet/info/", "/webcast/wallet/info/", r3), new Triple("/webcast/openapi/v2/wallet/info/", "/webcast/wallet/info/", r3), new Triple("/webcast/openapi/diamond/", "/webcast/diamond/", r3), new Triple("/webcast/openapi/v2/extra/", "/webcast/diamond/extra/", r3), new Triple("/webcast/openapi/v2/first_charge/", "/webcast/diamond/first_charge/", r3), new Triple("/webcast/openapi/v2/wallet/", "/webcast/wallet_api/", r2), new Triple("/webcast/wallet_api/withdrawal_qualification/", "/webcast/openapi/wallet/withdrawal_qualification/", r3)});
        h = CollectionsKt.emptyList();
        i = CollectionsKt.listOf(new String[]{"/webcast/room/latest_bg/", "/webcast/review/get_latest_ban_record/"});
    }

    public static String a(String r14) {
        Intrinsics.checkNotNullParameter(r14, "path");
        Iterator<T> r0 = g.iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        Triple r1 = (Triple) r0.next();
        String r7 = (String) r1.component1();
        String r8 = (String) r1.component2();
        MatchRule r2 = (MatchRule) r1.component3();
        if (r2 != MatchRule.PREFIX) goto L12;
        if (StringsKt.startsWith$default(r14, r7, false, 2, null) == false) goto L12;
        return StringsKt.replaceFirst$default(r14, r7, r8, false, 4, null);
    L12:
        if (r2 != MatchRule.FULL) goto L4;
        if (Intrinsics.areEqual(r14, r7) == false) goto L4;
        return r8;
    L17:
        if (((Boolean) np0.a.getValue()).booleanValue() == false) goto L34;
        List r3 = (List) c.getValue();
        if (r3 == null) goto L34;
        Iterator r4 = r3.iterator();
    L22:
        if (r4.hasNext() == false) goto L34;
        PathPrefixReplaceRule r5 = (PathPrefixReplaceRule) r4.next();
        String r6 = r5.component1();
        String r9 = r5.component2();
        int r10 = r5.component3();
        if (r10 != MatchRule.PREFIX.ordinal()) goto L30;
        if (StringsKt.startsWith$default(r14, r6, false, 2, null) == false) goto L30;
        return StringsKt.replaceFirst$default(r14, r6, r9, false, 4, null);
    L30:
        if (r10 != MatchRule.FULL.ordinal()) goto L22;
        if (Intrinsics.areEqual(r14, r6) == false) goto L22;
        return r9;
    L34:
        int r11 = StringsKt.indexOf$default(r14, "/webcast/openapi/v2/", 0, false, 6, null);
        boolean r12 = true;
        if (r11 < 0) goto L39;
        if (2 < r11) goto L39;
        boolean r13 = true;
    L40:
        Iterable r15 = (Iterable) b.getValue();
        if ((r15 instanceof Collection) == true) goto L43;
    L45:
        Iterator r16 = r15.iterator();
    L47:
        if (r16.hasNext() == false) goto L51;
        if (StringsKt.contains$default(r14, (String) r16.next(), false, 2, null) == false) goto L47;
    L52:
        if (r13 == false) goto L55;
        if (r12 == false) goto L55;
        ALogger.d("aggressive_fuse", "intercept: " + r14 + " will not be mapped, by setting");
    L55:
        if (r13 == false) goto L76;
        if (r12 == false) goto L58;
        return r14;
    L58:
        return StringsKt.replace(r14, "/webcast/openapi/v2/", "/webcast/", false);
    L76:
        return r14;
    L51:
        r12 = false;
        goto L52
    L43:
        if (((Collection) r15).isEmpty() == false) goto L45;
    L39:
        r13 = false;
        goto L40
    }

    public static String b(String r13) {
        Intrinsics.checkNotNullParameter(r13, "url");
        if (((Boolean) np0.a.getValue()).booleanValue() == true) goto L5;
        return r13;
    L5:
        boolean r1 = true;
        if (r13.length() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return r13;
    L11:
        URI r2 = new URI(r13);
        String r3 = r2.getHost();
        IMiddlewareHostNetwork r4 = jc1.k.f(IMiddlewareHostNetwork.class);
        if (r4 == null) goto L14;
        String r6 = r4.getHostDomain();
    L16:
        if (TextUtils.equals(r3, r6) == false) goto L18;
        return r13;
    L18:
        String r7 = r2.getPath();
        List r8 = (List) f.getValue();
        if (r8 == null) goto L26;
        Iterator r9 = r8.iterator();
    L22:
        if (r9.hasNext() == false) goto L26;
        if (StringsKt.startsWith$default(r7, (String) r9.next(), false, 2, null) == false) goto L22;
    L34:
        r1 = false;
    L35:
        if (r1 == true) goto L37;
        return r13;
    L37:
        if (r4 == null) goto L50;
        String r5 = r4.getHostDomain();
        if (TextUtils.isEmpty(r5) == false) goto L41;
        return r13;
    L41:
        if (TextUtils.equals(r3, r5) == true) goto L52;
        String r14 = new URI(r2.getScheme(), r2.getUserInfo(), r5, r2.getPort(), r2.getPath(), r2.getQuery(), r2.getFragment()).toString();
        ALogger.d("aggressive_fuse", "replace host " + r3 + " -> " + r5);
        return r14;
    L52:
        return r13;
    L50:
        return r13;
    L26:
        List r10 = (List) e.getValue();
        if (r10 == null) goto L34;
        Iterator r11 = r10.iterator();
    L30:
        if (r11.hasNext() == false) goto L34;
        if (StringsKt.startsWith$default(r7, (String) r11.next(), false, 2, null) == false) goto L30;
    L14:
        r6 = null;
        goto L16
    L8:
        r0 = false;
        goto L9
    }

    public final SsResponse<?> intercept(Interceptor.Chain r13) {
        Intrinsics.checkNotNullParameter(r13, "chain");
        Request r0 = r13.request();
        String r7 = r0.getPath();
        String r3 = a(r7);
        List<String> r1 = i;
        boolean r10 = true;
        if ((r1 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        if (StringsKt.contains$default(r7, (String) r2.next(), false, 2, null) == false) goto L9;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L17;
        String r5 = StringsKt.replace(r0.getUrl(), "/webcast/", "/webcast/openapi/", false);
    L20:
        String r6 = b(r5);
        if ((!Intrinsics.areEqual(r6, r0.getUrl())) == false) goto L23;
        Request r8 = r0.newBuilder().url(r6).build();
    L25:
        if ((!Intrinsics.areEqual(r6, r0.getUrl())) == false) goto L27;
        ALogger.d("aggressive_fuse", "intercept: " + r8.getPath() + ", <- " + r0.getPath());
    L27:
        Iterator<T> r9 = h.iterator();
    L29:
        if (r9.hasNext() == false) goto L40;
        Pair r11 = (Pair) r9.next();
        String r12 = (String) r11.component1();
        MatchRule r14 = (MatchRule) r11.component2();
        if (r14 != MatchRule.PREFIX) goto L36;
        if (StringsKt.startsWith$default(r7, r12, false, 2, null) == false) goto L36;
    L41:
        if (r10 == false) goto L45;
        LinkedList r15 = new LinkedList(r8.getHeaders());
        CollectionsKt.removeAll(r15, FuseRequestAdaptorInterceptor$removePbHeader$1.INSTANCE);
        Request r16 = r8.newBuilder().headers(r15).build();
        ALogger.d("aggressive_fuse", "intercept removePbFinalRequest: ".concat(r7));
        return r13.proceed(r16);
    L45:
        return r13.proceed(r8);
    L36:
        if (r14 != MatchRule.FULL) goto L29;
        if (Intrinsics.areEqual(r7, r12) == false) goto L29;
    L40:
        r10 = false;
        goto L41
    L23:
        r8 = r0;
        goto L25
    L17:
        if ((!Intrinsics.areEqual(r3, r7)) == false) goto L19;
        r5 = StringsKt.replace$default(r0.getUrl(), r7, r3, false, 4, null);
        goto L20
    L19:
        r5 = r0.getUrl();
    L13:
        r4 = false;
        goto L14
    L5:
        if (r1.isEmpty() == false) goto L7;
        goto L7
    }
}
