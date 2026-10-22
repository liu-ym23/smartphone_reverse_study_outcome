package androidx.room.jarjarred.kotlinx.metadata.impl.extensions;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.kotlinx.metadata.KmExtensionVisitor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmExtension;", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionVisitor;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "visitor", "", "accept", "(Ljava/lang/Object;)V", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface KmExtension<V extends KmExtensionVisitor> extends KmExtensionVisitor {
    void accept(V r5);
}
