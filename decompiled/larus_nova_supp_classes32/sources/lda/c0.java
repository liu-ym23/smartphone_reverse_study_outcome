package lda;

import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.modules.omni.OmniTaskStatus;
import com.obric.assistant.cocreationreview.modules.omni.OmniTaskTriggerType;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c0 {
    public final long a;
    public final String b;
    public OmniTaskTriggerType c;
    public String d;
    public final LinkedHashMap<Integer, c> e;

    public c0() {
        throw null;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r9 = (c0) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        return (((((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "PendingOmniRecord(createdAt=" + this.a + ", userQuery=" + this.b + ", taskTriggerType=" + this.c + ", latestReply=" + this.d + ", steps=" + this.e + ')';
    }

    public final void a(w r5) {
        Intrinsics.checkNotNullParameter(r5, "step");
        this.c = r5.j;
        String r0 = r5.f;
        if (StringsKt.isBlank(r0) == false) goto L5;
        r0 = r5.e;
    L5:
        String r1 = v.a(r0);
        if ((!StringsKt.isBlank(r1)) == false) goto L9;
        this.e.put(Integer.valueOf(r5.d), new c(r1));
    L9:
        if ((!StringsKt.isBlank(r5.f)) == false) goto L12;
        this.d = r5.f;
        return;
    }

    public final b0 b(a0 r15) {
        Intrinsics.checkNotNullParameter(r15, "stop");
        List r0 = CollectionsKt.toList(this.e.values());
        if (r0.isEmpty() == false) goto L5;
        r0 = CollectionsKt.listOf(new c("用户主动停止任务"));
    L5:
        List r11 = r0;
        String r2 = v.b(r15.a);
        ModuleKey r3 = e.a.a;
        String r4 = r15.a;
        long r5 = this.a;
        String r7 = this.b;
        String r1 = this.d;
        if (StringsKt.isBlank(r1) == false) goto L9;
        r1 = "用户主动停止了 Omni 任务";
    L9:
        return new b0(r2, r3, r4, r5, r7, r1, OmniTaskStatus.USER_STOPPED, r15.f, r11, j.a(this.a, r15.d));
    }

    public c0(long r4, String r6, OmniTaskTriggerType r7) {
        LinkedHashMap<Integer, c> r0 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r6, "userQuery");
        Intrinsics.checkNotNullParameter(r7, "taskTriggerType");
        Intrinsics.checkNotNullParameter(NameKeys.UnloadStrategy_No_Strategy, "latestReply");
        Intrinsics.checkNotNullParameter(r0, "steps");
        this.a = r4;
        this.b = r6;
        this.c = r7;
        this.d = NameKeys.UnloadStrategy_No_Strategy;
        this.e = r0;
    }
}
