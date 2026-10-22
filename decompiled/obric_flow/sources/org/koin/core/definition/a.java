package org.koin.core.definition;

import ai.j0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wu.a f21006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KClass f21007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wu.a f21008c;
    public final Lambda d;
    public final Kind e;
    public List f;
    public final b g;

    /* JADX WARN: Multi-variable type inference failed */
    public a(wu.a r5, KClass r10, wu.a r11, Function2 r12, Kind r13, List r14) {
        Intrinsics.checkNotNullParameter(r5, "scopeQualifier");
        Intrinsics.checkNotNullParameter(r10, "primaryType");
        Intrinsics.checkNotNullParameter(r12, "definition");
        Intrinsics.checkNotNullParameter(r13, "kind");
        Intrinsics.checkNotNullParameter(r14, "secondaryTypes");
        this.f21006a = r5;
        this.f21007b = r10;
        this.f21008c = r11;
        this.d = (Lambda) r12;
        this.e = r13;
        this.f = r14;
        this.g = new b();
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type org.koin.core.definition.BeanDefinition<*>");
        a r10 = (a) r5;
        if (Intrinsics.areEqual(this.f21007b, r10.f21007b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f21008c, r10.f21008c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f21006a, r10.f21006a) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        wu.a r5 = this.f21008c;
        if (r5 == null) goto L5;
        int r10 = r5.hashCode();
    L6:
        int r11 = this.f21007b.hashCode();
        int r12 = this.f21006a.hashCode();
        return r12 + ((r11 + (r10 * 31)) * 31);
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        String r5 = this.e.toString();
        String r10 = "'" + yu.a.a(this.f21007b) + '\'';
        wu.a r11 = this.f21008c;
        String r12 = "";
        if (r11 == null) goto L6;
        String r13 = ",qualifier:" + r11;
        if (r13 == null) goto L6;
    L7:
        wu.b r14 = org.koin.core.registry.a.e;
        wu.a r15 = this.f21006a;
        if (Intrinsics.areEqual(r15, r14) == false) goto L10;
        String r16 = "";
    L12:
        if (this.f.isEmpty() == true) goto L15;
        r12 = j0.C(",binds:", CollectionsKt.q(this.f, ",", null, null, 0, null, BeanDefinition$toString$defOtherTypes$typesAsString$1.INSTANCE, 30));
    L15:
        return "[" + r5 + ':' + r10 + r13 + r16 + r12 + ']';
    L10:
        r16 = ",scope:" + r15;
    L6:
        r13 = "";
        goto L7
    }
}
