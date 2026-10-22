package ynb;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.lark.pb.im.v1.DoubaoTyping;
import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import com.bytedance.lark.pb.im.v1.TypingMessage;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.biz.im.api.extension.chat_window.h;
import com.ss.android.lark.chat.entity.ComponentType;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.utils.m;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.dependency.KeyboardAssemblerModule;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.parser.internal.j;
import com.ss.android.lark.utils.UIHelper;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wnb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements wnb.b<a> {
    public static final C0348a o = null;
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b a;
    public com.ss.android.lark.keyboard.b b;
    public wnb.c c;
    public View d;
    public ImageView e;
    public Animator f;
    public TextView g;
    public final String h;
    public boolean i;
    public long j;
    public Chatter k;
    public String l;
    public boolean m;
    public final c n;

    /* JADX INFO: renamed from: ynb.a$a, reason: collision with other inner class name */
    public static final class C0348a implements wnb.b.a<a> {
        public C0348a() {
        }
    }

    public static final class b {
        public final boolean a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = r0 * 31;
            String r2 = this.b;
            if (r2 != null) goto L9;
            int r3 = 0;
        L11:
            return r1 + r3;
        L9:
            r3 = r2.hashCode();
            goto L11
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "TypingUiState(visible=" + this.a + ", displayName=" + this.b + ')';
        }

        public b(boolean r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c extends aqb.a {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        @Override // aqb.a
        public final void e(DoubaoTyping r10) {
            Intrinsics.checkNotNullParameter(r10, "doubaoTyping");
            Log.i("InputStateTopExpandPlugin", "receives doubaoTyping push: chatId: " + r10.chat_id + ", messageIds: " + r10.message_ids + ", updateMs: " + r10.update_time_ms);
            if (Intrinsics.areEqual(this.a.g(), r10.chat_id.toString()) == true) goto L6;
            Log.e("InputStateTopExpandPlugin", "receives doubaoTyping push ignored: pushChatId=" + r10.chat_id + ", currentChatId=" + this.a.g());
            return;
        L6:
            long r2 = r10.update_time_ms.longValue();
            a r0 = this.a;
            if (r2 >= r0.j) goto L10;
            Log.w("InputStateTopExpandPlugin", "receive doubaoTyping push but not latest: " + r10.update_time_ms + " < " + this.a.j);
            return;
        L10:
            r0.j = r10.update_time_ms.longValue();
            a r1 = this.a;
            if (r1.d == null) goto L181;
            List r3 = r10.messages;
            h r4 = r1.a.e;
            boolean r5 = true;
            if (r4 == null) goto L23;
            ComponentType r7 = r4.a;
            if (r7 == null) goto L23;
            ComponentType.Companion.getClass();
            Intrinsics.checkNotNullParameter(r7, "<this>");
            if (r7 != ComponentType.CHAT) goto L20;
            boolean r8 = true;
        L21:
            if (r8 != true) goto L23;
            boolean r9 = true;
        L24:
            if (r9 == false) goto L42;
            Intrinsics.checkNotNull(r3);
            List r6 = r3;
            if ((r6 instanceof Collection) == true) goto L28;
        L30:
            Iterator r11 = r6.iterator();
        L32:
            if (r11.hasNext() == false) goto L71;
            TypingMessage r12 = (TypingMessage) r11.next();
            Long r13 = r12.thread_id;
            if (r13 != null) goto L36;
        L39:
            boolean r14 = true;
        L40:
            if (r14 == false) goto L32;
        L70:
            boolean r15 = true;
        L73:
            if (r15 == true) goto L75;
            b r16 = new b(false, null);
        L86:
            Log.i("InputStateTopExpandPlugin", "renderTyping: visible=" + r16.a);
            boolean r17 = r16.a;
            if (r17 == true) goto L89;
        L91:
            boolean r18 = false;
        L92:
            r1.m = r17;
            if (r17 == true) goto L107;
            View r19 = r1.d;
            if (r19 != null) goto L97;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r19 = null;
        L97:
            r19.animate().cancel();
            View r20 = r1.d;
            if (r20 != null) goto L100;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r20 = null;
        L100:
            r20.setTranslationY(0.0f);
            View r21 = r1.d;
            if (r21 != null) goto L103;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r21 = null;
        L103:
            r21.setAlpha(1.0f);
            View r22 = r1.d;
            if (r22 != null) goto L106;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r22 = null;
        L106:
            r22.setVisibility(8);
        L135:
            boolean r23 = r16.a;
            ImageView r24 = r1.e;
            if (r24 == null) goto L156;
            if (r23 == true) goto L146;
            Animator r25 = r1.f;
            if (r25 == null) goto L142;
            r25.cancel();
        L142:
            r1.f = null;
            Drawable r26 = r24.getBackground();
            if (r26 == null) goto L145;
            r26.setAlpha(0);
        L145:
            r24.setAlpha(1.0f);
            r24.setVisibility(0);
            goto L156
        L146:
            Animator r27 = r1.f;
            if (r27 != null) goto L149;
        L151:
            boolean r28 = false;
        L152:
            if (r28 == true) goto L156;
            ValueAnimator r29 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r29.setDuration(1000);
            r29.setRepeatCount(-1);
            r29.setRepeatMode(1);
            r29.addUpdateListener(new ynb.b(r24));
            r29.start();
            r1.f = r29;
            goto L156
        L149:
            if (r27.isRunning() != true) goto L151;
            r28 = true;
        L156:
            if (r16.a == false) goto L178;
            String r110 = r16.b;
            if (r110 != null) goto L160;
        L163:
            if (r5 == true) goto L179;
            TextView r30 = r1.g;
            if (r30 == null) goto L180;
            r30.setText(r1.f(r110));
            return;
        L180:
            return;
        L179:
            return;
        L160:
            if (StringsKt.isBlank(r110) == true) goto L163;
            r5 = false;
            goto L163
        L178:
            return;
        L107:
            View r31 = r1.d;
            if (r31 != null) goto L110;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r31 = null;
        L110:
            r31.setVisibility(0);
            if (r18 == true) goto L122;
            View r32 = r1.d;
            if (r32 != null) goto L115;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r32 = null;
        L115:
            r32.animate().cancel();
            View r33 = r1.d;
            if (r33 != null) goto L118;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r33 = null;
        L118:
            r33.setTranslationY(0.0f);
            View r34 = r1.d;
            if (r34 != null) goto L121;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r34 = null;
        L121:
            r34.setAlpha(1.0f);
            goto L135
        L122:
            View r35 = r1.d;
            if (r35 != null) goto L125;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r35 = null;
        L125:
            r35.animate().cancel();
            View r36 = r1.d;
            if (r36 != null) goto L128;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r36 = null;
        L128:
            r36.setAlpha(0.0f);
            View r37 = r1.d;
            if (r37 != null) goto L131;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r37 = null;
        L131:
            r37.setTranslationY(0.0f);
            View r38 = r1.d;
            if (r38 != null) goto L134;
            Intrinsics.throwUninitializedPropertyAccessException("view");
            r38 = null;
        L134:
            r38.post(new ynb.c(r1));
            goto L135
        L89:
            if (r1.m == true) goto L91;
            r18 = true;
            goto L92
        L75:
            Chatter r111 = j.a(r10.chatter);
            if (r111 == null) goto L78;
            String r39 = r111.getId();
        L80:
            if (r1.k == null) goto L84;
            if (r39 != null) goto L83;
        L85:
            r16 = new b(true, m.b(r1.k, ChatterNameDisplayRule.ALIAS_NAME, false));
            goto L86
        L83:
            if (Intrinsics.areEqual(r39, r1.l) == true) goto L85;
        L84:
            r1.k = r111;
            r1.l = r39;
            goto L85
        L78:
            r39 = null;
            goto L80
        L36:
            if (Intrinsics.areEqual(r13, r12.msg_id) == true) goto L39;
            r14 = false;
        L71:
            r15 = false;
            goto L73
        L28:
            if (r6.isEmpty() == false) goto L30;
        L42:
            if (r4 == null) goto L51;
            ComponentType r40 = r4.a;
            if (r40 == null) goto L51;
            ComponentType.Companion.getClass();
            Intrinsics.checkNotNullParameter(r40, "<this>");
            if (r40 != ComponentType.REPLY_IN_THREAD) goto L48;
            boolean r41 = true;
        L49:
            if (r41 != true) goto L51;
            boolean r42 = true;
        L52:
            if (r42 == false) goto L71;
            Intrinsics.checkNotNull(r3);
            List r43 = r3;
            if ((r43 instanceof Collection) == true) goto L56;
        L58:
            Iterator r44 = r43.iterator();
        L60:
            if (r44.hasNext() == false) goto L71;
            TypingMessage r45 = (TypingMessage) r44.next();
            Long r46 = r45.thread_id;
            if (r46 != null) goto L64;
        L68:
            boolean r47 = false;
        L69:
            if (r47 == false) goto L60;
        L64:
            if (Intrinsics.areEqual(r46.toString(), r4.b) == false) goto L68;
            if (Intrinsics.areEqual(r45.thread_id, r45.msg_id) == true) goto L68;
            r47 = true;
            goto L69
        L56:
            if (r43.isEmpty() == false) goto L58;
        L48:
            r41 = false;
        L51:
            r42 = false;
            goto L52
        L20:
            r8 = false;
        L23:
            r9 = false;
            goto L24
        }
    }

    static {
        o = new C0348a();
    }

    @Override // wnb.b
    public final boolean i() {
        return false;
    }

    @Override // wnb.b
    public final View a() {
        itb.a r0 = OfficeSDKManager.getHostGlobalService(itb.a.class);
        if (r0 == null) goto L7;
        String r1 = r0.i();
        if (r1 == null) goto L7;
    L8:
        View r2 = LayoutInflater.from(this.a.a.requireContext()).inflate(2131565098, null);
        ((TextView) r2.findViewById(2131388525)).setText(f(r1));
        Intrinsics.checkNotNull(r2);
        r2.setVisibility(8);
        this.d = r2;
        this.e = (ImageView) r2.findViewById(2131371516);
        View r3 = this.d;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r3 = null;
    L11:
        this.g = (TextView) r3.findViewById(2131388525);
        View r4 = this.d;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r4 = null;
    L14:
        r4.findViewById(2131374808).setVisibility(8);
        ImageView r5 = this.e;
        if (r5 == null) goto L21;
        GradientDrawable r6 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ColorProtector.parseColor("#00000000"), ColorProtector.parseColor("#55000000"), ColorProtector.parseColor("#00000000")});
        r6.setShape(1);
        r6.setGradientType(1);
        r6.setGradientRadius(32.0f);
        r5.setBackground(r6);
        Drawable r7 = r5.getBackground();
        if (r7 == null) goto L21;
        r7.setAlpha(0);
    L21:
        if (this.i == true) goto L24;
        KeyboardAssemblerModule.a().registerPushChatRelation(this.h, g(), SubscribeChatEventRequest.SubscriptionKey.DOUBAO_TYPING, this.n);
        this.i = true;
    L24:
        View r8 = this.d;
        if (r8 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        return null;
    L28:
        return r8;
    L7:
        r1 = "";
        goto L8
    }

    @Override // wnb.b
    public final e b() {
        return new e(UIHelper.dp2px(12.0f), 0, 0, 0);
    }

    public final String g() {
        String r0 = this.a.c.getId();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // wnb.b
    public final wnb.c h() {
        wnb.c r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    @Override // wnb.b
    public final void onDestroy() {
        View r0 = this.d;
        if (r0 == null) goto L5;
        r0.setOnClickListener(null);
    L5:
        Animator r1 = this.f;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.f = null;
        this.e = null;
        this.g = null;
        if (this.i == false) goto L13;
        KeyboardAssemblerModule.a().unregisterPushChatRelation(this.h, g(), SubscribeChatEventRequest.SubscriptionKey.DOUBAO_TYPING);
        this.i = false;
        return;
    }

    @Override // wnb.b
    public final DirectionInParent c() {
        return DirectionInParent.TOP;
    }

    @Override // wnb.b
    public final InputInnerVisibilityMode d() {
        return InputInnerVisibilityMode.DYNAMIC;
    }

    @Override // wnb.b
    public final Direction getDirection() {
        return Direction.TopExpand;
    }

    @Override // wnb.b
    public final wnb.b.a<a> getKey() {
        return o;
    }

    public a(com.ss.android.lark.biz.im.api.extension.chat_window.b r2) {
        Intrinsics.checkNotNullParameter(r2, "keyboardPluginContext");
        this.a = r2;
        this.h = String.valueOf(hashCode());
        this.n = new c(this);
    }

    @Override // wnb.b
    public final void e(InputInnerController r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final String f(String r4) {
        String r0 = UIUtils.getString(this.a.a.requireContext(), 2131890100);
        ICUUtils.FormatArgsBuilder r1 = new ICUUtils.FormatArgsBuilder();
        r1.b("brandName", r4);
        return ICUUtils.icuFormat(r0, r1.a);
    }

    @Override // wnb.b
    public final void setKeyboard(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }
}
