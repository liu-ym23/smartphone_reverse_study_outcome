package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/RoomModeFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "a", "RoomMode", "RoomModeAdapter", "b", "RoomModeItemViewHolder", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomModeFragment extends BaseFragment {
    public static final /* synthetic */ int g = 0;
    public RecyclerView d;
    public final Lazy e;
    public final Lazy f;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/RoomModeFragment$RoomMode;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "AUDIO_CHAT_ROOM", "RADIO", "KTV", "CHORUS", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum RoomMode extends Enum<RoomMode> {
        public static final RoomMode AUDIO_CHAT_ROOM = null;
        public static final RoomMode CHORUS = null;
        public static final RoomMode KTV = null;
        public static final RoomMode RADIO = null;
        public static final /* synthetic */ RoomMode[] a = null;
        private final String value;

        static {
            RoomMode r1 = new RoomMode("AUDIO_CHAT_ROOM", 0, PbRequest.SwitchType.ROOM);
            AUDIO_CHAT_ROOM = r1;
            RoomMode r2 = new RoomMode("RADIO", 1, "radio");
            RADIO = r2;
            RoomMode r3 = new RoomMode("KTV", 2, "ktv");
            KTV = r3;
            RoomMode r4 = new RoomMode("CHORUS", 3, "chorus");
            CHORUS = r4;
            a = new RoomMode[]{r1, r2, r3, r4};
        }

        public static RoomMode valueOf(String r1) {
            return (RoomMode) r27.a.a(RoomMode.class, r1);
        }

        public static RoomMode[] values() {
            return (RoomMode[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public RoomMode(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/RoomModeFragment$RoomModeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/RoomModeFragment$RoomModeItemViewHolder;", "Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/RoomModeFragment;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class RoomModeAdapter extends RecyclerView.Adapter<RoomModeItemViewHolder> {
        public final List<b> a;
        public final /* synthetic */ RoomModeFragment b;

        public final int getItemCount() {
            return this.a.size();
        }

        public RoomModeAdapter(RoomModeFragment r2, List<b> r3) {
            Intrinsics.checkNotNullParameter(r3, "roomModeList");
            this.b = r2;
            this.a = r3;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
            RoomModeItemViewHolder r5 = (RoomModeItemViewHolder) r3;
            Intrinsics.checkNotNullParameter(r5, "holder");
            r5.a = ((b) ListProtector.get(this.a, r4)).e;
            ImageView r0 = r5.c;
            if (r0 == null) goto L5;
            r0.setImageResource(((b) ListProtector.get(this.a, r4)).a);
        L5:
            View r1 = r5.b;
            if (r1 == null) goto L8;
            r1.setBackgroundResource(((b) ListProtector.get(this.a, r4)).b);
        L8:
            TextView r2 = r5.d;
            if (r2 == null) goto L11;
            r2.setText(((b) ListProtector.get(this.a, r4)).c);
        L11:
            TextView r6 = r5.e;
            if (r6 == null) goto L14;
            r6.setText(((b) ListProtector.get(this.a, r4)).d);
        L14:
            RoomModeFragment r7 = this.b;
            int r8 = RoomModeFragment.g;
            if (((RoomMode) r7.e.getValue()) != r5.a) goto L20;
            View r9 = r5.b;
            if (r9 == null) goto L21;
            r9.setSelected(true);
            return;
        L21:
            return;
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            View r5 = LayoutInflater.from(r3.getContext()).inflate(2131566393, r3, false);
            return new RoomModeItemViewHolder(this.b, r5);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/RoomModeFragment$RoomModeItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class RoomModeItemViewHolder extends RecyclerView.ViewHolder {
        public RoomMode a;
        public final View b;
        public final ImageView c;
        public final TextView d;
        public final TextView e;
        public final /* synthetic */ RoomModeFragment f;

        public RoomModeItemViewHolder(RoomModeFragment r4, View r5) {
            Intrinsics.checkNotNullParameter(r5, "itemView");
            this.f = r4;
            super(r5);
            View r6 = r5.findViewById(2131384778);
            this.b = r6;
            this.c = (ImageView) r5.findViewById(2131384799);
            this.d = (TextView) r5.findViewById(2131384800);
            this.e = (TextView) r5.findViewById(2131384798);
            if (r6 == null) goto L6;
            r6.setOnClickListener(new com.bytedance.android.livesdk.utils.w0(new AnonymousClass1(this), 500));
            return;
        }
    }

    public static final class a {
    }

    public final class b {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final RoomMode e;

        public b(int r2, int r3, int r4, int r5, RoomMode r6) {
            Intrinsics.checkNotNullParameter(r6, "mode");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    static {
    }

    public RoomModeFragment() {
        this.e = LazyKt.lazy(new RoomModeFragment$currentRoomMode$2(this));
        this.f = LazyKt.lazy(new RoomModeFragment$roomModeList$2(this));
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        RecyclerView r5 = r3.findViewById(2131385000);
        this.d = r5;
        if (r5 == null) goto L5;
        r5.setAdapter(new RoomModeAdapter(this, (List) this.f.getValue()));
    L5:
        RecyclerView r6 = this.d;
        if (r6 == null) goto L8;
        r6.setLayoutManager(new GridLayoutManager(getContext(), 2));
    L8:
        RecyclerView r7 = this.d;
        if (r7 == null) goto L12;
        r7.addItemDecoration(new AnonymousClass1());
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566066, r3, false);
    }
}
