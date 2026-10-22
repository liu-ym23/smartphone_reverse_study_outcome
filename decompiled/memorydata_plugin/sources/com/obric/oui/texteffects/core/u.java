package com.obric.oui.texteffects.core;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/texteffects/core/TextEffectSpec;", "", OaidModel.KEY_ID, "", "durationMs", "", "loop", "Lcom/obric/oui/texteffects/core/LoopSpec;", "stages", "", "Lcom/obric/oui/texteffects/core/EffectStage;", "(Ljava/lang/String;JLcom/obric/oui/texteffects/core/LoopSpec;Ljava/util/List;)V", "getDurationMs", "()J", "getId", "()Ljava/lang/String;", "getLoop", "()Lcom/obric/oui/texteffects/core/LoopSpec;", "getStages", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f14641b;
    private final r c;
    private final List<l> d;

    public u(String r3, long r4, r r6, List<l> r7) {
        List<l> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r6, "loop");
        Intrinsics.checkNotNullParameter(r8, "stages");
        this.f14640a = r3;
        this.f14641b = r4;
        this.c = r6;
        this.d = r8;
    }

    public /* synthetic */ u(String r8, long r9, r r11, List r12, int r13, DefaultConstructorMarker r14) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        if ((r13 & 4) == 0) goto L5;
        r11 = (r) ZeusTransformUtils.preCheckCast(r.c.f14635a, r.class, "com.obric.memorydata.plugin");
    L5:
        this(r8, r9, r11, r6);
    }

    public final String a() {
        return this.f14640a;
    }

    public final long b() {
        return this.f14641b;
    }

    public final r c() {
        return this.c;
    }

    public final List<l> d() {
        return this.d;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, u.class) == true) goto L8;
        return false;
    L8:
        u r10 = (u) ZeusTransformUtils.preCheckCast(r9, u.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f14640a, r10.f14640a) == true) goto L12;
        return false;
    L12:
        if (this.f14641b == r10.f14641b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f14640a.hashCode() * 31) + Long.hashCode(this.f14641b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "TextEffectSpec(id=" + this.f14640a + ", durationMs=" + this.f14641b + ", loop=" + this.c + ", stages=" + this.d + ')';
    }
}
