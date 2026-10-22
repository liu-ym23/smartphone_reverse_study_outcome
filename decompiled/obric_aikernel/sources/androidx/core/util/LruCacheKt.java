package androidx.core.util;

import android.util.LruCache;
import com.bytedance.crash.entity.EventBody;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
public final class LruCacheKt {

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$4, reason: invalid class name */
    @SourceDebugExtension({"SMAP\nLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LruCache.kt\nandroidx/core/util/LruCacheKt$lruCache$4\n*L\n1#1,54:1\n*E\n"})
    public static final class AnonymousClass4<K, V> extends LruCache<K, V> {
        final /* synthetic */ Function1<K, V> $create;
        final /* synthetic */ Function4<Boolean, K, V, V, Unit> $onEntryRemoved;
        final /* synthetic */ Function2<K, V, Integer> $sizeOf;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(int r10, Function2<? super K, ? super V, Integer> r11, Function1<? super K, ? extends V> r12, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> r13) {
            this.$sizeOf = r11;
            this.$create = r12;
            this.$onEntryRemoved = r13;
            super(r10);
        }

        @Override // android.util.LruCache
        protected V create(K r10) {
            Intrinsics.checkNotNullParameter(r10, "key");
            return this.$create.invoke(r10);
        }

        @Override // android.util.LruCache
        protected void entryRemoved(boolean r10, K r11, V r12, V r13) {
            Intrinsics.checkNotNullParameter(r11, "key");
            Intrinsics.checkNotNullParameter(r12, "oldValue");
            this.$onEntryRemoved.invoke(Boolean.valueOf(r10), r11, r12, r13);
        }

        @Override // android.util.LruCache
        protected int sizeOf(K r10, V r11) {
            Intrinsics.checkNotNullParameter(r10, "key");
            Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
            return this.$sizeOf.invoke(r10, r11).intValue();
        }
    }

    public static final <K, V> LruCache<K, V> lruCache(int r10, Function2<? super K, ? super V, Integer> r11, Function1<? super K, ? extends V> r12, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> r13) {
        Intrinsics.checkNotNullParameter(r11, "sizeOf");
        Intrinsics.checkNotNullParameter(r12, "create");
        Intrinsics.checkNotNullParameter(r13, "onEntryRemoved");
        return new AnonymousClass4(r10, r11, r12, r13);
    }

    public static /* synthetic */ LruCache lruCache$default(int r10, Function2 r11, Function1 r12, Function4 r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = AnonymousClass1.INSTANCE;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = AnonymousClass2.INSTANCE;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = AnonymousClass3.INSTANCE;
    L11:
        Intrinsics.checkNotNullParameter(r11, "sizeOf");
        Intrinsics.checkNotNullParameter(r12, "create");
        Intrinsics.checkNotNullParameter(r13, "onEntryRemoved");
        return new AnonymousClass4(r10, r11, r12, r13);
    }
}
