package com.larus.canvas.feature.component.title;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface m extends com.larus.canvas.feature.component.base.c {

    public static final class a implements m {
        public final List<ly8.g> a;

        public a(List<ly8.g> r2) {
            Intrinsics.checkNotNullParameter(r2, "items");
            this.a = r2;
        }
    }
}
