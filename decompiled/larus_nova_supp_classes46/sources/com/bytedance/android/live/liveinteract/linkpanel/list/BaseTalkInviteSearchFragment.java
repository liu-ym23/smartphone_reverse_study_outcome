package com.bytedance.android.live.liveinteract.linkpanel.list;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteSearchContract$View;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.utils.t2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/list/BaseTalkInviteSearchFragment;", "Lcom/bytedance/android/live/liveinteract/linkpanel/contract/BaseTalkInviteSearchContract$View;", "<init>", "()V", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public class BaseTalkInviteSearchFragment extends BaseTalkInviteSearchContract$View {
    public IRoom g;
    public RecyclerView h;
    public EditText i;
    public ImageView j;
    public TextView k;
    public MultiTypeAdapter l;
    public final LinkedList<Object> m;

    public static final class a implements TextWatcher {
        public final /* synthetic */ BaseTalkInviteSearchFragment a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public a(BaseTalkInviteSearchFragment r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            if (TextUtils.isEmpty(r1) == false) goto L7;
            TextView r5 = this.a.k;
            if (r5 == null) goto L11;
            r5.setVisibility(0);
            return;
        L11:
            return;
        L7:
            TextView r6 = this.a.k;
            if (r6 == null) goto L13;
            r6.setVisibility(8);
            return;
        }
    }

    public static final class b implements View.OnKeyListener {
        public final /* synthetic */ BaseTalkInviteSearchFragment a;

        public b(BaseTalkInviteSearchFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View r1, int r2, KeyEvent r3) {
            if (r2 != 66) goto L12;
            if (r3 != null) goto L6;
        L7:
            BaseTalkInviteSearchFragment r4 = this.a;
            EditText r5 = r4.i;
            if (r5 == null) goto L14;
            yf0.d r6 = (yf0.d) r4.f;
            r5.getText().toString();
            r6.d();
            return false;
        L14:
            return false;
        L6:
            if (r3.getAction() != 1) goto L7;
            return false;
        L12:
            return false;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ BaseTalkInviteSearchFragment a;

        public c(BaseTalkInviteSearchFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.m.clear();
            MultiTypeAdapter r3 = this.a.l;
            if (r3 == null) goto L5;
            r3.notifyDataSetChanged();
        L5:
            EditText r4 = this.a.i;
            if (r4 == null) goto L9;
            r4.setText("");
            return;
        }
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final float T90() {
        return 432.0f;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final String W90() {
        return "";
    }

    public BaseTalkInviteSearchFragment() {
        this.m = new LinkedList();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        t2.a(getContext(), this.i);
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Room r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        this.g = r3;
        if (r3 == null) goto L5;
        String r4 = r3.getOwnerUserIdString();
    L6:
        Intrinsics.areEqual(r4, jc1.k.n(IMiddlewareUserService.class).user().n());
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        LinearLayout r4 = (LinearLayout) r2.findViewById(2131371744);
        this.h = r2.findViewById(2131384076);
        this.i = (EditText) r2.findViewById(2131375615);
        TextView r5 = (TextView) r2.findViewById(2131366984);
        this.j = (ImageView) r2.findViewById(2131366942);
        LinearLayout r6 = (LinearLayout) r2.findViewById(2131371557);
        this.k = (TextView) r2.findViewById(2131374381);
        MultiTypeAdapter r7 = new MultiTypeAdapter();
        this.l = r7;
        RecyclerView r8 = this.h;
        if (r8 == null) goto L5;
        r8.setAdapter(r7);
    L5:
        RecyclerView r9 = this.h;
        if (r9 == null) goto L8;
        r9.setLayoutManager(new LinearLayoutManager(getContext()));
    L8:
        MultiTypeAdapter r10 = this.l;
        if (r10 == null) goto L11;
        r10.A2(this.m);
    L11:
        EditText r11 = this.i;
        if (r11 == null) goto L14;
        r11.addTextChangedListener(new a(this));
    L14:
        EditText r12 = this.i;
        if (r12 == null) goto L17;
        r12.setOnKeyListener(new b(this));
    L17:
        ImageView r13 = this.j;
        if (r13 == null) goto L21;
        r13.setOnClickListener(new c(this));
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565515, r3, false);
    }
}
