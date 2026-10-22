package com.larus.asr.session.component;

import android.os.SystemClock;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h0 implements p0 {
    public final com.larus.asr.session.p a;
    public final boolean b;
    public final Function0<Boolean> c;
    public final Function1<f0, Unit> d;
    public final f2a.d e;

    public static final class a {
    }

    static {
    }

    public /* synthetic */ h0(com.larus.asr.session.p r3, Function0 r4) {
        this(r3, false, r4, new g0());
    }

    @Override // com.larus.asr.session.component.p0
    public final void b(b0 r12, com.larus.asr.session.i r13) {
        Intrinsics.checkNotNullParameter(r12, "event");
        Intrinsics.checkNotNullParameter(r13, "complete");
        f0 r0 = r12.getContext();
        wc9.e r1 = this.a.h();
        if (r1 == null) goto L5;
        String r2 = r1.a;
    L6:
        String r3 = "";
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        BotModel r4 = this.a.i();
        if (r4 == null) goto L12;
        String r10 = r4.getBotId();
    L14:
        if (((Boolean) this.c.invoke()).booleanValue() == false) goto L16;
        IConversationRepoService.a.f(RepoDispatcherDelegate.b.f(), r2, false, false, OmniBreakReason.OmniBreakReason_CLICK_ASR, 6);
    L16:
        f2a.c r5 = this.e.b("onSpeak called, elapsedRealtime:" + SystemClock.elapsedRealtime());
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put(new f2a.f("from_text_area"), String.valueOf(r0.b().b));
        r6.put(new f2a.f("asr_only"), String.valueOf(this.b));
        r6.put(f2a.f.h, r2);
        f2a.f r7 = f2a.f.e;
        if (r10 == null) goto L20;
        r3 = r10;
    L20:
        r6.put(r7, r3);
        r5.d(r6);
        r5.c.d = "invokeOnSpeak";
        r5.c.b = CollectionsKt.listOf(r0.b().d.a);
        r5.c.e = r0.b().d.b;
        f2a.c.c(r5, null, 15);
        if (((Boolean) r12.e.invoke()).booleanValue() == true) goto L24;
        r13.invoke(c0.a.a);
        return;
    L24:
        this.d.invoke(r0);
        r13.invoke(c0.b.a);
        return;
    L12:
        r10 = null;
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h0(com.larus.asr.session.p r2, boolean r3, Function0<Boolean> r4, Function1<? super f0, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r4, "shouldInterruptReply");
        Intrinsics.checkNotNullParameter(r5, "onPrepared");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = new f2a.d("VoiceInput", "AsrStartPreparePre");
    }
}
