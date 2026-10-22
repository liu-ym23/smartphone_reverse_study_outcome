package androidx.core.view.autofill;

import android.view.autofill.AutofillId;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class AutofillIdCompat {
    private final Object mWrappedObj;

    private AutofillIdCompat(AutofillId r1) {
        this.mWrappedObj = r1;
    }

    public static AutofillIdCompat toAutofillIdCompat(AutofillId r1) {
        return new AutofillIdCompat(r1);
    }

    public AutofillId toAutofillId() {
        return (AutofillId) ZeusTransformUtils.preCheckCast(this.mWrappedObj, AutofillId.class, "com.obric.memorydata.plugin");
    }
}
