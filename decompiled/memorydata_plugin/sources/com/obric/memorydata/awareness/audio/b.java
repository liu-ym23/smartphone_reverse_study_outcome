package com.obric.memorydata.awareness.audio;

import com.obric.memorydata.database.entity.ChatMessage;
import kotlin.Metadata;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/awareness/audio/AlwaysOnRecordPlatformClient;", "", ChatMessage.TYPE_QUERY, "Lcom/obric/memorydata/awareness/audio/PlatformResult;", "Lorg/json/JSONArray;", "startTimestampSeconds", "", "endTimestampSeconds", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface b {
    f<JSONArray> query(long r1, long r3);
}
