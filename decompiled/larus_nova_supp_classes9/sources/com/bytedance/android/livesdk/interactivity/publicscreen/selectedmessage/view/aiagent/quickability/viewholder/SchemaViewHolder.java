package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.viewholder;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.Ability;
import ia2.b;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/aiagent/quickability/viewholder/SchemaViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/aiagent/quickability/viewholder/QuickAbilityTextViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SchemaViewHolder extends QuickAbilityTextViewHolder {
    public SchemaViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "root");
        super(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.viewholder.QuickAbilityTextViewHolder, com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.viewholder.QuickAbilityBaseViewHolder
    public final boolean V3(b r4) {
        Context r0 = this.c.getContext();
        if (r4 == null) goto L7;
        Ability r5 = r4.a;
        if (r5 == null) goto L7;
        String r6 = r5.getSchema();
    L9:
        if (r6 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == true) goto L20;
        if (r0 == null) goto L20;
        IBaseLiveActionHandler r3 = k.f(IBaseLiveActionHandler.class);
        if (r3 == null) goto L20;
        r3.handle(r0, r6);
    L20:
        return true;
    L11:
        if (r6.length() == 0) goto L14;
        r2 = false;
    L7:
        r6 = null;
        goto L9
    }
}
