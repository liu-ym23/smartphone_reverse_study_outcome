package com.ss.android.lark.flow.chat.titlebar.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\f\b\u0007\u0018\u0000 \u0087\u00012\u00020\u0001:\u000e\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001bJ\u0010\u0010.\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010\u0019J\u0010\u00100\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102J\u0010\u00103\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u000102J\u000e\u00105\u001a\u00020,2\u0006\u00106\u001a\u00020\u0014J\u001c\u00107\u001a\u00020,2\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020,\u0018\u000109J\u001c\u0010:\u001a\u00020,2\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020,\u0018\u000109J\u001c\u0010;\u001a\u00020,2\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020,\u0018\u000109J\u0010\u0010<\u001a\u00020,2\b\u0010=\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020@J\u000e\u0010A\u001a\u00020,2\u0006\u0010?\u001a\u00020@J\u000e\u0010B\u001a\u00020(2\u0006\u0010C\u001a\u00020\u000fJ\u000e\u0010D\u001a\u00020(2\u0006\u0010C\u001a\u00020\u000fJ\u0006\u0010E\u001a\u00020,J\u0006\u0010F\u001a\u00020,J\u0017\u0010G\u001a\u00020,2\n\b\u0001\u0010H\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010IJ\u000e\u0010J\u001a\u00020,2\u0006\u0010K\u001a\u00020(J\u0010\u0010L\u001a\u00020,2\b\b\u0001\u0010H\u001a\u00020\u0007J\u0010\u0010M\u001a\u00020,2\b\b\u0001\u0010H\u001a\u00020\u0007J\u0018\u0010N\u001a\u00020,2\u0006\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u0007H\u0014J0\u0010Q\u001a\u00020,2\u0006\u0010R\u001a\u00020(2\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u0007H\u0014J\u0010\u0010W\u001a\u00020,2\u0006\u0010X\u001a\u00020YH\u0014J\b\u0010Z\u001a\u00020[H\u0014J\u0012\u0010\\\u001a\u00020[2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\\\u001a\u00020[2\u0006\u0010]\u001a\u00020[H\u0014J\u0010\u0010^\u001a\u00020(2\u0006\u0010]\u001a\u00020[H\u0014J\u0018\u0010_\u001a\u00020,2\u0006\u0010?\u001a\u00020@2\u0006\u0010`\u001a\u00020(H\u0002J\u0018\u0010a\u001a\u00020(2\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020(H\u0002J\u0010\u0010b\u001a\u00020,2\u0006\u0010`\u001a\u00020(H\u0002J\u0010\u0010c\u001a\u00020\u00142\u0006\u0010?\u001a\u00020@H\u0002J\u0016\u0010d\u001a\u00020,2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00140fH\u0002JF\u0010g\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070h2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u000f0j2\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00140k2\u0006\u0010l\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\u0007H\u0002J(\u0010n\u001a\u00020,2\u0006\u0010o\u001a\u00020\u00142\u0006\u0010p\u001a\u00020q2\u0006\u0010l\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\u0007H\u0002J0\u0010r\u001a\u00020\u00072\u0006\u0010s\u001a\u00020\u00072\u0006\u0010t\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u00072\u0006\u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020(H\u0002J0\u0010x\u001a\u00020\u00072\u0006\u0010y\u001a\u00020\u00072\u0006\u0010t\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u00072\u0006\u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020(H\u0002J\u0010\u0010z\u001a\u00020\u00072\u0006\u0010{\u001a\u00020|H\u0002J\u0012\u0010}\u001a\u00020,2\b\u00106\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010~\u001a\u00020,H\u0002J\b\u0010\u007f\u001a\u00020,H\u0002J\t\u0010\u0080\u0001\u001a\u00020,H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u001e\u001a\u00060\u001fR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!R\u0016\u0010$\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010%R\u0012\u0010&\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0088\u0001"}, d2 = {"Lcom/ss/android/lark/flow/chat/titlebar/view/CoreNavigationBar;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "minActionSizePx", "minBarHeightPx", "dividerHeightPx", "leftActionOrder", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "rightActionOrder", "leftActionViews", "Ljava/util/LinkedHashMap;", "Landroid/view/View;", "Lkotlin/collections/LinkedHashMap;", "rightActionViews", "centerView", "centerViewProvider", "Lcom/ss/android/lark/flow/chat/titlebar/view/CoreNavigationBar$ViewProvider;", "centerAlignment", "Lcom/ss/android/lark/flow/chat/titlebar/view/CoreNavigationBar$CenterHorizontalAlignment;", "titleStyleConfigure", "Lcom/ss/android/lark/flow/chat/titlebar/view/CoreNavigationBar$ITitleStyleConfigure;", "defaultCenterView", "Lcom/ss/android/lark/flow/chat/titlebar/view/CoreNavigationBar$DefaultCenterView;", "getDefaultCenterView", "()Lcom/ss/android/lark/flow/chat/titlebar/view/CoreNavigationBar$DefaultCenterView;", "defaultCenterView$delegate", "Lkotlin/Lazy;", "iconTintColor", "Ljava/lang/Integer;", "dividerColor", "dividerVisible", "", "dividerPaint", "Landroid/graphics/Paint;", "setCenterHorizontalAlignment", "", "alignment", "setCenterViewProvider", "provider", "setTitle", "title", "", "setSubtitle", "subtitle", "setSubtitleView", "view", "setTitleClickListener", "onClick", "Lkotlin/Function1;", "setTitleRowClickListener", "setSubTitleClickListener", "setTitleStyleConfigure", "configure", "addLeftAction", "action", "Lcom/ss/android/lark/flow/chat/titlebar/view/CoreNavigationBar$Action;", "addRightAction", "removeLeftAction", "actionId", "removeRightAction", "clearLeftActions", "clearRightActions", "setIconTint", "color", "(Ljava/lang/Integer;)V", "setDividerVisible", "visible", "setDividerColor", "setNavigationBarBackgroundColor", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "l", "t", "r", "b", "onDraw", "canvas", "Landroid/graphics/Canvas;", "generateDefaultLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "generateLayoutParams", "p", "checkLayoutParams", "addActionInternal", "isLeft", "removeActionInternal", "clearActionsInternal", "resolveActionView", "applyTintToAutoCreatedActionViews", "views", "", "measureActions", "Lkotlin/Pair;", "actions", "", "", "parentWidth", "parentHeightSpec", "measureActionChild", "child", "lp", "Landroid/view/ViewGroup$MarginLayoutParams;", "layoutLeftActions", "startX", "top", "bottom", "centerY", "isRtl", "layoutRightActions", "endX", "dpToPx", "dp", "", "setCenterViewInternal", "ensureDefaultCenterAttachedIfNoCustomCenter", "ensureDefaultCenterAttached", "applyTitleStyleConfigure", "ViewProvider", "ITitleStyleConfigure", "Action", "SimpleAction", "CenterHorizontalAlignment", "DefaultCenterView", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CoreNavigationBar extends ViewGroup {
    public static final /* synthetic */ int q = 0;
    public final int a;
    public final int b;
    public final int c;
    public final ArrayList<Object> d;
    public final ArrayList<Object> e;
    public final LinkedHashMap<Object, View> f;
    public final LinkedHashMap<Object, View> g;
    public View h;
    public f i;
    public CenterHorizontalAlignment j;
    public d k;
    public final Lazy l;
    public Integer m;
    public int n;
    public boolean o;
    public final Paint p;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/flow/chat/titlebar/view/CoreNavigationBar$CenterHorizontalAlignment;", "", "<init>", "(Ljava/lang/String;I)V", "START", "CENTER", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum CenterHorizontalAlignment extends Enum<CenterHorizontalAlignment> {
        public static final CenterHorizontalAlignment CENTER = null;
        public static final CenterHorizontalAlignment START = null;
        public static final /* synthetic */ CenterHorizontalAlignment[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<CenterHorizontalAlignment> getEntries() {
            return b;
        }

        static {
            CenterHorizontalAlignment r0 = new CenterHorizontalAlignment("START", 0);
            START = r0;
            CenterHorizontalAlignment r1 = new CenterHorizontalAlignment("CENTER", 1);
            CENTER = r1;
            CenterHorizontalAlignment[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static CenterHorizontalAlignment[] values() {
            return (CenterHorizontalAlignment[]) a.clone();
        }

        public static CenterHorizontalAlignment valueOf(String r1) {
            return (CenterHorizontalAlignment) r27.a.a(CenterHorizontalAlignment.class, r1);
        }

        public CenterHorizontalAlignment(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements View.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class b {
    }

    public final class c extends LinearLayout {
        public final AppCompatTextView a;
        public final AppCompatTextView b;
        public final AppCompatImageView c;
        public final FrameLayout d;
        public final LinearLayout e;
        public View f;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[CenterHorizontalAlignment.values().length];
                r0[CenterHorizontalAlignment.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[CenterHorizontalAlignment.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public final void a(CenterHorizontalAlignment r8) {
            Intrinsics.checkNotNullParameter(r8, "alignment");
            int[] r0 = a.a;
            int r1 = r0[r8.ordinal()];
            int r2 = 8388627;
            if (r1 == 1) goto L8;
            if (r1 != 2) goto L7;
            int r3 = 17;
        L9:
            setGravity(r3);
            int r4 = r0[r8.ordinal()];
            if (r4 == 1) goto L15;
            if (r4 != 2) goto L14;
            int r5 = 4;
        L16:
            LinearLayout r6 = this.e;
            int r9 = r0[r8.ordinal()];
            if (r9 == 1) goto L22;
            if (r9 != 2) goto L21;
            r2 = 17;
            goto L22
        L21:
            throw new NoWhenBranchMatchedException();
        L22:
            r6.setGravity(r2);
            this.a.setTextAlignment(r5);
            this.b.setTextAlignment(r5);
            View r10 = this.f;
            if (r10 == null) goto L26;
            r10.setTextAlignment(r5);
            return;
        L26:
            return;
        L14:
            throw new NoWhenBranchMatchedException();
        L15:
            r5 = 5;
            goto L16
        L7:
            throw new NoWhenBranchMatchedException();
        L8:
            r3 = 8388627;
            goto L9
        }

        public c(CoreNavigationBar r11, Context r12) {
            Intrinsics.checkNotNullParameter(r12, "context");
            super(r12);
            AppCompatTextView r0 = new AppCompatTextView(r12);
            this.a = r0;
            AppCompatTextView r1 = new AppCompatTextView(r12);
            this.b = r1;
            AppCompatImageView r2 = new AppCompatImageView(r12);
            this.c = r2;
            FrameLayout r3 = new FrameLayout(r12);
            this.d = r3;
            LinearLayout r4 = new LinearLayout(r12);
            this.e = r4;
            setOrientation(1);
            setGravity(17);
            r4.setOrientation(0);
            r4.setGravity(16);
            r0.setMaxLines(1);
            r0.setEllipsize(TextUtils.TruncateAt.END);
            r0.setIncludeFontPadding(false);
            r0.setTextSize(2, 17.0f);
            r0.setTypeface(r0.getTypeface(), 1);
            r3.setId(2131373027);
            r3.setVisibility(8);
            int r9 = CoreNavigationBar.q;
            int r13 = r11.e(12.0f);
            r2.setLayoutParams(new LinearLayout.LayoutParams(r13, r13));
            r2.setImageResource(2131235849);
            r2.setVisibility(8);
            r1.setMaxLines(1);
            r1.setEllipsize(TextUtils.TruncateAt.END);
            r1.setIncludeFontPadding(false);
            r1.setTextSize(2, 11.0f);
            r1.setVisibility(8);
            LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(-2, -2);
            r14.weight = 1.0f;
            Unit r6 = Unit.INSTANCE;
            r4.addView(r0, r14);
            LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(-2, -2);
            r15.setMarginStart(UIUtils.dp2px(r12, 4.0f));
            r4.addView(r3, r15);
            r4.addView(r2);
            addView(r4, new LinearLayout.LayoutParams(-2, -2));
            addView(r1, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    public interface d {
        void a(AppCompatTextView r1);

        void b(AppCompatImageView r1);

        void c(AppCompatTextView r1);
    }

    public static final class e {
        public final Object a;
        public final Drawable b;
        public final Integer c;
        public final f d;
        public final Function1<View, Unit> e;

        public e() {
            throw null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof e) == true) goto L8;
            return false;
        L8:
            e r6 = (e) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Drawable r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Integer r5 = this.c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            f r8 = this.d;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            Function1<View, Unit> r11 = this.e;
            if (r11 == null) goto L19;
            r2 = r11.hashCode();
        L19:
            return r10 + r2;
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "SimpleAction(id=" + this.a + ", iconDrawable=" + this.b + ", iconResId=" + this.c + ", iconViewProvider=" + this.d + ", onClick=" + this.e + ')';
        }

        public e(TitleBarActionKey r3, Drawable r4, f r5, Function1 r6, int r7) {
            if ((r7 & 2) == 0) goto L6;
            r4 = null;
        L6:
            if ((r7 & 8) == 0) goto L9;
            r5 = null;
        L9:
            if ((r7 & 16) == 0) goto L11;
            r6 = null;
        L11:
            Intrinsics.checkNotNullParameter(r3, "id");
            this.a = r3;
            this.b = r4;
            this.c = null;
            this.d = r5;
            this.e = r6;
        }
    }

    public interface f {
        View createView(Context r1);
    }

    public /* synthetic */ class g {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CenterHorizontalAlignment.values().length];
            r0[CenterHorizontalAlignment.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CenterHorizontalAlignment.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ Function1 a;

        public h(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        @Override // android.view.View.OnClickListener
        public final /* synthetic */ void onClick(View r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public CoreNavigationBar(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CoreNavigationBar(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final c getDefaultCenterView() {
        return (c) this.l.getValue();
    }

    public final void c() {
        d r0 = this.k;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.c(getDefaultCenterView().a);
        r0.a(getDefaultCenterView().b);
        r0.b(getDefaultCenterView().c);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public final void f() {
        getDefaultCenterView().a(this.j);
        c();
        setCenterViewInternal(getDefaultCenterView());
    }

    private final void setCenterViewInternal(View r2) {
        View r0 = this.h;
        if (r0 != r2) goto L5;
        return;
    L5:
        if (r0 == null) goto L7;
        removeView(r0);
    L7:
        this.h = r2;
        if (r2 != null) goto L10;
    L13:
        requestLayout();
        return;
    L10:
        if (r2.getLayoutParams() != null) goto L12;
        r2.setLayoutParams(generateDefaultLayoutParams());
    L12:
        addView(r2);
        goto L13
    }

    public final void b(Collection<? extends View> r5) {
        Integer r0 = this.m;
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        AppCompatImageView r1 = (View) r6.next();
        if (Intrinsics.areEqual(r1.getTag(), "core_navigation_bar:auto_action_view") == false) goto L4;
        if ((r1 instanceof AppCompatImageView) == false) goto L4;
        if (r0 == null) goto L10;
        r1.setColorFilter(r0.intValue());
        goto L4
    L10:
        r1.clearColorFilter();
        goto L4
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r2) {
        Intrinsics.checkNotNullParameter(r2, "p");
        return r2 instanceof ViewGroup.MarginLayoutParams;
    }

    public final void d(boolean r4) {
        if (r4 == false) goto L4;
        ArrayList<Object> r5 = this.d;
        LinkedHashMap<Object, View> r0 = this.f;
    L5:
        Pair r6 = TuplesKt.to(r5, r0);
        ArrayList r1 = (ArrayList) r6.component1();
        LinkedHashMap r7 = (LinkedHashMap) r6.component2();
        Iterator r2 = r7.values().iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        removeView((View) r2.next());
        goto L7
    L9:
        r7.clear();
        r1.clear();
        requestLayout();
        return;
    L4:
        r5 = this.e;
        r0 = this.g;
        goto L5
    }

    public final int e(float r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        Intrinsics.checkNotNullParameter(r2, "p");
        return new ViewGroup.MarginLayoutParams(r2);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        super.onDraw(r8);
        if (this.o == true) goto L6;
        return;
    L6:
        if (this.c > 0) goto L8;
        return;
    L8:
        this.p.setColor(this.n);
        r8.drawRect(0.0f, getHeight() - this.c, getWidth(), getHeight(), this.p);
    }

    public final void setCenterHorizontalAlignment(CenterHorizontalAlignment r3) {
        Intrinsics.checkNotNullParameter(r3, "alignment");
        if (this.j == r3) goto L9;
        this.j = r3;
        if (this.h != getDefaultCenterView()) goto L7;
        getDefaultCenterView().a(r3);
    L7:
        requestLayout();
        return;
    }

    public final void setCenterViewProvider(f r3) {
        this.i = r3;
        if (r3 != null) goto L6;
        f();
        return;
    L6:
        View r4 = r3.createView(getContext());
        ViewParent r0 = r4.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L9;
        ViewGroup r1 = (ViewGroup) r0;
    L10:
        if (r1 == null) goto L12;
        r1.removeView(r4);
    L12:
        setCenterViewInternal(r4);
        return;
    L9:
        r1 = null;
        goto L10
    }

    public final void setDividerColor(int r2) {
        if (this.n == r2) goto L6;
        this.n = r2;
        invalidate();
        return;
    }

    public final void setDividerVisible(boolean r2) {
        if (this.o == r2) goto L6;
        this.o = r2;
        invalidate();
        return;
    }

    public final void setIconTint(Integer r2) {
        if (Intrinsics.areEqual(this.m, r2) == false) goto L5;
        return;
    L5:
        this.m = r2;
        b(this.f.values());
        b(this.g.values());
        c r0 = getDefaultCenterView();
        if (r2 != null) goto L8;
        r0.c.clearColorFilter();
    L9:
        invalidate();
        return;
    L8:
        r0.c.setColorFilter(r2.intValue());
        goto L9
    }

    public final void setNavigationBarBackgroundColor(int r1) {
        setBackgroundColor(r1);
    }

    public final void setSubTitleClickListener(Function1<? super View, Unit> r4) {
        c r0 = getDefaultCenterView();
        if (r4 != null) goto L5;
        r0.b.setOnClickListener(null);
        r0.b.setClickable(false);
        return;
    L5:
        r0.b.setClickable(true);
        r0.b.setOnClickListener(new h(r4));
    }

    public final void setSubtitle(CharSequence r6) {
        c r0 = getDefaultCenterView();
        View r1 = r0.f;
        if (r1 == null) goto L5;
        r0.removeView(r1);
    L5:
        r0.f = null;
        if (r6 != null) goto L8;
    L11:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        r0.b.setText(null);
        r0.b.setVisibility(8);
        r0.a.setTextSize(2, 17.0f);
    L17:
        if (this.i != null) goto L21;
        f();
        return;
    L21:
        return;
    L15:
        r0.b.setText(r6);
        r0.b.setVisibility(0);
        r0.a.setTextSize(2, 15.0f);
        goto L17
    L8:
        if (r6.length() == 0) goto L11;
        r3 = false;
        goto L13
    }

    public final void setSubtitleView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        c r1 = getDefaultCenterView();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "view");
        View r0 = r1.f;
        if (r0 == r5) goto L13;
        if (r0 == null) goto L6;
        r1.removeView(r0);
    L6:
        ViewParent r2 = r5.getParent();
        if ((r2 instanceof ViewGroup) == false) goto L9;
        ViewGroup r3 = (ViewGroup) r2;
    L10:
        if (r3 == null) goto L12;
        r3.removeView(r5);
    L12:
        r1.f = r5;
        r1.addView(r5, new LinearLayout.LayoutParams(-2, -2));
        goto L13
    L9:
        r3 = null;
    L13:
        r1.b.setText(null);
        r1.b.setVisibility(8);
        r5.setVisibility(0);
        r5.setTextAlignment(r1.b.getTextAlignment());
        r1.a.setTextSize(2, 15.0f);
        if (this.i != null) goto L18;
        f();
        return;
    }

    public final void setTitle(CharSequence r2) {
        getDefaultCenterView().a.setText(r2);
        if (this.i != null) goto L7;
        f();
        return;
    }

    public final void setTitleClickListener(Function1<? super View, Unit> r5) {
        c r0 = getDefaultCenterView();
        if (r5 != null) goto L5;
        r0.a.setOnClickListener(null);
        r0.a.setClickable(false);
        r0.c.setVisibility(8);
    L7:
        if (this.i != null) goto L11;
        f();
        return;
    L11:
        return;
    L5:
        r0.a.setClickable(true);
        r0.a.setOnClickListener(new h(r5));
        r0.c.setVisibility(0);
        goto L7
    }

    public final void setTitleRowClickListener(Function1<? super View, Unit> r3) {
        LinearLayout r0 = getDefaultCenterView().e;
        if (r3 == null) goto L5;
        h r1 = new h(r3);
    L6:
        r0.setOnClickListener(r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setTitleStyleConfigure(d r1) {
        this.k = r1;
        c();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new ViewGroup.MarginLayoutParams(getContext(), r3);
    }

    public final void a(e r6, boolean r7) {
        if (r7 == false) goto L4;
        ArrayList<Object> r8 = this.d;
        LinkedHashMap<Object, View> r0 = this.f;
    L5:
        Pair r9 = TuplesKt.to(r8, r0);
        ArrayList r1 = (ArrayList) r9.component1();
        LinkedHashMap r10 = (LinkedHashMap) r9.component2();
        View r2 = (View) r10.get(r6.a);
        if (r2 == null) goto L8;
        removeView(r2);
        r10.remove(r6.a);
        r1.remove(r6.a);
    L8:
        f r3 = r6.d;
        h r4 = null;
        if (r3 == null) goto L16;
        AppCompatImageView r5 = r3.createView(getContext());
        ViewParent r11 = r5.getParent();
        if ((r11 instanceof ViewGroup) == false) goto L13;
        ViewGroup r12 = (ViewGroup) r11;
    L14:
        if (r12 == null) goto L34;
        r12.removeView(r5);
    L34:
        r5.setMinimumWidth(Math.max(r5.getMinimumWidth(), this.a));
        r5.setMinimumHeight(Math.max(r5.getMinimumHeight(), this.a));
        Function1<View, Unit> r13 = r6.e;
        if (r13 == null) goto L37;
        r4 = new h(r13);
    L37:
        r5.setOnClickListener(r4);
        if (r5.getLayoutParams() != null) goto L40;
        int r14 = this.a;
        r5.setLayoutParams(new ViewGroup.MarginLayoutParams(r14, r14));
    L40:
        addView(r5);
        r1.add(r6.a);
        r10.put(r6.a, r5);
        requestLayout();
        return;
    L13:
        r12 = null;
        goto L14
    L16:
        r5 = new AppCompatImageView(getContext());
        r5.setClickable(true);
        r5.setFocusable(true);
        r5.setScaleType(ImageView.ScaleType.CENTER);
        Drawable r15 = r6.b;
        if (r15 == null) goto L19;
        r5.setImageDrawable(r15);
    L30:
        Integer r16 = this.m;
        if (r16 == null) goto L33;
        r5.setColorFilter(r16.intValue());
    L33:
        r5.setTag("core_navigation_bar:auto_action_view");
        goto L34
    L19:
        Integer r17 = r6.c;
        if (r17 == null) goto L30;
        if (r17 != null) goto L24;
    L25:
        Integer r18 = r6.c;
        if (r18 == null) goto L28;
        int r19 = r18.intValue();
    L29:
        r5.setImageResource(r19);
        goto L30
    L28:
        r19 = 0;
        goto L29
    L24:
        if (r17.intValue() == 0) goto L30;
    L4:
        r8 = this.e;
        r0 = this.g;
        goto L5
    }

    public final boolean h(Object r2, boolean r3) {
        if (r3 == false) goto L4;
        ArrayList<Object> r4 = this.d;
        LinkedHashMap<Object, View> r0 = this.f;
    L5:
        Pair r5 = TuplesKt.to(r4, r0);
        ArrayList r1 = (ArrayList) r5.component1();
        View r6 = (View) ((LinkedHashMap) r5.component2()).remove(r2);
        if (r6 != null) goto L9;
        return false;
    L9:
        r1.remove(r2);
        removeView(r6);
        requestLayout();
        return true;
    L4:
        r4 = this.e;
        r0 = this.g;
        goto L5
    }

    @Override // android.view.View
    public final void onMeasure(int r18, int r19) {
        int r2 = View.MeasureSpec.getSize(r18);
        if (ViewCompat.getLayoutDirection(this) != 1) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        int r6 = getPaddingRight();
    L9:
        if (r3 == false) goto L11;
        int r4 = getPaddingLeft();
    L12:
        int r7 = getPaddingTop();
        int r8 = getPaddingBottom();
        int r9 = Math.max(0, (r2 - r6) - r4);
        Pair<Integer, Integer> r10 = g(this.d, this.f, r9, r19);
        Pair<Integer, Integer> r11 = g(this.e, this.g, r9, r19);
        int r12 = ((Number) r10.getFirst()).intValue();
        int r13 = ((Number) r11.getFirst()).intValue();
        int r14 = Math.max(r12, r13);
        View r15 = this.h;
        CenterHorizontalAlignment r5 = this.j;
        int r16 = g.a[r5.ordinal()];
        if (r16 != 1) goto L15;
        int r17 = 0;
        int r20 = Math.max(0, (r9 - r12) - r13);
    L20:
        if (r15 == null) goto L22;
        ViewGroup.LayoutParams r21 = r15.getLayoutParams();
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r22 = (ViewGroup.MarginLayoutParams) r21;
        r15.measure(View.MeasureSpec.makeMeasureSpec(Math.max(r17, (r20 - r22.leftMargin) - r22.rightMargin), Target.SIZE_ORIGINAL), ViewGroup.getChildMeasureSpec(r19, ((r7 + r8) + r22.topMargin) + r22.bottomMargin, r22.height));
        r15.getMeasuredWidth();
        r17 = (r15.getMeasuredHeight() + r22.topMargin) + r22.bottomMargin;
    L22:
        int r23 = Math.max(Math.max(((Number) r10.getSecond()).intValue(), ((Number) r11.getSecond()).intValue()), r17);
        int r1 = ViewGroup.resolveSize(Math.max(this.b, (r23 + r7) + r8), r19);
        setMeasuredDimension(ViewGroup.resolveSize(Math.max(r2, r6 + r4), r18), r1);
        return;
    L15:
        if (r16 != 2) goto L18;
        r17 = 0;
        r20 = Math.max(0, r9 - (r14 * 2));
        goto L20
    L18:
        throw new NoWhenBranchMatchedException();
    L11:
        r4 = getPaddingRight();
        goto L12
    L8:
        r6 = getPaddingLeft();
        goto L9
    L5:
        r3 = false;
        goto L6
    }

    public CoreNavigationBar(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = e(44.0f);
        int r5 = e(44.0f);
        this.b = r5;
        this.c = Math.max(1, e(0.5f));
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new LinkedHashMap();
        this.g = new LinkedHashMap();
        this.j = CenterHorizontalAlignment.CENTER;
        this.l = LazyKt.lazy(new CoreNavigationBar$defaultCenterView$2(this, r2));
        Paint r6 = new Paint(1);
        r6.setStyle(Paint.Style.FILL);
        this.p = r6;
        setMinimumHeight(r5);
        setClipToPadding(false);
        setWillNotDraw(false);
        f();
        setOnClickListener(a.a);
    }

    public /* synthetic */ CoreNavigationBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final Pair<Integer, Integer> g(List<? extends Object> r10, Map<Object, ? extends View> r11, int r12, int r13) {
        Iterator<T> r14 = r10.iterator();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r14.hasNext() == false) goto L15;
        LinkedHashMap r4 = (LinkedHashMap) r11;
        View r3 = (View) r4.get(r14.next());
        if (r3 == null) goto L4;
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
        int r7 = Math.max(0, (r12 - r6.leftMargin) - r6.rightMargin);
        int r8 = ViewGroup.getChildMeasureSpec(r13, ((getPaddingTop() + getPaddingBottom()) + r6.topMargin) + r6.bottomMargin, r6.height);
        r3.measure(View.MeasureSpec.makeMeasureSpec(r7, Target.SIZE_ORIGINAL), r8);
        int r9 = Math.max(this.a, r3.getMeasuredWidth());
        int r15 = Math.max(this.a, r3.getMeasuredHeight());
        if (r3.getMeasuredWidth() == r9) goto L11;
    L12:
        r3.measure(View.MeasureSpec.makeMeasureSpec(Math.min(r9, r7), 1073741824), View.MeasureSpec.makeMeasureSpec(r15, 1073741824));
    L13:
        int r16 = (r3.getMeasuredWidth() + r6.leftMargin) + r6.rightMargin;
        r1 = r1 + r16;
        r2 = Math.max(r2, (r3.getMeasuredHeight() + r6.topMargin) + r6.bottomMargin);
        goto L4
    L11:
        if (r3.getMeasuredHeight() == r15) goto L13;
    L15:
        return TuplesKt.to(Integer.valueOf(r1), Integer.valueOf(r2));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        int r1 = r21 - r19;
        int r2 = r22 - r20;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        int r6 = getPaddingRight();
    L9:
        if (r3 == false) goto L11;
        int r7 = getPaddingLeft();
    L12:
        int r8 = r1 - r7;
        int r9 = (getPaddingTop() + (r2 - getPaddingBottom())) / 2;
        int r10 = -1;
        int r11 = this.d.size() - 1;
        int r12 = r6;
    L14:
        if ((-1) >= r11) goto L24;
        View r13 = this.f.get(ListProtector.get(this.d, r11));
        if (r13 == null) goto L23;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        int r16 = r13.getMeasuredWidth();
        int r17 = r13.getMeasuredHeight();
        int r4 = r9 - (r17 / 2);
        int r110 = r17 + r4;
        int r111 = r12 + r15.leftMargin;
        int r5 = r111 + r16;
        if (r3 == true) goto L21;
        r13.layout(r111, r4, r5, r110);
    L22:
        r12 = r5 + r15.rightMargin;
        goto L23
    L21:
        int r112 = getWidth() - r111;
        r13.layout(r112 - r16, r4, r112, r110);
    L23:
        r11 = r11 - 1;
        goto L14
    L24:
        int r23 = this.e.size() - 1;
        int r24 = r8;
    L25:
        if (r10 >= r23) goto L40;
        View r25 = this.g.get(ListProtector.get(this.e, r23));
        if (r25 == null) goto L39;
        if (r25.getVisibility() != 0) goto L32;
        boolean r113 = true;
    L33:
        if (r113 == false) goto L39;
        ViewGroup.LayoutParams r114 = r25.getLayoutParams();
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114;
        int r116 = r25.getMeasuredWidth();
        int r117 = r25.getMeasuredHeight();
        int r118 = r9 - (r117 / 2);
        int r119 = r117 + r118;
        int r26 = r24 - r115.rightMargin;
        int r27 = r26 - r116;
        if (r3 == true) goto L37;
        r25.layout(r27, r118, r26, r119);
    L38:
        r24 = r27 - r115.leftMargin;
        goto L39
    L37:
        int r28 = getWidth() - r27;
        r25.layout(r28 - r116, r118, r28, r119);
        goto L38
    L32:
        r113 = false;
    L39:
        r23 = r23 - 1;
        r10 = -1;
        goto L25
    L40:
        View r29 = this.h;
        if (r29 == null) goto L62;
        ViewGroup.LayoutParams r30 = r29.getLayoutParams();
        Intrinsics.checkNotNull(r30, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r31 = (ViewGroup.MarginLayoutParams) r30;
        int r32 = r29.getMeasuredWidth();
        int r120 = r29.getMeasuredHeight();
        int r33 = r9 - (r120 / 2);
        int r121 = r120 + r33;
        int r122 = g.a[this.j.ordinal()];
        if (r122 != 1) goto L45;
        int r34 = Math.min(r12 + r31.leftMargin, (r24 - r31.rightMargin) - r32);
    L50:
        int r35 = r34 + r32;
        if (r3 == true) goto L53;
        r29.layout(r34, r33, r35, r121);
        return;
    L53:
        int r36 = r1 - r34;
        r29.layout(r36 - r32, r33, r36, r121);
        return;
    L45:
        if (r122 != 2) goto L48;
        int r37 = Math.max(r12 - r6, r8 - r24);
        int r38 = r6 + r37;
        r34 = r38 + ((Math.max(0, (r8 - r37) - r38) - r32) / 2);
        goto L50
    L48:
        throw new NoWhenBranchMatchedException();
    L62:
        return;
    L11:
        r7 = getPaddingRight();
        goto L12
    L8:
        r6 = getPaddingLeft();
        goto L9
    L5:
        r3 = false;
        goto L6
    }
}
