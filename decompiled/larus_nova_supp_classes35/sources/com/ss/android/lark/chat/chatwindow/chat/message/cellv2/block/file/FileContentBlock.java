package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b3b.h;
import com.larksuite.component.ui.toast.LKUIToast;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.base.view.vo.message.FileContentVO;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.suite.lark.platform.component.widget_biz_fileview.FileView;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FileContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<FileContentVO>, Object> {
    public final IMMessageKeys$Blocks g;

    public static final class a {
    }

    public static final class b implements k<View>, g {
        public final View a;
        public final FileView b;

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void b() {
            this.b.l.setVisibility(8);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void c() {
            this.b.getFileIconView().setCornerRadiusDP(0.0f);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public Context getContext() {
            return this.a.getContext();
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void i() {
            FileView r0 = this.b;
            r0.o.getLayoutParams().guideBegin = 0;
            r0.a.getLayoutParams().guideBegin = 0;
            r0.b.getLayoutParams().guideEnd = 0;
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void k() {
            this.b.R5();
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final ViewGroup o() {
            return this.b.l;
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void showLoading() {
            LKUIToast.showLoading(this.a.getContext(), 2131891535);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void f() {
            this.b.setBackgroundResource(2131235383);
        }

        public final View getView() {
            return this.a;
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void l() {
            LKUIToast.cancelLoading();
        }

        public b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
            FileView r3 = r2.findViewById(2131365529);
            this.b = r3;
            r3.S5();
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void a(int r2) {
            this.b.setTopBorderColor(r2);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void d(ViewGroup.LayoutParams r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            this.b.l.setLayoutParams(r2);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void e(Object r2) {
            this.b.setTag(r2);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void g(boolean r2) {
            this.b.setFileSizeVisibility(r2);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void h(boolean r2) {
            this.b.setBottomMargin(r2);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void j(boolean r2) {
            this.b.setTopBorderVisibility(r2);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void m(com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.a.c r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.b.setOnLongClickListener(r2);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void showToast(String r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            LKUIToast.show(this.a.getContext(), r2);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g
        public final void n(FileView.b r2, com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.a.b r3) {
            Intrinsics.checkNotNullParameter(r2, "fileInfo");
            Intrinsics.checkNotNullParameter(r3, "callback");
            FileView r0 = this.b;
            r0.setCallback(r3);
            r0.setInfo(r2);
        }
    }

    static {
    }

    public final j getKey() {
        return this.g;
    }

    public FileContentBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.FILE_CONTENT;
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(m<y6b.a<FileContentVO>> r8, q<y6b.a<FileContentVO>> r9, y6b.a<FileContentVO> r10) {
        Intrinsics.checkNotNullParameter(r8, "cell");
        Intrinsics.checkNotNullParameter(r9, "layout");
        Intrinsics.checkNotNullParameter(r10, Keys.API_RETURN_KEY_DATA);
        b r1 = (b) r9.c(this.g, IMMessageKeys$Slots.CONTENT, FileContentBlock$update$blockView$1.INSTANCE);
        com.ss.android.lark.blueprint.g r11 = this.a;
        b3b.f r2 = this.d;
        if ((r2 instanceof h) == true) goto L6;
        r2 = null;
    L6:
        new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.a(r11, r2).update(r1, r10, this.c, this.e, r8, this);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(m<y6b.a<FileContentVO>> r1, q<y6b.a<FileContentVO>> r2, y6b.a<FileContentVO> r3) {
        update2(r1, r2, r3);
    }
}
