package com.obric.oui.texteffects.runtime;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00160\u0018H\u0086\bø\u0001\u0000J\u0006\u0010\u0019\u001a\u00020\u000bJ\u0016\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fR\u001e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/texteffects/runtime/ReusableTextEffectFrame;", "", "initialLayerCapacity", "", "(I)V", "<set-?>", "activeLayerCount", "getActiveLayerCount", "()I", "layers", "Ljava/util/ArrayList;", "Lcom/obric/oui/texteffects/runtime/ReusableLayerFrame;", "Lkotlin/collections/ArrayList;", "getLayers", "()Ljava/util/ArrayList;", "", "normalizedPlayTimeMs", "getNormalizedPlayTimeMs", "()J", "playTimeMs", "getPlayTimeMs", "forEachActive", "", "action", "Lkotlin/Function1;", "nextLayer", "reset", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f14695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f14696b;
    private final ArrayList<e> c;
    private int d;

    public f() {
        this(0, 1, null);
    }

    public f(int r2) {
        this.c = new ArrayList(r2);
    }

    public /* synthetic */ f(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        this(r1);
    }

    public final ArrayList<e> a() {
        return this.c;
    }

    public final void a(long r1, long r3) {
        this.f14695a = r1;
        this.f14696b = r3;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.c, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        this.d = 0;
        return;
    }

    public final int b() {
        return this.d;
    }

    public final e c() {
        if (this.d < this.c.size()) goto L5;
        ((Collection) ZeusTransformUtils.preCheckCast(this.c, Collection.class, "com.obric.memorydata.plugin")).add(new e());
    L5:
        ArrayList<e> r0 = this.c;
        int r1 = this.d;
        this.d = r1 + 1;
        e r4 = r0.get(r1);
        Intrinsics.checkNotNullExpressionValue(r4, "layers[activeLayerCount++]");
        return (e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.memorydata.plugin");
    }
}
