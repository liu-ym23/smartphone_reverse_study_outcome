package com.larus.bmhome.view.actionbar.custom.actionbarpanel;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.instruction.core.model.ActionBarDisplayType;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.bmhome.view.actionbar.custom.ActionBarSwitch;
import com.larus.bmhome.view.actionbar.custom.CustomActionBar;
import com.larus.bmhome.view.actionbar.custom.CustomActionBarNormalHolder;
import com.larus.bmhome.view.actionbar.custom.CustomActionBarSwitchHolder;
import com.larus.bmhome.view.actionbar.custom.t1;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.c7;
import vs8.c;
import vs8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 22\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00012B\u0019\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u000fH\u0016J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000fH\u0016J\u0018\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u000fH\u0016J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\u0016J\u0018\u0010)\u001a\u00020\u00102\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010+H\u0016J\u0018\u0010,\u001a\u00020\u00102\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010+H\u0002J\u0018\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u000fH\u0016J\f\u00100\u001a\u0006\u0012\u0002\b\u000301H\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00063"}, d2 = {"Lcom/larus/bmhome/view/actionbar/custom/actionbarpanel/CustomActionBarPanelAdapterImpl;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "Lcom/larus/bmhome/view/actionbar/BaseActionBarHolder;", "Lcom/larus/bmhome/view/actionbar/custom/actionbarpanel/CustomActionBarPanelAdapter;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "callback", "Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;", "<init>", "(Lcom/larus/bmhome/chat/ChatParam;Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;)V", "getChatParam", "()Lcom/larus/bmhome/chat/ChatParam;", "updateAddMoreWidthCallback", "Lkotlin/Function1;", "", "", "getUpdateAddMoreWidthCallback", "()Lkotlin/jvm/functions/Function1;", "setUpdateAddMoreWidthCallback", "(Lkotlin/jvm/functions/Function1;)V", "itemWidth", "addMoreWidth", "getAddMoreWidth", "()I", "setAddMoreWidth", "(I)V", "items", "", "getItems", "()Ljava/util/List;", "setItemWidth", "width", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemViewType", "submitList", "list", "", "checkItemWidth", "itemMoved", "fromPosition", "toPosition", "asAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomActionBarPanelAdapterImpl extends ListAdapter<z0, BaseActionBarHolder> implements d {
    public static final CustomActionBarPanelAdapterImpl$Companion$DIFF_CALLBACK$1 g = null;
    public final ChatParam a;
    public final t1 b;
    public Function1<? super Integer, Unit> c;
    public int d;
    public int e;
    public final List<z0> f;

    public static final class a {
    }

    @Override // vs8.d
    public final RecyclerView.Adapter<?> e() {
        return this;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.view.actionbar.custom.actionbarpanel.CustomActionBarPanelAdapterImpl$Companion$DIFF_CALLBACK$1] */
    static {
        g = new CustomActionBarPanelAdapterImpl$Companion$DIFF_CALLBACK$1();
    }

    @Override // vs8.d
    public final int f0() {
        return this.e;
    }

    @Override // vs8.d
    public final void I0(int r1) {
        this.d = r1;
    }

    public final int getItemViewType(int r1) {
        Integer r2 = ((z0) getItem(r1)).f;
        if (r2 == null) goto L6;
        return r2.intValue();
    L6:
        return ActionBarDisplayType.NORMAL.getValue();
    }

    @Override // vs8.d
    public final void r0(c r1) {
        this.c = r1;
    }

    public final void submitList(List<z0> r12) {
        ((ArrayList) this.f).clear();
        if (r12 == null) goto L6;
        ((ArrayList) this.f).addAll(r12);
    L6:
        if (r12 == null) goto L37;
        Iterator<T> r13 = r12.iterator();
        if (r13.hasNext() == true) goto L10;
        Object r14 = null;
    L30:
        z0 r15 = (z0) r14;
        if (r15 == null) goto L37;
        String r1 = r15.e;
        if (r1 == null) goto L37;
        String r16 = StringsKt.replace$default(r1, " ", "", false, 4, null);
        if (r16 == null) goto L37;
        int r17 = r16.length();
    L38:
        FLogger.a.d("ActionBarPanelAdapter", "updateSpanCount: maxNameSize:" + r17);
        if (r17 <= 4) goto L43;
        int r18 = c7.b(Integer.valueOf((r17 - 4) * 14));
        this.e = r18;
        Function1<? super Integer, Unit> r0 = this.c;
        if (r0 == null) goto L46;
        r0.invoke(Integer.valueOf(r18));
    L46:
        super.submitList(this.f);
        return;
    L43:
        this.e = 0;
        Function1<? super Integer, Unit> r19 = this.c;
        if (r19 == null) goto L46;
        r19.invoke(0);
        goto L46
    L10:
        Object r2 = r13.next();
        if (r13.hasNext() == true) goto L13;
    L12:
        r14 = r2;
        goto L30
    L13:
        String r3 = ((z0) r2).e;
        if (r3 == null) goto L18;
        String r4 = StringsKt.replace$default(r3, " ", "", false, 4, null);
        if (r4 == null) goto L18;
        int r5 = r4.length();
    L19:
        Object r6 = r13.next();
        String r7 = ((z0) r6).e;
        if (r7 == null) goto L24;
        String r8 = StringsKt.replace$default(r7, " ", "", false, 4, null);
        if (r8 == null) goto L24;
        int r9 = r8.length();
    L25:
        if (r5 >= r9) goto L28;
        r2 = r6;
        r5 = r9;
    L28:
        if (r13.hasNext() == true) goto L19;
    L24:
        r9 = 0;
    L18:
        r5 = 0;
    L37:
        r17 = 0;
        goto L38
    }

    public CustomActionBarPanelAdapterImpl(ChatParam r2, CustomActionBar.e r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(g);
        this.a = r2;
        this.b = r3;
        this.d = c7.b(106);
        this.f = new ArrayList();
    }

    @Override // vs8.e
    public final void H1(int r3, int r4) {
        z0 r0 = (z0) ListProtector.remove(this.f, r3);
        ListProtector.add(this.f, r4, r0);
        notifyItemMoved(r3, r4);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        BaseActionBarHolder r6 = (BaseActionBarHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        FLogger.a.i("ActionBarPanelAdapter", "onBindViewHolder position:" + r5);
        z0 r0 = (z0) getItem(r5);
        CustomActionBarNormalHolder r2 = null;
        CustomActionBarSwitchHolder r3 = null;
        if (getItemViewType(r5) != ActionBarDisplayType.SWITCH.getValue()) goto L10;
        if ((r6 instanceof CustomActionBarSwitchHolder) == false) goto L7;
        r3 = (CustomActionBarSwitchHolder) r6;
    L7:
        if (r3 == null) goto L15;
        r3.U3(r0, Integer.valueOf(this.d));
        return;
    L15:
        return;
    L10:
        if ((r6 instanceof CustomActionBarNormalHolder) == false) goto L12;
        r2 = (CustomActionBarNormalHolder) r6;
    L12:
        if (r2 == null) goto L17;
        r2.V3(r0, Integer.valueOf(this.d));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        int r1 = 2131374692;
        if (r11 != ActionBarDisplayType.SWITCH.getValue()) goto L20;
        RoundConstraintLayout r12 = LayoutInflater.from(r10.getContext()).inflate(2131562533, r10, false);
        if (ViewBindings.findChildViewById(r12, 2131374692) == null) goto L19;
        if (ViewBindings.findChildViewById(r12, 2131376335) == null) goto L17;
        r1 = 2131387153;
        if (((ActionBarSwitch) ViewBindings.findChildViewById(r12, 2131387153)) == null) goto L19;
        if (ViewBindings.findChildViewById(r12, 2131390830) != null) goto L13;
        r1 = 2131390830;
        goto L19
    L13:
        if (((TextView) ViewBindings.findChildViewById(r12, 2131390835)) != null) goto L42;
        r1 = 2131390835;
        goto L19
    L42:
        return new CustomActionBarSwitchHolder(r12, this.a, this.b, false, true, 8);
    L17:
        r1 = 2131376335;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r1)));
    L20:
        RoundConstraintLayout r13 = LayoutInflater.from(r10.getContext()).inflate(2131562532, r10, false);
        if (ViewBindings.findChildViewById(r13, 2131367812) != null) goto L23;
        r1 = 2131367812;
    L41:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r1)));
    L23:
        if (ViewBindings.findChildViewById(r13, 2131374692) == null) goto L41;
        r1 = 2131374695;
        if (ViewBindings.findChildViewById(r13, 2131374695) == null) goto L41;
        if (ViewBindings.findChildViewById(r13, 2131376335) == null) goto L38;
        r1 = 2131378977;
        if (((ProgressBar) ViewBindings.findChildViewById(r13, 2131378977)) == null) goto L41;
        if (ViewBindings.findChildViewById(r13, 2131390830) != null) goto L33;
        r1 = 2131390830;
        goto L41
    L33:
        if (((TextView) ViewBindings.findChildViewById(r13, 2131390835)) != null) goto L35;
        r1 = 2131390835;
        goto L41
    L35:
        return new CustomActionBarNormalHolder(r13, this.a, this.b, false, true, null, null, 72);
    L38:
        r1 = 2131376335;
        goto L41
    }
}
