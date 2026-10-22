package com.obric.assistant.feedback;

import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class b implements Function0 {
    public final /* synthetic */ int a;

    public /* synthetic */ b(int r1) {
        this.a = r1;
    }

    public final Object invoke() {
        int r0 = this.a;
        int r1 = ObricFeedbackService.e;
        AppHost.Companion r2 = AppHost.a;
        Toast.makeText(r2.getApplication(), ContextCompat.getString(r2.getApplication(), r0), 0).show();
        return Unit.INSTANCE;
    }
}
