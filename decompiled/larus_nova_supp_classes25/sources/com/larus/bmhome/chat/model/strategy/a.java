package com.larus.bmhome.chat.model.strategy;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a implements Function2 {
    public final /* synthetic */ ChatRetryStrategy a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ ChatPageContext e;
    public final /* synthetic */ Ref.ObjectRef f;
    public final /* synthetic */ wc9.e g;

    public /* synthetic */ a(ChatRetryStrategy r1, Message r2, String r3, String r4, ChatPageContext r5, Ref.ObjectRef r6, wc9.e r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final Object invoke(Object r19, Object r20) {
        final ChatRetryStrategy r2 = this.a;
        final Message r3 = this.b;
        String r5 = this.c;
        String r6 = this.d;
        ChatPageContext r9 = this.e;
        Ref.ObjectRef r10 = this.f;
        wc9.e r11 = this.g;
        Function1 r8 = new b(r2, r3);
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new ChatRetryStrategy$resendMediaMessage$uploadImageAfterAddMsg$1$1(r2, r3, (Map) r19, r5, r6, (Function1) r20, r8, r9, r10, r11, null), 3, null);
        return Unit.INSTANCE;
    }
}
