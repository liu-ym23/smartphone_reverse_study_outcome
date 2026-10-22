package com.obric.aikernel;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.multiusr.AIKernelServiceEntry;
import com.obric.aikernel.multiusr.BaseMultiUsrService;
import com.obric.aikernel.tob.api.IToBStrategyManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class AIKernelService extends BaseMultiUsrService {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f4380g;

    public AIKernelService() {
        this.f4380g = "AIKernelService";
    }

    @Override // com.obric.aikernel.multiusr.BaseMultiUsrService
    protected ComponentName b() {
        return new ComponentName(getApplicationContext(), AIKernelServiceEntry.class);
    }

    @Override // com.obric.aikernel.multiusr.BaseMultiUsrService
    public IBinder c(Intent r10) {
        AIKLog r11 = AIKLog.INSTANCE;
        String r12 = this.f4380g;
        StringBuilder r13 = new StringBuilder();
        r13.append("onBind from ");
        String r14 = null;
        if (r10 == null) goto L5;
        String r15 = r10.toString();
    L6:
        r13.append(r15);
        r13.append(", pkg=");
        if (r10 == null) goto L9;
        String r16 = r10.getPackage();
    L10:
        r13.append(r16);
        r13.append(':');
        if (r10 == null) goto L13;
        r14 = r10.getType();
    L13:
        r13.append(r14);
        r13.append('.');
        r11.i(r12, r13.toString());
        IToBStrategyManager r17 = h8.a.a();
        if (r17 == null) goto L16;
        r17.handleAIKServiceOnBind(this, r10);
    L16:
        f r18 = f.f4481a;
        Context r19 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r19, "applicationContext");
        InferServiceWrapper r20 = r18.a(r19);
        BindResumeDispatcher.f4383a.b(r10);
        return r20;
    L9:
        r16 = null;
        goto L10
    L5:
        r15 = null;
        goto L6
    }

    @Override // android.app.Service
    protected void dump(FileDescriptor r10, PrintWriter r11, String[] r12) {
        if (r10 != null) goto L4;
        r10 = FileDescriptor.out;
    L4:
        f r13 = f.f4481a;
        Context r14 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r14, "applicationContext");
        r13.a(r14).dump(r10, r12);
        if (r11 == null) goto L8;
        r11.flush();
        return;
    }
}
