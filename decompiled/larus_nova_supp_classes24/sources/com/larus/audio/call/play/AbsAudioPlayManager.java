package com.larus.audio.call.play;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class AbsAudioPlayManager implements u68.c {
    public final boolean a;
    public final boolean b;
    public final Integer c;
    public final Lazy d;
    public final f e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0084\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/call/play/AbsAudioPlayManager$Wait;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID", "WAIT", "DATA_END", "STOPPED", "COMPLETE", "PAUSED", "RESUME", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Wait extends Enum<Wait> {
        public static final Wait COMPLETE = null;
        public static final Wait DATA_END = null;
        public static final Wait INVALID = null;
        public static final Wait PAUSED = null;
        public static final Wait RESUME = null;
        public static final Wait STOPPED = null;
        public static final Wait WAIT = null;
        public static final /* synthetic */ Wait[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Wait> getEntries() {
            return b;
        }

        static {
            Wait r0 = new Wait("INVALID", 0);
            INVALID = r0;
            Wait r1 = new Wait("WAIT", 1);
            WAIT = r1;
            Wait r3 = new Wait("DATA_END", 2);
            DATA_END = r3;
            Wait r5 = new Wait("STOPPED", 3);
            STOPPED = r5;
            Wait r7 = new Wait("COMPLETE", 4);
            COMPLETE = r7;
            Wait r9 = new Wait("PAUSED", 5);
            PAUSED = r9;
            Wait r11 = new Wait("RESUME", 6);
            RESUME = r11;
            Wait[] r13 = {r0, r1, r3, r5, r7, r9, r11};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
        }

        public static Wait[] values() {
            return (Wait[]) a.clone();
        }

        public static Wait valueOf(String r1) {
            return (Wait) r27.a.a(Wait.class, r1);
        }

        public Wait(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Override // u68.a
    public void c(boolean r1) {
    }

    @Override // u68.c
    public void f() {
    }

    public b l() {
        return (b) this.d.getValue();
    }

    @Override // u68.a
    public final void i(u68.a.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.e.h(r2);
    }

    @Override // u68.a
    public final void j(u68.a.b r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        f r1 = this.e;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "callback");
        if (((CopyOnWriteArraySet) r1.b).contains(r3) == false) goto L7;
        ((CopyOnWriteArraySet) r1.b).remove(r3);
        return;
    }

    public AbsAudioPlayManager(boolean r1, boolean r2, Integer r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        hashCode();
        this.d = LazyKt.lazy(new a(this));
        this.e = new f();
    }
}
