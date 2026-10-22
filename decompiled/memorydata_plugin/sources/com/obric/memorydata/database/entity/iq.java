package com.obric.memorydata.database.entity;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.plugin.R;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a\n\u0010\n\u001a\u00020\u0002*\u00020\u0002\u001a\n\u0010\u000b\u001a\u00020\u0002*\u00020\u0002\u001a\n\u0010\f\u001a\u00020\r*\u00020\u000e\u001a\f\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\r\u001a\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u001a\u0012\u0010\u0014\u001a\u00020\u0010*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0012\"'\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004\"'\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004\"\u000e\u0010\u0013\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"unionSemanticTypeZhToEn", "", "", "getUnionSemanticTypeZhToEn", "()Ljava/util/Map;", "unionSemanticTypeZhToEn$delegate", "Lkotlin/Lazy;", "unionSemanticTypeEnToZh", "getUnionSemanticTypeEnToZh", "unionSemanticTypeEnToZh$delegate", "mapUnionSemanticTypeToEn", "mapUnionSemanticTypeToZh", "toMemoryEntityDirect", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "toUnionSemanticMemoryEntity", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "evidenceCount", "", "PROACTIVE_SEMANTIC_DESCRIPTION", "toRawMemoryEntity", "memoryProductType", "database_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class iq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Lazy f9233a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f9234b = null;

    static {
        f9233a = LazyKt.lazy($$Lambda$iq$Q8TvqvxgcK9hgUgUZJxb97LlYw.INSTANCE);
        f9234b = LazyKt.lazy($$Lambda$iq$CeAMPRraVw76gisdjE01Shifc2o.INSTANCE);
    }

    public static final MemoryEntity a(ip r15) {
        Intrinsics.checkNotNullParameter(r15, "<this>");
        List<fa> r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveSemanticRelevantDataDao().queryByMemoryId(r15.getEntityId());
        String r9 = b(r15.a());
        String r10 = r15.c();
        String r13 = r15.b();
        String r11 = r15.d();
        String r12 = r15.f();
        long r4 = r15.getCreateTime();
        fa r1 = (fa) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r0), fa.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        int r2 = r1.i();
    L6:
        long r6 = r15.getModifyTime();
        InfoCommonMemoryEntity r3 = new InfoCommonMemoryEntity(r15.getEntityId(), r4, r6, r2, r9, r10, r11, r12, r13);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L9;
        fa r5 = (fa) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r0), fa.class, "com.obric.memorydata.plugin");
        r3.setSourceQuery(r5.c());
        r3.setSourceText(r5.d());
        r3.setScreenshot(com.obric.memorydata.personalcontext.util.f.c(r5.e()));
        r3.setDetailStatus(r5.h());
        r3.setSourcePackageName(r5.g());
        r3.setSourceAppName(r5.f());
    L9:
        r3.setUuid(r15.getUuid());
        r3.setDetail(null);
        r3.set_packageName(r15.getPackageName());
        r3.setDetailStatus(0);
        r3.setEvidenceCount(r15.h());
        r3.setConfidence(r15.l());
        r3.setUserEdit(r15.g());
        r3.setLogId(r15.m());
        return (MemoryEntity) ZeusTransformUtils.preCheckCast(r3, MemoryEntity.class, "com.obric.memorydata.plugin");
    L5:
        r2 = r15.i();
        goto L6
    }

    public static final RawMemoryEntity a(ip r54, int r55) {
        Intrinsics.checkNotNullParameter(r54, "<this>");
        String r3 = r54.getEntityId();
        long r4 = r54.getCreateTime();
        long r6 = r54.getModifyTime();
        long r9 = r54.getTimestamp();
        String r11 = r54.getPackageName();
        int r12 = r54.getHashCodeValue();
        String r13 = r54.getUuid();
        String r26 = b(r54.a());
        String r27 = r54.c();
        String r28 = r54.d();
        String r29 = r54.f();
        String r30 = r54.b();
        String r46 = r54.d();
        boolean r49 = r54.g();
        return new RawMemoryEntity(0, r3, r4, r6, 0, r9, r11, r12, r13, EntityType.MEMORY_INFO_COMMON, r55, null, null, null, null, null, null, null, null, null, null, r26, r27, r28, r29, r30, null, null, null, null, null, null, null, null, null, null, null, null, null, r54.m(), null, r46, 0, null, r49, -66062319, 2431, null);
    }

    public static final ip a(MemoryEntity r47) {
        Intrinsics.checkNotNullParameter(r47, "<this>");
        if (ZeusTransformUtils.instanceOf(r47, InfoCommonMemoryEntity.class) == false) goto L5;
        InfoCommonMemoryEntity r1 = (InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r47, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        String r3 = r1.getInfoValue();
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        String r8 = r47.getId();
        long r9 = r47.getCreateTime();
        long r11 = r47.getLastModifiedTime();
        String r5 = r47.get_packageName();
        if (r5 != null) goto L14;
        String r16 = "";
    L15:
        String r18 = r47.getUuid();
        String r19 = a(((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r47, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getInfoKey());
        String r2 = r1.getTag();
        if (r2 != null) goto L18;
        String r20 = "";
    L19:
        String r23 = r3 + " 用户主动记忆";
        String r4 = r1.getRelatedMemoryids();
        if (r4 != null) goto L22;
        String r24 = "";
    L24:
        return new ip(0, r8, r9, r11, NetError.ERR_CACHE_READ_FAILURE, 0, r16, 0, r18, r19, r20, r3, "用户主动记忆", r23, r24, r47.getUserEdit(), 0, 1003, false, false, 4.0f, null, null, null, null, null, 0, "none", 1, null, null, 0, -404750303, null);
    L22:
        r24 = r4;
        goto L24
    L18:
        r20 = r2;
        goto L19
    L14:
        r16 = r5;
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    public static final ip a(RawMemoryEntity r44, int r45) {
        Intrinsics.checkNotNullParameter(r44, "<this>");
        if (r44.getMemoryType() == 10105) goto L6;
        return null;
    L6:
        String r0 = r44.getKey2();
        if (r0 != null) goto L9;
        r0 = "";
    L9:
        String r3 = r44.getKey1();
        if (r3 == null) goto L15;
        String r4 = a(r3);
        if (r4 == null) goto L15;
        String r17 = r4;
    L16:
        String r5 = r44.getKey5();
        if (r5 != null) goto L19;
        String r18 = "";
    L20:
        String r6 = r44.getKey4();
        if (r6 != null) goto L23;
        String r22 = "";
    L24:
        boolean r23 = r44.getUserEdit();
        if (r45 >= 1) goto L27;
        int r24 = 1;
    L29:
        return new ip(0, r44.getEntityId(), r44.getCreateTime(), r44.getModifyTime(), NetError.ERR_CACHE_READ_FAILURE, r44.getTimestamp(), r44.getPackageName(), r44.getHashCodeValue(), r44.getUuid(), r17, r18, r0, "用户主动记忆", r0 + " 用户主动记忆", r22, r23, r24, 1003, false, false, 4.0f, r44.getLogId(), null, null, null, null, 0, "none", 1, null, null, 0, -406847487, null);
    L27:
        r24 = r45;
        goto L29
    L23:
        r22 = r6;
        goto L24
    L19:
        r18 = r5;
    L15:
        r17 = "";
        goto L16
    }

    public static /* synthetic */ ip a(RawMemoryEntity r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 1;
    L6:
        return a(r0, r1);
    }

    public static final String a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        String r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r4;
    L8:
        String r1 = (String) ZeusTransformUtils.preCheckCast(a().get(r4), String.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L12;
        return r4;
    L12:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    private static final Map<String, String> a() {
        return (Map) ZeusTransformUtils.preCheckCast(f9233a.getValue(), Map.class, "com.obric.memorydata.plugin");
    }

    public static final String b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r5;
    L8:
        Map<String, String> r1 = b();
        String r2 = r5.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r2, "toLowerCase(...)");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.get(r2), String.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L12;
        return r5;
    L12:
        return r3;
    L5:
        r0 = false;
        goto L6
    }

    private static final Map<String, String> b() {
        return (Map) ZeusTransformUtils.preCheckCast(f9234b.getValue(), Map.class, "com.obric.memorydata.plugin");
    }

    private static final Map c() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.union_semantic_type_hobbies_and_interests, TypedValues.Custom.S_STRING, "union_semantic_type_hobbies_and_interests")), "interests"), TuplesKt.to(com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.union_semantic_type_preferences, TypedValues.Custom.S_STRING, "union_semantic_type_preferences")), "preference"), TuplesKt.to(com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.union_semantic_type_personal_info, TypedValues.Custom.S_STRING, "union_semantic_type_personal_info")), "userinfo"), TuplesKt.to(com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.union_semantic_type_social_relationships, TypedValues.Custom.S_STRING, "union_semantic_type_social_relationships")), "relationship"), TuplesKt.to("选择偏好", "preference"), TuplesKt.to("選擇偏好", "preference")});
    }

    private static final Map d() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("interests", com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.union_semantic_type_hobbies_and_interests, TypedValues.Custom.S_STRING, "union_semantic_type_hobbies_and_interests"))), TuplesKt.to("preference", com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.union_semantic_type_preferences, TypedValues.Custom.S_STRING, "union_semantic_type_preferences"))), TuplesKt.to("userinfo", com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.union_semantic_type_personal_info, TypedValues.Custom.S_STRING, "union_semantic_type_personal_info"))), TuplesKt.to("relationship", com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.union_semantic_type_social_relationships, TypedValues.Custom.S_STRING, "union_semantic_type_social_relationships")))});
    }

    public static /* synthetic */ Map lambda$CeAMPRraVw76gisdjE01Shifc2o() {
        return d();
    }

    /* JADX INFO: renamed from: lambda$Q8Tvqvxgc-K9hgUgUZJxb97LlYw, reason: not valid java name */
    public static /* synthetic */ Map m556lambda$Q8TvqvxgcK9hgUgUZJxb97LlYw() {
        return c();
    }
}
