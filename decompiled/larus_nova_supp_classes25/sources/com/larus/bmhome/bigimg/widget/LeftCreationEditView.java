package com.larus.bmhome.bigimg.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.j0;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 E2\u00020\u0001:\u0002DEB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010(\u001a\u00020)H\u0002J\f\u0010*\u001a\u00020)*\u00020+H\u0002J\b\u0010,\u001a\u00020)H\u0002J]\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u00010 2\b\b\u0002\u00101\u001a\u00020 2\b\b\u0002\u00102\u001a\u00020 2\b\b\u0002\u00103\u001a\u00020 2\b\b\u0002\u00104\u001a\u00020 2\b\b\u0002\u00105\u001a\u00020 2\n\b\u0002\u00106\u001a\u0004\u0018\u000107¢\u0006\u0002\u00108J\u0018\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020 J\u0016\u0010=\u001a\u00020)2\u0006\u0010:\u001a\u00020;2\u0006\u0010>\u001a\u00020 JS\u0010?\u001a\u00020)2\n\b\u0002\u00100\u001a\u0004\u0018\u00010 2\b\b\u0002\u00101\u001a\u00020 2\b\b\u0002\u00102\u001a\u00020 2\b\b\u0002\u00103\u001a\u00020 2\b\b\u0002\u00104\u001a\u00020 2\u0006\u00105\u001a\u00020 2\b\u00106\u001a\u0004\u0018\u000107H\u0002¢\u0006\u0002\u0010@J\u001c\u0010A\u001a\u00020 2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u00106\u001a\u0004\u0018\u000107H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001f\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010!R#\u0010\"\u001a\n $*\u0004\u0018\u00010#0#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0010\u001a\u0004\b%\u0010&¨\u0006F"}, d2 = {"Lcom/larus/bmhome/bigimg/widget/LeftCreationEditView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "moreView", "Lcom/larus/bmhome/bigimg/widget/LeftCreationEditItemView;", "shareView", "getShareView", "()Lcom/larus/bmhome/bigimg/widget/LeftCreationEditItemView;", "shareView$delegate", "Lkotlin/Lazy;", "imageEditView", "gotoVideoEdiView", "videoExtendView", "sharpnessEditView", "expandEditView", "eraseEditView", "remoteFunctionConfig", "Lcom/larus/platform/model/creation/EditFunctionArea;", "getRemoteFunctionConfig", "()Lcom/larus/platform/model/creation/EditFunctionArea;", "remoteFunctionConfig$delegate", "localFunctionConfig", "getLocalFunctionConfig", "localFunctionConfig$delegate", "isBeautyDowngrade", "", "()Z", "cache", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getCache", "()Lcom/bytedance/keva/Keva;", "cache$delegate", "handleRedVersion", "", "removeFromParent", "Landroid/view/View;", "clearViews", "onBindView", "actionListener", "Lcom/larus/bmhome/bigimg/widget/ICreationEditActionListener;", "isShowMore", "hasCreateImageAbility", "hasDetailImageEditAbility", "hasCreateVideoAbility", "hasExtendVideoAbility", "isShowShare", "functionVisibleConfig", "Lcom/larus/bmhome/bigimg/widget/LeftCreationEditView$FunctionVisibleConfig;", "(Lcom/larus/bmhome/bigimg/widget/ICreationEditActionListener;Ljava/lang/Boolean;ZZZZZLcom/larus/bmhome/bigimg/widget/LeftCreationEditView$FunctionVisibleConfig;)V", "updateImageEditPanelAlpha", "alpha", "", "ignoreShareIcon", "updateSharpnessState", "enabled", "initEditFunctionList", "(Ljava/lang/Boolean;ZZZZZLcom/larus/bmhome/bigimg/widget/LeftCreationEditView$FunctionVisibleConfig;)V", "isFunctionVisible", "functionName", "", "FunctionVisibleConfig", "Companion", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class LeftCreationEditView extends LinearLayout {
    public static final /* synthetic */ int l = 0;
    public LeftCreationEditItemView a;
    public final Lazy b;
    public LeftCreationEditItemView c;
    public LeftCreationEditItemView d;
    public LeftCreationEditItemView e;
    public LeftCreationEditItemView f;
    public LeftCreationEditItemView g;
    public LeftCreationEditItemView h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;

    public static final class a {
        public static b a() {
            int r0 = LeftCreationEditView.l;
            return new b(true, true, true, false, true, false);
        }

        public a() {
        }
    }

    public static final class b {
        public final boolean a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        public final boolean f;

        public b() {
            this(false, false, false, false, false, false);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == false) goto L9;
            int r3 = 1231;
        L10:
            int r4 = (r2 + r3) * 31;
            if (this.c == false) goto L13;
            int r5 = 1231;
        L14:
            int r6 = (r4 + r5) * 31;
            if (this.d == false) goto L17;
            int r7 = 1231;
        L18:
            int r8 = (r6 + r7) * 31;
            if (this.e == false) goto L21;
            int r9 = 1231;
        L22:
            int r10 = (r8 + r9) * 31;
            if (this.f == true) goto L27;
            r1 = 1237;
        L27:
            return r10 + r1;
        L21:
            r9 = 1237;
            goto L22
        L17:
            r7 = 1237;
            goto L18
        L13:
            r5 = 1237;
            goto L14
        L9:
            r3 = 1237;
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "FunctionVisibleConfig(toVideo=" + this.a + ", imageEdit=" + this.b + ", sharpness=" + this.c + ", expand=" + this.d + ", erase=" + this.e + ", videoExtend=" + this.f + ')';
        }

        public b(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    static {
        new a();
    }

    public LeftCreationEditView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LeftCreationEditView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final Keva getCache() {
        return (Keva) this.k.getValue();
    }

    private final sq9.r getLocalFunctionConfig() {
        return (sq9.r) this.j.getValue();
    }

    private final sq9.r getRemoteFunctionConfig() {
        return (sq9.r) this.i.getValue();
    }

    private final LeftCreationEditItemView getShareView() {
        return (LeftCreationEditItemView) this.b.getValue();
    }

    public final void b() {
        sq9.r r0 = getRemoteFunctionConfig();
        getCache().storeString("creation_edit_function_list", GsonProtectorUtils.toJson(HttpExtKt.f, r0));
    }

    public static sq9.r a(LeftCreationEditView r2) {
        String r3 = r2.getCache().getString("creation_edit_function_list", "");
        if (r3 == null) goto L7;
        sq9.r r4 = (sq9.r) GsonProtectorUtils.fromJson(HttpExtKt.f, r3, sq9.r.class);
        if (r4 == null) goto L7;
        return r4;
    L7:
        return new sq9.r(null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void e(LeftCreationEditItemView r2) {
        ViewParent r0 = r2.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        if (r1 == null) goto L9;
        r1.removeView(r2);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static boolean c(String r2, b r3) {
        if (r3 != null) goto L5;
        return true;
    L5:
        if (r2 != null) goto L7;
        return true;
    L7:
        switch(r2.hashCode()) {
            case -1571105471: goto L29;
            case -1443226002: goto L25;
            case -1431798345: goto L22;
            case -1289167206: goto L18;
            case -392382626: goto L14;
            case 96768678: goto L10;
            default: goto L40;
        };
    L40:
        return true;
    L10:
        if (r2.equals("erase") == true) goto L34;
        return true;
    L34:
        return r3.e;
    L14:
        if (r2.equals("video_extend") == true) goto L35;
        return true;
    L35:
        return r3.f;
    L18:
        if (r2.equals("expand") == true) goto L36;
        return true;
    L36:
        return r3.d;
    L22:
        if (r2.equals("to_video") == true) goto L38;
        return true;
    L38:
        return r3.a;
    L25:
        if (r2.equals("image_edit") == true) goto L39;
        return true;
    L39:
        return r3.b;
    L29:
        if (r2.equals("sharpness") == true) goto L32;
        return true;
    L32:
        return r3.c;
    }

    public final void f(float r4, boolean r5) {
        ConstraintLayout r0 = this.c;
        View r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.getParent();
    L7:
        if ((r2 instanceof View) == false) goto L9;
        View r3 = (View) r2;
    L10:
        if (r3 == null) goto L12;
        r3.setAlpha(r4);
    L12:
        ConstraintLayout r6 = this.g;
        if (r6 == null) goto L15;
        Object r7 = r6.getParent();
    L17:
        if ((r7 instanceof View) == false) goto L19;
        View r8 = (View) r7;
    L20:
        if (r8 == null) goto L22;
        r8.setAlpha(r4);
    L22:
        ConstraintLayout r9 = this.d;
        if (r9 == null) goto L25;
        Object r10 = r9.getParent();
    L27:
        if ((r10 instanceof View) == false) goto L29;
        View r11 = (View) r10;
    L30:
        if (r11 == null) goto L32;
        r11.setAlpha(r4);
    L32:
        ConstraintLayout r12 = this.e;
        if (r12 == null) goto L35;
        Object r13 = r12.getParent();
    L37:
        if ((r13 instanceof View) == false) goto L39;
        View r14 = (View) r13;
    L40:
        if (r14 == null) goto L42;
        r14.setAlpha(r4);
    L42:
        ConstraintLayout r15 = this.f;
        if (r15 == null) goto L45;
        Object r16 = r15.getParent();
    L47:
        if ((r16 instanceof View) == false) goto L49;
        View r17 = (View) r16;
    L50:
        if (r17 == null) goto L52;
        r17.setAlpha(r4);
    L52:
        ConstraintLayout r18 = this.h;
        if (r18 == null) goto L55;
        Object r19 = r18.getParent();
    L57:
        if ((r19 instanceof View) == false) goto L59;
        View r20 = (View) r19;
    L60:
        if (r20 == null) goto L62;
        r20.setAlpha(r4);
    L62:
        if (r5 == false) goto L64;
        getShareView().a.d.setAlpha(r4);
        return;
    L64:
        ConstraintLayout r21 = getShareView();
        if (r21 == null) goto L67;
        ViewParent r22 = r21.getParent();
    L69:
        if ((r22 instanceof View) == false) goto L71;
        r1 = (View) r22;
    L71:
        if (r1 == null) goto L75;
        r1.setAlpha(r4);
        return;
    L75:
        return;
    L67:
        r22 = null;
        goto L69
    L59:
        r20 = null;
        goto L60
    L55:
        r19 = null;
        goto L57
    L49:
        r17 = null;
        goto L50
    L45:
        r16 = null;
        goto L47
    L39:
        r14 = null;
        goto L40
    L35:
        r13 = null;
        goto L37
    L29:
        r11 = null;
        goto L30
    L25:
        r10 = null;
        goto L27
    L19:
        r8 = null;
        goto L20
    L15:
        r7 = null;
        goto L17
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    public LeftCreationEditView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = LazyKt.lazy(new u(r2));
        this.i = LazyKt.lazy(new v());
        this.j = LazyKt.lazy(new l(this));
        this.k = LazyKt.lazy(new m());
        setOrientation(1);
    }

    public /* synthetic */ LeftCreationEditView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Type inference failed for: r3v25, types: [android.view.ViewGroup, com.larus.bmhome.bigimg.widget.LeftCreationEditItemView] */
    public static void d(final LeftCreationEditView r17, final j r18, Boolean r19, boolean r20, boolean r21, boolean r22, boolean r23, boolean r24, b r25, int r26) {
        if ((r26 & 2) == 0) goto L5;
        Boolean r3 = Boolean.FALSE;
    L6:
        int r5 = 0;
        if ((r26 & 4) == 0) goto L9;
        boolean r4 = false;
    L11:
        if ((r26 & 8) == 0) goto L13;
        boolean r6 = r4;
    L15:
        if ((r26 & 16) == 0) goto L17;
        boolean r7 = false;
    L19:
        if ((r26 & 32) == 0) goto L21;
        boolean r8 = false;
    L23:
        if ((r26 & 64) == 0) goto L25;
        boolean r9 = true;
    L27:
        if ((r26 & 128) == 0) goto L29;
        b r2 = null;
    L30:
        r17.getClass();
        Intrinsics.checkNotNullParameter(r18, "actionListener");
        LeftCreationEditItemView r12 = r17.a;
        if (r12 == null) goto L33;
        e(r12);
    L33:
        e(r17.getShareView());
        LeftCreationEditItemView r13 = r17.c;
        if (r13 == null) goto L36;
        e(r13);
    L36:
        LeftCreationEditItemView r14 = r17.d;
        if (r14 == null) goto L39;
        e(r14);
    L39:
        LeftCreationEditItemView r15 = r17.e;
        if (r15 == null) goto L42;
        e(r15);
    L42:
        LeftCreationEditItemView r16 = r17.f;
        if (r16 == null) goto L45;
        e(r16);
    L45:
        LeftCreationEditItemView r110 = r17.g;
        if (r110 == null) goto L48;
        e(r110);
    L48:
        LeftCreationEditItemView r111 = r17.h;
        if (r111 == null) goto L51;
        e(r111);
    L51:
        r17.removeAllViews();
        int r112 = 6;
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L54;
        ?? r10 = new LeftCreationEditItemView(r17.getContext(), null, 6, 0);
        r10.S5(2131241138, null, Boolean.FALSE);
        int r11 = j0.a;
        r10.setContentDescription(j0.d(2131898824));
        r17.a = r10;
        FrameLayout r27 = new FrameLayout(r17.getContext());
        ConstraintLayout r113 = r17.a;
        FrameLayout.LayoutParams r114 = new FrameLayout.LayoutParams(-2, i5.c0());
        r114.gravity = 17;
        Unit r115 = Unit.INSTANCE;
        r27.addView(r113, r114);
        r17.addView(r27);
    L54:
        if (r9 == false) goto L56;
        FrameLayout r28 = new FrameLayout(r17.getContext());
        r28.addView(r17.getShareView(), new FrameLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams r29 = new LinearLayout.LayoutParams(-2, -2);
        r29.topMargin = 0;
        r29.gravity = 17;
        Unit r116 = Unit.INSTANCE;
        r17.addView(r28, r29);
    L56:
        if (r8 == true) goto L58;
        sq9.r r30 = z2.a.getCreationEditControlConfig().a();
        if (r30 == null) goto L245;
        List r31 = r30.a();
        if (r31 == null) goto L245;
        Iterator r32 = r31.iterator();
    L67:
        if (r32.hasNext() == false) goto L244;
        sq9.s r33 = (sq9.s) r32.next();
        if (c(r33.a(), r2) == false) goto L243;
        String r34 = r33.a();
        if (r34 == null) goto L243;
        switch(r34.hashCode()) {
            case -1571105471: goto L238;
            case -1443226002: goto L198;
            case -1431798345: goto L159;
            case -1289167206: goto L119;
            case 96768678: goto L77;
            default: goto L243;
        };
    L77:
        if (r34.equals("erase") == false) goto L243;
        if (r4 == false) goto L243;
        LeftCreationEditItemView r35 = new LeftCreationEditItemView(r17.getContext(), null, r112, r5);
        sq9.r r117 = r17.getRemoteFunctionConfig();
        if (r117 == null) goto L97;
        List r118 = r117.a();
        if (r118 == null) goto L97;
        Iterator r119 = r118.iterator();
    L86:
        if (r119.hasNext() == false) goto L91;
        Object r120 = r119.next();
        if (Intrinsics.areEqual(((sq9.s) r120).a(), "erase") == false) goto L86;
    L92:
        sq9.s r121 = (sq9.s) r120;
        if (r121 == null) goto L97;
        Integer r36 = r121.b();
        if (r36 == null) goto L97;
        int r37 = r36.intValue();
    L98:
        List r122 = r17.getLocalFunctionConfig().a();
        if (r122 == null) goto L113;
        Iterator r123 = r122.iterator();
    L102:
        if (r123.hasNext() == false) goto L107;
        Object r124 = r123.next();
        if (Intrinsics.areEqual(((sq9.s) r124).a(), "erase") == false) goto L102;
    L108:
        sq9.s r125 = (sq9.s) r124;
        if (r125 == null) goto L113;
        Integer r38 = r125.b();
        if (r38 == null) goto L113;
        int r39 = r38.intValue();
    L114:
        if (r37 <= r39) goto L116;
        boolean r40 = true;
    L117:
        r35.S5(2131241140, 2131906329, Boolean.valueOf(r40));
        r17.h = r35;
        FrameLayout r41 = new FrameLayout(r17.getContext());
        ConstraintLayout r42 = r17.h;
        FrameLayout.LayoutParams r43 = new FrameLayout.LayoutParams(-2, -2);
        r43.gravity = 17;
        Unit r126 = Unit.INSTANCE;
        r41.addView(r42, r43);
        LinearLayout.LayoutParams r44 = new LinearLayout.LayoutParams(-2, -2);
        r44.topMargin = i5.j0();
        r44.gravity = 17;
        r17.addView(r41, r44);
        goto L243
    L116:
        r40 = false;
        goto L117
    L107:
        r124 = null;
    L113:
        r39 = 0;
        goto L114
    L91:
        r120 = null;
    L97:
        r37 = 0;
        goto L98
    L119:
        if (r34.equals("expand") == false) goto L243;
        if (r4 == false) goto L243;
        LeftCreationEditItemView r45 = new LeftCreationEditItemView(r17.getContext(), null, 6, 0);
        sq9.r r127 = r17.getRemoteFunctionConfig();
        if (r127 == null) goto L138;
        List r128 = r127.a();
        if (r128 == null) goto L138;
        Iterator r129 = r128.iterator();
    L128:
        if (r129.hasNext() == false) goto L132;
        Object r130 = r129.next();
        if (Intrinsics.areEqual(((sq9.s) r130).a(), "expand") == false) goto L128;
    L133:
        sq9.s r131 = (sq9.s) r130;
        if (r131 == null) goto L138;
        Integer r132 = r131.b();
        if (r132 == null) goto L138;
        int r133 = r132.intValue();
    L139:
        List r134 = r17.getLocalFunctionConfig().a();
        if (r134 == null) goto L153;
        Iterator r135 = r134.iterator();
    L143:
        if (r135.hasNext() == false) goto L147;
        Object r136 = r135.next();
        if (Intrinsics.areEqual(((sq9.s) r136).a(), "expand") == false) goto L143;
    L148:
        sq9.s r137 = (sq9.s) r136;
        if (r137 == null) goto L153;
        Integer r46 = r137.b();
        if (r46 == null) goto L153;
        int r47 = r46.intValue();
    L154:
        if (r133 <= r47) goto L156;
        boolean r48 = true;
    L157:
        r45.S5(2131241139, 2131906326, Boolean.valueOf(r48));
        r17.g = r45;
        FrameLayout r49 = new FrameLayout(r17.getContext());
        ConstraintLayout r50 = r17.g;
        FrameLayout.LayoutParams r51 = new FrameLayout.LayoutParams(-2, -2);
        r51.gravity = 17;
        Unit r138 = Unit.INSTANCE;
        r49.addView(r50, r51);
        LinearLayout.LayoutParams r52 = new LinearLayout.LayoutParams(-2, -2);
        r52.topMargin = i5.j0();
        r52.gravity = 17;
        r17.addView(r49, r52);
        goto L243
    L156:
        r48 = false;
        goto L157
    L147:
        r136 = null;
    L153:
        r47 = 0;
        goto L154
    L132:
        r130 = null;
    L138:
        r133 = 0;
        goto L139
    L159:
        if (r34.equals("to_video") == false) goto L243;
        if (r7 == false) goto L243;
        sq9.r r53 = r17.getRemoteFunctionConfig();
        if (r53 == null) goto L177;
        List r54 = r53.a();
        if (r54 == null) goto L177;
        Iterator r55 = r54.iterator();
    L167:
        if (r55.hasNext() == false) goto L171;
        Object r56 = r55.next();
        if (Intrinsics.areEqual(((sq9.s) r56).a(), "to_video") == false) goto L167;
    L172:
        sq9.s r57 = (sq9.s) r56;
        if (r57 == null) goto L177;
        Integer r58 = r57.b();
        if (r58 == null) goto L177;
        int r59 = r58.intValue();
    L178:
        List r60 = r17.getLocalFunctionConfig().a();
        if (r60 == null) goto L192;
        Iterator r61 = r60.iterator();
    L182:
        if (r61.hasNext() == false) goto L186;
        Object r139 = r61.next();
        if (Intrinsics.areEqual(((sq9.s) r139).a(), "to_video") == false) goto L182;
    L187:
        sq9.s r140 = (sq9.s) r139;
        if (r140 == null) goto L192;
        Integer r62 = r140.b();
        if (r62 == null) goto L192;
        int r63 = r62.intValue();
    L193:
        if (r59 <= r63) goto L195;
        boolean r64 = true;
    L196:
        LeftCreationEditItemView r65 = new LeftCreationEditItemView(r17.getContext(), null, 6, 0);
        r65.S5(2131241148, 2131906331, Boolean.valueOf(r64));
        r17.d = r65;
        FrameLayout r66 = new FrameLayout(r17.getContext());
        r66.addView(r17.d, new FrameLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams r67 = new LinearLayout.LayoutParams(-2, -2);
        r67.topMargin = i5.j0();
        r67.gravity = 17;
        Unit r68 = Unit.INSTANCE;
        r17.addView(r66, r67);
        goto L243
    L195:
        r64 = false;
        goto L196
    L186:
        r139 = null;
    L192:
        r63 = 0;
        goto L193
    L171:
        r56 = null;
    L177:
        r59 = 0;
        goto L178
    L198:
        if (r34.equals("image_edit") == false) goto L243;
        if (r6 == false) goto L243;
        LeftCreationEditItemView r69 = new LeftCreationEditItemView(r17.getContext(), null, 6, 0);
        sq9.r r141 = r17.getRemoteFunctionConfig();
        if (r141 == null) goto L217;
        List r142 = r141.a();
        if (r142 == null) goto L217;
        Iterator r143 = r142.iterator();
    L207:
        if (r143.hasNext() == false) goto L211;
        Object r144 = r143.next();
        if (Intrinsics.areEqual(((sq9.s) r144).a(), "image_edit") == false) goto L207;
    L212:
        sq9.s r145 = (sq9.s) r144;
        if (r145 == null) goto L217;
        Integer r146 = r145.b();
        if (r146 == null) goto L217;
        int r147 = r146.intValue();
    L218:
        List r148 = r17.getLocalFunctionConfig().a();
        if (r148 == null) goto L232;
        Iterator r149 = r148.iterator();
    L222:
        if (r149.hasNext() == false) goto L226;
        Object r150 = r149.next();
        if (Intrinsics.areEqual(((sq9.s) r150).a(), "image_edit") == false) goto L222;
    L227:
        sq9.s r151 = (sq9.s) r150;
        if (r151 == null) goto L232;
        Integer r70 = r151.b();
        if (r70 == null) goto L232;
        int r71 = r70.intValue();
    L233:
        if (r147 <= r71) goto L235;
        boolean r152 = true;
    L236:
        r69.S5(2131241146, 2131906324, Boolean.valueOf(r152));
        r17.c = r69;
        FrameLayout r72 = new FrameLayout(r17.getContext());
        ConstraintLayout r73 = r17.c;
        FrameLayout.LayoutParams r74 = new FrameLayout.LayoutParams(-2, -2);
        r74.gravity = 17;
        Unit r153 = Unit.INSTANCE;
        r72.addView(r73, r74);
        LinearLayout.LayoutParams r75 = new LinearLayout.LayoutParams(-2, -2);
        r75.topMargin = i5.j0();
        r75.gravity = 17;
        r17.addView(r72, r75);
        goto L243
    L235:
        r152 = false;
        goto L236
    L226:
        r150 = null;
    L232:
        r71 = 0;
        goto L233
    L211:
        r144 = null;
    L217:
        r147 = 0;
        goto L218
    L238:
        if (r34.equals("sharpness") == false) goto L243;
        if (r4 == false) goto L243;
        LeftCreationEditItemView r76 = new LeftCreationEditItemView(r17.getContext(), null, 6, 0);
        r76.S5(2131241142, 2131906330, Boolean.FALSE);
        r17.f = r76;
        FrameLayout r77 = new FrameLayout(r17.getContext());
        ConstraintLayout r78 = r17.f;
        FrameLayout.LayoutParams r154 = new FrameLayout.LayoutParams(-2, -2);
        r154.gravity = 17;
        Unit r155 = Unit.INSTANCE;
        r77.addView(r78, r154);
        LinearLayout.LayoutParams r79 = new LinearLayout.LayoutParams(-2, -2);
        r79.topMargin = i5.j0();
        r79.gravity = 17;
        r17.addView(r77, r79);
    L243:
        r5 = 0;
        r112 = 6;
        goto L67
    L244:
        Unit r80 = Unit.INSTANCE;
    L245:
        e1.d(r17.getShareView(), new k(r18));
        ConstraintLayout r81 = r17.c;
        if (r81 == null) goto L248;
        e1.d(r81, new n(r18, r17));
    L248:
        ConstraintLayout r82 = r17.d;
        if (r82 == null) goto L251;
        e1.d(r82, new o(r18, r17));
    L251:
        ConstraintLayout r83 = r17.e;
        if (r83 == null) goto L254;
        e1.d(r83, new p(r18));
    L254:
        ConstraintLayout r84 = r17.f;
        if (r84 == null) goto L257;
        e1.d(r84, new q(r17, r18));
    L257:
        ConstraintLayout r85 = r17.g;
        if (r85 == null) goto L260;
        e1.d(r85, new r(r17, r18));
    L260:
        ConstraintLayout r86 = r17.h;
        if (r86 == null) goto L263;
        e1.d(r86, new s(r17, r18));
    L263:
        ConstraintLayout r0 = r17.a;
        if (r0 == null) goto L292;
        e1.d(r0, new t(r18));
        return;
    L292:
        return;
    L58:
        if (c("video_extend", r2) == false) goto L60;
        LeftCreationEditItemView r87 = new LeftCreationEditItemView(r17.getContext(), null, 6, 0);
        r87.S5(2131241141, 2131905605, Boolean.FALSE);
        r17.e = r87;
        FrameLayout r88 = new FrameLayout(r17.getContext());
        ConstraintLayout r89 = r17.e;
        FrameLayout.LayoutParams r90 = new FrameLayout.LayoutParams(-2, -2);
        r90.gravity = 17;
        Unit r91 = Unit.INSTANCE;
        r88.addView(r89, r90);
        LinearLayout.LayoutParams r92 = new LinearLayout.LayoutParams(-2, -2);
        r92.topMargin = i5.j0();
        r92.gravity = 17;
        r17.addView(r88, r92);
    L60:
        Unit r93 = Unit.INSTANCE;
        goto L245
    L29:
        r2 = r25;
        goto L30
    L25:
        r9 = r24;
        goto L27
    L21:
        r8 = r23;
        goto L23
    L17:
        r7 = r22;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r3 = r19;
        goto L6
    }
}
