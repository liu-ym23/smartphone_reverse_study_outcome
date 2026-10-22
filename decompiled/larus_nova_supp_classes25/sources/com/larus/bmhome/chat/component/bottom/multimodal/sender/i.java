package com.larus.bmhome.chat.component.bottom.multimodal.sender;

import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i implements IIMCallback<Message> {
    public final /* synthetic */ Function1<Message, Unit> a;
    public final /* synthetic */ String b;
    public final /* synthetic */ CoreInputSender$observeNestedFileUpload$nestedFileUploadObserver$1 c;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    public final void onSuccess(Object r2) {
        Message r3 = (Message) r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        this.a.invoke(r3);
        NestedFileCacheManagerService r4 = NestedFileCacheManagerService.b;
        r4.b2(this.b);
        r4.g(this.b).removeObserver(this.c.a);
    }

    public i(Function1<? super Message, Unit> r1, String r2, CoreInputSender$observeNestedFileUpload$nestedFileUploadObserver$1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
