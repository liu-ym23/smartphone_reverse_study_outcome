package a4;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.service.base.m;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import rb.b;
import rd.e;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Scenes f89a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f90b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f91c;
    public final KitType d;
    public final String e;
    public final e f;
    public FragmentActivity g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f92h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedHashMap f93i;

    public a(Scenes r5, String r10, String r11, Bundle r12, String r13, KitType r14, e r15) {
        Intrinsics.checkNotNullParameter(r5, "scenes");
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r11, "bid");
        Intrinsics.checkNotNullParameter(r12, "bundle");
        Intrinsics.checkNotNullParameter(r13, "originSchema");
        Intrinsics.checkNotNullParameter(r14, "kitType");
        Intrinsics.checkNotNullParameter(r15, "schemaModelUnion");
        this.f92h = new b();
        this.f93i = new LinkedHashMap();
        this.f89a = r5;
        this.f90b = r10;
        this.f91c = r11;
        this.e = r13;
        this.d = r14;
        this.f = r15;
    }

    @Override // com.bytedance.ies.bullet.service.base.m
    public final void release() {
        this.g = null;
        b r5 = this.f92h;
        if (r5 == null) goto L6;
        r5.f21717a.clear();
        return;
    }
}
