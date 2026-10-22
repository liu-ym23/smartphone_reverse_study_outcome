package kotlinx.serialization.json.internal;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/serialization/json/l;", ST.IMPLICIT_ARG_NAME, "", "invoke", "(Lkotlinx/serialization/json/l;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
final class TreeJsonEncoderKt$writeJson$encoder$1 extends Lambda implements Function1<kotlinx.serialization.json.l, Unit> {
    final /* synthetic */ Ref.ObjectRef<kotlinx.serialization.json.l> $result;

    public TreeJsonEncoderKt$writeJson$encoder$1(Ref.ObjectRef<kotlinx.serialization.json.l> r5) {
        this.$result = r5;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(kotlinx.serialization.json.l r5) {
        invoke2(r5);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(kotlinx.serialization.json.l r5) {
        Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
        this.$result.element = r5;
    }
}
