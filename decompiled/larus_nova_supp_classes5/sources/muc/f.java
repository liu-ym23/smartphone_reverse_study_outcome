package muc;

import juc.n;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface f {

    public static final class a {
        @ExperimentalSerializationApi
        public static <T> void a(f r1, n<? super T> r2, T r3) {
            Intrinsics.checkNotNullParameter(r2, "serializer");
            if (r2.getDescriptor().a() == false) goto L6;
            r1.encodeSerializableValue(r2, r3);
            return;
        L6:
            if (r3 != null) goto L8;
            r1.encodeNull();
            return;
        L8:
            r1.encodeNotNullMark();
            r1.encodeSerializableValue(r2, r3);
        }
    }

    d beginCollection(luc.f r1, int r2);

    d beginStructure(luc.f r1);

    void encodeBoolean(boolean r1);

    void encodeByte(byte r1);

    void encodeChar(char r1);

    void encodeDouble(double r1);

    void encodeEnum(luc.f r1, int r2);

    void encodeFloat(float r1);

    f encodeInline(luc.f r1);

    void encodeInt(int r1);

    void encodeLong(long r1);

    @ExperimentalSerializationApi
    void encodeNotNullMark();

    @ExperimentalSerializationApi
    void encodeNull();

    <T> void encodeSerializableValue(n<? super T> r1, T r2);

    void encodeShort(short r1);

    void encodeString(String r1);

    kotlinx.serialization.modules.d getSerializersModule();
}
