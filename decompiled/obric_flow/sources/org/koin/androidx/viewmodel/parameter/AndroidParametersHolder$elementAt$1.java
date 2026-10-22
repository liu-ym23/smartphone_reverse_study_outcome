package org.koin.androidx.viewmodel.parameter;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import org.koin.core.error.NoParameterFoundException;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class AndroidParametersHolder$elementAt$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ KClass<?> $clazz;
    final /* synthetic */ int $i;
    final /* synthetic */ a this$0;

    public AndroidParametersHolder$elementAt$1(a r5, int r10, KClass<?> r11) {
        this.this$0 = r5;
        this.$i = r10;
        this.$clazz = r11;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        a r5 = this.this$0;
        int r10 = this.$i;
        KClass<?> r11 = this.$clazz;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r11, "clazz");
        List r12 = r5.f22651a;
        if (r12.size() <= r10) goto L7;
        return r12.get(r10);
    L7:
        throw new NoParameterFoundException("Can't get injected parameter #" + r10 + " from " + r5 + " for type '" + yu.a.a(r11) + '\'');
    }
}
