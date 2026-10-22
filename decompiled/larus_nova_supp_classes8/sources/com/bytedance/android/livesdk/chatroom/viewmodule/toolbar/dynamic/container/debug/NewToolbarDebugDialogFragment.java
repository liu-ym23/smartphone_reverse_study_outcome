package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.debug;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.ContainerContextEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdkapi.api.IUtilsCommonService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zo1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/container/debug/NewToolbarDebugDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "toolbarservice-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewToolbarDebugDialogFragment extends DialogFragment {
    public static final /* synthetic */ int f = 0;
    public Map<Integer, View> d;
    public ContainerContextEnv e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ NewToolbarDebugDialogFragment a;

        public a(NewToolbarDebugDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            NewToolbarDebugDialogFragment r3 = this.a;
            int r0 = NewToolbarDebugDialogFragment.f;
            r3.T90();
        }
    }

    public final void T90() {
        ContainerContextEnv r0 = this.e;
        if (r0 == null) goto L9;
        f<s> r1 = r0.e;
        if (r1 == null) goto L9;
        List<s> r2 = r1.b("showing");
        if (r2 == null) goto L9;
        ((TextView) S90(2131391430)).setText(CollectionsKt.joinToString$default(r2, null, "[", "]", 0, null, NewToolbarDebugDialogFragment$buttonsString$1.INSTANCE, 25, null));
    L9:
        ContainerContextEnv r3 = this.e;
        if (r3 == null) goto L16;
        f<s> r4 = r3.e;
        if (r4 == null) goto L16;
        List<s> r5 = r4.b("ready");
        if (r5 == null) goto L16;
        ((TextView) S90(2131391712)).setText(CollectionsKt.joinToString$default(r5, null, "[", "]", 0, null, NewToolbarDebugDialogFragment$buttonsString$1.INSTANCE, 25, null));
    L16:
        k.n(IUtilsCommonService.class).showCenterToast("Bingo！");
    }

    public NewToolbarDebugDialogFragment() {
        this.d = new LinkedHashMap();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        T90();
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

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        ((Button) S90(2131364867)).setOnClickListener(new a(this));
        TextView r4 = (TextView) S90(2131388510);
        String r5 = getTag();
        if (r5 != null) goto L6;
        r5 = "{nil}";
    L6:
        r4.setText(r5);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566044, r3, false);
    }
}
