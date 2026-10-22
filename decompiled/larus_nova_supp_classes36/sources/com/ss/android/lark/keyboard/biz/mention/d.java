package com.ss.android.lark.keyboard.biz.mention;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.dto.usergroup.UserGroupEntity;
import com.ss.android.lark.keyboard.editor.FlowChatKeyboardEditor;
import com.ss.android.lark.keyboard.event.HeightChange;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.impl.atselector.AtSelectActivity;
import com.ss.android.lark.mention.base.impl.atselector.bean.AtSelectInitData;
import com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionPanelView;
import com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import w4b.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements com.ss.android.lark.keyboard.plugin.tool.at.a {
    public final FragmentActivity a;
    public final String b;
    public final Fragment c;
    public final com.ss.android.lark.keyboard.b d;
    public final String e;
    public final LiveData<Chat> f;
    public final AtomicBoolean g;
    public final o h;
    public boolean i;
    public final Lazy<DoubaoMentionViewModel> j;
    public final e k;
    public final Function0<Boolean> l;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.at.a
    public final void b(EditText r2, com.ss.android.lark.keyboard.plugin.tool.at.a.b r3) {
        Intrinsics.checkNotNullParameter(r2, "editText");
        Intrinsics.checkNotNullParameter(r3, "chatterInfo");
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.at.a
    public final String c() {
        Chatter r0 = ((DoubaoMentionViewModel) this.j.getValue()).getDoubaoChatter();
        if (r0 == null) goto L6;
        String r1 = r0.getId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.at.a
    public final AtomicBoolean f() {
        return this.g;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.at.a
    public final com.ss.android.lark.keyboard.plugin.tool.at.a.C0154a g(Intent r14) {
        if (r14 == null) goto L5;
        Object r0 = r14.getSerializableExtra("chatters_info");
        if (r0 == null) goto L5;
    L6:
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.collections.List<com.ss.android.lark.chat.entity.chatter.ChatChatter>");
        ChatterNameDisplayRule r1 = ChatterNameDisplayRule.ALIAS_NICKNAME_NAME;
        ArrayList r2 = new ArrayList();
        Iterator r3 = ((List) r0).iterator();
    L8:
        if (r3.hasNext() == false) goto L15;
        ChatChatter r4 = (ChatChatter) r3.next();
        String r9 = com.ss.android.lark.chat.utils.m.b(r4, r1, true);
        String r5 = r4.getLocalizedName();
        if (r5 != null) goto L12;
        String r10 = "";
    L13:
        String r7 = r4.getId();
        Chatter.ChatterType r8 = r4.getType();
        Intrinsics.checkNotNull(r9);
        r2.add(new com.ss.android.lark.keyboard.plugin.tool.at.a.b(r7, r8, r9, r10, r4.isOutChatUser(), r4.isAnonymous()));
        goto L8
    L12:
        r10 = r5;
        goto L13
    L15:
        if (r14 == null) goto L17;
        Serializable r15 = r14.getSerializableExtra("user_groups_info");
    L19:
        if ((r15 instanceof List) == false) goto L21;
        List r16 = (List) r15;
    L22:
        if (r16 != null) goto L24;
        r16 = CollectionsKt.emptyList();
    L24:
        ArrayList r6 = new ArrayList();
        Iterator r17 = r16.iterator();
    L26:
        if (r17.hasNext() == false) goto L34;
        UserGroupEntity r11 = (UserGroupEntity) r17.next();
        com.bytedance.lark.pb.im.v1.UserGroupEntity r12 = new com.bytedance.lark.pb.im.v1.UserGroupEntity.Builder().id(Long.valueOf(CastLongProtector.parseLong(r11.getGroupId()))).display_name(r11.getGroupName()).member_count(Integer.valueOf(CastIntegerProtector.parseInt(r11.getGroupMemberCount()))).status(1).cache_time(Long.valueOf(System.currentTimeMillis())).server_time(com.bytedance.lark.pb.im.v1.UserGroupEntity.DEFAULT_SERVER_TIME).description("").build();     // Catch: Exception -> L30
    L31:
        if (r12 == null) goto L26;
        r6.add(r12);
    L30:
        r12 = null;
        goto L31
    L34:
        return new com.ss.android.lark.keyboard.plugin.tool.at.a.C0154a(r2, r6, CollectionsKt.emptyList());
    L21:
        r16 = null;
        goto L22
    L17:
        r15 = null;
    L5:
        r0 = CollectionsKt.emptyList();
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.at.a
    public final void h(String r2) {
        if (r2 == null) goto L5;
        ((DoubaoMentionViewModel) this.j.getValue()).search(r2);
        return;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.at.a
    public final int a(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "chatId");
        return this.h.a();
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.at.a
    public final boolean d(boolean r6, boolean r7) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L39
        cya.h r2 = null;
        if (r7 == true) goto L6;
        if (r6 == false) goto L6;
    L16:
        Fragment r3 = this.c;     // Catch: Throwable -> L39
        if (r3 == null) goto L21;
        View r4 = r3.getView();     // Catch: Throwable -> L39
        if (r4 == null) goto L21;
        DoubaoMentionPanelView r5 = (DoubaoMentionPanelView) r4.findViewById(2131392525);     // Catch: Throwable -> L39
    L22:
        if (r6 == false) goto L33;
        com.ss.android.lark.keyboard.b r8 = this.d;     // Catch: Throwable -> L39
        if (r8 == null) goto L28;
        cya.d r9 = com.ss.android.lark.keyboard.a.a(r8);     // Catch: Throwable -> L39
        if (r9 == null) goto L28;
        r2 = r9.d();     // Catch: Throwable -> L39
    L28:
        boolean r10 = !(r2 instanceof com.ss.android.lark.keyboard.inputstate.b);     // Catch: Throwable -> L39
        if (r5 == null) goto L31;
        r5.a((DoubaoMentionViewModel) this.j.getValue(), this.k, r7, r10);     // Catch: Throwable -> L39
    L31:
        this.g.getAndSet(true);     // Catch: Throwable -> L39
        return true;
    L33:
        if (r5 == null) goto L35;
        r5.b();     // Catch: Throwable -> L39
    L35:
        if (r5 == null) goto L37;
        r5.c();     // Catch: Throwable -> L39
    L37:
        Object r11 = Result.constructor-impl(Boolean.valueOf(this.g.getAndSet(false)));     // Catch: Throwable -> L39
    L41:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L44;
        Log.e("AtKBPlugin", "showMentionView failed", r12);
    L44:
        return false;
    L21:
        r5 = null;
    L6:
        com.ss.android.lark.keyboard.b r13 = this.d;     // Catch: Throwable -> L39
        if (r13 == null) goto L9;
        com.ss.android.lark.keyboard.keyboard2.b r14 = r13.L();     // Catch: Throwable -> L39
    L11:
        if ((r14 instanceof FlowChatKeyboardEditor) == false) goto L13;
        FlowChatKeyboardEditor r15 = (FlowChatKeyboardEditor) r14;     // Catch: Throwable -> L39
    L14:
        if (r15 == null) goto L16;
        com.ss.android.lark.keyboard.biz.mention.inject.h.a r16 = com.ss.android.lark.keyboard.biz.mention.inject.h.d;     // Catch: Throwable -> L39
        r15.P(r6);     // Catch: Throwable -> L39
        goto L16
    L13:
        r15 = null;
        goto L14
    L9:
        r14 = null;
    L39:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.at.a
    public final void e(boolean r6, com.ss.android.lark.keyboard.b r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "keyboard");
        cya.h r2 = null;
        if (((Boolean) this.l.invoke()).booleanValue() == false) goto L17;
        cya.d r0 = com.ss.android.lark.keyboard.a.a(r7);
        if (r0 == null) goto L8;
        cya.h r1 = r0.d();
    L9:
        boolean r4 = true;
        if ((r1 instanceof com.ss.android.lark.keyboard.inputstate.b) == false) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == true) goto L17;
    L18:
        cya.d r9 = com.ss.android.lark.keyboard.a.a(r7);
        if (r9 == null) goto L21;
        r2 = r9.d();
    L21:
        boolean r10 = r2 instanceof com.ss.android.lark.keyboard.inputstate.c;
        String r11 = r8.getString("chat_type");
        JSONObject r5 = new JSONObject();
        if (r11 != null) goto L24;
        r11 = "";
    L24:
        r5.put("chat_type", r11);
        r5.put("is_reply", r10);
        String r12 = r5.toString();
        AtSelectInitData r13 = new AtSelectInitData(this.b);
        r13.setIsInterruptAtAll(false);
        r13.setEnableMyAI(false);
        r13.setUserCountVisible(r6);
        r13.setEnableAIKnowledge(r4);
        r13.setConfigJson(r12);
        Intent r14 = new Intent(this.a, AtSelectActivity.class);
        r14.putExtra("extra.init.data", r13);
        this.a.startActivityForResult(r14, 1638);
        return;
    L12:
        if ((r1 instanceof com.ss.android.lark.keyboard.inputstate.d) == true) goto L15;
        r3 = false;
        goto L16
    L8:
        r1 = null;
    L17:
        r4 = false;
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [androidx.lifecycle.LifecycleOwner] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public d(FragmentActivity r2, String r3, Fragment r4, final com.ss.android.lark.keyboard.b r5, String r6, Chat r7, MutableLiveData r8) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Intrinsics.checkNotNullParameter(r7, "initialChat");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = new AtomicBoolean(false);
        this.h = ChatCoreModule.a().getGroupMemberManageDependency();
        this.i = com.ss.android.lark.keyboard.utils.b.a(r7);
        this.j = LazyKt.lazy(new AtKBPluginDependency$mentionPanelViewModelDelegate$1(this));
        Log.i("AtKBPlugin", "init Doubao mention availability, group=" + r7.isGroup() + ", enabled=" + this.i);
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L18
        if ((!com.ss.android.lark.keyboard.edittext2.utils.d.a("messenger.im.disable_doubao_mention_kb_height_opt")) == false) goto L16;
        if (r5 == null) goto L12;
        com.ss.android.lark.keyboard.event.k r10 = r5.e();     // Catch: Throwable -> L18
        if (r10 == null) goto L12;
        com.ss.android.lark.keyboard.event.l r11 = r10.of(this);     // Catch: Throwable -> L18
        if (r11 == null) goto L12;
        r11.c(HeightChange.class, new AtKBPluginDependency$1$1(r5, this));     // Catch: Throwable -> L18
    L12:
        if (r4 != null) goto L14;
        ?? r12 = r2;
    L15:
        r12.getLifecycle().addObserver(new AtKBPluginDependency$1$2(r5, this));     // Catch: Throwable -> L18
        goto L16
    L14:
        r12 = r4;
    L16:
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L23;
        Log.e("AtKBPlugin", "init mention kb height opt failed", r14);
    L23:
        LiveData<Chat> r15 = this.f;
        if (r15 == null) goto L29;
        FragmentActivity r16 = this.c;
        if (r16 != null) goto L28;
        r16 = this.a;
    L28:
        r15.observe(r16, new c(this));
    L29:
        this.k = new e(this);
        this.l = AtKBPluginDependency$enableAtKnowledgeAiScene$1.INSTANCE;
        return;
    L18:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }
}
