package jy9;

import androidx.fragment.app.DialogFragment;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import java.io.Serializable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public final String a;
    public final String b;
    public final wc9.e c;
    public final Function1<ICoreInputAbility.OnSendParams, Unit> d;
    public final Function4<Serializable, String, String, zs8.a, Unit> e;
    public final Function1<DialogFragment, Unit> f;
    public final Function0<Unit> g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
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
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        wc9.e r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Function1<ICoreInputAbility.OnSendParams, Unit> r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Function4<Serializable, String, String, zs8.a, Unit> r11 = this.e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Function1<DialogFragment, Unit> r14 = this.f;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return ((r13 + r2) * 31) + this.g.hashCode();
    L17:
        r12 = r11.hashCode();
        goto L18
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
        return "BeautifyEnv(cvsId=" + this.a + ", botId=" + this.b + ", conversation=" + this.c + ", doSend=" + this.d + ", sendImageRemoveMessage=" + this.e + ", showDialogFragment=" + this.f + ", dismissCreationPage=" + this.g + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(String r2, String r3, wc9.e r4, Function1<? super ICoreInputAbility.OnSendParams, Unit> r5, Function4<? super Serializable, ? super String, ? super String, ? super zs8.a, Unit> r6, Function1<? super DialogFragment, Unit> r7, Function0<Unit> r8) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        Intrinsics.checkNotNullParameter(r8, "dismissCreationPage");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
