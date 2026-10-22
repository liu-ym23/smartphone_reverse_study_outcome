package com.larus.bmhome.chat.component.ext;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.bytedance.keva.Keva;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.larus.bmhome.chat.bean.ChatMsgDeleteScene;
import com.larus.bmhome.chat.component.list.r0;
import com.larus.bmhome.chat.list.cell.music.MusicCell;
import com.larus.bmhome.chat.list.cell.music.MusicCell$a;
import com.larus.bmhome.chat.model.a0;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.utils.v3;
import com.larus.common_ui.dialog.p0;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import vd8.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatFragmentDelegateDialogExtKt$showDeleteMessagesDialog$1 implements p0 {
    public final /* synthetic */ List<Message> a;
    public final /* synthetic */ CoroutineScope b;
    public final /* synthetic */ Function1<Boolean, Unit> c;
    public final /* synthetic */ String d;
    public final /* synthetic */ JSONObject e;
    public final /* synthetic */ ChatMsgDeleteScene f;
    public final /* synthetic */ Integer g;

    public final void confirm() {
        JsonArray r0 = new JsonArray();
        List<Message> r1 = this.a;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.add(((Message) r3.next()).getMessageId());
        goto L4
    L6:
        Iterator r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r0.add((String) r4.next());
        goto L8
    L10:
        IFlowSdkDepend r5 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r5 == null) goto L15;
        FlowAppletServiceImpl r6 = r5.g0();
        if (r6 == null) goto L15;
        JsonObject r7 = new JsonObject();
        r7.add("messageList", r0);
        Unit r8 = Unit.INSTANCE;
        r6.a("flow.onMultipleMessageDeleted", r7);
    L15:
        BuildersKt.launch$default(this.b, Dispatchers.getIO(), null, new ChatFragmentDelegateDialogExtKt$showDeleteMessagesDialog$1$confirm$4(this.a, this.d, this.e, this.f, this.g, null), 2, null);
        int r9 = MusicCell.g;
        MusicCell$a.a();
        Iterator<T> r10 = this.a.iterator();
    L16:
        Boolean r11 = null;
        if (r10.hasNext() == false) goto L21;
        Object r12 = r10.next();
        if (a0.b((Message) r12) == false) goto L16;
    L22:
        boolean r13 = true;
        if (((Message) r12) == null) goto L25;
        RepoDispatcher.a.getClass();
        RepoDispatcher.d.d.d.i6("ChatFragment showDeleteMessagesDialog", true);
    L25:
        Message r14 = (Message) CollectionsKt.firstOrNull(this.a);
        if (r14 == null) goto L28;
        String r15 = r14.getConversationId();
    L30:
        if (r15 != null) goto L32;
    L35:
        boolean r16 = true;
    L36:
        if (r16 == true) goto L38;
        ConcurrentHashMap r17 = v3.a;
        v3.e(r15);
    L38:
        List<Message> r18 = this.a;
        if ((r18 instanceof Collection) == true) goto L41;
    L43:
        Iterator<T> r19 = r18.iterator();
    L45:
        if (r19.hasNext() == false) goto L49;
        if (com.larus.bmhome.chat.bean.d.v0((Message) r19.next()) == false) goto L45;
        boolean r20 = true;
    L50:
        Boolean r21 = Boolean.valueOf(r20);
        if (r21.booleanValue() == false) goto L53;
        r11 = r21;
    L53:
        if (r11 == null) goto L55;
        r11.booleanValue();
        Lazy<Keva> r22 = g.b;
        FLogger.a.d("Pipeline_List_BigAvatarTask", "mark user delete onboarding text");
        ((Keva) g.b.getValue()).storeBoolean("user_delete_mock_onboarding_text", true);
    L56:
        Function1<Boolean, Unit> r23 = this.c;
        if (r23 == null) goto L68;
        r23.invoke(Boolean.valueOf(r13));
        return;
    L68:
        return;
    L55:
        r13 = false;
    L49:
        r20 = false;
        goto L50
    L41:
        if (r18.isEmpty() == false) goto L43;
    L32:
        if (r15.length() == 0) goto L35;
        r16 = false;
        goto L36
    L28:
        r15 = null;
        goto L30
    L21:
        r12 = null;
        goto L22
    }

    public ChatFragmentDelegateDialogExtKt$showDeleteMessagesDialog$1(List r1, LifecycleCoroutineScope r2, r0 r3, String r4, JSONObject r5, ChatMsgDeleteScene r6, Integer r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
