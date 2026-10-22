package com.obric.memorydata.middleware.impl.ttnet;

import android.content.Context;
import android.util.Log;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.d;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J*\u0010\n\u001a\u00020\u000b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u001c\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\rH\u0016J)\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0010\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010 H\u0016¢\u0006\u0002\u0010!J\u001c\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\r2\b\u0010$\u001a\u0004\u0018\u00010\u0010H\u0016J(\u0010%\u001a\u0004\u0018\u00010\r2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010&\u001a\u0004\u0018\u00010\r2\b\u0010'\u001a\u0004\u0018\u00010\rH\u0016J$\u0010(\u001a\u00020\u001a2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010&\u001a\u0004\u0018\u00010\r2\u0006\u0010'\u001a\u00020\u001aH\u0016J(\u0010)\u001a\u00020\u000b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\u0010*\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0002\b\u0003\u0018\u00010+H\u0016J\u0015\u0010,\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010 H\u0016¢\u0006\u0002\u0010-J\n\u0010.\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010/\u001a\u0004\u0018\u00010\rH\u0016J\n\u00100\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u00101\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010+H\u0016J\n\u00102\u001a\u0004\u0018\u00010\rH\u0016J\b\u00103\u001a\u00020\u000bH\u0016J \u00104\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u000105j\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u0001`6H\u0016J\b\u00107\u001a\u00020\u001aH\u0016J\u0016\u00108\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010+H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/memorydata/middleware/impl/ttnet/TTNetDepend;", "Lcom/bytedance/ttnet/ITTNetDepend;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "isCronetPluginInstalled", "", "isPrivateApiAccessEnabled", "mobOnEvent", "", "eventName", "", "labelName", "extraJson", "Lorg/json/JSONObject;", "onNetConfigUpdate", "config", "localData", "onAppConfigUpdated", "ext_json", "onShareCookieConfigUpdated", "shareCookieHosts", "executeGet", XSDatatype.FACET_MAXLENGTH, "", "url", "checkHttpRequestException", "tr", "", "remoteIp", "", "(Ljava/lang/Throwable;[Ljava/lang/String;)I", "monitorLogSend", "logType", "json", "getProviderString", "key", "defaultValue", "getProviderInt", "saveMapToProvider", "map", "", "getConfigServers", "()[Ljava/lang/String;", "getHostSuffix", "getApiIHostPrefix", "getCdnHostSuffix", "getHostReverseMap", "getShareCookieMainDomain", "onColdStartFinish", "getCookieFlushPathList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getAppId", "getTTNetServiceDomainMap", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f11877a;

    public b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.f11877a = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.ttnet.d
    public int a(Context r1, String r2, int r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        return 0;
    }

    @Override // com.bytedance.ttnet.d
    public String a(Context r1, String r2, String r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        return "";
    }

    @Override // com.bytedance.ttnet.d
    public void a(Context r2, String r3, String r4, JSONObject r5) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "labelName");
        Intrinsics.checkNotNullParameter(r5, "extraJson");
        Log.e("tyy", "event: " + r3 + " label: " + r4 + " json: " + r5);
    }

    @Override // com.bytedance.ttnet.d
    public void a(Context r2, Map<String, ?> r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.ttnet.d
    public void a(Context r1, JSONObject r2) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.ttnet.d
    public void a(String r1) {
    }

    @Override // com.bytedance.ttnet.d
    public void a(String r1, JSONObject r2) {
        com.bytedance.apm.a.a(r1, r2);
    }

    @Override // com.bytedance.ttnet.d
    public boolean a() {
        return true;
    }

    @Override // com.bytedance.ttnet.d
    public String[] b() {
        return new String[]{"tnc3-bjlgy.snssdk.com", "tnc3-alisc1.snssdk.com", "tnc3-aliec2.snssdk.com"};
    }

    @Override // com.bytedance.ttnet.d
    public String c() {
        return "snssdk.com";
    }

    @Override // com.bytedance.ttnet.d
    public String d() {
        return "byteimg.com";
    }

    @Override // com.bytedance.ttnet.d
    public String e() {
        return null;
    }

    @Override // com.bytedance.ttnet.d
    public void f() {
    }

    @Override // com.bytedance.ttnet.d
    public ArrayList<String> g() {
        return null;
    }

    @Override // com.bytedance.ttnet.d
    public Context getContext() {
        return this.f11877a;
    }

    @Override // com.bytedance.ttnet.d
    public int h() {
        return AppContext.INSTANCE.getAid();
    }

    @Override // com.bytedance.ttnet.d
    public Map<String, String> i() {
        Map<String, String> r2 = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.memorydata.plugin");
        r2.put(TTNetInit.DOMAIN_HTTPDNS_KEY, "dig.bdurl.net");
        r2.put(TTNetInit.DOMAIN_NETLOG_KEY, "crash.snssdk.com");
        r2.put(TTNetInit.DOMAIN_BOE_KEY, ".boe-gateway.byted.org");
        return r2;
    }
}
