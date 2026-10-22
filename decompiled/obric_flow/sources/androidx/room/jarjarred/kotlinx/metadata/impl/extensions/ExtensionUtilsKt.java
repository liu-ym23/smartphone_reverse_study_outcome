package androidx.room.jarjarred.kotlinx.metadata.impl.extensions;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.kotlinx.metadata.KmExtensionType;
import androidx.room.jarjarred.kotlinx.metadata.KmExtensionVisitor;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\u001a>\u0010\b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0019\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004¢\u0006\u0002\b\u0006H\u0000¢\u0006\u0004\b\b\u0010\t\u001a/\u0010\r\u001a\u00028\u0000\"\f\b\u0000\u0010\u000b*\u0006\u0012\u0002\b\u00030\n*\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionVisitor;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "type", "Lkotlin/Function1;", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/MetadataExtensions;", "Lkotlin/ExtensionFunctionType;", "block", "applySingleExtension", "(Lzt/c;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmExtension;", "N", "", "singleOfType", "(Ljava/util/Collection;Lzt/c;)Ljava/lang/Object;", "kotlinx-metadata"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ExtensionUtilsKt {
    public static final <T extends KmExtensionVisitor> T applySingleExtension(KmExtensionType r5, Function1<? super MetadataExtensions, ? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r10, "block");
        Iterator<MetadataExtensions> r11 = MetadataExtensions.Companion.getINSTANCES().iterator();
        T r12 = null;
    L4:
        if (r11.hasNext() == false) goto L12;
        T r13 = r10.invoke(r11.next());
        if (r13 == null) goto L4;
        if (r12 != null) goto L11;
        r12 = r13;
        goto L4
    L11:
        throw new IllegalStateException("Multiple extensions handle the same extension type: " + r5);
    L12:
        return r12;
    }

    public static final <N extends KmExtension<?>> N singleOfType(Collection<? extends N> r5, KmExtensionType r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "type");
        Iterator<? extends N> r11 = r5.iterator();
        N r12 = null;
    L4:
        if (r11.hasNext() == false) goto L11;
        N r13 = r11.next();
        if (Intrinsics.areEqual(r13.getType(), r10) == false) goto L4;
        if (r12 != null) goto L10;
        r12 = r13;
        goto L4
    L10:
        throw new IllegalStateException("Multiple extensions handle the same extension type: " + r10);
    L11:
        if (r12 == null) goto L14;
        return r12;
    L14:
        throw new IllegalStateException("No extensions handle the extension type: " + r10);
    }
}
