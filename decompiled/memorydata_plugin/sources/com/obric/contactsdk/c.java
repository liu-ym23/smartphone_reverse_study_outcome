package com.obric.contactsdk;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\u0006\u0010\u0015\u001a\u00020\u0011J\u0006\u0010\u0016\u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/contactsdk/CallSmsDataDonation;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mCallFeatureObserverInit", "", "mContactsDonateObserverInit", "getMContext", "()Landroid/content/Context;", "mHandlerThreadInit", "mMmsDonateObserverInit", "mSmsMmsDonateHandler", "Landroid/os/Handler;", "mSmsMmsDonateHandlerThread", "Landroid/os/HandlerThread;", "initCallFeatureObserver", "", "initContactsDataAwareness", "initDataAwareness", "initHandlerThread", "initMmsSmsDataAwareness", "release", "Companion", "contactsdk_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7851a = null;
    private static final String i = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f7852b;
    private Handler c;
    private HandlerThread d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/contactsdk/CallSmsDataDonation$Companion;", "", "()V", "TAG", "", "contactsdk_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f7851a = new a(null);
        i = "CallSmsDataDonation";
    }

    public c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "mContext");
        this.f7852b = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
    }

    private final void d() {
        if (this.h == false) goto L6;
        Log.d(i, "initHandlerThread: mHandlerThreadInit is true");
        return;
    L6:
        HandlerThread r0 = new HandlerThread("SmsMmsDonateHandlerThread");
        this.d = r0;
        HandlerThread r1 = null;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mSmsMmsDonateHandlerThread");
        r0 = null;
    L9:
        r0.start();
        HandlerThread r3 = this.d;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mSmsMmsDonateHandlerThread");
    L13:
        this.c = new Handler(r1.getLooper());
        this.h = true;
        return;
    L12:
        r1 = r3;
        goto L13
    }

    public final void a() {
        if (this.e == false) goto L6;
        Log.d(i, "initContactsDataAwareness: mContactsDonateObserverInit is true");
        return;
    L6:
        d();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        c r2 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        ZeusProviderTransform.registerContentObserver(r2.f7852b.getContentResolver(), com.obric.contactsdk.loader.f.b(), false, (ContentObserver) ZeusTransformUtils.preCheckCast(new defpackage.a(new Handler(), r2.f7852b), ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        r2.c();     // Catch: Throwable -> L9
        Object r3 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r3);
        if (r4 == null) goto L15;
        Log.e(i, "initContactsDataAwareness: registerContentObserver failed", r4);
    L15:
        if (Result.m1428isSuccessimpl(r3) == false) goto L20;
        Unit r0 = (Unit) ZeusTransformUtils.preCheckCast(r3, Unit.class, "com.obric.memorydata.plugin");
        this.e = true;
        return;
    L20:
        return;
    L9:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final void b() {
        if (this.f == false) goto L6;
        Log.d(i, "initMmsSmsDataAwareness: mMmsDonateObserverInit is true");
        return;
    L6:
        d();
        ContentResolver r0 = this.f7852b.getContentResolver();
        Uri r1 = com.obric.smssdk.utils.a.f14982a.a();
        Handler r4 = this.c;
        if (r4 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mSmsMmsDonateHandler");
        r4 = null;
    L9:
        ZeusProviderTransform.registerContentObserver(r0, r1, false, (ContentObserver) ZeusTransformUtils.preCheckCast(new com.obric.smssdk.c(r4, this.f7852b), ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f = true;
    }

    public final void c() {
        if (this.g == false) goto L6;
        Log.d(i, "initCallFeatureObserver: mCallFeatureObserverInit is true");
        return;
    L6:
        d();
        ZeusProviderTransform.registerContentObserver(this.f7852b.getContentResolver(), com.obric.contactsdk.loader.c.a(), false, (ContentObserver) ZeusTransformUtils.preCheckCast(new com.obric.contactsdk.a(new Handler(), this.f7852b), ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.g = true;
    }
}
