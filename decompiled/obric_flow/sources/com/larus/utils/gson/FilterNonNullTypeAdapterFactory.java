package com.larus.utils.gson;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/larus/utils/gson/FilterNonNullTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "<init>", "()V", "BaseTypeAdapter", "CollectionTypeAdapter", "MapTypeAdapter", "extension_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FilterNonNullTypeAdapterFactory implements TypeAdapterFactory {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/utils/gson/FilterNonNullTypeAdapterFactory$BaseTypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/gson/TypeAdapter;", "extension_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class BaseTypeAdapter<T> extends TypeAdapter<T> {
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader r5) {
            Intrinsics.checkNotNullParameter(r5, "in");
            throw null;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter r5, Object r10) {
            Intrinsics.checkNotNullParameter(r5, "out");
            throw null;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/utils/gson/FilterNonNullTypeAdapterFactory$CollectionTypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/larus/utils/gson/FilterNonNullTypeAdapterFactory$BaseTypeAdapter;", "extension_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CollectionTypeAdapter<T> extends BaseTypeAdapter<T> {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/utils/gson/FilterNonNullTypeAdapterFactory$MapTypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/larus/utils/gson/FilterNonNullTypeAdapterFactory$BaseTypeAdapter;", "extension_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class MapTypeAdapter<T> extends BaseTypeAdapter<T> {
    }

    public FilterNonNullTypeAdapterFactory() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter create(Gson r5, TypeToken r10) {
        Intrinsics.checkNotNullParameter(r5, "gson");
        Intrinsics.checkNotNullParameter(r10, "typeToken");
        return null;
    }
}
