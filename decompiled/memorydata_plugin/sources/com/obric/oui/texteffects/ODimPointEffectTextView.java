package com.obric.oui.texteffects;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.oui.texteffects.core.j;
import com.obric.oui.texteffects.core.k;
import com.obric.oui.texteffects.core.l;
import com.obric.oui.texteffects.core.n;
import com.obric.oui.texteffects.core.u;
import com.obric.oui.texteffects.runtime.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u0000 >2\u00020\u0001:\u0004>?@AB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u001bJ \u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0014J\b\u0010%\u001a\u00020 H\u0014J\u0018\u0010&\u001a\u00020 2\u0006\u0010!\u001a\u00020\f2\u0006\u0010#\u001a\u00020$H\u0014J\b\u0010'\u001a\u00020 H\u0014J\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u0017H\u0016J\u000e\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020\nJ\u0010\u0010,\u001a\u00020 2\b\u0010-\u001a\u0004\u0018\u00010\u0010J\u0012\u0010.\u001a\u00020 2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0010J\u0010\u00100\u001a\u00020 2\b\u0010-\u001a\u0004\u0018\u00010\u0010J\u0012\u00101\u001a\u00020 2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0010J\u000e\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020\u0010J\u0006\u00104\u001a\u00020 J\u000e\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020\u0010J\u000e\u00107\u001a\u00020 2\u0006\u00108\u001a\u00020\u0010J\u000e\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020\u0010J\b\u0010;\u001a\u00020 H\u0016J\b\u0010<\u001a\u00020 H\u0002J\f\u0010=\u001a\u00020\n*\u00020\fH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointEffectTextView;", "Lcom/obric/oui/texteffects/OProtocolTextEffectTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activeMode", "Lcom/obric/oui/texteffects/ODimPointEffectTextView$DimPointMode;", "logTag", "", "getLogTag", "()Ljava/lang/String;", "pendingRewriteText", "", "pendingTextType", "Lcom/obric/oui/texteffects/ODimPointEffectTextView$PendingTextType;", "promptExitGenerateText", "rewritePhase", "Lcom/obric/oui/texteffects/ODimPointEffectTextView$RewritePhase;", "currentPendingGradientAlpha", "", "currentRewritePlayTimeMs", "", "isContentPending", "", "isPromptPending", "isRewriteEnteringNewText", "isRewriteExitingOldText", "onEffectFrameUpdated", "", "effectName", "playTimeMs", "spec", "Lcom/obric/oui/texteffects/core/TextEffectSpec;", "onTextEffectFinished", "onTextEffectStarted", "onTextEffectStopped", "setDebugAnimationDurationScale", "scale", "setDimPointMode", "mode", "setTextWithEffect", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "startContentPending", "contentText", "startDimPointTextEffect", "startGenerate", "startGenerateFromPromptPending", "actualText", "startPending", "startPromptPending", "promptText", "startPromptTextSwitch", "newPromptText", "startRewrite", "newText", "stopEffect", "updateRewritePhase", "toDimPointMode", "Companion", "DimPointMode", "PendingTextType", "RewritePhase", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ODimPointEffectTextView extends OProtocolTextEffectTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f14563a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DimPointMode f14564b;
    private PendingTextType c;
    private CharSequence d;
    private RewritePhase e;
    private CharSequence f;
    private final String g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointEffectTextView$DimPointMode;", "", "(Ljava/lang/String;I)V", "NONE", "PENDING", "PROMPT_EXIT_TO_GENERATE", "PROMPT_SWITCH", "GENERATE", "REWRITE", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum DimPointMode extends Enum<DimPointMode> {
        private static final /* synthetic */ DimPointMode[] $VALUES = null;
        public static final DimPointMode GENERATE = null;
        public static final DimPointMode NONE = null;
        public static final DimPointMode PENDING = null;
        public static final DimPointMode PROMPT_EXIT_TO_GENERATE = null;
        public static final DimPointMode PROMPT_SWITCH = null;
        public static final DimPointMode REWRITE = null;

        private static final /* synthetic */ DimPointMode[] $values() {
            return new DimPointMode[]{NONE, PENDING, PROMPT_EXIT_TO_GENERATE, PROMPT_SWITCH, GENERATE, REWRITE};
        }

        static {
            NONE = new DimPointMode("NONE", 0);
            PENDING = new DimPointMode("PENDING", 1);
            PROMPT_EXIT_TO_GENERATE = new DimPointMode("PROMPT_EXIT_TO_GENERATE", 2);
            PROMPT_SWITCH = new DimPointMode("PROMPT_SWITCH", 3);
            GENERATE = new DimPointMode("GENERATE", 4);
            REWRITE = new DimPointMode("REWRITE", 5);
            $VALUES = $values();
        }

        private DimPointMode(String r1, int r2) {
            super(r1, r2);
        }

        public static DimPointMode valueOf(String r2) {
            return (DimPointMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(DimPointMode.class, r2), DimPointMode.class, "com.obric.memorydata.plugin");
        }

        public static DimPointMode[] values() {
            return (DimPointMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DimPointMode[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointEffectTextView$PendingTextType;", "", "(Ljava/lang/String;I)V", "CONTENT", "PROMPT", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum PendingTextType extends Enum<PendingTextType> {
        private static final /* synthetic */ PendingTextType[] $VALUES = null;
        public static final PendingTextType CONTENT = null;
        public static final PendingTextType PROMPT = null;

        private static final /* synthetic */ PendingTextType[] $values() {
            return new PendingTextType[]{CONTENT, PROMPT};
        }

        static {
            CONTENT = new PendingTextType("CONTENT", 0);
            PROMPT = new PendingTextType("PROMPT", 1);
            $VALUES = $values();
        }

        private PendingTextType(String r1, int r2) {
            super(r1, r2);
        }

        public static PendingTextType valueOf(String r2) {
            return (PendingTextType) ZeusTransformUtils.preCheckCast(Enum.valueOf(PendingTextType.class, r2), PendingTextType.class, "com.obric.memorydata.plugin");
        }

        public static PendingTextType[] values() {
            return (PendingTextType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PendingTextType[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointEffectTextView$RewritePhase;", "", "(Ljava/lang/String;I)V", "NONE", "EXITING_OLD_TEXT", "ENTERING_NEW_TEXT", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum RewritePhase extends Enum<RewritePhase> {
        private static final /* synthetic */ RewritePhase[] $VALUES = null;
        public static final RewritePhase ENTERING_NEW_TEXT = null;
        public static final RewritePhase EXITING_OLD_TEXT = null;
        public static final RewritePhase NONE = null;

        private static final /* synthetic */ RewritePhase[] $values() {
            return new RewritePhase[]{NONE, EXITING_OLD_TEXT, ENTERING_NEW_TEXT};
        }

        static {
            NONE = new RewritePhase("NONE", 0);
            EXITING_OLD_TEXT = new RewritePhase("EXITING_OLD_TEXT", 1);
            ENTERING_NEW_TEXT = new RewritePhase("ENTERING_NEW_TEXT", 2);
            $VALUES = $values();
        }

        private RewritePhase(String r1, int r2) {
            super(r1, r2);
        }

        public static RewritePhase valueOf(String r2) {
            return (RewritePhase) ZeusTransformUtils.preCheckCast(Enum.valueOf(RewritePhase.class, r2), RewritePhase.class, "com.obric.memorydata.plugin");
        }

        public static RewritePhase[] values() {
            return (RewritePhase[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RewritePhase[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointEffectTextView$Companion;", "", "()V", "EffectNameGenerate", "", "EffectNamePending", "EffectNamePromptExitToGenerate", "EffectNamePromptSwitch", "EffectNameRewrite", "PendingGradientLayerId", "Tag", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14565a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f14566b = null;

        static {
            int[] r0 = new int[DimPointMode.values().length];
            r0[DimPointMode.PENDING.ordinal()] = 1;
            r0[DimPointMode.GENERATE.ordinal()] = 2;
            r0[DimPointMode.REWRITE.ordinal()] = 3;
            r0[DimPointMode.PROMPT_EXIT_TO_GENERATE.ordinal()] = 4;
            r0[DimPointMode.PROMPT_SWITCH.ordinal()] = 5;
            r0[DimPointMode.NONE.ordinal()] = 6;
            f14565a = r0;
            int[] r1 = new int[RewritePhase.values().length];
            r1[RewritePhase.EXITING_OLD_TEXT.ordinal()] = 1;
            r1[RewritePhase.ENTERING_NEW_TEXT.ordinal()] = 2;
            r1[RewritePhase.NONE.ordinal()] = 3;
            f14566b = r1;
        }
    }

    static {
        f14563a = new a(null);
    }

    public ODimPointEffectTextView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public ODimPointEffectTextView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public ODimPointEffectTextView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.f14564b = DimPointMode.NONE;
        this.c = PendingTextType.CONTENT;
        this.e = RewritePhase.NONE;
        this.g = "DimPointTextView";
    }

    public /* synthetic */ ODimPointEffectTextView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    private final DimPointMode a(String r1) {
        switch(r1.hashCode()) {
            case -1253981585: goto L22;
            case -682587753: goto L18;
            case -208065901: goto L14;
            case 1101148556: goto L10;
            case 1810371957: goto L6;
            default: goto L26;
        };
    L6:
        if (r1.equals("generate") == false) goto L26;
        return DimPointMode.GENERATE;
    L10:
        if (r1.equals("rewrite") == false) goto L26;
        return DimPointMode.REWRITE;
    L14:
        if (r1.equals("prompt_exit_to_generate") == false) goto L26;
        return DimPointMode.PROMPT_EXIT_TO_GENERATE;
    L18:
        if (r1.equals("pending") == false) goto L26;
        return DimPointMode.PENDING;
    L22:
        if (r1.equals("prompt_switch") == false) goto L26;
        return DimPointMode.PROMPT_SWITCH;
    L26:
        return DimPointMode.NONE;
    }

    private final float i() {
        if (this.f14564b == DimPointMode.PENDING) goto L5;
    L32:
        return 0.0f;
    L5:
        if (this.c != PendingTextType.CONTENT) goto L32;
        u r0 = getCurrentTextEffectSpec();
        if (r0 != null) goto L10;
        return 0.0f;
    L10:
        Iterator<l> r1 = r0.d().iterator();
    L12:
        if (r1.hasNext() == false) goto L32;
        l r2 = (l) ZeusTransformUtils.preCheckCast(r1.next(), l.class, "com.obric.memorydata.plugin");
        Iterator<k> r3 = r2.e().iterator();
    L15:
        if (r3.hasNext() == false) goto L12;
        Iterator<j> r5 = ((k) ZeusTransformUtils.preCheckCast(r3.next(), k.class, "com.obric.memorydata.plugin")).b().iterator();
    L18:
        if (r5.hasNext() == false) goto L15;
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5.next(), j.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, j.b.class) == false) goto L18;
        if (Intrinsics.areEqual(r6.a(), "gradient_overlay") == false) goto L18;
        n r4 = ((j.b) ZeusTransformUtils.preCheckCast(r6, j.b.class, "com.obric.memorydata.plugin")).d();
        if (ZeusTransformUtils.instanceOf(r4, n.a.class) == false) goto L27;
        n.a r7 = (n.a) ZeusTransformUtils.preCheckCast(r4, n.a.class, "com.obric.memorydata.plugin");
    L28:
        if (r7 != null) goto L30;
        return 0.0f;
    L30:
        long r8 = getCurrentEffectPlayTimeMs() - r2.b();
        return RangesKt.coerceIn(m.f14709a.a(r7.b(), r8, 0.0f), 0.0f, 0.8f);
    L27:
        r7 = null;
        goto L28
    }

    private final void j() {
        if (this.f14564b == DimPointMode.REWRITE) goto L5;
        RewritePhase r0 = RewritePhase.NONE;
    L9:
        this.e = r0;
        return;
    L5:
        if (getCurrentEffectPlayTimeMs() >= 150) goto L7;
        r0 = RewritePhase.EXITING_OLD_TEXT;
        goto L9
    L7:
        r0 = RewritePhase.ENTERING_NEW_TEXT;
        goto L9
    }

    public final void a() {
        this.c = PendingTextType.CONTENT;
        OProtocolTextEffectTextView.a((OProtocolTextEffectTextView) ZeusTransformUtils.preCheckCast(this, OProtocolTextEffectTextView.class, "com.obric.memorydata.plugin"), com.obric.oui.texteffects.preset.a.f14644a.a(), "pending", false, null, null, null, 60, null);
    }

    public final void a(CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r0 = getText();
        if (r0 != null) goto L5;
        r0 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L5:
        if (r6 != null) goto L7;
        r6 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L7:
        boolean r2 = true;
        if (b() == true) goto L10;
    L16:
        boolean r1 = TextUtils.equals(r0, r6);
        int r3 = r0.length();
        if (r1 == false) goto L23;
        if (r3 == 0) goto L21;
        r2 = false;
    L21:
        if (r2 == false) goto L30;
        f();
        setText(r6);
        return;
    L30:
        return;
    L23:
        if (r3 == 0) goto L26;
        r2 = false;
    L26:
        if (r2 == false) goto L28;
        c(r6);
        return;
    L28:
        d(r6);
        return;
    L10:
        if (r6.length() <= 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L16;
        b(r6);
        return;
    L12:
        r4 = false;
        goto L13
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public void a(String r1, long r2, u r4) {
        Intrinsics.checkNotNullParameter(r1, "effectName");
        Intrinsics.checkNotNullParameter(r4, "spec");
        j();
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public void a(String r2, u r3) {
        Intrinsics.checkNotNullParameter(r2, "effectName");
        Intrinsics.checkNotNullParameter(r3, "spec");
        this.f14564b = a(r2);
        j();
    }

    public final void b(CharSequence r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "actualText");
        if (b() == true) goto L6;
        c(r13);
        return;
    L6:
        this.d = r13;
        OProtocolTextEffectTextView.a((OProtocolTextEffectTextView) ZeusTransformUtils.preCheckCast(this, OProtocolTextEffectTextView.class, "com.obric.memorydata.plugin"), com.obric.oui.texteffects.preset.a.f14644a.b(), "prompt_exit_to_generate", false, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 52, null);
    }

    public final boolean b() {
        if (this.f14564b == DimPointMode.PENDING) goto L5;
    L7:
        return false;
    L5:
        if (this.c != PendingTextType.PROMPT) goto L7;
        return true;
    }

    public final void c(CharSequence r10) {
        CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L5;
        setText(r11);
    L5:
        this.c = PendingTextType.CONTENT;
        this.d = null;
        OProtocolTextEffectTextView.a((OProtocolTextEffectTextView) ZeusTransformUtils.preCheckCast(this, OProtocolTextEffectTextView.class, "com.obric.memorydata.plugin"), com.obric.oui.texteffects.preset.a.f14644a.a(false), "generate", false, getText(), null, null, 52, null);
    }

    public final boolean c() {
        j();
        if (this.e != RewritePhase.EXITING_OLD_TEXT) goto L5;
        return true;
    L5:
        return false;
    }

    public final void d(CharSequence r12) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "newText");
        if (this.f14564b != DimPointMode.REWRITE) goto L12;
        RewritePhase r13 = this.e;
        int r14 = b.f14566b[r13.ordinal()];
        if (r14 != 1) goto L7;
        setText(r8);
        OProtocolTextEffectTextView.a((OProtocolTextEffectTextView) ZeusTransformUtils.preCheckCast(this, OProtocolTextEffectTextView.class, "com.obric.memorydata.plugin"), r8, null, r8, 2, null);
        return;
    L7:
        if (r14 != 2) goto L18;
        this.f = r8;
        return;
    L18:
        return;
    L12:
        CharSequence r15 = getText();
        if (r15 != null) goto L15;
        r15 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L15:
        CharSequence r7 = r15;
        float r16 = i();
        this.c = PendingTextType.CONTENT;
        this.d = null;
        this.f = null;
        setText(r8);
        OProtocolTextEffectTextView.a((OProtocolTextEffectTextView) ZeusTransformUtils.preCheckCast(this, OProtocolTextEffectTextView.class, "com.obric.memorydata.plugin"), com.obric.oui.texteffects.preset.a.f14644a.a(false, r16), "rewrite", false, r8, r7, r8, 4, null);
    }

    public final boolean d() {
        j();
        if (this.e != RewritePhase.ENTERING_NEW_TEXT) goto L5;
        return true;
    L5:
        return false;
    }

    public final long e() {
        return getCurrentEffectPlayTimeMs();
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public void f() {
        super.f();
        this.f14564b = DimPointMode.NONE;
        this.c = PendingTextType.CONTENT;
        this.d = null;
        this.e = RewritePhase.NONE;
        this.f = null;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public void g() {
        this.f14564b = DimPointMode.NONE;
        this.e = RewritePhase.NONE;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public String getLogTag() {
        return this.g;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public void h() {
        DimPointMode r0 = this.f14564b;
        this.f14564b = DimPointMode.NONE;
        this.e = RewritePhase.NONE;
        if (r0 != DimPointMode.PROMPT_EXIT_TO_GENERATE) goto L8;
        CharSequence r1 = this.d;
        this.d = null;
        this.c = PendingTextType.CONTENT;
        if (r1 == null) goto L18;
        c(r1);
        return;
    L18:
        return;
    L8:
        if (r0 != DimPointMode.PROMPT_SWITCH) goto L11;
        this.c = PendingTextType.PROMPT;
        return;
    L11:
        if (r0 != DimPointMode.REWRITE) goto L21;
        CharSequence r2 = this.f;
        this.f = null;
        if (r2 != null) goto L15;
        return;
    L15:
        if (TextUtils.equals(getText(), r2) == true) goto L23;
        d(r2);
        return;
    L23:
        return;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public void setDebugAnimationDurationScale(float r10) {
        float r0 = getDebugAnimationDurationScale();
        super.setDebugAnimationDurationScale(r10);
        if (r0 != getDebugAnimationDurationScale()) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
        return;
    L8:
        if (this.f14564b != DimPointMode.PENDING) goto L12;
        OProtocolTextEffectTextView.a((OProtocolTextEffectTextView) ZeusTransformUtils.preCheckCast(this, OProtocolTextEffectTextView.class, "com.obric.memorydata.plugin"), com.obric.oui.texteffects.preset.a.f14644a.a(), "pending", true, null, null, null, 56, null);
        return;
    L12:
        return;
    L5:
        r11 = false;
        goto L6
    }

    public final void setDimPointMode(DimPointMode r2) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        if (this.f14564b != r2) goto L5;
        return;
    L5:
        f();
        int r3 = b.f14565a[r2.ordinal()];
        if (r3 != 1) goto L8;
        a();
        return;
    L8:
        if (r3 != 2) goto L14;
        c(null);
        return;
    }

    public final void setTextWithEffect(CharSequence r3) {
        a((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }
}
