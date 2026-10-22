package com.ss.android.lark.flow.chat.message.block;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import b3b.h;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.base.view.vo.message.FileContentVO;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.g;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.flow.chat.databinding.FlowChatMessageV2BlockFileContentBinding;
import com.ss.android.lark.utils.a0;
import com.suite.lark.platform.component.widget_biz_fileview.FileView;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowFileContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<FileContentVO>, Object> {
    public static final String[] h = null;
    public final IMMessageKeys.Blocks g;

    public static final class a {
    }

    public static final class b extends com.ss.android.lark.blueprint.b<FlowChatMessageV2BlockFileContentBinding> implements g {
        public final void a(int r1) {
        }

        public final void b() {
        }

        public final void c() {
        }

        public final void d(ViewGroup.LayoutParams r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
        }

        public final void f() {
        }

        public final void h(boolean r1) {
        }

        public final void i() {
        }

        public final void j(boolean r1) {
        }

        public final void k() {
        }

        public final ViewGroup o() {
            return null;
        }

        public Context getContext() {
            return ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).a.getContext();
        }

        public final void showLoading() {
            LKUIToast.showLoading(getContext(), 2131891535);
        }

        public final void l() {
            LKUIToast.cancelLoading();
        }

        public b(FlowChatMessageV2BlockFileContentBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2);
        }

        public final void e(Object r2) {
            ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).a.setTag(r2);
        }

        public final void g(boolean r2) {
            TextView r0 = ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).d;
            if (r2 == false) goto L5;
            int r3 = 0;
        L6:
            r0.setVisibility(r3);
            return;
        L5:
            r3 = 8;
            goto L6
        }

        public final void m(com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.a.c r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).a.setOnLongClickListener(r2);
        }

        public final void showToast(String r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            LKUIToast.show(getContext(), r2);
        }

        public final void n(FileView.b r19, com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.a.b r20) {
            Intrinsics.checkNotNullParameter(r19, "fileInfo");
            Intrinsics.checkNotNullParameter(r20, "callback");
            FileView.ReceiveAuthorizationState r3 = FileView.ReceiveAuthorizationState.valueOf(r19.r);
            if (r3 != FileView.ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE) goto L5;
        L8:
            boolean r4 = true;
        L9:
            String r8 = null;
            String r10 = "";
            if (r4 == false) goto L21;
            Intrinsics.checkNotNull(r3);
            TextView r5 = ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).c;
            String r6 = r19.i;
            if (r6 != null) goto L15;
            r6 = "";
        L15:
            r5.setText(r6);
            ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).c.setTextColor(UIUtils.getColor(getContext(), 2131102042));
            ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).e.setVisibility(8);
            TextView r7 = ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).d;
            if (r3 != FileView.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY) goto L18;
            String r9 = UIUtils.getString(getContext(), 2131891244);
        L19:
            r7.setText(r9);
            ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).d.setTextColor(UIUtils.getColor(getContext(), 2131102042));
            ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).b.setImageResource(a0.b(null, "", 1));
        L60:
            ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).a.setOnClickListener(new com.ss.android.lark.flow.chat.message.block.b(r20, r19));
            return;
        L18:
            r9 = UIUtils.getString(getContext(), 2131891419);
            goto L19
        L21:
            if (r19.p == true) goto L29;
            TextView r11 = ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).c;
            String r12 = r19.i;
            if (r12 == null) goto L25;
            r10 = r12;
        L25:
            r11.setText(r10);
            ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).c.setTextColor(UIUtils.getColor(getContext(), 2131102042));
            ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).e.setVisibility(8);
            ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).d.setText(UIUtils.getString(getContext(), 2131891415));
            ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).d.setTextColor(UIUtils.getColor(getContext(), 2131102042));
            String r13 = r19.i;
            if (TextUtils.isEmpty(r13) == false) goto L28;
            r8 = r19.g;
        L28:
            ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).b.setImageResource(a0.b(r8, r13, 1));
            goto L60
        L29:
            String r14 = r19.i;
            if (r14 == null) goto L33;
            r10 = r14;
        L33:
            String r15 = FileUtils.m(r14);
            ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).c.setText(r19.i.substring(0, Math.max(0, r10.length() - r15.length())));
            ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).c.setTextColor(UIUtils.getColor(getContext(), 2131102040));
            ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).e.setVisibility(0);
            TextView r16 = ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).e;
            Intrinsics.checkNotNull(r15);
            if (r15.length() != 0) goto L36;
            boolean r17 = true;
        L38:
            if (r17 == true) goto L43;
            Intrinsics.checkNotNull(r15);
            r15 = r15.toUpperCase(Locale.ROOT);
            if (StringsKt.startsWith$default(r15, ".", false, 2, null) == false) goto L43;
            r15 = r15.substring(1);
        L43:
            r16.setText(r15);
            ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).e.setTextColor(UIUtils.getColor(getContext(), 2131102043));
            TextView r18 = ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).d;
            String[] r21 = FlowFileContentBlock.h;
            long r110 = r19.j;
            String[] r22 = FlowFileContentBlock.h;
            if (r110 >= 0) goto L47;
            r110 = 0;
        L47:
            if (r110 >= 1024) goto L49;
            String r23 = r110 + ' ' + r22[0];
        L56:
            r18.setText(r23);
            ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).d.setTextColor(UIUtils.getColor(getContext(), 2131102042));
            String r24 = r19.i;
            if (TextUtils.isEmpty(r24) == false) goto L59;
            r8 = r19.g;
        L59:
            ((FlowChatMessageV2BlockFileContentBinding) ((com.ss.android.lark.blueprint.b) this).a).b.setImageResource(a0.b(r8, r24, 1));
            goto L60
        L49:
            double r111 = r110 / 1024.0f;
            if (r111 >= 1024.0d) goto L53;
            StringCompanionObject r112 = StringCompanionObject.INSTANCE;
            r23 = String.format("%.2f %s", Arrays.copyOf(new Object[]{Double.valueOf(r111), r22[1]}, 2));
            goto L56
        L53:
            if (r111 >= 1048576.0d) goto L55;
            StringCompanionObject r113 = StringCompanionObject.INSTANCE;
            r23 = String.format("%.2f %s", Arrays.copyOf(new Object[]{Double.valueOf(r111 / 1024.0d), r22[2]}, 2));
            goto L56
        L55:
            double r114 = 1024;
            double r115 = ((r111 * ((double) 100)) / r114) / r114;
            StringCompanionObject r116 = StringCompanionObject.INSTANCE;
            r23 = String.format("%.2f %s", Arrays.copyOf(new Object[]{Double.valueOf(r115 / 100.0d), r22[3]}, 2));
            goto L56
        L36:
            r17 = false;
            goto L38
        L5:
            if (r3 == FileView.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY) goto L8;
            r4 = false;
            goto L9
        }
    }

    static {
        h = new String[]{"B", "KB", "MB", "GB"};
    }

    public final j getKey() {
        return this.g;
    }

    public FlowFileContentBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys.Blocks.FILE_CONTENT;
    }

    public void update(m<y6b.a<FileContentVO>> r8, q<y6b.a<FileContentVO>> r9, y6b.a<FileContentVO> r10) {
        Intrinsics.checkNotNullParameter(r8, "cell");
        Intrinsics.checkNotNullParameter(r9, "layout");
        Intrinsics.checkNotNullParameter(r10, "data");
        b r1 = r9.c(this.g, IMMessageKeys.Slots.CONTENT, new FlowFileContentBlock$update$blockView$1(this));
        com.ss.android.lark.blueprint.g r11 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).a;
        b3b.f r2 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).d;
        if ((r2 instanceof h) == true) goto L6;
        r2 = null;
    L6:
        new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.a(r11, r2).update(r1, r10, ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c, ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).e, r8, this);
    }

    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (y6b.a) r3);
    }
}
