package com.obric.oui.texteffects;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.loc.o;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.oui.texteffects.core.u;
import com.obric.oui.texteffects.render.j;
import com.obric.oui.texteffects.render.k;
import com.obric.oui.texteffects.runtime.f;
import com.obric.oui.texteffects.runtime.i;
import com.obric.oui.texteffects.runtime.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 i2\u00020\u0001:\u0001iB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010>\u001a\u00020?H\u0000¢\u0006\u0002\b@JG\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00172\u0006\u0010D\u001a\u00020\u00132\u0006\u0010E\u001a\u00020\n2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010G2\b\b\u0002\u0010I\u001a\u00020\u001dH\u0000¢\u0006\u0002\bJJ\b\u0010K\u001a\u00020BH\u0014J\u0010\u0010L\u001a\u00020B2\u0006\u0010M\u001a\u00020NH\u0014J \u0010O\u001a\u00020B2\u0006\u0010E\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\u0017H\u0014J(\u0010P\u001a\u00020B2\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u0007H\u0014J*\u0010U\u001a\u00020B2\b\u0010V\u001a\u0004\u0018\u00010G2\u0006\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\u0007H\u0014J\b\u0010Z\u001a\u00020BH\u0014J\u0018\u0010[\u001a\u00020B2\u0006\u0010E\u001a\u00020\n2\u0006\u0010C\u001a\u00020\u0017H\u0014J\b\u0010\\\u001a\u00020BH\u0014J\r\u0010]\u001a\u00020BH\u0000¢\u0006\u0002\b^J\n\u0010_\u001a\u0004\u0018\u00010`H\u0004J\u0010\u0010a\u001a\u00020B2\u0006\u0010b\u001a\u00020\u000fH\u0016J\u0010\u0010c\u001a\u00020B2\u0006\u0010D\u001a\u00020\u0013H\u0016JF\u0010d\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\n2\b\b\u0002\u0010e\u001a\u00020\u001d2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010G2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010GH\u0004J\b\u0010g\u001a\u00020BH\u0016J,\u0010h\u001a\u00020B2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010G2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010GH\u0004R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000f@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!R\u0011\u0010$\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\nX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\rR\u0014\u0010(\u001a\u00020\u000fX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0011R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010#\u001a\u0004\b,\u0010-R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010#\u001a\u0004\b1\u00102R\u001b\u00104\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010#\u001a\u0004\b6\u00107R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010#\u001a\u0004\b;\u0010<¨\u0006j"}, d2 = {"Lcom/obric/oui/texteffects/OProtocolTextEffectTextView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "activeEffectName", "getActiveEffectName", "()Ljava/lang/String;", "blurFilterCacheGranularityPx", "", "getBlurFilterCacheGranularityPx", "()F", "currentEffectPlayTimeMs", "", "getCurrentEffectPlayTimeMs", "()J", "currentTextEffectSpec", "Lcom/obric/oui/texteffects/core/TextEffectSpec;", "getCurrentTextEffectSpec", "()Lcom/obric/oui/texteffects/core/TextEffectSpec;", "debugAnimationDurationScale", "getDebugAnimationDurationScale", "delegateReady", "", "host", "Lcom/obric/oui/texteffects/host/AndroidTextViewEffectHost;", "getHost", "()Lcom/obric/oui/texteffects/host/AndroidTextViewEffectHost;", "host$delegate", "Lkotlin/Lazy;", "isEffectRunning", "()Z", "logTag", "getLogTag", "maxBlurRadiusDp", "getMaxBlurRadiusDp", "renderEngine", "Lcom/obric/oui/texteffects/render/TextEffectRenderEngine;", "getRenderEngine", "()Lcom/obric/oui/texteffects/render/TextEffectRenderEngine;", "renderEngine$delegate", "runtime", "Lcom/obric/oui/texteffects/runtime/TextEffectRuntime;", "getRuntime", "()Lcom/obric/oui/texteffects/runtime/TextEffectRuntime;", "runtime$delegate", "shaderRepository", "Lcom/obric/oui/texteffects/render/TextEffectShaderRepository;", "getShaderRepository", "()Lcom/obric/oui/texteffects/render/TextEffectShaderRepository;", "shaderRepository$delegate", "textRepository", "Lcom/obric/oui/texteffects/render/TextEffectTextRepository;", "getTextRepository", "()Lcom/obric/oui/texteffects/render/TextEffectTextRepository;", "textRepository$delegate", "characterSampleStatsForTest", "Lcom/obric/oui/texteffects/render/TextEffectRenderEngine$CharacterSampleStats;", "characterSampleStatsForTest$OUITextEffects_standardRelease", "installTextEffectFrameForTest", "", "spec", "playTimeMs", "effectName", "oldText", "", "newText", "clearTextCaches", "installTextEffectFrameForTest$OUITextEffects_standardRelease", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onEffectFrameUpdated", "onSizeChanged", "w", o.g, "oldw", "oldh", "onTextChanged", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, CommonConsts.APM_INNER_EVENT_COST_START, "lengthBefore", "lengthAfter", "onTextEffectFinished", "onTextEffectStarted", "onTextEffectStopped", "resetCharacterSampleStatsForTest", "resetCharacterSampleStatsForTest$OUITextEffects_standardRelease", "sampleCurrentEffectFrame", "Lcom/obric/oui/texteffects/runtime/TextEffectFrame;", "setDebugAnimationDurationScale", "scale", "setTextEffectPlayTime", "startTextEffect", "restart", "finalText", "stopEffect", "updateTextEffectSnapshots", "Companion", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OProtocolTextEffectTextView extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f14575a = null;

    @Deprecated
    private static final CharSequence m = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14576b;
    private final float c;
    private final float d;
    private String e;
    private float f;
    private boolean g;
    private final Lazy h;
    private final Lazy i;
    private final Lazy j;
    private final Lazy k;
    private final Lazy l;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/texteffects/OProtocolTextEffectTextView$Companion;", "", "()V", "EffectNameNone", "", "UnchangedText", "", "getUnchangedText", "()Ljava/lang/CharSequence;", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002J\u0018\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"com/obric/oui/texteffects/OProtocolTextEffectTextView$Companion$UnchangedText$1", "", XSDatatype.FACET_LENGTH, "", "getLength", "()I", "get", "", "index", "subSequence", "startIndex", "endIndex", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements CharSequence {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f14577a;

        b() {
        }

        public char a(int r1) {
            throw new IndexOutOfBoundsException();
        }

        public int a() {
            return this.f14577a;
        }

        @Override // java.lang.CharSequence
        public final char charAt(int r1) {
            return a(r1);
        }

        @Override // java.lang.CharSequence
        public final int length() {
            return a();
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int r1, int r2) {
            return (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f14575a = new a(null);
        m = (CharSequence) ZeusTransformUtils.preCheckCast(new b(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    public OProtocolTextEffectTextView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OProtocolTextEffectTextView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OProtocolTextEffectTextView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.f14576b = "ProtocolTextEffectView";
        this.c = 72.0f;
        this.d = 0.5f;
        this.e = "none";
        this.f = 1.0f;
        this.h = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OProtocolTextEffectTextView$host$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.i = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OProtocolTextEffectTextView$textRepository$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.j = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OProtocolTextEffectTextView$shaderRepository$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.k = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OProtocolTextEffectTextView$renderEngine$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.l = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OProtocolTextEffectTextView$runtime$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.g = true;
    }

    public /* synthetic */ OProtocolTextEffectTextView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ com.obric.oui.texteffects.a.a a(OProtocolTextEffectTextView r0) {
        return r0.getHost();
    }

    public static /* synthetic */ void a(OProtocolTextEffectTextView r7, u r8, String r9, boolean r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, Object r15) {
        CharSequence r16 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r17 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r18 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L22;
        if ((r14 & 4) == 0) goto L7;
        r10 = false;
    L7:
        boolean r3 = r10;
        if ((r14 & 8) == 0) goto L10;
        CharSequence r4 = null;
    L12:
        if ((r14 & 16) == 0) goto L14;
        CharSequence r5 = null;
    L16:
        if ((r14 & 32) == 0) goto L18;
        CharSequence r6 = null;
    L19:
        r7.a(r8, r9, r3, r4, r5, r6);
        return;
    L18:
        r6 = r18;
        goto L19
    L14:
        r5 = r17;
        goto L16
    L10:
        r4 = r16;
        goto L12
    L22:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startTextEffect");
    }

    public static /* synthetic */ void a(OProtocolTextEffectTextView r2, CharSequence r3, CharSequence r4, CharSequence r5, int r6, Object r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L19;
        if ((r6 & 1) == 0) goto L11;
        l r11 = r2.getRuntime().a();
        if (r11 != null) goto L9;
        r8 = null;
        goto L11
    L9:
        r8 = r11.c();
    L11:
        if ((r6 & 2) == 0) goto L14;
        r9 = m;
    L14:
        if ((r6 & 4) == 0) goto L16;
        r10 = m;
    L16:
        r2.a(r8, r9, r10);
        return;
    L19:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateTextEffectSnapshots");
    }

    public static final /* synthetic */ void a(OProtocolTextEffectTextView r0, String r1) {
        r0.e = r1;
    }

    public static final /* synthetic */ com.obric.oui.texteffects.render.l b(OProtocolTextEffectTextView r0) {
        return r0.getTextRepository();
    }

    public static final /* synthetic */ k c(OProtocolTextEffectTextView r0) {
        return r0.getShaderRepository();
    }

    private final com.obric.oui.texteffects.a.a getHost() {
        return (com.obric.oui.texteffects.a.a) ZeusTransformUtils.preCheckCast(this.h.getValue(), com.obric.oui.texteffects.a.a.class, "com.obric.memorydata.plugin");
    }

    private final j getRenderEngine() {
        return (j) ZeusTransformUtils.preCheckCast(this.k.getValue(), j.class, "com.obric.memorydata.plugin");
    }

    private final com.obric.oui.texteffects.runtime.k getRuntime() {
        return (com.obric.oui.texteffects.runtime.k) ZeusTransformUtils.preCheckCast(this.l.getValue(), com.obric.oui.texteffects.runtime.k.class, "com.obric.memorydata.plugin");
    }

    private final k getShaderRepository() {
        return (k) ZeusTransformUtils.preCheckCast(this.j.getValue(), k.class, "com.obric.memorydata.plugin");
    }

    private final com.obric.oui.texteffects.render.l getTextRepository() {
        return (com.obric.oui.texteffects.render.l) ZeusTransformUtils.preCheckCast(this.i.getValue(), com.obric.oui.texteffects.render.l.class, "com.obric.memorydata.plugin");
    }

    public final void a(u r3, String r4, boolean r5, CharSequence r6, CharSequence r7, CharSequence r8) {
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "spec");
        Intrinsics.checkNotNullParameter(r4, "effectName");
        getTextRepository().a(r10, r11);
        getTextRepository().a(r3);
        getRuntime().a(this.f);
        getRuntime().a(new i(r3, r4, r5, r9));
        this.e = r4;
        if (getWidth() <= 0) goto L5;
    L6:
        getRenderEngine().a(r3);
    L7:
        a(r4, r3);
        getRuntime().b();
        invalidate();
        return;
    L5:
        if (getMeasuredWidth() <= 0) goto L7;
        goto L6
    }

    public final void a(CharSequence r3, CharSequence r4, CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        getRuntime().a(r6);
        CharSequence r9 = m;
        if (r7 == r9) goto L5;
        getTextRepository().a(r7);
    L5:
        if (r8 == r9) goto L7;
        getTextRepository().b(r8);
    L7:
        invalidate();
    }

    public void a(String r1, long r2, u r4) {
        Intrinsics.checkNotNullParameter(r1, "effectName");
        Intrinsics.checkNotNullParameter(r4, "spec");
    }

    public void a(String r1, u r2) {
        Intrinsics.checkNotNullParameter(r1, "effectName");
        Intrinsics.checkNotNullParameter(r2, "spec");
    }

    public void f() {
        getRuntime().c();
        getTextRepository().b();
        getTextRepository().d();
        getShaderRepository().a();
        this.e = "none";
        g();
        invalidate();
    }

    public void g() {
    }

    public final String getActiveEffectName() {
        return this.e;
    }

    public float getBlurFilterCacheGranularityPx() {
        return this.d;
    }

    public final long getCurrentEffectPlayTimeMs() {
        l r2 = getRuntime().a();
        if (r2 != null) goto L6;
        return 0;
    L6:
        return r2.d();
    }

    public final u getCurrentTextEffectSpec() {
        l r0 = getRuntime().a();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.a();
    }

    public final float getDebugAnimationDurationScale() {
        return this.f;
    }

    public String getLogTag() {
        return this.f14576b;
    }

    public float getMaxBlurRadiusDp() {
        return this.c;
    }

    public void h() {
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        f();
        getShaderRepository().b();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        l r0 = getRuntime().a();
        if (r0 != null) goto L6;
        super.onDraw(r3);
        return;
    L6:
        f r1 = getRuntime().d();
        if (r1 != null) goto L9;
        return;
    L9:
        getRenderEngine().a(r3, r0.a(), r1);
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.g == false) goto L6;
        getTextRepository().c();
        getShaderRepository().a();
        return;
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence r3, int r4, int r5, int r6) {
        super.onTextChanged((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4, r5, r6);
        if (this.g == false) goto L6;
        getTextRepository().a();
        return;
    }

    public void setDebugAnimationDurationScale(float r3) {
        if (Float.isNaN(r3) == false) goto L5;
    L8:
        float r4 = 1.0f;
    L10:
        if (this.f != r4) goto L12;
        boolean r0 = true;
    L13:
        if (r0 == false) goto L15;
        return;
    L15:
        this.f = r4;
        getRuntime().a(r4);
        return;
    L12:
        r0 = false;
        goto L13
    L5:
        if (Float.isInfinite(r3) == true) goto L8;
        r4 = RangesKt.coerceIn(r3, 0.1f, 10.0f);
        goto L10
    }

    public void setTextEffectPlayTime(long r2) {
        getRuntime().a(r2);
        invalidate();
    }
}
