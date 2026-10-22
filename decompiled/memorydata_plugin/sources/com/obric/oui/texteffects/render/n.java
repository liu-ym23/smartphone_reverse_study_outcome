package com.obric.oui.texteffects.render;

import android.graphics.LinearGradient;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jf\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J<\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00162\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J(\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0002J\f\u0010 \u001a\u00020\u000e*\u00020!H\u0002¨\u0006\""}, d2 = {"Lcom/obric/oui/texteffects/render/TextLayoutCacheBuilder;", "", "()V", "build", "Lcom/obric/oui/texteffects/render/TextLayoutCache;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "paint", "Landroid/text/TextPaint;", "contentWidth", "", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "includeFontPadding", "", "startXForWidth", "Lkotlin/Function1;", "gradientFactory", "Landroid/graphics/LinearGradient;", "layout", "Landroid/text/Layout;", "buildCharacterStartXs", "", "widths", "buildCharacterWidthsFromLayout", "displayText", "", "fallbackWidths", "computeCanDrawCharactersDirectly", "chars", "", "totalWidth", "isDirectDrawSafeCharacter", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f14685a = null;

    static {
        f14685a = new n();
    }

    private n() {
    }

    private final boolean a(char r3) {
        if (' ' <= r3) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return true;
    L10:
        if (r3 != 8230) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r3 >= 127) goto L7;
        r1 = true;
        goto L8
    }

    private final boolean a(CharSequence r4, char[] r5, float r6, float r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r5.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return false;
    L9:
        if (r8.length() == r5.length) goto L12;
        return false;
    L12:
        if (r6 > 0.0f) goto L14;
    L29:
        return false;
    L14:
        if (r7 > (r6 + 0.5f)) goto L29;
        int r9 = r5.length;
        int r10 = 0;
    L17:
        if (r10 >= r9) goto L28;
        char r11 = r5[r10];
        r10 = r10 + 1;
        if (r11 == '\n') goto L27;
        if (r11 == '\r') goto L27;
        if (r11 == '\t') goto L27;
        if (a(r11) == true) goto L17;
    L27:
        return false;
    L28:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    private final float[] a(String r26, TextPaint r27, float r28, boolean r29, float[] r30, Layout r31) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return r30;
    L8:
        int r9 = RangesKt.coerceAtLeast((int) Math.ceil(Math.max(r28, Math.max(r27.measureText(r26), ArraysKt.sum(r30)))), 1);
        Layout r6 = null;
        if (r31 == null) goto L15;
        if (StringsKt.contentEquals(r31.getText(), (CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L15;
        r6 = r31;
    L15:
        if (r6 != null) goto L20;
        com.obric.oui.texteffects.a r7 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L19;
        Log.d(Intrinsics.stringPlus("OTextEff/", "CharacterLayoutCache"), "create width StaticLayout text={" + r26 + "}, layoutWidth=" + r9);
    L19:
        r6 = (Layout) ZeusTransformUtils.preCheckCast(new StaticLayout((CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.memorydata.plugin"), r27, r9, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, r29), Layout.class, "com.obric.memorydata.plugin");
    L23:
        float[] r1 = Arrays.copyOf(r30, r30.length);
        Intrinsics.checkNotNullExpressionValue(r1, "copyOf(this, size)");
        com.obric.oui.texteffects.a r3 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L26;
        Log.d(Intrinsics.stringPlus("OTextEff/", "CharacterLayoutCache"), "create widths copy size=" + r1.length + " text={" + r26 + '}');
    L26:
        int r4 = r26.length();
        int r8 = 0;
    L27:
        if (r8 >= r4) goto L42;
        int r10 = r8 + 1;
        if (r6.getLineForOffset(r8) != r6.getLineForOffset(r10)) goto L41;
        float r11 = Math.abs(r6.getPrimaryHorizontal(r10) - r6.getPrimaryHorizontal(r8));
        if (Float.isInfinite(r11) == false) goto L34;
    L36:
        boolean r12 = false;
    L37:
        if (r12 == false) goto L41;
        if (r11 <= 0.0f) goto L41;
        r1[r8] = r11;
        goto L41
    L34:
        if (Float.isNaN(r11) == true) goto L36;
        r12 = true;
    L41:
        r8 = r10;
        goto L27
    L42:
        com.obric.oui.texteffects.a r5 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L45;
        Log.d(Intrinsics.stringPlus("OTextEff/", "CharacterLayoutCache"), "buildCharacterWidthsFromLayout: displayText=" + r26 + ", widths=" + ArraysKt.joinToString$default(r1, (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));
    L45:
        return r1;
    L20:
        com.obric.oui.texteffects.a r13 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L23;
        Log.d(Intrinsics.stringPlus("OTextEff/", "CharacterLayoutCache"), "buildCharacterWidthsFromLayout: reuse liveLayout text={" + r26 + "}, layoutWidth=" + r6.getWidth());
        goto L23
    L5:
        r2 = false;
        goto L6
    }

    private final float[] a(float[] r5) {
        float[] r4 = new float[r5.length];
        int r0 = r5.length;
        float r1 = 0.0f;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        int r3 = r2 + 1;
        r4[r2] = r1;
        r1 = r1 + r5[r2];
        r2 = r3;
        goto L3
    L5:
        return r4;
    }

    public final m a(CharSequence r21, TextPaint r22, float r23, TextUtils.TruncateAt r24, boolean r25, Function1<? super Float, Float> r26, Function1<? super m, ? extends LinearGradient> r27, Layout r28) {
        CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
        Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r26, Function1.class, "com.obric.memorydata.plugin");
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r27, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r22, "paint");
        Intrinsics.checkNotNullParameter(r12, "startXForWidth");
        Intrinsics.checkNotNullParameter(r15, "gradientFactory");
        if (r24 != null) goto L5;
    L7:
        CharSequence r13 = r11;
    L8:
        String r6 = r13.toString();
        char[] r5 = r6.toCharArray();
        Intrinsics.checkNotNullExpressionValue(r5, "this as java.lang.String).toCharArray()");
        float[] r4 = new float[r5.length];
        com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L13;
        Log.d(Intrinsics.stringPlus("OTextEff/", "TextLayoutCacheBuilder"), "create fallbackWidths size=" + r5.length + " text={" + r6 + '}');
    L13:
        if (r5.length != 0) goto L15;
        boolean r1 = true;
    L17:
        if ((!r1) == false) goto L19;
        r22.getTextWidths(r5, 0, r5.length, r4);
    L19:
        float[] r7 = a(r6, r22, r23, r25, r4, r28);
        float[] r8 = a(r7);
        float r9 = ArraysKt.sum(r7);
        Intrinsics.checkNotNullExpressionValue(r13, "displayText");
        boolean r10 = a(r13, r5, r23, r9);
        com.obric.oui.texteffects.a r2 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L23;
        Log.d(Intrinsics.stringPlus("OTextEff/", "TextLayoutCacheBuilder"), "create TextLayoutCache text={" + r6 + "}, chars=" + r5.length + ", totalWidth=" + r9 + ", contentWidth=" + r23 + ", ellipsize=" + r24 + ", includeFontPadding=" + r25 + ", directDraw=" + r10);
    L23:
        m r16 = new m(r11, r13, r5, r7, r8, r10, r23, r24, r22.getTextSize(), r25, r9, ((Number) ZeusTransformUtils.preCheckCast(r12.invoke(Float.valueOf(r9)), Number.class, "com.obric.memorydata.plugin")).floatValue(), null);
        r16.a((LinearGradient) ZeusTransformUtils.preCheckCast(r15.invoke(r16), LinearGradient.class, "com.obric.memorydata.plugin"));
        return r16;
    L15:
        r1 = false;
        goto L17
    L5:
        if (r23 <= 0.0f) goto L7;
        r13 = TextUtils.ellipsize(r11, r22, r23, r24);
        goto L8
    }
}
