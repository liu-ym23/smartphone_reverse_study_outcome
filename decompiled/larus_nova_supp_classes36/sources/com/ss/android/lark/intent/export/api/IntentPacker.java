package com.ss.android.lark.intent.export.api;

import android.os.Bundle;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.intent.export.entity.output.IntentOutput;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/intent/export/api/IntentPacker;", "T", "Lcom/ss/android/lark/intent/export/entity/output/IntentOutput;", "", "appendIntentInfo", "Landroid/os/Bundle;", "bundle", "output", "(Landroid/os/Bundle;Lcom/ss/android/lark/intent/export/entity/output/IntentOutput;)Landroid/os/Bundle;", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public interface IntentPacker<T extends IntentOutput> {
    Bundle appendIntentInfo(Bundle r1, T r2);
}
