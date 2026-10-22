package kc8;

import androidx.fragment.app.DialogFragment;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface b0 {
    void E0(ICoreInputAbility.OnSendParams r1);

    void F5(nr9.g r1, String r2, Map<String, String> r3, Map<String, String> r4);

    Set<String> a();

    void b(Serializable r1, String r2, String r3, zs8.a r4);

    void c(DialogFragment r1);

    void d();
}
