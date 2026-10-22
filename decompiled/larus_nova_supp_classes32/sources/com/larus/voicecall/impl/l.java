package com.larus.voicecall.impl;

import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.platform.service.i3;
import com.larus.voicecall.impl.component.core.b0;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l {
    public static Pair<Boolean, Boolean> i;
    public final Fragment a;
    public final IRealtimeCallTracer b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public CompletableDeferred<Integer> g;
    public boolean h;

    public static final class a {
        public static boolean a(Context r1) {
            Intrinsics.checkNotNullParameter(r1, "context");
            if (i3.a.i() == false) goto L5;
        L7:
            return false;
        L5:
            if (b(r1) == false) goto L7;
            return true;
        }

        public static boolean b(Context r1) {
            Intrinsics.checkNotNullParameter(r1, "context");
            if (ContextCompat.checkSelfPermission(r1, "android.permission.RECORD_AUDIO") != 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        Boolean r0 = Boolean.FALSE;
        i = TuplesKt.to(r0, r0);
    }

    public final void a(boolean r8, b0 r9) {
        Intrinsics.checkNotNullParameter(r9, "callback");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new RealtimeCallCheckManager$checkAll$1(this, r8, r9, null), 3, null);
    }

    public l(Fragment r2, IRealtimeCallTracer r3, String r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r4, "enterMethod");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.h = true;
    }
}
