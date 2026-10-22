package com.bytedance.dataplatform;

import android.app.Application;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u001d\u001a\n\u0012\u0004\u0012\u0002H\u001f\u0018\u00010\u001e\"\u0004\b\u0000\u0010\u001f2\u0006\u0010 \u001a\u00020\u00072\u000e\u0010!\u001a\n\u0012\u0004\u0012\u0002H\u001f\u0018\u00010\u001cH\u0002J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007J.\u0010%\u001a\u00020#\"\u0004\b\u0000\u0010\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u001c2\u0006\u0010 \u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0007H\u0002J$\u0010'\u001a\n\u0012\u0004\u0012\u0002H\u001f\u0018\u00010\u001e\"\u0004\b\u0000\u0010\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u001cH\u0002JC\u0010(\u001a\u0002H\u001f\"\u0004\b\u0000\u0010\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u0001H\u001f2\u0006\u0010,\u001a\u00020-2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u0002H\u001f\u0018\u00010\u001c¢\u0006\u0002\u0010.J\u001e\u0010/\u001a\u00020-\"\u0004\b\u0000\u0010\u001f2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u0002H\u001f\u0018\u00010\u001cH\u0002J\u001a\u00100\u001a\u00020#2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0015J\u000e\u00102\u001a\u00020#2\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R[\u0010\u0005\u001aB\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00040\u0004 \b* \u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\t0\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0019\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/dataplatform/ClientExperimentManager;", "", "()V", "MAX_NUM", "", "clientExperimentLayer", "", "", "kotlin.jvm.PlatformType", "", "getClientExperimentLayer", "()Ljava/util/Map;", "clientExperimentLayer$delegate", "Lkotlin/Lazy;", "context", "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "setContext", "(Landroid/app/Application;)V", "customRandomStrategy", "Lkotlin/Function1;", "exposureManager", "Lcom/bytedance/dataplatform/ExposureManager;", "key2Vid", "toExposureIds", "", "Lkotlin/Triple;", "Lcom/bytedance/dataplatform/client/ClientDataSource;", "assignClientExperimentValue", "Lcom/bytedance/dataplatform/client/ClientGroup;", ExifInterface.GPS_DIRECTION_TRUE, "key", "clientDataSource", "clearLayerAssign", "", "layer", "expose", "vid", "getOrAssignExperimentGroup", "getValue", "classType", "Ljava/lang/reflect/Type;", "defaultValue", "withExposure", "", "(Ljava/lang/String;Ljava/lang/reflect/Type;Ljava/lang/Object;ZLcom/bytedance/dataplatform/client/ClientDataSource;)Ljava/lang/Object;", "isDefinitionError", "setCustomRandomStrategy", "supplier", "setExposureManager", "experiment_release"}, k = 1, mv = {1, 1, 15})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f2249a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f2250b = null;
    private static Application c;
    private static f d;
    private static final List<Triple<String, com.bytedance.dataplatform.b.a<?>, String>> e = null;
    private static final Map<String, String> f = null;
    private static final Lazy g = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
    static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f2251a;

        a(f r1) {
            this.f2251a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(b.b(b.f2250b), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            Triple r1 = (Triple) ZeusTransformUtils.preCheckCast(r0.next(), Triple.class, "com.obric.memorydata.plugin");
            this.f2251a.a((String) ZeusTransformUtils.preCheckCast(r1.getFirst(), String.class, "com.obric.memorydata.plugin"), (com.bytedance.dataplatform.b.a) ZeusTransformUtils.preCheckCast(r1.getSecond(), com.bytedance.dataplatform.b.a.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r1.getThird(), String.class, "com.obric.memorydata.plugin"));
            goto L4
        }
    }

    static {
        f2249a = new KProperty[]{(KProperty) ZeusTransformUtils.preCheckCast(Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(b.class), "clientExperimentLayer", "getClientExperimentLayer()Ljava/util/Map;")), KProperty.class, "com.obric.memorydata.plugin")};
        f2250b = new b();
        e = (List) ZeusTransformUtils.preCheckCast(new CopyOnWriteArrayList(), List.class, "com.obric.memorydata.plugin");
        f = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.memorydata.plugin");
        g = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(ClientExperimentManager$clientExperimentLayer$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    private b() {
    }

    public static final /* synthetic */ f a(b r1) {
        f r2 = d;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("exposureManager");
    L5:
        return r2;
    }

    public static final /* synthetic */ void a(b r0, f r1) {
        d = r1;
    }

    public static final /* synthetic */ List b(b r0) {
        return e;
    }

    public final void a(Application r2) {
        c = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.memorydata.plugin");
    }

    public final void a(f r2) {
        Intrinsics.checkParameterIsNotNull(r2, "exposureManager");
        if (d != null) goto L6;
        Log.d("Experiment:", "setExposureManager");
        d = r2;
        l.a((Runnable) ZeusTransformUtils.preCheckCast(new a(r2), Runnable.class, "com.obric.memorydata.plugin"));
        return;
    }

    public final Application getContext() {
        return c;
    }
}
