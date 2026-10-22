package com.larus.bmhome.view.actionbar.custom;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.databinding.LarusChatItemCustomActionbarNormalHolderBinding;
import com.larus.bmhome.instruction.core.model.ActionBarDisplayType;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.utils.logger.FLogger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001'B_\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010\u0012\u0012\b\u0002\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0000¢\u0006\u0002\b\u001cJ\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010$\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u0003H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "Lcom/larus/bmhome/view/actionbar/BaseActionBarHolder;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "callback", "Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;", "isImmerseStyle", "", "segmentFactory", "", "Lcom/larus/bmhome/view/actionbar/api/IActionBarSegment;", "actionBarShowTipCache", "Lcom/larus/bmhome/view/actionbar/custom/IActionBarShowTipCache;", "hostActivityProvider", "Lkotlin/Function0;", "Landroid/app/Activity;", "hostViewProvider", "Landroid/view/View;", "<init>", "(Lcom/larus/bmhome/chat/ChatParam;Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;ZLjava/util/List;Lcom/larus/bmhome/view/actionbar/custom/IActionBarShowTipCache;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getChatParam", "()Lcom/larus/bmhome/chat/ChatParam;", "firstFramePosted", "refreshRuntimeSegments", "", "runtimeSegments", "refreshRuntimeSegments$impl_mainlandRelease", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemViewType", "onViewRecycled", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomActionBarAdapter extends ListAdapter<com.larus.bmhome.actionbar.model.z0, BaseActionBarHolder> {
    public static final /* synthetic */ int i = 0;
    public final ChatParam a;
    public final t1 b;
    public final boolean c;
    public final List<ss8.e> d;
    public final x2 e;
    public final Function0<Activity> f;
    public final Function0<View> g;
    public boolean h;

    public static final class a {
    }

    static {
    }

    public CustomActionBarAdapter() {
        throw null;
    }

    public final int getItemViewType(int r4) {
        com.larus.bmhome.actionbar.model.z0 r5 = (com.larus.bmhome.actionbar.model.z0) getItem(r4);
        Iterator<ss8.e> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        ss8.e r1 = r0.next();
        Intrinsics.checkNotNull(r5);
        if (r1.h(r5) == false) goto L4;
        return r1.hashCode() + 100;
    L9:
        Integer r6 = r5.f;
        if (r6 == null) goto L13;
        return r6.intValue();
    L13:
        return ActionBarDisplayType.NORMAL.getValue();
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        BaseActionBarHolder r3 = (BaseActionBarHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(r3);
        r3.T3();
    }

    public final void y2(List<? extends ss8.e> r7) {
        Intrinsics.checkNotNullParameter(r7, "runtimeSegments");
        List<ss8.e> r0 = this.d;
        if (TypeIntrinsics.isMutableList(r0) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        CollectionsKt.removeAll(r0, new r1());
        Iterator<T> r8 = r7.iterator();
    L10:
        if (r8.hasNext() == false) goto L24;
        ss8.e r1 = (ss8.e) r8.next();
        List<ss8.e> r2 = r0;
        boolean r4 = true;
        if ((r2 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r3 = r2.iterator();
    L18:
        if (r3.hasNext() == false) goto L22;
        if (Intrinsics.areEqual(((ss8.e) r3.next()).getClass(), r1.getClass()) == false) goto L18;
        r4 = false;
    L22:
        if (r4 == false) goto L10;
        r0.add(r1);
        goto L10
    L14:
        if (r2.isEmpty() == false) goto L16;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        BaseActionBarHolder r7 = (BaseActionBarHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        if (this.h == true) goto L5;
        this.h = true;
        final View r0 = ((RecyclerView.ViewHolder) r7).itemView;
        r0.post(new q1(r0));
    L5:
        com.larus.bmhome.actionbar.model.z0 r1 = (com.larus.bmhome.actionbar.model.z0) getItem(r6);
        Iterator<ss8.e> r2 = this.d.iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        ss8.e r3 = r2.next();
        Intrinsics.checkNotNull(r1);
        if (r3.h(r1) == false) goto L7;
        r3.e(r7, r1, r6);
        return;
    L12:
        if (getItemViewType(r6) != ActionBarDisplayType.SWITCH.getValue()) goto L20;
        if ((r7 instanceof CustomActionBarSwitchHolder) == false) goto L16;
        CustomActionBarSwitchHolder r8 = (CustomActionBarSwitchHolder) r7;
    L17:
        if (r8 == null) goto L30;
        int r9 = CustomActionBarSwitchHolder.k;
        r8.U3(r1, null);
        return;
    L30:
        return;
    L16:
        r8 = null;
        goto L17
    L20:
        if ((r7 instanceof CustomActionBarNormalHolder) == false) goto L22;
        CustomActionBarNormalHolder r10 = (CustomActionBarNormalHolder) r7;
    L23:
        if (r10 == null) goto L32;
        int r11 = CustomActionBarNormalHolder.v;
        r10.V3(r1, null);
        return;
    L32:
        return;
    L22:
        r10 = null;
        goto L23
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r14, int r15) {
        Intrinsics.checkNotNullParameter(r14, "parent");
        Iterator<ss8.e> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        ss8.e r1 = r0.next();
        if (r15 != (r1.hashCode() + 100)) goto L4;
        return r1.f(r14, this.b, this.c);
    L9:
        if (r15 != ActionBarDisplayType.SWITCH.getValue()) goto L23;
        RoundConstraintLayout r16 = LayoutInflater.from(r14.getContext()).inflate(2131562534, r14, false);
        int r17 = 2131374692;
        if (ViewBindings.findChildViewById(r16, 2131374692) == null) goto L22;
        r17 = 2131376335;
        if (ViewBindings.findChildViewById(r16, 2131376335) == null) goto L22;
        r17 = 2131387153;
        if (((ActionBarSwitch) ViewBindings.findChildViewById(r16, 2131387153)) == null) goto L22;
        r17 = 2131390830;
        if (ViewBindings.findChildViewById(r16, 2131390830) == null) goto L22;
        r17 = 2131390835;
        if (((TextView) ViewBindings.findChildViewById(r16, 2131390835)) == null) goto L22;
        return new CustomActionBarSwitchHolder(r16, this.a, this.b, this.c, false, 16);
    L22:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r17)));
    L23:
        o37.c.e.getClass();
        n r2 = null;
        if (o37.c.f("action_bar_normal_holder_nita") == true) goto L26;
    L82:
        LarusChatItemCustomActionbarNormalHolderBinding r18 = null;
    L83:
        if (r18 != null) goto L85;
        r18 = LarusChatItemCustomActionbarNormalHolderBinding.b(LayoutInflater.from(r14.getContext()), r14);
    L85:
        nda.d.a().na(new TextView[]{r18.c, r18.d});
        RoundConstraintLayout r5 = r18.a;
        ChatParam r6 = this.a;
        t1 r7 = this.b;
        boolean r8 = this.c;
        x2 r19 = this.e;
        if ((r19 instanceof n) == false) goto L89;
        r2 = (n) r19;
    L89:
        return new CustomActionBarNormalHolder(r5, r6, r7, r8, false, r2, this.g, 16);
    L26:
        if (com.larus.platform.exp.a.e == false) goto L82;
        q37.a r3 = q37.a.i;
        r3.getClass();
        HashMap r4 = (HashMap) q37.a.b.get("action_bar_normal_holder_nita");
        if (r4 == null) goto L45;
        monitor-enter(r4);
        SparseArray r110 = (SparseArray) r4.get(Integer.valueOf(r3.f("action_bar_normal_holder_nita", null, false)));     // Catch: Throwable -> L42
        if (r110 == null) goto L36;
        List r111 = (List) r110.get(2131561884);     // Catch: Throwable -> L42
        if (r111 == null) goto L36;
        int r112 = r111.size();     // Catch: Throwable -> L42
    L37:
        if (r112 == 0) goto L39;
        boolean r113 = true;
    L40:
        monitor-exit(r4);
    L46:
        if (r113 == false) goto L82;
        Context r114 = r14.getContext();     // Catch: Throwable -> L80
    L49:
        if ((r114 instanceof ContextWrapper) == false) goto L58;
        if ((r114 instanceof Activity) == true) goto L52;
        Context r9 = ((ContextWrapper) r114).getBaseContext();     // Catch: Throwable -> L80
        if (r9 == r114) goto L60;
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L80
        r114 = r9;
    L60:
        Activity r115 = null;
    L61:
        if (r115 != null) goto L66;
        Function0<Activity> r116 = this.f;     // Catch: Throwable -> L80
        if (r116 == null) goto L65;
        r115 = (Activity) r116.invoke();     // Catch: Throwable -> L80
        goto L66
    L65:
        r115 = null;
    L66:
        if (r115 == null) goto L82;
        if (r115.isFinishing() == false) goto L70;
    L73:
        boolean r10 = true;
    L74:
        if (r10 == false) goto L77;
        r115 = null;
    L77:
        if (r115 == null) goto L82;
        o37.c.e.getClass();     // Catch: Throwable -> L80
        View r117 = o37.c.e("action_bar_normal_holder_nita").i(2131561884, r115, true);     // Catch: Throwable -> L80
        r117.setLayoutParams(new RecyclerView.LayoutParams(r117.getLayoutParams()));     // Catch: Throwable -> L80
        r18 = LarusChatItemCustomActionbarNormalHolderBinding.a(r117);     // Catch: Throwable -> L80
        goto L83
    L70:
        if (r115.isDestroyed() == true) goto L73;
        r10 = false;
        goto L74
    L52:
        r115 = (Activity) r114;     // Catch: Throwable -> L80
        goto L61
    L58:
        if ((r114 instanceof Activity) == false) goto L60;
        r115 = (Activity) r114;     // Catch: Throwable -> L80
    L80:
        th = move-exception;
        FLogger.a.e("CustomActionBarAdapter", "get preloaded normal holder failed: " + th.getMessage());
        goto L82
    L39:
        r113 = false;
    L36:
        r112 = 0;
    L42:
        th = move-exception;
        throw th;
    L45:
        r113 = false;
        goto L46
    }

    public CustomActionBarAdapter(ChatParam r3, t1 r4, boolean r5, final List r6, x2 r7, v r8, int r9) {
        if ((r9 & 64) == 0) goto L5;
        r8 = null;
    L5:
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r6, "segmentFactory");
        Intrinsics.checkNotNullParameter(r7, "actionBarShowTipCache");
        Intrinsics.checkNotNullParameter(r6, "segmentFactory");
        super(new CustomActionBarAdapter$Companion$differCallback$1(r6));
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = null;
        this.g = r8;
    }
}
