package com.obric.memorydata.recommend.ui;

import android.R;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.obric.memorydata.ui.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/recommend/ui/BaseFloatingMemoryActivity;", "Lcom/obric/memorydata/ui/BaseActivity;", "<init>", "()V", "floatingBottom", "", "getFloatingBottom", "()I", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class BaseFloatingMemoryActivity extends BaseActivity {
    private final int floatingBottom;

    public BaseFloatingMemoryActivity() {
        this.floatingBottom = MathKt.roundToInt(TypedValue.applyDimension(1, 24, Resources.getSystem().getDisplayMetrics()));
    }

    /* JADX INFO: renamed from: lambda$mHsmgVYMalaB7x53i4XmTF4iV-o, reason: not valid java name */
    public static /* synthetic */ WindowInsetsCompat m1137lambda$mHsmgVYMalaB7x53i4XmTF4iVo(View r0, WindowInsetsCompat r1) {
        return onCreate$lambda$0(r0, r1);
    }

    private static final WindowInsetsCompat onCreate$lambda$0(View r3, WindowInsetsCompat r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "windowInsets");
        Insets r0 = r4.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(r0, "getInsets(...)");
        r3.setPadding(r0.left, 0, r0.right, 0);
        return r4;
    }

    public int getFloatingBottom() {
        return this.floatingBottom;
    }

    @Override // com.obric.memorydata.ui.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        getWindow().setStatusBarColor(0);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.content), $$Lambda$BaseFloatingMemoryActivity$mHsmgVYMalaB7x53i4XmTF4iVo.INSTANCE);
    }
}
