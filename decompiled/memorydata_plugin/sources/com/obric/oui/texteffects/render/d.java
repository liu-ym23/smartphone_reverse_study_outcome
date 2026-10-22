package com.obric.oui.texteffects.render;

import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0000\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/obric/oui/texteffects/render/CharacterSpanState;", "", "advances", "", "xCorrections", "", "paint", "Landroid/text/TextPaint;", "spans", "Ljava/util/ArrayList;", "Lcom/obric/oui/texteffects/render/AnimatedCharacterSpan;", "Lkotlin/collections/ArrayList;", "spannable", "Landroid/text/SpannableString;", "layout", "Landroid/text/StaticLayout;", "frameBuffer", "Lcom/obric/oui/texteffects/runtime/TextEffectTimelineSampler$CharacterFrameBuffer;", "([I[FLandroid/text/TextPaint;Ljava/util/ArrayList;Landroid/text/SpannableString;Landroid/text/StaticLayout;Lcom/obric/oui/texteffects/runtime/TextEffectTimelineSampler$CharacterFrameBuffer;)V", "getAdvances", "()[I", "getFrameBuffer", "()Lcom/obric/oui/texteffects/runtime/TextEffectTimelineSampler$CharacterFrameBuffer;", "setFrameBuffer", "(Lcom/obric/oui/texteffects/runtime/TextEffectTimelineSampler$CharacterFrameBuffer;)V", "getLayout", "()Landroid/text/StaticLayout;", "setLayout", "(Landroid/text/StaticLayout;)V", "getPaint", "()Landroid/text/TextPaint;", "getSpannable", "()Landroid/text/SpannableString;", "setSpannable", "(Landroid/text/SpannableString;)V", "getSpans", "()Ljava/util/ArrayList;", "getXCorrections", "()[F", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f14657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f14658b;
    private final TextPaint c;
    private final ArrayList<a> d;
    private SpannableString e;
    private StaticLayout f;
    private com.obric.oui.texteffects.runtime.m.a g;

    public d(int[] r2, float[] r3, TextPaint r4, ArrayList<a> r5, SpannableString r6, StaticLayout r7, com.obric.oui.texteffects.runtime.m.a r8) {
        Intrinsics.checkNotNullParameter(r2, "advances");
        Intrinsics.checkNotNullParameter(r3, "xCorrections");
        Intrinsics.checkNotNullParameter(r4, "paint");
        Intrinsics.checkNotNullParameter(r5, "spans");
        this.f14657a = r2;
        this.f14658b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }

    public /* synthetic */ d(int[] r10, float[] r11, TextPaint r12, ArrayList r13, SpannableString r14, StaticLayout r15, com.obric.oui.texteffects.runtime.m.a r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 4) == 0) goto L5;
        TextPaint r4 = new TextPaint();
    L7:
        if ((r17 & 16) == 0) goto L9;
        SpannableString r6 = null;
    L11:
        if ((r17 & 32) == 0) goto L13;
        StaticLayout r7 = null;
    L15:
        if ((r17 & 64) == 0) goto L17;
        com.obric.oui.texteffects.runtime.m.a r8 = null;
    L18:
        this(r10, r11, r4, r13, r6, r7, r8);
        return;
    L17:
        r8 = r16;
        goto L18
    L13:
        r7 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r4 = r12;
        goto L7
    }

    public final void a(SpannableString r1) {
        this.e = r1;
    }

    public final void a(StaticLayout r1) {
        this.f = r1;
    }

    public final void a(com.obric.oui.texteffects.runtime.m.a r1) {
        this.g = r1;
    }

    public final int[] a() {
        return this.f14657a;
    }

    public final float[] b() {
        return this.f14658b;
    }

    public final TextPaint c() {
        return this.c;
    }

    public final ArrayList<a> d() {
        return this.d;
    }

    public final SpannableString e() {
        return this.e;
    }

    public final StaticLayout f() {
        return this.f;
    }

    public final com.obric.oui.texteffects.runtime.m.a g() {
        return this.g;
    }
}
