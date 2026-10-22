package com.ss.android.lark.filedetail.impl.detail.menu;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.filedetail.impl.open.OpenFileInfo;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements d {
    public final /* synthetic */ OpenFileInfo a;
    public final /* synthetic */ Context b;

    @Override // com.ss.android.lark.filedetail.impl.detail.menu.d
    public final void v() {
        OpenFileInfo r0 = this.a;
        if (r0.forwardAsFile == false) goto L5;
        hfb.b.d r1 = a.a;
        a.a(this.b, r0);
        return;
    L5:
        final a.C0206a r2 = new a.C0206a(this.b, r0);
        if (TextUtils.isEmpty(r2.b.mMessageId) == true) goto L34;
        OpenFileInfo r3 = r2.b;
        if (r3.mFavoriteMessage == null) goto L13;
        hfb.b.d r4 = a.a;
        if (r4 == null) goto L29;
        r4.e();
        return;
    L29:
        return;
    L13:
        Message r5 = r3.mMessage;
        if (r5 != null) goto L20;
        hfb.b.d r6 = a.a;
        if (r6 == null) goto L19;
        r6.d();
    L19:
        r5 = null;
    L20:
        if (r5 == null) goto L24;
        hfb.b.d r7 = a.a;
        if (r7 == null) goto L31;
        String r8 = r2.b.originMergeForwardId;
        r7.i();
        return;
    L31:
        return;
    L24:
        hfb.b.d r9 = a.a;
        if (r9 == null) goto L33;
        CollectionsKt.listOf(r2.b.mMessageId);
        new UIGetDataCallback(new FileMenuActionFactory$FileForward$onGetRemoteMessage$1(r2));
        r9.a();
        return;
    L33:
        return;
    }

    @Override // com.ss.android.lark.filedetail.impl.detail.menu.d
    public final boolean w() {
        if (TextUtils.isEmpty(this.a.threadId) == true) goto L5;
        hfb.b.d r0 = a.a;
        if (r0 == null) goto L18;
        String r1 = this.a.threadId;
        r0.h();
        return true;
    L18:
        return true;
    L5:
        if (this.a.mJumpPosition != (-1)) goto L8;
        return false;
    L8:
        hfb.b.d r2 = a.a;
        if (r2 == null) goto L16;
        r2.f();
        return true;
    L16:
        return true;
    }

    public c(OpenFileInfo r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }
}
