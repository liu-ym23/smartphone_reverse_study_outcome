package com.ss.android.lark.officewebview.quality.stable;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "bdr", "Lcom/ss/android/lark/officesdk/di/core/deps/webview/BlankDetectResultWrapper;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class BlankChecker$checkBlank$1 extends Lambda implements Function1<otb.a, Unit> {
    final /* synthetic */ Ref.ObjectRef<b.a> $blankResult;
    final /* synthetic */ b $result;
    final /* synthetic */ a this$0;

    public BlankChecker$checkBlank$1(Ref.ObjectRef<b.a> r1, a r2, b r3) {
        this.$blankResult = r1;
        this.this$0 = r2;
        super(1);
    }

    public final void invoke(otb.a r9) {
        Intrinsics.checkNotNullParameter(r9, "bdr");
        Ref.ObjectRef<b.a> r0 = this.$blankResult;
        a r1 = this.this$0;
        int r2 = a.a;
        r1.getClass();
        b.a r3 = new b.a();
        int r4 = 0;
        if (r9 == null) goto L5;
        boolean r5 = r9.c();
    L6:
        r3.b = r5;
        if (r9 == null) goto L9;
        String r6 = r9.b();
    L33:
        JSONObject r7 = new JSONObject(r6);     // Catch: Exception -> L18
        Iterator<String> r8 = r7.keys();     // Catch: Exception -> L18
        int r10 = 0;
        int r11 = 0;
    L12:
        if (r8.hasNext() == false) goto L17;
        int r12 = JSONObjectProtectorUtils.getInt(r7, r8.next());     // Catch: Exception -> L18
        r11 = r11 + r12;
        if (r12 <= r10) goto L12;
        r10 = r12;
        goto L12
    L17:
        float r13 = r10 / r11;
    L20:
        r3.e = (int) (r13 * 1000);
        if (r9 == null) goto L23;
        boolean r14 = r9.isSuccess();
    L24:
        r3.a = r14;
        if (r9 == null) goto L27;
        boolean r15 = r9.a();
    L28:
        r3.c = r15;
        if (r9 == null) goto L31;
        r4 = r9.d();
    L31:
        r3.d = r4;
        r3.f = true;
        r0.element = r3;
        return;
    L27:
        r15 = false;
        goto L28
    L23:
        r14 = false;
    L18:
        e = move-exception;
        j.c("BlankChecker", "getRate, error", e);
        r13 = 0.0f;
        goto L20
    L9:
        r6 = null;
        goto L33
    L5:
        r5 = false;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((otb.a) r1);
        return Unit.INSTANCE;
    }
}
