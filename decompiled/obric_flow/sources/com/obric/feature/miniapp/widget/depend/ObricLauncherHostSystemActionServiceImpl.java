package com.obric.feature.miniapp.widget.depend;

import android.content.ClipData;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.method.system.AbsGetLocationMethodIDL;
import com.lynx.tasm.behavior.ui.utils.e;
import k2.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import n1.c;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J1\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/obric/feature/miniapp/widget/depend/ObricLauncherHostSystemActionServiceImpl;", "<init>", "()V", "Landroid/hardware/SensorManager;", "sensorManager", "Ln1/c;", "bridgeContext", "", "bridgeName", "", "type", "Landroid/hardware/Sensor;", "getDefaultSensor", "(Landroid/hardware/SensorManager;Ln1/c;Ljava/lang/String;I)Landroid/hardware/Sensor;", "Landroid/content/Context;", "context", "Lk2/a;", "callback", "", "getLocation", "(Landroid/content/Context;Lk2/a;)V", "Landroid/content/ClipData;", "getPrimaryClip", "(Landroid/content/Context;Ln1/c;Ljava/lang/String;)Landroid/content/ClipData;", "", "hasPrimaryClip", "(Landroid/content/Context;Ln1/c;Ljava/lang/String;)Z", "clipData", "setPrimaryClip", "(Landroid/content/Context;Ln1/c;Ljava/lang/String;Landroid/content/ClipData;)V", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObricLauncherHostSystemActionServiceImpl {
    public ObricLauncherHostSystemActionServiceImpl() {
    }

    public Sensor getDefaultSensor(SensorManager r5, c r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "sensorManager");
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "bridgeName");
        return r5.getDefaultSensor(r12);
    }

    public void getLocation(Context r5, a r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "callback");
        com.bytedance.ai.bridge.method.system.a r11 = (com.bytedance.ai.bridge.method.system.a) r10;
        r11.getClass();
        Intrinsics.checkNotNullParameter("location not available", "msg");
        Intrinsics.checkNotNullParameter(AbsGetLocationMethodIDL.GetLocationResultModel.class, "<this>");
        BaseModel r12 = e.c(AbsGetLocationMethodIDL.GetLocationResultModel.class);
        AbsGetLocationMethodIDL.GetLocationResultModel r13 = (AbsGetLocationMethodIDL.GetLocationResultModel) r12;
        r13.setEnable(Boolean.valueOf(r11.f2006b));
        r13.setLongitude(null);
        r13.setLatitude(null);
        Unit r14 = Unit.INSTANCE;
        f r15 = r11.f2005a;
        r15.c("location not available", (ResultModel) r12);
    }

    public ClipData getPrimaryClip(Context r5, c r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "bridgeName");
        return null;
    }

    public boolean hasPrimaryClip(Context r5, c r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "bridgeName");
        return false;
    }

    public void setPrimaryClip(Context r5, c r10, String r11, ClipData r12) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "bridgeName");
        Intrinsics.checkNotNullParameter(r12, "clipData");
    }
}
