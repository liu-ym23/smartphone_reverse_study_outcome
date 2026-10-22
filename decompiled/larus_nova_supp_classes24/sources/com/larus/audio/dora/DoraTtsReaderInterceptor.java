package com.larus.audio.dora;

import android.app.Application;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.tts.ITtsReaderInterceptor;
import com.larus.tts.TtsInterceptResult;
import com.larus.tts.TtsScene;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.dora.ObricDoraDelegate;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/audio/dora/DoraTtsReaderInterceptor;", "Lcom/larus/tts/ITtsReaderInterceptor;", "<init>", "()V", "intercept", "Lcom/larus/tts/TtsInterceptResult;", "message", "Lcom/larus/im/bean/message/Message;", "scene", "Lcom/larus/tts/TtsScene;", "canHandle", "", "priority", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class DoraTtsReaderInterceptor implements ITtsReaderInterceptor {

    public static final class a {
    }

    static {
    }

    public DoraTtsReaderInterceptor() {
    }

    public final int priority() {
        return 40;
    }

    public final boolean a(Message r2, TtsScene r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "scene");
        FLogger.a.i("DoraTtsReaderInterceptor", "canHandle");
        return true;
    }

    public final TtsInterceptResult b(Message r4, TtsScene r5) {
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r5, "scene");
        if (f78.a.a.b() == false) goto L11;
        if (ObricDoraDelegate.b.t() == true) goto L11;
        if (CollectionsKt.listOf(new TtsScene[]{TtsScene.Auto_Streaming, TtsScene.Auto_ReceiveMessage, TtsScene.Auto_UpdateMessage, TtsScene.Auto_OnBoarding, TtsScene.Auto_Other}).contains(r5) == true) goto L9;
        s r6 = s.a;
        AppHost.Companion r0 = AppHost.a;
        Application r1 = r0.getApplication();
        String r2 = r0.getApplication().getString(2131901654);
        r6.getClass();
        s.t(r1, r2);
    L9:
        FLogger.a.i("ManualReadTtsInterceptor", "[TTS][DORA_IS_WAKE_UP] messageId = " + r4.getMessageId() + ", replyId: " + r4.getReplyId() + ", contentType:" + r4.getContentType() + ", status:" + r4.getMessageStatusLocal() + ", " + r4.getMessageStatus());
        return TtsInterceptResult.Deny;
    L11:
        return TtsInterceptResult.Pass;
    }
}
