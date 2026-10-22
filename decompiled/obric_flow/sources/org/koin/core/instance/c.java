package org.koin.core.instance;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.koin.core.error.InstanceCreationException;
import org.koin.core.logger.Level;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.koin.core.definition.a f21015a;

    public c(org.koin.core.definition.a r5) {
        Intrinsics.checkNotNullParameter(r5, "beanDefinition");
        this.f21015a = r5;
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    public Object a(b r13) {
        Intrinsics.checkNotNullParameter(r13, "context");
        um.a r5 = r13.f21012a;
        StringBuilder r10 = new StringBuilder("| (+) '");
        org.koin.core.definition.a r12 = this.f21015a;
        r10.append(r12);
        r10.append('\'');
        r5.o(r10.toString());
        vu.a r11 = r13.f21014c;     // Catch: Exception -> L8
        if (r11 != null) goto L6;
        r11 = new vu.a(null, 3);     // Catch: Exception -> L8
    L6:
        return r12.d.mo2invoke(r13.f21013b, r11);
    L8:
        e = move-exception;
        Intrinsics.checkNotNullParameter(e, "e");
        StringBuilder r14 = new StringBuilder();
        r14.append(e);
        r14.append("\n\t");
        StackTraceElement[] r15 = e.getStackTrace();
        ArrayList r16 = new ArrayList();
        int r17 = r15.length;
        int r18 = 0;
    L10:
        if (r18 >= r17) goto L14;
        StackTraceElement r19 = r15[r18];
        if (StringsKt.g(r19.getClassName(), "sun.reflect") == true) goto L14;
        r16.add(r19);
        r18 = r18 + 1;
    L14:
        r14.append(CollectionsKt.q(r16, "\n\t", null, null, 0, null, null, 62));
        String r20 = "* Instance creation error : could not create instance for '" + r12 + "': " + r14.toString();
        um.a r110 = r13.f21012a;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r20, "msg");
        r110.s(Level.ERROR, r20);
        throw new InstanceCreationException("Could not create instance for '" + r12 + '\'', e);
    }

    public abstract Object b(b r5);

    public final boolean equals(Object r5) {
        org.koin.core.definition.a r10 = null;
        if ((r5 instanceof c) == false) goto L5;
        c r11 = (c) r5;
    L6:
        if (r11 == null) goto L9;
        r10 = r11.f21015a;
    L9:
        return Intrinsics.areEqual(this.f21015a, r10);
    L5:
        r11 = null;
        goto L6
    }

    public final int hashCode() {
        return this.f21015a.hashCode();
    }
}
