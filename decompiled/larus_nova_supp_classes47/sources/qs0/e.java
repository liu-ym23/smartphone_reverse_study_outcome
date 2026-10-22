package qs0;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface e {
    JSONObject i();

    void tryShowLiveFlashFragment(Context r1, Bundle r2, Function1<? super DialogFragment, Unit> r3);
}
