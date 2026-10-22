package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import android.os.Message;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.chatroom.widget.LiveMessageRecyclerView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.settings.config.o0;
import com.bytedance.common.utility.collection.WeakHandler;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n {
    public final WeakHandler a;
    public final RecyclerView b;

    public static final class a implements Runnable {
        public final /* synthetic */ RecyclerView.Adapter a;

        public a(RecyclerView.Adapter r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.notifyDataSetChanged();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void a(RecyclerView.Adapter<?> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        b(new a(r2), "DataSetChanged");
    }

    public n(WeakHandler r2, LiveMessageRecyclerView r3) {
        Intrinsics.checkNotNullParameter(r2, "weakHandler");
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        this.a = r2;
        this.b = r3;
    }

    public final void b(Runnable r4, String r5) {
        if (this.b.isComputingLayout() == false) goto L10;
        o0 r0 = PublicScreenABHelper.D;
        if (r0.checkLayoutWhileUpdateData == false) goto L10;
        SafetyGuard.a(null, null, "Public Screen Data Update " + r5 + " called While Layout or Scroll");
        if (r0.postUpdateDuringLayout == true) goto L9;
        return;
    L9:
        Message r6 = Message.obtain();
        r6.what = 7;
        r6.obj = r4;
        this.a.sendMessage(r6);
        return;
    L10:
        r4.run();
    }
}
