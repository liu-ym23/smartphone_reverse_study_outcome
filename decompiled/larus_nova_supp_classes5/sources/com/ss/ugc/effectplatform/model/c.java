package com.ss.ugc.effectplatform.model;

import com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel;
import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c {
    public bytekn.foundation.utils.d<String, a> a;
    public final z.b<String, ModelInfo> b;

    public static final class a {
        public final ModelInfo a;

        public final int hashCode() {
            return this.a.hashCode();
        }

        public a(ModelInfo r1) {
            this.a = r1;
        }

        public final boolean equals(Object r2) {
            if (this != r2) goto L5;
            return true;
        L5:
            if (r2 == null) goto L9;
            return Intrinsics.areEqual(this.a, ((a) r2).a);
        L9:
            throw new TypeCastException("null cannot be cast to non-null type com.ss.ugc.effectplatform.model.LoadedModelList.ModelInfoState");
        }
    }

    public final z.b b() {
        if (this.b.isEmpty() == false) goto L9;
        Iterator r0 = ((ArrayList) this.a.b()).iterator();
    L6:
        if (r0.hasNext() == false) goto L9;
        a r1 = (a) r0.next();
        this.b.put(r1.a.getName(), r1.a);
    L9:
        return this.b;
    }

    public c() {
        this.a = new bytekn.foundation.utils.d();
        this.b = new z.b(false);
    }

    public final ExtendedUrlModel a(String r4) {
        Iterator r0 = ((ArrayList) this.a.b()).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        a r1 = (a) r0.next();
        if (Intrinsics.areEqual(r1.a.getName(), r4) == false) goto L4;
        return r1.a.getFile_url();
    L10:
        throw new IllegalArgumentException("modelName " + r4 + " doesn't exist");
    }
}
