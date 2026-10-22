package com.obric.oui.texteffects.core;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JC\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\""}, d2 = {"Lcom/obric/oui/texteffects/core/EffectStage;", "", OaidModel.KEY_ID, "", "startMs", "", "durationMs", "mask", "Lcom/obric/oui/texteffects/core/MaskSpec;", "groups", "", "Lcom/obric/oui/texteffects/core/EffectLayerGroupSpec;", "(Ljava/lang/String;JJLcom/obric/oui/texteffects/core/MaskSpec;Ljava/util/List;)V", "getDurationMs", "()J", "getGroups", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getMask", "()Lcom/obric/oui/texteffects/core/MaskSpec;", "getStartMs", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f14611b;
    private final long c;
    private final s d;
    private final List<k> e;

    public l(String r3, long r4, long r6, s r8, List<k> r9) {
        List<k> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r10, "groups");
        this.f14610a = r3;
        this.f14611b = r4;
        this.c = r6;
        this.d = r8;
        this.e = r10;
    }

    public /* synthetic */ l(String r10, long r11, long r13, s r15, List r16, int r17, DefaultConstructorMarker r18) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        if ((r17 & 8) == 0) goto L5;
        s r7 = null;
    L6:
        this(r10, r11, r13, r7, r8);
        return;
    L5:
        r7 = r15;
        goto L6
    }

    public final String a() {
        return this.f14610a;
    }

    public final long b() {
        return this.f14611b;
    }

    public final long c() {
        return this.c;
    }

    public final s d() {
        return this.d;
    }

    public final List<k> e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, l.class) == true) goto L8;
        return false;
    L8:
        l r10 = (l) ZeusTransformUtils.preCheckCast(r9, l.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f14610a, r10.f14610a) == true) goto L12;
        return false;
    L12:
        if (this.f14611b == r10.f14611b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f14610a.hashCode() * 31) + Long.hashCode(this.f14611b)) * 31) + Long.hashCode(this.c)) * 31;
        s r1 = this.d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.e.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "EffectStage(id=" + this.f14610a + ", startMs=" + this.f14611b + ", durationMs=" + this.c + ", mask=" + this.d + ", groups=" + this.e + ')';
    }
}
