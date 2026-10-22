package com.ss.android.lark.keyboard.classicinput;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OneShotPreDrawListener;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.framework.utils.DeviceUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.classicinput.base.IInputSupportAdditionPlugin;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.keyboard.statistics.TextInputPluginHitPoint;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiconTextView;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.i;
import com.ss.android.lark.widget.slidingup.SlidingUpPanelLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class a extends com.ss.android.lark.keyboard.classicinput.base.b {
    public InputSupportType A;
    public boolean B;
    public boolean C;
    public final CoroutineScope D;
    public boolean E;
    public boolean F;
    public boolean G;
    public final CharSequence e;
    public final int f;
    public final com.ss.android.lark.keyboard.classicinput.base.h g;
    public boolean h;
    public Activity i;
    public LinearLayout j;
    public LinearLayout k;
    public ImageView l;
    public EllipsizedEmojiconTextView m;
    public View n;
    public KeyboardFunctionEditText o;
    public ImageView p;
    public ImageView q;
    public View r;
    public CharSequence s;
    public boolean t;
    public View u;
    public ViewGroup v;
    public ViewGroup w;
    public FrameLayout x;
    public RecyclerView y;
    public View z;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.classicinput.a$a, reason: collision with other inner class name */
    public static final class C0131a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ a b;

        public b(View r1, a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.ss.android.lark.c.d(this.b.a().e());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            new TextInputPluginHitPoint("send").c();
            a r6 = this.a;
            if (r6.h == true) goto L19;
            KeyboardFunctionEditText r2 = null;
            if (r6.E == false) goto L10;
            AppCompatEditText r7 = r6.o;
            if (r7 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
            r7 = null;
        L9:
            RichText r8 = ExtensionEditTextCompatKt.b(r7);
        L14:
            a r0 = this.a;
            com.ss.android.lark.keyboard.classicinput.base.h r3 = r0.g;
            KeyboardFunctionEditText r1 = r0.o;
            if (r1 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        L18:
            r3.b(ExtensionEditTextCompatKt.g(r2), r8);
            this.a.l();
            this.a.r(new bob.a());
            this.a.getClass();
            return;
        L17:
            r2 = r1;
            goto L18
        L10:
            AppCompatEditText r9 = r6.o;
            if (r9 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
            r9 = null;
        L13:
            r8 = ExtensionEditTextCompatKt.f(r9);
            goto L14
        L19:
            r6.g.a();
        }
    }

    public static final class d implements View.OnClickListener {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.getClass();
            a r3 = this.a;
            if (r3.B == false) goto L6;
            r3.l();
            this.a.getClass();
            return;
        }
    }

    public static final class f implements View.OnFocusChangeListener {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r1, boolean r2) {
        }
    }

    public static final class g implements TextWatcher {
        public final /* synthetic */ a a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public g(a r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r2) {
            a r0 = this.a;
            if (r2 == null) goto L5;
            CharSequence r3 = StringsKt.trim(r2);
        L6:
            r0.u(!TextUtils.isEmpty(String.valueOf(r3)));
            return;
        L5:
            r3 = null;
            goto L6
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r3, int r4, int r5, int r6) {
            a r0 = this.a;
            if (r0.t == false) goto L5;
            return;
        L5:
            r0.b.onTextChanged(r3, r4, r5, r6);
        }
    }

    public static final class h implements rcc.d {
        public final /* synthetic */ a a;

        public h(a r1) {
            this.a = r1;
        }

        public final void a(int r1, int r2, int r3) {
            if (r1 == r2) goto L5;
            a r4 = this.a;
            r4.z(r4.s);
            return;
        }
    }

    static {
    }

    public int n() {
        return 2131561725;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final EditText c() {
        AppCompatEditText r0 = this.o;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        return null;
    L6:
        return r0;
    }

    @Override // com.ss.android.lark.keyboard.classicinput.base.b
    public void g() {
        com.ss.android.lark.keyboard.classicinput.base.c r0 = this.a;
        r0.getClass();
        Log.i("KeyBoard", "additionPluginController destroy");
        Iterator r1 = ((HashMap) r0.a).entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((IInputSupportAdditionPlugin) ((Map.Entry) r1.next()).getValue()).onDestroy();
        goto L4
    L6:
        ((HashMap) r0.d).clear();
        SlidingUpPanelLayout r2 = r0.e;
        if (r2 == null) goto L16;
        com.ss.android.lark.keyboard.classicinput.base.c.C0132c r3 = r0.j;
        List r4 = r2.D;
        monitor-enter(r4);
        ((CopyOnWriteArrayList) r2.D).remove(r3);     // Catch: Throwable -> L13
        monitor-exit(r4);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L16:
        AppCompatEditText r5 = this.o;
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r5 = null;
    L19:
        r5.setText("");
        CoroutineScopeKt.cancel$default(this.D, null, 1, null);
    }

    public final void l() {
        if (this.B == true) goto L5;
        return;
    L5:
        this.B = false;
        LinearLayout r0 = this.j;
        LinearLayout r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mReplyRegion");
        r0 = null;
    L8:
        r0.setVisibility(8);
        v();
        LinearLayout r2 = this.j;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mReplyRegion");
    L12:
        OneShotPreDrawListener.add(r1, new b(r1, this));
        return;
    L11:
        r1 = r2;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.widget.EditText] */
    public final void v() {
        Intrinsics.checkNotNullParameter("", "text");
        AppCompatEditText r0 = this.o;
        ?? r2 = 0;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r0 = null;
    L5:
        r0.setText("");
        AppCompatEditText r1 = this.o;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r1 = null;
    L8:
        r1.setText("");
        KeyboardFunctionEditText r3 = this.o;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r3 = null;
    L12:
        if (TextUtils.isEmpty(r3.getText()) == true) goto L22;
        AppCompatEditText r4 = this.o;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r4 = null;
    L16:
        KeyboardFunctionEditText r5 = this.o;
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
    L20:
        r4.setSelection(r2.length());
        return;
    L19:
        r2 = r5;
        goto L20
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final InputSupportType getInputType() {
        return this.A;
    }

    @Override // mob.a
    public final View b(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return LayoutInflater.from(r4.getContext()).inflate(n(), r4, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v105 */
    /* JADX WARN: Type inference failed for: r11v138 */
    /* JADX WARN: Type inference failed for: r11v139 */
    /* JADX WARN: Type inference failed for: r11v140 */
    /* JADX WARN: Type inference failed for: r11v18, types: [android.widget.EditText] */
    /* JADX WARN: Type inference failed for: r11v83, types: [android.widget.EditText, androidx.appcompat.widget.AppCompatEditText, com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText, java.lang.Object] */
    @Override // mob.a
    public View onViewCreated(View r11) {
        Intrinsics.checkNotNullParameter(r11, "rootView");
        this.i = a().l().getContext();
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        this.c = r11;
        this.j = (LinearLayout) e().findViewById(2131377591);
        this.k = (LinearLayout) e().findViewById(2131377590);
        this.l = (ImageView) e().findViewById(2131364683);
        this.m = e().findViewById(2131391327);
        this.n = e().findViewById(2131369251);
        KeyboardFunctionEditText r12 = (KeyboardFunctionEditText) e().findViewById(2131389087);
        this.o = r12;
        ?? r13 = r12;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r13 = 0;
    L5:
        r13.setPadding(0, 0, 0, 0);
        this.p = (ImageView) e().findViewById(2131382821);
        this.q = (ImageView) e().findViewById(2131367223);
        this.r = e().findViewById(2131382825);
        LinearLayout r14 = (LinearLayout) e().findViewById(2131380993);
        LinearLayout r15 = (LinearLayout) e().findViewById(2131371795);
        this.w = (ViewGroup) e().findViewById(2131389147);
        this.v = (ViewGroup) e().findViewById(2131364437);
        this.x = (FrameLayout) e().findViewById(2131375137);
        this.y = e().findViewById(2131375104);
        FrameLayout r16 = this.x;
        if (r16 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mImageContainer");
        r16 = null;
    L8:
        r16.setVisibility(8);
        ViewGroup r17 = this.y;
        if (r17 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mImagesContainer");
        r17 = null;
    L11:
        r17.setVisibility(8);
        View r18 = e().findViewById(2131375334);
        this.z = r18;
        if (r18 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("inputAndReplyZone");
        r18 = null;
    L14:
        r18.setOnClickListener(d.a);
        z(this.e);
        AppCompatEditText r19 = this.o;
        if (r19 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r19 = null;
    L17:
        r19.setHintTextColor(this.f);
        AppCompatEditText r110 = this.o;
        if (r110 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r110 = null;
    L20:
        LarkFont r6 = LarkFont.HEADLINE;
        zz7.a.d(r110, r6);
        AppCompatEditText r111 = this.o;
        if (r111 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r111 = null;
    L23:
        Activity r7 = this.i;
        if (r7 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        r7 = null;
    L26:
        ExtensionEditTextCompatKt.m(r111, zz7.b.g(r7, 19));
        KeyboardFunctionEditText r112 = this.o;
        if (r112 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r112 = null;
    L29:
        Activity r5 = this.i;
        if (r5 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        r5 = null;
    L32:
        int r8 = (int) zz7.b.i(r5, r6);
        Intrinsics.checkNotNullParameter(r112, "<this>");
        if ((r112 instanceof FunctionEditText) == false) goto L35;
        ((com.ss.android.lark.keyboard.edittext2.edittors.d) r112.q(com.ss.android.lark.keyboard.edittext2.edittors.d.e)).c = r8;
    L35:
        ImageView r113 = this.q;
        if (r113 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mPostInputBtn");
        r113 = null;
    L38:
        zz7.a.a(r113, 20);
        ImageView r114 = this.p;
        if (r114 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mPostDraftDotIV");
        r114 = null;
    L41:
        zz7.a.a(r114, 6);
        LinearLayout r115 = this.k;
        if (r115 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mReplyContentRegion");
        r115 = null;
    L44:
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        Activity r9 = this.i;
        if (r9 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        r9 = null;
    L47:
        r116.height = zz7.b.g(r9, 32);
        TextView r117 = this.m;
        if (r117 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mRootMsgTV");
        r117 = null;
    L50:
        zz7.a.d(r117, LarkFont.BODY1);
        EmojiconTextView r118 = this.m;
        if (r118 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("mRootMsgTV");
        r118 = null;
    L53:
        Activity r10 = this.i;
        if (r10 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        r10 = null;
    L56:
        r118.setEmojiconSize(zz7.b.g(r10, 16));
        View r119 = this.r;
        if (r119 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("mPostInputLayout");
        r119 = null;
    L59:
        r119.setVisibility(8);
        KeyboardFunctionEditText r120 = this.o;
        if (r120 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r120 = null;
    L62:
        r120.setInputType(212993);
        ImageView r121 = this.l;
        if (r121 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mCloseReplyBtn");
        r121 = null;
    L65:
        r121.setOnClickListener(new e(this));
        KeyboardFunctionEditText r122 = this.o;
        if (r122 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r122 = null;
    L68:
        View r20 = this.u;
        if (r20 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("mSendBtn");
        r20 = null;
    L71:
        Intrinsics.checkNotNullParameter(r122, "editText");
        Intrinsics.checkNotNullParameter(r20, "sendView");
        if (DeviceUtils.isPad() == false) goto L74;
        r122.setOnKeyListener(new com.ss.android.lark.keyboard.classicinput.base.a(r122, r20));
    L74:
        AppCompatEditText r123 = this.o;
        if (r123 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r123 = null;
    L77:
        r123.setOnFocusChangeListener(f.a);
        KeyboardFunctionEditText r124 = this.o;
        ?? r125 = r124;
        if (r124 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r125 = 0;
    L80:
        r125.addTextChangedListener(new g(this));
        com.ss.android.lark.keyboard.edittext2.utils.d.a("lark.urlspan.refactor.messenger");
        Intrinsics.checkNotNullParameter(r125, "<this>");
        ExtensionEditTextCompatKt.n(r125);
        r125.setOnSizeChangeListener(new h(this));
        if ((e().getLayoutParams() instanceof FrameLayout.LayoutParams) == false) goto L83;
        View r126 = e();
        ViewGroup.LayoutParams r21 = e().getLayoutParams();
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r22 = (FrameLayout.LayoutParams) r21;
        r22.gravity = 80;
        r126.setLayoutParams(r22);
    L83:
        AppCompatEditText r127 = this.o;
        if (r127 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r127 = null;
    L86:
        r127.setVerticalScrollBarEnabled(false);
        Activity r128 = a().l().getContext();
        View r23 = e();
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r24 = (ViewGroup) r23;
        Intrinsics.checkNotNullParameter(r24, "panelRegionParent");
        Intrinsics.checkNotNullParameter(r128, "activity");
        SlidingUpPanelLayout r2 = r24.findViewById(2131389147);
        ConstraintLayout r3 = r24.findViewById(2131364437);
        r2.setVisibility(8);
        r3.setVisibility(8);
        com.ss.android.lark.keyboard.classicinput.base.c r25 = this.a;
        com.ss.android.lark.keyboard.b r26 = a();
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNull(r3);
        r25.getClass();
        Intrinsics.checkNotNullParameter(r26, "keyboard");
        Intrinsics.checkNotNullParameter(r2, "popDrawerLayout");
        Intrinsics.checkNotNullParameter(r3, "additionFuncContainer");
        Intrinsics.checkNotNullParameter(r128, "activity");
        r25.i = r26;
        r25.e = r2;
        r25.g = r128;
        r25.h = 0;
        ((HashMap) r25.b).put("input_addition", new com.ss.android.lark.keyboard.classicinput.base.c.b("input_addition", r3, new com.ss.android.lark.keyboard.classicinput.base.e()));
        SlidingUpPanelLayout r129 = r25.e;
        if (r129 == null) goto L89;
        ((HashMap) r25.b).put("input_pop", new com.ss.android.lark.keyboard.classicinput.base.c.b("input_pop", r129, new com.ss.android.lark.keyboard.classicinput.base.f()));
    L89:
        SlidingUpPanelLayout r130 = r25.e;
        if (r130 == null) goto L99;
        r130.setGravity(80);
        com.ss.android.lark.keyboard.classicinput.base.c.C0132c r4 = r25.j;
        List r27 = r130.D;
        monitor-enter(r27);
        ((CopyOnWriteArrayList) r130.D).add(r4);     // Catch: Throwable -> L139
        monitor-exit(r27);     // Catch: Throwable -> L139
        r130.setFadeOnClickListener(new com.ss.android.lark.keyboard.classicinput.base.d(r130));
        r130.setOverlayed(true);
        r130.setPanelHeight(0);
        r130.setEnabled(false);
        r130.setShadowHeight(r25.h);
        r130.setDragView(null);
        View r131 = r130.findViewById(2131367794);
        r25.f = r131;
        if (r131 == null) goto L99;
        r131.setClickable(false);
    L139:
        th = move-exception;
        throw th;
    L99:
        com.ss.android.lark.keyboard.classicinput.base.c r132 = this.a;
        Iterator r28 = ((ArrayList) r132.c).iterator();
    L101:
        if (r28.hasNext() == false) goto L137;
        String r29 = (String) ((Pair) r28.next()).getSecond();
        if (r132.g == null) goto L101;
        com.ss.android.lark.keyboard.classicinput.base.c.b r30 = (com.ss.android.lark.keyboard.classicinput.base.c.b) ((HashMap) r132.b).get(r29);
        if (r30 == null) goto L101;
        IInputSupportAdditionPlugin r31 = (IInputSupportAdditionPlugin) ((HashMap) r132.a).get(r29);
        if (r31 == null) goto L110;
        r30.b.setVisibility(0);
        r30.getContext();
        r31.c();
        Activity r32 = r132.g;
        if (r32 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        r32 = null;
    L115:
        if ((r32 instanceof dwa.d) == false) goto L133;
        if (r31.getLayoutId() != 0) goto L123;
        if (r132.g != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
    L121:
        r31.a();
    L123:
        if (r132.g != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
    L125:
        Activity r33 = r132.g;
        if (r33 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        r33 = null;
    L128:
        dwa.c r34 = ((dwa.d) r33).Ey();
        Activity r35 = r132.g;
        if (r35 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        r35 = null;
    L131:
        r34.b(r35, r31.getLayoutId(), r30.b);
        View r36 = r31.d();
    L136:
        r30.b.addView(r36);
        goto L101
    L133:
        if (r132.g != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
    L135:
        r36 = r31.a();
        goto L136
    L110:
        r30.b.setVisibility(8);
        goto L101
    L137:
        Log.i("KeyBoard", "additionPluginController start");
        return e();
    }

    public final void r(bob.a r11) {
        Intrinsics.checkNotNullParameter(r11, "params");
        RichText r0 = r11.a;
        Log.d("doDraft", "Text input onSetDraft " + i.i(r0));
        Log.d("keyboard", "life onSetDraft " + i.i(r0));
        this.t = true;
        if (r0 != null) goto L5;
        y(com.ss.android.lark.widget.richtext.c.a());
    L6:
        this.t = false;
        if ((r11 instanceof bob.c) == false) goto L43;
        Log.i("TextInputSupportPlugin", "onSetDraft: draft is reply draft, changeToReplyMode");
        CharSequence r12 = ((bob.c) r11).b;
        LinearLayout r2 = this.j;
        LinearLayout r4 = null;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mReplyRegion");
        r2 = null;
    L11:
        r2.setVisibility(8);
        this.B = true;
        AppCompatEditText r1 = this.o;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r1 = null;
    L14:
        r1.requestFocus();
        EmojiconTextView r3 = this.m;
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRootMsgTV");
        r3 = null;
    L17:
        r3.setTranslateEmojiCode(false);
        SpannableStringBuilder r5 = new SpannableStringBuilder(r12);
        Iterator r6 = ArrayIteratorKt.iterator((ncc.e[]) r5.getSpans(0, r5.length(), ncc.e.class));
    L19:
        if (r6.hasNext() == false) goto L31;
        ncc.e r7 = (ncc.e) r6.next();
        EllipsizedEmojiconTextView r8 = this.m;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mRootMsgTV");
        r8 = null;
    L23:
        r7.a(new com.ss.android.lark.keyboard.classicinput.c(this, r8));
        Bitmap r9 = r7.b;
        if (r9 == null) goto L29;
        Paint r10 = new Paint();
        TextView r13 = this.m;
        if (r13 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mRootMsgTV");
        r13 = null;
    L28:
        r10.setColorFilter(new PorterDuffColorFilter(r13.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        Bitmap r14 = Bitmap.createBitmap(r9.getWidth(), r9.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNull(r14);
        new Canvas(r14).drawBitmap(r9, 0.0f, 0.0f, r10);
    L30:
        r7.b = r14;
        goto L19
    L29:
        r14 = null;
        goto L30
    L31:
        TextView r15 = this.m;
        if (r15 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mRootMsgTV");
        r15 = null;
    L34:
        r15.setText(r12);
        LinearLayout r16 = this.j;
        if (r16 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mReplyRegion");
    L38:
        OneShotPreDrawListener.add(r4, new com.ss.android.lark.keyboard.classicinput.b(r4, this));
        return;
    L37:
        r4 = r16;
        goto L38
    L43:
        return;
    L5:
        y(r0);
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final void setEnable(boolean r6) {
        Iterator r0 = ((ArrayList) this.a.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IInputSupportAdditionPlugin) ((Pair) r0.next()).getFirst()).b();
        goto L4
    L6:
        this.h = !r6;
        AppCompatEditText r1 = this.o;
        ImageView r2 = null;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r1 = null;
    L10:
        if (r6 == true) goto L18;
        KeyboardFunctionEditText r4 = this.o;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r4 = null;
    L15:
        if (TextUtils.isEmpty(r4.getText()) == false) goto L18;
        boolean r5 = false;
    L19:
        r1.setEnabled(r5);
        KeyboardFunctionEditText r3 = this.o;
        if (r3 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r3 = null;
    L22:
        Editable r7 = r3.getText();
        if (r7 == null) goto L25;
        CharSequence r8 = StringsKt.trim(r7);
    L26:
        u(!TextUtils.isEmpty(r8));
        ImageView r9 = this.q;
        if (r9 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mPostInputBtn");
    L30:
        r2.setEnabled(r6);
        return;
    L29:
        r2 = r9;
        goto L30
    L25:
        r8 = null;
    L18:
        r5 = true;
        goto L19
    }

    @Override // mob.a
    public final View t(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        View r3 = com.ss.android.lark.keyboard.utils.h.b(r2.getContext());
        this.u = r3;
        r3.setOnClickListener(new c(this));
        View r4 = this.u;
        if (r4 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mSendBtn");
        return null;
    L6:
        return r4;
    }

    public final void u(boolean r4) {
        View r1 = null;
        if (this.F == false) goto L9;
        View r5 = this.u;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mSendBtn");
    L8:
        r1.setEnabled(this.G);
        return;
    L7:
        r1 = r5;
        goto L8
    L9:
        View r0 = this.u;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mSendBtn");
    L13:
        r1.setEnabled(r4);
        return;
    L12:
        r1 = r0;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.widget.EditText] */
    public final void y(RichText r5) {
        AppCompatEditText r0 = this.o;
        ?? r2 = 0;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r0 = null;
    L6:
        if (Intrinsics.areEqual(r5, ExtensionEditTextCompatKt.f(r0)) == false) goto L8;
        return;
    L8:
        AppCompatEditText r1 = this.o;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r1 = null;
    L11:
        r1.setText("");
        KeyboardFunctionEditText r3 = this.o;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
    L15:
        ExtensionEditTextCompatKt.p(r2, r5);
        return;
    L14:
        r2 = r3;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.EditText] */
    public final void z(CharSequence r6) {
        if (r6 != null) goto L4;
        r6 = "";
    L4:
        this.s = r6;
        AppCompatEditText r7 = this.o;
        ?? r0 = 0;
        if (r7 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r7 = null;
    L7:
        float r8 = r7.getMeasuredWidth();
        AppCompatEditText r2 = this.o;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r2 = null;
    L10:
        float r9 = r8 - r2.getPaddingLeft();
        AppCompatEditText r3 = this.o;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r3 = null;
    L13:
        float r10 = (r9 - r3.getPaddingRight()) - 1.0f;
        AppCompatEditText r4 = this.o;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r4 = null;
    L16:
        CharSequence r5 = this.s;
        KeyboardFunctionEditText r11 = this.o;
        if (r11 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
    L20:
        r4.setHint(TextUtils.ellipsize(r5, r0.getPaint(), r10, TextUtils.TruncateAt.END));
        return;
    L19:
        r0 = r11;
        goto L20
    }

    public a(CharSequence r2, int r3, rcc.b r4, com.ss.android.lark.keyboard.classicinput.base.h r5) {
        Intrinsics.checkNotNullParameter(r2, "hint");
        Intrinsics.checkNotNullParameter(r4, "onPasteListener");
        Intrinsics.checkNotNullParameter(r5, "onSendTextCallback");
        this.e = r2;
        this.f = r3;
        this.g = r5;
        this.s = "";
        this.A = InputSupportType.Text;
        this.C = true;
        this.D = CoroutineScopeKt.plus(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), SupervisorKt.SupervisorJob$default(null, 1, null));
        this.G = true;
    }
}
