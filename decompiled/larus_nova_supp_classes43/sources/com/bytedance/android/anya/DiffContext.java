package com.bytedance.android.anya;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@AnyaDSL
public abstract class DiffContext {
    public Function1<? super v<?, ?>, Unit> a;

    public static final class a extends DiffContext {
        public a() {
        }
    }

    public DiffContext() {
        this.a = DiffContext$onConsumePropertyChange$1.INSTANCE;
    }
}
