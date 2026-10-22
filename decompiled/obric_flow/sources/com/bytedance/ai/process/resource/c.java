package com.bytedance.ai.process.resource;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.process.h;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Binder implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f2456b;

    public c(AtomicReference r5, int r10) {
        this.f2455a = r10;
        this.f2456b = r5;
        attachInterface(this, "com.bytedance.ai.process.ILoadAIPackageCallback");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // com.bytedance.ai.process.h
    public final void b(Applet r5) {
        switch(this.f2455a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter("AIManagerRemoteProxy", "tag");
        t0.d r10 = com.bytedance.ai.utils.c.f2846a;
        if (r10 == null) goto L17;
        r10.e("AIManagerRemoteProxy", "invalid callback--onAppletResult");
        return;
    L17:
        return;
    L8:
        StringBuilder r11 = new StringBuilder("onAppletResult: ");
        r11.append(r5);
        r11.append(", sessionId: ");
        if (r5 == null) goto L11;
        String r12 = r5.f2276x;
    L12:
        String r13 = androidx.room.jarjarred.org.antlr.runtime.a.v(r11, r12, "AIManagerRemoteProxy", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L15;
        r14.d("AIManagerRemoteProxy", r13);
    L15:
        AIManagerRemoteProxy$loadAIPackageFromServer$2.AnonymousClass1.a(this.f2456b, r5);
        return;
    L11:
        r12 = null;
        goto L12
    }

    @Override // com.bytedance.ai.process.h
    public final void c(Widget r5) {
        switch(this.f2455a) {
            case 0: goto L13;
            default: goto L4;
        };
    L4:
        StringBuilder r10 = new StringBuilder("onWidgetResult: ");
        r10.append(r5);
        r10.append(", sessionId: ");
        if (r5 == null) goto L7;
        String r11 = r5.f2276x;
    L8:
        String r12 = androidx.room.jarjarred.org.antlr.runtime.a.v(r10, r11, "AIManagerRemoteProxy", "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L11;
        r13.d("AIManagerRemoteProxy", r12);
    L11:
        AIManagerRemoteProxy$loadAIPackageFromServer$2.AnonymousClass1.a(this.f2456b, r5);
        return;
    L7:
        r11 = null;
        goto L8
    L13:
        Intrinsics.checkNotNullParameter("AIManagerRemoteProxy", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L17;
        r14.e("AIManagerRemoteProxy", "invalid callback--onWidgetResult");
        return;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int r5, Parcel r10, Parcel r11, int r12) {
        Applet r13 = null;
        Widget r14 = null;
        if (r5 != 1) goto L5;
        r10.enforceInterface("com.bytedance.ai.process.ILoadAIPackageCallback");
        if (r10.readInt() == 0) goto L20;
        r13 = Applet.CREATOR.createFromParcel(r10);
    L20:
        b(r13);
        r11.writeNoException();
        return true;
    L5:
        if (r5 != 2) goto L7;
        r10.enforceInterface("com.bytedance.ai.process.ILoadAIPackageCallback");
        if (r10.readInt() == 0) goto L15;
        r14 = Widget.CREATOR.createFromParcel(r10);
    L15:
        c(r14);
        r11.writeNoException();
        return true;
    L7:
        if (r5 != 1598968902) goto L9;
        r11.writeString("com.bytedance.ai.process.ILoadAIPackageCallback");
        return true;
    L9:
        return super.onTransact(r5, r10, r11, r12);
    }
}
