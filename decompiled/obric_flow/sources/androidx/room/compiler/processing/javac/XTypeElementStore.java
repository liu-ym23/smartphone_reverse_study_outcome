package androidx.room.compiler.processing.javac;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.processing.XTypeElement;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004Bc\u0012#\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u0012\u001a\u00028\u00012\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0017J\u0016\u0010\u0018\u001a\u00028\u00012\u0006\u0010\u0019\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u0018\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0002\u0010\u001bR+\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\f\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/room/compiler/processing/javac/XTypeElementStore;", "BackingType", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/compiler/processing/XTypeElement;", "", "findElement", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "qName", "getQName", "wrap", "type", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "typeCache", "", "Ljava/lang/ref/WeakReference;", "cache", "element", "(Ljava/lang/String;Landroidx/room/compiler/processing/XTypeElement;)Landroidx/room/compiler/processing/XTypeElement;", "clear", "", "clear$room_compiler_processing", "get", "backingType", "(Ljava/lang/Object;)Landroidx/room/compiler/processing/XTypeElement;", "(Ljava/lang/String;)Landroidx/room/compiler/processing/XTypeElement;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class XTypeElementStore<BackingType, T extends XTypeElement> {
    private final Function1<String, BackingType> findElement;
    private final Function1<BackingType, String> getQName;
    private final Map<String, WeakReference<T>> typeCache;
    private final Function1<BackingType, T> wrap;

    /* JADX WARN: Multi-variable type inference failed */
    public XTypeElementStore(Function1<? super String, ? extends BackingType> r5, Function1<? super BackingType, String> r10, Function1<? super BackingType, ? extends T> r11) {
        Intrinsics.checkNotNullParameter(r5, "findElement");
        Intrinsics.checkNotNullParameter(r10, "getQName");
        Intrinsics.checkNotNullParameter(r11, "wrap");
        this.findElement = r5;
        this.getQName = r10;
        this.wrap = r11;
        this.typeCache = new LinkedHashMap();
    }

    private final T cache(String r5, T r10) {
        this.typeCache.put(r5, new WeakReference(r10));
        return r10;
    }

    public final void clear$room_compiler_processing() {
        this.typeCache.clear();
    }

    public final T get(BackingType r5) {
        String r10 = this.getQName.invoke(r5);
        if (r10 == null) goto L5;
        WeakReference<T> r11 = this.typeCache.get(r10);
        if (r11 == null) goto L12;
        T r12 = r11.get();
        if (r12 == null) goto L12;
        return r12;
    L12:
        return (T) cache(r10, this.wrap.invoke(r5));
    L5:
        return this.wrap.invoke(r5);
    }

    public final T get(String r5) {
        Intrinsics.checkNotNullParameter(r5, "qName");
        WeakReference<T> r10 = this.typeCache.get(r5);
        if (r10 == null) goto L7;
        T r11 = r10.get();
        if (r11 == null) goto L7;
        return r11;
    L7:
        BackingType r12 = this.findElement.invoke(r5);
        if (r12 == null) goto L14;
        T r13 = this.wrap.invoke(r12);
        if (r13 != null) goto L13;
        return null;
    L13:
        return (T) cache(r5, r13);
    L14:
        return null;
    }
}
