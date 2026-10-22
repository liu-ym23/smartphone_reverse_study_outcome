package org.koin.androidx.scope;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lorg/koin/androidx/scope/RetainedScopeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lorg/koin/android/scope/a;", "koin-android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class RetainedScopeActivity extends AppCompatActivity implements org.koin.android.scope.a {
    public final Lazy s;

    public RetainedScopeActivity() {
        super(0);
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.s = LazyKt.lazy(new ComponentActivityExtKt$activityRetainedScope$1(this));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        if (t() == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("Required value was null.");
    }

    @Override // org.koin.android.scope.a
    public final org.koin.core.scope.a t() {
        return (org.koin.core.scope.a) this.s.getValue();
    }
}
