package androidx.core.util;

import android.util.LruCache;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001aø\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000628\b\u0006\u0010\u0007\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b2%\b\u0006\u0010\r\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u000e2d\b\u0006\u0010\u000f\u001a^\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010H\u0086\b¨\u0006\u0016"}, d2 = {"lruCache", "Landroid/util/LruCache;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "maxSize", "", "sizeOf", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "key", EventBody.KEY_VALUE, "create", "Lkotlin/Function1;", "onEntryRemoved", "Lkotlin/Function4;", "", "evicted", "oldValue", "newValue", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LruCacheKt {

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0004J/\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00012\b\u0010\n\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010\u000bJ\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/util/LruCacheKt$lruCache$4", "Landroid/util/LruCache;", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "sizeOf", "", EventBody.KEY_VALUE, "(Ljava/lang/Object;Ljava/lang/Object;)I", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass4<K, V> extends LruCache<K, V> {
        final /* synthetic */ Function1<K, V> $create;
        final /* synthetic */ Function4<Boolean, K, V, V, Unit> $onEntryRemoved;
        final /* synthetic */ Function2<K, V, Integer> $sizeOf;

        public AnonymousClass4(int r3, Function2<? super K, ? super V, Integer> r4, Function1<? super K, ? extends V> r5, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> r6) {
            Function2<K, V, Integer> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
            Function1<K, V> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
            Function4<Boolean, K, V, V, Unit> r9 = (Function4) ZeusTransformUtils.wrapperContextForParams(r6, Function4.class, "com.obric.memorydata.plugin");
            this.$sizeOf = r7;
            this.$create = r8;
            this.$onEntryRemoved = r9;
            super(r3);
        }

        @Override // android.util.LruCache
        public V create(K r1) {
            return this.$create.invoke(r1);
        }

        @Override // android.util.LruCache
        public void entryRemoved(boolean r1, K r2, V r3, V r4) {
            this.$onEntryRemoved.invoke(Boolean.valueOf(r1), r2, r3, r4);
        }

        @Override // android.util.LruCache
        public int sizeOf(K r1, V r2) {
            return ((Number) ZeusTransformUtils.preCheckCast(this.$sizeOf.invoke(r1, r2), Number.class, "com.obric.memorydata.plugin")).intValue();
        }
    }

    public static final <K, V> LruCache<K, V> lruCache(int r2, Function2<? super K, ? super V, Integer> r3, Function1<? super K, ? extends V> r4, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> r5) {
        return (LruCache) ZeusTransformUtils.preCheckCast(new AnonymousClass4(r2, (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin"), (Function4) ZeusTransformUtils.wrapperContextForParams(r5, Function4.class, "com.obric.memorydata.plugin")), LruCache.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ LruCache lruCache$default(int r1, Function2 r2, Function1 r3, Function4 r4, int r5, Object r6) {
        Function2 r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function4 r9 = (Function4) ZeusTransformUtils.wrapperContextForParams(r4, Function4.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r7 = (Function2) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, Function2.class, "com.obric.memorydata.plugin");
    L6:
        if ((r5 & 4) == 0) goto L9;
        r8 = (Function1) ZeusTransformUtils.preCheckCast(AnonymousClass2.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L9:
        if ((r5 & 8) == 0) goto L12;
        r9 = (Function4) ZeusTransformUtils.preCheckCast(AnonymousClass3.INSTANCE, Function4.class, "com.obric.memorydata.plugin");
    L12:
        return (LruCache) ZeusTransformUtils.preCheckCast(new AnonymousClass4(r1, r7, r8, r9), LruCache.class, "com.obric.memorydata.plugin");
    }
}
