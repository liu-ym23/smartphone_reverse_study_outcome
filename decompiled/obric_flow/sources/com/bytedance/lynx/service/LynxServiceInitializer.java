package com.bytedance.lynx.service;

import androidx.annotation.Keep;
import com.bytedance.lynx.service.extension.LynxExtensionService;
import com.bytedance.lynx.service.log.LynxLogService;
import com.bytedance.lynx.service.memory.monitor.LynxMemoryMonitorService;
import com.bytedance.lynx.service.model.b;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.lynx.service.network.LynxHttpService;
import com.bytedance.lynx.service.reporter.LynxEventReporterService;
import com.bytedance.lynx.service.resource.LynxResourceService;
import com.bytedance.lynx.service.security.LynxSecurityService;
import com.bytedance.lynx.service.trail.LynxTrailService;
import com.lynx.base.log.LynxLog;
import com.lynx.service.devtool.LynxDevToolService;
import com.lynx.service.devtool.LynxInternalDevToolService;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.service.ILynxI18nService;
import eg.a;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import ko.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zf.h;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/lynx/service/LynxServiceInitializer;", "", "<init>", "()V", "", "registerServices", "", "isInitial", "()Z", "createServiceAdapters", "Lcom/bytedance/lynx/service/model/b;", "lynxServiceConfig", "initialize", "(Lcom/bytedance/lynx/service/model/b;)V", "ensureInitialize", "getLynxServiceConfig", "()Lcom/bytedance/lynx/service/model/b;", "", "TAG", "Ljava/lang/String;", "INSTANCE_NAME", "Lcom/bytedance/lynx/service/model/b;", "Leg/a;", "resourceAdapter", "Leg/a;", "Lfg/a;", "settingsAdapter", "Lfg/a;", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxServiceInitializer {
    public static final LynxServiceInitializer INSTANCE = null;
    private static final String INSTANCE_NAME = "INSTANCE";
    public static final String TAG = "LynxServiceInitializer";
    private static b lynxServiceConfig;
    private static a resourceAdapter;
    private static fg.a settingsAdapter;

    static {
        INSTANCE = new LynxServiceInitializer();
    }

    private LynxServiceInitializer() {
    }

    private final void createServiceAdapters() {
        b r5 = lynxServiceConfig;     // Catch: Throwable -> L5
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("lynxServiceConfig");     // Catch: Throwable -> L5
        r5 = null;
    L7:
        int r10 = r5.f.ordinal();     // Catch: Throwable -> L5
        if (r10 == 0) goto L20;
        if (r10 == 1) goto L14;
        return;
    L14:
        if (Class.forName("com.bytedance.lynx.service.adapter.global.resource.LynxResourceServiceAdapter").getDeclaredField(INSTANCE_NAME).get(null) == null) goto L18;
        throw new ClassCastException();     // Catch: Throwable -> L5
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.lynx.service.resource.ILynxResourceServiceAdapter");     // Catch: Throwable -> L5
    L20:
        if (Class.forName("com.bytedance.lynx.service.adapter.common.resource.LynxResourceServiceAdapter").getDeclaredField(INSTANCE_NAME).get(null) == null) goto L24;
        throw new ClassCastException();     // Catch: Throwable -> L5
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.lynx.service.resource.ILynxResourceServiceAdapter");     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        LynxLog.b(4, TAG, "failed in createServiceAdapters: " + th);
    }

    private final boolean isInitial() {
        return false;
    }

    private final void registerServices() {
        r.g().k(h.a());
        r r5 = r.g();
        LynxLogService.Companion.getClass();
        r5.k((LynxLogService) LynxLogService.access$getINSTANCE$delegate$cp().getValue());
        r.g().k(LynxTrailService.INSTANCE);
        r.g().k(LynxHttpService.getInstance());
        r.g().k(LynxResourceService.INSTANCE);
        r.g().k(LynxMonitorService.INSTANCE);
        r.g().k(LynxEventReporterService.INSTANCE);
        r.g().k(LynxMemoryMonitorService.INSTANCE);
        r r10 = r.g();
        LynxSecurityService.Companion.getClass();
        r10.k((LynxSecurityService) LynxSecurityService.access$getINSTANCE$delegate$cp().getValue());
        r.g().k(LynxExtensionService.INSTANCE);
        r.g().k(LynxDevToolService.Companion.getINSTANCE());     // Catch: NoClassDefFoundError -> L5 ClassNotFoundException -> L7
        LynxLog.b(2, TAG, "Register LynxDevToolService");     // Catch: NoClassDefFoundError -> L5 ClassNotFoundException -> L7
    L19:
        b r11 = null;
        b r12 = lynxServiceConfig;     // Catch: Exception -> L23
        if (r12 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("lynxServiceConfig");     // Catch: Exception -> L23
        r12 = null;
    L25:
        int r13 = r12.f.ordinal();     // Catch: Exception -> L23
        if (r13 == 0) goto L36;
        if (r13 != 1) goto L52;
        Field r14 = Class.forName("com.bytedance.lynx.service.i18n.LynxI18nService").getDeclaredField(INSTANCE_NAME);     // Catch: Exception -> L23
        r r15 = r.g();     // Catch: Exception -> L23
        Object r16 = r14.get(null);     // Catch: Exception -> L23
        if (r16 == null) goto L34;
        r15.k((ILynxI18nService) r16);     // Catch: Exception -> L23
        return;
    L34:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.service.ILynxI18nService");     // Catch: Exception -> L23
    L52:
        return;
    L36:
        if (Class.forName("com.bytedance.lynx.service.adapter.common.trail.LynxABExperimentAdapter").getConstructor(null).newInstance(null) == null) goto L40;
        throw new ClassCastException();     // Catch: Exception -> L23
    L40:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.lynx.service.trail.ILynxABExperimentAdapter");     // Catch: Exception -> L23
    L23:
        e = move-exception;
        StringBuilder r17 = new StringBuilder("Failed initServiceCenter with exception: ");
        r17.append(e);
        r17.append(" adapterType: ");
        b r18 = lynxServiceConfig;
        if (r18 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("lynxServiceConfig");
    L45:
        r17.append(r11.f);
        LynxLog.b(4, TAG, r17.toString());
        return;
    L44:
        r11 = r18;
        goto L45
    L7:
        e = move-exception;
        LynxLog.b(4, TAG, "Failed to register LynxDevToolService: " + e.getMessage());
    L50:
        r.g().k(LynxInternalDevToolService.Companion.getINSTANCE());     // Catch: NoClassDefFoundError -> L13 ClassNotFoundException -> L15
        LynxLog.b(2, TAG, "Register LynxInternalDevToolService");     // Catch: NoClassDefFoundError -> L13 ClassNotFoundException -> L15
    L15:
        e = move-exception;
        LynxLog.b(4, TAG, "Failed to register LynxInternalDevToolService: " + e.getMessage());
    L13:
        e = move-exception;
        LynxLog.b(4, TAG, "Failed to register LynxInternalDevToolService: " + e.getMessage());
    L5:
        e = move-exception;
        LynxLog.b(4, TAG, "Failed to register LynxDevToolService: " + e.getMessage());
        goto L50
    }

    public final void ensureInitialize() {
        if (isInitial() == true) goto L6;
        LynxLog.b(4, TAG, "Please initialize before use.");
        return;
    L6:
        LynxLog.b(2, TAG, "Ensure initialize.");
        Intrinsics.throwUninitializedPropertyAccessException("resourceAdapter");
        throw null;
    }

    public final b getLynxServiceConfig() {
        if (isInitial() == true) goto L6;
        LynxLog.b(4, TAG, "Please initialize before call getLynxServiceConfig.");
        return null;
    L6:
        b r5 = lynxServiceConfig;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("lynxServiceConfig");
        return null;
    L10:
        return r5;
    }

    public final void initialize(b r10) {
        Intrinsics.checkNotNullParameter(r10, "lynxServiceConfig");
        TraceEvent.c("LynxServiceInitializer.initialize");
        LynxLog.b(2, TAG, "LynxServiceInitializer initialize.");
        lynxServiceConfig = r10;
        registerServices();
        createServiceAdapters();
        LynxMonitorService.INSTANCE.initialize(r10);
        Class.forName("com.bytedance.xelement.markdown.Markdown").getDeclaredMethod("init", null).invoke(null, null);     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9 ClassNotFoundException -> L11
    L17:
        LynxSecurityService.Companion.getClass();
        ((LynxSecurityService) LynxSecurityService.access$getINSTANCE$delegate$cp().getValue()).initialize();
        TraceEvent.a(0, "LynxServiceInitializer.initialize");
        return;
    L11:
        e = move-exception;
        LynxLog.b(4, "LynxMarkDownService", "LynxMarkDownService ClassNotFoundException");
        e.printStackTrace();
    L7:
        e = move-exception;
        LynxLog.b(4, "LynxMarkDownService", "LynxMarkDownService IllegalAccessException");
        e.printStackTrace();
    L9:
        e = move-exception;
        LynxLog.b(4, "LynxMarkDownService", "LynxMarkDownService NoSuchMethodException");
        e.printStackTrace();
    L5:
        e = move-exception;
        LynxLog.b(4, "LynxMarkDownService", "LynxMarkDownService InvocationTargetException");
        e.printStackTrace();
        goto L17
    }
}
