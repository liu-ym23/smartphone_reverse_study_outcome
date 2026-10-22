package com.ss.android.lark.officesdk.minutes.assembly.fileupload;

import android.content.Context;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager;
import eub.a;
import eub.f;
import eub.h;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@OfficeSDKUserScope
public final class MmMinutesFileUploadCapacityImpl implements a {

    @Inject
    public com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final Lazy b;

    @Inject
    public MmMinutesFileUploadCapacityImpl() {
        this.b = LazyKt.lazy(new MmMinutesFileUploadCapacityImpl$manager$2(this));
    }

    @Override // eub.a
    public final z0 O9(String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        MmMinutesFileUploadSessionManager r1 = (MmMinutesFileUploadSessionManager) this.b.getValue();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "taskId");
        MmMinutesFileUploadSessionManager.e r4 = r1.p.get(r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.b;
    }

    @Override // eub.a
    public final void setContext(Context r5) {
        MmMinutesFileUploadSessionManager r0 = (MmMinutesFileUploadSessionManager) this.b.getValue();
        String r1 = r0.d;
        StringBuilder r2 = new StringBuilder("setContext: context=");
        if (r5 == null) goto L5;
        String r3 = r5.getClass().getSimpleName();
    L6:
        r2.append(r3);
        r2.append(", isNull=");
        if (r5 != null) goto L9;
        boolean r4 = true;
    L10:
        r2.append(r4);
        lvb.a.e(r1, r2.toString());
        r0.t = r5;
        return;
    L9:
        r4 = false;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    @Override // eub.a
    public final Object c4(f r2, Continuation<? super String> r3) {
        return ((MmMinutesFileUploadSessionManager) this.b.getValue()).H(r2, r3);
    }

    @Override // eub.a
    public final Object jb(h r2, Continuation<? super String> r3) {
        return ((MmMinutesFileUploadSessionManager) this.b.getValue()).G(r2, r3);
    }
}
