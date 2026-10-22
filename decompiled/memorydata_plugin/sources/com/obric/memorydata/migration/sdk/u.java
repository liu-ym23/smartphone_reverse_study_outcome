package com.obric.memorydata.migration.sdk;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationLogObserver;", "Lcom/obric/memorydata/migration/sdk/MigrationObserver;", "logPrefix", "", "<init>", "(Ljava/lang/String;)V", "lastProgressPercent", "", "onEvent", "", "event", "Lcom/obric/memorydata/migration/sdk/MigrationEvent;", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class u implements v {
    private final String c;
    private int d;

    /* JADX WARN: Multi-variable type inference failed */
    public u() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public u(String r2) {
        Intrinsics.checkNotNullParameter(r2, "logPrefix");
        this.c = r2;
        this.d = -1;
    }

    public /* synthetic */ u(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "migration";
    L5:
        this(r1);
    }

    @Override // com.obric.memorydata.migration.sdk.v
    public void onEvent(p r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        if (ZeusTransformUtils.instanceOf(r9, p.d.class) == false) goto L12;
        t.f11981a.a(this.c + " sender qr generated, len=" + ((p.d) ZeusTransformUtils.preCheckCast(r9, p.d.class, "com.obric.memorydata.plugin")).a().length());
        t r0 = t.f11981a;
        StringBuilder r2 = new StringBuilder().append(this.c).append(" pairingCodePresent=");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(((p.d) ZeusTransformUtils.preCheckCast(r9, p.d.class, "com.obric.memorydata.plugin")).b().getPairingCode(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        r0.a(r2.append(!r4).toString());
        t r1 = t.f11981a;
        StringBuilder r8 = new StringBuilder().append(this.c).append(" endpoints=").append(((p.d) ZeusTransformUtils.preCheckCast(r9, p.d.class, "com.obric.memorydata.plugin")).b().getEndpoints());
    L30:
        r1.a(r8.toString());
        return;
    L7:
        if (StringsKt.isBlank(r3) == true) goto L10;
        r4 = false;
        goto L11
    L12:
        String r5 = "";
        if (ZeusTransformUtils.instanceOf(r9, p.a.class) == false) goto L24;
        if (((p.a) ZeusTransformUtils.preCheckCast(r9, p.a.class, "com.obric.memorydata.plugin")).c() <= 0) goto L17;
        String r6 = r.f11979a.a(((p.a) ZeusTransformUtils.preCheckCast(r9, p.a.class, "com.obric.memorydata.plugin")).c()) + '(' + ((p.a) ZeusTransformUtils.preCheckCast(r9, p.a.class, "com.obric.memorydata.plugin")).c() + "B)";
    L18:
        t r7 = t.f11981a;
        StringBuilder r10 = new StringBuilder().append(this.c).append(" artifact: ").append(((p.a) ZeusTransformUtils.preCheckCast(r9, p.a.class, "com.obric.memorydata.plugin")).a()).append(" -> ").append(((p.a) ZeusTransformUtils.preCheckCast(r9, p.a.class, "com.obric.memorydata.plugin")).b());
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L22;
        r5 = " (" + r6 + ')';
    L22:
        r7.a(r10.append(r5).toString());
        return;
    L17:
        r6 = "";
        goto L18
    L24:
        if (ZeusTransformUtils.instanceOf(r9, p.e.class) == false) goto L32;
        r1 = t.f11981a;
        StringBuilder r11 = new StringBuilder().append(this.c).append(" state: ").append(((p.e) ZeusTransformUtils.preCheckCast(r9, p.e.class, "com.obric.memorydata.plugin")).a()).append(' ');
        String r12 = ((p.e) ZeusTransformUtils.preCheckCast(r9, p.e.class, "com.obric.memorydata.plugin")).b();
        if (r12 == null) goto L29;
        r5 = r12;
    L29:
        r8 = r11.append(r5);
        goto L30
    L32:
        if (ZeusTransformUtils.instanceOf(r9, p.b.class) == false) goto L35;
        t.f11981a.a(this.c + " error: " + ((p.b) ZeusTransformUtils.preCheckCast(r9, p.b.class, "com.obric.memorydata.plugin")).a() + ' ' + ((p.b) ZeusTransformUtils.preCheckCast(r9, p.b.class, "com.obric.memorydata.plugin")).b().a() + ' ' + ((p.b) ZeusTransformUtils.preCheckCast(r9, p.b.class, "com.obric.memorydata.plugin")).b().b(), ((p.b) ZeusTransformUtils.preCheckCast(r9, p.b.class, "com.obric.memorydata.plugin")).b().c());
        return;
    L35:
        if (ZeusTransformUtils.instanceOf(r9, p.c.class) == false) goto L41;
        int r13 = ((p.c) ZeusTransformUtils.preCheckCast(r9, p.c.class, "com.obric.memorydata.plugin")).d();
        if (r13 == this.d) goto L45;
        this.d = r13;
        Pair<String, String> r14 = r.f11979a.a(((p.c) ZeusTransformUtils.preCheckCast(r9, p.c.class, "com.obric.memorydata.plugin")).b(), ((p.c) ZeusTransformUtils.preCheckCast(r9, p.c.class, "com.obric.memorydata.plugin")).c());
        t.f11981a.a(this.c + " progress: " + ((p.c) ZeusTransformUtils.preCheckCast(r9, p.c.class, "com.obric.memorydata.plugin")).a() + ' ' + ((String) ZeusTransformUtils.preCheckCast(r14.component1(), String.class, "com.obric.memorydata.plugin")) + '/' + ((String) ZeusTransformUtils.preCheckCast(r14.component2(), String.class, "com.obric.memorydata.plugin")) + ' ' + ((p.c) ZeusTransformUtils.preCheckCast(r9, p.c.class, "com.obric.memorydata.plugin")).d() + '%');
        return;
    L45:
        return;
    L41:
        throw new NoWhenBranchMatchedException();
    }
}
