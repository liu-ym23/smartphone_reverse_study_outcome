package androidx.compose.runtime.collection;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0006H\u0080\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2 = {"fastForEach", "", ExifInterface.GPS_DIRECTION_TRUE, "", "", "block", "Lkotlin/Function1;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nIdentityArraySet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IdentityArraySet.kt\nandroidx/compose/runtime/collection/IdentityArraySetKt\n+ 2 IdentityArraySet.kt\nandroidx/compose/runtime/collection/IdentityArraySet\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,389:1\n108#2,7:390\n1855#3,2:397\n*S KotlinDebug\n*F\n+ 1 IdentityArraySet.kt\nandroidx/compose/runtime/collection/IdentityArraySetKt\n*L\n385#1:390,7\n387#1:397,2\n*E\n"})
public final class IdentityArraySetKt {
    public static final <T> void fastForEach(Set<? extends T> r5, Function1<? super T, Unit> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "block");
        if ((r5 instanceof IdentityArraySet) == false) goto L7;
        IdentityArraySet r11 = (IdentityArraySet) r5;
        Object[] r12 = r11.getValues();
        int r13 = r11.size();
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L11;
        Object r15 = r12[r14];
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        r10.invoke(r15);
        r14 = r14 + 1;
        goto L5
    L11:
        return;
    L7:
        Iterator<T> r16 = r5.iterator();
    L9:
        if (r16.hasNext() == false) goto L14;
        r10.invoke(r16.next());
        goto L9
    }
}
