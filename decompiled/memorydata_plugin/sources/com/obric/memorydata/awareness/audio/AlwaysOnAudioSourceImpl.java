package com.obric.memorydata.awareness.audio;

import android.content.Context;
import com.obric.memorydata.awareness.api.audio.AlwaysOnAudioError;
import com.obric.memorydata.awareness.api.audio.AlwaysOnAudioQueryResult;
import com.obric.memorydata.awareness.api.audio.IAlwaysOnAudioSource;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0000H\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/awareness/audio/AlwaysOnAudioSourceImpl;", "Lcom/obric/memorydata/awareness/api/audio/IAlwaysOnAudioSource;", "<init>", "()V", "TAG", "", "platformClient", "Lcom/obric/memorydata/awareness/audio/AlwaysOnRecordPlatformClient;", "getPlatformClient", "()Lcom/obric/memorydata/awareness/audio/AlwaysOnRecordPlatformClient;", "platformClient$delegate", "Lkotlin/Lazy;", "getInst", ChatMessage.TYPE_QUERY, "Lcom/obric/memorydata/awareness/api/audio/AlwaysOnAudioQueryResult;", "startTimestampSeconds", "", "endTimestampSeconds", "queryPlatform", "Lcom/obric/memorydata/awareness/audio/PlatformResult;", "Lorg/json/JSONArray;", "logFailure", "", "event", "error", "Lcom/obric/memorydata/awareness/api/audio/AlwaysOnAudioError;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AlwaysOnAudioSourceImpl implements IAlwaysOnAudioSource {
    public static final AlwaysOnAudioSourceImpl INSTANCE = null;
    private static final String TAG = "AlwaysOnAudioSource";
    private static final Lazy platformClient$delegate = null;

    static {
        INSTANCE = new AlwaysOnAudioSourceImpl();
        platformClient$delegate = LazyKt.lazy($$Lambda$AlwaysOnAudioSourceImpl$3F4nF_cCUswH7zItiaQ6riW4Ds.INSTANCE);
    }

    private AlwaysOnAudioSourceImpl() {
    }

    @JvmStatic
    public static final AlwaysOnAudioSourceImpl getInst() {
        return INSTANCE;
    }

    private final b getPlatformClient() {
        return (b) ZeusTransformUtils.preCheckCast(platformClient$delegate.getValue(), b.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$3F4nF_cCUs-wH7zItiaQ6riW4Ds, reason: not valid java name */
    public static /* synthetic */ g m472lambda$3F4nF_cCUswH7zItiaQ6riW4Ds() {
        return platformClient_delegate$lambda$0();
    }

    private final void logFailure(String r7, AlwaysOnAudioError r8) {
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "DataCenter operation failed, event=" + r7 + ", code=" + r8.name(), null, 4, null);
    }

    private static final g platformClient_delegate$lambda$0() {
        return new g((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    private final f<JSONArray> queryPlatform(long r2, long r4) {
    L15:
        return getPlatformClient().query(r2, r4);
    L7:
        e = move-exception;
        f.a r3 = new f.a(AlwaysOnAudioError.PLATFORM_UNAVAILABLE, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L12:
        return (f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.memorydata.plugin");
    L9:
        e = move-exception;
        r3 = new f.a(AlwaysOnAudioError.PERMISSION_DENIED, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        e = move-exception;
        r3 = new f.a(AlwaysOnAudioError.PLATFORM_CALL_FAILED, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L12
    }

    @Override // com.obric.memorydata.awareness.api.audio.IAlwaysOnAudioSource
    public AlwaysOnAudioQueryResult query(long r4, long r6) {
        if (r4 < 0) goto L19;
        if (r6 <= r4) goto L19;
        f<JSONArray> r5 = queryPlatform(r4, r6);
        if (ZeusTransformUtils.instanceOf(r5, f.b.class) == false) goto L13;
        AlwaysOnAudioQueryResult r3 = a.a((JSONArray) ZeusTransformUtils.preCheckCast(((f.b) ZeusTransformUtils.preCheckCast(r5, f.b.class, "com.obric.memorydata.plugin")).a(), JSONArray.class, "com.obric.memorydata.plugin"));
        if (r3.isSuccess() == false) goto L20;
        RunLog.INSTANCE.debug(TAG, "DataCenter query succeeded, count=" + r3.getSegments().size());
        return r3;
    L20:
        return r3;
    L13:
        if (ZeusTransformUtils.instanceOf(r5, f.a.class) == false) goto L17;
        logFailure("always_on_query", ((f.a) ZeusTransformUtils.preCheckCast(r5, f.a.class, "com.obric.memorydata.plugin")).a());
        return new AlwaysOnAudioQueryResult(null, ((f.a) ZeusTransformUtils.preCheckCast(r5, f.a.class, "com.obric.memorydata.plugin")).a(), 1, null);
    L17:
        throw new NoWhenBranchMatchedException();
    L19:
        return new AlwaysOnAudioQueryResult(null, AlwaysOnAudioError.INVALID_TIME_WINDOW, 1, null);
    }
}
