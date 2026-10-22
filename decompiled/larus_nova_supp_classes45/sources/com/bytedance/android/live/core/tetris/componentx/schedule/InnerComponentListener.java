package com.bytedance.android.live.core.tetris.componentx.schedule;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.componentx.component.ComponentCenter;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.element.container.ContainerElement;
import com.bytedance.android.live.core.tetris.layer.core.element.view.ViewElement;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.merge.MergeWidgetElement;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentManagerABHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class InnerComponentListener implements com.bytedance.android.live.core.tetris.componentx.component.c {
    public final Map<String, Boolean> a;
    public ComponentSchedulingManager b;
    public int c;
    public int d;
    public final String e;
    public final Map<String, Object> f;
    public final Map<String, l> g;
    public final Map<String, l> h;
    public Job i;
    public h70.b j;

    @Override // com.bytedance.android.live.core.tetris.componentx.component.c
    public final void b(Element r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.c
    public final void c(j70.f r2) {
        Intrinsics.checkNotNullParameter(r2, "elementType");
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.c
    public final void d(Element r2, d70.a r3) {
        Intrinsics.checkNotNullParameter(r2, "element");
        Intrinsics.checkNotNullParameter(r3, "component");
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.c
    public final void f(LayerDescriptorList r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptors");
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.c
    public final void h(Element r2, d70.a r3) {
        Intrinsics.checkNotNullParameter(r2, "element");
        Intrinsics.checkNotNullParameter(r3, "component");
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.c
    public final void i(d70.a r2) {
        Intrinsics.checkNotNullParameter(r2, "component");
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.c
    public final void j(ComponentCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "componentCenter");
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.c
    public final void k(d70.a r2) {
        Intrinsics.checkNotNullParameter(r2, "component");
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.c
    public final void onDestroy() {
        Map<String, Boolean> r0 = this.a;
        if (r0 == null) goto L5;
        ((LinkedHashMap) r0).clear();
    L5:
        Job r1 = this.i;
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        this.b = null;
        Map<String, Object> r2 = this.f;
        if (r2 == null) goto L11;
        ((LinkedHashMap) r2).clear();
    L11:
        Map<String, l> r3 = this.g;
        if (r3 == null) goto L14;
        ((LinkedHashMap) r3).clear();
    L14:
        Map<String, l> r4 = this.h;
        if (r4 == null) goto L18;
        ((LinkedHashMap) r4).clear();
        return;
    }

    public InnerComponentListener() {
        this.a = new LinkedHashMap();
        this.c = Integer.MAX_VALUE;
        this.e = "InnerComponentListener";
        this.f = new LinkedHashMap();
        this.g = new LinkedHashMap();
        this.h = new LinkedHashMap();
    }

    public static String n(d70.a r2) {
        j70.f r0 = r2.getElementType();
        String r1 = null;
        if (r0 == null) goto L5;
        String r3 = r0.b;
    L7:
        if (TextUtils.isEmpty(r3) == false) goto L16;
        j70.f r4 = r2.getElementType();
        if (r4 == null) goto L11;
        String r5 = r4.a;
    L13:
        if (TextUtils.isEmpty(r5) == false) goto L16;
        return r2.getClass().getSimpleName();
    L11:
        r5 = null;
    L16:
        j70.f r6 = r2.getElementType();
        if (r6 == null) goto L19;
        String r7 = r6.b;
    L20:
        j70.f r8 = r2.getElementType();
        if (r8 == null) goto L24;
        r1 = r8.a;
    L24:
        return Intrinsics.stringPlus(r7, r1);
    L19:
        r7 = null;
        goto L20
    L5:
        r3 = null;
        goto L7
    }

    public static String o(Element r3) {
        j70.f r0 = r3.d;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.b;
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L16;
        j70.f r4 = r3.d;
        if (r4 == null) goto L11;
        String r5 = r4.a;
    L13:
        if (TextUtils.isEmpty(r5) == false) goto L16;
        return r3.getClass().getSimpleName();
    L11:
        r5 = null;
    L16:
        StringBuilder r6 = new StringBuilder();
        j70.f r7 = r3.d;
        if (r7 == null) goto L19;
        String r8 = r7.b;
    L20:
        r6.append(r8);
        j70.f r9 = r3.d;
        if (r9 == null) goto L23;
        r1 = r9.a;
    L23:
        r6.append(r1);
        return r6.toString();
    L19:
        r8 = null;
        goto L20
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.c
    public final void a(Element<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "element");
        Intrinsics.checkNotNullParameter(r4, "element");
        if ((r4 instanceof ContainerElement) == true) goto L9;
        if ((r4 instanceof ViewElement) == true) goto L9;
        if ((r4 instanceof MergeWidgetElement) == true) goto L9;
        return;
    L9:
        if (ComponentManagerABHelper.INSTANCE.enableFullLog() == false) goto L12;
        ALogger.i(this.e, "当前加载完成的组件是 elementType = " + r4.d + " fromElementType = " + r4.e);
    L12:
        if (this.h.containsKey(o(r4)) == false) goto L16;
        this.f.put(o(r4), r4);
        l(o(r4), r4.d.a);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.c
    public final void e(d70.a<h70.b> r5) {
        Intrinsics.checkNotNullParameter(r5, "component");
        if (v.a() == false) goto L6;
        ALogger.i(this.e, "当前加载完成的组件是 " + n(r5));
    L6:
        if (this.h.containsKey(n(r5)) == false) goto L12;
        this.f.put(n(r5), r5);
        String r1 = n(r5);
        j70.f r2 = r5.getElementType();
        if (r2 == null) goto L10;
        String r3 = r2.a;
    L11:
        l(r1, r3);
        goto L12
    L10:
        r3 = null;
    L12:
        Intrinsics.checkNotNullParameter(r5, "component");
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.c
    public final void g(d70.a<h70.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "component");
        Intrinsics.checkNotNullParameter(r2, "component");
    }

    public final LayerDescriptorList m(m r8) {
        LayerDescriptorList r9 = r8.b;
        if (r9 == null) goto L41;
        ComponentSchedulingManager r0 = this.b;
        if (r0 == null) goto L7;
        LayerDescriptorList r1 = r0.a(r9);
    L8:
        if (r1 != null) goto L10;
    L11:
        ArrayList r2 = new ArrayList();
        Iterator<j70.h<? extends h70.b>> r11 = r9.iterator();
    L13:
        if (r11.hasNext() == false) goto L19;
        j70.h<? extends h70.b> r3 = r11.next();
        if (r1 == null) goto L13;
        if (r1.contains(r3) == true) goto L13;
        r2.add(r3);
        ALogger.i(this.e, "doubleCheck disable canload ".concat(r3.getClass().getName()));
        goto L13
    L19:
        Iterator r12 = r2.iterator();
    L21:
        if (r12.hasNext() == false) goto L40;
        j70.h r4 = (j70.h) r12.next();
        if ((r4 instanceof j70.h) == true) goto L25;
        r4 = null;
    L25:
        if (r4 == null) goto L35;
        h70.b r5 = this.j;
        if (r5 == null) goto L34;
        Intrinsics.checkNotNull(r5);
        String r6 = r4.C(r5).b;
        h70.b r7 = this.j;
        Intrinsics.checkNotNull(r7);
        String r13 = r4.C(r7).a;
        if (TextUtils.isEmpty(r6) == true) goto L31;
    L33:
        String r14 = r6 + r13;
    L36:
        if (r14 == null) goto L21;
        if (this.h.remove(r14) == null) goto L21;
        this.d++;
        ALogger.i(this.e, "doubleCheck disable canload ".concat(r14));
        goto L21
    L31:
        if (TextUtils.isEmpty(r13) == false) goto L33;
        r14 = r4.getClass().getSimpleName();
        goto L36
    L34:
        r14 = r4.getClass().getSimpleName();
        goto L36
    L35:
        r14 = null;
    L40:
        return r1;
    L10:
        if (r1.size() == r9.size()) goto L40;
    L7:
        r1 = null;
        goto L8
    L41:
        return r9;
    }

    public final void p(m r5) {
        if (r5 == null) goto L12;
        List<l> r6 = r5.a;
        if (r6 == null) goto L16;
        Iterator<T> r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L17;
        l r0 = (l) r7.next();
        if (this.h.containsKey(r0.a) == false) goto L11;
        ALogger.i(this.e, "Error： 已经有此组件了 " + r0.a);
    L11:
        this.h.put(r0.a, r0);
        goto L7
    L17:
        return;
    L16:
        return;
    }

    public final void q(long r11) {
        if (r11 <= 0) goto L6;
        CoroutineScope r0 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.i = BuildersKt.launch$default(r0, null, null, new InnerComponentListener$handleTimeoutOptJob$1(this, r11, r0, null), 3, null);
        return;
    }

    public final void r(boolean r4) {
        if (r4 == false) goto L9;
        Map<String, l> r5 = this.h;
        if (r5 == null) goto L9;
        Iterator r6 = ((LinkedHashMap) r5).entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) r6.next();
        Map<String, l> r1 = this.g;
        Object r2 = r0.getKey();
        r1.put((String) r2, (l) r0.getValue());
    L9:
        ((LinkedHashMap) this.h).clear();
        ComponentSchedulingManager r7 = this.b;
        if (r7 == null) goto L18;
        ComponentBatchBaseLoadState r8 = r7.i;
        if (r8 == null) goto L19;
        b r9 = r8.b();
        if (r9 == null) goto L20;
        r9.c(this.c, BatchTogetherConditionManager.BatchLoadConditionType.END_BATCH_ONLOAD);
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void l(String r4, String r5) {
        if (r4 == null) goto L12;
        this.h.remove(r4);
        this.d++;
        if (ComponentManagerABHelper.INSTANCE.enableFullLog() == false) goto L7;
        ALogger.i(this.e, "加载完成了" + this.d + " 个, 当前新加载的是 " + r5);
    L7:
        if (this.h.size() != 0) goto L13;
        ALogger.i(this.e, "需要被监听的批次是 " + this.c + " 该批次加载完成");
        r(false);
        Job r6 = this.i;
        if (r6 == null) goto L14;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
        return;
    L14:
        return;
    L13:
        return;
    }
}
