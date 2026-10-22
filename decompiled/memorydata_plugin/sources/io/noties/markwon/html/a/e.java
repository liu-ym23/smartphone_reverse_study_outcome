package io.noties.markwon.html.a;

import android.view.ViewGroup;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a4\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t\u001a:\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004¨\u0006\u000e"}, d2 = {"clearWidgetCache", "", "Landroid/view/ViewGroup;", "obtainWidget", "Lio/noties/markwon/html/customdata/ICustomDataWidget;", "startIndex", "", "endIndex", "dataType", "", "dataValue", "dataValueId", "recycleWidget", "widget", "markwon-html_release"}, k = 2, mv = {1, 1, 15})
public final class e {
    public static final g a(ViewGroup r9, int r10, int r11, String r12, String r13, String r14) {
        Intrinsics.checkParameterIsNotNull(r9, "$this$obtainWidget");
        Intrinsics.checkParameterIsNotNull(r12, "dataType");
        Intrinsics.checkParameterIsNotNull(r13, "dataValue");
        Intrinsics.checkParameterIsNotNull(r14, "dataValueId");
        Object r0 = r9.getTag(ZeusTransformUtils.mapRes(R.id.markwon_cached_widget_list, OaidModel.KEY_ID, "markwon_cached_widget_list"));
        if (TypeIntrinsics.isMutableList(r0) == true) goto L5;
        r0 = null;
    L5:
        List r1 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L34;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r3.hasNext() == false) goto L24;
        Object r6 = r3.next();
        b r7 = (b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.memorydata.plugin");
        if (r7.a() == r10) goto L13;
    L21:
        boolean r8 = false;
    L22:
        if (r8 == false) goto L9;
    L25:
        b r15 = (b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L35;
        r1.remove(r15);
        r9.setTag(ZeusTransformUtils.mapRes(R.id.markwon_cached_widget_list, OaidModel.KEY_ID, "markwon_cached_widget_list"), r1);
        return r15.g();
    L35:
        return null;
    L13:
        if (r7.b() != r11) goto L21;
        if (Intrinsics.areEqual(r7.c(), r12) == false) goto L21;
        if (Intrinsics.areEqual(r7.d(), r13) == false) goto L21;
        if (Intrinsics.areEqual(r7.e(), r14) == false) goto L21;
        r8 = true;
        goto L22
    L24:
        r6 = null;
        goto L25
    L34:
        return null;
    }

    public static final void a(ViewGroup r3) {
        Intrinsics.checkParameterIsNotNull(r3, "$this$clearWidgetCache");
        r3.setTag(ZeusTransformUtils.mapRes(R.id.markwon_cached_widget_list, OaidModel.KEY_ID, "markwon_cached_widget_list"), null);
    }
}
