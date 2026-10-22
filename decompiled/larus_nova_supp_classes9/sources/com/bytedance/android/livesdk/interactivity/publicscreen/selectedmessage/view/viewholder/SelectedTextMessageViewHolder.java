package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.viewholder;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.interactivity.textmessage.viewholder.TextMessageRenderViewHolder;
import e52.a;
import g52.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/viewholder/SelectedTextMessageViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/textmessage/viewholder/TextMessageRenderViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SelectedTextMessageViewHolder extends TextMessageRenderViewHolder {
    public final Map<String, String> q;
    public Map<String, String> r;
    public final Function1<f<?>, Map<String, String>> s;
    public final Function2<Boolean, Map<String, String>, Boolean> t;

    @Override // com.bytedance.android.livesdk.interactivity.textmessage.viewholder.TextMessageRenderViewHolder
    public final void W3(f<?> r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "renderResult");
    }

    @Override // com.bytedance.android.livesdk.interactivity.textmessage.viewholder.TextMessageRenderViewHolder
    public final boolean Y3(boolean r3) {
        Function2<Boolean, Map<String, String>, Boolean> r0 = this.t;
        if (r0 == null) goto L7;
        Boolean r4 = (Boolean) r0.invoke(Boolean.valueOf(r3), this.r);
        if (r4 == null) goto L7;
        return r4.booleanValue();
    L7:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.textmessage.viewholder.TextMessageRenderViewHolder
    public final void Z3(f<?> r2) {
        Function1<f<?>, Map<String, String>> r0 = this.s;
        if (r0 != null) goto L5;
        Map<String, String> r1 = this.q;
    L6:
        this.r = r1;
        if (r2 == null) goto L10;
        r2.D = r1;
        return;
    L10:
        return;
    L5:
        r1 = (Map) r0.invoke(r2);
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.textmessage.viewholder.TextMessageRenderViewHolder, com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder
    public final void U3(f<?> r2, int r3, e r4) {
        Intrinsics.checkNotNullParameter(r2, "message");
        super.U3(r2, r3, r4);
    }

    @Override // com.bytedance.android.livesdk.interactivity.textmessage.viewholder.TextMessageRenderViewHolder
    public final void X3(View r2, f<?> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "message");
        if (r4 == false) goto L6;
        if (r2 == null) goto L10;
        int r5 = 2131249530;
    L8:
        r2.setBackgroundResource(r5);
        return;
    L10:
        return;
    L6:
        if (r2 == null) goto L11;
        r5 = 0;
        goto L8
    }

    public SelectedTextMessageViewHolder(TextMessageRenderViewHolder.f r2, k r3, a r4, Function1 r5, Function2 r6) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "processor");
        super(r2, r3, true, r4);
        this.s = r5;
        this.t = r6;
        this.q = MapsKt.mapOf(TuplesKt.to("msg_show_area", "selected_msg"));
    }
}
