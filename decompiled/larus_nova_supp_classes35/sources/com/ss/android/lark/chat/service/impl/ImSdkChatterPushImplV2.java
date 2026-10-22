package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.contact.v1.PushChannelNickname;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class ImSdkChatterPushImplV2 implements m6b.t {
    public final String a;
    public final com.bytedance.lark.rustclient.api.l b;
    public final CompositeDisposable c;
    public final d d;
    public final Lazy e;
    public final c f;
    public final Lazy g;
    public final b h;
    public final List<com.ss.android.lark.biz.im.api.h0> i;
    public final List<com.ss.android.lark.biz.im.api.i0> j;
    public final List<w> k;
    public final List<com.ss.android.lark.biz.im.api.l0> l;

    public static final class a {
    }

    public static final class b implements Function1<PushChannelNickname, Unit> {
        public final /* synthetic */ ImSdkChatterPushImplV2 a;

        public b(ImSdkChatterPushImplV2 r1) {
            this.a = r1;
        }

        public final Object invoke(Object r5) {
            PushChannelNickname r6 = (PushChannelNickname) r5;
            Intrinsics.checkNotNullParameter(r6, "pushChannelNickname");
            Channel r0 = com.ss.android.lark.parser.internal.g.a(r6.channel);     // Catch: Throwable -> L5
            CoreThreadPool.getDefault().getUIExecutor().execute(new u0(r6, this.a, r0));     // Catch: Throwable -> L5
        L8:
            return Unit.INSTANCE;
        L5:
            th = move-exception;
            Log.e("ImSdkChatterPushImplV2", th, true);
            goto L8
        }
    }

    public static final class c implements Function1<Entity, Unit> {
        public final /* synthetic */ ImSdkChatterPushImplV2 a;

        public c(ImSdkChatterPushImplV2 r1) {
            this.a = r1;
        }

        public final Object invoke(Object r7) {
            Entity r8 = (Entity) r7;
            Intrinsics.checkNotNullParameter(r8, "entity");
            com.ss.android.lark.chat.entity.chatter.a r9 = com.ss.android.lark.parser.internal.j.b(r8, null);     // Catch: Throwable -> L13
            LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L13
            r1.putAll(new HashMap(r9.a));     // Catch: Throwable -> L13
            r1.putAll(r9.a());     // Catch: Throwable -> L13
            List r10 = CollectionsKt.toList(r1.values());     // Catch: Throwable -> L13
            if (r10.isEmpty() == true) goto L16;
            CoreThreadPool.getDefault().getUIExecutor().execute(new v0(this.a, r10));     // Catch: Throwable -> L13
            ImSdkChatterPushImplV2 r2 = this.a;     // Catch: Throwable -> L13
            Iterator r11 = r10.iterator();     // Catch: Throwable -> L13
        L8:
            if (r11.hasNext() == false) goto L16;
            Chatter r3 = (Chatter) r11.next();     // Catch: Throwable -> L13
            CoreThreadPool.getDefault().getUIExecutor().execute(new w0(r2, r3));     // Catch: Throwable -> L13
            Log.i("ImSdkChatterPushImplV2", "onPushChatter " + r3.getId() + ", is mine chatter: " + Intrinsics.areEqual(r3.getId(), r2.a));     // Catch: Throwable -> L13
            if (Intrinsics.areEqual(r3.getId(), r2.a) == false) goto L8;
            CoreThreadPool.getDefault().getUIExecutor().execute(new x0(r2, r3));     // Catch: Throwable -> L13
        L16:
            return Unit.INSTANCE;
        L13:
            th = move-exception;
            Log.e("ImSdkChatterPushImplV2", th, true);
            goto L16
        }
    }

    public static final class d implements Function1<Throwable, Unit> {
        public d() {
        }

        public final Object invoke(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "throwable");
            Log.e("ImSdkChatterPushImplV2", r3);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // m6b.t
    public final void A5(com.ss.android.lark.biz.im.api.l0 r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.l).remove(r2);
    }

    @Override // m6b.t
    public final void J1(com.ss.android.lark.biz.im.api.h0 r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.i).contains(r2) == true) goto L8;
        ((CopyOnWriteArrayList) this.i).add(r2);
        Disposable r3 = (Disposable) this.e.getValue();
        Log.i("ImSdkChatterPushImplV2", "add listener to chatterDisposable");
        return;
    }

    @Override // m6b.t
    public final void h5(w r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.k).remove(r2);
    }

    @Override // m6b.t
    public final void la(com.ss.android.lark.biz.im.api.i0 r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.j).contains(r2) == true) goto L8;
        ((CopyOnWriteArrayList) this.j).add(r2);
        Disposable r3 = (Disposable) this.e.getValue();
        Log.i("ImSdkChatterPushImplV2", "add listener to chatterDisposable");
        return;
    }

    @Override // m6b.t
    public final void r8(com.ss.android.lark.biz.im.api.l0 r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.l).contains(r2) == true) goto L8;
        ((CopyOnWriteArrayList) this.l).add(r2);
        Disposable r3 = (Disposable) this.e.getValue();
        Log.i("ImSdkChatterPushImplV2", "add listener to channelNicknameDisposable");
        return;
    }

    @Override // m6b.t
    public final void te(com.ss.android.lark.biz.im.api.h0 r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.i).remove(r2);
    }

    @Override // m6b.t
    public final void w8(com.ss.android.lark.biz.im.api.i0 r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.j).remove(r2);
    }

    @Override // m6b.t
    public final void x5(w r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.k).contains(r2) == true) goto L8;
        ((CopyOnWriteArrayList) this.k).add(r2);
        Disposable r3 = (Disposable) this.g.getValue();
        Log.i("ImSdkChatterPushImplV2", "add listener to channelNicknameDisposable");
        return;
    }

    @Inject
    public ImSdkChatterPushImplV2(String r2, com.bytedance.lark.rustclient.api.l r3) {
        Intrinsics.checkNotNullParameter(r2, "currentUserId");
        Intrinsics.checkNotNullParameter(r3, "userRustClient");
        this.a = r2;
        this.b = r3;
        Log.i("ImSdkChatterPushImplV2", "current user id is " + r2);
        this.c = new CompositeDisposable();
        this.d = new d();
        LazyThreadSafetyMode r4 = LazyThreadSafetyMode.SYNCHRONIZED;
        this.e = LazyKt.lazy(r4, new ImSdkChatterPushImplV2$chatterDisposable$2(this));
        this.f = new c(this);
        this.g = LazyKt.lazy(r4, new ImSdkChatterPushImplV2$channelNicknameDisposable$2(this));
        this.h = new b(this);
        this.i = new CopyOnWriteArrayList();
        this.j = new CopyOnWriteArrayList();
        this.k = new CopyOnWriteArrayList();
        this.l = new CopyOnWriteArrayList();
    }
}
