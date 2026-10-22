package com.ss.android.lark.chatwindow.view.preview;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.ui.ViewTransitionContainer;
import com.ss.android.lark.blueprint.recyclerview.BlueprintCellViewHolder;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.w0;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import w4b.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UrlPreviewCollapsingHelper<T extends BaseTextContentVO<?>> {
    public static final /* synthetic */ int o = 0;
    public final m2b.a a;
    public final y6b.a<T> b;
    public final l c;
    public final RecyclerView.ViewHolder d;
    public final ViewGroup e;
    public final View f;
    public final c g;
    public final ViewTransitionContainer<TextView> h;
    public final ImageView i;
    public final j j;
    public final Lazy k;
    public a l;
    public final String m;
    public CollapsingState n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chatwindow/view/preview/UrlPreviewCollapsingHelper$CollapsingState;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Default", "Collapsed", "Expanded", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CollapsingState extends Enum<CollapsingState> {
        public static final CollapsingState Collapsed = null;
        public static final a Companion = null;
        public static final CollapsingState Default = null;
        public static final CollapsingState Expanded = null;
        public static final /* synthetic */ CollapsingState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<CollapsingState> getEntries() {
            return b;
        }

        static {
            CollapsingState r0 = new CollapsingState("Default", 0);
            Default = r0;
            CollapsingState r1 = new CollapsingState("Collapsed", 1);
            Collapsed = r1;
            CollapsingState r3 = new CollapsingState("Expanded", 2);
            Expanded = r3;
            CollapsingState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new a();
        }

        public static CollapsingState[] values() {
            return (CollapsingState[]) a.clone();
        }

        public static CollapsingState valueOf(String r1) {
            return (CollapsingState) r27.a.a(CollapsingState.class, r1);
        }

        public CollapsingState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final boolean a;
        public final RecyclerView.ViewHolder b;
        public final View c;
        public final View d;
        public final View e;
        public final Function0<Unit> f;
        public final AnimatorSet g;
        public final int h;

        /* JADX INFO: renamed from: com.ss.android.lark.chatwindow.view.preview.UrlPreviewCollapsingHelper$a$a, reason: collision with other inner class name */
        public static final class C0119a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ a a;

            public C0119a(a r1) {
                this.a = r1;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r3) {
                Intrinsics.checkNotNullParameter(r3, "it");
                View r0 = this.a.d;
                Object r4 = r3.getAnimatedValue();
                Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
                r0.setRotation(((Float) r4).floatValue());
            }
        }

        public static final class b implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ a a;

            public b(a r1) {
                this.a = r1;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r3) {
                Intrinsics.checkNotNullParameter(r3, "it");
                View r0 = this.a.e;
                Object r4 = r3.getAnimatedValue();
                Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
                r0.setAlpha(((Float) r4).floatValue());
            }
        }

        public static final class c implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ a a;

            public c(a r1) {
                this.a = r1;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r3) {
                Intrinsics.checkNotNullParameter(r3, "it");
                ViewGroup.LayoutParams r0 = this.a.e.getLayoutParams();
                Object r4 = r3.getAnimatedValue();
                Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");
                r0.height = ((Integer) r4).intValue();
                this.a.e.setLayoutParams(r0);
            }
        }

        public static final class d extends AnimatorListenerAdapter {
            public final /* synthetic */ a a;

            public d(a r1) {
                this.a = r1;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r3) {
                Intrinsics.checkNotNullParameter(r3, "animation");
                super.onAnimationCancel(r3);
                a r4 = this.a;
                View r0 = r4.e;
                int r5 = r4.h;
                ViewGroup.LayoutParams r1 = r0.getLayoutParams();
                r1.height = r5;
                r0.setLayoutParams(r1);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r3) {
                Intrinsics.checkNotNullParameter(r3, "animation");
                super.onAnimationEnd(r3);
                a r4 = this.a;
                View r0 = r4.e;
                int r5 = r4.h;
                ViewGroup.LayoutParams r1 = r0.getLayoutParams();
                r1.height = r5;
                r0.setLayoutParams(r1);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
                super.onAnimationStart(r2);
                a r3 = this.a;
                if (r3.a == true) goto L6;
                r3.e.setVisibility(0);
                return;
            }
        }

        public static final class e implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ a a;

            public e(a r1) {
                this.a = r1;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r3) {
                Intrinsics.checkNotNullParameter(r3, "it");
                View r0 = this.a.c;
                Object r4 = r3.getAnimatedValue();
                Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");
                k.a(r0, ((Integer) r4).intValue());
            }
        }

        public static final class f extends AnimatorListenerAdapter {
            public final /* synthetic */ a a;
            public final /* synthetic */ int b;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
                super.onAnimationCancel(r2);
                k.a(this.a.c, this.b);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
                super.onAnimationEnd(r2);
                k.a(this.a.c, this.b);
            }

            public f(a r1, int r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public static final class g extends AnimatorListenerAdapter {
            public final /* synthetic */ a a;

            public g(a r1) {
                this.a = r1;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
                super.onAnimationCancel(r2);
                this.a.f.invoke();
                RecyclerView.ViewHolder r3 = this.a.b;
                if (r3 == null) goto L6;
                r3.setIsRecyclable(true);
                return;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
                super.onAnimationEnd(r2);
                this.a.f.invoke();
                RecyclerView.ViewHolder r3 = this.a.b;
                if (r3 == null) goto L6;
                r3.setIsRecyclable(true);
                return;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
                super.onAnimationStart(r2);
                RecyclerView.ViewHolder r3 = this.a.b;
                if (r3 == null) goto L6;
                r3.setIsRecyclable(false);
                return;
            }
        }

        public static final class h {
        }

        static {
        }

        public a(boolean r8, RecyclerView.ViewHolder r9, View r10, View r11, View r12, Function0<Unit> r13) {
            Intrinsics.checkNotNullParameter(r10, "entryView");
            Intrinsics.checkNotNullParameter(r11, "arrowView");
            Intrinsics.checkNotNullParameter(r12, "collapsedView");
            Intrinsics.checkNotNullParameter(r13, "completion");
            this.a = r8;
            this.b = r9;
            this.c = r10;
            this.d = r11;
            this.e = r12;
            this.f = r13;
            this.h = -2;
            float r14 = r11.getRotation();
            if (r8 == false) goto L5;
            float r15 = 180.0f;
        L6:
            ValueAnimator r16 = ValueAnimator.ofFloat(new float[]{r14, r15}).setDuration(300);
            r16.addUpdateListener(new C0119a(this));
            if (r8 == false) goto L9;
            float r4 = 0.0f;
        L10:
            if (r8 == true) goto L12;
            r12.setAlpha(0.0f);
        L12:
            ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{r12.getAlpha(), r4}).setDuration(300);
            r0.addUpdateListener(new b(this));
            int[] r5 = new int[2];
            r5[0] = r12.getHeight();
            if (r8 == false) goto L15;
            int r17 = 0;
        L16:
            r5[1] = r17;
            ValueAnimator r18 = ValueAnimator.ofInt(r5).setDuration(300);
            r18.addUpdateListener(new c(this));
            r18.addListener(new d(this));
            if (r8 == false) goto L19;
            int r19 = 0;
        L20:
            ValueAnimator r110 = ValueAnimator.ofInt(new int[]{r10.getPaddingBottom(), r19}).setDuration(300);
            r110.addUpdateListener(new e(this));
            r110.addListener(new f(this, r19));
            AnimatorSet r20 = new AnimatorSet();
            this.g = r20;
            r20.playTogether(new Animator[]{r16, r0, r18, r110});
            r20.setDuration(300);
            r20.addListener(new g(this));
            return;
        L19:
            r19 = UIHelper.dp2px(4.0f);
            goto L20
        L15:
            ViewParent r6 = r12.getParent();
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.view.ViewGroup");
            r12.measure(View.MeasureSpec.makeMeasureSpec(((ViewGroup) r6).getMeasuredWidth(), PluginList.LEVEL_NOT_SET), View.MeasureSpec.makeMeasureSpec(0, 0));
            r17 = r12.getMeasuredHeight();
            goto L16
        L9:
            r4 = 1.0f;
            goto L10
        L5:
            r15 = 360.0f;
            goto L6
        }
    }

    public static final class b {
    }

    public interface c {
        void a(String r1, boolean r2);
    }

    static {
    }

    public final void a() {
        if (((Boolean) this.k.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        a r0 = this.l;
        if (r0 == null) goto L8;
        r0.g.cancel();
        View r1 = r0.e;
        int r2 = r0.h;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        r3.height = r2;
        r1.setLayoutParams(r3);
    L8:
        Integer r4 = null;
        this.l = null;
        boolean r5 = true;
        if (this.e.getVisibility() == 8) goto L19;
        Object r6 = this.e.getTag(2131388118);
        if ((r6 instanceof Integer) == false) goto L14;
        r4 = (Integer) r6;
    L14:
        if (r4 == null) goto L16;
        int r7 = r4.intValue();
    L17:
        if (r7 <= 1) goto L19;
        boolean r8 = true;
    L21:
        if (r8 == false) goto L38;
        CollapsingState r9 = this.n;
        if (r9 != CollapsingState.Collapsed) goto L25;
    L28:
        boolean r10 = true;
    L29:
        if (r10 == false) goto L31;
        this.e.setVisibility(8);
    L37:
        this.f.setVisibility(0);
        this.f.setOnClickListener(this.j);
        c();
        return;
    L31:
        ViewGroup r11 = this.e;
        if (r11.getAlpha() == 1.0f) goto L35;
        r5 = false;
    L35:
        if (r5 == true) goto L37;
        r11.setAlpha(1.0f);
        goto L37
    L25:
        if (r9 == CollapsingState.Default) goto L28;
        r10 = false;
        goto L29
    L38:
        this.f.setVisibility(8);
        ViewGroup r12 = this.e;
        if (r12.getAlpha() == 1.0f) goto L42;
        r5 = false;
    L42:
        if (r5 == true) goto L46;
        r12.setAlpha(1.0f);
        return;
    L46:
        return;
    L16:
        r7 = 0;
    L19:
        r8 = false;
        goto L21
    }

    public final void c() {
        if (this.e.getVisibility() != 8) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.i.setRotation(180.0f);
        this.e.setAlpha(0.0f);
        d(2131891229, false);
        k.a(this.f, 0);
        return;
    L8:
        this.i.setRotation(360.0f);
        this.e.setAlpha(1.0f);
        d(2131891228, false);
        k.a(this.f, UIHelper.dp2px(4.0f));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void b(boolean r3) {
        if (r3 == false) goto L4;
        String r4 = "fold";
    L5:
        LinkedHashMap r0 = new LinkedHashMap();
        Map<String, Object> r1 = ChatParamUtils.f(this.a.getChatId());
        if (r1 == null) goto L8;
        r0.putAll(r1);
    L8:
        r0.putAll(ChatParamUtils.h(this.b));
        r0.putAll(ChatHitPointNew.a(this.b));
        r0.put("click", r4);
        Statistics.sendEvent("im_url_render_click", new JSONObject(r0));
        return;
    L4:
        r4 = "unfold";
        goto L5
    }

    public final void d(int r3, boolean r4) {
        final String r5 = UIHelper.getString(r3);
        this.h.update(r4, new UrlPreviewCollapsingHelper$updateBtnTitle$1(r5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UrlPreviewCollapsingHelper(m2b.a r2, y6b.a r3, l r4, BlueprintCellViewHolder r5, ViewGroup r6, View r7, w0 r8) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "fgDependency");
        Intrinsics.checkNotNullParameter(r6, "previewContainer");
        Intrinsics.checkNotNullParameter(r7, "collapseButton");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r7.findViewById(2131364862);
        this.i = (ImageView) r7.findViewById(R.id.icon);
        this.j = new j(this);
        this.k = LazyKt.lazy(new UrlPreviewCollapsingHelper$isFeatureEnabled$2(this));
        this.m = r3.getId();
        CollapsingState.a r9 = CollapsingState.Companion;
        Boolean r10 = ((BaseTextContentVO) r3.b()).D;
        r9.getClass();
        if (r10 != null) goto L6;
        CollapsingState r11 = CollapsingState.Default;
    L11:
        this.n = r11;
        return;
    L6:
        if (Intrinsics.areEqual(r10, Boolean.TRUE) == false) goto L9;
        r11 = CollapsingState.Collapsed;
        goto L11
    L9:
        if (Intrinsics.areEqual(r10, Boolean.FALSE) == false) goto L14;
        r11 = CollapsingState.Expanded;
        goto L11
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
