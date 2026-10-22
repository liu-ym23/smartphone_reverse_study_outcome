package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.viewholder;

import am2.x;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.p;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.Ability;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import ia2.b;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/aiagent/quickability/viewholder/QuickAbilityBaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class QuickAbilityBaseViewHolder extends RecyclerView.ViewHolder {
    public ia2.a a;
    public b b;
    public final View c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ QuickAbilityBaseViewHolder a;

        public a(QuickAbilityBaseViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            QuickAbilityBaseViewHolder r7 = this.a;
            b r0 = r7.b;
            LinkedHashMap r1 = new LinkedHashMap();
            ia2.a r2 = r7.a;
            if (r2 != null) goto L5;
        L7:
            String r3 = "expand#1";
        L8:
            r1.put("show_type", r3);
            r1.put("msg_show_area", "ai_assistant");
            String r4 = BuildConfig.FLAVOR;
            if (r0 == null) goto L14;
            Ability r5 = r0.a;
            if (r5 == null) goto L14;
            String r8 = r5.getText();
            if (r8 == null) goto L14;
        L15:
            r1.put("hotkey_text", r8);
            if (r0 == null) goto L23;
            Ability r9 = r0.a;
            if (r9 == null) goto L23;
            String r10 = String.valueOf(r9.getType());
            if (r10 == null) goto L23;
            r4 = r10;
        L23:
            r1.put("hotkey_type", r4);
            Boolean r11 = p.a;
            ia2.a r13 = r7.a;
            if (r13 == null) goto L28;
            WeakReference<DataCenter> r14 = r13.getDataCenter();
            if (r14 == null) goto L28;
            DataCenter r15 = r14.get();
        L29:
            p.c("hotkey", r1, r15);
            r7.V3(r0);
            return;
        L28:
            r15 = null;
        L14:
            r8 = BuildConfig.FLAVOR;
            goto L15
        L5:
            if (r2.isMessageListEmpty() != true) goto L7;
            r3 = "expand#0";
            goto L8
        }
    }

    public void U3(b r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    public abstract boolean V3(b r1);

    public QuickAbilityBaseViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        super(r2);
        this.c = r2;
        r2.setOnClickListener(new a(this));
    }

    public final void T3(DataCenter r5) {
        b r0 = this.b;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.c == true) goto L8;
        return;
    L8:
        r0.c = false;
        LinkedHashMap r2 = new LinkedHashMap();
        String r1 = r0.a.getText();
        if (r1 != null) goto L11;
        r1 = BuildConfig.FLAVOR;
    L11:
        r2.put("hotkey_text", r1);
        r2.put("event_page", "live_take_detail");
        r2.put("module_name", "selected_message_layer");
        r2.put("element_name", "ai_assistant_hotkey");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.b.a(r2, r5);
        j0.l().sendLog("livesdk_selected_message_layer_ai_assistant_hotkey_show", r2, new Object[]{x.class, Room.class});
    }
}
