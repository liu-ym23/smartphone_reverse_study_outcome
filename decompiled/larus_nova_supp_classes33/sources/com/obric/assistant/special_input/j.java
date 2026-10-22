package com.obric.assistant.special_input;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j {
    public static final kotlinx.coroutines.flow.b1 a = null;

    public j() {
    }

    static {
        OSkillExtensionSettingRepository.a.getClass();
        a = OSkillExtensionSettingRepository.j;
    }

    public static /* synthetic */ boolean b() {
        return a(0);
    }

    public static boolean a(long r5) {
        OSkillExtensionSettingRepository.a.getClass();
        if (OSkillExtensionSettingRepository.c() == true) goto L5;
        OSkillExtensionSettingRepository.e();
        return false;
    L5:
        OSkillExtensionSettingRepository.a();
        if (r5 > 0) goto L34;
        OSkillExtensionSettingRepository.b("lazy_read");
    L23:
        t0 r6 = (t0) OSkillExtensionSettingRepository.i.getValue();
        if (r6.e != 1) goto L26;
        boolean r7 = true;
    L27:
        if (r7 == true) goto L29;
        return false;
    L29:
        if (r6.a == false) goto L38;
        return true;
    L38:
        return false;
    L26:
        r7 = false;
        goto L27
    L34:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        Object r1 = Result.constructor-impl(Boolean.valueOf(OSkillExtensionSettingRepository.d.tryLock(r5, TimeUnit.MILLISECONDS)));     // Catch: Throwable -> L9
    L11:
        Boolean r2 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L15;
        r1 = r2;
    L15:
        if (((Boolean) r1).booleanValue() == true) goto L32;
        t0 r3 = (t0) OSkillExtensionSettingRepository.i.getValue();
        FLogger.a.w("SkillExtSettingRepo", "syncRemoteState timeout for send, timeoutMs=" + r5 + ", enabled=" + r3.a + ", hasLoadedRemote=" + r3.c + ", omniSkillAvailableState=" + r3.e + ", hasLoadedOmniSkillAvailableRemote=" + r3.f);
        goto L23
    L32:
        OSkillExtensionSettingRepository.f("send_message_sync");     // Catch: Throwable -> L19
        OSkillExtensionSettingRepository.d.unlock();
    L19:
        th = move-exception;
        OSkillExtensionSettingRepository.d.unlock();
        throw th;
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}
