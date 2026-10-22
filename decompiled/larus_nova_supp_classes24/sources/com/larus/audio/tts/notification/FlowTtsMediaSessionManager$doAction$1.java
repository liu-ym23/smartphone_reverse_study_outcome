package com.larus.audio.tts.notification;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import m58.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.tts.notification.FlowTtsMediaSessionManager$doAction$1", f = "FlowTtsMediaSessionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowTtsMediaSessionManager$doAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<g, Unit> $action;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FlowTtsMediaSessionManager this$0;

    public static final class a implements ServiceConnection {
        public final /* synthetic */ FlowTtsMediaSessionManager a;

        public a(FlowTtsMediaSessionManager r1) {
            this.a = r1;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r2) {
            Intrinsics.checkNotNullParameter(r2, "name");
            this.a.a = null;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r2, IBinder r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "binder");
            FlowTtsMediaService r0 = null;
            if ((r3 instanceof FlowTtsMediaService.b) == false) goto L5;
            FlowTtsMediaService.b r4 = (FlowTtsMediaService.b) r3;
        L6:
            if (r4 == null) goto L8;
            r0 = r4.a;
        L8:
            this.a.a = r0;
            ArrayList r5 = new ArrayList(this.a.d);
            this.a.d.clear();
            Iterator r6 = r5.iterator();
        L10:
            if (r6.hasNext() == false) goto L12;
            Function1 r7 = (Function1) r6.next();
            Intrinsics.checkNotNull(r0);
            r7.invoke(r0);
            goto L10
        L12:
            this.a.b = false;
            return;
        L5:
            r4 = null;
            goto L6
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlowTtsMediaSessionManager$doAction$1(FlowTtsMediaSessionManager r1, Function1<? super g, Unit> r2, Continuation<? super FlowTtsMediaSessionManager$doAction$1> r3) {
        this.this$0 = r1;
        this.$action = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        FlowTtsMediaSessionManager$doAction$1 r0 = new FlowTtsMediaSessionManager$doAction$1(this.this$0, this.$action, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L38;
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        FlowTtsMediaSessionManager r8 = this.this$0;
        g r0 = r8.a;
        if (r0 == null) goto L20;
        Function1<g, Unit> r1 = this.$action;
        if (r0.a() == true) goto L10;
        r1.invoke(r0);
        return Unit.INSTANCE;
    L10:
        m58.b r2 = h.k;
        if (r2 == null) goto L13;
        Application r3 = r2.getApplication();
    L14:
        ServiceConnection r4 = r8.c;
        if (r4 == null) goto L19;
        if (r3 != null) goto L42;
    L18:
        r8.c = null;
        goto L19
    L42:
        r3.unbindService(r4);     // Catch: Exception -> L39
    L19:
        r8.a = null;
        goto L20
    L13:
        r3 = null;
    L20:
        this.this$0.d.add(this.$action);
        FlowTtsMediaSessionManager r9 = this.this$0;
        if (r9.b == true) goto L23;
        r9.b = true;
        a r5 = new a(r9);
        r9.c = r5;
        m58.b r10 = h.k;
        if (r10 == null) goto L35;
        Application r11 = r10.getApplication();
        if (r11 == null) goto L35;
        r11.bindService(new Intent(r11, FlowTtsMediaService.class), r5, 1);     // Catch: Exception -> L32
    L34:
        return Unit.INSTANCE;
    L32:
        this.this$0.b = false;
    L35:
        this.this$0.b = false;
        return Unit.INSTANCE;
    L23:
        return Unit.INSTANCE;
    L38:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
