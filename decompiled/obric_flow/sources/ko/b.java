package ko;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.service.IServiceProvider;
import com.lynx.tasm.u;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends IServiceProvider {
    void onLynxEnvSetup();

    void onLynxViewDestroy(LynxContext r5);

    void onLynxViewSetup(LynxContext r5, u r10, com.lynx.tasm.behavior.c r11);
}
