package ccb;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final int a;
    public final boolean b;
    public final boolean c;
    public final String d;
    public final List<ChatChatter> e;
    public final Map<String, String> f;
    public final Map<String, String> g;

    public a() {
        this(0, false, false, BuildConfig.FLAVOR, new ArrayList(0), null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
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
        int r0 = this.a * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == true) goto L10;
        r2 = 1237;
    L10:
        int r4 = (r3 + r2) * 31;
        String r5 = this.d;
        int r6 = 0;
        if (r5 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (((r4 + r7) * 31) + this.e.hashCode()) * 31;
        Map<String, String> r9 = this.f;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        Map<String, String> r12 = this.g;
        if (r12 == null) goto L23;
        r6 = r12.hashCode();
    L23:
        return r11 + r6;
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = r5.hashCode();
        goto L14
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatChatterResponse(memberCount=" + this.a + ", showSearch=" + this.b + ", isShowDepartment=" + this.c + ", cursor=" + this.d + ", chatChatters=" + this.e + ", chatterLetterMap=" + this.f + ", chatterDepartmentNameMap=" + this.g + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(int r2, boolean r3, boolean r4, String r5, List<? extends ChatChatter> r6, Map<String, String> r7, Map<String, String> r8) {
        Intrinsics.checkNotNullParameter(r6, "chatChatters");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
