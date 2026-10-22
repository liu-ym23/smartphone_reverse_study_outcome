package b3;

import android.util.Log;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f852b;

    public m(int r5) {
        this.f851a = r5;
        switch(r5) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.f852b = new JSONObject();
        return;
    L6:
        this.f852b = new JSONObject();
    }

    public final void a(String r10, Long r11) {
        JSONObject r5 = this.f852b;
        int r12 = this.f851a;
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        switch(r12) {
            case 0: goto L10;
            default: goto L5;
        };
    L5:
        if (r5.optLong(r10) == 0) goto L7;
        boolean r13 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("redundancy record: " + r10 + ", " + r11, LogLevel.f5955c, "Monitor-Timeline");
        return;
    L7:
        e(r10, r11);
        return;
    L10:
        if (r5.optLong(r10) == 0) goto L14;
        String r14 = "redundancy record: " + r10 + ", " + r11;
        Intrinsics.checkNotNullParameter("Monitor-Timeline", "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L22;
        r15.w("Monitor-Timeline", r14);
        return;
    L22:
        return;
    L14:
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        if (r11 != null) goto L19;
        String r16 = "record with null metric: " + r10 + ", " + r11;
        Intrinsics.checkNotNullParameter("Monitor-Timeline", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L24;
        r17.w("Monitor-Timeline", r16);
        return;
    L24:
        return;
    L19:
        r5.put(r10, r11.longValue());
    }

    public void b(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "jsonObject");
        JSONObject r10 = this.f852b;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
        Iterator<String> r12 = r5.keys();     // Catch: Throwable -> L8
        if (r12 != null) goto L6;
        Unit r13 = null;
    L12:
        Object r14 = Result.m124constructorimpl(r13);     // Catch: Throwable -> L8
    L15:
        Throwable r15 = Result.m127exceptionOrNullimpl(r14);
        if (r15 == null) goto L24;
        String r16 = "JsonUtils.wrap " + r15.getMessage();
        Intrinsics.checkNotNullParameter("Monitor-Timeline", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L25;
        r17.e("Monitor-Timeline", r16);
        return;
    L25:
        return;
    L24:
        return;
    L6:
        if (r12.hasNext() == false) goto L10;
        String r18 = r12.next();     // Catch: Throwable -> L8
        r10.put(r18, r5.opt(r18));     // Catch: Throwable -> L8
        goto L6
    L10:
        r13 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public final boolean c(String r5) {
        switch(this.f851a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        if (this.f852b.optLong(r5) == 0) goto L7;
        return true;
    L7:
        return false;
    L9:
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        if (this.f852b.optLong(r5) == 0) goto L12;
        return true;
    L12:
        return false;
    }

    public long d(String r10) {
        JSONObject r11 = this.f852b;
        int r12 = this.f851a;
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        switch(r12) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        long r13 = r11.optLong(r10);
        if (r13 != 0) goto L8;
        boolean r14 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d(td.d.b("get null metric: ", r10), LogLevel.f5955c, "Monitor-Timeline");
        return -1;
    L8:
        return r13;
    L9:
        long r15 = r11.optLong(r10);
        if (r15 != 0) goto L15;
        String r16 = "get null metric: ".concat(r10);
        Intrinsics.checkNotNullParameter("Monitor-Timeline", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L17;
        r17.w("Monitor-Timeline", r16);
        return -1;
    L17:
        return -1;
    L15:
        return r15;
    }

    public void e(String r5, Long r10) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        if (r10 != null) goto L6;
        boolean r11 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("record with null metric: " + r5 + ", " + r10, LogLevel.f5955c, "Monitor-Timeline");
        return;
    L6:
        Log.i("Monitor-Timeline", "record " + r5 + ", " + r10);
        this.f852b.put(r5, r10.longValue());     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        boolean r12 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d(androidx.room.jarjarred.org.antlr.runtime.a.o(e, com.lynx.tasm.utils.e.b("record exception: key=", r5, ", msg=")), LogLevel.f5955c, "Monitor-Timeline");
    }
}
