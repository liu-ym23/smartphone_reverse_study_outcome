package com.larus.business.multitask_management.impl.floatwindow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.common_ui.floatwindow.manager.FloatPriority;
import com.larus.platform.service.z2;
import com.larus.utils.m0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements e19.h {
    public Context a;
    public TaskManagementFloatWindowView b;
    public e19.b c;
    public int d;
    public boolean e;
    public final String f;
    public final boolean g;
    public final List<String> h;
    public final boolean i;

    /* JADX INFO: renamed from: com.larus.business.multitask_management.impl.floatwindow.a$a, reason: collision with other inner class name */
    public static final class C0074a {
    }

    static {
    }

    public final boolean f() {
        return false;
    }

    public final void onWindowDismiss() {
    }

    public final void onWindowShow() {
    }

    public final void setWidth(int r1) {
    }

    public final void a() {
        TaskManagementFloatWindowView r0 = this.b;
        if (r0 == null) goto L9;
        Job r1 = r0.h;
        if (r1 == null) goto L7;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L7:
        r0.h = null;
        r0.d();
        return;
    }

    public final void b() {
        TaskManagementFloatWindowView r0 = this.b;
        if (r0 == null) goto L9;
        Job r1 = r0.h;
        if (r1 == null) goto L7;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L7:
        r0.h = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new TaskManagementFloatWindowView$onAdded$1(r0, null), 3, null);
        return;
    }

    public final int c() {
        Context r0 = this.a;
        return ContextCompat.getColor(r0, v19.c.b(2130972072, r0, 2131103117));
    }

    public final View getContentView() {
        TaskManagementFloatWindowView r0 = this.b;
        if (r0 != null) goto L8;
        r0 = new TaskManagementFloatWindowView(v19.f.d(this.a), null, 6, 0);
        this.b = r0;
        e19.b r1 = this.c;
        if (r1 == null) goto L8;
        r0.e(r1);
    L8:
        return r0;
    }

    public final FloatPriority getPriority() {
        return new FloatPriority(2);
    }

    public final e19.f h() {
        e19.b r0 = this.c;
        if (r0 == null) goto L15;
        Rect r1 = r0.c;
        if (r1 == null) goto L15;
        Integer r2 = Integer.valueOf(r1.height());
        if (r2.intValue() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L15;
        int r4 = r2.intValue();
    L16:
        int r5 = (int) (r4 / 3.25f);
        int r6 = this.a.getResources().getDimensionPixelSize(v19.c.b(2130971524, this.a, 2131167417)) + r5;
        return new e19.f(o() + n(), new IntRange(r5 - this.a.getResources().getDimensionPixelSize(v19.c.b(2130971546, this.a, 2131167462)), this.a.getResources().getDimensionPixelSize(v19.c.b(2130971546, this.a, 2131167462)) + r6), new IntRange(0, n() + o()), new IntRange(r5, r6), new IntRange(o(), n() + o()), Integer.valueOf(this.a.getResources().getDimensionPixelSize(v19.c.b(2130971512, this.a, 2131167393))), Float.valueOf(400.0f));
    L9:
        r3 = false;
    L15:
        int r7 = m0.a;
        r4 = m0.a(this.a);
        goto L16
    }

    public final int m() {
        int r0 = TaskManagementFloatWindowView.G;
        e19.b r1 = this.c;
        if (r1 == null) goto L12;
        Rect r2 = r1.c;
        if (r2 == null) goto L12;
        Integer r3 = Integer.valueOf(r2.width());
        if (r3.intValue() <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
    L14:
        return (TaskManagementFloatWindowView.a.a(r3) + this.a.getResources().getDimensionPixelSize(v19.c.b(2130971163, null, 2131166696))) + o();
    L9:
        r4 = false;
    L12:
        r3 = null;
        goto L14
    }

    public final int n() {
        return this.a.getResources().getDimensionPixelSize(v19.c.b(2130971208, this.a, 2131166786));
    }

    public final int o() {
        Resources r0 = this.a.getResources();
        int r1 = TaskManagementFloatWindowView.G;
        return r0.getDimensionPixelSize(v19.c.b(2130971299, null, 2131166968));
    }

    public final int getWidth() {
        return m();
    }

    public final List<String> d() {
        return this.h;
    }

    public final boolean g() {
        return this.i;
    }

    public final int getHeight() {
        return this.d;
    }

    public final boolean i() {
        return this.e;
    }

    public final String k() {
        return this.f;
    }

    public final boolean n0() {
        return this.g;
    }

    public a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r3;
        m();
        this.f = "task_management_float_window";
        Context r4 = this.a;
        ContextCompat.getColor(r4, v19.c.b(2130972072, r4, 2131103117));
        this.g = true;
        this.h = CollectionsKt.listOf("multi_task_management");
        this.i = z2.a.getMultiTaskManagementConfig().b();
    }

    public final void e(boolean r1) {
        this.e = r1;
    }

    public final void j(e19.b r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        this.c = r2;
        TaskManagementFloatWindowView r0 = this.b;
        if (r0 == null) goto L6;
        r0.e(r2);
        return;
    }

    public final View l(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r2 == this.a) goto L5;
        boolean r0 = true;
    L6:
        this.a = r2;
        if (r0 == false) goto L10;
        this.b = null;
    L10:
        return getContentView();
    L5:
        r0 = false;
        goto L6
    }

    public final void setHeight(int r1) {
        this.d = r1;
    }
}
