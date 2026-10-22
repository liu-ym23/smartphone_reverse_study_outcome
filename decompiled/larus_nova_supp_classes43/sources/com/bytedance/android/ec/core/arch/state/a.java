package com.bytedance.android.ec.core.arch.state;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.core.arch.state.b;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a<S extends b> {
    public final Channel<Function1<S, S>> a;
    public final Channel<Function1<S, Unit>> b;
    public final MutableLiveData<S> c;
    public volatile S d;
    public final MutableLiveData e;
    public final CoroutineScope f;
    public final CoroutineContext g;

    /* JADX WARN: Multi-variable type inference failed */
    public a(b r10, CoroutineScope r11) {
        EmptyCoroutineContext r0 = EmptyCoroutineContext.INSTANCE;
        Intrinsics.checkNotNullParameter(r10, "initialState");
        Intrinsics.checkNotNullParameter(r11, "scope");
        Intrinsics.checkNotNullParameter(r0, "contextOverride");
        this.f = r11;
        this.g = r0;
        this.a = ChannelKt.Channel(Integer.MAX_VALUE);
        this.b = ChannelKt.Channel(Integer.MAX_VALUE);
        MutableLiveData<S> r1 = new MutableLiveData();
        r1.setValue(r10);
        Unit r12 = Unit.INSTANCE;
        this.c = r1;
        this.d = r10;
        this.e = r1;
        BuildersKt.launch$default(r11, Dispatchers.getIO().plus(r0), null, new CoroutinesStateStore$setupTriggerFlushQueues$1(this, null), 2, null);
    }
}
