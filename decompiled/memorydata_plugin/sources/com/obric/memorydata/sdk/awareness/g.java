package com.obric.memorydata.sdk.awareness;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.sdk.MemoryResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u001c\u001a\u00020\u0018J\u0012\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e*\u0004\u0018\u00010\u0018J1\u0010 \u001a\u0004\u0018\u0001H!\"\b\b\u0000\u0010!*\u00020\"*\u00020\u00182\u0006\u0010#\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H!0%¢\u0006\u0002\u0010&R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/PersistentAwarenessContract;", "", "<init>", "()V", "AUTHORITY_MEMORYDATA_AWARENESS", "", "CALLBACK_AUTHORITY_SUFFIX", "METHOD_REGISTER_PERSISTENT_FEATURE_EVENT", "METHOD_REGISTER_PERSISTENT_CONTEXT_EVENT", "METHOD_ADD_GEOFENCE", "METHOD_REMOVE_GEOFENCE", "METHOD_UNREGISTER_PERSISTENT_SUBSCRIPTION", "METHOD_CLEAR_ALL_PERSISTENT_SUBSCRIPTIONS", "METHOD_PERSISTENT_AWARENESS_CALLBACK", "METHOD_REPORT_AWARENESS_EVENT", "KEY_REGISTER_REQUEST", "KEY_GEOFENCE_REQUEST", "KEY_FENCE_ID", "KEY_CALLBACK", "KEY_SUBSCRIPTION_ID", "KEY_AWARENESS_EVENT", "RESULT_CODE", "RESULT_MESSAGE", "resultBundle", "Landroid/os/Bundle;", "code", "", "message", "successBundle", "toMemoryResponse", "Lcom/obric/memorydata/sdk/MemoryResponse;", "Ljava/lang/Void;", "getParcelableCompat", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Parcelable;", "key", "clazz", "Ljava/lang/Class;", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Class;)Landroid/os/Parcelable;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f12826a = null;

    static {
        f12826a = new g();
    }

    private g() {
    }

    public final Bundle a(int r2, String r3) {
        Bundle r1 = new Bundle();
        r1.putInt("result_code", r2);
        r1.putString("result_message", r3);
        return r1;
    }

    public final <T extends Parcelable> T a(Bundle r3, String r4, Class<T> r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "clazz");
        r3.setClassLoader(r5.getClassLoader());
        if (Build.VERSION.SDK_INT < 33) goto L6;
        Parcelable r6 = (Parcelable) ZeusTransformUtils.preCheckCast(r3.getParcelable(r4, r5), Parcelable.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L10
    L9:
        return (T) r6;
    L6:
        r6 = r3.getParcelable(r4);     // Catch: RuntimeException -> L10
        if (ZeusTransformUtils.instanceOf(r6, Parcelable.class) == true) goto L9;
        return null;
    L13:
        return null;
    }

    public final MemoryResponse<Void> a(Bundle r13) {
        if (r13 != null) goto L7;
        return new MemoryResponse(400, "provider returns null", null, 4, null);
    L7:
        return new MemoryResponse(r13.getInt("result_code", 400), r13.getString("result_message"), null, 4, null);
    }
}
