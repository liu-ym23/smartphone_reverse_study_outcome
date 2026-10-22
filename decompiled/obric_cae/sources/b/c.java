package b;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import com.qualcomm.qti.qesdk.QesdkUtils;
import he.i;

/* JADX INFO: loaded from: classes.dex */
public final class c extends a<Intent, ActivityResult> {
    @Override // b.a
    public final Intent a(ComponentActivity r8, Object r10) {
        Intent r11 = (Intent) r10;
        i.f(r8, "context");
        i.f(r11, QesdkUtils.TAGS.TAG_INPUT);
        return r11;
    }

    @Override // b.a
    public final Object c(Intent r8, int r10) {
        return new ActivityResult(r8, r10);
    }
}
