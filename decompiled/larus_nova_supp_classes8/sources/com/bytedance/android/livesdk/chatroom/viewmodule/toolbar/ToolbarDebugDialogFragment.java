package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.livesdkapi.api.IUtilsCommonService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ToolbarDebugDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarDebugDialogFragment extends DialogFragment {
    public static final /* synthetic */ int f = 0;
    public Map<Integer, View> d;
    public com.bytedance.android.livesdk.chatroom.utils.c0 e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ToolbarDebugDialogFragment a;

        public a(ToolbarDebugDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ToolbarDebugDialogFragment r3 = this.a;
            int r0 = ToolbarDebugDialogFragment.f;
            r3.U90();
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ToolbarDebugDialogFragment a;

        public b(ToolbarDebugDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            if (((Spinner) this.a.S90(2131387110)).getSelectedItemId() != 0) goto L5;
            char r6 = 0;
        L6:
            Object r0 = ((Spinner) this.a.S90(2131387108)).getSelectedItem();
            ExtendedToolbarButton r2 = null;
            if ((r0 instanceof Map) == true) goto L9;
            r0 = null;
        L9:
            Map r1 = (Map) r0;
            if (r1 == null) goto L14;
            Collection r3 = r1.values();
            if (r3 == null) goto L14;
            Object r4 = CollectionsKt.firstOrNull(r3);
        L16:
            if ((r4 instanceof String) == true) goto L18;
            r4 = null;
        L18:
            ToolbarButton r7 = ToolbarButton.fromName((String) r4);
            if (r7 == null) goto L21;
            r2 = r7.extended();
        L21:
            if (r2 != null) goto L24;
            jc1.k.n(IUtilsCommonService.class).showCenterToast("Illegal Argument Exception");
            return;
        L24:
            x3 r8 = y3.l();
            if (r8 == null) goto L36;
            if (r8.s(r2) != null) goto L30;
            jc1.k.n(IUtilsCommonService.class).showCenterToast(r2.f() + " not loaded yet");
            return;
        L30:
            if (r6 != 0) goto L32;
            r8.c(r2);
        L33:
            this.a.U90();
            return;
        L32:
            r8.i(r2);
            goto L33
        L36:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
        L14:
            r4 = null;
            goto L16
        L5:
            r6 = '\b';
            goto L6
        }
    }

    public final void U90() {
        com.bytedance.android.livesdk.chatroom.utils.c0 r1 = this.e;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mutexHelper");
    L5:
        Set<ExtendedToolbarButton> r2 = r1.c().keySet();
        TextView r3 = (TextView) S90(2131391430);
        ToolbarDebugDialogFragment$buttonsString$1 r17 = ToolbarDebugDialogFragment$buttonsString$1.INSTANCE;
        r3.setText(CollectionsKt.joinToString$default(r2, null, "[", "]", 0, null, r17, 25, null));
        TextView r4 = (TextView) S90(2131391712);
        com.bytedance.android.livesdk.chatroom.utils.c0 r5 = this.e;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mutexHelper");
    L8:
        r4.setText(CollectionsKt.joinToString$default(CollectionsKt.subtract(r5.g().keySet(), r2), null, "[", "]", 0, null, r17, 25, null));
        jc1.k.n(IUtilsCommonService.class).showCenterToast("Bingo！");
    }

    public ToolbarDebugDialogFragment() {
        this.d = new LinkedHashMap();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        U90();
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final SimpleAdapter T90(Collection<String> r8) {
        Context r1 = requireContext();
        Collection<String> r9 = r8;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        r2.add(MapsKt.mapOf(TuplesKt.to("item", (String) r10.next())));
        goto L4
    L7:
        return new SimpleAdapter(r1, r2, R.layout.simple_list_item_1, new String[]{"item"}, new int[]{R.id.text1});
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        ((Button) S90(2131364867)).setOnClickListener(new a(this));
        ((Button) S90(2131364866)).setOnClickListener(new b(this));
        Spinner r4 = (Spinner) S90(2131387108);
        com.bytedance.android.livesdk.chatroom.utils.c0 r5 = this.e;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mutexHelper");
    L5:
        r4.setAdapter(T90(((LinkedHashMap) r5.e().a).keySet()));
        ((Spinner) S90(2131387110)).setAdapter(T90(CollectionsKt.listOf(new String[]{"VISIBLE", "GONE"})));
        TextView r6 = (TextView) S90(2131388510);
        String r7 = getTag();
        if (r7 != null) goto L9;
        r7 = "{nil}";
    L9:
        r6.setText(r7);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (this.e != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mutexHelper");
    L6:
        return r2.inflate(2131566043, r3, false);
    }
}
