package com.larus.doc.impl.chat.component;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.office.k;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import va8.c0;
import va8.l0;
import va8.n;
import va8.o;
import va8.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\u0006H\u0016J\b\u0010-\u001a\u00020\u0006H\u0016J\b\u0010.\u001a\u00020\u0006H\u0016J\b\u0010/\u001a\u00020\u0006H\u0016J\b\u00100\u001a\u00020\tH\u0016J\b\u00101\u001a\u00020\tH\u0016J\b\u00102\u001a\u00020'H\u0002J\u001c\u00103\u001a\u00020'2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\u00020 X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larus/doc/impl/chat/component/ActionBarSceneManagerComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/bmhome/ability/IChatSceneAbility;", "<init>", "()V", "currentScene", "", "sceneLoadMaps", "", "", "actionBarCoreAbility", "Lcom/larus/bmhome/ability/ICustomActionBarCoreAbility;", "getActionBarCoreAbility", "()Lcom/larus/bmhome/ability/ICustomActionBarCoreAbility;", "actionBarCoreAbility$delegate", "Lkotlin/Lazy;", "pageTaskInfoAbility", "Lcom/larus/bmhome/ability/IPageTaskInfoCoreAbility;", "getPageTaskInfoAbility", "()Lcom/larus/bmhome/ability/IPageTaskInfoCoreAbility;", "pageTaskInfoAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "chatInputCoreAbility", "Lcom/larus/bmhome/ability/IChatInputCoreAbility;", "getChatInputCoreAbility", "()Lcom/larus/bmhome/ability/IChatInputCoreAbility;", "chatInputCoreAbility$delegate", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "convId", "onCreate", "", "onViewCreated", "view", "Landroid/view/View;", "switchScene", "scene", "curScene", "curPage", "getSpeakInputHint", "isInDocCreateList", "isInAiEdit", "changeInputHint", "putMessageExt", "ext", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionBarSceneManagerComponent extends BaseContentWidget implements r {
    public static final /* synthetic */ int t = 0;
    public String m;
    public final Map<String, Boolean> n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public int s;

    public static final class a {
    }

    public static final class b implements Function0<l0> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(l0.class));
        }
    }

    public static final class c implements Function0<o> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(o.class));
        }
    }

    public static final class d implements Function0<n> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(n.class));
        }
    }

    static {
    }

    public final String J30() {
        if (Intrinsics.areEqual(this.m, "doc_create_list") == false) goto L6;
        return "ai_doc_list";
    L6:
        if (StringsKt.contains$default(this.m, "doc", false, 2, null) == false) goto L9;
        return "ai_doc_detail";
    L9:
        return this.m;
    }

    public final boolean Jg() {
        return Intrinsics.areEqual(this.m, "doc_ai_edit");
    }

    public final String U0() {
        if (Intrinsics.areEqual(this.m, "doc_create_empty") == false) goto L5;
    L8:
        String r0 = getContext().getString(2131899514);
        Intrinsics.checkNotNull(r0);
        return r0;
    L5:
        if (Intrinsics.areEqual(this.m, "doc_create_list") == true) goto L8;
        String r1 = getContext().getString(2131899516);
        Intrinsics.checkNotNull(r1);
        return r1;
    }

    public final o Y2() {
        return (o) this.q.getValue();
    }

    public ActionBarSceneManagerComponent() {
        this.m = "doc_exist_content";
        this.n = new LinkedHashMap();
        this.o = LazyKt.lazy(new com.larus.doc.impl.chat.component.a(this));
        this.p = LazyKt.lazy(new b(this));
        this.q = LazyKt.lazy(new c(this));
        this.r = LazyKt.lazy(new d(this));
        this.s = 2131365588;
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r1 == null) goto L6;
        String r2 = r1.getString("key_action_bar_scene", null);
        if (r2 == null) goto L6;
    L7:
        this.m = r2;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r0 == null) goto L11;
        r0.getString("argConversationId", "");
        return;
    L11:
        return;
    L6:
        r2 = "doc_exist_content";
        goto L7
    }

    public final int U2() {
        return this.s;
    }

    public final String WE() {
        return this.m;
    }

    public final void GS(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "ext");
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (Intrinsics.areEqual(com.larus.ui.arch.component.internal.attach.a.b(this, this).getTag(), "tag_doc_chat_fragment") == false) goto L5;
        String r5 = r4.put("doc_page_scene", "doc_create_list");
    L6:
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r6 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r6 == null) goto L10;
        r6.post(new com.larus.doc.impl.chat.component.b(this));
        return;
    L10:
        return;
    L5:
        String r7 = r4.put("doc_page_scene", this.m);
        goto L6
    }

    public final void JD(String r9) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        FLogger r0 = FLogger.a;
        r0.i("ActionBarSceneManagerComponent", "[switchScene] scene:".concat(r9));
        this.m = r9;
        Object r1 = ((LinkedHashMap) this.n).get(r9);
        Boolean r3 = Boolean.TRUE;
        boolean r2 = Intrinsics.areEqual(r1, r3);
        c0 r4 = (c0) this.o.getValue();
        if (r4 == null) goto L5;
        r4.gv(this.m, LifecycleOwnerKt.getLifecycleScope(this), !r2);
    L5:
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r5 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r5 == null) goto L8;
        r5.postDelayed(new com.larus.doc.impl.chat.component.c(this), 1000);
    L8:
        this.n.put(this.m, r3);
        r0.i("ActionBarSceneManagerComponent", "changeInputHint, currentScene = " + this.m);
        if (Intrinsics.areEqual(this.m, "doc_create_empty") == false) goto L17;
        o r6 = Y2();
        if (r6 == null) goto L13;
        r6.S6(getContext().getString(2131899615));
    L13:
        o r7 = Y2();
        if (r7 == null) goto L30;
        r7.HH(getContext().getString(2131899514));
    L30:
        if (Intrinsics.areEqual(r9, "doc_ai_edit") == false) goto L35;
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r10 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r10 == null) goto L36;
        r10.postDelayed(new com.larus.doc.impl.chat.component.d(this), 250);
        return;
    L36:
        return;
    L35:
        return;
    L17:
        if (Intrinsics.areEqual(this.m, "ai_space_detail") == false) goto L22;
        o r8 = Y2();
        if (r8 == null) goto L30;
        Context r11 = getContext();
        int r12 = k.a;
        r8.S6(r11.getString(2131897580));
        goto L30
    L22:
        if (Intrinsics.areEqual(this.m, "doc_exist_content") == false) goto L30;
        o r13 = Y2();
        if (r13 == null) goto L26;
        Context r14 = getContext();
        int r15 = k.a;
        r13.S6(r14.getString(2131897592));
    L26:
        o r16 = Y2();
        if (r16 == null) goto L30;
        Context r17 = getContext();
        int r18 = k.a;
        r16.HH(r17.getString(2131897592));
        goto L30
    }

    public final void X2(int r1) {
        this.s = r1;
    }

    public final void onViewCreated(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        FLogger.a.i("ActionBarSceneManagerComponent", "onViewCreated, currentScene = " + this.m);
    }
}
