package com.larus.bmhome.chat.model.repo;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class u0 implements Function0 {
    public final /* synthetic */ ic8.w a;
    public final /* synthetic */ ChatSender b;
    public final /* synthetic */ Message c;

    public /* synthetic */ u0(ic8.w r1, ChatSender r2, Message r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        ic8.w r0 = this.a;
        ChatSender r2 = this.b;
        Message r3 = this.c;
        if ((r0 instanceof ai8.b) == false) goto L18;
        String r1 = ((ai8.b) r0).content();
        if (StringsKt.isBlank(r1) == false) goto L51;
    L13:
        Object r4 = null;
    L14:
        TextContent r5 = (TextContent) r4;
        if (r5 == null) goto L32;
        String r6 = r5.text;
    L34:
        if (r6 != null) goto L36;
    L47:
        BuildersKt.launch$default(r2.b, null, null, new ChatSender$sendAudioTextNew$2$3(r2, r3, null), 3, null);
        return Unit.INSTANCE;
    L36:
        if (com.larus.utils.o0.d(r6) == false) goto L38;
        String r7 = r6;
    L39:
        if (r7 == null) goto L47;
        IFlowSdkDepend r8 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r8 == null) goto L47;
        r8.P();
        Fragment r9 = ChatServiceImpl.a.f();
        if (r9 == null) goto L47;
        ICoreInputAbility r10 = a.g(r9).getAbility(ICoreInputAbility.class);
        if (r10 == null) goto L47;
        ICoreInputAbility.b.d(r10, r7, true, true, null, null, false, 56);
        goto L47
    L38:
        r7 = null;
    L32:
        r6 = null;
        goto L34
    L51:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L9
        r4 = Result.constructor-impl(HttpExtKt.f.fromJson(r1, TextContent.class));     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r4) == false) goto L14;
    L9:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L18:
        if ((r0 instanceof ai8.h) == false) goto L33;
        String r13 = ((ai8.h) r0).content();
        if (StringsKt.isBlank(r13) == false) goto L49;
    L28:
        Object r14 = null;
    L29:
        TextContent r15 = (TextContent) r14;
        if (r15 == null) goto L32;
        r6 = r15.text;
        goto L34
    L49:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L24
        r14 = Result.constructor-impl(HttpExtKt.f.fromJson(r13, TextContent.class));     // Catch: Throwable -> L24
    L27:
        if (Result.isFailure-impl(r14) == false) goto L29;
    L24:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L33:
        r6 = "";
        goto L34
    }
}
