package com.obric.audio.enroll.base;

import android.os.Build;
import android.os.Bundle;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import com.obric.audio.enroll.ui.VoicePrintEnrollActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0004R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000bX\u0082.¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/audio/enroll/base/BaseFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "lifeEventTag", "", "getLifeEventTag", "()Ljava/lang/String;", "resumeTime", "", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "activityResultCallback", "Lkotlin/Function1;", "", "", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "showQuitDialog", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseFragment extends Fragment {
    public static final /* synthetic */ int d = 0;

    public static final class a {
    }

    static {
    }

    public final void S90() {
        if (getActivity() != null) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 24) goto L9;
        VoicePrintEnrollActivity r0 = getActivity();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.audio.enroll.ui.VoicePrintEnrollActivity");
        r0.F1();
        return;
    }

    public BaseFragment() {
    }

    public final void onResume() {
        super.onResume();
    }

    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new mia.a(this));
    }
}
