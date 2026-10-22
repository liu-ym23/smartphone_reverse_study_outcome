package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.castscreen.AdaptiveDialogFragment;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/BaseActionSheet;", "Lcom/bytedance/android/livesdk/castscreen/AdaptiveDialogFragment;", "<init>", "()V", "ActionSheetAdapter", "ActionSheetItemViewHolder", "a", "b", "c", "d", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BaseActionSheet extends AdaptiveDialogFragment {
    public a e;
    public c f;
    public List<d> g;
    public final int h;
    public final int i;
    public View j;
    public View k;
    public View l;
    public RecyclerView m;
    public View n;
    public View o;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/BaseActionSheet$ActionSheetAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/BaseActionSheet$ActionSheetItemViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ActionSheetAdapter extends RecyclerView.Adapter<ActionSheetItemViewHolder> {
        public final BaseActionSheet a;

        public final int getItemCount() {
            return this.a.g.size();
        }

        public ActionSheetAdapter(BaseActionSheet r2) {
            Intrinsics.checkNotNullParameter(r2, "actionSheet");
            this.a = r2;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
            ActionSheetItemViewHolder r5 = (ActionSheetItemViewHolder) r3;
            Intrinsics.checkNotNullParameter(r5, "viewHolder");
            d r6 = (d) ListProtector.get(this.a.g, r4);
            r5.a.setOnClickListener(new j(this, r6));
            if (this.a.isVertical() == false) goto L5;
        L15:
            View r7 = r5.a;
            if (r7 == null) goto L23;
            TextView r8 = (TextView) r7;
            r8.setText(r6.a);
            if (r6.c == false) goto L20;
            r8.setTextColor(com.bytedance.android.live.core.utils.s1.h(this.a.i));
            return;
        L20:
            r8.setTextColor(com.bytedance.android.live.core.utils.s1.h(this.a.h));
            return;
        L23:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        L5:
            if (PadConfigUtils.c() == false) goto L7;
            PadConfigUtils.c();
            goto L15
        L7:
            View r9 = r5.a;
            if (r9 == null) goto L14;
            TextView r0 = (TextView) r9;
            r0.setText(r6.a);
            if (r6.c == false) goto L12;
            r0.setTextColor(com.bytedance.android.live.core.utils.s1.h(this.a.i));
            r9.setBackgroundDrawable(AppCompatResources.getDrawable(r0.getContext(), 2131250068));
            return;
        L12:
            r0.setTextColor(com.bytedance.android.live.core.utils.s1.h(this.a.h));
            r9.setBackgroundDrawable(null);
            return;
        L14:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r6, int r7) {
            Intrinsics.checkNotNullParameter(r6, "viewGroup");
            if (this.a.isVertical() == false) goto L5;
        L8:
            TextView r0 = new TextView(r6.getContext());
            r0.setTextSize(14.0f);
            r0.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) com.bytedance.android.live.core.utils.s1.e(56.0f)));
            com.bytedance.android.live.core.utils.a1.j(r0, 1);
            r0.setGravity(17);
        L10:
            return new ActionSheetItemViewHolder(r0);
        L5:
            if (PadConfigUtils.c() == false) goto L7;
            PadConfigUtils.c();
            goto L8
        L7:
            r0 = new TextView(r6.getContext());
            r0.setTextSize(15.0f);
            r0.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) com.bytedance.android.live.core.utils.s1.e(45.0f)));
            com.bytedance.android.live.core.utils.a1.j(r0, 1);
            r0.setGravity(17);
            goto L10
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/BaseActionSheet$ActionSheetItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ActionSheetItemViewHolder extends RecyclerView.ViewHolder {
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
    }

    public interface c {
        void a(d r1);
    }

    public static final class d {
        public String a;
        public int b;
        public boolean c;

        public d() {
        }
    }

    static {
    }

    public BaseActionSheet() {
        this.g = new ArrayList();
        this.h = 2131108505;
        this.i = 2131108506;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        a r0 = this.e;
        if (r0 == null) goto L6;
        r0.onDismiss();
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        a r0 = this.e;
        if (r0 == null) goto L6;
        r0.onShow();
        return;
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        if (PadConfigUtils.c() == false) goto L37;
        PadConfigUtils.c();
        View r4 = this.l;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetContainer");
    L8:
        if (PadConfigUtils.c() == false) goto L10;
        Drawable r0 = com.bytedance.android.live.core.utils.s1.m(2131248927);
    L11:
        r4.setBackgroundDrawable(r0);
        Dialog r5 = getDialog();
        if (r5 == null) goto L16;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L16;
        WindowManager.LayoutParams r1 = r6.getAttributes();
        r1.height = com.bytedance.android.live.core.utils.x1.d(getContext());
        r6.setAttributes(r1);
    L16:
        View r7 = this.k;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
    L19:
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == true) goto L22;
        r8 = null;
    L22:
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
        if (r9 == null) goto L32;
        r9.height = -1;
        if (PadConfigUtils.c() == false) goto L27;
        int r2 = com.bytedance.android.live.core.utils.s1.f(375.0f);
    L28:
        r9.width = r2;
        View r10 = this.k;
        if (r10 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
    L31:
        r10.setLayoutParams(r9);
        goto L32
    L27:
        r2 = com.bytedance.android.live.core.utils.s1.y();
    L32:
        View r11 = this.k;
        if (r11 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
    L35:
        com.bytedance.android.live.core.utils.a1.j(r11, 8388613);
        return;
    L10:
        r0 = com.bytedance.android.live.core.utils.s1.m(2131248924);
        goto L11
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

    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        if (PadConfigUtils.c() == false) goto L5;
        PadConfigUtils.c();
        int r8 = 2131567953;
    L6:
        View r9 = r5.inflate(r8, r6, false);
        this.j = r9;
        if (r9 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L9:
        this.k = r9.findViewById(2131392873);
        View r10 = this.j;
        if (r10 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L12:
        this.m = r10.findViewById(2131392877);
        View r11 = this.j;
        if (r11 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L15:
        this.l = r11.findViewById(2131392875);
        View r12 = this.j;
        if (r12 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L18:
        this.n = r12.findViewById(2131392874);
        View r13 = this.j;
        if (r13 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L21:
        this.o = r13.findViewById(2131392876);
        if (isVertical() == false) goto L24;
    L33:
        View r14 = this.o;
        if (r14 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetEmptyView");
    L36:
        r14.setOnClickListener(new l(this));
        View r15 = this.n;
        if (r15 == null) goto L39;
        r15.setOnClickListener(new m(this));
    L39:
        RecyclerView r16 = this.m;
        if (r16 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetListView");
    L42:
        r16.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        RecyclerView r17 = this.m;
        if (r17 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetListView");
    L45:
        r17.setAdapter(new ActionSheetAdapter(this));
        View r18 = this.j;
        if (r18 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L48:
        return r18;
    L24:
        if (PadConfigUtils.c() == false) goto L26;
        PadConfigUtils.c();
        goto L33
    L26:
        Context r19 = getContext();
        Intrinsics.checkNotNull(r19);
        Drawable r20 = AppCompatResources.getDrawable(r19, 2131253334);
        View r21 = this.l;
        if (r21 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetContainer");
    L29:
        r21.setBackgroundDrawable(r20);
        View r22 = this.l;
        if (r22 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetContainer");
    L32:
        r22.setOnClickListener(new k(this));
        goto L33
    L5:
        r8 = 2131567952;
        goto L6
    }
}
