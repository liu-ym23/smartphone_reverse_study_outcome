package com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.f;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.depend.user.IContactActiveViewHolderWrapper;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.widget.TransparentCircleIconView;
import com.bytedance.android.uicomponent.compoundbutton.TranslucentCheckBox;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class InviteeUserItemViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/invite/adapter/InviteeUserItemViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public final TransparentCircleIconView a;
        public final TransparentCircleIconView b;
        public final ImageView c;
        public final TextView d;
        public final TranslucentCheckBox e;
        public IContactActiveViewHolderWrapper f;
        public com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter.a g;
        public a h;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ ItemViewHolder a;

            public a(ItemViewHolder r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r2) {
                TranslucentCheckBox r3 = this.a.e;
                r3.setChecked(!r3.isChecked());
            }
        }

        public static final class b implements CompoundButton.OnCheckedChangeListener {
            public final /* synthetic */ ItemViewHolder a;

            public b(ItemViewHolder r1) {
                this.a = r1;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton r2, boolean r3) {
                a r4 = this.a.h;
                if (r4 == null) goto L8;
                r4.b = r3;
                c r0 = r4.c;
                if (r0 == null) goto L9;
                r0.bl(r4, r3);
                return;
            L9:
                return;
            }
        }

        public ItemViewHolder(View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            super(r3);
            this.a = r3.findViewById(2131367709);
            this.b = r3.findViewById(2131367941);
            this.c = (ImageView) r3.findViewById(2131367708);
            this.d = (TextView) r3.findViewById(2131367719);
            TranslucentCheckBox r0 = r3.findViewById(2131367712);
            this.e = r0;
            r3.setOnClickListener(new a(this));
            r0.setOnCheckedChangeListener(new b(this));
        }
    }

    public static final class a extends b {
        public final Fragment d;

        public a(f r2, c r3, WidgetManager r4) {
            Intrinsics.checkNotNullParameter(r2, "contact");
            super(r2, false, r3);
            this.d = r4;
        }
    }

    public InviteeUserItemViewBinder() {
    }

    public final void b(RecyclerView.ViewHolder r4, Object r5) {
        final ItemViewHolder r6 = (ItemViewHolder) r4;
        final a r7 = (a) r5;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "item");
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "item");
        r6.h = r7;
        r7.a.getClass();
        r6.a.setVisibility(8);
        r6.b.setVisibility(0);
        TransparentCircleIconView r0 = r6.b;
        r7.a.getClass();
        ImageLoader.bindImage(r0, null);
        TextView r1 = r6.d;
        r7.a.getClass();
        r1.setText(null);
        r6.e.setChecked(r7.b);
        if (r6.f != null) goto L8;
        Fragment r2 = r7.d;
        if (r2 == null) goto L8;
        r6.f = TTLiveSDK.hostService().user().createIContactActiveViewHolder(r2, r6.c);
        Unit r3 = Unit.INSTANCE;
    L8:
        if (r6.g != null) goto L10;
        r6.g = new com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter.a(r6);
        Unit r8 = Unit.INSTANCE;
    L10:
        IContactActiveViewHolderWrapper r9 = r6.f;
        if (r9 == null) goto L13;
        r9.observeAndUpdateActiveStatus(r7.a, r6.g);
    L13:
        r3.e(((RecyclerView.ViewHolder) r6).itemView, new InviteeUserItemViewBinder$ItemViewHolder$bindItem$3(r6, r7));
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        int r1 = 0;
        View r6 = r4.inflate(2131566303, r5, false);
        if ((r6 instanceof ViewGroup) == false) goto L8;
        ViewGroup r7 = (ViewGroup) r6;
        int r0 = r7.getChildCount();
    L5:
        if (r1 >= r0) goto L8;
        r3.k(r7.getChildAt(r1));
        r1 = r1 + 1;
    L8:
        return new ItemViewHolder(r6);
    }
}
