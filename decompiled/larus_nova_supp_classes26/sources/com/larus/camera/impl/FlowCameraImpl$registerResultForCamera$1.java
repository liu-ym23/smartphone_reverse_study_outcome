package com.larus.camera.impl;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.starter.StarterViewModel;
import com.larus.camera.impl.starter.b;
import com.larus.utils.lifecycle.SafeLifecycleObserver;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import jx8.j;
import jx8.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/larus/camera/impl/FlowCameraImpl$registerResultForCamera$1", "Lcom/larus/utils/lifecycle/SafeLifecycleObserver;", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowCameraImpl$registerResultForCamera$1 extends SafeLifecycleObserver {
    public final /* synthetic */ FlowCameraImpl a;
    public final /* synthetic */ Fragment b;
    public final /* synthetic */ Function1<CameraOutputContext, Unit> c;
    public final /* synthetic */ Function0<Unit> d;

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, jx8.m] */
    public final void onCreate(LifecycleOwner r14) {
        Intrinsics.checkNotNullParameter(r14, "owner");
        final FlowCameraImpl r15 = this.a;
        final Fragment r0 = this.b;
        final Function1<CameraOutputContext, Unit> r1 = this.c;
        final Function0<Unit> r2 = this.d;
        final ?? r3 = new m(r1, r2);
        r15.getClass();
        Intrinsics.checkNotNullParameter(r0, "fragment");
        Intrinsics.checkNotNullParameter(r3, "observer");
        final StarterViewModel r4 = (StarterViewModel) new ViewModelProvider(r0).get(StarterViewModel.class);
        MutableLiveData<CameraOutputContext> r5 = r4.getResultLiveEvent();
        r5.removeObservers(r0);
        r5.observe(r0, new FlowCameraImpl$c(new j(r4, r0, r15, r3)));
        Bundle r16 = r0.getArguments();
        OutputParam r6 = null;
        if (r16 == null) goto L5;
        String r17 = r16.getString("CAMERA_RESULT_ROUTE_TOKEN");
    L6:
        boolean r7 = true;
        if (r17 != null) goto L9;
    L12:
        boolean r8 = true;
    L13:
        if (r8 == false) goto L37;
        FragmentActivity r18 = r0.getActivity();
        if (r18 == null) goto L20;
        Intent r19 = r18.getIntent();
        if (r19 == null) goto L20;
        r17 = r19.getStringExtra("CAMERA_RESULT_ROUTE_TOKEN");
    L21:
        if (r17 != null) goto L23;
    L26:
        boolean r9 = true;
    L27:
        if (r9 == false) goto L37;
        FragmentActivity r110 = r0.getActivity();
        if (r110 == null) goto L36;
        Intent r111 = r110.getIntent();
        if (r111 == null) goto L36;
        Bundle r112 = r111.getExtras();
        if (r112 == null) goto L36;
        r17 = r112.getString("CAMERA_RESULT_ROUTE_TOKEN");
    L36:
        r17 = null;
        goto L37
    L23:
        if (r17.length() == 0) goto L26;
        r9 = false;
    L20:
        r17 = null;
    L37:
        if (r17 != null) goto L39;
    L42:
        boolean r10 = true;
    L44:
        if (r10 == true) goto L46;
        FLogger.a.i("FlowCameraImpl", "[route] observe register, fragment=" + r0.getClass().getSimpleName() + ", token=" + StringsKt.take(r17, 8) + "...");
    L47:
        if (r17 == null) goto L70;
        ConcurrentHashMap<String, CameraOutputContext> r11 = b.a;
        Intrinsics.checkNotNullParameter(r17, "token");
        if (r17.length() != 0) goto L51;
        boolean r12 = true;
    L53:
        if (r12 == false) goto L55;
        FLogger.a.w("CameraResultRoute", "[consume] empty token, miss");
        CameraOutputContext r13 = null;
    L60:
        if (r13 == null) goto L71;
        FLogger r113 = FLogger.a;
        StringBuilder r20 = new StringBuilder("[route] deliver pending result to fragment=");
        r20.append(r0.getClass().getSimpleName());
        r20.append(", listSize=");
        List<OutputParam> r21 = r13.getOutputParamList();
        if (r21 == null) goto L64;
        Integer r22 = Integer.valueOf(r21.size());
    L65:
        r20.append(r22);
        r20.append(", firstParam=");
        List<OutputParam> r23 = r13.getOutputParamList();
        if (r23 == null) goto L68;
        r6 = (OutputParam) CollectionsKt.firstOrNull(r23);
    L68:
        r20.append(r6);
        r113.i("FlowCameraImpl", r20.toString());
        r4.getResultLiveEvent().postValue(r13);
        return;
    L64:
        r22 = null;
        goto L65
    L71:
        return;
    L55:
        ConcurrentHashMap<String, CameraOutputContext> r24 = b.a;
        r13 = r24.remove(r17);
        FLogger r114 = FLogger.a;
        StringBuilder r115 = new StringBuilder("[consume] token=");
        r115.append(StringsKt.take(r17, 8));
        r115.append("..., hit=");
        if (r13 != null) goto L59;
        r7 = false;
    L59:
        r115.append(r7);
        r115.append(", size=");
        r115.append(r24.size());
        r114.i("CameraResultRoute", r115.toString());
        goto L60
    L51:
        r12 = false;
        goto L53
    L70:
        return;
    L46:
        FLogger.a.d("FlowCameraImpl", "[route] observe register, fragment=" + r0.getClass().getSimpleName() + ", token empty");
        goto L47
    L39:
        if (r17.length() == 0) goto L42;
        r10 = false;
        goto L44
    L9:
        if (r17.length() == 0) goto L12;
        r8 = false;
        goto L13
    L5:
        r17 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlowCameraImpl$registerResultForCamera$1(FlowCameraImpl r1, Fragment r2, Function1<? super CameraOutputContext, Unit> r3, Function0<Unit> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
