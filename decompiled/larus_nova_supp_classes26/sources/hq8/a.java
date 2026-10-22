package hq8;

import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.tabs.TabLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final ConstraintLayout a;
    public final TabLayout b;
    public final AppCompatTextView c;
    public final AppCompatImageView d;
    public final FrameLayout e;
    public final FrameLayout f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
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
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public final String toString() {
        return "MultiTabViewCollector(root=" + this.a + ", tlSwitchTab=" + this.b + ", tvEditorTitle=" + this.c + ", btnEditorClose=" + this.d + ", flAttachmentArea=" + this.e + ", flEditorInstruction=" + this.f + ')';
    }

    public a(ConstraintLayout r2, TabLayout r3, AppCompatTextView r4, AppCompatImageView r5, FrameLayout r6, FrameLayout r7) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "tlSwitchTab");
        Intrinsics.checkNotNullParameter(r4, "tvEditorTitle");
        Intrinsics.checkNotNullParameter(r5, "btnEditorClose");
        Intrinsics.checkNotNullParameter(r6, "flAttachmentArea");
        Intrinsics.checkNotNullParameter(r7, "flEditorInstruction");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
