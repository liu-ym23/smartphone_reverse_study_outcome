package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import com.google.gson.Gson;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\t\u001a\n\u0010\n\u001a\u00020\t*\u00020\u000b\"#\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\f"}, d2 = {"gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "getTimerAction", "Lcom/obric/eventkit/eventstaskmanager/TimerTaskAction;", "", "readStringOrEmpty", "Landroid/os/Parcel;", "eventstaskkit_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Lazy f8034a = null;

    static {
        f8034a = LazyKt.lazy(TimerTaskKt$gson$2.INSTANCE);
    }

    public static final Gson a() {
        return (Gson) ZeusTransformUtils.preCheckCast(f8034a.getValue(), Gson.class, "com.obric.memorydata.plugin");
    }

    public static final String a(Parcel r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r2 = r1.readString();
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2;
    }
}
