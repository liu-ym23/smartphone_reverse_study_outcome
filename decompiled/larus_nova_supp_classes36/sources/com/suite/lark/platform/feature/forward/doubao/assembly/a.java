package com.suite.lark.platform.feature.forward.doubao.assembly;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final a a = null;

    /* JADX INFO: renamed from: com.suite.lark.platform.feature.forward.doubao.assembly.a$a, reason: collision with other inner class name */
    public static final class C0246a {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0246a) == true) goto L8;
            return false;
        L8:
            C0246a r6 = (C0246a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "ResolvedTarget(chatId=" + this.a + ", threadId=" + this.b + ')';
        }

        public C0246a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "chatId");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        a = new a();
    }

    public a() {
    }

    public static boolean a(final npc.a r10, final List r11, final String r12, final f r13) {
        Intrinsics.checkNotNullParameter(r10, "request");
        Intrinsics.checkNotNullParameter(r11, "targets");
        Intrinsics.checkNotNullParameter(r12, "note");
        Intrinsics.checkNotNullParameter(r13, "callback");
        int r1 = 0;
        if (r10.a() == false) goto L58;
        ArrayList r0 = (ArrayList) r11;
        if (r0.isEmpty() == true) goto L58;
        final Function1<List<? extends C0246a>, Unit> r5 = new DoubaoFileSender$send$1(r10, r12, r13);
        final Function1<ErrorResult, Unit> r14 = new DoubaoFileSender$send$2(r13);
        final C0246a[] r6 = new C0246a[r0.size()];
        final ArrayList r4 = new ArrayList();
        Iterator r15 = r11.iterator();
    L9:
        if (r15.hasNext() == false) goto L40;
        Object r16 = r15.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        npc.c r17 = (npc.c) r16;
        int r7 = r17.e;
        if (r7 == 1) goto L32;
        if (r7 == 2) goto L28;
        if (r7 != 3) goto L19;
        if (StringsKt.isBlank(r17.a) == true) goto L26;
        if (StringsKt.isBlank(r17.d) == true) goto L26;
        r6[r1] = new C0246a(r17.a, r17.d);
    L38:
        r1 = r3;
    L26:
        r14.invoke(new ErrorResult(-1, "thread target is incomplete"));
    L57:
        return true;
    L19:
        r14.invoke(new ErrorResult(-1, "unsupported target type"));
        goto L57
    L28:
        if (StringsKt.isBlank(r17.a) == true) goto L29;
        r6[r1] = new C0246a(r17.a, null);
        goto L38
    L29:
        r14.invoke(new ErrorResult(-1, "group chat id is empty"));
        goto L57
    L32:
        if (StringsKt.isBlank(r17.a) == true) goto L33;
        if ((true ^ StringsKt.isBlank(r17.f)) == false) goto L37;
        r6[r1] = new C0246a(r17.f, null);
        goto L38
    L37:
        r4.add(Integer.valueOf(r1));
        goto L38
    L33:
        r14.invoke(new ErrorResult(-1, "chatter id is empty"));
        goto L57
    L40:
        if (r4.isEmpty() == false) goto L42;
        r5.invoke(ArraysKt.filterNotNull(r6));
        goto L57
    L42:
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r19 = r4.iterator();
    L44:
        if (r19.hasNext() == false) goto L46;
        r18.add(((npc.c) ListProtector.get(r11, ((Number) r19.next()).intValue())).a);
        goto L44
    L46:
        List<String> r110 = CollectionsKt.distinct(r18);
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L49
        ImSdkService.b().C2(r110, new DoubaoFileSender$resolveTargets$2$1(r4, r5, r6, r11, r14));     // Catch: Throwable -> L49
        Object r112 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L49
    L51:
        Throwable r113 = Result.exceptionOrNull-impl(r112);
        if (r113 == null) goto L57;
        String r114 = r113.getMessage();
        if (r114 != null) goto L56;
        r114 = "create p2p chat failed";
    L56:
        r14.invoke(new ErrorResult(-1, r114));
    L49:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r112 = Result.constructor-impl(ResultKt.createFailure(th));
    L58:
        return false;
    }
}
