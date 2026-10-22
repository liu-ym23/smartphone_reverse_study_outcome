package nh;

import com.bytedance.pia.core.utils.m;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements fh.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f20256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FutureTask f20257c;

    public /* synthetic */ f(String r5, FutureTask r10) {
        this.f20256b = r5;
        this.f20257c = r10;
    }

    @Override // fh.c
    public final void release() {
        m.b(new kh.b(6, this.f20256b, this.f20257c));
    }
}
