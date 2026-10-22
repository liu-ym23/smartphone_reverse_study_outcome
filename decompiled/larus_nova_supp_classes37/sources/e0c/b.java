package e0c;

import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.f0;
import dagger.BindsInstance;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface b {
    b a(@BindsInstance f0 r1);

    b b(@BindsInstance String r1);

    a build();

    b userSession(@BindsInstance UserSession r1);
}
