package com.ss.android.lark.floating.widget.appfloat;

import android.view.View;
import android.view.WindowManager;
import com.ss.android.lark.floating.enums.SidePattern;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class TouchUtils$sideHideAnim$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AppFloatManager.b $action;
    final /* synthetic */ boolean $notifyVc;
    final /* synthetic */ h $params;
    final /* synthetic */ View $view;
    final /* synthetic */ WindowManager $windowManager;
    final /* synthetic */ TouchUtils this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SidePattern.values().length];
            r0[SidePattern.RESULT_LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[SidePattern.RESULT_RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[SidePattern.RESULT_HORIZONTAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public TouchUtils$sideHideAnim$1(TouchUtils r1, h r2, View r3, WindowManager r4, AppFloatManager.b r5, boolean r6) {
        this.this$0 = r1;
        this.$params = r2;
        this.$view = r3;
        this.$windowManager = r4;
        this.$action = r5;
        this.$notifyVc = r6;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1242invoke() {
        TouchUtils r0 = this.this$0;
        h r1 = this.$params;
        View r2 = this.$view;
        int r3 = TouchUtils.v;
        r0.f(r1, r2);
        TouchUtils r4 = this.this$0;
        r4.r = true;
        r4.l();
        SidePattern r5 = this.this$0.b.m;
        int r6 = a.a[r5.ordinal()];
        if (r6 != 1) goto L5;
        int r7 = this.this$0.d(this.$view);
    L15:
        TouchUtils r8 = this.this$0;
        h r9 = this.$params;
        r8.b(true, r9, r7, this.$windowManager, this.$view, this.$action, this.$notifyVc);
        return;
    L5:
        if (r6 != 2) goto L7;
        r7 = this.this$0.e();
        goto L15
    L7:
        if (r6 == 3) goto L9;
        return;
    L9:
        TouchUtils r10 = this.this$0;
        if (r10.h >= r10.i) goto L12;
        r7 = r10.d(this.$view);
        goto L15
    L12:
        r7 = r10.e();
        goto L15
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1242invoke();
        return Unit.INSTANCE;
    }
}
