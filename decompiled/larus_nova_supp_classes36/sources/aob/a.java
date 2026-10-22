package aob;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.base.e;
import com.ss.android.lark.keyboard.base.f;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.base.l;
import com.ss.android.lark.keyboard.base.q;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements wnb.b<a>, l {
    public static final C0007a e = null;
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b a;
    public com.ss.android.lark.keyboard.b b;
    public wnb.c c;
    public View d;

    /* JADX INFO: renamed from: aob.a$a, reason: collision with other inner class name */
    public static final class C0007a implements wnb.b.a<a> {
        public C0007a() {
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            com.ss.android.lark.keyboard.keyboard2.b r3 = this.a.f().L();
            if ((r3 instanceof f) == false) goto L5;
            f r4 = (f) r3;
        L6:
            if (r4 == null) goto L9;
            r4.D();
            return;
        L9:
            return;
        L5:
            r4 = null;
            goto L6
        }
    }

    public static final class c implements TextWatcher {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ a b;

        /* JADX INFO: renamed from: aob.a$c$a, reason: collision with other inner class name */
        public static final class RunnableC0008a implements Runnable {
            public final /* synthetic */ a a;
            public final /* synthetic */ EditText b;

            public RunnableC0008a(a r1, EditText r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a r0 = this.a;     // Catch: Throwable -> L11
                if (this.b.getLineCount() < 3) goto L5;
                boolean r1 = true;
            L6:
                C0007a r2 = a.e;     // Catch: Throwable -> L11
                if (r1 == false) goto L9;
                r0.h().a(r2);     // Catch: Throwable -> L11
            L16:
                return;
            L9:
                r0.h().b(r2);     // Catch: Throwable -> L11
                goto L16
            L5:
                r1 = false;
            L11:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L19;
                throw th;
            }
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public c(EditText r1, a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            EditText r5 = this.a;
            r5.post(new RunnableC0008a(this.b, r5));
        }
    }

    static {
        e = new C0007a();
    }

    @Override // com.ss.android.lark.keyboard.base.l
    public final boolean g(q r1) {
        return false;
    }

    @Override // wnb.b
    public final boolean i() {
        return false;
    }

    @Override // com.ss.android.lark.keyboard.base.l
    public final void y(boolean r1) {
    }

    @Override // wnb.b
    public final View a() {
        f r2 = null;
        View r0 = LayoutInflater.from(this.a.a.requireContext()).inflate(2131561611, null);
        ImageView r1 = (ImageView) r0.findViewById(2131375951);
        r0.setOnClickListener(new b(this));
        this.d = r0;
        com.ss.android.lark.keyboard.keyboard2.b r3 = f().L();
        if ((r3 instanceof f) == false) goto L5;
        f r4 = (f) r3;
    L6:
        if (r4 == null) goto L8;
        r4.p(this);
    L8:
        com.ss.android.lark.keyboard.keyboard2.b r5 = f().L();
        if ((r5 instanceof f) == false) goto L11;
        r2 = (f) r5;
    L11:
        boolean r6 = false;
        if (r2 == null) goto L14;
        int r7 = e.a;
        r2.N(false);
    L14:
        EditText r8 = f().L().c();
        if (r8.getLineCount() < 3) goto L17;
        r6 = true;
    L17:
        C0007a r9 = e;
        if (r6 == false) goto L20;
        h().a(r9);
    L21:
        r8.addTextChangedListener(new c(r8, this));
        Intrinsics.checkNotNull(r0);
        return r0;
    L20:
        h().b(r9);
        goto L21
    L5:
        r4 = null;
        goto L6
    }

    @Override // wnb.b
    public final wnb.e b() {
        return new wnb.e(UIHelper.dp2px(6.0f), 0, UIHelper.dp2px(12.0f), 0);
    }

    public final com.ss.android.lark.keyboard.b f() {
        com.ss.android.lark.keyboard.b r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        return null;
    }

    @Override // wnb.b
    public final wnb.c h() {
        wnb.c r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    @Override // wnb.b
    public final void onDestroy() {
        View r0 = this.d;
        if (r0 == null) goto L5;
        r0.setOnClickListener(null);
    L5:
        View r1 = this.d;
        if (r1 == null) goto L21;
        r1.setOnLongClickListener(null);
    L21:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L17
        com.ss.android.lark.keyboard.keyboard2.b r3 = f().L();     // Catch: Throwable -> L17
        if ((r3 instanceof f) == false) goto L11;
        f r4 = (f) r3;     // Catch: Throwable -> L17
    L12:
        if (r4 == null) goto L14;
        r4.E(this);     // Catch: Throwable -> L17
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L17
    L15:
        Result.constructor-impl(r5);     // Catch: Throwable -> L17
    L19:
        this.d = null;
        return;
    L14:
        r5 = null;
        goto L15
    L11:
        r4 = null;
    L17:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }

    @Override // wnb.b
    public final DirectionInParent c() {
        return DirectionInParent.TOP;
    }

    @Override // wnb.b
    public final InputInnerVisibilityMode d() {
        return InputInnerVisibilityMode.DYNAMIC;
    }

    @Override // wnb.b
    public final Direction getDirection() {
        return Direction.InnerEndVertical;
    }

    @Override // wnb.b
    public final wnb.b.a<a> getKey() {
        return e;
    }

    public a(com.ss.android.lark.biz.im.api.extension.chat_window.b r2) {
        Intrinsics.checkNotNullParameter(r2, "keyboardPluginContext");
        this.a = r2;
    }

    @Override // wnb.b
    public final void e(InputInnerController r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    @Override // wnb.b
    public final void setKeyboard(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }
}
