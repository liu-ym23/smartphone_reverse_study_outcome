package com.obric.memorydata.database.c;

import androidx.exifinterface.media.ExifInterface;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.dao.AutoMemoryProSnapShotDao;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.aa;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0014\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016J\u0014\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013J\u0006\u0010\u0019\u001a\u00020\u000eJ\f\u0010\u001a\u001a\u00020\u001b*\u00020\u0006H\u0002J\u0014\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\f\u0010\u001f\u001a\u00020 *\u00020\u0006H\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/memorydata/database/review/AutoMemoryProSnapshotSync;", "", "<init>", "()V", "rawObservationIdsOverride", "Ljava/lang/ThreadLocal;", "", "withRawObservationIds", ExifInterface.GPS_DIRECTION_TRUE, "rawObservationIdsJson", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "insertSnapshot", "", "entity", "Lcom/obric/memorydata/database/entity/AutoMemoryProEntity;", "insertSnapshots", "entities", "", "deleteByAutoMemoryProId", "autoMemoryProId", "", "deleteByAutoMemoryProIds", "autoMemoryProIds", "deleteAll", "toJsonArrayOrEmpty", "Lorg/json/JSONArray;", "hasSameReviewContent", "", "Lcom/obric/memorydata/database/entity/AutoMemoryProSnapShotEntity;", "toJsonObjectOrEmpty", "Lorg/json/JSONObject;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8848a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<String> f8849b = null;

    static {
        f8848a = new a();
        f8849b = new ThreadLocal();
    }

    private a() {
    }

    private final JSONArray a(String r2) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L4
        Object r3 = Result.m1421constructorimpl(new JSONArray(r2));     // Catch: Throwable -> L4
    L6:
        JSONArray r4 = new JSONArray();
        if (Result.m1427isFailureimpl(r3) == false) goto L10;
        r3 = r4;
    L10:
        return (JSONArray) ZeusTransformUtils.preCheckCast(r3, JSONArray.class, "com.obric.memorydata.plugin");
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    private final boolean a(aa r2, AutoMemoryProEntity r3) {
        JSONObject r1 = b(r2.e());
        if (Intrinsics.areEqual(r1.optString("title"), r3.getTitle()) == true) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(r1.optString("subtitle"), r3.getSubtitle()) == false) goto L9;
        if (Intrinsics.areEqual(r1.optString(Params.CONTENT), r3.getContent()) == false) goto L9;
        return true;
    }

    private final JSONObject b(String r2) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L4
        Object r3 = Result.m1421constructorimpl(new JSONObject(r2));     // Catch: Throwable -> L4
    L6:
        JSONObject r4 = new JSONObject();
        if (Result.m1427isFailureimpl(r3) == false) goto L10;
        r3 = r4;
    L10:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin");
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final <T> T a(String r4, Function0<? extends T> r5) {
        Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "rawObservationIdsJson");
        Intrinsics.checkNotNullParameter(r3, "block");
        if (b.f8850a.a() == false) goto L5;
        ThreadLocal<String> r6 = f8849b;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r6.get(), String.class, "com.obric.memorydata.plugin");
        r6.set(r4);
        T r7 = (T) r3.invoke();
        if (r0 != null) goto L10;
        r6.remove();
    L11:
        return r7;
    L10:
        r6.set(r0);
    L12:
        th = move-exception;
        ThreadLocal<String> r8 = f8849b;
        if (r0 != null) goto L16;
        r8.remove();
    L17:
        throw th;
    L16:
        r8.set(r0);
        goto L17
    L5:
        return (T) r3.invoke();
    }

    public final void a() {
        if (b.f8850a.a() == true) goto L5;
        return;
    L5:
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProSnapShotDao().deleteAll();
    }

    public final void a(long r3) {
        if (b.f8850a.a() == true) goto L5;
        return;
    L5:
        if (r3 <= 0) goto L10;
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProSnapShotDao().deleteByAutoMemoryProId(r3);
        return;
    }

    public final void a(AutoMemoryProEntity r18) {
        Intrinsics.checkNotNullParameter(r18, "entity");
        if (e.f8857a.a() == false) goto L5;
        return;
    L5:
        if (b.f8850a.a() == true) goto L7;
        return;
    L7:
        if (r18.getId() <= 0) goto L26;
        AutoMemoryProSnapShotDao r1 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProSnapShotDao();
        aa r2 = r1.queryLatestByAutoMemoryProId(r18.getId());
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
        JSONObject r3 = r18.toJsonObject();
        String r6 = (String) ZeusTransformUtils.preCheckCast(f8849b.get(), String.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L22;
        r3.put("rawObservationIds", f8848a.a(r6));
    L22:
        r3.put("snapshotVersion", r11);
        r3.put("snapshotTime", r13);
        d.f8856a.a(r3, r2);
        long r8 = r18.getId();
        String r10 = r18.getEntityId();
        String r12 = r3.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "toString(...)");
        r1.insert(new aa(0, r8, r10, r11, r12, r13, 1, null));
        return;
    L12:
        if (a(r2, r18) != true) goto L14;
        r5 = true;
        goto L15
    }

    public final void a(List<AutoMemoryProEntity> r3) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "entities");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        AutoMemoryProEntity r5 = (AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r4.next(), AutoMemoryProEntity.class, "com.obric.memorydata.plugin");
        f8848a.a(r5);
        goto L4
    }

    public final void b(List<Long> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "autoMemoryProIds");
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
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProSnapShotDao().deleteByAutoMemoryProIds(r11);
    }
}
