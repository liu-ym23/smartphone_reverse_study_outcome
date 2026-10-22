package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.SecretChatApi;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.HistorySecretChatListAdapter;
import com.bytedance.android.livesdk.interactivity.model.INPUT_PARAM_KEY;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k1 implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<a, Object> {
    public final InputSectionType a;
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g b;
    public a c;

    public final class a extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j {
        public HSImageView c;
        public TextView d;
        public RecyclerView e;
        public final IBaseUser f;
        public Disposable g;
        public final HistorySecretChatListAdapter h;
        public final Boolean i;
        public final /* synthetic */ k1 j;

        public a(k1 r2, View r3, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "panelBridges");
            this.j = r2;
            super(r3, r4);
            CommentFlowContext r5 = r4.S();
            Object r6 = null;
            if (r5 == null) goto L7;
            Map<Object, Object> r7 = r5.m;
            if (r7 == null) goto L7;
            Object r8 = r7.get(INPUT_PARAM_KEY.TargetUser);
        L9:
            if ((r8 instanceof IBaseUser) == false) goto L12;
            r6 = r8;
        L12:
            this.f = (IBaseUser) r6;
            this.h = new HistorySecretChatListAdapter();
            this.i = (Boolean) ec2.e1.a.getValue();
            return;
        L7:
            r8 = null;
            goto L9
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
        a r0 = this.c;
        if (r0 == null) goto L8;
        Disposable r1 = r0.g;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    L9:
        return;
    }

    public k1() {
        this.a = InputSectionType.SECRET_CHAT;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r8) {
        Intrinsics.checkNotNullParameter(r8, "panelBridge");
        Activity r0 = r8.getActivity();
        Disposable r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        this.b = r8;
        View r2 = LayoutInflater.from(r0).inflate(2131567835, null);
        a r3 = new a(this, r2, r8);
        r3.c = r3.a.findViewById(2131391990);
        r3.d = (TextView) r3.a.findViewById(2131392049);
        IBaseUser r9 = r3.f;
        if (r9 == null) goto L10;
        py.k r10 = r9.getAvatarThumbKt();
        if (r10 == null) goto L10;
        ImageUtil.loadImage(r3.c, r10, 0);
    L10:
        IBaseUser r11 = r3.f;
        if (r11 == null) goto L17;
        String r13 = r11.getNickName();
        if (r13 == null) goto L17;
        TextView r4 = r3.d;
        if (r4 == null) goto L17;
        r4.setText(r13);
    L17:
        RecyclerView r14 = r3.a.findViewById(2131374420);
        r3.e = r14;
        if (r14 == null) goto L20;
        r14.setAdapter(r3.h);
    L20:
        RecyclerView r15 = r3.e;
        if (r15 == null) goto L28;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r6 = r3.j.b;
        if (r6 == null) goto L25;
        Context r7 = r6.getContext();
    L26:
        LinearLayoutManager r5 = new LinearLayoutManager(r7, 1, false);
        r5.setStackFromEnd(true);
        Unit r16 = Unit.INSTANCE;
        r15.setLayoutManager(r5);
        goto L28
    L25:
        r7 = null;
    L28:
        if (r3.i.booleanValue() == true) goto L35;
        RecyclerView r17 = r3.e;
        if (r17 == null) goto L32;
        r17.setVerticalFadingEdgeEnabled(false);
    L32:
        RecyclerView r18 = r3.e;
        if (r18 == null) goto L35;
        r18.setHorizontalFadingEdgeEnabled(false);
    L35:
        RecyclerView r19 = r3.e;
        if (r19 == null) goto L38;
        r19.addItemDecoration(new SpaceItemDecoration(1, com.bytedance.android.live.core.utils.s1.f(6.0f), true));
    L38:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r20 = r3.j.b;
        if (r20 == null) goto L41;
        Long r21 = Long.valueOf(r20.Z());
    L42:
        IBaseUser r23 = r3.f;
        if (r23 == null) goto L47;
        String r24 = r23.getIdString();
        if (r24 == null) goto L47;
        Long r25 = Long.valueOf(CastLongProtector.parseLong(r24));
    L48:
        SecretChatApi.a.getClass();
        SecretChatApi r26 = (SecretChatApi) com.bytedance.android.live.network.c.b().e(SecretChatApi.class);
        if (r26 == null) goto L57;
        Observable<Response<com.bytedance.android.livesdk.interactivity.api.chatchannel.model.i>> r27 = r26.getHistorySecretChat(r21, r25);
        if (r27 == null) goto L57;
        Observable r28 = r27.subscribeOn(Schedulers.io());
        if (r28 == null) goto L57;
        Observable r29 = r28.observeOn(AndroidSchedulers.mainThread());
        if (r29 == null) goto L57;
        r1 = r29.subscribe(new i1(r3), j1.a);
    L57:
        r3.g = r1;
        Unit r30 = Unit.INSTANCE;
        this.c = r3;
        return r2;
    L47:
        r25 = null;
        goto L48
    L41:
        r21 = null;
        goto L42
    }
}
