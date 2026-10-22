package com.larus.bmhome.chat.component.ext;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.larus.bmhome.chat.bean.ChatMsgDeleteScene;
import com.larus.bmhome.chat.list.cell.music.MusicCell;
import com.larus.bmhome.chat.list.cell.music.MusicCell$a;
import com.larus.bmhome.chat.model.a0;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.double_post.fragment.q;
import com.larus.bmhome.utils.v3;
import com.larus.common_ui.dialog.p0;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatFragmentDelegateDialogExtKt$showTurnOffRecommendVideoDialog$1 implements p0 {
    public final /* synthetic */ List<Message> a;
    public final /* synthetic */ Function0<Unit> b;
    public final /* synthetic */ CoroutineScope c;
    public final /* synthetic */ String d;
    public final /* synthetic */ JSONObject e;
    public final /* synthetic */ ChatMsgDeleteScene f;

    public final void confirm() {
        Message r0 = (Message) CollectionsKt.lastOrNull(this.a);
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L13;
        Function0<Unit> r3 = this.b;
        if (r3 == null) goto L54;
        r3.invoke();
        return;
    L54:
        return;
    L13:
        JsonArray r4 = new JsonArray();
        List<Message> r5 = this.a;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r7 = r5.iterator();
    L15:
        if (r7.hasNext() == false) goto L17;
        r6.add(((Message) r7.next()).getMessageId());
        goto L15
    L17:
        Iterator r8 = r6.iterator();
    L19:
        if (r8.hasNext() == false) goto L21;
        r4.add((String) r8.next());
        goto L19
    L21:
        IFlowSdkDepend r9 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r9 == null) goto L26;
        FlowAppletServiceImpl r10 = r9.g0();
        if (r10 == null) goto L26;
        JsonObject r11 = new JsonObject();
        r11.add("messageList", r4);
        Unit r12 = Unit.INSTANCE;
        r10.a("flow.onMultipleMessageDeleted", r11);
    L26:
        BuildersKt.launch$default(this.c, Dispatchers.getIO(), null, new ChatFragmentDelegateDialogExtKt$showTurnOffRecommendVideoDialog$1$confirm$4(this.a, this.d, this.e, this.f, null), 2, null);
        int r13 = MusicCell.g;
        MusicCell$a.a();
        Iterator<T> r14 = this.a.iterator();
    L27:
        String r15 = null;
        if (r14.hasNext() == false) goto L32;
        Object r16 = r14.next();
        if (a0.b((Message) r16) == false) goto L27;
    L34:
        if (((Message) r16) == null) goto L36;
        RepoDispatcher.a.getClass();
        RepoDispatcher.d.d.d.i6("ChatFragment showDeleteMessagesDialog", true);
    L36:
        Message r17 = (Message) CollectionsKt.firstOrNull(this.a);
        if (r17 == null) goto L39;
        r15 = r17.getConversationId();
    L39:
        if (r15 != null) goto L41;
    L42:
        r1 = true;
    L43:
        if (r1 == true) goto L45;
        ConcurrentHashMap r18 = v3.a;
        v3.e(r15);
    L45:
        Function0<Unit> r19 = this.b;
        if (r19 == null) goto L55;
        r19.invoke();
        return;
    L55:
        return;
    L41:
        if (r15.length() != 0) goto L43;
    L32:
        r16 = null;
        goto L34
    L5:
        if (com.larus.bmhome.chat.bean.d.C0(r0) != true) goto L7;
        r2 = true;
        goto L8
    }

    public ChatFragmentDelegateDialogExtKt$showTurnOffRecommendVideoDialog$1(List r1, q r2, LifecycleCoroutineScope r3, String r4, JSONObject r5, ChatMsgDeleteScene r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
