package com.obric.audio.enroll.sami;

import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantPropertyParameter;
import com.obric.assistant.common.spi.IObricSamiService;
import gd9.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/audio/enroll/sami/ObricSamiService;", "Lcom/obric/assistant/common/spi/IObricSamiService;", "Lcom/larus/im/depend/IPersonalContextProvider;", "<init>", "()V", "TAG", "", "resetAec", "", "samiCore", "", "getPersonalContextParam", "context", "taskId", "getPersonalContextId", "getPersonalContextType", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSamiService implements IObricSamiService, x {
    public final String a;

    public final SAMICorePropertyId b() {
        FLogger.a.i(this.a, "getPersonalContextId: Voice_Assistant_Update_Personal_Context");
        return SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Update_Personal_Context;
    }

    public final SAMICoreDataType c() {
        FLogger.a.i(this.a, "getPersonalContextType: Voice_Assistant_Property_Param");
        return SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
    }

    public ObricSamiService() {
        this.a = "ObricSamiAbility";
    }

    public final void d(SAMICore r4) {
        Intrinsics.checkNotNullParameter(r4, "samiCore");
        FLogger.a.i(this.a, "resetAec");
        SAMICoreProperty r0 = new SAMICoreProperty();
        SAMICorePropertyId r1 = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Reset_Aec;
        r0.id = r1;
        if ((r4 instanceof SAMICore) == true) goto L6;
        r4 = null;
    L6:
        if (r4 == null) goto L9;
        r4.SAMICoreSetProperty(r1, r0);
        return;
    }

    public final SAMICoreVoiceAssistantPropertyParameter a(String r6, String r7) {
        FLogger.a.i(this.a, "getPersonalContextParam: " + r6 + '=' + r6 + ", " + r7 + '=' + r7);
        SAMICoreVoiceAssistantPropertyParameter r0 = new SAMICoreVoiceAssistantPropertyParameter();
        r0.updatePersonalContextPayload = r6;
        r0.taskId = r7;
        return r0;
    }
}
