package com.larus.bmhome.utils;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class o {
    public final String a;

    public static final class a extends o {
        public static final a b = null;

        static {
            b = new a();
        }

        @Override // com.larus.bmhome.utils.o
        public final List<String> a() {
            return CollectionsKt.listOf(new String[]{this.a, "text/markdown"});
        }

        public a() {
        }
    }

    public List<String> a() {
        return CollectionsKt.listOf(this.a);
    }

    public o() {
        this.a = "text/plain";
    }
}
