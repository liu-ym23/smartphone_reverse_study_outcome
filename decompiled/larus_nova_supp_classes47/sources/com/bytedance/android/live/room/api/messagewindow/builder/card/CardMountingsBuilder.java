package com.bytedance.android.live.room.api.messagewindow.builder.card;

import android.content.Context;
import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import x61.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class CardMountingsBuilder {
    public DataCenter a;
    public Context b;
    public Object c;
    public int d;
    public MsgWindowPosition e;
    public final Function1<? super ContainerBuilder, Unit> f;
    public Function1<? super b, Unit> g;
    public final Function1<? super d, Unit> h;
    public final Function1<? super a, Unit> i;

    public static final class ContainerBuilder {
        public final Function0<? extends h<?, ?>> a;
        public final CardConstraint b;

        public ContainerBuilder() {
            this.a = CardMountingsBuilder$ContainerBuilder$content$1.INSTANCE;
            this.b = new CardConstraint(-2, -2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public Function0<Unit> a;
        public Function0<Unit> b;
        public Function0<Unit> c;
        public Function0<Unit> d;
        public final v61.a e;

        public b(v61.a r2) {
            Intrinsics.checkNotNullParameter(r2, "card");
            this.e = r2;
        }
    }

    public static final class c {
        public static final c a = null;

        public c() {
        }

        static {
            a = new c();
        }
    }

    public static final class d {
        public final List<t71.a> a;
        public final List<t71.a> b;

        public d() {
            ArrayList r0 = new ArrayList();
            this.a = r0;
            this.b = r0;
        }
    }

    public CardMountingsBuilder() {
        this.c = c.a;
        this.d = Integer.MIN_VALUE;
        this.e = MsgWindowPosition.BOTTOM_RIGHT;
        this.f = CardMountingsBuilder$containerBuilderInit$1.INSTANCE;
        this.g = CardMountingsBuilder$lifeCycleBuilderInit$1.INSTANCE;
        this.h = CardMountingsBuilder$strategyBuilderInit$1.INSTANCE;
        this.i = CardMountingsBuilder$argsBuilderInit$1.INSTANCE;
    }

    public static void a(CardMountingsBuilder r0, DataCenter r1, Object r2, int r3, MsgWindowPosition r4, int r5) {
        if ((r5 & 16) == 0) goto L5;
        r4 = MsgWindowPosition.BOTTOM_RIGHT;
    L5:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "identity");
        Intrinsics.checkNotNullParameter(r4, "position");
        r0.a = r1;
        r0.c = r2;
        r0.d = r3;
        r0.b = null;
        r0.e = r4;
    }
}
