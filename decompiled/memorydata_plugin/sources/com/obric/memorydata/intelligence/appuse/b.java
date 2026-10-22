package com.obric.memorydata.intelligence.appuse;

import com.bytedance.crash.util.DateUtils;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.AppStateType;
import com.obric.memorydata.database.entity.dq;
import com.obric.memorydata.database.entity.eb;
import com.obric.memorydata.database.entity.ic;
import com.obric.memorydata.database.entity.n;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.intelligence.b.c;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.tom_roush.pdfbox.pdmodel.a.d.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ&\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/intelligence/appuse/AppUsageHelper;", "", "<init>", "()V", "getPackageCategory", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "getAppUsageDurationInfo", "", "Lcom/obric/memorydata/intelligence/appuse/IUsageInfo;", "startTimeStamp", "", "endTimeStamp", "getScreenLockPeriod", "Ljava/util/ArrayList;", "Lcom/obric/memorydata/intelligence/appuse/IScreenLockPeriod;", "Lkotlin/collections/ArrayList;", "getAudioPlayPeriod", "Lcom/obric/memorydata/intelligence/appuse/IAudioPlayPeriod;", "getMovementList", "Lcom/obric/memorydata/intelligence/appuse/IMovementItem;", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9935a = null;

    static {
        f9935a = new b();
    }

    private b() {
    }

    public final String a(String r3) {
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        AppCategoryMsg r2 = a.f9933a.a(r3);
        if (r2 != null) goto L6;
        return null;
    L6:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r2.getSubCategory(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == false) goto L16;
        return r2.getCategory();
    L16:
        return r2.getSubCategory();
    L9:
        if (r4.length() == 0) goto L12;
        r5 = false;
        goto L13
    }

    public final List<IUsageInfo> a(long r30, long r32) {
        long r13 = r32;
        List<n> r1 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAppUsageDao().queryRecords(r30, r13);
        ArrayList r15 = new ArrayList();
        String r10 = "com.obric.memorydata.plugin";
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator<n> r4 = r1.iterator();
    L4:
        if (r4.hasNext() == false) goto L23;
        n r5 = (n) ZeusTransformUtils.preCheckCast(r4.next(), n.class, "com.obric.memorydata.plugin");
        String r6 = r5.a();
        long r24 = r5.e();
        String r7 = (String) ZeusTransformUtils.preCheckCast(r3.get(r6), String.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L11;
        r7 = a(r6);
        if (r7 != null) goto L10;
        r7 = StructuredDataId.RESERVED;
    L10:
        r3.put(r6, r7);
        RunLog.INSTANCE.debug("EntityGsonUtil", "getAppUsageDurationInfo: " + r6 + ", " + r7);
    L12:
        String r19 = r7;
        int r26 = r5.d();
        String r8 = r5.f();
        if (Intrinsics.areEqual(r8, AppStateType.FG.getState()) == false) goto L16;
        r2.put(r6, new IUsageInfo(r6, r19, -1, r24, -1, r26));
    L22:
        r4 = r4;
        r3 = r3;
        goto L4
    L16:
        if (Intrinsics.areEqual(r8, AppStateType.BG.getState()) == false) goto L22;
        if (r2.containsKey(r6) == false) goto L20;
        Object r9 = r2.get(r6);
        Intrinsics.checkNotNull(r9);
        long r11 = ((IUsageInfo) ZeusTransformUtils.preCheckCast(r9, IUsageInfo.class, "com.obric.memorydata.plugin")).getStartUsageTime();
        r2.remove(r6);
        long r22 = r11;
    L21:
        r15.add(new IUsageInfo(r6, r19, r24 - r22, r22, r24, r26));
        goto L22
    L20:
        r22 = r30;
        goto L21
    L11:
        RunLog.INSTANCE.debug("EntityGsonUtil", "getAppUsageDurationInfo from map: " + r6 + ", " + r7);
        goto L12
    L23:
        Iterator r17 = r2.entrySet().iterator();
    L25:
        if (r17.hasNext() == false) goto L27;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r17.next(), Map.Entry.class, r10);
        String r14 = (String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, r10);
        IUsageInfo r16 = (IUsageInfo) ZeusTransformUtils.preCheckCast(r12.getValue(), IUsageInfo.class, r10);
        r15.add(new IUsageInfo(r14, r16.getAppCategory(), r13 - r16.getStartUsageTime(), r16.getStartUsageTime(), r32, r16.getConnectionType()));
        r10 = r10;
        r13 = r32;
        goto L25
    L27:
        String r18 = r10;
        int r0 = DateUtils.DAY;
        if (r15.size() != 0) goto L54;
        Iterator<Map.Entry<String, c>> r110 = com.obric.memorydata.intelligence.b.a.f9936a.b().entrySet().iterator();
    L31:
        if (r110.hasNext() == false) goto L43;
        Map.Entry r20 = (Map.Entry) ZeusTransformUtils.preCheckCast(r110.next(), Map.Entry.class, r18);
        String r21 = (String) ZeusTransformUtils.preCheckCast(r20.getKey(), String.class, r18);
        c r23 = (c) ZeusTransformUtils.preCheckCast(r20.getValue(), c.class, r18);
        if ((r30 - r23.a()) >= r0) goto L41;
        if (r32 <= r23.a()) goto L41;
        String r25 = a(r21);
        if (r25 != null) goto L39;
        String r27 = StructuredDataId.RESERVED;
    L40:
        r15.add(new IUsageInfo(r21, r27, r32 - r30, r30, r32, -1));
        r110 = r110;
        r0 = DateUtils.DAY;
        goto L31
    L39:
        r27 = r25;
    L41:
        r110 = r110;
        goto L31
    L43:
        if (r15.size() != 0) goto L54;
        n r28 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAppUsageDao().queryLastRecord(r30 - TimeUnit.DAYS.toMillis(1), r30);
        if (r28 == null) goto L54;
        if (Intrinsics.areEqual(r28.f(), "fg") == false) goto L54;
        String r29 = a(r28.a());
        if (r29 != null) goto L51;
        String r31 = StructuredDataId.RESERVED;
    L52:
        r15.add(new IUsageInfo(r28.a(), r31, r32 - r30, r30, r32, r28.d()));
        goto L54
    L51:
        r31 = r29;
    L54:
        return (List) ZeusTransformUtils.preCheckCast(r15, List.class, r18);
    }

    public final ArrayList<IScreenLockPeriod> b(long r20, long r22) {
        ArrayList<IScreenLockPeriod> r7 = new ArrayList();
        Iterator<ic> r0 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getScreenStateDao().queryOnAndOffEvents(r20, r22).iterator();
        String r5 = null;
        ic r6 = null;
    L4:
        if (r0.hasNext() == false) goto L15;
        ic r8 = (ic) ZeusTransformUtils.preCheckCast(r0.next(), ic.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L8;
        long r13 = r6.c();
    L9:
        long r15 = r8.c();
        if (Intrinsics.areEqual(r8.d(), "unlock") == true) goto L11;
        if (Intrinsics.areEqual(r8.d(), f.g) == false) goto L4;
    L14:
        r6 = r8;
        goto L4
    L11:
        r7.add(new IScreenLockPeriod(r13, r15, r15 - r13));
        goto L14
    L8:
        r13 = r20;
        goto L9
    L15:
        if (r6 == null) goto L18;
        r5 = r6.d();
    L18:
        if (Intrinsics.areEqual(r5, f.g) == false) goto L20;
        r7.add(new IScreenLockPeriod(r6.c(), r22, r22 - r6.c()));
    L20:
        return r7;
    }

    public final List<IAudioPlayPeriod> c(long r8, long r10) {
        ArrayList r7 = new ArrayList();
        Iterator<eb> r9 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getOsAudioPlayDao().queryRecords(r8, r10).iterator();
    L4:
        if (r9.hasNext() == false) goto L7;
        eb r11 = (eb) ZeusTransformUtils.preCheckCast(r9.next(), eb.class, "com.obric.memorydata.plugin");
        r7.add(new IAudioPlayPeriod(r11.d(), r11.e(), r11.g()));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
    }

    public final List<IMovementItem> d(long r3, long r5) {
        List<dq> r2 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMovementStateDao().queryRecords(r3, r5);
        ArrayList r4 = new ArrayList();
        Iterator<dq> r6 = r2.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        dq r7 = (dq) ZeusTransformUtils.preCheckCast(r6.next(), dq.class, "com.obric.memorydata.plugin");
        r4.add(new IMovementItem(r7.c(), r7.d(), r7.f()));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
    }
}
