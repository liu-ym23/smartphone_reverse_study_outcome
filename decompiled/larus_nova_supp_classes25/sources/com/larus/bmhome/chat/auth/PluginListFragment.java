package com.larus.bmhome.chat.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.auth.model.PluginItem;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.markdown.memory.MemoryActionTag;
import com.larus.bmhome.databinding.LarusLayoutFragmentPluginListBinding;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\"\u001a\u00020 H\u0002J\u0010\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020 H\u0002J\b\u0010'\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larus/bmhome/chat/auth/PluginListFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/bmhome/databinding/LarusLayoutFragmentPluginListBinding;", "botId", "", "conversationId", "adapter", "Lcom/larus/bmhome/chat/auth/PluginListAdapter;", "getAdapter", "()Lcom/larus/bmhome/chat/auth/PluginListAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager$delegate", "lastTrackPositions", "", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "updateCurrentList", "requestNextPage", MemoryActionTag.MEMORY_ACTION_TAG_UPDATE, "", "trackOnItemShow", "autoLogEnterPage", "getCurrentPageName", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class PluginListFragment extends TraceFragment {
    public static final /* synthetic */ int k = 0;
    public LarusLayoutFragmentPluginListBinding e;
    public String f;
    public String g;
    public final Lazy h;
    public final Lazy i;
    public final List<Integer> j;

    public final boolean S90() {
        return false;
    }

    public final String k() {
        return "plugin_management";
    }

    public final PluginListAdapter U90() {
        return (PluginListAdapter) this.h.getValue();
    }

    public final void V90() {
        PluginManagerDelegate r0 = PluginManagerDelegate.a;
        String r1 = this.f;
        Intrinsics.checkNotNullParameter(r1, "botId");
        ConcurrentHashMap<String, PluginManager> r2 = PluginManager.d;
        List r3 = CollectionsKt.toMutableList(PluginManager.a.a(r1).a.d);
        ListProtector.add(r3, 0, new PluginItem(null, null, null, null, null, null, null, null, 255, null));
        U90().submitList(r3);
    }

    public PluginListFragment() {
        this.f = "";
        this.g = "";
        this.h = LazyKt.lazy(new x(this));
        this.i = LazyKt.lazy(new y(this));
        this.j = new ArrayList();
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r5, r6);
        Bundle r7 = getArguments();
        String r0 = "";
        if (r7 == null) goto L5;
        String r8 = r7.getString("bot_id", "");
    L6:
        if (r8 != null) goto L8;
        r8 = "";
    L8:
        this.f = r8;
        Bundle r9 = getArguments();
        if (r9 == null) goto L11;
        String r10 = r9.getString("conversation_id", "");
    L12:
        if (r10 == null) goto L15;
        r0 = r10;
    L15:
        this.g = r0;
        hc8.a r11 = PluginManagerDelegate.a.f(this.f);
        String r1 = this.g;
        b r12 = (b) r11;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r1, "conversationId");
        Intrinsics.checkNotNullParameter("bot_setting", "previousPage");
        r12.d("plugin_management", "bot_setting", r1, r12.a);
        LarusLayoutFragmentPluginListBinding r13 = this.e;
        if (r13 == null) goto L20;
        RecyclerView r14 = r13.c;
        if (r14 == null) goto L20;
        r14.setLayoutManager((LinearLayoutManager) this.i.getValue());
        r14.setAdapter(U90());
    L20:
        V90();
        PluginManagerDelegate.r(this.f, true, null, new z(this));
        LarusLayoutFragmentPluginListBinding r15 = this.e;
        if (r15 == null) goto L25;
        RecyclerView r16 = r15.c;
        if (r16 == null) goto L25;
        r16.addOnScrollListener(new AnonymousClass2(this));
    L25:
        PluginListAdapter r17 = U90();
        Function1<? super PluginItem, Unit> r18 = new a0(this);
        r17.getClass();
        Intrinsics.checkNotNullParameter(r18, "listener");
        r17.b = r18;
        LarusLayoutFragmentPluginListBinding r19 = this.e;
        if (r19 == null) goto L31;
        AppCompatImageView r20 = r19.b;
        if (r20 == null) goto L32;
        e1.d(r20, new b0(this));
        return;
    L32:
        return;
    L31:
        return;
    L11:
        r10 = null;
        goto L12
    L5:
        r8 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        ConstraintLayout r6 = r3.inflate(2131562822, r4, false);
        int r7 = 2131366972;
        AppCompatImageView r8 = ViewBindings.findChildViewById(r6, 2131366972);
        if (r8 == null) goto L11;
        r7 = 2131384076;
        RecyclerView r0 = ViewBindings.findChildViewById(r6, 2131384076);
        if (r0 == null) goto L11;
        r7 = 2131388772;
        if (((TextView) ViewBindings.findChildViewById(r6, 2131388772)) == null) goto L11;
        ConstraintLayout r9 = r6;
        this.e = new LarusLayoutFragmentPluginListBinding(r9, r8, r0);
        return r9;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
