package com.larus.voicecall.impl.continue_talk;

import ce8.c;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.tts.ITtsReaderInterceptor;
import com.larus.tts.TtsInterceptResult;
import com.larus.tts.TtsScene;
import com.obric.aivoice.core.data.NameKeys;
import f2a.d;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/voicecall/impl/continue_talk/ContinuousTalkTtsInterceptor;", "Lcom/larus/tts/ITtsReaderInterceptor;", "<init>", "()V", "logger", "Lcom/larus/utils/logger/FlowFormatLogger;", "priority", NameKeys.UnloadStrategy_No_Strategy, "canHandle", NameKeys.UnloadStrategy_No_Strategy, "message", "Lcom/larus/im/bean/message/Message;", "scene", "Lcom/larus/tts/TtsScene;", "intercept", "Lcom/larus/tts/TtsInterceptResult;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContinuousTalkTtsInterceptor implements ITtsReaderInterceptor {
    public final d a;

    public static final class a {
    }

    static {
    }

    public final boolean a(Message r2, TtsScene r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "scene");
        return true;
    }

    public final int priority() {
        return 30;
    }

    public ContinuousTalkTtsInterceptor() {
        this.a = new d("Chat", "ContinuousTalkTtsInterceptor");
    }

    public final TtsInterceptResult b(Message r6, TtsScene r7) {
        Intrinsics.checkNotNullParameter(r6, "message");
        Intrinsics.checkNotNullParameter(r7, "scene");
        if (c.a() == false) goto L13;
        t19.s.a.g(com.larus.utils.i.getActivity(AppHost.a.getApplication()), 2131901018, false);
        f2a.c r8 = this.a.a("[TTS][IS_CONTINUOUS_TALK]");
        r8.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r0 = new Pair[5];
        f2a.f r1 = f2a.f.i;
        String r3 = r6.getMessageId();
        String r4 = NameKeys.UnloadStrategy_No_Strategy;
        if (r3 != null) goto L7;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        r0[0] = TuplesKt.to(r1, r3);
        f2a.f r2 = new f2a.f("reply_id");
        String r5 = r6.getReplyId();
        if (r5 == null) goto L11;
        r4 = r5;
    L11:
        r0[1] = TuplesKt.to(r2, r4);
        r0[2] = TuplesKt.to(f2a.f.g, Integer.valueOf(r6.getContentType()));
        r0[3] = TuplesKt.to(new f2a.f("status_local"), Integer.valueOf(r6.getMessageStatusLocal()));
        r0[4] = TuplesKt.to(new f2a.f("status"), String.valueOf(r6.getMessageStatus()));
        r8.d(MapsKt.mapOf(r0));
        f2a.c.c(r8, null, 15);
        return TtsInterceptResult.Deny;
    L13:
        return TtsInterceptResult.Pass;
    }
}
