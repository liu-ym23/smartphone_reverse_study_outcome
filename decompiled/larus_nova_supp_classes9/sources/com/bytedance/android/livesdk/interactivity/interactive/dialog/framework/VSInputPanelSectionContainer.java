package com.bytedance.android.livesdk.interactivity.interactive.dialog.framework;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdk.utils.t2;
import com.bytedance.bdlocation.BuildConfig;
import i40.c;
import i40.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import k82.d;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u00021\fB'\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020\u0011¢\u0006\u0004\b/\u00100J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR$\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00118\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R3\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00180\u0017j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0018`\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR7\u0010\"\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0017j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u001f`\u00198\u0006¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001dR\u0014\u0010%\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0013\u0010)\u001a\u0004\u0018\u00010&8F¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/framework/VSInputPanelSectionContainer;", "Landroid/widget/FrameLayout;", "Li40/c;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/framework/VSInputSectionType;", "sections", BuildConfig.FLAVOR, "setSupportSections", BuildConfig.FLAVOR, "block", "setCanBlockTouchEvent", "<set-?>", "b", "Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/framework/VSInputSectionType;", "getCurrentSectionType", "()Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/framework/VSInputSectionType;", "currentSectionType", BuildConfig.FLAVOR, "e", "I", "getKeyboardHeight", "()I", "keyboardHeight", "Ljava/util/HashMap;", "Lk82/d;", "Lkotlin/collections/HashMap;", "h", "Ljava/util/HashMap;", "getSectionProviders", "()Ljava/util/HashMap;", "sectionProviders", "Lk82/c;", "i", "getSectionControllers", "sectionControllers", "getSupportKeyboard", "()Z", "supportKeyboard", "Landroid/view/View;", "getCurrentSectionView", "()Landroid/view/View;", "currentSectionView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSInputPanelSectionContainer extends FrameLayout implements c {
    public static final int k = 0;
    public final Set<VSInputSectionType> a;
    public VSInputSectionType b;
    public VSInputSectionType c;
    public boolean d;
    public int e;
    public k82.a f;
    public final HashMap<VSInputSectionType, View> g;
    public final HashMap<VSInputSectionType, d> h;
    public final HashMap<VSInputSectionType, k82.c> i;
    public final CopyOnWriteArrayList<b> j;

    public static final class a {
    }

    public interface b {
        void a(VSInputSectionType r1, VSInputSectionType r2);
    }

    public VSInputPanelSectionContainer(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VSInputPanelSectionContainer(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    static {
        k = UtilityKotlinExtentionsKt.i(275);
    }

    private final boolean getSupportKeyboard() {
        return this.a.contains(VSInputSectionType.KEYBOARD);
    }

    public final void c() {
        Iterator<Map.Entry<VSInputSectionType, View>> r0 = this.g.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        UtilityKotlinExtentionsKt.t(r0.next().getValue());
        goto L4
    }

    public final View getCurrentSectionView() {
        return this.g.get(this.b);
    }

    public final VSInputSectionType getCurrentSectionType() {
        return this.b;
    }

    public final int getKeyboardHeight() {
        return this.e;
    }

    public final HashMap<VSInputSectionType, k82.c> getSectionControllers() {
        return this.i;
    }

    public final HashMap<VSInputSectionType, d> getSectionProviders() {
        return this.h;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.d == false) goto L6;
        return true;
    L6:
        return super.onInterceptTouchEvent(r2);
    }

    public final void setCanBlockTouchEvent(boolean r1) {
        this.d = r1;
    }

    public final void setSupportSections(Set<? extends VSInputSectionType> r3) {
        Intrinsics.checkNotNullParameter(r3, "sections");
        removeAllViews();
        this.a.clear();
        this.a.add(VSInputSectionType.NONE);
        this.a.addAll(r3);
    }

    public final void X6(boolean r2, int r3) {
        if (r2 == false) goto L22;
        int r0 = 0;
        if (r3 >= s1.w()) goto L6;
        boolean r4 = true;
    L7:
        if (r4 == true) goto L9;
    L18:
        VSInputSectionType r5 = this.b;
        VSInputSectionType r6 = this.c;
        VSInputSectionType r1 = VSInputSectionType.KEYBOARD;
        if (r6 != r1) goto L21;
        this.c = VSInputSectionType.NONE;
    L21:
        this.b = r1;
        c();
        UtilityKotlinExtentionsKt.t(this);
        b(r5, this.b);
        return;
    L9:
        if (((Boolean) VSSettingKeys.LIVE_INPUT_KEYBOARD_HEIGHT_STATUS_BAR_ADJUST.getValue()).booleanValue() == false) goto L12;
        r0 = StatusBarUtil.getStatusBarHeight(getContext());
    L12:
        if (this.e > 0) goto L14;
        this.e = r3 - r0;
    L14:
        k82.a r7 = this.f;
        if (r7 == null) goto L17;
        r7.v();
        e r8 = nq1.d.v;
        Integer r9 = Integer.valueOf(this.e);
        r8.getClass();
        f.d(r8, r9);
        goto L18
    L17:
        e r10 = nq1.d.w;
        Integer r11 = Integer.valueOf(this.e);
        r10.getClass();
        f.d(r10, r11);
        goto L18
    L6:
        r4 = false;
        goto L7
    L22:
        VSInputSectionType r13 = this.b;
        VSInputSectionType r14 = VSInputSectionType.KEYBOARD;
        if (r13 != r14) goto L30;
        View r15 = this.g.get(this.c);
        if (r15 == null) goto L27;
        UtilityKotlinExtentionsKt.w(r15);
    L27:
        this.b = this.c;
        this.c = VSInputSectionType.NONE;
        UtilityKotlinExtentionsKt.w(this);
        b(r14, this.b);
        return;
    }

    public final void a(h82.b r4, d r5) {
        Intrinsics.checkNotNullParameter(r4, "panelBridge");
        Intrinsics.checkNotNullParameter(r5, "provider");
        VSInputSectionType r0 = r5.b();
        View r1 = r5.g(r4);
        if (r1 != null) goto L6;
        return;
    L6:
        if (this.a.contains(r0) == true) goto L10;
        r5.h(r0, r1);
        return;
    L10:
        if (this.g.get(r0) == null) goto L12;
        return;
    L12:
        this.f = r4;
        this.h.put(r0, r5);
        this.g.put(r0, r1);
        this.i.put(r0, r5.c());
        addView(r1);
        r1.setVisibility(8);
    }

    public final void b(VSInputSectionType r4, VSInputSectionType r5) {
        d r0 = this.h.get(r5);
        if (r0 == null) goto L5;
        r0.e();
    L5:
        d r1 = this.h.get(r4);
        if (r1 == null) goto L8;
        r1.a();
    L8:
        Iterator<b> r2 = this.j.iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        b r3 = r2.next();
        View r6 = this.g.get(r4);
        View r7 = this.g.get(r5);
        r3.a(r4, r5);
        goto L10
    }

    public VSInputPanelSectionContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        VSInputSectionType r5 = VSInputSectionType.NONE;
        this.a = SetsKt.hashSetOf(new VSInputSectionType[]{r5});
        this.b = r5;
        this.c = r5;
        this.g = new HashMap();
        this.h = new HashMap();
        this.i = new HashMap();
        this.j = new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        d(this, r5, null, 4);
    }

    public /* synthetic */ VSInputPanelSectionContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static void d(VSInputPanelSectionContainer r4, VSInputSectionType r5, EditText r6, int r7) {
        EditText r1 = null;
        if ((r7 & 2) == 0) goto L6;
        r6 = null;
    L6:
        if ((r7 & 4) == 0) goto L8;
        boolean r8 = true;
    L9:
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "sectionType");
        if (r4.a.contains(r5) == false) goto L43;
        VSInputSectionType r2 = r4.b;
        if (r2 == r5) goto L44;
        r4.c = r5;
        if (r6 != null) goto L20;
        k82.a r9 = r4.f;
        if (r9 == null) goto L21;
        r1 = r9.a;
    L21:
        h.a("switch to section: " + r5.getTypeName() + ", current panel: " + r4.b.getTypeName());
        int r10 = k82.b.a[r5.ordinal()];
        if (r10 != 1) goto L24;
        r4.b = VSInputSectionType.NONE;
        if (r4.getSupportKeyboard() == false) goto L38;
        t2.a(r4.getContext(), r1);
    L38:
        UtilityKotlinExtentionsKt.t(r4);
        return;
    L24:
        if (r10 != 2) goto L26;
        t2.b(r4.getContext(), r1);
        return;
    L26:
        if (r4.b != VSInputSectionType.KEYBOARD) goto L28;
        t2.a(r4.getContext(), r1);
        return;
    L28:
        r4.c();
        if (r8 == false) goto L33;
        View r11 = r4.g.get(r4.c);
        if (r11 == null) goto L33;
        UtilityKotlinExtentionsKt.w(r11);
    L33:
        r4.c = VSInputSectionType.NONE;
        r4.b = r5;
        UtilityKotlinExtentionsKt.w(r4);
        r4.b(r2, r5);
        return;
    L20:
        r1 = r6;
        goto L21
    L44:
        return;
    L43:
        return;
    L8:
        r8 = false;
        goto L9
    }
}
