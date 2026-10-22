package com.bytedance.android.livesdk.interactivity.comment.mention;

import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements InputPanelSectionContainer.c {
    public final Set<InputSectionType> a;
    public final /* synthetic */ MentionSectionController b;

    public d(MentionSectionController r3) {
        this.b = r3;
        this.a = SetsKt.setOf(new InputSectionType[]{InputSectionType.NONE, InputSectionType.KEYBOARD});
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer.c
    public final void a(InputSectionType r2, InputSectionType r3) {
        Intrinsics.checkNotNullParameter(r2, "previousType");
        Intrinsics.checkNotNullParameter(r3, "currentSectionType");
        if (r2 != r3) goto L6;
        return;
    L6:
        if (this.a.contains(r2) == false) goto L11;
        if (this.a.contains(r3) == true) goto L11;
        this.b.b.P(false);
        return;
    L11:
        if (this.a.contains(r3) == true) goto L13;
        return;
    L13:
        if (this.a.contains(r2) == true) goto L18;
        this.b.b.P(true);
        return;
    }
}
