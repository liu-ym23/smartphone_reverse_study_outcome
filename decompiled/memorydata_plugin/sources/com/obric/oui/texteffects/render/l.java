package com.obric.oui.texteffects.render;

import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.Log;
import android.widget.TextView;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.oui.texteffects.core.TextSource;
import com.obric.oui.texteffects.core.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0019J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J\"\u0010 \u001a\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010!\u001a\u00020\bJ\u0018\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0006\u0010$\u001a\u00020\u0019J\u000e\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020\u0019J\u000e\u0010)\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\rJ\u0018\u0010*\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\u00192\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010.\u001a\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\rJ\u001a\u0010/\u001a\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\f\u00100\u001a\u00020\b*\u00020'H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/obric/oui/texteffects/render/TextEffectTextRepository;", "", "host", "Lcom/obric/oui/texteffects/host/TextViewEffectHost;", "logTag", "", "(Lcom/obric/oui/texteffects/host/TextViewEffectHost;Ljava/lang/String;)V", "applyingInternalText", "", "currentCache", "Lcom/obric/oui/texteffects/render/TextLayoutCache;", "newCache", "newText", "", "oldCache", "oldText", "plainCurrentText", "buildCache", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "layout", "Landroid/text/Layout;", "cacheFor", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/oui/texteffects/core/TextSource;", "clearLayoutCaches", "", "clearOldAndNewCaches", "clearSnapshots", "computeContentWidth", "", "computeStartX", "textWidth", "installForTest", "clearCaches", "isReusable", "cache", "onTextChanged", "prepareCurrentCharacterText", "spec", "Lcom/obric/oui/texteffects/core/TextEffectSpec;", "restorePlainText", "setFinalText", "setInternalText", "bufferType", "Landroid/widget/TextView$BufferType;", "updateNewText", "updateOldText", "updateSnapshots", "requiresCurrentLiveLayoutCharacterEffect", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.oui.texteffects.a.b f14680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14681b;
    private CharSequence c;
    private CharSequence d;
    private m e;
    private m f;
    private m g;
    private CharSequence h;
    private boolean i;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14682a = null;

        static {
            int[] r0 = new int[TextSource.values().length];
            r0[TextSource.Current.ordinal()] = 1;
            r0[TextSource.Old.ordinal()] = 2;
            r0[TextSource.New.ordinal()] = 3;
            f14682a = r0;
        }
    }

    public l(com.obric.oui.texteffects.a.b r3, String r4) {
        com.obric.oui.texteffects.a.b r5 = (com.obric.oui.texteffects.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.texteffects.a.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "host");
        Intrinsics.checkNotNullParameter(r4, "logTag");
        this.f14680a = r5;
        this.f14681b = r4;
        com.obric.oui.texteffects.a r2 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L6;
        Log.d(Intrinsics.stringPlus("OTextEff/", r4), "create TextEffectTextRepository");
        return;
    }

    private final float a(float r4) {
        TextView r0 = this.f14680a.a();
        float r3 = e();
        float r1 = r0.getCompoundPaddingLeft();
        int r2 = r0.getGravity() & 7;
        if (r2 != 1) goto L5;
        float r5 = (r3 - r4) / 2.0f;
    L12:
        return r1 + r5;
    L5:
        if (r2 != 5) goto L7;
    L9:
        r5 = r3 - r4;
        goto L12
    L7:
        if (r2 == 8388613) goto L9;
        return r1;
    }

    public static final /* synthetic */ float a(l r0, float r1) {
        return r0.a(r1);
    }

    private final m a(CharSequence r12, Layout r13) {
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.memorydata.plugin");
        TextView r0 = this.f14680a.a();
        m r1 = n.f14685a.a(r14, this.f14680a.c(), e(), r0.getEllipsize(), r0.getIncludeFontPadding(), (Function1) ZeusTransformUtils.preCheckCast(new TextEffectTextRepository$buildCache$1(this), Function1.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(TextEffectTextRepository$buildCache$2.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), r13);
        com.obric.oui.texteffects.a r2 = com.obric.oui.texteffects.a.f14578a;
        String r11 = this.f14681b;
        if (com.obric.oui.texteffects.a.a() == false) goto L9;
        String r15 = Intrinsics.stringPlus("OTextEff/", r11);
        StringBuilder r16 = new StringBuilder().append("create TextLayoutCache sourceText={").append(r14).append("}, displayText={").append(r1.b()).append("}, width=").append(r1.k()).append(", contentWidth=").append(r1.g()).append(", liveLayout=");
        if (r13 == null) goto L7;
        boolean r17 = true;
    L8:
        Log.d(r15, r16.append(r17).toString());
        goto L9
    L7:
        r17 = false;
    L9:
        return r1;
    }

    private final void a(CharSequence r3, TextView.BufferType r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.i = true;
        this.f14680a.a(r5, r4);     // Catch: Throwable -> L6
        this.i = false;
        return;
    L6:
        th = move-exception;
        this.i = false;
        throw th;
    }

    private final boolean a(m r5, CharSequence r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        TextView r0 = this.f14680a.a();
        if (Intrinsics.areEqual(r5.a(), r7) == false) goto L20;
        if (r5.g() != e()) goto L7;
        boolean r8 = true;
    L8:
        if (r8 == false) goto L20;
        if (r5.h() != r0.getEllipsize()) goto L20;
        if (r5.i() != this.f14680a.c().getTextSize()) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L20;
        if (r5.j() != r0.getIncludeFontPadding()) goto L20;
        return true;
    L14:
        r4 = false;
        goto L15
    L7:
        r8 = false;
    L20:
        return false;
    }

    private final boolean b(u r8) {
        Iterator<com.obric.oui.texteffects.core.l> r7 = r8.d().iterator();
    L4:
        if (r7.hasNext() == false) goto L22;
        Iterator<com.obric.oui.texteffects.core.k> r9 = ((com.obric.oui.texteffects.core.l) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.oui.texteffects.core.l.class, "com.obric.memorydata.plugin")).e().iterator();
    L7:
        if (r9.hasNext() == false) goto L4;
        Iterator<com.obric.oui.texteffects.core.j> r2 = ((com.obric.oui.texteffects.core.k) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.oui.texteffects.core.k.class, "com.obric.memorydata.plugin")).b().iterator();
    L10:
        if (r2.hasNext() == false) goto L7;
        com.obric.oui.texteffects.core.j r4 = (com.obric.oui.texteffects.core.j) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.oui.texteffects.core.j.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.texteffects.core.j.b.class) == true) goto L14;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == false) goto L10;
        return true;
    L14:
        if (((com.obric.oui.texteffects.core.j.b) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.texteffects.core.j.b.class, "com.obric.memorydata.plugin")).c() != TextSource.Current) goto L18;
        if (((com.obric.oui.texteffects.core.j.b) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.texteffects.core.j.b.class, "com.obric.memorydata.plugin")).g() == null) goto L18;
        r5 = true;
        goto L19
    L22:
        return false;
    }

    private final float e() {
        TextView r0 = this.f14680a.a();
        return RangesKt.coerceAtLeast((this.f14680a.e() - r0.getCompoundPaddingLeft()) - r0.getCompoundPaddingRight(), 0.0f);
    }

    public final m a(TextSource r6) {
        Intrinsics.checkNotNullParameter(r6, AILabCheckPermissionTask.KEY_SOURCE);
        int r7 = a.f14682a[r6.ordinal()];
        m r3 = null;
        if (r7 != 1) goto L5;
        CharSequence r8 = this.h;
        if (r8 != null) goto L40;
        r8 = this.f14680a.b();
    L40:
        m r0 = this.e;
        if (r0 != null) goto L44;
    L46:
        if (r3 != null) goto L55;
        m r4 = a(r8, this.f14680a.d());
        this.e = r4;
        com.obric.oui.texteffects.a r1 = com.obric.oui.texteffects.a.f14578a;
        String r5 = this.f14681b;
        if (com.obric.oui.texteffects.a.a() == false) goto L56;
        String r9 = Intrinsics.stringPlus("OTextEff/", r5);
        StringBuilder r2 = new StringBuilder();
        String r10 = "build current text cache, text=";
    L21:
        Log.d(r9, r2.append(r10).append(r8).append(", width=").append(r4.k()).toString());
        return r4;
    L56:
        return r4;
    L55:
        return r3;
    L44:
        if (a(r0, r8) == false) goto L46;
        r3 = r0;
        goto L46
    L5:
        if (r7 != 2) goto L7;
        r8 = this.c;
        if (r8 != null) goto L27;
        r8 = this.f14680a.b();
    L27:
        m r11 = this.f;
        if (r11 != null) goto L31;
    L29:
        r11 = null;
    L32:
        if (r11 != null) goto L54;
        r4 = a(r8, null);
        this.f = r4;
        com.obric.oui.texteffects.a r12 = com.obric.oui.texteffects.a.f14578a;
        String r13 = this.f14681b;
        if (com.obric.oui.texteffects.a.a() == false) goto L53;
        r9 = Intrinsics.stringPlus("OTextEff/", r13);
        r2 = new StringBuilder();
        r10 = "build old text cache, text=";
        goto L21
    L53:
        return r4;
    L54:
        return r11;
    L31:
        if (a(r11, r8) == false) goto L29;
    L7:
        if (r7 != 3) goto L23;
        r8 = this.d;
        if (r8 != null) goto L11;
        r8 = this.f14680a.b();
    L11:
        m r14 = this.g;
        if (r14 != null) goto L15;
    L17:
        if (r3 != null) goto L50;
        r4 = a(r8, this.f14680a.d());
        this.g = r4;
        com.obric.oui.texteffects.a r15 = com.obric.oui.texteffects.a.f14578a;
        String r16 = this.f14681b;
        if (com.obric.oui.texteffects.a.a() == false) goto L51;
        r9 = Intrinsics.stringPlus("OTextEff/", r16);
        r2 = new StringBuilder();
        r10 = "build new text cache, text=";
        goto L21
    L51:
        return r4;
    L50:
        return r3;
    L15:
        if (a(r14, r8) == false) goto L17;
        r3 = r14;
        goto L17
    L23:
        throw new NoWhenBranchMatchedException();
    }

    public final void a() {
        if (this.i == false) goto L5;
        return;
    L5:
        this.h = null;
        m r1 = this.e;
        if (r1 == null) goto L9;
        r1.p();
    L9:
        this.e = null;
    }

    public final void a(u r6) {
        Intrinsics.checkNotNullParameter(r6, "spec");
        if (b(r6) == true) goto L6;
        b();
        return;
    L6:
        CharSequence r0 = this.h;
        if (r0 != null) goto L9;
        r0 = this.f14680a.b();
    L9:
        String r1 = r0.toString();
        m r2 = this.e;
        if (r2 != null) goto L13;
    L11:
        r2 = null;
    L14:
        if (r2 != null) goto L17;
        r2 = a((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"), this.f14680a.d());
        this.e = r2;
    L17:
        if (e.f14659a.a(r6) == true) goto L19;
    L27:
        this.h = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
        SpannableString r7 = o.a(r2);
        if (r7 != null) goto L31;
        return;
    L31:
        if (this.f14680a.b() != r7) goto L33;
        return;
    L33:
        a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), TextView.BufferType.SPANNABLE);
        return;
    L19:
        if (r2.f() == false) goto L27;
        r2.p();
        if (this.h == null) goto L23;
    L24:
        a((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"), TextView.BufferType.NORMAL);
    L25:
        this.h = null;
        return;
    L23:
        if (ZeusTransformUtils.instanceOf(this.f14680a.b(), Spanned.class) == false) goto L25;
    L13:
        if (a(r2, (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L11;
        goto L11
    }

    public final void a(CharSequence r3) {
        this.c = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        m r4 = this.f;
        if (r4 == null) goto L6;
        r4.p();
    L6:
        this.f = null;
    }

    public final void a(CharSequence r3, CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        this.c = r5;
        this.d = r6;
        m r7 = this.f;
        if (r7 == null) goto L6;
        r7.p();
    L6:
        m r8 = this.g;
        if (r8 == null) goto L10;
        r8.p();
    L10:
        this.f = null;
        this.g = null;
    }

    public final void b() {
        CharSequence r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        this.h = null;
        m r2 = this.e;
        if (r2 == null) goto L9;
        r2.p();
    L9:
        this.e = null;
        if (ZeusTransformUtils.instanceOf(this.f14680a.b(), Spanned.class) == true) goto L12;
        return;
    L12:
        a(r0, TextView.BufferType.NORMAL);
    }

    public final void b(CharSequence r3) {
        this.d = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        m r4 = this.g;
        if (r4 == null) goto L6;
        r4.p();
    L6:
        this.g = null;
    }

    public final void c() {
        m r0 = this.e;
        if (r0 == null) goto L6;
        r0.p();
    L6:
        m r1 = this.f;
        if (r1 == null) goto L10;
        r1.p();
    L10:
        m r2 = this.g;
        if (r2 == null) goto L14;
        r2.p();
    L14:
        this.e = null;
        this.f = null;
        this.g = null;
    }

    public final void c(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        this.h = null;
        m r1 = this.e;
        if (r1 == null) goto L6;
        r1.p();
    L6:
        this.e = null;
        a(r4, TextView.BufferType.NORMAL);
    }

    public final void d() {
        this.c = null;
        this.d = null;
        m r1 = this.f;
        if (r1 == null) goto L6;
        r1.p();
    L6:
        m r2 = this.g;
        if (r2 == null) goto L10;
        r2.p();
    L10:
        this.f = null;
        this.g = null;
    }
}
