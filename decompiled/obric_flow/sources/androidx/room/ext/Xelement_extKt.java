package androidx.room.ext;

import androidx.room.Entity;
import androidx.room.compiler.processing.XElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0000\u001a\u0004\u0010\u0000(\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000ò\u0001\u0004\n\u00020\u0005¨\u0006\u0006"}, d2 = {"DEFAULT_IMPLS_CLASS_NAME", "", "isEntityElement", "", "Landroidx/room/compiler/processing/XElement;", "Landroidx/room/compiler/processing/XTypeElement;", "room-compiler"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class Xelement_extKt {
    public static final String DEFAULT_IMPLS_CLASS_NAME = "DefaultImpls";

    public static final boolean isEntityElement(XElement r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.hasAnnotation(Reflection.getOrCreateKotlinClass(Entity.class));
    }
}
