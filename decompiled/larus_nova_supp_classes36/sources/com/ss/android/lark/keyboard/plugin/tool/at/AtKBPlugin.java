package com.ss.android.lark.keyboard.plugin.tool.at;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import com.bytedance.lark.pb.im.v1.UserGroupEntity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.edittext2.utils.e;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.i;
import com.ss.android.lark.keyboard.keyboard2.m;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.keyboard.statistics.PostInputPluginHitPoint;
import com.ss.android.lark.keyboard.statistics.TextInputPluginHitPoint;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchWikiInfo;
import cya.h;
import hob.d;
import hob.j;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class AtKBPlugin extends m implements com.ss.android.lark.keyboard.base.b {
    public final String c;
    public final boolean d;
    public final com.ss.android.lark.keyboard.plugin.tool.at.a e;
    public final boolean f;
    public View g;
    public final boolean h;
    public boolean i;
    public long j;
    public Chat k;
    public final AtomicBoolean l;
    public final AtomicBoolean m;
    public boolean n;
    public final KeyboardMenuItemKey o;
    public boolean p;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AtKBPlugin b;

        public b(EditText r1, AtKBPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.requestFocus();     // Catch: Throwable -> L4
            this.b.n().z().z();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements lob.a, mob.b {
        public boolean a;
        public final /* synthetic */ AtKBPlugin b;

        @Override // lob.a, android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
        }

        @Override // lob.a, android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // lob.a
        public final void r(Editable r1, int r2, int r3) {
        }

        @Override // lob.a
        public final boolean z(int r1, KeyEvent r2) {
            return false;
        }

        public c(AtKBPlugin r1) {
            this.b = r1;
        }

        @Override // mob.b
        public final void a(boolean r1) {
            this.a = r1;
        }

        @Override // lob.a
        public final void j(EditText r2) {
            Intrinsics.checkNotNullParameter(r2, "editText");
        }

        @Override // lob.a, android.text.TextWatcher
        public final void onTextChanged(CharSequence r8, int r9, int r10, int r11) {
            AtKBPlugin r12 = this.b;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L37
            boolean r1 = true;
            if (r12.p == true) goto L6;
        L35:
            r12.J(false, true);     // Catch: Throwable -> L37
            return;
        L6:
            if (this.a == true) goto L35;
            EditText r2 = r12.H().c();     // Catch: Throwable -> L37
            if (r2.isAttachedToWindow() == true) goto L13;
            r12.J(false, true);     // Catch: Throwable -> L37
            return;
        L13:
            if (r12.f == false) goto L15;
            AtKBPlugin.C(r12, r2, r11);     // Catch: Throwable -> L37
        L30:
            if (r12.f == true) goto L32;
        L34:
            Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L37
        L39:
            Throwable r14 = Result.exceptionOrNull-impl(r13);
            if (r14 == null) goto L44;
            Log.e("AtKBPlugin", "AtKBPlugin's onTextChanged throw Exception", r14);
            return;
        L44:
            return;
        L32:
            if (r12.l.get() == false) goto L34;
            AtKBPlugin.A(r12, r8, r9, r11);     // Catch: Throwable -> L37
            goto L34
        L15:
            if (r11 != 0) goto L17;
            r12.J(false, true);     // Catch: Throwable -> L37
        L17:
            if (r11 != 1) goto L30;
            if (r8 != null) goto L20;
        L22:
            r1 = false;
        L23:
            if (r1 == false) goto L30;
            if (r12.e.a(r12.c, false) != 0) goto L30;
            long r3 = System.currentTimeMillis();     // Catch: Throwable -> L37
            if ((r3 - r12.j) <= 1000) goto L30;
            r12.j = r3;     // Catch: Throwable -> L37
            r12.L();     // Catch: Throwable -> L37
            goto L30
        L20:
            if (r8.charAt(r9) != '@') goto L22;
        L37:
            th = move-exception;
            Result.Companion r15 = Result.Companion;
            r13 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L39
        }
    }

    static {
    }

    public final void L() {
        boolean r0 = true;
        if (J(true, true) == false) goto L7;
        Log.i("AtKBPlugin", "startAtSelector returns for showMentionView.");
        return;
    L7:
        if (this.n == false) goto L9;
        n().z().g();
    L9:
        Chat r1 = this.k;
        if (r1 == null) goto L12;
        boolean r2 = r1.isUserCountVisible();
    L13:
        Log.i("AtKBPlugin", "startAtSelector enable showUserCount: " + r2);
        Bundle r3 = new Bundle();
        Chat r4 = this.k;
        if (r4 != null) goto L16;
    L18:
        r0 = false;
    L19:
        if (r0 == false) goto L21;
        String r5 = INotificationHitPoint.ChatType.CHAT_TYPE_SINGLE;
    L22:
        r3.putString("chat_type", r5);
        this.e.e(r2, n(), r3);
        return;
    L21:
        r5 = INotificationHitPoint.ChatType.CHAT_TYPE_GROUP;
        goto L22
    L16:
        if (r4.isP2PChat() != true) goto L18;
    L12:
        r2 = true;
        goto L13
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final int a() {
        return 2131253681;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void s() {
        boolean r2 = true;
        int r0 = this.e.a(this.c, true);
        if (this.f == true) goto L5;
        if (r0 != 0) goto L9;
        L();
    L12:
        if (H().getInputType() == InputSupportType.Post) goto L16;
        r2 = false;
    L16:
        if (r2 == false) goto L18;
        new PostInputPluginHitPoint("mention").c();
        return;
    L18:
        new TextInputPluginHitPoint("mention").c();
        return;
    L9:
        if (r0 != 1) goto L12;
        G();
        goto L12
    L5:
        if (this.l.get() == true) goto L12;
        this.m.getAndSet(true);
        G();
        goto L12
    }

    public final void G() {
        EditText r0 = H().c();
        int r1 = r0.getSelectionStart();
        Editable r2 = r0.getEditableText();
        if (r1 >= 0) goto L5;
    L8:
        r2.append("@");
        return;
    L5:
        if (r1 >= r2.length()) goto L8;
        r2.insert(r1, "@");
    }

    public final mob.a H() {
        com.ss.android.lark.keyboard.keyboard2.b r0 = n().L();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.keyboard.plugin.input.base.ISendKeyboardEditor");
        return (mob.a) r0;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final Integer q() {
        return 2131914264;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void u() {
        H().s(new c(this));
        n().e().of(this).d(h.class, new AtKBPlugin$onCreate$2$1(this));
        n().z().v(this).c(new AtKBPlugin$onCreate$3(this));
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final KeyboardMenuItemKey g() {
        return this.o;
    }

    public static /* synthetic */ boolean K(AtKBPlugin r2) {
        return r2.J(false, true);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void w(boolean r2) {
        View r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
        r0 = null;
    L5:
        r0.setEnabled(r2);
        this.i = r2;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void x(i r3) {
        Intrinsics.checkNotNullParameter(r3, "iconHolder");
        r3.a.setActivated(this.d);
        this.g = r3.a;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void y(boolean r1) {
        this.p = r1;
    }

    public final boolean J(boolean r3, boolean r4) {
        if (this.f == false) goto L11;
        if (r3 == true) goto L7;
        this.m.set(false);
    L7:
        if (this.l.get() == r3) goto L12;
        boolean r5 = this.e.d(r3, r4);
        this.l.getAndSet(r5);
        return true;
    L12:
        return true;
    L11:
        return false;
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
    @Override // com.ss.android.lark.keyboard.base.b
    public final void e(int r10, Intent r11) {
        Intrinsics.checkNotNullParameter(r11, "data");
        if (r10 == 1638) goto L5;
        return;
    L5:
        boolean r12 = false;
        J(false, true);
        AppCompatEditText r1 = n().L().c();
        Lazy r2 = KeyboardAtModule.a;
        if (((KeyboardAtModule.a) r2.getValue()).isFeatureGatingEnable("messenger.message.corporate_aite_clouddocuments") == true) goto L8;
    L50:
        com.ss.android.lark.keyboard.plugin.tool.at.a.C0154a r13 = this.e.g(r11);
        if (r13.a.isEmpty() == true) goto L53;
    L57:
        if (r12 == false) goto L60;
        return;
    L60:
        if (((KeyboardAtModule.a) r2.getValue()).isFeatureGatingEnable("messenger.setting.mention_user_group") == false) goto L73;
        if ((!r13.b.isEmpty()) == false) goto L73;
        Iterator<T> r14 = r13.b.iterator();
    L65:
        if (r14.hasNext() == false) goto L73;
        UserGroupEntity r3 = (UserGroupEntity) r14.next();
        long r4 = r3.id.longValue();
        String r5 = r3.display_name;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r5, "displayName");
        if ((r1 instanceof FunctionEditText) == false) goto L69;
        FunctionEditText r6 = (FunctionEditText) r1;
    L70:
        if (r6 == null) goto L65;
        ((com.ss.android.lark.keyboard.edittext2.edittors.b) r6.q(com.ss.android.lark.keyboard.edittext2.edittors.b.d)).insert(new d(r4, r5, 1));
        goto L65
    L69:
        r6 = null;
    L73:
        if ((!r13.a.isEmpty()) == false) goto L79;
        Iterator<T> r15 = r13.a.iterator();
    L76:
        if (r15.hasNext() == false) goto L79;
        com.ss.android.lark.keyboard.plugin.tool.at.a.b r7 = (com.ss.android.lark.keyboard.plugin.tool.at.a.b) r15.next();
        this.e.b(r1, r7);
        ExtensionEditTextCompatKt.i(r1, r7.a, r7.c, r7.d, r7.e, r7.f);
    L79:
        if ((!r13.c.isEmpty()) == false) goto L87;
        Iterator<T> r16 = r13.c.iterator();
    L82:
        if (r16.hasNext() == false) goto L87;
        com.ss.android.lark.keyboard.plugin.tool.at.a.c r17 = (com.ss.android.lark.keyboard.plugin.tool.at.a.c) r16.next();
        int r0 = e.c(r1);
        if (r0 < 0) goto L86;
        r1.getEditableText().delete(r0, r0 + 1);
    L86:
        r17.getClass();
        ExtensionEditTextCompatKt.h(r1, null, null, null, true, "");
    L87:
        r1.post(new b(r1, this));
        return;
    L53:
        if (r13.b.isEmpty() == false) goto L57;
        if (r13.c.isEmpty() == false) goto L57;
        r12 = true;
        goto L57
    L8:
        if (r11.getBooleanExtra("IS_NEW_MENTION", false) == false) goto L50;
        Object r18 = r11.getSerializableExtra("MENTION_DATA");
        if (r18 != null) goto L12;
        r18 = CollectionsKt.emptyList();
    L12:
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type kotlin.collections.List<com.ss.android.lark.search.dto.info.SearchBaseInfo>");
        List r19 = (List) r18;
        if (r19.isEmpty() == false) goto L15;
        return;
    L15:
        Iterator r110 = r19.iterator();
    L17:
        if (r110.hasNext() == false) goto L87;
        SearchSpaceInfo r111 = (SearchBaseInfo) r110.next();
        if ((r111 instanceof SearchChatterInfo) == true) goto L20;
        boolean r8 = r111 instanceof SearchSpaceInfo;
        if (r8 == true) goto L25;
        if ((r111 instanceof SearchWikiInfo) == false) goto L17;
    L25:
        if (r8 == false) goto L28;
        String r9 = r111.getDocUrl();
    L31:
        if (r9 == null) goto L17;
        String r20 = r111.getTitle();
        if (r20 == null) goto L17;
        if ((r1 instanceof KeyboardFunctionEditText) == false) goto L39;
        KeyboardFunctionEditText r21 = (KeyboardFunctionEditText) r1;
    L40:
        if (r21 == null) goto L17;
        int r22 = e.c(r1);
        if (r22 < 0) goto L45;
        ((KeyboardFunctionEditText) r1).getEditableText().delete(r22, r22 + 1);
    L45:
        eob.a r23 = (eob.a) r21.q(eob.a.f);
        j r24 = new j(r9);
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r24.e = r20;
        j.a r25 = r24.f;
        if ((r111 instanceof SearchWikiInfo) == false) goto L48;
        int r112 = 2131256245;
    L49:
        r25.a = r112;
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        r24.f = r25;
        r23.insert(r24);
        goto L17
    L48:
        r112 = 2131254246;
        goto L49
    L39:
        r21 = null;
        goto L40
    L28:
        if ((r111 instanceof SearchWikiInfo) == false) goto L30;
        r9 = ((SearchWikiInfo) r111).getUrl();
        goto L31
    L30:
        r9 = null;
        goto L31
    L20:
        SearchChatterInfo r113 = (SearchChatterInfo) r111;
        ExtensionEditTextCompatKt.i(r1, r113.getId(), r113.getTitle(), r113.getTitle(), !r113.isInChat(), false);
        goto L17
    }

    public static final void C(AtKBPlugin r9, EditText r10, int r11) {
        if (r9.f == true) goto L6;
        return;
    L6:
        if (r11 > 2) goto L92;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L71
        Editable r13 = r10.getEditableText();     // Catch: Throwable -> L71
        if (r13 == null) goto L84;
        int r6 = r10.getSelectionStart();     // Catch: Throwable -> L71
        boolean r7 = false;
        if (r6 >= 0) goto L14;
    L69:
        r9.J(false, true);     // Catch: Throwable -> L71
        return;
    L14:
        if (r6 > r13.length()) goto L69;
        if (StringsKt.indexOf$default(r13, '@', 0, false, 6, null) >= 0) goto L19;
        r9.J(false, true);     // Catch: Throwable -> L71
        return;
    L19:
        int r0 = r6 - 1;     // Catch: Throwable -> L71
        if (r0 < 0) goto L22;
    L24:
        com.ss.android.lark.keyboard.edittext2.span.a[] r1 = (com.ss.android.lark.keyboard.edittext2.span.a[]) r13.getSpans(0, r0, com.ss.android.lark.keyboard.edittext2.span.a.class);     // Catch: Throwable -> L71
        int r2 = r13.getSpanEnd((com.ss.android.lark.keyboard.edittext2.span.a) ArraysKt.getOrNull(r1, r1.length - 1));     // Catch: Throwable -> L71
        if (r6 != r2) goto L27;
        r9.J(false, true);     // Catch: Throwable -> L71
    L27:
        if (r0 < 0) goto L68;
        if (r0 < (r6 - 10)) goto L68;
        if (r0 <= (r2 - 1)) goto L68;
        char r3 = r13.charAt(r0);     // Catch: Throwable -> L71
        if (r3 == '@') goto L35;
        if (CharsKt.isWhitespace(r3) == true) goto L65;
        r0 = r0 - 1;     // Catch: Throwable -> L71
        goto L27
    L65:
        if (r9.l.get() == false) goto L88;
        r9.J(false, true);     // Catch: Throwable -> L71
        return;
    L88:
        return;
    L35:
        if (r13.charAt(r0) != '@') goto L59;
        if (r0 <= 0) goto L59;
        char r14 = r13.charAt(r0 - 1);     // Catch: Throwable -> L71
        if ('a' <= r14) goto L40;
    L42:
        boolean r4 = false;
    L43:
        if (r4 == false) goto L45;
    L53:
        boolean r15 = true;
    L54:
        if (r15 == false) goto L59;
        if (r9.m.get() == true) goto L59;
        r9.J(false, true);     // Catch: Throwable -> L71
        return;
    L45:
        if ('A' <= r14) goto L47;
    L49:
        boolean r16 = false;
    L50:
        if (r16 == true) goto L53;
        r15 = false;
        goto L54
    L47:
        if (r14 >= '[') goto L49;
        r16 = true;
        goto L50
    L40:
        if (r14 >= '{') goto L42;
        r4 = true;
    L59:
        if (r0 != (r10.getSelectionStart() - 1)) goto L61;
        r7 = true;
    L61:
        r9.J(true, r7);     // Catch: Throwable -> L71
        return;
    L68:
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L71
    L73:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L90;
        Log.e("AtKBPlugin", "deal updateMentionViewByCursor failed", r18);
        return;
    L90:
        return;
    L22:
        if (r9.l.get() == false) goto L24;
        r9.J(false, true);     // Catch: Throwable -> L71
        goto L24
    L84:
        return;
    L71:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L73
    }

    public static final void A(AtKBPlugin r2, CharSequence r3, int r4, int r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L28
        if (r2.f == true) goto L6;
        return;
    L6:
        if (r2.l.get() == false) goto L40;
        if (r3 == null) goto L41;
        if (r5 < 0) goto L42;
        if (r4 < 0) goto L43;
        int r6 = RangesKt.coerceAtMost(r5 + r4, r3.length());     // Catch: Throwable -> L28
        int r1 = r6 - 1;     // Catch: Throwable -> L28
        if (r4 > r6) goto L44;
    L15:
        if (r1 <= 0) goto L22;
        char r7 = r3.charAt(r1);     // Catch: Throwable -> L28
        if (r7 == '@') goto L22;
        if (CharsKt.isWhitespace(r7) == true) goto L22;
        r1 = r1 - 1;     // Catch: Throwable -> L28
    L22:
        int r8 = r1 + 1;     // Catch: Throwable -> L28
        if (r8 <= r6) goto L25;
        CharSequence r9 = "";
    L26:
        r2.e.h(r9.toString());     // Catch: Throwable -> L28
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L30:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L45;
        Log.e("AtKBPlugin", "deal dealMentionSearch failed", r11);
        return;
    L45:
        return;
    L25:
        r9 = r3.subSequence(r8, r6);     // Catch: Throwable -> L28
        goto L26
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L28:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    }

    public AtKBPlugin(String r3, boolean r4, com.ss.android.lark.keyboard.plugin.tool.at.a r5, boolean r6, String r7, int r8) {
        if ((r8 & 2) == 0) goto L6;
        r4 = false;
    L6:
        if ((r8 & 16) == 0) goto L9;
        r6 = false;
    L9:
        if ((r8 & 32) == 0) goto L11;
        r7 = "";
    L11:
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Intrinsics.checkNotNullParameter(r5, "atDependency");
        Intrinsics.checkNotNullParameter(r7, "threadId");
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.h = true;
        this.l = r5.f();
        this.m = new AtomicBoolean(false);
        this.o = KeyboardMenuItemKey.At;
        this.p = true;
    }
}
