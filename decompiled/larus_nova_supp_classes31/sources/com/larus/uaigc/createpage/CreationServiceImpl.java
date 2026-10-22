package com.larus.uaigc.createpage;

import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.larus.uaigc.creation.ICreationService;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/uaigc/createpage/CreationServiceImpl;", "Lcom/larus/uaigc/creation/ICreationService;", "<init>", "()V", "getAiReplicaWhiteTUrl", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationServiceImpl implements ICreationService {
    public CreationServiceImpl() {
    }

    @Override // com.larus.uaigc.creation.ICreationService
    public final Object a(Continuation<? super String> r5) {
        DigitalAvatarInfoManager r0 = DigitalAvatarInfoManager.a;
        r0.getClass();
        String r1 = (String) DigitalAvatarInfoManager.b.getValue();
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        if (r1.length() != 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L15;
        Object r6 = r0.c("", r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        return r6;
    L14:
        return (String) r6;
    L15:
        return r1;
    L8:
        r3 = false;
        goto L9
    }
}
