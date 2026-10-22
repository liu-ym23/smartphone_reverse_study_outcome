package com.larus.bmhome.chat.model;

import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.obric.assistant.spi.audio.IObricContinuousTalkService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Map a() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L8;
        FlowAppletServiceImpl r1 = r0.g0();
        if (r1 == null) goto L8;
        return r1.h();
    L8:
        return new LinkedHashMap();
    }

    public static boolean b(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        PlayStateEnum r0 = AudioServiceDelegate.a.r0().l();
        RepoDispatcher.a.getClass();
        if (Intrinsics.areEqual(RepoDispatcher.d.d.d.o6(), r5.getMessageId()) == true) goto L5;
    L9:
        boolean r1 = false;
    L10:
        IObricContinuousTalkService r2 = (IObricContinuousTalkService) ServiceManager.get().getService(IObricContinuousTalkService.class);
        if (r2 != null) goto L13;
    L15:
        boolean r6 = false;
    L16:
        if (r1 == true) goto L18;
        if (r6 == true) goto L18;
        return false;
    L18:
        return true;
    L13:
        if (r2.a(r5.getMessageId()) != true) goto L15;
        r6 = true;
        goto L16
    L5:
        if (r0 != PlayStateEnum.PLAY_STATE_PREPARE) goto L7;
    L8:
        r1 = true;
        goto L10
    L7:
        if (r0 != PlayStateEnum.PLAY_STATE_PLAYING) goto L9;
        goto L8
    }
}
