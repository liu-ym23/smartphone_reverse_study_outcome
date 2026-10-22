package com.obric.memorydata.awareness.audio;

import android.content.Context;
import android.datacenter.perception.AlwaysOnRecordManager;
import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.awareness.api.audio.AlwaysOnAudioError;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J#\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00130\r\"\u0004\b\u0000\u0010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0015H\u0082\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/awareness/audio/SdkAlwaysOnRecordPlatformClient;", "Lcom/obric/memorydata/awareness/audio/AlwaysOnRecordPlatformClient;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "manager", "Landroid/datacenter/perception/AlwaysOnRecordManager;", "getManager", "()Landroid/datacenter/perception/AlwaysOnRecordManager;", "manager$delegate", "Lkotlin/Lazy;", ChatMessage.TYPE_QUERY, "Lcom/obric/memorydata/awareness/audio/PlatformResult;", "Lorg/json/JSONArray;", "startTimestampSeconds", "", "endTimestampSeconds", "callSdk", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function0;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f8536b;

    public g(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.f8535a = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
        this.f8536b = LazyKt.lazy(new $$Lambda$g$h7fKYlI4mI3PKBMLM8821MsHAp4(this));
    }

    private final AlwaysOnRecordManager a() {
        return (AlwaysOnRecordManager) ZeusTransformUtils.preCheckCast(this.f8536b.getValue(), AlwaysOnRecordManager.class, "com.obric.memorydata.plugin");
    }

    private static final AlwaysOnRecordManager a(g r1) {
        return new AlwaysOnRecordManager(r1.f8535a);
    }

    public static /* synthetic */ AlwaysOnRecordManager lambda$h7fKYlI4mI3PKBMLM8821MsHAp4(g r0) {
        return a(r0);
    }

    @Override // com.obric.memorydata.awareness.audio.b
    public synchronized f<JSONArray> query(long r2, long r4) {
        monitor-enter(this);
        f r3 = (f) ZeusTransformUtils.preCheckCast(new f.b(a().queryRecordData(r2, r4)), f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5 RuntimeException -> L7 LinkageError -> L10 SecurityException -> L12
    L14:
        f<JSONArray> r5 = a.a(r3);     // Catch: Throwable -> L5
        monitor-exit(this);
        return r5;
    L5:
        th = move-exception;
        throw th;
    L7:
        e = move-exception;
        Object r6 = ZeusTransformUtils.preCheckCast(new f.a(AlwaysOnAudioError.PLATFORM_CALL_FAILED, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
    L9:
        r3 = (f) r6;     // Catch: Throwable -> L5
    L10:
        e = move-exception;
        r6 = ZeusTransformUtils.preCheckCast(new f.a(AlwaysOnAudioError.PLATFORM_UNAVAILABLE, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
    L12:
        e = move-exception;
        r6 = ZeusTransformUtils.preCheckCast(new f.a(AlwaysOnAudioError.PERMISSION_DENIED, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        goto L9
    }
}
