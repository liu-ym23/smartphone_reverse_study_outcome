package com.obric.memorydata.personalcontext.external;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.platform.godzilla.anr.monitor.idletask.ArrayListWrapper;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.memorydata.middleware.api.IAgentServiceProvider;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0013J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u0013J2\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H!0 \"\b\b\u0000\u0010!*\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130 J\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0 2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\"0 J\u0012\u0010(\u001a\u0004\u0018\u00010\u00132\b\u0010)\u001a\u0004\u0018\u00010\"J\u000e\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\fJ\u0016\u0010,\u001a\u00020-2\u0006\u0010+\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u0013J\u0016\u0010/\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\f2\u0006\u00100\u001a\u00020\u0013J{\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0013072\u0006\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020\f2\b\u0010:\u001a\u0004\u0018\u00010\u00132\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001072&\u0010<\u001a\"\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000b0 \u0012\u0004\u0012\u00020\u00160=¢\u0006\u0002\u0010>J\u001c\u0010?\u001a\u00020\f*\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\u0013J\n\u0010A\u001a\u00020\u0013*\u00020\u0013J\u0006\u0010B\u001a\u00020-J\u0006\u0010C\u001a\u00020-J\u0006\u0010D\u001a\u00020-R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR'\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006E"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/ExternalDataCollectorUtils;", "", "<init>", "()V", "agentServiceProvider", "Lcom/obric/memorydata/middleware/api/IAgentServiceProvider;", "getAgentServiceProvider", "()Lcom/obric/memorydata/middleware/api/IAgentServiceProvider;", "setAgentServiceProvider", "(Lcom/obric/memorydata/middleware/api/IAgentServiceProvider;)V", "entityDataRequesterMap", "", "", "Lcom/obric/memorydata/personalcontext/external/ExternalEntityDataRequester;", "getEntityDataRequesterMap", "()Ljava/util/Map;", "entityDataRequesterMap$delegate", "Lkotlin/Lazy;", "removeDoubleDashPrefix", "", "input", "updateLastSyncTime", "", "bizName", "timeStamp", "", "getLastSyncTime", "safeGetColumn", "cursor", "Landroid/database/Cursor;", "columnName", "sortEntityListByIds", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/capabilitykit/entity/app/AppEntity;", "entityList", "", "ids", "changeEntityPackageName", "entities", "getPackageName", "appEntity", "getActivePackageName", "type", "interruptIndex", "", "callPackageName", "getPackageNameByType", "default", "paginationQuery", "contentResolver", "Landroid/content/ContentResolver;", "uri", "Landroid/net/Uri;", "projection", "", "paginationColumnName", "pageLimit", "selection", "selectionArgs", "result", "Lkotlin/Function1;", "(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;[Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getColumnIndexSafe", LocationMonitorConst.TAG, "formatPhoneNumber", "hasSmsPermission", "hasCallLogPermission", "hasContactsPermission", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f12138a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static IAgentServiceProvider f12139b;
    private static final Lazy c = null;

    static {
        f12138a = new g();
        c = LazyKt.lazy($$Lambda$g$fKDEIVVsPiToUpKfNbSR3Lxgz3Q.INSTANCE);
    }

    private g() {
    }

    private static final Map f() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(201, com.obric.memorydata.personalcontext.external.c.a.f12109a), TuplesKt.to(202, com.obric.memorydata.personalcontext.external.b.a.f12104a), TuplesKt.to(101, com.obric.memorydata.personalcontext.external.message.b.f12147a), TuplesKt.to(301, com.obric.memorydata.personalcontext.external.d.b.f12114a), TuplesKt.to(Integer.valueOf(EntityType.FILE), com.obric.memorydata.personalcontext.external.file.b.f12130a), TuplesKt.to(402, com.obric.memorydata.personalcontext.external.schedule.b.f12162a)});
    }

    public static /* synthetic */ Map lambda$fKDEIVVsPiToUpKfNbSR3Lxgz3Q() {
        return f();
    }

    public final int a(Cursor r5, String r6, String r7) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r5, Cursor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "columnName");
        Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
        if (r4 != null) goto L5;
        return -1;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L18;
        return r4.getColumnIndexOrThrow(r6);
    L12:
        e = move-exception;
        RunLog.INSTANCE.error(r7, "getColumnIndexSafe failed, columnName=" + r6, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return -1;
    L18:
        return -1;
    L7:
        r1 = false;
        goto L8
    }

    public final IAgentServiceProvider a() {
        return f12139b;
    }

    public final String a(int r3) {
        com.obric.memorydata.middleware.api.device.a r0 = DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport();
        if (r3 != 302) goto L6;
        r3 = 301;
    L6:
        if (r0.a(r3) == false) goto L9;
        return b(r3, AppContext.INSTANCE.getPackageName());
    L9:
        return AppContext.INSTANCE.getPackageName();
    }

    public final String a(Cursor r2, String r3) {
        Cursor r1 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "columnName");
        if (r1 == null) goto L7;
        int r4 = r1.getColumnIndex(r3);
        if (r4 == (-1)) goto L7;
        return r1.getString(r4);
    L7:
        return null;
    }

    public final String a(AppEntity r1) {
        if (r1 == null) goto L4;
        int r2 = r1.getType();
    L6:
        return a(r2);
    L4:
        r2 = -1;
        goto L6
    }

    public final String a(String r3) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L13;
        return "";
    L13:
        return StringsKt.removePrefix(r3, (CharSequence) ZeusTransformUtils.preCheckCast("--", CharSequence.class, "com.obric.memorydata.plugin"));
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r4 = false;
        goto L9
    }

    public final <T extends AppEntity> List<T> a(Collection<? extends T> r7, List<String> r8) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r7, Collection.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "entityList");
        Intrinsics.checkNotNullParameter(r9, "ids");
        ArrayListWrapper r10 = (List<T>) ((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Object r2 = r12.next();
        String r3 = ((AppEntity) ZeusTransformUtils.preCheckCast(r2, AppEntity.class, "com.obric.memorydata.plugin")).getId();
        Object r4 = r1.get(r3);
        if (r4 != null) goto L8;
        r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r1.put(r3, r4);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")).add(r2);
        goto L4
    L9:
        Iterator r13 = r9.iterator();
    L11:
        if (r13.hasNext() == false) goto L21;
        List r14 = (List) ZeusTransformUtils.preCheckCast(r1.get((String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin")), List.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L15;
    L18:
        boolean r15 = true;
    L19:
        if (r15 == true) goto L11;
        r10.add(r14.get(0));
        goto L11
    L15:
        if (r5.isEmpty() == true) goto L18;
        r15 = false;
        goto L19
    L21:
        return r10;
    }

    public final List<AppEntity> a(List<? extends AppEntity> r4) {
        List<AppEntity> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "entities");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        AppEntity r1 = (AppEntity) ZeusTransformUtils.preCheckCast(r5.next(), AppEntity.class, "com.obric.memorydata.plugin");
        String r2 = f12138a.a(r1);
        if (r2 == null) goto L4;
        r1.set_packageName(r2);
        goto L4
    L8:
        return r3;
    }

    public final void a(ContentResolver r22, Uri r23, String[] r24, String r25, int r26, String r27, String[] r28, Function1<? super List<? extends Map<String, String>>, Unit> r29) {
        String[] r0 = r24;
        Function1 r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r29, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r22, "contentResolver");
        Intrinsics.checkNotNullParameter(r23, "uri");
        Intrinsics.checkNotNullParameter(r0, "projection");
        Intrinsics.checkNotNullParameter(r25, "paginationColumnName");
        Intrinsics.checkNotNullParameter(r13, "result");
        Object r7 = null;
        Long r16 = null;
    L3:
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r27, CharSequence.class, "com.obric.memorydata.plugin");
        int r17 = 0;
        if (r1 != null) goto L6;
    L9:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        StringBuilder r3 = new StringBuilder();
    L14:
        String r4 = r3.append(r25).append(" > ?").toString();
        long r5 = 0;
        if (r28 != null) goto L20;
        String[] r6 = new String[1];
        if (r16 == null) goto L19;
        r5 = r16.longValue();
    L19:
        r6[0] = String.valueOf(r5);
        String[] r8 = r6;
    L23:
        Object r10 = r7;
        Cursor r9 = ZeusProviderTransform.query(r22, r23, r24, r4, r8, r25 + " ASC", "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L51;
        Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(r9, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r14 = (Cursor) ZeusTransformUtils.preCheckCast(r12, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        int r15 = 0;
    L28:
        if (r14.moveToNext() == false) goto L43;
        Map r18 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        int r19 = r0.length;     // Catch: Throwable -> L45
        int r110 = 0;
    L30:
        Cursor r21 = r14;
        if (r110 >= r19) goto L33;
        String r20 = r0[r110];     // Catch: Throwable -> L45
        r18.put(r20, f12138a.a(r9, r20));     // Catch: Throwable -> L45
        r110 = r110 + 1;     // Catch: Throwable -> L45
        r14 = r21;
        r0 = r24;
        goto L30
    L33:
        r11.add(r18);     // Catch: Throwable -> L45
        String r30 = f12138a.a(r9, r25);     // Catch: Throwable -> L45
        if (r30 == null) goto L36;
        Long r31 = StringsKt.toLongOrNull(r30);     // Catch: Throwable -> L45
    L37:
        if (r31 == null) goto L39;
        r16 = r31;
    L39:
        r15 = r15 + 1;     // Catch: Throwable -> L45
        if (r15 >= r26) goto L43;
        r14 = r21;
        r0 = r24;
        goto L28
    L36:
        r31 = null;
    L43:
        r17 = r15;
        Unit r32 = Unit.INSTANCE;     // Catch: Throwable -> L45
        Object r33 = null;
        CloseableKt.closeFinally(r12, null);
    L52:
        int r34 = r17;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L55;
        r13.invoke(r11);
    L55:
        if (r34 < r26) goto L56;
        r7 = r33;
        r0 = r24;
        goto L3
    L56:
        return;
    L45:
        th = move-exception;
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    L51:
        r33 = r10;
        goto L52
    L20:
        if (r16 == null) goto L22;
        r5 = r16.longValue();
    L22:
        r8 = (String[]) ZeusTransformUtils.preCheckCast(ArraysKt.plus(r28, String.valueOf(r5)), String[].class, "com.obric.memorydata.plugin");
        goto L23
    L13:
        r3 = new StringBuilder().append('(').append(r27).append(") AND ");
        goto L14
    L6:
        if (r1.length() == 0) goto L9;
        r2 = false;
        goto L11
    }

    public final void a(String r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "bizName");
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("external_entity_collector_" + r5, r6);
    }

    public final boolean a(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "callPackageName");
        if (r3 != 302) goto L6;
        r3 = 301;
    L6:
        if (AppContext.INSTANCE.isDebug() == true) goto L8;
        return false;
    L8:
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(r3) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(r4, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName()) == true) goto L15;
        return true;
    L15:
        return false;
    }

    public final long b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "bizName");
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong("external_entity_collector_" + r5, 0);
    }

    public final String b(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "default");
        com.obric.memorydata.middleware.api.device.a r1 = DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport();
        if (r2 != 201) goto L7;
        return r1.c().a();
    L7:
        if (r2 != 202) goto L11;
        return r1.c().b();
    L11:
        if (r2 != 101) goto L15;
        return r1.c().c();
    L15:
        if (r2 != 301) goto L19;
        return r1.c().d();
    L19:
        if (r2 != 801) goto L23;
        return r1.c().e();
    L23:
        if (r2 == 402) goto L25;
        return r3;
    L25:
        return r1.c().f();
    }

    public final Map<Integer, h> b() {
        return (Map) ZeusTransformUtils.preCheckCast(c.getValue(), Map.class, "com.obric.memorydata.plugin");
    }

    public final String c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return r2;
    L8:
        String r3 = PhoneNumberUtils.formatNumber(r2, Locale.getDefault().getCountry());
        if (r3 != null) goto L12;
        return r2;
    L12:
        return r3;
    L5:
        r1 = false;
        goto L6
    }

    public final boolean c() {
        if (ContextCompat.checkSelfPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "android.permission.READ_SMS") == 0) goto L5;
    L7:
        return false;
    L5:
        if (e() == false) goto L7;
        return true;
    }

    public final boolean d() {
        if (ContextCompat.checkSelfPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "android.permission.READ_CALL_LOG") == 0) goto L5;
    L7:
        return false;
    L5:
        if (e() == false) goto L7;
        return true;
    }

    public final boolean e() {
        if (ContextCompat.checkSelfPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "android.permission.READ_CONTACTS") != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
