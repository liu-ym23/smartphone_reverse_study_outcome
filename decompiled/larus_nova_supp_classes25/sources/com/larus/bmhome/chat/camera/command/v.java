package com.larus.bmhome.chat.camera.command;

import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.model.action.SuggestedActionData;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class v {
    public static final Lazy a = null;
    public static final Map<String, SuggestedActionData> b = null;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/larus/bmhome/chat/camera/command/SuggestedActionCache$defaultSuggestedActionData$2$1$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/larus/platform/model/action/SuggestedActionData;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class a extends TypeToken<SuggestedActionData> {
        public a() {
        }
    }

    static {
        a = LazyKt.lazy(new u());
        b = new LinkedHashMap();
    }

    public static SuggestedActionData a(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L18;
        Intrinsics.checkNotNullParameter(r3, "botId");
        SuggestedActionData r1 = (SuggestedActionData) ((LinkedHashMap) b).get(r3);
        if (r1 == null) goto L13;
        FLogger.a.i("SuggestedActionCache", "hit memory cache");
        return r1;
    L13:
        SuggestedActionData r4 = bc8.e.a.b(r3);
        if (r4 == null) goto L18;
        FLogger.a.i("SuggestedActionCache", "hit disk cache");
        return r4;
    L18:
        return (SuggestedActionData) a.getValue();
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }
}
