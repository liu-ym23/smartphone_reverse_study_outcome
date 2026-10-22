package c7b;

import android.text.TextUtils;
import android.view.View;
import b3b.f;
import b3b.q;
import com.ss.android.lark.blueprint.recyclerview.BlueprintCellViewHolder;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.PostContentBlock;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chatbase.view.post.PostChatView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.announce_opendoc.AnnounceOpenDocHitPoint;
import com.ss.android.lark.statistics.chat.ChatHitPoint;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import z5c.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends OnSingleClickListener {
    public final /* synthetic */ PostChatView a;

    public e(PostChatView r1) {
        this.a = r1;
    }

    public final void onSingleClick(View r6) {
        PostChatView r0 = this.a;
        if (r0.r == false) goto L13;
        if (r0.p == true) goto L7;
    L9:
        View.OnClickListener r1 = this.a.l;
        if (r1 == null) goto L65;
        r1.onClick(r6);
        return;
    L65:
        return;
    L7:
        if (TextUtils.isEmpty(r0.q) == true) goto L9;
        ChatCoreModule.a().getBrowserDependency().openUrl(this.a.getContext(), this.a.q);
        AnnounceOpenDocHitPoint.a(this.a.u);
        return;
    L13:
        if (TextUtils.isEmpty(r0.s) == true) goto L16;
        String r7 = this.a.t;
    L16:
        if (TextUtils.isEmpty(this.a.s) == true) goto L18;
        String r8 = this.a.s;
    L19:
        PostChatView r2 = this.a;
        if (r2.p == false) goto L25;
        if (TextUtils.isEmpty(r2.q) == true) goto L67;
        ChatCoreModule.a().getBrowserDependency().openUrl(this.a.getContext(), this.a.q);
        AnnounceOpenDocHitPoint.a(this.a.u);
        return;
    L67:
        return;
    L25:
        if (r2.A == true) goto L29;
        Log.i("PostChatView2", "supportJumpToThread is false");
        return;
    L29:
        if (r2.v == false) goto L31;
    L62:
        ChatHitPoint.a("postMessage");
        return;
    L31:
        if (r2.C == false) goto L61;
        PostContentBlock.e r9 = r2.D;
        if (r9 == null) goto L62;
        y6b.a<PostContentVO> r3 = r9.a;
        if ((r3 instanceof y6b.c) == false) goto L62;
        y6b.c r4 = (y6b.c) r3;
        if (r4.K2 == true) goto L39;
    L41:
        boolean r5 = false;
    L42:
        if (r5 == false) goto L62;
        xza.a r10 = r9.b;
        f r11 = null;
        if ((r10 instanceof xza.a) == false) goto L46;
        xza.a r12 = r10;
    L47:
        if (r12 == null) goto L51;
        BlueprintCellViewHolder r13 = r12.i();
        if (r13 == null) goto L51;
        Integer r14 = Integer.valueOf(r13.getLayoutPosition());
    L52:
        if (r14 == null) goto L62;
        PostContentBlock r15 = r9.c;
        y6b.a<PostContentVO> r16 = r9.a;
        r14.intValue();
        f r17 = r15.d;
        if ((r17 instanceof q) == false) goto L56;
        r11 = r17;
    L56:
        if (r11 == null) goto L58;
        r11.t(((y6b.c) r16).c, r14.intValue());
    L58:
        f r18 = r15.d;
        if (r18 == null) goto L62;
        r18.t(((y6b.c) r16).c, r14.intValue());
    L51:
        r14 = null;
        goto L52
    L46:
        r12 = null;
        goto L47
    L39:
        if (r4.i == false) goto L41;
        r5 = true;
        goto L42
    L61:
        ChatCoreModule.a().getChatDependency().h(Contexts.preferActivity(this.a.getContext()), r8, u0.e.b);
        goto L62
    L18:
        r8 = this.a.t;
        goto L19
    }
}
