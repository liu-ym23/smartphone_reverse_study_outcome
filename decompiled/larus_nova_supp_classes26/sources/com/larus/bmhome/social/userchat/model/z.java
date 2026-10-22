package com.larus.bmhome.social.userchat.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.component.list.ChatListComponentViewModel;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.CollectionDetail;
import com.larus.platform.model.MessageCollection;
import com.larus.platform.service.g0;
import hq9.k0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class z implements c0 {
    public final MessageCollection a;
    public ArrayList<Message> b;
    public ChatMessageReceiverModel.c c;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(y r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final void E4(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final boolean a() {
        return false;
    }

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final void b(vr8.b r1, Integer r2) {
        Intrinsics.checkNotNullParameter(r1, "callback");
    }

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final void c() {
    }

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final void clear() {
    }

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final void d(vr8.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }

    public z(MessageCollection r2) {
        Intrinsics.checkNotNullParameter(r2, "collection");
        this.a = r2;
    }

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final boolean O7(String r5) {
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return false;
    L11:
        ArrayList<Message> r3 = this.b;
        if (r3 != null) goto L14;
    L24:
        return false;
    L14:
        if (r3.isEmpty() == false) goto L16;
    L15:
        boolean r6 = false;
    L22:
        if (r6 != true) goto L24;
        return true;
    L16:
        Iterator<T> r4 = r3.iterator();
    L18:
        if (r4.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(((Message) r4.next()).getMessageId(), r5) == false) goto L18;
        r6 = true;
        goto L22
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.larus.bmhome.social.userchat.model.y] */
    @Override // com.larus.bmhome.social.userchat.model.c0
    public final void e(ChatListComponentViewModel.ChatListMessageChangeListener r51, ChatMessageReceiverModel.d r52, long r53, CoroutineScope r55) {
        Intrinsics.checkNotNullParameter(r51, "listener");
        this.c = r51;
        this.b = new ArrayList();
        AppHost.Companion r1 = AppHost.a;
        if (r1.isTestChannel() == true) goto L5;
    L12:
        List r2 = this.a.getCollectionDetails();
        if (r2 == null) goto L30;
        int r3 = r2.size() - 1;
    L16:
        if ((-1) >= r3) goto L30;
        Message r5 = k0.a((CollectionDetail) ListProtector.get(r2, r3));
        if (r5 == null) goto L29;
        ArrayList<Message> r4 = this.b;
        if (r4 == null) goto L29;
        if (com.larus.bmhome.chat.bean.d.G0(r5) == false) goto L24;
        int r10 = 11;
    L25:
        Map r14 = r5.getBusinessExt();
        if (r14 != null) goto L28;
        r14 = new LinkedHashMap();
    L28:
        Map r15 = r14;
        r15.put("message_collect_mode", "1");
        r15.put("common_button_v2_hidden", "true");
        Unit r6 = Unit.INSTANCE;
        r4.add(Message.copy$default(r5, null, null, null, 0, r10, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, r15, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -4194321, 31, null));
        goto L29
    L24:
        r10 = 21;
    L29:
        r3 = r3 - 1;
    L30:
        ArrayList<Message> r7 = this.b;
        if (r7 == null) goto L42;
        ChatMessageReceiverModel.c r8 = this.c;
        if (r8 == null) goto L43;
        ChatMessageReceiverModel.c.a.a(r8, new com.larus.bmhome.social.page.datasource.event.c(r7, 0, CollectionsKt.listOf(new com.larus.bmhome.social.page.datasource.event.b.d(true))));
        return;
    L43:
        return;
    L42:
        return;
    L5:
        if (Intrinsics.areEqual(this.a.getCollectionId(), "collection_id_debug_markdown_render") == false) goto L12;
        LifecycleOwner r9 = r1.a().getCurrentActivity();
        if ((r9 instanceof AppCompatActivity) == false) goto L40;
        LiveData r11 = g0.a.g();
        if (r11 == null) goto L41;
        r11.observe(r9, new b(new y(this)));
        return;
    L41:
        return;
    }
}
