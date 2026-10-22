package com.bytedance.android.live.profit.lottery;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LotteryPluginStore implements com.bytedance.android.scope.o, o {
    public boolean a;
    public final Map<Object, n> b;
    public final LotteryContext c;
    public final LotteryRepository d;

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.lottery.LotteryPluginStore$onStart$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/live/profit/lottery/Lottery;", "Lkotlin/ParameterName;", "name", "lottery", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Lottery, Boolean> {
        public AnonymousClass1(LotteryPluginStore r8) {
            super(1, r8, LotteryPluginStore.class, "interceptNewLottery", "interceptNewLottery(Lcom/bytedance/android/live/profit/lottery/Lottery;)Z", 0);
        }

        public final boolean invoke(Lottery r3) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            Collection r0 = ((LinkedHashMap) ((LotteryPluginStore) ((CallableReference) this).receiver).b).values();
            if ((r0 instanceof Collection) == true) goto L5;
        L7:
            Iterator r1 = r0.iterator();
        L9:
            if (r1.hasNext() == false) goto L13;
            if (((n) r1.next()).c(r3) == false) goto L9;
            return true;
        L13:
            return false;
        L5:
            if (r0.isEmpty() == false) goto L7;
            goto L7
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return Boolean.valueOf(invoke((Lottery) r1));
        }
    }

    public final void onStop() {
        this.a = true;
        Iterator r0 = ((LinkedHashMap) this.b).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((n) r0.next()).onUnload();
        goto L4
    L6:
        ((LinkedHashMap) this.b).clear();
    }

    public final void onStart() {
        LotteryRepository r0 = this.d;
        r0.m = new AnonymousClass1(this);
    }

    @Override // com.bytedance.android.live.profit.lottery.o
    public final void a(n r4) {
        Intrinsics.checkNotNullParameter(r4, "plugin");
        Class<?> r1 = r4.getClass();
        Intrinsics.checkNotNullParameter(r1, "uniqueId");
        Intrinsics.checkNotNullParameter(r4, "plugin");
        if (this.a == false) goto L6;
        return;
    L6:
        if (this.b.containsKey(r1) == true) goto L11;
        this.b.put(r1, r4);
        r4.a(this.c);
        return;
    }

    public LotteryPluginStore(LotteryContext r2, LotteryRepository r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lotteryRepository");
        this.c = r2;
        this.d = r3;
        this.b = new LinkedHashMap();
    }
}
