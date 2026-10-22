package com.obric.aikernel.isolate.impl;

import android.content.pm.PackageManager;
import android.os.Binder;
import com.obric.aikernel.isolate.api.IDebugPssCollect;
import com.obric.aikernel.isolate.api.IIsolateApi;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.flow.k1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class DebugPssCollectImpl implements IDebugPssCollect {
    public static final DebugPssCollectImpl INSTANCE = null;
    private static final f1<Unit> debugNextPack = null;
    private static final ArrayList<JSONObject> debugPackMemoryResult = null;

    static {
        INSTANCE = new DebugPssCollectImpl();
        debugPackMemoryResult = new ArrayList();
        debugNextPack = k1.b(0, 1, null, 5, null);
    }

    private DebugPssCollectImpl() {
    }

    @JvmStatic
    public static final DebugPssCollectImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.aikernel.isolate.api.IDebugPssCollect
    public boolean canBind(PackageManager r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "packageManager");
        Intrinsics.checkNotNullParameter(r11, "pName");
        boolean r12 = true;
        if (isDebugOpen() == false) goto L17;
        String r13 = null;
        String[] r14 = r10.getPackagesForUid(Binder.getCallingUid());
        if (r14 != null) goto L7;
    L13:
        if (r12 == true) goto L16;
        r13 = r14[0];
    L16:
        return Intrinsics.areEqual(r11, r13);
    L7:
        if (r14.length != 0) goto L9;
        boolean r15 = true;
    L10:
        if (r15 == true) goto L13;
        r12 = false;
        goto L13
    L9:
        r15 = false;
        goto L10
    L17:
        return true;
    }

    @Override // com.obric.aikernel.isolate.api.IDebugPssCollect
    public f1<Unit> getDebugNextPack() {
        return debugNextPack;
    }

    @Override // com.obric.aikernel.isolate.api.IDebugPssCollect
    public ArrayList<JSONObject> getDebugPackMemoryResult() {
        return debugPackMemoryResult;
    }

    @Override // com.obric.aikernel.isolate.api.IDebugPssCollect
    public boolean isDebugOpen() {
        if (AppContext.INSTANCE.isAdminMode() == false) goto L13;
        IIsolateApi r10 = k7.b.a();
        if (r10 == null) goto L9;
        k7.a r11 = r10.debugKV();
        if (r11 == null) goto L9;
        boolean r12 = r11.b();
    L10:
        if (r12 == false) goto L14;
        return true;
    L14:
        return false;
    L9:
        r12 = false;
        goto L10
    L13:
        return false;
    }

    @Override // com.obric.aikernel.isolate.api.IDebugPssCollect
    public void nextPack() {
        if (isDebugOpen() == true) goto L5;
        return;
    L5:
        getDebugNextPack().c(Unit.INSTANCE);
    }

    @Override // com.obric.aikernel.isolate.api.IDebugPssCollect
    public Object waitNextDebugPack(Continuation<? super Unit> r10) {
        if (isDebugOpen() == false) goto L5;
        Object r11 = e.p(getDebugNextPack(), r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r11;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }
}
