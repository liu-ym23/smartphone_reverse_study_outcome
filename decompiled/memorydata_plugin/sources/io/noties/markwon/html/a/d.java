package io.noties.markwon.html.a;

import android.view.View;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bJF\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0004¨\u0006\u0012"}, d2 = {"Lio/noties/markwon/html/customdata/CustomDataLynxWidgetExt;", "", "()V", "obtainWidget", "Lio/noties/markwon/html/customdata/ICustomDataWidget;", "view", "Landroid/view/View;", "startIndex", "", "endIndex", "dataType", "", "dataValue", "dataValueId", "dataTag", "recycleWidget", "", "widget", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f16557a = null;

    static {
        f16557a = new d();
    }

    private d() {
    }

    public final g a(View r5, int r6, int r7, String r8, String r9, String r10, String r11) {
        Intrinsics.checkParameterIsNotNull(r5, "view");
        Intrinsics.checkParameterIsNotNull(r8, "dataType");
        Intrinsics.checkParameterIsNotNull(r9, "dataValue");
        Intrinsics.checkParameterIsNotNull(r10, "dataValueId");
        Intrinsics.checkParameterIsNotNull(r11, "dataTag");
        Object r4 = r5.getTag(ZeusTransformUtils.mapRes(R.id.markwon_cached_lynx_widget_list, OaidModel.KEY_ID, "markwon_cached_lynx_widget_list"));
        if (TypeIntrinsics.isMutableList(r4) == true) goto L5;
        r4 = null;
    L5:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L36;
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r13.hasNext() == false) goto L26;
        Object r14 = r13.next();
        b r2 = (b) ZeusTransformUtils.preCheckCast(r14, b.class, "com.obric.memorydata.plugin");
        if (r2.a() == r6) goto L13;
    L23:
        boolean r3 = false;
    L24:
        if (r3 == false) goto L9;
    L27:
        b r15 = (b) ZeusTransformUtils.preCheckCast(r14, b.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L30;
        return null;
    L30:
        return r15.g();
    L13:
        if (r2.b() != r7) goto L23;
        if (Intrinsics.areEqual(r2.c(), r8) == false) goto L23;
        if (Intrinsics.areEqual(r2.d(), r9) == false) goto L23;
        if (Intrinsics.areEqual(r2.e(), r10) == false) goto L23;
        if (Intrinsics.areEqual(r2.f(), r11) == false) goto L23;
        r3 = true;
        goto L24
    L26:
        r14 = null;
        goto L27
    L36:
        return null;
    }

    public final void a(View r14, int r15, int r16, String r17, String r18, String r19, String r20, g r21) {
        g r10 = (g) ZeusTransformUtils.wrapperContextForParams(r21, g.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r14, "view");
        Intrinsics.checkParameterIsNotNull(r17, "dataType");
        Intrinsics.checkParameterIsNotNull(r18, "dataValue");
        Intrinsics.checkParameterIsNotNull(r19, "dataValueId");
        Intrinsics.checkParameterIsNotNull(r20, "dataTag");
        Intrinsics.checkParameterIsNotNull(r10, "widget");
        Object r1 = r14.getTag(ZeusTransformUtils.mapRes(R.id.markwon_cached_lynx_widget_list, OaidModel.KEY_ID, "markwon_cached_lynx_widget_list"));
        if (TypeIntrinsics.isMutableList(r1) == true) goto L5;
        r1 = null;
    L5:
        List r2 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L9;
        r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    L9:
        r2.add(new b(r15, r16, r17, r18, r19, r20, r10));
        r14.setTag(ZeusTransformUtils.mapRes(R.id.markwon_cached_lynx_widget_list, OaidModel.KEY_ID, "markwon_cached_lynx_widget_list"), r2);
    }
}
