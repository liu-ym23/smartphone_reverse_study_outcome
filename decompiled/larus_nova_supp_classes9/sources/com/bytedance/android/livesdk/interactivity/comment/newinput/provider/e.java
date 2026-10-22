package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profit.privilege.model.danmu.DanmakuTabList;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.interactivity.api.IExpressionService;
import com.bytedance.android.livesdk.interactivity.api.comment.data.IntercomSyncDataModel;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentInputConfig;
import com.bytedance.android.livesdk.interactivity.comment.newinput.LivePortraitInputDialogV3;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.interactivity.comment.view.BarrageView;
import com.bytedance.android.livesdk.widget.EmojiEditView;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<c, z62.b> {
    public static final a g = null;
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g a;
    public final InputSectionType b;
    public final CompositeDisposable c;
    public final int d;
    public c e;
    public final d f;

    public static final class a implements z62.b {
        public a() {
        }

        @Override // z62.b
        public final void C(com.bytedance.android.live.base.model.data.activityemoji.b r2) {
            Intrinsics.checkNotNullParameter(r2, "activityEmoji");
        }

        @Override // z62.b
        public final int[] D() {
            return new int[]{0, 0};
        }

        @Override // z62.b
        public final void E() {
        }

        @Override // z62.b
        public final void c() {
        }

        @Override // z62.b
        public final int e() {
            return 0;
        }

        @Override // z62.b
        public final void g(com.bytedance.android.livesdk.interactivity.api.emoji.a r2) {
            Intrinsics.checkNotNullParameter(r2, "emoji");
        }

        @Override // z62.b
        public final void j(com.bytedance.android.livesdk.interactivity.api.emoji.a r2) {
            Intrinsics.checkNotNullParameter(r2, "emoji");
        }

        @Override // z62.b
        public final void l(Context r2, com.bytedance.android.live.base.model.message.h r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "activityEmoji");
            Intrinsics.checkNotNullParameter(r4, "text");
            Intrinsics.checkNotNullParameter(r5, "clickArea");
        }

        @Override // z62.b
        public final void o(Context r1, String r2) {
            Intrinsics.checkNotNullParameter(r2, "word");
        }

        @Override // z62.b
        public final void q(Context r1, String r2) {
            Intrinsics.checkNotNullParameter(r2, "word");
        }

        @Override // z62.b
        public final void t(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
        }

        @Override // z62.b
        public final long u() {
            return 0;
        }

        @Override // z62.b
        public final void w(TextWatcher r2) {
            Intrinsics.checkNotNullParameter(r2, "watcher");
        }

        @Override // z62.b
        public final void x(com.bytedance.android.live.profit.privilege.model.danmu.b r2) {
            Intrinsics.checkNotNullParameter(r2, "tabItem");
        }
    }

    public static final class b {
    }

    public final class c extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j {
        public HSImageView c;
        public BarrageView d;
        public FrameLayout e;
        public EmojiEditView f;
        public TextView g;
        public long h;
        public final com.bytedance.android.live.profit.privilege.a i;
        public boolean j;
        public final float k;
        public final CopyOnWriteArrayList<TextWatcher> l;
        public int m;
        public int n;
        public final C0127c o;
        public final f p;
        public final boolean q;
        public final b r;
        public final /* synthetic */ e s;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ c a;

            public a(c r1) {
                this.a = r1;
            }

            public final void accept(Object r4) {
                DanmakuTabList r5 = (DanmakuTabList) r4;
                InputSectionType r0 = null;
                if (r5 == null) goto L5;
                String r6 = r5.getErrorReason();
            L7:
                if (r6 != null) goto L9;
            L12:
                boolean r7 = true;
            L13:
                if (r7 == true) goto L15;
                this.a.i.isInDanmakuMode().setValue(Boolean.FALSE);
                this.a.h();
                return;
            L15:
                c r8 = this.a;
                if (r8.q == false) goto L20;
                com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r1 = r8.s.a;
                if (r1 == null) goto L33;
                r1.O(!c.g(r8));
                return;
            L33:
                return;
            L20:
                com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r9 = r8.s.a;
                if (r9 == null) goto L24;
                r0 = r9.Q();
            L24:
                if (r0 != InputSectionType.KEYBOARD) goto L28;
                com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r10 = this.a.s.a;
                if (r10 == null) goto L35;
                r10.x0();
                return;
            L35:
                return;
            L28:
                c r11 = this.a;
                com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2 = r11.s.a;
                if (r2 == null) goto L37;
                r2.O(!c.g(r11));
                return;
            L37:
                return;
            L9:
                if (r6.length() == 0) goto L12;
                r7 = false;
                goto L13
            L5:
                r6 = null;
                goto L7
            }
        }

        public static final class b implements InputFilter {
            public final /* synthetic */ c a;

            public b(c r1) {
                this.a = r1;
            }

            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence r1, int r2, int r3, Spanned r4, int r5, int r6) {
                if (this.a.l() == false) goto L11;
                Context r7 = this.a.b.getContext();
                com.bytedance.android.livesdk.interactivity.api.quickcomment.f r8 = this.a.b.Y();
                if (r8 == null) goto L7;
                String r9 = r8.getFixCommentToast();
            L8:
                IESUIUtils.displayToast(r7, r9);
                return BuildConfig.FLAVOR;
            L7:
                r9 = null;
                goto L8
            L11:
                return BuildConfig.FLAVOR;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.newinput.provider.e$c$c, reason: collision with other inner class name */
        public static final class C0127c implements EmojiEditView.a {
            public final /* synthetic */ c a;

            public final void a() {
                com.bytedance.android.livesdk.interactivity.comment.newinput.c r0 = this.a.b.V();
                if (r0 == null) goto L13;
                com.bytedance.android.livesdk.interactivity.comment.newinput.a r1 = r0.g;
                if (r1 != null) goto L7;
                return;
            L7:
                if (TextUtils.equals(r1.a, "non_paste") == true) goto L10;
                r1 = null;
            L10:
                if (r1 == null) goto L15;
                Intrinsics.checkNotNullParameter("pure_paste", "<set-?>");
                r1.a = "pure_paste";
                return;
            L15:
                return;
            }

            public C0127c(c r1) {
                this.a = r1;
            }
        }

        public static final class d<T> implements Consumer {
            public final /* synthetic */ c a;
            public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.emoji.a b;
            public final /* synthetic */ boolean c;
            public final /* synthetic */ Editable d;

            public d(c r1, com.bytedance.android.livesdk.interactivity.api.emoji.a r2, boolean r3, Editable r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            public final void accept(Object r17) {
                Bitmap r1 = (Bitmap) r17;
                com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r3 = this.a.s.a;
                if (r3 == null) goto L7;
                Activity r4 = r3.getActivity();
                if (r4 == null) goto L7;
                Resources r5 = r4.getResources();
            L8:
                BitmapDrawable r2 = new BitmapDrawable(r5, r1);
                float r6 = r1.getWidth() / (r1.getHeight() + 0.0f);
                int r7 = com.bytedance.android.live.core.utils.s1.f(18.0f);
                com.bytedance.android.livesdk.interactivity.comment.input.c r8 = new com.bytedance.android.livesdk.interactivity.comment.input.c(r2, this.b, (int) (r6 * r7), r7);
                String r9 = r8.c();
                SpannableStringBuilder r10 = new SpannableStringBuilder(r9);
                int r11 = 0;
                r10.setSpan(r8, 0, r9.length(), 33);
                if (this.c == false) goto L62;
                c r13 = this.a;
                Editable r14 = this.d;
                com.bytedance.android.livesdk.interactivity.api.emoji.a r15 = this.b;
                r13.getClass();
                List<String> r16 = r15.e();
                boolean r18 = true;
                if (r16 == null) goto L29;
                TokenCert r19 = b72.a.a;
                Intrinsics.checkNotNullParameter(r16, "strs");
                StringBuilder r20 = new StringBuilder();
                List r21 = CollectionsKt.toMutableList(r16);
                ArrayList r23 = new ArrayList();
                b72.a.a(r21, 0, r23, r20);
                String r24 = r14.toString();
                Iterator r25 = r23.iterator();
            L14:
                if (r25.hasNext() == false) goto L29;
                String r26 = (String) r25.next();
                if (StringsKt.contains(r24, r26, true) == false) goto L14;
                int r110 = StringsKt.lastIndexOf$default(r24, r26, 0, false, 6, null);
                if (r110 < 0) goto L14;
                Object[] r111 = r14.getSpans(r110, r26.length() + r110, Object.class);
                int r112 = r111.length;
                int r113 = 0;
                boolean r114 = false;
            L20:
                if (r113 >= r112) goto L27;
                Object r115 = r111[r113];
                if ((r115 instanceof e90.a) == false) goto L26;
                if ((r115 instanceof eb2.a) == true) goto L26;
                r114 = true;
            L26:
                r113 = r113 + 1;
                goto L20
            L27:
                if (r114 == true) goto L14;
                r14.delete(r110, r26.length() + r110);
                r14.insert(r110, r10);
                boolean r27 = true;
            L30:
                if (r27 == false) goto L33;
                r13 = null;
            L33:
                if (r13 == null) goto L88;
                c r28 = this.a;
                Editable r29 = this.d;
                com.bytedance.android.livesdk.interactivity.api.emoji.a r30 = this.b;
                r28.getClass();
                eb2.a[] r31 = (eb2.a[]) r29.getSpans(0, r29.toString().length(), eb2.a.class);
                int r33 = r31.length - 1;
            L35:
                if (r33 < 0) goto L51;
                if (r31[r33] == null) goto L50;
                List<String> r34 = r30.e();
                if (r34 == null) goto L50;
                if (CollectionsKt.contains(r34, r31[r33].c) != true) goto L50;
                int r35 = r29.getSpanStart(r31[r33]);
                int r36 = r29.getSpanEnd(r31[r33]);
                e90.a[] r37 = (e90.a[]) r29.getSpans(r35, r36, e90.a.class);
                int r38 = r37.length;
                int r116 = 0;
            L44:
                if (r116 >= r38) goto L49;
                if ((r37[r116] instanceof eb2.a) == false) goto L51;
                r116 = r116 + 1;
                goto L44
            L49:
                r29.delete(r35, r36);
                r29.insert(r35, r10);
            L52:
                if (r18 == true) goto L54;
                c r39 = r13;
            L55:
                if (r39 == null) goto L89;
                Editable r40 = this.d;
                com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r41 = r39.s.a;
                if (r41 == null) goto L61;
                EditText r43 = r41.a;
                if (r43 == null) goto L61;
                r11 = r43.getSelectionStart();
            L61:
                r40.insert(r11, r10);
                return;
            L89:
                return;
            L54:
                r39 = null;
            L50:
                r33 = r33 - 1;
            L51:
                r18 = false;
                goto L52
            L88:
                return;
            L29:
                r27 = false;
                goto L30
            L62:
                c r44 = this.a;
                Editable r45 = this.d;
                com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r46 = r44.s.a;
                if (r46 == null) goto L67;
                EditText r47 = r46.a;
                if (r47 == null) goto L67;
                r11 = r47.getSelectionStart();
            L67:
                r45.insert(r11, r10);
                return;
            L7:
                r5 = null;
                goto L8
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.newinput.provider.e$c$e, reason: collision with other inner class name */
        public static final class C0128e<T> implements Consumer {
            public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.emoji.a a;

            public C0128e(com.bytedance.android.livesdk.interactivity.api.emoji.a r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                com.bytedance.android.livesdk.interactivity.comment.utils.g.a("input fusion emoji failed due to " + ((Throwable) r3).getMessage() + ", emoji id: " + this.a.c());
            }
        }

        public static final class f implements TextWatcher {
            public final /* synthetic */ c a;
            public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g b;

            public static final class a implements Runnable {
                public final /* synthetic */ f a;

                public a(f r1) {
                    this.a = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    c r0 = this.a.a;     // Catch: Throwable -> L10
                    EmojiEditView r1 = r0.f;     // Catch: Throwable -> L10
                    if (r1 == null) goto L5;
                    int r2 = r1.getHeight();     // Catch: Throwable -> L10
                L6:
                    f r3 = this.a;     // Catch: Throwable -> L10
                    c r4 = r3.a;     // Catch: Throwable -> L10
                    if (r4.n == r2) goto L13;
                    r4.n = r2;     // Catch: Throwable -> L10
                    r3.b.t0();     // Catch: Throwable -> L10
                    return;
                L13:
                    return;
                L5:
                    r2 = r0.n;     // Catch: Throwable -> L10
                L10:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == true) goto L17;
                    throw th;
                }
            }

            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            }

            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable r5) {
                com.bytedance.android.livesdk.interactivity.comment.newinput.c r0 = this.a.b.V();
                CharSequence r1 = null;
                if (r0 == null) goto L12;
                com.bytedance.android.livesdk.interactivity.comment.newinput.a r2 = r0.g;
                if (r2 == null) goto L12;
                if (TextUtils.equals(r2.a, "pure_paste") == true) goto L10;
                r2 = null;
            L10:
                if (r2 == null) goto L12;
                Intrinsics.checkNotNullParameter("edit_with_paste", "<set-?>");
                r2.a = "edit_with_paste";
            L12:
                EmojiEditView r3 = this.a.f;
                if (r3 == null) goto L15;
                r1 = r3.getText();
            L15:
                if (r1 != null) goto L19;
                r1 = BuildConfig.FLAVOR;
            L19:
                if (TextUtils.isEmpty(r1) == false) goto L23;
                this.b.d(false);
                TextView r4 = this.a.g;
                if (r4 == null) goto L27;
                UtilityKotlinExtentionsKt.w(r4);
            L27:
                if (this.b.Q() == InputSectionType.NONE) goto L31;
                EmojiEditView r6 = this.a.f;
                if (r6 == null) goto L31;
                r6.post(new a(this));
            L31:
                com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r7 = this.b;
                r7.e = r7.d;
                r7.d = 0;
                c r8 = this.a;
                EmojiEditView r9 = r8.f;
                if (r9 == null) goto L34;
                TokenCert r10 = b72.a.a;
                r8.m = b72.a.c(r9, r8.m());
            L34:
                if (r5 == null) goto L39;
                Iterator<TextWatcher> r11 = this.a.l.iterator();
            L37:
                if (r11.hasNext() == false) goto L39;
                r11.next().afterTextChanged(r5);
            L39:
                this.a.h = System.currentTimeMillis();
                return;
            L23:
                this.b.d(true);
                TextView r13 = this.a.g;
                if (r13 == null) goto L27;
                UtilityKotlinExtentionsKt.t(r13);
                goto L27
            }

            public f(c r1, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public final boolean i() {
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.s.a;
            if (r0 == null) goto L11;
            com.bytedance.android.livesdk.interactivity.comment.newinput.c r1 = r0.V();
            if (r1 == null) goto L11;
            com.bytedance.android.livesdk.interactivity.comment.newinput.a r2 = r1.g;
            if (r2 == null) goto L11;
            if (r2.b != true) goto L11;
            return true;
        L11:
            return false;
        }

        public final String j() {
            if (this.b.k0() == true) goto L5;
            com.bytedance.android.livesdk.interactivity.comment.newinput.c r0 = this.b.V();
            if (r0 == null) goto L23;
            com.bytedance.android.livesdk.interactivity.comment.newinput.a r1 = r0.g;
            if (r1 == null) goto L23;
            x22.a r2 = r1.e;
            if (r2 == null) goto L23;
            String r3 = r2.a;
            if (r3 == null) goto L23;
            if (r3.length() <= 0) goto L17;
            boolean r4 = true;
        L18:
            if (r4 == true) goto L21;
            r3 = null;
        L21:
            if (r3 == null) goto L23;
            return r3;
        L17:
            r4 = false;
        L23:
            return com.bytedance.android.live.core.utils.s1.B(2131922325);
        L5:
            return com.bytedance.android.live.core.utils.s1.B(2131915379);
        }

        public final void k() {
            com.bytedance.android.live.profit.privilege.a r0 = this.i;
            if (r0 == null) goto L6;
            this.s.c.add(r0.getDanmakuTabList().a().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this)));
            return;
        }

        public final boolean l() {
            com.bytedance.android.livesdk.interactivity.api.quickcomment.f r0 = this.b.Y();
            if (r0 != null) goto L5;
        L11:
            return false;
        L5:
            if (r0.isFixedComment() != true) goto L11;
            CommentFlowContext r1 = this.b.S();
            if (r1 != null) goto L9;
            return true;
        L9:
            if (y22.b.a(r1) == true) goto L11;
            return true;
        }

        public final boolean m() {
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.s.a;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.m0() != true) goto L7;
            return true;
        }

        public final void n() {
            BarrageView r0 = this.d;
            if (r0 == null) goto L5;
            r0.b.setSelected(true);
            ((TransitionDrawable) r0.a.getBackground()).startTransition(100);
            ((TransitionDrawable) r0.b.getBackground()).startTransition(100);
            r0.b.animate().translationXBy(UIUtils.dip2Px(r0.getContext(), 18.0f)).setDuration(100).start();
            r0.f = true;
            r0.b(true);
        L5:
            this.j = true;
            com.bytedance.android.live.profit.privilege.a r1 = this.i;
            if (r1 == null) goto L9;
            r1.jl();
            return;
        }

        public final void h() {
            if (i() == false) goto L36;
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.s.a;
            if (r0 == null) goto L7;
            r0.O(false);
        L7:
            HSImageView r1 = this.c;
            py.k r2 = null;
            if (r1 == null) goto L11;
            r1.setBackground(null);
        L11:
            if (m() == false) goto L33;
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r3 = this.s.a;
            if (r3 == null) goto L21;
            com.bytedance.android.livesdk.interactivity.comment.newinput.c r4 = r3.V();
            if (r4 == null) goto L21;
            com.bytedance.android.livesdk.interactivity.comment.newinput.a r5 = r4.g;
            if (r5 == null) goto L21;
            com.bytedance.android.live.profit.privilege.model.danmu.b r6 = r5.d;
            if (r6 == null) goto L21;
            py.k r7 = r6.getEntranceImg();
        L22:
            if (r7 == null) goto L33;
            HSImageView r8 = this.c;
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r9 = this.s.a;
            if (r9 == null) goto L32;
            com.bytedance.android.livesdk.interactivity.comment.newinput.c r10 = r9.V();
            if (r10 == null) goto L32;
            com.bytedance.android.livesdk.interactivity.comment.newinput.a r11 = r10.g;
            if (r11 == null) goto L32;
            com.bytedance.android.live.profit.privilege.model.danmu.b r13 = r11.d;
            if (r13 == null) goto L32;
            r2 = r13.getEntranceImg();
        L32:
            ImageUtil.loadImage(r8, r2, 0);
            return;
        L21:
            r7 = null;
        L33:
            HSImageView r14 = this.c;
            if (r14 == null) goto L53;
            r14.setActualImageResource(2131251922);
            return;
        L53:
            return;
        L36:
            BarrageView r15 = this.d;
            if (r15 != null) goto L39;
        L42:
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r16 = this.s.a;
            if (r16 == null) goto L45;
            r16.O(false);
        L45:
            TextView r17 = this.g;
            if (r17 == null) goto L48;
            r17.setText(j());
        L48:
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r18 = this.s.a;
            if (r18 == null) goto L55;
            r18.t0();
            return;
        L55:
            return;
        L39:
            if (r15.f == false) goto L42;
            r15.b(false);
            r15.b.setSelected(false);
            ((TransitionDrawable) r15.a.getBackground()).reverseTransition(100);
            ((TransitionDrawable) r15.b.getBackground()).reverseTransition(100);
            r15.b.animate().translationXBy(-UIUtils.dip2Px(r15.getContext(), 18.0f)).setDuration(100).start();
            r15.f = false;
            goto L42
        }

        public static final boolean g(c r1) {
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2 = r1.s.a;
            if (r2 != null) goto L5;
        L7:
            return false;
        L5:
            if (r2.l0() != true) goto L7;
            return true;
        }

        public final void o(com.bytedance.android.livesdk.interactivity.api.emoji.a r8, boolean r9) {
            Intrinsics.checkNotNullParameter(r8, "fusionEmoji");
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.s.a;
            if (r0 == null) goto L18;
            EditText r1 = r0.a;
            if (r1 == null) goto L19;
            Editable r2 = r1.getEditableText();
            if (r2 == null) goto L20;
            com.bytedance.android.livesdk.interactivity.api.emoji.e r3 = com.bytedance.android.livesdk.interactivity.api.q.d();
            if (r3 == null) goto L16;
            Long r4 = r8.b();
            if (r4 == null) goto L14;
            long r5 = r4.longValue();
        L15:
            r3.a(r5, r8, System.currentTimeMillis());
            goto L16
        L14:
            r5 = 0;
        L16:
            com.bytedance.android.livesdk.chatroom.utils.a1.k(r8.a()).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, r8, r9, r2), new C0128e(r8));
            return;
        L20:
            return;
        L19:
            return;
        }

        public c(e r2, View r3, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "panelBridge");
            this.s = r2;
            super(r3, r4);
            this.i = yt0.c.i();
            this.k = 15.0f;
            this.l = new CopyOnWriteArrayList();
            this.o = new C0127c(this);
            this.p = new f(this, r4);
            this.q = r4.n0();
            this.r = new b(this);
        }
    }

    public static final class d implements z62.b {
        public final /* synthetic */ e a;

        @Override // z62.b
        public final int[] D() {
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.a.a;
            if (r0 == null) goto L9;
            EditText r1 = r0.a;
            if (r1 == null) goto L9;
            return new int[]{r1.getSelectionStart(), r1.getSelectionEnd()};
        L9:
            return new int[]{0, 0};
        }

        @Override // z62.b
        public final void E() {
            c r0 = this.a.e;
            if (r0 == null) goto L13;
            r0.j = false;
            if (r0.i() == true) goto L14;
            BarrageView r2 = r0.d;
            if (r2 == null) goto L9;
            r2.b(false);
        L9:
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r1 = r0.s.a;
            if (r1 == null) goto L15;
            r1.t0();
            return;
        L15:
            return;
        L14:
            return;
        }

        @Override // z62.b
        public final void c() {
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.a.a;     // Catch: Exception -> L16
            if (r0 == null) goto L9;
            EditText r1 = r0.a;     // Catch: Exception -> L16
            if (r1 == null) goto L9;
            Editable r2 = r1.getText();     // Catch: Exception -> L16
            if (r2 == null) goto L9;
            int r3 = r2.length();     // Catch: Exception -> L16
        L10:
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r4 = this.a.a;     // Catch: Exception -> L16
            if (r4 == null) goto L21;
            EditText r5 = r4.a;     // Catch: Exception -> L16
            if (r5 == null) goto L22;
            r5.setSelection(r3);     // Catch: Exception -> L16
            return;
        L22:
            return;
        L21:
            return;
        L9:
            r3 = 0;
        L16:
            e = move-exception;
            com.bytedance.android.livesdk.log.b0 r6 = com.bytedance.android.livesdk.log.b0.o();
            StackTraceElement[] r7 = e.getStackTrace();
            r6.getClass();
            com.bytedance.android.live.core.log.g.m(6, r7);
        }

        @Override // z62.b
        public final int e() {
            c r0 = this.a.e;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.m;
        }

        @Override // z62.b
        public final long u() {
            c r0 = this.a.e;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.h;
        }

        public d(e r1) {
            this.a = r1;
        }

        @Override // z62.b
        public final void C(com.bytedance.android.live.base.model.data.activityemoji.b r5) {
            Intrinsics.checkNotNullParameter(r5, "activityEmoji");
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.a.a;
            if (r0 == null) goto L9;
            EditText r1 = r0.a;
            if (r1 == null) goto L9;
            Editable r2 = r1.getEditableText();
            if (r2 == null) goto L9;
            int r3 = ((com.bytedance.android.livesdk.interactivity.comment.input.a[]) r2.getSpans(0, r2.length(), com.bytedance.android.livesdk.interactivity.comment.input.a.class)).length;
        L10:
            int r4 = this.a.d;
            if (r3 < r4) goto L14;
            com.bytedance.android.live.core.utils.f2.c(com.bytedance.android.live.core.utils.s1.C(2131919201, new Object[]{Integer.valueOf(r4)}), 0);
            return;
        L14:
            Observable.just(r5).flatMap(new s()).subscribe(new t(this, r5), new u(r5));
            return;
        L9:
            r3 = 0;
            goto L10
        }

        @Override // z62.b
        public final void g(com.bytedance.android.livesdk.interactivity.api.emoji.a r3) {
            Intrinsics.checkNotNullParameter(r3, "emoji");
            c r0 = this.a.e;
            if (r0 == null) goto L6;
            r0.o(r3, false);
            return;
        }

        @Override // z62.b
        public final void j(com.bytedance.android.livesdk.interactivity.api.emoji.a r3) {
            Intrinsics.checkNotNullParameter(r3, "emoji");
            c r0 = this.a.e;
            if (r0 == null) goto L6;
            r0.o(r3, true);
            return;
        }

        @Override // z62.b
        public final void t(Context r8) {
            Intrinsics.checkNotNullParameter(r8, "context");
            int r1 = b72.c.a;
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2 = this.a.a;
            if (r2 == null) goto L5;
            EditText r3 = r2.a;
        L6:
            Intrinsics.checkNotNullParameter(r8, "context");
            if (r3 == null) goto L11;
            View r9 = LayoutInflater.from(r8).inflate(2131565318, null, false);
            r9.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            r9.layout(0, 0, r9.getMeasuredWidth(), r9.getMeasuredHeight());
            Bitmap r0 = Bitmap.createBitmap(r9.getMeasuredWidth(), r9.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            r9.draw(new Canvas(r0));
            BitmapDrawable r4 = new BitmapDrawable(r9.getResources(), r0);
            int r10 = com.bytedance.android.live.core.utils.s1.f(24.0f);
            com.bytedance.android.livesdk.interactivity.comment.input.e r5 = new com.bytedance.android.livesdk.interactivity.comment.input.e(r4, com.bytedance.android.live.core.utils.s1.B(2131920489), (int) ((r0.getWidth() / r0.getHeight()) * r10), r10);
            String r11 = r5.f;
            SpannableStringBuilder r6 = new SpannableStringBuilder(r11);
            r6.setSpan(r5, 0, r11.length(), 33);
            r3.setText(r6);
            return;
        L11:
            return;
        L5:
            r3 = null;
            goto L6
        }

        @Override // z62.b
        public final void w(TextWatcher r2) {
            Intrinsics.checkNotNullParameter(r2, "watcher");
            c r0 = this.a.e;
            if (r0 == null) goto L8;
            CopyOnWriteArrayList<TextWatcher> r1 = r0.l;
            if (r1 == null) goto L9;
            r1.add(r2);
            return;
        L9:
            return;
        }

        @Override // z62.b
        public final void x(com.bytedance.android.live.profit.privilege.model.danmu.b r5) {
            Intrinsics.checkNotNullParameter(r5, "tabItem");
            c r1 = this.a.e;
            if (r1 == null) goto L52;
            Intrinsics.checkNotNullParameter(r5, "tabItem");
            if (r1.i() == false) goto L41;
            if (r5.getStyle() != 21) goto L26;
            com.bytedance.android.livesdk.interactivity.comment.newinput.c r6 = r1.b.V();
            if (r6 == null) goto L13;
            com.bytedance.android.livesdk.interactivity.comment.newinput.a r7 = r6.g;
            if (r7 == null) goto L13;
            r7.e = null;
        L13:
            com.bytedance.android.live.profit.privilege.a r8 = r1.i;
            if (r8 == null) goto L18;
            com.bytedance.live.datacontext.m r9 = r8.isInDanmakuMode();
            if (r9 == null) goto L18;
            r9.setValue(Boolean.FALSE);
        L18:
            TextView r10 = r1.g;
            if (r10 == null) goto L22;
            r10.setText(r1.j());
        L22:
            if (r1.q == true) goto L53;
            HSImageView r11 = r1.c;
            if (r11 == null) goto L54;
            r11.setActualImageResource(2131251922);
            return;
        L54:
            return;
        L53:
            return;
        L26:
            TextView r0 = r1.g;
            if (r0 == null) goto L29;
            r0.setText(r5.getCommentToast());
        L29:
            com.bytedance.android.live.profit.privilege.a r2 = r1.i;
            if (r2 == null) goto L35;
            com.bytedance.live.datacontext.m r3 = r2.isInDanmakuMode();
            if (r3 == null) goto L35;
            r3.setValue(Boolean.TRUE);
        L35:
            if (r1.q == true) goto L56;
            HSImageView r4 = r1.c;
            if (r4 == null) goto L39;
            r4.setBackground(null);
        L39:
            ImageUtil.loadImage(r1.c, r5.getEntranceImg(), 0);
            return;
        L56:
            return;
        L41:
            if (r5.getStyle() != 21) goto L43;
            r1.h();
            return;
        L43:
            TextView r13 = r1.g;
            if (r13 == null) goto L46;
            r13.setText(r5.getCommentToast());
        L46:
            com.bytedance.android.live.profit.privilege.a r14 = r1.i;
            if (r14 == null) goto L59;
            com.bytedance.live.datacontext.m r15 = r14.isInDanmakuMode();
            if (r15 == null) goto L60;
            r15.setValue(Boolean.TRUE);
            return;
        L60:
            return;
        L59:
            return;
        }

        @Override // z62.b
        public final void o(Context r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "word");
            int r4 = b72.c.a;
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5 = this.a.a;
            if (r5 == null) goto L5;
            EditText r6 = r5.a;
        L6:
            if (r6 == null) goto L13;
            int r0 = r6.getSelectionStart();
            Editable r7 = r6.getEditableText();
            if (r7 == null) goto L12;
            r7.insert(r0, r3);
            return;
        L12:
            return;
        L13:
            return;
        L5:
            r6 = null;
            goto L6
        }

        @Override // z62.b
        public final void q(Context r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "word");
            int r4 = b72.c.a;
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5 = this.a.a;
            if (r5 == null) goto L5;
            EditText r6 = r5.a;
        L6:
            if (r6 == null) goto L13;
            int r0 = r6.getSelectionStart();
            Editable r7 = r6.getEditableText();
            if (r7 == null) goto L12;
            r7.insert(r0, r3);
            return;
        L12:
            return;
        L13:
            return;
        L5:
            r6 = null;
            goto L6
        }

        @Override // z62.b
        public final void l(Context r13, com.bytedance.android.live.base.model.message.h r14, String r15, String r16) {
            Intrinsics.checkNotNullParameter(r13, "context");
            Intrinsics.checkNotNullParameter(r14, "guideChatConf");
            Intrinsics.checkNotNullParameter(r15, "text");
            Intrinsics.checkNotNullParameter(r16, "clickArea");
            int r4 = b72.c.a;
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5 = this.a.a;
            if (r5 == null) goto L5;
            EditText r6 = r5.a;
        L6:
            EditText r10 = r6;
            Intrinsics.checkNotNullParameter(r13, "context");
            Intrinsics.checkNotNullParameter(r14, "guideChatConf");
            Intrinsics.checkNotNullParameter(r15, "text");
            Intrinsics.checkNotNullParameter(r16, "clickArea");
            if (r10 == null) goto L26;
            Editable r0 = r10.getEditableText();
            if (r0 == null) goto L18;
            com.bytedance.android.livesdk.interactivity.comment.input.d[] r1 = (com.bytedance.android.livesdk.interactivity.comment.input.d[]) r0.getSpans(0, r0.length(), com.bytedance.android.livesdk.interactivity.comment.input.d.class);
            int r2 = r1.length;
            int r7 = 0;
        L12:
            if (r7 >= r2) goto L18;
            com.bytedance.android.livesdk.interactivity.comment.input.d r8 = r1[r7];
            if (Intrinsics.areEqual(r8.getDesc(), r14.c()) == true) goto L15;
            r7 = r7 + 1;
            goto L12
        L15:
            r0.delete(r0.getSpanStart(r8), r0.getSpanEnd(r8));
            com.bytedance.android.livesdk.interactivity.comment.utils.a.f(r14, r16, false);
            return;
        L18:
            if (r14.a() == null) goto L20;
            com.bytedance.android.livesdk.chatroom.utils.a1.k(r14.a()).map(new b72.e(r13, r14, r15)).onErrorReturn(new b72.f(r13, r14, r15)).compose(RxUtil.rxSchedulerHelper()).subscribe(new b72.g(r15, r16, r10), new b72.h(r14, r13, r15, r16, r10));
            return;
        L20:
            b72.c.b(com.bytedance.android.livesdk.interactivity.api.expression.h.a(r13, r14, r15), r14, r15, r16, r10);
            return;
        L26:
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r1) {
    }

    static {
        g = new a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
        c r0 = this.e;
        if (r0 == null) goto L11;
        r0.s.c.clear();
        r0.j = false;
        EmojiEditView r1 = r0.f;
        if (r1 == null) goto L7;
        c.C0127c r2 = r0.o;
        r1.d.remove(r2);
    L7:
        r0.l.clear();
        com.bytedance.android.livesdk.interactivity.api.emoji.e r3 = com.bytedance.android.livesdk.interactivity.api.q.d();
        if (r3 == null) goto L12;
        r3.c();
        return;
    L12:
        return;
    }

    public e() {
        this.b = InputSectionType.CONTENT;
        this.c = new CompositeDisposable();
        this.d = ((Integer) ec2.d0.a.getValue()).intValue();
        this.f = new d(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.e;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r18) {
        Intrinsics.checkNotNullParameter(r18, "panelBridge");
        Activity r2 = r18.getActivity();
        String r3 = null;
        if (r2 != null) goto L5;
        return null;
    L5:
        this.a = r18;
        if (r18.n0() == false) goto L8;
        View r4 = LayoutInflater.from(r2).inflate(2131567696, null);
    L9:
        c r5 = new c(this, r4, r18);
        r5.e = (FrameLayout) r5.a.findViewById(2131371464);
        CommentFlowContext r0 = r5.b.S();
        FrameLayout r6 = r5.e;
        if (r6 == null) goto L12;
        r6.getPaddingRight();
    L12:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r7 = r5.s.a;
        if (r7 == null) goto L48;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r8 = r7.V();
        if (r8 == null) goto L48;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r9 = r8.g;
        if (r9 == null) goto L48;
        u22.m.a r10 = r9.j;
        if (r10 == null) goto L48;
        String r11 = r10.d;
        IMiddlewareUserService r13 = jc1.k.f(IMiddlewareUserService.class);
        if (r13 == null) goto L25;
        com.bytedance.android.livesdk.user.e r14 = r13.user();
        if (r14 == null) goto L25;
        String r15 = r14.n();
    L27:
        if ((!Intrinsics.areEqual(r11, r15)) == false) goto L33;
        IBaseUser r16 = r10.j;
        if (r16 != null) goto L31;
    L32:
        boolean r17 = true;
    L34:
        if (r17 == true) goto L37;
        r10 = null;
    L37:
        if (r10 == null) goto L48;
        if (r0 == null) goto L43;
        CommentInputConfig r19 = r0.d;
        if (r19 == null) goto L42;
        boolean r20 = r19.s;
    L44:
        if (r20 == false) goto L46;
        final int r21 = 2131108369;
    L47:
        com.bytedance.android.livesdk.interactivity.api.expression.c r23 = new com.bytedance.android.livesdk.interactivity.api.expression.c(com.bytedance.android.live.liveinteract.f.a(r21, new ContentSectionProvider$ContentSectionController$initEmojiEditView$mentionEditTextParam$2$1(r21)), r10.e, r10.d.toString(), r10.i, r10.j, false);
    L56:
        if (r0 == null) goto L61;
        CommentInputConfig r1 = r0.d;
        if (r1 == null) goto L60;
        boolean r24 = r1.s;
    L62:
        IExpressionService r25 = (IExpressionService) jc1.k.n(IExpressionService.class);
        if (r24 == false) goto L69;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r26 = r5.s.a;
        if (r26 == null) goto L67;
        Context r27 = r26.getContext();
    L68:
        int r28 = LivePortraitInputDialogV3.L;
        EmojiEditView r29 = r25.createEmojiEditText(r27, LivePortraitInputDialogV3.a.a(), r23);
    L74:
        if (r29 == null) goto L380;
        EmojiEditView r30 = r29;
        FrameLayout.LayoutParams r31 = new FrameLayout.LayoutParams(-1, -2);
        r31.gravity = 8388627;
        r30.setLayoutParams(r31);
        r30.setImeOptions(268435460);
        r30.setInputType(1);
        r30.setLineSpacing(com.bytedance.android.live.core.utils.s1.f(3.0f), r30.getLineSpacingMultiplier());
        r30.setTextAlignment(5);
        r30.setTextColor(com.bytedance.android.live.core.utils.s1.h(2131107788));
        r30.setTextSize(1, r5.k);
        if (r5.b.n0() == false) goto L78;
        r30.setInputType(131072);
        r30.setSingleLine(false);
        r30.setPadding(0, 0, 0, 0);
        r30.setMaxLines(3);
        r30.setHorizontallyScrolling(false);
    L79:
        r30.setOnEditorActionListener(r.a);
        r30.setBackground(null);
        Field r33 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: Exception -> L82
        r33.setAccessible(true);     // Catch: Exception -> L82
        r33.set(r30, 2131250389);     // Catch: Exception -> L82
    L85:
        if (Build.VERSION.SDK_INT < 26) goto L87;
        r30.setImportantForAutofill(2);
    L87:
        FrameLayout r34 = r5.e;
        if (r34 == null) goto L90;
        r34.addView(r30);
    L90:
        r5.f = r30;
        r5.c = r5.a.findViewById(2131367816);
        r5.d = (BarrageView) r5.a.findViewById(2131363971);
        r5.g = (TextView) r5.a.findViewById(2131371466);
        EmojiEditView r35 = r5.f;
        if (r35 == null) goto L93;
        r35.postDelayed(new f(r5), 1000);
    L93:
        EmojiEditView r36 = r5.f;
        if (r36 == null) goto L96;
        r36.addTextChangedListener(r5.p);
    L96:
        EmojiEditView r37 = r5.f;
        if (r37 == null) goto L99;
        r37.d.add(r5.o);
    L99:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r38 = r5.s.a;
        if (r38 == null) goto L102;
        r38.a = r5.f;
    L102:
        EmojiEditView r39 = r5.f;
        if (r39 == null) goto L105;
        r39.setOnClickListener(new g(r5));
    L105:
        String r40 = "on";
        if (r5.i() == false) goto L196;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r41 = r5.s.a;
        if (r41 != null) goto L110;
    L167:
        HSImageView r43 = r5.c;
        if (r43 == null) goto L170;
        UtilityKotlinExtentionsKt.t(r43);
    L170:
        com.bytedance.android.live.profit.privilege.a r44 = r5.i;
        if (r44 == null) goto L175;
        com.bytedance.live.datacontext.m r45 = r44.isInDanmakuMode();
        if (r45 == null) goto L175;
        r45.setValue(Boolean.FALSE);
    L175:
        String r110 = "no_permission";
    L176:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r46 = r5.b.V();
        if (r46 == null) goto L186;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r47 = r46.g;
        if (r47 == null) goto L186;
        OpenInputSource r48 = r47.t;
        if (r48 == null) goto L186;
        String r49 = r48.getSource();
        if (r49 == null) goto L186;
        String r111 = r49;
    L187:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r50 = r5.b.V();
        if (r50 == null) goto L194;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r51 = r50.g;
        if (r51 == null) goto L194;
        com.bytedance.android.live.profit.privilege.model.danmu.b r53 = r51.d;
        if (r53 == null) goto L194;
        Integer r112 = Integer.valueOf(r53.getStyle());
    L195:
        com.bytedance.android.livesdk.interactivity.api.monitor.b.c(r111, true, null, r110, r112, "landscape");
    L287:
        r5.b.k(new h(r5));
        EmojiEditView r54 = r5.f;
        if (r54 == null) goto L290;
        r54.setOnKeyListener(new i(r5));
    L290:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r55 = r5.b.V();
        if (r55 == null) goto L295;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r56 = r55.g;
        if (r56 == null) goto L295;
        x22.a r57 = r56.e;
    L296:
        if (r57 == null) goto L308;
        TextView r58 = r5.g;
        if (r58 == null) goto L312;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r59 = r5.b.V();
        if (r59 == null) goto L306;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r60 = r59.g;
        if (r60 == null) goto L306;
        x22.a r61 = r60.e;
        if (r61 == null) goto L306;
        String r63 = r61.a;
    L307:
        r58.setText(r63);
    L306:
        r63 = null;
    L312:
        if (r5.b.k0() == false) goto L317;
        TextView r64 = r5.g;
        if (r64 == null) goto L317;
        r64.setText(2131915379);
    L317:
        if (com.bytedance.android.livesdk.interactivity.api.p.a() == true) goto L319;
    L330:
        CommentFlowContext r65 = r5.b.S();
        if (r65 == null) goto L335;
        CommentInputConfig r66 = r65.d;
        if (r66 == null) goto L335;
        r3 = r66.r;
    L335:
        if (r3 == null) goto L339;
        TextView r67 = r5.g;
        if (r67 == null) goto L339;
        r67.setText(r3);
    L339:
        EmojiEditView r68 = r5.f;
        if (r68 == null) goto L354;
        Editable r69 = r68.getEditableText();
        if (r69 == null) goto L354;
        if (r69.length() <= 0) goto L346;
        boolean r70 = true;
    L347:
        if (r70 != true) goto L354;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r71 = r5.s.a;
        if (r71 == null) goto L351;
        r71.d(true);
    L351:
        TextView r73 = r5.g;
        if (r73 == null) goto L354;
        UtilityKotlinExtentionsKt.t(r73);
        goto L354
    L346:
        r70 = false;
    L354:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r74 = r5.b.V();
        if (r74 == null) goto L360;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r75 = r74.g;
        if (r75 == null) goto L360;
        CharSequence r76 = r75.g;
        if (r76 == null) goto L360;
    L362:
        if (r76.length() <= 0) goto L364;
        boolean r77 = true;
    L365:
        if (r77 == false) goto L369;
        EmojiEditView r78 = r5.f;
        if (r78 == null) goto L373;
        r78.post(new j(r5, r76));
    L373:
        if (r5.l() == false) goto L377;
        EmojiEditView r79 = r5.f;
        if (r79 == null) goto L377;
        r79.setFilters(new InputFilter[]{r5.r});
    L377:
        Unit r80 = Unit.INSTANCE;
        this.e = r5;
        return r4;
    L369:
        EmojiEditView r81 = r5.f;
        if (r81 == null) goto L373;
        r81.post(new k(r5));
        goto L373
    L364:
        r77 = false;
    L360:
        r76 = BuildConfig.FLAVOR;
        goto L362
    L319:
        if (r5.b.k0() == true) goto L330;
        IntercomSyncDataModel r83 = com.bytedance.android.livesdk.interactivity.api.q.h();
        if (r83 == null) goto L330;
        if (r83.getHasUserCloseIntercomCommentTips() == true) goto L330;
        TextView r84 = r5.g;
        if (r84 == null) goto L327;
        r84.setText(2131915879);
    L327:
        IntercomSyncDataModel r85 = com.bytedance.android.livesdk.interactivity.api.q.h();
        if (r85 == null) goto L330;
        r85.setHasUserCloseIntercomCommentTips(true);
        goto L330
    L308:
        TextView r86 = r5.g;
        if (r86 == null) goto L312;
        r86.setText(2131922325);
    L295:
        r57 = null;
    L194:
        r112 = null;
    L186:
        r111 = CardLockInfo.sUNKNOWN;
        goto L187
    L110:
        if (r41.f0() != true) goto L167;
        r5.k();
        HSImageView r87 = r5.c;
        if (r87 == null) goto L114;
        UtilityKotlinExtentionsKt.w(r87);
    L114:
        com.bytedance.android.livesdk.interactivity.comment.utils.a.e();
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r88 = r5.s.a;
        if (r88 == null) goto L125;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r89 = r88.V();
        if (r89 == null) goto L125;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r90 = r89.g;
        if (r90 == null) goto L125;
        if ((!TextUtils.isEmpty(r90.f)) != true) goto L125;
        HSImageView r91 = r5.c;
        if (r91 == null) goto L138;
        r91.setOnClickListener(new o(r5));
    L138:
        r110 = "off";
    L125:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r93 = r5.s.a;
        if (r93 == null) goto L139;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r94 = r93.V();
        if (r94 == null) goto L139;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r95 = r94.g;
        if (r95 == null) goto L139;
        u22.m.a r96 = r95.j;
        if (r96 == null) goto L139;
        if (r96.k != true) goto L139;
        HSImageView r97 = r5.c;
        if (r97 == null) goto L138;
        r97.setOnClickListener(p.a);
    L139:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r98 = r5.s.a;
        if (r98 == null) goto L145;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r99 = r98.V();
        if (r99 == null) goto L145;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r100 = r99.g;
        if (r100 == null) goto L145;
    L146:
        com.bytedance.android.live.profit.privilege.model.danmu.b r113 = r100.d;
        if (r113 != null) goto L149;
    L162:
        r40 = "off";
    L163:
        HSImageView r101 = r5.c;
        if (r101 == null) goto L166;
        r101.setOnClickListener(new q(r5));
    L166:
        r110 = r40;
        goto L176
    L149:
        if (r113.getStyle() == 21) goto L162;
        HSImageView r102 = r5.c;
        if (r102 == null) goto L153;
        r102.setBackground(null);
    L153:
        HSImageView r103 = r5.c;
        com.bytedance.android.live.profit.privilege.model.danmu.b r104 = r100.d;
        if (r104 == null) goto L156;
        py.k r105 = r104.getEntranceImg();
    L157:
        ImageUtil.loadImage(r103, r105, 0);
        com.bytedance.android.live.profit.privilege.a r106 = r5.i;
        if (r106 == null) goto L163;
        com.bytedance.live.datacontext.m r107 = r106.isInDanmakuMode();
        if (r107 == null) goto L163;
        r107.setValue(Boolean.TRUE);
        goto L163
    L156:
        r105 = null;
    L145:
        r100 = new com.bytedance.android.livesdk.interactivity.comment.newinput.a();
        goto L146
    L196:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r108 = r5.s.a;
        if (r108 != null) goto L199;
    L258:
        BarrageView r109 = r5.d;
        if (r109 == null) goto L261;
        UtilityKotlinExtentionsKt.t(r109);
    L261:
        com.bytedance.android.live.profit.privilege.a r114 = r5.i;
        if (r114 == null) goto L266;
        com.bytedance.live.datacontext.m r115 = r114.isInDanmakuMode();
        if (r115 == null) goto L266;
        r115.setValue(Boolean.FALSE);
    L266:
        String r116 = "no_permission";
    L267:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r117 = r5.b.V();
        if (r117 == null) goto L277;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r118 = r117.g;
        if (r118 == null) goto L277;
        OpenInputSource r119 = r118.t;
        if (r119 == null) goto L277;
        String r120 = r119.getSource();
        if (r120 == null) goto L277;
        String r121 = r120;
    L278:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r122 = r5.b.V();
        if (r122 == null) goto L285;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r123 = r122.g;
        if (r123 == null) goto L285;
        com.bytedance.android.live.profit.privilege.model.danmu.b r124 = r123.d;
        if (r124 == null) goto L285;
        Integer r125 = Integer.valueOf(r124.getStyle());
    L286:
        com.bytedance.android.livesdk.interactivity.api.monitor.b.c(r121, true, null, r116, r125, "portrait");
    L285:
        r125 = null;
    L277:
        r121 = CardLockInfo.sUNKNOWN;
        goto L278
    L199:
        if (r108.f0() != true) goto L258;
        r5.k();
        BarrageView r126 = r5.d;
        if (r126 == null) goto L203;
        UtilityKotlinExtentionsKt.w(r126);
    L203:
        FrameLayout r127 = r5.e;
        if (r127 == null) goto L206;
        r127.setPadding(UtilityKotlinExtentionsKt.i(58), r127.getPaddingTop(), r127.getPaddingRight(), r127.getPaddingBottom());
    L206:
        TextView r128 = r5.g;
        if (r128 == null) goto L209;
        r128.setPadding(UtilityKotlinExtentionsKt.i(60), r128.getPaddingTop(), r128.getPaddingRight(), r128.getPaddingBottom());
    L209:
        com.bytedance.android.livesdk.interactivity.comment.utils.a.e();
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r129 = r5.s.a;
        if (r129 == null) goto L220;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r130 = r129.V();
        if (r130 == null) goto L220;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r131 = r130.g;
        if (r131 == null) goto L220;
        if ((!TextUtils.isEmpty(r131.f)) != true) goto L220;
        BarrageView r132 = r5.d;
        if (r132 == null) goto L233;
        r132.setOnClickListener(new l(r5));
    L233:
        r116 = "off";
    L220:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r133 = r5.s.a;
        if (r133 == null) goto L234;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r134 = r133.V();
        if (r134 == null) goto L234;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r135 = r134.g;
        if (r135 == null) goto L234;
        u22.m.a r136 = r135.j;
        if (r136 == null) goto L234;
        if (r136.k != true) goto L234;
        BarrageView r137 = r5.d;
        if (r137 == null) goto L233;
        r137.setOnClickListener(m.a);
    L234:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r138 = r5.s.a;
        if (r138 == null) goto L240;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r139 = r138.V();
        if (r139 == null) goto L240;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r140 = r139.g;
        if (r140 == null) goto L240;
    L242:
        if (r140.d == null) goto L248;
        r5.n();
        com.bytedance.android.live.profit.privilege.a r141 = r5.i;
        if (r141 == null) goto L254;
        com.bytedance.live.datacontext.m r142 = r141.isInDanmakuMode();
        if (r142 == null) goto L254;
        r142.setValue(Boolean.TRUE);
    L254:
        BarrageView r143 = r5.d;
        if (r143 == null) goto L257;
        r143.setOnClickListener(new n(r5));
    L257:
        r116 = r40;
        goto L267
    L248:
        com.bytedance.android.live.profit.privilege.a r144 = r5.i;
        if (r144 == null) goto L253;
        com.bytedance.live.datacontext.m r145 = r144.isInDanmakuMode();
        if (r145 == null) goto L253;
        r145.setValue(Boolean.FALSE);
    L253:
        r40 = "off";
    L240:
        r140 = new com.bytedance.android.livesdk.interactivity.comment.newinput.a();
    L82:
        e = move-exception;
        i40.h.b("V3 emoji key board mCursorDrawableRes", e);
        goto L85
    L78:
        r30.setSingleLine(false);
        r30.setHorizontallyScrolling(false);
        goto L79
    L380:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.widget.EmojiEditView");
    L67:
        r27 = null;
        goto L68
    L69:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r146 = r5.s.a;
        if (r146 == null) goto L72;
        Context r147 = r146.getContext();
    L73:
        int r148 = LivePortraitInputDialogV3.L;
        r29 = r25.createEmojiEditText(r147, LivePortraitInputDialogV3.a.a());
        goto L74
    L72:
        r147 = null;
        goto L73
    L60:
        r24 = false;
        goto L62
    L61:
        r24 = true;
        goto L62
    L46:
        r21 = 2131108403;
        goto L47
    L42:
        r20 = false;
        goto L44
    L43:
        r20 = true;
        goto L44
    L31:
        if (r16.isMysteryMan() != true) goto L32;
    L33:
        r17 = false;
    L25:
        r15 = null;
    L48:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r149 = r5.s.a;
        if (r149 == null) goto L55;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r150 = r149.V();
        if (r150 == null) goto L55;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r151 = r150.g;
        if (r151 == null) goto L55;
        r151.j = null;
    L55:
        r23 = null;
        goto L56
    L8:
        r4 = LayoutInflater.from(r2).inflate(2131567700, null);
        goto L9
    }
}
