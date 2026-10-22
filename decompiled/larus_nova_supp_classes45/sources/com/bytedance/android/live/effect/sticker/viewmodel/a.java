package com.bytedance.android.live.effect.sticker.viewmodel;

import com.ss.android.ugc.effectmanager.effect.model.SearchEffectModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a<T, R> {

    /* JADX INFO: renamed from: com.bytedance.android.live.effect.sticker.viewmodel.a$a, reason: collision with other inner class name */
    public static final class C0196a<R> extends a {
        public final Throwable a;
        public final R b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof C0196a) == false) goto L10;
            C0196a r4 = (C0196a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            Throwable r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            R r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Error(exception=" + this.a + ", trace=" + this.b + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0196a(Throwable r1, StickerSearchViewModel.b r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b<T, R> extends a<T, R> {
        public final T a;
        public final R b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            T r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            R r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Success(data=" + this.a + ", trace=" + this.b + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(SearchEffectModel r1, StickerSearchViewModel.b r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public a() {
    }
}
