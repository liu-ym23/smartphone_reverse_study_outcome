package com.ss.android.lark.forwardv3.plugins;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.forwardv3.plugins.at.ForwardAtStrategy;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.span.ClickLinkMovementMethod;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import z5c.r;
import z5c.z2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForwardAtPlugin implements i {
    public final g a;
    public KeyboardFunctionEditText b;
    public boolean c;
    public String d;

    public static final class a {
    }

    public static final class b implements TextWatcher {
        public final /* synthetic */ ForwardAtPlugin a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public b(ForwardAtPlugin r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r2, int r3, int r4, int r5) {
            ForwardAtPlugin r6 = this.a;
            qqb.a.h("");     // Catch: Throwable -> L14
            boolean r0 = true;
            if (r5 != 1) goto L12;
            if (r2 != null) goto L7;
        L9:
            r0 = false;
        L10:
            if (r0 == false) goto L12;
            r6.a.a();     // Catch: Throwable -> L14
            goto L12
        L7:
            if (r2.charAt(r3) != '@') goto L9;
        L12:
            qqb.a.a();
            return;
        L14:
            th = move-exception;
            qqb.a.a();
            throw th;
        }
    }

    public static final class c implements View.OnFocusChangeListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r3, boolean r4) {
            if (r4 == false) goto L5;
            s5c.a r5 = r.j;
            s5c.h r6 = s5c.h.a;
            s5c.a r0 = z2.h;
            int r1 = zib.e.a;
            r5.getClass();
            zib.e.a.e(s5c.d.b.b(r5, r6).plus(r0));
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void c() {
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void d() {
    }

    public ForwardAtPlugin(com.ss.android.lark.forwardv3.plugins.a r2) {
        Intrinsics.checkNotNullParameter(r2, "atDependency");
        this.a = r2;
        this.d = "";
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void a(Intent r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        Serializable r13 = r12.getSerializableExtra("EXTRA_KEY_CHATTER_INFO");
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.collections.List<com.ss.android.lark.search.dto.info.SearchBaseInfo>");
        List r14 = (List) r13;
        ArrayList r0 = new ArrayList();
        if ((!r14.isEmpty()) == false) goto L23;
        Iterator r15 = r14.iterator();
    L8:
        if (r15.hasNext() == false) goto L23;
        SearchChatterInfo r1 = (SearchBaseInfo) r15.next();
        String r4 = r1.getTitle();
        if (com.ss.android.lark.forwardv3.utils.b.b() == true) goto L12;
    L20:
        boolean r5 = false;
    L21:
        r0.add(new g.a(r1.getId(), r4, r5));
        goto L8
    L12:
        if ((r1 instanceof SearchChatterInfo) == false) goto L14;
        SearchChatterInfo r6 = r1;
    L15:
        if (r6 == null) goto L17;
        boolean r7 = r6.isInChat();
    L18:
        if (r7 == true) goto L20;
        r5 = true;
        goto L21
    L17:
        r7 = true;
        goto L18
    L14:
        r6 = null;
    L23:
        if (CollectionUtils.isEmpty(r0) == false) goto L25;
        return;
    L25:
        this.c = true;
        Iterator r16 = r0.iterator();
    L27:
        if (r16.hasNext() == false) goto L40;
        g.a r2 = (g.a) r16.next();
        KeyboardFunctionEditText r3 = this.b;
        if (r3 == null) goto L27;
        com.ss.android.lark.keyboard.edittext2.edittors.a r8 = (com.ss.android.lark.keyboard.edittext2.edittors.a) r3.q(com.ss.android.lark.keyboard.edittext2.edittors.a.e);
        String r9 = r2.a;
        String r10 = r2.b;
        String r11 = r2.c;
        boolean r17 = com.ss.android.lark.forwardv3.utils.b.a("core.forward.alert_support_at", false);
        Log.i("FGUtils", "FG key: core.forward.alert_support_at: " + r17);
        if (r17 == true) goto L33;
    L38:
        boolean r18 = r2.d;
    L39:
        hob.c r19 = new hob.c(r9, r10, r11, r18, r2.e);
        r19.f = false;
        r8.insert(r19);
        goto L27
    L33:
        if (this.d.length() != 0) goto L35;
        boolean r20 = true;
    L36:
        if (r20 == false) goto L38;
        r18 = false;
        goto L39
    L35:
        r20 = false;
        goto L36
    L40:
        AppCompatEditText r110 = this.b;
        if (r110 == null) goto L52;
        r110.post(new com.ss.android.lark.forwardv3.plugins.b(this));
        return;
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void e(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        if (TextUtils.isEmpty((CharSequence) r2) == true) goto L6;
        this.d = (String) r2;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v8, types: [android.widget.EditText, com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText, com.ss.android.lark.keyboard.edittext2.base.FunctionEditText] */
    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final i b(FragmentActivity r2, Fragment r3, View r4) {
        Intrinsics.checkNotNullParameter(r4, "pluginTarget");
        if ((r4 instanceof KeyboardFunctionEditText) == false) goto L5;
        this.b = (KeyboardFunctionEditText) r4;
    L6:
        AppCompatEditText r5 = this.b;
        if (r5 == null) goto L9;
        r5.setHint(2131890746);
    L9:
        AppCompatEditText r6 = this.b;
        if (r6 == null) goto L12;
        r6.addTextChangedListener(new b(this));
    L12:
        AppCompatEditText r7 = this.b;
        if (r7 == null) goto L16;
        r7.setOnFocusChangeListener(c.a);
    L16:
        if (com.ss.android.lark.forwardv3.utils.b.b() == false) goto L20;
        ?? r8 = this.b;
        if (r8 == 0) goto L20;
        r8.setMovementMethod(new ClickLinkMovementMethod(r8));
        ArrayList r9 = new ArrayList();
        r9.add(new ForwardAtStrategy(new ForwardAtPlugin$attachToTargetView$3$1(this)));
        ((com.ss.android.lark.keyboard.edittext2.edittors.a) r8.q(com.ss.android.lark.keyboard.edittext2.edittors.a.e)).W(r9);
    L20:
        return this;
    L5:
        Log.e("ForwardAtPlugin", "ForwardAtPlugin do not support this view");
        goto L6
    }
}
