package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.entities.BlockByStrangerRelationLarkErrorExtra;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int d = 0;
    public final Context a;
    public final ChatService b;
    public final Fragment c;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.a$a, reason: collision with other inner class name */
    public static final class C0034a {
    }

    static {
    }

    public final Context getContext() {
        return this.a;
    }

    public final boolean a(ErrorResult r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "err");
        if (r13.getErrorCode() == 7006) goto L5;
        return false;
    L5:
        if (r14 == false) goto L7;
        return false;
    L7:
        FragmentActivity r3 = this.a;
        FragmentActivity r4 = this.c;
        Intrinsics.checkNotNullParameter(r13, "<this>");
        byte[] r0 = r13.getExtraRaw();
        FragmentActivity r1 = null;
        if (r0 == null) goto L10;
        String r2 = ((BlockByStrangerRelationLarkErrorExtra) BlockByStrangerRelationLarkErrorExtra.ADAPTER.decode(r0)).mstranger_user_id.toString();
    L11:
        if (r2 != null) goto L13;
        Log.e("StrangerErrorProcess", "stranger chatter id is null, can't open p2p chat");
        return true;
    L13:
        if (r4 == null) goto L15;
        r1 = r4;
    L18:
        if (r1 == null) goto L25;
        LifecycleCoroutineScope r6 = LifecycleOwnerKt.getLifecycleScope(r1);
        if (r6 == null) goto L26;
        BuildersKt.launch$default(r6, Dispatchers.getIO(), null, new StrangerErrorProcess$openP2PChatForStranger$2$1(this, r2, r3, r4, null), 2, null);
        return true;
    L26:
        return true;
    L25:
        return true;
    L15:
        if ((r3 instanceof FragmentActivity) == false) goto L18;
        r1 = r3;
        goto L18
    L10:
        r2 = null;
        goto L11
    }

    public a(Context r2, ChatService r3, Fragment r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chatService");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
