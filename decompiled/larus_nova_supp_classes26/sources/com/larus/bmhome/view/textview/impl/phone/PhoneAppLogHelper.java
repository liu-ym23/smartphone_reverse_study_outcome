package com.larus.bmhome.view.textview.impl.phone;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.larus.bmhome.chat.api.q0;
import fh8.q;
import io.noties.markwon.ext.tables.TableRowSpan2;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class PhoneAppLogHelper {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r12, String r13, String r14, SpannableStringBuilder r15, q0 r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r12, "context");
        if (r15 == null) goto L24;
        Intrinsics.checkNotNullParameter(r15, "<this>");
        SpannableStringBuilder r4 = new SpannableStringBuilder(r15);
        Iterator r1 = ArraysKt.sortedWith(r15.getSpans(0, r15.length(), TableRowSpan2.class), new q(r15)).iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        TableRowSpan2 r2 = (TableRowSpan2) r1.next();
        int r3 = r15.getSpanStart(r2);
        int r6 = r15.getSpanEnd(r2);
        if (r3 < 0) goto L6;
        if (r6 > r4.length()) goto L6;
        if (r3 >= r6) goto L6;
        r4.setSpan(r2, r3, r6, r15.getSpanFlags(r2));
        goto L6
    L13:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PhoneAppLogHelper$reportPhoneAppLog$1(r17, r4, r12, r13, r14, r16, null), 3, null);
        return;
    }
}
