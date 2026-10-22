package com.larus.bmhome.input.api;

import kotlin.Metadata;
import kotlinx.coroutines.flow.i1;
import pp8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/input/api/EnterKeyBehaviorServiceNoop;", "Lcom/larus/bmhome/input/api/IEnterKeyBehaviorService;", "<init>", "()V", "getFinalBehavior", "Lcom/larus/bmhome/input/api/EnterKeyAction;", "finalBehavior", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class EnterKeyBehaviorServiceNoop implements IEnterKeyBehaviorService {
    public EnterKeyBehaviorServiceNoop() {
    }

    @Override // com.larus.bmhome.input.api.IEnterKeyBehaviorService
    public final EnterKeyAction a() {
        return EnterKeyAction.NEWLINE;
    }

    @Override // com.larus.bmhome.input.api.IEnterKeyBehaviorService
    /* JADX INFO: renamed from: a */
    public final i1<EnterKeyAction> mo10a() {
        return a.a;
    }
}
