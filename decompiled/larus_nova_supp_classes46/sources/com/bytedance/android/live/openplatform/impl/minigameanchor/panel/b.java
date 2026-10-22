package com.bytedance.android.live.openplatform.impl.minigameanchor.panel;

import android.widget.Button;
import android.widget.TextView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ MiniGameFeaturePanelDialog a;

    public b(MiniGameFeaturePanelDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        if (Intrinsics.areEqual((Boolean) r6, Boolean.TRUE) == false) goto L16;
        Button r7 = (Button) this.a.T90(2131387051);
        if (r7 == null) goto L7;
        r7.setSelected(true);
    L7:
        Button r8 = (Button) this.a.T90(2131387051);
        if (r8 == null) goto L10;
        r8.setText(this.a.getResources().getString(2131920975));
    L10:
        Button r9 = (Button) this.a.T90(2131387051);
        if (r9 == null) goto L13;
        r9.setTextColor(this.a.getResources().getColor(2131107885));
    L13:
        TextView r10 = (TextView) this.a.T90(2131387066);
        if (r10 == null) goto L29;
        r10.setVisibility(0);
        return;
    L29:
        return;
    L16:
        Button r11 = (Button) this.a.T90(2131387051);
        if (r11 == null) goto L19;
        r11.setSelected(false);
    L19:
        Button r12 = (Button) this.a.T90(2131387051);
        if (r12 == null) goto L22;
        r12.setText(this.a.getResources().getString(2131920976));
    L22:
        Button r13 = (Button) this.a.T90(2131387051);
        if (r13 == null) goto L25;
        r13.setTextColor(this.a.getResources().getColor(2131109391));
    L25:
        TextView r14 = (TextView) this.a.T90(2131387066);
        if (r14 == null) goto L31;
        r14.setVisibility(8);
        return;
    }
}
