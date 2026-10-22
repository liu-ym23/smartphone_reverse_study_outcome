package rs8;

import com.larus.bmhome.instruction.IInstructionCreator;
import com.larus.bmhome.instruction.IInstructionSubCreator;
import com.larus.common.apphost.AppHost;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m {
    public static final boolean a = false;
    public static final Set<IInstructionCreator> b = null;
    public static final Set<IInstructionSubCreator> c = null;

    static {
        a = AppHost.a.isTestChannel();
        b = ServiceManager.get().getServices(IInstructionCreator.class, true);
        c = ServiceManager.get().getServices(IInstructionSubCreator.class, true);
    }
}
