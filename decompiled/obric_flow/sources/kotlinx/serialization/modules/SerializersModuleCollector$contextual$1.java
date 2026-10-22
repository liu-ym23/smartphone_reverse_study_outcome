package kotlinx.serialization.modules;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.c;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/serialization/c;", ST.IMPLICIT_ARG_NAME, "invoke", "(Ljava/util/List;)Lkotlinx/serialization/c;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
final class SerializersModuleCollector$contextual$1 extends Lambda implements Function1<List<? extends c>, c> {
    final /* synthetic */ c $serializer;

    public SerializersModuleCollector$contextual$1(c r5) {
        this.$serializer = r5;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ c invoke(List<? extends c> r5) {
        return invoke2(r5);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final c invoke2(List<? extends c> r5) {
        Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
        return this.$serializer;
    }
}
