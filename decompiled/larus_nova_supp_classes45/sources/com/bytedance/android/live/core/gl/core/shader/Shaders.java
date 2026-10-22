package com.bytedance.android.live.core.gl.core.shader;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H&j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/core/gl/core/shader/Shaders;", "", "Lcom/bytedance/android/live/core/gl/core/shader/a;", "createShader", "DEFAULT_TEXTURE_SHADER", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract enum Shaders extends Enum<Shaders> {
    public static final Shaders DEFAULT_TEXTURE_SHADER = null;
    public static final /* synthetic */ Shaders[] a = null;

    static {
        final String r2 = "DEFAULT_TEXTURE_SHADER";
        final int r3 = 0;
        Shaders r1 = new DEFAULT_TEXTURE_SHADER(r2, r3);
        DEFAULT_TEXTURE_SHADER = r1;
        a = new Shaders[]{r1};
    }

    public Shaders() {
        throw null;
    }

    public static Shaders valueOf(String r1) {
        return (Shaders) r27.a.a(Shaders.class, r1);
    }

    public static Shaders[] values() {
        return (Shaders[]) a.clone();
    }

    public abstract a createShader();

    public Shaders(String r1, int r2, DefaultConstructorMarker r3) {
        super(r1, r2);
    }
}
