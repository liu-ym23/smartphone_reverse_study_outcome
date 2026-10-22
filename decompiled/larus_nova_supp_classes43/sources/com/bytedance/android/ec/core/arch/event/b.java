package com.bytedance.android.ec.core.arch.event;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.arch.lifecycle.e;
import com.bytedance.android.ec.core.arch.viewmodel.QStateViewModel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.BroadcastChannelImpl;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.internal.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public b() {
    }

    static {
    }

    public static void b(QStateViewModel r10, d r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "stateViewModel");
        Intrinsics.checkNotNullParameter(r11, "event");
        ConcurrentHashMap<String, a> r13 = r10.getEventMap$ec_core_saasRelease();
        String r0 = Reflection.getOrCreateKotlinClass(r11.getClass()).getQualifiedName();
        a r1 = r13.get(r0);
        if (r1 != null) goto L8;
        b0 r14 = kotlinx.coroutines.channels.d.a;
        Channel.Factory.getClass();
        r1 = new a(new BroadcastChannelImpl(Channel.a.b));
        a r15 = r13.putIfAbsent(r0, r1);
        if (r15 == null) goto L8;
        r1 = r15;
    L8:
        a r16 = r1;
        if (r12 == true) goto L11;
        r16.d.offer(r11);
        return;
    L11:
        if (r16.b == false) goto L13;
        r16.d.offer(r11);
        return;
    L13:
        r16.c = r11;
    }

    public static void a(QStateViewModel r16, boolean r17, LifecycleOwner r18, CoroutineContext r19, KClass r20, Function1 r21, int r22) {
        if ((r22 & 2) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r22 & 4) == 0) goto L9;
        LifecycleOwner r10 = null;
    L11:
        if ((r22 & 8) == 0) goto L13;
        CoroutineContext r11 = EmptyCoroutineContext.INSTANCE;
    L14:
        Intrinsics.checkNotNullParameter(r16, "stateViewModel");
        Intrinsics.checkNotNullParameter(r11, "dispatcher");
        Intrinsics.checkNotNullParameter(r20, "eventKClass");
        Intrinsics.checkNotNullParameter(r21, "block");
        ConcurrentHashMap<String, a> r12 = r16.getEventMap$ec_core_saasRelease();
        String r13 = r20.getQualifiedName();
        a r14 = r12.get(r13);
        if (r14 != null) goto L20;
        b0 r15 = kotlinx.coroutines.channels.d.a;
        Channel.Factory.getClass();
        r14 = new a(new BroadcastChannelImpl(Channel.a.b));
        a r23 = r12.putIfAbsent(r13, r14);
        if (r23 == null) goto L20;
        r14 = r23;
    L20:
        a r24 = r14;
        r24.b = true;
        if (r0 == false) goto L27;
        Intrinsics.checkNotNull(r10);
        CoroutineScope r110 = e.a(r10);
        if (r110 != null) goto L25;
    L26:
        BuildersKt.launch$default(mg.b.a(r16), Dispatchers.getMain(), null, new EventFunc$collect$1(r24, r21, null), 2, null);
        Unit r1 = Unit.INSTANCE;
        return;
    L25:
        if (BuildersKt.launch$default(r110, null, null, new EventFunc$observeEvent$1(r10, r24, r11, r21, null), 3, null) == null) goto L26;
        return;
    L27:
        BuildersKt.launch$default(mg.b.a(r16), r11, null, new EventFunc$collect$1(r24, r21, null), 2, null);
        return;
    L13:
        r11 = r19;
        goto L14
    L9:
        r10 = r18;
        goto L11
    L5:
        r0 = r17;
        goto L7
    }
}
