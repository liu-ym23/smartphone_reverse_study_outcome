package com.obric.assistant.chat.component.bottom.core.mention;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import com.larus.applog.api.IApplog;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.p1;
import com.larus.bmhome.chat.model.j1;
import com.larus.bmhome.view.ChatInputText;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.ability.chat.input.SkillSelectSource;
import com.obric.assistant.chat.component.bottom.core.k;
import com.obric.assistant.special_input.PhoneOperationModeRestoreResult;
import com.obric.assistant.special_input.j;
import com.obric.assistant.special_input.p0;
import com.obric.assistant.util.ObricMentionHighlightHelper;
import com.obric.assistant.util.r1;
import com.obric.assistant.util.s1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricMentionInputController {
    public static final /* synthetic */ int o = 0;
    public final Context a;
    public final EditText b;
    public final paa.c c;
    public final p1 d;
    public final com.larus.bmhome.instruction.g e;
    public final ICoreInputAbility f;
    public final Function0<de8.c> g;
    public ObricMentionHighlightHelper.a h;
    public String i;
    public boolean j;
    public boolean k;
    public final f l;
    public final g m;
    public final h n;

    public static final class a {
    }

    public static abstract class b {

        public static final class a extends b {
            public final paa.e a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Allowed(skill=" + this.a + ')';
            }

            public a(paa.e r2) {
                Intrinsics.checkNotNullParameter(r2, "skill");
                this.a = r2;
            }
        }

        /* JADX INFO: renamed from: com.obric.assistant.chat.component.bottom.core.mention.ObricMentionInputController$b$b, reason: collision with other inner class name */
        public static final class C0077b extends b {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0077b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0077b) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Rejected(reason=" + this.a + ')';
            }

            public C0077b(String r2) {
                Intrinsics.checkNotNullParameter(r2, "reason");
                this.a = r2;
            }
        }

        public b() {
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PhoneOperationModeRestoreResult.values().length];
            r0[PhoneOperationModeRestoreResult.READY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[PhoneOperationModeRestoreResult.NOT_READY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[PhoneOperationModeRestoreResult.UNAVAILABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.obric.assistant.chat.component.bottom.core.mention.b, java.lang.Object] */
    public final void b() {
        if (this.h == null) goto L5;
        return;
    L5:
        int r4 = ContextCompat.getColor(this.a, 2131103809);
        int r0 = ObricMentionHighlightHelper.a;
        EditText r3 = this.b;
        ObricMentionInputController$attachHighlight$1 r5 = new ObricMentionInputController$attachHighlight$1(this);
        ?? r6 = new com.obric.assistant.chat.component.bottom.core.mention.b(this);
        ObricMentionInputController$attachHighlight$3 r7 = new ObricMentionInputController$attachHighlight$3(this);
        ObricMentionInputController$attachHighlight$4 r8 = new ObricMentionInputController$attachHighlight$4(this);
        Intrinsics.checkNotNullParameter(r3, "editText");
        Intrinsics.checkNotNullParameter(r5, "isEnabled");
        Intrinsics.checkNotNullParameter(r6, "mentionItemsProvider");
        Intrinsics.checkNotNullParameter(r7, "onSelected");
        Intrinsics.checkNotNullParameter(r8, "onUnselected");
        TextWatcher r1 = new ObricMentionHighlightHelper.a(r3, r4, r5, r6, r7, r8);
        Object r2 = ((ObricMentionHighlightHelper.a) r1).a.getTag(2131381214);
        ChatInputText r9 = null;
        if ((r2 instanceof View.OnKeyListener) == false) goto L8;
        View.OnKeyListener r10 = (View.OnKeyListener) r2;
    L9:
        ((ObricMentionHighlightHelper.a) r1).m = r10;
        ((ObricMentionHighlightHelper.a) r1).a.setOnKeyListener(new r1(r1));
        EditText r11 = ((ObricMentionHighlightHelper.a) r1).a;
        if ((r11 instanceof ChatInputText) == false) goto L12;
        r9 = (ChatInputText) r11;
    L12:
        if (r9 == null) goto L16;
        s1 r12 = ((ObricMentionHighlightHelper.a) r1).p;
        Intrinsics.checkNotNullParameter(r12, "interceptor");
        if (((ArrayList) r9.f).contains(r12) == true) goto L16;
        ((ArrayList) r9.f).add(r12);
    L16:
        r1.g(((ObricMentionHighlightHelper.a) r1).a.getText());
        ((ObricMentionHighlightHelper.a) r1).a.addTextChangedListener(r1);
        r1.o(((ObricMentionHighlightHelper.a) r1).a.getText());
        this.h = r1;
        return;
    L8:
        r10 = null;
        goto L9
    }

    public final void d() {
        if (this.k == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L10;
        this.b.post(new com.obric.assistant.chat.component.bottom.core.mention.c(this));
        return;
    L10:
        if (this.j == true) goto L13;
        FLogger.a.i("ObricMentionInputController", "consumeAutoMentionFromRoute: wait for text draft restore");
        return;
    L13:
        de8.c r0 = (de8.c) this.g.invoke();
        List<paa.e> r2 = null;
        if (r0 == null) goto L17;
        Bundle r3 = r0.b;
        if (r3 == null) goto L17;
    L21:
        if (com.obric.assistant.chat.b.b(r3) == true) goto L23;
        return;
    L23:
        boolean r5 = false;
        if (com.obric.assistant.chat.b.c(r3) == false) goto L69;
        b r1 = k(r3);
        if ((r1 instanceof b.a) == false) goto L64;
        paa.e r4 = ((b.a) r1).a;
        if (r3 == null) goto L30;
        String r10 = r3.getString("obric_auto_mention_content");
    L31:
        if (r10 != null) goto L34;
        r10 = NameKeys.UnloadStrategy_No_Strategy;
    L34:
        if (StringsKt.isBlank(r10) == false) goto L36;
        j(r3, "route_demo", "content_blank");
        e();
        return;
    L36:
        String r12 = "@" + r4.b;
        if (StringsKt.contains$default(r10, r12, false, 2, null) == true) goto L40;
        r10 = r12 + ' ' + r10;
    L40:
        paa.c r9 = this.c;
        if (r9 == null) goto L43;
        r2 = r9.Nh();
    L43:
        if (r2 != null) goto L45;
        r2 = CollectionsKt.emptyList();
    L45:
        List r6 = CollectionsKt.plus(r2, r4);
        HashSet r11 = new HashSet();
        ArrayList r13 = new ArrayList();
        Iterator r7 = r6.iterator();
    L47:
        if (r7.hasNext() == false) goto L51;
        Object r14 = r7.next();
        if (r11.add(((paa.e) r14).a) == false) goto L47;
        r13.add(r14);
        goto L47
    L51:
        int r8 = ObricMentionHighlightHelper.a;
        ObricMentionHighlightHelper.d r15 = ObricMentionHighlightHelper.a(r10, ContextCompat.getColor(this.a, 2131103809), r13);
        if (r15 != null) goto L54;
        j(r3, "route_demo", "restore_content_empty");
        e();
        return;
    L54:
        PhoneOperationModeRestoreResult r16 = p0.a(this.e, "route_demo", true);
        Intrinsics.checkNotNullParameter(r16, "<this>");
        if (r16 != PhoneOperationModeRestoreResult.READY) goto L57;
        r5 = true;
    L57:
        if (r5 == true) goto L60;
        j(r3, "route_demo", "phone_operation_unavailable");
        e();
        return;
    L60:
        if (o(r4, r15.b, SkillSelectSource.ROUTE_DEMO, true) == true) goto L62;
        FLogger.a.w("ObricMentionInputController", "consumeAutoMentionPrefillFromRoute: sync failed, skillId=" + r4.a);
        j(r3, "route_demo", "sync_failed");
        e();
        return;
    L62:
        a(r4, "obric_auto_mention_prefill", r15.a, true);
        e();
        FLogger.a.i("ObricMentionInputController", "consumeAutoMentionPrefillFromRoute: success, skillId=" + r4.a);
        return;
    L30:
        r10 = null;
        goto L31
    L64:
        if ((r1 instanceof b.C0077b) == false) goto L68;
        FLogger r17 = FLogger.a;
        StringBuilder r18 = new StringBuilder("consumeAutoMentionPrefillFromRoute: rejected, reason=");
        b.C0077b r19 = (b.C0077b) r1;
        r18.append(r19.a);
        r17.w("ObricMentionInputController", r18.toString());
        j(r3, "route_demo", r19.a);
        e();
        return;
    L68:
        throw new NoWhenBranchMatchedException();
    L69:
        b r20 = k(r3);
        if ((r20 instanceof b.a) == false) goto L91;
        paa.e r21 = ((b.a) r20).a;
        PhoneOperationModeRestoreResult r110 = p0.a(this.e, "route_use", true);
        Intrinsics.checkNotNullParameter(r110, "<this>");
        if (r110 != PhoneOperationModeRestoreResult.READY) goto L74;
        boolean r22 = true;
    L75:
        if (r22 == true) goto L78;
        j(r3, "route_use", "phone_operation_unavailable");
        e();
        return;
    L78:
        List<String> r23 = CollectionsKt.listOf(r21.a);
        SkillSelectSource r24 = SkillSelectSource.ROUTE_USE;
        ICoreInputAbility r111 = this.f;
        if (r111 != null) goto L81;
    L83:
        boolean r25 = false;
    L85:
        if (o(r21, r23, r24, true ^ r25) == true) goto L88;
        FLogger.a.w("ObricMentionInputController", "consumeAutoMentionFromRoute: sync failed, skillId=" + r21.a);
        j(r3, "route_use", "sync_failed");
        e();
        return;
    L88:
        a(r21, "obric_auto_mention", null, false);
        e();
        return;
    L81:
        if (r111.Rp() != 2) goto L83;
        r25 = true;
        goto L85
    L74:
        r22 = false;
        goto L75
    L91:
        if ((r20 instanceof b.C0077b) == false) goto L95;
        FLogger r26 = FLogger.a;
        StringBuilder r27 = new StringBuilder("consumeAutoMentionFromRoute: rejected, reason=");
        b.C0077b r28 = (b.C0077b) r20;
        r27.append(r28.a);
        r26.w("ObricMentionInputController", r27.toString());
        j(r3, "route_use", r28.a);
        e();
        return;
    L95:
        throw new NoWhenBranchMatchedException();
    L17:
        if (r0 == null) goto L19;
        r3 = r0.a;
        goto L21
    L19:
        r3 = null;
        goto L21
    }

    public final void e() {
        de8.c r0 = (de8.c) this.g.invoke();
        int r1 = com.obric.assistant.chat.b.a;
        Bundle r2 = null;
        if (r0 == null) goto L5;
        Bundle r3 = r0.b;
    L6:
        com.obric.assistant.chat.b.a(r3);
        if (r0 == null) goto L9;
        r2 = r0.a;
    L9:
        com.obric.assistant.chat.b.a(r2);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void f() {
        paa.c r0 = this.c;
        if (r0 == null) goto L5;
        List<paa.e> r1 = r0.a00();
    L6:
        if (r1 != null) goto L8;
        r1 = CollectionsKt.emptyList();
    L8:
        Iterator<T> r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        paa.e r3 = (paa.e) r2.next();
        b();
        ObricMentionHighlightHelper.a r4 = this.h;
        if (r4 == null) goto L10;
        r4.l(r3);
        goto L10
    L14:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void g() {
        p1 r0 = this.d;
        if (r0 == null) goto L18;
        j1 r1 = r0.Y3();
        if (r1 == null) goto L19;
        paa.c r2 = this.c;
        if (r2 == null) goto L10;
        List<String> r3 = r2.Yg();
    L11:
        if (r3 != null) goto L14;
        r3 = CollectionsKt.emptyList();
    L14:
        if (Intrinsics.areEqual(r1.o(), r3) == false) goto L16;
        return;
    L16:
        r1.k(r3);
        return;
    L10:
        r3 = null;
        goto L11
    L19:
        return;
    }

    public final void h() {
        p1 r0 = this.d;
        if (r0 == null) goto L18;
        j1 r1 = r0.Y3();
        if (r1 == null) goto L19;
        paa.c r2 = this.c;
        if (r2 == null) goto L10;
        List<String> r3 = r2.AM();
    L11:
        if (r3 != null) goto L14;
        r3 = CollectionsKt.emptyList();
    L14:
        if (Intrinsics.areEqual(r1.r(), r3) == false) goto L16;
        return;
    L16:
        r1.j(r3);
        return;
    L10:
        r3 = null;
        goto L11
    L19:
        return;
    }

    public final void i() {
        if (this.k == true) goto L5;
        return;
    L5:
        ICoreInputAbility r0 = this.f;
        if (r0 == null) goto L9;
        r0.oz(com.obric.assistant.task.skill.f.d());
    L9:
        if (com.obric.assistant.task.skill.f.d() == true) goto L11;
    L13:
        boolean r1 = false;
    L14:
        if (r1 == true) goto L19;
        ObricMentionHighlightHelper.a r2 = this.h;
        if (r2 == null) goto L20;
        r2.h = null;
        r2.e();
        return;
    L20:
        return;
    L19:
        return;
    L11:
        if (j.b() == false) goto L13;
        r1 = true;
        goto L14
    }

    public final b k(Bundle r5) {
        if (r5 == null) goto L4;
        String r0 = r5.getString("obric_skill_slug");
        String r1 = NameKeys.UnloadStrategy_No_Strategy;
        if (r0 != null) goto L8;
        r0 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        String r2 = StringsKt.trim(r0).toString();
        String r3 = r5.getString("obric_skill_display_name");
        if (r3 == null) goto L12;
        r1 = r3;
    L12:
        String r4 = StringsKt.trim(r1).toString();
        if (StringsKt.isBlank(r2) == true) goto L36;
        if (StringsKt.isBlank(r4) == true) goto L36;
        paa.c r6 = this.c;
        if (r6 == null) goto L20;
        paa.e r7 = r6.GJ(r2);
        if (r7 != null) goto L24;
        String r8 = r5.getString("obric_skill_cover_url");
        if (r8 == null) goto L32;
        String r9 = StringsKt.trim(r8).toString();
        if (r9 == null) goto L32;
        if ((!StringsKt.isBlank(r9)) == false) goto L32;
    L34:
        return new b.a(new paa.e(r2, r4, r9, 56));
    L32:
        r9 = null;
        goto L34
    L24:
        return new b.a(r7);
    L20:
        return new b.C0077b("skill ability unavailable");
    L36:
        return new b.C0077b("skill metadata is blank");
    L4:
        return new b.C0077b("arguments is null");
    }

    public final void l(List<paa.e> r15) {
        if (this.j == true) goto L5;
        return;
    L5:
        p1 r0 = this.d;
        if (r0 == null) goto L80;
        j1 r1 = r0.Y3();
        if (r1 == null) goto L82;
        List r2 = r1.r();
        if (r2.isEmpty() == false) goto L13;
        return;
    L13:
        boolean r3 = false;
        if (r15.isEmpty() == false) goto L23;
        paa.c r4 = this.c;
        if (r4 != null) goto L18;
    L20:
        boolean r5 = false;
    L21:
        if (r5 == true) goto L23;
        return;
    L18:
        if (r4.Yb() != true) goto L20;
        r5 = true;
    L23:
        HashSet r6 = new HashSet();
        Iterator<T> r16 = r15.iterator();
    L25:
        if (r16.hasNext() == false) goto L27;
        r6.add(((paa.e) r16.next()).a);
        goto L25
    L27:
        ArrayList r7 = new ArrayList();
        Iterator r17 = r2.iterator();
    L29:
        if (r17.hasNext() == false) goto L34;
        Object r8 = r17.next();
        if (r6.contains((String) r8) == false) goto L29;
        r7.add(r8);
        goto L29
    L34:
        if (r7.isEmpty() == false) goto L40;
        FLogger.a.i("ObricMentionInputController", "restoreSelectedSkillsFromDraft: no available skill matches draft, clear draft");
        paa.c r18 = this.c;
        if (r18 == null) goto L38;
        r18.x70(CollectionsKt.emptyList());
    L38:
        r1.j(CollectionsKt.emptyList());
        return;
    L40:
        paa.c r19 = this.c;
        if (r19 == null) goto L43;
        List<String> r110 = r19.AM();
    L44:
        if (r110 != null) goto L47;
        r110 = CollectionsKt.emptyList();
    L47:
        if (Intrinsics.areEqual(CollectionsKt.toSet(r110), CollectionsKt.toSet(r7)) == false) goto L49;
        return;
    L49:
        int r111 = c.a[p0.a(this.e, "selected_draft_restore", true).ordinal()];
        if (r111 == 1) goto L63;
        if (r111 != 2) goto L53;
        FLogger.a.i("ObricMentionInputController", "restoreSelectedSkillsFromDraft: wait omni skill state");
        return;
    L53:
        if (r111 != 3) goto L60;
        FLogger.a.w("ObricMentionInputController", "restoreSelectedSkillsFromDraft: phone-operation/omni unavailable, clear draft");
        paa.c r112 = this.c;
        if (r112 == null) goto L57;
        r112.x70(CollectionsKt.emptyList());
    L57:
        r1.j(CollectionsKt.emptyList());
        return;
    L60:
        throw new NoWhenBranchMatchedException();
    L63:
        paa.c r113 = this.c;
        if (r113 == null) goto L66;
        r113.x70(r7);
    L66:
        h();
        FLogger.a.i("ObricMentionInputController", "restoreSelectedSkillsFromDraft: restored skillIds=" + CollectionsKt.joinToString$default(r7, null, null, null, 0, null, null, 63, null));
        ICoreInputAbility r114 = this.f;
        if (r114 != null) goto L69;
    L71:
        if (r3 == true) goto L81;
        f();
        return;
    L81:
        return;
    L69:
        if (r114.Rp() != 2) goto L71;
        r3 = true;
        goto L71
    L43:
        r110 = null;
        goto L44
    L82:
        return;
    }

    public final void m(List<paa.e> r12) {
        String r0 = this.i;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r12.isEmpty() == false) goto L8;
        return;
    L8:
        Editable r1 = this.b.getText();
        if (r1 == null) goto L26;
        String r2 = r1.toString();
        if (r2 != null) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r2, r0) == true) goto L17;
        this.i = null;
        FLogger.a.i("ObricMentionInputController", "retryDraftRestoreIfNeeded skipped, input text changed");
        return;
    L17:
        CharSequence r4 = c(r0, r12, false);
        if (r4 != null) goto L21;
        FLogger.a.i("ObricMentionInputController", "retryDraftRestoreIfNeeded skipped, no mention match");
        return;
    L21:
        ICoreInputAbility r3 = this.f;
        if (r3 == null) goto L24;
        ICoreInputAbility.b.d(r3, r4, false, false, null, null, false, 62);
    L24:
        FLogger.a.i("ObricMentionInputController", "retryDraftRestoreIfNeeded success");
        return;
    }

    public final void n(List<String> r3, SkillSelectSource r4) {
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        String r0 = (String) r5.next();
        paa.c r1 = this.c;
        if (r1 == null) goto L4;
        r1.YW(r0, r4);
        goto L4
    L8:
        g();
    }

    public final CharSequence c(String r8, List<paa.e> r9, boolean r10) {
        p1 r0 = this.d;
        if (r0 == null) goto L7;
        j1 r1 = r0.Y3();
        if (r1 == null) goto L7;
        List r2 = r1.o();
    L8:
        if (r2 != null) goto L11;
        r2 = CollectionsKt.emptyList();
    L11:
        if (r2.isEmpty() == false) goto L13;
        return null;
    L13:
        int r3 = ContextCompat.getColor(this.a, 2131103809);
        Set r4 = CollectionsKt.toSet(r2);
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r9.iterator();
    L15:
        if (r6.hasNext() == false) goto L19;
        Object r7 = r6.next();
        if (r4.contains(((paa.e) r7).a) == false) goto L15;
        r5.add(r7);
        goto L15
    L19:
        ObricMentionHighlightHelper.d r11 = ObricMentionHighlightHelper.a(r8, r3, r5);
        if (r11 != null) goto L28;
        if (r10 == true) goto L23;
    L27:
        return null;
    L23:
        if (r9.isEmpty() == false) goto L27;
        if (StringsKt.contains$default(r8, '@', false, 2, null) == false) goto L27;
        this.i = r8;
        FLogger.a.i("ObricMentionInputController", "buildRestoreTextDraftContent: defer until skill cache loaded");
        goto L27
    L28:
        int r12 = c.a[p0.a(this.e, "draft_restore", true).ordinal()];
        if (r12 == 1) goto L43;
        if (r12 != 2) goto L32;
        this.i = r8;
        FLogger.a.i("ObricMentionInputController", "buildRestoreTextDraftContent: defer until omni skill state ready");
        return null;
    L32:
        if (r12 != 3) goto L40;
        this.i = null;
        FLogger.a.w("ObricMentionInputController", "buildRestoreTextDraftContent: skip mention restore, phone operation mode unavailable");
        p1 r13 = this.d;
        if (r13 == null) goto L38;
        j1 r14 = r13.Y3();
        if (r14 == null) goto L38;
        r14.k(CollectionsKt.emptyList());
    L38:
        return null;
    L40:
        throw new NoWhenBranchMatchedException();
    L43:
        this.i = null;
        n(r11.b, SkillSelectSource.DRAFT);
        return r11.a;
    L7:
        r2 = null;
        goto L8
    }

    public final void j(Bundle r3, String r4, String r5) {
        JSONObject r0 = new JSONObject();
        r0.put("source", r4);
        if (r3 == null) goto L5;
        String r6 = r3.getString("obric_skill_slug");
    L6:
        if (r6 != null) goto L8;
        r6 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        r0.put("skill_id", r6);
        r0.put("reason", r5);
        paa.c r7 = this.c;
        if (r7 == null) goto L13;
        boolean r8 = true;
        if (r7.Yb() != true) goto L13;
    L14:
        r0.put("cache_loaded", r8);
        r0.put("has_prefill", com.obric.assistant.chat.b.c(r3));
        FLogger.a.i("ObricMentionInputController", "report obric_auto_mention_rejected: " + r0);
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L17
        IApplog.a.reportEvent("obric_auto_mention_rejected", r0);     // Catch: Throwable -> L17
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L25;
        FLogger.a.w("ObricMentionInputController", "report obric_auto_mention_rejected failed. " + r11.getMessage(), r11);
        return;
    L25:
        return;
    L17:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L13:
        r8 = false;
        goto L14
    L5:
        r6 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r8v4, types: [com.obric.assistant.chat.component.bottom.core.mention.e, java.lang.Object] */
    public final void a(paa.e r8, String r9, final CharSequence r10, boolean r11) {
        ICoreInputAbility r0 = this.f;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        if (r11 == true) goto L11;
        return;
    L11:
        b();
        ObricMentionHighlightHelper.a r12 = this.h;
        if (r12 != null) goto L15;
        return;
    L15:
        if (r10 != null) goto L17;
        this.b.requestFocus();
        EditText r13 = this.b;
        r13.setSelection(r13.length());
        r12.l(r8);
    L36:
        ICoreInputAbility r14 = this.f;
        if (r14 == null) goto L39;
        r14.g2(3, true);
    L39:
        ICoreInputAbility r15 = this.f;
        if (r15 == null) goto L54;
        ICoreInputAbility.b.e(r15, r9, null, false, 6);
        return;
    L54:
        return;
    L17:
        paa.c r3 = this.c;
        if (r3 == null) goto L20;
        List<paa.e> r4 = r3.Nh();
    L21:
        if (r4 != null) goto L23;
        r4 = CollectionsKt.emptyList();
    L23:
        List r16 = CollectionsKt.plus(r4, r8);
        HashSet r5 = new HashSet();
        ArrayList r6 = new ArrayList();
        Iterator r17 = r16.iterator();
    L25:
        if (r17.hasNext() == false) goto L29;
        Object r7 = r17.next();
        if (r5.add(((paa.e) r7).a) == false) goto L25;
        r6.add(r7);
        goto L25
    L29:
        ?? r18 = new e(this, r10);
        Intrinsics.checkNotNullParameter(r6, "mentionItems");
        Intrinsics.checkNotNullParameter(r18, "updateText");
        r12.i = true;
        r12.l = null;
        r18.invoke();     // Catch: Throwable -> L43
        Iterator r19 = r6.iterator();     // Catch: Throwable -> L43
    L32:
        if (r19.hasNext() == false) goto L34;
        r12.f((paa.e) r19.next());     // Catch: Throwable -> L43
        goto L32
    L34:
        r12.g(r12.a.getText());     // Catch: Throwable -> L43
        r12.i = false;
        r12.o(r12.a.getText());
    L43:
        th = move-exception;
        r12.i = false;
        throw th;
    L20:
        r4 = null;
        goto L21
    L5:
        if (r0.Rp() != 2) goto L7;
        r1 = true;
        goto L8
    }

    public final boolean o(paa.e r6, List<String> r7, SkillSelectSource r8, boolean r9) {
        paa.c r0 = this.c;
        if (r0 == null) goto L5;
        r0.hZ(r6, r8);
    L5:
        h();
        paa.c r1 = this.c;
        if (r1 == null) goto L23;
        List<paa.e> r2 = r1.a00();
        if (r2 == null) goto L23;
        List<paa.e> r3 = r2;
        if ((r3 instanceof Collection) == true) goto L12;
    L14:
        Iterator<T> r4 = r3.iterator();
    L16:
        if (r4.hasNext() == false) goto L20;
        if (Intrinsics.areEqual(((paa.e) r4.next()).a, r6.a) == false) goto L16;
        boolean r5 = true;
    L21:
        if (r5 != true) goto L23;
        boolean r10 = true;
    L24:
        if (r10 == false) goto L52;
        if (r9 == false) goto L52;
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r7.iterator();
    L29:
        if (r12.hasNext() == false) goto L33;
        Object r13 = r12.next();
        if (Intrinsics.areEqual((String) r13, r6.a) == false) goto L29;
        r11.add(r13);
        goto L29
    L33:
        n(r11, r8);
        paa.c r14 = this.c;
        if (r14 == null) goto L64;
        List<paa.e> r15 = r14.Nh();
        if (r15 == null) goto L65;
        List<paa.e> r16 = r15;
        if ((r16 instanceof Collection) == true) goto L40;
    L42:
        Iterator<T> r17 = r16.iterator();
    L44:
        if (r17.hasNext() == false) goto L48;
        if (Intrinsics.areEqual(((paa.e) r17.next()).a, r6.a) == false) goto L44;
        boolean r18 = true;
    L49:
        if (r18 != true) goto L66;
        return true;
    L66:
        return false;
    L48:
        r18 = false;
        goto L49
    L40:
        if (r16.isEmpty() == false) goto L42;
    L65:
        return false;
    L64:
        return false;
    L52:
        return r10;
    L20:
        r5 = false;
        goto L21
    L12:
        if (r3.isEmpty() == false) goto L14;
    L23:
        r10 = false;
        goto L24
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.obric.assistant.chat.component.bottom.core.mention.f] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.obric.assistant.chat.component.bottom.core.mention.g] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.obric.assistant.chat.component.bottom.core.mention.h] */
    public ObricMentionInputController(Context r2, EditText r3, paa.c r4, p1 r5, com.larus.bmhome.instruction.g r6, ICoreInputAbility r7, k r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "inputText");
        Intrinsics.checkNotNullParameter(r8, "chatArgumentDataProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.l = new f(this);
        this.m = new g(this);
        this.n = new h(this);
    }
}
