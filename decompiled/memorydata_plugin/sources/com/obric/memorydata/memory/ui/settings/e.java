package com.obric.memorydata.memory.ui.settings;

import com.bytedance.bdinstall.oaid.OaidModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/GlobalMemoryBannerData;", "Lcom/obric/oui/banner/BannerData;", OaidModel.KEY_ID, "", "title", "", "tip", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getTip", "holderKey", "getHolderKey", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e implements com.obric.oui.banner.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f11467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11468b;
    private final String c;

    public e(int r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "tip");
        this.f11467a = r2;
        this.f11468b = r3;
        this.c = r4;
    }

    public final int a() {
        return this.f11467a;
    }

    public final String b() {
        return this.f11468b;
    }

    public final String c() {
        return this.c;
    }

    @Override // com.obric.oui.banner.a
    public String d() {
        return GlobalMemoryBannerViewHolder.Companion.a();
    }
}
