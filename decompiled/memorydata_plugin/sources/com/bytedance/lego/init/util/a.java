package com.bytedance.lego.init.util;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.config.ProcessMatchMode;
import com.bytedance.lego.init.model.DelayTaskInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"supportCurProcess", "", "Lcom/bytedance/lego/init/model/DelayTaskInfo;", "getSupportCurProcess", "(Lcom/bytedance/lego/init/model/DelayTaskInfo;)Z", "initscheduler_release"}, k = 2, mv = {1, 1, 13})
public final class a {
    public static final boolean a(DelayTaskInfo r6) {
        Intrinsics.checkParameterIsNotNull(r6, "receiver$0");
        if (r6.runInProcess.contains(LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL) == false) goto L6;
        return true;
    L6:
        if (r6.runInProcess.contains(InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName()) == false) goto L9;
        return true;
    L9:
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().isMainProcess() == false) goto L13;
        return r6.runInProcess.contains("main");
    L13:
        if (r6.runInProcess.contains("nonmain") == false) goto L15;
        return true;
    L15:
        ProcessMatchMode r0 = InitScheduler.INSTANCE.getProcessMatchMode$initscheduler_release();
        int r1 = b.f2797a[r0.ordinal()];
        if (r1 != 1) goto L18;
        List<String> r7 = r6.runInProcess;
        Intrinsics.checkExpressionValueIsNotNull(r7, "runInProcess");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L28:
        if (r8.hasNext() == false) goto L41;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        String r3 = InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName();
        Intrinsics.checkExpressionValueIsNotNull(r2, "it");
        if (StringsKt.endsWith(r3, r2, true) == false) goto L28;
        return true;
    L41:
        return false;
    L18:
        if (r1 != 2) goto L32;
        List<String> r9 = r6.runInProcess;
        Intrinsics.checkExpressionValueIsNotNull(r9, "runInProcess");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L22:
        if (r10.hasNext() == false) goto L40;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName(), CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkExpressionValueIsNotNull(r4, "it");
        if (StringsKt.contains(r5, (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"), true) == false) goto L22;
        return true;
    L40:
        return false;
    L32:
        return false;
    }
}
