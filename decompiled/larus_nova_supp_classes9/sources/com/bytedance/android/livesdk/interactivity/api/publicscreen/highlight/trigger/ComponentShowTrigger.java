package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.trigger;

import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.TriggerKey;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.d;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.m;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.o;
import com.bytedance.android.livesdkapi.toolbar.ToolbarBehaviorData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.j;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/trigger/ComponentShowTrigger;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/d;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComponentShowTrigger extends d implements Observer<KVData> {
    public final TriggerKey d;
    public final DataCenter e;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.d
    public final void d() {
        DataCenter r0 = this.e;
        if (r0 == null) goto L6;
        r0.observe("cmd_specific_behavior_loaded", this);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.d, com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.m
    public final void release() {
        DataCenter r0 = this.e;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        super.release();
    }

    public final TriggerKey e() {
        return this.d;
    }

    public ComponentShowTrigger(DataCenter r1) {
        this.e = r1;
        this.d = TriggerKey.ComponentShowDismiss;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L38;
        String r0 = r5.getKey();
        if (r0.hashCode() == 1995521258) goto L9;
        return;
    L9:
        if (r0.equals("cmd_specific_behavior_loaded") == false) goto L34;
        Object r6 = r5.getData();
        if ((r6 instanceof ToolbarBehaviorData) == true) goto L13;
        r6 = null;
    L13:
        ToolbarBehaviorData r7 = (ToolbarBehaviorData) r6;
        if (r7 == null) goto L35;
        int r1 = o.a;
        o.c(r7.getId() + ", " + r7.getBehaviorMappingName() + ", " + r7.isFold());
        int r2 = r7.getId();
        if (1 <= r2) goto L19;
        return;
    L19:
        if (9 >= r2) goto L21;
        return;
    L21:
        if (r7.isFold() == true) goto L37;
        m.a r3 = this.a;
        if (r3 == null) goto L25;
        r3.a(e());
    L25:
        h r8 = i.b(this.e, 1);
        if (r8 == null) goto L32;
        j<k> r9 = r8.getHighlightContext();
        if (r9 == null) goto L32;
        k r10 = (k) r9.getValue();
        if (r10 == null) goto L32;
        r10.setHasComponentShow(true);
    L32:
        o.c("挂载组件:" + r7.getId() + "已展示，卸载话题组件");
        return;
    L37:
        return;
    L35:
        return;
    L34:
        return;
    }
}
