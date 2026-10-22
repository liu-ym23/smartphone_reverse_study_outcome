package com.larus.security.azeroth;

import com.larus.im.bean.message.Message;
import com.larus.im.depend.IAzerothService;
import com.larus.security.api.g;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/larus/security/azeroth/AzerothServiceImpl;", "Lcom/larus/im/depend/IAzerothService;", "<init>", "()V", "generateAndUploadFornaxToken", "", "curMsg", "Lcom/larus/im/bean/message/Message;", "source", "", "dislikeDetailType", "detailContent", "", "(Lcom/larus/im/bean/message/Message;ILjava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AzerothServiceImpl implements IAzerothService {
    public AzerothServiceImpl() {
    }

    public final Object a(Message r2, Integer r3, String r4, Continuation r5) {
        Object r6 = g.a(r2, 1, r3, r4, r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }
}
