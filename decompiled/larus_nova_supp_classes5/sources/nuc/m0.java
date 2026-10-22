package nuc;

import juc.d;
import kotlinx.serialization.InternalSerializationApi;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@InternalSerializationApi
public interface m0<T> extends d<T> {
    d<?>[] childSerializers();

    d<?>[] typeParametersSerializers();
}
