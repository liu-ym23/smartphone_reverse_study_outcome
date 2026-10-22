package com.bytedance.android.livesdk.interactivity.publicscreen.viewholder;

import am2.x;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.message.d4;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l;
import com.bytedance.android.livesdk.interactivity.textmessage.model.c0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import g52.e;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/viewholder/RoomNoticeViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/ui/MessageViewHolder;", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomNoticeViewHolder extends MessageViewHolder {
    public static final /* synthetic */ int d = 0;
    public final boolean b;
    public final e52.a c;

    public static final class a {
        @JvmStatic
        public static void a(d4 r5, View r6, boolean r7, e r8, boolean r9) {
            Intrinsics.checkNotNullParameter(r5, "data");
            Intrinsics.checkNotNullParameter(r6, "itemView");
            TextView r0 = (TextView) r6.findViewById(2131381025);
            TextView r1 = (TextView) r6.findViewById(2131381030);
            NoMoreSpaceTextView r2 = r6.findViewById(2131381020);
            TextView r10 = (TextView) r6.findViewById(2131381016);
            boolean r3 = true;
            if (r8 == null) goto L5;
            int r4 = e.j;
            r8.a(r2, true);
        L5:
            r2.setText(r5.g());
            String r11 = r5.getNoticeTitle();
            if (r11 != null) goto L8;
        L13:
            r1.setText(2131922295);
        L14:
            if (r7 == false) goto L16;
            UtilityKotlinExtentionsKt.w(r10);
        L16:
            if (r9 == false) goto L18;
            UtilityKotlinExtentionsKt.w(r0);
            return;
        L18:
            UtilityKotlinExtentionsKt.t(r0);
            return;
        L8:
            if (r11.length() == 0) goto L11;
            r3 = false;
        L11:
            if (r3 == true) goto L13;
            r1.setText(r5.getNoticeTitle());
            goto L14
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder
    public final void T3() {
        HashMap r0 = new HashMap();
        j0.l().sendLog("livesdk_live_announcement_show", r0, new Object[]{IRoom.class, x.class});
    }

    public RoomNoticeViewHolder(View r2, boolean r3, q92.a r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.b = r3;
        this.c = r4;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder
    public final void U3(f<?> r4, int r5, e r6) {
        if ((r4 instanceof c0) == false) goto L8;
        d4 r7 = ((c0) r4).b;
        if (r7 == null) goto L9;
        d4 r8 = r7;
        a.a(r8, ((RecyclerView.ViewHolder) this).itemView, this.b, r6, r8.O0());
        l.e(((RecyclerView.ViewHolder) this).itemView, l.a(false, r4, this.c));
        return;
    L9:
        return;
    }
}
