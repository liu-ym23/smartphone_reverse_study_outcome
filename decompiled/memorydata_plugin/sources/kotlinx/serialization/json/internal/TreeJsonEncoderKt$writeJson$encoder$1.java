package kotlinx.serialization.json.internal;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", "Lkotlinx/serialization/json/JsonElement;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class TreeJsonEncoderKt$writeJson$encoder$1 extends Lambda implements Function1<kotlinx.serialization.json.g, Unit> {
    final /* synthetic */ Ref.ObjectRef<kotlinx.serialization.json.g> $result;

    TreeJsonEncoderKt$writeJson$encoder$1(Ref.ObjectRef<kotlinx.serialization.json.g> r1) {
        this.$result = r1;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(kotlinx.serialization.json.g r3) {
        invoke2((kotlinx.serialization.json.g) ZeusTransformUtils.preCheckCast(r3, kotlinx.serialization.json.g.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(kotlinx.serialization.json.g r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        this.$result.element = r2;
    }
}
