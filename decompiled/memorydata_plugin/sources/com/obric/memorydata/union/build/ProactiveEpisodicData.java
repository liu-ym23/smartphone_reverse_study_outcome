package com.obric.memorydata.union.build;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.memory.api.MemoryBuildApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u009f\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\u0018\b\u0002\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R%\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/obric/memorydata/union/build/ProactiveEpisodicData;", "Lcom/obric/memorydata/union/build/UnionEpisodicData;", "title", "", Params.CONTENT, "contentFrom", "observation", "entityIdList", "", "businessType", "action", ObricMemoryConstants.KEY_SESSION_ID, "schedules", "Lcom/obric/memorydata/memory/api/MemoryBuildApi$Schedule;", LocationMonitorConst.TAG, "keyInfoMap", "", "logId", "poisonLabel", "", "poisonLabelVersion", "modifyTime", "", "sourceInfo", "", "sceneIds", "importantRawRefIds", "sourceRawRefIds", "sourcePackageName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;JLjava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getSchedules", "()Ljava/util/List;", "getTag", "()Ljava/lang/String;", "getKeyInfoMap", "()Ljava/util/Map;", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveEpisodicData extends UnionEpisodicData {
    private final Map<String, List<String>> keyInfoMap;
    private final List<MemoryBuildApi.Schedule> schedules;
    private final String tag;

    public ProactiveEpisodicData(String r34, String r35, String r36, String r37, List<String> r38, String r39, String r40, String r41, List<MemoryBuildApi.Schedule> r42, String r43, Map<String, ? extends List<String>> r44, String r45, Integer r46, Integer r47, long r48, Map<String, ? extends Object> r50, List<String> r51, List<String> r52, List<String> r53, List<String> r54) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r38, List.class, "com.obric.memorydata.plugin");
        List<MemoryBuildApi.Schedule> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r42, List.class, "com.obric.memorydata.plugin");
        Map<String, List<String>> r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r44, Map.class, "com.obric.memorydata.plugin");
        Map r23 = (Map) ZeusTransformUtils.wrapperContextForParams(r50, Map.class, "com.obric.memorydata.plugin");
        List r24 = (List) ZeusTransformUtils.wrapperContextForParams(r51, List.class, "com.obric.memorydata.plugin");
        List r25 = (List) ZeusTransformUtils.wrapperContextForParams(r52, List.class, "com.obric.memorydata.plugin");
        List r26 = (List) ZeusTransformUtils.wrapperContextForParams(r53, List.class, "com.obric.memorydata.plugin");
        List r27 = (List) ZeusTransformUtils.wrapperContextForParams(r54, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r34, "title");
        Intrinsics.checkNotNullParameter(r35, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r36, "contentFrom");
        Intrinsics.checkNotNullParameter(r37, "observation");
        Intrinsics.checkNotNullParameter(r39, "businessType");
        Intrinsics.checkNotNullParameter(r40, "action");
        super(r34, r35, r36, r37, r5, r39, r40, r41, r45, r46, r47, null, null, null, null, null, null, null, null, null, Long.valueOf(r48), null, r23, r24, r25, r26, r27, null, 137361408, null);
        this.schedules = r14;
        this.tag = r43;
        this.keyInfoMap = r15;
    }

    public /* synthetic */ ProactiveEpisodicData(String r26, String r27, String r28, String r29, List r30, String r31, String r32, String r33, List r34, String r35, Map r36, String r37, Integer r38, Integer r39, long r40, Map r42, List r43, List r44, List r45, List r46, int r47, DefaultConstructorMarker r48) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.memorydata.plugin");
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r36, Map.class, "com.obric.memorydata.plugin");
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r42, Map.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r43, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r44, List.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r45, List.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r46, List.class, "com.obric.memorydata.plugin");
        if ((r47 & 128) == 0) goto L5;
        String r11 = null;
    L7:
        if ((r47 & 256) == 0) goto L9;
        List r12 = null;
    L11:
        if ((r47 & 512) == 0) goto L13;
        String r13 = null;
    L15:
        if ((r47 & 1024) == 0) goto L17;
        Map r14 = null;
    L19:
        if ((r47 & 2048) == 0) goto L21;
        String r15 = null;
    L23:
        if ((r47 & 4096) == 0) goto L25;
        Integer r16 = null;
    L27:
        if ((r47 & 8192) == 0) goto L29;
        Integer r17 = null;
    L31:
        if ((r47 & 16384) == 0) goto L33;
        long r18 = System.currentTimeMillis();
    L35:
        if ((32768 & r47) == 0) goto L37;
        Map r20 = null;
    L39:
        if ((65536 & r47) == 0) goto L41;
        List r21 = null;
    L43:
        if ((131072 & r47) == 0) goto L45;
        List r22 = null;
    L47:
        if ((262144 & r47) == 0) goto L49;
        List r23 = null;
    L51:
        if ((r47 & 524288) == 0) goto L53;
        List r24 = null;
    L54:
        this(r26, r27, r28, r29, r8, r31, r32, r11, r12, r13, r14, r15, r16, r17, r18, r20, r21, r22, r23, r24);
        return;
    L53:
        r24 = r2;
        goto L54
    L49:
        r23 = r7;
        goto L51
    L45:
        r22 = r6;
        goto L47
    L41:
        r21 = r5;
        goto L43
    L37:
        r20 = r4;
        goto L39
    L33:
        r18 = r40;
        goto L35
    L29:
        r17 = r39;
        goto L31
    L25:
        r16 = r38;
        goto L27
    L21:
        r15 = r37;
        goto L23
    L17:
        r14 = r3;
        goto L19
    L13:
        r13 = r35;
        goto L15
    L9:
        r12 = r1;
        goto L11
    L5:
        r11 = r33;
        goto L7
    }

    public final Map<String, List<String>> getKeyInfoMap() {
        return this.keyInfoMap;
    }

    public final List<MemoryBuildApi.Schedule> getSchedules() {
        return this.schedules;
    }

    public final String getTag() {
        return this.tag;
    }
}
