package com.ss.android.lark.keyboard.keyboard2;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface g {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;
        public static final Map<KeyboardMenuItemKey, Integer> b = null;
        public static final C0152a c = null;

        /* JADX INFO: renamed from: com.ss.android.lark.keyboard.keyboard2.g$a$a, reason: collision with other inner class name */
        public static final class C0152a implements g {

            /* JADX INFO: renamed from: com.ss.android.lark.keyboard.keyboard2.g$a$a$a, reason: collision with other inner class name */
            public static final class C0153a<T> implements Comparator {
                public C0153a() {
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T r3, T r4) {
                    Map<KeyboardMenuItemKey, Integer> r0 = a.b;
                    EnumMap r1 = (EnumMap) r0;
                    EnumMap r2 = (EnumMap) r0;
                    return ComparisonsKt.compareValues((Integer) r1.get(((m) r3).g()), (Integer) r2.get(((m) r4).g()));
                }
            }

            public C0152a() {
            }

            @Override // com.ss.android.lark.keyboard.keyboard2.g
            public final List<m> a(List<? extends m> r2) {
                Intrinsics.checkNotNullParameter(r2, "items");
                return CollectionsKt.sortedWith(r2, new C0153a());
            }
        }

        public a() {
        }

        static {
            a = new a();
            EnumMap r0 = new EnumMap(KeyboardMenuItemKey.class);
            b = r0;
            r0.put(KeyboardMenuItemKey.Emoji, 1);
            r0.put(KeyboardMenuItemKey.At, 2);
            r0.put(KeyboardMenuItemKey.Voice, 3);
            r0.put(KeyboardMenuItemKey.Photo, 4);
            r0.put(KeyboardMenuItemKey.File, 5);
            r0.put(KeyboardMenuItemKey.BurnLife, 6);
            r0.put(KeyboardMenuItemKey.AaStyle, 7);
            r0.put(KeyboardMenuItemKey.RestrictedBurnLife, 8);
            r0.put(KeyboardMenuItemKey.Plus, 9);
            r0.put(KeyboardMenuItemKey.UploadLog, 10);
            c = new C0152a();
        }
    }

    static {
        a = a.a;
    }

    List<m> a(List<? extends m> r1);
}
