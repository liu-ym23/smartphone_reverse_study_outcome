package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.t2;
import com.bytedance.bdlocation.BuildConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u00031\f2B'\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020\u0011¢\u0006\u0004\b/\u00100J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR$\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00118\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015RC\u0010\u001e\u001a.\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00180\u0017j\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0018`\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR7\u0010\"\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0017j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u001f`\u00198\u0006¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001dR\u0014\u0010%\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0013\u0010)\u001a\u0004\u0018\u00010&8F¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/InputPanelSectionContainer;", "Landroid/widget/FrameLayout;", "Li40/c;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/InputSectionType;", "sections", BuildConfig.FLAVOR, "setSupportSections", BuildConfig.FLAVOR, "block", "setCanBlockTouchEvent", "<set-?>", "b", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/InputSectionType;", "getCurrentSectionType", "()Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/InputSectionType;", "currentSectionType", BuildConfig.FLAVOR, "f", "I", "getKeyboardHeight", "()I", "keyboardHeight", "Ljava/util/HashMap;", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/k;", "Lkotlin/collections/HashMap;", "i", "Ljava/util/HashMap;", "getSectionProviders", "()Ljava/util/HashMap;", "sectionProviders", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/j;", "j", "getSectionControllers", "sectionControllers", "getSupportKeyboard", "()Z", "supportKeyboard", "Landroid/view/View;", "getCurrentSectionView", "()Landroid/view/View;", "currentSectionView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "c", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InputPanelSectionContainer extends FrameLayout implements i40.c {
    public static final int m = 0;
    public static final Set<InputSectionType> n = null;
    public final Set<InputSectionType> a;
    public InputSectionType b;
    public InputSectionType c;
    public InputSectionType d;
    public boolean e;
    public int f;
    public g g;
    public final HashMap<InputSectionType, View> h;
    public final HashMap<InputSectionType, k<?, ?>> i;
    public final HashMap<InputSectionType, j> j;
    public final CopyOnWriteArrayList<c> k;
    public final CopyOnWriteArrayList<b> l;

    public static final class a {
    }

    public interface b {
        void a();
    }

    public interface c {
        void a(InputSectionType r1, InputSectionType r2);
    }

    public InputPanelSectionContainer(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InputPanelSectionContainer(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    static {
        m = UtilityKotlinExtentionsKt.i(275);
        n = SetsKt.setOf(new InputSectionType[]{InputSectionType.DANMAKU, InputSectionType.CONTENT, InputSectionType.CONTROL_PORTRAIT, InputSectionType.SEND_PORTRAIT, InputSectionType.MENTION, InputSectionType.MORE});
    }

    private final boolean getSupportKeyboard() {
        return this.a.contains(InputSectionType.KEYBOARD);
    }

    public final void d() {
        Iterator<Map.Entry<InputSectionType, View>> r0 = this.h.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        UtilityKotlinExtentionsKt.t(r0.next().getValue());
        goto L4
    }

    public final View getCurrentSectionView() {
        return this.h.get(this.b);
    }

    public final InputSectionType getCurrentSectionType() {
        return this.b;
    }

    public final int getKeyboardHeight() {
        return this.f;
    }

    public final HashMap<InputSectionType, j> getSectionControllers() {
        return this.j;
    }

    public final HashMap<InputSectionType, k<?, ?>> getSectionProviders() {
        return this.i;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.e == false) goto L6;
        return true;
    L6:
        return super.onInterceptTouchEvent(r2);
    }

    public final void setCanBlockTouchEvent(boolean r1) {
        this.e = r1;
    }

    public final void setSupportSections(Set<? extends InputSectionType> r3) {
        Intrinsics.checkNotNullParameter(r3, "sections");
        removeAllViews();
        this.a.clear();
        this.a.add(InputSectionType.NONE);
        this.a.addAll(r3);
    }

    public final void X6(boolean r2, int r3) {
        if (r2 == true) goto L5;
        InputSectionType r4 = this.b;
        InputSectionType r5 = InputSectionType.KEYBOARD;
        if (r4 != r5) goto L27;
        View r6 = this.h.get(this.c);
        if (r6 == null) goto L24;
        UtilityKotlinExtentionsKt.w(r6);
    L24:
        this.b = this.c;
        this.c = InputSectionType.NONE;
        UtilityKotlinExtentionsKt.w(this);
        b(r5, this.b);
        return;
    L27:
        return;
    L5:
        if (r3 >= s1.w()) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == false) goto L15;
        this.f = r3;
        g r8 = this.g;
        if (r8 != null) goto L12;
    L14:
        com.bytedance.android.livesdk.sharedpref.e<Integer> r9 = l42.a.n;
        Integer r10 = Integer.valueOf(this.f);
        r9.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r9, r10);
        goto L15
    L12:
        if (r8.n0() != true) goto L14;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r11 = l42.a.m;
        Integer r13 = Integer.valueOf(this.f);
        r11.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r11, r13);
    L15:
        InputSectionType r14 = this.b;
        InputSectionType r15 = this.c;
        InputSectionType r0 = InputSectionType.KEYBOARD;
        if (r15 != r0) goto L18;
        this.c = InputSectionType.NONE;
    L18:
        this.b = r0;
        d();
        UtilityKotlinExtentionsKt.t(this);
        b(r14, this.b);
        return;
    L7:
        r7 = false;
        goto L8
    }

    public final void a(g r3, k<?, ?> r4) {
        Intrinsics.checkNotNullParameter(r3, "panelBridge");
        Intrinsics.checkNotNullParameter(r4, "provider");
        InputSectionType r0 = r4.b();
        if (this.a.contains(r0) == true) goto L6;
        return;
    L6:
        if (this.h.get(r0) == null) goto L8;
        return;
    L8:
        this.g = r3;
        this.i.put(r0, r4);
        if (n.contains(r0) == false) goto L15;
        View r5 = r4.h(r3);
        if (r5 != null) goto L13;
        return;
    L13:
        this.j.put(r0, r4.c());
        this.h.put(r0, r5);
        addView(r5);
        r5.setVisibility(8);
        return;
    }

    public final void b(InputSectionType r4, InputSectionType r5) {
        k<?, ?> r0 = this.i.get(r5);
        if (r0 == null) goto L5;
        r0.e();
    L5:
        k<?, ?> r1 = this.i.get(r4);
        if (r1 == null) goto L8;
        r1.a();
    L8:
        Iterator<c> r2 = this.k.iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        c r3 = r2.next();
        View r6 = this.h.get(r4);
        View r7 = this.h.get(r5);
        r3.a(r4, r5);
        goto L10
    }

    public InputPanelSectionContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        InputSectionType r5 = InputSectionType.NONE;
        this.a = SetsKt.hashSetOf(new InputSectionType[]{r5});
        this.b = r5;
        this.c = r5;
        this.d = r5;
        this.h = new HashMap();
        this.i = new HashMap();
        this.j = new HashMap();
        this.k = new CopyOnWriteArrayList();
        this.l = new CopyOnWriteArrayList();
        e(this, r5, null, false, 4);
    }

    public final void c(InputSectionType r3, EditText r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "sectionType");
        if (this.a.contains(r3) == true) goto L6;
        return;
    L6:
        if (this.b != r3) goto L8;
        return;
    L8:
        if (r5 == false) goto L19;
        this.d = r3;
        View r6 = this.h.get(r3);
        if (r6 == null) goto L12;
        a1.k(r6, getHeight());
    L12:
        if (r6 == null) goto L14;
        r6.bringToFront();
    L14:
        View r7 = this.h.get(this.d);
        if (r7 == null) goto L17;
        UtilityKotlinExtentionsKt.w(r7);
    L17:
        if (r4 == null) goto L25;
        r4.setClickable(false);
    L25:
        InputSectionType r8 = this.b;
        InputSectionType r9 = this.d;
        HashMap<InputSectionType, k<?, ?>> r0 = this.i;
        if (r5 == false) goto L28;
        InputSectionType r1 = r9;
    L29:
        k<?, ?> r2 = r0.get(r1);
        if (r2 == null) goto L32;
        r2.g(r5);
    L32:
        Iterator<b> r10 = this.l.iterator();
    L34:
        if (r10.hasNext() == false) goto L36;
        b r11 = r10.next();
        View r13 = this.h.get(r8);
        View r14 = this.h.get(r9);
        r11.a();
        goto L34
    L36:
        return;
    L28:
        r1 = r8;
        goto L29
    L19:
        View r15 = this.h.get(this.d);
        if (r15 == null) goto L22;
        UtilityKotlinExtentionsKt.t(r15);
    L22:
        this.d = InputSectionType.NONE;
        if (r4 == null) goto L25;
        r4.setClickable(true);
        goto L25
    }

    public /* synthetic */ InputPanelSectionContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static void e(InputPanelSectionContainer r3, InputSectionType r4, EditText r5, boolean r6, int r7) {
        EditText r1 = null;
        if ((r7 & 2) == 0) goto L6;
        r5 = null;
    L6:
        if ((r7 & 4) == 0) goto L8;
        r6 = true;
    L8:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "sectionType");
        if (r3.a.contains(r4) == false) goto L52;
        InputSectionType r8 = r3.b;
        if (r8 == r4) goto L53;
        r3.c = r4;
        if (r5 != null) goto L19;
        g r9 = r3.g;
        if (r9 == null) goto L20;
        r1 = r9.a;
    L20:
        i40.h.c("switch to section: " + r4.getTypeName() + ", current panel: " + r3.b.getTypeName(), true);
        i40.h.d = r4.getTypeName();
        int r10 = i.a[r4.ordinal()];
        if (r10 != 1) goto L23;
        r3.b = InputSectionType.NONE;
        if (r3.getSupportKeyboard() == false) goto L47;
        t2.a(r3.getContext(), r1);
    L47:
        UtilityKotlinExtentionsKt.t(r3);
        return;
    L23:
        if (r10 != 2) goto L25;
        t2.b(r3.getContext(), r1);
        i40.h.d = "keyboard";
        return;
    L25:
        if (r3.h.get(r4) != null) goto L35;
        k<?, ?> r11 = r3.i.get(r4);
        if (r11 == null) goto L35;
        g r0 = r3.g;
        if (r0 == null) goto L35;
        View r2 = r11.h(r0);
        if (r2 == null) goto L54;
        r3.j.put(r4, r11.c());
        r3.h.put(r4, r2);
        r3.addView(r2);
        r2.setVisibility(8);
        goto L35
    L54:
        return;
    L35:
        if (r3.b != InputSectionType.KEYBOARD) goto L37;
        t2.a(r3.getContext(), r1);
        return;
    L37:
        r3.d();
        if (r6 == false) goto L42;
        View r13 = r3.h.get(r3.c);
        if (r13 == null) goto L42;
        UtilityKotlinExtentionsKt.w(r13);
    L42:
        r3.c = InputSectionType.NONE;
        r3.b = r4;
        UtilityKotlinExtentionsKt.w(r3);
        r3.b(r8, r4);
        return;
    L19:
        r1 = r5;
        goto L20
    L53:
        return;
    }
}
