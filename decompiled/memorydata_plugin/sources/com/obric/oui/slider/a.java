package com.obric.oui.slider;

import android.content.Context;
import android.view.View;
import android.widget.SeekBar;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.oui.c.a.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J8\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000fH\u0007J6\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/slider/SeekBarVibrateHelper;", "", "()V", "lastHandledProgress", "", "Ljava/lang/Integer;", "vibrationCountAfterLastUserChangeProgress", "onProgressChanged", "", "context", "Landroid/content/Context;", "seekBar", "Landroid/widget/SeekBar;", "progress", "fromUser", "", "markCount", "isSegmentStyle", "vibrateIfNeeded", "effectId", MemoryInfoSectionEditActivity.KIND_SCENE, "", "useCustomHapticEffect", "view", "Landroid/view/View;", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0776a f14494a = null;
    private static final String d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Integer f14495b;
    private int c;

    /* JADX INFO: renamed from: com.obric.oui.slider.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/slider/SeekBarVibrateHelper$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0776a {
        private C0776a() {
        }

        public /* synthetic */ C0776a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14494a = new C0776a(null);
        d = "SeekBarVibrateHelper";
    }

    public a() {
        this.c = Integer.MAX_VALUE;
    }

    private final void a(Context r3, int r4, String r5, boolean r6, View r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (this.c >= 2) goto L10;
        b.b(d, Intrinsics.stringPlus("vibrateIfNeeded: ", r5));
        if (r6 == false) goto L7;
        com.obric.oui.a.a.a(r8, r4);
    L8:
        this.c++;
        return;
    L7:
        com.obric.oui.a.a.f13272a.a(r7, r4);
        goto L8
    }

    static /* synthetic */ void a(a r6, Context r7, int r8, String r9, boolean r10, View r11, int r12, Object r13) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if ((r12 & 8) == 0) goto L5;
        r10 = true;
    L5:
        boolean r4 = r10;
        if ((r12 & 16) == 0) goto L8;
        r11 = null;
    L8:
        r6.a(r1, r8, r9, r4, r11);
    }

    public final void a(Context r16, SeekBar r17, int r18, boolean r19, int r20, boolean r21) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r17, "seekBar");
        if (r19 == true) goto L6;
        this.f14495b = Integer.valueOf(r18);
        this.c = Integer.MAX_VALUE;
        return;
    L6:
        this.c = 0;
        int r4 = r17.getMin();
        int r5 = r17.getMax();
        if (r18 != r4) goto L10;
        int r2 = 5;
        boolean r6 = false;
        View r7 = null;
        int r8 = 24;
        Object r9 = null;
        String r3 = "hit minProgress";
    L9:
        a(this, r1, r2, r3, r6, r7, r8, r9);
        return;
    L10:
        if (r18 != r5) goto L12;
        r2 = 4;
        r6 = false;
        r7 = null;
        r8 = 24;
        r9 = null;
        r3 = "hit maxProgress";
        goto L9
    L12:
        int r10 = r20 - 1;
        if (r21 == false) goto L49;
        if (r10 > 1) goto L16;
        return;
    L16:
        if (this.f14495b == null) goto L44;
        float r11 = (r5 - r4) / r10;
        if (1 > r10) goto L44;
        int r12 = 1;
    L20:
        int r13 = r12 + 1;
        int r14 = MathKt.roundToInt((r12 * r11) - (r11 / 2)) + r4;
        Integer r15 = this.f14495b;
        Intrinsics.checkNotNull(r15);
        if (r15.intValue() >= r14) goto L24;
        if (r18 < r14) goto L24;
        boolean r110 = true;
    L25:
        Integer r111 = this.f14495b;
        Intrinsics.checkNotNull(r111);
        if (r111.intValue() <= r14) goto L29;
        if (r18 > r14) goto L29;
        boolean r112 = true;
    L30:
        if (r12 == 1) goto L39;
        if (r12 != r10) goto L34;
        r110 = r112;
        goto L39
    L34:
        if (r110 == true) goto L38;
        if (r112 == true) goto L38;
        r110 = false;
    L38:
        r110 = true;
    L39:
        if (r110 == true) goto L40;
        if (r12 == r10) goto L44;
        r12 = r13;
        goto L20
    L40:
        a(r1, 26, "passed boundary: " + r12 + '/' + r10 + ", progress: " + r18, false, (View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.memorydata.plugin"));
    L29:
        r112 = false;
    L24:
        r110 = false;
    L44:
        this.f14495b = Integer.valueOf(r18);
        return;
    }
}
