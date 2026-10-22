package kotlinx.serialization.internal;

import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends q0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f19272c;
    public final c0 d;

    public d0(kotlinx.serialization.c r5, kotlinx.serialization.c r10, int r11) {
        this.f19272c = r11;
        switch(r11) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "kSerializer");
        Intrinsics.checkNotNullParameter(r10, "vSerializer");
        super(r5, r10);
        kotlinx.serialization.descriptors.g r12 = r5.getDescriptor();
        kotlinx.serialization.descriptors.g r13 = r10.getDescriptor();
        Intrinsics.checkNotNullParameter(r12, "keyDesc");
        Intrinsics.checkNotNullParameter(r13, "valueDesc");
        this.d = new c0("kotlin.collections.HashMap", r12, r13);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "kSerializer");
        Intrinsics.checkNotNullParameter(r10, "vSerializer");
        super(r5, r10);
        kotlinx.serialization.descriptors.g r14 = r5.getDescriptor();
        kotlinx.serialization.descriptors.g r15 = r10.getDescriptor();
        Intrinsics.checkNotNullParameter(r14, "keyDesc");
        Intrinsics.checkNotNullParameter(r15, "valueDesc");
        this.d = new c0("kotlin.collections.LinkedHashMap", r14, r15);
    }

    @Override // kotlinx.serialization.internal.a
    public final Object b() {
        switch(this.f19272c) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return new LinkedHashMap();
    L7:
        return new HashMap();
    }

    @Override // kotlinx.serialization.internal.a
    public final int c(Object r5) {
        switch(this.f19272c) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        LinkedHashMap r10 = (LinkedHashMap) r5;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.size() * 2;
    L6:
        HashMap r11 = (HashMap) r5;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        return r11.size() * 2;
    }

    @Override // kotlinx.serialization.internal.a
    public final Object f(Object r5) {
        switch(this.f19272c) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(null, "<this>");
        return new LinkedHashMap(null);
    L6:
        Intrinsics.checkNotNullParameter(null, "<this>");
        return new HashMap(null);
    }

    @Override // kotlinx.serialization.internal.a
    public final Object g(Object r5) {
        switch(this.f19272c) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        LinkedHashMap r10 = (LinkedHashMap) r5;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10;
    L6:
        HashMap r11 = (HashMap) r5;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        return r11;
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        switch(this.f19272c) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.d;
    L7:
        return this.d;
    }
}
