package ju0;

import com.bytedance.android.live.profit.format.voicechat.model.VoiceChatState;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e extends b {
    public final VoiceChatState b;
    public final long c;

    public e(JSONObject r7) {
        Intrinsics.checkNotNullParameter(r7, Constants.Keys.DATA);
        super(r7);
        VoiceChatState.a r0 = VoiceChatState.Companion;
        String r1 = r7.optString("cur_state", "unknown");
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "state");
        VoiceChatState[] r2 = VoiceChatState.values();
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L8;
        VoiceChatState r5 = r2[r4];
        if (Intrinsics.areEqual(r5.getState(), r1) == true) goto L9;
        r4 = r4 + 1;
    L9:
        if (r5 != null) goto L11;
        r5 = VoiceChatState.UNKNOWN;
    L11:
        this.b = r5;
        this.c = r7.optLong("event_time", 0);
        return;
    L8:
        r5 = null;
        goto L9
    }
}
