package com.obric.oui.texteffects.render;

import android.graphics.LinearGradient;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u0006\u0010K\u001a\u00020LJ\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u000bHÆ\u0003J\t\u0010O\u001a\u00020\rHÆ\u0003J\t\u0010P\u001a\u00020\rHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0006HÆ\u0003J\t\u0010T\u001a\u00020\bHÆ\u0003J\t\u0010U\u001a\u00020\bHÆ\u0003J\t\u0010V\u001a\u00020\u000bHÆ\u0003J\t\u0010W\u001a\u00020\rHÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010Y\u001a\u00020\rHÆ\u0003J\u008f\u0001\u0010Z\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001J\r\u0010[\u001a\u00020;H\u0000¢\u0006\u0002\b\\J\u0013\u0010]\u001a\u00020\u000b2\b\u0010^\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010_\u001a\u00020`H\u0016J\t\u0010a\u001a\u00020bHÖ\u0001R\u001a\u0010\u0013\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR(\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u001f\u001a\u0004\u0018\u00010 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0013\u0010&\u001a\u0004\u0018\u00010'8F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0013\u0010.\u001a\u0004\u0018\u00010/8F¢\u0006\u0006\u001a\u0004\b0\u00101R!\u00102\u001a\u0012\u0012\u0004\u0012\u00020403j\b\u0012\u0004\u0012\u000204`58F¢\u0006\u0006\u001a\u0004\b6\u00107R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0011\u0010\u0011\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u0010@R\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bJ\u00109¨\u0006c"}, d2 = {"Lcom/obric/oui/texteffects/render/TextLayoutCache;", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "displayText", "chars", "", "widths", "", "characterStartXs", "canDrawCharactersDirectly", "", "contentWidth", "", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "textSizePx", "includeFontPadding", "baseTotalWidth", "baseStartX", "gradientShader", "Landroid/graphics/LinearGradient;", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[C[F[FZFLandroid/text/TextUtils$TruncateAt;FZFFLandroid/graphics/LinearGradient;)V", "getBaseStartX", "()F", "setBaseStartX", "(F)V", "getBaseTotalWidth", "setBaseTotalWidth", "getCanDrawCharactersDirectly", "()Z", EventBody.KEY_VALUE, "Lcom/obric/oui/texteffects/runtime/TextEffectTimelineSampler$CharacterFrameBuffer;", "characterFrameBuffer", "getCharacterFrameBuffer", "()Lcom/obric/oui/texteffects/runtime/TextEffectTimelineSampler$CharacterFrameBuffer;", "setCharacterFrameBuffer", "(Lcom/obric/oui/texteffects/runtime/TextEffectTimelineSampler$CharacterFrameBuffer;)V", "characterLayout", "Landroid/text/StaticLayout;", "getCharacterLayout", "()Landroid/text/StaticLayout;", "characterPaint", "Landroid/text/TextPaint;", "getCharacterPaint", "()Landroid/text/TextPaint;", "characterSpannable", "Landroid/text/SpannableString;", "getCharacterSpannable", "()Landroid/text/SpannableString;", "characterSpans", "Ljava/util/ArrayList;", "Lcom/obric/oui/texteffects/render/AnimatedCharacterSpan;", "Lkotlin/collections/ArrayList;", "getCharacterSpans", "()Ljava/util/ArrayList;", "getCharacterStartXs", "()[F", "characterState", "Lcom/obric/oui/texteffects/render/CharacterSpanState;", "getChars", "()[C", "getContentWidth", "getDisplayText", "()Ljava/lang/CharSequence;", "getEllipsize", "()Landroid/text/TextUtils$TruncateAt;", "getGradientShader", "()Landroid/graphics/LinearGradient;", "setGradientShader", "(Landroid/graphics/LinearGradient;)V", "getIncludeFontPadding", "getText", "getTextSizePx", "getWidths", "clearCharacterResources", "", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "ensureCharacterState", "ensureCharacterState$OUITextEffects_standardRelease", "equals", "other", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharSequence f14683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f14684b;
    private final char[] c;
    private final float[] d;
    private final float[] e;
    private final boolean f;
    private final float g;
    private final TextUtils.TruncateAt h;
    private final float i;
    private final boolean j;
    private float k;
    private float l;
    private LinearGradient m;
    private d n;

    public m(CharSequence r3, CharSequence r4, char[] r5, float[] r6, float[] r7, boolean r8, float r9, TextUtils.TruncateAt r10, float r11, boolean r12, float r13, float r14, LinearGradient r15) {
        CharSequence r16 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r17 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r17, "displayText");
        Intrinsics.checkNotNullParameter(r5, "chars");
        Intrinsics.checkNotNullParameter(r6, "widths");
        Intrinsics.checkNotNullParameter(r7, "characterStartXs");
        this.f14683a = r16;
        this.f14684b = r17;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
    }

    public final CharSequence a() {
        return this.f14683a;
    }

    public final void a(LinearGradient r1) {
        this.m = r1;
    }

    public final void a(com.obric.oui.texteffects.runtime.m.a r1) {
        if (r1 != null) goto L7;
        d r0 = this.n;
        if (r0 == null) goto L10;
        r1 = null;
    L8:
        r0.a(r1);
        return;
    L10:
        return;
    L7:
        r0 = q();
        goto L8
    }

    public final CharSequence b() {
        return this.f14684b;
    }

    public final char[] c() {
        return this.c;
    }

    public final float[] d() {
        return this.d;
    }

    public final float[] e() {
        return this.e;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, m.class) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f14683a, ((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.memorydata.plugin")).f14683a) == false) goto L48;
        if (Intrinsics.areEqual(this.f14684b, ((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.memorydata.plugin")).f14684b) == false) goto L48;
        if (Arrays.equals(this.c, ((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.memorydata.plugin")).c) == false) goto L48;
        if (Arrays.equals(this.d, ((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.memorydata.plugin")).d) == false) goto L48;
        if (Arrays.equals(this.e, ((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.memorydata.plugin")).e) == false) goto L48;
        if (this.f != ((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.memorydata.plugin")).f) goto L48;
        if (this.g != ((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.memorydata.plugin")).g) goto L23;
        boolean r2 = true;
    L24:
        if (r2 == false) goto L48;
        if (this.h != ((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.memorydata.plugin")).h) goto L48;
        if (this.i != ((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.memorydata.plugin")).i) goto L30;
        boolean r3 = true;
    L31:
        if (r3 == false) goto L48;
        if (this.j != ((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.memorydata.plugin")).j) goto L48;
        if (this.k != ((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.memorydata.plugin")).k) goto L37;
        boolean r4 = true;
    L38:
        if (r4 == false) goto L48;
        if (this.l != ((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.memorydata.plugin")).l) goto L42;
        boolean r5 = true;
    L43:
        if (r5 == false) goto L48;
        if (Intrinsics.areEqual(this.m, ((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.memorydata.plugin")).m) == false) goto L48;
        return true;
    L42:
        r5 = false;
        goto L43
    L37:
        r4 = false;
        goto L38
    L30:
        r3 = false;
        goto L31
    L23:
        r2 = false;
    L48:
        return false;
    }

    public final boolean f() {
        return this.f;
    }

    public final float g() {
        return this.g;
    }

    public final TextUtils.TruncateAt h() {
        return this.h;
    }

    public int hashCode() {
        int r0 = ((((((((((((this.f14683a.hashCode() * 31) + this.f14684b.hashCode()) * 31) + Arrays.hashCode(this.c)) * 31) + Arrays.hashCode(this.d)) * 31) + Arrays.hashCode(this.e)) * 31) + Boolean.hashCode(this.f)) * 31) + Float.hashCode(this.g)) * 31;
        TextUtils.TruncateAt r1 = this.h;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((((r0 + r3) * 31) + Float.hashCode(this.i)) * 31) + Boolean.hashCode(this.j)) * 31) + Float.hashCode(this.k)) * 31) + Float.hashCode(this.l)) * 31;
        LinearGradient r5 = this.m;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final float i() {
        return this.i;
    }

    public final boolean j() {
        return this.j;
    }

    public final float k() {
        return this.k;
    }

    public final float l() {
        return this.l;
    }

    public final SpannableString m() {
        d r0 = this.n;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.e();
    }

    public final TextPaint n() {
        return q().c();
    }

    public final com.obric.oui.texteffects.runtime.m.a o() {
        d r0 = this.n;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.g();
    }

    public final void p() {
        this.n = null;
    }

    public final d q() {
        d r0 = this.n;
        if (r0 == null) goto L5;
        return r0;
    L5:
        i r1 = o.a(this.d);
        d r11 = new d(r1.a(), r1.b(), null, new ArrayList(this.c.length), null, null, null, 116, null);
        this.n = r11;
        return r11;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("TextLayoutCache(text=").append(this.f14683a).append(", displayText=").append(this.f14684b).append(", chars=").append(Arrays.toString(this.c)).append(", widths=").append(Arrays.toString(this.d)).append(", characterStartXs=").append(Arrays.toString(this.e)).append(", canDrawCharactersDirectly=").append(this.f).append(", contentWidth=").append(this.g).append(", ellipsize=").append(this.h).append(", textSizePx=").append(this.i).append(", includeFontPadding=").append(this.j).append(", baseTotalWidth=").append(this.k).append(", baseStartX=");
        r0.append(this.l).append(", gradientShader=").append(this.m).append(')');
        return r0.toString();
    }
}
