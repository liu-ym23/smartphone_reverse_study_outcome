package com.ss.android.lark.officesdk.minutes.service.foundation.network.core;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import com.ss.android.lark.officesdk.minutes.service.foundation.userscope.MinutesUCCImpl;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final l a;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a b;
    public final CoroutineScope c;
    public final ConcurrentHashMap<Command, Disposable> d;
    public final ConcurrentHashMap<com.ss.android.lark.pb.improto.Command, Disposable> e;
    public final ConcurrentHashMap<Command, MutableSharedFlow<?>> f;
    public final ConcurrentHashMap<com.ss.android.lark.pb.improto.Command, MutableSharedFlow<?>> g;
    public final e h;

    public static final class a {
    }

    static {
    }

    public d(l r2, MinutesUCCImpl r3) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        Intrinsics.checkNotNullParameter(r3, "userContext");
        this.a = r2;
        this.b = r3;
        this.c = CoroutineScopeKt.CoroutineScope(MMCoroutines.b("MmNetPushHandler"));
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentHashMap();
        this.h = new e(this);
    }
}
