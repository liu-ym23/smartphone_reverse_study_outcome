package com.obric.memorydata.memory.ui.detail;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/SourceLinkIntentResolver;", "", "<init>", "()V", "TAG", "", "targetSourceApp", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "sourcePackageName", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ae f10847a = null;

    static {
        f10847a = new ae();
    }

    private ae() {
    }

    public final void a(Context r9, Intent r10, String r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r10, MemorySourceLinkType.INTENT);
        Intrinsics.checkNotNullParameter(r11, "sourcePackageName");
        r10.setPackage(r11);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        ae r8 = (ae) ZeusTransformUtils.preCheckCast(this, ae.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        List<ResolveInfo> r13 = r12.getPackageManager().queryIntentActivities(r10, 65536);     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r13, "queryIntentActivities(...)");     // Catch: Throwable -> L14
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Iterator r16 = r14.iterator();     // Catch: Throwable -> L14
    L5:
        if (r16.hasNext() == false) goto L12;
        ActivityInfo r1 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r16.next(), ResolveInfo.class, "com.obric.memorydata.plugin")).activityInfo;     // Catch: Throwable -> L14
        if (r1 != null) goto L9;
        ad r2 = null;
    L10:
        if (r2 == null) goto L5;
        r15.add(r2);     // Catch: Throwable -> L14
        goto L5
    L9:
        String r3 = r1.packageName;     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L14
        String r4 = r1.name;     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r4, ActivityLifecycle.NAME);     // Catch: Throwable -> L14
        r2 = new ad(r3, r4);     // Catch: Throwable -> L14
        goto L10
    L12:
        Object r17 = Result.m1421constructorimpl((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
    L16:
        Throwable r18 = Result.m1424exceptionOrNullimpl(r17);
        if (r18 == null) goto L19;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SourceLinkIntentResolver", "query source activities failed: " + r18.getMessage(), null, 4, null);
    L19:
        List r19 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r17) == false) goto L22;
        r17 = r19;
    L22:
        List r20 = (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin");
        ad r21 = af.a(r20, r11);
        if (r21 != null) goto L25;
        return;
    L25:
        r10.setComponent(new ComponentName(r21.a(), r21.b()));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SourceLinkIntentResolver", "pin source activity, package=" + r11 + ", candidates=" + r20 + ", component=" + r21.b(), false, 4, null);
        return;
    L14:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r17 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    }
}
