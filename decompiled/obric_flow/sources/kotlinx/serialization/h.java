package kotlinx.serialization;

import ai.p;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.internal.i1;
import kotlinx.serialization.internal.m;
import kotlinx.serialization.internal.q;
import kotlinx.serialization.internal.y0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i1 f19248a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i1 f19249b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y0 f19250c = null;
    public static final y0 d = null;

    static {
        SerializersCacheKt$SERIALIZERS_CACHE$1 r5 = SerializersCacheKt$SERIALIZERS_CACHE$1.INSTANCE;
        boolean r10 = m.f19309a;
        Intrinsics.checkNotNullParameter(r5, "factory");
        boolean r11 = m.f19309a;
        if (r11 == false) goto L5;
        i1 r12 = new q(r5);
    L6:
        f19248a = r12;
        SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1 r13 = SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r13, "factory");
        if (r11 == false) goto L9;
        i1 r14 = new q(r13);
    L10:
        f19249b = r14;
        SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1 r15 = SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r15, "factory");
        if (r11 == false) goto L13;
        y0 r16 = new s6.c(r15);
    L14:
        f19250c = r16;
        SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1 r17 = SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r17, "factory");
        if (r11 == false) goto L17;
        y0 r18 = new s6.c(r17);
    L18:
        d = r18;
        return;
    L17:
        r18 = new p(r17);
        goto L18
    L13:
        r16 = new p(r15);
        goto L14
    L9:
        r14 = new ym.p(r13);
        goto L10
    L5:
        r12 = new ym.p(r5);
        goto L6
    }
}
