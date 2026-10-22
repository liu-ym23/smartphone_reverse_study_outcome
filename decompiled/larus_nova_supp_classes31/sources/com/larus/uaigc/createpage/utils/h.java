package com.larus.uaigc.createpage.utils;

import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class h implements Function1 {
    public final /* synthetic */ hy9.f a;
    public final /* synthetic */ ImageEditSendMessageStrategy b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ String d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ Function1 f;
    public final /* synthetic */ int g;

    public /* synthetic */ h(hy9.f r1, ImageEditSendMessageStrategy r2, boolean r3, String r4, boolean r5, Function1 r6, int r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final Object invoke(Object r20) {
        hy9.f r2 = this.a;
        ImageEditSendMessageStrategy r6 = this.b;
        boolean r3 = this.c;
        String r4 = this.d;
        boolean r5 = this.e;
        Function1 r9 = this.f;
        int r10 = this.g;
        List r11 = (List) r20;
        Intrinsics.checkNotNullParameter(r11, "localMessageList");
        FLogger.a.i("ImageEditSendMessageStrategy", "ai beautify add image and text message success");
        if (r11.size() != 2) goto L16;
        Message r8 = (Message) CollectionsKt.firstOrNull(r11);
        if (r8 == null) goto L17;
        Message r12 = (Message) CollectionsKt.lastOrNull(r11);
        if (r12 == null) goto L18;
        ConcurrentHashMap r1 = ko8.b.a;
        ko8.b.b(r2.o, CollectionsKt.listOf(new String[]{r8.getLocalMessageId(), r12.getLocalMessageId()}));
        IConversationRepoService r13 = RepoDispatcherDelegate.b.f();
        String r7 = r8.getConversationId();
        if (r7 != null) goto L14;
        r7 = "";
    L14:
        IConversationRepoService.a.f(r13, r7, false, false, OmniBreakReason.OmniBreakReason_SEND_NEW_MSG, 4);
        r6.l(r8, 5, r3);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new ImageEditSendMessageStrategy$sendImageAndTextMessage$1$2$1(r2, r3, r4, r5, r6, r8, r12, r9, r10, r11, null), 2, null);
        return Unit.INSTANCE;
    L18:
        return Unit.INSTANCE;
    L17:
        return Unit.INSTANCE;
    L16:
        return Unit.INSTANCE;
    }
}
