package com.ss.android.lark.flow.chat.message.block.threadforward;

import android.view.View;
import android.widget.TextView;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.base.view.vo.message.ThreadForwardContentVOV2;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowThreadForwardHeaderBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<ThreadForwardContentVOV2>, Object> {
    public static final /* synthetic */ int k = 0;
    public final IMMessageKeys.Blocks g;
    public final IMMessageKeys.Slots h;
    public final Lazy i;
    public final Lazy j;

    public static final class a {
    }

    public static final class b implements k<View> {
        public final View a;
        public final View b;
        public final TextView c;

        public final View getView() {
            return this.a;
        }

        public b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
            this.b = r2.findViewById(2131389177);
            TextView r3 = (TextView) r2.findViewById(2131382828);
            this.c = r3;
            zz7.a.c(r3, 14);
        }
    }

    static {
    }

    public final j getKey() {
        return this.g;
    }

    public FlowThreadForwardHeaderBlock(g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys.Blocks.FLOW_THREAD_FORWARD_HEADER;
        this.h = IMMessageKeys.Slots.CONTENT;
        this.i = LazyKt.lazy(new FlowThreadForwardHeaderBlock$replyInThreadCallback$2(this));
        this.j = LazyKt.lazy(new FlowThreadForwardHeaderBlock$threadCallback$2(this));
    }

    public void update(m<y6b.a<ThreadForwardContentVOV2>> r6, q<y6b.a<ThreadForwardContentVOV2>> r7, y6b.a<ThreadForwardContentVOV2> r8) {
        Intrinsics.checkNotNullParameter(r6, "cell");
        Intrinsics.checkNotNullParameter(r7, "layout");
        Intrinsics.checkNotNullParameter(r8, "item");
        b r9 = (b) r7.c(this.g, this.h, FlowThreadForwardHeaderBlock$update$blockView$1.INSTANCE);
        ThreadForwardContentVOV2 r0 = r8.b();
        if (r0.j.length() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L9;
    L12:
        r9.c.setText(ICUUtils.icuFormat(UIUtils.getString(getContext(), 2131890197), "name", r0.i.getName()));
    L13:
        String r2 = r8.getId();
        ThreadForwardContentVOV2 r3 = r8.b();
        Thread r4 = ((v5b.a) r3).a.getThread();
        if (r4 == null) goto L17;
        String r5 = r4.id;
        if (r5 == null) goto L17;
    L18:
        r9.b.setOnClickListener(new c(r3, this, r5, r2));
        r9.b.setOnLongClickListener(new d(r6, this, r8));
        return;
    L17:
        r5 = "";
        goto L18
    L9:
        if (r0.f() == false) goto L12;
        String r10 = UIUtils.getString(getContext(), 2131890145);
        ICUUtils.FormatArgsBuilder r11 = new ICUUtils.FormatArgsBuilder();
        r11.b("name", r0.i.getName());
        r11.b("source_chat_name", r0.j);
        String r12 = ICUUtils.icuFormat(r10, r11.a);
        r9.c.setText(r12);
        goto L13
    L5:
        r1 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (y6b.a) r3);
    }
}
