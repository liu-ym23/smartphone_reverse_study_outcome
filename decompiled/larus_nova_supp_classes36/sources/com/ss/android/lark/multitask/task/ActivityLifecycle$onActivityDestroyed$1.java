package com.ss.android.lark.multitask.task;

import android.app.Activity;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "invoke", "(Ljava/lang/ref/WeakReference;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class ActivityLifecycle$onActivityDestroyed$1 extends Lambda implements Function1<WeakReference<Activity>, Boolean> {
    final /* synthetic */ Activity $activity;

    public ActivityLifecycle$onActivityDestroyed$1(Activity r1) {
        this.$activity = r1;
        super(1);
    }

    public final Boolean invoke(WeakReference<Activity> r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return Boolean.valueOf(Intrinsics.areEqual(r2.get(), this.$activity));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((WeakReference) r1);
    }
}
