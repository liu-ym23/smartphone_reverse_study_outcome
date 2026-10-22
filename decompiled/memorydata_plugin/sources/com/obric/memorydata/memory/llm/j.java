package com.obric.memorydata.memory.llm;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\b\u0002\u0010\u0006\u001a\u00060\u0007j\u0002`\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\n\u0012\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f0\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J \u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\f2\b\b\u0002\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020$2\u0006\u0010&\u001a\u00020\fJ\u0006\u0010*\u001a\u00020\u0003J\u0006\u0010+\u001a\u00020\u0005J\u0006\u0010,\u001a\u00020\fJ\u0006\u0010-\u001a\u00020(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00060\u0007j\u0002`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u001e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 ¨\u0006."}, d2 = {"Lcom/obric/memorydata/memory/llm/Session;", "", OaidModel.KEY_ID, "", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "contentBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "_contentFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_statusFlow", "Lcom/obric/memorydata/memory/llm/SessionStatus;", "keyInfoMap", "", "", "resultStrMemory", "timestamp", "", "<init>", "(Ljava/lang/String;Lcom/obric/capabilitykit/entity/memory/MemoryEntity;Ljava/lang/StringBuilder;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlinx/coroutines/flow/MutableStateFlow;Ljava/util/Map;Ljava/lang/String;J)V", "getKeyInfoMap", "()Ljava/util/Map;", "setKeyInfoMap", "(Ljava/util/Map;)V", "getResultStrMemory", "()Ljava/lang/String;", "setResultStrMemory", "(Ljava/lang/String;)V", "contentFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getContentFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "statusFlow", "getStatusFlow", "updateContent", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "status", "clearContent", "", "updateStatus", "getContent", "getMemoryEntity", "getStatus", "isExpired", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MemoryEntity f10295b;
    private final StringBuilder c;
    private final ae<String> d;
    private final ae<SessionStatus> e;
    private Map<String, ? extends List<String>> f;
    private String g;
    private final long h;
    private final ar<String> i;
    private final ar<SessionStatus> j;

    public j(String r3, MemoryEntity r4, StringBuilder r5, ae<String> r6, ae<SessionStatus> r7, Map<String, ? extends List<String>> r8, String r9, long r10) {
        ae<String> r11 = (ae) ZeusTransformUtils.wrapperContextForParams(r6, ae.class, "com.obric.memorydata.plugin");
        ae<SessionStatus> r12 = (ae) ZeusTransformUtils.wrapperContextForParams(r7, ae.class, "com.obric.memorydata.plugin");
        Map<String, ? extends List<String>> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r4, "memoryEntity");
        Intrinsics.checkNotNullParameter(r5, "contentBuilder");
        Intrinsics.checkNotNullParameter(r11, "_contentFlow");
        Intrinsics.checkNotNullParameter(r12, "_statusFlow");
        Intrinsics.checkNotNullParameter(r13, "keyInfoMap");
        Intrinsics.checkNotNullParameter(r9, "resultStrMemory");
        this.f10294a = r3;
        this.f10295b = r4;
        this.c = r5;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r9;
        this.h = r10;
        this.i = kotlinx.coroutines.flow.k.a(r11);
        this.j = kotlinx.coroutines.flow.k.a(r12);
    }

    public /* synthetic */ j(String r16, MemoryEntity r17, StringBuilder r18, ae r19, ae r20, Map r21, String r22, long r23, int r25, DefaultConstructorMarker r26) {
        ae r1 = (ae) ZeusTransformUtils.wrapperContextForParams(r19, ae.class, "com.obric.memorydata.plugin");
        ae r3 = (ae) ZeusTransformUtils.wrapperContextForParams(r20, ae.class, "com.obric.memorydata.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.memorydata.plugin");
        if ((r25 & 4) == 0) goto L5;
        StringBuilder r8 = new StringBuilder();
    L7:
        if ((r25 & 8) == 0) goto L9;
        r1 = at.a(r8.toString());
    L9:
        ae r9 = r1;
        if ((r25 & 16) == 0) goto L12;
        r3 = at.a(SessionStatus.INITIALIZED);
    L12:
        ae r10 = r3;
        if ((r25 & 32) == 0) goto L15;
        r2 = MapsKt.emptyMap();
    L15:
        Map r11 = r2;
        if ((r25 & 64) == 0) goto L18;
        String r12 = "";
    L20:
        if ((r25 & 128) == 0) goto L22;
        long r13 = System.currentTimeMillis();
    L23:
        this(r16, r17, r8, r9, r10, r11, r12, r13);
        return;
    L22:
        r13 = r23;
        goto L23
    L18:
        r12 = r22;
        goto L20
    L5:
        r8 = r18;
        goto L7
    }

    public static /* synthetic */ void a(j r0, String r1, SessionStatus r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.a(r1, r2, r3);
    }

    public final Map<String, List<String>> a() {
        return this.f;
    }

    public final void a(SessionStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "status");
        if (this.e.c() == r2) goto L6;
        this.e.b(r2);
        return;
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    public final void a(String r3, SessionStatus r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r4, "status");
        boolean r0 = false;
        if (r5 == false) goto L6;
        this.c.setLength(0);
    L6:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L8;
        r0 = true;
    L8:
        if (r0 == false) goto L11;
        this.c.append(r3);
        ae<String> r6 = this.d;
        String r7 = this.c.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        r6.b(r7);
    L11:
        if (this.e.c() == r4) goto L14;
        this.e.b(r4);
        return;
    }

    public final void a(Map<String, ? extends List<String>> r3) {
        Map<String, ? extends List<String>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.f = r4;
    }

    public final String b() {
        return this.g;
    }

    public final ar<String> c() {
        return this.i;
    }

    public final ar<SessionStatus> d() {
        return this.j;
    }

    public final String e() {
        String r2 = this.c.toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    public final MemoryEntity f() {
        return this.f10295b;
    }

    public final SessionStatus g() {
        return (SessionStatus) ZeusTransformUtils.preCheckCast(this.e.c(), SessionStatus.class, "com.obric.memorydata.plugin");
    }

    public final boolean h() {
        if ((System.currentTimeMillis() - this.h) <= 600000) goto L5;
        return true;
    L5:
        return false;
    }
}
