package com.bytedance.android.livesdk.chatroom.vs_base.view.actionsheet;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.ReplayAdaptiveDialogUIState;
import com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.ReplayDialogUIStyle;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.vs_base.util.k;
import com.bytedance.android.livesdk.chatroom.vs_base.view.ReplayAdaptiveDialogFragment;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/view/actionsheet/ReplayActionSheet;", "Lcom/bytedance/android/livesdk/chatroom/vs_base/view/ReplayAdaptiveDialogFragment;", "ActionSheetAdapter", "ActionSheetItemViewHolder", "a", "b", "c", "d", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ReplayActionSheet extends ReplayAdaptiveDialogFragment {
    public static final /* synthetic */ int s = 0;
    public a f;
    public c g;
    public List<? extends d> h;
    public final int i;
    public final int j;
    public DataCenter k;
    public View l;
    public View m;
    public View n;
    public RecyclerView o;
    public View p;
    public View q;
    public final int r;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/view/actionsheet/ReplayActionSheet$ActionSheetAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/chatroom/vs_base/view/actionsheet/ReplayActionSheet$ActionSheetItemViewHolder;", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static class ActionSheetAdapter extends RecyclerView.Adapter<ActionSheetItemViewHolder> {
        public final ReplayActionSheet a;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ ActionSheetAdapter a;
            public final /* synthetic */ d b;

            public a(ActionSheetAdapter r1, d r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r2) {
                c r3 = this.a.a.g;
                if (r3 == null) goto L13;
                r3.a(this.b);
            L13:
                this.a.a.dismiss();     // Catch: Exception -> L8
                return;
            L8:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
                Throwable r4 = DialogFragmentLancet.sLastShowStack;
                if (r4 == null) goto L15;
                com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
                return;
            }
        }

        public final int getItemCount() {
            return this.a.h.size();
        }

        public ActionSheetAdapter(ReplayActionSheet r2) {
            Intrinsics.checkNotNullParameter(r2, "actionSheet");
            this.a = r2;
        }

        public ActionSheetItemViewHolder z2(ViewGroup r5) {
            Intrinsics.checkNotNullParameter(r5, "viewGroup");
            TextView r1 = new TextView(r5.getContext());
            com.bytedance.android.livesdk.chatroom.vs_base.base.d r6 = ReplayRoomFragmentScopeUtil.a;
            ((com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d.class)).getClass();
            r1.setTextSize(16.0f);
            ((com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d.class)).getClass();
            r1.setLayoutParams(new ViewGroup.LayoutParams(-1, UtilityKotlinExtentionsKt.c(60)));
            k.a(r1, 1);
            r1.setGravity(17);
            return new ActionSheetItemViewHolder(r1);
        }

        public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
            y2((ActionSheetItemViewHolder) r1, r2);
        }

        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
            return z2(r1);
        }

        public void y2(ActionSheetItemViewHolder r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "viewHolder");
            d r6 = (d) ListProtector.get(this.a.h, r5);
            r4.a.setOnClickListener(new a(this, r6));
            View r7 = r4.a;
            if (r7 == null) goto L21;
            TextView r0 = (TextView) r7;
            r0.setText(r6.a);
            Integer r1 = null;
            if (r6.c == false) goto L18;
            r0.setTextColor(s1.h(this.a.j));
            com.bytedance.android.livesdk.chatroom.vs_base.base.d r8 = ReplayRoomFragmentScopeUtil.a;
            ReplayDialogUIStyle r9 = ((com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d.class)).p();
            int r10 = com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.c.c[r9.ordinal()];
            if (r10 != 1) goto L9;
        L16:
            if (r1 == null) goto L22;
            int r11 = r1.intValue();
            r7.setBackgroundDrawable(AppCompatResources.getDrawable(r0.getContext(), r11));
            return;
        L22:
            return;
        L9:
            if (r10 != 2) goto L11;
            r1 = 2131249849;
            goto L16
        L11:
            if (r10 == 3) goto L16;
            throw new NoWhenBranchMatchedException();
        L18:
            r0.setTextColor(s1.h(this.a.i));
            r7.setBackgroundDrawable(null);
            return;
        L21:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/view/actionsheet/ReplayActionSheet$ActionSheetItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static class ActionSheetItemViewHolder extends RecyclerView.ViewHolder {
        public final View a;

        public ActionSheetItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = r2;
        }
    }

    public interface a {
        void onDismiss();

        void onShow();
    }

    public static final class b {
        public static Drawable a(int r2) {
            if (r2 == 1) goto L9;
            if (r2 == 2) goto L11;
            return s1.m(2131250066);
        L11:
            return s1.m(2131250067);
        L9:
            return s1.m(2131250066);
        }
    }

    public interface c {
        void a(d r1);
    }

    public static class d {
        public String a;
        public int b;
        public boolean c;

        public d() {
        }
    }

    static {
    }

    public ReplayActionSheet() {
        this(1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.view.ReplayAdaptiveDialogFragment
    public final String S90() {
        return "ReplayActionSheet[" + hashCode() + ']';
    }

    public ActionSheetAdapter T90() {
        return new ActionSheetAdapter(this);
    }

    public final boolean U90() {
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r0 = ReplayRoomFragmentScopeUtil.a;
        if (((ReplayAdaptiveDialogUIState) ReplayRoomFragmentScopeUtil.a(ReplayAdaptiveDialogUIState.class)).i() == false) goto L5;
    L8:
        return true;
    L5:
        if (PadConfigUtils.c() == false) goto L7;
        PadConfigUtils.c();
        goto L8
    L7:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.view.ReplayAdaptiveDialogFragment
    public final int getActualContentWidth() {
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r0 = ReplayRoomFragmentScopeUtil.a;
        if (((com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d.class)).p() == ReplayDialogUIStyle.RightStyle) goto L7;
        return 0;
    L7:
        return UtilityKotlinExtentionsKt.c(250);
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        a r0 = this.f;
        if (r0 == null) goto L6;
        r0.onDismiss();
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        a r0 = this.f;
        if (r0 == null) goto L6;
        r0.onShow();
        return;
    }

    public ReplayActionSheet(int r1) {
        this.r = r1;
        this.h = new ArrayList();
        this.i = 2131108166;
        this.j = 2131108167;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        if (PadConfigUtils.c() == false) goto L13;
        dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L14;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }

    public View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r9 = ReplayRoomFragmentScopeUtil.a;
        int r10 = com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.c.a[((com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d.class)).p().ordinal()];
        if (r10 == 1) goto L10;
        if (r10 == 2) goto L9;
        if (r10 != 3) goto L8;
        int r11 = 2131567289;
    L11:
        View r12 = r6.inflate(r11, r7, false);
        this.l = r12;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L14:
        this.m = r12.findViewById(2131392873);
        View r13 = this.l;
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L17:
        this.o = r13.findViewById(2131392877);
        View r14 = this.l;
        if (r14 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L20:
        this.n = r14.findViewById(2131392875);
        View r15 = this.l;
        if (r15 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L23:
        this.p = r15.findViewById(2131392874);
        View r16 = this.l;
        if (r16 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L26:
        this.q = r16.findViewById(2131392876);
        com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d r17 = (com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d.class);
        int r18 = this.r;
        int r19 = com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.c.b[r17.p().ordinal()];
        ViewGroup.LayoutParams r4 = null;
        if (r19 == 1) goto L34;
        if (r19 == 2) goto L33;
        if (r19 != 3) goto L32;
        Drawable r20 = null;
    L36:
        if (r20 == null) goto L41;
        View r0 = this.n;
        if (r0 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetContainer");
    L40:
        r0.setBackground(r20);
    L41:
        com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d r21 = (com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d.class);
        View r1 = this.n;
        if (r1 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetContainer");
    L44:
        r21.getClass();
        Intrinsics.checkNotNullParameter(r1, "view");
        ViewGroup.LayoutParams r22 = r1.getLayoutParams();
        if (r22 == null) goto L47;
        r22.width = r21.o();
        Unit r23 = Unit.INSTANCE;
        r4 = r22;
    L47:
        r1.setLayoutParams(r4);
        View r24 = this.q;
        if (r24 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetEmptyView");
    L50:
        r24.setOnClickListener(new kr1.a(this));
        View r25 = this.p;
        if (r25 == null) goto L53;
        r25.setOnClickListener(new kr1.b(this));
    L53:
        RecyclerView r26 = this.o;
        if (r26 == null) goto L56;
        r26.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
    L56:
        RecyclerView r27 = this.o;
        if (r27 == null) goto L59;
        r27.setAdapter(T90());
    L59:
        View r28 = this.l;
        if (r28 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L62:
        return r28;
    L32:
        throw new NoWhenBranchMatchedException();
    L33:
        r20 = b.a(r18);
        goto L36
    L34:
        r20 = s1.m(2131249841);
        goto L36
    L8:
        throw new NoWhenBranchMatchedException();
    L9:
        r11 = 2131567290;
        goto L11
    L10:
        r11 = 2131567291;
        goto L11
    }
}
