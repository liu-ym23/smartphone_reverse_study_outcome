package com.bytedance.ies.bullet.lynx.element;

import androidx.annotation.Keep;
import com.bytedance.ies.bullet.core.h;
import com.lynx.canvas.KryptonEffectConfigService;
import kc.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/element/LynxCanvasEffectHandler;", "Lcom/lynx/canvas/KryptonEffectConfigService;", "<init>", "()V", "", "effectHost", "()Ljava/lang/String;", "appID", "accessKey", "effectResourcePath", "Companion", "kc/a", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class LynxCanvasEffectHandler extends KryptonEffectConfigService {
    public static final a Companion = null;
    private static volatile LynxCanvasEffectHandler instance;

    static {
        Companion = new a();
    }

    public LynxCanvasEffectHandler() {
    }

    public static final /* synthetic */ LynxCanvasEffectHandler access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ void access$setInstance$cp(LynxCanvasEffectHandler r5) {
        instance = r5;
    }

    public String accessKey() {
        return "68d32050064f11e891efe7cc07299bc5";
    }

    public String appID() {
        String r5 = h.g.d;
        if (r5 != null) goto L6;
        return "";
    L6:
        return r5;
    }

    public String effectHost() {
        return "https://effect.snssdk.com/";
    }

    public String effectResourcePath() {
        return "https://lf3-developer.bytemastatic.com/obj/developer/misc/EffectFaceResource.zip";
    }
}
