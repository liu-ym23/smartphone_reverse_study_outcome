package com.larus.bmhome.taskskill;

import com.larus.bmhome.instruction.core.model.ActionBarInstructionKey;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.dispatcher.api.AllDeviceResponse;
import com.larus.dispatcher.api.GetAllDevicesRepo;
import com.larus.im.internal.jni.bean.DispatchCommand;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l2 {
    public static final List<Integer> a = null;

    static {
        a = CollectionsKt.listOf(new Integer[]{Integer.valueOf(DispatchCommand.GET_META_REQUEST.value), Integer.valueOf(DispatchCommand.COMPLETION_REQUEST.value)});
    }

    public static boolean c() {
        return com.larus.platform.service.p1.a.a();
    }

    public static boolean a(com.larus.bmhome.instruction.g r3) {
        Intrinsics.checkNotNullParameter(r3, "instructionInputAbility");
        List<com.larus.bmhome.actionbar.model.z0> r4 = r3.tq();
        if (r4 == null) goto L16;
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        Object r0 = r5.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.z0) r0).b, ActionBarInstructionKey.COCO_DEEP_THINKING.getKey()) == false) goto L6;
    L11:
        com.larus.bmhome.actionbar.model.z0 r1 = (com.larus.bmhome.actionbar.model.z0) r0;
        if (r1 == null) goto L16;
        com.larus.bmhome.actionbar.model.p0 r6 = r1.o;
        if (r6 == null) goto L16;
        return Intrinsics.areEqual(r6.k, Boolean.TRUE);
    L10:
        r0 = null;
    L16:
        return false;
    }

    public static boolean b(String r17) {
        String r0 = com.larus.platform.service.p1.a.c();
        if (r17 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L36;
        List r7 = StringsKt.split$default(StringsKt.substringBefore$default(StringsKt.trim(r17).toString(), '-', null, 2, null), new char[]{'.'}, false, 0, 6, null);
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L13:
        if (r9.hasNext() == false) goto L17;
        Integer r10 = StringsKt.toIntOrNull((String) r9.next());
        if (r10 == null) goto L36;
        r8.add(Integer.valueOf(r10.intValue()));
        goto L13
    L17:
        List r1 = StringsKt.split$default(StringsKt.substringBefore$default(r0, '-', null, 2, null), new char[]{'.'}, false, 0, 6, null);
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r2 = r1.iterator();
    L19:
        if (r2.hasNext() == false) goto L23;
        Integer r5 = StringsKt.toIntOrNull((String) r2.next());
        if (r5 == null) goto L36;
        r4.add(Integer.valueOf(r5.intValue()));
        goto L19
    L23:
        int r6 = Math.max(r8.size(), r4.size());
        int r11 = 0;
    L24:
        if (r11 >= r6) goto L46;
        Integer r12 = (Integer) CollectionsKt.getOrNull(r8, r11);
        if (r12 == null) goto L28;
        int r13 = r12.intValue();
    L29:
        Integer r14 = (Integer) CollectionsKt.getOrNull(r4, r11);
        if (r14 == null) goto L32;
        int r15 = r14.intValue();
    L33:
        if (r13 != r15) goto L34;
        r11 = r11 + 1;
        goto L24
    L34:
        if (r13 <= r15) goto L36;
        return true;
    L32:
        r15 = 0;
        goto L33
    L28:
        r13 = 0;
        goto L29
    L46:
        return true;
    L36:
        return false;
    L5:
        if (StringsKt.isBlank(r17) == true) goto L8;
        r3 = false;
        goto L9
    }

    public static String d(bs8.a r4, AllDeviceResponse r5) {
        String r0 = null;
        if (r4 != null) goto L6;
        FLogger.a.i("TaskUtils", "[resolvePcDeviceId] miss, branch=empty_task_param");
        return null;
    L6:
        String r2 = r4.e;
        if (r2 != null) goto L9;
    L11:
        r2 = null;
    L12:
        if (r2 == null) goto L15;
        FLogger.a.i("TaskUtils", "[resolvePcDeviceId] hit, branch=local_pc_device_id");
        return r2;
    L15:
        String r6 = r4.a;
        if (r6 != null) goto L18;
    L20:
        r6 = null;
    L21:
        if (r6 != null) goto L24;
        FLogger.a.i("TaskUtils", "[resolvePcDeviceId] miss, branch=empty_device_name");
        return null;
    L24:
        if (r5 != null) goto L26;
        GetAllDevicesRepo r7 = GetAllDevicesRepo.a;
        r5 = GetAllDevicesRepo.d();
    L26:
        if (r5 == null) goto L43;
        List r8 = r5.getDevices();
        if (r8 == null) goto L43;
        Iterator r9 = r8.iterator();
    L31:
        if (r9.hasNext() == false) goto L39;
        Object r3 = r9.next();
        PcDevice r10 = (PcDevice) r3;
        if (r10 == null) goto L35;
        String r11 = r10.d();
    L37:
        if (Intrinsics.areEqual(r11, r6) == false) goto L31;
    L40:
        PcDevice r12 = (PcDevice) r3;
        if (r12 == null) goto L43;
        String r13 = r12.getDeviceId();
    L44:
        if (r13 != null) goto L46;
    L48:
        if (r0 == null) goto L50;
        FLogger.a.i("TaskUtils", "[resolvePcDeviceId] hit, branch=device_name_fallback");
    L51:
        return r0;
    L50:
        FLogger.a.i("TaskUtils", "[resolvePcDeviceId] miss, branch=device_name_fallback");
        goto L51
    L46:
        if ((!StringsKt.isBlank(r13)) == false) goto L48;
        r0 = r13;
        goto L48
    L35:
        r11 = null;
        goto L37
    L39:
        r3 = null;
    L43:
        r13 = null;
        goto L44
    L18:
        if ((!StringsKt.isBlank(r6)) == false) goto L20;
    L9:
        if ((!StringsKt.isBlank(r2)) == false) goto L11;
        goto L11
    }
}
