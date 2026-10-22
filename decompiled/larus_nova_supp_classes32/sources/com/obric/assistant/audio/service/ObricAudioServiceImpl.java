package com.obric.assistant.audio.service;

import android.media.AudioAttributes;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.audio.e;
import com.obric.assistant.common.spi.audio.IObricAudioService;
import com.obric.assistant.spi.audio.IObricTtsControlService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/audio/service/ObricAudioServiceImpl;", "Lcom/obric/assistant/common/spi/audio/IObricAudioService;", "<init>", "()V", "shouldNotPlayTts", NameKeys.UnloadStrategy_No_Strategy, "msg", "Lcom/larus/im/bean/message/Message;", "isComplexTaskMessage", "isOAutoCallUserMessageMustPlayTts", "getCurrentAudioFocusOwner", NameKeys.UnloadStrategy_No_Strategy, "isSystemNotification", "isCurrentFocusOwnerPhoneCall", "shouldBypassFocusFail", "scene", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAudioServiceImpl implements IObricAudioService {
    public ObricAudioServiceImpl() {
    }

    @Override // com.obric.assistant.common.spi.audio.IObricAudioService
    public final boolean d() {
        Lazy r0 = e.a;
        FLogger r2 = FLogger.a;
        r2.i("CurrentAudioFocusManager", "isSystemNotification");
        boolean r5 = false;
        if (e.d() == false) goto L39;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L26
        Object r4 = e.a();     // Catch: Throwable -> L26
        if (r4 == null) goto L36;
        String r6 = e.c(r4);     // Catch: Throwable -> L26
        r2.i("CurrentAudioFocusManager", "getPackageName: ".concat(r6));     // Catch: Throwable -> L26
        if (Intrinsics.areEqual(r6, "com.android.systemui") == false) goto L37;
        Method r1 = r4.getClass().getMethod("getAudioAttributes", new Class[0]);     // Catch: Throwable -> L26
        r1.setAccessible(true);     // Catch: Throwable -> L26
        Object r7 = r1.invoke(r4, new Object[0]);     // Catch: Throwable -> L26
        if (r7 == null) goto L38;
        Method r8 = AudioAttributes.class.getMethod("getUsage", new Class[0]);     // Catch: Throwable -> L26
        r8.setAccessible(true);     // Catch: Throwable -> L26
        Object r9 = r8.invoke(r7, new Object[0]);     // Catch: Throwable -> L26
        if ((r9 instanceof Integer) == false) goto L17;
        Integer r10 = (Integer) r9;     // Catch: Throwable -> L26
    L18:
        if (r10 == null) goto L20;
        int r11 = r10.intValue();     // Catch: Throwable -> L26
    L21:
        r2.i("CurrentAudioFocusManager", "getAudioUsage: " + r11 + ", packageName: " + r6);     // Catch: Throwable -> L26
        if (r11 != 5) goto L24;
        r5 = true;
    L24:
        Object r12 = Result.constructor-impl(Boolean.valueOf(r5));     // Catch: Throwable -> L26
    L28:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L33;
        FLogger.a.i("CurrentAudioFocusManager", "isSystemNotification error: " + r13.getMessage());
        r12 = Boolean.FALSE;
    L33:
        return ((Boolean) r12).booleanValue();
    L20:
        r11 = -1;
        goto L21
    L17:
        r10 = null;
        goto L18
    L38:
        return false;
    L37:
        return false;
    L36:
        return false;
    L26:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L39:
        return false;
    }

    @Override // com.obric.assistant.common.spi.audio.IObricAudioService
    public final boolean e() {
        Lazy r0 = e.a;
        FLogger r1 = FLogger.a;
        r1.i("CurrentAudioFocusManager", "isCurrentFocusOwnerPhoneCall");
        String r2 = e.b();
        boolean r3 = e.b.contains(r2);
        if (r3 == false) goto L5;
        r1.i("CurrentAudioFocusManager", "phone call focus owner detected: " + r2);
    L5:
        return r3;
    }

    @Override // com.obric.assistant.common.spi.audio.IObricAudioService
    public final String c() {
        return e.b();
    }

    @Override // com.obric.assistant.common.spi.audio.IObricAudioService
    public final boolean b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        IObricTtsControlService r0 = (IObricTtsControlService) ServiceManager.get().getService(IObricTtsControlService.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.b(r3);
    }
}
