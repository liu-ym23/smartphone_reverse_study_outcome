package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.holder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.ui.OptionNormalView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.ui.e;
import h80.c;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import np1.a;
import np1.b;
import np1.d;
import np1.f;
import np1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/settingpanel/holder/SettingNormalHolder;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/settingpanel/holder/BaseSettingHolder;", "Lnp1/g;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SettingNormalHolder extends BaseSettingHolder<g> {
    public final ViewGroup a;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.holder.BaseSettingHolder
    public final void U3() {
    }

    public SettingNormalHolder(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        super(LayoutInflater.from(r4.getContext()).inflate(2131566443, r4, false));
        View r5 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131378586);
        if ((r5 instanceof ViewGroup) == true) goto L5;
        r5 = null;
    L5:
        this.a = (ViewGroup) r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v3, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.holder.BaseSettingHolder
    public final void T3(b r11) {
        g r12 = (g) r11;
        Intrinsics.checkNotNullParameter(r12, "model");
        r12.g.a(c.c(((RecyclerView.ViewHolder) this).itemView));
        String r1 = r12.c;
        View r2 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390084);
        if ((r2 instanceof TextView) == true) goto L5;
        r2 = null;
    L5:
        TextView r3 = (TextView) r2;
        if (r3 == null) goto L11;
        r3.setText(r1);
        if (TextUtils.isEmpty(r1) == false) goto L10;
        UtilityKotlinExtentionsKt.t(r3);
        goto L11
    L10:
        UtilityKotlinExtentionsKt.w(r3);
    L11:
        ?? r4 = this.a;
        if (r4 == 0) goto L44;
        ArrayDeque r5 = new ArrayDeque(SequencesKt.toMutableList(SequencesKt.filterIsInstance(UtilityKotlinExtentionsKt.g(r4), OptionNormalView.class)));
        r4.removeAllViews();
        Iterator r6 = ((ArrayList) r12.d).iterator();
    L15:
        if (r6.hasNext() == false) goto L44;
        a r7 = (a) r6.next();
        d<? extends a> r8 = r7.a();
        if (r8 == null) goto L20;
        Intrinsics.checkNotNullParameter(r8, "$this$use");
        View r9 = r8.a(r4);
        r8.b(r7, r9);
        ?? r10 = r9;
        if (r9 == null) goto L20;
    L37:
        ViewParent r13 = r10.getParent();
        if ((r13 instanceof ViewGroup) == true) goto L40;
        r13 = null;
    L40:
        ?? r14 = (ViewGroup) r13;
        if (r14 == 0) goto L43;
        r14.removeView(r10);
    L43:
        r4.addView(r10);
    L20:
        OptionNormalView r15 = (OptionNormalView) r5.poll();
        if (r15 != null) goto L23;
        r15 = new OptionNormalView(((RecyclerView.ViewHolder) this).itemView.getContext(), null, 6, 0);
    L23:
        OptionNormalView r16 = r15;
        if ((r7 instanceof f) == true) goto L26;
        r7 = null;
    L26:
        f r17 = (f) r7;
        r10 = r16;
        if (r17 == null) goto L37;
        Intrinsics.checkNotNullParameter(r17, "model");
        RxUtilKt.c(com.bytedance.android.live.core.arch.mvvm.f.b(r17.c).subscribe(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.ui.d(r16)), r16.e);
        RxUtilKt.c(com.bytedance.android.live.core.arch.mvvm.f.b(r17.g).subscribe(new e(r16)), r16.e);
        LiveSwitchButton r18 = r16.c;
        if (r18 == null) goto L31;
        r18.setChecked(((Boolean) r17.e.a).booleanValue());
        r16.R5(((Boolean) r17.e.a).booleanValue());
        r18.setOnCheckedChangeListener(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.ui.b(r16, r17));
    L31:
        ImageView r19 = r16.b;
        r10 = r16;
        if (r19 == null) goto L37;
        if (r17.k == false) goto L36;
        UtilityKotlinExtentionsKt.w(r19);
        r19.setOnClickListener(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.ui.c(r17));
        r10 = r16;
        goto L37
    L36:
        UtilityKotlinExtentionsKt.t(r19);
        r19.setOnClickListener(null);
        r10 = r16;
    L44:
        r12.i.a(c.c(((RecyclerView.ViewHolder) this).itemView));
    }
}
