package com.ss.android.lark.chat.cot.detail.blueprint;

import com.ss.android.lark.blueprint.f;
import com.ss.android.lark.blueprint.n;
import com.ss.android.lark.blueprint.o;
import com.ss.android.lark.chat.cot.detail.CotDetailBlockType;
import com.ss.android.lark.chat.cot.detail.k;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements o<k> {
    public final Class<k> a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CotDetailBlockType.values().length];
            r0[CotDetailBlockType.THINKING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[CotDetailBlockType.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[CotDetailBlockType.TOOLCALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[CotDetailBlockType.ACTION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[CotDetailBlockType.STATUS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public c() {
        this.a = k.class;
    }

    public final Class<k> getDataType() {
        return this.a;
    }

    public final n a(Object r3) {
        k r4 = (k) r3;
        Intrinsics.checkNotNullParameter(r4, Keys.API_RETURN_KEY_DATA);
        CotDetailBlockType r5 = r4.b;
        int r6 = a.a[r5.ordinal()];
        if (r6 != 1) goto L5;
        Object r7 = b.a;
    L20:
        return new f(CotDetailCellKeys$Layouts.SINGLE, CollectionsKt.listOf(r7));
    L5:
        if (r6 != 2) goto L7;
        r7 = b.b;
        goto L20
    L7:
        if (r6 != 3) goto L9;
        r7 = b.c;
        goto L20
    L9:
        if (r6 != 4) goto L11;
        r7 = b.d;
        goto L20
    L11:
        if (r6 != 5) goto L14;
        r7 = b.e;
        goto L20
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
