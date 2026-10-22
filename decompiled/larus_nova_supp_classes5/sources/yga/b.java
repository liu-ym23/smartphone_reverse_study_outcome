package yga;

import com.obric.assistant.state.ISharedStateService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class b implements Function0 {
    public /* synthetic */ b() {
    }

    public final Object invoke() {
        return (ISharedStateService) ServiceManager.get().getService(ISharedStateService.class);
    }
}
