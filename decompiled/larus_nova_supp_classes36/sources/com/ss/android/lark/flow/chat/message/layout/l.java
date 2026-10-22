package com.ss.android.lark.flow.chat.message.layout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.blueprint.u;
import com.ss.android.lark.blueprint.v;
import com.ss.android.lark.chat.base.view.vo.message.ThreadForwardContentVOV2;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l extends com.ss.android.lark.flow.chat.message.layout.b {

    public static final class a implements wza.d<y6b.a<?>> {
        public final IMMessageKeys.Layouts a;

        public a() {
            this.a = IMMessageKeys.Layouts.BUBBLE_THREAD_FORWARD_NESTED;
        }

        public u getType() {
            return this.a;
        }

        public final q a(com.ss.android.lark.blueprint.g r3, BlueprintCell r4) {
            Intrinsics.checkNotNullParameter(r3, "ctx");
            Intrinsics.checkNotNullParameter(r4, "cell");
            return new l(r3, r4, false);
        }
    }

    public static final class b implements wza.d<y6b.a<?>> {
        public final IMMessageKeys.Layouts a;

        public b() {
            this.a = IMMessageKeys.Layouts.RTL_BUBBLE_THREAD_FORWARD_NESTED;
        }

        public u getType() {
            return this.a;
        }

        public final q a(com.ss.android.lark.blueprint.g r3, BlueprintCell r4) {
            Intrinsics.checkNotNullParameter(r3, "ctx");
            Intrinsics.checkNotNullParameter(r4, "cell");
            return new l(r3, r4, true);
        }
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.b, com.ss.android.lark.flow.chat.message.layout.a
    public final Map<v, Integer> z() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(IMMessageKeys.Slots.CONTENT, 2131364916), TuplesKt.to(IMMessageKeys.Slots.FOOTER, 2131364913), TuplesKt.to(IMMessageKeys.Slots.INNER_EXPOSURE, 2131364921)});
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.a
    public final void v() {
        View r0 = r().findViewById(2131375309);
        r0.setBackgroundResource(2131232179);
        int r1 = UIUtils.dp2px(((com.ss.android.lark.blueprint.a) this).a.getContext(), 12.0f);
        int r2 = UIUtils.dp2px(((com.ss.android.lark.blueprint.a) this).a.getContext(), 8.0f);
        r0.setPadding(r1, r2, r1, r2);
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.a
    public final void A(y6b.a<?> r9) {
        Intrinsics.checkNotNullParameter(r9, "data");
        super.A(r9);
        Iterator r10 = CollectionsKt.listOf(new IMMessageKeys.Blocks[]{IMMessageKeys.Blocks.IMAGE_CONTENT, IMMessageKeys.Blocks.MEDIA_CONTENT, IMMessageKeys.Blocks.MERGE_FORWARD_CONTENT, IMMessageKeys.Blocks.FLOW_PROFILE_CONTENT, IMMessageKeys.Blocks.FILE_CONTENT, IMMessageKeys.Blocks.FOLDER_CONTENT, IMMessageKeys.Blocks.SHARE_GROUP_CHAT_CONTENT}).iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        com.ss.android.lark.blueprint.k r0 = f((IMMessageKeys.Blocks) r10.next(), IMMessageKeys.Slots.CONTENT);
        if (r0 == null) goto L4;
        View r1 = r0.getView();
        if (r1 == null) goto L4;
        r1.setBackgroundResource(2131232178);
        goto L4
    L10:
        Iterator r11 = CollectionsKt.listOf(new IMMessageKeys.Blocks[]{IMMessageKeys.Blocks.MERGE_FORWARD_CONTENT, IMMessageKeys.Blocks.FLOW_PROFILE_CONTENT, IMMessageKeys.Blocks.FILE_CONTENT, IMMessageKeys.Blocks.FOLDER_CONTENT, IMMessageKeys.Blocks.SHARE_GROUP_CHAT_CONTENT}).iterator();
    L12:
        if (r11.hasNext() == false) goto L18;
        com.ss.android.lark.blueprint.k r2 = f((IMMessageKeys.Blocks) r11.next(), IMMessageKeys.Slots.CONTENT);
        if (r2 == null) goto L12;
        View r3 = r2.getView();
        if (r3 == null) goto L12;
        int r4 = UIUtils.dp2px(((com.ss.android.lark.blueprint.a) this).a.getContext(), 12.0f);
        r3.setPadding(r4, r4, r4, r4);
        goto L12
    L18:
        com.ss.android.lark.blueprint.k r12 = a(IMMessageKeys.Blocks.AUDIO_CONTENT);
        if (r12 == null) goto L38;
        View r13 = r12.getView();
        if (r13 == null) goto L39;
        r13.setBackgroundResource(2131232180);
        int r5 = UIUtils.dp2px(((com.ss.android.lark.blueprint.a) this).a.getContext(), 12.0f);
        int r6 = UIUtils.dp2px(((com.ss.android.lark.blueprint.a) this).a.getContext(), 8.0f);
        r13.setPadding(r5, r6, r5, r6);
        return;
    L39:
        return;
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.a
    public final /* bridge */ /* synthetic */ void l(Object r1) {
        A((y6b.a) r1);
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.b, com.ss.android.lark.flow.chat.message.layout.a
    public final LKUIRoundLinearLayout y(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        LKUIRoundLinearLayout r5 = LayoutInflater.from(r4.getContext()).inflate(2131561134, r4, false);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larksuite.component.ui.layout.LKUIRoundLinearLayout");
        return r5;
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.b, com.ss.android.lark.flow.chat.message.layout.a
    public final void B(LKUIRoundLinearLayout r8, y6b.a<?> r9) {
        Intrinsics.checkNotNullParameter(r8, "bodyLayout");
        Intrinsics.checkNotNullParameter(r9, "data");
        super.B(r8, r9);
        ViewGroup.LayoutParams r0 = r8.getLayoutParams();
        r0.width = -1;
        r8.setLayoutParams(r0);
        View r10 = r().findViewById(2131388585);
        String r5 = r9.getId();
        v5b.a r1 = r9.b();
        if ((r1 instanceof ThreadForwardContentVOV2) == false) goto L5;
        v5b.a r2 = (ThreadForwardContentVOV2) r1;
    L6:
        if (r2 == null) goto L23;
        Thread r3 = r2.a.getThread();
        if (r3 == null) goto L12;
        String r4 = r3.id;
        if (r4 == null) goto L12;
    L13:
        String r6 = r4;
        i3b.d r7 = ((com.ss.android.lark.blueprint.a) this).a.c.a(i3b.d.class);
        if (r7 == null) goto L16;
        b3b.f r11 = r7.g();
    L17:
        if (r10 == null) goto L19;
        r10.setOnClickListener(new m(r2, this, r11, r6, r5));
    L19:
        if (r10 == null) goto L22;
        r10.setOnLongClickListener(new n(this, r9));
        return;
    L22:
        return;
    L16:
        r11 = null;
    L12:
        r4 = "";
        goto L13
    L23:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public l(com.ss.android.lark.blueprint.g r2, BlueprintCell r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "cell");
        super(r2, r3, r4);
    }
}
