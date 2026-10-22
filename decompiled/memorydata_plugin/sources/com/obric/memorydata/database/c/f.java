package com.obric.memorydata.database.c;

import com.bytedance.crash.entity.EventBody;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.dao.UnionSemanticMemorySnapShotDao;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.fa;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.entity.iu;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0014\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\u0014\u0010\u0011\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\nJ\u0014\u0010\u0013\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\nJ\u0006\u0010\u0016\u001a\u00020\u0005J\u0014\u0010\u0017\u001a\u00020\u0005*\u00020\u00182\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0001H\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0015H\u0002J\u0014\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010\"\u001a\u00020\u00012\b\u0010#\u001a\u0004\u0018\u00010\u0015H\u0002¨\u0006$"}, d2 = {"Lcom/obric/memorydata/database/review/UnionSemanticMemorySnapshotSync;", "", "<init>", "()V", "insertSnapshot", "", "entity", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "insertSnapshots", "entities", "", "attachRelevantDataToLatestSnapshot", "relevantData", "Lcom/obric/memorydata/database/entity/ProactiveSemanticRelevantData;", "deleteByUnionSemanticMemoryId", "unionSemanticMemoryId", "", "deleteByUnionSemanticMemoryIds", "unionSemanticMemoryIds", "deleteByEntityIds", "entityIds", "", "deleteAll", "putReviewSourceFields", "Lorg/json/JSONObject;", "reviewSourceType", "reviewSourceEvidence", "Lorg/json/JSONArray;", "sourceScreenshot", "parseSnapshotJson", "snapshotJson", "hasSameReviewContent", "", "Lcom/obric/memorydata/database/entity/UnionSemanticMemorySnapShotEntity;", "parseJsonValueOrNull", EventBody.KEY_VALUE, "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f8859a = null;

    static {
        f8859a = new f();
    }

    private f() {
    }

    private final JSONArray a(fa r7, Object r8) {
        JSONArray r0 = new JSONArray();
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r7.d(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L26;
        JSONObject r3 = new JSONObject();
        String r5 = "dialog_bubble";
        if (Intrinsics.areEqual(b(r7), "dialog_bubble") == true) goto L15;
        r5 = "original_text";
    L15:
        JSONObject r6 = r3.put("type", r5).put(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, r7.d());
        Object r4 = r7.c();
        if (r4 != null) goto L18;
        r4 = JSONObject.NULL;
    L18:
        JSONObject r9 = r6.put(ChatMessage.TYPE_QUERY, r4);
        Object r10 = r7.f();
        if (r10 != null) goto L21;
        r10 = JSONObject.NULL;
    L21:
        JSONObject r11 = r9.put("appName", r10);
        Object r12 = r7.g();
        if (r12 != null) goto L24;
        r12 = JSONObject.NULL;
    L24:
        r0.put(r11.put(ObricMemoryConstants.KEY_PACKAGE_NAME, r12));
    L26:
        if (Intrinsics.areEqual(r8, JSONObject.NULL) == true) goto L34;
        JSONObject r13 = new JSONObject().put("type", "screenshot").put("screenshot", r8);
        Object r14 = r7.f();
        if (r14 != null) goto L30;
        r14 = JSONObject.NULL;
    L30:
        JSONObject r15 = r13.put("appName", r14);
        Object r16 = r7.g();
        if (r16 != null) goto L33;
        r16 = JSONObject.NULL;
    L33:
        r0.put(r15.put(ObricMemoryConstants.KEY_PACKAGE_NAME, r16));
    L34:
        return r0;
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L10
    }

    private final JSONObject a(String r3) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        f r2 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r4 = Result.m1421constructorimpl(new JSONObject(r3));     // Catch: Throwable -> L5
    L8:
        if (Result.m1424exceptionOrNullimpl(r4) == null) goto L12;
        r4 = new JSONObject().put("rawSnapshotJson", r3);
        Intrinsics.checkNotNullExpressionValue(r4, "put(...)");
    L12:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final void a(JSONObject r5, fa r6) {
        Object r0 = b(r6.e());
        r5.put("sourceType", b(r6));
        JSONObject r1 = new JSONObject();
        Object r2 = r6.f();
        if (r2 != null) goto L5;
        r2 = JSONObject.NULL;
    L5:
        JSONObject r3 = r1.put("appName", r2);
        Object r4 = r6.g();
        if (r4 != null) goto L8;
        r4 = JSONObject.NULL;
    L8:
        r5.put("sourceInfo", r3.put(ObricMemoryConstants.KEY_PACKAGE_NAME, r4));
        Object r7 = r6.c();
        if (r7 != null) goto L11;
        r7 = JSONObject.NULL;
    L11:
        r5.put("sourceQuery", r7);
        Object r8 = r6.d();
        if (r8 != null) goto L14;
        r8 = JSONObject.NULL;
    L14:
        r5.put("sourceText", r8);
        r5.put("sourceScreenshot", r0);
        r5.put("screenshot", r0);
        Object r9 = r6.f();
        if (r9 != null) goto L17;
        r9 = JSONObject.NULL;
    L17:
        r5.put("sourceAppName", r9);
        Object r10 = r6.g();
        if (r10 != null) goto L20;
        r10 = JSONObject.NULL;
    L20:
        r5.put("sourcePackageName", r10);
        r5.put("detailStatus", r6.h());
        r5.put("sourceEvidence", a(r6, r0));
    }

    private final boolean a(iu r2, ip r3) {
        JSONObject r1 = a(r2.e());
        if (Intrinsics.areEqual(r1.optString("semanticType"), r3.a()) == true) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(r1.optString("keyPhrase"), r3.c()) == false) goto L9;
        if (Intrinsics.areEqual(r1.optString("tagPath"), r3.b()) == false) goto L9;
        return true;
    }

    private final Object b(String r4) {
        if (r4 == null) goto L5;
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L11;
    L29:
        Object r3 = JSONObject.NULL;
        Intrinsics.checkNotNullExpressionValue(r3, "NULL");
        return r3;
    L11:
        if (Intrinsics.areEqual(r5, "null") == true) goto L29;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L22
        f r6 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (StringsKt.startsWith$default(r5, "{", false, 2, null) == false) goto L17;
        Object r7 = new JSONObject(r5);     // Catch: Throwable -> L22
    L20:
        Object r8 = Result.m1421constructorimpl(r7);     // Catch: Throwable -> L22
    L25:
        if (Result.m1427isFailureimpl(r8) == false) goto L28;
        return r5;
    L28:
        return r8;
    L17:
        if (StringsKt.startsWith$default(r5, "[", false, 2, null) == false) goto L19;
        r7 = new JSONArray(r5);     // Catch: Throwable -> L22
        goto L20
    L19:
        r7 = r5;
    L22:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L25
    L5:
        r5 = null;
        goto L6
    }

    private final String b(fa r5) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.c(), CharSequence.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
        if (r4 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == true) goto L20;
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.d(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L13;
    L16:
        boolean r8 = true;
    L17:
        if (r8 == true) goto L20;
        return "dialog_bubble";
    L13:
        if (StringsKt.isBlank(r7) == true) goto L16;
        r8 = false;
    L20:
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.e(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L23;
    L26:
        boolean r10 = true;
    L27:
        if (r10 == true) goto L30;
        return "screenshot";
    L30:
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.d(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L33;
    L34:
        r0 = true;
    L35:
        if (r0 == true) goto L38;
        return "original_text";
    L38:
        return "unknown";
    L33:
        if (StringsKt.isBlank(r11) == false) goto L35;
    L23:
        if (StringsKt.isBlank(r9) == true) goto L26;
        r10 = false;
        goto L27
    L5:
        if (StringsKt.isBlank(r4) == true) goto L8;
        r6 = false;
        goto L9
    }

    public final void a() {
        if (b.f8850a.a() == true) goto L5;
        return;
    L5:
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUnionSemanticMemorySnapShotDao().deleteAll();
    }

    public final void a(fa r15) {
        Intrinsics.checkNotNullParameter(r15, "relevantData");
        if (e.f8857a.a() == false) goto L5;
        return;
    L5:
        if (b.f8850a.a() == false) goto L13;
        UnionSemanticMemorySnapShotDao r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUnionSemanticMemorySnapShotDao();
        iu r2 = (iu) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r0.queryByEntityId(r15.b())), iu.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L10;
        return;
    L10:
        JSONObject r14 = a(r2.e());
        f8859a.a(r14, r15);
        String r9 = r14.toString();
        Intrinsics.checkNotNullExpressionValue(r9, "toString(...)");
        r0.insert(iu.a(r2, 0, 0, null, 0, r9, 0, 47, null));
        return;
    }

    public final void a(ip r18) {
        Intrinsics.checkNotNullParameter(r18, "entity");
        if (e.f8857a.a() == false) goto L5;
        return;
    L5:
        if (b.f8850a.a() == true) goto L7;
        return;
    L7:
        if (r18.getId() <= 0) goto L26;
        UnionSemanticMemorySnapShotDao r1 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUnionSemanticMemorySnapShotDao();
        iu r2 = r1.queryLatestByUnionSemanticMemoryId(r18.getId());
        int r4 = 0;
        if (r2 != null) goto L12;
    L14:
        boolean r5 = false;
    L15:
        if (r5 == false) goto L17;
        return;
    L17:
        if (r2 == null) goto L19;
        r4 = r2.d();
    L19:
        int r11 = r4 + 1;
        long r13 = System.currentTimeMillis();
        fa r3 = (fa) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveSemanticRelevantDataDao().queryByMemoryId(r18.getEntityId())), fa.class, "com.obric.memorydata.plugin");
        long r8 = r18.getId();
        String r10 = r18.getEntityId();
        JSONObject r0 = r18.x();
        r0.put("snapshotVersion", r11);
        r0.put("snapshotTime", r13);
        if (r3 == null) goto L22;
        f8859a.a(r0, r3);
    L22:
        d.f8856a.a(r0, r2);
        Unit r6 = Unit.INSTANCE;
        String r12 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "toString(...)");
        r1.insert(new iu(0, r8, r10, r11, r12, r13, 1, null));
        return;
    L12:
        if (a(r2, r18) != true) goto L14;
        r5 = true;
        goto L15
    }

    public final void a(List<ip> r3) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "entities");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ip r5 = (ip) ZeusTransformUtils.preCheckCast(r4.next(), ip.class, "com.obric.memorydata.plugin");
        f8859a.a(r5);
        goto L4
    }

    public final void b(List<Long> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "unionSemanticMemoryIds");
        if (b.f8850a.a() == true) goto L5;
        return;
    L5:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L7:
        if (r10.hasNext() == false) goto L14;
        Object r1 = r10.next();
        if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L7;
        r9.add(r1);
        goto L7
    L11:
        r2 = false;
        goto L12
    L14:
        List<Long> r11 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
        if (r11.isEmpty() == false) goto L17;
        return;
    L17:
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUnionSemanticMemorySnapShotDao().deleteByUnionSemanticMemoryIds(r11);
    }
}
