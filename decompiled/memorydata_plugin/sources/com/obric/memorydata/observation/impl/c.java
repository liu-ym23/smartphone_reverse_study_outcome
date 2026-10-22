package com.obric.memorydata.observation.impl;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.cae.libs.nfc.CaeNfcCardInfo;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/observation/impl/OAutoRawObservationAdapter;", "", "<init>", "()V", "SOURCE_OAUTO", "", "toRawObservation", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "deviceId", "timestamp", "", "agentText", ObricMemoryConstants.KEY_SESSION_ID, "observation_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f11998a = null;

    static {
        f11998a = new c();
    }

    private c() {
    }

    public final RawObservationEntity a(String r23, long r24, String r26, String r27) {
        Intrinsics.checkNotNullParameter(r23, "deviceId");
        Intrinsics.checkNotNullParameter(r26, "agentText");
        Intrinsics.checkNotNullParameter(r27, ObricMemoryConstants.KEY_SESSION_ID);
        JSONObject r0 = new JSONObject().put("type", "agent_turn").put(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, r26);
        JSONObject r1 = new JSONObject().put("session_id", r27);
        String r2 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        String r3 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r3, "toString(...)");
        return new RawObservationEntity(0, r23, "oauto", r24, r24, r24, r2, r3, null, null, 0, 0, CaeNfcCardInfo.LIFE_CYCLE_ACTIVE, null);
    }
}
