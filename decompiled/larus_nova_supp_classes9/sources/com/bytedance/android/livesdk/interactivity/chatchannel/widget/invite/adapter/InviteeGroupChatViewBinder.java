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
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class InviteeGroupChatViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/invite/adapter/InviteeGroupChatViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public final TransparentCircleIconView a;
        public final TextView b;
        public final ImageView c;
        public final TranslucentCheckBox d;
        public a e;
        public IContactActiveViewHolderWrapper f;
        public final Lazy g;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ ItemViewHolder a;

            public a(ItemViewHolder r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r2) {
                TranslucentCheckBox r3 = this.a.d;
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
                a r4 = this.a.e;
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

        public ItemViewHolder(View r5) {
            Intrinsics.checkNotNullParameter(r5, "itemView");
            super(r5);
            this.a = r5.findViewById(2131373927);
            this.b = (TextView) r5.findViewById(2131373984);
            this.c = (ImageView) r5.findViewById(2131373917);
            TranslucentCheckBox r0 = r5.findViewById(2131373935);
            this.d = r0;
            this.g = LazyKt.lazy(new InviteeGroupChatViewBinder$ItemViewHolder$activeCallback$2(this));
            r5.setOnClickListener(new a(this));
            r0.setOnCheckedChangeListener(new b(this));
            if ((r5 instanceof ViewGroup) == false) goto L7;
            ViewGroup r1 = (ViewGroup) r5;
            int r2 = r1.getChildCount();
            int r3 = 0;
        L5:
            if (r3 >= r2) goto L7;
            r3.k(r1.getChildAt(r3));
            r3 = r3 + 1;
        L7:
            r3.e(r5, new AnonymousClass3(this));
        }
    }

    public static final class a extends b {
        public final Fragment d;

        public a(f r2, c r3, WidgetManager r4) {
            Intrinsics.checkNotNullParameter(r2, "contact");
            super(r2, true, r3);
            this.d = r4;
        }
    }

    public InviteeGroupChatViewBinder() {
    }

    public final void b(RecyclerView.ViewHolder r4, Object r5) {
        ItemViewHolder r6 = (ItemViewHolder) r4;
        a r7 = (a) r5;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "groupChat");
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "groupChat");
        r6.e = r7;
        f r0 = r7.a;
        TransparentCircleIconView r1 = r6.a;
        r0.getClass();
        ImageLoader.bindImage(r1, null);
        r6.b.setText(null);
        r6.d.setChecked(r7.b);
        if (r6.f != null) goto L7;
        Fragment r8 = r7.d;
        if (r8 == null) goto L7;
        r6.f = TTLiveSDK.hostService().user().createIContactActiveViewHolder(r8, r6.c);
        Unit r9 = Unit.INSTANCE;
    L7:
        IContactActiveViewHolderWrapper r10 = r6.f;
        if (r10 == null) goto L11;
        r10.observeAndUpdateActiveStatus(r0, (IContactActiveViewHolderWrapper.IContactActiveCallback) r6.g.getValue());
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new ItemViewHolder(r4.inflate(2131566302, r5, false));
    }
}
