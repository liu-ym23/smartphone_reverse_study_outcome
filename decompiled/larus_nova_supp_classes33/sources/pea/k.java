package pea;

import android.content.Intent;
import com.google.gson.JsonObject;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.live.gr.island.island.template.GRExpandedDialogueTemplate;
import com.obric.assistant.live.gr.island.island.template.GRExpandedNormalTemplate;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class k {
    public final String a;
    public l b;
    public final Boolean c;
    public final JsonObject d;
    public final Integer e;
    public final Intent f;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Boolean r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        JsonObject r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Intent r11 = this.f;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "GRIslandWidget(templateId=" + this.a + ", templateData=" + this.b + ", isDefault=" + this.c + ", ext=" + this.d + ", intentType=" + this.e + ", intent=" + this.f + ')';
    }

    public final void a(String r7, Intent r8) {
        Intrinsics.checkNotNullParameter(r7, "action");
        Intrinsics.checkNotNullParameter(r8, MemorySourceLinkType.INTENT);
        l r0 = this.b;
        if ((r0 instanceof GRExpandedNormalTemplate) == false) goto L11;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.assistant.live.gr.island.island.template.GRExpandedNormalTemplate");
        Iterator<T> r1 = ((GRExpandedNormalTemplate) r0).m6getActions().iterator();
    L6:
        if (r1.hasNext() == false) goto L29;
        h r2 = (h) r1.next();
        if (Intrinsics.areEqual(r2.c, r7) == false) goto L6;
        r2.d = r8;
        FLogger.a.d("XiaomiIslandWidget", "setActionIntent: XiaomiExpandedTemplate16 " + r7 + ", " + r8);
        goto L6
    L29:
        return;
    L11:
        if ((r0 instanceof GRExpandedDialogueTemplate) == false) goto L18;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.assistant.live.gr.island.island.template.GRExpandedDialogueTemplate");
        Iterator<T> r3 = ((GRExpandedDialogueTemplate) r0).getTextButton().iterator();
    L14:
        if (r3.hasNext() == false) goto L30;
        e r4 = (e) r3.next();
        if (Intrinsics.areEqual(r4.b, r7) == false) goto L14;
        r4.c = r8;
        FLogger.a.d("XiaomiIslandWidget", "setActionIntent: XiaomiExpandedTemplate17 " + r7 + ", " + r8);
        goto L14
    L30:
        return;
    }

    public k(String r2, l r3, Boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "templateId");
        Intrinsics.checkNotNullParameter(r3, "templateData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = null;
        this.e = null;
        this.f = null;
    }
}
