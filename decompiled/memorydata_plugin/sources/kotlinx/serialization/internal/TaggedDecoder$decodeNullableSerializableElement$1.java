package kotlinx.serialization.internal;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "", "Tag", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class TaggedDecoder$decodeNullableSerializableElement$1<T> extends Lambda implements Function0<T> {
    final /* synthetic */ kotlinx.serialization.b<T> $deserializer;
    final /* synthetic */ T $previousValue;
    final /* synthetic */ cc<Tag> this$0;

    TaggedDecoder$decodeNullableSerializableElement$1(cc<Tag> r3, kotlinx.serialization.b<T> r4, T r5) {
        kotlinx.serialization.b<T> r6 = (kotlinx.serialization.b) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.serialization.b.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$deserializer = r6;
        this.$previousValue = r5;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final T invoke() {
        if (this.this$0.b() == false) goto L6;
        return (T) this.this$0.a(this.$deserializer, this.$previousValue);
    L6:
        return (T) this.this$0.c();
    }
}
