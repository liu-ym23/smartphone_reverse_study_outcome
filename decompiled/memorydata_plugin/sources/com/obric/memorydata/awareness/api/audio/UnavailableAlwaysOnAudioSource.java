package com.obric.memorydata.awareness.api.audio;

import com.obric.memorydata.database.entity.ChatMessage;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/awareness/api/audio/UnavailableAlwaysOnAudioSource;", "Lcom/obric/memorydata/awareness/api/audio/IAlwaysOnAudioSource;", "<init>", "()V", ChatMessage.TYPE_QUERY, "Lcom/obric/memorydata/awareness/api/audio/AlwaysOnAudioQueryResult;", "startTimestampSeconds", "", "endTimestampSeconds", "awareness_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class UnavailableAlwaysOnAudioSource implements IAlwaysOnAudioSource {
    public static final UnavailableAlwaysOnAudioSource INSTANCE = null;

    static {
        INSTANCE = new UnavailableAlwaysOnAudioSource();
    }

    private UnavailableAlwaysOnAudioSource() {
    }

    @Override // com.obric.memorydata.awareness.api.audio.IAlwaysOnAudioSource
    public AlwaysOnAudioQueryResult query(long r1, long r3) {
        return new AlwaysOnAudioQueryResult(null, AlwaysOnAudioError.PLATFORM_UNAVAILABLE, 1, null);
    }
}
