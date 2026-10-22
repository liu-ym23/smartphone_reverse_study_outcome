package com.bytedance.android.livesdk.interactivity.comment.input.framework;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profit.vip.e;
import com.bytedance.android.livesdk.utils.t2;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.m;
import ec2.g0;
import i40.c;
import i40.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001+B'\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010(\u001a\u00020\u000b¢\u0006\u0004\b)\u0010*J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0014\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R$\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010#\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/framework/InputPanelLayout;", "Landroid/widget/FrameLayout;", "Li40/c;", BuildConfig.FLAVOR, "isPortrait", BuildConfig.FLAVOR, "setIsPortrait", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/comment/input/framework/PanelType;", "panels", "setSupportPanels", BuildConfig.FLAVOR, "<set-?>", "c", "I", "getKeyboardHeight", "()I", "keyboardHeight", BuildConfig.FLAVOR, "i", "Ljava/lang/String;", "getPanelLayoutName", "()Ljava/lang/String;", "setPanelLayoutName", "(Ljava/lang/String;)V", "panelLayoutName", "getSupportKeyboard", "()Z", "supportKeyboard", "getCurrentPanelType", "()Lcom/bytedance/android/livesdk/interactivity/comment/input/framework/PanelType;", "currentPanelType", "Landroid/view/View;", "getCurrentPanelView", "()Landroid/view/View;", "currentPanelView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InputPanelLayout extends FrameLayout implements c {
    public PanelType a;
    public PanelType b;
    public int c;
    public final HashMap<PanelType, View> d;
    public final HashMap<PanelType, u62.c> e;
    public final CopyOnWriteArrayList<a> f;
    public final Set<PanelType> g;
    public boolean h;
    public String i;

    public interface a {
        void a(PanelType r1, PanelType r2);
    }

    public InputPanelLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InputPanelLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final boolean getSupportKeyboard() {
        return this.g.contains(PanelType.KEYBOARD);
    }

    public final View getCurrentPanelView() {
        return this.d.get(getCurrentPanelType());
    }

    public final PanelType getCurrentPanelType() {
        return this.a;
    }

    public final int getKeyboardHeight() {
        return this.c;
    }

    public final String getPanelLayoutName() {
        return this.i;
    }

    public final void setIsPortrait(boolean r1) {
        this.h = r1;
    }

    public final void setPanelLayoutName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.i = r2;
    }

    public final void setSupportPanels(Set<? extends PanelType> r3) {
        Intrinsics.checkNotNullParameter(r3, "panels");
        removeAllViews();
        this.g.clear();
        this.g.add(PanelType.NONE);
        this.g.addAll(r3);
    }

    public final void X6(boolean r5, int r6) {
        if (r5 == false) goto L25;
        int r7 = s1.w();
        int r1 = 0;
        if (this.h == true) goto L8;
        if (r6 < r7) goto L9;
    L10:
        boolean r0 = false;
    L11:
        h.a(this.i + " check keyboard valid: " + r0 + ", is portrait: " + this.h + ", keyboard height: " + r6 + ", screen height: " + r7);
        if (r0 == true) goto L14;
    L17:
        PanelType r8 = this.a;
        PanelType r9 = this.b;
        PanelType r2 = PanelType.KEYBOARD;
        if (r9 != r2) goto L20;
        this.b = PanelType.NONE;
    L20:
        this.a = r2;
        Iterator<Map.Entry<PanelType, View>> r10 = this.d.entrySet().iterator();
    L22:
        if (r10.hasNext() == false) goto L24;
        UtilityKotlinExtentionsKt.t(r10.next().getValue());
        goto L22
    L24:
        UtilityKotlinExtentionsKt.t(this);
        a(r8, getCurrentPanelType());
        return;
    L14:
        if (((Boolean) g0.a.getValue()).booleanValue() == false) goto L16;
        r1 = StatusBarUtil.getStatusBarHeight(getContext());
    L16:
        this.c = r6 - r1;
    L9:
        r0 = true;
        goto L11
    L8:
        if (r6 >= ((r7 / 3) * 2)) goto L10;
    L25:
        PanelType r11 = getCurrentPanelType();
        PanelType r13 = PanelType.KEYBOARD;
        if (r11 != r13) goto L34;
        View r14 = this.d.get(this.b);
        if (r14 == null) goto L30;
        UtilityKotlinExtentionsKt.w(r14);
    L30:
        this.a = this.b;
        this.b = PanelType.NONE;
        UtilityKotlinExtentionsKt.w(this);
        a(r13, getCurrentPanelType());
        return;
    }

    public final void a(PanelType r4, PanelType r5) {
        h.a(this.i + " dispatch panel switch, previous: " + r4.getTypeName() + ", current: " + r5.getTypeName());
        u62.c r0 = this.e.get(r4);
        if (r0 == null) goto L5;
        r0.b();
    L5:
        u62.c r1 = this.e.get(r5);
        if (r1 == null) goto L8;
        r1.a();
    L8:
        Iterator<a> r2 = this.f.iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        a r3 = r2.next();
        View r6 = this.d.get(r4);
        View r7 = this.d.get(r5);
        r3.a(r4, r5);
        goto L10
    }

    public final void b(PanelType r5, EditText r6) {
        Intrinsics.checkNotNullParameter(r5, "panelType");
        if (this.g.contains(r5) == true) goto L6;
        return;
    L6:
        if (getCurrentPanelType() != r5) goto L8;
        return;
    L8:
        PanelType r0 = getCurrentPanelType();
        this.b = r5;
        h.a(this.i + " switch to panel: " + r5.getTypeName() + ", current panel: " + getCurrentPanelType().getTypeName());
        e r1 = yt0.c.l();
        if (r1 == null) goto L17;
        m r2 = r1.isEmojiPanelShow();
        if (r2 == null) goto L17;
        if (r5 != PanelType.EMOJI) goto L15;
        boolean r3 = true;
    L16:
        r2.setValue(Boolean.valueOf(r3));
        goto L17
    L15:
        r3 = false;
    L17:
        int r4 = u62.a.a[r5.ordinal()];
        if (r4 != 1) goto L20;
        PanelType r7 = PanelType.NONE;
        this.a = r7;
        if (getSupportKeyboard() == false) goto L39;
        t2.a(getContext(), r6);
    L39:
        UtilityKotlinExtentionsKt.t(this);
        if (r0 == PanelType.KEYBOARD) goto L45;
        a(r0, r7);
        return;
    L45:
        return;
    L20:
        if (r4 == 2) goto L34;
        u62.c r8 = this.e.get(r5);
        if (r8 == null) goto L43;
        r8.c();
        if (getCurrentPanelType() != PanelType.KEYBOARD) goto L26;
        t2.a(getContext(), r6);
        return;
    L26:
        View r9 = this.d.get(getCurrentPanelType());
        if (r9 == null) goto L29;
        UtilityKotlinExtentionsKt.t(r9);
    L29:
        View r10 = this.d.get(this.b);
        if (r10 == null) goto L32;
        UtilityKotlinExtentionsKt.w(r10);
    L32:
        this.b = PanelType.NONE;
        this.a = r5;
        UtilityKotlinExtentionsKt.w(this);
        a(r0, getCurrentPanelType());
        return;
    L43:
        return;
    L34:
        t2.b(getContext(), r6);
    }

    public InputPanelLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        PanelType r5 = PanelType.NONE;
        this.a = r5;
        this.b = r5;
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new CopyOnWriteArrayList();
        this.g = SetsKt.hashSetOf(new PanelType[]{r5});
        this.i = "PanelLayout";
        b(r5, null);
    }

    public /* synthetic */ InputPanelLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
