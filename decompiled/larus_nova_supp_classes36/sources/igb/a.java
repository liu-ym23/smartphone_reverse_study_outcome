package igb;

import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewGroupKt;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.j1;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.i;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.base.view.vo.message.e;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.TextLayoutRenderConfigs;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.TextContentBlock;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.chatbase.view.TextChatView2;
import com.ss.android.lark.chatwindow.view.widget.TouchInterceptionLayout;
import com.ss.android.lark.coremd.utils.MessageStyleHelper;
import com.ss.android.lark.flow.chat.message.block.audio.FlowAudioLoadingDotsView;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.widget.light.LKUILightTextView;
import i3b.d;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements i<y6b.a<e>, e>, e6b.a {
    public final TextContentBlock a;

    /* JADX INFO: renamed from: igb.a$a, reason: collision with other inner class name */
    public static final class C0277a {
    }

    static {
    }

    public final Class<e> b() {
        this.a.getClass();
        return null;
    }

    public final e6b.a.a e(j r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        return this.a.e(r2);
    }

    public a(g r3) {
        TextContentBlock r0 = new TextContentBlock(r3);
        Intrinsics.checkNotNullParameter(r3, "ctx");
        Intrinsics.checkNotNullParameter(r0, "baseBlock");
        this.a = r0;
    }

    public final int d(y6b.a<e> r2) {
        if (r2.h() == false) goto L6;
        return UIUtils.getColor(this.a.getContext(), 2131102003);
    L6:
        return UIUtils.getColor(this.a.getContext(), 2131102004);
    }

    public final void a(m<y6b.a<e>> r6, q<y6b.a<e>> r7) {
        Intrinsics.checkNotNullParameter(r6, "cell");
        Intrinsics.checkNotNullParameter(r7, "layout");
        k r0 = r7.f(IMMessageKeys.Blocks.TEXT_CONTENT, IMMessageKeys.Slots.CONTENT);
        TextChatView2 r1 = null;
        if (r0 == null) goto L29;
        TouchInterceptionLayout r2 = r0.getView();
        if ((r2 instanceof TouchInterceptionLayout) == false) goto L8;
        TouchInterceptionLayout r3 = r2;
    L9:
        if (r3 == null) goto L29;
        Iterator r4 = ViewGroupKt.getChildren(r3).iterator();
    L13:
        if (r4.hasNext() == false) goto L17;
        Object r5 = r4.next();
        if ((((View) r5) instanceof TextChatView2) == false) goto L13;
    L19:
        if ((r5 instanceof TextChatView2) == false) goto L21;
        TextChatView2 r8 = (TextChatView2) r5;
    L23:
        if (r8 == null) goto L25;
        r8.setVisibility(0);
    L25:
        FlowAudioLoadingDotsView r9 = (FlowAudioLoadingDotsView) r3.findViewWithTag("flow_text_post_process_loading");
        if (r9 == null) goto L28;
        r9.b();
        r9.setVisibility(8);
    L28:
        r3.setMinimumWidth(0);
        r3.setMinimumHeight(0);
        goto L29
    L21:
        r8 = null;
        goto L23
    L17:
        r5 = null;
        goto L19
    L8:
        r3 = null;
    L29:
        k r10 = r7.f(IMMessageKeys.Blocks.TEXT_CONTENT, IMMessageKeys.Slots.CONTENT);
        if (r10 == null) goto L52;
        TouchInterceptionLayout r11 = r10.getView();
        if ((r11 instanceof TouchInterceptionLayout) == false) goto L35;
        TouchInterceptionLayout r12 = r11;
    L36:
        if (r12 == null) goto L52;
        Iterator r13 = ViewGroupKt.getChildren(r12).iterator();
    L40:
        if (r13.hasNext() == false) goto L44;
        Object r14 = r13.next();
        if ((((View) r14) instanceof TextChatView2) == false) goto L40;
    L46:
        if ((r14 instanceof TextChatView2) == false) goto L48;
        r1 = (TextChatView2) r14;
    L48:
        if (r1 == null) goto L52;
        LKUILightTextView r15 = r1.getLightTextView();
        if (r15 == null) goto L52;
        r15.w();
        goto L52
    L44:
        r14 = null;
        goto L46
    L35:
        r12 = null;
    L52:
        this.a.a(r6, r7);
    }

    public void update(m<y6b.a<e>> r11, q<y6b.a<e>> r12, y6b.a<e> r13) {
        Intrinsics.checkNotNullParameter(r11, "cell");
        Intrinsics.checkNotNullParameter(r12, "layout");
        Intrinsics.checkNotNullParameter(r13, "data");
        this.a.update(r11, r12, r13);
        k r14 = r12.f(IMMessageKeys.Blocks.TEXT_CONTENT, IMMessageKeys.Slots.CONTENT);
        if (r14 == null) goto L30;
        TouchInterceptionLayout r15 = r14.getView();
        if ((r15 instanceof TouchInterceptionLayout) == false) goto L8;
        TouchInterceptionLayout r16 = r15;
    L9:
        if (r16 == null) goto L30;
        Iterator r17 = ViewGroupKt.getChildren(r16).iterator();
    L13:
        if (r17.hasNext() == false) goto L17;
        Object r1 = r17.next();
        if ((((View) r1) instanceof TextChatView2) == false) goto L13;
    L19:
        if ((r1 instanceof TextChatView2) == false) goto L21;
        TextChatView2 r2 = (TextChatView2) r1;
    L22:
        if (r2 == null) goto L30;
        d r18 = this.a.a.c.a(d.class);
        if (r18 == null) goto L30;
        m2b.a r19 = r18.a();
        if (r19 == null) goto L30;
        LKUILightTextView r3 = r2.a;
        List r4 = TextLayoutRenderConfigs.a;
        r3.setTextColor(TextLayoutRenderConfigs.g(r19, r13.K(), MessageStyleHelper.b(r13)));
        goto L30
    L21:
        r2 = null;
        goto L22
    L17:
        r1 = null;
        goto L19
    L8:
        r16 = null;
    L30:
        k r110 = r12.f(IMMessageKeys.Blocks.TEXT_CONTENT, IMMessageKeys.Slots.CONTENT);
        if (r110 == null) goto L80;
        TouchInterceptionLayout r111 = r110.getView();
        if ((r111 instanceof TouchInterceptionLayout) == false) goto L36;
        TouchInterceptionLayout r112 = r111;
    L37:
        if (r112 == null) goto L81;
        Iterator r113 = ViewGroupKt.getChildren(r112).iterator();
    L41:
        if (r113.hasNext() == false) goto L45;
        Object r5 = r113.next();
        if ((((View) r5) instanceof TextChatView2) == false) goto L41;
    L47:
        if ((r5 instanceof TextChatView2) == false) goto L49;
        TextChatView2 r6 = (TextChatView2) r5;
    L50:
        if (r6 == null) goto L82;
        int r114 = UIUtils.dp2px(r112.getContext(), 32.0f);
        int r7 = UIUtils.dp2px(r112.getContext(), 8.0f);
        FlowAudioLoadingDotsView r8 = (FlowAudioLoadingDotsView) r112.findViewWithTag("flow_text_post_process_loading");
        if (r8 == null) goto L55;
        r8.setDotColor(d(r13));
    L56:
        int r115 = UIUtils.dp2px(r112.getContext(), 32.0f);
        LKUILightTextView r0 = r6.getLightTextView();
        int r9 = Math.max(r0.getMeasuredHeight(), Math.max(r0.getHeight(), UIUtils.dp2px(r112.getContext(), 22.0f)));
        if (r13.isPreMessage() == true) goto L59;
    L68:
        boolean r10 = false;
    L69:
        if (r10 == false) goto L71;
        r6.setVisibility(8);
        r112.setMinimumWidth(r115);
        r112.setMinimumHeight(r9);
        r8.setVisibility(0);
        r8.a();
        r112.requestLayout();
        return;
    L71:
        r6.setVisibility(0);
        r112.setMinimumWidth(0);
        r112.setMinimumHeight(0);
        r8.b();
        r8.setVisibility(8);
        r112.requestLayout();
        return;
    L59:
        if (r13.G() != SendStatus.SENDING) goto L68;
        j1.b r116 = (j1.b) r13.n(j1.b.class);
        r10 = true;
        if (r116 != null) goto L63;
    L65:
        boolean r117 = false;
    L66:
        if (r117 == false) goto L68;
    L63:
        if (r116.a != true) goto L65;
        r117 = true;
        goto L66
    L55:
        r8 = new FlowAudioLoadingDotsView(r112.getContext(), null, 6, 0);
        r8.setTag("flow_text_post_process_loading");
        r8.setVisibility(8);
        r8.setDotColor(d(r13));
        r8.setLayoutParams(new FrameLayout.LayoutParams(r114, r7, 17));
        r112.addView(r8);
        goto L56
    L82:
        return;
    L49:
        r6 = null;
        goto L50
    L45:
        r5 = null;
        goto L47
    L81:
        return;
    L36:
        r112 = null;
        goto L37
    }

    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (y6b.a) r3);
    }

    public final void c(BlueprintCell r2, q r3, Object r4, Object r5) {
        y6b.a r6 = (y6b.a) r4;
        e r7 = (e) r5;
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r7, "patch");
        this.a.c(r2, r3, r6, r7);
    }
}
