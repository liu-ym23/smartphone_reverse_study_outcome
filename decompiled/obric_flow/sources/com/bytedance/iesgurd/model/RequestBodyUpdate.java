package com.bytedance.iesgurd.model;

import android.util.Pair;
import androidx.annotation.Keep;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.n;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.meta.e;
import com.bytedance.iesgurd.meta.f;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.google.gson.annotations.SerializedName;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.utils.j;
import df.b;
import df.c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 )2\u00020\u0001:\u0002*+B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u001f\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\bJ1\u0010\u0012\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0012\u0010\u0018J\r\u0010\u0019\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001d\u001a \u0012\u0004\u0012\u00020\n\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\u001c0\u00100\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010 \u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\u001f0\u001f¢\u0006\u0004\b \u0010\u001eR.\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020!0\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u001e\"\u0004\b%\u0010&R,\u0010(\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020'0\u001f0\u001f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b(\u0010#¨\u0006,"}, d2 = {"Lcom/bytedance/iesgurd/model/RequestBodyUpdate;", "Lcom/bytedance/iesgurd/model/RequestBodyBase;", "Lcom/bytedance/iesgurd/core/ReqType;", "reqType", "<init>", "(Lcom/bytedance/iesgurd/core/ReqType;)V", "", "initLocalVersion", "()V", "initLocalVersionByDeployments", "", "accessKey", LynxMonitorService.KEY_CHANNEL, "", "getLocalVersion", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "", "accessKeys", "initCustom", "(Ljava/util/List;)V", "Lcom/bytedance/geckox/n;", LynxResourceModule.PARAMS_KEY, "Lcom/bytedance/geckox/OptionCheckUpdateParams;", "oldParams", "(Ljava/util/List;Lcom/bytedance/geckox/n;Lcom/bytedance/geckox/OptionCheckUpdateParams;)V", "getSortedDeployments", "()Ljava/lang/String;", "", "Landroid/util/Pair;", "getRequestMap", "()Ljava/util/Map;", "", "getLocalVersions", "Lcom/bytedance/iesgurd/model/DeploymentsData;", "deployments", "Ljava/util/Map;", "getDeployments", "setDeployments", "(Ljava/util/Map;)V", "Lcom/bytedance/iesgurd/model/RequestBodyUpdate$LocalData;", "local", "Companion", "com/bytedance/iesgurd/model/a", "LocalData", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class RequestBodyUpdate extends RequestBodyBase {
    public static final a Companion = null;
    private static final ConcurrentHashMap<String, Boolean> checkDirFinish = null;

    @SerializedName("deployments")
    private Map<String, DeploymentsData> deployments;

    @SerializedName("local")
    private final Map<String, Map<String, LocalData>> local;

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/iesgurd/model/RequestBodyUpdate$LocalData;", "", "()V", "availableMetaId", "", "getAvailableMetaId", "()Ljava/lang/Long;", "setAvailableMetaId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "forbidden", "", "getForbidden", "()Ljava/lang/Integer;", "setForbidden", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "hashVersion", "", "getHashVersion", "()Ljava/lang/String;", "setHashVersion", "(Ljava/lang/String;)V", "prepareMetaId", "getPrepareMetaId", "setPrepareMetaId", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    public static final class LocalData {

        @SerializedName("available_meta_id")
        private Long availableMetaId;

        @SerializedName("forbidden")
        private Integer forbidden;

        @SerializedName("hash_version")
        private String hashVersion;

        @SerializedName("prepare_meta_id")
        private Long prepareMetaId;

        public LocalData() {
            this.hashVersion = "";
        }

        public final Long getAvailableMetaId() {
            return this.availableMetaId;
        }

        public final Integer getForbidden() {
            return this.forbidden;
        }

        public final String getHashVersion() {
            return this.hashVersion;
        }

        public final Long getPrepareMetaId() {
            return this.prepareMetaId;
        }

        public final void setAvailableMetaId(Long r5) {
            this.availableMetaId = r5;
        }

        public final void setForbidden(Integer r5) {
            this.forbidden = r5;
        }

        public final void setHashVersion(String r5) {
            this.hashVersion = r5;
        }

        public final void setPrepareMetaId(Long r5) {
            this.prepareMetaId = r5;
        }
    }

    static {
        Companion = new a();
        checkDirFinish = new ConcurrentHashMap();
    }

    public RequestBodyUpdate(ReqType r5) {
        super(r5);
        this.deployments = new HashMap();
        this.local = new HashMap();
        if (r5 == ReqType.BYTESYNC) goto L6;
        initLocalVersion();
        return;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getCheckDirFinish$cp() {
        return checkDirFinish;
    }

    public static /* synthetic */ void initCustom$default(RequestBodyUpdate r5, List r10, n r11, OptionCheckUpdateParams r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = null;
    L5:
        r5.initCustom(r10, r11, r12);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private final void initLocalVersion() {
        ConcurrentHashMap r5 = c.d;
        List r10 = b.f16647h.a();
        Iterator r11 = r5.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L52;
        String r12 = (String) r11.next();
        if (r10 == null) goto L10;
        if (r10.contains(r12) == true) goto L4;
    L10:
        HashMap r13 = new HashMap();
        Map r14 = (Map) f.f6652a.get(r12);
        if (r14 == null) goto L16;
        Iterator r15 = r14.entrySet().iterator();
    L14:
        if (r15.hasNext() == false) goto L16;
        Map.Entry r16 = (Map.Entry) r15.next();
        LocalData r17 = new LocalData();
        r17.setPrepareMetaId(Long.valueOf(((PrepareMeta) r16.getValue()).getVersion()));
        r17.setHashVersion(((PrepareMeta) r16.getValue()).getHashVersion());
        r13.put(r16.getKey(), r17);
    L16:
        ConcurrentHashMap<String, Boolean> r18 = checkDirFinish;
        Boolean r19 = r18.get(r12);
        Boolean r20 = Boolean.TRUE;
        if (Intrinsics.areEqual(r19, r20) == true) goto L19;
        r18.put(r12, r20);
        boolean r21 = true;
    L20:
        File r22 = new File((String) r5.get(r12), r12);
        Map r23 = (Map) e.f6651c.get(r12);
        if (r23 == null) goto L49;
        Iterator r24 = r23.entrySet().iterator();
    L24:
        if (r24.hasNext() == false) goto L49;
        Map.Entry r25 = (Map.Entry) r24.next();
        String r110 = (String) r25.getKey();
        Long r111 = ((ChannelMeta) r25.getValue()).getId();
        if (r111 == null) goto L24;
        long r112 = r111.longValue();
        if (r21 == false) goto L42;
        if (new File(new File(r22, r110), String.valueOf(r112)).exists() == true) goto L42;
        EventSubType r113 = EventSubType.f6604k;
        String r26 = r25.toString();
        JSONObject r114 = new JSONObject();
        r114.put("sub_type", r113.f6615a);
        if (r12 == null) goto L34;
        r114.put("access_key", r12);
    L34:
        if (r110 == null) goto L36;
        r114.put("channels", r110);
    L36:
        if (r26 == null) goto L39;
        r114.put("err_msg", r26);
    L39:
        if (0 == 0) goto L41;
        r114.put("duration", 0);
    L41:
        j.g("geckosdk_event_message", r114);
        e.g(r12, r110);
    L42:
        LocalData r115 = (LocalData) r13.get(r110);
        if (r115 != null) goto L45;
        r115 = new LocalData();
        r13.put(r110, r115);
    L45:
        r115.setAvailableMetaId(r111);
        if (((ChannelMeta) r25.getValue()).getForbidden() == false) goto L24;
        r115.setForbidden(1);
    L49:
        if (r13.isEmpty() == true) goto L4;
        this.local.put(r12, r13);
        goto L4
    L19:
        r21 = false;
        goto L20
    }

    public final Map<String, DeploymentsData> getDeployments() {
        return this.deployments;
    }

    public final Long getLocalVersion(String r5, String r10) {
        Map<String, LocalData> r11 = this.local.get(r5);
        if (r11 == null) goto L8;
        LocalData r12 = r11.get(r10);
        if (r12 != null) goto L7;
        return null;
    L7:
        return r12.getAvailableMetaId();
    L8:
        return null;
    }

    public final Map<String, Map<String, Long>> getLocalVersions() {
        HashMap r5 = new HashMap();
        Iterator<Map.Entry<String, Map<String, LocalData>>> r10 = this.local.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L14;
        Map.Entry<String, Map<String, LocalData>> r11 = r10.next();
        r5.put(r11.getKey(), new HashMap());
        Iterator<Map.Entry<String, LocalData>> r12 = r11.getValue().entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L4;
        Map.Entry<String, LocalData> r13 = r12.next();
        Long r14 = r13.getValue().getAvailableMetaId();
        if (r14 == null) goto L7;
        long r15 = r14.longValue();
        Object r16 = r5.get(r11.getKey());
        if (r16 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        ((Map) r16).put(r13.getKey(), Long.valueOf(r15));
        goto L7
    L14:
        return r5;
    }

    public final Map<String, List<Pair<String, Long>>> getRequestMap() {
        HashMap r5 = new HashMap();
        Iterator<Map.Entry<String, Map<String, LocalData>>> r10 = this.local.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L13;
        Map.Entry<String, Map<String, LocalData>> r11 = r10.next();
        ArrayList r12 = new ArrayList();
        Iterator<Map.Entry<String, LocalData>> r13 = r11.getValue().entrySet().iterator();
    L7:
        if (r13.hasNext() == false) goto L11;
        Map.Entry<String, LocalData> r14 = r13.next();
        Long r15 = r14.getValue().getAvailableMetaId();
        if (r15 == null) goto L7;
        long r16 = r15.longValue();
        r12.add(new Pair(r14.getKey(), Long.valueOf(r16)));
        goto L7
    L11:
        r5.put(r11.getKey(), CollectionsKt.toList(r12));
        goto L4
    L13:
        return MapsKt.toMap(r5);
    }

    public final String getSortedDeployments() {
        StringBuilder r5 = new StringBuilder();
        Iterator r10 = CollectionsKt.sorted(this.deployments.keySet()).iterator();
    L4:
        if (r10.hasNext() == false) goto L11;
        String r11 = (String) r10.next();
        StringBuilder r12 = new StringBuilder();
        r12.append(r11);
        r12.append('-');
        DeploymentsData r13 = this.deployments.get(r11);
        if (r13 == null) goto L8;
        String r14 = r13.getSortString();
    L9:
        r12.append(r14);
        r5.append(r12.toString());
        goto L4
    L8:
        r14 = null;
        goto L9
    L11:
        return r5.toString();
    }

    public final void initCustom(List<String> r10, n r11, OptionCheckUpdateParams r12) {
        ConcurrentHashMap r5 = df.e.f16655b;
        c.f16652i.a();
        GeckoGlobalConfig r13 = c.f;
        Iterator<String> r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L33;
        String r15 = r14.next();
        HashMap r16 = new HashMap();
        ConcurrentHashMap r17 = (ConcurrentHashMap) r5.get(r15);
        if (r17 == null) goto L11;
        Iterator r18 = r17.entrySet().iterator();
    L9:
        if (r18.hasNext() == false) goto L11;
        Map.Entry r19 = (Map.Entry) r18.next();
        r16.put(r19.getKey(), r19.getValue());
    L11:
        CharSequence r20 = (CharSequence) r16.get("business_version");
        if (r20 != null) goto L14;
    L15:
        if (r13 == null) goto L17;
        r16.put("business_version", r13.getAppVersion());
    L17:
        if (r11 == null) goto L19;
        String r21 = r11.g;
    L21:
        if (Intrinsics.areEqual(r15, r21) == false) goto L23;
        r11.getClass();
    L23:
        if (r12 == null) goto L32;
        Map<String, Map<String, Object>> r22 = r12.getCustomParam();
        if (r22 == null) goto L32;
        Map<String, Object> r23 = r22.get(r15);
        if (r23 == null) goto L32;
        Iterator<Map.Entry<String, Object>> r24 = r23.entrySet().iterator();
    L30:
        if (r24.hasNext() == false) goto L32;
        Map.Entry<String, Object> r25 = r24.next();
        r16.put(r25.getKey(), r25.getValue().toString());
    L32:
        getCustom().put(r15, r16);
        goto L4
    L19:
        r21 = null;
        goto L21
    L14:
        if (r20.length() != 0) goto L17;
    }

    public final void initLocalVersionByDeployments() {
        List r5 = b.f16647h.a();
        Iterator<String> r10 = this.deployments.keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L35;
        String r11 = r10.next();
        if (r5 == null) goto L10;
        if (r5.contains(r11) == true) goto L4;
    L10:
        HashMap r12 = new HashMap();
        DeploymentsData r13 = this.deployments.get(r11);
        if (r13 == null) goto L33;
        List<String> r14 = r13.getChannels();
        if (r14 == null) goto L33;
        Iterator<T> r15 = r14.iterator();
    L16:
        if (r15.hasNext() == false) goto L33;
        String r16 = (String) r15.next();
        LocalData r17 = new LocalData();
        PrepareMeta r18 = f.a(r11, r16);
        boolean r19 = true;
        if (r18 == null) goto L20;
        r17.setPrepareMetaId(Long.valueOf(r18.getVersion()));
        r17.setHashVersion(r18.getHashVersion());
        boolean r20 = true;
    L21:
        ChannelMeta r21 = e.a(r11, r16);
        if (r21 == null) goto L24;
        Long r110 = r21.getId();
    L25:
        if (r110 == null) goto L29;
        r17.setAvailableMetaId(r21.getId());
        if (r21.getForbidden() == false) goto L30;
        r17.setForbidden(1);
    L30:
        if (r19 == false) goto L16;
        r12.put(r16, r17);
        goto L16
    L29:
        r19 = r20;
        goto L30
    L24:
        r110 = null;
        goto L25
    L20:
        r20 = false;
    L33:
        if (r12.isEmpty() == true) goto L4;
        this.local.put(r11, r12);
        goto L4
    }

    public final void setDeployments(Map<String, DeploymentsData> r5) {
        this.deployments = r5;
    }

    public final void initCustom(List<String> r10) {
        initCustom$default(this, r10, null, null, 4, null);
    }

    public final void initCustom() {
        initCustom$default(this, CollectionsKt.toList(c.d.keySet()), null, null, 4, null);
    }
}
