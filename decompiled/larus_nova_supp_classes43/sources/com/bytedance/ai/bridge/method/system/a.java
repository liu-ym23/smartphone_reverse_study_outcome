package com.bytedance.ai.bridge.method.system;

import android.app.Activity;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.OnPermissionGrantCallback;
import com.bytedance.ai.event.MessageIndication;
import f3.h;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import r4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements OnPermissionGrantCallback {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ h<AbsGetLocationMethodIDL.b> b;

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.system.a$a, reason: collision with other inner class name */
    public static final class C0036a implements r4.c {
        public final /* synthetic */ h<AbsGetLocationMethodIDL.b> a;
        public final /* synthetic */ boolean b;

        @Override // r4.c
        public final void b(r4.d r10) {
            Intrinsics.checkNotNullParameter(r10, "locationResult");
            h<AbsGetLocationMethodIDL.b> r0 = this.a;
            Intrinsics.checkNotNullParameter(AbsGetLocationMethodIDL.b.class, "<this>");
            BaseModel r1 = k3.c.a(AbsGetLocationMethodIDL.b.class);
            AbsGetLocationMethodIDL.b r11 = (AbsGetLocationMethodIDL.b) r1;
            r11.setEnable(Boolean.valueOf(this.b));
            r11.setLongitude(Double.valueOf(r10.b));
            r11.setLatitude(Double.valueOf(r10.a));
            h.a.b(r0, (ResultModel) r1);
        }

        public final void c(String r10) {
            Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
            h<AbsGetLocationMethodIDL.b> r0 = this.a;
            Intrinsics.checkNotNullParameter(AbsGetLocationMethodIDL.b.class, "<this>");
            BaseModel r1 = k3.c.a(AbsGetLocationMethodIDL.b.class);
            AbsGetLocationMethodIDL.b r11 = (AbsGetLocationMethodIDL.b) r1;
            r11.setEnable(Boolean.valueOf(this.b));
            r11.setLongitude(null);
            r11.setLatitude(null);
            Unit r12 = Unit.INSTANCE;
            h.a.a(r0, r10, null, r11.toJson(), 6);
        }

        public C0036a(h<AbsGetLocationMethodIDL.b> r1, boolean r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // r4.c
        public final void a(String r1, int r10) {
            Intrinsics.checkNotNullParameter(r1, MessageIndication.MESSAGE_TYPE_MSG);
            c(r1);
        }
    }

    @Override // com.bytedance.ai.bridge.service.OnPermissionGrantCallback
    public final void onAllGranted() {
        Activity r1 = this.a;
        h<AbsGetLocationMethodIDL.b> r0 = this.b;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L9
        boolean r11 = g4.a.b(r1);     // Catch: Throwable -> L9
        k r12 = r4.a.k;     // Catch: Throwable -> L9
        if (r12 != null) goto L7;
        h.a.a(r0, "HostSystemActionDepend is null", null, null, 14);     // Catch: Throwable -> L9
        return;
    L7:
        r12.d(r1, null, null, null, null, new C0036a(r0, r11), null, null);     // Catch: Throwable -> L9
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        h<AbsGetLocationMethodIDL.b> r14 = this.b;
        Throwable r15 = Result.exceptionOrNull-impl(r13);
        if (r15 == null) goto L16;
        h.a.a(r14, "get location err:" + r15.getMessage(), null, null, 14);
        return;
    L16:
        return;
    L9:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // com.bytedance.ai.bridge.service.OnPermissionGrantCallback
    public final void onNotGranted() {
        h<AbsGetLocationMethodIDL.b> r0 = this.b;
        Intrinsics.checkNotNullParameter(AbsGetLocationMethodIDL.b.class, "<this>");
        AbsGetLocationMethodIDL.b r1 = (AbsGetLocationMethodIDL.b) k3.c.a(AbsGetLocationMethodIDL.b.class);
        r1.setEnable(Boolean.FALSE);
        r1.setLongitude(null);
        r1.setLatitude(null);
        Unit r10 = Unit.INSTANCE;
        h.a.a(r0, "no location permission", null, r1.toJson(), 6);
    }

    public a(Activity r1, h<AbsGetLocationMethodIDL.b> r10) {
        this.a = r1;
        this.b = r10;
    }
}
