package com.larus.bmhome.chat.component.list;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;
import ky9.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n5 implements IIMCallback<Message> {
    public final /* synthetic */ a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Message c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public final boolean mustInMain() {
        return false;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    public final void onSuccess(Object r7) {
        Message r3 = (Message) r7;
        Intrinsics.checkNotNullParameter(r3, "result");
        this.a.d(this.b, this.c, r3, this.d, this.e);
    }

    public n5(a r1, String r2, Message r3, String r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
