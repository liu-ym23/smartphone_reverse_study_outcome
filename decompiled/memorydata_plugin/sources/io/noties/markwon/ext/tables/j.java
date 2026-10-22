package io.noties.markwon.ext.tables;

import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
abstract class j {
    static void a(final TextView r6) {
        a[] r0 = c(r6);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length > 0) goto L7;
        return;
    L7:
        if (r6.getTag(ZeusTransformUtils.mapRes(R.id.markwon_tables_scheduler, OaidModel.KEY_ID, "markwon_tables_scheduler")) != null) goto L9;
        View.OnAttachStateChangeListener r1 = new AnonymousClass1(r6);
        r6.addOnAttachStateChangeListener(r1);
        r6.setTag(ZeusTransformUtils.mapRes(R.id.markwon_tables_scheduler, OaidModel.KEY_ID, "markwon_tables_scheduler"), r1);
    L9:
        a.InterfaceC0862a r2 = new AnonymousClass2(r6);
        int r7 = r0.length;
        int r3 = 0;
    L10:
        if (r3 >= r7) goto L15;
        ((a) ZeusTransformUtils.preCheckCast(r0[r3], a.class, "com.obric.memorydata.plugin")).a(r2);
        r3 = r3 + 1;
        goto L10
    }

    static void b(TextView r5) {
        a[] r6 = c(r5);
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.length <= 0) goto L11;
        int r0 = r6.length;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L12;
        ((a) ZeusTransformUtils.preCheckCast(r6[r1], a.class, "com.obric.memorydata.plugin")).a(null);
        r1 = r1 + 1;
        goto L7
    L12:
        return;
    }

    public static a[] c(TextView r4) {
        CharSequence r5 = r4.getText();
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L7:
        return null;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, Spanned.class) == false) goto L7;
        return (a[]) ZeusTransformUtils.preCheckCast(((Spanned) ZeusTransformUtils.preCheckCast(r5, Spanned.class, "com.obric.memorydata.plugin")).getSpans(0, r5.length(), a.class), a[].class, "com.obric.memorydata.plugin");
    }
}
