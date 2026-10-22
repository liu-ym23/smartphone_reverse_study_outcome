package nuc;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import juc.d;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class t0 {
    @InternalSerializationApi
    public static final r0 a(String r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r3, "primitiveSerializer");
        return new r0(r2, new s0(r3));
    }
}
