package com.obric.memorydata.personalcontext.poison;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crypto.utils.CryptoConst;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.memorydata.database.backup.appentity.AbstractFakeAppEntity;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fR6\u0010\u0004\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/personalcontext/poison/EntityPoisonContentHasher;", "", "<init>", "()V", "reviewFieldsByEntityType", "Ljava/util/LinkedHashMap;", "", "", "", "Lkotlin/collections/LinkedHashMap;", "calculate", "entity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "entityType", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/google/gson/JsonObject;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12244a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LinkedHashMap<Integer, List<String>> f12245b = null;

    static {
        f12244a = new a();
        f12245b = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to(201, CollectionsKt.listOf(new String[]{ActivityLifecycle.NAME, "note"})), TuplesKt.to(203, CollectionsKt.listOf(ActivityLifecycle.NAME)), TuplesKt.to(202, CollectionsKt.listOf("transcript")), TuplesKt.to(101, CollectionsKt.listOf(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT)), TuplesKt.to(301, CollectionsKt.listOf(new String[]{ActivityLifecycle.NAME, "ocr"})), TuplesKt.to(302, CollectionsKt.listOf(ActivityLifecycle.NAME)), TuplesKt.to(303, CollectionsKt.listOf(ActivityLifecycle.NAME)), TuplesKt.to(601, CollectionsKt.listOf(new String[]{"title", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT})), TuplesKt.to(701, CollectionsKt.listOf(ActivityLifecycle.NAME)), TuplesKt.to(702, CollectionsKt.listOf(AnnotatedPrivateKey.LABEL)), TuplesKt.to(401, CollectionsKt.listOf(new String[]{ActivityLifecycle.NAME, "note"})), TuplesKt.to(501, CollectionsKt.listOf(new String[]{ActivityLifecycle.NAME, "transcript", "summary"})), TuplesKt.to(901, CollectionsKt.listOf(new String[]{"title", "webUrl"})), TuplesKt.to(902, CollectionsKt.listOf(new String[]{"title", "webUrl"})), TuplesKt.to(Integer.valueOf(EntityType.FILE), CollectionsKt.listOf("fileName")), TuplesKt.to(1001, CollectionsKt.listOf(new String[]{"title", "url"})), TuplesKt.to(Integer.valueOf(EntityType.STOCK), CollectionsKt.listOf(ActivityLifecycle.NAME)), TuplesKt.to(Integer.valueOf(EntityType.IM_CONTACT), CollectionsKt.listOf(ActivityLifecycle.NAME)), TuplesKt.to(Integer.valueOf(EntityType.LIFE_LOG), CollectionsKt.listOf(new String[]{Params.CONTENT, "title"})), TuplesKt.to(Integer.valueOf(EntityType.USER_PROFILE), CollectionsKt.listOf(new String[]{"profileKey", "profileValue"})), TuplesKt.to(Integer.valueOf(EntityType.PROACTIVE_MEMORY), CollectionsKt.listOf(new String[]{Params.CONTENT, "title"})), TuplesKt.to(Integer.valueOf(EntityType.MEMORY_COMMON_TEXT), CollectionsKt.listOf(new String[]{"title", MemoryListActivity.JUMP_FROM_DETAIL})), TuplesKt.to(Integer.valueOf(EntityType.MEMORY_INFO_COMMON), CollectionsKt.listOf(new String[]{LocationMonitorConst.TAG, "infoValue"}))});
    }

    private a() {
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r3 & 255)}, 1));
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$4f_phg3c1wzU8ZOPIeGgh-_CB2c, reason: not valid java name */
    public static /* synthetic */ CharSequence m1084lambda$4f_phg3c1wzU8ZOPIeGgh_CB2c(byte r0) {
        return a(r0);
    }

    public final String a(int r11, JsonObject r12) {
        Intrinsics.checkNotNullParameter(r12, AILabCheckPermissionTask.KEY_SOURCE);
        List r10 = (List) ZeusTransformUtils.preCheckCast(f12245b.get(Integer.valueOf(r11)), List.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L6;
        return null;
    L6:
        JsonObject r13 = new JsonObject();
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r14.hasNext() == false) goto L13;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
        JsonElement r2 = r12.get(r1);
        if (r2 != null) goto L12;
        r2 = (JsonElement) ZeusTransformUtils.preCheckCast(JsonNull.INSTANCE, JsonElement.class, "com.obric.memorydata.plugin");
    L12:
        r13.add(r1, r2);
        goto L8
    L13:
        String r15 = r13.toString();
        Intrinsics.checkNotNullExpressionValue(r15, "toString(...)");
        byte[] r16 = r15.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r16, "getBytes(...)");
        byte[] r3 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256).digest(r16);
        Intrinsics.checkNotNullExpressionValue(r3, "digest(...)");
        return ArraysKt.joinToString$default(r3, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$a$4f_phg3c1wzU8ZOPIeGgh_CB2c.INSTANCE, 30, null);
    }

    public final String a(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "entity");
        if (ZeusTransformUtils.instanceOf(r3, AbstractFakeAppEntity.class) == false) goto L5;
        return null;
    L5:
        if (f12245b.containsKey(Integer.valueOf(r3.getType())) == false) goto L11;
        JsonObject r0 = EntityExtKt.getEntityKeepTimeStampGson().toJsonTree(r3).getAsJsonObject();
        int r4 = r3.getType();
        Intrinsics.checkNotNull(r0);
        return a(r4, r0);
    L11:
        return null;
    }
}
