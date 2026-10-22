package com.ss.android.lark.keyboard.editor.input;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.utils.l1;
import com.ss.android.lark.dto.draft.QueryStatusInfo;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.keyboard.base.ReEditInfo;
import com.ss.android.lark.keyboard.base.ResourceUploadInfo;
import com.ss.android.lark.keyboard.biz.p000float.inject.FloatExpandPlugin;
import com.ss.android.lark.keyboard.editor.FlowChatKeyboardEditor;
import com.ss.android.lark.keyboard.edittext.FlowKeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor;
import com.ss.android.lark.keyboard.inputstate.InputStateController;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextExtraInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import z5c.p3;
import z5c.x3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class BaseRichTextInputPlugin implements com.ss.android.lark.keyboard.base.f {
    public static final /* synthetic */ int J = 0;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public PartialReplyInfo E;
    public com.ss.android.lark.keyboard.b F;
    public boolean G;
    public boolean H;
    public final com.ss.android.lark.keyboard.editor.input.a I;
    public CharSequence a;
    public final com.ss.android.lark.keyboard.editor.input.r b;
    public final b c;
    public final Fragment d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public Job h;
    public Job i;
    public String j;
    public Chatter k;
    public boolean l;
    public final Lazy m;
    public Activity n;
    public com.ss.android.lark.keyboard.editor.input.j o;
    public EditText p;
    public KeyboardFunctionEditText q;
    public com.ss.android.lark.keyboard.editor.input.o r;
    public View s;
    public View t;
    public a0 u;
    public final Set<com.ss.android.lark.keyboard.base.l> v;
    public NestedScrollView w;
    public View x;
    public lob.a y;
    public EditText z;

    public static final class a {
    }

    public interface b {
        void onResume();

        void onStop();
    }

    public static final class c {
        public final CharSequence a;
        public final CharSequence b;
        public final String c;
        public final int d;
        public final boolean e;

        public c() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(null, null) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31;
            if (this.e == false) goto L5;
            int r1 = 1231;
        L7:
            return ((r0 + r1) * 31) + 0;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "TransformData(title=" + this.a + ", content=" + this.b + ", selectEditor=" + this.c + ", sectionInfo=" + this.d + ", threadReplyOptionStateValue=" + this.e + ", typingTranslateInfo=null)";
        }

        public /* synthetic */ c(int r7) {
            this("", "", "content", 0, false);
        }

        public c(CharSequence r2, CharSequence r3, String r4, int r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r2, "title");
            Intrinsics.checkNotNullParameter(r3, "content");
            Intrinsics.checkNotNullParameter(r4, "selectEditor");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class d implements TextWatcher {
        public final /* synthetic */ BaseRichTextInputPlugin a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public d(BaseRichTextInputPlugin r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r2) {
            BaseRichTextInputPlugin r0 = this.a;
            if (r2 == null) goto L5;
            CharSequence r3 = StringsKt.trim(r2);
        L6:
            r0.m0(!TextUtils.isEmpty(String.valueOf(r3)));
            return;
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class e implements com.ss.android.lark.keyboard.edittext2.compat.d {
        public final /* synthetic */ BaseRichTextInputPlugin a;

        public e(BaseRichTextInputPlugin r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.keyboard.edittext2.compat.d
        public final void C(int r3, int r4) {
            Editable r0 = this.a.L().getText();
            lob.a r1 = this.a.y;
            if (r1 == null) goto L6;
            r1.r(r0, r3, r4 - r3);
            return;
        }
    }

    public static final class f implements com.ss.android.lark.keyboard.edittext2.compat.c {
        public final /* synthetic */ BaseRichTextInputPlugin a;

        public f(BaseRichTextInputPlugin r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.keyboard.edittext2.compat.c
        public final boolean a(int r3, KeyEvent r4) {
            BaseRichTextInputPlugin r0 = this.a;
            if (Intrinsics.areEqual(r0.z, r0.Z()) == false) goto L10;
            lob.a r1 = this.a.y;
            if (r1 != null) goto L7;
            return false;
        L7:
            if (r1.z(r3, r4) != true) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }
    }

    public static final class g implements View.OnFocusChangeListener {
        public final /* synthetic */ BaseRichTextInputPlugin a;

        public g(BaseRichTextInputPlugin r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r4, boolean r5) {
            if (r5 == false) goto L12;
            BaseRichTextInputPlugin r6 = this.a;
            if (r6.D == false) goto L13;
            AppCompatEditText r7 = r6.L();
            BaseRichTextInputPlugin r8 = this.a;
            r8.z = r7;
            r8.f0("content");
            this.a.Q().d(true);
            lob.a r9 = this.a.y;
            if (r9 == null) goto L8;
            r9.j(r7);
        L8:
            lob.a r10 = this.a.y;
            if (r10 == null) goto L14;
            r10.r(r7.getEditableText(), r7.getSelectionStart(), r7.getSelectionEnd() - r7.getSelectionStart());
            return;
        L14:
            return;
        L13:
            return;
        }
    }

    public static final class h implements TextView.OnEditorActionListener {
        public final /* synthetic */ BaseRichTextInputPlugin a;

        public h(BaseRichTextInputPlugin r1) {
            this.a = r1;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r11, int r12, KeyEvent r13) {
            if (r12 != 4) goto L10;
            BaseRichTextInputPlugin r0 = this.a;
            if (r0.B == false) goto L7;
            r0.o(false);
        L8:
            return true;
        L7:
            BaseRichTextInputPlugin.l0(r0, false, false, null, null, null, false, null, null, 254);
            goto L8
        L10:
            return false;
        }
    }

    public static final class i implements ViewTreeObserver.OnGlobalFocusChangeListener {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public final void onGlobalFocusChanged(View r3, View r4) {
            Log.d("BaseRichTextInputPlugin", "focus changed from " + r3 + " , to " + r4);
        }
    }

    public static final class j implements TextView.OnEditorActionListener {
        public final /* synthetic */ BaseRichTextInputPlugin a;

        public j(BaseRichTextInputPlugin r1) {
            this.a = r1;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r2, int r3, KeyEvent r4) {
            if (r3 != 4) goto L5;
        L13:
            this.a.L().setSelection(0);
            BaseRichTextInputPlugin.r0(this.a.L());
            return true;
        L5:
            if (r3 == 6) goto L13;
            if (r4 != null) goto L8;
        L12:
            return false;
        L8:
            if (66 != r4.getKeyCode()) goto L12;
            if (r4.getAction() != 0) goto L12;
            goto L12
        }
    }

    public static final class k implements TextWatcher {
        public final /* synthetic */ BaseRichTextInputPlugin a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public k(BaseRichTextInputPlugin r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r4) {
            Intrinsics.checkNotNullParameter(r4, "s");
            int r0 = r4.length();
        L3:
            r0 = r0 - 1;
            if ((-1) >= r0) goto L9;
            if (r4.charAt(r0) != '\n') goto L3;
            r4.replace(r0, r0 + 1, " ");
            goto L3
        L9:
            this.a.u();
        }
    }

    public static final class l implements View.OnFocusChangeListener {
        public final /* synthetic */ BaseRichTextInputPlugin a;

        public l(BaseRichTextInputPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r2, boolean r3) {
            if (r3 == false) goto L9;
            BaseRichTextInputPlugin r4 = this.a;
            if (r4.D == false) goto L10;
            EditText r5 = r4.Z();
            BaseRichTextInputPlugin r6 = this.a;
            r6.z = r5;
            r6.f0("title");
            this.a.Q().d(false);
            lob.a r7 = this.a.y;
            if (r7 == null) goto L11;
            r7.j(r5);
            return;
        L11:
            return;
        L10:
            return;
        }
    }

    public static final class m implements com.ss.android.lark.keyboard.edittext2.compat.c {
        public final /* synthetic */ BaseRichTextInputPlugin a;

        public m(BaseRichTextInputPlugin r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.keyboard.edittext2.compat.c
        public final boolean a(int r3, KeyEvent r4) {
            BaseRichTextInputPlugin r0 = this.a;
            if (Intrinsics.areEqual(r0.z, r0.Z()) == false) goto L10;
            lob.a r1 = this.a.y;
            if (r1 != null) goto L7;
            return false;
        L7:
            if (r1.z(r3, r4) != true) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }
    }

    public static final class n implements wxa.d {
        public final /* synthetic */ BaseRichTextInputPlugin a;

        public n(BaseRichTextInputPlugin r1) {
            this.a = r1;
        }

        public final void a(String r12, List r13, String r14) {
            Intrinsics.checkNotNullParameter(r12, "content");
            Intrinsics.checkNotNullParameter(r13, "entities");
            Intrinsics.checkNotNullParameter(r14, "txtScene");
            BaseRichTextInputPlugin.l0(this.a, false, true, r12, r13, null, false, null, null, 240);
        }
    }

    public static final class o implements View.OnClickListener {
        public final /* synthetic */ BaseRichTextInputPlugin a;

        public o(BaseRichTextInputPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.D();
        }
    }

    public static final class p implements View.OnTouchListener {
        public final /* synthetic */ BaseRichTextInputPlugin a;

        public p(BaseRichTextInputPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r5, MotionEvent r6) {
            if (r5.getId() == this.a.L().getId()) goto L6;
            return false;
        L6:
            if (this.a.L().canScrollVertically(1) == false) goto L8;
        L9:
            r5.getParent().requestDisallowInterceptTouchEvent(true);
            if (r6.getAction() != 1) goto L12;
            r5.getParent().requestDisallowInterceptTouchEvent(false);
        L12:
            return false;
        L8:
            if (this.a.L().canScrollVertically(-1) == false) goto L12;
            goto L9
        }
    }

    public static final class q implements TextView.OnEditorActionListener {
        public final /* synthetic */ KeyboardFunctionEditText a;

        public q(KeyboardFunctionEditText r1) {
            this.a = r1;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r3, int r4, KeyEvent r5) {
            if (r5 != null) goto L5;
        L7:
            boolean r0 = false;
        L8:
            if (r0 == true) goto L10;
        L17:
            return false;
        L10:
            if (r5.getAction() != 0) goto L17;
            if (StringsKt.trim(String.valueOf(this.a.getText())).toString().length() != 0) goto L14;
            boolean r6 = true;
        L15:
            if (r6 == false) goto L17;
            return true;
        L14:
            r6 = false;
            goto L15
        L5:
            if (r5.getKeyCode() != 66) goto L7;
            r0 = true;
            goto L8
        }
    }

    public static final class r implements Runnable {
        public final /* synthetic */ BaseRichTextInputPlugin a;

        public r(BaseRichTextInputPlugin r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.ss.android.lark.c.f(this.a.Q().n());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // mob.a
    public final void A() {
    }

    @Override // com.ss.android.lark.keyboard.base.f
    public abstract void D();

    public void J() {
        this.B = false;
        if (this.A == false) goto L5;
        K();
    L5:
        a0 r0 = this.u;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("msgSendBtnWrapper");
        r0 = null;
    L9:
        r0.a(1);
        com.ss.android.lark.keyboard.editor.input.o r1 = U();
        r1.getClass();
        r1.b[2] = "";
        r1.b();
    }

    public void K() {
    }

    public abstract int W();

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void d() {
    }

    @Override // com.ss.android.lark.keyboard.base.b
    public final void e(int r1, Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    public void e0(boolean r1) {
    }

    public void g(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
    }

    public void h0(KeyboardFunctionEditText r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
    }

    public abstract void i0(View r1);

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void j() {
    }

    public void n0(com.ss.android.lark.keyboard.base.n r2) {
        Intrinsics.checkNotNullParameter(r2, "draft");
    }

    @Override // com.ss.android.lark.keyboard.base.c
    public void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
    }

    public void p0() {
        this.D = false;
        b r0 = this.c;
        if (r0 == null) goto L5;
        r0.onStop();
    L5:
        this.z = null;
    }

    public void r(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
    }

    public abstract void t0();

    public void u() {
    }

    public void y(cya.i r2) {
        Intrinsics.checkNotNullParameter(r2, "replyData");
    }

    public static String R() {
        itb.a r0 = OfficeSDKManager.getHostGlobalService(itb.a.class);
        if (r0 == null) goto L6;
        String r1 = r0.i();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public void H() {
        if (this.B == false) goto L14;
        InputStateController r0 = Q().a();
        if (r0 == null) goto L11;
        cya.h r1 = r0.d();
        if (r1 == null) goto L11;
        com.ss.android.lark.keyboard.base.n r2 = r1.a;
        if (r2 == null) goto L11;
        r2.b(com.ss.android.lark.keyboard.inputstate.b.h, Boolean.TRUE);
    L11:
        if (r0 == null) goto L15;
        r0.pop();
        return;
    L15:
        return;
    }

    public final KeyboardFunctionEditText L() {
        KeyboardFunctionEditText r0 = this.q;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentEditor");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final String P() {
        String r0 = this.j;
        ?? r1 = 0;
        if (r0 != null) goto L5;
    L10:
        boolean r2 = com.ss.android.lark.keyboard.edittext2.utils.d.a("messenger.im.disable_doubao_suggest_name_non_blocking_fix");
        int r3 = com.ss.android.lark.keyboard.editor.input.i.a;
        String r4 = this.j;
        CharSequence r5 = R();
        Function0<String> r6 = new BaseRichTextInputPlugin$getDoubaoChatterNameForSuggest$finalName$1(this);
        Intrinsics.checkNotNullParameter(r5, "fallbackName");
        Intrinsics.checkNotNullParameter(r6, "blockingFetch");
        if (r4 != null) goto L13;
    L17:
        if (r2 == false) goto L23;
        CharSequence r7 = (CharSequence) r6.invoke();
        if (StringsKt.isBlank(r7) == true) goto L22;
        r5 = r7;
    L22:
        r5 = (String) r5;
    L23:
        r1 = r5;
    L24:
        if (r2 == false) goto L26;
        this.j = r1;
    L27:
        return r1;
    L26:
        q0();
        goto L27
    L13:
        if ((!StringsKt.isBlank(r4)) == false) goto L15;
        r1 = r4;
    L15:
        if (r1 == 0) goto L17;
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        return r0;
    }

    public final com.ss.android.lark.keyboard.editor.input.j Q() {
        com.ss.android.lark.keyboard.editor.input.j r0 = this.o;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("editorContext");
        return null;
    }

    public final com.ss.android.lark.keyboard.editor.input.o U() {
        com.ss.android.lark.keyboard.editor.input.o r0 = this.r;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("inputHintController");
        return null;
    }

    public final com.ss.android.lark.keyboard.b V() {
        com.ss.android.lark.keyboard.b r0 = this.F;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        return null;
    }

    public final View X() {
        View r0 = this.x;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    }

    public final View Y() {
        View r0 = this.s;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("statusTransformButton");
        return null;
    }

    public final EditText Z() {
        EditText r0 = this.p;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("titleEditor");
        return null;
    }

    public void g0() {
        if (this.q == null) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L14;
        KeyboardFunctionEditText r1 = L();
        if ((r1 instanceof FlowKeyboardFunctionEditText) == false) goto L11;
        FlowKeyboardFunctionEditText r2 = (FlowKeyboardFunctionEditText) r1;
    L12:
        if (r2 == null) goto L14;
        r2.setOnPasteUriListener(null);
        goto L14
    L11:
        r2 = null;
    L14:
        V().e().of(this).a();
        z();
        Job r3 = this.h;
        if (r3 == null) goto L17;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L17:
        this.h = null;
        Job r4 = this.i;
        if (r4 == null) goto L20;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L20:
        this.i = null;
        InputStateController r5 = Q().a();
        if (r5 == null) goto L25;
        cya.h r6 = r5.d();
        if (r6 == null) goto L25;
        Integer r7 = Integer.valueOf(r6.a());
    L27:
        if (Intrinsics.areEqual(r7, 2) == false) goto L32;
        InputStateController r8 = Q().a();
        if (r8 == null) goto L42;
        r8.pop();
    L42:
        Iterator r9 = ((LinkedHashMap) com.ss.android.lark.keyboard.widget.l.a).entrySet().iterator();
    L44:
        if (r9.hasNext() == false) goto L46;
        ((View) ((Map.Entry) r9.next()).getKey()).setOnTouchListener(null);
        goto L44
    L46:
        ((LinkedHashMap) com.ss.android.lark.keyboard.widget.l.a).clear();
        return;
    L32:
        if (Intrinsics.areEqual(r7, 4) == false) goto L42;
        InputStateController r10 = Q().a();
        if (r10 == null) goto L40;
        cya.h r11 = r10.d();
        if (r11 == null) goto L40;
        com.ss.android.lark.keyboard.base.n r12 = r11.a;
        if (r12 == null) goto L40;
        r12.b(com.ss.android.lark.keyboard.inputstate.b.h, Boolean.TRUE);
    L40:
        if (r10 == null) goto L42;
        r10.pop();
    L25:
        r7 = cya.h.b;
        goto L27
    L5:
        r0 = false;
        goto L7
    }

    public final Activity getActivity() {
        Activity r0 = this.n;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        return null;
    }

    public final void j0() {
        if (this.F != null) goto L5;
    L7:
        V().e().of(this).c(com.ss.android.lark.keyboard.biz.mention.inject.a.class, new BaseRichTextInputPlugin$onKeyboardInitialized$2(this));
        wxa.a r0 = (wxa.a) this.e.getValue();
        if (r0 == null) goto L11;
        r0.o3(new n(this));
        return;
    L11:
        return;
    L5:
        if (KeyboardVoiceFGUtils.e() == false) goto L7;
        V().e().of(this).c(com.ss.android.lark.keyboard.event.b.class, new BaseRichTextInputPlugin$onKeyboardInitialized$1$1(this));
        goto L7
    }

    public final void q0() {
        String r0 = this.j;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L18;
        Job r3 = this.i;
        if (r3 != null) goto L12;
    L14:
        if (r1 == true) goto L19;
        this.i = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.d), null, null, new BaseRichTextInputPlugin$prefetchDoubaoChatterNameForSuggestIfNeed$1(this, null), 3, null);
        return;
    L19:
        return;
    L12:
        if (r3.isActive() != true) goto L14;
        r1 = true;
        goto L14
    L18:
        return;
    L5:
        if ((!StringsKt.isBlank(r0)) != true) goto L7;
        r2 = true;
        goto L8
    }

    private final s5c.d S() {
        FloatExpandPlugin r0 = (FloatExpandPlugin) Q().b().d(FloatExpandPlugin.w);
        if (r0 == null) goto L6;
        s5c.d r1 = r0.c;
        if (r1 == null) goto L6;
        return r1;
    L6:
        s5c.d.o2.getClass();
        return new s5c.a("", "");
    }

    public final List<com.ss.android.lark.keyboard.base.k> T() {
        Editable r0 = L().getEditableText();
        int r3 = 0;
        Object[] r1 = r0.getSpans(0, r0.length(), com.ss.android.lark.keyboard.editor.input.n.class);
        ArrayList r2 = new ArrayList(r1.length);
        int r4 = r1.length;
    L3:
        if (r3 >= r4) goto L5;
        r2.add(((com.ss.android.lark.keyboard.editor.input.n) r1[r3]).a(L()));
        r3 = r3 + 1;
        goto L3
    L5:
        return r2;
    }

    public void a0() {
        this.z = L();
        ExtensionEditTextCompatKt.l(L(), "content");
        f0("content");
        Intrinsics.checkNotNullParameter(L(), "<this>");
        KeyboardFunctionEditText r0 = L();
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if ((r0 instanceof FunctionEditText) == false) goto L5;
        ((RichTextEditor) r0.q(RichTextEditor.t)).e = true;
    L5:
        KeyboardFunctionEditText r1 = L();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof KeyboardFunctionEditText) == false) goto L8;
        ((RichTextEditor) r1.q(RichTextEditor.t)).m = true;
    L8:
        KeyboardFunctionEditText r2 = L();
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof FunctionEditText) == false) goto L11;
        ((RichTextEditor) r2.q(RichTextEditor.t)).n = -1;
    L11:
        L().addTextChangedListener(new d(this));
        Job r3 = this.h;
        if (r3 == null) goto L14;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L14:
        this.h = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.d), null, null, new BaseRichTextInputPlugin$initAttachmentStateFlow$1(this, null), 3, null);
        L().addTextChangedListener(this.y);
        L().setSelectionChangedListener(new e(this));
        L().setOnKeyPreImeHandler(new f(this));
        L().setOnFocusChangeListener(new g(this));
        L().setOnEditorActionListener(new h(this));
        KeyboardFunctionEditText r4 = L();
        com.ss.android.lark.keyboard.edittext2.utils.d.a("lark.urlspan.refactor.messenger");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        ExtensionEditTextCompatKt.n(L());
        L().getViewTreeObserver().addOnGlobalFocusChangeListener(i.a);
    }

    public void b0() {
        ExtensionEditTextCompatKt.l(Z(), "title");
        Intrinsics.checkNotNullParameter(Z(), "<this>");
        ExtensionEditTextCompatKt.o(Z(), false);
        Object r0 = Z();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.keyboard.edittext2.base.FunctionEditText");
        RichTextEditor r1 = (RichTextEditor) ((FunctionEditText) r0).q(RichTextEditor.t);
        r1.h = false;
        r1.i = false;
        r1.f = false;
        r1.g = false;
        r1.e = false;
        r1.m = false;
        r1.k = false;
        Z().setOnEditorActionListener(new j(this));
        Z().addTextChangedListener(new k(this));
        Z().setOnFocusChangeListener(new l(this));
        Object r2 = Z();
        m r3 = new m(this);
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "preImeHandler");
        if ((r2 instanceof KeyboardFunctionEditText) == false) goto L6;
        ((KeyboardFunctionEditText) r2).setOnKeyPreImeHandler(new com.ss.android.lark.keyboard.edittext2.compat.b(r3));
        return;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final EditText c() {
        return L();
    }

    public void d0() {
        Q().f();
        Q().e();
        bya.a r0 = (bya.a) this.f.getValue();
        if (r0 == null) goto L5;
        r0.b(this.d);
    L5:
        bya.a r1 = (bya.a) this.f.getValue();
        if (r1 == null) goto L8;
        r1.a(this.d);
    L8:
        com.ss.android.lark.keyboard.event.k.a.a(V().e(), com.ss.android.lark.keyboard.event.q.b.a);
    }

    @Override // com.ss.android.lark.keyboard.base.f
    public final RichText getContent() {
        return ExtensionEditTextCompatKt.f(L());
    }

    public String k0() {
        return Z().getText().toString();
    }

    public final void w0() {
        String r0 = k0();
        if (this.A == false) goto L10;
        boolean r3 = true;
        if (r0.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
    L11:
        if (r3 == true) goto L13;
        return;
    L13:
        Editable r2 = L().getEditableText();
        r2.insert(0, r0 + '\n');
        r2.setSpan(new com.ss.android.lark.widget.span.c(), 0, r0.length(), 33);
        Z().setText("");
        L().setText(r2);
        L().setSelection(L().getEditableText().length());
        return;
    L7:
        r1 = false;
    L10:
        r3 = false;
        goto L11
    }

    public final void z() {
        Z().setText("");
        L().setText("");
        r0(L());
        L().setSelection(0);
    }

    public static final wxa.a a(BaseRichTextInputPlugin r0) {
        return (wxa.a) r0.e.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void r0(KeyboardFunctionEditText r1) {
        if (r1 != 0) goto L5;
        return;
    L5:
        if (r1.hasFocus() == false) goto L7;
        r1.clearFocus();
    L7:
        r1.requestFocus();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.widget.EditText, com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText] */
    public final void B(c r6) {
        Intrinsics.checkNotNullParameter(r6, "transformData");
        com.ss.android.lark.keyboard.keyboard2.b r0 = V().L();
        if ((r0 instanceof FlowChatKeyboardEditor) == false) goto L5;
        FlowChatKeyboardEditor r1 = (FlowChatKeyboardEditor) r0;
    L6:
        boolean r2 = true;
        if (r1 == null) goto L12;
        lob.b r3 = r1.u;
        if (r3 == null) goto L12;
        r3.a(true);
    L12:
        if (this.A == true) goto L14;
        Z().setText(r6.a);
    L14:
        L().setText(r6.b);
        ?? r4 = L();
        f0("content");
        int r7 = r6.d;
        if (r7 >= 0) goto L17;
    L19:
        r2 = false;
    L20:
        if (r2 == false) goto L22;
        r4.setSelection(r7);
        h0(r4);
    L22:
        this.z = r4;
        if (r1 == null) goto L28;
        lob.b r8 = r1.u;
        if (r8 == null) goto L29;
        r8.a(false);
        return;
    L29:
        return;
    L28:
        return;
    L17:
        if (r7 > r4.length()) goto L19;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.base.f
    public final void E(com.ss.android.lark.keyboard.base.l r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.v.remove(r2);
    }

    @Override // com.ss.android.lark.keyboard.base.f
    public void I(CharSequence r3) {
        Intrinsics.checkNotNullParameter(r3, "hint");
        if (this.G == true) goto L5;
        return;
    L5:
        this.a = r3;
        U().a(0, r3);
    }

    @Override // com.ss.android.lark.keyboard.base.f
    public final com.ss.android.lark.keyboard.base.q N(boolean r10) {
        String r3 = ExtensionEditTextCompatKt.g(L());
        if (TextUtils.isEmpty(StringsKt.trim(r3).toString()) == false) goto L6;
        return null;
    L6:
        w0();
        String r2 = StringsKt.trim(k0()).toString();
        Editable r0 = L().getEditableText();
        boolean r5 = false;
        com.ss.android.lark.keyboard.plugin.tool.at.b[] r1 = (com.ss.android.lark.keyboard.plugin.tool.at.b[]) r0.getSpans(0, r0.length(), com.ss.android.lark.keyboard.plugin.tool.at.b.class);
        if (r1.length != 0) goto L9;
        boolean r4 = true;
    L10:
        boolean r6 = !r4;
        if (r6 == false) goto L47;
        if (r10 == true) goto L47;
        com.ss.android.lark.keyboard.plugin.tool.at.b r11 = (com.ss.android.lark.keyboard.plugin.tool.at.b) ArraysKt.first(r1);
        Editable r7 = L().getEditableText();
        int r8 = r7.getSpanStart(r11);
        int r9 = r7.getSpanEnd(r11);
        if (r8 >= 0) goto L16;
    L18:
        boolean r12 = false;
    L19:
        if (r12 == false) goto L28;
        if (r9 >= 0) goto L22;
    L24:
        boolean r13 = false;
    L25:
        if (r13 == false) goto L28;
        if (r8 >= r9) goto L28;
        r7.delete(r8, r9);
        goto L28
    L22:
        if (r9 > r7.length()) goto L24;
        r13 = true;
    L28:
        int r14 = 0;
    L30:
        if (r14 >= r7.length()) goto L34;
        if (Character.isWhitespace(r7.charAt(r14)) == false) goto L34;
        r14 = r14 + 1;
    L34:
        if (r14 <= 0) goto L36;
        r7.delete(0, r14);
    L36:
        Editable r15 = L().getEditableText();
        int r16 = r15.getSpanStart(r11);
        int r17 = r15.getSpanEnd(r11);
        int r18 = L().getEditableText().length();
        if (r16 < 0) goto L40;
        if (r16 >= r18) goto L40;
        boolean r19 = true;
    L41:
        if (r19 == false) goto L47;
        if (r17 < 0) goto L45;
        if (r17 >= r18) goto L45;
        r5 = true;
    L45:
        if (r5 == false) goto L47;
        r15.delete(r16, r17);
    L40:
        r19 = false;
        goto L41
    L16:
        if (r8 >= r7.length()) goto L18;
        r12 = true;
    L47:
        RichText r110 = ExtensionEditTextCompatKt.d(L());
        r110.setRichTextVersion(1);
        return new com.ss.android.lark.keyboard.base.q(r2, r3, r110, this.E, r6, S(), T());
    L9:
        r4 = false;
        goto L10
    }

    @Override // mob.a
    public final View b(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return LayoutInflater.from(r4.getContext()).inflate(W(), r4, false);
    }

    public final CharSequence c0(CharSequence r4) {
        Intrinsics.checkNotNullParameter(r4, "hint");
        if (this.C == false) goto L5;
        return r4;
    L5:
        Log.i("BaseRichTextInputPlugin", "interceptHintIfNeed.");
        CharSequence r0 = this.I.b();
        if (r0.length() <= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        Log.i("RichTextInputShrinkPlugin", "intercepted hint before:" + r4.length() + " after:" + r0.length());
        this.I.a(r4);
        return r0;
    L12:
        return r4;
    L8:
        r1 = false;
        goto L9
    }

    public final void f0(String r3) {
        com.ss.android.lark.keyboard.event.k r0 = V().e();
        if (Intrinsics.areEqual(r3, "title") == false) goto L6;
        com.ss.android.lark.keyboard.event.k.a.a(r0, ChatEditorCurET.Title);
        return;
    L6:
        if (Intrinsics.areEqual(r3, "content") == false) goto L10;
        com.ss.android.lark.keyboard.event.k.a.a(r0, ChatEditorCurET.Content);
        return;
    }

    public final void m0(boolean r8) {
        boolean r0 = false;
        if (r8 == false) goto L39;
        Editable r1 = V().L().c().getEditableText();
        if (r1 == null) goto L36;
        SpannableStringBuilder r3 = new SpannableStringBuilder(r1);
        if (r3.length() != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L25;
        int r4 = r3.length();
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L17;
        if (Character.isWhitespace(r3.charAt(r5)) == false) goto L17;
        r5 = r5 + 1;
    L17:
        int r6 = r4 - 1;
    L18:
        if (r6 < r5) goto L22;
        if (Character.isWhitespace(r3.charAt(r6)) == false) goto L22;
        r6 = r6 - 1;
    L22:
        if (r5 <= r6) goto L24;
        r3.clear();
        goto L25
    L24:
        r3.delete(r6 + 1, r4);
        r3.delete(0, r5);
    L25:
        com.ss.android.lark.keyboard.plugin.tool.at.b[] r7 = (com.ss.android.lark.keyboard.plugin.tool.at.b[]) r3.getSpans(0, r3.length(), com.ss.android.lark.keyboard.plugin.tool.at.b.class);
        if (r7.length != 0) goto L28;
        boolean r9 = true;
    L30:
        if ((!r9) == false) goto L36;
        com.ss.android.lark.keyboard.plugin.tool.at.b r10 = (com.ss.android.lark.keyboard.plugin.tool.at.b) ArraysKt.firstOrNull(r7);
        int r11 = r3.getSpanStart(r10);
        int r12 = r3.getSpanEnd(r10);
        if (r11 != 0) goto L36;
        if (r12 != r3.length()) goto L36;
        boolean r13 = true;
    L37:
        if (r13 == true) goto L39;
        r0 = true;
        goto L39
    L28:
        r9 = false;
        goto L30
    L9:
        r2 = false;
    L36:
        r13 = false;
    L39:
        View r14 = this.t;
        if (r14 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("msgSendButton");
        r14 = null;
    L43:
        r14.setEnabled(r0);
        Iterator<T> r15 = this.v.iterator();
    L45:
        if (r15.hasNext() == false) goto L47;
        ((com.ss.android.lark.keyboard.base.l) r15.next()).y(r0);
        goto L45
    L47:
        e0(r8);
    }

    @Override // com.ss.android.lark.keyboard.base.f
    public final void o(boolean r8) {
        w0();
        String r0 = StringsKt.trim(k0()).toString();
        KeyboardFunctionEditText r1 = L();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.ss.android.lark.keyboard.edittext2.base.FunctionEditText");
        RichText r2 = com.ss.android.lark.keyboard.edittext2.edittors.richText.d.j((com.ss.android.lark.keyboard.edittext2.edittors.richText.d) r1.q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.g));
        InputStateController r3 = Q().a();
        if (r3 == null) goto L12;
        cya.h r4 = r3.d();
        if (r4 == null) goto L12;
        com.ss.android.lark.keyboard.base.n r5 = r4.a;
        if (r5 == null) goto L12;
        ReEditInfo r6 = (ReEditInfo) r5.a(ReEditInfo.Companion);
        if (r6 == null) goto L12;
        String r7 = r6.getMessageId();
        if (r7 == null) goto L12;
    L13:
        boolean r9 = true;
        if (r7.length() != 0) goto L16;
        boolean r10 = true;
    L18:
        if (r10 == false) goto L21;
        Log.w("BaseRichTextInputPlugin", "onReEditConfirmBtnClicked: reEdit msg is is empty");
    L21:
        if (com.ss.android.lark.widget.richtext.i.l(r2) == false) goto L30;
        if (r0.length() == 0) goto L26;
        r9 = false;
    L26:
        if (r9 == false) goto L30;
        Log.i("BaseRichTextInputPlugin", "onReEditConfirmBtnClicked: content are empty, try recall message");
        Intrinsics.checkNotNullParameter(r7, "messageId");
        new UDDialogBuilder(getActivity()).title(2131891071).message(2131891069).addActionButton(2131391778, 2131891068, new com.ss.android.lark.keyboard.editor.input.g(this, r7)).addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).textColorRes(2131102093).text(2131891070).onClickListener(new com.ss.android.lark.keyboard.editor.input.h(this, r7))).show();
        return;
    L30:
        if (this.C == false) goto L33;
        Log.i("BaseRichTextInputPlugin", "onReEditConfirmBtnClicked: interrupt send");
        this.b.a();
        return;
    L33:
        s5c.a r11 = z5c.r.D;
        s5c.a r12 = p3.c;
        r11.getClass();
        s5c.d r13 = s5c.d.b.b(r11, r12);
        if (r8 == false) goto L36;
        s5c.a r14 = x3.d;
    L37:
        s5c.d r15 = r13.plus(r14);
        this.b.b(r7, r0, r2, r15);
        H();
        return;
    L36:
        r14 = x3.c;
        goto L37
    L16:
        r10 = false;
    L12:
        r7 = "";
        goto L13
    }

    public void o0(boolean r2) {
        this.D = true;
        m0(true ^ TextUtils.isEmpty(StringsKt.trim(L().getEditableText())));
        b r3 = this.c;
        if (r3 == null) goto L6;
        r3.onResume();
        return;
    }

    @Override // mob.a
    public final View onViewCreated(View r4) {
        Intrinsics.checkNotNullParameter(r4, "rootView");
        Activity r0 = V().l().getContext();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.n = r0;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.x = r4;
        r(r4);
        KeyboardFunctionEditText r1 = (KeyboardFunctionEditText) r4.findViewById(2131376771);
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.q = r1;
        EditText r2 = (EditText) r4.findViewById(2131376774);
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.p = r2;
        NestedScrollView r3 = r4.findViewById(2131376772);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        this.w = r3;
        View r5 = r4.findViewById(2131387316);
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.s = r5;
        Y().setOnClickListener(new o(this));
        com.ss.android.lark.keyboard.editor.input.o r6 = new com.ss.android.lark.keyboard.editor.input.o(L());
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        this.r = r6;
        i0(r4);
        b0();
        a0();
        KeyboardFunctionEditText r7 = L();
        if ((r7 instanceof FlowKeyboardFunctionEditText) == false) goto L5;
        FlowKeyboardFunctionEditText r8 = (FlowKeyboardFunctionEditText) r7;
    L6:
        if (r8 == null) goto L9;
        r8.setOnPasteUriListener(new com.ss.android.lark.keyboard.editor.input.f(this));
    L9:
        if (com.ss.android.lark.keyboard.edittext2.utils.d.a("messenger.im.disable_doubao_suggest_name_non_blocking_fix") == true) goto L11;
        q0();
    L11:
        t0();
        View.OnTouchListener r9 = new p(this);
        Map<View, View.OnTouchListener> r10 = com.ss.android.lark.keyboard.widget.l.a;
        AppCompatEditText r11 = L();
        Intrinsics.checkNotNullParameter(r11, "view");
        com.ss.android.lark.keyboard.widget.l.a.put((View) r11, r9);
        r11.setOnTouchListener(r9);
        g(r4);
        this.G = true;
        return r4;
    L5:
        r8 = null;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.base.f
    public final void p(com.ss.android.lark.keyboard.base.l r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.v.add(r2);
    }

    @Override // mob.a
    public final void s(lob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "textWatcher");
        this.y = r2;
    }

    public final void s0(RichText r5) {
        RichText r0 = ExtensionEditTextCompatKt.c(L());
        cya.h r3 = null;
        if (Intrinsics.areEqual(r0, r5) == false) goto L14;
        if (r0 == null) goto L6;
        RichTextExtraInfo r1 = r0.getExtraInfo();
    L7:
        if (r5 == null) goto L9;
        RichTextExtraInfo r2 = r5.getExtraInfo();
    L11:
        if (Intrinsics.areEqual(r1, r2) == false) goto L14;
        Log.i("BaseRichTextInputPlugin", "setContentRichText: richText is not changed. method return");
        return;
    L9:
        r2 = null;
        goto L11
    L6:
        r1 = null;
    L14:
        InputStateController r4 = Q().a();
        if (r4 == null) goto L18;
        r3 = r4.f();
    L18:
        if (com.ss.android.lark.widget.richtext.i.l(r5) == true) goto L20;
    L23:
        L().setText("");
        if (com.ss.android.lark.widget.richtext.i.l(r5) == true) goto L26;
        ExtensionEditTextCompatKt.p(L(), r5);
        return;
    L26:
        ExtensionEditTextCompatKt.p(L(), com.ss.android.lark.widget.richtext.c.a());
        return;
    L20:
        if ((r3 instanceof com.ss.android.lark.keyboard.inputstate.c) == false) goto L23;
        Log.i("BaseRichTextInputPlugin", "setContentRichText: skip clearing after exit reply mode");
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void setKeyboard(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.F = r2;
    }

    @Override // mob.a
    public final View t(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        Context r2 = r4.getContext();
        Intrinsics.checkNotNullParameter(r4, "parent");
        a0 r1 = new a0(r2);
        View r5 = r1.getSendBtn();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.t = r5;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.u = r1;
        r1.getSendBtn().setOnClickListener(new com.ss.android.lark.keyboard.editor.input.b(this));
        r1.getSendBtn().setOnLongClickListener(new com.ss.android.lark.keyboard.editor.input.c(this));
        r1.getReEditBtnConfirm().setOnClickListener(new com.ss.android.lark.keyboard.editor.input.d(this));
        r1.getReEditBtnCancel().setOnClickListener(new com.ss.android.lark.keyboard.editor.input.e(this));
        return r1;
    }

    public final void u0(QueryStatusInfo r7) {
        Intrinsics.checkNotNullParameter(r7, "queryStatusInfo");
        if (r7.isQueryStatus() == false) goto L32;
        int r0 = r7.getStartPos();
        boolean r1 = true;
        if (r0 >= 0) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L30;
        int r3 = r7.getEndPos();
        if (r3 >= 0) goto L14;
    L16:
        boolean r4 = false;
    L17:
        if (r4 == false) goto L30;
        Editable r5 = L().getEditableText();
        r7.getSource();
        r5.setSpan(new com.ss.android.lark.keyboard.plugin.tool.at.b(0), r7.getStartPos(), r7.getEndPos(), 33);
        int r8 = L().getSelectionStart();
        L().setText(L().getText());
        if (r8 < 0) goto L27;
        Editable r6 = L().getText();
        if (r6 == null) goto L24;
        int r9 = r6.length();
    L25:
        if (r8 > r9) goto L27;
    L28:
        if (r1 == false) goto L33;
        L().setSelection(r8);
        return;
    L33:
        return;
    L24:
        r9 = 0;
    L27:
        r1 = false;
        goto L28
    L14:
        if (r3 > L().getEditableText().length()) goto L16;
        r4 = true;
    L30:
        Log.w("BaseRichTextInputPlugin", "setQueryStatusInfo: invalid pos, startPos = " + r7.getStartPos() + ", endPos = " + r7.getEndPos() + ", content length = " + L().getEditableText().length());
        return;
    L7:
        if (r0 > L().getEditableText().length()) goto L9;
        r2 = true;
        goto L10
    }

    public final void v0(CharSequence r5) {
        if (r5 != null) goto L4;
        Z().setText("");
    L12:
        if (TextUtils.isEmpty(Z().getText()) == true) goto L20;
        Z().setSelection(Z().length());
        return;
    L20:
        return;
    L4:
        SpannableStringBuilder r0 = new SpannableStringBuilder(r5);
        Iterator r1 = ArrayIteratorKt.iterator((ncc.e[]) r0.getSpans(0, r0.length(), ncc.e.class));
    L6:
        if (r1.hasNext() == false) goto L10;
        Drawable r2 = ((ncc.e) r1.next()).c;
        if (r2 == null) goto L6;
        r2.mutate();
        r2.setTint(Z().getCurrentTextColor());
        goto L6
    L10:
        Z().setText(r5);
        goto L12
    }

    public final void y0(EditText r4) {
        Intrinsics.checkNotNullParameter(r4, "focused");
        if (Build.VERSION.SDK_INT < 30) goto L5;
        com.ss.android.lark.c.f(Q().n());
        return;
    L5:
        r4.postDelayed(new r(this), 30);
    }

    @Override // com.ss.android.lark.keyboard.base.f
    public final void O(CharSequence r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "hint");
        boolean r0 = this.G;
        if (r0 == true) goto L5;
        return;
    L5:
        if (r0 == false) goto L8;
        L().setHintTextColor(r3);
    L8:
        I(r2);
    }

    public final void n(int r4, int r5) {
        ViewGroup r6 = (ViewGroup) X().findViewById(r5);
        dwa.d r0 = getActivity();
        if ((r0 instanceof dwa.d) == false) goto L5;
        View r1 = r0.Ey().b(r0, r4, r6);
    L6:
        if (r1 != null) goto L8;
        r1 = LayoutInflater.from(r0).inflate(r4, r6, false);
    L8:
        r6.addView(r1, new ViewGroup.LayoutParams(-1, -2));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void v(ReEditInfo r2, cya.i r3) {
        Intrinsics.checkNotNullParameter(r2, "reEditData");
        this.B = true;
        a0 r4 = this.u;
        if (r4 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("msgSendBtnWrapper");
        r4 = null;
    L6:
        r4.a(2);
        if (r3 == null) goto L9;
        y(r3);
    L9:
        com.ss.android.lark.c.f(Q().n());
        CharSequence r5 = c0(L().getContext().getString(2131890160));
        U().a(2, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x0(boolean r7, KeyboardFunctionEditText r8) {
        Intrinsics.checkNotNullParameter(r8, "editText");
        if (r7 == false) goto L5;
        int r9 = com.ss.android.lark.keyboard.utils.d.a;
        com.ss.android.lark.keyboard.utils.d.a(r8, new BaseRichTextInputPlugin$setupEnterSendAction$1(this));
    L13:
        r8.setOnEditorActionListener(new q(r8));
        return;
    L5:
        int r10 = com.ss.android.lark.keyboard.utils.d.a;
        Function0<Unit> r11 = new BaseRichTextInputPlugin$setupEnterSendAction$2(this);
        Intrinsics.checkNotNullParameter(r8, "editText");
        Intrinsics.checkNotNullParameter(r11, "sendAction");
        Intrinsics.checkNotNullParameter(r8, "editText");
        r8.setImeOptions(0);
        r8.setHorizontallyScrolling(true);
        r8.setInputType(147457);
        Object r2 = r8.getTag(2131376760);
        if ((r2 instanceof View.OnKeyListener) == false) goto L8;
        View.OnKeyListener r3 = (View.OnKeyListener) r2;
    L10:
        if (r3 == null) goto L12;
        Intrinsics.checkNotNullParameter(r3, "onKeyListener");
        r8.i.remove(r3);
        r8.setOnEditorActionListener(null);
        r8.setTag(2131376760, null);
    L12:
        r8.setHorizontallyScrolling(false);
        com.ss.android.lark.keyboard.utils.c r4 = new com.ss.android.lark.keyboard.utils.c(r11);
        Intrinsics.checkNotNullParameter(r4, "onKeyListener");
        ListProtector.add(r8.i, 0, r4);
        r8.setTag(2131376760, r4);
        goto L13
    L8:
        r3 = null;
        goto L10
    }

    public BaseRichTextInputPlugin(com.ss.android.lark.keyboard.editor.f r3, b r4, Fragment r5) {
        Intrinsics.checkNotNullParameter("", "hint");
        Intrinsics.checkNotNullParameter(r3, "sendCallBack");
        Intrinsics.checkNotNullParameter(r5, "host");
        this.a = "";
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = LazyKt.lazy(new BaseRichTextInputPlugin$attachmentExtension$2(this));
        this.f = LazyKt.lazy(BaseRichTextInputPlugin$fastAlbumAbility$2.INSTANCE);
        this.g = LazyKt.lazy(new BaseRichTextInputPlugin$attachmentEntityListStateFlow$2(this));
        this.m = LazyKt.lazy(LazyThreadSafetyMode.NONE, new BaseRichTextInputPlugin$suggestSendTempEditText$2(this));
        this.v = new LinkedHashSet();
        this.I = new com.ss.android.lark.keyboard.editor.input.a(this);
    }

    @Override // com.ss.android.lark.keyboard.base.f
    public final void F(boolean r11, Long r12, boolean r13, String r14, com.ss.android.lark.keyboard.base.r r15) {
        l0(this, r11, false, null, null, r12, r13, r14, r15, 14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v16, types: [android.widget.EditText, com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText] */
    /* JADX WARN: Type inference failed for: r4v8, types: [android.widget.EditText, com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText] */
    /* JADX WARN: Type inference failed for: r7v17, types: [android.widget.EditText, com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText] */
    public static void l0(BaseRichTextInputPlugin r24, boolean r25, boolean r26, String r27, List r28, Long r29, boolean r30, String r31, com.ss.android.lark.keyboard.base.r r32, int r33) {
        boolean r3 = false;
        if ((r33 & 2) == 0) goto L5;
        boolean r2 = false;
    L6:
        String r5 = "";
        if ((r33 & 4) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r33 & 8) == 0) goto L13;
        List r6 = null;
    L15:
        if ((r33 & 16) == 0) goto L17;
        Long r8 = null;
    L19:
        if ((r33 & 32) == 0) goto L21;
        boolean r9 = true;
    L23:
        if ((r33 & 64) == 0) goto L25;
        String r11 = null;
    L27:
        if ((r33 & 128) == 0) goto L29;
        com.ss.android.lark.keyboard.base.r r1 = null;
    L30:
        r24.getClass();
        Intrinsics.checkNotNullParameter(r4, "suggestTxt");
        if (r24.C == false) goto L33;
        r24.b.a();
        return;
    L33:
        IIMApi r12 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r12 == null) goto L36;
        r12.checkNetworkStatus(r24.getActivity());
    L36:
        if (r2 == true) goto L43;
        wxa.a r7 = (wxa.a) r24.e.getValue();
        if (r7 == null) goto L41;
        r6 = r7.q1();
        goto L43
    L41:
        r6 = null;
    L43:
        if (r2 == false) goto L84;
        String r10 = StringsKt.trimStart(r4).toString();
        String r14 = r24.P();
        Chatter r15 = r24.k;
        if (r15 == null) goto L47;
        String r16 = r15.getId();
    L48:
        if (r16 != null) goto L50;
        r16 = "";
    L50:
        String r13 = com.ss.android.lark.chat.utils.m.b(r24.k, ChatterNameDisplayRule.ALIAS_NAME, false);
        if (StringsKt.isBlank(r13) == false) goto L56;
        r13 = r24.j;
        if (r13 != null) goto L56;
        r13 = "";
    L56:
        if (StringsKt.isBlank(r13) == true) goto L60;
        r14 = r13;
    L60:
        if (StringsKt.isBlank(r14) == false) goto L62;
        String r17 = R();
    L63:
        String r18 = com.ss.android.lark.chat.utils.m.b(r24.k, ChatterNameDisplayRule.NAME, false);
        ?? r19 = (KeyboardFunctionEditText) r24.m.getValue();
        r19.setText(null);
        if ((!StringsKt.isBlank(r16)) == false) goto L68;
        Intrinsics.checkNotNull(r17);
        if ((!StringsKt.isBlank(r17)) == false) goto L68;
        Intrinsics.checkNotNull(r18);
        ExtensionEditTextCompatKt.j(r19, r16, r17, r18, false, false, true);
    L70:
        if (r19.getEditableText().length() <= 0) goto L72;
        boolean r110 = true;
    L73:
        if (r110 == false) goto L78;
        if (StringsKt.last(r19.getEditableText()) == ' ') goto L78;
        r19.getEditableText().append(' ');
    L78:
        if (r10.length() <= 0) goto L80;
        boolean r111 = true;
    L81:
        if (r111 == false) goto L83;
        r19.getEditableText().append(r10);
    L83:
        Pair r20 = TuplesKt.to(ExtensionEditTextCompatKt.g(r19), ExtensionEditTextCompatKt.d(r19));
        com.ss.android.lark.keyboard.base.q r21 = new com.ss.android.lark.keyboard.base.q("", (String) r20.component1(), (RichText) r20.component2(), r24.E, false, r24.S(), r24.T());
    L95:
        if (r2 == false) goto L97;
        boolean r112 = false;
    L98:
        if (r112 == false) goto L150;
        Editable r113 = r24.L().getEditableText();
        String r114 = r24.P();
        Chatter r115 = r24.k;
        if (r115 == null) goto L102;
        String r116 = r115.getId();
    L103:
        if (r116 != null) goto L105;
        r116 = "";
    L105:
        String r22 = com.ss.android.lark.chat.utils.m.b(r24.k, ChatterNameDisplayRule.ALIAS_NAME, false);
        if (StringsKt.isBlank(r22) == false) goto L113;
        String r23 = r24.j;
        if (r23 == null) goto L111;
        r5 = r23;
    L111:
        r22 = r5;
    L113:
        if (StringsKt.isBlank(r22) == true) goto L117;
        r114 = r22;
    L117:
        if (StringsKt.isBlank(r114) == false) goto L119;
        r114 = R();
    L119:
        String r34 = com.ss.android.lark.chat.utils.m.b(r24.k, ChatterNameDisplayRule.NAME, false);
        ?? r35 = (KeyboardFunctionEditText) r24.m.getValue();
        r35.setText(null);
        if ((!StringsKt.isBlank(r116)) == false) goto L124;
        Intrinsics.checkNotNull(r114);
        if ((!StringsKt.isBlank(r114)) == false) goto L124;
        Intrinsics.checkNotNull(r34);
        ExtensionEditTextCompatKt.j(r35, r116, r114, r34, false, false, true);
    L126:
        if (r113.length() <= 0) goto L128;
        boolean r36 = true;
    L129:
        if (r36 == true) goto L131;
    L141:
        if (r11 != null) goto L143;
    L146:
        boolean r37 = true;
    L147:
        if (r37 == true) goto L149;
        r35.getEditableText().append(r11);
    L149:
        String r38 = ExtensionEditTextCompatKt.g(r35);
        RichText r39 = ExtensionEditTextCompatKt.d(r35);
        r39.setRichTextVersion(1);
        Pair r40 = TuplesKt.to(r38, r39);
        r21 = com.ss.android.lark.keyboard.base.q.a(r21, (String) r40.component1(), (RichText) r40.component2(), 1017);
        goto L150
    L143:
        if (r11.length() == 0) goto L146;
        r37 = false;
        goto L147
    L131:
        if (Character.isWhitespace(r113.charAt(0)) == false) goto L133;
    L140:
        r35.getEditableText().append(r113);
        goto L141
    L133:
        if (r35.getEditableText().length() <= 0) goto L135;
        boolean r41 = true;
    L136:
        if (r41 == false) goto L140;
        if (StringsKt.last(r35.getEditableText()) == ' ') goto L140;
        r35.getEditableText().append(' ');
        goto L140
    L135:
        r41 = false;
        goto L136
    L128:
        r36 = false;
    L124:
        r35.getEditableText().append("@").append(r114);
        goto L126
    L102:
        r116 = null;
    L150:
        Context r117 = r24.d.requireContext();
        if (r2 == false) goto L154;
    L163:
        boolean r118 = true;
    L164:
        String r119 = com.ss.android.lark.keyboard.a.d(r24.V());
        String r120 = com.ss.android.lark.keyboard.a.b(r24.V());
        if (r1 != null) goto L167;
    L169:
        boolean r121 = false;
    L170:
        RichText r210 = ExtensionEditTextCompatKt.b(r24.V().L().c());
        if (r1 == null) goto L173;
        Map<String, ResourceUploadInfo> r211 = r1.w;
    L174:
        r21.j = new com.ss.android.lark.keyboard.base.r(r117, r118, r121, r6, r119, r120, r25, r210, r211, 2614776);
        List r42 = r6;
        if (r42 != null) goto L177;
    L180:
        boolean r212 = true;
    L181:
        boolean r43 = !r212;
        if (r43 == false) goto L200;
        if (r8 == null) goto L185;
        long r44 = r8.longValue();
    L186:
        com.ss.android.lark.keyboard.base.r r45 = r21.j;
        if (r45 == null) goto L189;
        r45.d = Long.valueOf(r44);
        r45.e = Boolean.FALSE;
    L189:
        StringBuilder r46 = new StringBuilder("[MessageBatch] prepare batch, queueId=");
        r46.append(r44);
        r46.append(", attachmentCount=");
        if (r6 == null) goto L192;
        int r47 = r6.size();
    L193:
        r46.append(r47);
        r46.append(", hasTrailingText=");
        if (r21.b.length() <= 0) goto L196;
        boolean r48 = true;
    L197:
        r46.append(r48);
        Log.i("BaseRichTextInputPlugin", r46.toString());
        Long r122 = null;
        r24.b.c(r24.d.requireContext(), com.ss.android.lark.keyboard.base.q.a(r21, null, null, 1023));
        wxa.a r49 = (wxa.a) r24.e.getValue();
        if (r49 == null) goto L202;
        r49.W0();
    L202:
        if (r21.b.length() <= 0) goto L204;
        boolean r123 = true;
    L205:
        if (r123 == false) goto L219;
        com.ss.android.lark.keyboard.base.r r50 = r21.j;
        if (r50 == null) goto L212;
        if (r43 == false) goto L210;
        Boolean r51 = Boolean.TRUE;
    L211:
        r50.e = r51;
        goto L212
    L210:
        r51 = r122;
    L212:
        if (r43 == false) goto L218;
        StringBuilder r52 = new StringBuilder("[MessageBatch] dispatch trailing text, queueId=");
        com.ss.android.lark.keyboard.base.r r53 = r21.j;
        if (r53 == null) goto L216;
        Long r54 = r53.d;
    L217:
        r52.append(r54);
        r52.append(", isLastInBatch=true");
        Log.i("BaseRichTextInputPlugin", r52.toString());
        goto L218
    L216:
        r54 = r122;
    L218:
        r24.b.f(r21);
    L219:
        Log.i("BaseRichTextInputPlugin", "onSendBtnClicked: send rich text, hasSmartReply = " + r21.e);
        if (r9 == false) goto L222;
        r24.z();
    L222:
        r24.d0();
        if (l1.a != null) goto L225;
        l1.a = Boolean.valueOf(FeatureGatingModule.getFeatureGatingService().isEnable("im.message.thread_model_addbutton_optimize"));
    L225:
        Boolean r55 = l1.a;
        Intrinsics.checkNotNull(r55, "null cannot be cast to non-null type kotlin.Boolean");
        if (r55.booleanValue() == false) goto L228;
        com.ss.android.lark.keyboard.event.k.a.a(r24.V().e(), com.ss.android.lark.keyboard.event.q.b.a);
    L228:
        com.ss.android.lark.keyboard.event.k r0 = r24.V().e();
        com.ss.android.lark.keyboard.base.r r56 = r21.j;
        if (r56 != null) goto L231;
    L233:
        com.ss.android.lark.keyboard.event.k.a.a(r0, new znb.c(r3));
        return;
    L231:
        if (r56.b != true) goto L233;
        r3 = true;
        goto L233
    L204:
        r123 = false;
        goto L205
    L196:
        r48 = false;
        goto L197
    L192:
        r47 = 0;
        goto L193
    L185:
        r44 = System.currentTimeMillis();
        goto L186
    L200:
        r122 = null;
        goto L202
    L177:
        if (r42.isEmpty() == true) goto L180;
        r212 = false;
        goto L181
    L173:
        r211 = null;
        goto L174
    L167:
        if (r1.c != true) goto L169;
        r121 = true;
        goto L170
    L154:
        if (r24.l == true) goto L163;
        Editable r57 = r24.L().getEditableText();
        if (r57.getSpans(0, r57.length(), com.ss.android.lark.keyboard.edittext.span.b.class).length != 0) goto L158;
        boolean r213 = true;
    L160:
        if ((!r213) == true) goto L163;
        r118 = false;
        goto L164
    L158:
        r213 = false;
        goto L160
    L97:
        r112 = r24.l;
        goto L98
    L80:
        r111 = false;
        goto L81
    L72:
        r110 = false;
    L68:
        r19.getEditableText().append("@").append(r17);
        goto L70
    L62:
        r17 = r14;
        goto L63
    L47:
        r16 = null;
        goto L48
    L84:
        if (r11 == null) goto L92;
        ?? r58 = (KeyboardFunctionEditText) r24.m.getValue();
        r58.setText(null);
        if (r11.length() <= 0) goto L88;
        boolean r124 = true;
    L89:
        if (r124 == false) goto L91;
        r58.getEditableText().append(r11);
    L91:
        r21 = new com.ss.android.lark.keyboard.base.q("", ExtensionEditTextCompatKt.g(r58), ExtensionEditTextCompatKt.d(r58), r24.E, false, r24.S(), r24.T());
        goto L95
    L88:
        r124 = false;
        goto L89
    L92:
        int r59 = com.ss.android.lark.keyboard.base.e.a;
        r21 = r24.N(false);
        if (r21 != null) goto L95;
        r21 = new com.ss.android.lark.keyboard.base.q("", "", ExtensionEditTextCompatKt.d(r24.L()), r24.E, false, r24.S(), r24.T());
        goto L95
    L29:
        r1 = r32;
        goto L30
    L25:
        r11 = r31;
        goto L27
    L21:
        r9 = r30;
        goto L23
    L17:
        r8 = r29;
        goto L19
    L13:
        r6 = r28;
        goto L15
    L9:
        r4 = r27;
        goto L11
    L5:
        r2 = r26;
        goto L6
    }
}
