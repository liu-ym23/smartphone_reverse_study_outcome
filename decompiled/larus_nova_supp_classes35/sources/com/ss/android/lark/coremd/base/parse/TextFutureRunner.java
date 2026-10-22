package com.ss.android.lark.coremd.base.parse;

import android.text.Spannable;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class TextFutureRunner {
    public final x a;
    public State b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/coremd/base/parse/TextFutureRunner$State;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "IDLE", "RUNNING", "FINISH", "FAILED", "core-md_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        public static final State FAILED = null;
        public static final State FINISH = null;
        public static final State IDLE = null;
        public static final State RUNNING = null;
        public static final /* synthetic */ State[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<State> getEntries() {
            return b;
        }

        static {
            State r0 = new State("IDLE", 0);
            IDLE = r0;
            State r1 = new State("RUNNING", 1);
            RUNNING = r1;
            State r3 = new State("FINISH", 2);
            FINISH = r3;
            State r5 = new State("FAILED", 3);
            FAILED = r5;
            State[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final class a implements x.a {
        public final x.a a;
        public final /* synthetic */ TextFutureRunner b;

        @Override // com.ss.android.lark.coremd.base.parse.x.a
        public final void a() {
            TextFutureRunner r0 = this.b;
            r0.b = State.FAILED;
            this.a.a();
        }

        public a(TextFutureRunner r2, com.ss.android.lark.coremd.impl.parse.n.a r3) {
            Intrinsics.checkNotNullParameter(r3, "handle");
            this.b = r2;
            this.a = r3;
        }

        @Override // com.ss.android.lark.coremd.base.parse.x.a
        public final void b(v7b.s r3, Spannable r4) {
            Intrinsics.checkNotNullParameter(r3, "node");
            Intrinsics.checkNotNullParameter(r4, "text");
            TextFutureRunner r0 = this.b;
            r0.b = State.FINISH;
            this.a.b(r3, r4);
        }
    }

    public TextFutureRunner(com.ss.android.lark.coremdbiz.facade.plugins.t r2) {
        Intrinsics.checkNotNullParameter(r2, "future");
        this.a = r2;
        this.b = State.IDLE;
    }
}
