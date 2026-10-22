package com.ss.android.lark.lynxkit.xbridge;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00062\u0006\u0010\r\u001a\u0002H\u000b¢\u0006\u0002\u0010\u000eJ'\u0010\u000f\u001a\u00020\n\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00062\u0006\u0010\r\u001a\u0002H\u000b¢\u0006\u0002\u0010\u000eJ!\u0010\u0010\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0006¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\nR\u001e\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/ContextProviderFactory;", "", "<init>", "()V", "holders", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "weakHolders", "Ljava/lang/ref/WeakReference;", "registerHolder", "", "T", "clazz", "instance", "(Ljava/lang/Class;Ljava/lang/Object;)V", "registerWeakHolder", "get", "(Ljava/lang/Class;)Ljava/lang/Object;", "removeAll", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ContextProviderFactory {
    private final ConcurrentHashMap<Class<?>, Object> holders;
    private final ConcurrentHashMap<Class<?>, WeakReference<?>> weakHolders;

    public final void removeAll() {
        this.holders.clear();
        this.weakHolders.clear();
    }

    public ContextProviderFactory() {
        this.holders = new ConcurrentHashMap();
        this.weakHolders = new ConcurrentHashMap();
    }

    public final <T> T get(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        T r0 = (T) this.holders.get(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        WeakReference<?> r3 = this.weakHolders.get(r2);
        if (r3 == null) goto L10;
        T r4 = (T) r3.get();
        if (r4 == null) goto L12;
        return r4;
    L12:
        return null;
    L10:
        return null;
    }

    public final <T> void registerHolder(Class<T> r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        ConcurrentHashMap<Class<?>, Object> r0 = this.holders;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Any");
        r0.put(r3, r4);
    }

    public final <T> void registerWeakHolder(Class<T> r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        this.weakHolders.put(r3, new WeakReference(r4));
    }
}
