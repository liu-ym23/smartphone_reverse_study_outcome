package i8a;

import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.service.IServiceProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface b extends IServiceProvider {
    void onLynxEnvSetup();

    void onLynxViewDestroy(LynxContext r1);

    void onLynxViewSetup(LynxContext r1, LynxGroup r2, com.lynx.tasm.behavior.c r3);
}
