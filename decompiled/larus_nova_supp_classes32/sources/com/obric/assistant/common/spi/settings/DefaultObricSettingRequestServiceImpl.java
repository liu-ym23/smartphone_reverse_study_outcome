package com.obric.assistant.common.spi.settings;

import com.obric.aivoice.core.data.NameKeys;
import h37.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/common/spi/settings/DefaultObricSettingRequestServiceImpl;", "Lcom/obric/assistant/common/spi/settings/IObricSettingRequestService;", "<init>", "()V", "overrideSettingResponse", NameKeys.UnloadStrategy_No_Strategy, "response", NameKeys.UnloadStrategy_No_Strategy, "overrideByObricSettings", "Lorg/json/JSONObject;", "appSettings", "Companion", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricSettingRequestServiceImpl implements IObricSettingRequestService {

    public static final class a {
    }

    static {
    }

    public DefaultObricSettingRequestServiceImpl() {
    }

    public final void a(c r2) {
        Intrinsics.checkNotNullParameter(r2, "response");
    }

    public final JSONObject b(JSONObject r1) {
        return null;
    }
}
