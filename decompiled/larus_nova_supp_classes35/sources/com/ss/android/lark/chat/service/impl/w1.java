package com.ss.android.lark.chat.service.impl;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.keyboard.dtocompat.FrameInfo;
import com.ss.android.lark.keyboard.dtocompat.VideoInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.todo.impl.features.detail.comment.CommentKeyboardSection;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class w1 extends c0c.b implements m6b.m {
    public final /* synthetic */ m6b.m b;
    public final com.ss.android.lark.passportc.internal.v c;
    public final com.ss.android.lark.passportc.convention.b<m6b.m> d;

    public static final class a {
    }

    static {
    }

    @Override // m6b.m
    public final Observable<Map<String, FrameInfo>> Db(List<VideoInfo> r2) {
        return this.b.Db(r2);
    }

    @Override // m6b.m
    public final Observable M4(List r7, boolean r8, CommentKeyboardSection.handleActivityResult.1 r9, Biz r10, Scene r11) {
        return this.b.M4(r7, r8, r9, r10, r11);
    }

    @Override // m6b.m
    public final void d2(String r2, boolean r3, IGetDataCallback<List<MessageInfo>> r4) {
        this.b.d2(r2, r3, r4);
    }

    public w1(com.ss.android.lark.passportc.api.j r4, com.ss.android.lark.passportc.internal.v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<m6b.m> r0 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r5.c(r1), m6b.m.class), m6b.m.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (m6b.m) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r2, f0c.g r3) {
        Log.i("PostServiceProxy", "preparing IPostService");
        com.ss.android.lark.passportc.internal.v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        m6b.m r6 = (m6b.m) e0c.k.b(r4.c(r5), m6b.m.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
