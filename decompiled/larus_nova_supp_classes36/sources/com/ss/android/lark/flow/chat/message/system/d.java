package com.ss.android.lark.flow.chat.message.system;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mya.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements com.ss.android.lark.biz.im.api.extension.message.b {

    public static final class a<T extends g> implements com.ss.android.lark.biz.im.api.extension.message.a {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Pair<Class<e>, e> a(com.ss.android.lark.biz.im.api.extension.message.e r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            return TuplesKt.to(e.class, new FlowChatterSystemActionHandler());
        }
    }

    public static final class b<T extends g> implements com.ss.android.lark.biz.im.api.extension.message.a {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Pair<Class<f>, f> a(com.ss.android.lark.biz.im.api.extension.message.e r3) {
            Intrinsics.checkNotNullParameter(r3, "param");
            return TuplesKt.to(f.class, new FlowExecuteActionSystemActionHandler(r3.f()));
        }
    }

    public d() {
    }

    public final Map<Integer, com.ss.android.lark.biz.im.api.extension.message.a<? extends g>> a() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(101, a.a), TuplesKt.to(103, b.a)});
    }
}
