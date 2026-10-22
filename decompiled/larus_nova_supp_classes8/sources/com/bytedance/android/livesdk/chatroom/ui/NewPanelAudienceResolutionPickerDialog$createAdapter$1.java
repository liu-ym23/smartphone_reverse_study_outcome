package com.bytedance.android.livesdk.chatroom.ui;

import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/livesdk/chatroom/ui/NewPanelAudienceResolutionPickerDialog$createAdapter$1", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/chatroom/ui/NewPanelAudienceResolutionPickerDialog$a;", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewPanelAudienceResolutionPickerDialog$createAdapter$1 extends RecyclerView.Adapter<NewPanelAudienceResolutionPickerDialog.a> {
    public final /* synthetic */ NewPanelAudienceResolutionPickerDialog a;

    public final int getItemCount() {
        this.a.getClass();
        throw null;
    }

    public NewPanelAudienceResolutionPickerDialog$createAdapter$1(NewPanelAudienceResolutionPickerDialog r1) {
        this.a = r1;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        NewPanelAudienceResolutionPickerDialog.a r6 = (NewPanelAudienceResolutionPickerDialog.a) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        this.a.getClass();
        l5 r7 = (l5) ListProtector.get(null, r5);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "audienceResolutionItemInfo");
        NewPanelAudienceResolutionPickerDialog.ResolutionItemView r8 = r6.a;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r7, "resolutionInfo");
        r8.a().setText(r7.b);
        r8.setBackground(new ColorDrawable(0));
        String r0 = r7.e;
        int r1 = r0.hashCode();
        if (r1 == (-1577166796)) goto L16;
        if (r1 == 1191572123) goto L13;
        if (r1 == 1671308008) goto L10;
    L18:
        r8.setOnClickListener(new b8(r8, r7));
        return;
    L10:
        if (r0.equals("disable") == false) goto L18;
        r8.a().setTextColor(ColorProtector.parseColor("#E6FFFFFF"));
        r8.a().setAlpha(0.5f);
        goto L18
    L13:
        if (r0.equals("selected") == false) goto L18;
        r8.a().setTextColor(ColorProtector.parseColor("#FE2C55"));
        r8.setBackground(r8.getContext().getResources().getDrawable(2131249864));
        goto L18
    L16:
        if (r0.equals("unselected") == false) goto L18;
        r8.a().setTextColor(-1);
        r8.a().setAlpha(0.9f);
        goto L18
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new NewPanelAudienceResolutionPickerDialog.a(new NewPanelAudienceResolutionPickerDialog.ResolutionItemView(this.a.getContext(), new NewPanelAudienceResolutionPickerDialog$createAdapter$1$onCreateViewHolder$1(this)));
    }
}
