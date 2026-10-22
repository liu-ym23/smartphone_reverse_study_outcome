package com.bytedance.android.livesdk.interactivity.service.messagelist;

import android.os.Message;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements IMessageListManager, WeakHandler.IHandler {
    public final WeakHandler a;
    public boolean b;
    public final PropertyOwner<IMessageListManager.a> c;
    public final List<c> d;
    public final Deque<c> e;
    public final CompositeDisposable f;
    public final AtomicBoolean g;
    public final b h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.IMessageListManager
    public final PropertyOwner a() {
        PropertyOwner<IMessageListManager.a> r0 = this.c;
        r0.getClass();
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.IMessageListManager
    public final PublishSubject b() {
        l r0 = this.h.b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.IMessageListManager
    public final int c() {
        l r0 = this.h.b();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.a;
    }

    public final int d() {
        l r0 = this.h.b();
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.c;
    }

    public final PublishSubject e() {
        l r0 = this.h.b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.IMessageListManager
    public final b getConfig() {
        return this.h;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.IMessageListManager
    public final List<c> getMessageList() {
        return this.d;
    }

    public g(b r9) {
        Intrinsics.checkNotNullParameter(r9, "config");
        this.h = r9;
        this.a = new WeakHandler(this);
        this.c = new PropertyOwner(new IMessageListManager.a(IMessageListManager.MessageChangeType.RELOAD_ALL, 0, 0, 0, null, 30));
        this.d = new ArrayList();
        this.e = new ArrayDeque();
        this.f = new CompositeDisposable();
        this.g = new AtomicBoolean();
    }

    public final void f(c r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        if (this.f.isDisposed() == false) goto L8;
        pm0.a r6 = om0.c.c();
        if (r6 == null) goto L41;
        r6.i("MessageListManager", "MessageListManager insertMessage failed for disposed");
        return;
    L41:
        return;
    L8:
        List<d> r0 = this.h.getInterceptors();
        Object r1 = null;
        if (r0 == null) goto L17;
        Iterator<T> r2 = r0.iterator();
    L12:
        if (r2.hasNext() == false) goto L16;
        Object r3 = r2.next();
        if (((d) r3).a(r5) == false) goto L12;
        r1 = r3;
    L16:
        r1 = (d) r1;
    L17:
        if (r1 == null) goto L20;
        return;
    L20:
        if (((ArrayDeque) this.e).size() > this.h.a().getMaxCount()) goto L22;
    L24:
        boolean r4 = false;
    L25:
        if (r4 == true) goto L35;
        if (((ArrayDeque) this.e).size() <= this.h.a().getMaxCount()) goto L31;
        ((ArrayDeque) this.e).pollFirst();
    L31:
        if (r5.b() == false) goto L33;
        ((ArrayDeque) this.e).addFirst(r5);
        goto L35
    L33:
        ((ArrayDeque) this.e).addLast(r5);
    L35:
        if (this.g.compareAndSet(false, true) == false) goto L42;
        this.a.sendEmptyMessageDelayed(20113, this.h.d().a());
        return;
    L42:
        return;
    L22:
        if (this.h.a().a() == false) goto L24;
        r4 = true;
        goto L25
    }

    public final void g(IMessageListManager.a r2) {
        l r0 = this.h.b();
        if (r0 == null) goto L5;
        r0.onEvent(r2);
    L5:
        this.c.a(r2);
    }

    public final void handleMsg(Message r23) {
        if (r23 != null) goto L5;
        return;
    L5:
        if (r23.what != 20113) goto L54;
        e r1 = this.h.d();
        int r3 = r1.c();
        ArrayList r4 = new ArrayList();
        int r6 = 0;
    L8:
        if (r6 >= r3) goto L28;
        c r9 = null;
        if (((ArrayDeque) this.e).isEmpty() == false) goto L13;
    L25:
        if (r9 == null) goto L27;
        r4.add(r9);
    L27:
        r6 = r6 + 1;
        goto L8
    L13:
        if (((ArrayList) this.d).isEmpty() == false) goto L24;
        Iterator r8 = ((ArrayDeque) this.e).iterator();
    L16:
        if (r8.hasNext() == false) goto L20;
        Object r10 = r8.next();
        if ((!((c) r10).c()) == false) goto L16;
    L21:
        c r11 = (c) r10;
        if (r11 == null) goto L25;
        ((ArrayDeque) this.e).remove(r11);
        r9 = r11;
        goto L25
    L20:
        r10 = null;
        goto L21
    L24:
        r9 = (c) ((ArrayDeque) this.e).pollFirst();
        goto L25
    L28:
        Iterator r5 = r4.iterator();
    L30:
        if (r5.hasNext() == false) goto L41;
        c r13 = (c) r5.next();
        if (((ArrayList) this.d).size() <= this.h.c().getMaxCount()) goto L40;
        int r7 = this.h.c().a();
        if (this.h.c().b() == true) goto L36;
        ((ArrayList) this.d).subList(0, r7).clear();
        g(new IMessageListManager.a(IMessageListManager.MessageChangeType.REMOVE_RANGE, 0, 0, r7, null, 18));
        goto L40
    L36:
        List<c> r14 = this.d;
        hb2.a r15 = hb2.a.b;
        if (((ArrayList) r14).contains(r15) == true) goto L39;
        ListProtector.add(this.d, 0, r15);
        g(new IMessageListManager.a(IMessageListManager.MessageChangeType.INSERT_ITEM, 0, 0, 0, r15, 12));
    L39:
        ((ArrayList) this.d).subList(1, r7 + 1).clear();
        g(new IMessageListManager.a(IMessageListManager.MessageChangeType.REMOVE_RANGE, 0, 1, r7, null, 18));
    L40:
        ((ArrayList) this.d).add(r13);
        g(new IMessageListManager.a(IMessageListManager.MessageChangeType.INSERT_BOTTOM, ((ArrayList) this.d).size() - 1, 0, 0, r13, 12));
        goto L30
    L41:
        r1.b();
        this.a.sendEmptyMessageDelayed(20113, r1.a());
        return;
    }
}
