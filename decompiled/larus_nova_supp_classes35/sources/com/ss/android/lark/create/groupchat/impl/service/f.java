package com.ss.android.lark.create.groupchat.impl.service;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import com.ss.android.lark.create.groupchat.dto.GroupCreateInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import e0c.k;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f extends c0c.b implements h {
    public final /* synthetic */ h b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<h> d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.create.groupchat.impl.service.h
    public final void Da(Context r11, GroupCreateInfo r12, List<? extends SearchBaseInfo> r13, IGetDataCallback<Chat> r14, CreateGroupScene r15, IGetDataCallback<w5b.a> r16, Fragment r17, hab.b r18) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "groupCreateInfo");
        Intrinsics.checkNotNullParameter(r13, "searchInfos");
        Intrinsics.checkNotNullParameter(r15, "source");
        Intrinsics.checkNotNullParameter(r18, "chatDependency");
        this.b.Da(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public f(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<h> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), h.class), h.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (h) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r2, f0c.g r3) {
        Log.i("CreateChatGroupServiceProxy", "preparing ICreateGroupServiceApi");
        v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        h r6 = (h) k.b(r4.c(r5), h.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
