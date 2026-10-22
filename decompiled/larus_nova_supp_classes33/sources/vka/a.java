package vka;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a implements b<JsonArray> {
    public final List<b<? extends JsonElement>> a;

    @Override // vka.b
    public final Object execute() {
        Intrinsics.checkNotNullParameter(f.a, "context");
        JsonArray r0 = new JsonArray();
        Iterator<T> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add((JsonElement) ((b) r1.next()).execute());
        goto L4
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends b<? extends JsonElement>> r2) {
        Intrinsics.checkNotNullParameter(r2, "ops");
        this.a = r2;
    }
}
