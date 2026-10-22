package obb;

import android.graphics.Bitmap;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.entity.UserSession;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final Boolean a;
    public final Boolean b;
    public final Integer c;
    public Integer d;
    public IconScene e;
    public Long f;
    public UserSession g;

    /* JADX INFO: renamed from: obb.a$a, reason: collision with other inner class name */
    public static final class C0271a {
    }

    static {
    }

    public final Bitmap a() {
        Integer r0 = this.c;
        if (r0 != null) goto L9;
        return null;
    L9:
        int r2 = rbb.a.a;     // Catch: Exception -> L7
        return rbb.a.b(r0.intValue(), null);
    L7:
        Log.e("ContainerInfo", BuildConfig.FLAVOR);
        return null;
    }

    public a() {
        this.e = IconScene.UNKNOW;
    }

    public a(IconScene r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        IconScene r0 = IconScene.UNKNOW;
        this.e = r2;
    }

    public final void b(IconScene r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public a(Boolean r2, Boolean r3, Integer r4) {
        this.e = IconScene.UNKNOW;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
