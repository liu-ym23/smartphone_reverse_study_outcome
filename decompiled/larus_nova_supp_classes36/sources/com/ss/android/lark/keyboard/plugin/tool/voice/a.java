package com.ss.android.lark.keyboard.plugin.tool.voice;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements Runnable {
    public final /* synthetic */ Function0<Unit> a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ AudioRecordMutexController c;
    public final /* synthetic */ b d;

    public a(Function0<Unit> r1, Context r2, AudioRecordMutexController r3, b r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        Function0<Unit> r0 = this.a;
        if (r0 == null) goto L5;
        r0.invoke();
    L10:
        String r1 = UIUtils.getString(this.b, 2131891301);
        Context r2 = this.b;
        Intrinsics.checkNotNull(r1);
        UDToast.show(r2, r1);
        AudioRecordMutexController r3 = this.c;
        b r4 = this.d;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "listener");
        r3.b.remove(r4);
        return;
    L5:
        StringBuilder r5 = new StringBuilder("onInterrupted cancelBlockRef is null, isParamNull:");
        if (this.a != null) goto L8;
        boolean r6 = true;
    L9:
        r5.append(r6);
        Log.i("AudioRecordMutexController", r5.toString());
        goto L10
    L8:
        r6 = false;
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
