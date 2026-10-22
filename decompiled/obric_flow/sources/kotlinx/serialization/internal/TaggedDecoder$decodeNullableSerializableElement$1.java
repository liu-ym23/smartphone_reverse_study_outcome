package kotlinx.serialization.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "", "Tag", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class TaggedDecoder$decodeNullableSerializableElement$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ kotlinx.serialization.b $deserializer;
    final /* synthetic */ Object $previousValue;
    final /* synthetic */ n1 this$0;

    public TaggedDecoder$decodeNullableSerializableElement$1(n1 r5, kotlinx.serialization.b r10, Object r11) {
        this.this$0 = r5;
        this.$deserializer = r10;
        this.$previousValue = r11;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        if (this.this$0.B() == false) goto L5;
        n1 r5 = this.this$0;
        kotlinx.serialization.b r10 = this.$deserializer;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, "deserializer");
        return r5.w(r10);
    L5:
        this.this$0.getClass();
        return null;
    }
}
