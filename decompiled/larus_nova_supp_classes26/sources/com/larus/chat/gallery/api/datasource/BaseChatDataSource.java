package com.larus.chat.gallery.api.datasource;

import com.larus.common.apphost.AppHost;
import com.larus.gallery.api.IGalleryDataSource;
import com.larus.gallery.api.b0;
import com.larus.gallery.api.k;
import com.larus.im.bean.message.Message;
import com.larus.utils.m0;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class BaseChatDataSource<T> implements IGalleryDataSource<T> {
    public final List<String> a;
    public final Message b;
    public final String c;
    public boolean d;
    public boolean e;
    public Message f;
    public final int g;
    public final com.larus.chat.gallery.api.datasource.a h;

    public static final class a {
    }

    static {
    }

    public final boolean b() {
        return false;
    }

    public final Object c(Continuation<? super b0<? extends List<? extends T>>> r1) {
        return n(this, r1);
    }

    public final Object f(T r1, Continuation<? super T> r2) {
        return r1;
    }

    public final boolean h() {
        return true;
    }

    public abstract int l();

    public abstract List<Message> m();

    public abstract Object o(Message r1, Continuation<? super List<? extends T>> r2);

    public final int k() {
        return this.g;
    }

    public BaseChatDataSource(List<String> r3, Message r4) {
        Intrinsics.checkNotNullParameter(r3, "messageTypeList");
        this.a = r3;
        this.b = r4;
        this.c = getClass().getSimpleName();
        this.d = true;
        this.e = true;
        this.f = r4;
        int r0 = m0.a;
        this.g = m0.b(AppHost.a.getApplication().getApplicationContext()) / i5.A();
        this.h = new com.larus.chat.gallery.api.datasource.a(r3, r4);
    }

    public static /* synthetic */ <T> Object n(BaseChatDataSource<T> r4, Continuation<? super b0<? extends List<? extends T>>> r5) {
        if ((r5 instanceof BaseChatDataSource$loadInitial$1) == false) goto L7;
        BaseChatDataSource$loadInitial$1 r0 = (BaseChatDataSource$loadInitial$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L17:
        List r7 = (List) r6;
        if (r7 != null) goto L21;
        r7 = CollectionsKt.emptyList();
    L21:
        return new b0.b(r7, true, true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        Message r8 = r4.b;
        r0.label = 1;
        r6 = r4.o(r8, r0);
        if (r6 != r2) goto L17;
        return r2;
    L7:
        r0 = new BaseChatDataSource$loadInitial$1(r4, r5);
        goto L8
    }

    public final Object d(T r2, Continuation<? super b0<? extends List<? extends T>>> r3) {
        return CoroutineScopeKt.coroutineScope(new BaseChatDataSource$loadMore$2(this, null), r3);
    }

    public final Object e(List<? extends T> r1, Continuation<? super List<? extends Pair<? extends T, k>>> r2) {
        return IGalleryDataSource.DefaultImpls.c(this, r1, r2);
    }

    public final Object g(T r2, Continuation<? super b0<? extends List<? extends T>>> r3) {
        return CoroutineScopeKt.coroutineScope(new BaseChatDataSource$loadPrevious$2(this, null), r3);
    }

    public final boolean j(T r1, T r2) {
        return Intrinsics.areEqual(r1, r2);
    }
}
