package f52;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.PSTopContainer;
import com.bytedance.android.livesdkapi.message.HighlightAreaPriorityConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class j<T> implements c {
    public final String a;
    public final f b;
    public final long c;
    public final int d;
    public final int e;
    public final int f;
    public final long g;
    public final ConflictStrategy h;
    public final ConflictStrategy i;
    public final ConflictStrategy j;
    public final boolean k;
    public final HighlightAreaPriorityConfig l;
    public final T m;

    @Override // f52.c
    public HighlightAreaPriorityConfig c() {
        return this.l;
    }

    @Override // f52.c
    public final ConflictStrategy d() {
        return this.j;
    }

    @Override // f52.c
    public final ConflictStrategy f() {
        return this.h;
    }

    @Override // f52.c
    public final boolean g() {
        return this.k;
    }

    @Override // f52.c
    public final int getDelayTime() {
        return this.e;
    }

    @Override // f52.c
    public final int getDuration() {
        return this.f;
    }

    @Override // f52.c
    public final long getEndTimestamp() {
        return this.g;
    }

    @Override // f52.c
    public final String getId() {
        return this.a;
    }

    @Override // f52.c
    public final long getStartTimestamp() {
        return this.c;
    }

    @Override // f52.c
    public f getType() {
        return this.b;
    }

    @Override // f52.c
    public final ConflictStrategy k() {
        return this.i;
    }

    @Override // f52.c
    public final int l() {
        return this.d;
    }

    @Override // f52.c
    public boolean j(c r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r2, "view");
        return true;
    }

    public final void m(b r6) {
        Intrinsics.checkNotNullParameter(r6, "container");
        if (this.g <= 0) goto L5;
        return;
    L5:
        if (this.f > 0) goto L10;
        r6.d(this);
        return;
    }

    @Override // f52.c
    public void e(c r3, PSTopContainer r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "container");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "container");
    }

    public j(String r9, f r10, long r11, int r13, int r14, int r15, long r16, ConflictStrategy r18, ConflictStrategy r19, ConflictStrategy r20, boolean r21, HighlightAreaPriorityConfig r23, T r24) {
        Intrinsics.checkNotNullParameter(r9, "id");
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r18, "priorityLowerStrategy");
        Intrinsics.checkNotNullParameter(r19, "priorityEqualStrategy");
        Intrinsics.checkNotNullParameter(r20, "priorityHigherStrategy");
        Intrinsics.checkNotNullParameter(r24, "data");
        this.a = r9;
        this.b = r10;
        this.c = r11;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r18;
        this.i = r19;
        this.j = r20;
        this.k = r21;
        this.l = r23;
        this.m = r24;
    }

    public /* synthetic */ j(String r19, f r20, long r21, int r23, int r24, int r25, long r26, ConflictStrategy r28, ConflictStrategy r29, ConflictStrategy r30, boolean r31, HighlightAreaPriorityConfig r33, Object r34, int r35) {
        if ((r35 & 128) == 0) goto L5;
        ConflictStrategy r13 = ConflictStrategy.DISCARD;
    L7:
        if ((r35 & 256) == 0) goto L9;
        ConflictStrategy r14 = ConflictStrategy.QUEUE;
    L11:
        if ((r35 & 512) == 0) goto L13;
        ConflictStrategy r15 = ConflictStrategy.INTERRUPT;
    L15:
        if ((r35 & 1024) == 0) goto L17;
        boolean r16 = false;
    L19:
        if ((r35 & 2048) == 0) goto L21;
        HighlightAreaPriorityConfig r17 = null;
    L22:
        this(r19, r20, r21, r23, r24, r25, r26, r13, r14, r15, r16, r17, r34);
        return;
    L21:
        r17 = r33;
        goto L22
    L17:
        r16 = r31;
        goto L19
    L13:
        r15 = r30;
        goto L15
    L9:
        r14 = r29;
        goto L11
    L5:
        r13 = r28;
        goto L7
    }
}
