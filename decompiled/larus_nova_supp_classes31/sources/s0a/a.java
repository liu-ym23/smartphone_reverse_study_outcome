package s0a;

import com.larus.im.internal.delegate.c0;
import com.larus.platform.api.creation.UserCreation;
import gd9.v;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements j0a.b {
    public final v a;

    /* JADX INFO: renamed from: s0a.a$a, reason: collision with other inner class name */
    public static final class C0073a {
    }

    static {
    }

    public a(v r2) {
        Intrinsics.checkNotNullParameter(r2, "networkDepend");
        this.a = r2;
    }

    @Override // j0a.b
    public final Object a(String r10, boolean r11) {
        c r5 = new c(CollectionsKt.listOf(r10), r11);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L29
        gd9.e r13 = this.a.h().d("/creativity/community/creation/mget", r5, null, null, null);     // Catch: Throwable -> L29
        if (r13.c() == true) goto L6;
        c0.b.i("CreationDetailRepositoryKmp", "fetchCreationDetail http failed, status=" + r13.b);     // Catch: Throwable -> L29
        Object r14 = j0a.a.b.a;     // Catch: Throwable -> L29
    L27:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L29
    L31:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L38;
        c0.b.e("CreationDetailRepositoryKmp", "fetchCreationDetail exception: " + r16);
        return j0a.a.b.a;
    L38:
        return r15;
    L6:
        String r17 = r13.d;     // Catch: Throwable -> L29
        if (r17 != null) goto L9;
    L12:
        boolean r18 = true;
    L13:
        if (r18 == false) goto L15;
        r14 = j0a.a.b.a;     // Catch: Throwable -> L29
        goto L27
    L15:
        e r19 = (e) xt7.d.b.c(e.Companion.serializer(), r17);     // Catch: Throwable -> L29
        if (r19.a == 0) goto L18;
        c0.b.i("CreationDetailRepositoryKmp", "fetchCreationDetail biz failed, code=" + r19.a);     // Catch: Throwable -> L29
        r14 = j0a.a.b.a;     // Catch: Throwable -> L29
        goto L27
    L18:
        g r110 = r19.c;     // Catch: Throwable -> L29
        if (r110 == null) goto L23;
        List<UserCreation> r111 = r110.a;     // Catch: Throwable -> L29
        if (r111 == null) goto L23;
        UserCreation r112 = (UserCreation) CollectionsKt.firstOrNull(r111);     // Catch: Throwable -> L29
    L24:
        if (r112 != null) goto L26;
        r14 = j0a.a.C0062a.a;     // Catch: Throwable -> L29
        goto L27
    L26:
        r14 = new j0a.a.c(r112);     // Catch: Throwable -> L29
    L23:
        r112 = null;
        goto L24
    L9:
        if (r17.length() == 0) goto L12;
        r18 = false;
    L29:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    }

    @Override // j0a.b
    public final Object b(String r11, boolean r12) {
        boolean r2 = true;
        if (r11 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L13;
        return Boxing.boxBoolean(false);
    L13:
        if (r12 == false) goto L15;
        int r13 = 1;
    L16:
        d r6 = new d(r11, r13);
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L37
        gd9.e r15 = this.a.h().d("/creativity/community/creation/like_action", r6, null, null, null);     // Catch: Throwable -> L37
        if (r15.c() == true) goto L20;
        c0.b.i("CreationDetailRepositoryKmp", "likeAction http failed, status=" + r15.b);     // Catch: Throwable -> L37
    L28:
        r2 = false;
    L35:
        Object r16 = Result.constructor-impl(Boxing.boxBoolean(r2));     // Catch: Throwable -> L37
    L39:
        Throwable r0 = Result.exceptionOrNull-impl(r16);
        if (r0 == null) goto L46;
        c0.b.e("CreationDetailRepositoryKmp", "likeAction exception: " + r0);
        return Boxing.boxBoolean(false);
    L46:
        return r16;
    L20:
        String r17 = r15.d;     // Catch: Throwable -> L37
        if (r17 != null) goto L23;
    L26:
        boolean r1 = true;
    L27:
        if (r1 == true) goto L28;
        h r18 = (h) xt7.d.b.c(h.Companion.serializer(), r17);     // Catch: Throwable -> L37
        if (r18.a == 0) goto L33;
        r2 = false;
    L33:
        if (r2 == true) goto L35;
        c0.b.i("CreationDetailRepositoryKmp", "likeAction biz failed, code=" + r18.a);     // Catch: Throwable -> L37
        goto L35
    L23:
        if (r17.length() == 0) goto L26;
        r1 = false;
    L37:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L15:
        r13 = 2;
        goto L16
    L5:
        if (r11.length() == 0) goto L8;
        r4 = false;
        goto L9
    }
}
