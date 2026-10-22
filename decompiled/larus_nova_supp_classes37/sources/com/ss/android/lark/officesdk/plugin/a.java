package com.ss.android.lark.officesdk.plugin;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginCallback;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginError;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginErrorCode;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginStage;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements CompletableOnSubscribe {
    public final /* synthetic */ Function1<OfficeSDKPluginCallback, Unit> a;
    public final /* synthetic */ OfficeSDKPluginStage b;
    public final /* synthetic */ String c;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.plugin.a$a, reason: collision with other inner class name */
    public static final class C0076a implements OfficeSDKPluginCallback {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ OfficeSDKPluginStage c;
        public final /* synthetic */ CompletableEmitter d;

        @Override // com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginCallback
        public final void onSuccess() {
            if (this.a.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            if (this.d.isDisposed() == true) goto L9;
            this.d.onComplete();
            return;
        }

        @Override // com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginCallback
        public final void onFailure(OfficeSDKPluginError r11) {
            Intrinsics.checkNotNullParameter(r11, "error");
            if (this.a.compareAndSet(false, true) == false) goto L6;
            this.d.tryOnError(new OfficeSDKPluginException(OfficeSDKPluginError.copy$default(r11, this.c, 0, null, null, null, 30, null), r11.getCause()));
            return;
        }

        @Override // com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginCallback
        public final void onProgress(int r6) {
            if (this.a.get() == false) goto L6;
            Log.w("OfficeSDKPluginRuntime", "Ignore progress after terminal callback, pluginId=" + this.b + ", stage=" + this.c + ", progress=" + r6);
            return;
        L6:
            boolean r0 = false;
            if (r6 >= 0) goto L9;
        L11:
            if (r0 == true) goto L14;
            Log.w("OfficeSDKPluginRuntime", "Ignore invalid progress, pluginId=" + this.b + ", stage=" + this.c + ", progress=" + r6);
            return;
        L14:
            Log.d("OfficeSDKPluginRuntime", "Plugin operation progress, pluginId=" + this.b + ", stage=" + this.c + ", progress=" + r6);
            return;
        L9:
            if (r6 >= 101) goto L11;
            r0 = true;
            goto L11
        }

        public C0076a(AtomicBoolean r1, String r2, OfficeSDKPluginStage r3, CompletableEmitter r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super OfficeSDKPluginCallback, Unit> r1, OfficeSDKPluginStage r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(CompletableEmitter r6) {
        Intrinsics.checkNotNullParameter(r6, "emitter");
        AtomicBoolean r0 = new AtomicBoolean(false);
        this.a.invoke(new C0076a(r0, this.c, this.b, r6));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (r0.compareAndSet(false, true) == false) goto L12;
        ConcurrentHashMap<String, Completable> r1 = d.a;
        r6.tryOnError(d.e(this.b, OfficeSDKPluginErrorCode.OPERATION_EXCEPTION, "Plugin operation failed: " + this.c, th));
        return;
    }
}
