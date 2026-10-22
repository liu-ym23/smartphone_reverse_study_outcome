package com.obric.oui.texteffects;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.LruCache;
import com.bytedance.ai.event.MessageIndication;
import com.obric.oui.texteffects.core.BlendSpec;
import com.obric.oui.texteffects.core.EffectProperty;
import com.obric.oui.texteffects.core.TextSource;
import com.obric.oui.texteffects.runtime.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import js.f;
import js.h;
import js.k;
import js.l;
import js.m;
import js.p;
import js.s;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0003\"#$B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001c\u001a\u00020\u00178\u0014X\u0094D¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010!\u001a\u00020\u000f8\u0014X\u0094D¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointEffectTextView;", "Lcom/obric/oui/texteffects/OProtocolTextEffectTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/obric/oui/texteffects/ODimPointEffectTextView$DimPointMode;", "mode", "", "setDimPointMode", "(Lcom/obric/oui/texteffects/ODimPointEffectTextView$DimPointMode;)V", "", "scale", "setDebugAnimationDurationScale", "(F)V", "", MessageIndication.CONTENT_TYPE_TEXT, "setTextWithEffect", "(Ljava/lang/CharSequence;)V", "", "w", "Ljava/lang/String;", "getLogTag", "()Ljava/lang/String;", "logTag", "x", "F", "getMaxBlurRadiusDp", "()F", "maxBlurRadiusDp", "DimPointMode", "PendingTextType", "RewritePhase", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ODimPointEffectTextView extends OProtocolTextEffectTextView {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DimPointMode f14698r;
    public PendingTextType s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CharSequence f14699t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public RewritePhase f14700u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public CharSequence f14701v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f14702w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f14703x;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointEffectTextView$DimPointMode;", "", "NONE", "PENDING", "PROMPT_EXIT_TO_GENERATE", "PROMPT_SWITCH", "GENERATE", "REWRITE", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum DimPointMode extends Enum<DimPointMode> {
        public static final DimPointMode GENERATE = null;
        public static final DimPointMode NONE = null;
        public static final DimPointMode PENDING = null;
        public static final DimPointMode PROMPT_EXIT_TO_GENERATE = null;
        public static final DimPointMode PROMPT_SWITCH = null;
        public static final DimPointMode REWRITE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DimPointMode[] f14704a = null;

        static {
            DimPointMode r5 = new DimPointMode("NONE", 0);
            NONE = r5;
            DimPointMode r10 = new DimPointMode("PENDING", 1);
            PENDING = r10;
            DimPointMode r11 = new DimPointMode("PROMPT_EXIT_TO_GENERATE", 2);
            PROMPT_EXIT_TO_GENERATE = r11;
            DimPointMode r12 = new DimPointMode("PROMPT_SWITCH", 3);
            PROMPT_SWITCH = r12;
            DimPointMode r13 = new DimPointMode("GENERATE", 4);
            GENERATE = r13;
            DimPointMode r14 = new DimPointMode("REWRITE", 5);
            REWRITE = r14;
            f14704a = new DimPointMode[]{r5, r10, r11, r12, r13, r14};
        }

        public static DimPointMode valueOf(String r5) {
            return (DimPointMode) Enum.valueOf(DimPointMode.class, r5);
        }

        public static DimPointMode[] values() {
            return (DimPointMode[]) f14704a.clone();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointEffectTextView$PendingTextType;", "", "CONTENT", "PROMPT", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum PendingTextType extends Enum<PendingTextType> {
        public static final PendingTextType CONTENT = null;
        public static final PendingTextType PROMPT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PendingTextType[] f14705a = null;

        static {
            PendingTextType r5 = new PendingTextType("CONTENT", 0);
            CONTENT = r5;
            PendingTextType r10 = new PendingTextType("PROMPT", 1);
            PROMPT = r10;
            f14705a = new PendingTextType[]{r5, r10};
        }

        public static PendingTextType valueOf(String r5) {
            return (PendingTextType) Enum.valueOf(PendingTextType.class, r5);
        }

        public static PendingTextType[] values() {
            return (PendingTextType[]) f14705a.clone();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointEffectTextView$RewritePhase;", "", "NONE", "EXITING_OLD_TEXT", "ENTERING_NEW_TEXT", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum RewritePhase extends Enum<RewritePhase> {
        public static final RewritePhase ENTERING_NEW_TEXT = null;
        public static final RewritePhase EXITING_OLD_TEXT = null;
        public static final RewritePhase NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RewritePhase[] f14706a = null;

        static {
            RewritePhase r5 = new RewritePhase("NONE", 0);
            NONE = r5;
            RewritePhase r10 = new RewritePhase("EXITING_OLD_TEXT", 1);
            EXITING_OLD_TEXT = r10;
            RewritePhase r11 = new RewritePhase("ENTERING_NEW_TEXT", 2);
            ENTERING_NEW_TEXT = r11;
            f14706a = new RewritePhase[]{r5, r10, r11};
        }

        public static RewritePhase valueOf(String r5) {
            return (RewritePhase) Enum.valueOf(RewritePhase.class, r5);
        }

        public static RewritePhase[] values() {
            return (RewritePhase[]) f14706a.clone();
        }
    }

    @JvmOverloads
    public ODimPointEffectTextView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public final LinearGradient c(ls.c r10, k r11) {
        Intrinsics.checkNotNullParameter(r10, "cache");
        Intrinsics.checkNotNullParameter(r11, "fill");
        float r12 = r10.f19789h;
        if (r12 > 0.01f) goto L6;
        return null;
    L6:
        float r5 = r10.f19790i;
        int[] r13 = ks.b.f19477a;
        Shader.TileMode r14 = Shader.TileMode.CLAMP;
        return new LinearGradient(r5, 0.0f, r5 + r12, 0.0f, r13, ks.b.f19478b, r14);
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public final ls.c d(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.CONTENT_TYPE_TEXT);
        return io.reactivex.exceptions.a.k(r10, getPaint(), e(), getEllipsize(), new ODimPointEffectTextView$buildTextCache$1(this), new ODimPointEffectTextView$buildTextCache$2(this));
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public String getLogTag() {
        return this.f14702w;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public float getMaxBlurRadiusDp() {
        return this.f14703x;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public final void p() {
        this.f14698r = DimPointMode.NONE;
        this.f14700u = RewritePhase.NONE;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public final void r() {
        super.r();
        this.f14698r = DimPointMode.NONE;
        this.s = PendingTextType.CONTENT;
        this.f14699t = null;
        this.f14700u = RewritePhase.NONE;
        this.f14701v = null;
    }

    public final boolean s() {
        if (this.f14698r == DimPointMode.PENDING) goto L5;
    L7:
        return false;
    L5:
        if (this.s != PendingTextType.PROMPT) goto L7;
        return true;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public void setDebugAnimationDurationScale(float r10) {
        float r5 = getDebugAnimationDurationScale();
        super.setDebugAnimationDurationScale(r10);
        if (r5 != getDebugAnimationDurationScale()) goto L6;
        return;
    L6:
        if (this.f14698r != DimPointMode.PENDING) goto L9;
        OProtocolTextEffectTextView.q(this, ks.a.f19474a.h(), "pending", true, null, null, null, 56);
        return;
    }

    public final void setDimPointMode(DimPointMode r10) {
        Intrinsics.checkNotNullParameter(r10, "mode");
        if (this.f14698r != r10) goto L5;
        return;
    L5:
        r();
        int r11 = a.f14726a[r10.ordinal()];
        if (r11 != 1) goto L8;
        this.s = PendingTextType.CONTENT;
        OProtocolTextEffectTextView.q(this, ks.a.f19474a.h(), "pending", false, null, null, null, 60);
        return;
    L8:
        if (r11 != 2) goto L14;
        t(null);
        return;
    }

    public final void setTextWithEffect(CharSequence r5) {
        CharSequence r10 = getText();
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        if (s() == false) goto L13;
        if (r5.length() <= 0) goto L13;
        u(r5);
        return;
    L13:
        if (TextUtils.equals(r10, r5) == false) goto L18;
        if (r10.length() != 0) goto L23;
        r();
        setText(r5);
        return;
    L23:
        return;
    L18:
        if (r10.length() != 0) goto L20;
        t(r5);
        return;
    L20:
        v(r5);
    }

    public final void t(CharSequence r10) {
        if (r10 == null) goto L4;
        setText(r10);
    L4:
        this.s = PendingTextType.CONTENT;
        this.f14699t = null;
        OProtocolTextEffectTextView.q(this, ks.a.f19474a.c(false), "generate", false, getText(), null, null, 52);
    }

    public final void u(CharSequence r17) {
        Intrinsics.checkNotNullParameter(r17, "actualText");
        if (s() == true) goto L6;
        t(r17);
        return;
    L6:
        this.f14699t = r17;
        TextSource r5 = TextSource.Current;
        EffectProperty r10 = EffectProperty.Alpha;
        js.a r11 = ks.a.f19476c;
        Pair[] r12 = {TuplesKt.to(0L, Float.valueOf(1.0f)), TuplesKt.to(150L, Float.valueOf(0.0f))};
        int r13 = 2;
        ArrayList r14 = new ArrayList(2);
        int r15 = 0;
    L7:
        if (r15 >= r13) goto L9;
        Pair r16 = r12[r15];
        r14.add(new m(((Number) r16.getFirst()).longValue(), new h(((Number) r16.getSecond()).floatValue())));
        r15 = r15 + 1;
        r13 = 2;
        goto L7
    L9:
        List r18 = CollectionsKt.listOf(new p(r10, r14, r11));
        OProtocolTextEffectTextView.q(this, new s("oui.dim_point.prompt_pending_exit", 150, null, CollectionsKt.listOf(new f("prompt_pending_exit", 150, CollectionsKt.listOf(new js.d("prompt_text_exit", r5, l.f18471c, BlendSpec.SRC_OVER, r18)))), 10), "prompt_exit_to_generate", false, "", null, null, 52);
    }

    public final void v(CharSequence r12) {
        Intrinsics.checkNotNullParameter(r12, "newText");
        if (this.f14698r != DimPointMode.REWRITE) goto L12;
        int r5 = a.f14727b[this.f14700u.ordinal()];
        if (r5 != 1) goto L7;
        setText(r12);
        CharSequence r10 = this.g;
        this.f = r12;
        this.g = r10;
        this.f14717h = r12;
        this.f14719j = null;
        this.f14720k = null;
        invalidate();
        return;
    L7:
        if (r5 != 2) goto L46;
        this.f14701v = r12;
        return;
    L46:
        return;
    L12:
        CharSequence r11 = getText();
        if (r11 != null) goto L15;
        r11 = "";
    L15:
        CharSequence r13 = r11;
        float r14 = 0.0f;
        if (this.f14698r == DimPointMode.PENDING) goto L18;
    L40:
        this.s = PendingTextType.CONTENT;
        this.f14699t = null;
        this.f14701v = null;
        setText(r12);
        OProtocolTextEffectTextView.q(this, ks.a.f19474a.i(r14, false), "rewrite", false, r12, r13, r12, 4);
        return;
    L18:
        if (this.s != PendingTextType.CONTENT) goto L40;
        s r15 = this.f14716c;
        if (r15 != null) goto L23;
        com.obric.oui.texteffects.runtime.c r16 = null;
    L24:
        if (r16 == null) goto L40;
        Iterator r17 = r16.f14753c.iterator();
    L28:
        if (r17.hasNext() == false) goto L32;
        Object r18 = r17.next();
        if (Intrinsics.areEqual(((com.obric.oui.texteffects.runtime.b) r18).f14742b, "gradient_overlay") == false) goto L28;
    L33:
        com.obric.oui.texteffects.runtime.b r19 = (com.obric.oui.texteffects.runtime.b) r18;
        if (r19 == null) goto L40;
        float r20 = r19.e;
        if (Float.isNaN(r20) == false) goto L39;
        r20 = 0.0f;
    L39:
        r14 = RangesKt.coerceIn(r20, 0.0f, 0.8f);
        goto L40
    L32:
        r18 = null;
        goto L33
    L23:
        LruCache r21 = e.f14755a;
        r16 = e.d(r15, this.e);
        goto L24
    }

    public final void w() {
        if (this.f14698r == DimPointMode.REWRITE) goto L5;
        RewritePhase r5 = RewritePhase.NONE;
    L9:
        this.f14700u = r5;
        return;
    L5:
        if (getCurrentEffectPlayTimeMs() >= 150) goto L7;
        r5 = RewritePhase.EXITING_OLD_TEXT;
        goto L9
    L7:
        r5 = RewritePhase.ENTERING_NEW_TEXT;
        goto L9
    }

    @JvmOverloads
    public ODimPointEffectTextView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ ODimPointEffectTextView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public ODimPointEffectTextView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f14698r = DimPointMode.NONE;
        this.s = PendingTextType.CONTENT;
        this.f14700u = RewritePhase.NONE;
        this.f14702w = "DimPointTextView";
        this.f14703x = 16.0f;
    }
}
