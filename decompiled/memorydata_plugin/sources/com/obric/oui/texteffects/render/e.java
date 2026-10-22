package com.obric.oui.texteffects.render;

import com.obric.oui.texteffects.core.CharacterRangeUnit;
import com.obric.oui.texteffects.core.TextSource;
import com.obric.oui.texteffects.core.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bJ\f\u0010\t\u001a\u00020\u0004*\u00020\nH\u0002J\f\u0010\u000b\u001a\u00020\u0004*\u00020\fH\u0002J\f\u0010\r\u001a\u00020\u0004*\u00020\u000eH\u0002J\f\u0010\u000f\u001a\u00020\u0004*\u00020\bH\u0002¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/texteffects/render/DirectCharacterDrawPolicy;", "", "()V", "canSkipCurrentSpanPreparation", "", "spec", "Lcom/obric/oui/texteffects/core/TextEffectSpec;", "supportsDirectDraw", "Lcom/obric/oui/texteffects/core/CharacterEffectSpec;", "isConstantOne", "Lcom/obric/oui/texteffects/core/CharacterFloatPropertySpec;", "isConstantZero", "Lcom/obric/oui/texteffects/core/CharacterDimensionPropertySpec;", "isZeroDimension", "Lcom/obric/oui/texteffects/core/EffectValue;", "supportsDirectCharacterDraw", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f14659a = null;

    static {
        f14659a = new e();
    }

    private e() {
    }

    private final boolean a(com.obric.oui.texteffects.core.b r4) {
        com.obric.oui.texteffects.core.f r0 = r4.b();
        if (r0 != null) goto L5;
        com.obric.oui.texteffects.core.c r5 = r4.a();
        if (r5 != null) goto L20;
        return true;
    L20:
        if (a(r5.a()) == true) goto L22;
        return false;
    L22:
        if (a(r5.b()) == true) goto L24;
        return false;
    L24:
        return true;
    L5:
        if (r0.a() != 0.0f) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L10;
        return false;
    L10:
        if (r0.b() != 0.0f) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == true) goto L15;
        return false;
    L15:
        return true;
    L12:
        r6 = false;
        goto L13
    L7:
        r3 = false;
        goto L8
    }

    private final boolean a(com.obric.oui.texteffects.core.e r4) {
        if (r4.a().c() != CharacterRangeUnit.Absolute) goto L16;
        if (r4.a().a() != 1.0f) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L16;
        if (r4.a().b() != 1.0f) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L16;
        return true;
    L12:
        r5 = false;
        goto L13
    L7:
        r3 = false;
    L16:
        return false;
    }

    private final boolean a(com.obric.oui.texteffects.core.m r5) {
        if (ZeusTransformUtils.instanceOf(r5, com.obric.oui.texteffects.core.m.a.class) == false) goto L8;
        if (((com.obric.oui.texteffects.core.m.a) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.texteffects.core.m.a.class, "com.obric.memorydata.plugin")).a() != 0.0f) goto L13;
        return true;
    L13:
        return false;
    L8:
        if (ZeusTransformUtils.instanceOf(r5, com.obric.oui.texteffects.core.m.b.class) == false) goto L13;
        if (((com.obric.oui.texteffects.core.m.b) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.texteffects.core.m.b.class, "com.obric.memorydata.plugin")).a() != 0.0f) goto L13;
        return true;
    }

    private final boolean b(com.obric.oui.texteffects.core.d r2) {
        if (a(r2.d()) == true) goto L5;
    L11:
        return false;
    L5:
        if (a(r2.f()) == false) goto L11;
        if (a(r2.h()) == false) goto L11;
        if (a(r2.i()) == false) goto L11;
        return true;
    }

    public final boolean a(com.obric.oui.texteffects.core.d r2) {
        Intrinsics.checkNotNullParameter(r2, "spec");
        if (com.obric.oui.texteffects.b.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (b(r2) == false) goto L7;
        return true;
    }

    public final boolean a(u r9) {
        Intrinsics.checkNotNullParameter(r9, "spec");
        if (com.obric.oui.texteffects.b.a() == true) goto L5;
        return false;
    L5:
        Iterator<com.obric.oui.texteffects.core.l> r8 = r9.d().iterator();
    L7:
        if (r8.hasNext() == false) goto L26;
        Iterator<com.obric.oui.texteffects.core.k> r1 = ((com.obric.oui.texteffects.core.l) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.oui.texteffects.core.l.class, "com.obric.memorydata.plugin")).e().iterator();
    L10:
        if (r1.hasNext() == false) goto L7;
        Iterator<com.obric.oui.texteffects.core.j> r4 = ((com.obric.oui.texteffects.core.k) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.oui.texteffects.core.k.class, "com.obric.memorydata.plugin")).b().iterator();
    L13:
        if (r4.hasNext() == false) goto L10;
        com.obric.oui.texteffects.core.j r5 = (com.obric.oui.texteffects.core.j) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.oui.texteffects.core.j.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, com.obric.oui.texteffects.core.j.b.class) == true) goto L17;
    L23:
        boolean r6 = false;
    L24:
        if (r6 == false) goto L13;
        boolean r10 = true;
    L27:
        if (r10 == false) goto L29;
        return false;
    L29:
        Iterator<com.obric.oui.texteffects.core.l> r11 = r9.d().iterator();
        boolean r12 = false;
    L31:
        if (r11.hasNext() == false) goto L47;
        Iterator<com.obric.oui.texteffects.core.k> r2 = ((com.obric.oui.texteffects.core.l) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.oui.texteffects.core.l.class, "com.obric.memorydata.plugin")).e().iterator();
    L34:
        if (r2.hasNext() == false) goto L31;
        Iterator<com.obric.oui.texteffects.core.j> r7 = ((com.obric.oui.texteffects.core.k) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.oui.texteffects.core.k.class, "com.obric.memorydata.plugin")).b().iterator();
    L37:
        if (r7.hasNext() == false) goto L34;
        com.obric.oui.texteffects.core.j r13 = (com.obric.oui.texteffects.core.j) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.oui.texteffects.core.j.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, com.obric.oui.texteffects.core.j.b.class) == true) goto L41;
    L45:
        boolean r14 = false;
    L46:
        if (r14 == false) goto L37;
    L41:
        if (((com.obric.oui.texteffects.core.j.b) ZeusTransformUtils.preCheckCast(r13, com.obric.oui.texteffects.core.j.b.class, "com.obric.memorydata.plugin")).c() != TextSource.Current) goto L45;
        if (((com.obric.oui.texteffects.core.j.b) ZeusTransformUtils.preCheckCast(r13, com.obric.oui.texteffects.core.j.b.class, "com.obric.memorydata.plugin")).g() == null) goto L45;
        r12 = true;
        r14 = true;
    L47:
        return r12;
    L17:
        if (((com.obric.oui.texteffects.core.j.b) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.texteffects.core.j.b.class, "com.obric.memorydata.plugin")).c() != TextSource.Current) goto L23;
        if (((com.obric.oui.texteffects.core.j.b) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.texteffects.core.j.b.class, "com.obric.memorydata.plugin")).g() == null) goto L23;
        if (f14659a.b(((com.obric.oui.texteffects.core.j.b) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.texteffects.core.j.b.class, "com.obric.memorydata.plugin")).g()) == true) goto L23;
        r6 = true;
        goto L24
    L26:
        r10 = false;
        goto L27
    }
}
