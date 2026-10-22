package com.obric.sva.sdk.ipc;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import com.bytedance.crash.Npth;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.runtime.manager.ObricMainProcessStateManager;
import com.obric.assistant.activation.presentation.runtime.manager.v1;
import com.obric.sva.sdk.config.ConfigManager;
import com.obric.sva.sdk.config.Stage2Config;
import com.obric.sva.sdk.controller.Global;
import com.obric.sva.sdk.controller.ManufactureFeatures;
import com.obric.sva.sdk.controller.SvaSdkGlobal;
import com.obric.sva.sdk.effectplatform.AuthModelConfig;
import com.obric.sva.sdk.logger.InteractorReportInitializer;
import com.obric.sva.sdk.sami.SamiPhoneEnrollManager;
import com.obric.sva.sdk.sami.SamiVoiceWakeupEngine;
import com.obric.sva.sdk.sami.SamiWakeupParamProvider;
import com.obric.sva.sdk.service.WakeupService;
import com.obric.sva.sdk.upload.WakeupUploadManager;
import com.obric.sva.sdk.utils.LogUtils;
import com.obric.sva.sdk.utils.ThreadUtil;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import rna.b;
import sna.f;
import xna.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016JO\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J1\u0010\u0017\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u0019J;\u0010\u001a\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u000eH\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J&\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u000e2\b\u0010$\u001a\u0004\u0018\u00010 H\u0016¨\u0006&"}, d2 = {"Lcom/obric/sva/sdk/ipc/SvaContentProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "onLowMemory", "", "onCreate", "", DownloadConstants.QUERY_KEY, "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "insert", "values", "Landroid/content/ContentValues;", "delete", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "hasPcmFiles", "directoryPath", "ensureSvaSdkGlobalInitialized", "getEffectiveModelSnapshot", "Landroid/os/Bundle;", "call", "method", "arg", "extras", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SvaContentProvider extends ContentProvider {
    public static final Companion Companion = null;
    public static final String TAG = "SvaContentProvider";

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ Unit a(String r0, String r1) {
        return _init_$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit b(String r0, String r1) {
        return _init_$lambda$0(r0, r1);
    }

    public static /* synthetic */ void c(SvaContentProvider r0) {
        call$lambda$35(r0);
    }

    public static /* synthetic */ Unit d(String r0, String r1) {
        return _init_$lambda$3(r0, r1);
    }

    public static /* synthetic */ Unit e(String r0, String r1) {
        return _init_$lambda$4(r0, r1);
    }

    public static /* synthetic */ Unit f(String r0, String r1) {
        return _init_$lambda$1(r0, r1);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        LogUtils.i(TAG, "onCreate.....", new Object[0]);
        Context r0 = getContext();
        if (r0 == null) goto L41;
        boolean r2 = UserSwitchReceiver.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        IntentFilter r3 = new IntentFilter();
        r3.addAction("android.intent.action.USER_FOREGROUND");
        r3.addAction("android.intent.action.USER_BACKGROUND");
        if (Build.VERSION.SDK_INT < 26) goto L41;
        if (UserSwitchReceiver.a == true) goto L41;
        SwitchReceiver r10 = UserSwitchReceiver.b;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L43;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L43:
    L35:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.registerReceiver(r10, r3, 4);
    L39:
        UserSwitchReceiver.a = true;
        goto L41
    L40:
        throw e;
    L13:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L26;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r3) == false) goto L26;
        int r4 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r10, r3, 4, null, null, 3, r0).result;     // Catch: Exception -> L35
        if (r4 != 1) goto L19;
        r0.registerReceiver(r10, r3, 4);     // Catch: Exception -> L35
    L42:
        goto L39
    L19:
        if (r4 != 2) goto L21;
        new Intent();     // Catch: Exception -> L35
        goto L42
    L21:
        if (r4 == 3) goto L42;
        r0.registerReceiver(r10, r3, 4);     // Catch: Exception -> L35
    L26:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L35
        r0.registerReceiver(r10, r3, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L35
        goto L42
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L31;
    L33:
        r0.registerReceiver(r10, r3, 4);     // Catch: Exception -> L35
        goto L42
    L31:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r3) == false) goto L33;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L35
        ContextCompat.registerReceiver(r0, r10, r3, null, ReceiverRegisterLancet.sProxyHandler, 4);     // Catch: Exception -> L35
    L41:
        return true;
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onLowMemory() {
        LogUtils.i(TAG, "onLowMemory.....", new Object[0]);
        Context r1 = getContext();
        if (r1 == null) goto L21;
        boolean r2 = UserSwitchReceiver.a;
        Intrinsics.checkNotNullParameter(r1, "context");
        if (UserSwitchReceiver.a == false) goto L17;
        SwitchReceiver r3 = UserSwitchReceiver.b;
        ReceiverRegisterLancet.loge(r3, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L19;
        r1.unregisterReceiver(r3);
        goto L17
    L19:
    L12:
        e = move-exception;
        if (r3 == null) goto L15;
        Npth.addTag("unregisterReceiver", r3.toString());
    L15:
        e.printStackTrace();
        goto L17
    L9:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r3, r1) == false) goto L17;
        r1.unregisterReceiver(r3);     // Catch: Exception -> L12
    L17:
        UserSwitchReceiver.a = false;
        return;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }

    private final Bundle getEffectiveModelSnapshot() {
        Bundle r0 = new Bundle();
        ensureSvaSdkGlobalInitialized();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(ConfigManager.INSTANCE.getStage2Config());     // Catch: Throwable -> L5
    L7:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        boolean r4 = true;
        if (r3 == null) goto L11;
        LogUtils.e(TAG, "getEffectiveModelSnapshot skipped: stage2Config is not initialized", new Object[]{r3});
    L11:
        if (Result.isFailure-impl(r2) == false) goto L13;
        r2 = null;
    L13:
        Stage2Config r5 = (Stage2Config) r2;
        if (r5 != null) goto L17;
        r0.putBoolean("ready", false);
        r0.putBoolean("sidReady", false);
        r0.putBoolean("authReady", false);
        return r0;
    L17:
        String r8 = r5.getVersion();
        if (r8 != null) goto L20;
    L25:
        boolean r9 = false;
    L119:
        SvaSdkGlobal r11 = SvaSdkGlobal.INSTANCE;     // Catch: Throwable -> L53
        List r10 = CollectionsKt.listOf(new String[]{r11.getPATH_SPEECH_VOICE_PRINT_SID_MODEL(), r11.getPATH_KEY_INFO_KWS_SID_MODEL()});     // Catch: Throwable -> L53
        if (r9 == false) goto L50;
        List r12 = r10;     // Catch: Throwable -> L53
        if ((r12 instanceof Collection) == true) goto L32;
    L34:
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L53
    L36:
        if (r13.hasNext() == false) goto L33;
        String r14 = (String) r13.next();     // Catch: Throwable -> L53
        if (r14.length() <= 0) goto L40;
        boolean r15 = true;
    L41:
        if (r15 == true) goto L43;
    L45:
        boolean r16 = false;
    L46:
        if (r16 == true) goto L36;
        boolean r17 = false;
    L48:
        if (r17 == false) goto L50;
        boolean r18 = true;
    L51:
        Object r19 = Result.constructor-impl(Boolean.valueOf(r18));     // Catch: Throwable -> L53
    L55:
        Throwable r110 = Result.exceptionOrNull-impl(r19);
        if (r110 == null) goto L58;
        LogUtils.w(TAG, "getEffectiveModelSnapshot sid not ready: " + r110.getMessage(), new Object[0]);
    L58:
        Boolean r111 = Boolean.FALSE;
        if (Result.isFailure-impl(r19) == false) goto L61;
        r19 = r111;
    L61:
        boolean r20 = ((Boolean) r19).booleanValue();
        AuthModelConfig r112 = AuthModelConfig.INSTANCE;
        SvaSdkGlobal r113 = SvaSdkGlobal.INSTANCE;     // Catch: Throwable -> L88
        List r21 = CollectionsKt.listOf(new String[]{r113.getPATH_SPEECH_VOICE_PRINT_SID_AUTH_MODEL(), r113.getPATH_KEY_INFO_KWS_SID_AUTH_MODEL()});     // Catch: Throwable -> L88
        if (r112.isReady() == false) goto L85;
        List r22 = r21;     // Catch: Throwable -> L88
        if ((r22 instanceof Collection) == true) goto L67;
    L69:
        Iterator r23 = r22.iterator();     // Catch: Throwable -> L88
    L71:
        if (r23.hasNext() == false) goto L68;
        String r114 = (String) r23.next();     // Catch: Throwable -> L88
        if (r114.length() <= 0) goto L75;
        boolean r115 = true;
    L76:
        if (r115 == true) goto L78;
    L80:
        boolean r116 = false;
    L81:
        if (r116 == true) goto L71;
        boolean r24 = false;
    L83:
        if (r24 == false) goto L85;
    L86:
        Object r6 = Result.constructor-impl(Boolean.valueOf(r4));     // Catch: Throwable -> L88
    L90:
        Throwable r25 = Result.exceptionOrNull-impl(r6);
        if (r25 == null) goto L93;
        LogUtils.w(TAG, "getEffectiveModelSnapshot auth not ready: " + r25.getMessage(), new Object[0]);
    L93:
        Boolean r26 = Boolean.FALSE;
        if (Result.isFailure-impl(r6) == false) goto L96;
        r6 = r26;
    L96:
        boolean r7 = ((Boolean) r6).booleanValue();
        Context r27 = getContext();
        if (r27 == null) goto L101;
        Context r28 = r27.getApplicationContext();
        if (r28 == null) goto L101;
        r112.refreshBuiltinQnn(r28, "getEffectiveModelSnapshot");
    L101:
        String r29 = r112.getQnnLibDir();
        r0.putBoolean("ready", r20);
        r0.putBoolean("sidReady", r20);
        r0.putBoolean("authReady", r7);
        r0.putString("qnnLibDir", r29);
        String r30 = "";
        if (r20 == false) goto L107;
        SvaSdkGlobal r31 = SvaSdkGlobal.INSTANCE;
        r0.putString("sidModelPath", r31.getPATH_SPEECH_VOICE_PRINT_SID_MODEL());
        r0.putString("sidKeyInfoPath", r31.getPATH_KEY_INFO_KWS_SID_MODEL());
        String r32 = r5.getVoiceprint_rawfile_md5();
        if (r32 != null) goto L106;
        r32 = "";
    L106:
        r0.putString("sidRawFileMd5", r32);
    L107:
        if (r7 == false) goto L109;
        SvaSdkGlobal r33 = SvaSdkGlobal.INSTANCE;
        r0.putString("authModelPath", r33.getPATH_SPEECH_VOICE_PRINT_SID_AUTH_MODEL());
        r0.putString("authKeyInfoPath", r33.getPATH_KEY_INFO_KWS_SID_AUTH_MODEL());
        r0.putString("authRawFileMd5", r112.getAuthRawFileMd5());
        r0.putString("authModelVersion", r112.getAuthModelVersion());
    L109:
        String r34 = r5.getVersion();
        if (r34 == null) goto L113;
        r30 = r34;
    L113:
        r0.putString(EffectConfiguration.KEY_VERSION, r30);
        StringBuilder r35 = new StringBuilder("getEffectiveModelSnapshot ready=");
        r35.append(r20);
        r35.append(" sidReady=");
        r35.append(r20);
        r35.append(" authReady=");
        r35.append(r7);
        r35.append(" qnnDir=");
        r35.append(r29);
        r35.append(" version=");
        r35.append(r5.getVersion());
        r35.append(" authVersion=");
        r35.append(r112.getAuthModelVersion());
        r35.append(" sid=");
        SvaSdkGlobal r36 = SvaSdkGlobal.INSTANCE;
        r35.append(r36.getPATH_SPEECH_VOICE_PRINT_SID_MODEL());
        r35.append(" auth=");
        r35.append(r36.getPATH_SPEECH_VOICE_PRINT_SID_AUTH_MODEL());
        LogUtils.i(TAG, r35.toString(), new Object[0]);
        return r0;
    L78:
        if (new PolarisFileWrapper(r114).isFile() == false) goto L80;
        r116 = true;
        goto L81
    L75:
        r115 = false;
    L68:
        r24 = true;
        goto L83
    L67:
        if (r22.isEmpty() == false) goto L69;
    L85:
        r4 = false;
    L88:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L90
    L43:
        if (new PolarisFileWrapper(r14).isFile() == false) goto L45;
        r16 = true;
        goto L46
    L40:
        r15 = false;
    L33:
        r17 = true;
        goto L48
    L32:
        if (r12.isEmpty() == false) goto L34;
    L50:
        r18 = false;
    L53:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L55
    L20:
        if (r8.length() <= 0) goto L22;
        boolean r38 = true;
    L23:
        if (r38 != true) goto L25;
        r9 = true;
        goto L119
    L22:
        r38 = false;
    L5:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public SvaContentProvider() {
        a.c(new k(), new l(), new m(), new n(), new o());
    }

    private final boolean ensureSvaSdkGlobalInitialized() {
        Context r0 = getContext();
        if (r0 == null) goto L5;
        Context r1 = r0.getApplicationContext();
    L7:
        if (r1 != null) goto L19;
        LogUtils.w(TAG, "ensureSvaSdkGlobalInitialized skipped: context is null", new Object[0]);
        return false;
    L19:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L12
        SvaSdkGlobal.INSTANCE.init(r1);     // Catch: Throwable -> L12
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r4 = Result.exceptionOrNull-impl(r2);
        if (r4 == null) goto L18;
        LogUtils.e(TAG, "ensureSvaSdkGlobalInitialized failed: " + r4.getMessage(), new Object[0]);
    L18:
        return Result.isSuccess-impl(r2);
    L12:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    private static final void call$lambda$35(SvaContentProvider r1) {
        r1.ensureSvaSdkGlobalInitialized();
        SvaSdkGlobal.INSTANCE.triggerAuthModelDownload("set-bypass-adaptive-sid");
    }

    private final boolean hasPcmFiles(String r9) {
        PolarisFileWrapper r1 = new PolarisFileWrapper(r9);     // Catch: Exception -> L22
        if (r1.exists() == true) goto L6;
        return false;
    L6:
        if (r1.isDirectory() == false) goto L27;
        File[] r10 = r1.listFiles();     // Catch: Exception -> L22
        if (r10 == null) goto L28;
        int r2 = r10.length;     // Catch: Exception -> L22
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L31;
        File r4 = r10[r3];     // Catch: Exception -> L22
        if (r4.isFile() == false) goto L17;
        if (StringsKt.endsWith$default(r4.getName(), ".pcm", false, 2, null) == false) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == true) goto L19;
        r3 = r3 + 1;
        goto L11
    L19:
        return true;
    L17:
        r5 = false;
        goto L18
    L31:
        return false;
    L28:
        return false;
    L27:
        return false;
    L30:
        return false;
    }

    private static final Unit _init_$lambda$0(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "t");
        Intrinsics.checkNotNullParameter(r2, "m");
        LogUtils.v(r1, r2, new Object[0]);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "t");
        Intrinsics.checkNotNullParameter(r2, "m");
        LogUtils.i(r1, r2, new Object[0]);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$2(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "t");
        Intrinsics.checkNotNullParameter(r2, "m");
        LogUtils.i(r1, r2, new Object[0]);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$3(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "t");
        Intrinsics.checkNotNullParameter(r2, "m");
        LogUtils.w(r1, r2, new Object[0]);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$4(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "t");
        Intrinsics.checkNotNullParameter(r2, "m");
        LogUtils.e(r1, r2, new Object[0]);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v121 */
    /* JADX WARN: Type inference failed for: r0v122, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v136 */
    /* JADX WARN: Type inference failed for: r0v137 */
    /* JADX WARN: Type inference failed for: r0v138 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31, types: [boolean, int] */
    @Override // android.content.ContentProvider
    public Bundle call(String r24, String r25, Bundle r26) {
        Intrinsics.checkNotNullParameter(r24, "method");
        LogUtils.i(TAG, "call with method " + r24, new Object[0]);
        String r7 = "";
        boolean r3 = true;
        switch(r24.hashCode()) {
            case -1819598069: goto L327;
            case -1515064389: goto L308;
            case -1372682794: goto L295;
            case -1314017441: goto L281;
            case -1018126628: goto L253;
            case -767576557: goto L238;
            case -434261138: goto L221;
            case -416625661: goto L202;
            case -410243685: goto L128;
            case -169701741: goto L117;
            case 38083406: goto L106;
            case 230288010: goto L81;
            case 279720913: goto L70;
            case 538563991: goto L63;
            case 564122442: goto L31;
            case 1340035432: goto L20;
            case 1516631156: goto L15;
            case 1775378600: goto L6;
            default: goto L352;
        };
    L352:
        return new Bundle();
    L6:
        if (r24.equals("sid-get-status") == false) goto L352;
        Bundle r0 = new Bundle();
        Context r1 = getContext();
        if (r1 == null) goto L11;
        boolean r2 = SamiPhoneEnrollManager.queryPhoneEnrolledFromLocalDb$default(SamiPhoneEnrollManager.INSTANCE, r1.getApplicationContext(), null, 2, null);
    L12:
        LogUtils.d(TAG, "sid-get-status local voiceprint_db status=" + r2, new Object[0]);
        r0.putBoolean("status", r2);
        return r0;
    L11:
        r2 = false;
        goto L12
    L15:
        if (r24.equals("sva-get-effective-model-snapshot") == false) goto L352;
        return getEffectiveModelSnapshot();
    L20:
        if (r24.equals("breath-upload-get-status") == false) goto L352;
        Bundle r4 = new Bundle();
        Context r5 = getContext();
        if (r5 == null) goto L29;
        Context r6 = r5.getApplicationContext();
        Intrinsics.checkNotNull(r6);
        String r8 = b.i(r6);
        if (f.a("breath_data_upload_status", -1) == 1) goto L28;
        r3 = false;
    L28:
        LogUtils.d(TAG, "breath-upload-get-status cachedUUID = " + b.l(r8) + ", status = " + r3, new Object[0]);
        r4.putBoolean("status", r3);
    L29:
        return r4;
    L31:
        if (r24.equals("breath-set-status") == false) goto L352;
        if (r26 == null) goto L35;
        ?? r9 = r26.getBoolean("status");
    L36:
        Context r10 = getContext();
        if (r10 == null) goto L40;
        Context r11 = r10.getApplicationContext();
        Intrinsics.checkNotNull(r11);
        r7 = b.i(r11);
    L40:
        if (r7.length() != 0) goto L42;
        boolean r12 = true;
    L43:
        if (r12 == false) goto L47;
        LogUtils.d(TAG, "empty uid or did, just return", new Object[0]);
        return new Bundle();
    L47:
        if (ManufactureFeatures.isFeatureBreathWakeupEnable() == true) goto L51;
        LogUtils.d(TAG, "NOT support breath wakeup on this device", new Object[0]);
        return BundleKt.bundleOf();
    L51:
        if (f.a("breath_wakeup_status", -1) != 1) goto L53;
        boolean r13 = true;
    L54:
        if (r13 != r9) goto L57;
        r3 = false;
    L57:
        LogUtils.d(TAG, "currentBreathStatus = " + r13 + ", updatedBreathStatus = " + r9 + ", statusChanged = " + r3, new Object[0]);
        if (r3 == false) goto L61;
        LogUtils.d(TAG, "set status to be " + r9, new Object[0]);
        f.c("breath_wakeup_status", r9);
        LogUtils.d(TAG, "BreathStatus will set to = " + r9, new Object[0]);
        WakeupSettingBus.INSTANCE.emit(WakeupSettingBus.Property.BREATH, r9);
    L61:
        return new Bundle();
    L53:
        r13 = false;
        goto L54
    L42:
        r12 = false;
        goto L43
    L35:
        r9 = 0;
        goto L36
    L63:
        if (r24.equals("wakeup-get-status") == false) goto L352;
        Bundle r14 = new Bundle();
        Context r15 = getContext();
        if (r15 == null) goto L68;
        Context r16 = r15.getApplicationContext();
        Intrinsics.checkNotNull(r16);
        String r17 = b.i(r16);
        boolean r18 = Global.sWakeupStatus;
        LogUtils.d(TAG, "cachedUUID = " + b.l(r17) + ", wakeup-get-status, currentWakeupStatus = " + r18, new Object[0]);
        r14.putBoolean("status", r18);
    L68:
        return r14;
    L70:
        if (r24.equals("set-bypass-adaptive-sid") == false) goto L352;
        if (r26 == null) goto L74;
        r3 = r26.getBoolean("status", true);
    L74:
        SamiWakeupParamProvider.INSTANCE.updateBypassAdaptiveSid(r3);
        LogUtils.i(TAG, "set-bypass-adaptive-sid bypass=" + r3, new Object[0]);
        if (r3 == true) goto L79;
        ThreadUtil.postOnWorkThread(new p(this));
    L79:
        return new Bundle();
    L81:
        if (r24.equals("sid-auth-save-adaptive-embedding") == false) goto L352;
        if (r26 == null) goto L85;
        long r19 = r26.getLong("wkrId", 0);
    L86:
        if (r26 == null) goto L88;
        int r20 = 0;
        int r21 = r26.getInt("save", 0);
    L89:
        LogUtils.i(TAG, "sid-auth-save-adaptive-embedding wkrId=" + r19 + " save=" + r21, new Object[r20]);
        Bundle r22 = new Bundle();
        if (r19 != 0) goto L363;
        LogUtils.w(TAG, "sid-auth-save-adaptive-embedding skip: wkrId=0", new Object[r20]);
        r22.putInt("ret", IntCompanionObject.MIN_VALUE);
        return r22;
    L363:
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L95
        Object r27 = Result.constructor-impl(Integer.valueOf(SamiVoiceWakeupEngine.INSTANCE.saveAdaptiveEmbedding(String.valueOf(r19), r21)));     // Catch: Throwable -> L95
    L97:
        Throwable r28 = Result.exceptionOrNull-impl(r27);
        if (r28 == null) goto L100;
        LogUtils.e(TAG, "sid-auth-save-adaptive-embedding failed: " + r28.getMessage(), new Object[0]);
    L100:
        Integer r29 = Integer.valueOf(IntCompanionObject.MIN_VALUE);
        if (Result.isFailure-impl(r27) == false) goto L103;
        r27 = r29;
    L103:
        r22.putInt("ret", ((Number) r27).intValue());
        return r22;
    L95:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L97
    L88:
        r20 = 0;
        r21 = 0;
        goto L89
    L85:
        r19 = 0;
        goto L86
    L106:
        if (r24.equals("notify-xtt-token-updated") == false) goto L352;
        if (r26 == null) goto L110;
        String r31 = r26.getString("reason");
    L111:
        if (r31 == null) goto L114;
        r7 = r31;
    L114:
        LogUtils.i(TAG, "notify-xtt-token-updated reason=".concat(r7), new Object[0]);
        WakeupUploadManager.INSTANCE.onUploadFileReady();
        return new Bundle();
    L110:
        r31 = null;
        goto L111
    L117:
        if (r24.equals("clear-wakeup-upload-queue") == false) goto L352;
        if (r26 == null) goto L121;
        String r32 = r26.getString("reason");
    L122:
        if (r32 == null) goto L125;
        r7 = r32;
    L125:
        WakeupUploadManager.INSTANCE.clearAllPendingFiles("provider:".concat(r7));
        return new Bundle();
    L121:
        r32 = null;
        goto L122
    L128:
        if (r24.equals("set-main-process-ready-binder") == false) goto L352;
        if (r26 == null) goto L132;
        IBinder r33 = r26.getBinder("main_process_ready_binder");
    L133:
        if (r26 == null) goto L135;
        long r110 = r26.getLong("ipc_generation", 0);
    L136:
        if (r26 == null) goto L138;
        String r34 = r26.getString("reason");
    L139:
        if (r34 == null) goto L142;
        r7 = r34;
    L142:
        String r35 = "provider_publish:".concat(r7);
        StringBuilder r36 = new StringBuilder("main_process_ready_binder_received: generation=");
        r36.append(r110);
        r36.append(" binderAlive=");
        if (r33 != null) goto L145;
    L147:
        boolean r37 = false;
    L148:
        r36.append(r37);
        r36.append(" reason=");
        r36.append(r7);
        LogUtils.i(TAG, r36.toString(), new Object[0]);
        ObricMainProcessStateManager r38 = ObricMainProcessStateManager.a;
        Intrinsics.checkNotNullParameter(r35, "reason");
        if (r33 != null) goto L151;
    L198:
        FLogger.a.w("ObricMainProcessStateManager", "ready_binder_ignored: reason=invalid_binder generation=" + r110 + " source=" + r35);
    L200:
        return new Bundle();
    L151:
        if (r110 == 0) goto L198;
        if (r33.isBinderAlive() == false) goto L198;
        ObricMainProcessStateManager.a.getClass();
        if (r33.isBinderAlive() == true) goto L158;
        FLogger.a.w("ObricMainProcessStateManager", "ready_binder_ignored: reason=already_dead generation=" + r110 + " source=" + r35);
        ObricMainProcessStateManager.a r39 = null;
    L174:
        if (r39 == null) goto L200;
        ReentrantLock r40 = ObricMainProcessStateManager.b;
        r40.lock();
        ObricMainProcessStateManager.a r41 = ObricMainProcessStateManager.f;     // Catch: Throwable -> L195
        ObricMainProcessStateManager.f = r39;     // Catch: Throwable -> L195
        ObricMainProcessStateManager.c.setValue(Boolean.TRUE);     // Catch: Throwable -> L195
        r40.unlock();
        if (r41 == null) goto L181;
        ObricMainProcessStateManager.a.getClass();
        ObricMainProcessStateManager.b(r41);
    L181:
        r40.lock();
    L192:
        th = move-exception;
        r40.unlock();
        throw th;
    L183:
        if (ObricMainProcessStateManager.f != r39) goto L187;
        if (r39.a.isBinderAlive() == false) goto L187;
    L188:
        r40.unlock();
        if (r3 == true) goto L191;
        ObricMainProcessStateManager.a.getClass();
        ObricMainProcessStateManager.a(r39, "dead_after_register");
        goto L200
    L191:
        FLogger.a.i("ObricMainProcessStateManager", "main_process_ready: generation=" + r110 + " source=" + r35);
    L187:
        r3 = false;
    L195:
        th = move-exception;
        r40.unlock();
        throw th;
    L158:
        Ref.ObjectRef r42 = new Ref.ObjectRef();
        v1 r43 = new v1(r42);
        r42.element = new ObricMainProcessStateManager.a(r33, r110, r43);
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L165
        r33.linkToDeath(r43, 0);     // Catch: Throwable -> L165
        Object r45 = r42.element;     // Catch: Throwable -> L165
        if (r45 != null) goto L162;
        Intrinsics.throwUninitializedPropertyAccessException("registration");     // Catch: Throwable -> L165
        ObricMainProcessStateManager.a r46 = null;
    L163:
        Object r47 = Result.constructor-impl(r46);     // Catch: Throwable -> L165
    L167:
        Throwable r48 = Result.exceptionOrNull-impl(r47);
        if (r48 == null) goto L171;
        FLogger.a.w("ObricMainProcessStateManager", "ready_binder_link_failed: generation=" + r110 + " source=" + r35 + " message=" + r48.getMessage());
    L171:
        if (Result.isFailure-impl(r47) == false) goto L173;
        r47 = null;
    L173:
        r39 = (ObricMainProcessStateManager.a) r47;
        goto L174
    L162:
        r46 = (ObricMainProcessStateManager.a) r45;     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r49 = Result.Companion;
        r47 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L167
    L145:
        if (r33.isBinderAlive() != true) goto L147;
        r37 = true;
        goto L148
    L138:
        r34 = null;
        goto L139
    L135:
        r110 = 0;
        goto L136
    L132:
        r33 = null;
        goto L133
    L202:
        if (r24.equals("reload-voice-wakeup-sami-core") == false) goto L352;
        Context r50 = getContext();
        if (r50 != null) goto L355;
        LogUtils.w(TAG, "reload-voice-wakeup-sami-core skipped: context is null", new Object[0]);
        return new Bundle();
    L355:
        Result.Companion r51 = Result.Companion;     // Catch: Throwable -> L210
        Intent r52 = new Intent(r50, WakeupService.class);     // Catch: Throwable -> L210
        r52.setAction("com.larus.nova.action.reload.sami.core");     // Catch: Throwable -> L210
        r50.startService(r52);     // Catch: Throwable -> L210
        LogUtils.i(TAG, "reload-voice-wakeup-sami-core trigger reload action success", new Object[0]);     // Catch: Throwable -> L210
        Object r53 = Result.constructor-impl(new Bundle());     // Catch: Throwable -> L210
    L212:
        Throwable r54 = Result.exceptionOrNull-impl(r53);
        if (r54 == null) goto L215;
        LogUtils.e(TAG, "reload-voice-wakeup-sami-core trigger reload action failed: " + r54.getMessage(), new Object[0]);
    L215:
        Bundle r55 = new Bundle();
        if (Result.isFailure-impl(r53) == false) goto L219;
        r53 = r55;
    L219:
        return (Bundle) r53;
    L210:
        th = move-exception;
        Result.Companion r56 = Result.Companion;
        r53 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L212
    L221:
        if (r24.equals("set-enrolling-status") == false) goto L352;
        if (r26 == null) goto L225;
        boolean r57 = r26.getBoolean("status");
    L226:
        LogUtils.i(TAG, "set-enrolling-status old status = " + Global.sEnrollIgnore + ", new status = " + r57, new Object[0]);
        if (r26 == null) goto L229;
        IBinder r58 = r26.getBinder("owner_token");
    L230:
        if (r26 == null) goto L232;
        long r59 = r26.getLong("ipc_generation", 0);
    L233:
        if (r58 == null) goto L235;
        TemporaryWakeupGateManager.INSTANCE.onOwnerTokenAvailable(r58, r59);
    L235:
        TemporaryWakeupGateManager.INSTANCE.updateGate(TemporaryWakeupGateManager.Gate.ENROLL_IGNORE, r57, r59, "set-enrolling-status");
        return new Bundle();
    L232:
        r59 = 0;
        goto L233
    L229:
        r58 = null;
        goto L230
    L225:
        r57 = false;
        goto L226
    L238:
        if (r24.equals("set-tracker-messenger") == false) goto L352;
        if (r26 == null) goto L242;
        IBinder r111 = r26.getBinder("tracker_messenger");
    L243:
        if (r26 == null) goto L245;
        IBinder r112 = r26.getBinder("owner_token");
    L247:
        if (r26 == null) goto L249;
        long r113 = r26.getLong("ipc_generation", 0);
    L250:
        TrackerManager.INSTANCE.attachFromHostProvider(r111, r112, r113, "provider_publish");
        return new Bundle();
    L249:
        r113 = 0;
        goto L250
    L245:
        r112 = null;
        goto L247
    L242:
        r111 = null;
        goto L243
    L253:
        if (r24.equals("breath-upload-set-status") == false) goto L352;
        if (r26 == null) goto L257;
        ?? r60 = r26.getBoolean("status");
    L258:
        Context r61 = getContext();
        if (r61 == null) goto L262;
        Context r62 = r61.getApplicationContext();
        Intrinsics.checkNotNull(r62);
        r7 = b.i(r62);
    L262:
        if (r7.length() != 0) goto L264;
        boolean r63 = true;
    L265:
        if (r63 == false) goto L269;
        LogUtils.d(TAG, "empty uid or did, just return", new Object[0]);
        return new Bundle();
    L269:
        if (f.a("breath_data_upload_status", -1) != 1) goto L271;
        boolean r64 = true;
    L272:
        if (r64 != r60) goto L275;
        r3 = false;
    L275:
        LogUtils.d(TAG, "currentBreathDataUploadStatus = " + r64 + ", updatedBreathDataUploadStatus = " + r60 + ", statusChanged = " + r3, new Object[0]);
        if (r3 == false) goto L279;
        LogUtils.d(TAG, "set status to be " + r60, new Object[0]);
        f.c("breath_data_upload_status", r60);
        LogUtils.d(TAG, "BreathDataUploadStatus will set to = " + r60, new Object[0]);
        WakeupSettingBus.INSTANCE.emit(WakeupSettingBus.Property.BREATH_UPLOAD, r60);
    L279:
        return new Bundle();
    L271:
        r64 = false;
        goto L272
    L264:
        r63 = false;
        goto L265
    L257:
        r60 = 0;
        goto L258
    L281:
        if (r24.equals("set-report-account") == false) goto L352;
        if (r26 == null) goto L285;
        String r65 = r26.getString("user_id");
    L286:
        if (r65 == null) goto L289;
        r7 = r65;
    L289:
        if (r26 == null) goto L291;
        int r66 = r26.getInt("odin_user_type", 0);
    L292:
        InteractorReportInitializer.INSTANCE.updateReportAccount(r7, r66);
        return new Bundle();
    L291:
        r66 = 0;
        goto L292
    L285:
        r65 = null;
        goto L286
    L295:
        if (r24.equals("breath-get-status") == false) goto L352;
        Bundle r67 = new Bundle();
        Context r68 = getContext();
        if (r68 == null) goto L306;
        Context r69 = r68.getApplicationContext();
        Intrinsics.checkNotNull(r69);
        String r70 = b.i(r69);
        if (ManufactureFeatures.isFeatureBreathWakeupEnable() == true) goto L302;
    L304:
        r3 = false;
    L305:
        LogUtils.d(TAG, "breath-get-status cachedUUID = " + b.l(r70) + ", status = " + r3, new Object[0]);
        r67.putBoolean("status", r3);
        goto L306
    L302:
        if (f.a("breath_wakeup_status", -1) != 1) goto L304;
    L306:
        return r67;
    L308:
        if (r24.equals("pull-up-assist-once") == false) goto L352;
        Context r71 = getContext();
        if (r71 != null) goto L353;
        LogUtils.w(TAG, "pull-up-assist-once skipped: context is null", new Object[0]);
        return new Bundle();
    L353:
        Result.Companion r72 = Result.Companion;     // Catch: Throwable -> L316
        Intent r73 = new Intent(r71, WakeupService.class);     // Catch: Throwable -> L316
        r73.setAction("com.larus.nova.action.pull.up.assist.once");     // Catch: Throwable -> L316
        r71.startService(r73);     // Catch: Throwable -> L316
        LogUtils.i(TAG, "pull-up-assist-once trigger success", new Object[0]);     // Catch: Throwable -> L316
        Object r74 = Result.constructor-impl(new Bundle());     // Catch: Throwable -> L316
    L318:
        Throwable r75 = Result.exceptionOrNull-impl(r74);
        if (r75 == null) goto L321;
        LogUtils.e(TAG, "pull-up-assist-once trigger failed: " + r75.getMessage(), new Object[0]);
    L321:
        Bundle r76 = new Bundle();
        if (Result.isFailure-impl(r74) == false) goto L325;
        r74 = r76;
    L325:
        return (Bundle) r74;
    L316:
        th = move-exception;
        Result.Companion r77 = Result.Companion;
        r74 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L318
    L327:
        if (r24.equals("wakeup-set-status") == false) goto L352;
        if (r26 == null) goto L331;
        ?? r78 = r26.getBoolean("status");
    L332:
        Context r79 = getContext();
        if (r79 == null) goto L336;
        Context r80 = r79.getApplicationContext();
        Intrinsics.checkNotNull(r80);
        r7 = b.i(r80);
    L336:
        if (r7.length() != 0) goto L338;
        boolean r81 = true;
    L339:
        if (r81 == false) goto L342;
        LogUtils.d(TAG, "empty uid or did, just return", new Object[0]);
        return new Bundle();
    L342:
        boolean r82 = Global.sWakeupStatus;
        if (r82 != r78) goto L346;
        r3 = false;
    L346:
        LogUtils.d(TAG, "currentWakeupStatus = " + r82 + ", updatedWakeupStatus = " + r78 + ", statusChanged = " + r3, new Object[0]);
        if (r3 == false) goto L350;
        f.c("voice_assistant_wakeup_status", r78);
        Global.sWakeupStatus = r78;
        LogUtils.d(TAG, "wakeup-set-status, updatedWakeupStatus = " + r78 + ", wakepuStatus = " + r78, new Object[0]);
        WakeupSettingBus.INSTANCE.emit(WakeupSettingBus.Property.WAKEUP, r78);
    L350:
        return new Bundle();
    L338:
        r81 = false;
        goto L339
    L331:
        r78 = 0;
        goto L332
    }
}
