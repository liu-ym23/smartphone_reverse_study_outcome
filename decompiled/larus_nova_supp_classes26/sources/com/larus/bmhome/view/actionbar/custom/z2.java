package com.larus.bmhome.view.actionbar.custom;

import android.view.View;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class z2 {
    public final ICoreInputAbility a;
    public final InstructionEditorViewModel b;
    public final com.larus.bmhome.actionbar.model.z0 c;
    public final View d;
    public final String e;
    public final Long f;
    public final String g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof z2) == true) goto L8;
        return false;
    L8:
        z2 r6 = (z2) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        ICoreInputAbility r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        InstructionEditorViewModel r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((((r3 + r5) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        String r7 = this.e;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.f;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.g;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "PodcastHandleContext(coreInputAbility=" + this.a + ", instructionEditorViewModel=" + this.b + ", item=" + this.c + ", itemView=" + this.d + ", botId=" + this.e + ", cvsId=" + this.f + ", chatType=" + this.g + ')';
    }

    public z2(ICoreInputAbility r2, InstructionEditorViewModel r3, com.larus.bmhome.actionbar.model.z0 r4, View r5, String r6, Long r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, "item");
        Intrinsics.checkNotNullParameter(r5, "itemView");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
