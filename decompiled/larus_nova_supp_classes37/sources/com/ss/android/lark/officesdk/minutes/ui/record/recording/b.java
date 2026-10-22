package com.ss.android.lark.officesdk.minutes.ui.record.recording;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final Handler a = null;
    public static final Map<String, List<WeakReference<MmBaseRecordingActivity>>> b = null;

    public static final class a implements Runnable {
        public final /* synthetic */ Function0 a;

        public a(Function0 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        a = new Handler(Looper.getMainLooper());
        b = new LinkedHashMap();
    }

    public static void a(Function0 r2) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r2.invoke();
        return;
    L5:
        a.post(new a(r2));
    }
}
