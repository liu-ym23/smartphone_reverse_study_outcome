package com.obric.memorydata.awareness.api.audio;

import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/awareness/api/audio/AlwaysOnAudioSource;", "Lcom/obric/memorydata/awareness/api/audio/IAlwaysOnAudioSource;", "<init>", "()V", ChatMessage.TYPE_QUERY, "Lcom/obric/memorydata/awareness/api/audio/AlwaysOnAudioQueryResult;", "startTimestampSeconds", "", "endTimestampSeconds", "awareness_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AlwaysOnAudioSource implements IAlwaysOnAudioSource {
    public static final AlwaysOnAudioSource INSTANCE = null;
    private final /* synthetic */ IAlwaysOnAudioSource $$delegate_0;

    static {
        INSTANCE = new AlwaysOnAudioSource();
    }

    private AlwaysOnAudioSource() {
        IAlwaysOnAudioSource r0 = (IAlwaysOnAudioSource) ZeusTransformUtils.preCheckCast(ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IAlwaysOnAudioSource.class)), IAlwaysOnAudioSource.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = (IAlwaysOnAudioSource) ZeusTransformUtils.preCheckCast(UnavailableAlwaysOnAudioSource.INSTANCE, IAlwaysOnAudioSource.class, "com.obric.memorydata.plugin");
    L5:
        this.$$delegate_0 = r0;
    }

    @Override // com.obric.memorydata.awareness.api.audio.IAlwaysOnAudioSource
    public AlwaysOnAudioQueryResult query(long r1, long r3) {
        return this.$$delegate_0.query(r1, r3);
    }
}
