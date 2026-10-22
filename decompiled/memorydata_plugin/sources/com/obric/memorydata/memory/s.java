package com.obric.memorydata.memory;

import android.content.Intent;
import android.os.Parcel;
import android.util.Base64;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/IntentTransform;", "", "<init>", "()V", "intentToString", "", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", ObricMemoryConstants.KEY_PACKAGE_NAME, "stringToIntent", TypedValues.Custom.S_STRING, "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f10512a = null;

    static {
        f10512a = new s();
    }

    private s() {
    }

    public final Intent a(String r3) {
        Intrinsics.checkNotNullParameter(r3, TypedValues.Custom.S_STRING);
        byte[] r4 = Base64.decode(r3, 0);
        Parcel r0 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(r0, "obtain(...)");
        r0.unmarshall(r4, 0, r4.length);
        r0.setDataPosition(0);
        Intent r2 = (Intent) ZeusTransformUtils.preCheckCast(Intent.CREATOR.createFromParcel(r0), Intent.class, "com.obric.memorydata.plugin");
        r0.recycle();
        Intrinsics.checkNotNull(r2);
        return r2;
    }

    public final String a(Intent r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
        Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Parcel r0 = Parcel.obtain();     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r0, "obtain(...)");     // Catch: Exception -> L5
        r3.writeToParcel(r0, 0);     // Catch: Exception -> L5
        r0.setDataPosition(0);     // Catch: Exception -> L5
        byte[] r5 = r0.marshall();     // Catch: Exception -> L5
        r0.recycle();     // Catch: Exception -> L5
        com.obric.memorydata.memory.tracker.c.f10533a.a(true, r4);     // Catch: Exception -> L5
        return Base64.encodeToString(r5, 0);
    L5:
        e = move-exception;
        com.obric.memorydata.memory.tracker.c.f10533a.a(false, r4);
        RunLog.INSTANCE.error("IntentTransform", "intentToString error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }
}
