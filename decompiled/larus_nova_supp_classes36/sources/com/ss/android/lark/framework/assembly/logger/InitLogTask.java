package com.ss.android.lark.framework.assembly.logger;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.lark.kmp.logger.LarkLogger;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.utils.ApkUtil;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.log.f;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.utils.a0;
import com.ss.android.lark.utils.o0;
import com.ss.android.rust.molten.ffi.LogConfig;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import se6.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 %2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002$%B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010!\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010\u0007\u001a\u0013\u0012\u000f\u0012\r\u0012\t\u0012\u00070\n¢\u0006\u0002\b\u000b0\t0\b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006&"}, d2 = {"Lcom/ss/android/lark/framework/assembly/logger/InitLogTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "", "<init>", "()V", "isMoltenLibLoaded", "", "logMufflers", "Ljavax/inject/Provider;", "", "Lcom/ss/android/lark/log/ILogMuffler;", "Lkotlin/jvm/JvmSuppressWildcards;", "getLogMufflers", "()Ljavax/inject/Provider;", "setLogMufflers", "(Ljavax/inject/Provider;)V", "execute", "", "context", "Landroid/content/Context;", "initLog", "initKmpLogger", "logConfig", "Lcom/ss/android/lark/log/LogConfig;", "isPrivateKA", "aLogEvent", "Lcom/ss/android/lark/log/alog/IALogEvent;", "getALogEvent", "()Lcom/ss/android/lark/log/alog/IALogEvent;", "isMoltenLogLibEnable", "isNeedLog", "getProcessName", "", "printTrackLog", "tag", INotificationHitPoint.NoticeType.MESSAGE, "CipherKeyConfiguration", "Companion", "logger-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class InitLogTask extends AbstractLaunchTask<Object> {
    public boolean c;

    @Inject
    public Provider<Set<com.ss.android.lark.log.b>> d;

    public final class a implements f.b {
        @Override // com.ss.android.lark.log.f.b
        public final Pair<String, String> a() {
            LogCipherConfigHandler.LogCipherConfig r0 = LogCipherConfigHandler.j;
            if (r0 != null) goto L7;
            return null;
        L7:
            return new Pair(r0.getKeyId(), r0.getPublicKey());
        }

        public a() {
        }
    }

    public static final class b {
    }

    static {
    }

    @Inject
    public InitLogTask() {
    }

    public final void a(final Context r18) {
        Intrinsics.checkNotNullParameter(r18, "context");
        int r3 = jac.a.a;
        boolean r4 = false;
        if (r18 == null) goto L10;
        String r5 = z.b(r18);
        if (TextUtils.isEmpty(r5) == true) goto L10;
        if (r5.contains(":sandboxed_process") == false) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == true) goto L22;
        Provider<Set<com.ss.android.lark.log.b>> r7 = this.d;
        if (r7 == null) goto L21;
        Set r8 = (Set) r7.get();
        if (r8 == null) goto L21;
        Iterator r9 = r8.iterator();
    L19:
        if (r9.hasNext() == false) goto L21;
        ((com.ss.android.lark.log.b) r9.next()).a(r18);
    L21:
        r4 = true;
    L22:
        if (r4 == false) goto L51;
        LogCipherConfigHandler r10 = LogCipherConfigHandler.i;
        Intrinsics.checkNotNullParameter(r18, "context");
        LogCipherConfigHandler r0 = LogCipherConfigHandler.i;
        AbstractBaseSettingHandler.a r11 = r0.e;
        r11.c(new LogCipherConfigHandler$init$1(r18));
        Function0<Unit> r12 = new LogCipherConfigHandler$init$2(r18);
        Intrinsics.checkNotNullParameter(r12, "strategy");
        r11.a(r11.g, r12);
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r0.f = r11;
        String r13 = null;
        com.ss.android.lark.storage.kv.flash.d r1 = com.ss.android.lark.storage.kv.flash.c.b;     // Catch: Throwable -> L26
        LogCipherConfigHandler.k = com.ss.android.lark.storage.kv.flash.c.b.a(r18).getString(null);     // Catch: Throwable -> L26
        LogCipherConfigHandler.LogCipherConfig r2 = (LogCipherConfigHandler.LogCipherConfig) new Gson().fromJson(com.ss.android.lark.storage.kv.flash.c.b.a(r18).getString(null), LogCipherConfigHandler.LogCipherConfig.class);     // Catch: Throwable -> L26
    L28:
        LogCipherConfigHandler.j = r2;
        if (o0.c(r18) == false) goto L31;
        int r14 = 4;
    L32:
        f.a r15 = new f.a();
        r15.a = r18;
        LarkAppContext.Companion.getClass();
        r15.k = LarkAppContext.access$getInstance$cp().appIdInfo().a;
        r15.b = r14;
        if (o0.a(r18) == false) goto L35;
        String r16 = "Main";
    L36:
        r15.c = r16;
        r15.d = DevEnvUtil.isDebugMode(r18);
        r15.e = a0.d(r18);
        r15.f = new PolarisFileWrapper(com.ss.android.lark.diskmanage.storage.d.k(r18), "temp").getAbsolutePath();
        r15.g = new com.ss.android.lark.framework.assembly.logger.b();
        r15.l = true;
        r15.j = new c(this, r18);
        r15.i = new a();
        r15.h = true ^ LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
        f r17 = new f(r15);
        Log.init(r17);
        Intrinsics.checkNotNull(r17);
        if (r17.b != 8) goto L50;
        f.b r19 = r17.i;
        if (r19 == null) goto L42;
        Pair<String, String> r20 = r19.a();
    L43:
        LarkLogger r21 = LarkLogger.a;
        String r22 = "Kmp" + r17.c;
        String r110 = new PolarisFileWrapper(r17.e, "molten2").getAbsolutePath();
        long r111 = r17.g;
        if (r20 == null) goto L46;
        String r112 = (String) r20.first;
    L47:
        if (r20 == null) goto L49;
        r13 = (String) r20.second;
    L49:
        LogConfig r23 = new LogConfig(r22, r110, r111, null, 5L, r13, r112);
        InitLogTask$initKmpLogger$1 r24 = new InitLogTask$initKmpLogger$1(q.a);
        Intrinsics.checkNotNullParameter(r23, "config");
        Intrinsics.checkNotNullParameter(r24, "isNativeLoaded");
        LarkLogger.c = r23;
        LarkLogger.d = r24;
        goto L50
    L46:
        r112 = null;
        goto L47
    L42:
        r20 = null;
    L50:
        Log.i("InitLogTask", "init log done, type:" + r14 + "; version:" + ApkUtil.getAppVersionName(r18) + "; process:" + z.c(r18));
        com.suite.component.logger.Log.e = new com.suite.lark.component.logger.dynamic.a(DevEnvUtil.isDebugMode(r18));
        return;
    L35:
        r16 = z.c(r18);
        Intrinsics.checkNotNull(r16);
        goto L36
    L31:
        r14 = 8;
    L26:
        th = move-exception;
        Log.e("LogCipherConfigHandler", "load log cipher config failed, error: " + th.getMessage());
        r2 = null;
        goto L28
    L51:
        Log.initWithNone();
        return;
    L10:
        r6 = false;
        goto L11
    }
}
