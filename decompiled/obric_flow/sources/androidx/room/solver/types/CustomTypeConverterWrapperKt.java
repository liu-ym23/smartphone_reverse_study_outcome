package androidx.room.solver.types;

import androidx.room.ProvidedTypeConverter;
import androidx.room.writer.TypeWriter;
import com.squareup.javapoet.e;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/room/writer/TypeWriter;", "Lcom/squareup/javapoet/e;", "className", "", "addRequiredTypeConverter", "(Landroidx/room/writer/TypeWriter;Lcom/squareup/javapoet/e;)V", "", "getRequiredTypeConverters", "(Landroidx/room/writer/TypeWriter;)Ljava/util/Set;", "room-compiler"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CustomTypeConverterWrapperKt {
    public static final void addRequiredTypeConverter(TypeWriter r5, e r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "className");
        r5.set(Reflection.getOrCreateKotlinClass(ProvidedTypeConverter.class), SetsKt.plus(getRequiredTypeConverters(r5), SetsKt.setOf(r10)));
    }

    public static final Set<e> getRequiredTypeConverters(TypeWriter r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Set<e> r10 = (Set) r5.get(Reflection.getOrCreateKotlinClass(ProvidedTypeConverter.class));
        if (r10 == null) goto L5;
        return r10;
    L5:
        return SetsKt.emptySet();
    }
}
