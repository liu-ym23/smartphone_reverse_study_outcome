package com.bytedance.ies.abmock.fetch;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004J\u000e\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020 J\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040*J\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040*2\u0006\u0010!\u001a\u00020\u0004J\b\u0010,\u001a\u0004\u0018\u00010\u0004J\b\u0010-\u001a\u0004\u0018\u00010\u0004J\u0006\u0010.\u001a\u00020'J\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040*2\u0006\u0010&\u001a\u00020'J\u0006\u00100\u001a\u00020'J\u0006\u00101\u001a\u00020'J\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040*J\u0006\u00103\u001a\u000204J\u0016\u00105\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004J\u000e\u00106\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0004J\u000e\u00107\u001a\u00020 2\u0006\u00108\u001a\u00020'J\u000e\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020'J\u0014\u0010;\u001a\u00020 2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00040*J\u001c\u0010=\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00040*J\u0014\u0010=\u001a\u00020 2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00040*J\u000e\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020\u0004J\u000e\u0010A\u001a\u00020 2\u0006\u0010B\u001a\u00020\u0004J\u000e\u0010C\u001a\u00020 2\u0006\u0010D\u001a\u00020'J\u001c\u0010E\u001a\u00020 2\u0006\u0010&\u001a\u00020'2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00040*J\u0006\u0010G\u001a\u00020 J\u0014\u0010H\u001a\u00020 2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00040*R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R#\u0010\u0017\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u0018\u0010\nR\u000e\u0010\u001a\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/bytedance/ies/abmock/fetch/FetchKeva;", "", "()V", "cdnFileUrlsKey", "", "cdnFileUrlsNamespaceKey", "configKeva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getConfigKeva", "()Lcom/bytedance/keva/Keva;", "configKeva$delegate", "Lkotlin/Lazy;", "configRepoName", "currentHashCheckCountKey", "fetchAbRequestCode", "fetchAbRequestCodeKey", "fetchConfigByGroupInfoIndexPrefixKey", "fetchConfigByGroupInfoKey", "fetchConfigByGroupOriginalJsonKey", "fetchRequestType", "fetchRequestTypeKey", "groupHashKey", "groupInfoKeva", "getGroupInfoKeva", "groupInfoKeva$delegate", "groupInfoRepo", "groupKeySetKey", "groupNumberKey", "isFirstLaunchKey", LocationMonitorConst.TAG, "appendCDNFileUrl", "", "nameSpace", "url", "appendCDNFileUrlNamespace", "namespace", "clearKeysByIndex", "groupIndex", "", "eraseGroupOriginalJson", "getCDNFileUrlNamespaceSet", "", "getCDNFileUrlSet", "getGroupInfo", "getGroupOriginalJson", "getHashCheckCount", "getKeysByIndex", "getRequestCode", "getRequestType", "getWhiteList", "isFirstLaunch", "", "removeCDNFileUrl", "removeCDNFileUrlNamespace", "setRequestCode", "status", "setRequestType", "type", "storeCDNFileUrlNamespaceSet", "namespaceSet", "storeCDNFileUrlSet", "urls", "storeGroupInfo", "groupInfo", "storeGroupOriginalJson", "groupOriginalJson", "storeHashCheckCount", CommonConsts.COUNT_TYPE, "storeKeysByIndex", "keys", "storeLaunch", "storeWhiteList", "whiteList", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2748b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private final Lazy q;
    private final String r;
    private final Lazy s;

    public e() {
        this.f2747a = "FetchKeva";
        this.f2748b = "is_fetch_launch";
        this.c = "fetch_config_by_group_info";
        this.d = "fetch_request_type";
        this.e = "fetch_config_by_group_info_index_";
        this.f = "fetch_config_by_group_original_json";
        this.g = "cdn_file_url_set";
        this.h = "cdn_file_url_namespace_set";
        this.i = "current_hash_check_count";
        this.j = "fetch_ab_request_code";
        this.k = "group_num";
        this.l = "group_hash";
        this.m = "group_key_";
        this.n = "fetch_request_type";
        this.o = "fetch_ab_request_code";
        this.p = "ABMOCK_FETCH_COMMON_KEVA";
        this.q = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new FetchKeva$groupInfoKeva$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.r = "CONFIG_ABMOCK_FETCH_COMMON_KEVA";
        this.s = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new FetchKeva$configKeva$2(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ String a(e r0) {
        return r0.p;
    }

    public static final /* synthetic */ String b(e r0) {
        return r0.r;
    }
}
