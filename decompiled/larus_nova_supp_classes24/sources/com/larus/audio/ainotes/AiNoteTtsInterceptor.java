package com.larus.audio.ainotes;

import android.app.Application;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.t1;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.tts.ITtsReaderInterceptor;
import com.larus.tts.TtsInterceptResult;
import com.larus.tts.TtsScene;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import f2a.d;
import f2a.f;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/audio/ainotes/AiNoteTtsInterceptor;", "Lcom/larus/tts/ITtsReaderInterceptor;", "<init>", "()V", "logger", "Lcom/larus/utils/logger/FlowFormatLogger;", "priority", "", "canHandle", "", "message", "Lcom/larus/im/bean/message/Message;", "scene", "Lcom/larus/tts/TtsScene;", "intercept", "Lcom/larus/tts/TtsInterceptResult;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AiNoteTtsInterceptor implements ITtsReaderInterceptor {
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
        return 20;
    }

    public AiNoteTtsInterceptor() {
        this.a = new d("Chat", "AiNoteTtsInterceptor");
    }

    public final TtsInterceptResult b(Message r11, TtsScene r12) {
        Intrinsics.checkNotNullParameter(r11, "message");
        Intrinsics.checkNotNullParameter(r12, "scene");
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L5;
        r0.y();
        t1 r1 = t1.a;
    L7:
        if (r1 != null) goto L9;
    L11:
        boolean r4 = false;
    L13:
        if (com.larus.audio.ainotes.a.d == true) goto L23;
        if (r1 != null) goto L16;
    L18:
        boolean r2 = false;
    L19:
        if (r2 == true) goto L23;
        return TtsInterceptResult.Pass;
    L16:
        if (r1.y0() != true) goto L18;
        r2 = true;
    L23:
        f2a.c r3 = this.a.a("[TTS][AI_NOTE_RECORDING] ");
        r3.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r5 = new Pair[5];
        f r6 = f.i;
        String r7 = r11.getMessageId();
        String r8 = "";
        if (r7 != null) goto L26;
        r7 = "";
    L26:
        r5[0] = TuplesKt.to(r6, r7);
        f r9 = new f("reply_id");
        String r10 = r11.getReplyId();
        if (r10 == null) goto L30;
        r8 = r10;
    L30:
        r5[1] = TuplesKt.to(r9, r8);
        r5[2] = TuplesKt.to(new f("content_type"), String.valueOf(r11.getContentType()));
        r5[3] = TuplesKt.to(new f("message_status_local"), String.valueOf(r11.getMessageStatusLocal()));
        r5[4] = TuplesKt.to(new f("message_status"), String.valueOf(r11.getMessageStatus()));
        r3.d(MapsKt.mapOf(r5));
        f2a.c.c(r3, null, 15);
        if (CollectionsKt.listOf(new TtsScene[]{TtsScene.Manual_Selector, TtsScene.Manual_LongPress, TtsScene.Manual_ActionView, TtsScene.Manual_Other}).contains(r12) == false) goto L38;
        s r13 = s.a;
        Application r14 = AppHost.a.getApplication();
        if (r4 == false) goto L35;
        int r15 = 2131898358;
    L36:
        r13.getClass();
        s.s(r14, r15);
        goto L38
    L35:
        r15 = 2131907325;
    L38:
        return TtsInterceptResult.Deny;
    L9:
        if (r1.j() != true) goto L11;
        r4 = true;
        goto L13
    L5:
        r1 = null;
        goto L7
    }
}
