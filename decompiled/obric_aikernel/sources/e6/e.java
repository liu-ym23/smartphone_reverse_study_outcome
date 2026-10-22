package e6;

import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.gson.internal.b f8646c;

    public e(com.google.gson.internal.b r10) {
        this.f8646c = r10;
    }

    q<?> a(com.google.gson.internal.b r10, com.google.gson.d r11, TypeToken<?> r12, d6.b r13) {
        Object r14 = r10.b(TypeToken.get(r13.value())).a();
        boolean r15 = r13.nullSafe();
        if ((r14 instanceof q) == false) goto L6;
        q<?> r16 = (q) r14;
    L24:
        if (r16 == null) goto L28;
        if (r15 == true) goto L27;
        return r16;
    L27:
        return r16.a();
    L28:
        return r16;
    L6:
        if ((r14 instanceof r) == false) goto L8;
        r16 = ((r) r14).b(r11, r12);
        goto L24
    L8:
        boolean r17 = r14 instanceof com.google.gson.o;
        if (r17 == true) goto L16;
        if ((r14 instanceof com.google.gson.h) == true) goto L16;
        throw new IllegalArgumentException("Invalid attempt to bind an instance of " + r14.getClass().getName() + " as a @JsonAdapter for " + r12.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
    L16:
        if (r17 == false) goto L18;
        com.google.gson.o r18 = (com.google.gson.o) r14;
    L20:
        if ((r14 instanceof com.google.gson.h) == false) goto L22;
        com.google.gson.h r19 = (com.google.gson.h) r14;
    L23:
        r16 = new m(r18, r19, r11, r12, null, r15);
        r15 = false;
        goto L24
    L22:
        r19 = null;
        goto L23
    L18:
        r18 = null;
        goto L20
    }

    @Override // com.google.gson.r
    public <T> q<T> b(com.google.gson.d r10, TypeToken<T> r11) {
        d6.b r12 = (d6.b) r11.getRawType().getAnnotation(d6.b.class);
        if (r12 != null) goto L7;
        return null;
    L7:
        return (q<T>) a(this.f8646c, r10, r11, r12);
    }
}
