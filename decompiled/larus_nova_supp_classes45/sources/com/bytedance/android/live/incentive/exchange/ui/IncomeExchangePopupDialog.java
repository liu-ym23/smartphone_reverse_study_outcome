package com.bytedance.android.live.incentive.exchange.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/incentive/exchange/ui/IncomeExchangePopupDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "a", "b", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IncomeExchangePopupDialog extends AppCompatDialog {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public static final class b {
    }

    static {
    }

    public final void onStop() {
        super.onStop();
        throw null;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setContentView(2131566166);
        View r3 = findViewById(2131371849);
        Intrinsics.checkNotNull(r3);
        ViewGroup r4 = (ViewGroup) r3;
        Intrinsics.checkNotNullParameter(r4, "rootView");
        r4.findViewById(2131366984);
        HSImageView r0 = (HSImageView) r4.findViewById(2131373724);
        TextView r1 = (TextView) r4.findViewById(2131388772);
        TextView r5 = (TextView) r4.findViewById(2131383020);
        TextView r6 = (TextView) r4.findViewById(2131385703);
        Button r7 = (Button) r4.findViewById(2131371841);
    }
}
