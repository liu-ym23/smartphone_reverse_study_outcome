package y7;

import android.app.Activity;
import android.content.Context;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.android.annie.debug.ui.DialogItem;
import com.bytedance.android.annie.util.m;
import com.bytedance.android.annie.util.p;
import java.util.LinkedList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements d {
    public final Context a;

    @Override // y7.d
    public final String getTitle() {
        return "appInfo";
    }

    @Override // y7.d
    public final List<DialogItem> a() {
        LinkedList r0 = new LinkedList();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        com.bytedance.android.annie.ng.g.b().getClass();     // Catch: Throwable -> L5
        o8.a r11 = com.bytedance.android.annie.ng.e.a;     // Catch: Throwable -> L5
        r0.add(new DialogItem(BdpAwemeConstant.KEY_APP_NAME, r11.b, null, 4));     // Catch: Throwable -> L5
        com.bytedance.android.annie.ng.g.b().getClass();     // Catch: Throwable -> L5
        r0.add(new DialogItem(BdpAwemeConstant.KEY_APP_ID, String.valueOf(r11.a), null, 4));     // Catch: Throwable -> L5
        r0.add(new DialogItem("deviceID", com.bytedance.android.annie.ng.g.b().b.b, null, 4));     // Catch: Throwable -> L5
        com.bytedance.android.annie.ng.g.b().getClass();     // Catch: Throwable -> L5
        Object r12 = Result.constructor-impl(Boolean.valueOf(r0.add(new DialogItem("appVersion", r11.d, null, 4))));     // Catch: Throwable -> L5
    L7:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L10;
        r13.printStackTrace();
    L10:
        StringBuilder r14 = new StringBuilder();
        p r15 = p.a;
        r14.append((int) r15.h(r15.e()));
        r14.append('*');
        Context r16 = this.a;
        if ((r16 instanceof Activity) == false) goto L13;
        Activity r17 = (Activity) r16;
    L14:
        r14.append((int) r15.h(p.c(r17).heightPixels));
        r0.add(new DialogItem("屏幕尺寸(单位:dp)", r14.toString(), null, 4));
        Context r18 = this.a;
        if ((r18 instanceof Activity) == false) goto L17;
        Activity r19 = (Activity) r18;
    L19:
        if (m.a(r19) == false) goto L21;
        String r20 = "横屏";
    L22:
        r0.add(new DialogItem("横竖屏状态", r20, null, 4));
        return r0;
    L21:
        r20 = "竖屏";
        goto L22
    L17:
        r19 = null;
        goto L19
    L13:
        r17 = null;
    L5:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public b(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.a = r10;
    }
}
