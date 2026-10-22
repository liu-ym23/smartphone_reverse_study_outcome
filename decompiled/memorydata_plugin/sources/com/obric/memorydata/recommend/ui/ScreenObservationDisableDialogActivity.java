package com.obric.memorydata.recommend.ui;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import com.bytedance.crash.constants.Constants;
import com.obric.memorydata.ui.NavigationBarScheme;
import com.obric.memorydata.ui.g;
import com.volcengine.zeus.activity.GeneratePluginActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/recommend/ui/ScreenObservationDisableDialogActivity;", "Landroid/app/Activity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenObservationDisableDialogActivity extends GeneratePluginActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12639a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Integer f12640b;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/recommend/ui/ScreenObservationDisableDialogActivity$Companion;", "", "<init>", "()V", "lastSystemUiVisibility", "", "getLastSystemUiVisibility", "()Ljava/lang/Integer;", "setLastSystemUiVisibility", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", Constants.LAUNCH_TAG, "", "context", "Landroid/content/Context;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12639a = new a(null);
    }

    public ScreenObservationDisableDialogActivity() {
    }

    private static final Unit a(ScreenObservationDisableDialogActivity r1, boolean r2) {
        ((ScreenObservationDisableDialogActivity) ZeusTransformUtils.wrapperContextForParams(r1, ScreenObservationDisableDialogActivity.class, "com.obric.memorydata.plugin")).finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$6Wa7oZRKhc9sT3odX-tZAdbICuw, reason: not valid java name */
    public static /* synthetic */ Unit m1139lambda$6Wa7oZRKhc9sT3odXtZAdbICuw(ScreenObservationDisableDialogActivity r0, boolean r1) {
        return a(r0, r1);
    }

    public String getPluginPkgName() {
        return "com.obric.memorydata.plugin";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r4) {
        super/*android.app.Activity*/.onCreate(r4);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        Window r5 = getWindow();
        Integer r0 = f12640b;
        if (r0 == null) goto L5;
        r5.getDecorView().setSystemUiVisibility(r0.intValue());
    L6:
        Intrinsics.checkNotNull(r5);
        g.a(r5, NavigationBarScheme.A);
        g.a(r5, false);
        b.f12643a.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), new $$Lambda$ScreenObservationDisableDialogActivity$6Wa7oZRKhc9sT3odXtZAdbICuw(this));
        return;
    L5:
        r5.getDecorView().setSystemUiVisibility(5888);
        r5.setStatusBarColor(0);
        goto L6
    }
}
