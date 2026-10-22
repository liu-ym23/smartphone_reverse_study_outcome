package com.obric.capability.schedulekit;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.intent.AppIntentImplInfo;
import com.obric.capabilitykit.common.intent.IntentSdkVersion;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/obric/capability/schedulekit/IntentSdkVersionResolver;", "", "()V", "TAG", "", "versionCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getSdkVersionByIntent", "intentName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSdkVersionByPackage", ObricMemoryConstants.KEY_PACKAGE_NAME, "invalidate", "", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f7411a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Integer> f7412b = null;

    static {
        f7411a = new f();
        f7412b = new ConcurrentHashMap();
    }

    private f() {
    }

    public final int a(String r6) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        int r1 = 0;
        if (r5 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == false) goto L11;
        return 0;
    L11:
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(f7412b.get(r6), Integer.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L24;
        return r8.intValue();
    L24:
        ApplicationInfo r9 = ((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.capability.schedulekit.a.c.f7378a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getApplicationInfo(r6, 128);     // Catch: Throwable -> L20
        Intrinsics.checkNotNullExpressionValue(r9, "context.packageManager.g…T_META_DATA\n            )");     // Catch: Throwable -> L20
        Bundle r10 = r9.metaData;     // Catch: Throwable -> L20
        if (r10 == null) goto L22;
        r1 = r10.getInt(IntentSdkVersion.META_DATA_KEY, 0);     // Catch: Throwable -> L20
    L22:
        ((Map) ZeusTransformUtils.preCheckCast(f7412b, Map.class, "com.obric.memorydata.plugin")).put(r6, Integer.valueOf(r1));
        return r1;
    L20:
        th = move-exception;
        com.obric.capability.schedulekit.b.c.f7384a.d("IntentSdkVersionResolver", "getSdkVersionByPackage(" + r6 + ") failed: " + th.getMessage());
        goto L22
    L5:
        if (r5.length() == 0) goto L8;
        r7 = false;
        goto L9
    }

    public final Object a(String r5, Continuation<? super Integer> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, IntentSdkVersionResolver$getSdkVersionByIntent$1.class) == false) goto L7;
        IntentSdkVersionResolver$getSdkVersionByIntent$1 r0 = (IntentSdkVersionResolver$getSdkVersionByIntent$1) ZeusTransformUtils.preCheckCast(r7, IntentSdkVersionResolver$getSdkVersionByIntent$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        boolean r3 = true;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r5 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
    L17:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L20;
    L23:
        if (r3 == false) goto L26;
        com.obric.capability.schedulekit.b.c.f7384a.d("IntentSdkVersionResolver", "getSdkVersionByIntent(" + r5 + ") no impl found");
        return Boxing.boxInt(0);
    L26:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r11.hasNext() == false) goto L36;
        Comparable r12 = (Comparable) ZeusTransformUtils.preCheckCast(Boxing.boxInt(f7411a.a(((AppIntentImplInfo) ZeusTransformUtils.preCheckCast(r11.next(), AppIntentImplInfo.class, "com.obric.memorydata.plugin")).getPackageName())), Comparable.class, "com.obric.memorydata.plugin");
    L30:
        if (r11.hasNext() == false) goto L34;
        Comparable r13 = (Comparable) ZeusTransformUtils.preCheckCast(Boxing.boxInt(f7411a.a(((AppIntentImplInfo) ZeusTransformUtils.preCheckCast(r11.next(), AppIntentImplInfo.class, "com.obric.memorydata.plugin")).getPackageName())), Comparable.class, "com.obric.memorydata.plugin");
        if (r12.compareTo(r13) >= 0) goto L30;
        r12 = r13;
        goto L30
    L34:
        return r12;
    L36:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new NoSuchElementException(), Throwable.class, "com.obric.memorydata.plugin"));
    L20:
        if (r10.isEmpty() == true) goto L23;
        r3 = false;
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r4);
        a r14 = a.f7373a;
        r0.L$0 = r5;
        r0.label = 1;
        r4 = r14.a(r5, r0);
        if (r4 != r8) goto L17;
        return r8;
    L7:
        r0 = new IntentSdkVersionResolver$getSdkVersionByIntent$1(this, r7);
        goto L8
    }
}
