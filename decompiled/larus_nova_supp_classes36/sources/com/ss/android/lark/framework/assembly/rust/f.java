package com.ss.android.lark.framework.assembly.rust;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.rustinfrabridge.netstate.impl.LarkNetworkLevelManager;
import com.ss.android.lark.utils.LarkContext;
import com.suite.lark.platform.component.storage.file.dirs.JournalLogDir;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.internal.Contexts;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public static final AtomicBoolean c = null;
    public final c3c.d.b a;
    public final c3c.d.d b;

    static {
        c = new AtomicBoolean(false);
    }

    public f(c3c.d.b r1, c3c.d.d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(Context r21, String r22, int r23, String r24, String r25) {
        this.a.b();     // Catch: Throwable -> L41
        epb.a r16 = (epb.a) e0c.k.a(LarkContext.getApplication(), epb.a.class);     // Catch: Throwable -> L41
        yzb.b r17 = (yzb.b) e0c.k.a(LarkContext.getApplication(), yzb.b.class);     // Catch: Throwable -> L41
        if (LarkAppContext.inst().buildConfig().isUsPackage() == false) goto L6;
        int r3 = InitSDKRequest.PackageId.LARK.getValue();     // Catch: Throwable -> L41
    L7:
        int r10 = r3;
        if (com.ss.android.lark.featuregating.b.b(LarkContext.getApplication()).a("improve.safe.score.rust") == false) goto L13;
        String r4 = com.suite.lark.platform.component.storage.file.dirs.b.a(r21);     // Catch: Throwable -> L41
        int r5 = com.suite.lark.platform.component.storage.file.dirs.i.a;     // Catch: Throwable -> L41
        Intrinsics.checkNotNullParameter(r21, "context");     // Catch: Throwable -> L41
        Lazy r6 = JournalLogDir.a;     // Catch: Throwable -> L41
        Intrinsics.checkNotNullParameter(r21, "context");     // Catch: Throwable -> L41
        String r7 = JournalLogDir.c;     // Catch: Throwable -> L41
        if (r7 != null) goto L12;
        r7 = com.ss.android.lark.diskmanage.storage.d.k(r21);     // Catch: Throwable -> L41
        JournalLogDir.c = r7;     // Catch: Throwable -> L41
    L12:
        String r8 = com.suite.lark.platform.component.storage.file.dirs.c.a(r7, "log/");     // Catch: Throwable -> L41
    L14:
        String r9 = r4;
        String r11 = r8;
        String r12 = com.ss.android.lark.diskmanage.storage.d.k(r21);     // Catch: Throwable -> L41
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L41
        StringBuilder r14 = new StringBuilder();     // Catch: Throwable -> L41
        r14.append(com.ss.android.lark.diskmanage.storage.d.j(r21));     // Catch: Throwable -> L41
        String r15 = File.separator;     // Catch: Throwable -> L41
        r14.append(r15);     // Catch: Throwable -> L41
        r14.append("npth");     // Catch: Throwable -> L41
        r14.append(r15);     // Catch: Throwable -> L41
        r13.add(r14.toString());     // Catch: Throwable -> L41
        com.bytedance.lark.sdk.refactor.n r18 = (com.bytedance.lark.sdk.refactor.n) ((DwarfSPIEntryPoint) EntryPoints.get(Contexts.getApplication(r21), DwarfSPIEntryPoint.class)).dwarfSPI().get(com.bytedance.lark.sdk.refactor.n.class);     // Catch: Throwable -> L41
        if (c.compareAndSet(false, true) == false) goto L19;
        ((CopyOnWriteArrayList) com.bytedance.lark.sdk.d.f).add(com.ss.android.lark.sdk.g.e.a);     // Catch: Throwable -> L41
        Log.i("ImSdkInit", "PushDispatcher registered before Rust SDK init");     // Catch: Throwable -> L41
    L19:
        if (r18.m(r9, b0.a.a.a()) != 0) goto L21;
        String r19 = "success";
    L22:
        Log.i("RustSDK", "pre init sdk result = ".concat(r19));     // Catch: Throwable -> L41
        this.a.a();     // Catch: Throwable -> L41
        yob.e.a().getClass();     // Catch: Throwable -> L41
        int r2 = com.ss.android.lark.language.service.impl.a.f;     // Catch: Throwable -> L41
        apb.b r20 = com.ss.android.lark.language.service.impl.a.b.a;     // Catch: Throwable -> L41
        Locale r26 = r20.getLanguageSetting();     // Catch: Throwable -> L41
        yob.e.a().getClass();     // Catch: Throwable -> L41
        String r27 = r20.d(r26);     // Catch: Throwable -> L41
        String r28 = xoc.a.a(r21);     // Catch: Throwable -> L41
        int r29 = m.a;     // Catch: Throwable -> L41
        this.b.getPreloadChatChatterCount();     // Catch: Throwable -> L41
        InitSDKRequest.Builder r30 = m.a(r21, r23, r27, r28, r9, r12, r13, r11, r10, 0, new go2.g());     // Catch: Throwable -> L39
        String r31 = r16.getInstallId();     // Catch: Throwable -> L39
        r30.device_info(new InitSDKRequest.DeviceInfo.Builder().device_id(r22).install_id(r31).build());     // Catch: Throwable -> L39
        r18.w(r30).subscribe();     // Catch: Throwable -> L39
        Log.i("ImSdkInit", "setDeviceInfo, deviceId= " + r22 + " ,installId= " + r31);     // Catch: Throwable -> L39
        if (TextUtils.isEmpty(r22) == true) goto L28;
        ((epb.b) e0c.k.a(LarkContext.getApplication(), epb.b.class)).a();     // Catch: Throwable -> L39
    L28:
        if (com.ss.android.lark.featuregating.b.b(LarkContext.getApplication()).a("improve.safe.score.rust") == false) goto L30;
        Context r0 = r21;
        ((k3c.a) ((DwarfSPIEntryPoint) EntryPoints.get(Contexts.getApplication(r21), DwarfSPIEntryPoint.class)).dwarfSPI().get(k3c.a.class)).w1(r0);     // Catch: Throwable -> L39
    L32:
        this.a.endSection();     // Catch: Throwable -> L41
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new e());     // Catch: Throwable -> L41
        this.a.endSection();     // Catch: Throwable -> L41
        ((g3c.a) ((DwarfSPIEntryPoint) EntryPoints.get(Contexts.getApplication(r21), DwarfSPIEntryPoint.class)).dwarfSPI().get(g3c.a.class)).v0(r0);     // Catch: Throwable -> L41
        List r32 = com.ss.android.lark.rustinfrabridge.netstate.impl.d.a;     // Catch: Throwable -> L41
        com.ss.android.lark.rustinfrabridge.netstate.impl.d r33 = com.ss.android.lark.rustinfrabridge.netstate.impl.d.b.a;     // Catch: Throwable -> L41
        r33.getClass();     // Catch: Throwable -> L41
        com.ss.android.lark.sdk.g.e.a.b(Command.PUSH_WEB_SOCKET_STATUS, new com.ss.android.lark.rustinfrabridge.netstate.impl.b(r33));     // Catch: Throwable -> L41
        Object r34 = LarkNetworkLevelManager.d;     // Catch: Throwable -> L41
        LarkNetworkLevelManager.a.a().v0(r0);     // Catch: Throwable -> L41
        com.ss.android.lark.rustinfrabridge.netstate.impl.f r1 = com.ss.android.lark.rustinfrabridge.netstate.impl.f.a.a;     // Catch: Throwable -> L41
        com.ss.android.lark.http.netstate.a r35 = new com.ss.android.lark.rustinfrabridge.netstate.impl.e();     // Catch: Throwable -> L41
        r1.getClass();     // Catch: Throwable -> L41
        com.ss.android.lark.http.netstate.c.a.a.a(r35);     // Catch: Throwable -> L41
        if (r17.isLogin() == true) goto L35;
        r18.b();     // Catch: Throwable -> L41
    L36:
        this.a.endSection();     // Catch: Throwable -> L41
        com.bytedance.lark.sdk.d.r();
        Log.i("ImSdkInit", "userUnit: " + r24 + " ,tenantBrand: " + r25);
        return;
    L35:
        com.bytedance.lark.sdk.d.l.e.set(false);     // Catch: Throwable -> L41
        goto L36
    L30:
        r0 = r21;
        new i3c.b(c3c.f.a());     // Catch: Throwable -> L39
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new i3c.a(r0));     // Catch: Throwable -> L39
    L39:
        th = th;
    L42:
        com.bytedance.lark.sdk.d.r();
        throw th;
    L21:
        r19 = "failed";
        goto L22
    L13:
        r4 = com.ss.android.lark.diskmanage.storage.d.c(r21);     // Catch: Throwable -> L41
        r8 = com.ss.android.lark.utils.a0.d(r21);     // Catch: Throwable -> L41
        goto L14
    L6:
        r3 = InitSDKRequest.PackageId.FEISHU.getValue();     // Catch: Throwable -> L41
    L41:
        th = th;
        goto L42
    }
}
