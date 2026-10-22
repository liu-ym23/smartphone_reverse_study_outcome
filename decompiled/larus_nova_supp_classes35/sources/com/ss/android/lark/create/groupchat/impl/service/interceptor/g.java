package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import com.ss.android.lark.create.groupchat.impl.service.CreateGroupService;
import com.ss.android.lark.create.groupchat.impl.service.InterceptorKey;
import com.ss.android.lark.create.groupchat.impl.service.InterceptorType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.entities.BlockByStrangerRelationLarkErrorExtra;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@InterceptorKey(InterceptorType.STRANGER)
public final class g implements com.ss.android.lark.create.groupchat.impl.service.c {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    @Inject
    public g() {
    }

    @Override // com.ss.android.lark.create.groupchat.impl.service.c
    public final boolean a(Context r13, CreateGroupScene r14, ErrorResult r15, Function1<? super Boolean, Unit> r16, Fragment r17, CreateGroupService.c r18) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "scene");
        Intrinsics.checkNotNullParameter(r15, "err");
        if (r15.getErrorCode() == 7006) goto L6;
        return false;
    L6:
        if (r14 != CreateGroupScene.CREATE_SECRET_CHAT) goto L9;
        return false;
    L9:
        if (r14 != CreateGroupScene.P2P) goto L19;
        if (r18 != null) goto L12;
    L14:
        boolean r0 = false;
    L15:
        if (r0 == false) goto L19;
        if (idb.f.a().isCurrentEnable("im.chat.picker_support_add_bot") == false) goto L19;
        boolean r5 = true;
    L20:
        Intrinsics.checkNotNullParameter(r15, "<this>");
        byte[] r1 = r15.getExtraRaw();
        Fragment r2 = null;
        if (r1 == null) goto L23;
        String r3 = ((BlockByStrangerRelationLarkErrorExtra) BlockByStrangerRelationLarkErrorExtra.ADAPTER.decode(r1)).mstranger_user_id.toString();
    L24:
        if (r3 != null) goto L26;
        Log.e("StrangerInterceptor", "stranger chatter id is null, can't open p2p chat");
    L35:
        return true;
    L26:
        if (r17 == null) goto L28;
        r2 = r17;
    L31:
        if (r2 == null) goto L35;
        LifecycleCoroutineScope r8 = LifecycleOwnerKt.getLifecycleScope(r2);
        if (r8 == null) goto L35;
        BuildersKt.launch$default(r8, Dispatchers.getIO(), null, new StrangerInterceptor$openP2PChatForStranger$2$1(this, r3, r17, r13, r5, null), 2, null);
        goto L35
    L28:
        if ((r13 instanceof FragmentActivity) == false) goto L31;
        r2 = (FragmentActivity) r13;
        goto L31
    L23:
        r3 = null;
        goto L24
    L12:
        if (r18.f != true) goto L14;
        r0 = true;
    L19:
        r5 = false;
        goto L20
    }
}
