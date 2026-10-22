package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.chat.base.view.vo.message.StickerContentVO;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.dto.group.GroupRecallEntity;
import com.ss.android.lark.widget.photopicker.animation.activitytransition.ActivityTransitionLauncher;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.richtext.Image;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class o implements com.ss.android.lark.chat.chatwindow.chat.menu.handler.b, b3b.f {
    public o() {
    }

    @Override // b3b.o
    public final void A(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
    }

    @Override // com.ss.android.lark.chat.utils.SystemContentUtil.a
    public final void B(String r1, List<GroupRecallEntity> r2) {
    }

    @Override // b3b.p
    public final void C(String r2, StickerContentVO r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "stickerContentVO");
    }

    @Override // b3b.l
    public final void D(String r1, String r2, String r3, Integer r4, Boolean r5, Fragment r6) {
        Intrinsics.checkNotNullParameter(r1, "messageId");
        Intrinsics.checkNotNullParameter(r2, "threadId");
    }

    @Override // b3b.t
    public void E(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.menu.handler.l
    public final void I(String r1, int r2, PartialReplyInfo r3) {
        Intrinsics.checkNotNullParameter(r1, "messageId");
    }

    @Override // b3b.d
    public final void K6(y6b.a<? extends v5b.a<?>> r1) {
    }

    @Override // b3b.n
    public final void P3(String r1, String r2, RichText r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "messageId");
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "content");
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.menu.handler.j
    public void R(int r1) {
    }

    @Override // o4b.a
    public final void U(PhotoItem r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "selectPhotoItem");
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.menu.handler.i
    public final void X(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "messageId");
    }

    @Override // q5b.a
    public final void a(View r1, List<Image> r2, Image r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "msgId");
    }

    @Override // b3b.a, q5b.b
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
    }

    @Override // q5b.a
    public final /* synthetic */ boolean c(String r1) {
        return false;
    }

    @Override // b3b.r
    public final void d(View r2, y6b.a<v5b.a<?>> r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "messageVO");
    }

    @Override // q5b.a
    public final /* synthetic */ void e(int r1, boolean r2) {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.model.preload.a.InterfaceC0048a
    public final void f(y6b.a<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "messageVO");
    }

    @Override // b3b.m
    public final void g(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "threadId");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "autoTranslateLanguageByForward");
    }

    @Override // b3b.f, b3b.a, com.ss.android.lark.chat.chatwindow.chat.model.preload.a.InterfaceC0048a
    public Context getContext() {
        return null;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.menu.handler.n
    public final void h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
    }

    @Override // p4b.b
    public final void i(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
    }

    @Override // b3b.g
    public final boolean j(y6b.b r1) {
        return false;
    }

    @Override // b3b.c
    public final void k(String r1) {
    }

    @Override // q5b.a
    public final void l(String r1) {
    }

    @Override // q5b.a
    public final void m(v5b.c r1, AppCompatImageView r2, r5b.a r3) {
    }

    @Override // b3b.i
    public final void n(View r1, String r2, List<? extends Object> r3, int r4) {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.menu.handler.l
    public final void o(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "messageId");
    }

    @Override // b3b.s
    public final void p(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        Intrinsics.checkNotNullParameter(r3, "url");
    }

    @Override // b3b.h
    public final void q(String r1) {
    }

    @Override // b3b.j
    public final void r(String r1, String r2) {
    }

    @Override // b3b.i
    public final void s(View r1, ActivityTransitionLauncher.LocationInfo r2, PhotoItem r3, boolean r4, boolean r5, int r6, Message.SourceType r7) {
    }

    @Override // b3b.q
    public final void t(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "messageId");
    }

    @Override // p4b.a
    public final void u(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
    }

    @Override // b3b.i
    public final void v(View r1, PhotoItem r2, boolean r3) {
    }

    @Override // a3b.b
    public final void w(String r1, String r2, Long r3) {
    }

    @Override // b3b.a
    public final void x(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "messageId");
    }

    @Override // b3b.r
    public final void y(String r1) {
    }

    @Override // b3b.k
    public final void z(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        Intrinsics.checkNotNullParameter(r3, "fromSource");
    }

    @Override // b3b.b
    public final void z0(String r1, String r2) {
    }

    @Override // b3b.b
    public final List<String> y0(int r1) {
        return new ArrayList();
    }
}
