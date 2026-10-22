package obric.flow.thermal;

import android.content.Context;
import android.os.IBinder;
import android.os.IThermalService;
import android.os.ServiceManager;
import android.os.Temperature;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static a f20537h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f20538i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Lambda f20539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IThermalService f20540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f20541c;
    public volatile float d;
    public volatile boolean e;
    public final AppThermalHelper$SkinThermalEventListener f;
    public final ArrayList g;

    static {
        f20538i = new Object();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [obric.flow.thermal.AppThermalHelper$SkinThermalEventListener] */
    public a() {
        this.d = -1.0f;
        this.f = new AppThermalHelper$SkinThermalEventListener(this);
        this.g = CollectionsKt.arrayListOf(new String[]{"com.android.mms", "com.android.contacts"});
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Function0 r5) {
        Intrinsics.checkNotNullParameter(r5, "notifyThermalAction");
        this.f20539a = (Lambda) r5;
        if (this.e == false) goto L16;
        Log.d("AppThermalHelper", "Thermal monitoring already started");
        return;
    L16:
        IBinder r10 = ServiceManager.getService("thermalservice");     // Catch: Exception -> L9
        if (r10 == null) goto L11;
        this.f20540b = IThermalService.Stub.asInterface(r10);     // Catch: Exception -> L9
        c();     // Catch: Exception -> L9
        this.e = true;     // Catch: Exception -> L9
        Log.d("AppThermalHelper", "Thermal monitoring service initialized successfully");     // Catch: Exception -> L9
    L15:
        return;
    L11:
        Log.e("AppThermalHelper", "Failed to get thermal service");     // Catch: Exception -> L9
    L9:
        e = move-exception;
        Log.e("AppThermalHelper", "Failed to initialize thermal monitoring service", e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v9, types: [kotlin.jvm.functions.Function0] */
    public final void b(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L6
        Lambda r11 = this.f20539a;     // Catch: Throwable -> L6
        ?? r12 = r11;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("notifyThermalActionListener");     // Catch: Throwable -> L6
        r12 = 0;
    L8:
        Object r13 = Result.m124constructorimpl((Unit) r12.invoke());     // Catch: Throwable -> L6
    L11:
        Throwable r14 = Result.m127exceptionOrNullimpl(r13);
        if (r14 == null) goto L17;
        Log.e("AppThermalHelper", "showOverheatToast:" + r14.getMessage());
        return;
    L17:
        return;
    L6:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final void c() {
        IThermalService r5 = this.f20540b;
        if (r5 != null) goto L11;
        Log.w("AppThermalHelper", "Thermal service not initialized, cannot register listener");
        return;
    L11:
        r5.registerThermalEventListenerWithType(this.f, 20);     // Catch: Exception -> L8
        Log.d("AppThermalHelper", "Skin thermal listener registered successfully");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.e("AppThermalHelper", "Failed to register skin thermal listener", e);
    }

    public final void d() {
        if (this.e == false) goto L12;
        IThermalService r5 = this.f20540b;
        if (r5 == null) goto L12;
        r5.unregisterThermalEventListener(this.f);     // Catch: Exception -> L9
        this.e = false;     // Catch: Exception -> L9
        this.f20540b = null;     // Catch: Exception -> L9
        this.f20541c = 0;     // Catch: Exception -> L9
        this.d = -1.0f;     // Catch: Exception -> L9
        this.f20539a = AppThermalHelper$release$1.INSTANCE;     // Catch: Exception -> L9
        Log.d("AppThermalHelper", "Thermal monitoring service released");     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        Log.e("AppThermalHelper", "Failed to unregister thermal listener", e);
        return;
    L12:
        Log.w("AppThermalHelper", "Thermal monitoring service not initialized, mIsListening: " + this.e);
    }

    public final void e(Temperature r5) {
        Intrinsics.checkNotNullParameter(r5, "temperature");
        this.f20541c = r5.getStatus();
        this.d = r5.getValue();
        StringCompanionObject r10 = StringCompanionObject.INSTANCE;
        Log.d("AppThermalHelper", String.format("Skin temperature updated - Status: %d, Temp: %f℃", Arrays.copyOf(new Object[]{Integer.valueOf(this.f20541c), Float.valueOf(this.d)}, 2)));
    }
}
