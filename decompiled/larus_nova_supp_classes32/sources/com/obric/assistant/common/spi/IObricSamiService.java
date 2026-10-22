package com.obric.assistant.common.spi;

import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantPropertyParameter;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H&J\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\t\u001a\u0004\u0018\u00010\u0001H&J\n\u0010\n\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/common/spi/IObricSamiService;", NameKeys.UnloadStrategy_No_Strategy, "resetAec", NameKeys.UnloadStrategy_No_Strategy, "samiCore", "getPersonalContextParam", "context", NameKeys.UnloadStrategy_No_Strategy, "taskId", "getPersonalContextId", "getPersonalContextType", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricSamiService {
    SAMICoreVoiceAssistantPropertyParameter a(String r1, String r2);

    SAMICorePropertyId b();

    SAMICoreDataType c();

    void d(SAMICore r1);
}
