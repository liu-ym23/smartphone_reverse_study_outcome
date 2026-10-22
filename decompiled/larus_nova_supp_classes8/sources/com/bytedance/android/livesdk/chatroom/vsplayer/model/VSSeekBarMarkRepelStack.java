package com.bytedance.android.livesdk.chatroom.vsplayer.model;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class VSSeekBarMarkRepelStack {
    public String a;
    public List<Pair<String, List<e>>> b;
    public final PublishSubject<VSSeekBarMarkRepelStack> c;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.vsplayer.model.VSSeekBarMarkRepelStack$update$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/e;", "it", "", "invoke", "(Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/e;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    final class AnonymousClass1 extends Lambda implements Function1<e, Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        public final void invoke(e r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((e) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final Pair<String, List<e>> a() {
        return (Pair) ListProtector.get(this.b, 0);
    L4:
        return null;
    }

    public VSSeekBarMarkRepelStack() {
        this.a = "notify_change_type_init";
        this.b = new ArrayList();
        PublishSubject<VSSeekBarMarkRepelStack> r0 = PublishSubject.create();
        r0.observeOn(AndroidSchedulers.mainThread());
        Unit r1 = Unit.INSTANCE;
        this.c = r0;
    }

    public final void b(Pair<String, ? extends List<e>> r7) {
        Intrinsics.checkNotNullParameter(r7, "item");
        Iterator<Pair<String, List<e>>> r0 = this.b.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual((String) r0.next().getFirst(), (String) r7.getFirst()) == true) goto L10;
        r2 = r2 + 1;
    L10:
        if (r2 == (-1)) goto L12;
        List<Pair<String, List<e>>> r1 = CollectionsKt.toMutableList(CollectionsKt.drop(this.b, RangesKt.coerceAtLeast(r2, 0)));
        this.b = r1;
        ListProtector.set(r1, 0, r7);
    L13:
        this.a = "notify_change_type_push_delete";
        this.c.onNext(this);
        return;
    L12:
        ListProtector.add(this.b, 0, r7);
        goto L13
    L9:
        r2 = -1;
        goto L10
    }

    public final boolean delete(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        boolean r4 = CollectionsKt.removeAll(this.b, new VSSeekBarMarkRepelStack$delete$b$1(r3));
        this.a = "notify_change_type_push_delete";
        this.c.onNext(this);
        return r4;
    }

    public final void update(String r4, Function1<? super e, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "updateAction");
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual((String) ((Pair) r1).getFirst(), r4) == false) goto L4;
    L9:
        Pair r2 = (Pair) r1;
        if (r2 == null) goto L17;
        List r6 = (List) r2.getSecond();
        if (r6 == null) goto L17;
        Iterator r7 = r6.iterator();
    L15:
        if (r7.hasNext() == false) goto L17;
        r5.invoke((e) r7.next());
    L17:
        this.a = "notify_change_type_update";
        this.c.onNext(this);
        return;
    L8:
        r1 = null;
        goto L9
    }
}
