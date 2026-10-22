package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k0 f19271c;

    public d(kotlinx.serialization.c r5, int r10) {
        this.f19270b = r10;
        switch(r10) {
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "element");
        this(r5, 0);
        kotlinx.serialization.descriptors.g r11 = r5.getDescriptor();
        Intrinsics.checkNotNullParameter(r11, "elementDesc");
        this.f19271c = new c(r11, 1);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "eSerializer");
        this(r5, 0);
        kotlinx.serialization.descriptors.g r12 = r5.getDescriptor();
        Intrinsics.checkNotNullParameter(r12, "elementDesc");
        this.f19271c = new c(r12, 3);
        return;
    L8:
        Intrinsics.checkNotNullParameter(r5, "eSerializer");
        this(r5, 0);
        kotlinx.serialization.descriptors.g r13 = r5.getDescriptor();
        Intrinsics.checkNotNullParameter(r13, "elementDesc");
        this.f19271c = new c(r13, 2);
    }

    @Override // kotlinx.serialization.internal.a
    public final Object b() {
        switch(this.f19270b) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return new LinkedHashSet();
    L7:
        return new HashSet();
    L9:
        return new ArrayList();
    }

    @Override // kotlinx.serialization.internal.a
    public final int c(Object r5) {
        switch(this.f19270b) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        LinkedHashSet r10 = (LinkedHashSet) r5;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.size();
    L6:
        HashSet r11 = (HashSet) r5;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        return r11.size();
    L8:
        ArrayList r12 = (ArrayList) r5;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        return r12.size();
    }

    @Override // kotlinx.serialization.internal.a
    public final Object f(Object r5) {
        switch(this.f19270b) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(null, "<this>");
        return new LinkedHashSet(null);
    L6:
        Intrinsics.checkNotNullParameter(null, "<this>");
        return new HashSet(null);
    L8:
        Intrinsics.checkNotNullParameter(null, "<this>");
        return new ArrayList(null);
    }

    @Override // kotlinx.serialization.internal.a
    public final Object g(Object r5) {
        switch(this.f19270b) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        LinkedHashSet r10 = (LinkedHashSet) r5;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10;
    L6:
        HashSet r11 = (HashSet) r5;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        return r11;
    L8:
        ArrayList r12 = (ArrayList) r5;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        return r12;
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        switch(this.f19270b) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return (c) this.f19271c;
    L7:
        return (c) this.f19271c;
    L9:
        return (c) this.f19271c;
    }

    @Override // kotlinx.serialization.internal.r
    public final void h(int r5, Object r10, Object r11) {
        switch(this.f19270b) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        LinkedHashSet r12 = (LinkedHashSet) r10;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        r12.add(r11);
        return;
    L6:
        HashSet r13 = (HashSet) r10;
        Intrinsics.checkNotNullParameter(r13, "<this>");
        r13.add(r11);
        return;
    L8:
        ArrayList r14 = (ArrayList) r10;
        Intrinsics.checkNotNullParameter(r14, "<this>");
        r14.add(r5, r11);
    }

    public d(kotlinx.serialization.c r5, char r10) {
        Intrinsics.checkNotNullParameter(r5, "element");
        super(r5);
    }
}
